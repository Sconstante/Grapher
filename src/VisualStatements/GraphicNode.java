package VisualStatements;

import static VisualStatements.Grapher.GameHeight;
import static VisualStatements.Grapher.GameWidth;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JTextField;

public class GraphicNode {

    private String name;
    private int xx;
    private int yy;
    private int state;//0.Normal,1.Seleccionado,2.Error,5.Marcado
    private static BufferedImage imageN;//Normal-blue
    private static BufferedImage imageS;//Selected-green
    private static BufferedImage imageE;//Error-red
    private static BufferedImage imageAct;//Error-red
    private static BufferedImage imageActS;
    private static BufferedImage imageActR;
    private static BufferedImage imageSelec;//Error-red
    private static BufferedImage imageSelecE;//Error-red

    public ArrayList<GraphicNode> adjacentNodes = new ArrayList<GraphicNode>();

    private static Grapher gra;

    public GraphicNode(String name, int x, int y, Grapher gra) {

        GraphicNode.gra = gra;
        this.xx = x;
        this.yy = y;
        this.name = name;
        state = 0;
        UploadImages();

    }

    public void addAdjacentNode(GraphicNode node) {
        adjacentNodes.add(node);
    }

    public void Actualizations() {

    }

    public void Frames() {
        state = 0;
        boolean s = false;
        boolean s1 = false;
        boolean s2 = false;
        if (gra.ActualNode == this) {
            if (Grapher.Window.focoNodoActivado == 1 && Grapher.Window.focoNodoVector == true) {
                state = 3;
                s = true;
            }
        }
        if (gra.SelectedNodeB == this || gra.SelectedNodeA == this) {
            if (Grapher.Window.focoVectorActivado == 2 && Grapher.Window.focoNodoVector == false) {
                state = 3;
                s1 = true;
            }
        }
        if (gra.SelectedNodeBB == this || gra.SelectedNodeAA == this) {
            if (Grapher.Window.focoVectorActivado == 1 && Grapher.Window.focoNodoVector == false) {
                state = 5;
                s2 = true;
            }
        }

        if (gra.Clicked == false) {
            Click = false;
        }
        if (gra.Clicked == true) {
            //double d = sqrt(pow((xx + gra.ratio) - Grapher.mouse.x, 2) + pow((yy + gra.ratio + 5) - Grapher.mouse.y, 2));
            if ((Grapher.mouse.x >= xx + 11 && Grapher.mouse.x <= xx + 48 && Grapher.mouse.y >= yy + 12 && Grapher.mouse.y <= yy + 27) || (Grapher.mouse.x >= xx + 24 && Grapher.mouse.x <= xx + 35 && Grapher.mouse.y >= yy + 5 && Grapher.mouse.y <= yy + 64)) {
                if (gra.Clicked == true && auxClick == false) {
                    deltaX = Grapher.mouse.x - xx;
                    deltaY = (Grapher.mouse.y - yy);
                    lastX = xx;
                    lastY = yy;
                    Click = true;
                    state = 1;
                    if (Grapher.Window.focoNodoActivado == 1 && Grapher.Window.focoNodoVector == true) {
                        if (gra.ActualNode != this) {
                            Interfaz.infonombreNodo.setText(name);
                        }
                        gra.ActualNode = this;
                    }
                    if (Grapher.Window.focoVectorActivado == 2 && Grapher.Window.focoNodoVector == false) {
                        if (gra.SelectedNodeA == null && gra.SelectedNodeB != this) {
                            gra.SelectedNodeA = this;
                            Interfaz.nombreVectorA.setText(name);
                        } else if (gra.SelectedNodeB == null && gra.SelectedNodeA != this) {
                            gra.SelectedNodeB = this;
                            Interfaz.nombreVectorB.setText(name);
                        } else if (gra.SelectedNodeA == this) {
                            gra.SelectedNodeA = null;
                            Interfaz.nombreVectorA.setText("-");
                        } else if (gra.SelectedNodeB == this) {
                            gra.SelectedNodeB = null;
                            Interfaz.nombreVectorB.setText("-");
                        }
                    }
                    if (Grapher.Window.focoVectorActivado == 1 && Grapher.Window.focoNodoVector == false) {
                        if (gra.SelectedNodeAA == null && gra.SelectedNodeBB != this) {
                            gra.SelectedNodeAA = this;
                            Interfaz.InfoNombreVectorA.setText(name);
                        } else if (gra.SelectedNodeBB == null && gra.SelectedNodeAA != this) {
                            gra.SelectedNodeBB = this;
                            Interfaz.InfoNombreVectorB.setText(name);
                        } else if (gra.SelectedNodeAA == this) {
                            gra.SelectedNodeAA = null;
                            Interfaz.InfoNombreVectorA.setText("-");
                        } else if (gra.SelectedNodeBB == this) {
                            gra.SelectedNodeBB = null;
                            Interfaz.InfoNombreVectorB.setText("-");
                        }
                    }
                    gra.LastNode = this;

                }
            }
        }

        if (Click == true) {//Accion hasta que se suelte
            xx = Grapher.mouse.x - deltaX;
            yy = Grapher.mouse.y - deltaY;
            state = 1;
            if (s == true || s1 == true) {
                state = 4;
            }
            if (s2 == true) {
                state = 5;
            }
            if (xx < -11) {
                xx = -11;
            }
            if (yy < 0) {
                yy = 0;
            }
            if (xx > 535) {
                xx = 535;
            }
            if (yy >428) {
                yy = 428;
            }

            for (int i = 0; i < Grapher.GraphicNodes.size(); i++) {
                if (this != Grapher.GraphicNodes.get(i)) {
                    ////////////////////////////////////////////////////////////////
                    /*double d = sqrt(pow((xx + gra.ratio) - (Grapher.GraphicNodes.get(i).getX() + gra.ratio), 2) + pow((yy + gra.ratio) - (Grapher.GraphicNodes.get(i).getY() + gra.ratio), 2));
                    if (d < gra.ratio * 2) {
                        state = 2;

                        break;
                    }*/
                    if (xx + 11 < Grapher.GraphicNodes.get(i).getX() + 48 && xx + 48 > Grapher.GraphicNodes.get(i).getX() + 11 && yy + 7 < Grapher.GraphicNodes.get(i).getY() + 16 && yy + 16 > Grapher.GraphicNodes.get(i).getY() + 7) {
                        state = 2;
                        break;
                    }
                    if (xx + 11 < Grapher.GraphicNodes.get(i).getX() + 33 && xx + 48 > Grapher.GraphicNodes.get(i).getX() + 26 && yy + 7 < Grapher.GraphicNodes.get(i).getY() + 59 && yy + 16 > Grapher.GraphicNodes.get(i).getY()) {
                        state = 2;
                        break;
                    }
                    if (xx + 26 < Grapher.GraphicNodes.get(i).getX() + 48 && xx + 33 > Grapher.GraphicNodes.get(i).getX() + 11 && yy < Grapher.GraphicNodes.get(i).getY() + 16 && yy + 59 > Grapher.GraphicNodes.get(i).getY() + 7) {
                        state = 2;
                        break;
                    }
                    if (xx + 26 < Grapher.GraphicNodes.get(i).getX() + 33 && xx + 33 > Grapher.GraphicNodes.get(i).getX() + 26 && yy < Grapher.GraphicNodes.get(i).getY() + 59 && yy + 59 > Grapher.GraphicNodes.get(i).getY()) {
                        state = 2;
                        break;
                    }

                    //////////////////////////////////////////////////////////////////
                }
            }
            if (s == true) {
                Interfaz.infoxtNodo.setText((xx+11) + "");
                Interfaz.infoytNodo.setText(yy + "");
            }

        }
        if (Click == false && auxPress == true) {//Release
            gra.LastNode = null;
            for (int i = 0; i < Grapher.GraphicNodes.size(); i++) {
                if (this != Grapher.GraphicNodes.get(i)) {
                    ///////////////////////////////////////////////
                    if (xx + 11 < Grapher.GraphicNodes.get(i).getX() + 48 && xx + 48 > Grapher.GraphicNodes.get(i).getX() + 11 && yy + 7 < Grapher.GraphicNodes.get(i).getY() + 16 && yy + 16 > Grapher.GraphicNodes.get(i).getY() + 7) {
                        xx = lastX;
                        yy = lastY;
                        break;
                    }
                    if (xx + 11 < Grapher.GraphicNodes.get(i).getX() + 33 && xx + 48 > Grapher.GraphicNodes.get(i).getX() + 26 && yy + 7 < Grapher.GraphicNodes.get(i).getY() + 59 && yy + 16 > Grapher.GraphicNodes.get(i).getY()) {
                        xx = lastX;
                        yy = lastY;
                        break;
                    }
                    if (xx + 26 < Grapher.GraphicNodes.get(i).getX() + 48 && xx + 33 > Grapher.GraphicNodes.get(i).getX() + 11 && yy < Grapher.GraphicNodes.get(i).getY() + 16 && yy + 59 > Grapher.GraphicNodes.get(i).getY() + 7) {
                        xx = lastX;
                        yy = lastY;
                        break;
                    }
                    if (xx + 26 < Grapher.GraphicNodes.get(i).getX() + 33 && xx + 33 > Grapher.GraphicNodes.get(i).getX() + 26 && yy < Grapher.GraphicNodes.get(i).getY() + 59 && yy + 59 > Grapher.GraphicNodes.get(i).getY()) {
                        xx = lastX;
                        yy = lastY;
                        break;
                    }
                    /////////////////////////////////////////////
                }
            }
        }
        switch (state) {
            case 0:
                gra.pixelex = InsertImage(this.xx, this.yy, gra.pixelex, imageN);
                break;
            case 1:
                gra.pixelex = InsertImage(this.xx, this.yy, gra.pixelex, imageS);
                break;
            case 2:
                gra.pixelex = InsertImage(this.xx, this.yy, gra.pixelex, imageE);
                break;
            case 3:
                gra.pixelex = InsertImage(this.xx, this.yy, gra.pixelex, imageAct);
                break;
            case 4:
                gra.pixelex = InsertImage(this.xx, this.yy, gra.pixelex, imageActS);
                break;
            case 5:
                gra.pixelex = InsertImage(this.xx, this.yy, gra.pixelex, imageActR);
                break;

        }

        auxClick = gra.Clicked;
        auxPress = Click;
    }

