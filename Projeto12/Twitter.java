package Projeto12;
import java.util.*;


class Tweet{
    int idTw;
    String username;
    String msg;
    TreeSet <String> likes;

    public void like(String username){
        likes.add(username);
    }

    public int getIdTw(){
        return idTw;
    }

    public String getUsername(){
        return username;
    }

    public String getMsg(){
        return msg;
    }

    public Tweet(int id, String username, String msg){
        this.idTw = id;
        this.username = username;
        this.msg = msg;
        this.likes = new TreeSet<>();

    }

    public String toString(){
        return idTw + ": " + username + " (" + msg + ") " + likes;
    }
}

class User{
    String username;
    private Map<String, User> Seguidores;
    private Map<String, User> Seguindo;
    private Map<Integer, Tweet> Timeline;
    int unreadCount;

    public void follow(User user){
        if(Seguindo.containsKey(user.getUsername())){
            throw new RuntimeException("Você ja segue essa pessoa");
        } else {
            Seguindo.put(user.getUsername(), this);
            user.Seguidores.put(this.getUsername(), this);
            System.out.println("voce segue esse usuario");
        }

    }

    public void unfollow(String username){
        User user = Seguindo.get(username);
        if(user == null){
            throw new RuntimeException("voce nao segue essa pessoa");
        } else {
            Seguindo.remove(username);
            user.Seguidores.remove(this.username);
            throw new RuntimeException("voce parou de seguir esse usuario");
        }

    }

    void sendTweet(Tweet tweet){
        this.Timeline.put(tweet.getIdTw(), tweet);
        this.unreadCount += 1;
        for(User user : Seguidores.values()){
            user.getUsername();
            user.unreadCount += 1;
            user.Timeline.put(tweet.getIdTw(), tweet);
        }
    }

    public String getUnread(){
        String x = "";
        Map<Integer, Tweet> y = new TreeMap<>();
        for(int i = Timeline.size() - this.unreadCount; i < Timeline.size(); i++){
            y.put(i, Timeline.get(i));
        }
        return x;
    }

    public String getTimeline(){
        String x = "";
        Map<Integer, Tweet> y = new TreeMap<>();
        for(int i=Timeline.size() - this.unreadCount; i < Timeline.size(); i++){
            y.put(i, Timeline.get(i));
        } if(this.unreadCount == 0){
            throw new RuntimeException("não tem tweets");
        } unreadCount = 0;
        for(Tweet tweet : y.values()){
            x += tweet;
        }
        return x;
    }

    public Tweet getTweet(int idTw){
        Tweet escrever = Timeline.get(idTw);
        escrever.like(getUsername());
        return escrever;
    }


    public String getUsername(){
        return username;
    }
}

class Controller{
    private Map<String, User> users;
    private Map<Integer, Tweet> tweets;
    int nextTwId;

    public void sendTweet(String username, String msg){
        Tweet tweetar = new Tweet(nextTwId, username, msg);
        User user = getUser(username);
        if(!users.containsKey(username)){
            throw new RuntimeException(" ");
        } else {
            tweets.put(nextTwId, tweetar);
            user.sendTweet(tweetar);
            nextTwId = nextTwId + 1;
            System.out.println("seu tweet foi enviado");
        }
    }

    public void addUser(String username){
        User user = new User();
        if(!users.containsKey(username)){
            users.put(username, user);
            System.out.println("voce criou uma nova conta");
        } else {
            throw new RuntimeException("Username já existe, coloque outro nome");
        }
    }

    public User getUser(String username){
        User user = users.get(username);
        if(user == null){
            throw new RuntimeException("Esse usuario nao existe");
        }
        return user;
    }

    public Controller(){
        this.users = new TreeMap<>();
        this.tweets = new TreeMap<>();
    }
}

public class Twitter{
    public static void main(String[] args) {
        User ux = new User();
        Controller adm = new Controller();
        Scanner leitor = new Scanner(System.in);
        while(true){
            String line = leitor.nextLine();
            String ui[] = line.split(" ");
            try { 
                if(ui[0].equals("End")){
                    break;
                } else if(ui[0].equals("Criar usuario")){
                    adm.addUser(ui[1]);
                } else if(ui[0].equals("Seguir")){
                    User Bruno = adm.getUser(ui[1]);
                    User Ramon = adm.getUser(ui[1]);
                    User Ismael = adm.getUser(ui[1]);
                    Bruno.follow(Ismael);
                    Ismael.follow(Ramon);
                } else if(ui[0].equals("Parar de seguir")){
                    User Bruno = adm.getUser(ui[1]);
                    Bruno.unfollow(ui[2]);
                } else if(ui[0].equals("Mostrar")){
                    System.out.println(adm);
                } else if(ui[0].equals("Tweetar merda")){
                    String mensagem = "";
                    String usuario = ui[1];
                    for(int i = 2; i < ui.length; i++){
                        mensagem += ui[i] + " ";
                    } adm.sendTweet(usuario, mensagem);
                } else if(ui[0].equals("timeline")){
                    User Bruno = adm.getUser(ui[1]);
                    System.out.println(Bruno.getTimeline());
                } else if(ui[0].equals("Like")){
                    User Ismael = adm.getUser(ui[1]);
                    Tweet animais = adm.getTweet(Integer.parseInt(ui[2]));
                    animais.like(ui[1]);
                } else {
                    System.out.println("Erro!");
                }
            } catch(RuntimeException e){
                System.out.println(e.getMessage());
            }
        } leitor.close();
    }
}