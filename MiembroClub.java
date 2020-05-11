 
import java.util.Objects;

/**
 *
 * @author Juan Moreno Galbarro
 */
public abstract class MiembroClub implements ISocio,Cloneable {

    //Atributos
    protected String nombre;/*nombre del miembro*/
    protected String apellidos; /*apellidos del miembro*/
    private String dni;/*dni del miembro*/
    private boolean accionista;/*booleano que guardará true si el miembro del club tiene acciones y false si no las tiene*/
    private double salario;/*guarda el salario.Nunca podrá ser mayor de 2000€ porque el club no dispone de fondos suficientes*/
    public Fecha fechaAltaClub;/*Fecha de alta al club. La he puesto en publica porque necesito acceder desde la clase hija(cuerpo tecnico)*/
    private int edad;
    
    //Constructor
    public MiembroClub(String nombre, String apellidos, String dni,
                       double salario, Fecha fechaAltaClub,int edad) {
        
        setNombre(nombre);
        setApellidos(apellidos);
        setDni(dni);
        setSalario(salario);
        setFechaAltaClub(fechaAltaClub);
        setEdad(edad);
        
    }

    public MiembroClub(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    

    //Metodos consultores y modificadores
    //nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //apellidos
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    //dni
    public String getDni() {
        return dni;
    }
    //Podria poner el dni en privado ya que es algo que no se debe poder modificar, pero puede haber equivocaciones al crear el objeto
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    //salario
    public double getSalario() {
        return salario;
        
    }

    public void setSalario(double salario) {
        if (salario < 1000) {
            System.out.println("ERROR: El salario minimo para un miembro de este club es de 1000€.");
            this.salario = 1000;
        }
        if (salario > 5000) {
            System.out.println("No podemos pagarle mas de 2000 euros a un miembro de este club.Desgraciadamente, no disponemos de tanto presupuesto.");
            this.salario = 5000;
        }
        else this.salario = salario;   
    }

    //fechaAltaClub
    public Fecha getFechaAltaClub() {
        return fechaAltaClub;
    }
    //Al igual que en el dni, deberia ir en privado, pero lo dejo en publico por si hay algun error al crear el objeto
    public void setFechaAltaClub(Fecha fechaAltaClub) {
        this.fechaAltaClub = fechaAltaClub;
    }
    //edad

    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        if(edad<18){
            System.out.println("Ningún miembro de nuestro club puede ser menor de edad.");
            this.edad = 18;
        }
        else{
            this.edad = edad;
        }
    }
    //accionista
    public boolean isAccionista() {
        return accionista;
    }

    public void setAccionista(boolean accionista) {
        this.accionista = accionista;
    }

    //Metodo toString
    public String toString() {
        return "MIEMBRO CLUB BALONCESTO MONTELLANO:"
                + "\n"
                + "nombre: " + nombre
                + "\n"
                + "apellidos: " + apellidos
                + "\n"
                + "edad: " + edad
                + "\n"
                + "dni: " + dni
                + "\n"
                + "salario: " + salario
                + "\n"
                + "Fecha de Alta en el club: " + fechaAltaClub
                + "\n";
    }

    //Metodo equals
    public boolean equals(Object o) {
        MiembroClub m = (MiembroClub) o;
        return nombre.equalsIgnoreCase(m.nombre) && apellidos.equalsIgnoreCase(m.apellidos) && edad==m.edad && dni.equalsIgnoreCase(m.dni)
                && accionista == m.accionista && salario == m.salario && fechaAltaClub == m.fechaAltaClub;
    }
    //Redefinimos el metodo clone de la clase object
    public Object clone(){
        Object obj = null;
        try{
            obj = super.clone();
        } catch (CloneNotSupportedException ex){
            System.out.println("no se puede duplicar el objeto miembroclub");
        }
        return obj;
    }
   

    //Metodos implementados
    //Borrar miembro:Borra los datos de un miembro del club ya existente
    public void darDeBaja() { 
        nombre = "";
        apellidos = "";
        edad = 0;
        dni = "";
        accionista = false;
        salario = 0.0;
        //Ponemos a 1/1/1970 las fechas
        fechaAltaClub.setAnyo(1);
        fechaAltaClub.setDia(1);
        fechaAltaClub.setMes(1970);
        fechaAltaClub.setHora(12);
        fechaAltaClub.setMinutos(0);
    }
    
    //Aumentar sueldo(metodo abstract)
    public abstract void aumentarSalario(int aumento);

    
    //Comprar acciones
    public void comprarAcciones(int numeroAcciones){
        
        if(numeroAcciones <= 0){
            System.out.println("El minimo de acciones para comprar es 1.");
        }
             
        if (numeroAcciones>10){
            System.out.println("No puedes comprar más de 10 acciones.");
        }
             
            else System.out.println("Ahora eres accionista de este gran club. Tu número de acciones es: "+numeroAcciones);
         }
         
     
     
    
}
