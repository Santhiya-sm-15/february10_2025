class Solution {
    ArrayList<Integer>[] adj;
    public int findCenter(int[][] edges) {
        int n=edges.length+1;
        adj=new ArrayList[n+1];
        int i;
        for(i=0;i<=n;i++)
            adj[i]=new ArrayList<>();
        for(int[] x:edges)
        {
            adj[x[0]].add(x[1]);
            adj[x[1]].add(x[0]);
        }
        for(i=1;i<=n;i++)
        {
            if(adj[i].size()==n-1)
                return i;
        }
        return 0;
    }
}