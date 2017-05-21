package com.niuniu.algotithm;

import com.niuiniu.data.com.niuniu.algorithm.AlgorithmUtil;
import com.niuniu.configure.Configuration;
import org.junit.Test;

import java.util.*;

/**
 * Created by zach on 17/5/21.
 */
public class AlgorithmUtilTest {
    @Test
    public void testGetDirection() {
        System.out.println(AlgorithmUtil.getDistance(1000, 2.34, 20));
    }

    @Test
    public void timeTest() throws InterruptedException {

        double startTime = System.currentTimeMillis();

        Thread.sleep(356);

        //距离开始时间，运行了多久，时间是毫秒
        double spentTimeMS = System.currentTimeMillis() - startTime;
        double spentTimeS = spentTimeMS / 1000.0;

        System.out.println(spentTimeS);

    }

    @Test
    public void testIsOnMsgSend() {
        boolean result = AlgorithmUtil.isOnMsgSend(20, 2);
        System.out.println(result);
    }

    //int msgSendTimeInterval = new Random().nextInt(Configuration.MSG_SEND_TIME_INTERVEL_MAX)%(Configuration.MSG_SEND_TIME_INTERVEL_MAX-Configuration.MSG_SEND_TIME_INTERVEL_MAX+1) + Configuration.MSG_SEND_TIME_INTERVEL_MIN;
    @Test
    public void testRandom() {
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            System.out.println(AlgorithmUtil.getSendMsgInterval(random));
        }

    }

    @Test
    public void testProb() {


        List<Integer> countList = new ArrayList<Integer>();
        Map<String, Integer> countMap = new HashMap<String, Integer>();


        int countTrue = 0;
        int countFalse = 0;
        for (int i = 0; i < 100; i++) {
            if(AlgorithmUtil.getProbability(10)){
                countTrue++;
                countMap.put("true", countTrue);
            }else {
                countFalse++;
                countMap.put("false", countFalse);
            }
        }

        System.out.println(countMap);
    }
    


}

