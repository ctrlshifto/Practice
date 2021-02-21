package com.algorithm.binarytree;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/2/21 21:55
 */
public class Offer26 {
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        if (A.val == B.val) {
            return judge(A, B);
        }
        boolean isLeft = isSubStructure(A.left, B);
        boolean isRight = isSubStructure(A.right, B);

        return isLeft || isRight;
    }

    private static boolean judge(TreeNode A, TreeNode B) {
        if (A.val != B.val && A.left == null && A.right == null) {
            return false;
        }
        if (A.left != null && B.left != null) {
            return judge(A.left, B.left);
        }
        if (A.right != null && B.right != null) {
            return judge(A.right, B.right);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(4);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode J = new TreeNode(6);
        TreeNode O = new TreeNode(7);
        TreeNode I = new TreeNode(8);
        TreeNode Q = new TreeNode(9);

        A.left = B;
        B.left = D;
        B.right = E;
        D.left = I;
        D.right = Q;
        A.right = C;
        C.left = J;
        C.right = O;

        TreeNode G = new TreeNode(4);
        TreeNode K = new TreeNode(8);
        TreeNode P = new TreeNode(9);
        G.left = K;
        G.right = P;

        final boolean subStructure = isSubStructure(A, G);
        System.out.println(subStructure);
    }
}
