package by.it.rudzko.jd01_08;

import java.util.Scanner;

/**
 * Created by Leta on 18.09.2016.
 */
public class CoffeeTable extends Table {

    private float r;
    private float l;
    private String col;

    @Override
    public void getPar() {
        System.out.println("Please enter radius of the table.");
        String a=new Scanner(System.in).nextLine();

        this.r=Float.valueOf(a);
        this.l=r*2;

    }


    @Override

    public void descr(float [] prices){

        prices[0]=super.getP();
    }

    public void descr() {
        System.out.println("\n\nCoffee Table\nRadius: "+r+".\nPrice: "+super.getP()+".");
    }

    @Override
    public float findSq() {
        return (float)(Math.PI*Math.pow(r,2));
    }

    @Override
    public String fitSize(float a, float b) {
        if (a>=this.l) return "Table fits width of the room.";
        else return "Table doesn't fit width of the room";
    }






}