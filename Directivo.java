
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
    protected String[] equiposrivales = {"Valencia Basket", "Real Madrid", "Estudiantes", "Unicaja", "Basket Zaragoza", "Real Betis Baloncesto","Los Angeles Lakers","Chigago Bulls","Bilbao Basket","San Antonio Spurs"};

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
        if(despacho < 0){
            System.out.println("Despacho no existente");
            this.despacho = 0;
        }
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
                + "\n";
    }

    //Metodo equals
    public boolean equals(Object o) {
        Directivo d = (Directivo) o;

        return super.equals(d) && despacho == d.despacho && secretario == d.secretario;
    }

    //Metodos implementados
    public void pedirVacaciones() { 
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

    public void consultarEstadisticas(Jugador j, int temporada) throws MyException {
        Calendar cal = new GregorianCalendar();
        int anyoActual = cal.get(Calendar.YEAR);
        if (temporada >= 1950 && temporada <= anyoActual) {
            if (temporada < j.fechaAltaClub.getAnyo()) {
                System.out.println("En el año " + temporada + " el jugador " + j.getNombre() + " " + j.getApellidos() + " no jugaba en nuestro club");
            } else {
                j.consultarEstadisticasJugador();
            }
        } else {
            throw new MyException("AÑO INCORRECTO");
        }
    }

    public static int existeEnArray(String[] array, String stringbuscada) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(stringbuscada)) {
                return i;
            }
        }
        return -1;
    }

    public void ficharJugadorOjeado(Ojeador o, String pais, int edadmin, int edadmax) throws MyException {
        o.InformeJugadoresOjeados(pais, edadmin, edadmax);
        String nombreJugadorFichado;
        System.out.println("¿A cual de los jugadores desea fichar?");
        System.out.println("Introduzca su nombre completo");
        nombreJugadorFichado = IO.readLine();

        int posicionDeElementoBuscado = existeEnArray(o.jugadoresOjeados, nombreJugadorFichado);
        if (posicionDeElementoBuscado != -1) {
            String equipoAleatorio = equiposrivales[new Random().nextInt(equiposrivales.length)];
            double dineroTraspaso;
            System.out.println("Este jugador juega actualmente en " + equipoAleatorio);
            System.out.println("Negociaciones abiertas con " + o.jugadoresOjeados[posicionDeElementoBuscado]);
            System.out.println("Introduzca la cantidad que pagaremos por el traspaso: ");
            dineroTraspaso = IO.readNumber();
            int respuestaDelClub = (int) (Math.random() * 10);  //generamos un booleano aleatorio
            while (respuestaDelClub > 6) {
                double nuevaCantidad;
                System.out.println(equipoAleatorio + " ha rechazado nuestra oferta. Piden una cantidad mayor de dinero.");
                nuevaCantidad = IO.readNumber();
                if (nuevaCantidad <= dineroTraspaso) {
                    throw new MyException("La cantidad ofrecida es inferior a la anterior. El club ha decidido romper las negociaciones");
                }
            }
            System.out.println("FICHADO!! "+o.jugadoresOjeados[posicionDeElementoBuscado]+" es nuevo jugador de nuestro club. "+equipoAleatorio +" ha aceptado nuestra oferta");
        } else {
            throw new MyException(nombreJugadorFichado + " no ha sido ojeado por " + o.getNombre() + " " + o.getApellidos() + ". Póngase en contacto con él si tiene especial interés en este jugador.");

        }

    }

}
