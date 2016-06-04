package com.ezneuron.pezman.ai.astar;

/**
 * Created by batty on 6/3/2016.
 */
public class AStarGraph {
    private Node[][] node;

    private final int width;
    private final int height;

    public AStarGraph(int width, int height) {
        this.width = width;
        this.height = height;

        node = new Node[height][width];
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < height; x++) {
                node[y][x] = new Node(this, x, y);
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Node getNode(int x, int y) {
        return node[y][x];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                stringBuilder.append(node[y][x].isWall ? "#" : " ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
