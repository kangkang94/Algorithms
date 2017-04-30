package BinarySearchTree;

/**
 * Created by kang on 17/4/29.
 */

import java.util.LinkedList;

/**
 * 二叉搜索树！
 * 1.前，中，后序遍历
 *
 * 2.（递归实现）查找"二叉树"中键值为key的节点
 *
 * 3.（非递归实现）查找"二叉树"中键值为key的节点
 *
 * 4.查找最小节点：返回tree为根结点的二叉树的最小结点
 *
 * 5.查找最大节点：返回tree为根结点的二叉树的最大结点
 *
 * 6.找到结点x的后继结点，即查找"二叉树中数值大于该结点"的最小结点，也就是右子树中的最小结点
 *
 * 7.找到结点x的前驱结点，即查找"二叉树中数值小于该结点"的最小结点
 *
 * 8.将结点插入二叉树中
 *
 * 9.删除结点（z）,并返回被删除的结点
 *
 * 10.打印二叉搜索树
 *
 *
 * @param <T>
 */
public class BSTree<T extends Comparable<T>> {

    //建立根结点
    private  BSTNode<T> mRoot = null;

    public class   BSTNode<T extends Comparable<T>>{

        T key;
        BSTNode<T> left;
        BSTNode<T> right;
        BSTNode<T> parent;

        public BSTNode(T key, BSTNode<T> left, BSTNode<T> right, BSTNode<T> parent) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public T getKey(){
            return key;
        }

        @Override
        public String toString() {
            return "key"+key;
        }
    }

    /**
     * 初始化空二叉搜索树
     */
    public BSTree() {
        mRoot=null;
    }

    /**
     * 前序遍历二叉树(递归版)
     */
    private void preOrder(BSTNode<T> node){

        if (node ==null){
            return;
        }

        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node);

    }

    public void preOrder(){
        this.preOrder(mRoot);
    }

    /**
     * 前序遍历二叉树(非递归版，栈思想实现)
     */
    public void preOrderNo(BSTNode<T> node){

        if (node==null){
            return;
        }

        BSTNode<T>[] nodes = new BSTNode[100];
        //记录栈顶的位置
        int top=-1;
        //保存栈弹出的元素
        BSTNode<T> p;

        //入栈，top++
        nodes[top] = node;
        top++;

        while (top>-1){
            //出栈，top--；
            p = nodes[top];
            top--;
            System.out.println(p.getKey()+"  ");

            //把右孩子入栈
            if (p.right!=null){
                top++;
                nodes[top] = p.right;
            }

            if (p.left!=null){
                top++;
                nodes[top]=p.left;
            }
        }

    }


    /**
     * 中序遍历二叉树(递归版)
     */
    private void inOrder(BSTNode<T> node){

        if (node ==null){
            return;
        }

        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node);

    }

    public void inOrder(){
        this.inOrder(mRoot);
    }


    /**
     * 中序遍历二叉树(非递归版，栈思想实现)
     */
    public void inOrderNo(BSTNode<T> node){

        BSTNode[] nodes = new BSTNode[100];

        //保存入栈出栈的元素
        BSTNode p = null;
        int top=-1;

        if (node!=null){
            p=node;
        }

        while(p!=null||top>-1){
            //不断地遍历找到最左孩子
            while(p!=null){
                //入栈
                top++;
                nodes[top]=p;
                p=p.left;

            }
            if (top>-1){

                p=nodes[top--];
                System.out.println(p+" ");
                //先尝试是否有右孩子

                p=p.right;
            }

        }

    }



    /**
     * 后序遍历二叉树(递归版)
     */
    private void postOrder(BSTNode<T> node){

        if (node ==null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node);

    }

    public void postOrder(){
        this.postOrder(mRoot);
    }



    /**
     * 后序遍历二叉树(非递归版，栈思想实现)
     */
    public void postOrderNo(BSTNode node){

        if (node==null)
            return;

        BSTNode[] nodes = new BSTNode[100];
        BSTNode p=null;
        int top =-1;

        int flag=0;

        do{

            while (node !=null){

                top++;
                nodes[top] = node;
                node = node.left;

            }
            //找到一次右孩子后跳出循环，p,flag重新赋值
            p=null;
            flag = 1;
            while (top>-1&& flag!=0){

                //出栈
                node = nodes[top];
                //右孩子为空则打印
                if ( node.right == p){
                    top--;
                    System.out.println(node+" ");
                }else {
                //有右孩子，则node指向右孩子！
                    node = node.right;
                    flag=0;
                }
            }
        }while (top>-1);


    }

    /**
     * 层序遍历，通过一个LinkedList来实现
     */
    public void levelIterator(BSTNode node){

        if (node == null){
            return;
        }

        LinkedList<BSTNode> queue = new LinkedList<>();
        queue.offer(node);

        //存放出来的结点
        BSTNode p =null;

        while(!queue.isEmpty()){
            p=queue.poll();
            System.out.println(p+" ");

            if (p.left!=null){
                queue.offer(p.left);
            }
            if (p.right!=null){
                queue.offer(p.right);
            }


        }


    }





}
