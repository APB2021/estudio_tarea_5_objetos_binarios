package estudio_tarea_5;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

class ObjectOutputStreamSinCabecera extends ObjectOutputStream {
	public ObjectOutputStreamSinCabecera(OutputStream fos) throws IOException {
		super(fos);
	}

	@Override
	protected void writeStreamHeader() throws IOException {
		// Evitar escribir cabecera duplicada
		reset();
	}
}
