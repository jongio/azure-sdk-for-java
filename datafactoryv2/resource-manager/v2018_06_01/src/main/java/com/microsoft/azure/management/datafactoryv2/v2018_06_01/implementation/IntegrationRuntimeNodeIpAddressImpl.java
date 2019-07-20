/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datafactoryv2.v2018_06_01.implementation;

import com.microsoft.azure.management.datafactoryv2.v2018_06_01.IntegrationRuntimeNodeIpAddress;
import com.microsoft.azure.arm.model.implementation.WrapperImpl;

class IntegrationRuntimeNodeIpAddressImpl extends WrapperImpl<IntegrationRuntimeNodeIpAddressInner> implements IntegrationRuntimeNodeIpAddress {
    private final DataFactoryManager manager;
    IntegrationRuntimeNodeIpAddressImpl(IntegrationRuntimeNodeIpAddressInner inner, DataFactoryManager manager) {
        super(inner);
        this.manager = manager;
    }

    @Override
    public DataFactoryManager manager() {
        return this.manager;
    }

    @Override
    public String ipAddress() {
        return this.inner().ipAddress();
    }

}