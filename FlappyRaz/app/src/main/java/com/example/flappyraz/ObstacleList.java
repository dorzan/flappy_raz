package com.example.flappyraz;

public class ObstacleList {
    Obstacle head;
    Obstacle last;
    int numOfFaces;

    public ObstacleList(){
    head = new Obstacle();
    last = head;
    numOfFaces = 8;
    }

    public Obstacle getHead() {
        return head;
    }

    public Obstacle getLast() {
        return last;
    }

    public void removeHead(){
        if (head == last)
            last = head.getNext();
        head = head.getNext();

    }

    public void insertObstacle(){
            Obstacle obstacle = new Obstacle();
            last.setNext(obstacle);
            last = obstacle;
    }

    public void moveAll(int distance){
        Obstacle temp = head;
        while(temp.getNext() != null){}
        temp.setPos(temp.getPos() - distance);
    }

    public int getNumOfFaces(){
        return numOfFaces;
    }
}