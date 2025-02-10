class Solution {
    ArrayList<Integer>[] adj;
    public int findJudge(int n, int[][] trust) {
        adj=new ArrayList[n+1];
        int i;
        for(i=0;i<=n;i++)
            adj[i]=new ArrayList<>();
        int[] indegree=new int[n+1];
        for(int[] x:trust)
        {
            adj[x[0]].add(x[1]);
            indegree[x[1]]++;
        }
        for(i=1;i<=n;i++)
        {
            if(adj[i].size()==0 && indegree[i]==n-1)
                return i;
        }
        return -1;
    }
}