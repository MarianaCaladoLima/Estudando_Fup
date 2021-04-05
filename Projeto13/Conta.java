package Projeto13;
import java.util.*;

class Cliente {
    String id;
    ArrayList<Conta> contas;

    public Cliente(String id){
        this.id = id;
        contas = new ArrayList<Conta>();
    }

    public String toString(){
        return "ID: " + id;
    }
}

class Agencia{
    ArrayList<Cliente> clientes;
    ArrayList<Conta> contas;

    public void Cliente(String id){

    }

    public void adicionarCliente(String id){

    }
}

class ContaCorrente extends Conta{
    float tarifaMensal;

    public ContaCorrente(String id, String idCliente){
        super(id, idCliente);
        this.type = "CC";
    }

    public void atualizacaoMensal(){

    }
}

class ContaPoupanca extends Conta{
    float rendimento;

    public ContaPoupanca(String id, String idCliente){
        super(id, idCliente);
        this.type = "CP";
    }

    public void atualizacaoMensal(){

    }
}

public class Conta{
    int id;
    float saldo;
    String idCliente;
    String type;

    public Conta(int id, String idCliente){
        this.id = id;
        this.saldo = 0;
        this.idCliente = idCliente;
        this.type = "";
    }

    public void sacar(float value){
        if(value <= 0){
            throw new RuntimeException("Valor negativo/nulo nao é permitido");
        } else if(value > this.saldo) {
            throw new RuntimeException("você nao tem saldo");
        } else {
            this.saldo -= value;
        }

    }

    public void depositar(float value){

    }

    public void transferir(Conta other, float value){

    }
    
    public void atualizacaoMensal(){

    }
    
    public String toString(){
        return "ID: " + id + "Saldo: " + saldo + "ID Do Cliente: " + idCliente + "Tipo: " + type;
    }


    public static void main(String[] args){
        Scanner vivo = new Scanner(System.in);
        while(true){
            String line = vivo.nextLine();
            String ui[] = line.split(" ");
            if(ui[0].equals("end")){
                break;
            } else if(ui[0].equals("add")){
                
            }
        }
        vivo.close();
    }
}
