public class Q2_AddTwoNumbers 
{
    ListNode reverse(ListNode head)
    {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        
        while(current != null)
        {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public void insertAtTail(ListNode answerHead, ListNode answerTail, int digit)
    {
        ListNode temp = new ListNode(digit);

        if(answerHead == null)
        {
            answerHead = temp;
            answerTail = temp;
            return;    
        }

        else
        {
            answerTail.next = temp;
            answerTail = temp;
        }
    }

    public ListNode add(ListNode l1, ListNode l2)
    {
        int carry = 0;

        ListNode answerHead = null;
        ListNode answerTail = null;

        while(l1 != null || l2 != null)
        {
            int sum = carry + l1.val + l2.val;

            int digit = sum % 10;

            insertAtTail(answerHead, answerTail, digit);

            carry = sum / 10;

        }

        while(l1 != null)
        {
            int sum = carry + l1.val;

            int digit = sum % 10;

            insertAtTail(answerHead, answerTail, digit);

            carry = sum / 10;

        }

        while(l2 != null)
        {
            int sum = carry + l2.val;

            int digit = sum % 10;

            insertAtTail(answerHead, answerTail, digit);

            carry = sum / 10;

        }

        while(carry != 0)
        {
            int sum = carry;

            int digit = sum % 10;

            insertAtTail(answerHead, answerTail, digit);

            carry = sum / 10;

        }

        return answerHead;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode answer = add(l1, l2);

        answer = reverse(answer);

        return answer;    
    }
}