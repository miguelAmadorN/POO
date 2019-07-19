
import javax.swing.JOptionPane;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MicroPhotoshop extends JFrame implements ActionListener, ChangeListener {

    int opc_slider;
    ImageIcon Imag_Select, otro_Icono;
    JLabel Imagen_Original, Imagen_Modificada;
    JTextField Name_Imagen;
    BufferedImage Ima_in_memo;
    JButton save, select, warhol, rgb_gbr, seg1, seg2, post, shane, white_black, cuart, neg, red, green, blue, gray, sepia;
    BufferedImage imagen;
    JPanel effect;
    JSlider slider_p;
    Filtros f = new Filtros();

    public MicroPhotoshop() {
        super("MICRO-PHOTOSHOP");

        JPanel pprincipal = new JPanel();
        pprincipal.setLayout(new BorderLayout());
        //-------------------->PANEL DE DATOS PERSONALES<--------------------------------------//
        JLabel Nombre1 = new JLabel("MIGUEL ANGEL AMADOR NAVA");
        Nombre1.setForeground(Color.white);
        JLabel Nombre2 = new JLabel("POO");
        Nombre2.setForeground(Color.white);
        JLabel Grupo = new JLabel("2CM8");
        Grupo.setForeground(Color.white);
        JPanel N_G = new JPanel();
        N_G.setLayout(new BorderLayout());
        N_G.add(Nombre1, BorderLayout.NORTH);
        N_G.add(Nombre2, BorderLayout.CENTER);
        N_G.add(Grupo, BorderLayout.SOUTH);

        JPanel ptitulo = new JPanel();
        ptitulo.setLayout(new BorderLayout());
        JLabel ltitulo = new JLabel("MICRO-PHOTOSHOP");
        ltitulo.setFont(new java.awt.Font("Arial Black", 0, 35));
        ltitulo.setForeground(Color.white);
        ptitulo.add(ltitulo, BorderLayout.CENTER);

        effect = new JPanel(new GridLayout(7, 2, 1, 1));
        sepia = new JButton("SEPIA");
        sepia.setBackground(Color.BLACK);
        sepia.setForeground(Color.white);
        sepia.setFont(new java.awt.Font("Cooper Black", 0, 13));

        gray = new JButton("ESCALA DE GRISES");
        gray.setBackground(Color.BLACK);
        gray.setForeground(Color.white);
        gray.setFont(new java.awt.Font("Cooper Black", 0, 13));

        blue = new JButton("AZUL");
        blue.setBackground(Color.BLACK);
        blue.setForeground(Color.white);
        blue.setFont(new java.awt.Font("Cooper Black", 0, 13));

        green = new JButton("VERDE");
        green.setBackground(Color.BLACK);
        green.setForeground(Color.white);
        green.setFont(new java.awt.Font("Cooper Black", 0, 13));

        red = new JButton("ROJO");
        red.setBackground(Color.BLACK);
        red.setForeground(Color.white);
        red.setFont(new java.awt.Font("Cooper Black", 0, 13));

        neg = new JButton("NEGATIVO");
        neg.setBackground(Color.BLACK);
        neg.setForeground(Color.white);
        neg.setFont(new java.awt.Font("Cooper Black", 0, 13));

        cuart = new JButton("CUARTEAR");
        cuart.setBackground(Color.BLACK);
        cuart.setForeground(Color.white);
        cuart.setFont(new java.awt.Font("Cooper Black", 0, 13));

        white_black = new JButton("BLANCO Y NEGRO");
        white_black.setBackground(Color.BLACK);
        white_black.setForeground(Color.white);
        white_black.setFont(new java.awt.Font("Cooper Black", 0, 13));

        shane = new JButton("BRILLO");
        shane.setBackground(Color.BLACK);
        shane.setForeground(Color.white);
        shane.setFont(new java.awt.Font("Cooper Black", 0, 13));

        post = new JButton("POSTERIZAR");
        post.setBackground(Color.BLACK);
        post.setForeground(Color.white);
        post.setFont(new java.awt.Font("Cooper Black", 0, 13));

        seg1 = new JButton("SEGMENTACION");
        seg1.setBackground(Color.BLACK);
        seg1.setForeground(Color.white);
        seg1.setFont(new java.awt.Font("Cooper Black", 0, 13));

        seg2 = new JButton("DE RGB A RBG");
        seg2.setBackground(Color.BLACK);
        seg2.setForeground(Color.white);
        seg2.setFont(new java.awt.Font("Cooper Black", 0, 13));

        rgb_gbr = new JButton("DE RGB A GBR");
        rgb_gbr.setBackground(Color.BLACK);
        rgb_gbr.setForeground(Color.white);
        rgb_gbr.setFont(new java.awt.Font("Cooper Black", 0, 13));

        warhol = new JButton("WARHOL");
        warhol.setBackground(Color.BLACK);
        warhol.setForeground(Color.white);
        warhol.setFont(new java.awt.Font("Cooper Black", 0, 13));

        effect.add(sepia);
        effect.add(blue);
        effect.add(green);
        effect.add(red);
        effect.add(neg);
        effect.add(cuart);
        effect.add(white_black);
        effect.add(gray);
        effect.add(shane);
        effect.add(post);
        effect.add(seg1);
        effect.add(seg2);
        effect.add(rgb_gbr);
        effect.add(warhol);

        JPanel pimagenes = new JPanel(new BorderLayout());
        JSplitPane split = new JSplitPane();
        split.setResizeWeight(0.5);//las dos divisiones
        JPanel pimagenoriginal = new JPanel();
        Imagen_Original = new JLabel();

        pimagenoriginal.add(Imagen_Original);
        JScrollPane spimgoriginal = new JScrollPane(pimagenoriginal);
        spimgoriginal.setBackground(Color.BLACK);
        spimgoriginal.setForeground(Color.BLACK);

        split.setLeftComponent(spimgoriginal);
        JPanel pimagengrises = new JPanel();
        Imagen_Modificada = new JLabel();
        pimagengrises.add(Imagen_Modificada);
        JScrollPane spimggrises = new JScrollPane(pimagengrises);
        split.setRightComponent(spimggrises);

        pimagenes.add(split);

        JPanel pselector = new JPanel();
        Name_Imagen = new JTextField(30);
        select = new JButton("IMPORTAR IMAGEN");
        select.setBackground(Color.white);
        select.setForeground(Color.BLACK);

        save = new JButton("GUARDAR");
        save.setBackground(Color.white);
        save.setForeground(Color.BLACK);

        select.addActionListener(this);
        sepia.addActionListener(this);
        save.addActionListener(this);
        gray.addActionListener(this);
        blue.addActionListener(this);
        green.addActionListener(this);
        red.addActionListener(this);
        neg.addActionListener(this);
        cuart.addActionListener(this);
        white_black.addActionListener(this);
        shane.addActionListener(this);
        post.addActionListener(this);
        seg1.addActionListener(this);
        seg2.addActionListener(this);
        rgb_gbr.addActionListener(this);
        warhol.addActionListener(this);
        pselector.add(Name_Imagen);
        pselector.add(select);
        pselector.add(save);

        JPanel pescalar = new JPanel();
        pescalar.setLayout(new BoxLayout(pescalar, BoxLayout.Y_AXIS));
        slider_p = new JSlider(0, 250);//public JSlider(int orientation, int min,int max,int value)
        slider_p.setValue(5);//valor por default
        slider_p.setOrientation(SwingConstants.HORIZONTAL);
        slider_p.setPaintTicks(true);
        slider_p.addChangeListener(this);
        slider_p.setMajorTickSpacing(25); // de cuanto en cuanto los nmeros en el slider
        slider_p.setMinorTickSpacing(5); //las rayitas de cuanto en cuanto
        slider_p.setPaintLabels(true);
        slider_p.setBackground(Color.BLACK);
        slider_p.setForeground(Color.white);
        pescalar.add(slider_p);

        pimagenoriginal.setBackground(Color.white);
        pimagengrises.setBackground(Color.white);
        pprincipal.setBackground(Color.BLACK);
        ptitulo.setBackground(Color.BLACK);
        pimagenes.setBackground(Color.BLACK);
        pselector.setBackground(Color.BLACK);
        pescalar.setBackground(Color.BLACK);
        effect.setBackground(Color.BLACK);
        N_G.setBackground(Color.BLACK);

        ptitulo.add(N_G, BorderLayout.EAST);
        pprincipal.add(ptitulo, BorderLayout.NORTH);
        pprincipal.add(pimagenes, BorderLayout.CENTER);
        pprincipal.add(pselector, BorderLayout.SOUTH);
        pprincipal.add(effect, BorderLayout.WEST);
        add(pprincipal);

        pimagenes.add(pescalar, BorderLayout.NORTH);

        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0, 0, 1300, 700);
        setLocationRelativeTo(null);
    }

    public void stateChanged(ChangeEvent arg0) {

        if (opc_slider == 1) {
            Image img = new ImageIcon(f.aplicarFiltroGrises(
                    Ima_in_memo, slider_p.getValue())).getImage(); //convertimos icon en una imagen

            if (img != null) {
                Image otraimg = img.getScaledInstance(600, 650, java.awt.Image.SCALE_SMOOTH); //creamos una imagen nueva dndole las dimensiones que queramos a la antigua
                ImageIcon otro_Icono = new ImageIcon(otraimg);
                Imagen_Modificada.setIcon(otro_Icono);
            }

        }
        if (opc_slider == 2) {
            Image img = new ImageIcon(f.aplicarFiltroBrillo(
                    Ima_in_memo, slider_p.getValue())).getImage(); //convertimos icon en una imagen

            if (img != null) {
                Image otraimg = img.getScaledInstance(600, 650, java.awt.Image.SCALE_SMOOTH); //creamos una imagen nueva dndole las dimensiones que queramos a la antigua
                ImageIcon otro_Icono = new ImageIcon(otraimg);
                Imagen_Modificada.setIcon(otro_Icono);
            }
        }
        if (opc_slider == 3) {
            Image img = new ImageIcon(f.aplicarFiltroPos(
                    Ima_in_memo, slider_p.getValue())).getImage(); //convertimos icon en una imagen

            if (img != null) {
                Image otraimg = img.getScaledInstance(600, 650, java.awt.Image.SCALE_SMOOTH); //creamos una imagen nueva dndole las dimensiones que queramos a la antigua
                ImageIcon otro_Icono = new ImageIcon(otraimg);
                Imagen_Modificada.setIcon(otro_Icono);
            }
        }
    }

    public void actionPerformed(ActionEvent ee) {
        JButton x = (JButton) ee.getSource();
        JFileChooser selector = new JFileChooser("C:/Users/Miguel/Pictures");
        opc_slider = 0;
        if (x == select) {
            int r = selector.showOpenDialog(null);
            if (r == JFileChooser.APPROVE_OPTION) {
                try {
                    Ima_in_memo = ImageIO.read(selector.getSelectedFile());
                    Imag_Select = new ImageIcon(Ima_in_memo);
                    Image img = Imag_Select.getImage(); //convertimos icon en una imagen
                    Image otraimg = img.getScaledInstance(
                            600, 650, java.awt.Image.SCALE_SMOOTH); //creamos una imagen nueva dndole las dimensiones que queramos a la antigua
                    ImageIcon otro_Icono = new ImageIcon(otraimg);
                    Imagen_Original.setIcon(otro_Icono);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (x == save) {
            Image source = otro_Icono.getImage();
            int w = source.getWidth(null);
            int h = source.getHeight(null);
            BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = (Graphics2D) image.getGraphics();
            g2d.drawImage(source, 0, 0, null);
            g2d.dispose();

            int s = selector.showSaveDialog(null);

            if (s == JFileChooser.APPROVE_OPTION) {
                File archivo = selector.getSelectedFile();

                try {
                    ImageIO.write(image, "jpg", archivo);
                    JOptionPane.showMessageDialog(null, "Imagen guardada exitosamente");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (x == sepia) {
            Image img = new ImageIcon(f.aplicarFiltroSepia(Ima_in_memo)).getImage(); //convertimos icon en una imagen
            Image otraimg = img.getScaledInstance(600, 650, java.awt.Image.SCALE_SMOOTH); //creamos una imagen nueva dndole las dimensiones que queramos a la antigua
            otro_Icono = new ImageIcon(otraimg);
            Imagen_Modificada.setIcon(otro_Icono);
            Name_Imagen.setText(selector.getSelectedFile().getName());
        }  else if (x == white_black) {
            JOptionPane.showMessageDialog(null, "Slider adaptado a blanco y negro");
            opc_slider = 1;
        } else if (x == shane) {
            JOptionPane.showMessageDialog(null, "Slider adaptado al brillo");
            opc_slider = 2;
        } else if (x == post) {
            JOptionPane.showMessageDialog(null, "Slider adaptado al posterizado");
            opc_slider = 3;
        } else if (x == blue) {
            Image img = new ImageIcon(f.aplicarFiltroAzul(Ima_in_memo)).getImage();
            Image otraimg = img.getScaledInstance(600, 650, java.awt.Image.SCALE_SMOOTH);
            otro_Icono = new ImageIcon(otraimg);
            Imagen_Modificada.setIcon(otro_Icono);
            Name_Imagen.setText(selector.getSelectedFile().getName());
        } else if (x == green) {
            Image img = new ImageIcon(f.aplicarFiltroVerde(Ima_in_memo)).getImage();
            Image otraimg = img.getScaledInstance(600, 650, java.awt.Image.SCALE_SMOOTH);
            otro_Icono = new ImageIcon(otraimg);
            Imagen_Modificada.setIcon(otro_Icono);
            Name_Imagen.setText(selector.getSelectedFile().getName());
        } else if (x == red) {
            Image img = new ImageIcon(f.aplicarFiltroRojo(Ima_in_memo)).getImage();
            Image otraimg = img.getScaledInstance(600, 650, java.awt.Image.SCALE_SMOOTH);
            otro_Icono = new ImageIcon(otraimg);
            Imagen_Modificada.setIcon(otro_Icono);
            Name_Imagen.setText(selector.getSelectedFile().getName());
        } else if (x == neg) {
            Image img = new ImageIcon(f.aplicarFiltroNegativo(Ima_in_memo)).getImage();
            Image otraimg = img.getScaledInstance(600, 650, java.awt.Image.SCALE_SMOOTH);
            otro_Icono = new ImageIcon(otraimg);
            Imagen_Modificada.setIcon(otro_Icono);
            Name_Imagen.setText(selector.getSelectedFile().getName());
        } else if (x == cuart) {
            Image img = new ImageIcon(f.aplicarFiltroCuartear(Ima_in_memo)).getImage();
            Image otraimg = img.getScaledInstance(600, 650, java.awt.Image.SCALE_SMOOTH);
            otro_Icono = new ImageIcon(otraimg);
            Imagen_Modificada.setIcon(otro_Icono);
            Name_Imagen.setText(selector.getSelectedFile().getName());
        } else if (x == gray) {
            Image img = new ImageIcon(f.aplicarFiltroBN(Ima_in_memo)).getImage();
            Image otraimg = img.getScaledInstance(600, 650, java.awt.Image.SCALE_SMOOTH);
            otro_Icono = new ImageIcon(otraimg);
            Imagen_Modificada.setIcon(otro_Icono);
            Name_Imagen.setText(selector.getSelectedFile().getName());
        } else if (x == seg1) {
            Image img = new ImageIcon(f.aplicarFiltroSeg(Ima_in_memo)).getImage();
            Image otraimg = img.getScaledInstance(600, 650, java.awt.Image.SCALE_SMOOTH);
            otro_Icono = new ImageIcon(otraimg);
            Imagen_Modificada.setIcon(otro_Icono);
            Name_Imagen.setText(selector.getSelectedFile().getName());
        } else if (x == seg2) {
            Image img = new ImageIcon(f.aplicarFiltroRGBtoRBG(Ima_in_memo)).getImage();
            Image otraimg = img.getScaledInstance(600, 650, java.awt.Image.SCALE_SMOOTH);
            otro_Icono = new ImageIcon(otraimg);
            Imagen_Modificada.setIcon(otro_Icono);
            Name_Imagen.setText(selector.getSelectedFile().getName());
        } else if (x == rgb_gbr) {
            Image img = new ImageIcon(f.aplicarFiltroRGBtoGBR(Ima_in_memo)).getImage();
            Image otraimg = img.getScaledInstance(600, 650, java.awt.Image.SCALE_SMOOTH);
            otro_Icono = new ImageIcon(otraimg);
            Imagen_Modificada.setIcon(otro_Icono);
            Name_Imagen.setText(selector.getSelectedFile().getName());
        } else if (x == warhol) {
            int numero = Integer.parseInt(JOptionPane.showInputDialog(
                    null, "Introduzca un numero",
                    "Warhol",
                    JOptionPane.QUESTION_MESSAGE));

            Image img = new ImageIcon(f.aplicarFiltroWarhol(Ima_in_memo, numero)).getImage(); //convertimos icon en una imagen
            Image otraimg = img.getScaledInstance(600, 650, java.awt.Image.SCALE_SMOOTH); //creamos una imagen nueva dndole las dimensiones que queramos a la antigua
            otro_Icono = new ImageIcon(otraimg);
            Imagen_Modificada.setIcon(otro_Icono);
            Name_Imagen.setText(selector.getSelectedFile().getName());
        }
    }

    public static void main(String[] args) {
        new MicroPhotoshop();
    }

}
