package maquina_snacks_archivos.servicio;

import maquina_snacks_archivos.dominio.Snack;

import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksLista implements IServicioSnacks{
    private static final List<Snack> snacks;

     //Bloque estático inicializador (es como un constructor)
    static{
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papas", 20.0));
        snacks.add(new Snack("Inkacola", 30.0));
        snacks.add(new Snack("Palomitas", 40.0));
    }

    public void agregarSnack(Snack snack) {
        snacks.add(snack);
    }

    public void mostrarSnacks() {
        System.out.println(" --- Snacks en el Inventario --- ");
        var inventarioSnacks = "";
        for (var snack : snacks) {
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println(inventarioSnacks);
    }

    public List<Snack> getSnacks() {
        return snacks;
    }
}
