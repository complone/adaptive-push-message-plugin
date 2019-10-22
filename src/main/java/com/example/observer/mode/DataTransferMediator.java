/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.example.observer.mode;

import com.example.observer.transfer.TransferObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chengxy
 * 2019/10/22
 */
public class DataTransferMediator {

    private Map<TransferObject, List<DataListener>> mediator = new HashMap<>();

    /**
     * 应用启动时初始化
     */
    public void init() {
    }

    public synchronized boolean register(TransferObject transferObject, DataListener dataListener) {
        List<DataListener> oberverList = mediator.get(transferObject);
        if (oberverList == null) {
            oberverList = new ArrayList<>();
        }
        oberverList.add(dataListener);
        mediator.put(transferObject, oberverList);
        System.out.println(transferObject.getData().toString());
        return true;
    }

    public synchronized boolean unregister(TransferObject transferObject, DataListener dataListener) {
        List<DataListener> oberverList = mediator.get(transferObject);
        if (oberverList == null) {
            return false;
        }
        oberverList.remove(dataListener);
        mediator.put(transferObject, oberverList);
        return true;
    }

    public synchronized boolean notifyAll(TransferObject transferObject) {
        List<DataListener> dataListeners = mediator.get(transferObject);
        dataListeners.forEach(
            observer -> observer.getUpdateFunc().apply(transferObject)
        );
        return true;
    }
}
