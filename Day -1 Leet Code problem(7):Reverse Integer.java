class Solution {
    public int reverse(int x) {
        int b=0;

        while(x!=0){
            int d = x%10;
            if(b>Integer.MAX_VALUE/10 || b<Integer .MIN_VALUE/10){
                return 0;
            }
            b = b*10+d;
            x = x/10;
        } 
        return b;
    }
}
