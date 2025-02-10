class Solution {
    public void dfs(int src,int n,int p,List<List<Integer>> res,boolean[] visited,List<Integer> l,int[][] graph)
    {
        if(src==n-1)
        {
            l.add(n-1);
            res.add(new ArrayList<>(l));
            l.remove(l.size()-1);
            return;
        }
        visited[src]=true;
        l.add(src);
        for(int x:graph[src])
        {
            if(!visited[x])
                dfs(x,n,src,res,visited,l,graph);
        }
        l.remove(l.size()-1);
        visited[src]=false;
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        int n=graph.length;
        dfs(0,n,-1,res,new boolean[n],new ArrayList<>(),graph);
        return res;
    }
}