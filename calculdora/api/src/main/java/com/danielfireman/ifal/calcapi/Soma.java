package com.danielfireman.ifal.calcapi;

import io.jooby.annotations.GET;
import io.jooby.annotations.Path;
import io.jooby.annotations.PathParam;
import io.jooby.exception.BadRequestException;
  
@Path("/soma/{op1}/{op2}")
public class Soma {

    @GET
    public double soma(@PathParam("op1") double op1, @PathParam("op2") double op2) {
        try {
            double resultado = op1 + op2;
            return resultado;
        } catch (NumberFormatException nfe) {
            throw new BadRequestException("Parâmetros inválidos: " + op1);
        }
    }
}