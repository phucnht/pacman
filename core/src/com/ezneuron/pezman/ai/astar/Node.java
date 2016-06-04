package com.ezneuron.pezman.ai.astar;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.utils.Array;

/**
 * Created by batty on 6/3/2016.
 */
public class Node {
    public final int x;
    public final int y;
    public boolean isWall;
    private final int index;
    private final Array<Connection<Node>> connections;

    public Node(AStarGraph map, int x, int y) {
        this.x = x;
        this.y = y;
        this.isWall = false;
        this.index = x * map.getHeight() + y;
        this.connections = new Array<Connection<Node>>();
    }

    public int getIndex() {
        return index;
    }

    public Array<Connection<Node>> getConnections() {
        return connections;
    }

    @Override
    public String toString() {
        return "Node{" + "y=" + y + ", x=" + x + '}';
    }
}
