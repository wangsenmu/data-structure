package com.wsm.data.structure.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by wangsm on 2018/5/29.
 */
public class BFS {

    /**
     * 按层级
     *
     * @param node
     */
    public static void bfsOrder(BinaryTree node) {

        if (node != null) {
            Queue<BinaryTree> queue = new ArrayDeque<BinaryTree>();
            queue.add(node);
            while (!queue.isEmpty()) {
                BinaryTree current_node = queue.poll();
                System.out.println(current_node.getData());
                if (current_node.getLeft() != null) {
                    queue.add(current_node.getLeft());
                }
                if (current_node.getRight() != null) {
                    queue.add(current_node.getRight());
                }
            }
        }
    }

}
