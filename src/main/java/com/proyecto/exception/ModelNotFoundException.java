package com.proyecto.exception;



//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends RuntimeException{

   public ModelNotFoundException(String message){
       super(message);
   }


}
