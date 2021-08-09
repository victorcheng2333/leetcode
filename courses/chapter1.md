#### 合并两个有序链表
```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        var dummy = new ListNode(0);
        var p = dummy;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null) p.next = l1;
        if(l2 != null) p.next = l2;
        return dummy.next;
    }
}
```

#### 删除有序数组中的重复项
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        // 双指针思路
        // cur 为去重后指针
        var cur = 0;
        // i 为遍历指针
        for(var i = 1; i < nums.length; i++) {
            if(nums[i] > nums[cur]) {
                cur += 1;
                nums[cur] = nums[i];
            } else {
                continue;
            }
        }
        return cur+1;
    }
}
```