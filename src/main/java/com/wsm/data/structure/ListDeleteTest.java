package com.wsm.data.structure;

import java.util.LinkedList;

/**
 * Created by wangsm on 2018/1/4.
 */
public class ListDeleteTest {

    public static void main(String[] args) {


        LinkedList linkList =new LinkedList();
//        linkList.add()

        int [] list = {1,2,5,6,8,7,9,10};
        int aa[] = listDelete(list,3);
    }


    /**
     * 移除指定下标元素，其余元素往前异味，最后一位保留
     * @param list
     * @param index
     * @return
     */
    public static int [] listDelete(int [] list ,int index){

        if(index<list.length){
            for (int i= index;i<list.length-1;i++) {
                list[i]= list[i+1];
            }
        }
        return list;

    }

}
