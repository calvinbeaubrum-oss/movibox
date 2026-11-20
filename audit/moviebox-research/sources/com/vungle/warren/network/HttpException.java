package com.vungle.warren.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import v00.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class HttpException extends RuntimeException {
    private final int code;
    private final String message;
    private final transient e<?> response;

    public HttpException(e<?> eVar) {
        super(getMessage(eVar));
        this.code = eVar.b();
        this.message = eVar.f();
        this.response = eVar;
    }

    private static String getMessage(@NonNull e<?> eVar) {
        return "HTTP " + eVar.b() + " " + eVar.f();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    @Nullable
    public e<?> response() {
        return this.response;
    }
}
