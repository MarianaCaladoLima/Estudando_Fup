package Projeto4;
import java.util.Scanner;
enum alimento {

    camundongo(10),
    pintinho(20),
    ratoDeTelhado(30),
    ratazana(40),
    porquinhoDaIndia(50),
    coelho(60),
    frango(70);

    int saciedade;

    alimento(int saciedade){
        this.saciedade = saciedade;
    }

    public String toString(){
        return "Fome adicional:" + this.saciedade;
    }
}

public class cobra {

    alimento estomago;
    String nome;
    private int fome;
    private int fomeMax;
    private int energia;
    private int enerMax;
    private int hidratacao;
    private int hidraMax;
    private int temperatura;
    private int tempMax;
    private int furtividade;
    private int furtivMax;
    private int idade;
    private int dinheiro;
    private boolean vivo;

    cobra(int fomeMax, int enerMax, int hidraMax, int tempMax, int furtivMax){
        this.fomeMax = fomeMax;
        this.enerMax = enerMax;
        this.tempMax = tempMax;
        this.hidraMax = hidraMax;
        this.furtivMax = furtivMax;

        this.energia = this.enerMax;
        this.fome = this.fomeMax;
        this.temperatura = this.tempMax;
        this.hidratacao = this.hidraMax;
        this.furtividade = this.furtivMax;

        this.dinheiro = 0;
        this.idade = 0;
        this.vivo = true;
        this.estomago = null;
    }

    public cobra(String string, int parseInt, int parseInt2, int parseInt3, int parseInt4, int parseInt5) {
    }

    void setFome(int valor){
        this.fome = valor;

        if(this.energia <= 0){
            this.energia = 0;
            this.vivo = false;
            System.out.println("Sua cobra morreu de fome");
            return;
        }
        if(this.fome > this.fomeMax){
            this.fome = this.fomeMax;
        }
    }

    int getFome(){
        return this.fome;
    }

    void setEnergia(int valor){
        this.energia = valor;

        if(this.energia <= 0){
            this.energia = 0;
            this.vivo = false;
            System.out.println("Sua cobra morreu de sono");
            return;
        }
        if(this.energia > this.enerMax){
            this.energia = this.enerMax;
        }
    }

    int getEnergia(){
        return this.energia;
    }

    void setHidratacao(int valor){
        this.hidratacao = valor;

        if(this.hidratacao <= 0){
            this.hidratacao = 0;
            this.vivo = false;
            System.out.println("Sua cobra morreu de sede");
            return;
        }
        if(this.hidratacao > this.hidraMax){
            this.hidratacao = this.hidraMax;
        }
    }

    int getHidratacao(){
        return this.hidratacao;
    }

    void setTemperatura(int valor){
        this.temperatura = valor;

        if(this.temperatura <= 0){
            this.temperatura = 0;
            this.vivo = false;
            System.out.println("Sua cobra morreu por conta da temperatura desregulada");
            return;
        }
        if(this.temperatura > this.tempMax){
            this.temperatura = this.tempMax;
        }
    }

    int getTemperatura(){
        return this.temperatura;
    }

    void setFurtividade(int valor){
        this.furtividade = valor;

        if(this.furtividade <= 0){
            this.furtividade = 0;
            this.vivo = false;
            System.out.println("Sua cobra chamou atenção de um falcão que a levou e a matou");
            return;
        }
        if(this.furtividade > this.furtivMax){
            this.furtividade = this.furtivMax;
        }
    }

    int getFurtividade(){
        return this.furtividade;
    }

    boolean viver(){
        if(!vivo){
            System.out.println("Sua cobra está morta, você nâo pode mexer com ela");
            return false;
        }
        return true;
    }

    void alimentar(alimento rango){
        if(estomago != null){
            System.out.println("Sua cobra ainda está digerindo alimento");
            return;
        }
        estomago = rango;
    }

    void regurgitar(){
        if(estomago == null){
            System.out.println("Sua cobra regurgitou");
            estomago = null;
        }

        alimento jst = estomago;
        estomago = null;
        System.out.println(jst);
    }

    void digerir(){
        if(estomago == null){
            System.out.println("Sua cobra não comeu");
            return;
        }

        this.fome += estomago.saciedade;
        estomago.saciedade = 0;
        estomago = null;
        
    }

    void brincar(){
        if(!vivo){
            return;
        }

        this.dinheiro+=1;
        this.idade+=1;
        setEnergia(energia-3);
        setFome(fome-1);
        setHidratacao(hidratacao-2);
        setTemperatura(temperatura-3);
        setFurtividade(furtividade-4);
    }

    void colocarNaBanheira(){
        if(!vivo){
            return;
        }

        this.idade+=1;
        setEnergia(energia-4);
        setFome(fome-1);
        setHidratacao(hidraMax);
        setTemperatura(temperatura+1);
        setFurtividade(furtividade-1);

    }

    void pedrasAquecidas(){
        if(!vivo){
            return;
        }

        this.idade+=1;
        setEnergia(energia-1);
        setFome(fome-2);
        setHidratacao(hidratacao-7);
        setTemperatura(tempMax);
        setFurtividade(furtividade-1);
    }

    void brumacao(int b){
        if(!vivo){
            return;
        }

        if(this.energia==this.enerMax-8){

            this.idade+=b;
            setEnergia(this.enerMax);
            setFome(fome-5);
            setHidratacao(hidratacao-3);
            setTemperatura(temperatura-1);
            setFurtividade(furtividade+1);

        } else {
            System.out.println("Sua cobra não quer dormir");
        }
    }

    void esconder(){
        if(!vivo){
            return;
        }

        this.idade+=1;
        setEnergia(energia-1);
        setFome(fome-1);
        setHidratacao(hidratacao-3);
        setTemperatura(temperatura-2);
        setFurtividade(furtivMax);
    }

    public String toString(){
        return "Fome: " + fome + "/" + "Energia: " + energia + "/" + "Hidratacao: " + hidratacao + "/" + "Temperatura: " + temperatura + "/" + "Furtividade: " + furtividade + "///////" + "Idade: " + idade + "/" + "Dinheiro: " + dinheiro;
    }

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        cobra cobra = new cobra("", 0, 0, 0, 0, 0);
        while(true){
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("init")){
                cobra = new cobra((ui[1]), Integer.parseInt(ui[2]), Integer.parseInt(ui[3]), Integer.parseInt(ui[4]), Integer.parseInt(ui[5]), Integer.parseInt(ui[6]));
            
            }else if(ui[0].equals("show")){
                System.out.println(cobra);
            }else{
                System.out.println("falha: comando invalido");
            }
        }
        scanner.close();
    }
}