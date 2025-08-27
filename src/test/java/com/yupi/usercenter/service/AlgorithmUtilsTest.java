package com.yupi.usercenter.service;

import com.yupi.usercenter.utils.AlgorithmUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


/**
 * 算法工具类测试
 */
public class AlgorithmUtilsTest {

    @Test
    void test() {
        String str1 = "yupidog";
        String str2 = "yupicat";
        String str3 = "yupipig";
        int distance1 = AlgorithmUtils.minDistance(str1, str2);
        int distance2 = AlgorithmUtils.minDistance(str1, str3);
        System.out.println(distance1);
        System.out.println(distance2);
    }

    @Test
    void testCompareTags() {
        List<String> tagList1 = Arrays.asList("java", "大一", "男");
        List<String> tagList2 = Arrays.asList("java", "大二", "女");
        List<String> tagList3 = Arrays.asList("python", "大二", "女");

        int distance1 = AlgorithmUtils.minDistance(tagList1, tagList2);
        int distance2 = AlgorithmUtils.minDistance(tagList1, tagList3);
        System.out.println(distance1);
        System.out.println(distance2);
    }
}
