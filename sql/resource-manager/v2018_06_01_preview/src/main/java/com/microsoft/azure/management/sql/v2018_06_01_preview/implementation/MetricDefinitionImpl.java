/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql.v2018_06_01_preview.implementation;

import com.microsoft.azure.management.sql.v2018_06_01_preview.MetricDefinition;
import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import rx.Observable;
import java.util.List;
import com.microsoft.azure.management.sql.v2018_06_01_preview.MetricAvailability;
import com.microsoft.azure.management.sql.v2018_06_01_preview.MetricName;
import com.microsoft.azure.management.sql.v2018_06_01_preview.PrimaryAggregationType;
import com.microsoft.azure.management.sql.v2018_06_01_preview.UnitType;

class MetricDefinitionImpl extends WrapperImpl<MetricDefinitionInner> implements MetricDefinition {
    private final SqlManager manager;

    MetricDefinitionImpl(MetricDefinitionInner inner,  SqlManager manager) {
        super(inner);
        this.manager = manager;
    }

    @Override
    public SqlManager manager() {
        return this.manager;
    }



    @Override
    public List<MetricAvailability> metricAvailabilities() {
        return this.inner().metricAvailabilities();
    }

    @Override
    public MetricName name() {
        return this.inner().name();
    }

    @Override
    public PrimaryAggregationType primaryAggregationType() {
        return this.inner().primaryAggregationType();
    }

    @Override
    public String resourceId() {
        return this.inner().resourceId();
    }

    @Override
    public List<String> supportedAggregationTypes() {
        return this.inner().supportedAggregationTypes();
    }

    @Override
    public UnitType unit() {
        return this.inner().unit();
    }

}
