import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int atrac , clientes , acro , limitEdad , limitAlt , restric = 0, tick = 0,j = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("ingrese el numero de atracciones disponibles");
        atrac = scan.nextInt();
        System.out.println("cuantos clientes se esperan atender hoy ?");
        clientes = scan.nextInt();
        scan.nextLine();

        int[]edadCl = new int[clientes];
        int[]altCl = new int[clientes];
        int[] doc = new int[clientes];

        for(int i = 1; i<=atrac;i++){
            System.out.println("--------------------------------------------------------------");
            System.out.println("ingrese el nombre de la atraccion mecanica");
            String nameAtrac = scan.nextLine();
            System.out.println("resgistre el nivel de acrofobia 1 bajo, 2 medio, 3 alto");
            acro = scan.nextInt();
            System.out.println("ingrese la edad minima permitida para su ingreso");
            limitEdad = scan.nextInt();
            System.out.println("ingrese la altura minima en cm permitida para su ingreso");
            limitAlt = scan.nextInt();
            System.out.println("--------------------------------------------------------------");

          while (j<= clientes-1) {
                System.out.println("Bienvenido esta en la atracion ".concat(nameAtrac));
                System.out.println("--------------------------------------------------------------");
                System.out.println("Porfavor ingrese su numero de documento");
                doc[j]= scan.nextInt();
                System.out.println("ingrese su altura en cm");
                altCl[j] = scan.nextInt();
                System.out.println("ingrese su edad");
                edadCl[j] = scan.nextInt();
                scan.nextLine();
                System.out.println("--------------------------------------------------------------");
                j++;
            }
            for (int k = 0;k<= clientes-1;k++) {
                String concat = "cliente con el numero de identificacion :".concat(String.valueOf(doc[k]));
                if (limitAlt > altCl[k] || limitEdad > edadCl[k] || (acro == 3 && (edadCl[k] < 18 || edadCl[k] > 40))) {
                    System.out.println(concat);
                    System.out.println("no cumple con los requisitos para entrar a la atracion : ".concat(nameAtrac));
                    restric++;
                } else {
                    System.out.println(concat);
                    System.out.println("bienvenido a la atracion su ticket es : ATC" + tick + (i));
                    tick++;
                }
                System.out.println("--------------------------------------------------------------");
            }
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("numero de tickets entregados en el parque : "+ tick);
        System.out.println("numero de restriciones : "+restric);
    }
}