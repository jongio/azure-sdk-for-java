/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cosmosdb.v2015_04_08.implementation;

import com.microsoft.azure.management.cosmosdb.v2015_04_08.SqlStoredProcedure;
import com.microsoft.azure.arm.model.implementation.CreatableUpdatableImpl;
import rx.Observable;
import com.microsoft.azure.management.cosmosdb.v2015_04_08.SqlStoredProcedureCreateUpdateParameters;
import java.util.Map;
import com.microsoft.azure.management.cosmosdb.v2015_04_08.SqlStoredProcedureResource;
import rx.functions.Func1;

class SqlStoredProcedureImpl extends CreatableUpdatableImpl<SqlStoredProcedure, SqlStoredProcedureInner, SqlStoredProcedureImpl> implements SqlStoredProcedure, SqlStoredProcedure.Definition, SqlStoredProcedure.Update {
    private final CosmosDBManager manager;
    private String resourceGroupName;
    private String accountName;
    private String databaseName;
    private String containerName;
    private String storedProcedureName;
    private SqlStoredProcedureCreateUpdateParameters createOrUpdateParameter;

    SqlStoredProcedureImpl(String name, CosmosDBManager manager) {
        super(name, new SqlStoredProcedureInner());
        this.manager = manager;
        // Set resource name
        this.storedProcedureName = name;
        //
        this.createOrUpdateParameter = new SqlStoredProcedureCreateUpdateParameters();
    }

    SqlStoredProcedureImpl(SqlStoredProcedureInner inner, CosmosDBManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.storedProcedureName = inner.name();
        // set resource ancestor and positional variables
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        this.accountName = IdParsingUtils.getValueFromIdByName(inner.id(), "databaseAccounts");
        this.databaseName = IdParsingUtils.getValueFromIdByName(inner.id(), "databases");
        this.containerName = IdParsingUtils.getValueFromIdByName(inner.id(), "containers");
        this.storedProcedureName = IdParsingUtils.getValueFromIdByName(inner.id(), "storedprocedures");
        //
        this.createOrUpdateParameter = new SqlStoredProcedureCreateUpdateParameters();
    }

    @Override
    public CosmosDBManager manager() {
        return this.manager;
    }

    @Override
    public Observable<SqlStoredProcedure> createResourceAsync() {
        DatabaseAccountsInner client = this.manager().inner().databaseAccounts();
        return client.createUpdateSqlStoredProcedureAsync(this.resourceGroupName, this.accountName, this.databaseName, this.containerName, this.storedProcedureName, this.createOrUpdateParameter)
            .map(new Func1<SqlStoredProcedureInner, SqlStoredProcedureInner>() {
               @Override
               public SqlStoredProcedureInner call(SqlStoredProcedureInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<SqlStoredProcedure> updateResourceAsync() {
        DatabaseAccountsInner client = this.manager().inner().databaseAccounts();
        return client.createUpdateSqlStoredProcedureAsync(this.resourceGroupName, this.accountName, this.databaseName, this.containerName, this.storedProcedureName, this.createOrUpdateParameter)
            .map(new Func1<SqlStoredProcedureInner, SqlStoredProcedureInner>() {
               @Override
               public SqlStoredProcedureInner call(SqlStoredProcedureInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<SqlStoredProcedureInner> getInnerAsync() {
        DatabaseAccountsInner client = this.manager().inner().databaseAccounts();
        return client.getSqlStoredProcedureAsync(this.resourceGroupName, this.accountName, this.databaseName, this.containerName, this.storedProcedureName);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }

    private void resetCreateUpdateParameters() {
        this.createOrUpdateParameter = new SqlStoredProcedureCreateUpdateParameters();
    }

    @Override
    public String _etag() {
        return this.inner()._etag();
    }

    @Override
    public String _rid() {
        return this.inner()._rid();
    }

    @Override
    public Object _ts() {
        return this.inner()._ts();
    }

    @Override
    public String body() {
        return this.inner().body();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String location() {
        return this.inner().location();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public String sqlStoredProcedureId() {
        return this.inner().sqlStoredProcedureId();
    }

    @Override
    public Map<String, String> tags() {
        return this.inner().getTags();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public SqlStoredProcedureImpl withExistingContainer(String resourceGroupName, String accountName, String databaseName, String containerName) {
        this.resourceGroupName = resourceGroupName;
        this.accountName = accountName;
        this.databaseName = databaseName;
        this.containerName = containerName;
        return this;
    }

    @Override
    public SqlStoredProcedureImpl withOptions(Map<String, String> options) {
        this.createOrUpdateParameter.withOptions(options);
        return this;
    }

    @Override
    public SqlStoredProcedureImpl withResource(SqlStoredProcedureResource resource) {
        this.createOrUpdateParameter.withResource(resource);
        return this;
    }

}
