/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaAdmin;
import dao.UsuarioDAO;
import modelo.Usuario;

public class LoginFrame extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginFrame() {
        setTitle("Login");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        initComponents();
        
    }
    private void login() {

        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.autenticar(username, password);

        if (usuario != null) {

            JOptionPane.showMessageDialog(this, "Bienvenido " + usuario.getUsername());

            dispose();

        if (usuario.getRol().equalsIgnoreCase("ADMIN")) {

            new VentanaAdmin(usuario).setVisible(true);

        } else if (usuario.getRol().equalsIgnoreCase("VENDEDOR")) {

            new VentanaPrincipal(usuario).setVisible(true);

        }

        } else {

            JOptionPane.showMessageDialog(this, "Credenciales incorrectas");

        }
    }
    private void initComponents() {

        JLabel lblUsername = new JLabel("Usuario:");
        lblUsername.setBounds(30, 30, 80, 25);
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(120, 30, 150, 25);
        add(txtUsername);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(30, 70, 80, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(120, 70, 150, 25);
        add(txtPassword);

        btnLogin = new JButton("Iniciar sesión");
        btnLogin.setBounds(100, 110, 130, 30);
        add(btnLogin);

        // Evento del botón
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
}
}