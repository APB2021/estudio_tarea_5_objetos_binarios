package estudio_tarea_5;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		GestorAlumnos gestor = new GestorAlumnos();
		File ficheroBinarioAlumos = gestor.solicitarFicheroBinario();

		for (int i = 0; i < 5; i++) {
			Alumno alumno = gestor.leeAlumno();
			gestor.guardaObjetoAlumno(alumno, ficheroBinarioAlumos);
		}
	}
}