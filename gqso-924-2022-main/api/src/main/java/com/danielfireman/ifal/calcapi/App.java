package com.danielfireman.ifal.calcapi;

import io.jooby.Jooby;

public class App extends Jooby {

  {
    get("/", ctx -> "Raiz");
    mvc(new Raiz());
  } 

  {
    get("/", ctx -> "Calculadora de soma");
    mvc(new Soma());
  } 

  {
    get("/", ctx -> "Calculadora de subtracao");
    mvc(new Subtracao());
  } 


  public static void main(final String[] args) {
    runApp(args, App::new);
  }

}
