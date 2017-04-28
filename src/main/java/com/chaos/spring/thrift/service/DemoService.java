package com.chaos.spring.thrift.service;

import com.chaos.spring.thrift.define.gen.Demo;
import com.chaos.spring.thrift.module.DemoModule;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zcfrank1st on 27/04/2017.
 */
@Component
public class DemoService implements Demo.Iface {
    private final DemoModule demoModule;

    @Autowired
    public DemoService(DemoModule demoModule) {
        this.demoModule = demoModule;
    }


    @Override
    public void helloworld() throws TException {
        System.out.println(demoModule.hello());
    }
}
