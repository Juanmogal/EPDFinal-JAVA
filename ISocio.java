/**
 *
 * @author Juan Moreno Galbarro
 */
public interface ISocio {
    //nombre
    public String getNombre();
    public void setNombre(String nombre);

    //apellidos
    public String getApellidos();
    public void setApellidos(String apellidos);

    //dni
    public String getDni();   
    public void setDni(String dni);

    //fechaAltaClub
    public Fecha getFechaAltaClub();     
    public void setFechaAltaClub(Fecha fechaAltaClub);
    
    
    
    //Da de baja a un miembro o a un aficionado, dependiendo del objeto que lo llame.
    //Pone todos los datos personales a cadena vacia o a 0, y la fecha la ponemos a 1/1/1970 12:00
    public void darDeBaja();
   
    //Compra el numero de acciones que se le pase por parametro, no pudiendo ser menos de 1 o mas de 10.
    public void comprarAcciones(int numeroAcciones);
    
    
}
  