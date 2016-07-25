package org.programacionv.aerolinea.controlador;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import org.programacionv.aerolinea.modelo.Vuelo;
import org.programacionv.aerolinea.servicios.VueloService;

@Named
@RequestScoped

public class dlgBuscarHorario implements Serializable{
	
	private static final long serialVersionUID = 2837803080834308L;
	private List<Vuelo> vueloList;
	
    @Inject
    Event<Vuelo> vueloListener;
    
    @Inject
	private VueloService vueloService;

	@PostConstruct
	
	private void init(){
		
		loadVuelo();
		
	}
	
	public List<Vuelo> getvueloList() {
		return vueloList;
	}

	public void setvueloList(List<Vuelo> vueloList) {
		this.vueloList = vueloList;
	}

	
	public void loadVuelo(){
		
		vueloList=vueloService.findAll();
	}
	
	public void emviarVueloSelecionada(Vuelo Vuelo){
		
		vueloListener.fire(Vuelo);
		  
	}
}
