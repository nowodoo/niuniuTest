package com.niuniu.configure;

/**
 * Created by zach on 17/5/18.
 */
public class Configuration {
    //车数量
    public static int NODENUM = 30;

    //程序是否在运行
    public static boolean RUNNING = true;

    //程序运行时间 秒
    public static int RUNNINGTIME = 3;

    //运行速度  16-32 单位  m/s
    public static int SPEED = 20;

    //记录相关的操作
    public static String RECOURD_DISTANCE = "DISTANCE";

    //主线程设置完了停止标志之后的保留时间，为了避免未结束的线程停止，按照道理，主线程设置了停止标志，子线程应该马上停止。(单位是秒)
    public static int MAIN_WAITTING_TIME = 1;

    //路的长度，单位米
    public static double ROAD_LENGTH = 1000.0;

    //消息发送时间间隔 单位S
    public static int MSG_SEND_TIME_INTERVEL_MIN = 1;
    public static int MSG_SEND_TIME_INTERVEL_MAX = 2;

    //计算时钟 ms
    public static int TIME_CLOCK = 100;

    //计算的概率   这里7表示是 70%
    public static int SEND_PROBABILITY = 7;
}
