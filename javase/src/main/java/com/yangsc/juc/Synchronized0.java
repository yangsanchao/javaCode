package com.yangsc.juc;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.TimeUnit;

/**
 * <p>Description: Synchronized0</p>
 *
 * <p>Copyright: © 2018-至今 All rights reserved.</p>
 *
 * @author yangsanchao
 * *
 * @date 2020/6/1 10:14
 **/
public class Synchronized0 {

    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(() -> {
            phone.sendSms();
        }, "A").start();
        new Thread(() -> {
            phone2.call();
        }, "B").start();

    }
}

@Log4j2
class Phone {
    /**
     * synchronized 锁的对象是方法的调用者！两个方法用的是同一个锁，谁先拿到谁执行！
     */
    public synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }
}