# february10_2025
The problems that I solved today

1.You are given a string s. Your task is to remove all digits by doing this operation repeatedly: Delete the first digit and the closest non-digit character to its left. Return the resulting string after removing all digits.

Code:
class Solution {
    public String clearDigits(String s) {
        int i,j;
        StringBuilder sb=new StringBuilder(s);
        for(i=0;i<sb.length();)
        {
            if(sb.charAt(i)>='0' && sb.charAt(i)<='9')
            {
                j=i-1;
                while(j>=0 && sb.charAt(j)>='0' && sb.charAt(j)<='9')
                    j--;
                sb.deleteCharAt(j);
                i--;
                sb.deleteCharAt(i);
            }
            else
                i++;
        }
        return sb.toString();
    }
}

2.There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node. You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph.

Code:
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

3.In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge. If the town judge exists, then: The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge. There is exactly one person that satisfies properties 1 and 2. You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist. Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

Code:
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

4.Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order. The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

Code:
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

5.There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key. When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms. Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.

Code:
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visited=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        visited[0]=true;
        int cnt=1;
        while(!q.isEmpty())
        {
            int x=q.poll();
            for(int a:rooms.get(x))
            {
                if(!visited[a])
                {
                    visited[a]=true;
                    cnt++;
                    q.add(a);
                }
            }
        }
        return cnt==n;
    }
}
