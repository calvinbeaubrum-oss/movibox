package com.mbridge.msdk.foundation.same.net.f;

import android.os.SystemClock;
import com.mbridge.msdk.foundation.same.net.g;
import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.same.net.l;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f44599a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.mbridge.msdk.foundation.same.net.c f44600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.mbridge.msdk.foundation.same.net.stack.b f44601c;

    public a(com.mbridge.msdk.foundation.same.net.stack.b bVar, com.mbridge.msdk.foundation.same.net.c cVar) {
        this.f44601c = bVar;
        this.f44600b = cVar;
    }

    private void a(i<?> iVar, com.mbridge.msdk.foundation.same.net.b.a aVar, long j11) throws com.mbridge.msdk.foundation.same.net.b.a {
        if (iVar == null || aVar == null) {
            throw new com.mbridge.msdk.foundation.same.net.b.a(4, null);
        }
        try {
            l lVarN = iVar.n();
            if (lVarN == null) {
                throw aVar;
            }
            long jF = lVarN.f();
            if (!lVarN.a(aVar) || j11 >= jF) {
                throw aVar;
            }
            this.f44600b.e(iVar);
        } catch (Exception unused) {
            throw aVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.mbridge.msdk.foundation.same.net.g
    public final c a(i<?> iVar) throws com.mbridge.msdk.foundation.same.net.b.a {
        byte[] bArrA;
        b bVarPerformRequest;
        c cVar;
        byte[] bArr;
        b bVar;
        c cVar2 = null;
        if (iVar == null) {
            return null;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        l lVarN = iVar.n();
        int i11 = 880023;
        int i12 = 399;
        int i13 = 200;
        if (lVarN != null && lVarN.b() > 0) {
            while (!iVar.q()) {
                try {
                    try {
                        iVar.r();
                        b bVarPerformRequest2 = this.f44601c.performRequest(iVar);
                        try {
                            int iC = bVarPerformRequest2.c();
                            byte[] bArrA2 = iVar.a(bVarPerformRequest2, this.f44600b);
                            try {
                                SystemClock.elapsedRealtime();
                                if (iC < i13 || iC > i12) {
                                    throw new IOException();
                                }
                                return new c(iC, bArrA2, bVarPerformRequest2.b());
                            } catch (IOException e11) {
                                e = e11;
                                bVar = bVarPerformRequest2;
                                bArr = bArrA2;
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                e.getMessage();
                                if (bVar == 0) {
                                    a(iVar, new com.mbridge.msdk.foundation.same.net.b.a(i11, cVar2, e.getMessage()), jElapsedRealtime2);
                                    cVar = cVar2;
                                } else {
                                    int iC2 = bVar.c();
                                    if (bArr != 0) {
                                        c cVar3 = new c(iC2, bArr, bVar.b());
                                        if (iC2 >= 400 && iC2 <= 499) {
                                            a(iVar, new com.mbridge.msdk.foundation.same.net.b.a(6, cVar3), jElapsedRealtime2);
                                            cVar = null;
                                        } else {
                                            if (iC2 >= 500 && iC2 <= 599) {
                                                throw new com.mbridge.msdk.foundation.same.net.b.a(7, cVar3, e.getMessage());
                                            }
                                            cVar = null;
                                            a(iVar, new com.mbridge.msdk.foundation.same.net.b.a(2, null, e.getMessage()), jElapsedRealtime2);
                                        }
                                    } else {
                                        cVar = cVar2;
                                        a(iVar, new com.mbridge.msdk.foundation.same.net.b.a(15, cVar, e.getMessage()), jElapsedRealtime2);
                                    }
                                }
                                cVar2 = cVar;
                                i11 = 880023;
                                i12 = 399;
                                i13 = 200;
                            }
                        } catch (IOException e12) {
                            e = e12;
                            bArr = cVar2;
                            bVar = bVarPerformRequest2;
                        }
                    } catch (IOException e13) {
                        e = e13;
                        c cVar4 = cVar2;
                        bArr = cVar4;
                        bVar = cVar4;
                    }
                } catch (ConnectException e14) {
                    cVar = cVar2;
                    long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    e14.getMessage();
                    a(iVar, new com.mbridge.msdk.foundation.same.net.b.a(12, cVar, e14.getMessage()), jElapsedRealtime3);
                    cVar2 = cVar;
                    i11 = 880023;
                    i12 = 399;
                    i13 = 200;
                } catch (MalformedURLException e15) {
                    cVar = cVar2;
                    long jElapsedRealtime4 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    e15.getMessage();
                    a(iVar, new com.mbridge.msdk.foundation.same.net.b.a(4, cVar, e15.getMessage()), jElapsedRealtime4);
                    cVar2 = cVar;
                    i11 = 880023;
                    i12 = 399;
                    i13 = 200;
                } catch (SocketTimeoutException e16) {
                    cVar = cVar2;
                    long jElapsedRealtime5 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    e16.getMessage();
                    a(iVar, new com.mbridge.msdk.foundation.same.net.b.a(10, cVar, e16.getMessage()), jElapsedRealtime5);
                    cVar2 = cVar;
                    i11 = 880023;
                    i12 = 399;
                    i13 = 200;
                } catch (UnknownHostException e17) {
                    cVar = cVar2;
                    long jElapsedRealtime6 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    e17.getMessage();
                    a(iVar, new com.mbridge.msdk.foundation.same.net.b.a(880041, cVar, e17.getMessage()), jElapsedRealtime6);
                    cVar2 = cVar;
                    i11 = 880023;
                    i12 = 399;
                    i13 = 200;
                } catch (SSLProtocolException e18) {
                    cVar = cVar2;
                    long jElapsedRealtime7 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    e18.getMessage();
                    a(iVar, new com.mbridge.msdk.foundation.same.net.b.a(11, cVar, e18.getMessage()), jElapsedRealtime7);
                    cVar2 = cVar;
                    i11 = 880023;
                    i12 = 399;
                    i13 = 200;
                } catch (ConnectTimeoutException e19) {
                    cVar = cVar2;
                    long jElapsedRealtime8 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    e19.getMessage();
                    a(iVar, new com.mbridge.msdk.foundation.same.net.b.a(3, cVar, e19.getMessage()), jElapsedRealtime8);
                    cVar2 = cVar;
                    i11 = 880023;
                    i12 = 399;
                    i13 = 200;
                }
            }
            iVar.a("perform-discard-cancelled");
            this.f44600b.a(iVar);
            throw new com.mbridge.msdk.foundation.same.net.b.a(-2, cVar2);
        }
        if (iVar.q()) {
            iVar.a("perform-discard-cancelled");
            this.f44600b.a(iVar);
            throw new com.mbridge.msdk.foundation.same.net.b.a(-2, null);
        }
        try {
            try {
                iVar.r();
                bVarPerformRequest = this.f44601c.performRequest(iVar);
                try {
                    int iC3 = bVarPerformRequest.c();
                    bArrA = iVar.a(bVarPerformRequest, this.f44600b);
                    try {
                        SystemClock.elapsedRealtime();
                        if (iC3 < 200 || iC3 > 399) {
                            throw new IOException();
                        }
                        return new c(iC3, bArrA, bVarPerformRequest.b());
                    } catch (IOException e21) {
                        e = e21;
                        SystemClock.elapsedRealtime();
                        e.getMessage();
                        if (bVarPerformRequest == null) {
                            throw new com.mbridge.msdk.foundation.same.net.b.a(880023, null, e.getMessage());
                        }
                        int iC4 = bVarPerformRequest.c();
                        if (bArrA == null) {
                            throw new com.mbridge.msdk.foundation.same.net.b.a(15, null, e.getMessage());
                        }
                        c cVar5 = new c(iC4, bArrA, bVarPerformRequest.b());
                        if (iC4 >= 400 && iC4 <= 499) {
                            throw new com.mbridge.msdk.foundation.same.net.b.a(6, cVar5, e.getMessage());
                        }
                        if (iC4 < 500 || iC4 > 599) {
                            throw new com.mbridge.msdk.foundation.same.net.b.a(2, cVar5, e.getMessage());
                        }
                        throw new com.mbridge.msdk.foundation.same.net.b.a(7, cVar5, e.getMessage());
                    }
                } catch (IOException e22) {
                    e = e22;
                    bArrA = null;
                }
            } catch (IOException e23) {
                e = e23;
                bArrA = null;
                bVarPerformRequest = null;
            }
        } catch (ConnectException e24) {
            SystemClock.elapsedRealtime();
            e24.getMessage();
            throw new com.mbridge.msdk.foundation.same.net.b.a(12, null, e24.getMessage());
        } catch (MalformedURLException e25) {
            SystemClock.elapsedRealtime();
            e25.getMessage();
            throw new com.mbridge.msdk.foundation.same.net.b.a(4, null, e25.getMessage());
        } catch (SocketTimeoutException e26) {
            SystemClock.elapsedRealtime();
            e26.getMessage();
            throw new com.mbridge.msdk.foundation.same.net.b.a(10, null, e26.getMessage());
        } catch (UnknownHostException e27) {
            SystemClock.elapsedRealtime();
            e27.getMessage();
            throw new com.mbridge.msdk.foundation.same.net.b.a(880041, null, e27.getMessage());
        } catch (SSLProtocolException e28) {
            SystemClock.elapsedRealtime();
            e28.getMessage();
            throw new com.mbridge.msdk.foundation.same.net.b.a(11, null, e28.getMessage());
        } catch (ConnectTimeoutException e29) {
            SystemClock.elapsedRealtime();
            e29.getMessage();
            throw new com.mbridge.msdk.foundation.same.net.b.a(3, null, e29.getMessage());
        }
    }
}
