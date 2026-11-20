package com.mbridge.msdk.e.a.a;

import android.os.SystemClock;
import com.mbridge.msdk.e.a.aa;
import com.mbridge.msdk.e.a.m;
import com.mbridge.msdk.e.a.n;
import com.mbridge.msdk.e.a.p;
import com.mbridge.msdk.e.a.v;
import com.mbridge.msdk.e.a.w;
import com.mbridge.msdk.e.a.x;
import com.mbridge.msdk.e.a.z;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b implements com.mbridge.msdk.e.a.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final c f43739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f43740b;

    public b(a aVar) {
        this(aVar, new c(4096));
    }

    private b(a aVar, c cVar) {
        this.f43740b = aVar;
        this.f43739a = cVar;
    }

    @Override // com.mbridge.msdk.e.a.j
    public final m a(p<?> pVar) throws z {
        f fVarA;
        byte[] bArr;
        byte[] bArr2;
        h.a aVar;
        Map<String, String> mapEmptyMap;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Collections.emptyList();
            try {
                com.mbridge.msdk.e.a.b.a aVarL = pVar.l();
                if (aVarL == null) {
                    mapEmptyMap = Collections.emptyMap();
                } else {
                    HashMap map = new HashMap();
                    String str = aVarL.f43770b;
                    if (str != null) {
                        map.put("If-None-Match", str);
                    }
                    long j11 = aVarL.f43772d;
                    if (j11 > 0) {
                        map.put("If-Modified-Since", e.a(j11));
                    }
                    mapEmptyMap = map;
                }
                fVarA = this.f43740b.a(pVar, mapEmptyMap);
                try {
                    int iA = fVarA.a();
                    List<com.mbridge.msdk.e.a.i> listB = fVarA.b();
                    if (iA == 304) {
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        com.mbridge.msdk.e.a.b.a aVarL2 = pVar.l();
                        return aVarL2 == null ? new m(304, null, true, jElapsedRealtime2, listB) : new m(304, aVarL2.f43769a, true, jElapsedRealtime2, e.a(listB, aVarL2));
                    }
                    InputStream inputStreamD = fVarA.d();
                    byte[] bArrA = inputStreamD != null ? h.a(inputStreamD, fVarA.c(), this.f43739a) : new byte[0];
                    try {
                        long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        if (jElapsedRealtime3 > 3000) {
                            try {
                                Object[] objArr = new Object[5];
                                objArr[0] = pVar;
                                objArr[1] = Long.valueOf(jElapsedRealtime3);
                                objArr[2] = bArrA != null ? Integer.valueOf(bArrA.length) : "null";
                                objArr[3] = Integer.valueOf(iA);
                                objArr[4] = Integer.valueOf(pVar.b().b());
                                aa.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
                            } catch (IOException e11) {
                                e = e11;
                                bArr = bArrA;
                            }
                        }
                        try {
                            if (iA < 200 || iA > 299) {
                                throw new IOException();
                            }
                            return new m(iA, bArrA, false, SystemClock.elapsedRealtime() - jElapsedRealtime, listB);
                        } catch (IOException e12) {
                            e = e12;
                        }
                    } catch (IOException e13) {
                        e = e13;
                        bArr2 = bArrA;
                    }
                    bArr = bArr2;
                    if (e instanceof SocketTimeoutException) {
                        aVar = new h.a("socket", new x());
                    } else {
                        if (e instanceof MalformedURLException) {
                            throw new com.mbridge.msdk.e.a.a("Bad URL " + pVar.i());
                        }
                        if (fVarA != null) {
                            int iA2 = fVarA.a();
                            aa.c("Unexpected response code %d for %s", Integer.valueOf(iA2), pVar.i());
                            if (bArr != null) {
                                m mVar = new m(iA2, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, fVarA.b());
                                if (iA2 >= 400 && iA2 <= 499) {
                                    com.mbridge.msdk.e.a.e eVar = new com.mbridge.msdk.e.a.e(mVar);
                                    eVar.a(iA2);
                                    throw eVar;
                                }
                                w wVar = new w(mVar);
                                wVar.a(iA2);
                                if (iA2 < 500) {
                                    throw wVar;
                                }
                                if (iA2 > 599) {
                                    throw wVar;
                                }
                                if (!pVar.q()) {
                                    throw wVar;
                                }
                                aVar = new h.a("server", wVar);
                            } else {
                                com.mbridge.msdk.e.a.l lVar = new com.mbridge.msdk.e.a.l();
                                lVar.a(iA2);
                                aVar = new h.a("network", lVar);
                            }
                        } else {
                            if (!pVar.r()) {
                                throw new n(e);
                            }
                            aVar = new h.a("connection", new n());
                        }
                    }
                    h.a aVar2 = aVar;
                    v vVarB = pVar.b();
                    int iS = pVar.s();
                    try {
                        vVarB.a(aVar2.f43755b);
                        String.format("%s-retry [timeout=%s]", aVar2.f43754a, Integer.valueOf(iS));
                    } catch (z e14) {
                        String.format("%s-timeout-giveup [timeout=%s]", aVar2.f43754a, Integer.valueOf(iS));
                        throw e14;
                    }
                } catch (IOException e15) {
                    e = e15;
                    bArr = null;
                }
            } catch (IOException e16) {
                e = e16;
                fVarA = null;
                bArr = null;
            }
        }
    }
}
