/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.example.observer.transfer;

import com.example.observer.mode.ID;

/**
 * @author chengxy
 * 2019/10/22
 */
public abstract class Application extends ID {

    @Override
    public boolean equals(Object c) {
        return equals(c, Application.class);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}

