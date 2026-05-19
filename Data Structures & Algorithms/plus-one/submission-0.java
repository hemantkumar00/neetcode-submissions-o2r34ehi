class Solution {
    public int[] plusOne(int[] digits) {
        LinkedList<Integer> list = new LinkedList<>();
        int carry = 1;
        int n = digits.length;
        for(int i=n-1;i>=0;i--){
            carry += digits[i];
            list.addFirst(carry%10);
            carry/=10;
        }
        if(carry > 0){
            list.addFirst(carry);
        }
        n = list.size();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
