package controller;

import View.View;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import model.Score;

/*
 @author nxlam
 */
public class Services {
    ServerSocket server;
    View view;
    Score score;
    int port = 1109;
    
    public static void main(String[] args) {
        new Services();
    }
    
    public Services(){
        try {
            view = new View();
            view.setVisible(true);
            score = new Score();
            connect();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public void connect() throws IOException, ClassNotFoundException{
        server = new ServerSocket(port);
        System.out.println("Server started!");
        while(true){
            Socket socket = server.accept();
            System.out.println("Connected!");
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            while(true){
                score = (Score) in.readObject();
                System.out.println("[SERVER] " + score.getColor() + ", " + score.getPoint() +", " + score.getStatus());
                if (score.getStatus().equalsIgnoreCase("new")){
                    if (score.getColor().equalsIgnoreCase("red")){
                        int point = view.getPoint("red");
                        if (score.getPoint() == 1){
                            score.setPoint(point+1);
                        } else if (score.getPoint() == 2){
                            score.setPoint(point+2);
                        } else {
                            score.setPoint(point+3);
                        }
                    } else if (score.getColor().equalsIgnoreCase("blue")){
                        int point = view.getPoint("blue");
                        if (score.getPoint() == 1){
                            score.setPoint(point+1);
                        } else if (score.getPoint() == 2){
                            score.setPoint(point+2);
                        } else {
                            score.setPoint(point+3);
                        }
                    }
                    view.setPoint(score);
                }
            }
        }
    }
}