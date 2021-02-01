/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excecoes;

/**
 *
 * @author jose.junior
 */
public class CancelarDeletarException extends Exception {
    
    public CancelarDeletarException(String errorMessage) {
        super(errorMessage);
    }
    
}
