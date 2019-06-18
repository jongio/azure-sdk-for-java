/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * abc
 */

package com.microsoft.azure.management.databox.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.databox.Services;
import rx.functions.Func1;
import rx.Observable;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.databox.SkuInformation;
import com.microsoft.azure.management.databox.AddressValidationOutput;
import com.microsoft.azure.management.databox.AvailableSkuRequest;
import com.microsoft.azure.management.databox.ValidateAddress;

class ServicesImpl extends WrapperImpl<ServicesInner> implements Services {
    private final DataBoxManager manager;

    ServicesImpl(DataBoxManager manager) {
        super(manager.inner().services());
        this.manager = manager;
    }

    public DataBoxManager manager() {
        return this.manager;
    }

    @Override
    public Observable<SkuInformation> listAvailableSkusAsync(final String location, final AvailableSkuRequest availableSkuRequest) {
        ServicesInner client = this.inner();
        return client.listAvailableSkusAsync(location, availableSkuRequest)
        .flatMapIterable(new Func1<Page<SkuInformationInner>, Iterable<SkuInformationInner>>() {
            @Override
            public Iterable<SkuInformationInner> call(Page<SkuInformationInner> page) {
                return page.items();
            }
        })
        .map(new Func1<SkuInformationInner, SkuInformation>() {
            @Override
            public SkuInformation call(SkuInformationInner inner) {
                return new SkuInformationImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<AddressValidationOutput> validateAddressMethodAsync(String location, ValidateAddress validateAddress) {
        ServicesInner client = this.inner();
        return client.validateAddressMethodAsync(location, validateAddress)
        .map(new Func1<AddressValidationOutputInner, AddressValidationOutput>() {
            @Override
            public AddressValidationOutput call(AddressValidationOutputInner inner) {
                return new AddressValidationOutputImpl(inner, manager());
            }
        });
    }

}
