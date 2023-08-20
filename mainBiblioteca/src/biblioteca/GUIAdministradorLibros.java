package biblioteca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAdministradorLibros {
    private JFrame frame;
    private AdministradorLibros admin;

    public GUIAdministradorLibros() {
        frame = new JFrame("Administrador de Libros");
        admin = new AdministradorLibros();

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Opciones");
        JMenuItem agregarItem = new JMenuItem("Agregar libro");
        JMenuItem eliminarItem = new JMenuItem("Eliminar libro por ISBN");
        JMenuItem mostrarItem = new JMenuItem("Mostrar todos los libros");

        menu.add(agregarItem);
        menu.add(eliminarItem);
        menu.add(mostrarItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        agregarItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titulo = JOptionPane.showInputDialog(frame, "Ingrese el título del libro:");
                String autor = JOptionPane.showInputDialog(frame, "Ingrese el autor:");
                String ISBN = JOptionPane.showInputDialog(frame, "Ingrese el ISBN:");

                if (titulo != null && autor != null && ISBN != null) {
                    Libro libro = new Libro(titulo, autor, ISBN);
                    admin.agregarLibro(libro);
                    JOptionPane.showMessageDialog(frame, "Libro agregado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        eliminarItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ISBN = JOptionPane.showInputDialog(frame, "Ingrese el ISBN del libro a eliminar:");

                if (ISBN != null && admin.eliminarLibroPorISBN(ISBN)) {
                    JOptionPane.showMessageDialog(frame, "Libro eliminado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "No se encontró libro con ese ISBN.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        mostrarItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String libros = admin.mostrarLibros();
                if (libros != null) {
                    JOptionPane.showMessageDialog(frame, libros, "Biblioteca", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "No hay libros en la biblioteca.", "Biblioteca", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUIAdministradorLibros();
            }
        });
    }
}
