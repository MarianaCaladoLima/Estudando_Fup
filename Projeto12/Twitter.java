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

    }

    public void unfollow(String username){

    }

    Tweet getTweet(int idTw){
        return n;
    }

    void sendTweet(Tweet tweet){
        
    }

    public String getUnread(){
        return m;
    }

    public String getTimeline(){
        return p;
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

    }

    public void addUser(String username){

    }

    public User getUser(username){
        User user = users.get(username);
        return user;
    }
}

public class Twitter{
    public static void main(String[] args) {
        
    }
}