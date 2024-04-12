package com.examen.uf2216.entidades.daos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.examen.uf2216.entidades.Libro;

public class LibroDaoCSV implements LibroDao<Libro> {

    private String filePath;

    public LibroDaoCSV(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Iterable<Libro> obtenerTodos() {
        List<Libro> libros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4) {
                    String titulo = data[0];
                    Long isbn = Long.parseLong(data[1]);
                    int nPaginas = Integer.parseInt(data[2]);
                    boolean formato = Boolean.parseBoolean(data[3]);
                    libros.add(new Libro(titulo, isbn, nPaginas, formato));
                } else {
                    System.out.println("Línea mal formateada: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return libros;
    }

    @Override
    public Libro obtenerPorIsbn(Long isbn) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Long currentIsbn = Long.parseLong(data[1]);
                if (currentIsbn.equals(isbn)) {
                    String titulo = data[0];
                    int nPaginas = Integer.parseInt(data[2]);
                    boolean formato = Boolean.parseBoolean(data[3]);
                    return new Libro(titulo, isbn, nPaginas, formato);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Libro insertar(Libro libro) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath, true))) {
            pw.println(libro.getTitulo() + "," + libro.getIsbn() + "," + libro.getnPaginas() + "," + libro.getFormato());
            return libro;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
