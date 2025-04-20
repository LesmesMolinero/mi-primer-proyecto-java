package lab6.veintiuna;

import tads.*;
public class Banca {

    protected IList<Carta> hand;
/**
* El jugador banca comienza robando una carta.
*
* @param baraja, baraja de donde se roba la carta.
*/
public Banca (Baraja baraja){
    this.hand = new ArrayList<Carta>();
    robaCarta(baraja);
}
/**
* Este jugador roba una carta de la baraja y la pone en su mano.
*
* @param baraja, baraja de donde se roba la carta.
*/
public void robaCarta (Baraja baraja){
    hand.add(baraja.robar());
}
/**
* El jugador banca juega primero y muestra solo la primera carta que roba.
* Debes escribir "Banca:", la primera carta y el numero de cartas que tiene en
* la mano.
*/
public void muestraPrimeraCarta (){
    System.out.println("Banca: " + hand.get(0) + " (" + hand.size() + " cartas)");
}
/**
* Escribe las cartas de la mano de este jugador ‘Banca‘. Se debe escribir:
* ’Banca:’ y cada carta en la mano del jugador Banca en una linea de texto. Y
* finalmente: ’Puntuacion: ’ y la puntuacion.
*/
public void muestraMano (){
    String res = "Banca:\n ";
    for(int i = 0; i < hand.size(); i++){
        res+= hand.get(i) + "\n";
    }
    System.out.println(res + "Puntuacion: " + puntuacion() +"\n");
}
/*
* Devuelve la puntuacion este jugador banca
*/
public int puntuacion (){
    int res = 0; 
    int ases = 0;
    for(int i = 0; i < hand.size(); i++){
        res+= hand.get(i).valor();
        if(hand.get(i).numero().equals("As")){
            ases++;
        }
    }
    while (res > 21 && ases > 0) {
        res -= 10;
        ases--;
    }
    return res;
}
/**
* Este jugador banca realiza su jugada.
*
* La banca siempre roba carta por debajo de una puntuacion de 17 y se planta
* con 17 o mas.
*
* @param baraja, la baraja de donde roba las cartas
*/
public void juegaTurnos (Baraja baraja){
    boolean termina = false;
    while (!termina) {
        if(puntuacion() < 17){
            robaCarta(baraja);
        }
        else{
            termina = true;
        }   
    }
}
}
