package com.mashibing.inter;

import org.springframework.stereotype.Service;

/**
 * ClassName: com.mashibing.inter
 * Function: TODO
 * Reason: TODO
 * Date: 2020/9/29
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
@Service
public class MyCalculator2 {
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    public int mult(int i, int j) {
        int result = i * j;
        return result;
    }

    public int div(int i, int j) {
        int result = i / j;
        return result;
    }

    public Integer doAdd(Integer i, Integer j) {
        Integer result = i+j;
        return result;
    }
}
