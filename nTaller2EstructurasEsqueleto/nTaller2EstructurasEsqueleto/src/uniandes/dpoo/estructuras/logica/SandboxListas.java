package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class SandboxListas
{

    private List<Integer> listaEnteros;

    private List<String> listaCadenas;


    public SandboxListas( )
    {
        listaEnteros = new ArrayList<Integer>( );
        listaCadenas = new LinkedList<String>( );
    }

    
    public List<Integer> getCopiaEnteros( )
    {
        List<Integer> copia = new ArrayList<Integer>();
        
        for(int i = 0; i < listaEnteros.size(); i++) {
        	copia.add(listaEnteros.get(i));
        }
        return copia;
    }

    
    public List<String> getCopiaCadenas( )
    {
        List<String> copia = new LinkedList<String>();
        
        for(int i = 0; i < listaCadenas.size(); i++) {
        	copia.add(listaCadenas.get(i));
        }
        return copia;
    }

    
    public int[] getEnterosComoArreglo( )
    {	
    	int size = listaEnteros.size();
        int[] arreglo = new int[size];
        
        for(int i = 0; i < size; i++) {
        	arreglo[i] = listaEnteros.get(i);
        }
        return arreglo;
    }


    public int getCantidadEnteros( )
    {
        return listaEnteros.size();
    }


    public int getCantidadCadenas( )
    {
        return listaCadenas.size();
    }


    public void agregarEntero( int entero )
    {
    	listaEnteros.add(entero);
    }


    public void agregarCadena( String cadena )
    {
    	listaCadenas.add(cadena);
    }


    public void eliminarEntero( int valor )
    {
    	int size = listaEnteros.size();
    	List<Integer> eliminados = new ArrayList<Integer>();
    	
    	for(int i = 0; i < size; i++) {
    		if(listaEnteros.get(i) == valor) {
    			eliminados.add(i);
    		}
    	}
    	for (int j = 0; j < eliminados.size(); j++) {
    		listaEnteros.remove(j);
    	}
    }


    public void eliminarCadena( String cadena )
    {
    	int size = listaCadenas.size();
    	
    	for(int i = 0; i < size; i++) {
    		if(listaCadenas.get(i).equals(cadena)) {
    			listaCadenas.remove(i);
    		}
    		else {
    			i++;
    		}
    	}
    }


    public void insertarEntero( int entero, int posicion )
    {
    	int size = listaEnteros.size();
    	if(posicion < 0) {
    		listaEnteros.add(0, entero);
    	}
    	else if(posicion >= size) {
    		listaEnteros.add(entero);
    	}
    	else {
    		listaEnteros.add(posicion, entero);
    	}
    }

    
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	if(posicion < listaEnteros.size() && posicion >= 0) {
    		listaEnteros.remove(posicion);
    	}
    }


    public void reiniciarArregloEnteros( double[] valores )
    {
    	listaEnteros.clear();
    	
    	for(int i = 0; i < valores.length; i++) {
    		listaEnteros.add((int) valores[i]);
    	}
    }


    public void reiniciarArregloCadenas( List<Object> objetos )
    {
    	listaCadenas.clear();
    	for(int i = 0; i < objetos.size(); i++) {
    		listaCadenas.add(objetos.get(i).toString());
    	}
    }


    public void volverPositivos( )
    {
    	int size = listaEnteros.size();
    	for(int i = 0; i < size; i++) {
    		if(listaEnteros.get(i) < 0) {
    			listaEnteros.set(i, listaEnteros.get(i) * -1);
    		}
    	}
    }

 
    public void organizarEnteros( )
    {
    	int sizeMod = listaEnteros.size() - 1 ;
    	for(int i = 0; i < sizeMod; i++) {
    		for(int j = 0; j < sizeMod - i; j++) {
    			if(listaEnteros.get(j) < listaEnteros.get(j+1)) {
	    			int temporal = listaEnteros.get(j);
	    			listaEnteros.set(j, listaEnteros.get(j+1));
	    			listaEnteros.set(j+1, temporal);
    			}
    		}
    	}
    }


    public void organizarCadenas( )
    {
    	int sizeMod = listaCadenas.size() - 1;
    	for(int i = 0; i < sizeMod; i++) {
    		for(int j = 0; j < sizeMod - i; j++) {
    			if(listaCadenas.get(j).compareTo(listaCadenas.get(j+1)) > 0) {
    				String temporal = listaCadenas.get(j);
    				listaCadenas.set(j, listaCadenas.get(j+1));
    				listaCadenas.set(j+1, temporal);
    			}
    		}
    	}
    			
    }


    public int contarApariciones( int valor )
    {
    	int size = listaEnteros.size();
    	int contador = 0;
    	
    	for(int i = 0; i < size; i++) {
    		if(listaEnteros.get(i) == valor) {
    			contador++;
    		}
    	}
    	return contador;
    }


    public int contarApariciones( String cadena )
    {
        int size = listaCadenas.size();
        int contador = 0;
        
        for(int i = 0; i < size; i++) {
        	if(listaCadenas.get(i).equalsIgnoreCase(cadena)) {
        		contador ++;
        	}
        }
        return contador;
    }


    public int contarEnterosRepetidos( )
    {
        int repetidos = 0;
        int size = listaEnteros.size();
        List<Integer> contados = new ArrayList<>();
        
        for(int i = 0; i < size; i++) {
        	int actual = listaEnteros.get(i);
        	
        	if(!contados.contains(actual)) {
        		for(int j = i + 1; j < size; j++) {
        			if(actual == listaEnteros.get(j)) {
        				repetidos++;
        				contados.add(actual);
        			}
        		}
        	}
        }
        return repetidos;
    }


    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	int size = listaEnteros.size();
    	
        if(otroArreglo.length != size || otroArreglo == null) {
        	return false; 
        }
        else {
        	for(int i = 0; i < size; i++) {
        		if(listaEnteros.get(i) != otroArreglo[i]) {
        			return false;
        		}
        	}
        }
        return true;
    }


    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	listaEnteros.clear();
    	
    	for(int i = 0; i < cantidad; i++) {
    		int rango = maximo - minimo + 1;
    		int random = (int) (Math.random() *  rango) + minimo;
    		
    		listaEnteros.add(random);
    	}
    }

}
