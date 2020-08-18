package com.bloom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


/**
 * @Author:WhomHim
 * @Description:
 * @Date: Create in 2020-3-3 12:57:06
 * @Modified by:
 */
public class BloomFilterTest {
    public static void main(String[] args) {
    }

    @Data
    @Builder
    @ToString
    @AllArgsConstructor
    public static class Email {
        private String userName;
        private String domain;
    }
}
