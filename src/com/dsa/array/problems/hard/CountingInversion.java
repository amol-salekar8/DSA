package com.dsa.array.problems.hard;

public class CountingInversion {
    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 1, 3, 5};

        System.out.println(bruteForceApproach(nums));
        System.out.println(mergeSort(nums, 0, nums.length-1));
    }

    public static long bruteForceApproach(int [] nums){
        long count = 0;
        for(int i=0;i< nums.length;i++){
            for (int j = i+1; j < nums.length ; j++) {
                if(nums[i] > nums[j])
                    count++;
            }
        }
        return count;
    }

    public static long mergeSort(int nums[], int start, int end){
        long count =0;
        if(start < end ) {
            int mid = start + (end - start)/2;
            count += mergeSort(nums, start, mid);
            count += mergeSort(nums, mid+1, end);
            count += merge(nums, start, mid, end);
        }
        return count;
    }

    public static long merge(int[] nums, int start, int mid, int end){
        int count = 0;
        int temp[] = new int[end - start+1];
        int left = start;
        int right = mid+1;
        int index = 0;

        while(left <= mid && right <= end){
            // left side is smaller
            if(nums[left] <= nums[right]){
                temp[index++] = nums[left++];
            }else {
                // right side is smaller
                temp[index++] = nums[right++];
                // if leftElement > rightElement all the element present  in leftSide  are by default gretor;
                count += (mid - left + 1);
            }
        }

        /* remaining part of left array */
        while(left <= mid){
            temp[index++] = nums[left++];
        }

        /* remaining part of right array */
        while(right <= end){
            temp[index++] = nums[right++];
        }

        System.arraycopy(temp, 0, nums, start, end-start+1);

        return count;
    }

}
