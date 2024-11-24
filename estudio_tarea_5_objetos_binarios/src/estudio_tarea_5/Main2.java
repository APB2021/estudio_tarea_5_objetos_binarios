package estudio_tarea_5;

public class Main2 {
	public static void main(String[] args) {
		GestorAlumnos gestor = new GestorAlumnos();
		gestor.leerFicheroBinario(gestor.solicitarFicheroBinario());
	}
}