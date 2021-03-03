package Projeto5;
import java.util.*;

class Fone {
    private String label;
    private String number;

    public Fone(String label, String number){
        this.label = label;
        this.number = number;
    }

    public String toString(){
        return label + ":" + number;
    }

    public static Boolean validate(String number){
        int n = 0;
        String validacao = "1234567890";
        String value[] = new String[10];
        String numero[] = new String[number.length()];
        value = validacao.split("");
        numero = number.split("");
        for (int i = 0; i < numero.length; i++){
            for (int m = 0; m < value.length; m++){
                if(numero[i].equals(value[m])){
                    n++;

            }
        }
    }

    if(n < numero.length){
        System.out.println("numero invalido");
        return false;
    }else{
        return true;
    }

}}

public class contato {
    private String nome;
    private ArrayList<Fone> fones;
    
    public void addFone(String label, String number){
        fones.add(new Fone(label, number));
    }

    public void deleteFone(int index){
        fones.remove(index);
    }

    public contato(String nome){
        this.nome = nome;
        fones = new ArrayList<>();
    }

    public String toString(){
        return "nome: " + nome + "numero: " + fones;
    }

    public static void main(String args[]){
        contato Vinicios13 = new contato("Viado");
        Vinicios13.addFone("é muito viado", "yeiu");
        System.out.println(Vinicios13);
    }
}