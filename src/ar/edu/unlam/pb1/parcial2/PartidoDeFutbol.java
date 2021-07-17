package ar.edu.unlam.pb1.parcial2;

public class PartidoDeFutbol {
	private EquipoDeFutbol local;
	private EquipoDeFutbol visitante;
	private int ContadorGolesLocales = 0;
	private int ContadorGolesVisitantes = 0;
	private Evento goles[];
	private Evento amonestados[];
	private Evento expulsados[];
	

	public PartidoDeFutbol(EquipoDeFutbol local, EquipoDeFutbol visitante) {
		this.local = local;
		this.visitante = visitante;
		goles = new Evento[10];
		amonestados = new Evento[22];
		expulsados = new Evento[11];
	}
	
	/*
	 * Se debe marcar un nuevo Gol 
	 * Dependiendo del autor (según al equipo que pertenezca) y del tipo (si es a favor o en contra) se sabrá a quien contabilizarlo
	 */
	public void marcar(Evento gol) {
		for (Evento golesMarcados : goles) {
			if (golesMarcados == null) {
				golesMarcados = gol;
			}
		}
	}
	
	/*
	 * Se registra un nuevo amonestado en el partido. 
	 * Si el mismo ya poseía una amonestación previa, se lo debe expulsar. 
	 * El método devuelve la cantidad de amonestaciones del jugador. 
	 * Los valores posibles de retorno son:
	 * 1 - Si no tenía amonestación previa o 
	 * 2 - Si ya poseía una amonestación previa y termina siendo expulsado
	 * 
	 */
	public int amonestar(Evento amonestado) {
		for (Evento jugadoresAmonestados : amonestados) {
			if (jugadoresAmonestados == null) {
				jugadoresAmonestados = amonestado;
				return 1;
			} else {
				if (jugadoresAmonestados.getAutor().getNombre() == amonestado.getAutor().getNombre()) {
					return 2;
				}
			}
		}
		return 0;
	}

	/*
	 * Se registra un nuevo expulsado en el partido. 
	 */
	public void expulsar(Evento expulsado) {
		for (Evento jugadorExpulsado : expulsados) {
			if (jugadorExpulsado == null) {
				jugadorExpulsado = expulsado;
			}
		}
	}

	/*
	 * Se cuentan la cantidad de goles por equipo (Se debe considerar si el gol resultó a favor o en contra), y devuelve el equipo ganador (Si hubo un empate retorna null) 
	 */
	public EquipoDeFutbol getGanador() {
		EquipoDeFutbol ganador = null;

		for (Evento goles : goles) {
			if (goles != null) {
				if (goles.getTipo() == TipoDeEvento.GOL_A_FAVOR && goles.getAutor().getEquipo() == local || goles.getTipo() == TipoDeEvento.GOL_EN_CONTRA && goles.getAutor().getEquipo() == visitante) {
					ContadorGolesLocales++;
				}
				if (goles.getTipo() == TipoDeEvento.GOL_A_FAVOR && goles.getAutor().getEquipo() == visitante || goles.getTipo() == TipoDeEvento.GOL_EN_CONTRA && goles.getAutor().getEquipo() == local) {
					ContadorGolesVisitantes++;
				}
			}
		}
		
		if(ContadorGolesLocales>ContadorGolesVisitantes) {
			ganador= local;
		}else {
			ganador= visitante;
		}
		
		return ganador;
	}
	
	/*
	 * El método toString debe describir el ESTADO del partido (Equipos que se enfrentan, los goles realizados, los amonestado y expulsados).
	 */
	public String toString() {
		String resultado = "Se enfrentan los equipos " + getLocal() + " de local y " + getVisitante() + " de visitante\nEl equipo " 
						+ getLocal() + " marcó " + ContadorGolesLocales + " goles y el equipo visitante " + getVisitante() + " marcó " + ContadorGolesVisitantes 
						+ " goles. \nEl equipo ganador es: " + getGanador();
		return resultado;
	}

	public EquipoDeFutbol getLocal() {
		return local;
	}

	public EquipoDeFutbol getVisitante() {
		return visitante;
	}

}
