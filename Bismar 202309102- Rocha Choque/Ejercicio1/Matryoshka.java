
/**
 * Write a description of class Matryoshka here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class Matryoshka {

    String[] s;
    int n;
    public void construirS(String[] s){
        this.s= s;
    }
    
    public String[][] ordenar(String[] s) {        
        String[][] resul;
        construirS(s);
        for(int i =0; i< s.length ;i++){
            if(s[i] == "a"){
                n++;
            }
        }
        resul = new String[n][];
        for(int i = 0; i<n; i++){
            resul[i] = llenadoC(n);
        }
        return resul;
    }
    String res;
    private String recolectar(int i, int n){      
        if(n<=3 && s.length != 0){
            if(i < s.length){
                if(s[i] == "a" && n == 1){
                    res = "a";               
                    s = remove(s,i);
                    construirS(s);
                    i++;
                    n++;
                    recolectar(i,n);
                }
                else{
                    if(s[i] == "b" && n == 2){
                    res = res+"b";               
                    s = remove(s,i);
                    construirS(s);
                    i++;
                    n++;
                    recolectar(i,n);
                    }
                    else{
                        if(s[i] == "c" && n == 3){
                        res = res+"c";               
                        s = remove(s,i);
                        construirS(s);
                        i++;
                        n++;
                        recolectar(i,n);
                        }
                        else{
                        i++;
                        recolectar(i,n);
                        }
                    }
                }
            }
            else{
                i=0;
                recolectar(i,n);
            }
        }
        
        return res;
    }
    
    private String[] llenadoC(int n){
        String p = recolectar(0,1);
        char c;
        String[] resul = new String[p.length()];
        for(int i=0; i < p.length(); i++){
            c = p.charAt(i);
            resul[i] = String.valueOf(c);
        }
        return resul;
    }
    
    public String[] remove(String[] array, int index) {
        if (array == null || index < 0 || index >= array.length) {
            throw new IllegalArgumentException("Índice inválido");
        }

        // Crear un nuevo array con un tamaño reducido
        String[] nuevoArray = new String[array.length - 1];

        // Copiar los elementos excepto el que está en el índice a eliminar
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                nuevoArray[j++] = array[i];
            }
        }

        return nuevoArray;
    }

}