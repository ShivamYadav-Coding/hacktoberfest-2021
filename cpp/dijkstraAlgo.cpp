#include <bits/stdc++.h>
using namespace std;
vector<pair<int, int>> graph[100005];
int dist[100005];

void djikstra(int src, int n)
{
    for (int i = 1; i <= n; i++)
        dist[i] = INT_MAX;
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({0, src});
    dist[src] = 0;
    while (!pq.empty())
    {
        int wt = pq.top().first;
        int node = pq.top().second;
        pq.pop();
        for (auto child : graph[node])
        {
            int newDist = child.second + wt;
            if (newDist < dist[child.first])
            {
                dist[child.first] = newDist;
                pq.push({newDist, child.first});
            }
        }
    }
}

int main()
{
    int n, e;
    cin >> n >> e;
    int a, b;
    int wt;
    while (e--)
    {
        cin >> a >> b >> wt;
        graph[a].push_back({b, wt});
        graph[b].push_back({a, wt});
    }
    djikstra(1, n);
    for (int i = 1; i <= n; i++)
        cout << dist[i] << " ";
    cout << endl;
    return 0;
}