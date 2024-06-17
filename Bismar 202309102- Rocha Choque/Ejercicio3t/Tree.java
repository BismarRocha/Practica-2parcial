
/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Tree<T>
{
    public ArrayList<Tree<T>> childs;
    public T data;
    
    public static <T> void mirarArbol(Tree<T> root){
        ArrayList<ArrayList<T>> niveles = new ArrayList<>();
        colectarNiveles(root, 0, niveles);
        
        for(ArrayList<T> nivel : niveles) {
            for(T item : nivel){
                System.out.print(item);
            }
            System.out.println();
        }
    }
    
    public static <T> void colectarNiveles(Tree<T> node, int nivel, ArrayList<ArrayList<T>> niveles){
        if(node == null){
            return;
        }
        
        if(niveles.size() <= nivel){
            niveles.add(new ArrayList<>());
        }
        niveles.get(nivel).add(node.data);
        
        for(Tree<T> child : node.childs){
            colectarNiveles(child, nivel +1, niveles);
        }
    }
}
