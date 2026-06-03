class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) -> 
            a.get(0).equals(b.get(0))
                ? a.get(1).compareTo(b.get(1))
                : a.get(0).compareTo(b.get(0))
        );
        int len = tickets.size()+1;
        List<String> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0;i< tickets.size(); i++){
            String v = tickets.get(i).get(0);
            String u = tickets.get(i).get(1);
            if(!map.containsKey(v)){
                map.put(v, new ArrayList<>());
            }
            map.get(v).add(u);
        }
        ans.add("JFK");
        dfs(map, ans, len, "JFK");
        return ans;
    }
    private boolean dfs(Map<String, List<String>> map, List<String> ans, int len, String curr){
        if(ans.size() == len)return true;
        if(!map.containsKey(curr))return false;
        List<String> st = new LinkedList<>(map.get(curr));
        for(String val : st){
            ans.add(val);
            map.get(curr).remove(val);
            if(dfs(map, ans,len, val))return true;
            ans.remove(ans.size() - 1);
            map.get(curr).add(val);
        }
        return false;
    }
}
