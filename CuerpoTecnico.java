import poo.io.IO;
/**
 *
 * @author Juan Moreno Galbarro
 */
public class CuerpoTecnico extends MiembroClub implements Comparable {

    //CONSTANTES
    //Constantes para controlar el puesto en el CuerpoTecnico
    static final String PRIMERENTRENADOR = "primer entrenador";
    static final String SEGUNDOENTRENADOR = "segundo entrenador";
    static final String DELEGADODEPISTA = "delegado de pista";
    static final String UTILLERO = "utillero";
    static final String FISIO = "fisio";

    //ATRIBUTOS
    private int temporadasExperiencia; //Atributo entero que guardará el numero de temporadas que lleva ejerciendo su puesto de trabajo
    private String tipo; //Puede ser primer entrenador, segundo entrenador, delegado de pista, fisio o utillero.Se controlará con constantes
    private int numeroLicencia; //Numero de licencia de la federacion de cada uno de los miembros del cuerpo tecnico
    private String equipoProcedencia;
    /*Guardará el equipo anterior en el que ha ejercido su puesto.
                                     En el caso de que sea la primera vez que entrena, guardará "nunca ha ejercido su puesto"*/
    private Jugador[] quintetoInicial = new Jugador[5];

    //Constructor
    public CuerpoTecnico(String nombre, String apellidos, String dni, double salario, Fecha fechaAltaClub, int edad,
            int temporadasExperiencia, String equipoProcedencia, String tipo, int numeroLicencia) {
        super(nombre, apellidos, dni, salario, fechaAltaClub, edad);
        setTemporadasExperiencia(temporadasExperiencia);
        setEquipoProcedencia(equipoProcedencia);
        setTipo(tipo);
        setNumeroLicencia(numeroLicencia);

    }

    //Getters y setters
    //temporadasExperiencia
    public int getTemporadasExperiencia() {
        return temporadasExperiencia;
    }

    public void setTemporadasExperiencia(int temporadasExperiencia) {
        if (temporadasExperiencia < 0) {
            System.out.println("La experiencia de un miembro del cuerpo técnico no puede ser menor que 0");
            this.temporadasExperiencia = 0;
        } else {
            this.temporadasExperiencia = temporadasExperiencia;
        }
    }

    //equipo de procedencia
    public String getEquipoProcedencia() {
        return equipoProcedencia;
    }

    public void setEquipoProcedencia(String equipoProcedencia) {
        if (equipoProcedencia.equalsIgnoreCase("")) {
            this.equipoProcedencia = "Nunca ha ejercido este puesto";
        } else {
            this.equipoProcedencia = equipoProcedencia;
        }
    }

    //tipo(set controlado con constantes)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        //He utilizado el "toLowerCase()" para que aunque introduzca el contenido de la variable en mayusculas o con alguna mayuscula, 
        //el metodo set y el validamiento funcionen correctamente. Así tambien me ahorro tener que crear constantes con todas las variaciones
        // de mayusculas y minusculas de los valores de las constantes. Por ejemplo: "Utillero", "UTILLERO", "UtilleRO", etc
        tipo = tipo.toLowerCase();

