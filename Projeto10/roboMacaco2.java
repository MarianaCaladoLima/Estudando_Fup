package Projeto10;

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

public class roboMacaco2{
    energia central;
    String nome;
    int dinheiro;
    int dano;
    int bateria;
    int bateMax;
    boolean resistencia;
    boolean quebrado;


    roboMacaco2(String nome, int dinheiro, boolean resistencia, energia central, int dano, int bateria, boolean quebrado){
        this.nome = nome;
        this.dano = dano;
        this.dinheiro = dinheiro;
        this.resistencia = true;
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
        if(central != null){
            this.bateria += central.celulaCarregador;
            central.celulaCarregador = 0;
            central = null;
        } else {

        throw new NullPointerException("não há nenhuma celula");
    }}

    void escudoQuebrado(boolean resistencia){
        if(resistencia = true){
            resistencia = false;
            System.out.println("Escudo quebrado");
        }
    }

    void duelo(roboMacaco2 other){
        if(other.quebrado){
            System.out.println("os sistemas falharam");
            return;
        }

        if(other.resistencia = true){
            System.out.println("ele ainda tem escudo de resistencia");
            return;
        } else {
            if(other.dano > 0){
            other.dano -= 10;
            System.out.println("soco de macaco com ataque de bananas aereas");
        } else {
            other.quebrado = true;
            other.dinheiro -= 30;
            dinheiro += 30;
            System.out.println("destruição fatal. Você ganhou!");
        }
    }}

    void dueloEmRelacaoAVoce(roboMacaco2 other){
        if(quebrado){
            System.out.println("você está quebrado");
            return;
        }
        if(resistencia = true){
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

    void quebrarEscudo(roboMacaco2 other){
        if(other.resistencia = true){
            System.out.println("você quebrou as defesas do seu adversario");
            other.resistencia = false;
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

    void inimigoConsertando(roboMacaco2 other){
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

            resistencia = true;
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
        roboMacaco2 Lineu = new roboMacaco2("Lineu", 30, true, null, 100, 0, false);
    System.out.println(Lineu);
        roboMacaco2 Mateus = new roboMacaco2("Mateus", 30, true, null, 150, 0, false);
    System.out.println(Mateus);

    try{

    energia forca = energia.grande;

    Lineu.carregar(forca);
    System.out.println(Lineu);
    Lineu.consumir();
    Lineu.consumir();
    System.out.println(Lineu);

} catch(NullPointerException e){
    System.out.println(e.getMessage());
} catch(RuntimeException e){
    System.out.println(e.getMessage());
} finally {
    System.out.println("eu so quero acabar logo T-T");
}

try{
    energia meio = energia.media;


    Mateus.carregar(meio);
    System.out.println(Mateus);
    Mateus.consumir();
    Mateus.consumir();
    System.out.println(Mateus);
    
} catch(NullPointerException e){
    System.out.println(e.getMessage());
} catch(RuntimeException e){
    System.out.println(e.getMessage());
} finally {
    System.out.println("eu so quero acabar logo T-T");
}

System.out.println(Lineu);
System.out.println(Mateus);

}}