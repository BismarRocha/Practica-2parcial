
/**
 * Write a description of class ListaCSE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
class Nodo {
    int dato;
    Nodo suc;

    Nodo(int dato) {
        this.dato = dato;
        this.suc = null;
    }
}

public class ListaCSE{
    private Nodo ini = null;
    private Nodo ult = null;

    public void agregar(int dato) {
        Nodo p = new Nodo(dato);
        if (ini == null) {
            ini = p;
            ult = p;
            p.suc = ini;
        } else {
            ult.suc = p;
            ult = p;
            ult.suc = ini;
        }
    }

    private Nodo[] encontrarNodo(Nodo actual, Nodo previo, int indiceActual, int indiceObjetivo) {
        if (indiceActual == indiceObjetivo) {
            return new Nodo[] {previo, actual};
        }
        return encontrarNodo(actual.suc, actual, indiceActual + 1, indiceObjetivo);
    }

    public void intercambiar(int i, int j) {
        if (i == j || ini == null) return;

        Nodo[] resultadoI = encontrarNodo(ini, null, 0, i);
        Nodo[] resultadoJ = encontrarNodo(ini, null, 0, j);

        Nodo prevI = resultadoI[0];
        Nodo nodoI = resultadoI[1];
        Nodo prevJ = resultadoJ[0];
        Nodo nodoJ = resultadoJ[1];

        if (nodoI == null || nodoJ == null) return; 

        if (prevI != null){
            prevI.suc = nodoJ;
        } 
        else{
            ini = nodoJ;
        }

        if (prevJ != null){
            prevJ.suc = nodoI;
        }
        else {
            ini = nodoI;
        } 

        Nodo temp = nodoI.suc; 
        nodoI.suc = nodoJ.suc;
        nodoJ.suc = temp;

        if (i + 1 == j) {
            if (prevI != null){
                prevI.suc = nodoJ;
                nodoJ.suc = nodoI;
                nodoI.suc = nodoJ.suc.suc;
            }           
        } else if (j + 1 == i) {
            if (prevJ != null){
                prevJ.suc = nodoI;
                nodoI.suc = nodoJ;
                nodoJ.suc = nodoI.suc.suc;
            }         
        }
    }

    public String[] imprimir() {
        if (ini == null) return new String[0]; 

        Nodo actual = ini;
        List<String> elementos = new ArrayList<>();

        do {
            elementos.add(Integer.toString(actual.dato));
            actual = actual.suc;
        } while (actual != ini);

        return elementos.toArray(new String[0]);
    }

}

