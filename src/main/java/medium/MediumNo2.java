package medium;

/**
 * 中难度第2题：
 * 两数相加（Add Two Numbers）
 */
public class MediumNo2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //设置两个变量用于存储组装后的相加数
        int add1 = 0;
        int add2 = 0;

        //组装两个相加的数
        add1 = assembleAdder(l1);
        add2 = assembleAdder(l2);

        add2 = add1 + add2;

        ListNode resultNode = null;

        int pos = 0;
        while (add2/10 != 0) {
            if (pos==0) {
                resultNode = new ListNode(add2 % 10);
            } else {
                resultNode.next = new ListNode(add2 % 10);
            }

            pos++;
        }

        return resultNode;
    }

    /**
     * 组装相加的数
     * @param adderNode 待组装加数的链表节点
     * @return
     */
    public int assembleAdder(ListNode adderNode) {

        //设置两个变量用于存储组装后的相加数
        int adder = 0;
        //设置两个变量用于遍历链表时，确定数字的位数
        int add1Pos = 0;

        while (adderNode!=null) {

            if (add1Pos!=0) {
                adder += (adderNode.val * add1Pos);
                add1Pos = add1Pos * 10;
            } else {
                adder += adderNode.val;
                add1Pos += 10;
            }

        }

        return adder;
    }

    public static void main(String[] args) {
        MediumNo2 no2 = new MediumNo2();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l1.next = new ListNode(6);
        l1.next = new ListNode(4);

        ListNode resultNode = no2.addTwoNumbers(l1, l2);
        do {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        } while (resultNode.next!=null);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
