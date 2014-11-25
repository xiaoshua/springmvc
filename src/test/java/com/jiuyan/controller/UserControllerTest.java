package com.jiuyan.controller;

import com.jiuyan.base.BaseTest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by xiaoshua on 2014/11/19.
 */
public class UserControllerTest extends BaseTest {

    @Autowired
    private UserController userController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testGetAll() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/getAll").accept(MediaType.APPLICATION_JSON));
        System.out.println(ToStringBuilder.reflectionToString(resultActions));
        MvcResult mvcResult = resultActions.andReturn();
        System.out.println(ToStringBuilder.reflectionToString(mvcResult));
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println(result);
    }

}
