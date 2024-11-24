package estudio_tarea_5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GestorAlumnos {

	private static Scanner sc = new Scanner(System.in);

	private String solicitarDatoString(String datoSolicitado) {
		System.out.print(datoSolicitado);
		datoSolicitado = sc.nextLine();
		return datoSolicitado;
	}

	public File solicitarFicheroBinario() {
		String rutaFicheroBinario = solicitarDatoString("Ruta: ");
		String nombreFicheroBinario = solicitarDatoString("Nombre fichero binario(.dat): ");
		File ficheroBinario = new File(rutaFicheroBinario, nombreFicheroBinario);
		return ficheroBinario;
	}

	public Alumno leeAlumno() {

		System.out.print("Nia: ");
		int nia = sc.nextInt();
		sc.nextLine();

		String nombre = solicitarDatoString("Nombre: ");
		String apellidos = solicitarDatoString("Apellidos: ");

		System.out.print("Género: ");
		char genero = sc.nextLine().toUpperCase().charAt(0);

		String fechaNacimientoString = solicitarDatoString("Fecha de nacimiento: ");
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaNacimientoLocalDate = LocalDate.parse(fechaNacimientoString, formato);

		String ciclo = solicitarDatoString("Ciclo: ");
		String curso = solicitarDatoString("Curso: ");
		String grupo = solicitarDatoString("Grupo: ");

		Alumno alumno = new Alumno(nia, nombre, apellidos, genero, fechaNacimientoLocalDate, ciclo, curso, grupo);

		return alumno;
	}

	public void guardaObjetoAlumno(Alumno alumno, File ficheroBinario) {
	    boolean existeFichero = ficheroBinario.exists(); // Verificar si el fichero ya existe.

	    try (FileOutputStream fos = new FileOutputStream(ficheroBinario, true);
	         ObjectOutputStream oos = existeFichero 
	             ? new ObjectOutputStreamSinCabecera(fos) // Usar clase personalizada si el fichero existe
	             : new ObjectOutputStream(fos)) { // Usar clase estándar si es un fichero nuevo
	        oos.writeObject(alumno); // Escribir el objeto alumno en el fichero
	    } catch (IOException e) {
	        System.err.println("Error al guardar el objeto alumno: " + e.getMessage());
	    }
	}


}
