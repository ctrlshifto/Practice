package com.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.codec.Charsets;


/**
 * @Author:WhomHim
 * @Description:
 * @Date: Create in 2020-3-3 12:57:06
 * @Modified by:
 */
public class BloomFilterTest {
    public static void main(String[] args) {
        long expectedInsertions = 10000000;
        double fpp = 0.00001;
        BloomFilter<CharSequence> bloomFilter = BloomFilter
                .create(Funnels.stringFunnel(Charsets.UTF_8), expectedInsertions, fpp);

        bloomFilter.put("aaa");
        bloomFilter.put("bbb");
        boolean containsString = bloomFilter.mightContain("aaa");
        System.out.println(containsString);

        BloomFilter<Email> emailBloomFilter = BloomFilter
                .create((Funnel<Email>) (from, into) -> into.putString(from.getDomain(), Charsets.UTF_8),
                        expectedInsertions, fpp);

        emailBloomFilter.put(new Email("sage.wang", "quanr.com"));
        boolean containsEmail = emailBloomFilter.mightContain(new Email("sage.wangaaa", "quanr.com"));
        System.out.println(containsEmail);
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
