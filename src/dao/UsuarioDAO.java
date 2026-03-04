/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Usuario;
import conexion.ConexionBD; // Ajusta si tu clase se llama diferente
public class UsuarioDAO {
    public Usuario autenticar(String username, String password) {
    
    Usuario usuario = null;
    
    String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
    
    try (Connection con = ConexionBD.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, username);
        ps.setString(2, password);
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setUsername(rs.getString("username"));
            usuario.setPassword(rs.getString("password"));
            usuario.setRol(rs.getString("rol"));
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return usuario;
}
}
