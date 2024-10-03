package VisualStatements;

import Routes.BFS;
import Routes.DFS;
import Routes.Kruskal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Interfaz extends JFrame {

    public Grapher grapher;
    private static JPanel modo;
    private boolean BotonPaccion;
    private static JLabel BotonP;
    //modo editar 
    private static JPanel vector_nodo; //Aqui se elige si se está trabajando con vector o nodo;
    private static JPanel edicionNodo;
    private static JPanel edicionVector;
    //botones de vector_nodo
    private static JLabel botonNodo;
    private static JLabel botonVector;
    //componentes de edicion_nodo
    private static JPanel PanelNodo;
    private static JPanel PanelInfoNodo;
    private static JLabel agregarNodo;
    private static JLabel addNodo;
    private static JLabel infoNodoBoton;
    private static JLabel tituloNodo;
    private static JLabel eliminarNodo;
    private static JLabel crearNodo;
    private static JLabel xNodo;
    private static JLabel yNodo;
    public static JTextField xtNodo;
    public static JTextField ytNodo;
    public static JLabel xtNodo2;
    public static JLabel ytNodo2;
    private static JTextField nombreNodo;
    private static JLabel nombreNodo2;
    private boolean infoNodoActivado;
    private boolean addNodoActivado;
    public int focoNodoActivado;//0-ninguno,1-info,2-add
    private static JLabel infotituloNodo;
    private static JLabel infoeliminarNodo;
    private static JLabel infoguardarNodo;
    private static JLabel infoxNodo;
    private static JLabel infoyNodo;
    public static JLabel infoxtNodo;
    public static JLabel infoytNodo;
    public static JLabel infonombreNodo2;
    public static JTextField infonombreNodo;
    public static JLabel nombreVentana;
    public static JLabel nombreVentana1;
    public static JLabel nVentana;
    public static JLabel nVentana1;

    //Componentes del boton vector
    private static JPanel panelVector;
    private static JLabel AgregarVector;
    private static JLabel AddVector;
    private static JPanel panelinfoVector;
    private static JLabel InfoVectorBoton;

    //Componentes de creacion del vector
    private static JLabel tituloVectorA;
    private static JLabel tituloVectorB;
    public static JLabel nombreVectorA;
    public static JLabel nombreVectorB;
    private static JLabel CancelarVector;
    private static JLabel CrearVector;

    //Componentes de informacion y edicion del vector
    private static JLabel InfoTituloVectorA;
    private static JLabel InfoTituloVectorB;
    public static JLabel InfoNombreVectorA;
    public static JLabel InfoNombreVectorB;
    private static JLabel InfoCancelarVector;
    private static JLabel InfoCrearVector;

    //Variables - Vector
    private boolean infoVectorActivado;
    private boolean addVectorActivado;
    public int focoVectorActivado;//0-ninguno,1-info,2-add

    private static JPanel panelRecorrido; //Aqui se elige si se está trabajando con vector o nodo;
    private static JLabel botonDFS;
    private static JLabel botonBFS;
    private static JLabel botonMin;
    private static JPanel infoRecorrido; //DFS
    private static JLabel CancelinfoRecorrido;
    private static JPanel infoRecorrido2; //BFS
    private static JLabel CancelinfoRecorrido2;

    //Componentes info Recorrido
    private static JLabel TituloNodoI;
    public static JLabel NombreNodoI;
    public static JLabel play;
    public static JLabel Visualizer;

    private static JLabel TituloNodoI2;
    public static JLabel NombreNodoI2;
    public static JLabel play2;
    public static JLabel Visualizer2;

    private static String parrafo;

    private static JScrollPane scroll;
    private static JScrollPane scroll2;
    public boolean pause;
    public boolean pause2;

    //menu desplegable
    public static JLabel config;
    public static JLabel config1;
    public static JLabel config2;
    public static JLabel config3;
    public static JPanel menu;
    public boolean menub;
    public int tipoEjecucion;

    public boolean focoNodoVector;//false-vector,true-nodo

    public Interfaz() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        pack();
        grapher = new Grapher(this);
        add(grapher.WorkBoard);
        setSize(grapher.FrameWidth, grapher.FrameHeight);//800,600
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(35, 37, 43));
        setVisible(true);

        int xx = (grapher.FrameWidth + (grapher.FrameWidth - getContentPane().getWidth()));
        int yy = (grapher.FrameHeight + (grapher.FrameHeight - getContentPane().getHeight()));
        setSize(xx, yy);

        infoNodoActivado = false;
        addNodoActivado = false;
        focoNodoActivado = 0;
        focoNodoVector = true;
        BotonPaccion = false;

        modo = new JPanel();
        BotonP = new JLabel();
        vector_nodo = new JPanel();
        edicionNodo = new JPanel();
        edicionVector = new JPanel();
        PanelNodo = new JPanel();
        PanelInfoNodo = new JPanel();
        botonVector = new JLabel();
        botonNodo = new JLabel();
        agregarNodo = new JLabel();
        addNodo = new JLabel();
        infoNodoBoton = new JLabel();
        tituloNodo = new JLabel();
        eliminarNodo = new JLabel();
        crearNodo = new JLabel();
        nombreNodo = new JTextField();
        nombreNodo2 = new JLabel();
        xtNodo = new JTextField();
        ytNodo = new JTextField();
        xtNodo2 = new JLabel();
        ytNodo2 = new JLabel();
        xNodo = new JLabel();
        yNodo = new JLabel();
        infotituloNodo = new JLabel();
        infoeliminarNodo = new JLabel();
        infoguardarNodo = new JLabel();
        infonombreNodo = new JTextField();
        infonombreNodo2 = new JLabel();
        infoxtNodo = new JLabel(" - ");
        infoytNodo = new JLabel(" - ");
        infoxNodo = new JLabel();
        infoyNodo = new JLabel();
        nombreVentana = new JLabel();
        nombreVentana1 = new JLabel();
        nVentana = new JLabel();
        nVentana1 = new JLabel();

        //Componentes del modo vector
        panelVector = new JPanel();
        AgregarVector = new JLabel();
        AddVector = new JLabel();
        panelinfoVector = new JPanel();
        InfoVectorBoton = new JLabel();
        tituloVectorA = new JLabel();
        tituloVectorB = new JLabel();
        nombreVectorA = new JLabel(" - ");
        nombreVectorB = new JLabel(" - ");
        CancelarVector = new JLabel();
        CrearVector = new JLabel();
        InfoTituloVectorA = new JLabel();
        InfoTituloVectorB = new JLabel();
        InfoNombreVectorA = new JLabel(" - ");
        InfoNombreVectorB = new JLabel(" - ");
        InfoCancelarVector = new JLabel();
        InfoCrearVector = new JLabel();

        //Variables - Vector
        infoVectorActivado = false;
        addVectorActivado = false;
        focoVectorActivado = 0;//0-ninguno,1-info,2-add
        tipoEjecucion = 0;

        panelRecorrido = new JPanel();
        botonDFS = new JLabel();
        botonBFS = new JLabel();
        botonMin = new JLabel();
        infoRecorrido = new JPanel();
        CancelinfoRecorrido = new JLabel();
        infoRecorrido2 = new JPanel();
        CancelinfoRecorrido2 = new JLabel();
        //Componentes de info recorrido
        TituloNodoI = new JLabel();
        NombreNodoI = new JLabel();
        play = new JLabel();
        pause = false;
        Visualizer = new JLabel("", SwingConstants.LEFT);

        TituloNodoI2 = new JLabel();
        NombreNodoI2 = new JLabel();
        play2 = new JLabel();
        pause2 = false;
        Visualizer2 = new JLabel("", SwingConstants.LEFT);

        scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        parrafo = "";
        //menu desplegable
        config = new JLabel("F");
        config1 = new JLabel();
        config2 = new JLabel();
        config3 = new JLabel();
        menu = new JPanel();
        menub = false;

        modo.setVisible(false);
        vector_nodo.setVisible(false);

        GraphicsObjects();

    }

    private void GraphicsObjects() {

        modo.setLayout(null);
        modo.setBounds(10, 20, 198, 98);
        modo.setBackground(Color.DARK_GRAY);
        modo.setOpaque(false);
        add(modo);
        modo.setVisible(true);

        vector_nodo.setLayout(null);
        vector_nodo.setBounds(10, 118, 198, 98);
        vector_nodo.setBackground(Color.ORANGE);
        vector_nodo.setOpaque(false);
        add(vector_nodo);
        vector_nodo.setVisible(true);

        edicionNodo.setLayout(null);
        edicionNodo.setBounds(10, 216, 198, 296);
        edicionNodo.setBackground(Color.WHITE);
        edicionNodo.setOpaque(false);
        add(edicionNodo);
        edicionNodo.setVisible(true);

        edicionVector.setLayout(null);
        edicionVector.setBounds(10, 216, 198, 296);
        edicionVector.setBackground(Color.DARK_GRAY);
        edicionVector.setOpaque(false);
        add(edicionVector);
        edicionVector.setVisible(false);

        botonNodo.setLayout(null);
        vector_nodo.add(botonNodo);
        botonNodo.setBounds(25, 0, 146, 30);
        botonNodo.setOpaque(false);
        botonNodo.setBackground(new Color(48, 144, 25)); //cambia color fondo jlabel
        botonNodo.setFont(new Font("arial", 1, 40));
        //botonNodo.setText(precio + "$");
        botonNodo.setForeground(Color.WHITE);
        botonNodo.setIcon(new ImageIcon(getClass().getResource("/Files/torresSeleccion.png")));
        botonNodo.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseEntered(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                botonNodo.setIcon(new ImageIcon(getClass().getResource("/Files/torresEncima.png")));
            }
        });
        botonNodo.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseExited(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      
                if (focoNodoVector == true) {
                    botonNodo.setIcon(new ImageIcon(getClass().getResource("/Files/torresSeleccion.png")));
                } else {
                    botonNodo.setIcon(new ImageIcon(getClass().getResource("/Files/botonNodo.png")));
                }

            }
        });
        botonNodo.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  
                edicionNodo.setVisible(true);
                edicionVector.setVisible(false);
                focoNodoVector = true;
                botonNodo.setIcon(new ImageIcon(getClass().getResource("/Files/torresSeleccion.png")));
                botonVector.setIcon(new ImageIcon(getClass().getResource("/Files/botonVector.png")));
            }

        });

        botonVector.setLayout(null);
        vector_nodo.add(botonVector);
        botonVector.setBounds(25, 45, 146, 30);
        botonVector.setOpaque(false);
        botonVector.setBackground(new Color(48, 144, 25)); //cambia color fondo jlabel
        botonVector.setFont(new Font("arial", 1, 40));
        //botonVector.setText(precio + "$");
        botonVector.setForeground(Color.WHITE);
        botonVector.setIcon(new ImageIcon(getClass().getResource("/Files/botonVector.png")));
        botonVector.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseEntered(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                botonVector.setIcon(new ImageIcon(getClass().getResource("/Files/conexionEncima.png")));
            }
        });
        botonVector.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseExited(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      
                if (focoNodoVector == false) {
                    botonVector.setIcon(new ImageIcon(getClass().getResource("/Files/conexionSeleccion.png")));
                } else {

                    botonVector.setIcon(new ImageIcon(getClass().getResource("/Files/botonVector.png")));
                }

            }
        });
        botonVector.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  
                edicionNodo.setVisible(false);
                edicionVector.setVisible(true);
                focoNodoVector = false;
                botonVector.setIcon(new ImageIcon(getClass().getResource("/Files/conexionSeleccion.png")));
                botonNodo.setIcon(new ImageIcon(getClass().getResource("/Files/botonNodo.png")));
            }

        });

        PanelNodo.setLayout(null);
        PanelNodo.setBounds(9, 65, 180, 222);
        PanelNodo.setBackground(new Color(56, 58, 62));
        edicionNodo.add(PanelNodo);
        PanelNodo.setVisible(false);

        PanelInfoNodo.setLayout(null);
        PanelInfoNodo.setBounds(9, 65, 180, 222);
        PanelInfoNodo.setBackground(new Color(56, 58, 62));
        edicionNodo.add(PanelInfoNodo);
        PanelInfoNodo.setVisible(false);

        menu.setLayout(null);
        menu.setBounds(174, 20, 15, 45);
        menu.setBackground(Color.GREEN);
        menu.setOpaque(false);
        modo.add(menu);

        menu.setVisible(false);

        config.setLayout(null);
        modo.add(config);
        config.setBounds(174, 5, 15, 15);
        config.setOpaque(false);
        config.setBackground(Color.BLUE); //cambia color fondo jlabel
        config.setFont(new Font("arial", 1, 40));
        //botonNodo.setText(precio + "$");
        config.setForeground(Color.WHITE);
        config.setIcon(new ImageIcon(getClass().getResource("/Files/config.png")));
        config.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  

                if (menub == true) {
                    menu.setVisible(false);
                    menub = false;
                    config.setIcon(new ImageIcon(getClass().getResource("/Files/config.png")));
                } else {
                    menu.setVisible(true);
                    menub = true;
                    config.setIcon(new ImageIcon(getClass().getResource("/Files/configA.png")));
                }

            }

        });

        config1.setLayout(null);
        menu.add(config1);
        config1.setBounds(0, 0, 15, 15);
        config1.setOpaque(false);
        config1.setBackground(Color.YELLOW); //cambia color fondo jlabel
        config1.setFont(new Font("arial", 1, 40));
        //botonNodo.setText(precio + "$");
        config1.setForeground(Color.WHITE);
        config1.setIcon(new ImageIcon(getClass().getResource("/Files/config1.png")));
        config1.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  
                if (grapher.nombres == true) {
                    grapher.nombres = false;

                } else {
                    grapher.nombres = true;
                }
            }

        });

        config2.setLayout(null);
        menu.add(config2);
        config2.setBounds(0, 15, 15, 15);
        config2.setOpaque(false);
        config2.setBackground(Color.YELLOW); //cambia color fondo jlabel
        config2.setFont(new Font("arial", 1, 40));
        //botonNodo.setText(precio + "$");
        config2.setForeground(Color.WHITE);
        config2.setIcon(new ImageIcon(getClass().getResource("/Files/config2.png")));
        config2.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  
                if (grapher.peso == true) {
                    grapher.peso = false;

                } else {
                    grapher.peso = true;
                }
            }

        });

        config3.setLayout(null);
        menu.add(config3);
        config3.setBounds(0, 30, 15, 15);
        config3.setOpaque(false);
        config3.setBackground(Color.YELLOW); //cambia color fondo jlabel
        config3.setFont(new Font("arial", 1, 40));
        //botonNodo.setText(precio + "$");
        config3.setForeground(Color.WHITE);
        config3.setIcon(new ImageIcon(getClass().getResource("/Files/config3.png")));
        config3.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  

            }

        });

        nombreVentana.setLayout(null);
        //edicionNodo.add(addNodo);
        edicionNodo.add(nombreVentana);
        //addNodo.setBounds(159, 35, 30, 30);
        nombreVentana.setBounds(12, 35, 90, 30);
        nombreVentana.setOpaque(false);
        nombreVentana.setBackground(Color.BLUE); //cambia color fondo jlabel
        nombreVentana.setFont(new Font("arial", 1, 20));
        //addNodo.setText(precio + "$");
        nombreVentana.setForeground(Color.WHITE);
        nombreVentana.setIcon(new ImageIcon(getClass().getResource("/Files/VentanaC.png")));
        nombreVentana.setVisible(false);

        nombreVentana1.setLayout(null);
        //edicionNodo.add(addNodo);
        edicionNodo.add(nombreVentana1);
        //addNodo.setBounds(159, 35, 30, 30);
        nombreVentana1.setBounds(12, 35, 90, 30);
        nombreVentana1.setOpaque(false);
        nombreVentana1.setBackground(Color.BLUE); //cambia color fondo jlabel
        nombreVentana1.setFont(new Font("arial", 1, 20));
        //addNodo.setText(precio + "$");
        nombreVentana1.setForeground(Color.WHITE);
        nombreVentana1.setIcon(new ImageIcon(getClass().getResource("/Files/VentanaI.png")));
        nombreVentana1.setVisible(false);

        agregarNodo.setLayout(null);
        edicionNodo.add(agregarNodo);
        agregarNodo.setBounds(10, 0, 30, 30);
        agregarNodo.setOpaque(false);
        agregarNodo.setBackground(Color.BLACK); //cambia color fondo jlabel
        agregarNodo.setFont(new Font("arial", 1, 30));
        //agregarNodo.setText(precio + "$");
        agregarNodo.setForeground(Color.WHITE);
        agregarNodo.setIcon(new ImageIcon(getClass().getResource("/Files/agregar.png")));
        agregarNodo.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseEntered(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                agregarNodo.setIcon(new ImageIcon(getClass().getResource("/Files/agregar2.png")));
            }
        });
        agregarNodo.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseExited(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                agregarNodo.setIcon(new ImageIcon(getClass().getResource("/Files/agregar.png")));
            }
        });
        agregarNodo.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override

            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  

                focoNodoActivado = 2;
                agregarNodo.setVisible(false);
                PanelNodo.setVisible(true);
                addNodo.setVisible(true);
                PanelInfoNodo.setVisible(false);
                addNodoActivado = true;

                nombreVentana.setVisible(true);
                nombreVentana1.setVisible(false);
                if (focoNodoActivado == 1) {
                    infoNodoBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infoOscuro.png")));

                } else {

                    infoNodoBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infofondo.png")));
                }

            }

        });

        addNodo.setLayout(null);
        //edicionNodo.add(addNodo);
        edicionNodo.add(addNodo);
        //addNodo.setBounds(159, 35, 30, 30);
        addNodo.setBounds(109, 35, 40, 30);
        addNodo.setOpaque(false);
        addNodo.setBackground(Color.BLUE); //cambia color fondo jlabel
        addNodo.setFont(new Font("arial", 1, 20));
        //addNodo.setText(precio + "$");
        addNodo.setForeground(Color.WHITE);
        addNodo.setIcon(new ImageIcon(getClass().getResource("/Files/addfondo.png")));
        addNodo.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK
                switch (focoNodoActivado) {
                    case 0:
                        PanelNodo.setVisible(true);
                        PanelInfoNodo.setVisible(false);
                        addNodoActivado = true;
                        focoNodoActivado = 2;
                        infoNodoBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infofondo.png")));
                        addNodo.setIcon(new ImageIcon(getClass().getResource("/Files/addfondo.png")));
                        nombreVentana.setVisible(true);
                        nombreVentana1.setVisible(false);
                        break;
                    case 1:
                        PanelNodo.setVisible(true);
                        PanelInfoNodo.setVisible(false);
                        addNodoActivado = true;
                        focoNodoActivado = 2;
                        infoNodoBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infoOscuro.png")));
                        addNodo.setIcon(new ImageIcon(getClass().getResource("/Files/addfondo.png")));
                        nombreVentana.setVisible(true);
                        nombreVentana1.setVisible(false);
                        break;
                    case 2:
                        if (infoNodoActivado == true) {
                            PanelNodo.setVisible(false);
                            PanelInfoNodo.setVisible(true);
                            addNodoActivado = false;
                            focoNodoActivado = 1;
                            infoNodoBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infocerrao.png")));
                            addNodo.setIcon(new ImageIcon(getClass().getResource("/Files/addOscuro.png")));
                            nombreVentana1.setVisible(true);
                            nombreVentana.setVisible(false);
                        } else {
                            PanelNodo.setVisible(false);
                            PanelInfoNodo.setVisible(false);
                            addNodoActivado = false;
                            focoNodoActivado = 0;
                            infoNodoBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infofondo.png")));
                            addNodo.setIcon(new ImageIcon(getClass().getResource("/Files/addcerrao.png")));
                            nombreVentana.setVisible(false);
                            nombreVentana1.setVisible(false);
                        }
                        break;
                    default:
                        break;
                }

            }

        });
        addNodo.setVisible(false);

        infoNodoBoton.setLayout(null);
        edicionNodo.add(infoNodoBoton);
        infoNodoBoton.setBounds(149, 35, 40, 30);
        infoNodoBoton.setOpaque(false);
        infoNodoBoton.setBackground(Color.PINK); //cambia color fondo jlabel
        infoNodoBoton.setFont(new Font("arial", 1, 20));
        infoNodoBoton.setForeground(Color.WHITE);
        infoNodoBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infofondo.png")));
        infoNodoBoton.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  
                switch (focoNodoActivado) {
                    case 0:
                        PanelNodo.setVisible(false);
                        PanelInfoNodo.setVisible(true);
                        infoNodoActivado = true;
                        focoNodoActivado = 1;
                        addNodo.setIcon(new ImageIcon(getClass().getResource("/Files/addcerrao.png")));
                        infoNodoBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infocerrao.png")));
                        nombreVentana1.setVisible(true);
                        nombreVentana.setVisible(false);
                        break;
                    case 2:
                        PanelNodo.setVisible(false);
                        PanelInfoNodo.setVisible(true);
                        infoNodoActivado = true;
                        focoNodoActivado = 1;
                        addNodo.setIcon(new ImageIcon(getClass().getResource("/Files/addOscuro.png")));
                        infoNodoBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infocerrao.png")));
                        nombreVentana1.setVisible(true);
                        nombreVentana.setVisible(false);
                        break;
                    case 1:
                        if (addNodoActivado == true) {
                            PanelNodo.setVisible(true);
                            PanelInfoNodo.setVisible(false);
                            infoNodoActivado = false;
                            focoNodoActivado = 2;
                            addNodo.setIcon(new ImageIcon(getClass().getResource("/Files/addfondo.png")));
                            infoNodoBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infoOscuro.png")));
                            nombreVentana.setVisible(true);
                            nombreVentana1.setVisible(false);

                        } else {
                            PanelNodo.setVisible(false);
                            PanelInfoNodo.setVisible(false);
                            infoNodoActivado = false;
                            focoNodoActivado = 0;
                            addNodo.setIcon(new ImageIcon(getClass().getResource("/Files/addcerrao.png")));
                            infoNodoBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infofondo.png")));
                            nombreVentana.setVisible(false);
                            nombreVentana1.setVisible(false);

                        }
                        break;
                    default:
                        break;
                }
            }

        });

        tituloNodo.setLayout(null);
        PanelNodo.add(tituloNodo);
        tituloNodo.setBounds(20, 30, 140, 30);
        tituloNodo.setOpaque(false);
        tituloNodo.setBackground(Color.BLACK); //cambia color fondo jlabel
        tituloNodo.setFont(new Font("arial", 1, 20));
        //tituloNodo.setText(precio + "$");
        tituloNodo.setForeground(Color.WHITE);
        tituloNodo.setIcon(new ImageIcon(getClass().getResource("/Files/tituloNodo2.png")));

        nombreNodo.setLayout(null);
        PanelNodo.add(nombreNodo);
        nombreNodo.setBounds(25, 70, 130, 30);
        nombreNodo.setHorizontalAlignment(JTextField.LEFT);
        nombreNodo.setOpaque(false);
        nombreNodo.setLayout(null);
        nombreNodo.setBorder(null);
        nombreNodo.setCaretColor(Color.WHITE);
        nombreNodo.setBackground(new Color(56, 58, 62)); //cambia color fondo jlabel 
        nombreNodo.setFont(new Font("century gothic", 1, 18));
        //nombreNodo.setBorder(BorderFactory.createLineBorder(new Color(93, 105, 100)));
        nombreNodo.setForeground(Color.white);

        nombreNodo2.setLayout(null);
        PanelNodo.add(nombreNodo2);
        nombreNodo2.setBounds(20, 70, 140, 30);
        //nombreNodo2.setHorizontalAlignment(JTextField.LEFT);
        nombreNodo2.setOpaque(true);
        nombreNodo2.setLayout(null);
        nombreNodo2.setBackground(new Color(56, 58, 62)); //cambia color fondo jlabel 
        //nombreNodo2.setFont(new Font("century gothic", 1, 18));
        nombreNodo2.setBorder(BorderFactory.createLineBorder(new Color(93, 105, 100)));
        nombreNodo2.setForeground(Color.white);

        eliminarNodo.setLayout(null);
        //edicionNodo.add(     eliminarNodo);
        PanelNodo.add(eliminarNodo);
        //     eliminarNodo.setBounds(159, 35, 30, 30);
        eliminarNodo.setBounds(20, 180, 60, 30);
        eliminarNodo.setOpaque(false);
        eliminarNodo.setBackground(Color.GREEN); //cambia color fondo jlabel
        eliminarNodo.setFont(new Font("arial", 1, 20));
        //     eliminarNodo.setText(precio + "$");
        eliminarNodo.setForeground(Color.BLACK);
        eliminarNodo.setIcon(new ImageIcon(getClass().getResource("/Files/cancelarNodo2.png")));
        eliminarNodo.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseEntered(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                eliminarNodo.setIcon(new ImageIcon(getClass().getResource("/Files/cancelarEncima.png")));
            }
        });
        eliminarNodo.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseExited(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                eliminarNodo.setIcon(new ImageIcon(getClass().getResource("/Files/cancelarNodo2.png")));
            }
        });
        eliminarNodo.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  
                focoNodoActivado = 0;
                infoNodoBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infofondo.png")));
                nombreVentana.setVisible(false);
                nombreVentana1.setVisible(false);

                if (infoNodoActivado == true) {
                    PanelInfoNodo.setVisible(true);
                    focoNodoActivado = 1;
                    infoNodoBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infocerrao.png")));
                    nombreVentana1.setVisible(true);
                    nombreVentana.setVisible(false);
                }

                agregarNodo.setVisible(true);
                PanelNodo.setVisible(false);
                addNodo.setVisible(false);
                addNodoActivado = false;

            }

        });

        crearNodo.setLayout(null);
        //edicionNodo.add(     crearNodo);
        PanelNodo.add(crearNodo);
        //     crearNodo.setBounds(159, 35, 30, 30);
        crearNodo.setBounds(100, 180, 60, 30);
        crearNodo.setOpaque(false);
        crearNodo.setBackground(Color.GREEN); //cambia color fondo jlabel
        crearNodo.setFont(new Font("arial", 1, 20));
        //     crearNodo.setText(precio + "$");
        crearNodo.setForeground(Color.BLACK);
        crearNodo.setIcon(new ImageIcon(getClass().getResource("/Files/crear.png")));
        crearNodo.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseEntered(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                crearNodo.setIcon(new ImageIcon(getClass().getResource("/Files/crearEncima.png")));
            }
        });
        crearNodo.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseExited(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                crearNodo.setIcon(new ImageIcon(getClass().getResource("/Files/crear.png")));
            }
        });
        crearNodo.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  
                try {
                    int x = Integer.parseInt(xtNodo.getText());
                    int y = Integer.parseInt(ytNodo.getText());
                    x=x-11;
                    ytNodo.setText("");
                    xtNodo.setText("");
                    //nombreNodo.setText("");
                    grapher.addGraphicNode(nombreNodo.getText(), x, y);
                    //grapher.addGraphicVector(grapher.GraphicNodes.size() - 1, grapher.GraphicNodes.size() - 2);
                    nombreNodo.setText("");
                    /*focoNodoActivado = 0;

                    if (infoNodoActivado == true) {
                        PanelInfoNodo.setVisible(true);
                        focoNodoActivado = 1;
                    }

                    agregarNodo.setVisible(true);
                    PanelNodo.setVisible(false);
                    addNodo.setVisible(false);
                    addNodoActivado = false;*/
                } catch (NumberFormatException r) {
                    //System.out.println("No");
                }

            }

        });

        xNodo.setLayout(null);
        //edicionNodo.add(     xNodo);
        PanelNodo.add(xNodo);
        //     xNodo.setBounds(159, 35, 30, 30);
        xNodo.setBounds(20, 120, 30, 30);
        xNodo.setOpaque(false);
        xNodo.setBackground(Color.GREEN); //cambia color fondo jlabel
        xNodo.setFont(new Font("arial", 1, 20));
        //     xNodo.setText(precio + "$");
        xNodo.setForeground(Color.BLACK);
        xNodo.setIcon(new ImageIcon(getClass().getResource("/Files/xNodo.png")));

        yNodo.setLayout(null);
        //edicionNodo.add(    yNodo);
        PanelNodo.add(yNodo);
        //    yNodo.setBounds(159, 35, 30, 30);
        yNodo.setBounds(90, 120, 30, 30);
        yNodo.setOpaque(false);
        yNodo.setBackground(Color.GREEN); //cambia color fondo jlabel
        yNodo.setFont(new Font("arial", 1, 20));
        //    yNodo.setText(precio + "$");
        yNodo.setForeground(Color.BLACK);
        yNodo.setIcon(new ImageIcon(getClass().getResource("/Files/yNodo.png")));

        xtNodo.setLayout(null);
        PanelNodo.add(xtNodo);
        xtNodo.setBounds(54, 120, 34, 30);
        xtNodo.setHorizontalAlignment(JTextField.LEFT);
        xtNodo.setOpaque(false);
        xtNodo.setLayout(null);
        xtNodo.setBorder(null);
        xtNodo.setCaretColor(Color.WHITE);
        xtNodo.setBackground(new Color(56, 58, 62)); //cambia color fondo jlabel 
        xtNodo.setFont(new Font("century gothic", 1, 18));
        //xtNodo.setBorder(BorderFactory.createLineBorder(new Color(93, 105, 100)));
        xtNodo.setForeground(Color.white);

        xtNodo2.setLayout(null);
        PanelNodo.add(xtNodo2);
        xtNodo2.setBounds(51, 120, 40, 30);
        //xtNodo2.setHorizontalAlignment(JTextField.LEFT);
        xtNodo2.setOpaque(true);
        xtNodo2.setLayout(null);
        xtNodo2.setBackground(new Color(56, 58, 62)); //cambia color fondo jlabel 
        //xtNodo2.setFont(new Font("century gothic", 1, 18));
        xtNodo2.setBorder(BorderFactory.createLineBorder(new Color(93, 105, 100)));
        xtNodo2.setForeground(Color.white);

        ytNodo.setLayout(null);
        PanelNodo.add(ytNodo);
        ytNodo.setBounds(123, 120, 34, 30);
        ytNodo.setHorizontalAlignment(JTextField.LEFT);
        ytNodo.setOpaque(false);
        ytNodo.setLayout(null);
        ytNodo.setBorder(null);
        ytNodo.setCaretColor(Color.WHITE);
        ytNodo.setBackground(new Color(56, 58, 62)); //cambia color fondo jlabel 
        ytNodo.setFont(new Font("century gothic", 1, 18));
        //ytNodo.setBorder(BorderFactory.createLineBorder(new Color(93, 105, 100)));
        ytNodo.setForeground(Color.white);

        ytNodo2.setLayout(null);
        PanelNodo.add(ytNodo2);
        ytNodo2.setBounds(120, 120, 40, 30);
        //ytNodo2.setHorizontalAlignment(JTextField.LEFT);
        ytNodo2.setOpaque(true);
        ytNodo2.setLayout(null);
        ytNodo2.setBackground(new Color(56, 58, 62)); //cambia color fondo jlabel 
        //ytNodo2.setFont(new Font("century gothic", 1, 18));
        ytNodo2.setBorder(BorderFactory.createLineBorder(new Color(93, 105, 100)));
        ytNodo2.setForeground(Color.white);

        infotituloNodo.setLayout(null);
        PanelInfoNodo.add(infotituloNodo);
        infotituloNodo.setBounds(20, 30, 140, 30);
        infotituloNodo.setOpaque(false);
        infotituloNodo.setBackground(Color.BLACK); //cambia color fondo jlabel
        infotituloNodo.setFont(new Font("arial", 1, 20));
        //tituloNodo.setText(precio + "$");
        infotituloNodo.setForeground(Color.WHITE);
        infotituloNodo.setIcon(new ImageIcon(getClass().getResource("/Files/tituloNodo2.png")));

        infonombreNodo.setLayout(null);
        PanelInfoNodo.add(infonombreNodo);
        infonombreNodo.setBounds(25, 70, 130, 30);
        infonombreNodo.setHorizontalAlignment(JTextField.LEFT);
        infonombreNodo.setOpaque(false);
        infonombreNodo.setLayout(null);
        infonombreNodo.setBorder(null);
        infonombreNodo.setCaretColor(Color.WHITE);
        infonombreNodo.setBackground(new Color(93, 105, 100)); //cambia color fondo jlabel 
        infonombreNodo.setFont(new Font("century gothic", 1, 18));
        //infonombreNodo.setBorder(BorderFactory.createLineBorder(new Color(93, 105, 100)));
        infonombreNodo.setForeground(Color.white);

        infonombreNodo2.setLayout(null);
        PanelInfoNodo.add(infonombreNodo2);
        infonombreNodo2.setBounds(20, 70, 140, 30);
        //nombreNodo2.setHorizontalAlignment(JTextField.LEFT);
        infonombreNodo2.setOpaque(true);
        infonombreNodo2.setLayout(null);
        infonombreNodo2.setBackground(new Color(56, 58, 62)); //cambia color fondo jlabel 
        //nombreNodo2.setFont(new Font("century gothic", 1, 18));
        infonombreNodo2.setBorder(BorderFactory.createLineBorder(new Color(93, 105, 100)));
        infonombreNodo2.setForeground(Color.white);

        infoeliminarNodo.setLayout(null);
        //edicionNodo.add(     eliminarNodo);
        PanelInfoNodo.add(infoeliminarNodo);
        //     eliminarNodo.setBounds(159, 35, 30, 30);
        infoeliminarNodo.setBounds(20, 180, 60, 30);
        infoeliminarNodo.setOpaque(false);
        infoeliminarNodo.setBackground(Color.GREEN); //cambia color fondo jlabel
        infoeliminarNodo.setFont(new Font("arial", 1, 20));
        //     eliminarNodo.setText(precio + "$");
        infoeliminarNodo.setForeground(Color.BLACK);
        infoeliminarNodo.setIcon(new ImageIcon(getClass().getResource("/Files/eliminar.png")));
        infoeliminarNodo.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseEntered(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                infoeliminarNodo.setIcon(new ImageIcon(getClass().getResource("/Files/eliminarEncima.png")));
            }
        });
        infoeliminarNodo.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseExited(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                infoeliminarNodo.setIcon(new ImageIcon(getClass().getResource("/Files/eliminar.png")));
            }
        });
        infoeliminarNodo.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  

                for (int i = 0; i < Grapher.GraphicNodes.size(); i++) {
                    if (Grapher.GraphicNodes.get(i) == grapher.ActualNode) {
                        grapher.deleteGraphicNode(i);
                        break;
                    }
                }
                grapher.SelectedNodeB = null;
                grapher.SelectedNodeA = null;
                grapher.SelectedNodeBB = null;
                grapher.SelectedNodeAA = null;
                grapher.ActualNode = null;
                infonombreNodo.setText("");
                infoxtNodo.setText(" - ");
                infoytNodo.setText(" - ");

            }
        });

        infoxNodo.setLayout(null);
        //edicionNodo.add(     xNodo);
        PanelInfoNodo.add(infoxNodo);
        //     xNodo.setBounds(159, 35, 30, 30);
        infoxNodo.setBounds(20, 120, 30, 30);
        infoxNodo.setOpaque(false);
        infoxNodo.setBackground(Color.GREEN); //cambia color fondo jlabel
        //infoxNodo.setFont(new Font("century gothic", 1, 18));
        //     xNodo.setText(precio + "$");
        infoxNodo.setForeground(Color.BLACK);
        infoxNodo.setIcon(new ImageIcon(getClass().getResource("/Files/xNodo.png")));

        infoyNodo.setLayout(null);
        //edicionNodo.add(    yNodo);
        PanelInfoNodo.add(infoyNodo);
        //    yNodo.setBounds(159, 35, 30, 30);
        infoyNodo.setBounds(90, 120, 30, 30);
        infoyNodo.setOpaque(false);
        infoyNodo.setBackground(Color.GREEN); //cambia color fondo jlabel
        //infoyNodo.setFont(new Font("century gothic", 1, 20));
        //    yNodo.setText(precio + "$");
        infoyNodo.setForeground(Color.BLACK);
        infoyNodo.setIcon(new ImageIcon(getClass().getResource("/Files/yNodo.png")));

        infoxtNodo.setLayout(null);
        PanelInfoNodo.add(infoxtNodo);
        infoxtNodo.setBounds(51, 118, 40, 30);
        //xtNodo2.setHorizontalAlignment(JTextField.LEFT);
        infoxtNodo.setOpaque(true);
        infoxtNodo.setLayout(null);
        infoxtNodo.setBackground(new Color(56, 58, 62)); //cambia color fondo jlabel 
        infoxtNodo.setFont(new Font("century gothic", 0, 22));
        //infoxtNodo.setBorder(BorderFactory.createLineBorder(new Color(93, 105, 100)));
        infoxtNodo.setForeground(new Color(173, 174, 176));

        infoytNodo.setLayout(null);
        PanelInfoNodo.add(infoytNodo);
        infoytNodo.setBounds(120, 118, 40, 30);
        //ytNodo2.setHorizontalAlignment(JTextField.LEFT);
        infoytNodo.setOpaque(true);
        infoytNodo.setLayout(null);
        infoytNodo.setBackground(new Color(56, 58, 62)); //cambia color fondo jlabel 
        infoytNodo.setFont(new Font("century gothic", 0, 22));
        //infoytNodo.setBorder(BorderFactory.createLineBorder(new Color(93, 105, 100)));
        infoytNodo.setForeground(new Color(173, 174, 176));

        infoguardarNodo.setLayout(null);
        //edicionNodo.add(     crearNodo);
        PanelInfoNodo.add(infoguardarNodo);
        //     crearNodo.setBounds(159, 35, 30, 30);
        infoguardarNodo.setBounds(100, 180, 60, 30);
        infoguardarNodo.setOpaque(false);
        infoguardarNodo.setBackground(Color.GREEN); //cambia color fondo jlabel
        infoguardarNodo.setFont(new Font("arial", 1, 20));
        //     crearNodo.setText(precio + "$");
        infoguardarNodo.setForeground(Color.BLACK);
        infoguardarNodo.setIcon(new ImageIcon(getClass().getResource("/Files/guardar.png")));
        infoguardarNodo.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseEntered(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                infoguardarNodo.setIcon(new ImageIcon(getClass().getResource("/Files/guardarArriba.png")));
            }
        });
        infoguardarNodo.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseExited(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                infoguardarNodo.setIcon(new ImageIcon(getClass().getResource("/Files/guardar.png")));
            }
        });
        infoguardarNodo.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  

                for (int i = 0; i < Grapher.GraphicNodes.size(); i++) {
                    if (Grapher.GraphicNodes.get(i) == grapher.ActualNode) {
                        Grapher.GraphicNodes.get(i).setName(infonombreNodo.getText());
                    }
                }

            }
        });

        //COMPONENTES DEL MODO VECTOR
        panelVector.setLayout(null);
        panelVector.setBounds(9, 65, 180, 222);
        panelVector.setBackground(new Color(56, 58, 62));
        edicionVector.add(panelVector);
        panelVector.setVisible(false);

        panelinfoVector.setLayout(null);
        panelinfoVector.setBounds(9, 65, 180, 222);
        panelinfoVector.setBackground(new Color(56, 58, 62));
        edicionVector.add(panelinfoVector);
        panelinfoVector.setVisible(false);

        nVentana.setLayout(null);
        //edicionNodo.add(addNodo);
        edicionVector.add(nVentana);
        //addNodo.setBounds(159, 35, 30, 30);
        nVentana.setBounds(12, 35, 90, 30);
        nVentana.setOpaque(false);
        nVentana.setBackground(Color.BLUE); //cambia color fondo jlabel
        nVentana.setFont(new Font("arial", 1, 20));
        //addNodo.setText(precio + "$");
        nVentana.setForeground(Color.WHITE);
        nVentana.setIcon(new ImageIcon(getClass().getResource("/Files/VentanaC.png")));
        nVentana.setVisible(false);

        nVentana1.setLayout(null);
        //edicionNodo.add(addNodo);
        edicionVector.add(nVentana1);
        //addNodo.setBounds(159, 35, 30, 30);
        nVentana1.setBounds(12, 35, 90, 30);
        nVentana1.setOpaque(false);
        nVentana1.setBackground(Color.BLUE); //cambia color fondo jlabel
        nVentana1.setFont(new Font("arial", 1, 20));
        //addNodo.setText(precio + "$");
        nVentana1.setForeground(Color.WHITE);
        nVentana1.setIcon(new ImageIcon(getClass().getResource("/Files/VentanaI.png")));
        nVentana1.setVisible(false);

        AgregarVector.setLayout(null);
        edicionVector.add(AgregarVector);
        AgregarVector.setBounds(10, 0, 30, 30);
        AgregarVector.setOpaque(false);
        AgregarVector.setBackground(Color.BLACK); //cambia color fondo jlabel
        AgregarVector.setFont(new Font("arial", 1, 30));
        //agregarNodo.setText(precio + "$");
        AgregarVector.setForeground(Color.WHITE);
        AgregarVector.setIcon(new ImageIcon(getClass().getResource("/Files/agregar.png")));
        AgregarVector.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseEntered(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                AgregarVector.setIcon(new ImageIcon(getClass().getResource("/Files/agregar2.png")));
            }
        });
        AgregarVector.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseExited(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                AgregarVector.setIcon(new ImageIcon(getClass().getResource("/Files/agregar.png")));
            }
        });
        AgregarVector.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  

                focoVectorActivado = 2;
                AgregarVector.setVisible(false);
                panelVector.setVisible(true);
                AddVector.setVisible(true);
                panelinfoVector.setVisible(false);
                addVectorActivado = true;
                nVentana.setVisible(true);
                nVentana1.setVisible(false);
                if (focoVectorActivado == 1) {
                    InfoVectorBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infoOscuro.png")));
                } else {

                    InfoVectorBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infofondo.png")));
                }

            }

        });

        AddVector.setLayout(null);
        //edicionNodo.add(AddVector);
        edicionVector.add(AddVector);
        //AddVector.setBounds(159, 35, 30, 30);
        AddVector.setBounds(109, 35, 40, 30);
        AddVector.setOpaque(false);
        AddVector.setBackground(Color.BLUE); //cambia color Fondo jlabel
        AddVector.setFont(new Font("arial", 1, 20));
        //AddVector.setText(precio + "$");
        AddVector.setForeground(Color.WHITE);
        AddVector.setIcon(new ImageIcon(getClass().getResource("/Files/addfondo.png")));
        AddVector.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK

                switch (focoVectorActivado) {
                    case 0:
                        panelVector.setVisible(true);
                        panelinfoVector.setVisible(false);
                        addVectorActivado = true;
                        focoVectorActivado = 2;
                        InfoVectorBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infofondo.png")));
                        AddVector.setIcon(new ImageIcon(getClass().getResource("/Files/addfondo.png")));
                        nVentana.setVisible(true);
                        nVentana1.setVisible(false);
                        break;
                    case 1:
                        panelVector.setVisible(true);
                        panelinfoVector.setVisible(false);
                        addVectorActivado = true;
                        focoVectorActivado = 2;
                        InfoVectorBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infoOscuro.png")));
                        AddVector.setIcon(new ImageIcon(getClass().getResource("/Files/addfondo.png")));
                        nVentana.setVisible(true);
                        nVentana1.setVisible(false);
                        break;
                    case 2:
                        if (infoVectorActivado == true) {
                            panelVector.setVisible(false);
                            panelinfoVector.setVisible(true);
                            addVectorActivado = false;
                            focoVectorActivado = 1;
                            InfoVectorBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infocerrao.png")));
                            AddVector.setIcon(new ImageIcon(getClass().getResource("/Files/addOscuro.png")));
                            nVentana1.setVisible(true);
                            nVentana.setVisible(false);
                        } else {
                            panelVector.setVisible(false);
                            panelinfoVector.setVisible(false);
                            addVectorActivado = false;
                            focoVectorActivado = 0;
                            InfoVectorBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infofondo.png")));
                            AddVector.setIcon(new ImageIcon(getClass().getResource("/Files/addcerrao.png")));
                            nombreVentana1.setVisible(false);
                            nombreVentana.setVisible(false);
                        }
                        break;
                    default:
                        break;
                }

            }

        });
        AddVector.setVisible(false);

        InfoVectorBoton.setLayout(null);
        edicionVector.add(InfoVectorBoton);
        InfoVectorBoton.setBounds(149, 35, 40, 30);
        InfoVectorBoton.setOpaque(false);
        InfoVectorBoton.setBackground(Color.PINK); //cambia color fondo jlabel
        InfoVectorBoton.setFont(new Font("arial", 1, 20));
        InfoVectorBoton.setForeground(Color.WHITE);
        InfoVectorBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infofondo.png")));
        InfoVectorBoton.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  

                switch (focoVectorActivado) {
                    case 0:
                        panelVector.setVisible(false);
                        panelinfoVector.setVisible(true);
                        infoVectorActivado = true;
                        focoVectorActivado = 1;
                        AddVector.setIcon(new ImageIcon(getClass().getResource("/Files/addcerrao.png")));
                        InfoVectorBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infocerrao.png")));
                        nVentana1.setVisible(true);
                        nVentana.setVisible(false);
                        break;
                    case 2:
                        panelVector.setVisible(false);
                        panelinfoVector.setVisible(true);
                        infoVectorActivado = true;
                        focoVectorActivado = 1;
                        AddVector.setIcon(new ImageIcon(getClass().getResource("/Files/addOscuro.png")));
                        InfoVectorBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infocerrao.png")));
                        nVentana1.setVisible(true);
                        nVentana.setVisible(false);
                        break;
                    case 1:
                        if (addVectorActivado == true) {
                            panelVector.setVisible(true);
                            panelinfoVector.setVisible(false);
                            infoVectorActivado = false;
                            focoVectorActivado = 2;
                            AddVector.setIcon(new ImageIcon(getClass().getResource("/Files/addfondo.png")));
                            InfoVectorBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infoOscuro.png")));
                            nVentana.setVisible(true);
                            nVentana1.setVisible(false);
                        } else {
                            panelVector.setVisible(false);
                            panelinfoVector.setVisible(false);
                            infoVectorActivado = false;
                            focoVectorActivado = 0;
                            AddVector.setIcon(new ImageIcon(getClass().getResource("/Files/addcerrao.png")));
                            InfoVectorBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infofondo.png")));
                            nVentana.setVisible(false);
                            nVentana1.setVisible(false);
                        }
                        break;
                    default:
                        break;
                }
            }

        });

        //Pestaña de creacion (Vector)
        tituloVectorA.setLayout(null);
        panelVector.add(tituloVectorA);
        tituloVectorA.setBounds(5, 10, 90, 30);
        tituloVectorA.setOpaque(false);
        tituloVectorA.setBackground(Color.BLACK); //cambia color fondo jlabel
        tituloVectorA.setFont(new Font("arial", 1, 18));
        //tituloNodo.setText(precio + "$");
        tituloVectorA.setForeground(Color.BLACK);
        tituloVectorA.setIcon(new ImageIcon(getClass().getResource("/Files/tituloVectorA.png")));

        nombreVectorA.setLayout(null);
        panelVector.add(nombreVectorA);
        nombreVectorA.setBounds(5, 40, 90, 30);
        nombreVectorA.setOpaque(false);
        nombreVectorA.setBackground(Color.BLACK); //cambia color fondo jlabel
        nombreVectorA.setFont(new Font("century gothic", 1, 20));
        //tituloNodo.setText(precio + "$");
        nombreVectorA.setForeground(new Color(173, 174, 176));

        tituloVectorB.setLayout(null);
        panelVector.add(tituloVectorB);
        tituloVectorB.setBounds(5, 70, 90, 30);
        tituloVectorB.setOpaque(false);
        tituloVectorB.setBackground(Color.BLACK); //cambia color fondo jlabel
        tituloVectorB.setFont(new Font("arial", 1, 18));
        //tituloNodo.setText(precio + "$");
        tituloVectorB.setForeground(Color.BLACK);
        tituloVectorB.setIcon(new ImageIcon(getClass().getResource("/Files/tituloVectorB.png")));

        nombreVectorB.setLayout(null);
        panelVector.add(nombreVectorB);
        nombreVectorB.setBounds(5, 100, 90, 30);
        nombreVectorB.setOpaque(false);
        nombreVectorB.setBackground(Color.BLACK); //cambia color fondo jlabel
        nombreVectorB.setFont(new Font("century gothic", 1, 20));
        //tituloNodo.setText(precio + "$");
        nombreVectorB.setForeground(new Color(173, 174, 176));

        CancelarVector.setLayout(null);
        //edicionNodo.add(  CancelarVector);
        panelVector.add(CancelarVector);
        //      CancelarVector.setBounds(159, 35, 30, 30);
        CancelarVector.setBounds(20, 180, 60, 30);
        CancelarVector.setOpaque(false);
        CancelarVector.setBackground(Color.GREEN); //cambia color fondo jlabel
        CancelarVector.setFont(new Font("arial", 1, 20));
        //     CancelarVector.setText(precio + "$");
        CancelarVector.setForeground(Color.BLACK);
        CancelarVector.setIcon(new ImageIcon(getClass().getResource("/Files/cancelarNodo2.png")));
        CancelarVector.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseEntered(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                CancelarVector.setIcon(new ImageIcon(getClass().getResource("/Files/cancelarEncima.png")));
            }
        });
        CancelarVector.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseExited(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                CancelarVector.setIcon(new ImageIcon(getClass().getResource("/Files/cancelarNodo2.png")));
            }
        });
        CancelarVector.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  
                focoVectorActivado = 0;
                InfoVectorBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infofondo.png")));
                nVentana.setVisible(false);
                nVentana1.setVisible(false);
                if (infoVectorActivado == true) {
                    panelinfoVector.setVisible(true);
                    focoVectorActivado = 1;
                    InfoVectorBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infocerrao.png")));
                    nVentana.setVisible(false);
                    nVentana1.setVisible(true);
                }

                AgregarVector.setVisible(true);
                panelVector.setVisible(false);
                AddVector.setVisible(false);
                addVectorActivado = false;
            }

        });

        CrearVector.setLayout(null);
        //edicionNodo.add(     crearNodo);
        panelVector.add(CrearVector);
        //     crearNodo.setBounds(159, 35, 30, 30);
        CrearVector.setBounds(100, 180, 60, 30);
        CrearVector.setOpaque(false);
        CrearVector.setBackground(Color.GREEN); //cambia color fondo jlabel
        CrearVector.setFont(new Font("arial", 1, 20));
        //     crearNodo.setText(precio + "$");
        CrearVector.setForeground(Color.BLACK);
        CrearVector.setIcon(new ImageIcon(getClass().getResource("/Files/crear.png")));
        CrearVector.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseEntered(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                CrearVector.setIcon(new ImageIcon(getClass().getResource("/Files/crearEncima.png")));
            }
        });
        CrearVector.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseExited(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                CrearVector.setIcon(new ImageIcon(getClass().getResource("/Files/crear.png")));
            }
        });
        CrearVector.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  
                nombreVectorA.setText("-");
                nombreVectorB.setText("-");

                int a = 0;
                int b = 0;
                for (int i = 0; i < Grapher.GraphicNodes.size(); i++) {
                    if (Grapher.GraphicNodes.get(i) == grapher.SelectedNodeA) {
                        a = i;
                        break;
                    }
                }
                for (int i = 0; i < Grapher.GraphicNodes.size(); i++) {
                    if (Grapher.GraphicNodes.get(i) == grapher.SelectedNodeB) {
                        b = i;
                        break;
                    }
                }
                grapher.addGraphicVector(a, b);
                grapher.SelectedNodeB = null;
                grapher.SelectedNodeA = null;
                /*focoVectorActivado = 0;

                if (infoVectorActivado == true) {
                    panelinfoVector.setVisible(true);
                    focoVectorActivado = 1;
                }

                AgregarVector.setVisible(true);
                panelVector.setVisible(false);
                AddVector.setVisible(false);
                addVectorActivado = false;*/
            }
        });

        //Pestaña de informacion (Vector)
        InfoTituloVectorA.setLayout(null);
        panelinfoVector.add(InfoTituloVectorA);
        InfoTituloVectorA.setBounds(5, 10, 90, 30);
        InfoTituloVectorA.setOpaque(false);
        InfoTituloVectorA.setBackground(Color.BLACK); //cambia color fondo jlabel
        InfoTituloVectorA.setFont(new Font("arial", 1, 18));
        //tituloNodo.setText(precio + "$");
        InfoTituloVectorA.setForeground(Color.BLACK);
        InfoTituloVectorA.setIcon(new ImageIcon(getClass().getResource("/Files/tituloVectorA.png")));

        InfoNombreVectorA.setLayout(null);
        panelinfoVector.add(InfoNombreVectorA);
        InfoNombreVectorA.setBounds(5, 40, 90, 30);
        InfoNombreVectorA.setOpaque(false);
        InfoNombreVectorA.setBackground(Color.BLACK); //cambia color fondo jlabel
        InfoNombreVectorA.setFont(new Font("century gothic", 1, 20));
        //tituloNodo.setText(precio + "$");
        InfoNombreVectorA.setForeground(new Color(173, 174, 176));

        InfoTituloVectorB.setLayout(null);
        panelinfoVector.add(InfoTituloVectorB);
        InfoTituloVectorB.setBounds(5, 70, 90, 30);
        InfoTituloVectorB.setOpaque(false);
        InfoTituloVectorB.setBackground(Color.BLACK); //cambia color fondo jlabel
        InfoTituloVectorB.setFont(new Font("arial", 1, 18));
        //tituloNodo.setText(precio + "$");
        InfoTituloVectorB.setForeground(Color.BLACK);
        InfoTituloVectorB.setIcon(new ImageIcon(getClass().getResource("/Files/tituloVectorB.png")));

        InfoNombreVectorB.setLayout(null);
        panelinfoVector.add(InfoNombreVectorB);
        InfoNombreVectorB.setBounds(5, 100, 90, 30);
        InfoNombreVectorB.setOpaque(false);
        InfoNombreVectorB.setBackground(Color.BLACK); //cambia color fondo jlabel
        InfoNombreVectorB.setFont(new Font("century gothic", 1, 20));
        //tituloNodo.setText(precio + "$");
        InfoNombreVectorB.setForeground(new Color(173, 174, 176));

        InfoCancelarVector.setLayout(null);
        //edicionNodo.add(  CancelarVector);
        panelinfoVector.add(InfoCancelarVector);
        //      CancelarVector.setBounds(159, 35, 30, 30);
        InfoCancelarVector.setBounds(20, 180, 60, 30);
        InfoCancelarVector.setOpaque(false);
        InfoCancelarVector.setBackground(Color.GREEN); //cambia color fondo jlabel
        InfoCancelarVector.setFont(new Font("arial", 1, 20));
        //     CancelarVector.setText(precio + "$");
        InfoCancelarVector.setForeground(Color.BLACK);
        InfoCancelarVector.setIcon(new ImageIcon(getClass().getResource("/Files/eliminar.png")));
        InfoCancelarVector.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseEntered(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                InfoCancelarVector.setIcon(new ImageIcon(getClass().getResource("/Files/eliminarEncima.png")));
            }
        });
        InfoCancelarVector.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseExited(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                InfoCancelarVector.setIcon(new ImageIcon(getClass().getResource("/Files/eliminar.png")));
            }
        });
        InfoCancelarVector.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  
                InfoNombreVectorA.setText("-");
                InfoNombreVectorB.setText("-");

                int a = 0;
                int b = 0;
                for (int i = 0; i < Grapher.GraphicNodes.size(); i++) {
                    if (Grapher.GraphicNodes.get(i) == grapher.SelectedNodeAA) {
                        a = i;
                        break;
                    }
                }
                for (int i = 0; i < Grapher.GraphicNodes.size(); i++) {
                    if (Grapher.GraphicNodes.get(i) == grapher.SelectedNodeBB) {
                        b = i;
                        break;
                    }
                }
                grapher.deleteGraphicVector(a, b);
                grapher.SelectedNodeBB = null;
                grapher.SelectedNodeAA = null;
            }

        });

        InfoCrearVector.setLayout(null);
        //edicionNodo.add(     crearNodo);
        panelinfoVector.add(InfoCrearVector);
        //     crearNodo.setBounds(159, 35, 30, 30);
        InfoCrearVector.setBounds(100, 180, 60, 30);
        InfoCrearVector.setOpaque(false);
        InfoCrearVector.setBackground(Color.GREEN); //cambia color fondo jlabel
        InfoCrearVector.setFont(new Font("arial", 1, 20));
        //     crearNodo.setText(precio + "$");
        InfoCrearVector.setForeground(Color.BLACK);
        InfoCrearVector.setIcon(new ImageIcon(getClass().getResource("/Files/guardar.png")));
        InfoCrearVector.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseEntered(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                InfoCrearVector.setIcon(new ImageIcon(getClass().getResource("/Files/guardarArriba.png")));
            }
        });
        InfoCrearVector.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseExited(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                InfoCrearVector.setIcon(new ImageIcon(getClass().getResource("/Files/guardar.png")));
            }
        });
        InfoCrearVector.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  
                InfoVectorBoton.setIcon(new ImageIcon(getClass().getResource("/Files/infofondo.png")));
                panelinfoVector.setVisible(false);
            }
        });

        panelRecorrido.setLayout(null);
        panelRecorrido.setBounds(10, 118, 198, 98);
        panelRecorrido.setBackground(new Color(56, 58, 62));
        add(panelRecorrido);
        panelRecorrido.setOpaque(false);
        panelRecorrido.setVisible(false);

        infoRecorrido.setLayout(null);
        infoRecorrido.setBounds(10, 216, 198, 296);
        infoRecorrido.setBackground(new Color(56, 58, 62));
        add(infoRecorrido);
        infoRecorrido.setOpaque(true);
        infoRecorrido.setVisible(false);

        //panelScroll.setLayout(null);
        //panelScroll.setBounds(5, 5, 175, 200);
        //panelScroll.setBackground(Color.PINK);
        //scroll.add(panelScroll);
        //panelScroll.setVisible(false);
        //scroll.setLayout(null);
        scroll.setBounds(10, 136, 180, 146);
        scroll.setBackground(new Color(56, 58, 62));
        infoRecorrido.add(scroll);
        scroll.setVisible(false);
        scroll.setBorder(null);
        /*scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            public void configureScrollBarColors() {
                this.thumbColor = Color.GRAY;
            }
        });*/
        //(9, 13, 180, 120);

        //panelScroll.setPreferredSize(new Dimension(200,143));
        //scroll.setViewportView(panelScroll);
        infoRecorrido2.setLayout(null);
        infoRecorrido2.setBounds(10, 216, 198, 296);
        infoRecorrido2.setBackground(new Color(56, 58, 62));
        add(infoRecorrido2);
        infoRecorrido2.setVisible(false);

        scroll2.setBounds(10, 136, 180, 146);
        scroll2.setBackground(new Color(56, 58, 62));
        infoRecorrido2.add(scroll2);
        scroll2.setVisible(false);
        scroll2.setBorder(null);

        botonDFS.setLayout(null);
        panelRecorrido.add(botonDFS);
        botonDFS.setBounds(26, 0, 60, 40);
        botonDFS.setOpaque(false);
        botonDFS.setBackground(new Color(48, 144, 25)); //cambia color fondo jlabel
        botonDFS.setFont(new Font("arial", 1, 20));
        //botonNodo.setText(precio + "$");
        botonDFS.setForeground(Color.WHITE);
        botonDFS.setIcon(new ImageIcon(getClass().getResource("/Files/botonDFS.png")));
        botonDFS.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseEntered(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                botonDFS.setIcon(new ImageIcon(getClass().getResource("/Files/DFSencima.png")));
            }
        });
        botonDFS.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseExited(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      
                if (tipoEjecucion == 1) {
                    botonDFS.setIcon(new ImageIcon(getClass().getResource("/Files/DFSselec.png")));
                } else {

                    botonDFS.setIcon(new ImageIcon(getClass().getResource("/Files/botonDFS.png")));
                }

            }
        });
        botonDFS.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  
                grapher.anim = false;
                grapher.anim2 = false;
                grapher.Route = null;
                grapher.rt = 0;

                infoRecorrido.setVisible(true);
                infoRecorrido2.setVisible(false);
                scroll.setVisible(true);
                scroll2.setVisible(false);
                botonBFS.setIcon(new ImageIcon(getClass().getResource("/Files/botonBFS.png")));
                botonDFS.setIcon(new ImageIcon(getClass().getResource("/Files/DFSselec.png")));
                botonMin.setIcon(new ImageIcon(getClass().getResource("/Files/mincosto.png")));
                tipoEjecucion = 1;
                for (int l = 0; l < Grapher.GraphicNodes.size(); l++) {
                    Grapher.GraphicNodes.get(l).setState(0);
                }

            }

        });

        botonBFS.setLayout(null);
        panelRecorrido.add(botonBFS);
        botonBFS.setBounds(112, 0, 60, 40);
        botonBFS.setOpaque(false);
        botonBFS.setBackground(new Color(48, 144, 25)); //cambia color fondo jlabel
        botonBFS.setFont(new Font("arial", 1, 20));
        //botonNodo.setText(precio + "$");
        botonBFS.setForeground(Color.WHITE);
        botonBFS.setIcon(new ImageIcon(getClass().getResource("/Files/botonBFS.png")));
        botonBFS.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseEntered(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                botonBFS.setIcon(new ImageIcon(getClass().getResource("/Files/BFSencima.png")));
            }
        });
        botonBFS.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseExited(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      
                if (tipoEjecucion == 2) {
                    botonBFS.setIcon(new ImageIcon(getClass().getResource("/Files/BFSselec.png")));
                } else {

                    botonBFS.setIcon(new ImageIcon(getClass().getResource("/Files/botonBFS.png")));
                }

            }
        });
        botonBFS.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK 
                grapher.anim = false;
                grapher.anim2 = false;
                grapher.Route = null;
                grapher.rt = 0;

                infoRecorrido2.setVisible(true);

                infoRecorrido.setVisible(false);
                scroll2.setVisible(true);
                scroll.setVisible(false);

                botonBFS.setIcon(new ImageIcon(getClass().getResource("/Files/BFSselec.png")));
                botonDFS.setIcon(new ImageIcon(getClass().getResource("/Files/botonDFS.png")));
                botonMin.setIcon(new ImageIcon(getClass().getResource("/Files/mincosto.png")));
                tipoEjecucion = 2;
                for (int l = 0; l < Grapher.GraphicNodes.size(); l++) {
                    Grapher.GraphicNodes.get(l).setState(0);
                }

            }

        });

        botonMin.setLayout(null);
        panelRecorrido.add(botonMin);
        botonMin.setBounds(26, 50, 146, 30);
        botonMin.setOpaque(false);
        botonMin.setBackground(new Color(48, 144, 25)); //cambia color fondo jlabel
        botonMin.setFont(new Font("arial", 1, 20));
        //botonNodo.setText(precio + "$");
        botonMin.setForeground(Color.WHITE);
        botonMin.setIcon(new ImageIcon(getClass().getResource("/Files/mincosto.png")));
        botonMin.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseEntered(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                botonMin.setIcon(new ImageIcon(getClass().getResource("/Files/mincostoEncima.png")));
            }
        });
        botonMin.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseExited(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      
                if (tipoEjecucion == 3) {
                    botonMin.setIcon(new ImageIcon(getClass().getResource("/Files/mincostoSelec.png")));
                } else {

                    botonMin.setIcon(new ImageIcon(getClass().getResource("/Files/mincosto.png")));
                }

            }
        });
        botonMin.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  
                grapher.anim = false;
                grapher.anim2 = false;
                grapher.Route = null;
                grapher.rt = 0;

                infoRecorrido.setVisible(false);
                infoRecorrido2.setVisible(false);
                scroll.setVisible(false);
                scroll2.setVisible(false);

                botonBFS.setIcon(new ImageIcon(getClass().getResource("/Files/botonBFS.png")));
                botonDFS.setIcon(new ImageIcon(getClass().getResource("/Files/botonDFS.png")));
                botonMin.setIcon(new ImageIcon(getClass().getResource("/Files/mincostoEncima.png")));
                tipoEjecucion = 3;

                try {
                    Kruskal krus = new Kruskal(Grapher.GraphicNodes, grapher);
                    ArrayList<GraphicVector> Route = krus.Kruskal_Route();
                    grapher.Route = Route;
                    ////System.out.println(Route.size()+" mira 2");
                    // for (int i = 0; i < Route.size(); i++) {
                    //   //System.out.println(Route.get(i).getNodeA().getName() + "-" + Route.get(i).getNodeB().getName());
                    // }

                } catch (Exception g) {

                }
                for (int l = 0; l < Grapher.GraphicNodes.size(); l++) {
                    Grapher.GraphicNodes.get(l).setState(0);
                }

            }

        });

        //Componentes Recorrido DFS
        CancelinfoRecorrido.setLayout(null);
        infoRecorrido.add(CancelinfoRecorrido);
        CancelinfoRecorrido.setBounds(173, 0, 25, 25);
        CancelinfoRecorrido.setOpaque(false);
        CancelinfoRecorrido.setBackground(Color.RED); //cambia color fondo jlabel
        CancelinfoRecorrido.setFont(new Font("arial", 1, 20));
        //agregarNodo.setText(precio + "$");
        CancelinfoRecorrido.setForeground(Color.BLACK);
        CancelinfoRecorrido.setIcon(new ImageIcon(getClass().getResource("/Files/cancelEjec.png")));
        CancelinfoRecorrido.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseEntered(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                CancelinfoRecorrido.setIcon(new ImageIcon(getClass().getResource("/Files/cancelOscuro.png")));
            }
        });
        CancelinfoRecorrido.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseExited(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                CancelinfoRecorrido.setIcon(new ImageIcon(getClass().getResource("/Files/cancelEjec.png")));
            }
        });
        CancelinfoRecorrido.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  

                infoRecorrido.setVisible(false);
                scroll.setVisible(false);
                tipoEjecucion = 0;
                botonDFS.setIcon(new ImageIcon(getClass().getResource("/Files/botonDFS.png")));
            }

        });

        TituloNodoI.setLayout(null);
        infoRecorrido.add(TituloNodoI);
        TituloNodoI.setBounds(29, 10, 130, 30);
        TituloNodoI.setOpaque(false);
        TituloNodoI.setBackground(Color.BLACK); //cambia color fondo jlabel
        TituloNodoI.setFont(new Font("arial", 1, 18));
        //tituloNodo.setText(precio + "$");
        TituloNodoI.setIcon(new ImageIcon(getClass().getResource("/Files/tituloEjec.png")));
        TituloNodoI.setForeground(Color.BLACK);

        NombreNodoI.setLayout(null);
        infoRecorrido.add(NombreNodoI);
        NombreNodoI.setBounds(29, 40, 130, 30);
        NombreNodoI.setOpaque(true);
        NombreNodoI.setFont(new Font("arial", 1, 18));
        NombreNodoI.setBackground(new Color(56, 58, 62));
        NombreNodoI.setHorizontalAlignment(JTextField.CENTER);
        //tituloNodo.setText(precio + "$");
        NombreNodoI.setBorder(BorderFactory.createLineBorder(new Color(93, 105, 100)));
        NombreNodoI.setForeground(Color.WHITE);

        ytNodo2.setLayout(null);
        PanelNodo.add(ytNodo2);
        ytNodo2.setBounds(120, 120, 40, 30);
        //ytNodo2.setHorizontalAlignment(JTextField.LEFT);
        ytNodo2.setOpaque(true);
        ytNodo2.setLayout(null);
        ytNodo2.setBackground(new Color(56, 58, 62)); //cambia color fondo jlabel 
        //ytNodo2.setFont(new Font("century gothic", 1, 18));
        ytNodo2.setBorder(BorderFactory.createLineBorder(new Color(93, 105, 100)));
        ytNodo2.setForeground(Color.white);

        play.setLayout(null);
        infoRecorrido.add(play);
        play.setBounds(79, 85, 40, 40);
        play.setOpaque(false);
        play.setBackground(Color.BLACK); //cambia color fondo jlabel
        play.setFont(new Font("arial", 1, 20));
        //agregarNodo.setText(precio + "$");
        play.setForeground(Color.WHITE);
        play.setIcon(new ImageIcon(getClass().getResource("/Files/playBoton.png")));
        play.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  
                grapher.anim = false;
                grapher.anim2 = false;
                grapher.Route = null;
                grapher.rt = 0;

                if (pause == false) {
                    play.setIcon(new ImageIcon(getClass().getResource("/Files/pauseBoton.png")));
                    play.setBackground(Color.GREEN);
                    try {
                        int n = 0;
                        for (int j = 0; j < Grapher.GraphicNodes.size(); j++) {
                            if (Grapher.GraphicNodes.get(j) == grapher.NodoInicial) {
                                n = j;
                                break;
                            }
                        }
                        DFS dfs = new DFS(Grapher.GraphicNodes, grapher, n);
                        ArrayList<GraphicVector> Route = dfs.DFS_Route();
                        Visualizer.setText("<html><p style=\"width:139px\">");
                        if (Grapher.GraphicVectors != null) {
                            for (int j = 0; j < Grapher.GraphicVectors.size(); j++) {
                                grapher.Route = Route;
                                grapher.anim2 = false;
                                grapher.anim = true;
                                break;
                            }
                            ////System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        }
                        for (int i = 0; i < Route.size(); i++) {
                            //System.out.println(Route.get(i).getNodeA().getName() + "-" + Route.get(i).getNodeB().getName());
                        }
                    } catch (Exception g) {

                    }

                    pause = true;
                } else {
                    play.setIcon(new ImageIcon(getClass().getResource("/Files/playBoton.png")));
                    play.setBackground(Color.BLACK);
                    pause = false;

                    play2.setIcon(new ImageIcon(getClass().getResource("/Files/playBoton.png")));
                    play2.setBackground(Color.BLACK);
                    pause2 = false;
                    for (int l = 0; l < Grapher.GraphicNodes.size(); l++) {
                        Grapher.GraphicNodes.get(l).setState(0);
                    }

                }
                //Visualizer.setText(Visualizer.getText()+"perro ");
            }

        });

        //Componentes Recorrido BFS
        CancelinfoRecorrido2.setLayout(null);
        infoRecorrido2.add(CancelinfoRecorrido2);
        CancelinfoRecorrido2.setBounds(173, 0, 25, 25);
        CancelinfoRecorrido2.setOpaque(false);
        CancelinfoRecorrido2.setBackground(Color.RED); //cambia color fondo jlabel
        CancelinfoRecorrido2.setFont(new Font("arial", 1, 20));
        //agregarNodo.setText(precio + "$");
        CancelinfoRecorrido2.setForeground(Color.BLACK);
        CancelinfoRecorrido2.setIcon(new ImageIcon(getClass().getResource("/Files/cancelEjec.png")));
        CancelinfoRecorrido2.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseEntered(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                CancelinfoRecorrido2.setIcon(new ImageIcon(getClass().getResource("/Files/cancelOscuro.png")));
            }
        });
        CancelinfoRecorrido2.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mouseExited(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK      

                CancelinfoRecorrido2.setIcon(new ImageIcon(getClass().getResource("/Files/cancelEjec.png")));
            }
        });
        CancelinfoRecorrido2.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  

                infoRecorrido2.setVisible(false);
                scroll2.setVisible(false);
                tipoEjecucion = 0;
                botonBFS.setIcon(new ImageIcon(getClass().getResource("/Files/botonBFS.png")));
            }

        });

        TituloNodoI2.setLayout(null);
        infoRecorrido2.add(TituloNodoI2);
        TituloNodoI2.setBounds(29, 10, 130, 30);
        TituloNodoI2.setOpaque(false);
        TituloNodoI2.setBackground(Color.BLACK); //cambia color fondo jlabel
        TituloNodoI2.setFont(new Font("arial", 1, 18));
        //tituloNodo.setText(precio + "$");
        TituloNodoI2.setIcon(new ImageIcon(getClass().getResource("/Files/tituloEjec.png")));
        TituloNodoI2.setForeground(Color.BLACK);

        NombreNodoI2.setLayout(null);
        infoRecorrido2.add(NombreNodoI2);
        NombreNodoI2.setBounds(29, 40, 130, 30);
        NombreNodoI2.setOpaque(true);
        NombreNodoI2.setFont(new Font("arial", 1, 18));
        NombreNodoI2.setBackground(new Color(56, 58, 62));
        NombreNodoI2.setHorizontalAlignment(JTextField.CENTER);
        NombreNodoI2.setBorder(BorderFactory.createLineBorder(new Color(93, 105, 100)));
        //tituloNodo.setText(precio + "$");
        NombreNodoI2.setForeground(Color.WHITE);

        play2.setLayout(null);
        infoRecorrido2.add(play2);
        play2.setBounds(79, 85, 40, 40);
        play2.setOpaque(false);
        play2.setBackground(Color.BLACK); //cambia color fondo jlabel
        play2.setFont(new Font("arial", 1, 20));
        //agregarNodo.setText(precio + "$");
        play2.setForeground(Color.WHITE);
        play2.setIcon(new ImageIcon(getClass().getResource("/Files/playBoton.png")));
        play2.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  
                grapher.anim = false;
                grapher.anim2 = false;
                grapher.Route = null;
                grapher.rt = 0;

                if (pause2 == false) {
                    play2.setIcon(new ImageIcon(getClass().getResource("/Files/pauseBoton.png")));
                    play2.setBackground(Color.GREEN);
                    try {
                        int n = 0;
                        for (int j = 0; j < Grapher.GraphicNodes.size(); j++) {
                            if (Grapher.GraphicNodes.get(j) == grapher.NodoInicial) {
                                n = j;
                                break;
                            }
                        }
                        BFS bfs = new BFS(Grapher.GraphicNodes, grapher, n);
                        ArrayList<GraphicVector> Route = bfs.BFS_Route();
                        Visualizer2.setText("<html><p style=\"width:139px\">");
                        if (Grapher.GraphicVectors != null) {
                            for (int j = 0; j < Grapher.GraphicVectors.size(); j++) {
                                grapher.Route = Route;
                                grapher.anim2 = false;
                                grapher.anim = true;
                                break;
                            }
                            ////System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        }
                        for (int i = 0; i < Route.size(); i++) {
                            //System.out.println(Route.get(i).getNodeA().getName() + "-" + Route.get(i).getNodeB().getName());
                        }
                        //Kruskal krus = new Kruskal(grapher.GraphicNodes, grapher);
                    } catch (Exception g) {

                    }

                    pause2 = true;
                } else {
                    play2.setIcon(new ImageIcon(getClass().getResource("/Files/playBoton.png")));
                    play2.setBackground(Color.BLACK);
                    pause2 = false;
                    play.setIcon(new ImageIcon(getClass().getResource("/Files/playBoton.png")));
                    play.setBackground(Color.BLACK);
                    pause = false;
                    for (int l = 0; l < Grapher.GraphicNodes.size(); l++) {
                        Grapher.GraphicNodes.get(l).setState(0);
                    }
                }
                //Visualizer2.setText(Visualizer2.getText()+"perro ");
            }

        });

        Visualizer.setLayout(null);
        Visualizer.setAutoscrolls(true);
        scroll.setViewportView(Visualizer);
        //scroll.add(Visualizer);
        Visualizer.setBounds(9, 13, 180, 120);
        Visualizer.setOpaque(true);
        Visualizer.setBackground(new Color(35, 37, 43)); //cambia color fondo jlabel
        Visualizer.setFont(new Font("century gothic", 1, 16));
        //agregarNodo.setText(precio + "$");
        Visualizer.setForeground(new Color(173, 174, 176));
        Visualizer.setText("<html><p style=\"width:125px\">");
        Visualizer.setVerticalAlignment(SwingConstants.TOP);
        //agregarNodo.setIcon(new ImageIcon(getClass().getResource("/recursos/borrar2.png")));
        Visualizer.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  

            }

        });

        Visualizer2.setLayout(null);
        Visualizer2.setAutoscrolls(true);
        scroll2.setViewportView(Visualizer2);
        //scroll.add(Visualizer);
        Visualizer2.setBounds(9, 13, 180, 120);
        Visualizer2.setOpaque(true);
        Visualizer2.setBackground(new Color(35, 37, 43)); //cambia color fondo jlabel
        Visualizer2.setFont(new Font("century gothic", 1, 16));
        //agregarNodo.setText(precio + "$");
        Visualizer2.setForeground(new Color(173, 174, 176));
        Visualizer2.setText("<html><p style=\"width:125px\">");
        Visualizer2.setVerticalAlignment(SwingConstants.TOP);
        //agregarNodo.setIcon(new ImageIcon(getClass().getResource("/recursos/borrar2.png")));
        Visualizer2.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK  

            }

        });

        //js.setPreferredSize(new Dimension(100, 100));
        //Boton Creacion - Ejecucion
        BotonP.setLayout(null);
        //edicionNodo.add(  CancelarVector);
        modo.add(BotonP);
        //      CancelarVector.setBounds(159, 35, 30, 30);
        BotonP.setBounds(44, 34, 110, 40);
        BotonP.setOpaque(false);
        BotonP.setBackground(Color.GREEN); //cambia color fondo jlabel
        BotonP.setFont(new Font("arial", 1, 20));
        //     CancelarVector.setText(precio + "$");
        BotonP.setForeground(Color.BLACK);
        BotonP.setIcon(new ImageIcon(getClass().getResource("/Files/Modo.png")));
        BotonP.addMouseListener(new MouseAdapter() { //CREO CONSTRUCTOR CONSULTA LABEL
            @Override
            public void mousePressed(MouseEvent e) {  //PARA PODER ACCIONAR EL CLICK 
                grapher.anim = false;
                grapher.anim2 = false;
                grapher.Route = null;
                grapher.rt = 0;
                Visualizer.setText("<html><p style=\"width:139px\">");
                Visualizer2.setText("<html><p style=\"width:139px\">");

                if (BotonPaccion == false) {
                    grapher.APS_Loop = true;
                    BotonP.setIcon(new ImageIcon(getClass().getResource("/Files/Modo1.png")));
                    vector_nodo.setVisible(false);
                    edicionNodo.setVisible(false);
                    edicionVector.setVisible(false);
                    BotonPaccion = true;
                    panelRecorrido.setVisible(true);
                    for (int l = 0; l < Grapher.GraphicNodes.size(); l++) {
                        Grapher.GraphicNodes.get(l).setState(0);
                    }
                    grapher.APS_Loop = true;
                    botonBFS.setIcon(new ImageIcon(getClass().getResource("/Files/botonBFS.png")));
                    botonDFS.setIcon(new ImageIcon(getClass().getResource("/Files/botonDFS.png")));
                    botonMin.setIcon(new ImageIcon(getClass().getResource("/Files/mincosto.png")));

                } else {
                    grapher.APS_Loop = false;
                    BotonP.setIcon(new ImageIcon(getClass().getResource("/Files/Modo.png")));
                    if (focoNodoVector == true) {
                        vector_nodo.setVisible(true);
                        edicionNodo.setVisible(true);

                        edicionVector.setVisible(false);
                        panelRecorrido.setVisible(false);
                        infoRecorrido.setVisible(false);
                        infoRecorrido2.setVisible(false);
                        scroll.setVisible(false);
                        scroll2.setVisible(false);

                    } else {

                        vector_nodo.setVisible(true);
                        edicionNodo.setVisible(false);
                        edicionVector.setVisible(true);

                        panelRecorrido.setVisible(false);
                        infoRecorrido.setVisible(false);
                        infoRecorrido2.setVisible(false);
                        scroll.setVisible(false);
                        scroll2.setVisible(false);

                    }
                    BotonPaccion = false;
                }
                try {
                    grapher.NodoInicial = Grapher.GraphicNodes.get(0);
                    NombreNodoI.setText(Grapher.GraphicNodes.get(0).getName());
                    NombreNodoI2.setText(Grapher.GraphicNodes.get(0).getName());
                } catch (Exception g) {

                }

                tipoEjecucion = 0;
            }

        });

    }

    
}
