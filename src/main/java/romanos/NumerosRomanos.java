package romanos;

public enum NumerosRomanos {
	UNO (1,"I",3),
	CINCO (5, "V",1),
	DIEZ (10, "X",3),
	CINCUENTA (50,"L",1),
	CIEN (100,"C",3),
	QUINIENTOS(500,"D",1),
	MIL(1000,"M",100);
	
	private final int numero;
	private final String numeroRomano;
	private final int maxRepeticiones;
	
	NumerosRomanos(int numero, String numeroRomano, int maxRepeticiones) {
		this.numero=numero;
		this.numeroRomano=numeroRomano;
		this.maxRepeticiones = maxRepeticiones;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public String getNumeroRomano() {
		return this.numeroRomano;
	}
	
	public int getMaxRepeticiones() {
		return this.maxRepeticiones;
	}
}
