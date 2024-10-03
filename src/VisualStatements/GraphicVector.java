package VisualStatements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.text.DecimalFormat;

public class GraphicVector {

    private GraphicNode NodeA;
    private GraphicNode NodeB;
    private Grapher gra;
    private double d;
    public int color1 = 0xffa3a3a3;
    public int color2 = 0xffee9a1e;

    public GraphicVector(GraphicNode nodeA, GraphicNode nodeB, Grapher gra) {

        this.NodeA = nodeA;
        this.NodeB = nodeB;
        this.gra = gra;

    }

    public void Actualizations() {
        double x1 = NodeA.getX() + gra.ratio;
        double x2 = NodeB.getX() + gra.ratio;
        double y1 = NodeA.getY() + gra.ratio;
        double y2 = NodeB.getY() + gra.ratio;

        d = sqrt(pow((x1) - (x2), 2) + pow((y1) - (y2), 2));

    }

    public double getValue() {
        return d;
    }

    public GraphicNode getNodeA() {
        return NodeA;
    }

    public GraphicNode getNodeB() {
        return NodeB;
    }

    public Graphics Frames(Graphics g) {

        g.setColor(Color.BLACK);
        g.drawLine(NodeA.getX() + gra.ratio, NodeA.getY() + gra.ratio, NodeB.getX() + gra.ratio, NodeB.getY() + gra.ratio);

        return g;
    }

    public void Frames() {

        gra.pixelex = StrokeLine(NodeA.getX() + gra.ratio+17, NodeA.getY() + gra.ratio, NodeB.getX() + gra.ratio+17, NodeB.getY() + gra.ratio, gra.pixelex, 3, color1);

    }

    public void FramesS() {
        gra.pixelex = StrokeLine(NodeA.getX() + gra.ratio+17, NodeA.getY() + gra.ratio, NodeB.getX() + gra.ratio+17, NodeB.getY() + gra.ratio, gra.pixelex, 3, color2);
    }

    public void FramesN() {
        gra.pixelex = StrokeLine(NodeA.getX() + gra.ratio+17, NodeA.getY() + gra.ratio, NodeB.getX() + gra.ratio+17, NodeB.getY() + gra.ratio, gra.pixelex, 3, 0xff181634);
    }

    private int[] StrokeLine(int x11, int y11, int x22, int y22, int[] pixelex, int s, int c) {

        int color = c;//0xffFFC600 //0xfffafafa
        int bb = color & 255;
        int gg = color >> 8 & 255;
        int rr = color >> 16 & 255;
        int aa = 180;//180
        color = (aa << 24) + (rr << 16) + (gg << 8) + bb;

        pixelex = InsertLine(x11, y11, x22, y22, pixelex, color);

        int i1;
        int i2;
        if (s % 2 == 0) {
            i1 = s / 2;
            i2 = i1 - 1;
        } else {
            i1 = (s - 1) / 2;
            i2 = i1;
        }

        for (int i = 1; i < i1 + 1; i++) {

            if (i == i1) {

                int b = color & 255;
                int g = color >> 8 & 255;
                int r = color >> 16 & 255;
                int a = 159;//159
                int a2 = 159;//143

                int h = (a << 24) + (r << 16) + (g << 8) + b;
                int h1 = (a2 << 24) + (r << 16) + (g << 8) + b;
                pixelex = InsertLine(x11 + i, y11, x22 + i, y22, pixelex, h);
                pixelex = InsertLine(x11, y11 + i, x22, y22 + i, pixelex, h1);
            } else {
                pixelex = InsertLine(x11 + i, y11, x22 + i, y22, pixelex, color);
                pixelex = InsertLine(x11, y11 + i, x22, y22 + i, pixelex, color);
            }
        }
        for (int i = 1; i < i2 + 1; i++) {
            if (i == i2) {
                int b = color & 255;
                int g = color >> 8 & 255;
                int r = color >> 16 & 255;
                int a = 159;//159
                int a2 = 159;//143

                int h = (a << 24) + (r << 16) + (g << 8) + b;
                int h1 = (a2 << 24) + (r << 16) + (g << 8) + b;
                pixelex = InsertLine(x11 - i, y11, x22 - i, y22, pixelex, h1);
                pixelex = InsertLine(x11, y11 - i, x22, y22 - i, pixelex, h);
            } else {
                pixelex = InsertLine(x11 - i, y11, x22 - i, y22, pixelex, color);
                pixelex = InsertLine(x11, y11 - i, x22, y22 - i, pixelex, color);
            }

        }

        return pixelex;
    }

