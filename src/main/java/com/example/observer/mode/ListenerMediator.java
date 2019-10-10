/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.example.observer.mode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chengxy
 * 中介者模式 管理观察者与被观察者的交互
 * 2019/10/10
 */
public class ListenerMediator {

    private Map<Data, List<DataListener>> mediator = new HashMap<>();

    public void init(){}

    public synchronized boolean register(Data data,DataListener dataListener){
        List<DataListener> dataListeners = mediator.get(data);

        if (dataListener == null){
            dataListeners = new ArrayList<>();
        }
        dataListeners.add(dataListener);
        mediator.put(data,dataListeners);
        return true;

    }


    public synchronized boolean unregister(Data data,DataListener dataListener){
        List<DataListener> dataListeners = mediator.get(data);
        if (dataListeners == null) {
            return false;
        }
        dataListeners.remove(dataListener);
        mediator.put(data, dataListeners);
        return true;
    }

    public synchronized boolean notifyAll(Data data) {
        List<DataListener> configObservers = mediator.get(data);
        configObservers.forEach(
            observer -> observer.getUpdateFunc().apply(data)
        );
        return true;
    }

}
