package com.internfoxmula.dwmongo;


import com.internfoxmula.dwmongo.db.MongoService;
import com.internfoxmula.dwmongo.health.DropwizardMongoDBHealthCheckResource;
import com.internfoxmula.dwmongo.resources.EmployeeResource;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class dwMongoApplication extends Application<dwMongoConfiguration> {
    
    private static final Logger logger = LoggerFactory.getLogger(dwMongoApplication.class);
    
    public static void main(final String[] args) throws Exception {
        new dwMongoApplication().run(args);
    }

    @Override
    public String getName() {
        return "dwMongo";
    }

    @Override
    public void initialize(final Bootstrap<dwMongoConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final dwMongoConfiguration config,
                    final Environment env) throws Exception {
        // TODO: implement application
        MongoClient mongoClient = new MongoClient(config.getMongoHost(), config.getMongoPort());
        MongoManaged mongoManaged = new MongoManaged(mongoClient);
        env.lifecycle().manage(mongoManaged);
        MongoDatabase db = mongoClient.getDatabase(config.getMongoDB());
        MongoCollection<Document> collection = db.getCollection(config.getCollectionName());
        logger.info("Registering RESTful API resources");
        //env.jersey().register(new PingResource());
        env.jersey().register(new EmployeeResource(collection, new MongoService()));
        env.healthChecks().register("DropwizardMongoDBHealthCheck",
                new DropwizardMongoDBHealthCheckResource(mongoClient));
        
    }

}
