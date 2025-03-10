/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsur.pokebatalla.model.pokemons;

import java.io.Serializable;
import mx.edu.itsur.pokebatalla.model.moves.AtaqueRapido;
import mx.edu.itsur.pokebatalla.model.moves.GolpeKarate;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;
import mx.edu.itsur.pokebatalla.model.moves.PistolaAgua;
import mx.edu.itsur.pokebatalla.model.moves.Placaje;
import mx.edu.itsur.pokebatalla.model.moves.Proteccion;

/**
 *
 * @author RAFAEL CASTRO TINOCO
 */
public class Wartortle extends Pokemon implements Serializable{

    public enum Movimientos {
        PLACAJE,
        PISTOLA_AGUA,
        PROTECCION

        //Otros movimientos...
    }

    public Wartortle() {
        this.tipo = "AGUA";
        this.hp = 59;
        this.ataque = 63;
        this.defensa = 80;
        this.nivel = 16;
        this.precision = 5;
        this.xp = 143;
    }

    //Constructor alterno 1
    public Wartortle(String nombre) {
        this(); //invocando al constructor default
        this.nombre = nombre;
    }

    public void atacar(Pokemon oponente, int ordinalMovimiento) {

        if (this.hp <= 0) {
            System.out.println("El Pokemon esta agotado y no puede realizar mas movimientos");
            return;
        }
        Wartortle.Movimientos movimientoAUtilizar = Wartortle.Movimientos.values()[ordinalMovimiento];
        //Instanciar el movimiento solicitado
        Movimiento instanciaMovimiento;

        switch (movimientoAUtilizar) {
            case PISTOLA_AGUA:
                instanciaMovimiento = new PistolaAgua();
                break;
            case PROTECCION:
                instanciaMovimiento = new Proteccion();
                break;
            case PLACAJE:
                instanciaMovimiento = new Placaje();
                break;

            //Otros movimientos aquí...                
            default:
                throw new AssertionError();
        }

        //Aplicar el movimiento.
        instanciaMovimiento.utilizar(this, oponente);
    }

    @Override
    public Enum[] getMovimientos() {
        return Wartortle.Movimientos.values();
    }
}
