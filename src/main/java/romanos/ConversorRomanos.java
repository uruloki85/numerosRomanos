package romanos;

public class ConversorRomanos {
	public static String aNumeroRomano(int num) {
		String numeroRomano = "";
		
		int[] valores = separarDigitos(num);
		
		for (int numero : valores) {
			numeroRomano += calcular(numero);
		}
		
		return numeroRomano;
	}
	
	private static String calcular(int numero) {
		String valor = "";
		if (numero >= NumerosRomanos.MIL.getNumero()) {
			// numero >= 1000
			valor = mayorIgualQueXRepetible(numero, NumerosRomanos.MIL,
					NumerosRomanos.QUINIENTOS, 100);
		} else if (numero < NumerosRomanos.MIL.getNumero()
				&& numero >= NumerosRomanos.QUINIENTOS.getNumero()) {
			// 1000 > numero >= 500
			valor = mayorIgualQueX(numero, NumerosRomanos.QUINIENTOS,
					NumerosRomanos.MIL, NumerosRomanos.CIEN, 100);
		} else if (numero < NumerosRomanos.QUINIENTOS.getNumero()
				&& numero >= NumerosRomanos.CIEN.getNumero()) {
			// 500 > numero >= 100
			valor = mayorIgualQueXRepetible(numero, NumerosRomanos.CIEN,
					NumerosRomanos.QUINIENTOS, 100);
		} else if (numero < NumerosRomanos.CIEN.getNumero()
				&& numero >= NumerosRomanos.CINCUENTA.getNumero()) {
			// 100 > numero >= 50
			valor = mayorIgualQueX(numero, NumerosRomanos.CINCUENTA,
					NumerosRomanos.CIEN, NumerosRomanos.DIEZ, 10);
		} else if (numero < NumerosRomanos.CINCUENTA.getNumero()
				&& numero >= NumerosRomanos.DIEZ.getNumero()) {
			// 50 > numero >= 10
			valor = mayorIgualQueXRepetible(numero, NumerosRomanos.DIEZ,
					NumerosRomanos.CINCUENTA, 10);
		} else if (numero < NumerosRomanos.DIEZ.getNumero()
				&& numero >= NumerosRomanos.CINCO.getNumero()) {
			// 10 > numero >= 5
			valor = mayorIgualQueX(numero, NumerosRomanos.CINCO,
					NumerosRomanos.DIEZ, NumerosRomanos.UNO, 1);
		} else {
			// 5 > numero > 0
			valor = mayorIgualQueXRepetible(numero, NumerosRomanos.UNO,
					NumerosRomanos.CINCO, 1);
		}

		return valor;
	}
	
	private static String mayorIgualQueX(int numero, NumerosRomanos numX,
			NumerosRomanos numSuperior, NumerosRomanos numInferior, int decena) {
		String valor = "";
		int div = numero / numX.getNumero();
		int mod = numero % numX.getNumero();
		mod /= decena;
		if (mod > numInferior.getMaxRepeticiones()) {
			// Restar (p.e. IX para 9)
			int repeticiones = numSuperior.getNumero() - div * numX.getNumero()
					- mod * decena;
			repeticiones /= decena;
			valor += concatenaValorXVeces(numInferior.getNumeroRomano(),
					repeticiones);
			valor += numSuperior.getNumeroRomano();
		} else {
			// Concatena (p.e. VI para 6)
			valor += numX.getNumeroRomano();
			valor += concatenaValorXVeces(numInferior.getNumeroRomano(), mod);
		}
		return valor;

	}

	private static String mayorIgualQueXRepetible(int numero,
			NumerosRomanos numX, NumerosRomanos numSuperior, int decena) {
		String valor = "";
		int div = numero / numX.getNumero();
		int mod = numero % numX.getNumero();

		if (div > numX.getMaxRepeticiones()) {
			// Restar (p.e. XL para 40)
			int repeticiones = numSuperior.getNumero() - div * numX.getNumero()
					- mod;
			repeticiones /= decena;
			valor += concatenaValorXVeces(numX.getNumeroRomano(), repeticiones);
			valor += numSuperior.getNumeroRomano();
		} else {
			// Concatena (p.e. XX para 20)
			valor += concatenaValorXVeces(numX.getNumeroRomano(), div);
		}
		return valor;

	}
	
	private static String concatenaValorXVeces(String letra, int div) {		
		String numeroRomano = "";
		for (int i = 0; i < div; i++) {
			numeroRomano += letra;
		}		
		return numeroRomano;
	}

	private static int[] separarDigitos(int num) {
		String numero = String.valueOf(num);
		int digitos[] = new int[numero.length()];
		for(int i=0; i < numero.length(); i++) {
			int posicion = (numero.length()-1)-i;
			String valor = concatenaCerosSegunPosicion(numero.charAt(i), posicion);
			digitos[i] = Integer.parseInt(valor);
		}
		
		return digitos;
	}

