public class Q2_AddTwoNumbers 
{ 
    // Approach 1
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


    //Approach 2
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode dummy = new ListNode(0); 
        ListNode curr = dummy;
        int carry = 0;
       
        while(l1 != null || l2 != null || carry == 1)
        {
            int sum = 0; 

            if(l1 != null)
            { 
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null)
            { 
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;

            carry = sum/10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next; 
        }
        return dummy.next;
}