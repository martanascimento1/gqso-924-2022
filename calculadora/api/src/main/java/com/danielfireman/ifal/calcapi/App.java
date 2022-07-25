package com.danielfireman.ifal.calcapi;
 
import io.jooby.Jooby;

public class App extends Jooby {
  
  {
    get("/", ctx -> "Calculadora de soma");
    mvc(new Soma());
  } 

  {
    get("/", ctx -> "Calculadora de subtracao");
    mvc(new Subtracao());
  }
  
  {
    get("/", ctx -> "Calculadora de divisao");
    mvc(new Divisao());
  } 

  {
    get("/", ctx -> "Calculadora de multiplicacao");
    mvc(new Multiplicacao());
  }

  {
    get("/", ctx -> "Calculadora API");
  } 

  public static void main(final String[] args) {
    runApp(args, App::new);
  }

}
