import java.util.ArrayList;
import java.util.List;

public class Snacks {
    private static final List<Snack> snacks;

    // Bloque estático inicializador (es como un constructor)
    static{
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papas Lays", 20));
        snacks.add(new Snack("Maquis", 30));
        snacks.add(new Snack("Inka Cola", 40));
    }

    public static void agregarSnack(Snack snack) {
        snacks.add(snack);
    }

    public static void mostrarSnacks() {
        var inventarioSnacks = "";
        for (var snack : snacks) {
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println(" --- Snacks en el Inventario --- ");
        System.out.println(inventarioSnacks);
    }

    public static List<Snack> getSnacks() {
        return snacks;
    }
}
