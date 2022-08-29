package com.danielfireman.ifal.calcapi;

import io.jooby.JoobyTest;
import io.jooby.StatusCode;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JoobyTest(App.class)
public class IntegrationTest {

  static OkHttpClient client = new OkHttpClient();

  @Test
  public void shouldSayHi(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort)
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals("Calculadora API", rsp.body().string());
      assertEquals(StatusCode.OK.value(), rsp.code());
    }
  }

  @Test
<<<<<<< HEAD
  public void checaErro(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/soma/a/a")
=======
  public void checError (int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/div/a/a")
>>>>>>> main
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST_CODE, rsp.code());
    }
  }

  @Test
<<<<<<< HEAD
  public void checaSucesso(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/soma/10/10")
=======
  public void checSucesso(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/div/10/10")
>>>>>>> main
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.OK_CODE, rsp.code());
<<<<<<< HEAD
      assertEquals("20.0", rsp.body().string());
=======
      assertEquals("1.0", rsp.body().string());
>>>>>>> main
    }
  }

  @Test
  public void checarError (int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/mult/a/a")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST_CODE, rsp.code());
    }
  }

  @Test
  public void checarSucesso(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/mult/5/5")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.OK_CODE, rsp.code());
      assertEquals("25.0", rsp.body().string());
    }
  }

  @Test
  public void checarErr (int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/sub/a/a")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST_CODE, rsp.code());
    }
  }

  @Test
  public void checarSuc(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/sub/6/1")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.OK_CODE, rsp.code());
      assertEquals("5.0", rsp.body().string());
    }
  }

}