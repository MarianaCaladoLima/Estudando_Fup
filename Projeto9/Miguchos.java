package Projeto9;
import java.util.*;

class Telefone{
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

    public Telefone(String label, String number){
        if(validate(number)){
            this.label = label;
            this.number = number;
        }
    }

    public Telefone(int serial){

    }

    public String toString(){
        return label + ":" + number;
    }
}

class Contact {
    String nome;
    ArrayList<Telefone> fones;

    void addNumero(String label, String number){
        fones.add(new Telefone(label, number));
        Null();
    }

    void removerNumero(int index){
        fones.remove(index);

    }

    void Null(){
        for(int i = 0; i < fones.size();){
            if(fones.get(i).label == null || fones.get(i).number == null){
                removerNumero(i);
            }
        }
    }

    public Contact(String nome, String label, String number){
        fones = new ArrayList<Telefone>();
        fones.add(new Telefone(label, number));
        this.nome = nome;
    }

    public String coloqueNome(){
        return nome;
    }

    void darNome(String nome){
        this.nome = nome;
    }

    public ArrayList<Telefone> coloqueNumero(){
        return fones;
    }

    void colocarNumero(ArrayList<Telefone> fones){
        this.fones = fones;
    }

    public String toString(){
        return "Nome: " + nome + "Telefone: " + fones;
    }
}

public class Miguchos{
    private ArrayList<Contact> listadecontacts;
    private ArrayList<Contact> booksmarks;

    public int searchContact(String nome){
        for(int i = 0; i < listadecontacts.size(); i++){
            if(listadecontacts.get(i).coloqueNome() == nome){
                return i;
            }
        }
        return -1;
    }

    public void addContato(String nome, Telefone fones){
        if(searchContact(nome) != -1){
            System.out.println("Esse nome já foi salvo anteriormente");
        } else {
            listadecontacts.add(new Contact(nome, fones.label, fones.number));
        }
    }

    public boolean removerContato(String nome){
        int aux = searchContact(nome);
        if(aux == -1){
            System.out.println("Contato inexistente");
            return false;
        } else {
            listadecontacts.remove(aux);
            return true;
        }
    }

    public ArrayList<Contact> pesquisar(String pattern){
        ArrayList<Contact> xua = new ArrayList<>();
        for(int i = 0; i < listadecontacts.size(); i++){
            if(listadecontacts.get(i).toString().contains(pattern)){
                xua.add(i, listadecontacts.get(i));
            }
        }
        return xua;
    }

    public ArrayList<Contact> verContacts(String nome){
        return listadecontacts;
    }

    boolean Book(String id){
        String uxa;
        uxa = "@ " + id;
        for(int i = 0; i < booksmarks.size(); i++){
            if(listadecontacts.get(i).coloqueNome().equals(uxa)){
                return false;
            }
        }
        return true;
    }

    public void bookmark(String id){
        String ed;
        if(Book(id)){
            ed = "@ " + id;
            for(int i = 0; i < listadecontacts.size(); i++){
                if(listadecontacts.get(i).coloqueNome().equals(id)){
                    listadecontacts.get(i).darNome(ed);
                    booksmarks.add(listadecontacts.get(i));
                }
            }
        }
    }

    public void unBookmark(String id){
        if(Book(id)){
            System.out.println("Erro... esse contato n existe");
        } else {
            String naoAguentoMais = "@ " + id;
            for(int i = 0; i < booksmarks.size(); i++){
                if(booksmarks.get(i).coloqueNome().equals(naoAguentoMais)){
                    booksmarks.remove(i);
                }
            }
            for(int i = 0; i < listadecontacts.size(); i++){
                if(listadecontacts.get(i).coloqueNome().equals(naoAguentoMais)){
                    listadecontacts.get(i).darNome(id);
                }
            }
        }
    }

    public ArrayList<Contact> getBookmarks(){
        return booksmarks;
    }

    public Miguchos(){
        listadecontacts = new ArrayList<Contact>();
        booksmarks = new ArrayList<Contact>();
    }

    public String toString(){
        return "Seus Contatos: " + listadecontacts + "Favoritos: " + booksmarks;
    }

    public static void main(String[] args){
        Miguchos miguchos = new Miguchos();
        System.out.println(miguchos);
    }


}