/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.containerregistry.v2019_06_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The properties for updating the platform configuration.
 */
public class PlatformUpdateParameters {
    /**
     * The operating system type required for the run. Possible values include:
     * 'Windows', 'Linux'.
     */
    @JsonProperty(value = "os")
    private OS os;

    /**
     * The OS architecture. Possible values include: 'amd64', 'x86', 'arm'.
     */
    @JsonProperty(value = "architecture")
    private Architecture architecture;

    /**
     * Variant of the CPU. Possible values include: 'v6', 'v7', 'v8'.
     */
    @JsonProperty(value = "variant")
    private Variant variant;

    /**
     * Get the operating system type required for the run. Possible values include: 'Windows', 'Linux'.
     *
     * @return the os value
     */
    public OS os() {
        return this.os;
    }

    /**
     * Set the operating system type required for the run. Possible values include: 'Windows', 'Linux'.
     *
     * @param os the os value to set
     * @return the PlatformUpdateParameters object itself.
     */
    public PlatformUpdateParameters withOs(OS os) {
        this.os = os;
        return this;
    }

    /**
     * Get the OS architecture. Possible values include: 'amd64', 'x86', 'arm'.
     *
     * @return the architecture value
     */
    public Architecture architecture() {
        return this.architecture;
    }

    /**
     * Set the OS architecture. Possible values include: 'amd64', 'x86', 'arm'.
     *
     * @param architecture the architecture value to set
     * @return the PlatformUpdateParameters object itself.
     */
    public PlatformUpdateParameters withArchitecture(Architecture architecture) {
        this.architecture = architecture;
        return this;
    }

    /**
     * Get variant of the CPU. Possible values include: 'v6', 'v7', 'v8'.
     *
     * @return the variant value
     */
    public Variant variant() {
        return this.variant;
    }

    /**
     * Set variant of the CPU. Possible values include: 'v6', 'v7', 'v8'.
     *
     * @param variant the variant value to set
     * @return the PlatformUpdateParameters object itself.
     */
    public PlatformUpdateParameters withVariant(Variant variant) {
        this.variant = variant;
        return this;
    }

}
