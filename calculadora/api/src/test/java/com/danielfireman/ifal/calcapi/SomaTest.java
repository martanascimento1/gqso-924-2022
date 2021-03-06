package com.danielfireman.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;
import io.jooby.exception.BadRequestException;

public class SomaTest {
    @Test
    public void soma() {
        MockRouter router = new MockRouter(new App());
        router.get("/soma/8/4", rsp -> {
            assertEquals(12.0, rsp.value());
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
    public void operadorVirgula() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/soma/2,5/2,5", rsp -> {});
        });
    }
}