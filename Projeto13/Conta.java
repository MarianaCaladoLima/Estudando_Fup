package Projeto13;
import java.util.*;

class Cliente {
    String id;
    ArrayList<Conta> contas;

    public Cliente(String id){
        this.id = id;
    }

    public String toString(){
        return "pinto de travesti gay";
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

    }

    public void atualizacaoMensal(){

    }
}

class ContaPoupanca extends Conta{
    float rendimento;

    public ContaPoupanca(String id, String idCliente){

    }

    public void atualizacaoMensal(){

    }
}

public class Conta{
    int id;
    float saldo;
    String idCliente;
    String type;

    public Conta(String id, String idCliente){

    }

    public void sacar(float value){

    }

    public void depositar(float value){

    }

    public void transferir(Conta other, float value){

    }
    
    public void atualizacaoMensal(){

    }
    
    public String toString(){
        return "";
    }


    public static void main(String[] args) {
        
    }
}
