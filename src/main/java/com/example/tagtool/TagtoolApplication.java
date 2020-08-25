package com.example.tagtool;

import com.example.tagtool.tagController.UserController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
@MapperScan("com.example.tagtool.tagDao")//扫描指定包的接口
public class TagtoolApplication  {

//    public String minWindow(String S, String T) {
//        int lent = T.length();
//        int lens = S.length();
//        int cnt = 0;
//        int begin = lens;
//        int next = 0;
//        int minbegin = lens;
//        int minlen = lens+1;
//
//        for(int i=0;i<lens;){
//            if(S.charAt(i)!=T.charAt(cnt))
//            {
//                if(S.charAt(i)==T.charAt(0)&&next==0)
//                {
//                    next=i;
//                }
//                i++;
//                continue;
//            }
//            else{
//
//                if(cnt == 0)
//                    begin = i;
//                cnt++;
//                if(cnt == lent) {
//                    int lennow = i-begin+1;
//                    if (lennow<minlen){
//                        minlen = lennow;
//                        minbegin = begin;
//                    }
//                    cnt =0;
//                    i=next==0?begin+1:next;
//                    next = 0;
//                    continue;
//                }
//                i++;
//            }
//        }
//        if(minlen > lens){return "";}
//        return S.substring(minbegin,minbegin+minlen);
//    }
//    public static void main(String[] args)
//    {
//        System.out.println(new TagtoolApplication().minWindow("abbcbddde","bce"));
//    }
    public static void main(String[] args) {
        SpringApplication.run(TagtoolApplication.class, args);
    }

}
