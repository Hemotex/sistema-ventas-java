/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import modelo.Usuario;
import dao.VentaDAO;

public class VentanaAdmin extends javax.swing.JFrame {

    private Usuario usuario;

    public VentanaAdmin(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        mostrarAdmin();
        cargarEstadisticas();
    }

    private void mostrarAdmin(){
        lblAdmin.setText("Administrador: " + usuario.getUsername());
    }

    private void cargarEstadisticas(){

        VentaDAO ventaDAO = new VentaDAO();

        double totalVentas = ventaDAO.obtenerTotalVentas();
        double totalGanancias = ventaDAO.obtenerTotalGanancias();

        lblVentas.setText("Total Ventas: $" + totalVentas);
        lblGanancias.setText("Total Ganancias: $" + totalGanancias);
    }

    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblAdmin = new javax.swing.JLabel();
        lblVentas = new javax.swing.JLabel();
        lblGanancias = new javax.swing.JLabel();

        btnUsuarios = new javax.swing.JButton();
        
        btnUsuarios.addActionListener(evt -> {

            javax.swing.JOptionPane.showMessageDialog(
            this,
            "Aquí irá la gestión de usuarios."
            );
        });
        
        btnVerVentas = new javax.swing.JButton();
        btnVerVentas.addActionListener(evt -> {

            new VentanaPrincipal(usuario).setVisible(true);
            dispose();
        });
        
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Panel de Administración");

        lblTitulo.setText("PANEL DE ADMINISTRACIÓN");
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18));

        btnUsuarios.setText("Gestión de Usuarios");
        btnVerVentas.setText("Ver Ventas");
        btnCerrar.setText("Cerrar");

        btnCerrar.addActionListener(evt -> dispose());

        setLayout(new java.awt.GridLayout(7,1,10,10));

        add(lblTitulo);
        add(lblAdmin);
        add(lblVentas);
        add(lblGanancias);
        add(btnUsuarios);
        add(btnVerVentas);
        add(btnCerrar);

        setSize(350,400);
        setLocationRelativeTo(null);
    }

    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblVentas;
    private javax.swing.JLabel lblGanancias;

    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton btnVerVentas;
    private javax.swing.JButton btnCerrar;
}

   
