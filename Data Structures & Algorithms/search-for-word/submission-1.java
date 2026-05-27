class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0) == board[i][j]){
                    if(fun(board, i, j, n, m, word, 0, new boolean[n][m]))return true;
                }
            }
        }
        return false;
    }
    private boolean fun(char[][] board, int i, int j, int n, int m, String word, int wordInd, boolean[][] vis){
        if(i<0 || i>=n || j< 0 || j>= m || wordInd >= word.length() || board[i][j] != word.charAt(wordInd) || vis[i][j])return false;
        if(word.length()-1 == wordInd) return true;
        int[] x = {0,0,1,-1};
        int[] y = {1,-1,0,0};
        boolean bool = false;
        vis[i][j] = true;
        for(int k =0;k<4;k++){
            bool |= fun(board, i+x[k], j+y[k], n, m, word, wordInd+1, vis);
        }
        vis[i][j] = false;
        return bool;
    }
}
