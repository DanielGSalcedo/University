

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double [][] calificaciones = new double[5][7];
        double [] definitivas = new double[5];


        int fila, columna,vueltas = 0;

        Scanner scan = new Scanner(System.in);
         programa:
        do {
            System.out.println("-----------------------------------------------------------");
            String opciones = (vueltas == 0)? "":"ingrese 2 para ver definitivas \ningrese 3 para buscar notas \ningrese 4 para visualizar la tabla \ningrese 5 para salir";
            System.out.printf("ingrese 1 para registrar notas %n%s%n",opciones);
            int option = scan.nextInt();
            System.out.println("-----------------------------------------------------------");
            if(vueltas == 0 && option >1){
                continue;
            }

            switch (option) {
                case 1 -> {
                    System.out.println("ingrese las notas");
                    for (int i = 0; i < calificaciones.length; i++) {
                        System.out.println("-----------------------------------------------------------");
                        System.out.printf("%34s %n","Materia "+(i+1));
                        System.out.println("-----------------------------------------------------------");
                        for (int j = 0; j < 7; j++) {
                            String notaname = (j == 0) ? "Previo 1"
                                    : (j == 1) ? "Previo 2"
                                    : (j == 2) ? "Quiz 1"
                                    : (j == 3) ? "Quiz 2"
                                    : (j == 4) ? "Taller indvidual"
                                    : (j == 5) ? "Taller grupal"
                                    : "Examen Final";
                            do {
                                System.out.printf("ingrese la nota del %s de la materia %d %n", notaname, i + 1);
                                calificaciones[i][j] = scan.nextFloat();
                                if (calificaciones[i][j] > 5.0 || calificaciones[i][j] < 1.0) {
                                    System.out.println("ingrese una nota valida");
                                } else break;
                            } while (true);
                        }
                    }
                    for (int i = 0; i < definitivas.length; i++) {
                        double previo3 = (calificaciones[i][2] + calificaciones[i][3] + calificaciones[i][4] + calificaciones[i][5]) / 4;
                        definitivas[i] = (((calificaciones[i][0] + calificaciones[i][1] + previo3) / 3) * 0.7) + (calificaciones[i][6] * 0.3);
                    }
                }
                case 2 -> {
                    double defmay =Double.MIN_VALUE, defmin = Double.MAX_VALUE;

                    for (double i : definitivas) {
                        if (i > defmay) {
                            defmay = i;
                        }
                        if (i < defmin) {
                            defmin = i;
                        }
                    }
                    System.out.println("-----------------------------------------------------------");
                    System.out.printf("la definitiva mas baja fue %.1f %n", defmin);
                    System.out.printf("la definitiva mas alta fue %.1f %n", defmay);
                    System.out.println("-----------------------------------------------------------");
                }
                case 3 -> {
                    do {
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("ingrese la fila de la nota a buscar");
                        fila = scan.nextInt();
                    } while (fila < 1 || fila > 5);
                    do {
                        System.out.println("ingrese la columna de la nota a buscar");
                        columna = scan.nextInt();
                    } while (columna < 1 || columna > 7);
                    double notab = calificaciones[fila - 1][columna - 1];
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("la nota en esa ubicacion es: " + notab);
                    System.out.println("-----------------------------------------------------------");
                }
                case 4 -> {
                    System.out.println("--------------------------------------------------------------------------------------------------------------");
                    System.out.printf("            | Previo1 | Previo2 | Quiz1 | Quiz2 | TallerIndividual | TallerGrupal | ExamenFinal | definitiva | %n");
                    for(int i = 0; i < 5;i++){
                        System.out.printf("| Materia %d |   %.1f   |   %.1f   |  %.1f  |  %.1f  |       %.1f        |     %.1f      |     %.1f     |     %.1f    |%n"
                        ,i+1,calificaciones[i][0],calificaciones[i][1],calificaciones[i][2],calificaciones[i][3],calificaciones[i][4],calificaciones[i][5],calificaciones[i][6],definitivas[i]);
                        System.out.println("--------------------------------------------------------------------------------------------------------------");
                    }
                }
                case 5 -> {
                    break programa;
                }
            }
            vueltas++;
        }while (true);
    }
}
