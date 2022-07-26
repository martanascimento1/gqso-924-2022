package com.danielfireman.ifal.calcapi;

import io.jooby.annotations.GET;
import io.jooby.annotations.Path;
import io.jooby.annotations.PathParam;
import io.jooby.exception.BadRequestException;
  
@Path("/div/{op1}/{op2}")
public class Divisao {

    @GET
    public double divisao(@PathParam("op1") double op1, @PathParam("op2") double op2) {
        try {
            if(op2==0){
                throw new BadRequestException("Não pode dividir por zero ");
            }
            double resultado = op1 / op2;
            return resultado;
        } catch (NumberFormatException nfe) {
            throw new BadRequestException("Parâmetros inválidos: " + op1 + op2);
        }
    }
}