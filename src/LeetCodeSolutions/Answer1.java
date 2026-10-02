

//给定一个整数数组 nums 和一个整数目标值 target，
//请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
void main() {
}

//1.暴力求解
//nums[i]从nums[0]开始，nums[0]与nums[j]进行nums.length次相加，j开始为0，每次相加后+1
//j从0到nums.length-1后，nums[i]+1,直到求出结果
public int[] twoSum(int[] nums, int target) {
    for(int i = 0; i < nums.length; i++){
        for(int j = i + 1; j < nums.length; j++){
            if(nums[i] + nums[j] == target){
                return new int[]{i, j};
            }
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}
//2.哈希表求解
//把每次遍历到的数字当作key存入hashmap，下标当作value存入，因为只需要两数求和
//即便第二次有相同的key，value会被覆盖为新下标，但我们需要的数字没变化

//例子：加入nums[i]此时遍历到第一个数字，但map是空的，不符合if，于是把第一个元素put到了map中，nums[i]便利到了第二个数字，
//此时map中找到了对应的key，符合if，于是return回结果
public int[] twoSum2(int[] nums,int target){
    HashMap map = new HashMap();
    int rem = 0;
    for(int i = 0; i < nums.length; i++){
        rem = target - nums[i];
        if(map.containsKey(rem)){
            return new int[]{(int) map.get(rem),i};
        }
        map.put(nums[i],i);

    }
    throw new IllegalArgumentException("No two sum solution");
}



