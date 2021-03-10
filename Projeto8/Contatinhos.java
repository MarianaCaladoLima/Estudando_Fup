package Projeto8;
import java.util.*;


class Contato{
    String label;
    String number;

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
    }}

    public Contato(String label, String number){
        if(validate(number)){
        this.label = label;
        this.number = number;
    }}

    public Contato(int serial){

    }

    public String toString(){
        return label + ":" + number;
    }
}

class Telefone{
    private String nome;
    private ArrayList<Contato> fone;

    void addContato(String label, String number){
        fone.add(new Contato(label, number));
        Null();
    }

    void removerContato(int index){
        fone.remove(index);

    }

    void Null(){
        for(int i = 0; i < fone.size();){
            if(fone.get(i).label == null || fone.get(i).number == null){
                removerContato(i);
            }
        }
    }

    public Telefone(String nome, String label, String number){
        fone = new ArrayList<Contato>();
        fone.add(new Contato(label, number));
        this.nome = nome;
    }

    public String coloqueNome(){
        return nome;
    }

    public ArrayList<Contato> coloqueNumero(){
        return fone;
    }

    public String toString(){
        return "Nome: " + nome + "Telefone: " + fone;
    }
}

public class Contatinhos{
    private ArrayList<Telefone> amigos;

    public int Buscar(String nome){
        for(int i = 0; i < amigos.size(); i++){
            if(amigos.get(i).coloqueNome() == nome ){
                return i;
            }
        }
        return -1;
    }

    void Adicionar(String nome, Contato fone){
        if(Buscar(nome) != -1){
            System.out.println("Já tem um contato com esse nome, deseja substituir?");
        } else {
            amigos.add(new Telefone(nome, fone.label, fone.number));
        }
    }
    public boolean removerContatinho(String nome){
        int aux = Buscar(nome);
        if(aux == -1){
            System.out.println("Esse contato não existe");
            return false;
        } else {
            amigos.remove(aux);
            return true;
        }
    }

    public ArrayList<Telefone> busca(String add){
        ArrayList<Telefone> xua = new ArrayList<>();
        for(int i = 0; i < amigos.size(); i++){
            if(amigos.get(i).toString().contains(add)){
                xua.add(i, amigos.get(i));
            }
        }
        return xua;
    }

    public ArrayList<Telefone> contatos(String nome){
        return amigos;
    }

    public Contatinhos(){
        amigos = new ArrayList<Telefone>();
    }

    public String toString(){
        return "Seus contatos: " + amigos;
    }

    public static void main(String[] args){
        Contatinhos contatos = new Contatinhos();
        System.out.println(contatos);
    }
}