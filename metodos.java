import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class metodos {
    Queue<objFastFood> cventas = new LinkedList<>();
    Scanner sc = new Scanner(System.in);
    public void principal() {
     
        metodos m = new metodos();
        
        int opt = 0;
        Queue<objFastFood> cola = new LinkedList<>();
        boolean bandera = true;
        while (bandera) {
            System.out.println("bienvenidos a FastFood ITM");
            System.out.println("Nuestro ménu");
            System.out.println("1: Ingresar Venta");
            System.out.println("2: Despachar Pedido");
            System.out.println("3: Mostrar Pedidos Pendientes");
            System.out.println("4: Mostrar Salidas");
            System.out.println("5: Salir");

            opt = m.ValidarEntero(sc);
            sc.nextLine();
            if (opt < 1 || opt > 5) {
                System.out.println("Esta opcion no esta en el menu");
                continue;
            }
            switch (opt) {
                case 1:
                    cola.offer(m.IngresarVenta());
                    break;
                case 2:
                    cola = m.DespacharPedido(cola);
                    break;
                case 3:
                    m.MostrarPendientes(cola);
                    break;
                case 4:
                    m.TurnosAtendidos();
                    break;

                default:
                    System.out.println("Hasta luego");
                    break;
            }
        }
    }

    public int ValidarEntero(Scanner sc) {
        int numero = 0;
        while (!sc.hasNextInt()) {
            System.out.println("Por favor ingrese un numero de 1 al 6 ");
            sc.next();
        }
        numero = sc.nextInt();
        return numero;
    }

    public objFastFood IngresarVenta() {
        Scanner sc = new Scanner(System.in);
        metodos m = new metodos();
        objFastFood o = new objFastFood();
        System.out.println("Ingrese Nombre Cliente");
        o.setNombreCliente(sc.next());
        System.out.println("1: Perro");
        System.out.println("2: Perra");
        System.out.println("3: Perro Suizo");
        System.out.println("4: Hamburguesa");
        System.out.println("5: Pizza");
        o.setTipo(m.ValidarEntero(sc));
        System.out.println("Ingrese el tamaño");
        System.out.println("1: Grande");
        System.out.println("2: mediano");
        System.out.println("3: Perro Pequeño");
        o.setTamaño(m.ValidarEntero(sc));
        System.out.println("Ingrese el precio");
        o.setPrecio(sc.nextDouble());
        return o;

    }

    public Queue<objFastFood> DespacharPedido(Queue<objFastFood> co) {
        System.out.println("El siguiente turno es para: " + co.peek().getNombreCliente());
        cventas.offer(co.remove());
        return co;
    }

    public void MostrarPendientes(Queue<objFastFood> co) {
        System.out.println("Turnos pendientes ");
        for (objFastFood o : co) {
            System.out.println("Nombre : " + o.getNombreCliente());
            switch (o.getTipo()) {
                case 1:
                    System.out.println("Perro");
                    break;
                case 2:
                    System.out.println("Perra");
                    break;
                case 3:
                    System.out.println("Perro Suizo");
                    break;
                case 4:
                    System.out.println("Hamburguesa");
                    break;

                default:
                    System.out.println("Pizza");
                    break;
            }

        }
    }

    public void TurnosAtendidos() {
        for (objFastFood o : cventas) {
            System.out.println("Nombre : " + o.getNombreCliente());
            switch (o.getTipo()) {
                case 1:
                    System.out.println("Perro");
                    break;
                case 2:
                    System.out.println("Perra");
                    break;
                case 3:
                    System.out.println("Perro Suizo");
                    break;
                case 4:
                    System.out.println("Hamburguesa");
                    break;

                default:
                    System.out.println("Pizza");
                    break;
            }
            System.out.println("Precio : " + o.getPrecio());
        }
    }
}
