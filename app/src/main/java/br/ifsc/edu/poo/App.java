package br.ifsc.edu.poo;

import br.ifsc.edu.poo.erbs.Erb;
import edu.princeton.cs.algs4.Draw;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Draw draw = new Draw();
        draw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw.setCanvasSize(800,600);
        draw.setXscale(0,800);
        draw.setYscale(0,600);

        Scanner entrada = new Scanner(System.in);
        int i = 0;

        Erb[] erb = new Erb[6];
        while(entrada.hasNext()){
            String linha = entrada.nextLine();
            String[] v = linha.split(" ");
            String tempName = v[0];
            int tempX = Integer.parseInt(v[1]);
            int tempY = Integer.parseInt(v[2]);
            int raio = Integer.parseInt(v[3]);
            erb[i] = new Erb(tempName, tempX, tempY, raio);
            i++;
        }

        for(int j = 0; j < 6; j++){
            if(erb[j] != null){
                draw.setPenColor(Color.black);
                draw.circle(erb[j].getX(), erb[j].getY(), erb[j].getRaio());
                draw.text(erb[j].getX(), erb[j].getY(), erb[j].getNome());
            }
        }

        int temp = 0;
        for(int j = 0; j < 6; j++){
            if(erb[j] != null && erb[j].pontoAreaCobertura(Integer.parseInt(args[0]),Integer.parseInt(args[1]))){
                System.out.println("A coordenada " + "(" + args[0] + "," + args[1] + ")" + " está na área de cobertura da ERB " + erb[j].getNome());
                temp++;
            }
        }
        if(temp == 0){
            System.out.println("Fora da área de cobertura de qualquer ERB");
        }
        draw.save("erb.png");

    }
}
