
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import poo.io.IO;

/**
 *
 * @author Juan
 */
public class Directivo extends EquipoDirectivo {

    //Atributos
    private int despacho;
    private Secretario secretario;
    private Fecha[] diasVacaciones = new Fecha[5];

    //Constructor
    //Directivos con secretario 
    public Directivo(String nombre, String apellidos, String dni, double salario, Fecha fechaAltaClub, int edad,
            String correoElectronico, int telefono, int despacho, Secretario secretario) {
        super(nombre, apellidos, dni, salario, fechaAltaClub, edad, correoElectronico, telefono);
        setDespacho(despacho);
        setSecretario(secretario);

    }

    //Directivos sin secretario
    public Directivo(String nombre, String apellidos, String dni, double salario, Fecha fechaAltaClub, int edad,
            String correoElectronico, int telefono, int despacho) {
        super(nombre, apellidos, dni, salario, fechaAltaClub, edad, correoElectronico, telefono);
        setDespacho(despacho);

    }

    //Metodos consultores y modificadores
    public int getDespacho() {
        return despacho;
    }

    public void setDespacho(int despacho) {

        this.despacho = despacho;
    }

    public Secretario getSecretario() {
        return secretario;
    }

    public void setSecretario(Secretario secretario) {
        this.secretario = secretario;
    }

    //Metodo toString
    public String toString() {
        return "DIRECTIVO C.B.Montellano:"
                + super.toString()
                + "Formación académica: " + despacho
                + "\n"
                + "Secretario: " + secretario.getNombre() + " " + secretario.getApellidos()
                + "\n"
                +"dzsdfdfdsf";
    }

    //Metodo equals
    public boolean equals(Object o) {
        Directivo d = (Directivo) o;

        return super.equals(d) && despacho == d.despacho && secretario == d.secretario;
    }

    //Metodos implementados
    public void pedirVacaciones() { //IMPLEMENTAR EXCEPCIÓN
        //Creamos un objeto de la clase gregorian calendar
        Calendar cal = new GregorianCalendar();
        int anyoActual = cal.get(Calendar.YEAR);
        int diavacaciones;
        int mesvacaciones;

        System.out.println("Tienes 5 dias de vacaciones al año disponibles. Eligélos bien");
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

     public void aumentarSalario(int aumento) {
        double nuevosalario;
        nuevosalario = super.getSalario() + aumento;

        if (super.getSalario() == 5000) {
            System.out.println(nombre + " " + apellidos + " ya cobra el máximo permitido para un jugador de nuestro club, que son 5000 €. No podemos aplicarle ningún aumento.");
        } else if (nuevosalario > 5000) {
            System.out.println("Con este aumento de salario " + nombre + " " + apellidos + " ha superado el maximo salarial para un jugador de nuestro club. Reajustaremos su salario al máximo permitido");
            super.setSalario(nuevosalario);
            System.out.println("Nuevo sueldo: " + nuevosalario + " €");
        } else {
            System.out.println("El sueldo de " + nombre + " " + apellidos + " ha sido aumentado. Su nuevo sueldo es: " + nuevosalario + " €");
        }
    }
    public void ficharJugadorOjeado(Ojeador o) {
        o.getJugadores();
        String opcionjugador;
        System.out.println("¿A cual de los jugadores desea fichar?");
        opcionjugador = IO.readLine();

    }

    public void consultarEstadisticas(Jugador j, int temporada) throws MyException{
        Calendar cal = new GregorianCalendar();
        int anyoActual = cal.get(Calendar.YEAR);
        if (temporada >= 1950 && temporada <= anyoActual) {
            if (temporada < j.fechaAltaClub.getAnyo()) {
                System.out.println("En el año " + temporada + " el jugador " + j.getNombre() + " " + j.getApellidos() + " no jugaba en nuestro club");
            } else {
                j.consultarEstadisticasJugador();
            }
        }else{
            throw new MyException("AÑO INCORRECTO");
        }
    }

}
