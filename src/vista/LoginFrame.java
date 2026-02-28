/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import modelo.Usuario;
import dao.UsuarioDAO;
import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame{
    private JTextField txtUser;
    private JPasswordField txtPassword;

    public LoginFrame() {

        setTitle("Login");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3,2,5,5));

        panel.add(new JLabel("Usuario:"));
        txtUser = new JTextField();
        panel.add(txtUser);

        panel.add(new JLabel("Contraseña:"));
        txtPassword = new JPasswordField();
        panel.add(txtPassword);

        JButton btnLogin = new JButton("Iniciar sesión");
        panel.add(new JLabel());
        panel.add(btnLogin);

        add(panel);

        btnLogin.addActionListener(e -> login());

        setVisible(true);
    }

    private void login() {

        String user = txtUser.getText();
        String pass = new String(txtPassword.getPassword());

        Usuario usuario = new Usuario(user, pass);
        UsuarioDAO dao = new UsuarioDAO();

        if (dao.validarLogin(usuario)) {
            JOptionPane.showMessageDialog(this, "Bienvenido " + user);
            dispose();
            VentanaPrincipal vp = new VentanaPrincipal();
            vp.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
        }
    }
}
