package com.example.chartspringbootsamples.base;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Rollback()
@Transactional
public class BaseTest {
}
