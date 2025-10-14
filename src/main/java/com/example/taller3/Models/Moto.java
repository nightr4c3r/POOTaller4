package com.example.taller3.Models;

import java.util.ArrayList;


public class Moto {
    private String placa;
    private String marca;
    private String modelo;
    private ArrayList<Moto>  motos;

    public Moto (){

    }
    public Moto(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        motos = new ArrayList<Moto>();

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public ArrayList<Moto> getMotos() {
        return motos;
    }

    public void setMotos(ArrayList<Moto> motos) {
        this.motos = motos;
    }

    @Override
    public String toString() {
        return "Moto{" + "placa='" + placa + '\'' + ", marca='" + marca + '\'' + ", modelo='" + modelo + '\'' + ", motos=" + motos +'}';
    }
}
