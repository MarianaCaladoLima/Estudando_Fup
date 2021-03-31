package Projeto7;
import java.util.*;

class Pessoa {
    int idade;
    String id;

    public Pessoa(int idade, String id){
        this.idade = idade;
        this.id = id;
    }

    public String toString(){
        return "Idade: " + idade + "Id: " + id ;
    }

}

public class Buzao {
    private ArrayList<Pessoa> assentos;
    private int preferencial;


    public Buzao(int area, int preferencial){
        Random r = new Random();
        int aux;
        assentos = new ArrayList<Pessoa>();
        for(int i = 0; i < area; i++){
            assentos.add(new Pessoa(0, null));
        }
        for(int i = 0; i < this.preferencial; i++){
            aux = r.nextInt(area);
            assentos.set(aux, new Pessoa(0, "@ "));
        }
    }

    public int find(String id){
        for(int i = 0; i < assentos.size(); i++){
            if(assentos.get(i).id.equals(id)){
                return i;
            }
        }
        return -1;
    }



    public int procurarAssento(int inicio, int fim){
        for(int i = inicio; i <= fim; i++){
            if(assentos.get(i).id == null){
                return i;
            }
        }
        return -1;
    }

    public int vagaPreferencial(int inicio, int fim){
        for(int i = inicio; i <= fim; i++){
            if("@ ".equals(assentos.get(i).id)){
                return i;
            }
        }
        return -1;
    }

    public boolean subir(Pessoa pessoa){
        int vaga = 0;
        if(pessoa.idade > 60){
            vaga = vagaPreferencial(1, assentos.size());
            assentos.set(vaga, new Pessoa(pessoa.idade, "@" + pessoa.id)); 
        }else{ 
            vaga = procurarAssento(1, assentos.size());
            assentos.set(vaga, pessoa);
        }
        return false;
    }

    public Pessoa sair(String id){
        int ind;
        ind = find(id);
        assentos.set(ind, new Pessoa(0, null));
        return null;
    }

    public String toString(){
        return "Assentos: " + assentos;
    }

    public static void main(String[] args){
        Buzao buzao = new Buzao(12, 4);
        Scanner ler = new Scanner(System.in);
        while(true){
            String line = ler.nextLine();
            String ui[] = line.split(" ");
            if(ui[0].equals("end")){
                break;
            } else if(ui[0].equals("init")){
                System.out.println("De as informaçoes do passageiro");
                String id = ler.nextLine();
                int idade = ler.nextInt();
                buzao.subir(new Pessoa(idade, id));
            } else if(ui[0].equals("descer")){
                String remover = ler.nextLine();
                buzao.sair(remover);
            } else if(ui[0].equals("printar")){
                System.out.println(buzao);
            } else {
                System.out.println("ERRO");
            }
            ler.close();
        }
        
    }
}
