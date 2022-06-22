package com.test.experiment.ex.filterstream;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author trd
 * @since 2022/6/14 14:16
 */
public class ToFilter {
    @Test
    public void run() {

        List<OrdrA> ordrAList = new ArrayList<>();
        ordrAList.add(new OrdrA("To supply the new PT 1532", "zhangsan"));
        ordrAList.add(new OrdrA("To Site the new PT supply", "chenliu"));
        ordrAList.add(new OrdrA("To supply new PT 1532", "lisi"));
        ordrAList.add(new OrdrA("To LV new PT inspection", "wangwu"));
        ordrAList.add(new OrdrA("LN000252 supply new PT 1532", "lisi"));
        ordrAList.add(new OrdrA("LN000252(S) - Site work inspection", "wangwu"));
        ordrAList.add(new OrdrA("To supply LV", "chenliu"));

        List<UsrA> usrAList = new ArrayList<>();
        usrAList.add(new UsrA("zhangsan@qq.com", "zhangsan"));
        usrAList.add(new UsrA("lisi@qq.com", "lisi"));
        usrAList.add(new UsrA("wangwu@qq.com", "wangwu"));
        usrAList.add(new UsrA("chenliu@qq.com", "chenliu"));

        final List<OU> collect = ordrAList.stream()
                .map(v -> {
                    final UsrA usrA = usrAList.stream()
                            .filter(u -> u.account.equals(v.creator))
                            .collect(Collectors.toList()).get(0);
                    return OU.builder()
                            .creator(v.creator)
                            .desc(v.desc)
                            .email(usrA.email)
                            .build();
                }).collect(Collectors.toList());
        System.out.println();
    }


}
