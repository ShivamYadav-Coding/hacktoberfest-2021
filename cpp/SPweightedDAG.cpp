#include <bits/stdc++.h>
using namespace std;
void FindTopo(stack<int> &topo, int node, vector<int> vis, vector<pair<int, int>> adj[])
{
    vis[node] = 1;
    for (auto it : adj[node])
    {
        if (!vis[it.first])
        {
            FindTopo(topo, it.first, vis, adj);
        }
    }
    topo.push(node);
}
vector<int> Shortestpath(int n, int src, vector<pair<int, int>> adj[])
{
    stack<int> topo;
    vector<int> vis(n, 0);
    for (int i = 0; i < n; i++)
    {
        if (!vis[i])
        {
            FindTopo(topo, i, vis, adj);
        }
    }
    vector<int> Dist(n, INT_MAX);
    Dist[src] = 0;
    while (!topo.empty())
    {
        int Node = topo.top();
        cout << Node << endl;
        topo.pop();
        if (Dist[Node] != INT_MAX)
        {
            for (auto it : adj[Node])
            {
                if (Dist[Node] + it.second < Dist[it.first])
                {
                    Dist[it.first] = Dist[Node] + it.second;
                }
            }
        }
    }
    return Dist;
}
int main()
{
    int n, m;
    cin >> n >> m;
    vector<pair<int, int>> adj[n];
    for (int i = 0; i < m; i++)
    {
        int u, v, wt;
        cin >> u >> v >> wt;
        adj[u].push_back({v, wt});
    }
    cout << "Enter a source\n";
    int src;
    cin >> src;
    vector<int> res = Shortestpath(n, src, adj);
    for (int i = 0; i < res.size(); i++)
    {
        cout << i << "-> " << res[i] << endl;
    }
}
