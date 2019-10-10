/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.example.observer.mode.listener;

import com.example.observer.mode.Application;
import com.example.observer.mode.Data;

/**
 * @author chengxy
 * 2019/10/10
 */
public class AApp extends Application {

    public AApp(){

    }

    public Object haa(Data c) {
        System.out.println("haa: " + c.getData());
        return c;
    }

    public Object hab(Data c) {
        System.out.println("hab: " + c.getData());
        return c;
    }

    public Object hac(Data c) {
        System.out.println("hac: " + c.getData());
        return c;
    }

}
