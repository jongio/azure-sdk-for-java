/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datafactoryv2.v2018_06_01;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.management.datafactoryv2.v2018_06_01.implementation.LinkedServiceInner;

/**
 * Azure SQL Managed Instance linked service.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("AzureSqlMI")
@JsonFlatten
public class AzureSqlMILinkedService extends LinkedServiceInner {
    /**
     * The connection string. Type: string, SecureString or
     * AzureKeyVaultSecretReference.
     */
    @JsonProperty(value = "typeProperties.connectionString", required = true)
    private Object connectionString;

    /**
     * The Azure key vault secret reference of password in connection string.
     */
    @JsonProperty(value = "typeProperties.password")
    private AzureKeyVaultSecretReference password;

    /**
     * The ID of the service principal used to authenticate against Azure SQL
     * Managed Instance. Type: string (or Expression with resultType string).
     */
    @JsonProperty(value = "typeProperties.servicePrincipalId")
    private Object servicePrincipalId;

    /**
     * The key of the service principal used to authenticate against Azure SQL
     * Managed Instance.
     */
    @JsonProperty(value = "typeProperties.servicePrincipalKey")
    private SecretBase servicePrincipalKey;

    /**
     * The name or ID of the tenant to which the service principal belongs.
     * Type: string (or Expression with resultType string).
     */
    @JsonProperty(value = "typeProperties.tenant")
    private Object tenant;

    /**
     * The encrypted credential used for authentication. Credentials are
     * encrypted using the integration runtime credential manager. Type: string
     * (or Expression with resultType string).
     */
    @JsonProperty(value = "typeProperties.encryptedCredential")
    private Object encryptedCredential;

    /**
     * Get the connection string. Type: string, SecureString or AzureKeyVaultSecretReference.
     *
     * @return the connectionString value
     */
    public Object connectionString() {
        return this.connectionString;
    }

    /**
     * Set the connection string. Type: string, SecureString or AzureKeyVaultSecretReference.
     *
     * @param connectionString the connectionString value to set
     * @return the AzureSqlMILinkedService object itself.
     */
    public AzureSqlMILinkedService withConnectionString(Object connectionString) {
        this.connectionString = connectionString;
        return this;
    }

    /**
     * Get the Azure key vault secret reference of password in connection string.
     *
     * @return the password value
     */
    public AzureKeyVaultSecretReference password() {
        return this.password;
    }

    /**
     * Set the Azure key vault secret reference of password in connection string.
     *
     * @param password the password value to set
     * @return the AzureSqlMILinkedService object itself.
     */
    public AzureSqlMILinkedService withPassword(AzureKeyVaultSecretReference password) {
        this.password = password;
        return this;
    }

    /**
     * Get the ID of the service principal used to authenticate against Azure SQL Managed Instance. Type: string (or Expression with resultType string).
     *
     * @return the servicePrincipalId value
     */
    public Object servicePrincipalId() {
        return this.servicePrincipalId;
    }

    /**
     * Set the ID of the service principal used to authenticate against Azure SQL Managed Instance. Type: string (or Expression with resultType string).
     *
     * @param servicePrincipalId the servicePrincipalId value to set
     * @return the AzureSqlMILinkedService object itself.
     */
    public AzureSqlMILinkedService withServicePrincipalId(Object servicePrincipalId) {
        this.servicePrincipalId = servicePrincipalId;
        return this;
    }

    /**
     * Get the key of the service principal used to authenticate against Azure SQL Managed Instance.
     *
     * @return the servicePrincipalKey value
     */
    public SecretBase servicePrincipalKey() {
        return this.servicePrincipalKey;
    }

    /**
     * Set the key of the service principal used to authenticate against Azure SQL Managed Instance.
     *
     * @param servicePrincipalKey the servicePrincipalKey value to set
     * @return the AzureSqlMILinkedService object itself.
     */
    public AzureSqlMILinkedService withServicePrincipalKey(SecretBase servicePrincipalKey) {
        this.servicePrincipalKey = servicePrincipalKey;
        return this;
    }

    /**
     * Get the name or ID of the tenant to which the service principal belongs. Type: string (or Expression with resultType string).
     *
     * @return the tenant value
     */
    public Object tenant() {
        return this.tenant;
    }

    /**
     * Set the name or ID of the tenant to which the service principal belongs. Type: string (or Expression with resultType string).
     *
     * @param tenant the tenant value to set
     * @return the AzureSqlMILinkedService object itself.
     */
    public AzureSqlMILinkedService withTenant(Object tenant) {
        this.tenant = tenant;
        return this;
    }

    /**
     * Get the encrypted credential used for authentication. Credentials are encrypted using the integration runtime credential manager. Type: string (or Expression with resultType string).
     *
     * @return the encryptedCredential value
     */
    public Object encryptedCredential() {
        return this.encryptedCredential;
    }

    /**
     * Set the encrypted credential used for authentication. Credentials are encrypted using the integration runtime credential manager. Type: string (or Expression with resultType string).
     *
     * @param encryptedCredential the encryptedCredential value to set
     * @return the AzureSqlMILinkedService object itself.
     */
    public AzureSqlMILinkedService withEncryptedCredential(Object encryptedCredential) {
        this.encryptedCredential = encryptedCredential;
        return this;
    }

}
