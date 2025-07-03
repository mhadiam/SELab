package org.example.adapters;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.util.HashSet;
import java.util.Set;

public class JGraphTGraphAdapter<V> implements GraphAdapter<V> {
    private final Graph<V, DefaultEdge> graph;

    public JGraphTGraphAdapter(Graph<V, DefaultEdge> graph) {
        this.graph = graph;
    }

    @Override
    public void addVertex(V vertex) {
        graph.addVertex(vertex);
    }

    @Override
    public void addEdge(V source, V target) {
        graph.addEdge(source, target);
    }

    @Override
    public Set<V> getNeighbors(V vertex) {
        Set<V> neighbors = new HashSet<>();
        for (DefaultEdge edge : graph.edgesOf(vertex)) {
            V source = graph.getEdgeSource(edge);
            V target = graph.getEdgeTarget(edge);
            if (!vertex.equals(source)) {
                neighbors.add(source);
            } else {
                neighbors.add(target);
            }
        }
        return neighbors;
    }
}
