import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    // min heap solution
    /**
     * public int findKthLargest(int[] nums, int k) {
     * if(nums==null || nums.length==0) return -1;
     *
     * PriorityQueue<Integer> pq = new PriorityQueue<>();
     * int n = nums.length;
     * for(int i=0; i<n;i++){
     * pq.add(nums[i]);
     * if(pq.size()>k){
     * pq.poll();
     * }
     * }
     * return pq.peek();
     * }
     */

    // max heap Solution

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        // use custom comparator for max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b-a);
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i=0; i<n;i++){
            pq.add(nums[i]);
            if(pq.size()> n-k){
                min = Math.min(min, pq.poll());
            }
        }
        return min;

    }
}
