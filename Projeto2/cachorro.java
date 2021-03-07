package Projeto2;
import java.util.Scanner;
public class cachorro{
    String nome;
    int energia;
    int enerMax;
    int interesse;
    int interMax;
    boolean sede;

    cachorro(String nome, int energia, int enerMax, int interesse, int interMax, boolean sede){
        this.nome = nome;
        this.energia = energia;
        this.enerMax = energia;
        this.interesse = interesse;
        this.interMax = interesse;
        this.sede = false;
    }

    public cachorro(String string, String string2, int parseInt) {
    }

    void sentar(int aprendizado){
        if(aprendizado>=2 && energia>0 && interesse>0){
            System.out.println("thacutu thacutu thatha thathacutu (batida de funk, eu sei, piada ruim)");
            energia-= 1;
        } else {
            System.out.println("?");
            interesse-= 1;
            aprendizado+= 1;
        }
    }

    void rolar(int aprendizado){
        if(aprendizado>=3 && energia>0 && interesse>=2){
            System.out.println("Girando Girando");
            energia-= 1;
        } else {
            System.out.println("?");
            interesse-= 2;
            aprendizado+= 1;
        }
    }

    void dePe(int aprendizado){
        if(aprendizado>=5 && energia>0 && interesse>=3){
            System.out.println("To de pé tutor! Olha!");
            energia-= 2;
        } else {
            System.out.println("?");
            interesse-= 3;
            aprendizado+= 1;
        }
    }

    void darMortal(int aprendizado){
        if(aprendizado>=8 && energia>0 && interesse>=4){
            System.out.println("yei!");
            energia-= 4;
            sede = true;
        } else {
            System.out.println("?");
            interesse-= 5;
            aprendizado+= 1;
        }
    }

    void duploTripoTwistCarpado(int aprendizado){
        if(aprendizado>=12 && energia>1 && interesse>=7){
            System.out.println("Daiane dos Santos");
            energia-= 6;
            interesse-= 1;
            sede = true;
        } else {
            System.out.println("?");
            interesse-= 8;
            sede = true;
            energia-= 3;
            aprendizado+= 1;
        }
    }


    boolean equals(cachorro other){
        return nome.equals(other.nome);
    }
    
    void beber(Boolean sede){
        if(sede = true){
            sede = false;
            System.out.println("Beber água é bom, mas nunca se esquecam de comer fruta tambem");
        }
    }

    void petisco(int turno){
        turno =  interesse;
        if(interesse > interMax){
            interesse = interMax;
        } 
        System.out.print("eu quero!");
    }
        public String toString(){
                return "Nome:" + nome + "Energia:" + energia + "Interesse:" + interesse + "Sede:" + sede; 
            }

    void descansar(int turno){
        energia+= turno;
        if(energia>enerMax){
            energia=enerMax;
        }
        System.out.println("zzzzzzz");
    }
        
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        cachorro cachorro = new cachorro("", "", 0);
          while(true){
              String line = scanner.nextLine();
              String[]ui = line.split("");
              if(ui[0].equals("end")){
                    break;
                } else if(ui[0].equals("init")){
                    cachorro = new cachorro(ui[1], ui[2], Integer.parseInt(ui[3]));
                } else if(ui[0].equals("show")){
                    System.out.println(cachorro);
                } else{
                    System.out.println("falha: comando invalido");
                }
            }
        scanner.close();
    }
}