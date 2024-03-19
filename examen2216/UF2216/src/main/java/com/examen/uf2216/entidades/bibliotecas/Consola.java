package com.examen.uf2216.entidades.bibliotecas;

import java.util.Scanner;

public class Consola {
	private static final Scanner sc = new Scanner(System.in);

	public static String leerString(String mensaje, boolean esOpcional) {
		String texto;
		boolean repetir = true;

		do {
			System.out.println(mensaje + ": ");
			texto = sc.nextLine().trim();

			if (!esOpcional && texto.length() == 0) {
				System.out.println("Este dato es obligatorio");
			} else {
				repetir = false;
			}
		} while (repetir);

		return texto.length() > 0 ? texto : null;
	}

	public static Long leerLong(String mensaje, boolean obligatorio) {
	    boolean hayError = true;
	    Long l = null;

	    do {
	        String dato = leerString(mensaje, obligatorio);

	        if (dato == null) {
	            return null;
	        }

	        try {
	            l = Long.parseLong(dato);
	            hayError = false;
	        } catch (NumberFormatException e) {
	            System.out.println("Por favor, introduce un número válido.");
	        }
	    } while (hayError);

	    return l;
	}


	public static int leerInt(String mensaje, boolean esObligatorio) {
        int numero = 0;
        boolean hayError;

        do {
            try {
                String dato = leerString(mensaje, esObligatorio);
                if (dato == null) {
                    return 0;
                }

                numero = Integer.parseInt(dato);
                hayError = false;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número entero válido");
                hayError = true;
            }
        } while (hayError);

        return numero;
    }

	public static boolean leerBoolean(String mensaje, boolean esOpcional) {
	    String entrada;
	    boolean valor = false;

	    do {
	        System.out.print(mensaje);
	        entrada = sc.nextLine().trim();

	        if (entrada.isEmpty()) {
	            if (esOpcional) {
	                return false;
	            } else {
	                System.out.println("Este dato es obligatorio");
	            }
	        } else if (entrada.equalsIgnoreCase("true") || entrada.equalsIgnoreCase("false")) {
	            valor = Boolean.parseBoolean(entrada);
	        } else {
	            System.out.println("Por favor, introduce 'true' o 'false'");
	        }
	    } while (!entrada.equalsIgnoreCase("true") && !entrada.equalsIgnoreCase("false"));

	    return valor;
	}
}
