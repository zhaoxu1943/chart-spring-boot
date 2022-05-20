package com.example.chartspringbootsamples.controller;

import com.z.starter.autoconfig.query.PageCardQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;

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


    private static final String TEST_PAGE_NAME_1 = "alarm";

    private static final PageCardQuery testQuery1 = new PageCardQuery().setPageName(TEST_PAGE_NAME_1).setCardNumber(6).setCardOffset(1).setCardSpan(8).setNumberOfCutPage(2);



    //inject the random port
    @LocalServerPort
    private int port;

    //spring boot automatically provided a testRestTemplate
    //just @Autowired to it
    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    public void createPageShouldReturnPageObj() {
        //RequestBody
        HttpEntity<PageCardQuery> request = new HttpEntity<>(testQuery1);

        String json =  this.testRestTemplate.postForObject("http://localhost:"+port+"/page-info/create",request,
                String.class);

        assertThat(json).isNotNull();
    }


}
