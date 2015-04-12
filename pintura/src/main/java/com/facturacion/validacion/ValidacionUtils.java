package com.facturacion.validacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionUtils {
	public static Boolean tieneSoloNumero (String cadena) {
		//20-08407193-8
		Boolean resultado = false;
		try {
			Integer numero =Integer.parseInt(cadena);
			resultado = true;
		} catch (NumberFormatException e) {
			// no es numero
		} catch (Exception e) {
			// no es numero
		}
		return resultado;
	}

	public static Boolean tieneSoloLetras(String cadena) {
        //en c�digo ASCII los n�meros ocupan rangos entre 48 y 57
        int letraEnASCII;
        boolean contieneSoloLetras = true;
        for (int i = 0; i < cadena.length(); i++)
        {
            letraEnASCII = cadena.codePointAt(i); // convierte a c�digo ASCII
            if ( (letraEnASCII <= 90) && (letraEnASCII >= 65) ) {
            	//ok
            } else if ( (letraEnASCII <= 122) && (letraEnASCII >= 97) ) {
            	//ok
            } else if ( (letraEnASCII <= 165) && (letraEnASCII >= 160) ) {
            	//ok
            } else if ( (letraEnASCII == 129) || (letraEnASCII == 130) || (letraEnASCII == 154) ) {
            	//ok
            } else if ( (letraEnASCII == 181) || (letraEnASCII == 144) || (letraEnASCII == 214) ) {
            	//ok
            } else if ( (letraEnASCII == 224) || (letraEnASCII == 233) ) {
            	//ok
            } else {
            	// no es letra
                contieneSoloLetras = false;
                i = cadena.length();
            }      
        }
        return contieneSoloLetras;
    }
	
	public static Boolean tieneFormatoTelefono(String cadena) {
        //en c�digo ASCII los n�meros ocupan rangos entre 48 y 57
		//40 y 41 son parentesis
		//45 es guion
        int letraEnASCII;
        boolean formatoTelefono = true;
        for (int i = 0; i < cadena.length(); i++)
        {
            letraEnASCII = cadena.codePointAt(i); // convierte a c�digo ASCII
            if ( (letraEnASCII <= 57) && (letraEnASCII >= 48) ) {
            	//ok
            } else if ( (letraEnASCII == 40) || (letraEnASCII == 41) || (letraEnASCII == 45) ) {
            	//ok
            } else {
            	// no es relacionado al formato de telefono
                formatoTelefono = false;
                i = cadena.length();
            }      
        }
        return formatoTelefono;
    }
	public static Boolean tieneFormatoMail(String cadena){
		Boolean result = false;
		Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(cadena);

        if(mat.matches()){
        	result = true;
        }
        return result;
	}
	public static Boolean tieneSoloFloat (String cadena) {
		
		Boolean resultado = false;
		try {
			float numero = Float.valueOf(cadena);
			resultado = true;
		} catch (NumberFormatException e) {
			// no es numero
		} catch (Exception e) {
			// no es numero
		}
		return resultado;
	}
	
}
