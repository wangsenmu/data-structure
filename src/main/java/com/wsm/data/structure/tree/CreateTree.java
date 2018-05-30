package com.wsm.data.structure.tree;

/**
 * Created by wangsm on 2018/5/29.
 */
@SuppressWarnings("all")
public class CreateTree {


    public static void main(String[] args) {


        //创建 插入
        BinaryTree node_a = new BinaryTree("a");
        node_a.insertLeft(node_a, "b");
        node_a.insertRight(node_a, "c");

        BinaryTree node_b = node_a.getLeft();
        BinaryTree node_c = node_a.getRight();

        node_b.insertRight(node_b, "d");
        node_c.insertLeft(node_c, "e");
        node_c.insertRight(node_c, "f");

        BinaryTree node_d = node_b.getRight();
        BinaryTree node_e = node_c.getLeft();
        BinaryTree node_f = node_c.getRight();


    /*    System.out.println("【node_a data】:" + node_a.getData());
        System.out.println("【node_b data】:" + node_b.getData());
        System.out.println("【node_c data】:" + node_c.getData());
        System.out.println("【node_d data】:" + node_d.getData());
        System.out.println("【node_e data】:" + node_e.getData());
        System.out.println("【node_f data】:" + node_f.getData());*/


       /* System.out.println("前序遍历:--------");
        node_a.preOrder(node_a);
        System.out.println("中序遍历:--------");
        node_a.inOrder(node_a);
        System.out.println("后序遍历:--------");
        node_a.afterOrder(node_a);*/


        BFS.bfsOrder(node_a);

    }

}
