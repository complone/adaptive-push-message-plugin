/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the dataidential and proprietary information of GuaHao Company.
 * ("dataidential Information").
 * You shall not disclose such dataidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.example.observer.transfer;

import com.example.observer.mode.DataTransferMediator;
import com.example.observer.mode.ID;

import lombok.Getter;

/**
 * @author chengxy
 * 2019/10/22
 */
@Getter
public class TransferObject<T> extends ID {

    private T data;
    private DataTransferMediator mediator;

    public TransferObject(T data, DataTransferMediator mediator) {
        super.setId();
        this.data = data;
        this.mediator = mediator;
    }

    public void update(T data) {
        this.data = data;
        mediator.notifyAll(this);
    }

    @Override
    public boolean equals(Object c) {
        return equals(c, TransferObject.class);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}