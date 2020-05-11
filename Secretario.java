
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
    private Fecha[] reuniones = new Fecha[3];

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

    public void modificarContratoJugador(Jugador j) throws MyException {
        int modificacion;
        System.out.println("CONTRATO ACTUAL DEL JUGADOR: " + j.getNombre() + " " + j.getApellidos());
        System.out.println("DNI: " + j.getDni());
        System.out.println("Fecha alta club: " + j.fechaAltaClub);
        System.out.println("Fecha finalización del contrato: " + j.fechaFinalizacionContrato());
        System.out.println("Rol en el equipo: " + j.getRolEquipo());
        System.out.println("Salario actual: " + j.getSalario());
        System.out.println("¿Que parte del contrato desea modificar?");
        System.out.println("1.Años de contrato");
        System.out.println("2.Rol en el equipo");
        System.out.println("3.Modificar salario");
        System.out.println("Introduzca la opción deseada");
        modificacion = (int) IO.readNumber();
        if (modificacion >= 1 && modificacion <= 3) {
            switch (modificacion) {
                case 1:
                    int anyofinalizacion;
                    System.out.println("Introduzca el año de finalización de contrato");
                    anyofinalizacion = (int) IO.readNumber();
                    j.setAnyosContrato(anyofinalizacion);
                    System.out.println("El contrato de " + j.getNombre() + " " + j.getApellidos() + " " + "finalizará el " + j.fechaFinalizacionContrato());
                    break;
                case 2:
                    double salario;
                    System.out.println("Introduzca el nuevo salario");
                    salario = (double) IO.readNumber();
                    j.setSalario(salario);
                    System.out.println("Ahora nuestro jugador " + j.getNombre() + " " + j.getApellidos() + " cobrará " + j.getSalario() + " €.");
                    break;
                case 3:
                    String nuevorol;
                    System.out.println("Introduzca el nuevo rol del jugador");
                    nuevorol = IO.readLine();
                    j.setRolEquipo(nuevorol);
                    System.out.println("Nuevo rol de " + j.getNombre() + " " + j.getApellidos() + ": " + j.getRolEquipo());
                    break;
                default:
                    break;
            }
        } else {
            throw new MyException("Opción incorrecta. Como secretario, solo puedes modificar las 3 opciones de contrato establecidas.");
        }
    }//fin metodo modificarcontrato

    private void reunionesMensuales(int mes2) {
        Calendar cal = new GregorianCalendar();
        int anyoActual = cal.get(Calendar.YEAR);
        for (int i = 0; i < reuniones.length; i++) {
            int dia = (int) Math.random() * 31 + 1;
            int mes = mes2;
            int hora = (int) (Math.floor(Math.random() * (21 - 8 + 1)) + 8);
            int minutos = (int) Math.random() * 60;
            reuniones[i] = new Fecha(dia, mes2, anyoActual, hora, minutos);
        }
    }

    public void consultarReunionesMensuales(int mes) throws MyException {
        reunionesMensuales(mes);
        if (mes >= 1 && mes <= 12) {
            for (int i = 0; i < reuniones.length; i++) {
                switch (mes) {
                    case 1:
                        System.out.println("En Enero sus reuniones programadas son las siguientes: ");
                        System.out.println(reuniones[i]);
                        break;
                    case 2:
                        System.out.println("En Febrero sus reuniones programadas son las siguientes: ");
                        System.out.println(reuniones[i]);
                        break;
                    case 3:
                        System.out.println("En Marzo sus reuniones programadas son las siguientes: ");
                        System.out.println(reuniones[i]);
                        break;
                    case 4:
                        System.out.println("En Abril sus reuniones programadas son las siguientes: ");
                        System.out.println(reuniones[i]);
                        break;
                    case 5:
                        System.out.println("En Mayo sus reuniones programadas son las siguientes: ");
                        System.out.println(reuniones[i]);
                        break;
                    case 6:
                        System.out.println("En Junio sus reuniones programadas son las siguientes: ");
                        System.out.println(reuniones[i]);
                        break;
                    case 7:
                        System.out.println("En Julio sus reuniones programadas son las siguientes: ");
                        System.out.println(reuniones[i]);
                        break;
                    case 8:
                        System.out.println("En Agosto sus reuniones programadas son las siguientes: ");
                        System.out.println(reuniones[i]);
                        break;
                    case 9:
                        System.out.println("En Septiembre sus reuniones programadas son las siguientes: ");
                        System.out.println(reuniones[i]);
                        break;
                    case 10:
                        System.out.println("En Octubre sus reuniones programadas son las siguientes: ");
                        System.out.println(reuniones[i]);
                        break;
                    case 11:
                        System.out.println("En Noviembre sus reuniones programadas son las siguientes: ");
                        System.out.println(reuniones[i]);
                        break;
                    case 12:
                        System.out.println("En Diciembre sus reuniones programadas son las siguientes: ");
                        System.out.println(reuniones[i]);
                        break;
                    default:
                        break;
                }
            }
        } else {
            throw new MyException("Mes introducido incorrecto. Elige un mes entre 1 y 12");
        }
    }

}//FIN CLASE 
