package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;
import java.util.Random;
import java.util.Arrays;


public class SandboxArreglos
{
    private int[] arregloEnteros;
    private String[] arregloCadenas;

    
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    
    public int[] getCopiaEnteros( )
    {	
    	int size = arregloEnteros.length;
    	int[] copia = new int[size];
    	for (int i = 0;  i < size; i++) {
    		copia[i] = arregloEnteros[i];
    	}
        return copia;
    }

    
    public String[] getCopiaCadenas( )
    {	
    	int size = arregloCadenas.length;
    	String[] copia = new String[size];
    	for (int i = 0; i < size; i++) {
    		copia[i] = arregloCadenas[i];
    	}
        return copia;
    }

    
    public int getCantidadEnteros( )
    {
        return arregloEnteros.length;
    }

    
    public int getCantidadCadenas( )
    {
        return arregloCadenas.length;
    }

    
    public void agregarEntero( int entero )
    {	
    	int size = arregloEnteros.length;
    	int[] nuevo = new int[size + 1];
    	for (int i = 0; i < size; i++) {
    		nuevo[i] = arregloEnteros[i];
    	}
    	nuevo[size] = entero;
    	arregloEnteros = nuevo;
    }

    
    public void agregarCadena( String cadena )
    {	
    	int size = arregloCadenas.length;
    	String[] nuevo = new String[size + 1];
    	for (int i = 0; i < size; i++) {
    		nuevo[i] = arregloCadenas[i];
    	}
    	nuevo[size] = cadena;
    	arregloCadenas = nuevo;
    }

    
    public void eliminarEntero( int valor )
    {	
    	int size = arregloEnteros.length;
    	int contador = 0;
    	for (int i = 0; i < size; i++) {
    		if (valor == arregloEnteros[i]) {
    			contador++;
    		}
    	}
    	int[] nuevo = new int[size - contador];
    	int indice = 0;
    	for (int i = 0; i < size; i++) {
    		if (valor != arregloEnteros[i]) {
    			nuevo[indice++] = arregloEnteros[i];
    		}
    	}
    	arregloEnteros = nuevo;
    }

    
    public void eliminarCadena( String cadena )
    {	
    	int size = arregloCadenas.length;
    	int contador = 0;
		for (int i = 0; i < size; i++) {
			if (arregloCadenas[i].equals(cadena)) {
				contador++;
			}
		}
		String[] nuevo = new String[size - contador];
		int indice = 0;
		for (int i = 0; i < size; i++) {
			if (!arregloCadenas[i].equals(cadena)) {
				nuevo[indice++] = arregloCadenas[i];
			}
		}
		arregloCadenas = nuevo;
	}

    
    public void insertarEntero( int entero, int posicion )
    {
    	int size = arregloEnteros.length;
    	posicion = Math.max(0, Math.min(posicion, size));
    	int[] nuevo = new int[size + 1];
    	
    	for (int i = 0; i < size; i++) {
    		nuevo[i] = arregloEnteros[i];
    	}
    	nuevo[posicion] = entero;
    	
    	for (int i = posicion; i < size; i++) {
    		nuevo[i+1] = arregloEnteros[i];
    	}
    	arregloEnteros = nuevo;
    }

    
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	int size = arregloEnteros.length;
    	if (posicion >= size || posicion < 0) return;
    	
    	int[] nuevo = new int[size];
    	
