class PrefixTree {
    Node dummy;
    public PrefixTree() {
        dummy = new Node();
    }

    public void insert(String word) {
        Node iter = dummy;
        int n = word.length();
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(iter.word[ch-'a'] == null){
                iter.word[ch-'a'] = new Node();
            }
            iter = iter.word[ch-'a'];
        }
        iter.isEnd = true;
    }

    public boolean search(String word) {
        Node iter = dummy;
        int n = word.length();
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(iter.word[ch-'a'] == null)return false;
            iter = iter.word[ch-'a'];
        }
        return iter.isEnd;
    }

    public boolean startsWith(String word) {
        Node iter = dummy;
        int n = word.length();
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(iter.word[ch-'a'] == null)return false;
            iter = iter.word[ch-'a'];
        }
        return true;
    }
}
class Node{
    Node[] word;
    boolean isEnd;
    public Node(){
        this.word = new Node[26];
        this.isEnd = false;
    }
}