        switch (tipo) {
            case PRIMERENTRENADOR:
            case SEGUNDOENTRENADOR:
            case DELEGADODEPISTA:
            case UTILLERO:
            case FISIO:
                this.tipo = tipo;
                break;
            default:
                System.out.println("El puesto en el cuerpo tecnico introducido es incorrecto. Los puestos posibles son: "
                        + "primer entrenador, segundo entrenador, delegado de pista, utillero y fisio");
                this.tipo = "SIN PUESTO DEFINIDO EN EL CUERPO TECNICO";
        }
    }

    //numeroLicencia de la federacion
    public int getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(int numeroLicencia) {
        if (numeroLicencia < 100000 || numeroLicencia > 999999) {
            System.out.println("El numero de licencia tan solo tiene 6 digitos");
            this.numeroLicencia = 999999;
        } else {
            this.numeroLicencia = numeroLicencia;
        }
    }

    //Metodo toString
    public String toString() {
        return super.toString()
                + "\n"
                + "Numero de licencia federativa: " + numeroLicencia
                + "\n"
                + "Equipo de procedencia: " + equipoProcedencia
                + "\n"
                + "tipo: " + tipo
                + "\n"
                + "Temporadas de experiencia: " + temporadasExperiencia
                + "\n";
    }

    //Metodo equals
    public boolean equals(Object o) {
        CuerpoTecnico c = (CuerpoTecnico) o;
        return super.equals(c) && numeroLicencia == c.numeroLicencia && tipo.equalsIgnoreCase(c.tipo) && temporadasExperiencia == c.temporadasExperiencia
                && equipoProcedencia.equalsIgnoreCase(c.equipoProcedencia);
    }

    //Metodo compareTo(apellidos y edad)
    @Override
    public int compareTo(Object o) {
        CuerpoTecnico ct = (CuerpoTecnico) o;
        int cmp = this.getApellidos().compareToIgnoreCase(ct.getApellidos());

        if (cmp == 0) {
            if (this.getEdad() > ct.getEdad()) {
                cmp = 1;
            } else if (this.getEdad() < ct.getEdad()) {
                cmp = -1;
            } else {
                cmp = 0;
            }
        }
        return cmp;
    }
    
    //Metodos implementados
    
    //apartarJugadorDelEquipo
    public void apartarJugadorDelEquipo(Jugador j, String motivo) {
        System.out.println("El jugador " + j.getNombre() + " " + j.getApellidos() + " " + "ha sido apartado del equipo por decision "
                + "del cuerpo tecnico por el siguiente motivo: "
                + "\n"
                + "   " + motivo
                + "\n"
                + "El club ha decidido suspenderle su sueldo este mes"
                + "\n");
    }
    //pedirFichajes(entrenador y segundo entrenador)
    public void pedirFichajes(int numeroFichajes) {
        if (numeroFichajes <= 0) {
            System.out.println("El número de fichajes pedidos no es válido.");
        }
        if (tipo.equalsIgnoreCase("primer entrenador") || tipo.equalsIgnoreCase("segundo entrenador")) {
            System.out.println("Perfecto señor " + getNombre() + ". Valoraremos su peticion en el proximo mercado de fichajes,");
            if (numeroFichajes > 3) {
                System.out.println("aunque debería minimizar el número de fichajes, nuestro presupuesto no nos permite pagar tantas fichas.");
            }
        } else {
            System.out.println("Lo sentimos señor " + getNombre() + ". Su puesto de " + tipo + " no le permite pedir fichajes a nuestro director deportivo."
                    + " Solo los entrenadores pueden hacer estas peticiones.");
        }
    }
    //aumentarSueldo(el sueldo maximo del cuerpo tecnico seran 3000 euros)
    public void aumentarSalario(int aumento) {
        double nuevosalario;
        nuevosalario = super.getSalario() + aumento;

        if (super.getSalario() == 3000) {
            System.out.println(nombre + " " + apellidos + " ya cobra el máximo permitido para un integrante del cuerpo técnico de nuestro club, que son 3000 €. No podemos aplicarle ningún aumento.");
        } else if (nuevosalario > 3000) {
            System.out.println("Con este aumento de salario " + nombre + " " + apellidos + " ha superado el máximo salarial para un jugador de nuestro club. Reajustaremos su salario al máximo permitido");
            super.setSalario(nuevosalario);
            System.out.println("Nuevo sueldo: " + nuevosalario + " €");
        } else {
            System.out.println("El sueldo de " + nombre + " " + apellidos + " ha sido aumentado. Su nuevo sueldo es: " + nuevosalario + " €");
        }
    }

    

    public void sacarQuintetoInicial() {
        String nombretitular, apellidotitular;
        
        System.out.println("Introduzca los nombres completos de los jugadores que formarán tu quinteto, Sr/a " + nombre + " " + apellidos);
        for (int i = 0; i < quintetoInicial.length; i++) {     
            int dorsalaleatorio = (int) Math.floor(Math.random()*99);
            System.out.println("Nombre: ");
            nombretitular = IO.readLine();
            System.out.println("Apellidos: ");
            apellidotitular = IO.readLine();
            quintetoInicial[i] = new Jugador(nombretitular, apellidotitular,dorsalaleatorio);

        }
       
        //Sacamos por pantalla las posiciones del array ordenados como un quinteto de baloncesto
        System.out.println("               " + quintetoInicial[0].getNombre() + " "+quintetoInicial[0].getApellidos() +" #"+ quintetoInicial[0].getDorsal()+"          ");
        System.out.println(quintetoInicial[1].getNombre() + " "+quintetoInicial[1].getApellidos()  +" #"+quintetoInicial[1].getDorsal()+ "                      " + quintetoInicial[2].getNombre() + " "+quintetoInicial[2].getApellidos() +" #"+quintetoInicial[2].getDorsal());
        System.out.println("                                                                                                                   ");
        System.out.println("     "+quintetoInicial[3].getNombre() + " "+quintetoInicial[3].getApellidos() +" #"+quintetoInicial[3].getDorsal() + "          " + quintetoInicial[4].getNombre() + " "+quintetoInicial[4].getApellidos()+" #"+quintetoInicial[4].getDorsal()+"     ");
    }

}
