/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.example.observer;

import com.example.observer.mode.DataListener;
import com.example.observer.mode.DataTransferMediator;
import com.example.observer.transfer.Receiver;
import com.example.observer.transfer.TransferObject;

import java.util.concurrent.TimeUnit;

/**
 * @author chengxy
 * 2019/10/22
 */
public class RunConfig {


    public static void main(String[] args) {

        // 中介者是全局管理者，是最先存在的
        DataTransferMediator mediator = new DataTransferMediator();

        // 这一步在数据平台实现, 可以采用注解的方式注入到应用中，数据仅与中介者交互
        TransferObject aTransferObject = new TransferObject("Haha", mediator);

        TransferObject bTransferObject = new TransferObject("BoBo",mediator);
        Receiver a = new Receiver();


        // 这一步可以通过应用启动时注册到分布式服务发现系统上来完成
        mediator.register(aTransferObject, new DataListener(a, conf -> a.haa(conf)));
        mediator.register(aTransferObject, new DataListener(a, conf -> a.hab(conf)));
        mediator.register(bTransferObject, new DataListener(a, conf -> a.hac(conf)));

        // 核心: 更新与通知
        aTransferObject.update("I am changed");
        sleep(2000);


        //mediator.unregister(cConfig, new ConfigObserver(b, conf -> b.hbc(conf)));


    }

    private static void sleep(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
