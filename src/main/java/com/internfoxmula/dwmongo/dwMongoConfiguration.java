package com.internfoxmula.dwmongo;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class dwMongoConfiguration extends Configuration {
    // TODO: implement service configuration
    
    @JsonProperty
    @NotEmpty
    public String mongoHost="localhost";

    @JsonProperty
    @Min(1)
    @Max(65535)
    public int mongoPort=27017;

    @JsonProperty
    @NotEmpty
    public String mongoDB="softwaredevelopercentral";

    @JsonProperty
    @NotEmpty
    public String collectionName="employees";

    public String getMongoHost() {
        return mongoHost;
    }

    public void setMongoHost(String mongoHost) {
        this.mongoHost = mongoHost;
    }

    public int getMongoPort() {
        return mongoPort;
    }

    public void setMongoPort(int mongoPort) {
        this.mongoPort = mongoPort;
    }

    public String getMongoDB() {
        return mongoDB;
    }

    public void setMongoDB(String mongoDB) {
        this.mongoDB = mongoDB;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
}
