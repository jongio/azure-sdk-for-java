/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.blockchain.implementation;

import java.util.List;
import com.microsoft.azure.management.blockchain.SkuSetting;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Resource type Sku.
 */
public class ResourceTypeSkuInner {
    /**
     * Gets or sets the resource type.
     */
    @JsonProperty(value = "resourceType")
    private String resourceType;

    /**
     * Gets or sets the Skus.
     */
    @JsonProperty(value = "skus")
    private List<SkuSetting> skus;

    /**
     * Get gets or sets the resource type.
     *
     * @return the resourceType value
     */
    public String resourceType() {
        return this.resourceType;
    }

    /**
     * Set gets or sets the resource type.
     *
     * @param resourceType the resourceType value to set
     * @return the ResourceTypeSkuInner object itself.
     */
    public ResourceTypeSkuInner withResourceType(String resourceType) {
        this.resourceType = resourceType;
        return this;
    }

    /**
     * Get gets or sets the Skus.
     *
     * @return the skus value
     */
    public List<SkuSetting> skus() {
        return this.skus;
    }

    /**
     * Set gets or sets the Skus.
     *
     * @param skus the skus value to set
     * @return the ResourceTypeSkuInner object itself.
     */
    public ResourceTypeSkuInner withSkus(List<SkuSetting> skus) {
        this.skus = skus;
        return this;
    }

}
