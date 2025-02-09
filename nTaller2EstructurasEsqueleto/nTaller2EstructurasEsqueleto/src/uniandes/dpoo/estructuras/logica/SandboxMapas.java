package uniandes.dpoo.estructuras.logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;


public class SandboxMapas
{

    private Map<String, String> mapaCadenas;

    
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }


    public List<String> getValoresComoLista( )
    {
        Collection<String> valores = mapaCadenas.values();
        List<String> lista = new java.util.ArrayList<>(valores);
        java.util.Collections.sort(lista);
        return lista;
    }


    public List<String> getLlavesComoListaInvertida( )
    {
        Collection<String> llaves = mapaCadenas.keySet();
        List<String> lista = new java.util.ArrayList<>(llaves);
        java.util.Collections.sort(lista);
        java.util.Collections.reverse(lista);
        return lista;
    }


    public String getPrimera( )
    {
        if(mapaCadenas.isEmpty()) {
        	return null;
        }
        
        Iterator<String> iter = mapaCadenas.keySet().iterator();
        String primera = iter.next();
        
        while(iter.hasNext()) {
        	String llave = iter.next();
        	if(llave.compareTo(primera) < 0) {
        		primera = llave;
        	}
        }
        
        return primera;
    }


    public String getUltima( )
    {
        if(mapaCadenas.isEmpty()) {
        	return null;
        }
        
        Iterator<String> iter = mapaCadenas.keySet().iterator();
        String ultima = iter.next();
        
        while(iter.hasNext()) {
        	String llave = iter.next();
        	if(llave.compareTo(ultima) > 0) {
        		ultima = llave;
        	}
        }
        
        return ultima;
    }


    public Collection<String> getLlaves( )
    {
        Map<String, String> mayusculas = new HashMap<>();
        Iterator<String> iter = mapaCadenas.keySet().iterator();
        
        while(iter.hasNext()) {
        	String llave = iter.next();
        	mayusculas.put(llave.toUpperCase(), mapaCadenas.get(llave));
        }
        return mayusculas.keySet();
    }


    public int getCantidadCadenasDiferentes( )
    {
        Map<String, Integer> difs = new HashMap<>();
        Iterator<String> iter = mapaCadenas.values().iterator();
        
        while(iter.hasNext()) {
        	String valor = iter.next();
        	difs.put(valor, 1);
        }
        return difs.size();
    }


    public void agregarCadena( String cadena )
    {
    	String llave = "";
    	int size = cadena.length();
    	
    	for(int i = 0; i < size; i++) {
    		llave = cadena.charAt(i) + llave;
    	}
    	mapaCadenas.put(llave, cadena);
    }


    public void eliminarCadenaConLLave( String llave )
    {
    	mapaCadenas.remove(llave);
    }


    public void eliminarCadenaConValor( String valor )
    {
    	String llave = "";
    	int size = valor.length();
    	
    	for(int i = 0; i < size; i++) {
    		llave = valor.charAt(i) + llave;
    	}
    	mapaCadenas.remove(llave);
    }


    public void reiniciarMapaCadenas( List<Object> objetos )
    {
    	mapaCadenas.clear();
    	
    	for(int i = 0; i < objetos.size(); i++) {
    		String valor = objetos.get(i).toString();
    		String llave = "";
    		
    		for(int j = 0; j < valor.length(); j++) {
    			llave = valor.charAt(j) + llave;
    		}
    		mapaCadenas.put(llave, valor);
    	}
    }


    public void volverMayusculas( )
    {
    	Map<String, String> nuevo = new HashMap<>();
    	String [] llaves = mapaCadenas.keySet().toArray(new String[0]);
    	
    	for(int i = 0; i < llaves.length; i++) {
    		String keyMayus = llaves[i].toUpperCase();
    		nuevo.put(keyMayus, mapaCadenas.get(llaves[i]));
    	}
    	mapaCadenas = nuevo;
    }

 
    public boolean compararValores( String[] otroArreglo )
    {
        Collection<String> valores = mapaCadenas.values();
        
        for(int i = 0; i < otroArreglo.length; i++) {
        	String elemento = otroArreglo[i];
        	boolean encontrado = false;
        	
        	Iterator<String> iter = valores.iterator();
        	while(iter.hasNext()) {
        		if(iter.next().equals(elemento)) {
        			encontrado = true;
        		}
        	}
        	if(!encontrado) {
        		return false;
        	}
        }
        return true;
    }
    

}
