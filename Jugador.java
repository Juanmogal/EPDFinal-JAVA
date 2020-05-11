
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 *
 * @author Juan Moreno Galbarro
 */
public class Jugador extends MiembroClub implements Comparable {

    //CONSTANTES
    //Constantes para controlar la posicion del jugador
    static final String BASE = "base";
    static final String ESCOLTA = "escolta";
    static final String ALERO = "alero";
    static final String PIVOT = "pivot";

    //Constantes para controlar el rol del jugador en el equipo
    static final String ESTRELLA = "estrella";
    static final String PROMESA = "promesa";
    static final String TITULAR = "titular";
    static final String SUPLENTE = "suplente";

    //Atributos
    private int dorsal;
    /*Entero que muestra el numero de la camiseta del jugador*/
    private boolean canterano;
    /*Booleano que devuelve true si el jugador viene de las categorias inferiores del club*/
    private String posicion;
    /*Guarda la posición en la que juega el jugador.Las posiciones solo podran ser 4, que serán controladas con constantes:
                                -Base
                                -Escolta
                                -Alero
                                -Pivot*/
    private double altura;
    private double peso;
    private String equipoProcedencia;/*Guardará el equipo anterior en el que ha jugado. 
                                       En el caso de que sea canterano(boolean canterano), el "equipoProcedencia" 
                                       será "Categorias inferiores del Club Baloncesto Montellano"*/
    private int anyosContrato;
    private String rolEquipo;

    private double[] estadisticas = new double[3];

    
    //Constructor
    public Jugador(String nombre, String apellidos, String dni, double salario, Fecha fechaAltaClub, int edad, int dorsal,
            String posicion, double altura, double peso, String equipoProcedencia,int anyosContrato, String rolEquipo) {

        super(nombre, apellidos, dni, salario, fechaAltaClub, edad);
        setDorsal(dorsal);
        setPosicion(posicion);
        setAltura(altura);
        setPeso(peso);
        setEquipoProcedencia(equipoProcedencia);
        setRolEquipo(rolEquipo);
    }

    public Jugador(String nombre, String apellidos, int dorsal) {
        super(nombre, apellidos);
        this.dorsal = dorsal;
    }

