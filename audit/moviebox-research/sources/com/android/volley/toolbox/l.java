package com.android.volley.toolbox;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.android.volley.AuthFailureError;
import com.android.volley.ClientError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final VolleyError f16587b;

        public b(String str, VolleyError volleyError) {
            this.f16586a = str;
            this.f16587b = volleyError;
        }
    }

    public static void a(Request<?> request, b bVar) throws VolleyError {
        com.android.volley.k retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.b(bVar.f16587b);
            request.addMarker(String.format("%s-retry [timeout=%s]", bVar.f16586a, Integer.valueOf(timeoutMs)));
        } catch (VolleyError e11) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", bVar.f16586a, Integer.valueOf(timeoutMs)));
            throw e11;
        }
    }

    public static com.android.volley.g b(Request<?> request, long j11, List<com.android.volley.e> list) {
        com.android.volley.c.a cacheEntry = request.getCacheEntry();
        if (cacheEntry == null) {
            return new com.android.volley.g(304, (byte[]) null, true, j11, list);
        }
        return new com.android.volley.g(304, cacheEntry.f16490a, true, j11, d.a(list, cacheEntry));
    }

    public static byte[] c(InputStream inputStream, int i11, ByteArrayPool byteArrayPool) throws Throwable {
        byte[] bArrA;
        m mVar = new m(byteArrayPool, i11);
        try {
            bArrA = byteArrayPool.a(1024);
            while (true) {
                try {
                    int i12 = inputStream.read(bArrA);
                    if (i12 == -1) {
                        break;
                    }
                    mVar.write(bArrA, 0, i12);
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                            com.android.volley.l.e("Error occurred when closing InputStream", new Object[0]);
                        }
                    }
                    byteArrayPool.b(bArrA);
                    mVar.close();
                    throw th;
                }
            }
            byte[] byteArray = mVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
                com.android.volley.l.e("Error occurred when closing InputStream", new Object[0]);
            }
            byteArrayPool.b(bArrA);
            mVar.close();
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
            bArrA = null;
        }
    }

    public static void d(long j11, Request<?> request, byte[] bArr, int i11) {
        if (com.android.volley.l.f16526b || j11 > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j11);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i11);
            objArr[4] = Integer.valueOf(request.getRetryPolicy().a());
            com.android.volley.l.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    public static b e(Request<?> request, IOException iOException, long j11, @Nullable e eVar, @Nullable byte[] bArr) throws VolleyError {
        if (iOException instanceof SocketTimeoutException) {
            return new b("socket", new TimeoutError());
        }
        if (iOException instanceof MalformedURLException) {
            throw new RuntimeException("Bad URL " + request.getUrl(), iOException);
        }
        if (eVar == null) {
            if (request.shouldRetryConnectionErrors()) {
                return new b("connection", new NoConnectionError());
            }
            throw new NoConnectionError(iOException);
        }
        int iD = eVar.d();
        com.android.volley.l.c("Unexpected response code %d for %s", Integer.valueOf(iD), request.getUrl());
        if (bArr == null) {
            return new b("network", new NetworkError());
        }
        com.android.volley.g gVar = new com.android.volley.g(iD, bArr, false, SystemClock.elapsedRealtime() - j11, eVar.c());
        if (iD == 401 || iD == 403) {
            return new b("auth", new AuthFailureError(gVar));
        }
        if (iD >= 400 && iD <= 499) {
            throw new ClientError(gVar);
        }
        if (iD < 500 || iD > 599 || !request.shouldRetryServerErrors()) {
            throw new ServerError(gVar);
        }
        return new b("server", new ServerError(gVar));
    }
}
