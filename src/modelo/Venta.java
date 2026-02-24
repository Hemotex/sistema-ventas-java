/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;

public class Venta {
    private int id;
    private double precio;
    private double costo;
    private int cantidad;
    private LocalDate fecha;
    
    public Venta(double precio, double costo, int cantidad, LocalDate fecha) {
    this.precio = precio;
    this.costo = costo;
    this.cantidad = cantidad;
    this.fecha = fecha;
    }

    public Venta(int id, double precio, double costo, int cantidad, LocalDate fecha) {
        this.id = id;
        this.precio = precio;
        this.costo = costo;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getId() {
    return id;
    }   

    public double getTotal() {
        return precio * cantidad;
    }

    public double getGanancia() {
        return (precio - costo) * cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double getCosto() {
        return costo;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public LocalDate getFecha() {
    return fecha;
    }
}
