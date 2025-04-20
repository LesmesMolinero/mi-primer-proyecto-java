package lab6.veintiuna;
import java.util.Scanner;
import tads.ArrayList;
import tads.IList;
public class Jugador {
private static final String TEXTO_PREGUNTA = "Robas o te plantas? (carta/me planto)";
private static final String TEXTO_ACCION_INVALIDA = "Escribe ’carta’ o ’me planto’ (sin comillas)";
protected IList<Carta> hand;
/**
* Construye un jugador. Inicialmente el jugador no tiene ninguna carta.
*/
public Jugador (){
    this.hand = new ArrayList<Carta>();
}
/**
* Este jugador roba una carta de la baraja y la pone en su mano.
*
* @param baraja, baraja de donde se roba la carta.
*/
public void robaCarta (Baraja baraja){
    hand.add(baraja.robar());
}
/*
* Devuelve la puntuacion del jugador
*/
public int puntuacion (){
    int res = 0; 
    int ases = 0;
    for(int i = 0; i < hand.size(); i++){
        res+= hand.get(i).valor();
        if(hand.get(i).numero().trim().equals("As")){
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
* Devuelve un texto con las cartas de la mano de este jugador. El texto es: ’Tu
* mano:’, un salto de linea y cada carta en la mano del jugador en una linea de
* texto. Y finalmente: ’Puntuacion: ’, la puntuacion y un salto de linea.
*/
public String muestraMano (){
    String res = "Tu mano:\n";
    for(int i = 0; i <hand.size(); i++){
        res += hand.get(i) + "\n";
    }
    return res + "Puntuacion: " + puntuacion() + "\n";
}
/**
* Este jugador hace su jugada.
*
* Se pide al usuario si roba o se planta (se escribe en la terminal
* ‘TEXTO_PREGUNTA‘). La accion del jugador se lee de scanner (una linea). Si
* pide "carta" se debe robar una carta y mostrar la mano del jugador. Si el
* usuario no proporciona una accion valida se debe pedir de nuevo con
* ‘TEXTO_ACCION_INVALIDA‘.
*
* Se repite hasta que la puntuacion sea mayor igual que 21 o el jugador diga
* "me planto".
*
* @param scanner, las acciones del jugador se leen desde este parametro
* @param baraja, baraja de donde se roban las cartas.
*/
public void juegaTurnos (Scanner scanner, Baraja baraja){
    boolean termina = false;
    while(!termina){
        System.out.println(TEXTO_PREGUNTA);
        String input = scanner.nextLine();
        if(input.equals("carta")){
            robaCarta(baraja);
            System.out.println(muestraMano());
        }
        else if(input.equals("me planto") || puntuacion() >= 21){
            termina = true;
        }
        else{
            System.out.println(TEXTO_ACCION_INVALIDA);
        }
    }
}
}
