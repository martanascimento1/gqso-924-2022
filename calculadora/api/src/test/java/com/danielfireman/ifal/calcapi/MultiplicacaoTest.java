package com.danielfireman.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;
import io.jooby.exception.BadRequestException;

public class MultiplicacaoTest {
    @Test
    public void multiplicacao() {
        MockRouter router = new MockRouter(new App());
        router.get("/mult/5/4", rsp -> {
            assertEquals(20.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    @Test
    public void multiplicacao_operadorString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/mult/a/a", rsp -> {});
        });
    }

    @Test
    public void operadorVirgula() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/mult/2,5/2,5", rsp -> {});
        });
    }
}