/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.example.observer.mode;

import java.util.function.Function;

import lombok.AllArgsConstructor;

/**
 * @author chengxy
 * 2019/10/10
 */
@lombok.Data
@AllArgsConstructor
public class DataListener {

    private Application app;
    private Function<Data,Object> updateFunc;

    @Override
    public boolean equals(Object c){
        if (c == null || ! (c instanceof DataListener)){
            return false;
        }
        DataListener cmp = (DataListener) c;
        return cmp.getApp().equals(this.getApp());
    }

    @Override
    public int hashCode() {
        return app.hashCode();
    }
}
