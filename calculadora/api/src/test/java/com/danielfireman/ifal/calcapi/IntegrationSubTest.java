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
public class IntegrationSubTest {

  static OkHttpClient client = new OkHttpClient();

  @Test
  public void checarErro (int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/sub/a/a")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST_CODE, rsp.code());
    }
  }

  @Test
  public void checarSucesso(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/sub/6/1")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.OK_CODE, rsp.code());
      assertEquals("5.0", rsp.body().string());
    }
  }
}