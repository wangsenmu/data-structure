package com.wsm.data.structure.tree;

/**
 * Created by wangsm on 2018/5/29.
 */
public class BinaryTree {

    private BinaryTree left;
    private BinaryTree right;
    private String data;

    public BinaryTree() {
    }


    public BinaryTree(String data) {
        this(data, null, null);
    }

    public BinaryTree(String data, BinaryTree left, BinaryTree right) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void insertLeft(BinaryTree node, String value) {
        //先判断参数不为空
        if (node != null) {
            //如果插入结点没有左结点，则新建结点，并作为该结点的左结点
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTree(value));
            } else {
                BinaryTree newB = new BinaryTree(value);
                newB.setLeft(node.getLeft());
                node.setLeft(newB);
            }
        }
    }

    public void insertRight(BinaryTree node, String value) {
        //先判断参数不为空
        if (node != null) {
            //如果插入结点没有左结点，则新建结点，并作为该结点的左结点
            if (node.getRight() == null) {
                node.setRight(new BinaryTree(value));
            } else {
                BinaryTree newB = new BinaryTree(value);
                newB.setRight(node.getRight());
                node.setRight(newB);
            }
        }
    }

    public void preOrder(BinaryTree node) {
        if (node != null) {
            System.out.println(node.getData());
            if (node.getLeft() != null) {
                node.getLeft().preOrder(node.getLeft());
            }
            if (node.getRight() != null) {
                node.getRight().preOrder(node.getRight());
            }
        }
    }


    /**
     * 中序遍历
     * 左结点优先，之后是中间，然后是右结点
     */
    public void inOrder(BinaryTree node) {
        if (node != null) {
            if (node.getLeft() != null) {
                node.getLeft().inOrder(node.getLeft());
            }
            System.out.println(node.getData());
            if (node.getRight() != null) {
                node.getRight().inOrder(node.getRight());
            }
        }
    }


    /**
     * 后序遍历
     * <p>
     * 1、进入左结点并输出，当且仅当它有左结点
     * 2、输出根结点的值
     * 3、进入结点并输出，当且仅当它有右结点
     */
    public void afterOrder(BinaryTree node) {
        if (node == null)
            return;
        if (node.getLeft() != null) {
            node.getLeft().afterOrder(node.getLeft());
        }

        if (node.getRight() != null) {
            node.getRight().afterOrder(node.getRight());
        }
        System.out.println(node.getData());
    }


    public void insertNode(BinaryTree node, Integer value) {

        if (node == null)
            return;
        if (value <= Integer.parseInt(node.getData()) && node.getLeft() != null) {
            node.getLeft().insertNode(node.getLeft(), value);
        } else if (value <= Integer.parseInt(node.getData())) {
            node.setLeft(new BinaryTree(value + ""));
        } else if (value > Integer.parseInt(node.getData()) && node.getRight() != null) {
            node.getRight().insertNode(node.getRight(), value);
        } else if (value > Integer.parseInt(node.getData())) {
            node.setRight(new BinaryTree(value + ""));
        }
    }

    /**
     * 查找节点是否存在
     *
     *  1、我们以根结点作为当前节点开始。给定值小于当前结点值吗？如果是，那么我将在左子树上查找它。
     *  2、给定值大于当前结点值吗？如果是，那么我们将在右子树上查找它。
     *  3、如果规则 #1 和 #2 均为假，我们可以比较当前节点值和给定值是否相等。如果返回真，那么我们可以说：“是的，我们的树拥有给定的值。” 否则，我们说： “不，我们的树没有给定的值。”
     */
    public boolean findNode(BinaryTree node, Integer value) {
        if (node == null)
            return false;
        if (value < Integer.parseInt(node.getData()) && node.getLeft() != null) {
            return node.getLeft().findNode(node.getLeft(), value);
        }
        if (value > Integer.parseInt(node.getData()) && node.getRight() != null) {
            return node.getRight().findNode(node.getRight(), value);
        }
        return value == Integer.parseInt(node.getData());
    }

    /**
     * 删除节点
     * @param node
     * @param value
     * @param parent
     * @return
     *
     * 首先: 注意下参数 value 和 parent 。我们想找到值等于该 value 的 node ，并且该 node 的父节点对于删除该 node 是至关重要的。
    其次: 注意下返回值。我们的算法将会返回一个布尔值。我们的算法在找到并删除该节点时返回 true 。否则返回 false 。
    第2行到第9行：我们开始查找等于我们要查找的给定的 value 的 node 。如果该 value 小于 current node 值，我们进入左子树，递归处理（当且仅当，current node 有左孩子）。如果该值大于，则进入右子树。递归处理。
    第10行: 我们开始考虑删除算法。
    第11行到第13行: 我们处理了没有孩子、并且是父节点的左孩子的节点。我们通过设置父节点的左孩子为空来删除该节点。
    第14行和第15行: 我们处理了没有孩子、并且是父节点的右孩子的节点。我们通过设置父节点的右孩子为空来删除该节点。
    清除节点的方法：我将会在后续文章中给出 clear_node 的代码。该函数将节点的左孩子、右孩子和值都设置为空。
    第16行到第18行: 我们处理了只有一个孩子（左孩子）、并且它是其父节点的左孩子的节点。我们将父节点的左孩子设置为当前节点的左孩子（这是它唯一拥有的孩子）。
    第19行到第21行: 我们处理了只有一个孩子（左孩子）、并且它是其父节点的右孩子的节点。我们将父节点的右孩子设置为当前节点的左孩子（这是它唯一拥有的孩子）。
    第22行到第24行: 我们处理了只有一个孩子（右孩子），并且是其父节点的左孩子的节点。我们将父节点的左孩子设置为当前节点的右孩子（这是它唯一的孩子）。
    第25行到第27行: 我们处理了只有一个孩子（右孩子），并且它是其父节点的右孩子的节点。我们将父节点的右孩子设置为当前节点的右孩子（这是它唯一的孩子）。
    第28行到第30行: 我们处理了同时拥有左孩子和右孩子的节点。我们获取拥有最小值的节点（代码随后给出），并将其值设置给当前节点。通过删除最小的节点完成节点移除。
    第32行: 如果我们找到了要查找的节点，就需要返回 true 。从第11行到第31行，我们处理了这些情况。所以直接返回 true ，这就够了。
     *
     */
    public boolean removeNode(BinaryTree node, Integer value, BinaryTree parent) {
        if (node != null) {
            if (value < Integer.valueOf(node.data) && node.left != null) {
                return node.left.removeNode(node.left, value, node);
            } else if (value < Integer.valueOf(node.data)) {
                return false;
            } else if (value > Integer.valueOf(node.data) && node.right != null) {
                return node.right.removeNode(node.right, value, node);
            } else if (value > Integer.valueOf(node.data)) {
                return false;
            } else {
                if (node.left == null && node.right == null && node == parent.left) {
                    parent.left = null;
                    node.clearNode(node);
                } else if (node.left == null && node.right == null && node == parent.right) {
                    parent.right = null;
                    node.clearNode(node);
                } else if (node.left != null && node.right == null && node == parent.left) {
                    parent.left = node.left;
                    node.clearNode(node);
                } else if (node.left != null && node.right == null && node == parent.right) {
                    parent.right = node.left;
                    node.clearNode(node);
                } else if (node.right != null && node.left == null && node == parent.left) {
                    parent.left = node.right;
                    node.clearNode(node);
                } else if (node.right != null && node.left == null && node == parent.right) {
                    parent.right = node.right;
                    node.clearNode(node);
                } else {
                    node.data=String.valueOf(node.right.findMinValue(node.right));
                    node.right.removeNode(node.right,Integer.valueOf(node.right.data),node);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 清空n节点
     * clear_node 方法：设置节点的三个属性为空——(value, left_child, and right_child)
     *
     * @param node
     */
    public void clearNode(BinaryTree node) {
        node.data = null;
        node.left = null;
        node.right = null;
    }

    /**
     * 查找树中最小值
     * find_minimum_value方法：一路向下找最左侧的。如果我们无法找到任何节点，我们找其中最小的
     */
    public Integer findMinValue(BinaryTree node) {
        if (node != null) {
            if (node.left != null) {
                return node.left.findMinValue(node.left);
            } else {
                return Integer.valueOf(node.data);
            }
        }
        return null;
    }

}
