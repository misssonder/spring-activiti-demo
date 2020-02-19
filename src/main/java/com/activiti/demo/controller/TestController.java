package com.activiti.demo.controller;

import com.activiti.demo.repository.UserRepository;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.runtime.TaskRuntime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "测试接口")
@RequestMapping("/test")
public class TestController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProcessRuntime processRuntime;
    @Autowired
    TaskRuntime taskRuntime;
    @ApiOperation(value ="测试")
    @RequestMapping(value = "/sayHello")
    public Object sayHello() {
        JSONObject result =new JSONObject();
//        ProcessInstance processInstance = processRuntime
//                .start(ProcessPayloadBuilder
//                        .start().withProcessDefinitionKey("holiday")
//                        .build());
//        result.put("ID",processInstance.getId());
        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));
        if(tasks.getTotalItems()>0){
            for (Task task : tasks.getContent()){
                System.out.println("任务"+task);
            }
        }
        return result;

    }
}
