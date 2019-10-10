/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.example.observer.mode;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chengxy
 * 2019/10/10
 */
public abstract class ID {

    private static AtomicLong gloalId = new AtomicLong(0);

    //通过id字段标识消息类型以及应用
    protected Long id;

    public void setId(){
        this.id = gloalId.addAndGet(1);
    }

    public <T> boolean equals(Object obj,Class<T>cls){
        if (obj == null || (cls.isInstance(obj))){
            return false;
        }
        return ((ID)obj).id.equals(this.id);
    }

    public int hasCode(){
        return id.hashCode();
    }

}
