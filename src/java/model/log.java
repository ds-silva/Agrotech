package model;

import java.time.LocalDate;

public class log {

    private LocalDate dataHora;
    private String evento;
    private String usuario;
    
    public log(){}

    public log(
            LocalDate data_hora, 
            String evento, 
            String usuario) {

        this.dataHora = data_hora;

        this.evento = evento;

        this.usuario = usuario;

    }

    public LocalDate getDataHora() {

        return dataHora;
    }

    public void setDataHora(LocalDate data_hora) /*throws Exception */ {
        
        //if (data_hora == null ) {
        //    throw new Exception ("O campo esta vazio!");
        //}else {
            
         this.dataHora = data_hora;
        //}

    }

    public String getEvento() {

        return evento;
    }

    public void setEvento(String evento) throws Exception {

        //if (evento == null){
        // throw new Exception ("O campo esta vazio!"); 
         
        //}
        //else {
            
            this.evento = evento;
        //}
        
        
    }

    public String getUsuario() {

        return usuario;
    }

    public void setUsuario(String usuario) throws Exception {
  
        //if (usuario == null){

        //    throw new Exception ("O campo esta vazio!");
        //}
       // else {
        this.usuario = usuario;
       // }
        

    }
}
