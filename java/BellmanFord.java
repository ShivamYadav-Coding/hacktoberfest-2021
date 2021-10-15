public class BellmanFord {

    public static void main(String[] args) {
        int vertices = 5; // Number of vertices in graph
        int edges = 8; // Number of edges in graph
 
        Graph g = new Graph(vertices, edges);
 
        //edge 0, vertex 0
        g.edge[0].src = 0; //source vertex
        g.edge[0].dest = 1; //destination vertex
        g.edge[0].weight = -1;
 
        //edge 1, vertex 1
        g.edge[1].src = 0;  //source vertex
        g.edge[1].dest = 2; //destination vertex
        g.edge[1].weight = 4;
 
        // edge 2, vertex 2
        g.edge[2].src = 1;  //source vertex
        g.edge[2].dest = 2; //destination vertex
        g.edge[2].weight = 3;
 
        // edge 3, vertex 3
        g.edge[3].src = 1;  //source vertex
        g.edge[3].dest = 3; //destination vertex
        g.edge[3].weight = 2;
 
        // edge 4, vertex 4
        g.edge[4].src = 1;  //source vertex
        g.edge[4].dest = 4; //destination vertex
        g.edge[4].weight = 2;
 
        // edge 5, vertex2
        g.edge[5].src = 3; //source vertex
        g.edge[5].dest = 2; //destination vertex
        g.edge[5].weight = 5;
 
        // edge 6, vertex 1
        g.edge[6].src = 3;  //source vertex
        g.edge[6].dest = 1; //destination vertex
        g.edge[6].weight = 1;
 
        // edge 7, vertex 3
        g.edge[7].src = 4;  //source vertex
        g.edge[7].dest = 3; //destination vertex
        g.edge[7].weight = -3;
 
        g.BellmanFord(g, 0);
    }
    
}

class Edge { // java class to show edge with weight
    int src, dest, weight;
    Edge()
    {
        this.src = 0;
        this.dest = 0 ;
        this.weight =0;
    }
}


class Graph {
    
     
    int e, v; //e for edge. v for vertex
    
    Edge edge[]; //creates edge ref array to Edge class
 
    
    Graph(int v, int e) // Creates a graph with v vertices and e edges
    {
        this.e = e;
        this.v = v;
       
        edge = new Edge[e]; // create e number of edges
        for (int i = 0; i < e; ++i){
            edge[i] = new Edge();
        }
            
    }
 
    //BellmanFord function to find the shortest distance
    void BellmanFord(Graph graph, int src)
    {
        int v = graph.v, E = graph.e;
        int dist[] = new int[v]; 
 
        //First step - Initializing - vertices are situated infinity.
        for (int i = 0; i < v; ++i){
            dist[i] = Integer.MAX_VALUE;
        }
            
        dist[src] = 0;
 
        // Step 2: Relax all edges |V| - 1 times. A simple shortest path from src to any other vertex can have at-most |V| - 1 edges
        
        for (int i = 1; i < v; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src;
                int v1 = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v1])
                    dist[v1] = dist[u] + weight;
            }
        }
 
        // Step 3: check for negative-weight cycles. The above step guarantees shortest distances if graph doesn't
        // contain negative weight cycle. If we get a shorter
        // path, then there is a cycle.
        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].src;
            int v1 = graph.edge[j].dest;
            int weight = graph.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v1]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        printArr(dist, v);
    }
 
    // A utility function used to print the solution
    void printArr(int dist[], int v)
    {
        System.out.println("Vertex \tDistance from Source");
        for (int i = 0; i < v; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }
}