    	for(int i = 0; i < posicion; i++) {
    		nuevo[i] = arregloEnteros[i]; 
    	}
    	for(int i = posicion + 1; i < size; i++) {
    		nuevo[i-1] = arregloEnteros[i];
    	}
    	arregloEnteros = nuevo;
    }

    public void reiniciarArregloEnteros( double[] valores )
    {
    	int size = valores.length;
    	arregloEnteros = new int[size];
    	
    	for(int i = 0; i < size; i++) {
    		arregloEnteros[i] = (int)valores[i];
    	}
    }


    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	int size = objetos.length;
    	arregloCadenas = new String[size];
    	
    	for(int i = 0; i < size; i++) {
    		arregloCadenas[i] = objetos[i].toString();
    	}
    }

    
    public void volverPositivos( )
    {
    	int size = arregloEnteros.length;
    	
    	for(int i = 0; i < size; i++) {
    		if (arregloEnteros[i] < 0) {
    			arregloEnteros[i] = arregloEnteros[i] * -1;
    		}
    	}
    }

    
    public void organizarEnteros( )
    {
    	Arrays.sort(arregloEnteros);
    }


    public void organizarCadenas( )
    {
    	Arrays.sort(arregloCadenas);
    }


    public int contarApariciones( int valor )
    {
    	int size = arregloEnteros.length;
        int contador = 0;
        
        for(int i = 0; i < size; i++) {
        	if(arregloEnteros[i] == valor) {
        		contador++;
        	}
        }
        return contador;
    }


    public int contarApariciones( String cadena )
    {
        int size = arregloCadenas.length;
        int contador = 0;
        
        for(int i = 0; i < size; i++) {
        	if(arregloCadenas[i].equalsIgnoreCase(cadena)) {
        		contador++;
        	}
        }
        return contador;
    }


    public int[] buscarEntero( int valor )
    {
    	int contador = 0;
        int size = arregloEnteros.length;
        
        for(int i = 0; i < size; i++) {
        	if(arregloEnteros[i] == valor) {
        		contador++;
        	}
        }
        
        int[] posiciones = new int[contador];
        int pos = 0;
        
        for(int i = 0; i < size; i++) {
        	if(arregloEnteros[i] ==  valor) {
        		posiciones[pos] = i;
        		pos++;
        	}
        }
        return posiciones;
    }

    
    public int[] calcularRangoEnteros( )
    {
        int size = arregloEnteros.length;
        
        if(size == 0) {
        	return new int[0];
        }

        int min = arregloEnteros[0];
        int max = arregloEnteros[0];

        for(int i = 0; i < size; i++) {
        	if(arregloEnteros[i] < min) {
        		min = arregloEnteros[i];
        	}
        	if(arregloEnteros[i] > max) {
        		max = arregloEnteros[i];
        	}
        }
        return new int[] {min, max};
    }

    
    public HashMap<Integer, Integer> calcularHistograma()
    {
        HashMap<Integer, Integer> histograma = new HashMap<>();
        int size = arregloEnteros.length;
        for(int i = 0; i < size; i++) {
        	if(histograma.containsKey(i)){
        		histograma.put(i, histograma.get(i) + 1);
        	}
        	else {
        		histograma.put(i, 1);
        	}
        }
        return histograma;
    }


    public int contarEnterosRepetidos()
    {
    	HashMap<Integer, Integer> conteo = new HashMap<>();
    	int contador = 0;
    	int size = arregloEnteros.length;
    	
    	for(int i = 0; i < size; i++) {
    		if(conteo.containsKey(i)) {
    			conteo.put(i, conteo.get(i) + 1);
    			if(conteo.get(i) == 2) {
    				contador++;
    			}
    		}
    		else {
    			conteo.put(i, 1);
    		}
    	}
    	return contador;
    }


    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	int size = arregloEnteros.length;
        if(size != otroArreglo.length) {
        	return false;
        }
        for(int i = 0; i < size; i++) {
        	if(arregloEnteros[i] != otroArreglo[i]) {
        		return false;
        	}
        }
        return true; 
    }
    
    private boolean compararArreglos(int[] arreglo1, int[] arreglo2) {
    	int size = arreglo1.length;
    	for(int i = 0; i < size; i++) {
    		if(arreglo1[i] != arreglo2[i]) {
    			return false;
    		}
    	}
    	return true; 
    }


    public boolean mismosEnteros( int[] otroArreglo )
    {
        int size = arregloEnteros.length;
        int sizeOtro = otroArreglo.length;
        
        if(size != sizeOtro) {
        	return false;
        }
        int[] copiaOg = getCopiaEnteros();
        int[] copiaOtros = Arrays.copyOf(otroArreglo, sizeOtro);
        Arrays.sort(copiaOg);
        Arrays.sort(copiaOtros);
        
       return compararArreglos(copiaOg, copiaOtros);
    }


    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	Random random = new Random();
    	arregloEnteros = new int[cantidad];
    	
    	for(int i = 0; i < cantidad; i++) {
    		arregloEnteros[i] = random.nextInt(maximo - minimo + 1) + minimo;
    	}
    	
    }

}
