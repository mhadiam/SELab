package org.example.adapters;

import java.util.Set;

public interface GraphAdapter<V> {
    void addVertex(V vertex);
    void addEdge(V source, V target);
    Set<V> getNeighbors(V vertex);
}
