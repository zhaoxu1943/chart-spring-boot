package com.z.starter.autoconfig.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhaoxu
 * @date 2022/4/22 16:21
 * @since
 */
class PageCreateUtilTest {

  @Test
  void createPageStructure() {
    System.out.println(PageCreateUtil.createPageStructure("alarm",8,9,1));
  }
}