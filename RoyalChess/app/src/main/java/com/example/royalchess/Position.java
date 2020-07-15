package com.example.royalchess;

public class Position {
    private int x;
    private int y;

    public Position(int t_x, int t_y){
        x = t_x;
        y = t_y;
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Position that = (Position) obj;
        return this.x == that.x && this.y == that.y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int t_x){
        x = t_x;
    }

    public  void setY(int t_y){
        y = t_y;
    }

    public int getC(){
        return x;
    }

    public int getR(){
        return y;
    }
}
