import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int atrac , clientes , acro , limitEdad ,ingresos =0, limitAlt , restric = 0, tick = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("ingrese el numero de atracciones disponibles");
        atrac = scan.nextInt();
        System.out.println("cuantos clientes se esperan atender hoy por atracion?");
        clientes = scan.nextInt();
        scan.nextLine();

        for(int i = 1; i<=atrac;i++){
            System.out.println("--------------------------------------------------------------");
            System.out.println("ingrese el nombre de la atraccion mecanica");
            String nameAtrac = scan.nextLine();
            System.out.println("resgistre el nivel de acrofobia 1 bajo, 2 medio, 3 alto");
            acro = scan.nextInt();
            System.out.println("ingrese la edad minima permitida para su ingreso");
            limitEdad = scan.nextInt();
            System.out.println("ingrese la altura minima permitida para su ingreso");
            limitAlt = scan.nextInt();
            System.out.println("--------------------------------------------------------------");
            do{
                System.out.println("--------------------------------------------------------------");
                System.out.println("esta en la atracion "+ i);
                System.out.println("hola porfavor ingrse su numero de documento");
                int doc = scan.nextInt();
                System.out.println("ingrese su altura en cm");
                int altura = scan.nextInt();
                System.out.println("ingrese su edad");
                int edadClient = scan.nextInt();
                scan.nextLine();
                System.out.println("--------------------------------------------------------------");
                if(limitAlt> altura || limitEdad > edadClient || (acro == 3 && (edadClient < 18 || edadClient > 40))){
                    System.out.println("no cumple con los requisitos para entrar a la atracion ");
                    restric++;
                }else{
                    ingresos++;
                    tick++;
                    System.out.println("bienvenido a la atracion su ticket es : ATC"+tick+(i));
                }
                System.out.println("--------------------------------------------------------------");
            }while(ingresos < clientes);
            ingresos = 0;
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("numero de tickets entregados en el parque : "+ tick);
        System.out.println("numero de restriciones : "+restric);
    }
}