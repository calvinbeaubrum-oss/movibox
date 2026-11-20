package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.metrics.j;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import sl.i;
import vl.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class FirebasePerfOkHttpClient {
    public static void a(Response response, j jVar, long j11, long j12) throws IOException {
        Request request = response.request();
        if (request == null) {
            return;
        }
        jVar.s(request.url().url().toString());
        jVar.h(request.method());
        if (request.body() != null) {
            long jContentLength = request.body().contentLength();
            if (jContentLength != -1) {
                jVar.l(jContentLength);
            }
        }
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody != null) {
            long jContentLength2 = responseBodyBody.contentLength();
            if (jContentLength2 != -1) {
                jVar.o(jContentLength2);
            }
            MediaType mediaTypeContentType = responseBodyBody.contentType();
            if (mediaTypeContentType != null) {
                jVar.n(mediaTypeContentType.toString());
            }
        }
        jVar.i(response.code());
        jVar.m(j11);
        jVar.q(j12);
        jVar.c();
    }

    @Keep
    public static void enqueue(Call call, Callback callback) {
        Timer timer = new Timer();
        call.enqueue(new i(callback, k.k(), timer, timer.getMicros()));
    }

    @Keep
    public static Response execute(Call call) throws IOException {
        j jVarD = j.d(k.k());
        Timer timer = new Timer();
        long micros = timer.getMicros();
        try {
            Response responseExecute = call.execute();
            a(responseExecute, jVarD, micros, timer.getDurationMicros());
            return responseExecute;
        } catch (IOException e11) {
            Request request = call.request();
            if (request != null) {
                HttpUrl httpUrlUrl = request.url();
                if (httpUrlUrl != null) {
                    jVarD.s(httpUrlUrl.url().toString());
                }
                if (request.method() != null) {
                    jVarD.h(request.method());
                }
            }
            jVarD.m(micros);
            jVarD.q(timer.getDurationMicros());
            sl.j.d(jVarD);
            throw e11;
        }
    }
}
