package Projeto6;
import java.util.*;

class Espiral{
    String produto;
    int quantidade;
    int preco;

    public Espiral(String produto, int quantidade, int preco){
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String toString(){
        return "Produto: " + produto + "Quantidade: " + quantidade + "Preço: " + preco;
    }
}

public class JunkFood{
    private ArrayList<Espiral> espirais = new ArrayList<>();
    int saldo;
    int produtoMax;

    public JunkFood(){

    }

    public boolean addDinheiro(int totalInserido){
        this.saldo += totalInserido;
        return true;
    }

    void saldoDoElemento(){
        System.out.println(saldo);
    }

    void limparEspiral(int numero){
        espirais.set(numero, new Espiral(null, 0, 0));
    }

    public float troco(){
        this.saldo = 0;
        return 0;
    }

    public boolean alterarEspiral(int numero, String produto, int quantidade, int preco){
        espirais.set(numero, new Espiral(produto, quantidade, preco));
        return true;
    }

    public boolean comprar(int numero){
        if(numero < 0 || numero > espirais.size()){
            System.out.println("erro");
            return false;
        }
        if(espirais.get(numero) == null){
            System.out.println("A espiral está vazia");
            return false;
        }
        if(espirais.get(numero).quantidade == 0){
            System.out.println("os produtos acabaram");
            return false;
        }
        if(saldo > espirais.get(numero).preco){
            saldo = espirais.get(numero).preco;
            if(espirais.get(numero).quantidade > 1){
                espirais.get(numero).quantidade -= 1;
            } else {
                limparEspiral(numero);
            }
        }
        return true;
    }

    public String toString(){
        return "Espiral: " + espirais;
    }

    public static void main(String args[]){
        JunkFood maquina = new JunkFood();
        maquina.addDinheiro(0);
        ArrayList<Espiral> espirais = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            espirais.add(new Espiral("", 0, 0));
        }
        espirais.set(0, new Espiral("Saco de 7belo", 5, 1));
        espirais.set(1, new Espiral("MM", 3, 7));
        espirais.set(2, new Espiral("Kinder Ovo", 15, 20));
        espirais.set(3, new Espiral("Twix", 8, 3));
        espirais.set(4, new Espiral("Kit kat", 9, 4));
        espirais.set(5, new Espiral("Milka", 10, 9));
        espirais.set(6, new Espiral("Diamante negro", 4, 4));
        espirais.set(7, new Espiral("Cookie", 8, 5));

        Scanner analisar = new Scanner(System.in);
        while(true){
            String line = analisar.nextLine();
            int dinheiro = analisar.nextInt();
            String ui[] = line.split(" ");
            if(ui[0].equals("end")){
                break;
            } else if(ui[0].equals("Coloque dinheiro")){
                maquina.addDinheiro(dinheiro);
            } else if(ui[0].equals("comprar")){
                maquina.comprar(dinheiro);
            } else if(ui[0].equals("troco")){
                maquina.troco();
            } else {
                System.out.println("Erro");
            }
            analisar.close();
        }
    }
}