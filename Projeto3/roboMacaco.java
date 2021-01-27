package Projeto3;

enum energia {

    pequena(25),
    media(50),
    grande(100);

    int celulaCarregador;

    energia(int celulaCarregador){
        this.celulaCarregador = celulaCarregador;
    }

    public String toString() {
        return "Energia adicionada:" + this.celulaCarregador;
    }
}

public class roboMacaco{
    energia central;
    int dinheiro;
    int dano;
    int bateria;
    int bateMax;
    int resistencia;
    boolean quebrado;


    roboMacaco(int dinheiro, int resistencia, energia central, int dano, int bateria, boolean quebrado){
        this.dano = dano;
        this.dinheiro = dinheiro;
        this.resistencia = resistencia;
        this.quebrado = false;
        this.central = null;
        this.bateria = bateria;
        this.bateMax = bateria;
    }

    public String toString(){
        return "Robo Macaco : bateria:" + bateria + " dano:" + dano + " resistencia:" + resistencia + " dinheiro:" + dinheiro + " central:" + central;
    }

    void carregar(energia Energia){
        if(central != null){
            System.out.println("já possui uma celula de energia");
            return;
        }
        central = Energia;
    }

    energia remover(){
        if(central == null){
            System.out.println("a celula de energia já foi retirada");
            return null;
        }

        energia aux = central;
        central = null;
        return aux;
    }

    void consumir(){
        if(central == null){
            System.out.println("não há nenhuma celula");
            return;
        }
        
        this.bateria += central.celulaCarregador;
        central.celulaCarregador = 0;
        central = null;
    }

    void escudoQuebrado(){
        if(resistencia == 1){
            resistencia = 0;
            System.out.println("seu escudo de resistencia foi quebrado");
        }
    }

    void duelo(roboMacaco other){
        if(other.quebrado){
            System.out.println("os sistemas falharam");
            return;
        }

        if(other.resistencia == 1){
            System.out.println("ele ainda tem escudo de resistencia");
            return;
        } 

        //Ataques
        if(other.dano > 0){
            other.dano -= 10;
            System.out.println("soco de macaco com ataque de bananas aereas");
        } else {
            other.quebrado = true;
            other.dinheiro -= 30;
            dinheiro += 30;
            System.out.println("destruição fatal. Você ganhou!");
        }
    }

    void dueloEmRelacaoAVoce(roboMacaco other){
        if(quebrado){
            System.out.println("você está quebrado");
            return;
        }
        if(resistencia == 1){
            System.out.println("você ainda tem seus escudos");
            return;
        }

        //Ataques
        if(dano > 0){
            dano -= 10;
            System.out.println("você tomou");
        } else {
            quebrado = true;
            dinheiro -= 30;
            other.dinheiro += 30;
            System.out.println("o inimigo te destruiu. Você perdeu!");
        }
    }

    void quebrarEscudo(roboMacaco other){
        if(other.resistencia == 1){
            System.out.println("você quebrou as defesas do seu adversario");
            other.resistencia = 0;
        }
    }

    void consertando(){
        if(quebrado = false){
            System.out.println("ainda estou operando");
            return;
        } 
        
        if (dinheiro>=70) {
            dinheiro -= 70;
            quebrado = false;
            System.out.println("pronto novamente para a batalha");
        } else {
            System.out.println("você não pode realizar o conserto");

        }
    }

    void inimigoConsertando(roboMacaco other){
        if(other.quebrado = false){
            System.out.println("ainda quero destruir");
            return;
        }
        
        if (other.dinheiro>=70) {
            other.dinheiro -= 70;
            other.quebrado = false;
            System.out.println("pronto novamente para a batalha");
        } else {
            System.out.println("ele não pode ser reparado");

        }
    }

    void reparo(){
        if(quebrado = true){
            System.out.println("ainda estou quebrado");
            return;
        }

        //reparo adicional
        if(bateria>=14 && dinheiro>=40){
            bateria -= 14;
            dinheiro -= 40;

            resistencia = 1;
            dano += 100;

        } else {
            System.out.println("você não possui recursos suficientes para aprimorar");
        }}

        void melhorar(){
            if(quebrado = true){
                System.out.println("ainda estou quebrado");
                return;
            }
    
            //aprimoramento adicional
            if(bateria>=68 && dinheiro>=100){
                bateria -= 68;
                dinheiro -= 100;
    
                bateMax += 10;
                dano += 300;
    
            } else {
                System.out.println("você não possui recursos suficientes para aprimorar");
            }
        }

            boolean fugir(int foraDaArena){
                if(quebrado){
                    System.out.println("os sistemas falharam");
                    return false;
                } else if(dano < 10){
                    System.out.println("eu nao consigo sair");
                    return false;
                } else if(bateria > foraDaArena){
                    System.out.println("fuga realizada com sucesso");
                    bateria -= foraDaArena;
                    return true;
                } else {
                System.out.println("minha bateria não é suficiente para realizar essa ação");
                return false;
            }
        
    }

    public static void main(String[] args) {
        roboMacaco Lineu = new roboMacaco(30, 1, null, 100, 0, false);
    System.out.println(Lineu);
        roboMacaco Mateus = new roboMacaco(30, 1, null, 150, 0, false);
    System.out.println(Mateus);

    energia forca = energia.grande;


    Lineu.carregar(forca);
    System.out.println(Lineu);
    Lineu.consumir();
    System.out.println(Lineu);

    energia meio = energia.media;


    Mateus.carregar(meio);
    System.out.println(Mateus);
    Mateus.consumir();
    System.out.println(Mateus);

    }

}