    //Getters y setters
    //dorsal
    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        if (dorsal < 0 || dorsal > 99) {
            System.out.println("ERROR: El dorsal del jugador debe estar entre el 0 y el 99");
            this.dorsal = 0;
        } else {
            this.dorsal = dorsal;
        }
    }

    //canterano
    public boolean isCanterano() {
        return canterano;
    }

    public void setCanterano(boolean canterano) {
        this.canterano = canterano;
    }

    //posicion
    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        //He utilizado el "toLowerCase()" para que aunque introduzca el contenido de la variable en mayusculas o con alguna mayuscula, 
        //el metodo set y el validamiento funcionen correctamente. Así tambien me ahorro tener que crear constantes con todas las variaciones
        // de mayusculas y minusculas de los valores de las constantes. Por ejemplo: "Base", "BaSE", "bASE", etc
        posicion = posicion.toLowerCase();
        switch (posicion) {
            case BASE:
            case ESCOLTA:
            case ALERO:
            case PIVOT:
                this.posicion = posicion;
                break;
            default:
                System.out.println("La posicion introducida es incorrecta. Las posiciones posibles para un jugador son: "
                        + "base,escolta,alero y pivot");
                this.posicion = "SIN POSICION DEFINIDA EN EL EQUIPO";
        }
    }

    //altura
    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura < 0) {
            System.out.println("ERROR: La altura no puede ser menor que 0");
            this.altura = 0;
        } else {
            this.altura = altura;
        }
    }

    //peso
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso < 0) {
            System.out.println("ERROR: El peso no puede ser menor que 0");
            this.peso = 0;
        } else {
            this.peso = peso;
        }
    }

    //equipoProcedencia
    public String getEquipoProcedencia() {
        return equipoProcedencia;
    }

    public void setEquipoProcedencia(String equipoProcedencia) {
        if (canterano == true) {
            this.equipoProcedencia = "Categorias inferiores";
        } else {
            this.equipoProcedencia = equipoProcedencia;
        }
    }

    //Estadisticas
    public double[] getEstadisticas() {
        return estadisticas;
    }

    //Rol Equipo
    public String getRolEquipo() {
        return rolEquipo;
    }
    
    //Años de contrato

    public int getAnyosContrato() {
        return anyosContrato;
    }

    public void setAnyosContrato(int anyosContrato) {
        this.anyosContrato = anyosContrato;
    }
    

    public void setRolEquipo(String rolEquipo) {
        //He utilizado el "toLowerCase()" para que aunque introduzca el contenido de la variable en mayusculas o con alguna mayuscula, 
        //el metodo set y el validamiento funcionen correctamente. Así tambien me ahorro tener que crear constantes con todas las variaciones
        // de mayusculas y minusculas de los valores de las constantes. Por ejemplo: "Estrella", "eStrElla", etc
        rolEquipo = rolEquipo.toLowerCase();
        switch (rolEquipo) {
            case ESTRELLA:
            case PROMESA:
            case TITULAR:
            case SUPLENTE:
                this.rolEquipo = rolEquipo;
                break;
            default:
                System.out.println("El rol introducido es incorrecto. Los roles posibles para un jugador son: "
                        + "estrella, promesa, titular y suplente");
                this.rolEquipo = "SIN ROL DEFINIDO EN EL EQUIPO";
        }
    }

    //Metodo toString
    public String toString() {
        return "JUGADOR CLUB BALONCESTO MONTELLANO:"
                + "\n"
                + super.toString()
                + "\n"
                + "dorsal: " + dorsal
                + "\n"
                + "altura: " + altura
                + "\n"
                + "peso: " + peso
                + "\n"
                + "posicion: " + posicion
                + "\n"
                + "Años de contrato: " + anyosContrato
                + "\n"
                + "¿Es canterano? " + canterano
                + "\n"
                + "Rol en el equipo: " + rolEquipo
                + "\n"
                + "Equipo de procedencia " + equipoProcedencia
                + "\n";
    }

    //Metodo equals
    public boolean equals(Object o) {
        Jugador j = (Jugador) o;
        return super.equals(j) && dorsal == j.dorsal && altura == j.altura && canterano == j.canterano && posicion.equalsIgnoreCase(j.posicion)
                && peso == j.peso && equipoProcedencia.equalsIgnoreCase(j.equipoProcedencia) && rolEquipo.equalsIgnoreCase(j.rolEquipo) && anyosContrato == j.anyosContrato;
    }

    //Metodo compare to
    @Override
    public int compareTo(Object o) {
        Jugador j = (Jugador) o;
        int cmp = this.getApellidos().compareToIgnoreCase(j.getApellidos());

        if (cmp == 0) {
            if (this.getEdad() > j.getEdad()) {
                cmp = 1;
            } else if (this.getEdad() < j.getEdad()) {
                cmp = -1;
            } else {
                cmp = 0;
            }
        }
        return cmp;
    }

    //Metodos implementados 
    public Fecha fechaFinalizacionContrato(){
        int anyoFinalizacion = fechaAltaClub.getAnyo()+anyosContrato;
        Fecha fechaFinalizacionContrato = new Fecha(fechaAltaClub.getDia(),fechaAltaClub.getMes(),anyoFinalizacion,fechaAltaClub.getHora(),fechaAltaClub.getMinutos());
        return fechaFinalizacionContrato;
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

    public void informeMedico() {
        System.out.println("INFORME MEDICO DEL JUGADOR: " + super.getNombre() + " " + super.getApellidos());
        if (peso < 80) {
            System.out.println("Tu peso es muy bajo para la exigencia de nuestra categoria. Ponte en contacto"
                    + "con nuestro nutricionista y sigue las pautas correspondientes.");
        }
        if (peso > 130) {
            System.out.println("Tu peso es elevado para la exigencia fisica de nuestra categoria y puedes tener problemas."
                    + "Ponte en contacto con el nutricionista y tomar medidas para solucionarlo lo antes posible");
        } else {
            System.out.println("Tu peso es correcto, sigue trabajando duro y controlando tu dieta.");
        }

    }

    public void pedirTraspaso(String equipoPedido) {
        //Creamos un objeto de la clase gregorian calendar
        Calendar c1 = new GregorianCalendar();
        int mes = c1.get(Calendar.MONTH) + 1;
        // Te permite pedir traspaso entre enero y febrero, o entre junio y agosto, ya que son los dos periodos de traspaso.
        if (mes == 1 || mes == 2) {
            System.out.println("PERIODO DE FICHAJES DE INVIERNO:"
                    + "\n"
                    + "Hemos recibido tu petición de traspaso a " + equipoPedido + ".Nos pondremos en contacto con ellos en cuanto podamos.");
        }
        if (mes >= 6 && mes <= 8) {
            System.out.println("PERIODO DE FICHAJES DE VERANO:"
                    + "\n"
                    + "Hemos recibido tu petición de traspaso a " + equipoPedido + ".Nos pondremos en contacto con ellos en cuanto podamos.");
        } else {
            System.out.println("No podemos ponernos en contacto con " + equipoPedido + "."
                    + "\n"
                    + "Actualmente no se puede negociar con ningún equipo,espere "
                    + "al siguiente periodo para poder pedir el traspaso.");
        }
    }

//   public void estadisticasJugadores() throws MyException{
//       if(djsdjsajdjsdsdad)
//           ddsdsdskd
//       for(int i=0;i<estadisticas.length;i++){
//           double estadistica = Math.random() * 20;
//           estadisticas[i] = estadistica;
//       }
//       else{
//               throw new MyException(BASE)
//               }]
//   }
    public void estadisticasJugadores() {
        /*Para no pisar las estadisticas de ningun jugador, 
         si el contenido es distinto de 0 es porque ya lo hemos llamado y por 
        lo tanto las estadisticas desde jugador o desde directivo, seran las mismas*/
        if (estadisticas[0] == 0) { 
            for (int i = 0; i < estadisticas.length; i++) {
                double estadistica = Math.random() * 20;
                estadisticas[i] = estadistica;
            }
        }
    }

    public void consultarEstadisticasJugador() {
        estadisticasJugadores();
        System.out.printf("Puntos: %.1f\n", + estadisticas[0]); 
        System.out.printf("Asistencias: %.1f\n", + estadisticas[1]);
        System.out.printf("Rebotes: %.1f\n", + estadisticas[2]);
    }

}
