/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_12021;
import java.io.IOException;//o importacion de bibliotecas
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.util.Date;
import java.util.Scanner;

/**
 * Esta clase es el main que se utiliza para ejecutar el programa
 * @author Emmanuel Herrera y Yoni Custodio
 * @version 1.0.0
 */
public class MainTest {
    
    private static int correlativo1 = 0;
    private static int correlativo2 = 0;    
    private static int correlativo3 = 0;
    private static int parqueo1 = 0;
    private static int parqueo2 = 0;    
    private static int parqueo3 = 0;
    private static int ptarifa1 = 0;
    private static int ptarifa2 = 0;
    private static int ptarifa3 = 0;
    /**
     * Metodo estatico que al ser invocado se utiliza para mostrar un menu de opciones
     */
    public static void menu(){//menu de ingreso
        System.out.println("Escoja el numero de la opcion que quiere realizar:");
        System.out.println("1: Ingresar Vehiculo");
        System.out.println("2: Sacar Vehiculo");
        System.out.println("3: Salir");
    }
    
    /**
     * Metodo estatico que al ser invocado se utiliza para mostrar un menu de opciones
     */
    public static void subMenu(){//Menu tipo de vehiculo
        System.out.println("Escoja el numero de la opcion que quiere realizar:");
        System.out.println("1: Ingresar Automovil");
        System.out.println("2: Ingresar Motocicleta");
        System.out.println("3: Ingresar Camion");
        System.out.println("4: Salir");
    }
    
    /**
     * Metodo estatico que al ser invocado se utiliza para mostrar un menu de opciones
     */
    public static void subMenue(){//Menu retiro de vehiculo
        System.out.println("Escoja el numero de la opcion que quiere realizar:");
        System.out.println("1: Sacar Automovil");
        System.out.println("2: Sacar Motocicleta");
        System.out.println("3: Sacar Camion");
        System.out.println("4: Salir");
    }
    
    /**
     * Metodo donde se ejecuta el programa
     * @param args the command line arguments
     * @throws Este metodo puede generar una excepcion de tipo IOException
     */
    public static void main(String[] args) throws IOException {
        
        Scanner entrada = new Scanner(System.in);
        
        ArregloDeVehiculos av = new ArregloDeVehiculos() {};
        
        System.out.println("Estableza el numero de estacionamientos que hay para un Automovil");
        parqueo1 = entrada.nextInt();
        System.out.println("Estableza el numero de estacionamientos que hay para una Motocicleta");
        parqueo2 = entrada.nextInt();
        System.out.println("Estableza el numero de estacionamientos que hay para un Camion");
        parqueo3 = entrada.nextInt();
        /*System.out.println("ingrese la tarifa de vehiculo para el dia de hoy");
        /*ptarifa1 = entrada.nextInt();
        System.out.println("ingrese la tarifa de vehiculo para el dia de hoy");
        ptarifa2 = entrada.nextInt();
        System.out.println("ingrese la tarifa de vehiculo para el dia de hoy");
        ptarifa3 = entrada.nextInt();*/
        Automovil auto[] = new Automovil[parqueo1];
        Motocicleta moto[] = new Motocicleta[parqueo2];
        Camion camion[] = new Camion[parqueo3];
        
        int op=0,op1=0,op2=0;
        
        do {
            menu();
            op = entrada.nextInt();
            
            switch(op){
                
                case 1:
                    subMenu();
                    op1 = entrada.nextInt();
                    
                    
                    switch (op1){
                        
                        case 1:
                            entrada.nextLine();
                            if (correlativo1 < parqueo1) {

                                for (correlativo1 = correlativo1; correlativo1 < parqueo1; correlativo1++) {
                                    System.out.println("Ingrese su Placa");
                                    String placa = entrada.nextLine();

                                    Date date = new Date();
                                    
                                    System.out.println("Ingrese los segundos que va a estar en el estacionamiento");
                                    double tiempo = entrada.nextInt();                                    

                                    System.out.println("Ingrese la tarifa por segundo");
                                    double pTarifa = entrada.nextDouble();

                                    double total = tiempo * pTarifa;

                                    Automovil auto1 = new Automovil(correlativo1 + 1, placa, date, total, EnumVehiculo.AUTOMOVIL);
                                    auto[correlativo1] = auto1;
                                    correlativo1++;
                                    av.agregarUnVehiculo(auto1);
                                    PDDocument documento = new PDDocument();
                                    PDPage pagina = new PDPage(PDRectangle.A4);
                                    documento.addPage(pagina);
                                    PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

                                    String cont = Integer.toString(correlativo1);

                                    for (int i = 1; i <= 5; i++) {
                                        contenido.beginText();
                                        contenido.setFont(PDType1Font.HELVETICA, 10);
                                        if (i == 1) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText(":TICKET:");
                                        }
                                        if (i == 2 && cont.length() == 1) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("Su numero de estacionamiento es------- 00" + auto1.getNumeroDeEstacionamiento());
                                        }
                                        if (i == 2 && cont.length() == 2) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("Su numero de estacionamiento es------- 0" + auto1.getNumeroDeEstacionamiento());
                                        }
                                        if (i == 2 && cont.length() == 3) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("Su numero de estacionamiento es------- " + auto1.getNumeroDeEstacionamiento());
                                        }
                                        if (i == 3) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("La placa del vehiculo es------- " + placa);
                                        }
                                        if (i == 4) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("La Fecha y Hora es-- " + date);
                                        }
                                        if (i == 5) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("El precio por la tarifa es------- Q" + total);
                                        }

