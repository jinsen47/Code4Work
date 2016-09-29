package com.github.jinsen47.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinsen on 16/9/21.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int label) {
        this.label = label;
        neighbors = new ArrayList<>();
    }
}
