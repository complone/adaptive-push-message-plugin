/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.example.observer.mode.controller;

import com.example.observer.mode.Data;
import com.example.observer.mode.DataListener;
import com.example.observer.mode.ListenerMediator;
import com.example.observer.mode.listener.AApp;

import java.util.concurrent.TimeUnit;

/**
 * @author chengxy
 * 2019/10/10
 */

public class AppController {


    public static void main(String[] args){
    // 中介者是全局管理者，是最先存在的
    ListenerMediator mediator = new ListenerMediator();

    // 这一步在配置平台，消息推送实现, 可以采用注解的方式注入到应用中，配置仅与中介者交互
    Data aConfig = new Data("Haha", mediator);
    Data bConfig = new Data(-1L, mediator);
    Data cConfig = new Data(true, mediator);
    AApp a = new AApp();

    // 这一步可以通过应用启动时注册到分布式服务发现系统上来完成
    mediator.register(aConfig, new DataListener(a, conf -> a.haa(conf)));
    mediator.register(bConfig, new DataListener(a, conf -> a.hab(conf)));
    mediator.register(cConfig, new DataListener(a, conf -> a.hac(conf)));


    // 核心: 更新与通知
    aConfig.update("I am changed");
    sleep(2000);

    bConfig.update(9L);
    sleep(2000);

    mediator.unregister(cConfig, new DataListener(a, conf -> a.haa(conf)));

    cConfig.update(false);
    sleep(2000);

    }

    private static void sleep(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
