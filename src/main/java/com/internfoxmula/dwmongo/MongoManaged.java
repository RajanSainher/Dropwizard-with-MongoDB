/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.internfoxmula.dwmongo;

/**
 *
 * @author sainh
 */
import com.mongodb.Mongo;
import io.dropwizard.lifecycle.Managed;
 
public class MongoManaged implements Managed {
 
    private Mongo mongo;
 
    public MongoManaged(Mongo mongo) {
        this.mongo = mongo;
    }
 
    @Override
    public void start() throws Exception {
    }
 
    @Override
    public void stop() throws Exception {
        mongo.close();
    }
 
}