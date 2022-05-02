class NumArray {
    
    private int[] nums;
    
    private SegmentTreeNode segmentTreeHead;

    public NumArray(int[] nums) {
        this.nums = nums;
        segmentTreeHead = SegmentTreeUtil.createSegmentTree(this.nums, 0, nums.length - 1);
    }
    
    public void update(int index, int val) {
        SegmentTreeUtil.update(segmentTreeHead, index, val - nums[index]);
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        return SegmentTreeUtil.sumRange(segmentTreeHead, left, right);
    }
}

class SegmentTreeNode {
    
    public int begin;
    
    public int end;
    
    public int val;
    
    public SegmentTreeNode leftChild;
    
    public SegmentTreeNode rightChild;
}

class SegmentTreeUtil {
    
    public static SegmentTreeNode createSegmentTree(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        
        SegmentTreeNode node = new SegmentTreeNode();
        node.begin = begin;
        node.end = end;
        
        if (begin == end) {
            node.val = nums[begin];
            return node;
        }
        
        int mid = begin + (end - begin) / 2;
        SegmentTreeNode leftChild = createSegmentTree(nums, begin, mid);
        SegmentTreeNode rightChild = createSegmentTree(nums, mid + 1, end);
        
        node.leftChild = leftChild;
        node.rightChild = rightChild;
        node.val = node.leftChild.val + node.rightChild.val;
        
        return node;
    }
    
    public static void update(SegmentTreeNode segmentTreeHead, int index, int diff) {
        if (segmentTreeHead ==  null) {
            return;
        }
        
        if (index < segmentTreeHead.begin || index > segmentTreeHead.end) {
            return;
        }
        
        segmentTreeHead.val += diff;
        
        if (index == segmentTreeHead.begin && segmentTreeHead.begin == segmentTreeHead.end) {
            return;
        }
        
        update(segmentTreeHead.leftChild, index, diff);
        update(segmentTreeHead.rightChild, index, diff);
    }
    
    public static int sumRange(SegmentTreeNode segmentTreeHead, int begin, int end) {
        if (segmentTreeHead == null || begin > end) {
            return 0;
        }
        
        if (segmentTreeHead.begin >= begin && segmentTreeHead.end <= end) {
            return segmentTreeHead.val;
        }
        
        if (end < segmentTreeHead.begin || begin > segmentTreeHead.end) {
            return 0;
        }
        
        return sumRange(segmentTreeHead.leftChild, begin, end) + sumRange(segmentTreeHead.rightChild, begin, end);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */