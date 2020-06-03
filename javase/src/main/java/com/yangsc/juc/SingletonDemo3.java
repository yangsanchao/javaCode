package com.yangsc.juc;

import lombok.extern.log4j.Log4j2;

/**
 * <p>Description: SingletonDemo</p>
 *
 * <p>Copyright: © 2018-至今 All rights reserved.</p>
 *
 * @author yangsanchao
 * *
 * @date 2020/5/27 13:27
 **/
@Log4j2
public class SingletonDemo3 {
    public static volatile SingletonDemo3 instance;

    private SingletonDemo3() {
    }

    public static SingletonDemo3 getInstance() {
        if (instance == null) {
            synchronized(SingletonDemo3.class){
                if (instance == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new SingletonDemo3();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SingletonDemo3 singletonDemo = SingletonDemo3.getInstance();
                log.info(singletonDemo);
            }).start();
        }
    }
}
