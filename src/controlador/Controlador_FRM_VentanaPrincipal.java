/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.MetodosPrestamo;
import vista.FRM_VentanaPrincipal;

/**
 *
 * @author RandyGUTI
 */
public class Controlador_FRM_VentanaPrincipal implements ActionListener{

    public MetodosPrestamo metodos;
    FRM_VentanaPrincipal frm_VentanaPrincipal;
    
    public Controlador_FRM_VentanaPrincipal(FRM_VentanaPrincipal frm_VentanaPrincipal) 
    {
       metodos=new MetodosPrestamo();
       this.frm_VentanaPrincipal=frm_VentanaPrincipal;
    }
    public void actionPerformed(ActionEvent e)
    {
      if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("ConsultaRapida") )
      {
        consultar();
      }
      if(e.getActionCommand().equals("Agregar"))
      {
         metodos.agregarPrestamo(frm_VentanaPrincipal.devolverInformacion());
         frm_VentanaPrincipal.mostrarMensaje("El préstamo del libro se realizó con éxito");
         frm_VentanaPrincipal.resetearGUI();
      }
      if(e.getActionCommand().equals("Modificar"))
      {
         metodos.modificarPrestamo(frm_VentanaPrincipal.devolverInformacion());
         frm_VentanaPrincipal.mostrarMensaje("Se ha modificado el préstamo con éxito");
         frm_VentanaPrincipal.resetearGUI();
      }
      if(e.getActionCommand().equals("Eliminar"))
      {
         metodos.eliminarPrestamo(frm_VentanaPrincipal.devolverInformacion());
         frm_VentanaPrincipal.mostrarMensaje("Se ha eliminado el préstamo con éxito");
         frm_VentanaPrincipal.resetearGUI();
      }
    }
    public void consultar()
    {
      if(metodos.consultarPrestamo(frm_VentanaPrincipal.devolverNumeroPrestamo()))
      {
        frm_VentanaPrincipal.mostrarInformacion(metodos.getArregloInformacion());
        frm_VentanaPrincipal.habilitarEdicion();
      }
      else
      {
        frm_VentanaPrincipal.mostrarMensaje("El numero de prestamo no está registrado, PUEDE UTILIZARLO");
        frm_VentanaPrincipal.habilitarAgregar();
      }
    }
}
