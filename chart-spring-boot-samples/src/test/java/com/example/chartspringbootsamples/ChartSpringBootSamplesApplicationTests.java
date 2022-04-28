package com.example.chartspringbootsamples;

import com.z.starter.autoconfig.controller.PageController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * base test test if the application context cannot start
 *
 * @param
 * @return
 * @throws
 * @author zhaoxu
 */
// @SpringBootTest will search for @SpringBootConfiguration
// which in @SpringbootApplication
// and use that to start a spring application context

@SpringBootTest

// nice feature is spring test support is cached between  tests
// so start application only once  ,@DirtiesContext can controller it
class ChartSpringBootSamplesApplicationTests {

    @Resource
    PageController pageController;

    @Test
    void contextLoads() {
        //test important bean is not null
        assertThat(pageController).isNotNull();
    }

}
