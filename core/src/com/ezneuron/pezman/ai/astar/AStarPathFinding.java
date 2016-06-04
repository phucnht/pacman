package com.ezneuron.pezman.ai.astar;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.ai.pfa.DefaultConnection;
import com.badlogic.gdx.ai.pfa.DefaultGraphPath;
import com.badlogic.gdx.ai.pfa.GraphPath;
import com.badlogic.gdx.ai.pfa.Heuristic;
import com.badlogic.gdx.ai.pfa.PathFinder;
import com.badlogic.gdx.ai.pfa.indexed.IndexedAStarPathFinder;
import com.badlogic.gdx.ai.pfa.indexed.IndexedGraph;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by batty on 6/3/2016.
 */
public class AStarPathFinding {
    public final AStarGraph aStarGraph; // construire la graphe
    private final PathFinder<Node> pathFinder; // Trouver la chemin a partir d'un noeud dans la graphe grace a l'info de ce noeud.
    private final Heuristic<Node> heuristic; // generer l'estimation de cout pour deplacer d'une node donnee a la cible
    private final GraphPath<Connection<Node>> connectionGraphPath; // une chemin dans la graphe

    private static final int[][] NEXTNODE = new int[][] {
            new int[] {-1,  0},
            new int[] { 1,  0},
            new int[] { 0, -1},
            new int[] { 0,  1}
    };

    public Node findNextNode(Vector2 source, Vector2 destination){
        int sourceX = MathUtils.floor(source.x);
        int sourceY = MathUtils.floor(source.y);
        int destinationX = MathUtils.floor(destination.x);
        int destinationY = MathUtils.floor(destination.y);

        if (aStarGraph == null
                || sourceX < 0 || sourceX >= aStarGraph.getWidth()
                || sourceY < 0 || sourceY >= aStarGraph.getHeight()
                || destinationX < 0 || destinationX >= aStarGraph.getWidth()
                || destinationY < 0 || destinationY >= aStarGraph.getHeight()){
            return null;
        }

        Node sourceNode = aStarGraph.getNode(sourceX, sourceY);
        Node destinationNode = aStarGraph.getNode(destinationX, destinationY);
        connectionGraphPath.clear();
        pathFinder.searchConnectionPath(sourceNode, destinationNode, heuristic, connectionGraphPath);

        return connectionGraphPath.getCount() == 0 ? null : connectionGraphPath.get(0).getToNode();
    }

    public AStarPathFinding(AStarGraph aStarGraph) {
        this.aStarGraph = aStarGraph;

        // une sorte de PathFinder pour trouver les chemmins interruptible et non-interruptible
        this.pathFinder = new IndexedAStarPathFinder<Node>(createGraph(aStarGraph));

        this.heuristic = new Heuristic<Node>() {
            @Override
            public float estimate(Node node, Node endNode) {
                // Distance de Manhattan
                return Math.abs(endNode.x - node.x) + Math.abs(endNode.y - node.y);
            }
        };

        // implementation de GraphPath en utilisant un array pour contenir les nodes et les connections
        this.connectionGraphPath = new DefaultGraphPath<Connection<Node>>();
    }

    public static MyGraph createGraph(AStarGraph aStarGraph) {
        final int height = aStarGraph.getHeight();
        final int width = aStarGraph.getWidth();
        MyGraph graph = new MyGraph(aStarGraph);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Node node = aStarGraph.getNode(x, y);
                // Ignorer si c'est la mur
                if (node.isWall) {
                    continue;
                }
                // Ajouter la connection pour les noeuds valides
                for (int offset=0; offset < NEXTNODE.length; offset++){
                    int nextX = node.x + NEXTNODE[offset][0];
                    int nextY = node.y + NEXTNODE[offset][1];
                    if (nextX >= 0 && nextX < width && nextY >= 0 && nextY < height){
                        Node next = aStarGraph.getNode(nextX, nextY);
                        if (!next.isWall){
                            // Ajouter la connection pour les noeuds proches et probable a deplacer
                            node.getConnections().add(new DefaultConnection<Node>(node, next));
                        }
                    }
                }
                node.getConnections().shuffle();
            }
        }

        return graph;
    }

    // graphe pour IndexedAStarPathFinder.
    private static class MyGraph implements IndexedGraph<Node> {

        AStarGraph graph;

        public MyGraph(AStarGraph graph) {
            this.graph = graph;
        }

        @Override
        public int getIndex(Node node) {
            return node.getIndex();
        }

        @Override
        public int getNodeCount() {
            return graph.getHeight() * graph.getHeight();
        }

        @Override
        public Array<Connection<Node>> getConnections(Node fromNode) {
            return fromNode.getConnections();
        }
    }
}
