【视频学习Day03_LeetCode15】
//思路：1.暴力破解：依次遍历，寻找是否有-nums[i]==nums[j]+nums[k]，isInList和isSame用来去重。

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[j]+nums[k]==-nums[i]){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        if(isInList(list,temp)){
                            continue;
                        }
                        list.add(temp);
                    }
                }
            }
        }

        return list;
    }
    private boolean isInList(List<List<Integer>> list,List<Integer> temp){
        for(int i=0;i<list.size();i++){
            if(isSame(list.get(i),temp)){
                return true;
            }
        }
        return false;
    }
    private boolean isSame(List<Integer> l1,List<Integer> l2){
        Collections.sort(l1);
        Collections.sort(l2);
        for(int i=0;i<l1.size();i++){
            if(l1.get(i)==l2.get(i)){
                return true;
            }
        }
        return false;
    }
}