    public Graphics Names(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("century gothic", Font.PLAIN, 13));
        g.drawString(name, xx + 40, yy);
        return g;
    }

    public void APS_Frames() {

        if (gra.anim == false) {
            state = 0;
        }
        if (gra.NodoInicial == this && (Grapher.Window.tipoEjecucion == 1 || Grapher.Window.tipoEjecucion == 2) && gra.anim == false) {
            state = 3;
        }
        if (Grapher.Window.tipoEjecucion == 3) {
            state = 0;
        }
        //state = 0;
        if (gra.Route != null && Grapher.Window.tipoEjecucion != 3) {
            if (gra.Route.get(gra.rt).getNodeA() == this || gra.Route.get(gra.rt).getNodeB() == this) {
                state = 3;
            }
        }
        if (gra.Clicked == false) {
            Click = false;
        }
        if (gra.Clicked == true && gra.anim == false) {
            //double d = sqrt(pow((xx + gra.ratio) - Grapher.mouse.x, 2) + pow((yy + gra.ratio + 5) - Grapher.mouse.y, 2));
            if ((Grapher.mouse.x >= xx + 11 && Grapher.mouse.x <= xx + 48 && Grapher.mouse.y >= yy + 12 && Grapher.mouse.y <= yy + 27) || (Grapher.mouse.x >= xx + 24 && Grapher.mouse.x <= xx + 35 && Grapher.mouse.y >= yy + 5 && Grapher.mouse.y <= yy + 64)) {
                if (gra.Clicked == true && auxClick == false) {
                    //System.out.println("xd");
                    Click = true;
                    gra.NodoInicial = this;
                    Interfaz.NombreNodoI.setText(name);
                    Interfaz.NombreNodoI2.setText(name);
                }
            }
        }
        //state=0;
        switch (state) {
            case 0:
                gra.pixelex = InsertImage(this.xx, this.yy, gra.pixelex, imageN);
                break;
            case 1:
                gra.pixelex = InsertImage(this.xx, this.yy, gra.pixelex, imageS);
                break;
            case 2:
                gra.pixelex = InsertImage(this.xx, this.yy, gra.pixelex, imageE);
                break;
            case 3:
                gra.pixelex = InsertImage(this.xx, this.yy, gra.pixelex, imageAct);
                break;
            case 4:
                gra.pixelex = InsertImage(this.xx, this.yy, gra.pixelex, imageActS);
                break;
            case 5:
                gra.pixelex = InsertImage(this.xx, this.yy, gra.pixelex, imageActR);
                break;

        }
        auxClick = gra.Clicked;
        auxPress = Click;
    }

    public void FramesActual() {
        gra.pixelex = InsertImage(this.xx, this.yy, gra.pixelex, imageAct);
    }

    public void FramesSelect(JTextField l1, JTextField l2) {
        state = 5;
        if (gra.Clicked == false) {
            Click = false;
        }
        if (gra.Clicked == true) {
            //double d = sqrt(pow((xx + gra.ratio) - Grapher.mouse.x, 2) + pow((yy + gra.ratio + 5) - Grapher.mouse.y, 2));
            if ((Grapher.mouse.x >= xx + 11 && Grapher.mouse.x <= xx + 48 && Grapher.mouse.y >= yy + 12 && Grapher.mouse.y <= yy + 27) || (Grapher.mouse.x >= xx + 24 && Grapher.mouse.x <= xx + 35 && Grapher.mouse.y >= yy + 5 && Grapher.mouse.y <= yy + 64)) {
                if (gra.Clicked == true && auxClick == false) {
                    deltaX = Grapher.mouse.x - xx;
                    deltaY = (Grapher.mouse.y - yy);
                    Click = true;
                    state = 5;

                }
            }
        }

        if (Click == true) {//Accion hasta que se suelte
            xx = Grapher.mouse.x - deltaX;
            yy = Grapher.mouse.y - deltaY;
            state = 5;
            if (xx < -11) {
                xx = -11;
            }
            if (yy < 0) {
                yy = 0;
            }
            if (xx > 535) {
                xx = 535;
            }
            if (yy >428) {
                yy = 428;
            }
            for (int i = 0; i < Grapher.GraphicNodes.size(); i++) {
                if (this != Grapher.GraphicNodes.get(i)) {
                    if (xx + 11 < Grapher.GraphicNodes.get(i).getX() + 48 && xx + 48 > Grapher.GraphicNodes.get(i).getX() + 11 && yy + 7 < Grapher.GraphicNodes.get(i).getY() + 16 && yy + 16 > Grapher.GraphicNodes.get(i).getY() + 7) {
                        state = 6;
                        break;
                    }
                    if (xx + 11 < Grapher.GraphicNodes.get(i).getX() + 33 && xx + 48 > Grapher.GraphicNodes.get(i).getX() + 26 && yy + 7 < Grapher.GraphicNodes.get(i).getY() + 59 && yy + 16 > Grapher.GraphicNodes.get(i).getY()) {
                        state = 6;
                        break;
                    }
                    if (xx + 26 < Grapher.GraphicNodes.get(i).getX() + 48 && xx + 33 > Grapher.GraphicNodes.get(i).getX() + 11 && yy < Grapher.GraphicNodes.get(i).getY() + 16 && yy + 59 > Grapher.GraphicNodes.get(i).getY() + 7) {
                        state = 6;
                        break;
                    }
                    if (xx + 26 < Grapher.GraphicNodes.get(i).getX() + 33 && xx + 33 > Grapher.GraphicNodes.get(i).getX() + 26 && yy < Grapher.GraphicNodes.get(i).getY() + 59 && yy + 59 > Grapher.GraphicNodes.get(i).getY()) {
                        state = 6;
                        break;
                    }
                }
            }
            l1.setText((xx + 11) + "");
            l2.setText(yy + "");
        } else {
            for (int i = 0; i < Grapher.GraphicNodes.size(); i++) {
                if (this != Grapher.GraphicNodes.get(i)) {
                    if (xx + 11 < Grapher.GraphicNodes.get(i).getX() + 48 && xx + 48 > Grapher.GraphicNodes.get(i).getX() + 11 && yy + 7 < Grapher.GraphicNodes.get(i).getY() + 16 && yy + 16 > Grapher.GraphicNodes.get(i).getY() + 7) {
                        state = 6;
                        break;
                    }
                    if (xx + 11 < Grapher.GraphicNodes.get(i).getX() + 33 && xx + 48 > Grapher.GraphicNodes.get(i).getX() + 26 && yy + 7 < Grapher.GraphicNodes.get(i).getY() + 59 && yy + 16 > Grapher.GraphicNodes.get(i).getY()) {
                        state = 6;
                        break;
                    }
                    if (xx + 26 < Grapher.GraphicNodes.get(i).getX() + 48 && xx + 33 > Grapher.GraphicNodes.get(i).getX() + 11 && yy < Grapher.GraphicNodes.get(i).getY() + 16 && yy + 59 > Grapher.GraphicNodes.get(i).getY() + 7) {
                        state = 6;
                        break;
                    }
                    if (xx + 26 < Grapher.GraphicNodes.get(i).getX() + 33 && xx + 33 > Grapher.GraphicNodes.get(i).getX() + 26 && yy < Grapher.GraphicNodes.get(i).getY() + 59 && yy + 59 > Grapher.GraphicNodes.get(i).getY()) {
                        state = 6;
                        break;
                    }
                }
            }
            try {
                int x = Integer.parseInt(l1.getText());
                int y = Integer.parseInt(l2.getText());
                xx = x-11;
                yy = y;
            } catch (NumberFormatException e) {
                xx = 1000;
                yy = 1000;
            }

        }
        switch (state) {
            case 6:
                gra.pixelex = InsertImage(this.xx, this.yy, gra.pixelex, imageSelecE);
                break;
            case 5:
                gra.pixelex = InsertImage(this.xx, this.yy, gra.pixelex, imageSelec);
                break;
        }

        auxClick = gra.Clicked;
        auxPress = Click;

    }

    boolean auxClick;
    boolean auxPress;
    boolean Click;
    int deltaX;
    int deltaY;
    int lastX;
    int lastY;

    //////////////////// Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return xx;
    }

    public void setX(int x) {
        this.xx = x;
    }

    public int getY() {
        return yy;
    }

    public void setY(int y) {
        this.yy = y;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {

        if (state == 0 || state == 1 || state == 2) {
            this.state = state;
        } else {
            this.state = 0;
        }
    }

    private void UploadImages() {
//dinero3.setIcon(new ImageIcon(getClass().getResource("/recursos/monedas_1.png")));
        try {

            /*InputStream input = new FileInputStream("ojoN.png");

            ImageInputStream imageInput = ImageIO.createImageInputStream(input);*/
            BufferedImage imagenL = ImageIO.read(getClass().getResource("/Files/torreN.png"));//imageInput
            /*
            int alto = imagenL.getHeight();
            int ancho = imagenL.getWidth();
            //System.out.println("Ancho :" + ancho + "/ Alto: " + alto);*/
            imageN = imagenL;
        } catch (IOException ex) {
            Logger.getLogger(Grapher.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            /*InputStream input = new FileInputStream("ojoG.png");

            ImageInputStream imageInput = ImageIO.createImageInputStream(input);*/
            BufferedImage imagenL = ImageIO.read(getClass().getResource("/Files/torreB.png"));//imageInput
            /*
            int alto = imagenL.getHeight();
            int ancho = imagenL.getWidth();
            //System.out.println("Ancho :" + ancho + "/ Alto: " + alto);*/
            imageS = imagenL;
        } catch (IOException ex) {
            Logger.getLogger(Grapher.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            /* InputStream input = new FileInputStream("ojo.png");

//            ImageInputStream imageInput = ImageIO.createImageInputStream(input);*/
            BufferedImage imagenL = ImageIO.read(getClass().getResource("/Files/torreM.png"));//imageInput
            /*
            int alto = imagenL.getHeight();
            int ancho = imagenL.getWidth();
            //System.out.println("Ancho :" + ancho + "/ Alto: " + alto);*/
            imageE = imagenL;
        } catch (IOException ex) {
            Logger.getLogger(Grapher.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            /* InputStream input = new FileInputStream("ojo.png");

//            ImageInputStream imageInput = ImageIO.createImageInputStream(input);*/
            BufferedImage imagenL = ImageIO.read(getClass().getResource("/Files/torreSelec.png"));//imageInput
            /*
            int alto = imagenL.getHeight();
            int ancho = imagenL.getWidth();
            //System.out.println("Ancho :" + ancho + "/ Alto: " + alto);*/
            imageSelec = imagenL;
        } catch (IOException ex) {
            Logger.getLogger(Grapher.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            /* InputStream input = new FileInputStream("ojo.png");

//            ImageInputStream imageInput = ImageIO.createImageInputStream(input);*/
            BufferedImage imagenL = ImageIO.read(getClass().getResource("/Files/torreSelect1.png"));//imageInput
            /*
            int alto = imagenL.getHeight();
            int ancho = imagenL.getWidth();
            //System.out.println("Ancho :" + ancho + "/ Alto: " + alto);*/
            imageSelecE = imagenL;
        } catch (IOException ex) {
            Logger.getLogger(Grapher.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            /* InputStream input = new FileInputStream("ojo.png");

//            ImageInputStream imageInput = ImageIO.createImageInputStream(input);*/
            BufferedImage imagenL = ImageIO.read(getClass().getResource("/Files/torreV.png"));//imageInput
            /*
            int alto = imagenL.getHeight();
            int ancho = imagenL.getWidth();
            //System.out.println("Ancho :" + ancho + "/ Alto: " + alto);*/
            imageAct = imagenL;
        } catch (IOException ex) {
            Logger.getLogger(Grapher.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            /* InputStream input = new FileInputStream("ojo.png");

//            ImageInputStream imageInput = ImageIO.createImageInputStream(input);*/
            BufferedImage imagenL = ImageIO.read(getClass().getResource("/Files/torreC.png"));//imageInput
            /*
            int alto = imagenL.getHeight();
            int ancho = imagenL.getWidth();
            //System.out.println("Ancho :" + ancho + "/ Alto: " + alto);*/
            imageActS = imagenL;
        } catch (IOException ex) {
            Logger.getLogger(Grapher.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            /* InputStream input = new FileInputStream("ojo.png");

//            ImageInputStream imageInput = ImageIO.createImageInputStream(input);*/
            BufferedImage imagenL = ImageIO.read(getClass().getResource("/Files/torreA.png"));//imageInput
            /*
            int alto = imagenL.getHeight();
            int ancho = imagenL.getWidth();
            //System.out.println("Ancho :" + ancho + "/ Alto: " + alto);*/
            imageActR = imagenL;
        } catch (IOException ex) {
            Logger.getLogger(Grapher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int[] InsertImage(int x, int y, int[] pixelex, BufferedImage ima) {

        for (int i = 0; i < ima.getWidth(); i++) {
            for (int j = 0; j < ima.getHeight(); j++) {

                if ((x + i) < GameWidth && (y + j) < GameHeight && (x + i) >= 0 && (y + j) >= 0) {

                    int b = ima.getRGB(i, j) & 255;
                    int g = (ima.getRGB(i, j) >> 8) & 255;
                    int r = (ima.getRGB(i, j) >> 16) & 255;
                    int a = (ima.getRGB(i, j) >> 24) & 255;
                    int b2 = pixelex[(x + i) + (y + j) * GameWidth] & 255;
                    int g2 = (pixelex[(x + i) + (y + j) * GameWidth] >> 8) & 255;
                    int r2 = (pixelex[(x + i) + (y + j) * GameWidth] >> 16) & 255;
                    int a2 = (pixelex[(x + i) + (y + j) * GameWidth] >> 24) & 255;

                    r = (r * a + r2 * (255 - a)) / 255;
                    g = (g * a + g2 * (255 - a)) / 255;
                    b = (b * a + b2 * (255 - a)) / 255;
                    a = 255;
                    int h = (a << 24) + (r << 16) + (g << 8) + b;
                    pixelex[(x + i) + (y + j) * GameWidth] = h;
                }

            }
        }
        return pixelex;
    }
}
