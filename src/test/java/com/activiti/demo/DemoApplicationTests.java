package com.activiti.demo;

import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.impl.Page;
import org.apache.catalina.security.SecurityUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest
@RunWith(SpringRunner.class)
class DemoApplicationTests {
    @Autowired
    TaskRuntime taskRuntime;
    @Autowired
    ProcessRuntime processRuntime;
    @Test
    void contextLoads() {
        ProcessDefinition processDefinition = processRuntime.processDefinition(String.valueOf(Pageable.of(0, 10)));
        System.out.println(processDefinition.getKey());

    }

}