    public Graphics Names(Graphics g) {
        double x1 = NodeA.getX() + gra.ratio;
        double x2 = NodeB.getX() + gra.ratio;
        double y1 = NodeA.getY() + gra.ratio;
        double y2 = NodeB.getY() + gra.ratio;

        double u = sqrt(pow((x1) - (x2), 2) + pow((y1) - (y2), 2));
        DecimalFormat df = new DecimalFormat("#.00");
        String t = (df.format(u));
        g.setColor(Color.BLACK);
        g.setFont(new Font("century gothic", Font.PLAIN, 13));
        int x;
        if (NodeA.getX() > NodeB.getX()) {
            x = (NodeA.getX() - NodeB.getX()) / 2;
            x = x + NodeB.getX();
        } else {
            x = (NodeB.getX() - NodeA.getX()) / 2;
            x = x + NodeA.getX();
        }
        int y;
        if (NodeA.getY() > NodeB.getY()) {
            y = (NodeA.getY() - NodeB.getY()) / 2;
            y = y + NodeB.getY();
        } else {
            y = (NodeB.getY() - NodeA.getY()) / 2;
            y = y + NodeA.getY();
        }

        g.drawString(t + "", x, y + 7);
        return g;
    }

   

    private int[] InsertLine(int x11, int y11, int x22, int y22, int[] pixelex, int color) {

        double x1 = x11;
        double x2 = x22;
        double y1 = y11;
        double y2 = y22;

        if (x11 > x22) {
            double aux = x2;
            double auy = y2;
            int auxint = x22;
            int auyint = y22;
            x2 = x1;
            x1 = aux;
            y2 = y1;
            y1 = auy;

            x22 = x11;
            x11 = auxint;
            y22 = y11;
            y11 = auyint;
        }

        for (int i = x11; i < x22 + 1; i++) {
            double ry;
            if (x22 - x11 == 0) {
                ry = y1;
            } else {
                ry = Math.round(((y2 - y1) * (i - x1)) / (x2 - x1)) + y1;
            }//Tomando la parte decimal
            if ((i) < Grapher.GameWidth && (ry) < Grapher.GameHeight && (i) >= 0 && (ry) >= 0) {
                int b = color & 255;
                int g = color >> 8 & 255;
                int r = color >> 16 & 255;
                int a = color >> 24 & 255;
                int b2 = pixelex[(i) + ((int) ry) * Grapher.GameWidth] & 255;
                int g2 = (pixelex[(i) + ((int) ry) * Grapher.GameWidth] >> 8) & 255;
                int r2 = (pixelex[(i) + ((int) ry) * Grapher.GameWidth] >> 16) & 255;
                int a2 = (pixelex[(i) + ((int) ry) * Grapher.GameWidth] >> 24) & 255;

                r = (r * a + r2 * (255 - a)) / 255;
                g = (g * a + g2 * (255 - a)) / 255;
                b = (b * a + b2 * (255 - a)) / 255;
                a = 255;
                int h = (a << 24) + (r << 16) + (g << 8) + b;
                pixelex[(i) + ((int) ry) * Grapher.GameWidth] = h;
            }
        }
        if (y11 > y22) {
            double aux = x2;
            double auy = y2;
            int auxint = x22;
            int auyint = y22;
            x2 = x1;
            x1 = aux;
            y2 = y1;
            y1 = auy;

            y22 = y11;
            y11 = auyint;
        }
        for (int i = y11; i < y22 + 1; i++) {
            double rx;
            if (y2 - y1 == 0) {
                rx = x1;
            } else {
                rx = Math.round(((x2 - x1) * (i - y1)) / (y2 - y1)) + x1;
            }//Tomando la parte decimal
            if ((rx) < Grapher.GameWidth && (i) < Grapher.GameHeight && (rx) >= 0 && (i) >= 0) {

                int b = color & 255;
                int g = color >> 8 & 255;
                int r = color >> 16 & 255;
                int a = color >> 24 & 255;
                int b2 = pixelex[((int) rx) + (i) * Grapher.GameWidth] & 255;
                int g2 = (pixelex[((int) rx) + (i) * Grapher.GameWidth] >> 8) & 255;
                int r2 = (pixelex[((int) rx) + (i) * Grapher.GameWidth] >> 16) & 255;
                int a2 = (pixelex[((int) rx) + (i) * Grapher.GameWidth] >> 24) & 255;

                r = (r * a + r2 * (255 - a)) / 255;
                g = (g * a + g2 * (255 - a)) / 255;
                b = (b * a + b2 * (255 - a)) / 255;
                a = 255;
                int h = (a << 24) + (r << 16) + (g << 8) + b;
                pixelex[((int) rx) + (i) * Grapher.GameWidth] = h;
            }
        }

        return pixelex;

    }

}
