import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class VentanaVideojuego extends JFrame {
    private JLabel lblid;
    private JLabel lblNombre;
    private JLabel lblGenero;
    private JLabel lblPeso;
    private JLabel lblPlataforma;
    private JLabel lblDesarrollador;

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtGenero;
    private JTextField txtPeso;
    private JTextField txtPlataforma;
    private JTextField txtDesarrollador;

    private JButton boton;
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private ModeloTabla modelo;
    private ArrayList<Videojuego> info;
    private JScrollPane scroll;
    private JTable tabla;

    public VentanaVideojuego(String title) throws HeadlessException {
    this.setSize(500,700);


    layout = new GridLayout(2,1);
    this.setLayout(layout);

    //panel1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(0x39B3CE));

        lblid = new JLabel("Id:");
        txtId = new JTextField(4);
        panel1.add(lblid);
        panel1.add(txtId);

        lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(30);
        panel1.add(lblNombre);
        panel1.add(txtNombre);

        lblGenero = new JLabel("Genero:");
        txtGenero = new JTextField(15);
        panel1.add(lblGenero);
        panel1.add(txtGenero);

        lblPeso = new JLabel("Peso (Gb):");
        txtPeso = new JTextField(6);
        panel1.add(lblPeso);
        panel1.add(txtPeso);

        lblPlataforma = new JLabel("Plataforma:");
        txtPlataforma = new JTextField(15);
        panel1.add(lblPlataforma);
        panel1.add(txtPlataforma);

        lblDesarrollador = new JLabel("Desarrollador:");
        txtDesarrollador = new JTextField(25);
        panel1.add(lblDesarrollador);
        panel1.add(txtDesarrollador);

        boton = new JButton("Agregar juego");
        panel1.add(boton);

    this.getContentPane().add(panel1);

    //panel2
        panel2 = new JPanel((new FlowLayout()));
        panel2.setBackground(new Color(0x9E30BB));

        info= new ArrayList<>();
        info.add(new Videojuego(1,
                "League of Legend",
                "MOBA", 4.5,
                "Windows y Mac",
                "Riot Games"));
        modelo = new ModeloTabla(info);
        tabla = new JTable(modelo);
        scroll = new JScrollPane(tabla);
        panel2.add(scroll);




        this.getContentPane().add(panel2);


    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.boton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            Videojuego nuevo = new Videojuego();
            nuevo.setId(Integer.parseInt(txtId.getText()));
            nuevo.setNombre(txtNombre.getText());
            nuevo.setGenero(txtGenero.getText());
            nuevo.setPeroEnGb(Double.parseDouble(txtPeso.getText()));
            nuevo.setPlataforma(txtPlataforma.getText());
            nuevo.setDesarrollador(txtDesarrollador.getText());
            //info.add(nuevo);
            modelo.agregarJuego(nuevo);
            tabla.updateUI();
        }
    });
    }
}
