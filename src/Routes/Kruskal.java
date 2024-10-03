package Routes;

import VisualStatements.Grapher;
import VisualStatements.GraphicNode;
import VisualStatements.GraphicVector;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;

public class Kruskal {

    private ArrayList<GraphicVector> Route;
    private ArrayList<GraphicNode> nodes;
    private ArrayList<Vector> camino;

    private Grapher g;
    //private boolean visto[];

    public Kruskal(ArrayList<GraphicNode> nodes, Grapher g) {
        this.g = g;
        this.nodes = nodes;

        ArrayList<Nodo> Nodos = new ArrayList<Nodo>();
        Route = new ArrayList<GraphicVector>();

        for (int j = 0; j < nodes.size(); j++) {
            Nodo n = new Nodo(nodes.get(j).getName(), nodes.get(j).getX(), nodes.get(j).getY());
            Nodos.add(n);
        }
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.get(i).adjacentNodes.size(); j++) {
                int n = 0;
                for (int k = 0; k < nodes.size(); k++) {
                    if (nodes.get(k) == nodes.get(i).adjacentNodes.get(j)) {
                        n = k;
                        break;
                    }
                }
                Nodos.get(i).AgregarNodoAdyacente(Nodos.get(n));
            }
        }

        boolean visto[] = new boolean[Nodos.size()];
        for (int i = 0; i < visto.length; i++) {
            visto[i] = false;
        }
        ArrayList<Vector> colar = new ArrayList<>();
        Kruskal(Nodos, visto, colar);
    }

    public ArrayList<GraphicVector> Kruskal_Route() {

        //System.out.println(camino.size()+" mira 1");
        for (int i = 0; i < camino.size(); i++) {
            addGraphicVector(camino.get(i).n1, camino.get(i).n2, nodes);
        }

        return Route;
    }

    public void addGraphicVector(int nn1, int nn2, ArrayList<GraphicNode> GraphicNodes) {

        if (nn1 < GraphicNodes.size() && nn2 < GraphicNodes.size()) {
            GraphicNode n1 = GraphicNodes.get(nn1);
            GraphicNode n2 = GraphicNodes.get(nn2);
            GraphicVector newVector = new GraphicVector(n1, n2, g);
            Route.add(newVector);
        }
    }

    public class Nodo {

        public String name;
        public int x;
        public int y;
        public ArrayList<Nodo> NodosAdyacentes = new ArrayList<Nodo>();

        public Nodo(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        public void AgregarNodoAdyacente(Nodo n) {
            NodosAdyacentes.add(n);
        }
    }

    public class Vector {

        int n1;
        int n2;

        public Vector(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }

    }

    public void Kruskal(ArrayList<Nodo> nodos, boolean visto[], ArrayList<Vector> cola) {

        for (int j = 0; j < nodos.size(); j++) {
            for (int i = 0; i < nodos.get(j).NodosAdyacentes.size(); i++) {
                int n = 0;
                for (int k = 0; k < nodos.size(); k++) {
                    if (nodos.get(k) == nodos.get(j).NodosAdyacentes.get(i)) {
                        n = k;
                        break;
                    }
                }
                cola = agregarVector(cola, n, j);
            }
        }
        for (int i = 0; i < cola.size(); i++) {
            double x1 = nodos.get(cola.get(i).n1).x;
            double y1 = nodos.get(cola.get(i).n1).y;
            double x2 = nodos.get(cola.get(i).n2).x;
            double y2 = nodos.get(cola.get(i).n2).y;
            double d = sqrt(pow((x1) - (x2), 2) + pow((y1) - (y2), 2));
            System.out.println(cola.get(i).n1 + "-" + cola.get(i).n2 + "//" + d);
        }
        System.out.println("////////////");
        cola = organizar(cola, nodos);
        for (int i = 0; i < cola.size(); i++) {
            double x1 = nodos.get(cola.get(i).n1).x;
            double y1 = nodos.get(cola.get(i).n1).y;
            double x2 = nodos.get(cola.get(i).n2).x;
            double y2 = nodos.get(cola.get(i).n2).y;
            double d = sqrt(pow((x1) - (x2), 2) + pow((y1) - (y2), 2));
            System.out.println(cola.get(i).n1 + "-" + cola.get(i).n2 + "//" + d);
        }
        System.out.println("////////////");

        ArrayList<Vector> colaro = new ArrayList<>();
        colaro.add(cola.get(0));
        System.out.println("-----");
        System.out.println(colaro.size());
        for (int i = 1; i < cola.size(); i++) {
            if (!comprobarCiclo(colaro, cola.get(i), nodos)) {
                colaro.add(cola.get(i));
                System.out.println("-----");
            }

        }
        System.out.println("///");
        /*for (int i = 0; i < cola.size(); i++) {
            System.out.println(nodos.get(cola.get(i).n1).name + "-" + nodos.get(cola.get(i).n2).name);
        }*/
        System.out.println("///");
        for (int i = 0; i < colaro.size(); i++) {
            System.out.println(nodos.get(colaro.get(i).n1).name + "-" + nodos.get(colaro.get(i).n2).name);
        }
        //System.out.println(cola.get(r).n1 + "-" + cola.get(r).n2);
        camino = colaro;
    }

    private boolean comprobarCiclo(ArrayList<Vector> cola, Vector v, ArrayList<Nodo> nodos) {

        ArrayList<Nodo> Nodes = new ArrayList<Nodo>();

        ArrayList<Vector> colar = new ArrayList<Vector>();

        for (int i = 0; i < cola.size(); i++) {
            colar.add(cola.get(i));
        }
        colar.add(v);
        int ni1 = colar.get(0).n1;
        int ni2 = colar.get(0).n2;

        Nodo nni1 = new Nodo(nodos.get(ni1).name, 0, 0);
        Nodo nni2 = new Nodo(nodos.get(ni2).name, 0, 0);

        Nodes.add(nni1);
        Nodes.add(nni2);

        Nodes.get(0).AgregarNodoAdyacente(Nodes.get(1));
        Nodes.get(1).AgregarNodoAdyacente(Nodes.get(0));

        for (int u = 1; u < colar.size(); u++) {

            int n1 = colar.get(u).n1;
            int n2 = colar.get(u).n2;
            Nodo nn1 = new Nodo(nodos.get(n1).name, 0, 0);
            Nodo nn2 = new Nodo(nodos.get(n2).name, 0, 0);
            boolean existN1 = false;
            boolean existN2 = false;
            for (int j = 0; j < Nodes.size(); j++) {

                if (Nodes.get(j).name.equals(nn1.name)) {
                    existN1 = true;
                    break;
                }
            }
            for (int j = 0; j < Nodes.size(); j++) {

                if (Nodes.get(j).name.equals(nn2.name)) {
                    existN2 = true;
                    break;
                }
            }
            if (existN1 == false) {
                Nodes.add(nn1);
            }
            if (existN2 == false) {
                Nodes.add(nn2);
            }
            int nr1 = 0;
            int nr2 = 0;
            for (int j = 0; j < Nodes.size(); j++) {
                if (Nodes.get(j).name.equals(nn1.name)) {
                    nr1 = j;
                    break;
                }
            }
            for (int j = 0; j < Nodes.size(); j++) {
                if (Nodes.get(j).name.equals(nn2.name)) {
                    nr2 = j;
                    break;
                }
            }
            Nodes.get(nr2).AgregarNodoAdyacente(Nodes.get(nr1));
            Nodes.get(nr1).AgregarNodoAdyacente(Nodes.get(nr2));

        }
        int r = 0;
        Nodo nnn2 = new Nodo(nodos.get(v.n1).name, 0, 0);
        for (int j = 0; j < Nodes.size(); j++) {
            if (Nodes.get(j).name.equals(nnn2.name)) {
                r = j;
                break;
            }
        }
        boolean vist[] = new boolean[Nodes.size()];
        for (int k = 0; k < vist.length; k++) {
            vist[k] = false;
            // System.out.println(Nodes.get(k).name + " ui");
        }
        /*i = true;
        aux = false;
        DFS_Kruskel(Nodes, 0, vist);*/
        aux = false;
        DFS_Kruskel(Nodes, r, vist, r);
        return aux;
    }
    boolean aux;

    public void DFS_Kruskel(ArrayList<Nodo> nodos, int nodoI, boolean visto[], int parent) {

        visto[nodoI] = true;

        for (int p = 0; p < nodos.get(nodoI).NodosAdyacentes.size(); p++) {
            int n = 0;
            for (int j = 0; j < nodos.size(); j++) {
                if (nodos.get(j) == nodos.get(nodoI).NodosAdyacentes.get(p)) {
                    n = j;
                    break;
                }
            }
            if (n != parent) {
                //System.out.println(visto[n]);
                if (visto[n] == true) {
                    aux = true;
                }
            }
            if (visto[n] == false) {
                // System.out.println(nodos.get(nodoI).name + "-" + nodos.get(n).name);
                DFS_Kruskel(nodos, n, visto, nodoI);
                // System.out.println(nodos.get(n).name + "-" + nodos.get(nodoI).name);
            }

        }

    }

    private ArrayList<Vector> agregarVector(ArrayList<Vector> cola, int n1, int n2) {

        boolean exist = false;
        for (int i = 0; i < cola.size(); i++) {
            if ((cola.get(i).n1 == n1 && cola.get(i).n2 == n2) || (cola.get(i).n1 == n2 && cola.get(i).n2 == n1)) {
                exist = true;
            }
        }
        if (exist == false) {
            Vector v = new Vector(n1, n2);
            cola.add(v);
        }
        return cola;
    }

    private ArrayList<Vector> organizar(ArrayList<Vector> cola, ArrayList<Nodo> nodos) {

        Vector vect[] = new Vector[cola.size()];
        for (int i = 0; i < cola.size(); i++) {
            vect[i] = cola.get(i);
        }

        //
        for (int i = 0; i < cola.size(); i++) {
            for (int j = 0; j < cola.size(); j++) {
                double x1 = nodos.get(vect[i].n1).x;
                double y1 = nodos.get(vect[i].n1).y;
                double x2 = nodos.get(vect[i].n2).x;
                double y2 = nodos.get(vect[i].n2).y;
                double d = sqrt(pow((x1) - (x2), 2) + pow((y1) - (y2), 2));
                x1 = nodos.get(vect[j].n1).x;
                y1 = nodos.get(vect[j].n1).y;
                x2 = nodos.get(vect[j].n2).x;
                y2 = nodos.get(vect[j].n2).y;
                double d1 = sqrt(pow((x1) - (x2), 2) + pow((y1) - (y2), 2));

                if (d1 > d) {
                    Vector aux = vect[j];
                    vect[j] = vect[i];
                    vect[i] = aux;
                }
            }
        }
        ArrayList<Vector> aux = new ArrayList<>();
        for (int i = 0; i < cola.size(); i++) {
            aux.add(vect[i]);
        }

        return aux;
    }
}
