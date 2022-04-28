package com.example.chartspringbootsamples.controller;

import com.z.starter.autoconfig.dto.PageCardDTO;
import com.z.starter.autoconfig.dto.ResultDTO;
import com.z.starter.autoconfig.po.Page;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * RANDOM_PORT to start server with a random port
 * useful to avoid conflicts in test environment
 *
 *  @localServerPort can inject the port
 *
 * @author zhaoxu
 * @date 2022/4/28 9:58
 * @since
 */
//add springRunner to start application contest
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PageControllerTest {


    //inject the random port
    @LocalServerPort
    private int port;

    //spring boot automatically provided a testRestTemplate
    //just @Autowired to it
    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    public void createPageShouldReturnPageObj() throws Exception{


        //RequsetBody
        HttpEntity<PageCardDTO> request = new HttpEntity<>(new PageCardDTO().setPageName("alarm").setCardNumber(6).setCardOffset(1).setCardSpan(8));

        String json =  this.testRestTemplate.postForObject("http://localhost:"+port+"/page-info/create",request,
                String.class);
        assertThat(json).isNotNull();
    }


}