import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author Juan Moreno Galbarro
 */
public class Aficionado implements ISocio, Cloneable{
    
    //CONSTANTES
    //Constantes para controlar el tipo de aficionado
    static final String INFANTIL="infantil";
    static final String JUVENIL="juvenil";
    static final String ADULTO="adulto";
    static final String SENIOR="senior";
    static final String sksksk = "pepito";
    
    //Atributos
    private String nombre;/*nombre del aficionado*/
    private String apellidos; /*apellidos del aficionado*/
    private String dni;/*dni del aficionado*/
    private Fecha fechaAltaClub;/*Fecha de alta al club*/
    private String tipoAficionado; //Podrá ser infantil, juvenil, adulto o senior.
    private boolean accionista=false;/*booleano que guardará true si el aficionado del club tiene acciones y false si no las tiene.
                                 Sera true cuando se llame al metodo de comprar acciones*/
    private boolean aficionadoPremium=false;/*Booleano que guardará true si el aficionado es premium(tiene 10 años de antiguedad)
                                        Sera true cuando se llame al metodo de ser aficionado premium y cumpla los requisitos*/
    
  
    //Constructor        
    public Aficionado(String nombre, String apellidos, String dni,Fecha fechaAltaClub, String tipoAficionado) {
        setNombre(nombre);
        setApellidos(apellidos);
        setDni(dni);
        setFechaAltaClub(fechaAltaClub);
        setTipoAficionado(tipoAficionado);
    }
    //Getter y setter
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

    public void setDni(String dni) {
        this.dni = dni;
    }
    //FechaAlta
    public Fecha getFechaAltaClub() {
        return fechaAltaClub;
    }

    public void setFechaAltaClub(Fecha fechaAltaClub) {
        this.fechaAltaClub = fechaAltaClub;
    }
    //tipoAficionado
    public String getTipoAficionado() {
        return tipoAficionado;
    }

    public void setTipoAficionado(String tipoAficionado) {
        //He utilizado el "toLowerCase()" para que aunque introduzca el contenido de la variable en mayusculas o con alguna mayuscula, 
        //el metodo set y el validamiento funcionen correctamente. Así tambien me ahorro tener que crear constantes con todas las variaciones
        // de mayusculas y minusculas de los valores de las constantes. Por ejemplo: "INFANTIL", "inFANTIL", "Infantil", etc
        tipoAficionado = tipoAficionado.toLowerCase();
       switch(tipoAficionado){
            case INFANTIL:
            case JUVENIL:
            case ADULTO:
            case SENIOR:
                this.tipoAficionado= tipoAficionado;
        break;
            default:
                System.out.println("El tipo de aficionado introducido no es correcto. Los tipos de aficionados posibles son: "
                        + "infantil, juvenil, adulto y senior");
                this.tipoAficionado="SIN TIPO DE AFICIONADO DEFINIDO";
        }
       
    }
    //accionista
    public boolean isAccionista() {
        return accionista;
    }

    public void setAccionista(boolean accionista) {
        this.accionista = accionista;
    }
    //aficionado premium
    public boolean isAficionadoPremium() {
        return aficionadoPremium;
    }

    public void setAficionadoPremium(boolean aficionadoPremium) {
        this.aficionadoPremium = aficionadoPremium;
    }
    
    //Metodo toString
    public String toString() {
        return  "Nombre: " + nombre
                + "\n"
                + "Apellidos: " + apellidos
                + "\n"
                + "DNI: " + dni
                + "\n"
                + "Fecha de Alta en el club: " + fechaAltaClub
                + "\n"
                + "Tipo de aficionado: " + tipoAficionado
                + "\n";
    }
    
    //Metodo equals

     public boolean equals(Object o) {
        Aficionado a = (Aficionado) o;
        return nombre.equalsIgnoreCase(a.nombre) && apellidos.equalsIgnoreCase(a.apellidos) && dni.equalsIgnoreCase(a.dni) && fechaAltaClub == a.fechaAltaClub
                && tipoAficionado.equalsIgnoreCase(a.tipoAficionado);
    }
  //Redefinimos el metodo clone de la clase object
    public Object clone(){
        Object obj = null;
        try{
        obj = super.clone();
        }catch (CloneNotSupportedException ex) {
            System.out.println("no se puede duplicar");
        }
        
        return obj;
    }
            
     //Da de baja a un aficionado, poniendo a cadenas vacias sus atributos String, a false los boolean y a 1/1/1970 12:00 la fecha de alta del club
     public void darDeBaja(){
        nombre = "";
        apellidos = "";
        dni = "";
        tipoAficionado = "SIN TIPO DE AFICIONADO DEFINIDO";
        //Ponemos a 1/1/1970 las fechas
        fechaAltaClub.setAnyo(1);
        fechaAltaClub.setDia(1);
        fechaAltaClub.setMes(1970);
        fechaAltaClub.setHora(12);
        fechaAltaClub.setMinutos(0);
        accionista = false;

     }
     
     
     public void hacerseAficionadoPremium(){
         Calendar c2 = new GregorianCalendar();
           //Guardamos en anyoactual el año actual que hemos sacado creando un objeto de GregorianCalendar
           int anyoactual = c2.get(Calendar.YEAR);
           //Guardamos en anyoalta el año en el que se dio de alta, con el get de fechaAltaClub
           int anyoalta = fechaAltaClub.getAnyo();
           int antiguedad;
           
           //Guardamos en antiguedad los años que han pasado desde que se dio de alta en el club hasta el dia de hoy.
           antiguedad = anyoactual - anyoalta;
         
           if(antiguedad>=10){
               aficionadoPremium = true;
               System.out.println("ENHORABUENA. Ya eres aficionado premium de este gran club. Pasate por nuestras oficinas,"
                       + "tenemos un regalo para ti.");
           }
           else 
               aficionadoPremium = false;
               System.out.println("Lo sentimos, aun no cumples los requisitos para ser aficionado premium.Intentalo mas adelante");
         
     }
     
    public void comprarAcciones(int numeroAcciones){
         if(tipoAficionado.equalsIgnoreCase("infantil")){
             System.out.println("Tu carnet es intantil, por lo tanto no tienes la edad necesaria para comprar acciones");
         }
         if(tipoAficionado.equalsIgnoreCase("juvenil")){
             System.out.println("Tu carnet es juvenil, en cuanto tengas 18 puedes ser accionista, mientras tanto no");
         }
         
         if(tipoAficionado.equalsIgnoreCase("adulto") || tipoAficionado.equalsIgnoreCase("senior")){
             if(numeroAcciones <= 0){
                 System.out.println("El minimo de acciones para comprar es 1.");
             }
             
             if (numeroAcciones>10){
                 System.out.println("No puedes comprar más de 10 acciones.");
             }
             
             else System.out.println("Ahora eres accionista de este gran club. Tu número de acciones es: "+numeroAcciones);
         }
         
     
     }
     
}