import java.util.Comparator;
/**
 *
 * @author Juan
 */
public class ComparadorDorsal implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Jugador j1 = (Jugador)o1;
        Jugador j2 = (Jugador)o2;
        
        int dorsal1=j1.getDorsal();
        int dorsal2=j2.getDorsal();
        int cmp;
        
        if(dorsal1>dorsal2){
            cmp = 1;
        }
        else if(dorsal1<dorsal2){
            cmp=-1;
        }
        else {
            //si los dorsales son iguales, los compararemos con el metodo compareTo implementado en la clase jugador
            cmp=j1.compareTo(j2);
        }
        return cmp;
      
    }
    
}
