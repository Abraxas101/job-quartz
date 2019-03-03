package com.nwx.job.quartz.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @version : V1.0
 * @Description: 集合操作工具类
 * @Auther: Neil
 * @Date: 2019/3/3 14:32
 */
public class ListUtils {

    /**
     * @Author Neil
     * @Description 集合的切割
     * @Date 2019/3/3 14:40
     * @Param [list 待切割的集合, pageSize 分页长度]
     * @return java.util.List<java.util.List<T>> 返回分页数据
     **/
    public static <T> List<List<T>> splitList(List<T> list, int pageSize){
        int listSize = list.size();
        int page = (listSize + (pageSize - 1)) / pageSize;
        List<List<T>> listArray = new ArrayList<List<T>>();
        for (int i = 0; i < page; i++) {
            List<T> subList = new ArrayList<T>();

            for (int j = 0; j < listSize; j++) {
                int pageIndex  = ((j + 1) + (pageSize - 1)) / pageSize;
                if(pageIndex == (i + 1)){
                    subList.add(list.get(j));
                }
                if((j + 1) == ((j + 1) * pageSize)){
                    break;
                }
            }
            listArray.add(subList);
        }
        return listArray;
    }
}
