
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import poo.io.IO;

/**
 *
 * @author Juan
 */
public class Ojeador extends EquipoDirectivo {

    //Atributos
    private int anosDeExperiencia;

    private Fecha[] diasVacaciones = new Fecha[3];
    private String[] apellidos = {"Alocén", "Jímenez", "López", "Gasol", "Rubio", "Llull", "Fernández", "Simón", "Herrera", "Cintado", "Mirotic"};
    private String[] nombres = {"Carlos", "Juan", "Raul", "Marc", "Ricky", "Sergi", "Rudy", "Krunoslav", "Carlitos", "Gabriel", "Nikola"};
    public String[] jugadoresOjeados = new String[5];

    //Constructor
    public Ojeador(String nombre, String apellidos, String dni, double salario, Fecha fechaAltaClub, int edad,
            String correoElectronico, int telefono, int anosdeExperiencia) {
        super(nombre, apellidos, dni, salario, fechaAltaClub, edad, correoElectronico, telefono);
        setAnosDeExperiencia(anosDeExperiencia);

    }

//GETTERS Y SETTERS
    public int getAnosDeExperiencia() {
        return anosDeExperiencia;
    }

    public void setAnosDeExperiencia(int anosDeExperiencia) {
        if (anosDeExperiencia < 0) {
            this.anosDeExperiencia = 0;
        } else {
            this.anosDeExperiencia = anosDeExperiencia;
        }
    }

    public void getJugadores() {
         
        for (int i = 0; i < jugadoresOjeados.length; i++) {
            jugadoresOjeados[i] = nombres[new Random().nextInt(jugadoresOjeados.length)] + " " + apellidos[new Random().nextInt(jugadoresOjeados.length)] ;
            System.out.println(jugadoresOjeados[i]);
        }
    
    }
       
    
    //Metodo toString
    public String toString() {
        return "OJEADOR C.B.Montellano:"
                + super.toString()
                + "Años de experiencia: " + anosDeExperiencia
                + "\n";
    }

    //Metodo equals
    public boolean equals(Object o) {
        Ojeador o2 = (Ojeador) o;

        return super.equals(o2) && anosDeExperiencia == o2.anosDeExperiencia;
    }
    //Metodos implementados

    //Dentro de este metodo se hace una llamada a hacerSeguimientoJugadores que rellena el array de jugadores y edades aleatorias. En este metodo lo mostramos por pantalla
    public void InformeJugadoresOjeados(String pais, int edadminima, int edadmaxima) {
        System.out.println("Tras varios días ojeando jugadores, " + getNombre() + " " + getApellidos() + " ha considerado que estos son los mejores adaptándose a los filtros establecidos");
        System.out.println("FILTROS ESTABLECIDOS:");
        System.out.println("País: " + pais + " " + "Edad: " + edadminima + "-" + edadmaxima);

        ojearJugadores(); //Llamada al metodo que rellenar el array.

        for (int i = 0; i < jugadoresOjeados.length; i++) {
            int edadJugadorOjeado = new Random().nextInt(edadmaxima - edadminima) + edadminima; //Crea un entero aleatorio con el rango que se le pase por parametro
            System.out.println(jugadoresOjeados[i] +" "+edadJugadorOjeado+" años" );        //Muestra el contenido del array jugadores Ojeados
        }
    }

    public void ojearJugadores() {
        for (int i = 0; i < jugadoresOjeados.length; i++) {
            
            jugadoresOjeados[i] = nombres[new Random().nextInt(jugadoresOjeados.length)] + " " + apellidos[new Random().nextInt(jugadoresOjeados.length)] ;
        }
    }

    //Implementacion del metodo abstracto de la clase padre
    public void pedirVacaciones() {
        //Creamos un objeto de la clase gregorian calendar
        Calendar cal = new GregorianCalendar();
        int anyoActual = cal.get(Calendar.YEAR);
        int diavacaciones;
        int mesvacaciones;

        System.out.println("Tienes 3 dias de vacaciones al año disponibles. Eligélos bien");
        for (int i = 0; i < diasVacaciones.length; i++) {
            System.out.println("Introduzca el dia de tu día " + (i + 1) + " de vacaciones");
            diavacaciones = (int) IO.readNumber();
            System.out.println("Introduzca el mes de tu día" + (i + 1) + " de vacaciones");
            mesvacaciones = (int) IO.readNumber();
            diasVacaciones[i] = new Fecha(diavacaciones, mesvacaciones, anyoActual);

        }
        System.out.println("En " + anyoActual + " tus dias de vacaciones serán los siguientes: ");
        for (int i = 0; i < diasVacaciones.length; i++) {
            System.out.println(diasVacaciones[i].getDia() + "/" + diasVacaciones[i].getMes() + "/" + anyoActual);

        }

    }

}
