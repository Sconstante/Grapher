/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Routes;

import VisualStatements.Grapher;
import VisualStatements.GraphicNode;
import VisualStatements.GraphicVector;
import java.util.ArrayList;

public class DFS {

    private ArrayList<GraphicVector> Route;
    private ArrayList<GraphicNode> nodes;
    private final Grapher g;
    private boolean visto[];
    private int NodeI;

    public DFS(ArrayList<GraphicNode> nodes, Grapher g, int NodeI) {
        this.g = g;
        this.nodes = nodes;
        this.NodeI=NodeI;
        visto = new boolean[nodes.size()];
        Route = new ArrayList<GraphicVector>();
    }

    public ArrayList<GraphicVector> DFS_Route() {

        for (int i = 0; i < visto.length; i++) {
            visto[i] = false;
        }
        DFS(nodes, NodeI, visto);

        return Route;
    }

    public void DFS(ArrayList<GraphicNode> nodos, int nodoI, boolean visto[]) {

        visto[nodoI] = true;

        for (int i = 0; i < nodos.get(nodoI).adjacentNodes.size(); i++) {
            int n = 0;
            for (int j = 0; j < nodos.size(); j++) {
                if (nodos.get(j) == nodos.get(nodoI).adjacentNodes.get(i)) {
                    n = j;
                    break;
                }
            }

            if (visto[n] == false) {

                //System.out.println(nodos.get(nodoI).name + "-" + nodos.get(n).name);
                addGraphicVector(nodoI, n, nodos);
                DFS(nodos, n, visto);
                addGraphicVector(n, nodoI, nodos);
                //System.out.println(nodos.get(n).name + "-" + nodos.get(nodoI).name);
            }

        }
    }

    public void addGraphicVector(int nn1, int nn2, ArrayList<GraphicNode> GraphicNodes) {

        if (nn1 < GraphicNodes.size() && nn2 < GraphicNodes.size()) {
            GraphicNode n1 = GraphicNodes.get(nn1);
            GraphicNode n2 = GraphicNodes.get(nn2);
            GraphicVector newVector = new GraphicVector(n1, n2, g);
            Route.add(newVector);
        }
    }

}
