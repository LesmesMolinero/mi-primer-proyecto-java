package lab6.veintiuna;
public class Carta {
// Usa estos atributos de clase para manejar los datos de las cartas.
private static final String[] PALO = { "Oros", "Espadas", "Bastos", "Copas" };
private static final String[] NUMERO = { "As", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey" };
private static final int[] VALOR = { 11, 2, 3, 4, 5, 6, 7, 10, 10, 10 };
/**
* Construye una carta de la baraja.
*
* Para generar la carta se supone que las cartas se ordenan del As al Rey y que
* el orden de los palos es Oros, Espadas, Bastos y Copas. Por ejemplo: la carta
* 0 es el As de Oros, la 10 es el As de Espadas y la 23 es el 4 de Bastos.
*
* @param indice, el indice de la carta entre 0 y 39
*/

private final int indice;

public Carta (int indice){
    if(indice <0 || indice > 39){
        throw new IndexOutOfBoundsException("El indice no pertenece al rango permitido");
    }
    this.indice = indice;
}
/**
* Devuelve el palo de la carta (uno de los valores en PALO).
*
* @return el palo de esta carta
*/
public String palo (){
    return PALO[indice/10];
}
/**
* Devuelve el numero de la carta (uno de los valores en NUMERO).
*
* @return el numero de esta carta
*/
public String numero (){
    return NUMERO[indice%10];
}
/**
* Devuelve el numero de la carta (uno de los valores en VALOR).
*
* @return el valor de la carta en el juego de la veintiuna
*/
public int valor (){
    return VALOR[indice%10];
}
/**
* Devuelve el nombre de la carta en la forma ’numero’ de ’palo’.
*/
@Override
public String toString (){
    return numero() + " de " + palo();
}
}
