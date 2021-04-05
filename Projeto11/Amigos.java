package Projeto11;
import java.util.*;

import Projeto5.contato;

class Fone{
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

    public Fone(String label, String number){
        if(validate(number)){
        this.label = label;
        this.number = number;
    }}

    public Fone(int serial){

    }

    public String toString(){
        return label + ":" + number;
    }
}

class Contato{
    private String nome;
    private ArrayList<Fone> fones;

    void addNumero(String label, String number){
        fones.add(new Fone(label, number));
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

    public Contato(String nome){
        this.nome = nome;
    }

    public String coloqueNome(){
        return this.nome;
    }

    public boolean containskey(String nome){
        throw new UnsupportedOperationException("Vazio");
    }

    public ArrayList<Fone> coloqueNumero(){
        return fones;
    }

    public String toString(){
        return "Seus contatos: " + nome + fones;
    }
}

class ContatoStar extends Contato{
    private boolean star;

    public ContatoStar(String nome, List<Fone> fones){
        super(nome, fones);
    }

    public boolean getStar(){
        return star;
    }

    public void setStar(boolean value){
        if(this.star == value){
            throw new RuntimeException("Esse contato ja tem um valor");
        } else {
            this.star = value;
        }
    }

    public String toString(){
        return "";
    }
}

class Agenda{
    Map<String, Contato> contatos;

    public Agenda(){
        contatos = new TreeMap<>();
    }

    public int findPos(String nome){
        for(int i = 0; i < contatos.size(); i++){
            Contato aux = contatos.get(i);
            if(aux != null && aux.coloqueNome().equals(nome)){
                return i;
            }
        }
        return -1;
    }

    public void addContato(String nome, ArrayList<Fone> fones){
        Contato contato = contatos.get(nome);
        if(!contato.containskey(nome)){
            contatos.put(nome, new Contato(nome));
        } for(Fone fone : fones){
            contato.addNumero(fone.label, fone.number);
        }
    }

    public boolean rmContato(String nome){
        Contato contato = (ContatoStar) getContato(nome);
        contatos.remove(nome);
        return true;
    }

    public List<Contato> pesquisar(String pattern){
        List<Contato> aux = new ArrayList<>();
        for(Contato cano : contatos.values()){
            if(cano.toString().contains(pattern)){
                aux.add(cano);
            }
        }
        return aux;
    }

    ArrayList<Contato> getContatos(){
        return new ArrayList<Contato>(contatos.values());
    }

    Contato getContato(String name){
        Contato contato = contatos.get(name);
        if(contato == null){
            throw new RuntimeException("contato inexistente");
        }
        return contato;
    }

    public String toString(){
        return "Contatos:" + contatos;
    }
}

class AgendaStar extends Agenda{
    Map<String, ContatoStar> bookmarks;

    public AgendaStar(){
        bookmarks = new TreeMap<>();
        contatos = new TreeMap<>();
    }

    public List<Contato> getStarred(){
        return new ArrayList<Contato>(bookmarks.values());
    }

    public void star(String fod){
        Contato contato = this.getContato(fod);
        if(contato instanceof ContatoStar){
            ContatoStar geo = (ContatoStar) contato;
            if(!geo.getStar()){
                geo.setStar(true);
                bookmarks.put(fod, geo);
            }
        }
    }

    public void unStar(String fod){
        Contato contato = this.getContato(fod);
        if(contato instanceof ContatoStar){
            ContatoStar geo = (ContatoStar) contato;
            if(!geo.getStar()){
                geo.setStar(false);
                bookmarks.put(fod, geo);
            }
        }
    }

    public String toString(){
        return "Favoritos: " + bookmarks;
    }

}

public class Amigos {
    public static void main(String args[]){
        AgendaStar nova = new AgendaStar();
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                String line = scanner.nextLine();
                String ui[] = line.split(" ");
                if(ui[0].equals("End")){
                    break;
                } else if(ui[0].equals("add contato")){
                    List<Fone> fones = new ArrayList<>();
                    for(int i = 2; i < ui.length; i++){
                        fones.add(new Fone(ui[2], ui[3]));
                    } 
                    ContatoStar cfc = new ContatoStar(ui[1], fones);
                    if(ui[ui.length-1].equals(" ")){
                        cfc.setStar(true);
                    }
                    nova.addContato(cfc, fones);
                    System.out.println(nova);
                } else if(ui[0].equals("remover contato")){
                    nova.rmContato((ui[1]));
                } else if(ui[0].equals("pesquisar contato")){
                    System.out.println(nova.pesquisar(ui[1]));
                } else if(ui[0].equals("add estrela")){
                    nova.star(ui[1]);
                } else if(ui[0].equals("remover estrela")){
                    nova.unStar(ui[1]);
                } else if(ui[0].equals("all")){
                    System.out.println(nova.getStarred());
                } else {
                    System.out.println("ERRO");
                }
            } catch(ArrayIndexOutOfBoundsException e){
                throw e;
            } catch(RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
