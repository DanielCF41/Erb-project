package br.ifsc.edu.poo.erbs;

public class Erb {
    private String nome;
    private int x;
    private int y;
    private int raio;

    private final int COORDENADA_MIN = 10;
    private final int COORDENADA_MAX = 500;
    private final int RAIO_MIN = 10;
    private final int RAIO_MAX = 400;

    public Erb(String nome, int x, int  y, int raio){
        this.nome = nome;
        if(!setX(x) || !setY(y)){
            this.x = COORDENADA_MIN;
            this.y = COORDENADA_MIN;
        }
        if(!setRaio(raio)){
            this.raio = RAIO_MIN;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getX() {
        return x;
    }

    public boolean setX(int x) {
        if(x >= COORDENADA_MIN && x <= COORDENADA_MAX) {
            this.x = x;
            return true;
        }
        return false;
    }

    public double getY() {
        return y;
    }

    public boolean setY(int y) {
        if(y >= COORDENADA_MIN && y <= COORDENADA_MAX) {
            this.y = y;
            return true;
        }
        return false;
    }

    public double getRaio() {
        return raio;
    }

    public boolean setRaio(int raio) {
        if(raio >= RAIO_MIN && raio <= RAIO_MAX) {
            this.raio = raio;
            return true;
        }
        return false;
    }

    public boolean pontoAreaCobertura(int x, int y){
        if(Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2)) <= this.raio){
            return true;
        }
        return false;
    }
}
