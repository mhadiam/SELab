package org.example.adapters;

import edu.uci.ics.jung.graph.SparseMultigraph;

import java.util.HashSet;
import java.util.Set;

public class JungGraphAdapter<V, E> implements GraphAdapter<V> {
    private final SparseMultigraph<V, E> graph;

    public JungGraphAdapter(SparseMultigraph<V, E> graph) {
        this.graph = graph;
    }

    @Override
    public void addVertex(V vertex) {
        graph.addVertex(vertex);
    }

    @Override
    public void addEdge(V source, V target) {
        // Generate edge ID
        E edge = (E) ("E" + (graph.getEdgeCount() + 1));
        graph.addEdge(edge, source, target);
    }

    @Override
    public Set<V> getNeighbors(V vertex) {
        return new HashSet<>(graph.getNeighbors(vertex));
    }
}
