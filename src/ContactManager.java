package src;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    
    private List<Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<>();
    }

    // Método para Agregar un contacto
    public void addContact(Contact contact) {
        this.contacts.add(contact);
        System.out.println("\nContacto Agregado: " + contact.getName());
    }

    // Método para Eliminar un contacto
    public void removeContact(String name) {
        Contact contactToRemove = searchByNameContact(name);
        if(contactToRemove != null){
            contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
            System.out.println("\nContacto Eliminado con Éxito");
        } else { System.out.println("\nContacto No Encontrado"); }
    }

    // Método para buscar un Contacto por el nombre
    public Contact searchByNameContact(String name){
        return contacts.stream()
                .filter(contact -> contact.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }

    // Metodo para Listar Contactos
    public void listContacts(){
        if(contacts.isEmpty()){ System.out.println("\nNo hay contactos para mostrar"); }
        else { System.out.println("\nLista de Contactos\n---------------------------------");
            contacts.forEach(contact -> System.out.println(contact + "\n---------------------------------"));}
    }
}