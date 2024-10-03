package Routes;

import VisualStatements.Grapher;
import VisualStatements.GraphicNode;
import VisualStatements.GraphicVector;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private ArrayList<GraphicVector> Route;
    private ArrayList<GraphicNode> nodes;
    private Queue<GraphicNode> cola;
    private final Grapher g;
    private boolean visto[];
    private int NodeI;

    public BFS(ArrayList<GraphicNode> nodes, Grapher g, int NodeI) {
        this.g = g;
        this.nodes = nodes;
        this.NodeI = NodeI;
        visto = new boolean[nodes.size()];
        Route = new ArrayList<GraphicVector>();
        cola = new LinkedList<>();
    }

    public ArrayList<GraphicVector> BFS_Route() {

        for (int i = 0; i < visto.length; i++) {
            visto[i] = false;
        }
        BFS(nodes, NodeI, visto, cola);

        return Route;
    }

    public void BFS(ArrayList<GraphicNode> nodos, int nodoI, boolean visto[], Queue<GraphicNode> cola) {

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
                cola.add(nodos.get(n));
                visto[n] = true;
                //addGraphicVector(n, nodoI, nodos);
                //System.out.println(nodos.get(n).name + "-" + nodos.get(nodoI).name);
            }
        }

        if (!cola.isEmpty()) {
            int n = 0;
            for (int j = 0; j < nodos.size(); j++) {
                if (nodos.get(j) == cola.peek()) {
                    n = j;
                    cola.poll();
                    break;
                }
            }
            BFS(nodos, n, visto, cola);

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
