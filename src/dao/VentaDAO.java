/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.ConexionBD;
import modelo.Venta;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {
    public boolean guardarVenta(Venta venta) {

    Connection conn = ConexionBD.conectar();

    if (conn == null) {
        return false;
    }

    String sql = "INSERT INTO ventas (precio, costo, cantidad, total, ganancia, fecha) VALUES (?, ?, ?, ?, ?, ?)";

    try {

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDouble(1, venta.getPrecio());
        pstmt.setDouble(2, venta.getCosto());
        pstmt.setInt(3, venta.getCantidad());
        pstmt.setDouble(4, venta.getTotal());
        pstmt.setDouble(5, venta.getGanancia());
        pstmt.setDate(6, Date.valueOf(venta.getFecha()));
        pstmt.executeUpdate();
        return true;

    } catch (Exception e) {
        System.out.println("Error al guardar venta: " + e.getMessage());
        return false;
    }
}


    public double obtenerTotalVentas() {
        String sql = "SELECT SUM(total) FROM ventas";
        double total = 0;

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                total = rs.getDouble(1);
            }

        } catch (Exception e) {
            System.out.println("Error al consultar total ventas: " + e.getMessage());
        }

        return total;
    }

    public double obtenerTotalGanancias() {
        String sql = "SELECT SUM(ganancia) FROM ventas";
        double total = 0;

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                total = rs.getDouble(1);
            }

        } catch (Exception e) {
            System.out.println("Error al consultar total ganancias: " + e.getMessage());
        }

        return total;
    }
    public List<Object[]> obtenerVentas() {

    List<Object[]> listaVentas = new ArrayList<>();

    String sql = "SELECT id, fecha, precio, costo, cantidad, total, ganancia FROM ventas";

    try (Connection con = ConexionBD.conectar();
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {

            Object[] fila = new Object[7];

            fila[0] = rs.getInt("id");
            fila[1] = rs.getDate("fecha").toLocalDate();
            fila[2] = rs.getDouble("precio");
            fila[3] = rs.getDouble("costo");
            fila[4] = rs.getInt("cantidad");
            fila[5] = rs.getDouble("total");
            fila[6] = rs.getDouble("ganancia");

            listaVentas.add(fila);
        }

    } catch (Exception e) {
        System.out.println("Error al obtener historial: " + e.getMessage());
    }

    return listaVentas;
}
    public boolean eliminarVenta(int id) {

    String sql = "DELETE FROM ventas WHERE id = ?";

    try (Connection con = ConexionBD.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id);
        ps.executeUpdate();
        return true;

    } catch (Exception e) {
        System.out.println("Error al eliminar venta: " + e.getMessage());
        return false;
    }
    }
    
    public boolean eliminarTodas() {

    String sql = "DELETE FROM ventas";

    try (Connection con = ConexionBD.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.executeUpdate();
        return true;

    } catch (Exception e) {
        System.out.println("Error al eliminar todas las ventas: " + e.getMessage());
        return false;
    }
}
    public boolean actualizarVenta(Venta venta) {

    String sql = "UPDATE ventas SET precio = ?, costo = ?, cantidad = ? WHERE id = ?";

    try (Connection con = ConexionBD.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setDouble(1, venta.getPrecio());
        ps.setDouble(2, venta.getCosto());
        ps.setInt(3, venta.getCantidad());
        ps.setInt(4, venta.getId());

        ps.executeUpdate();
        return true;

    } catch (Exception e) {
        System.out.println("Error al actualizar venta: " + e.getMessage());
        return false;
    }
}


}
