
import java.util.Objects;

/**
 *
 * @author Juan
 */
public abstract class EquipoDirectivo extends MiembroClub {

    //ATRIBUTOS
    private String correoElectronico; //Numero de licencia de la federacion de cada uno de los miembros del cuerpo tecnico
    private int telefono;

    //Constructor
    public EquipoDirectivo(String nombre, String apellidos, String dni, double salario, Fecha fechaAltaClub, int edad,
            String correoElectronico, int telefono) {
        super(nombre, apellidos, dni, salario, fechaAltaClub, edad);
        setCorreoElectronico(correoElectronico);
        setTelefono(telefono);

    }
    //Getters y setters

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Fecha getFechaAltaClub() {
        return fechaAltaClub;
    }

    public void setFechaAltaClub(Fecha fechaAltaClub) {
        this.fechaAltaClub = fechaAltaClub;
    }

    //Metodo toString
    public String toString() {
        return "MIEMBRO DIRECTIVO CLUB BALONCESTO MONTELLANO:"
                + super.toString()
                + "\n"
                + "Correo electrónico: " + correoElectronico
                + "\n"
                + "Teléfono móvil: " + telefono
                + "\n";
    }

    //Metodo equals
    public boolean equals(Object o) {
        EquipoDirectivo ed = (EquipoDirectivo) o;

        return super.equals(ed) && correoElectronico.equalsIgnoreCase(ed.correoElectronico) && telefono == ed.telefono;
    }

    //Metodos implementados
    public void aumentarSalario(int aumento) {
        double nuevosalario;
        nuevosalario = super.getSalario() + aumento;

        if (super.getSalario() == 4000) {
            System.out.println(nombre + " " + apellidos + " ya cobra el máximo permitido para un integrante del cuerpo técnico de nuestro club, que son 3000 €. No podemos aplicarle ningún aumento.");
        } else if (nuevosalario > 4000) {
            System.out.println("Con este aumento de salario " + nombre + " " + apellidos + " ha superado el máximo salarial para un jugador de nuestro club. Reajustaremos su salario al máximo permitido");
            super.setSalario(nuevosalario);
            System.out.println("Nuevo sueldo: " + nuevosalario + " €");
        } else {
            System.out.println("El sueldo de " + nombre + " " + apellidos + " ha sido aumentado. Su nuevo sueldo es: " + nuevosalario + " €");
        }
    }
    public abstract void pedirVacaciones();

}
