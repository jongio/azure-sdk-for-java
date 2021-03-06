/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.subscription.v2019_10_01_preview.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The created subscription object.
 */
public class SubscriptionCreationResultInner {
    /**
     * The link to the new subscription. Use this link to check the status of
     * subscription creation operation.
     */
    @JsonProperty(value = "subscriptionLink")
    private String subscriptionLink;

    /**
     * Get the link to the new subscription. Use this link to check the status of subscription creation operation.
     *
     * @return the subscriptionLink value
     */
    public String subscriptionLink() {
        return this.subscriptionLink;
    }

    /**
     * Set the link to the new subscription. Use this link to check the status of subscription creation operation.
     *
     * @param subscriptionLink the subscriptionLink value to set
     * @return the SubscriptionCreationResultInner object itself.
     */
    public SubscriptionCreationResultInner withSubscriptionLink(String subscriptionLink) {
        this.subscriptionLink = subscriptionLink;
        return this;
    }

}
