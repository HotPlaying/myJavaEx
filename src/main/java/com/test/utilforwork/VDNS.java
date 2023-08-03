package com.test.utilforwork;

import java.util.LinkedList;

/**
 * @author tangrd
 * @date 2020/7/16 16:59
 * @description
 */
public class VDNS {
    static class Node {
        Node next;
        Integer value;

        Node(Integer value) {
            next = null;
            this.value = value;
        }
    }

    static class LinkList {
        Node head;
        public LinkList() {
            head = new Node(null);
        }
    }

    public LinkList solution(LinkList a, LinkList b) {
        Node pA = a.head;
        Node pB = b.head;
        LinkList ans = new LinkList();
        Node pAns = ans.head;

        boolean raiseFlag = false;
        while (pA.next != null && pB.next != null) {
            int v = pA.value + pB.value;
            if (raiseFlag) {
                ++v;
            }
            raiseFlag = v >= 10;
            v = v % 10;
            pAns.next = new Node(v);

            pA = pA.next;
            pB = pB.next;
        }

        while (pA.next != null) {
            pAns.next = new Node(pA.next.value);
            pA = pA.next;
        }

        while (pB.next != null) {
            pAns.next = new Node(pB.next.value);
            pB = pB.next;
        }

        return ans;
    }
}
