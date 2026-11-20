package com.transsion.transfer.androidasync.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.transsion.transfer.androidasync.AsyncServer;
import com.transsion.transfer.androidasync.http.filter.ChunkedInputFilter;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class HttpUtil {

    /* JADX INFO: compiled from: source.java */
    public static class EndEmitter extends com.transsion.transfer.androidasync.v {
        public static EndEmitter O(AsyncServer asyncServer, final Exception exc) {
            EndEmitter endEmitter = new EndEmitter();
            asyncServer.D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.HttpUtil.EndEmitter.1
                @Override // java.lang.Runnable
                public void run() {
                    EndEmitter.this.L(exc);
                }
            });
            return endEmitter;
        }
    }

    public static long a(Headers headers) {
        String strC = headers.c(HttpHeaders.CONTENT_LENGTH);
        if (strC == null) {
            return -1L;
        }
        try {
            return Long.parseLong(strC);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static gy.a b(com.transsion.transfer.androidasync.r rVar, fy.a aVar, Headers headers) {
        String strC = headers.c(HttpHeaders.CONTENT_TYPE);
        if (strC == null) {
            return null;
        }
        String[] strArrSplit = strC.split(";");
        for (int i11 = 0; i11 < strArrSplit.length; i11++) {
            strArrSplit[i11] = strArrSplit[i11].trim();
        }
        for (String str : strArrSplit) {
            if ("application/x-www-form-urlencoded".equals(str)) {
                return new gy.h();
            }
            if ("application/json".equals(str)) {
                return new gy.b();
            }
            if ("text/plain".equals(str)) {
                return new gy.f();
            }
            if (str != null && str.startsWith("multipart/")) {
                return new gy.c(strC);
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x007a  */
    /* JADX WARN: Code duplicated, block: B:30:0x0084  */
    /* JADX WARN: Code duplicated, block: B:32:0x0090  */
    /* JADX WARN: Code duplicated, block: B:36:? A[RETURN, SYNTHETIC] */
    public static com.transsion.transfer.androidasync.r c(com.transsion.transfer.androidasync.r rVar, Protocol protocol, Headers headers, boolean z11) {
        long j11;
        com.transsion.transfer.androidasync.v chunkedInputFilter;
        com.transsion.transfer.androidasync.v dVar;
        try {
            String strC = headers.c(HttpHeaders.CONTENT_LENGTH);
            j11 = strC != null ? Long.parseLong(strC) : -1L;
        } catch (NumberFormatException unused) {
        }
        if (-1 == j11) {
            if ("chunked".equalsIgnoreCase(headers.c("Transfer-Encoding"))) {
                chunkedInputFilter = new ChunkedInputFilter();
                chunkedInputFilter.M(rVar);
            } else if (z11) {
                EndEmitter endEmitterO = EndEmitter.O(rVar.a(), null);
                endEmitterO.M(rVar);
                return endEmitterO;
            }
            if ("gzip".equals(headers.c(HttpHeaders.CONTENT_ENCODING))) {
                dVar = new iy.c();
                dVar.M(rVar);
            } else {
                if ("deflate".equals(headers.c(HttpHeaders.CONTENT_ENCODING))) {
                    return rVar;
                }
                dVar = new iy.d();
                dVar.M(rVar);
            }
            return dVar;
        }
        if (j11 < 0) {
            EndEmitter endEmitterO2 = EndEmitter.O(rVar.a(), new BodyDecoderException("not using chunked encoding, and no content-length found."));
            endEmitterO2.M(rVar);
            return endEmitterO2;
        }
        if (j11 == 0) {
            EndEmitter endEmitterO3 = EndEmitter.O(rVar.a(), null);
            endEmitterO3.M(rVar);
            return endEmitterO3;
        }
        chunkedInputFilter = new iy.b(j11);
        chunkedInputFilter.M(rVar);
        rVar = chunkedInputFilter;
        if ("gzip".equals(headers.c(HttpHeaders.CONTENT_ENCODING))) {
            dVar = new iy.c();
            dVar.M(rVar);
        } else {
            if ("deflate".equals(headers.c(HttpHeaders.CONTENT_ENCODING))) {
                return rVar;
            }
            dVar = new iy.d();
            dVar.M(rVar);
        }
        return dVar;
    }

    public static boolean d(Protocol protocol, Headers headers) {
        String strC = headers.c("Connection");
        if (strC == null) {
            return protocol == Protocol.HTTP_1_1;
        }
        return "keep-alive".equalsIgnoreCase(strC);
    }

    public static boolean e(String str, Headers headers) {
        String strC = headers.c("Connection");
        if (strC == null) {
            return Protocol.get(str) == Protocol.HTTP_1_1;
        }
        return "keep-alive".equalsIgnoreCase(strC);
    }
}
