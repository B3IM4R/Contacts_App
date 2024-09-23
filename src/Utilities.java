package src;

public class Utilities {
    // Método que valida el nombre del contacto
    public static boolean isValidName(String name) {
        return name.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$");
    }

    // Método que valida el número de teléfono
    public static boolean isvalidPhoneNumber(String phoneNumber){
        return phoneNumber.matches("\\+?\\d{10,15}");
    }

    // Método que valida el correo electrónico
    public static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
}