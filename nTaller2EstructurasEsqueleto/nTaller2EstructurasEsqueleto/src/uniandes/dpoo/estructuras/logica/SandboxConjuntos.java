package uniandes.dpoo.estructuras.logica;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;


public class SandboxConjuntos
{
    private NavigableSet<String> arbolCadenas;

    public SandboxConjuntos( )
    {
        arbolCadenas = new TreeSet<String>( );
    }

    
    public List<String> getCadenasComoLista( )
    {
        String[] arreglo = arbolCadenas.toArray(new String[0]);
        return new java.util.AbstractList<String>() {
        	@Override
        	public String get(int index) { 
        		return arreglo[index];
        	}
        	
        	@Override
        	public String set(int index, String element) {
        		String old = arreglo[index];
        		arreglo[index] = element; 
        		return old;
        	}
        	
        	@Override
        	public int size() {
        		return arreglo.length;
        	}
        };	
    }


    public List<String> getCadenasComoListaInvertida( )
    {
        final String[] arreglo = arbolCadenas.toArray(new String[0]);
        return new java.util.AbstractList<String>() {
        	@Override
        	public String get(int index) {
        		return arreglo[arreglo.length - 1 - index];
        	}
        	
        	@Override
        	public String set(int index, String element) {
        		int indexAct = arreglo.length - 1 - index; 
        		String old = arreglo[indexAct];
        		arreglo[indexAct] = element;
        		return old;
        	}
        	
        	@Override
        	public int size() {
        		return arreglo.length;
        	}
        };
    }


    public String getPrimera( )
    {
        if(arbolCadenas.isEmpty()) {
        	return null;
        }
        else {
        	return arbolCadenas.first();
        }
    }

    
    public String getUltima( )
    {
        if(arbolCadenas.isEmpty()) {
        	return null;
        }
        else {
        	return arbolCadenas.last();
        }
    }


    public Collection<String> getSiguientes( String cadena )
    {
        return arbolCadenas.tailSet(cadena, true);
    }

    public int getCantidadCadenas( )
    {
        return arbolCadenas.size();
    }


    public void agregarCadena( String cadena )
    {
    	if(cadena != null) {
    		arbolCadenas.add(cadena);
    	}
    }


    public void eliminarCadena( String cadena )
    {
    	arbolCadenas.remove(cadena);
    }


    public void eliminarCadenaSinMayusculasOMinusculas( String cadena )
    {
    	if(cadena != null) {
    		String cadenaUniv = cadena.toLowerCase();
    		NavigableSet <String> temporal = new TreeSet<>();
    		String[] arreglo = arbolCadenas.toArray(new String[0]);
    		for(int i = 0; i < arreglo.length; i++) {
    			String string = arreglo[i];
    			if(!string.toLowerCase().equals(cadenaUniv)) {
    				temporal.add(string);
    			}
    		}
    		arbolCadenas = temporal;
    	}
    }


    public void eliminarPrimera( )
    {
    	if(arbolCadenas.size() != 0) {
    		String primero = arbolCadenas.first();
    		arbolCadenas.remove(primero);
    	}
    }


    public void reiniciarConjuntoCadenas( List<Object> objetos )
    {
    	arbolCadenas.clear();
    	if(objetos != null) {
    		for(int i = 0; i < objetos.size(); i++) {
    			Object obj = objetos.get(i);
    			if(obj != null) {
    				arbolCadenas.add(obj.toString());
    			}
    		}
    	}
    }


    public void volverMayusculas( )
    {
    	NavigableSet<String> temporal = new TreeSet <>();
    	String[] arreglo = arbolCadenas.toArray(new String[0]);
    	for(int i = 0; i < arreglo.length; i++) {
    		temporal.add(arreglo[i].toUpperCase());
    	}
    	arbolCadenas = temporal;
    }

    
    public TreeSet<String> invertirCadenas( )
    {
        TreeSet<String> invertido = new TreeSet<>();
        String[] arreglo = arbolCadenas.toArray(new String[0]);
        
        for(int i = arreglo.length - 1; i >= 0; i--){
        	invertido.add(arreglo[i]);
        }
        return invertido;
    }


    public boolean compararElementos( String[] otroArreglo )
    {
		if(otroArreglo == null) {
        	return false;
        }

        else {
        	for(int i = 0; i < otroArreglo.length; i++) {
        		String elemento = otroArreglo[i];
        		if (elemento == null || !arbolCadenas.contains(elemento)) {
        			return false;
        		}
        	}
        	return true;
        }
    }
    
}
