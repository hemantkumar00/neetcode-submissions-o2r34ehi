class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = 0;
        int k = m-1;
        int l = n-1;
        List<Integer> list = new ArrayList<>();
        while(j<=l && i<=k){
            if(j<=l && i<=k){
                for(int a = i ; a<=k ;a++){
                    list.add(matrix[j][a]);
                }
                j++;
            }
            if(j<=l && i<=k){
                for(int a = j ; a<=l ;a++){
                    list.add(matrix[a][k]);
                }
                k--;
            }
            if(j<=l && i<=k){
                for(int a = k ; a>=i ;a--){
                    list.add(matrix[l][a]);
                }
                l--;
            }
            if(j<=l && i<=k){
                for(int a = l ; a>=j ;a--){
                    list.add(matrix[a][i]);
                }
                i++;
            }
        }
        return list;
    }
}
