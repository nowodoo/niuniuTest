package com.niuniu.bean;

import com.niuiniu.data.ConcurrentData;
import com.niuiniu.data.com.niuniu.algorithm.AlgorithmUtil;
import com.niuniu.configure.Configuration;

import java.util.Random;

/**
 * Created by zach on 17/5/18.
 */
public class Node implements Runnable{
    //节点编号
    public String nodeCode;

    //节点速度 默认值10  m/s
    public double speed = 10;

    //节点方向，默认值<-向左
    public String direction = "<-";

    //距离起点的距离,默认都是0
    public double startPosition = 0;

    //到起点的距离，计算公式是 startPoint+ 时间*速度
    public double distance = 0;

    //时钟计数
    public long timeClockCount = 0;

    //上次发送消息的时钟数
    public long lastTimeClockCountOnMsg = 0;

    public Node(String _nodeCode, String _direction, double _speed) {
        nodeCode = _nodeCode;
        direction = _direction;
        speed = _speed;
    }

    public void run() {
        Random random = new Random();


        //开始时间
        double startTime = System.currentTimeMillis();
        //初始化消息的发送时间间隔
        int msgSendTimeInterval = AlgorithmUtil.getSendMsgInterval(random);

        //程序运行的开关
        while (Configuration.RUNNING) {

            //距离开始时间，运行了多久，时间是毫秒
            double spentTimeMS = System.currentTimeMillis() - startTime;
            double spentTimeS = spentTimeMS / 1000;
            distance = AlgorithmUtil.getDistance(startPosition, spentTimeS, speed);

            //记录现在的距离  节点  时间  常亮
            ConcurrentData.map.put("CARCODE-" + nodeCode + "-SPEED-" + speed + "-SPENTTIMEMS-" + spentTimeMS + "-SPENTTIMES-" + spentTimeS + "-" + Configuration.RECOURD_DISTANCE + "-" + distance+"-DIRECTION-"+direction, distance + "");

            //相比较上次发送消息的时钟， 现在的时钟-上次发送消息时的时钟
            long lastTimeClockCountInterval = timeClockCount - lastTimeClockCountOnMsg;
            //模拟消息发送，放在消息内存中
            //判断时间间隔是不是和给定的消息发送时间间隔相等，每次时钟进行判断
            if (AlgorithmUtil.isOnMsgSend(lastTimeClockCountInterval, msgSendTimeInterval)) {

                //根据配置的概率发送消息
                if (AlgorithmUtil.getProbability(Configuration.SEND_PROBABILITY)) {
                    ConcurrentData.msgMap.put("CARNODE-"+nodeCode+"-"+timeClockCount, "sent");
                }

                lastTimeClockCountOnMsg = timeClockCount;
                //发送一次就改变一次发送的时间间隔
                msgSendTimeInterval = AlgorithmUtil.getSendMsgInterval(random);
            }




            try {
                //每1/10  秒去刷新速度
                timeClockCount++;
                Thread.sleep(Configuration.TIME_CLOCK);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
