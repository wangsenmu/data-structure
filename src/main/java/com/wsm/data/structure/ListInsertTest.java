package com.wsm.data.structure;

import java.util.List;

/**
 * Created by wangsm on 2018/1/4.
 */
public class ListInsertTest {

    public static void main(String[] args) {
        int [] list = {1,2,5,6,8,7,9,10};
        int aa[] = listInsert(list,3,10);
    }


    /**
     * 插入新元素以后依次往后移动，移除最后一个元素
     * @param list
     * @param index 下标位置
     * @param e 插入元素
     * @return
     */
    public static int[] listInsert(int[] list , int index, int e){

        if(index<1 || index>list.length)
            return list;
        if(index<list.length){
            for (int k =list.length-1;k>index;k--) {
                    list[k] = list[k-1];
            }
        }
        list[index] = e;
        return list;
    }

}
