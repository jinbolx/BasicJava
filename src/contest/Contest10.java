package contest;

public class Contest10 {

    public static void main(String[] args) {
        Contest10 contest10 = new Contest10();
        int[] array = new int[]{};
        System.out.println(contest10.minMoves2(array));
    }

    public int minMoves2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }else {
            int total = 0;
            for (Integer in :
                    nums) {
                total += in;
            }
            if (total%nums.length==0){

            }
        }
return 0;
    }
}
