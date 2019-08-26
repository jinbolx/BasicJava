package contest;

public class Contest4 {
    int[]nums1;
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,3,3};
        Contest4 contest4=new Contest4(nums);
    }
    //
    public int integerReplacement(int n) {
       return getCount(n,0);
    }
    public int getCount(int num,int count){
        if (num==2){
            count++;
        }else {
            if (num%2==0){
                getCount(num/2,++count);
            }else {
                getCount(num-1,++count);
            }
        }
        return count;
    }
    public Contest4(int[] nums) {
        this.nums1=nums;
    }


}