	private static String concatenaCerosSegunPosicion(char digito, int posicion) {
		
		String valor = String.valueOf(digito);
		for(int i = 0; i < posicion; i++) {
			valor += "0";
		}
		
		return valor;
	}
	
//	private static String mayorQue0(int numero) {
//		String valor = "";
//		int div = numero / NumerosRomanos.UNO.getNumero();
//		
//		if (div > NumerosRomanos.UNO.getMaxRepeticiones()*NumerosRomanos.UNO.getNumero()) {
//			//Restar (p.e. IV para 4)
//			int repeticiones = NumerosRomanos.CINCO.getNumero() 
//					- (div * NumerosRomanos.UNO.getNumero());		
//			valor += concatenaValorXVeces(NumerosRomanos.UNO.getNumeroRomano(), repeticiones);
//			valor += NumerosRomanos.CINCO.getNumeroRomano();
//		} else {
//			//Concatena (p.e. II para 2)
//			valor = concatenaValorXVeces(NumerosRomanos.UNO.getNumeroRomano(), div);
//		}
//		return valor;
//	}
	
//	private static String mayorQue1000(int numero) {
//		int div = numero / NumerosRomanos.MIL.getNumero();
//		String valor = concatenaValorXVeces(NumerosRomanos.MIL.getNumeroRomano(), div); 
//		
//		return valor;
//	}
	
//	private static String mayorIgualQue500(int numero) {
//	String valor = "";
//	int div = numero / NumerosRomanos.QUINIENTOS.getNumero();
//	int mod = numero % NumerosRomanos.QUINIENTOS.getNumero();
//	mod /= 100;
//	if (mod > NumerosRomanos.CIEN.getMaxRepeticiones()) {
//		//Restar (p.e. CM para 900)
//		int repeticiones = NumerosRomanos.MIL.getNumero() - div
//				* NumerosRomanos.QUINIENTOS.getNumero() - mod * 100;
//		if (repeticiones != 0) {
//			repeticiones /= 100;
//		}
//		valor += concatenaValorXVeces(NumerosRomanos.CIEN.getNumeroRomano(), repeticiones);
//		valor += NumerosRomanos.MIL.getNumeroRomano();
//	} else {
//		//Concatena (p.e. DC para 600)
//		valor += NumerosRomanos.QUINIENTOS.getNumeroRomano();
//		valor += concatenaValorXVeces(NumerosRomanos.CIEN.getNumeroRomano(), mod);
//	}
//	return valor;
//}

//private static String mayorIgualQue50(int numero) {
//	String valor = "";
//	int div = numero / NumerosRomanos.CINCUENTA.getNumero();
//	int mod = numero % NumerosRomanos.CINCUENTA.getNumero();
//	mod /= 10;
//	if (mod > NumerosRomanos.DIEZ.getMaxRepeticiones()) {
//		//Restar (p.e. XC para 90)
//		int repeticiones = NumerosRomanos.CIEN.getNumero() - div
//				* NumerosRomanos.CINCUENTA.getNumero() - mod * 10;
//		if (repeticiones != 0) {
//			repeticiones /= 10;
//		}			
//		valor += concatenaValorXVeces(NumerosRomanos.DIEZ.getNumeroRomano(), repeticiones);
//		valor += NumerosRomanos.CIEN.getNumeroRomano();
//	} else {
//		//Concatena (p.e. LX para 60)
//		valor += NumerosRomanos.CINCUENTA.getNumeroRomano();
//		valor += concatenaValorXVeces(NumerosRomanos.DIEZ.getNumeroRomano(), mod);
//	}
//	return valor;
//}

//private static String mayorIgualQue5(int numero) {
//	String valor = "";
//	int div = numero / NumerosRomanos.CINCO.getNumero();
//	int mod = numero % NumerosRomanos.CINCO.getNumero();
//	
//	if (mod > NumerosRomanos.UNO.getMaxRepeticiones()*NumerosRomanos.UNO.getNumero()) {
//		//Restar (p.e. IX para 9)
//		int repeticiones = NumerosRomanos.DIEZ.getNumero() 
//				- (div * NumerosRomanos.CINCO.getNumero())
//						- mod;		
//		valor += concatenaValorXVeces(NumerosRomanos.UNO.getNumeroRomano(), repeticiones);
//		valor += NumerosRomanos.DIEZ.getNumeroRomano();
//	} else {
//		//Concatena (p.e. VI para 6)
//		valor += NumerosRomanos.CINCO.getNumeroRomano();
//		valor += concatenaValorXVeces(NumerosRomanos.UNO.getNumeroRomano(), mod);
//	}
//	return valor;
//}
	
//	private static String mayorIgualQue100(int numero) {
//		String valor = "";
//		int div = numero / NumerosRomanos.CIEN.getNumero();
//		int mod = numero % NumerosRomanos.CIEN.getNumero();
//
//		if (div > NumerosRomanos.CIEN.getMaxRepeticiones()) {
//			//Restar (p.e. CD para 400)
//			int repeticiones = NumerosRomanos.QUINIENTOS.getNumero()
//					- div * NumerosRomanos.CIEN.getNumero() - mod;
//			if (repeticiones != 0) {
//				repeticiones /= 100;
//			}			
//			valor += concatenaValorXVeces(NumerosRomanos.CIEN.getNumeroRomano(), repeticiones);
//			valor += NumerosRomanos.QUINIENTOS.getNumeroRomano();
//		} else {
//			//Concatena (p.e. CC para 200)
//			valor = concatenaValorXVeces(NumerosRomanos.CIEN.getNumeroRomano(), div);
//		}
//		return valor;
//	}
	
//	private static String mayorIgualQue10(int numero) {
//		String valor = "";
//		int div = numero / NumerosRomanos.DIEZ.getNumero();
//		int mod = numero % NumerosRomanos.DIEZ.getNumero();
//		
//		if (div > NumerosRomanos.DIEZ.getMaxRepeticiones()) {
//			//Restar (p.e. XL para 40)
//			int repeticiones = NumerosRomanos.CINCUENTA.getNumero() - div
//					* NumerosRomanos.DIEZ.getNumero() - mod * 10;
//			if (repeticiones != 0) {
//				repeticiones /= 10;
//			}			
//			valor += concatenaValorXVeces(NumerosRomanos.DIEZ.getNumeroRomano(), repeticiones);
//			valor += NumerosRomanos.CINCUENTA.getNumeroRomano();
//		} else {
//			//Concatena (p.e. XX para 20)
//			valor = concatenaValorXVeces(NumerosRomanos.DIEZ.getNumeroRomano(), div);
//		}
//		return valor;
//	}
}
