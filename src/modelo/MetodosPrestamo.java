/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author RandyGUTI
 */
public class MetodosPrestamo {
    
    private ArrayList<Prestamo> arrayPrestamos;
    String[] arregloInformacionConsultada=new String[3];

    public MetodosPrestamo() 
    {
       arrayPrestamos = new ArrayList <Prestamo>();
    }
    public void agregarPrestamo(String arreglo[])
    {
      Prestamo temporal = new Prestamo(arreglo[0], arreglo[1], arreglo[2], arreglo[3]);
      arrayPrestamos.add(temporal);
    }
    public String numeroConsecutivo()
    {
      String numeroConsecutivo= "000";
      
      if(arrayPrestamos.size()==0)
      {
        numeroConsecutivo+=1;
      }
      else
      {
        int numero=Integer.parseInt(arrayPrestamos.get(arrayPrestamos.size()-1).getNumeroPrestamo());
        numero++;
        numeroConsecutivo="000"+numero;
      }
      numeroConsecutivo=numeroConsecutivo.substring(numeroConsecutivo.length()-4,numeroConsecutivo.length());
      return numeroConsecutivo;
    }
    public boolean consultarPrestamo(String numeroPrestamo)
    {
      boolean existe=false;
      
      for(int contador=0;contador<arrayPrestamos.size();contador++)
      {
         if(arrayPrestamos.get(contador).getNumeroPrestamo().equals(numeroPrestamo))
         {
            arregloInformacionConsultada[0]=arrayPrestamos.get(contador).getNombreUsuario();
            arregloInformacionConsultada[1]=arrayPrestamos.get(contador).getCedulaUsuario();
            arregloInformacionConsultada[2]=arrayPrestamos.get(contador).getIsbnLibro();
            existe=true;
         }
      }
      return existe;
    }
    public void eliminarPrestamo(String[] arreglo)
    {
      for(int contador=0;contador<arrayPrestamos.size();contador++)
      {
         if(arrayPrestamos.get(contador).getNumeroPrestamo().equals(arreglo[0]))
         {
            arrayPrestamos.remove(contador);
         }
      }
    }
    public void modificarPrestamo(String[] arreglo)
    {
      for(int contador=0;contador<arrayPrestamos.size();contador++)
      {
         if(arrayPrestamos.get(contador).getNumeroPrestamo().equals(arreglo[0]))
         {
            arrayPrestamos.get(contador).setNombreUsuario(arreglo[1]);
            arrayPrestamos.get(contador).setCedulaUsuario(arreglo[2]);
            arrayPrestamos.get(contador).setIsbnLibro(arreglo[3]);
         }
      }
    }
    public String[] getArregloInformacion()
    {
      return arregloInformacionConsultada;
    }
}
