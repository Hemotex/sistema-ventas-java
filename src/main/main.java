/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import vista.VentanaPrincipal;

public class main {
  public static void main(String[] args) {
      System.out.println("Sistema actualizado 2026");
      try {
           for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               if ("Nimbus".equals(info.getName())) {
                   javax.swing.UIManager.setLookAndFeel(info.getClassName());
                   break;
                }
            }
      } catch (Exception e) {
        System.out.println("No se pudo aplicar Nimbus");
}

        new VentanaPrincipal().setVisible(true);
    }  
}
