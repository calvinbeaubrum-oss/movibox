package com.transsion.http.request;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public enum HttpMethod {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    PATCH("PATCH"),
    HEAD("HEAD"),
    MOVE("MOVE"),
    COPY("COPY"),
    DELETE("DELETE"),
    OPTIONS("OPTIONS"),
    TRACE("TRACE"),
    CONNECT("CONNECT");


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f52879b;

    HttpMethod(String str) {
        this.f52879b = str;
    }

    public static boolean permitsCache(HttpMethod httpMethod) {
        return httpMethod == GET || httpMethod == POST;
    }

    public static boolean permitsRequestBody(HttpMethod httpMethod) {
        return httpMethod == POST || httpMethod == PUT || httpMethod == PATCH || httpMethod == DELETE;
    }

    public static boolean permitsRetry(HttpMethod httpMethod) {
        return httpMethod == GET;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f52879b;
    }
}
