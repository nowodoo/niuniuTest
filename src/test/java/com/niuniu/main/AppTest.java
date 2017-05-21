package com.niuniu.main;

import com.niuiniu.data.ConcurrentData;
import com.niuiniu.data.com.niuniu.algorithm.AlgorithmUtil;
import com.niuniu.bean.Node;
import com.niuniu.configure.Configuration;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zach on 17/5/18.
 */
public class AppTest {

    @Test
    public void testApp() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Configuration.NODENUM);

        //默认方向
        String direction = "<-";
        for (int i = 1; i <= Configuration.NODENUM; i++) {

            //按照启动的顺序获取方向
            direction = AlgorithmUtil.getDirection(i);

            //开启线程
            executorService.execute(new Node(i+"", direction, Configuration.SPEED));
        }

        Thread.sleep(Configuration.RUNNINGTIME * 1000);

        //结束程序运行,因为线程中是用这个变量去决定自己是不是运行的。
        Configuration.RUNNING = false;

        //然后观察两秒，主线程需要等待两秒，避免子线程退出。
        Thread.sleep(Configuration.MAIN_WAITTING_TIME * 1000);

        System.out.println(ConcurrentData.map);
        System.out.println(ConcurrentData.msgMap);
        System.out.println(ConcurrentData.testMsgMap);

    }
}
