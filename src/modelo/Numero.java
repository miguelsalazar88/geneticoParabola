package modelo;

import java.util.Random;

public class Numero implements Comparable<Numero> {

    private final String especimen; // 0010101010 // -115 115
    private final int calificacion; // y =
    private Random rnd = new Random();

    public Numero(String especimen) {
        this.especimen = especimen;
        this.calificacion = getCal(getDecimal(this.especimen));
    }

    public int getDecimal(String especimen){
        String decimalString = "";
        for (int i = 0; i < especimen.length()-1; i++) {
            decimalString += String.valueOf(especimen.charAt(i));
        }
        int binario = Integer.parseInt(decimalString);
        int decimal = 0;
        int n = 0;
        while(true){
            if(binario == 0){
                break;
            } else {
                int temp = binario%10;
                decimal += temp*Math.pow(2, n);
                binario = binario/10;
                n++;
            }
        }
        if(especimen.charAt(especimen.length()-1)=='0'){
            return decimal * -1;
        }
        else{
            return decimal;
        }

    }

    public int getCal(int x){
        if(x > 1023){
            return -1;
        }
        else if(x < -1023){
            return -1;
        }
        else{
            return (int) (-2*(Math.pow(x,2))+(5*x) +2); // -2x^2 + 5x +2
        }
    }
    public String crearhijo(Numero especimen2){

        int mitad = rnd.nextInt(8);
        String hijo = "";
        for (int i = 0; i < mitad; i++) {
            hijo += String.valueOf(this.especimen.charAt(i));
        }
        for (int i = mitad; i <especimen2.getEspecimen().length(); i++) {
            hijo += String.valueOf(especimen2.getEspecimen().charAt(i));
        }
        return hijo;
    }

    @Override
    public int compareTo(Numero o) {

        if(this.getCalificacion() > o.getCalificacion()){
            return -1;
        }
        else if(this.getCalificacion() == o.getCalificacion()){
            return 0;
        }
        else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Especimen: " + especimen + ", Calificación: " + calificacion;
    }

    public String getEspecimen() {
        return especimen;
    }

    public int getCalificacion() {
        return calificacion;
    }


}
