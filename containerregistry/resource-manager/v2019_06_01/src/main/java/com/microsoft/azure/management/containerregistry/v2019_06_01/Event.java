/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.containerregistry.v2019_06_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.containerregistry.v2019_06_01.implementation.ContainerRegistryManager;
import com.microsoft.azure.management.containerregistry.v2019_06_01.implementation.EventInner;

/**
 * Type representing Event.
 */
public interface Event extends HasInner<EventInner>, HasManager<ContainerRegistryManager> {
    /**
     * @return the eventRequestMessage value.
     */
    EventRequestMessage eventRequestMessage();

    /**
     * @return the eventResponseMessage value.
     */
    EventResponseMessage eventResponseMessage();

    /**
     * @return the id value.
     */
    String id();

}
