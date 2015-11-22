/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package fumadores;
import monitor.*;
/**
 *
 * @author fcis
 */
class Estanco extends AbstractMonitor
{ 
    private Condition puede_obtener = makeCondition();
    private Condition puede_poner = makeCondition();
    private Condition[] fumador = new Condition[3];  //vector de 3 condiciones para los fumadores
    private int contador = 0;
    private int ingred;

    public Estanco(){
	for(int i = 0; i<fumador.length; i++){
	 	   fumador[i] = makeCondition();
	}
    }
// invocado por cada fumador, indicando su ingrediente o numero
public void obtenerIngrediente( int miIngrediente ){ 
    enter();        
        if(miIngrediente != ingred || contador == 0){
            System.out.print("\nfumador " +miIngrediente+ " espera para obtener el ingrediente");
            fumador[miIngrediente].await();       
	}	
	System.out.print("\nFumador ==' "+miIngrediente+" obteniendo el ingrediente "+ingred);
	contador--;
	puede_poner.signal();	
    leave();
}
// invocado por el estanquero, indicando el ingrediente que pone
public void ponerIngrediente( int ingrediente ){ 
    enter();                   
        ingred = ingrediente;
        System.out.print("\n");
	System.out.print("\nEl estanquero ha puesto el ingrediente: "+ingrediente);
	contador++;
        fumador[ingred].signal(); 
    leave();
}
// invocado por el estanquero
public void esperarRecogidaIngrediente(){ 
    enter();		        	    
        if(contador != 0){
            System.out.print("\nEstanquero espera la recogida del ingrediente");
            puede_poner.await();                
	}
    leave();	    
}
}//class Estanco
//***************************************************************
class Fumador implements Runnable{
    //variable de instancia
    int miIngrediente;
    public Thread thr ;
    private Estanco estanco;
    //constructor
    public Fumador( int p_miIngrediente, String nombre, Estanco estanco ){
	this.miIngrediente = p_miIngrediente;
	thr = new Thread(this,nombre);
	this.estanco = estanco;
    }
    //run a ejecutar por todos los fumadores
    public void run(){
	while ( true ){ 
            estanco.obtenerIngrediente( miIngrediente );
            ax.dormir_max( 2000 );
        }
    }    
}//fumador
//*****************************************************************
class Estanquero implements Runnable{ 	
	private Estanco estanco;
	public Thread thr ;
	int id;
    //constructor Estanquero
    public Estanquero(int i, String nombre, Estanco estanco){
	int id = i;
	thr = new Thread(this,nombre);
	this.estanco = estanco;
    }
    //run a ejecutar por el Estanquero
    public void run(){ 		
	int ingrediente ;
	while (true){
            ingrediente = (int) (Math.random () * 3.0); // 0,1 o 2
            estanco.ponerIngrediente( ingrediente );
            estanco.esperarRecogidaIngrediente() ;
        }
    }
}//class Estanquero
//*********************************************************
class Fumadores 
{ 
  public static void main( String[] args ) 
  { 
    Estanco unestanco = new Estanco();
    Fumador[] fumad = new Fumador[3] ;        //vector de tres fumadores
    Estanquero[] estanQ = new Estanquero[1] ; //vector de un Estanquero	                           	

	  // crear hebras fumadores
	  for(int i = 0; i < fumad.length; i++)  
	    fumad[i] = new Fumador(i,"Fumador",unestanco) ;
          //crear el estanquero
	  for(int i=0; i<estanQ.length; i++)  	
	    estanQ[i] = new Estanquero(i,"Estanquero",unestanco) ;  

	  // poner en marcha las hebras de fumadores
	  for(int i = 0; i < fumad.length; i++) 
            fumad[i].thr.start();
  	  //poner en marcha el estanquero
  	  for(int i=0; i<estanQ.length; i++)
            estanQ[i].thr.start();
  }//main
}//class fumadores



