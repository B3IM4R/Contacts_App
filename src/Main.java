package src;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();
        List<Long> tiempos = new ArrayList<>();

        byte option;

        do {
            String name = "", phoneNumber = "", email = "";

            System.out.println("\n***APLICACIÓN DE CONTACTOS***");
            System.out.println("1. Agregar Nuevo Contacto");
            System.out.println("2. Eliminar un Contacto");
            System.out.println("3. Buscar un Contacto");
            System.out.println("4. Listar Contactos");
            System.out.println("5. Salir del Programa");

            System.out.print("\nElige una Opción: ");
            option = sc.nextByte();
            sc.nextLine();

            long startTime, endTime;

            switch(option){
                case 1:
                    while(!Utilities.isValidName(name)){
                        System.out.print("\nNuevo Contacto\nAsegúrate que el Nombre solo contenga letras\nNombre: ");
                        name = sc.nextLine();
                    }
                    while(!Utilities.isvalidPhoneNumber(phoneNumber)){
                        System.out.print("\nAsegúrate que el Número de Teléfono contenga entre 10 y 15 dígitos\nTeléfono: ");
                        phoneNumber = sc.nextLine();
                    }
                    while(!Utilities.isValidEmail(email)){
                        System.out.print("\nAsegúrate que el correo tenga el formato: 'usuario@dominio.com'\nCorreo: ");
                        email = sc.nextLine();
                    }
                    startTime = System.currentTimeMillis();
                    contactManager.addContact(new Contact(name, phoneNumber, email));
                    endTime = System.currentTimeMillis();
                    tiempos.add(endTime - startTime);
                    break;
                case 2:
                    System.out.print("\nIngresa el Nombre del Contacto a Eliminar: ");
                    name = sc.nextLine();
                    startTime = System.currentTimeMillis();
                    contactManager.removeContact(name);
                    endTime = System.currentTimeMillis();
                    tiempos.add(endTime - startTime);
                    break;
                case 3:
                    System.out.print("\nIngresa el Nombre del Contacto a Buscar: ");
                    name = sc.nextLine();
                    startTime = System.currentTimeMillis();
                    Contact contact = contactManager.searchByNameContact(name);
                    endTime = System.currentTimeMillis();
                    tiempos.add(endTime - startTime);
                    if (contact != null) { System.out.println("\nDatos del Contacto\n\n" + contact); }
                    break;
                case 4:
                    startTime = System.currentTimeMillis();
                    contactManager.listContacts();
                    endTime = System.currentTimeMillis();
                    tiempos.add(endTime - startTime);
                    break;
                case 5:
                    System.out.println("\nSaliendo...");
                    break;
                default:
                    System.out.println("\nOpción Inválida");
                    break;
            }
        } while(option != 5);
        resultadosOperaciones(tiempos);
    }
    private static void resultadosOperaciones(List<Long> tiempos) {
        System.out.println("\n*** RESULTADOS DE TIEMPO DE RESPUESTA ***");
        System.out.println("Operación  | Tiempo (ms)");
        System.out.println("---------------------------");
        for (int i = 0; i < tiempos.size(); i++) {
            System.out.printf("%-11d | %d ms\n", (i + 1), tiempos.get(i));
        }

        long total = 0;
        for (Long tiempo : tiempos) {
            total += tiempo;
        }
        System.out.printf("Promedio: %.2f ms\n", (double) total / tiempos.size());
    }
}