                                        contenido.endText();
                                    }
                                    contenido.close();

                                    documento.save("C:\\Users\\em47a\\OneDrive\\Escritorio\\SEMESTRE 4\\PROGRAMACION 3\\UNIDAD 2\\tAREAS\\Proyecto_12021\\pdf\\ticketauto.pdf");
                                    
                                    System.out.println("Se ha generando el PDF");

                                    
                                    break;
                                }

                            } else {
                                System.out.println("Todos los estacionamientos estan ocupados");
                            }
                            break; 
                            
                        case 2:
                            
                            if (correlativo2 < parqueo2) {

                                for (correlativo2 = correlativo2; correlativo2 < parqueo2; correlativo2++) {
                                    entrada.nextLine();
                                    System.out.println("Ingrese su placa");
                                    String placa = entrada.nextLine();

                                    Date date = new Date();

                                    System.out.println("Ingrese el numero de segundos que va a estar en el estacionamiento");
                                    double tiempo = entrada.nextInt();

                                    System.out.println("Ingrese la tarifa por segundo");
                                    double pTarifa = entrada.nextDouble();

                                    double total = tiempo*pTarifa;

                                    Motocicleta moto1 = new Motocicleta(correlativo2 + 1, placa, date, total, EnumVehiculo.MOTOCICLETA);
                                    moto[correlativo2] = moto1;
                                    correlativo2++;

                                    av.agregarUnVehiculo(moto1);
                                    
                                    PDDocument documento = new PDDocument();
                                    PDPage pagina = new PDPage(PDRectangle.A4);
                                    documento.addPage(pagina);
                                    PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

                                    String cont = Integer.toString(correlativo2);

                                    for (int i = 1; i <= 5; i++) {
                                        contenido.beginText();
                                        contenido.setFont(PDType1Font.HELVETICA, 10);
                                        if (i == 1) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText(":TICKET:");
                                        }
                                        if (i == 2 && cont.length() == 1) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("Su numero de estacionamiento es------- 00" + moto1.getNumeroDeEstacionamiento());
                                        }
                                        if (i == 2 && cont.length() == 2) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("Su numero de estacionamiento es------- 0" + moto1.getNumeroDeEstacionamiento());
                                        }
                                        if (i == 2 && cont.length() == 3) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("Su numero de estacionamiento es------- " + moto1.getNumeroDeEstacionamiento());
                                        }
                                        if (i == 3) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("La placa del vehiculo es------- " + placa);
                                        }
                                        if (i == 4) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("La fecha y Hora es-- " + date);
                                        }
                                        if (i == 5) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("El precio por tarifa es------- Q" + total);
                                        }

                                        contenido.endText();
                                    }
                                    contenido.close();

                                    documento.save("C:\\Users\\em47a\\OneDrive\\Escritorio\\SEMESTRE 4\\PROGRAMACION 3\\UNIDAD 2\\tAREAS\\Proyecto_12021\\pdf\\ticketmoto.pdf");
                                    
                                    System.out.println("Se ha generando el PDF");


                                    break;
                                }

                            } else {
                                System.out.println("Todos los estacionamientos de motocicletas se encuentran ocupados");
                            }

                            break;
                            
                        case 3:
                            entrada.nextLine();
                            System.out.println("Un periodo equivale a 5 segundos");
                            System.out.println("Si excede un periodo, tedra un recargo de Q5.00 por cada periodo extra");

                            if (correlativo3 < parqueo3) {

                                for (correlativo3 = correlativo3; correlativo3 < parqueo3; correlativo3++) {

                                    System.out.println("Ingrese su placa");
                                    String placa = entrada.nextLine();

                                    Date date = new Date();
                                    

                                    Camion camion1 = new Camion(correlativo3 + 1, placa, date,15 , EnumVehiculo.CAMION);
                                    camion[correlativo3] = camion1;
                                    correlativo3++;
                                    av.agregarUnVehiculo(camion1);
                                    PDDocument documento = new PDDocument();
                                    PDPage pagina = new PDPage(PDRectangle.A4);
                                    documento.addPage(pagina);
                                    PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

                                    String cont = Integer.toString(correlativo3);

                                    for (int i = 1; i <= 5; i++) {
                                        contenido.beginText();
                                        contenido.setFont(PDType1Font.HELVETICA, 10);
                                        if (i == 1) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText(":TICKET:");
                                        }
                                        if (i == 2 && cont.length() == 1) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("Su numero de estacionamiento es----- 00" + camion1.getNumeroDeEstacionamiento());
                                        }
                                        if (i == 2 && cont.length() == 2) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("Su numero de estacionamiento es----- 0" + camion1.getNumeroDeEstacionamiento());
                                        }
                                        if (i == 2 && cont.length() == 3) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("Su numero de estacionamiento es----- " + camion1.getNumeroDeEstacionamiento());
                                        }
                                        if (i == 3) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("La placa del vehiculo es----- " + placa);
                                        }
                                        if (i == 4) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("La Fecha y Hora es-- " + date);
                                        }
                                        if (i == 5) {
                                            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                            contenido.showText("El precio por la tarifa es----- Q15.00");
                                        }

                                        contenido.endText();
                                    }
                                    contenido.close();

                                    documento.save("C:\\Users\\em47a\\OneDrive\\Escritorio\\SEMESTRE 4\\PROGRAMACION 3\\UNIDAD 2\\tAREAS\\Proyecto_12021\\pdf\\ticketCamion.pdf");
                                    
                                    System.out.println("Se ha generando el PDF");
                                    
                                    break;

                                }

                            }else{
                                System.out.println("Todos los estacionamientos estan ocupados");
                            }
                            break;
                            
                        case 4:
                            break;
                            
                    }
                    break;
                case 2:
                    
                    subMenue();//salida de vehiculos
                    op2 = entrada.nextInt();
                    entrada.nextLine();
                    switch(op2){
                        
                        case 1:
                            
                            System.out.println("Ingrese su placa");
                            String placa = entrada.nextLine();

                            int contador = 0;                            

                            Automovil auto2 = new Automovil();

                            for (int x = 0; x < parqueo1; x++) {
                                if (placa.equals(auto[x].getNoPlaca())) {
                                    double montoTotal = auto2.total(auto[x].getTarifa());

                                    try {
                                        System.out.println("Ingrese su nit");
                                        String noNit = entrada.nextLine();

                                        PDDocument documento = new PDDocument();
                                        PDPage pagina = new PDPage(PDRectangle.A4);
                                        documento.addPage(pagina);
                                        PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

                                        for (int i = 1; i <= 6; i++) {
                                            contenido.beginText();
                                            contenido.setFont(PDType1Font.HELVETICA, 12);
                                            if (i == 1) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText(":FACTURA:");
                                            }
                                            if (i == 2) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("El NIT para su factura es------- " + noNit);
                                            }
                                            if (i == 3) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("El precio por la tarifa es------- " + auto[x].getTarifa());
                                            }
                                            if (i == 4) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("Tiene un descuento de------- 0");
                                            }
                                            if (i == 5) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("Tiene un recargo de------- 0");
                                            }
                                            if (i == 6) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("El monto a pagar es de------- " + montoTotal);
                                            }

                                            contenido.endText();
                                        }
                                        contenido.close();

                                        documento.save("C:\\Users\\em47a\\OneDrive\\Escritorio\\SEMESTRE 4\\PROGRAMACION 3\\UNIDAD 2\\tAREAS\\Proyecto_12021\\pdf\\facturaAutomovil.pdf");
                                        
                                        System.out.println("Se ha generando el PDF");

                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                    contador++;
                                    break;
                                }
                            }

                            if (contador == 0) {
                                System.out.println("La placa que ingreso no coincide con ninguna del estacionamiento");
                            }
                            break;
                            
                        case 2:
                            int cont = 0;
                            
                            Motocicleta moto2 = new Motocicleta();
                            System.out.println("Ingrese su numero de placa");
                            placa = entrada.nextLine();
                            for (int x = 0; x < parqueo2; x++) {
                                if (placa.equals(moto[x].getNoPlaca())) {
                                    double descuento = moto[x].getTarifa() * 0.10;
                                    double montoTotal = moto2.monto(moto[x].getTarifa());

                                    try {
                                        System.out.println("Ingrese su nit");
                                        String noNit = entrada.nextLine();

                                        PDDocument documento = new PDDocument();
                                        PDPage pagina = new PDPage(PDRectangle.A4);
                                        documento.addPage(pagina);
                                        PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

                                        for (int i = 1; i <= 6; i++) {
                                            contenido.beginText();
                                            contenido.setFont(PDType1Font.HELVETICA, 12);
                                            if (i == 1) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText(":FACTURA:");
                                            }
                                            if (i == 2) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("El NIT para su factura es------- " + noNit);
                                            }
                                            if (i == 3) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("El precio por la tarifa es------- " + moto[x].getTarifa());
                                            }
                                            if (i == 4) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("Tiene un descuento de------- " + descuento);
                                            }
                                            if (i == 5) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("Tiene un recargo de------- 0");
                                            }
                                            if (i == 6) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("El monto a pagar es de------- " + montoTotal);
                                            }

                                            contenido.endText();
                                        }
                                        contenido.close();

                                        documento.save("C:\\Users\\em47a\\OneDrive\\Escritorio\\SEMESTRE 4\\PROGRAMACION 3\\UNIDAD 2\\tAREAS\\Proyecto_12021\\pdf\\facturaMotocicleta.pdf");
                                        
                                        System.out.println("Se ha generando el PDF");


                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                    cont++;
                                    break;
                                }

                            }

                            if (cont == 0) {
                                System.out.println("La placa que ingreso no coincide con ninguna del estacionamiento");
                            }

                            break;
                            
                        case 3:
                            
                            System.out.println("Ingrese su numero de placa");
                            placa = entrada.nextLine();

                            contador = 0;
                            

                            Camion camion2 = new Camion();

                            for (int x = 0; x < parqueo3; x++) {
                                if (placa.equals(camion[x].getNoPlaca())) {
                                    double periodos = 0;
                                    System.out.println("Cuantos periodos estuvo en el estacionamiento?");
                                    periodos = entrada.nextDouble();
                                    double recargo = (periodos - 1) * 5;
                                    double montoTotal = camion2.total(periodos);

                                    try {
                                        entrada.nextLine();
                                        System.out.println("Ingrese su nit");
                                        String noNit = entrada.nextLine();

                                        PDDocument documento = new PDDocument();
                                        PDPage pagina = new PDPage(PDRectangle.A4);
                                        documento.addPage(pagina);
                                        PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

                                        for (int i = 1; i <= 6; i++) {
                                            contenido.beginText();
                                            contenido.setFont(PDType1Font.HELVETICA, 12);
                                            if (i == 1) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText(":FACTURA:");
                                            }
                                            if (i == 2) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("El NIT para su factura es------- " + noNit);
                                            }
                                            if (i == 3) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("El precio por la tarifa es------- " + camion[x].getTarifa());
                                            }
                                            if (i == 4) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("Tiene un descuento de------- 0");
                                            }
                                            if (i == 5) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("Tiene un recargo de------- " + recargo);
                                            }
                                            if (i == 6) {
                                                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                                                contenido.showText("El monto a pagar es de------- " + montoTotal);
                                            }

                                            contenido.endText();
                                        }
                                        contenido.close();

                                        documento.save("C:\\Users\\em47a\\OneDrive\\Escritorio\\SEMESTRE 4\\PROGRAMACION 3\\UNIDAD 2\\tAREAS\\Proyecto_12021\\pdf\\facturaCamion.pdf");
                                        
                                        System.out.println("Se ha generando el PDF");


                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                    contador++;
                                    break;
                                }
                            }

                            if (contador == 0) {
                                System.out.println("La placa que ingreso no coincide con ninguna del estacionamiento");
                            }
                            break;
                            
                        case 4:
                            break;
                        
                    }
                    
                case 3:
                    break;
                
            }

            

        } while (op != 3);
        
    }
    
}

