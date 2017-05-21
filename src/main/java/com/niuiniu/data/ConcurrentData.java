package com.niuiniu.data;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zach on 17/5/19.
 */
public class ConcurrentData {
    //存放运行信息
    public static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();

    //存放发送的消息信息
    public static ConcurrentHashMap<String, String> msgMap = new ConcurrentHashMap<String, String>();
    public static ConcurrentHashMap<String, String> testMsgMap = new ConcurrentHashMap<String, String>();
}
