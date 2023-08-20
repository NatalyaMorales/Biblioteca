package biblioteca;

import java.util.ArrayList;

class AdministradorLibros {
    private ArrayList<Libro> biblioteca = new ArrayList<>();

    // Métodos agregarLibro, eliminarLibroPorISBN, mostrarLibros...
    void agregarLibro(Libro libro) {
        biblioteca.add(libro);
    }

    boolean eliminarLibroPorISBN(String ISBN) {
        for (Libro libro : biblioteca) {
            if (libro.ISBN.equals(ISBN)) {
                biblioteca.remove(libro);
                return true;
            }
        }
        return false;
    }

    String mostrarLibros() {
        StringBuilder librosStr = new StringBuilder();
        for (Libro libro : biblioteca) {
            librosStr.append(libro).append("\n");
        }
        return librosStr.toString();
    }
}