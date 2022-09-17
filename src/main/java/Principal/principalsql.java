/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.sql.*;
import java.util.Scanner;


/**
 *
 * @author Yesica 
 */
class principalsql {
     
 private static int opcion=-1;
      private static final Scanner scanner= new Scanner(System.in);
     private static final principalsql crud=new principalsql();
    public static void main(String[] args) throws SQLException {
         String NIV;
         while (opcion != 0) {
             try {
                   System.out.println("""
                                      Base Comisiones
                                      Selecciona una opcion
                                      1.- Consultar empleado
                                      2.- Listar a todos los empleados
                                      3.- Actualizar registro
                                      4.- Eliminar registro
                                        """);
                opcion=Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                  case 1:
                        System.out.println("Consultar Datos");
                   System.out.println("Ingrese el Niv que desea consultar");
                    NIV=scanner.nextLine();
                      principalsql.ej2(NIV);
                        break;

                      

                        
                         case 2:
                        System.out.println("Listar Datos");
                       principalsql.Listar();
                     
                        break;
                        
                          case 3:
                        System.out.println("Actualizar registo");
                        System.out.println("Ingresa el NIV del empleado:");
                        NIV=scanner.nextLine();
                        principalsql.Actualizar(NIV);
                        
                        
                        break;
                        
                         case 4:
                        System.out.println("Eliminar Registro");
                        System.out.println("Ingrese el NIV del empleado:");
                        NIV=scanner.nextLine();
                        principalsql.Eliminar(NIV);
                        
                        break;
                        
                 
                }
                 
             } catch (NumberFormatException e) {
             }
         
         }
    
     }
   
      public static void ej2(String NIV){
         
        //paso 1 creamos la conexion a la base de datos
        
        String url="jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
       
        try {
 
   Connection conexion=DriverManager.getConnection(url,"root","");  //paso 2 creamos el objeto conexion
    Statement sentencia= conexion.createStatement();    
   String comi = "SELECT*FROM tb_comisiones where NIV="+NIV;     
    ResultSet resultado=sentencia.executeQuery(comi); 
  
    while(resultado.next()){
 
               System.out.println("NIV="+resultado.getInt(1));
               System.out.println("Nombre = "+resultado.getString(2));
               System.out.println("Enero ="+resultado.getInt(3));
               System.out.println("Febrero ="+resultado.getInt(4));
               System.out.println("Marzo ="+resultado.getInt(5));
               System.out.println("Abril ="+resultado.getInt(6));
               System.out.println("Mayo="+resultado.getInt(7));
               System.out.println("Junio ="+resultado.getInt(8));
        
              
    }  
   
  
        } catch (SQLException ex ) {
   
        }
       
       
    }
      
        public static void Listar(){
           String url="jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
           try {
             
   Connection conexion=DriverManager.getConnection(url,"root",""); 
    Statement sentencia= conexion.createStatement();
   String sql = "SELECT*FROM dbcomisiones.tb_comisiones";
    ResultSet resultado=sentencia.executeQuery(sql); 
                                                       
                                                      
  
            int enero=0,febrero=0,marzo=0,abril=0,mayo=0,junio=0;
            
            while(resultado.next()){
                 System.out.println("NIV="+resultado.getInt(1));
               System.out.println("Nombre = "+resultado.getString(2));
               System.out.println("Enero ="+resultado.getInt(3));
               System.out.println("Febrero ="+resultado.getInt(4));
               System.out.println("Marzo ="+resultado.getInt(5));
               System.out.println("Abril ="+resultado.getInt(6));
               System.out.println("Mayo="+resultado.getInt(7));
               System.out.println("Junio ="+resultado.getInt(8));
               
                
                enero=enero+resultado.getInt(3);
                febrero=febrero+resultado.getInt(4);
                marzo=marzo+resultado.getInt(5);
                abril=abril+resultado.getInt(6);
                mayo=mayo+resultado.getInt(7);
                junio=junio+resultado.getInt(8);
                
            }
            System.out.println("*****Total de Ventas por mes:***** ");
            System.out.println("Enero = "+enero+"\nFebrero = "+febrero+"\nMarzo = "+marzo);
            System.out.println("Abril = "+abril+"\nMayo = "+mayo+"\nJunio = "+junio);
           } catch (SQLException e) {
           }
        }
          
                     public static void Actualizar(String NIV){
                         String Nombre;
           String url="jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
           try {
             //paso 2 creamos el objeto conexion
   Connection conexion=DriverManager.getConnection(url,"root","");
    //paso  3 creamos el objeto stantement
    Statement sentencia= conexion.createStatement();
    //paso 4 creamos la instruccion
   String sql = "SELECT*FROM tb_comisiones where NIV="+NIV;    
  
    //paso 5 ejecutamos el query
    ResultSet resultado=sentencia.executeQuery(sql);
    //paso 6 procesar el resultado
    // explicar como se maneja el siguiente registro
  
            while(resultado.next()){
                    System.out.println("NIV = "+resultado.getInt(1));
                     System.out.println(" Nombre = "+resultado.getString(2));
                    System.out.println("Ingresa Nombre Actualizado");
                
            }
             Nombre=scanner.nextLine();  
             String query = "update tb_comisiones set nombre= '"+Nombre+"' where NIV= "+NIV;
            sentencia.executeUpdate(query);
            System.out.println("Actualizacion realizada!");
        
            
                  
              } catch (SQLException e) {
                  
                  
              }
                     }
        
    public static void Eliminar(String NIV) throws SQLException{
           String  url="jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
    Connection conexion=DriverManager.getConnection(url,"root","");
    Statement sentencia= conexion.createStatement(); 
    String sql = "SELECT*FROM tb_comisiones where NIV="+NIV;  
    String query = "delete from tb_comisiones where NIV="+NIV;
   String respuesta;
 
    ResultSet resultado=sentencia.executeQuery(sql);

           
    while(resultado.next()){
                    System.out.println("NIV = "+resultado.getInt(1));
                     System.out.println(" Nombre = "+resultado.getString(2));
                      System.out.println("Estas seguro que quieres eliminar ");
            }
             

            respuesta=scanner.nextLine();
            
            if (respuesta.equalsIgnoreCase("si")) {
                sentencia.executeUpdate(query);
                System.out.println("Eliminado");

            }else{
                System.out.println("Cancelado");
            }
        } catch (SQLException ex) {
            
        }

    
       
       }
    
   
}



    
    
    

