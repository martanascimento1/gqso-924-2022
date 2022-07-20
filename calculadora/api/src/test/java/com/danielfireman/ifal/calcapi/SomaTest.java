package com.danielfireman.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;
import io.jooby.exception.BadRequestException;

public class RaizTest {
    @Test
    public void soma() {
        MockRouter router = new MockRouter(new App());
        router.get("/soma/4/4", rsp -> {
            assertEquals(8.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    @Test
    public void somaDecimais() {
        MockRouter router = new MockRouter(new App());
        router.get("/soma/4.5/4.5", rsp -> {
            assertEquals(9.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    @Test
    public void soma_operadorString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/soma/a/a", rsp -> {});
        });
    }

    @Test
    public void soma_operadorVirgula() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/soma/2,5/2,5", rsp -> {});
        });
    }
}