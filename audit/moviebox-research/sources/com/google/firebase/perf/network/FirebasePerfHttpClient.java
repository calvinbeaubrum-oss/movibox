package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.metrics.j;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;
import sl.h;
import vl.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class FirebasePerfHttpClient {
    public static <T> T a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, Timer timer, k kVar) throws IOException {
        j jVarD = j.d(kVar);
        try {
            jVarD.s(httpHost.toURI() + httpRequest.getRequestLine().getUri()).h(httpRequest.getRequestLine().getMethod());
            Long lA = sl.j.a(httpRequest);
            if (lA != null) {
                jVarD.l(lA.longValue());
            }
            timer.reset();
            jVarD.m(timer.getMicros());
            return (T) httpClient.execute(httpHost, httpRequest, new h(responseHandler, timer, jVarD));
        } catch (IOException e11) {
            jVarD.q(timer.getDurationMicros());
            sl.j.d(jVarD);
            throw e11;
        }
    }

    public static <T> T b(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext, Timer timer, k kVar) throws IOException {
        j jVarD = j.d(kVar);
        try {
            jVarD.s(httpHost.toURI() + httpRequest.getRequestLine().getUri()).h(httpRequest.getRequestLine().getMethod());
            Long lA = sl.j.a(httpRequest);
            if (lA != null) {
                jVarD.l(lA.longValue());
            }
            timer.reset();
            jVarD.m(timer.getMicros());
            return (T) httpClient.execute(httpHost, httpRequest, new h(responseHandler, timer, jVarD), httpContext);
        } catch (IOException e11) {
            jVarD.q(timer.getDurationMicros());
            sl.j.d(jVarD);
            throw e11;
        }
    }

    public static <T> T c(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, Timer timer, k kVar) throws IOException {
        j jVarD = j.d(kVar);
        try {
            jVarD.s(httpUriRequest.getURI().toString()).h(httpUriRequest.getMethod());
            Long lA = sl.j.a(httpUriRequest);
            if (lA != null) {
                jVarD.l(lA.longValue());
            }
            timer.reset();
            jVarD.m(timer.getMicros());
            return (T) httpClient.execute(httpUriRequest, new h(responseHandler, timer, jVarD));
        } catch (IOException e11) {
            jVarD.q(timer.getDurationMicros());
            sl.j.d(jVarD);
            throw e11;
        }
    }

    public static <T> T d(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext, Timer timer, k kVar) throws IOException {
        j jVarD = j.d(kVar);
        try {
            jVarD.s(httpUriRequest.getURI().toString()).h(httpUriRequest.getMethod());
            Long lA = sl.j.a(httpUriRequest);
            if (lA != null) {
                jVarD.l(lA.longValue());
            }
            timer.reset();
            jVarD.m(timer.getMicros());
            return (T) httpClient.execute(httpUriRequest, new h(responseHandler, timer, jVarD), httpContext);
        } catch (IOException e11) {
            jVarD.q(timer.getDurationMicros());
            sl.j.d(jVarD);
            throw e11;
        }
    }

    public static HttpResponse e(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, Timer timer, k kVar) throws IOException {
        j jVarD = j.d(kVar);
        try {
            jVarD.s(httpHost.toURI() + httpRequest.getRequestLine().getUri()).h(httpRequest.getRequestLine().getMethod());
            Long lA = sl.j.a(httpRequest);
            if (lA != null) {
                jVarD.l(lA.longValue());
            }
            timer.reset();
            jVarD.m(timer.getMicros());
            HttpResponse httpResponseExecute = httpClient.execute(httpHost, httpRequest);
            jVarD.q(timer.getDurationMicros());
            jVarD.i(httpResponseExecute.getStatusLine().getStatusCode());
            Long lA2 = sl.j.a(httpResponseExecute);
            if (lA2 != null) {
                jVarD.o(lA2.longValue());
            }
            String strB = sl.j.b(httpResponseExecute);
            if (strB != null) {
                jVarD.n(strB);
            }
            jVarD.c();
            return httpResponseExecute;
        } catch (IOException e11) {
            jVarD.q(timer.getDurationMicros());
            sl.j.d(jVarD);
            throw e11;
        }
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return (T) a(httpClient, httpHost, httpRequest, responseHandler, new Timer(), k.k());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        return (T) b(httpClient, httpHost, httpRequest, responseHandler, httpContext, new Timer(), k.k());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler) throws IOException {
        return (T) c(httpClient, httpUriRequest, responseHandler, new Timer(), k.k());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext) throws IOException {
        return (T) d(httpClient, httpUriRequest, responseHandler, httpContext, new Timer(), k.k());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        return e(httpClient, httpHost, httpRequest, new Timer(), k.k());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        return f(httpClient, httpHost, httpRequest, httpContext, new Timer(), k.k());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws IOException {
        return g(httpClient, httpUriRequest, new Timer(), k.k());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        return h(httpClient, httpUriRequest, httpContext, new Timer(), k.k());
    }

    public static HttpResponse f(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext, Timer timer, k kVar) throws IOException {
        j jVarD = j.d(kVar);
        try {
            jVarD.s(httpHost.toURI() + httpRequest.getRequestLine().getUri()).h(httpRequest.getRequestLine().getMethod());
            Long lA = sl.j.a(httpRequest);
            if (lA != null) {
                jVarD.l(lA.longValue());
            }
            timer.reset();
            jVarD.m(timer.getMicros());
            HttpResponse httpResponseExecute = httpClient.execute(httpHost, httpRequest, httpContext);
            jVarD.q(timer.getDurationMicros());
            jVarD.i(httpResponseExecute.getStatusLine().getStatusCode());
            Long lA2 = sl.j.a(httpResponseExecute);
            if (lA2 != null) {
                jVarD.o(lA2.longValue());
            }
            String strB = sl.j.b(httpResponseExecute);
            if (strB != null) {
                jVarD.n(strB);
            }
            jVarD.c();
            return httpResponseExecute;
        } catch (IOException e11) {
            jVarD.q(timer.getDurationMicros());
            sl.j.d(jVarD);
            throw e11;
        }
    }

    public static HttpResponse g(HttpClient httpClient, HttpUriRequest httpUriRequest, Timer timer, k kVar) throws IOException {
        j jVarD = j.d(kVar);
        try {
            jVarD.s(httpUriRequest.getURI().toString()).h(httpUriRequest.getMethod());
            Long lA = sl.j.a(httpUriRequest);
            if (lA != null) {
                jVarD.l(lA.longValue());
            }
            timer.reset();
            jVarD.m(timer.getMicros());
            HttpResponse httpResponseExecute = httpClient.execute(httpUriRequest);
            jVarD.q(timer.getDurationMicros());
            jVarD.i(httpResponseExecute.getStatusLine().getStatusCode());
            Long lA2 = sl.j.a(httpResponseExecute);
            if (lA2 != null) {
                jVarD.o(lA2.longValue());
            }
            String strB = sl.j.b(httpResponseExecute);
            if (strB != null) {
                jVarD.n(strB);
            }
            jVarD.c();
            return httpResponseExecute;
        } catch (IOException e11) {
            jVarD.q(timer.getDurationMicros());
            sl.j.d(jVarD);
            throw e11;
        }
    }

    public static HttpResponse h(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext, Timer timer, k kVar) throws IOException {
        j jVarD = j.d(kVar);
        try {
            jVarD.s(httpUriRequest.getURI().toString()).h(httpUriRequest.getMethod());
            Long lA = sl.j.a(httpUriRequest);
            if (lA != null) {
                jVarD.l(lA.longValue());
            }
            timer.reset();
            jVarD.m(timer.getMicros());
            HttpResponse httpResponseExecute = httpClient.execute(httpUriRequest, httpContext);
            jVarD.q(timer.getDurationMicros());
            jVarD.i(httpResponseExecute.getStatusLine().getStatusCode());
            Long lA2 = sl.j.a(httpResponseExecute);
            if (lA2 != null) {
                jVarD.o(lA2.longValue());
            }
            String strB = sl.j.b(httpResponseExecute);
            if (strB != null) {
                jVarD.n(strB);
            }
            jVarD.c();
            return httpResponseExecute;
        } catch (IOException e11) {
            jVarD.q(timer.getDurationMicros());
            sl.j.d(jVarD);
            throw e11;
        }
    }
}
