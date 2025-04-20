package lab6.veintiuna;
import java.util.Random;

public class Baraja {
private Carta[] cards;
private Random rand;
private int numCartas;
/**
* Construye una baraja espanhola de 40 cartas.
*
* @param rand, el generador de numeros aleatorios
*/
public Baraja (Random rand){
    this.cards = new Carta[40];
    for(int i = 0; i < cards.length; i++){
        this.cards[i] = new Carta(i);
    }
    this.rand =rand;
    this.numCartas = 40;
}
/**
* Barajar esta baraja.
*
* Se emplea el siguiente algoritmo: a) Genera dos enteros aleatorios entre 0 y
* size()-1 b) Intercambia las cartas en las posiciones dadas por los enteros
* aleatorios c) Repite a) y b) ‘n‘ veces Es obligatorio usar rand para generar
* los enteros aleatorios.
*
* @param n, las veces que se intercambian las cartas.
*/
public void barajar (int n){
    for(int i = 0; i < n; i++){
        int a = rand.nextInt(size());
        int b =rand.nextInt(size());
        Carta temp = cards[a];
        cards[a] = cards[b];
        cards[b] = temp;
    }
}
/**
* Roba una carta de esta baraja.
*
* Se debe roba la ultima carta de la baraja.
*
* @POST size() se decrementa en 1.
* @return La carta robada.
*/
public Carta robar (){
    numCartas -= 1;
    return cards[numCartas];
}
/**
* Numero de cartas en esta baraja.
*
* @return el numero de cartas
*/
public int size (){
    return numCartas;
}
}

