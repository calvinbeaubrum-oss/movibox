package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import sl.c;
import sl.d;
import vl.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class FirebasePerfUrlConnection {
    public static Object a(j jVar, k kVar, Timer timer) throws IOException {
        timer.reset();
        long micros = timer.getMicros();
        com.google.firebase.perf.metrics.j jVarD = com.google.firebase.perf.metrics.j.d(kVar);
        try {
            URLConnection uRLConnectionA = jVar.a();
            if (uRLConnectionA instanceof HttpsURLConnection) {
                return new d((HttpsURLConnection) uRLConnectionA, timer, jVarD).getContent();
            }
            return uRLConnectionA instanceof HttpURLConnection ? new c((HttpURLConnection) uRLConnectionA, timer, jVarD).getContent() : uRLConnectionA.getContent();
        } catch (IOException e11) {
            jVarD.m(micros);
            jVarD.q(timer.getDurationMicros());
            jVarD.s(jVar.toString());
            sl.j.d(jVarD);
            throw e11;
        }
    }

    public static Object b(j jVar, Class[] clsArr, k kVar, Timer timer) throws IOException {
        timer.reset();
        long micros = timer.getMicros();
        com.google.firebase.perf.metrics.j jVarD = com.google.firebase.perf.metrics.j.d(kVar);
        try {
            URLConnection uRLConnectionA = jVar.a();
            if (uRLConnectionA instanceof HttpsURLConnection) {
                return new d((HttpsURLConnection) uRLConnectionA, timer, jVarD).getContent(clsArr);
            }
            return uRLConnectionA instanceof HttpURLConnection ? new c((HttpURLConnection) uRLConnectionA, timer, jVarD).getContent(clsArr) : uRLConnectionA.getContent(clsArr);
        } catch (IOException e11) {
            jVarD.m(micros);
            jVarD.q(timer.getDurationMicros());
            jVarD.s(jVar.toString());
            sl.j.d(jVarD);
            throw e11;
        }
    }

    public static InputStream c(j jVar, k kVar, Timer timer) throws IOException {
        timer.reset();
        long micros = timer.getMicros();
        com.google.firebase.perf.metrics.j jVarD = com.google.firebase.perf.metrics.j.d(kVar);
        try {
            URLConnection uRLConnectionA = jVar.a();
            if (uRLConnectionA instanceof HttpsURLConnection) {
                return new d((HttpsURLConnection) uRLConnectionA, timer, jVarD).getInputStream();
            }
            return uRLConnectionA instanceof HttpURLConnection ? new c((HttpURLConnection) uRLConnectionA, timer, jVarD).getInputStream() : uRLConnectionA.getInputStream();
        } catch (IOException e11) {
            jVarD.m(micros);
            jVarD.q(timer.getDurationMicros());
            jVarD.s(jVar.toString());
            sl.j.d(jVarD);
            throw e11;
        }
    }

    @Keep
    public static Object getContent(URL url) throws IOException {
        return a(new j(url), k.k(), new Timer());
    }

    @Keep
    public static Object getContent(URL url, Class[] clsArr) throws IOException {
        return b(new j(url), clsArr, k.k(), new Timer());
    }

    @Keep
    public static Object instrument(Object obj) throws IOException {
        if (obj instanceof HttpsURLConnection) {
            return new d((HttpsURLConnection) obj, new Timer(), com.google.firebase.perf.metrics.j.d(k.k()));
        }
        return obj instanceof HttpURLConnection ? new c((HttpURLConnection) obj, new Timer(), com.google.firebase.perf.metrics.j.d(k.k())) : obj;
    }

    @Keep
    public static InputStream openStream(URL url) throws IOException {
        return c(new j(url), k.k(), new Timer());
    }
}
