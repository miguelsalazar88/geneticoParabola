package app;

import modelo.Numero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class App {

    public static void main(String[] args) {

        ArrayList<Numero> poblacion = poblar();

        System.out.println("Lista Original: \n");

        for (Numero n: poblacion) {
            System.out.println(n.toString());
        }

        poblacion = reemplazar(poblacion, 1000);

        System.out.println("Lista Mejorada: \n");

        for (Numero n: poblacion) {
            System.out.println(n.toString());
        }

    }

    public static ArrayList<Numero> poblar(){

        Random rnd= new Random();

        ArrayList<Numero> poblacion = new ArrayList<Numero>();

        for (int i = 0; i <= 40 ; i++) {
            String num = "";
            for (int j = 0; j < 11; j++) {
                num += String.valueOf(rnd.nextInt(2));
            }
            poblacion.add(new Numero(num));
        }
        Collections.sort(poblacion);
        return poblacion;
    }

    public static ArrayList<Numero> reemplazar(ArrayList<Numero> poblacion, int veces){

        for (int i = 0; i < veces; i++) {

            for (int j = 0; j < 10; j++) {
                Numero n = new Numero(poblacion.get(j).crearhijo(poblacion.get(j+1)));
                if(n.getCalificacion() > poblacion.get(j).getCalificacion()
                    && n.getCalificacion() > poblacion.get(j+1).getCalificacion()){
                    poblacion.remove(j);
                    poblacion.add(n);
                }
            }
        }
        Collections.sort(poblacion);
        return poblacion;
    }

}
