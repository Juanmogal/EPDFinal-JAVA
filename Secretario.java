
import java.util.Calendar;
import java.util.GregorianCalendar;
import poo.io.IO;

/**
 *
 * @author Juan
 */
public class Secretario extends EquipoDirectivo {

    //Atributos
    private String formacion;
    private int anosexperiencia;
    private Fecha[] diasVacaciones = new Fecha[4];

    //Constructor
    public Secretario(String nombre, String apellidos, String dni, double salario, Fecha fechaAltaClub, int edad,
            String correoElectronico, int telefono, String formacion, int anosexperiencia) {
        super(nombre, apellidos, dni, salario, fechaAltaClub, edad, correoElectronico, telefono);
        setFormacion(formacion);
        setAnosexperiencia(anosexperiencia);

    }
    //GETTERS Y SETTERS

    public String getFormacion() {
        return formacion;
    }

    public void setFormacion(String formacion) {
        if (formacion == "") {
            System.out.println("Secretario sin formación");
        } else {
            this.formacion = formacion;
        }

    }

    public int getAnosexperiencia() {
        return anosexperiencia;
    }

    public void setAnosexperiencia(int anosexperiencia) {
        if (anosexperiencia < 0) {
            System.out.println("La experiencia de un miembro del cuerpo técnico no puede ser menor que 0");
            this.anosexperiencia = 0;
        } else {
            this.anosexperiencia = anosexperiencia;
        }
    }

    //Metodo toString
    public String toString() {
        return "SECRETARIO C.B.Montellano:"
                + super.toString()
                + "Formación académica: " + formacion
                + "\n"
                + "Años de experiencia: " + anosexperiencia
                + "\n";
    }
    //Metodo equals

    public boolean equals(Object o) {
        Secretario s = (Secretario) o;
        return super.equals(s) && anosexperiencia == s.anosexperiencia && formacion.equalsIgnoreCase(s.formacion);
    }

    //Metodos implementados
    
    //Implementacion del metodo abstracto de la clase padre
    public void pedirVacaciones() { //IMPLEMENTAR EXCEPCIÓN
        //Creamos un objeto de la clase gregorian calendar
        Calendar cal = new GregorianCalendar();
        int anyoActual = cal.get(Calendar.YEAR);
        int diavacaciones;
        int mesvacaciones;

        System.out.println("Tienes 4 dias de vacaciones al año disponibles. Eligélos bien");
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
