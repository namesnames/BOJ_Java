import sys
import heapq
input = sys.stdin.readline
V,E = map(int,input().rstrip().split())
K = int(input())

matrix = [[] for _ in range(V+1)]
for _ in range(E):
    u,v,w = map(int,input().rstrip().split())
    matrix[u].append((v,w))

dist = [int(1e9)] * (V+1)

def dijkstra(start):
    dist[start] = 0
    queue = []

    heapq.heappush(queue,(0,start))

    while queue:
        w,v = heapq.heappop(queue)

        if(w > dist[v]):
            continue
        for nv, nw in matrix[v]:
            if(dist[nv] > w + nw):    
                dist[nv] = w + nw
                heapq.heappush(queue,(dist[nv],nv))

dijkstra(K)

for i in range(1,V+1):
    if(dist[i] == int(1e9)):
        print("INF")
    else:   
        print(dist[i])

