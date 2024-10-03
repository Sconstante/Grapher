package VisualStatements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Grapher extends java.awt.Canvas implements Runnable {
    //ANCHO:584 ALTO:492

    public static int GameWidth = 584;
    public static int GameHeight = 492;
    public static Thread GameLoop;
    public static boolean workingLoop = false;

    public static JPanel WorkBoard;
    public static Interfaz Window;
    public final int FrameWidth = 820;
    public final int FrameHeight = 532;

    public static boolean st = false;
    public static int aps = 0;
    public static int fps = 0;
    private static BufferedImage imagen;

    private static int[] pixeles;

    public int[] pixelex;
    public boolean Clicked;
    public static Mouse mouse;
    public final int ratio = 12;

    // private static GraphicNode nodo;
    //public static GraphicVector v;
    public static ArrayList<GraphicNode> GraphicNodes = new ArrayList<GraphicNode>();
    public static ArrayList<GraphicVector> GraphicVectors = new ArrayList<GraphicVector>();
    public GraphicNode LastNode;
    public GraphicNode SelectNode;

    public GraphicNode ActualNode;
    public GraphicNode SelectedNodeA;
    public GraphicNode SelectedNodeB;
    public GraphicNode SelectedNodeAA;
    public GraphicNode SelectedNodeBB;

    public GraphicNode AnimationA;
    public GraphicNode AnimationB;

    public GraphicNode NodoInicial;

    public boolean peso;
    public boolean nombres;
    public boolean APS_Loop;
    ArrayList<GraphicVector> Route;

    public Grapher(Interfaz w) {
        Route = null;
        SelectedNodeA = null;
        SelectedNodeB = null;
        SelectedNodeAA = null;
        SelectedNodeBB = null;
        NodoInicial = null;
        AnimationA = null;
        AnimationB = null;
        LastNode = null;
        Window = w;
        imagen = new BufferedImage(GameWidth, GameHeight, BufferedImage.TYPE_INT_RGB);
        pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
        setPreferredSize(new Dimension(GameWidth, GameHeight));
        peso = true;
        nombres = true;

        mouse = new Mouse();
        addMouseListener(mouse);
        WorkBoard = new JPanel();
        WorkBoard.setBounds(216, 20, GameWidth, GameHeight);
        WorkBoard.add(this, BorderLayout.CENTER);
        WorkBoard.setBackground(Color.DARK_GRAY);

        pixelex = new int[GameWidth * GameHeight];

        Clicked = false;
        SelectNode = new GraphicNode("", 1000, 1000, this);
        addGraphicNode("Z", 200, 200);
        deleteGraphicNode(0);

        APS_Loop = false;

        cargarfondo();
        StartLoop();

    }

    int i = 0;

    private void Frames() {
        mouse.UpdateCursor();
        Clicked = mouse.getPress();
        BufferStrategy estrategia = getBufferStrategy();

        if (estrategia == null) {
            createBufferStrategy(3);
            return;
        }
        System.arraycopy(pixelex, 0, pixeles, 0, pixeles.length);
        Graphics g = estrategia.getDrawGraphics();
        super.paint(g);
        Limpiar();
        
        for (int j = 0; j < GraphicVectors.size(); j++) {
            GraphicVectors.get(j).Frames();
        }
        if (Window.focoVectorActivado == 2 && Window.focoNodoVector == false) {
            if (SelectedNodeB != null && SelectedNodeA != null) {
                GraphicVector SelectVector = new GraphicVector(SelectedNodeB, SelectedNodeA, this);
                SelectVector.FramesS();
            }
        }
        if (Window.focoVectorActivado == 1 && Window.focoNodoVector == false) {
            if (SelectedNodeBB != null && SelectedNodeAA != null) {
                FrameEspecial();
            }
        }

        for (i = 0; i < GraphicNodes.size(); i++) {
            GraphicNodes.get(i).Frames();
        }
        FrameLastNode();
        if (Window.focoNodoActivado == 2 && Window.focoNodoVector == true) {
            SelectNode.FramesSelect(Interfaz.xtNodo, Interfaz.ytNodo);
        }

        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
        //g = v.Frames(g);

        if (nombres == true) {
            for (i = 0; i < GraphicNodes.size(); i++) {
                g = GraphicNodes.get(i).Names(g);
            }
        }
        if (peso == true) {
            for (int j = 0; j < GraphicVectors.size(); j++) {
                g = GraphicVectors.get(j).Names(g);
            }
        }
        //g.dispose();
        estrategia.show();
    }

    private void APS_Frames() {
        mouse.UpdateCursor();
        Clicked = mouse.getPress();
        BufferStrategy estrategia = getBufferStrategy();

        if (estrategia == null) {
            createBufferStrategy(3);
            return;
        }
        System.arraycopy(pixelex, 0, pixeles, 0, pixeles.length);
        Graphics g = estrategia.getDrawGraphics();
        Limpiar();
        for (int j = 0; j < GraphicVectors.size(); j++) {
            GraphicVectors.get(j).Frames();
        }
        /*if (AnimationA != null && AnimationB != null) {
            GraphicVector SelectVector = new GraphicVector(AnimationA, AnimationB, this);
            SelectVector.FramesS();
        }*/
        if (Route != null) {
            if (rt >= Route.size()) {
                anim = false;
                anim2 = false;
                time = 0;
                rt = 0;
                Interfaz.play.setIcon(new ImageIcon(getClass().getResource("/Files/playBoton.png")));
                Window.pause = false;
                Interfaz.play2.setIcon(new ImageIcon(getClass().getResource("/Files/playBoton.png")));

                Window.pause2 = false;
                Route = null;
                for (int l = 0; l < GraphicNodes.size(); l++) {
                    GraphicNodes.get(l).setState(0);
                }
            }
        }
        if (Route != null && Window.tipoEjecucion == 3) {
            for (int j = 0; j < Route.size(); j++) {
                Route.get(j).FramesS();
            }
        }

        if (anim2 == true) {
            Route.get(rt).FramesS();
        }

        for (i = 0; i < GraphicNodes.size(); i++) {
            GraphicNodes.get(i).APS_Frames();
        }
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
        //g = v.Frames(g);
        if (nombres == true) {
            for (i = 0; i < GraphicNodes.size(); i++) {
                g = GraphicNodes.get(i).Names(g);
            }
        }
        if (peso == true) {
            for (int j = 0; j < GraphicVectors.size(); j++) {
                g = GraphicVectors.get(j).Names(g);
            }
        }

        //g.dispose();
        estrategia.show();

    }

    private void FrameEspecial() {
        int a = 0;
        int b = 0;
        for (int j = 0; j < Grapher.GraphicNodes.size(); j++) {
            if (Grapher.GraphicNodes.get(j) == SelectedNodeAA) {
                a = j;
                break;
            }
        }
        for (int j = 0; j < Grapher.GraphicNodes.size(); j++) {
            if (Grapher.GraphicNodes.get(j) == SelectedNodeBB) {
                b = j;
                break;
            }
        }
        GraphicNode n1 = GraphicNodes.get(a);
        GraphicNode n2 = GraphicNodes.get(b);
        boolean exist = false;
        for (int j = 0; j < GraphicVectors.size(); j++) {
            if ((GraphicVectors.get(j).getNodeA().getName().equals(n1.getName()) && GraphicVectors.get(j).getNodeB().getName().equals(n2.getName())) || (GraphicVectors.get(j).getNodeA().getName().equals(n2.getName()) && GraphicVectors.get(j).getNodeB().getName().equals(n1.getName()))) {
                exist = true;
                break;
            }
        }
        if (exist) {
            GraphicVector SelectVector = new GraphicVector(SelectedNodeBB, SelectedNodeAA, this);
            SelectVector.FramesN();
        }

    }

    int time = 0;
    int rt = 0;
    boolean anim = false;
    boolean anim2 = false;

    public void Actualizations() {

        if (anim == true) {

            if (anim2 == false) {
                if (Window.tipoEjecucion == 1) {
                    Interfaz.Visualizer.setText(Interfaz.Visualizer.getText() + Route.get(rt).getNodeA().getName() + "→" + Route.get(rt).getNodeB().getName());
                }
                if (Window.tipoEjecucion == 2) {
                    Interfaz.Visualizer2.setText(Interfaz.Visualizer2.getText() + Route.get(rt).getNodeA().getName() + "→" + Route.get(rt).getNodeB().getName());
                }
            }

            if (time == 120) {  //poner el timepo querido mas 1    

                rt++;
                if (rt < Route.size()) {
                    if (Window.tipoEjecucion == 1) {
                        Interfaz.Visualizer.setText(Interfaz.Visualizer.getText() + " , " + Route.get(rt).getNodeA().getName() + "→" + Route.get(rt).getNodeB().getName());
                    }
                    if (Window.tipoEjecucion == 2) {
                        Interfaz.Visualizer2.setText(Interfaz.Visualizer2.getText() + " , " + Route.get(rt).getNodeA().getName() + "→" + Route.get(rt).getNodeB().getName());
                    }
                }
                time = 0;
            }
            time++;
            anim2 = true;
        }

    }

    private void FrameLastNode() {
        if (LastNode != null) {
            LastNode.Frames();
        }
    }

    public void Limpiar() {

        for (int j = 0; j < pixelex.length; j++) {
            pixelex[j] = 0xffdce6f0;//0xfffae717; 0xff563025 //Background Color             
        }
        pixelex = InsertImage(0, 0, pixelex, fondo1);

        // pixelex[pixelex.length-(584*6)] = 0xfffae717;
    }

    public void addGraphicNode(String name, int x, int y) {

        if (!(name == null || "".equals(name))) {

            boolean exist = false;
            for (GraphicNode nodelist : GraphicNodes) {
                if (nodelist.getName().equals(name)) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                GraphicNode newNode = new GraphicNode(name, x, y, this);
                GraphicNodes.add(newNode);
            } else {
                //System.out.println("Ya existe ese nodo");
            }

        } else {
            //System.out.println("No se pueden nodos nulos");
        }
        /*GraphicNode newNode = new GraphicNode(name, x, y, this);
        GraphicNodes.add(newNode);*/
    }

    public void addGraphicVector(int nn1, int nn2) {

        if (nn1 < GraphicNodes.size() && nn2 < GraphicNodes.size()) {
            GraphicNode n1 = GraphicNodes.get(nn1);
            GraphicNode n2 = GraphicNodes.get(nn2);
            boolean exist = false;
            for (int j = 0; j < GraphicVectors.size(); j++) {
                if ((GraphicVectors.get(j).getNodeA().getName().equals(n1.getName()) && GraphicVectors.get(j).getNodeB().getName().equals(n2.getName())) || (GraphicVectors.get(j).getNodeA().getName().equals(n2.getName()) && GraphicVectors.get(j).getNodeB().getName().equals(n1.getName()))) {
                    exist = true;
                    break;
                }
            }
            if (n1.getName().equals(n2.getName())) {
                //System.out.println("Es el mismo nodo");
            } else if (exist == true) {
                //System.out.println("Ya existe ese vector");
            } else {
                try {
                    GraphicVector newVector = new GraphicVector(n1, n2, this);
                    GraphicVectors.add(newVector);
                    n1.addAdjacentNode(n2);
                    n2.addAdjacentNode(n1);
                } catch (Exception e) {
                    //System.out.println("No se pudo agregar el vector");
                }
            }
        }
    }

    public void deleteGraphicNode(int n) {

        if (n < GraphicNodes.size()) {
            GraphicNode node = GraphicNodes.get(n);

            if (!(node.getName() == null || "".equals(node.getName()))) {

                boolean exist = false;
                for (GraphicNode nodelist : GraphicNodes) {
                    if (nodelist.getName().equals(node.getName())) {
                        exist = true;
                        break;
                    }
                }
                if (exist) {

                    GraphicNodes.remove(node);
                    for (int j = 0; j < GraphicNodes.size(); j++) {
                        for (int p = 0; p < GraphicNodes.get(j).adjacentNodes.size(); p++) {
                            if (GraphicNodes.get(j).adjacentNodes.get(p) == node) {
                                GraphicNodes.get(j).adjacentNodes.remove(p);
                            }

                        }
                    }
                    for (int j = 0; j < GraphicVectors.size(); j++) {

                        if (GraphicVectors.get(j).getNodeA().getName().equals(node.getName()) || GraphicVectors.get(j).getNodeB().getName().equals(node.getName())) {
                            GraphicVectors.remove(j);
                            ////System.out.println("borré");
                            j = -1;
                        }
                    }
                } else {
                    //System.out.println("No existe ese nodo");
                }
            } else {
                //System.out.println("No se pueden nodos nulos");
            }
        }
    }

    public void deleteGraphicVector(int nn1, int nn2) {
        if (nn1 < GraphicNodes.size() && nn2 < GraphicNodes.size()) {
            GraphicNode n1 = GraphicNodes.get(nn1);
            GraphicNode n2 = GraphicNodes.get(nn2);

            for (int j = 0; j < GraphicVectors.size(); j++) {

                if ((GraphicVectors.get(j).getNodeA().getName().equals(n1.getName()) && GraphicVectors.get(j).getNodeB().getName().equals(n2.getName())) || (GraphicVectors.get(j).getNodeA().getName().equals(n2.getName()) && GraphicVectors.get(j).getNodeB().getName().equals(n1.getName()))) {
                    GraphicVectors.remove(j);

                    j = -1;
                }
            }
            for (int p = 0; p < GraphicNodes.get(nn1).adjacentNodes.size(); p++) {
                if (GraphicNodes.get(nn1).adjacentNodes.get(p) == n2) {
                    GraphicNodes.get(nn1).adjacentNodes.remove(p);
                }
            }
            for (int p = 0; p < GraphicNodes.get(nn2).adjacentNodes.size(); p++) {
                if (GraphicNodes.get(nn2).adjacentNodes.get(p) == n1) {
                    GraphicNodes.get(nn2).adjacentNodes.remove(p);
                }
            }

        }

    }

    public class Mouse extends MouseAdapter {

        public int x;
        public int y;
        private boolean click;
        private boolean press;
        public boolean release;

        public Mouse() {

        }

        public void UpdateCursor() {
            Point pos = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(pos, WorkBoard);
            this.x = pos.x;
            this.y = pos.y;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (click == false) {
                click = true;
            }
        }

        public boolean getClick() {
            return click;
        }
        public int tipoClick = 0;

        public void resetClick() {
            ////System.out.println(release);
            release = false;
            if (sw == 1) {
                release = true;
                sw = 2;
            }

            if (click == true) {
                click = false;
            }
            if (press == false && sw == 0) {
                sw = 1;
            }
        }
        private int sw = 2;

        @Override
        public void mouseReleased(MouseEvent e) {
            if (press == true) {
                press = false;
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (press == false) {
                press = true;
            }
            sw = 0;

        }

        public boolean getPress() {
            return press;
        }

        public void resetPress() {
            if (press == true) {
                press = false;
            }
        }

    }

    public void StartLoop() {
        GameLoop = new Thread(this, "Graficos");
        workingLoop = true;
        GameLoop.start();
    }

    public void PauseLoop() {
        workingLoop = false;
        try {
            GameLoop.join();
        } catch (InterruptedException ex) {
            System.err.println("The Thread could not be paused");
        }
    }

    @Override
    public void run() {

        final int NS_SEG = 1000000000;
        final byte APS_OBJ = 127;
        final double NS_ACT = NS_SEG / APS_OBJ;
        long refact = System.nanoTime();
        long refcont = System.nanoTime();
        double time_trans;
        double delta = 0;
        while (workingLoop == true) {

            final long inibucle = System.nanoTime();
            time_trans = inibucle - refact;
            refact = inibucle;
            delta += time_trans / NS_ACT;
            while (delta >= 1) {
                /////////////APS Data per Time
                Actualizations();//<------Actualizar aqui
                //Frames();  

                aps++;
                delta--;
            }
            //<------Mostrar aqui
            //APS_Frames();
            if (APS_Loop == false) {
                Frames();
            } else {
                APS_Frames();
            }
            fps++;
            if (System.nanoTime() - refcont > NS_SEG) {
                // Window.setTitle("Game Name" + " | APS: " + aps + " | FPS: " + fps);
                aps = 0;
                fps = 0;
                refcont = System.nanoTime();
            }

        }
    }

    private int[] InsertImage(int x, int y, int[] pixelex, BufferedImage ima) {

        for (int k = 0; k < ima.getWidth(); k++) {
            for (int j = 0; j < ima.getHeight(); j++) {

                if ((x + k) < GameWidth && (y + j) < GameHeight && (x + k) >= 0 && (y + j) >= 0) {
                    pixelex[(x + k) + (y + j) * GameWidth] = ima.getRGB(k, j);
                }

            }
        }
        return pixelex;
    }
    private static BufferedImage fondo1;

    private void cargarfondo() {
        try {

            /*InputStream input = new FileInputStream("ojoN.png");

            ImageInputStream imageInput = ImageIO.createImageInputStream(input);*/
            BufferedImage imagenL = ImageIO.read(getClass().getResource("/Files/mapa1.png"));//imageInput
            /*
            int alto = imagenL.getHeight();
            int ancho = imagenL.getWidth();
            //System.out.println("Ancho :" + ancho + "/ Alto: " + alto);*/
            fondo1 = imagenL;
        } catch (IOException ex) {
            // Logger.getLogger(Grapher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
