package com.niuiniu.data.com.niuniu.algorithm;

import com.niuniu.configure.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zach on 17/5/21.
 */
public class AlgorithmUtil {
    private static List<Integer> all = new ArrayList<Integer>(){{add(0);add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);}};

    /**
     * 获取方向
     * @return
     */
    public static String getDirection(int sequence) {
        String result = "<-";

        //不同的方向平均分配算法，根据2的余数进行判断。
        if (0 == sequence % 2) {
            result = "<-";
        } else {
            result = "<-";
        }

        return result;
    }


    /**
     * 根据起始位置和时间获取距离
     * @param startPosition
     * @param spentTime 单位： 秒
     * @return
     */
    public static double getDistance(double startPosition, double spentTime, double speed) {
        return (startPosition + (spentTime * speed)) % Configuration.ROAD_LENGTH;
    }

    /**
     * 用clock间隔，和发送消息的的间隔判断是不是需要发用消息。
     * @param timeClockCountInterval
     * @param timeInterVal
     * @return
     */
    public static boolean isOnMsgSend(long timeClockCountInterval, int timeInterVal) {
        if (timeInterVal == (timeClockCountInterval * Configuration.TIME_CLOCK / 1000)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取下一次获取消息的时间间隔
     * @param random
     * @return
     */
    public static int getSendMsgInterval(Random random) {
        return random.nextInt(Configuration.MSG_SEND_TIME_INTERVEL_MAX)%(Configuration.MSG_SEND_TIME_INTERVEL_MAX-Configuration.MSG_SEND_TIME_INTERVEL_MIN+1) + Configuration.MSG_SEND_TIME_INTERVEL_MIN;
    }

    /**
     * 获取概率的事件
     * @param random
     * @return
     */
    public static boolean getProbability(int probability) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < probability; i++) {
            list.add(i);
        }

        Random random = new Random();
        int temp  = random.nextInt(10);



        if (list.contains(temp) && all.contains(temp)){
            return true;
        }else {
            return false;
        }
    }

}
