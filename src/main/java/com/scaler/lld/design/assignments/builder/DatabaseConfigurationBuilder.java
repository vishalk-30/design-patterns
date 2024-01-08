package com.scaler.lld.design.assignments.builder;

import lombok.Getter;

@WithBuilder
@Getter
public class DatabaseConfigurationBuilder {
    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

    public DatabaseConfigurationBuilder() {
    }

    public DatabaseConfigurationBuilder(String databaseUrl, String username, String password, int maxConnections, boolean enableCache, boolean isReadOnly) {
        this.databaseUrl = databaseUrl;
        this.username = username;
        this.password = password;
        this.maxConnections = maxConnections;
        this.enableCache = enableCache;
        this.isReadOnly = isReadOnly;
    }
    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private DatabaseConfigurationBuilder db ;

        public Builder databaseUrl(String databaseUrl) {
            db.databaseUrl = databaseUrl;
            return this;
        }

        public Builder setUsername(String username) {
            db.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            db.password = password;
            return this;
        }

        public Builder setMaxConnections(int maxConnections) {
            db.maxConnections = maxConnections;
            return this;
        }

        public Builder setEnableCache(boolean enableCache) {
            db.enableCache = enableCache;
            return this;
        }

        public Builder setReadOnly(boolean readOnly) {
            db.isReadOnly = readOnly;
            return this;
        }

        public DatabaseConfigurationBuilder build(){
            DatabaseConfigurationBuilder databaseConfigurationBuilder = new DatabaseConfigurationBuilder();
            databaseConfigurationBuilder.databaseUrl = db.databaseUrl;
            databaseConfigurationBuilder.password = db.password;
            databaseConfigurationBuilder.username = db.username;
            databaseConfigurationBuilder.maxConnections = db.maxConnections;
            databaseConfigurationBuilder.enableCache = db.enableCache;
            databaseConfigurationBuilder.isReadOnly = db.isReadOnly;
            return databaseConfigurationBuilder;
        }

    }


}