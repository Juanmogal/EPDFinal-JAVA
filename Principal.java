
/**
 *
 * @author Juan Moreno Galbarro
 */
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import poo.io.*;

public class Principal {

    public static void main(String[] args) {
        //FECHA
        //Creamos una fecha de la clase fecha y pasamos a comprobar las restricciones de fecha para ver que esta bien corregida la clase fecha
        Fecha f1 = new Fecha(31,2,2020,14,57); /*Probamos las restricciones de dia*/
        System.out.println(f1.toString());
        Fecha f2 = new Fecha(12,14,2020,14,57); /*Probamos las restricciones de mes*/
        System.out.println(f2.toString());
        Fecha f3 = new Fecha(12,2,1600,14,57); /*Probamos las restricciones de año*/
        System.out.println(f3.toString());
        Fecha f4 = new Fecha(12,2,2020,25,57); /*Probamos las restricciones de hora*/
        System.out.println(f4.toString());
        Fecha f5 = new Fecha(12,2,2020,14,63); /*Probamos las restricciones de minutos*/
        System.out.println(f5.toString());
        //Creamos una fecha para utilizarla en las fechas de alta de club para crear los objetos siguientes.
        Fecha f6 = new Fecha(27,1,2010,15,32);
   
//        //AFICIONADO(CLASE EXTERNA)
//        //Creamos un objeto de la clase aficionado(String nombre, String apellidos, String dni,Fecha fechaAltaClub, String tipoAficionado)
//        Aficionado a1 = new Aficionado("Marta","Moreno Lopez","12345678B",f6,"adulto");
//        //Probamos por ejemplo el metodo setTipoAficionado que tiene restricciones a la hora de introducirle el tipo
//        a1.setTipoAficionado("d");
//        System.out.println(a1.getTipoAficionado());
//        //Tras hacer esto, podemos comprobar que tolowercase funciona correctamente y que si le pasas por parametro algo diferente
//        // a infantil,juvenil, adulto o senior, el tipo es "SIN TIPO DE AFICIONADO DEFINIDO"
//        //toString
//        System.out.println(a1.toString());
//        //equals 
//        Aficionado a2 = new Aficionado("Marta","Moreno Lopez","12345678B",f6,"adulto");
//        System.out.println(a1.equals(a2)); /*Como antes le hemos hecho un set a a1 y hemos cambiado el tipo de aficionado, el equals
//                                            dará false. Si lo comentamos devolverá true.*/
//        //hacerseAficionadoPremium
//        a2.hacerseAficionadoPremium(); /*Como hace 10 años que es aficionado del club, cumple los requisitos y puede ser aficionado premium*/
//        //comprarAcciones
//        a2.comprarAcciones(5); /*Como no es socio infantil ni juvenil(que no pueden por la edad), podra comprar acciones.
//                                            Ademas el numero de acciones que quiere comprar no es menor de 1 ni mayor que 0.*/
//        a2.darDeBaja(); //Pone a 0 los enteros, a cadenas vacias los string,a false los boolean y a 1/1/1970 12:00 la fecha y la hora de alta
        
          //CUERPO TECNICO(CLASE HIJA)
           //Creamos un objeto de la clase cuerpo tecnico(public CuerpoTecnico(String nombre, String apellidos, String dni, double salario, Fecha fechaAltaClub, int edad,
          //int temporadasExperiencia, String equipoProcedencia, String tipo, int numeroLicencia
        CuerpoTecnico ct1 = new CuerpoTecnico("Fran","Cintado","12345678C",1200.50, f6, 4, 51,"Real Madrid","primer entrenador",152336);
        //Probamos algunos sets de los que tienen restricciones. Por ejemplo:
        ct1.setTemporadasExperiencia(-1); /*las temporadas de experiencia no pueden ser menor que 0, si lo son, se pondra a 0*/
        ct1.setEdad(-2);/*los integrantes del cuerpo tecnico tienen que ser mayores de edad y la edad no puede ser menor que 0*/
        ct1.setTipo("tercer entrenador");/* si el tipo no es primer entrenador, segundo entrenador, utillero, fisio o delegado de pista
                                              el tipo se pondrá a "SIN PUESTO DEFINIDO EN EL CUERPO TECNICO"*/

        //toString
        System.out.println(ct1.toString());
        //equals
        CuerpoTecnico ct2 = new CuerpoTecnico("Fran","Cintado","12345678C",1200.50, f6, 4, 51,"Real Madrid","primer entrenador",152336);
        System.out.println(ct1.equals(ct2));/*Deberia devolver un true, ya que ct1 y ct2 son dos objetos iguales, pero al haberles hecho los set
                                          //  los valores han cambiado, si comentamos los set de arriba, devolvera true, sino false*/
        //ApartarJugadordelEquipo
        ct1.apartarJugadorDelEquipo(j3,"pelea en el vestuario"); //le pasamos un jugador creado anteriormente y un string por parametro
        
        ct1.pedirFichajes(6); // como el tipo de ct1 no es primer ni segundo entrenador no puede pedir fichajes.
                                         //en el caso de que lo fuera, el numero de fichajes es elevado y le dirá que son demasiados
                                         
                                         
      
      //Por último, probamos el metodo clone que hemos redefinido en la clase aficionado, y miembroclub
     
      Aficionado a4 = new Aficionado("Paula","Rodriguez","12345678B",f6,"infantil");
      Aficionado a18 = new Aficionado("","","",f6,"");
      a18 = (Aficionado) a4.clone();                         
      System.out.println(a18.toString());   
        
        
        
        
        
        
        
//        
//        //JUGADOR(CLASE HIJA)
//        //Creamos un objeto de la clase jugador
//        Jugador j1 = new Jugador("Juan","Moreno","4567890A",1950.60, f6,23,10,"alero",1.82,95.8,"Montellano","Estrella");
//        //Probamos algunos metodos sets para ver si las restricciones funcionan correctamente
//        j1.setDorsal(-3); /*El dorsal no puede ser mayor que 99, ni menor que 0. En estos dos casos se pondrá a 0*/
//        j1.setPosicion("AF");/*si la posicion es distinta de base, escolta, alero y pivot, guardará "SIN POSICION DEFINIDA EN EL EQUIPO"*/
//        j1.setPeso(-25);
//        j1.setAltura(-9.12);
//        //La altura y el peso no pueden ser menores que 0
//        System.out.println(j1.getEquipoProcedencia()); // Como hemos puesto el canterano a true al crearlo, guarda en el equipo de procedencia,
//                                                       //las categorias inferiores del club
//        
//        //toString
//        System.out.println(j1.toString());
//        
//        //equals
//        Jugador j2 = new Jugador("Juan","Moreno","4567890A",1950.60, f6,5, true,"alero",1.82,95.8,"Montellano","Estrella");
//        Jugador j3 = new Jugador("Juan","Moreno","4567890A",1950.60, f6,5, true,"alero",1.82,95.8,"Montellano","Estrella");
//        System.out.println(j2.equals(j3));
//        
//        //informeMedico
//        j1.informeMedico();//Dependiendo del peso introducido devolverá una cosa u otra
//        //pedirTraspaso
//        j1.pedirTraspaso("Barcelona"); // Como actualmente no estamos en mercado de fichajes, no puede pedir el traspaso.
//                                                 //Compara la fecha, con la fecha actual.
//        
                             
//      //PROBAR EL METODO CLONE CON OTRA CLASE(MIEMBRO CLUB Y ES ABSTRACTA)
////       MiembroClub mc9 = new MiembroClub("Andres","Ceballos","12345432S", 1200, f6);  
////       MiembroClub mc14 = new MiembroClub("","","", 0, f6);
////       mc14 = (MiembroClub) mc9.clone(); 
////       System.out.println(mc14.toString());
//   
      Fecha f6 = new Fecha(27, 1, 2010, 15, 32);
////        
      Ojeador o = new Ojeador("Alex", "Espada", "123456789", 1000, f6, 30, "djodfjdfj", 635555, 3);
//////    Secretario s1 = new Secretario("Juan", "Moreno", "1234", 200, f6, 50, "dr", 66, "gfgfh", 2);
      Directivo d1 = new Directivo("Juan", "Moreno", "1234", 1200, f6, 50, "dr", 66, 43);
      try{
      d1.ficharJugadorOjeado(o,"francia", 16, 25);
      }catch(MyException e2){
          System.err.println("excepcion capturada");
          e2.printStackTrace();
      }
       
//       CuerpoTecnico ct1 = new CuerpoTecnico("Fran", "Cintado", "12345678C", 1200.50, f6, 88, 51, "Real Madrid", "primer entrenador", 152336);
//       ct1.programarAmistoso();
////
//        //ct1.sacarQuintetoInicial();
//        //j1.consultarEstadisticasJugador();
////        try {
////            d1.consultarEstadisticas(j1, 2022);
////        }catch(MyException e){
////            System.err.println("Excepción capturada en el main");
////            e.printStackTrace();    
////        }
//        
////        Jugador [] plantilla = new Jugador[2];
////        plantilla[0] = new Jugador("Juan", "Moreno", "4567890A", 1950.60, f6, 23, 48, "alero", 1.82, 95.8, "Montellano", "Estrella");
////        plantilla[1] = new Jugador("Alex", "Zacevedo", "4567890A", 1950.60, f6, 11, 10, "alero", 1.82, 95.8, "Montellano", "Estrella");
////        Arrays.sort(plantilla);
////        for(int i=0;i<plantilla.length;i++){
////        System.out.println(plantilla[i]);
//////        }
////        Arrays.sort(plantilla,new ComparadorDorsal());
////        for(int i=0;i<plantilla.length;i++){
////        System.out.println(plantilla[i]);
////        }
//
////ct1.sacarQuintetoInicial();
//
//ugador j1 = new Jugador("Juan", "Moreno", "4567890A", 1950.60, f6, 23, 48, "alero", 1.82, 95.8, "Montellano",5, "Estrella");
//
//        try {
//            d1.consultarEstadisticas(j1, 2021);
//        }catch(MyException matero){
//            System.err.println("Excepción capturada en el main");
//            matero.printStackTrace();    
//        }
//
//

       
    }
}
