
/**
 * Write a description of class ListaCSE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
class Nodo {
    int dato;
    Nodo siguiente;

    Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

public class ListaCSE{
    private Nodo cabeza = null;
    private Nodo cola = null;

    public void agregar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
        } else {
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
            cola.siguiente = cabeza;
        }
    }

    public void intercambiar(int i, int j) {
        if (i == j) return; // No es necesario intercambiar si los índices son iguales

        Nodo prevI = null, prevJ = null, currI = cabeza, currJ = cabeza;
        Nodo nodoI = null, nodoJ = null;

        int indice = 0;
        do {
            if (indice == i - 1) prevI = currI;
            if (indice == j - 1) prevJ = currJ;
            if (indice == i) nodoI = currI;
            if (indice == j) nodoJ = currJ;

            currI = currI.siguiente;
            currJ = currJ.siguiente;
            indice++;
        } while (currI != cabeza);

        if (nodoI == null || nodoJ == null) return; // Índices fuera de rango

        if (prevI != null) prevI.siguiente = nodoJ;
        else cabeza = nodoJ;

        if (prevJ != null) prevJ.siguiente = nodoI;
        else cabeza = nodoI;

        Nodo temp = nodoI.siguiente;
        nodoI.siguiente = nodoJ.siguiente;
        nodoJ.siguiente = temp;

        // Manejar el caso cuando los nodos son adyacentes
        if (i + 1 == j) {
            prevI.siguiente = nodoJ;
            nodoJ.siguiente = nodoI;
            nodoI.siguiente = currJ;
        } else if (j + 1 == i) {
            prevJ.siguiente = nodoI;
            nodoI.siguiente = nodoJ;
            nodoJ.siguiente = currI;
        }
    }

    public String[] imprimir() {
        if (cabeza == null) return new String[0];

        Nodo actual = cabeza;
        List<String> elementos = new ArrayList<>();

        do {
            elementos.add(Integer.toString(actual.dato));
            actual = actual.siguiente;
        } while (actual != cabeza);

        return elementos.toArray(new String[0]);
    }

    public static void main(String[] args) {
        ListaCircularSimplementeEnlazada lista = new ListaCircularSimplementeEnlazada();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(4);

        System.out.println("Lista original: " + Arrays.toString(lista.imprimir()));

        lista.intercambiar(1, 3);
        System.out.println("Después de intercambiar(1, 3): " + Arrays.toString(lista.imprimir()));

        lista.intercambiar(0, 2);
        System.out.println("Después de intercambiar(0, 2): " + Arrays.toString(lista.imprimir()));
    }
}

