package model;

import java.io.Serializable;

/*
 @author nxlam
 */
public class Score implements Serializable {
    private static final long serialVersionUID = 2020;
    private String color;
    private int point;
    private String status;

    public Score(String color, int point, String status) {
        this.color = color;
        this.point = point;
        this.status = status;
    }
    
    public Score(){
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}