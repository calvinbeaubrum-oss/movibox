package com.bykv.vk.openvk.sc.sc.pFF.pFF;

import android.os.SystemClock;
import android.util.Log;
import com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF.zY;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import l8.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class qr extends sc {
    private final We BT;
    private final Socket Ql;
    private final d SR;
    private volatile boolean Xc;
    private volatile pFF dE;

    /* JADX INFO: compiled from: source.java */
    public class a implements pFF.a {
        public a() {
        }

        @Override // com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF.a
        public void a(pFF pff) throws Throwable {
            qr.this.zY.addAndGet(pff.zY.get());
            qr.this.We.addAndGet(pff.We.get());
            synchronized (pff.Ql) {
                pff.Ql.notifyAll();
            }
            if (pff.We()) {
                qr.this.BT.k(qr.this.qr(), null);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OutputStream f26018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f26019b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f26020c;

        public b(OutputStream outputStream, int i11) {
            this.f26018a = outputStream;
            this.f26019b = i11;
        }

        public int a() {
            return this.f26019b;
        }

        public void b(byte[] bArr, int i11, int i12) throws com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.We {
            try {
                this.f26018a.write(bArr, i11, i12);
                this.f26019b += i12;
            } catch (IOException e11) {
                throw new com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.We(e11);
            }
        }

        public void c(byte[] bArr, int i11, int i12) throws com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.We {
            if (this.f26020c) {
                return;
            }
            try {
                this.f26018a.write(bArr, i11, i12);
                this.f26020c = true;
            } catch (IOException e11) {
                throw new com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.We(e11);
            }
        }

        public boolean d() {
            return this.f26020c;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.b f26021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public zY f26022b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Socket f26023c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d f26024d;

        public c a(zY zYVar) {
            if (zYVar == null) {
                throw new IllegalArgumentException("db == null");
            }
            this.f26022b = zYVar;
            return this;
        }

        public c b(d dVar) {
            this.f26024d = dVar;
            return this;
        }

        public c c(Socket socket) {
            if (socket == null) {
                throw new IllegalArgumentException("socket == null");
            }
            this.f26023c = socket;
            return this;
        }

        public qr d() {
            if (this.f26022b == null || this.f26023c == null) {
                throw new IllegalArgumentException();
            }
            return new qr(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a(qr qrVar);

        void b(qr qrVar);
    }

    public qr(c cVar) {
        super(cVar.f26021a, cVar.f26022b);
        this.Xc = true;
        this.Ql = cVar.f26023c;
        this.SR = cVar.f26024d;
        this.BT = We.o();
    }

    private void Ol() {
        pFF pff = this.dE;
        this.dE = null;
        if (pff != null) {
            pff.sc();
        }
    }

    private b Qj() {
        com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY zYVar;
        try {
            this.Ol = Ol.a(this.Ql.getInputStream());
            OutputStream outputStream = this.Ql.getOutputStream();
            if (this.Ol.f25906c.f25909a == 1) {
                com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY zYVar2 = com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25970a;
                zYVar = null;
            } else {
                zYVar = com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25970a;
            }
            if (zYVar == null) {
                if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                    Log.e("TAG_PROXY_ProxyTask", "cache is null");
                }
                return null;
            }
            this.f26026sc = zYVar;
            this.f26025qr = this.Ol.f25906c.f25910b;
            this.Qj = this.Ol.f25906c.f25911c;
            this.WH = new com.bykv.vk.openvk.sc.sc.pFF.pFF.b(this.Ol.f25906c.f25915g);
            this.TRI = this.Ol.f25905b;
            if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                new StringBuilder("request from MediaPlayer:    ").append(this.Ol.toString());
            }
            return new b(outputStream, this.Ol.f25906c.f25912d);
        } catch (Ol.We e11) {
            p8.a.v(this.Ql);
            if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e11));
            }
            if (this.f26026sc != null) {
                qr();
            }
            return null;
        } catch (IOException e12) {
            p8.a.v(this.Ql);
            if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e12));
            }
            if (this.f26026sc != null) {
                qr();
            }
            return null;
        }
    }

    private void We(b bVar, com.bykv.vk.openvk.sc.sc.pFF.pFF.b.a aVar) throws Throwable {
        Qj qj2;
        Ol();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int iA = bVar.a();
        e eVarSc = sc(aVar, iA, this.Ol.f25906c.f25913e, "GET");
        if (eVarSc == null) {
            return;
        }
        Qj qj3 = null;
        int i11 = 0;
        try {
            String strM = p8.a.m(eVarSc, false, true);
            if (strM != null) {
                throw new com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.zY(strM + ", rawKey: " + this.f26025qr + ", url: " + aVar);
            }
            pFF.e eVarE = this.pFF.e(this.Qj, TRI());
            int iH = p8.a.h(eVarSc);
            if (eVarE != null && eVarE.f26006c != iH) {
                if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                    Log.e("TAG_PROXY_ProxyTask", "Content-Length not match, old: " + eVarE.f26006c + ", " + iH + ", key: " + this.Qj);
                }
                throw new com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.pFF("Content-Length not match, old length: " + eVarE.f26006c + ", new length: " + iH + ", rawKey: " + this.f26025qr + ", currentUrl: " + aVar + ", previousInfo: " + eVarE.f26008e);
            }
            if (!bVar.d()) {
                String strL = p8.a.l(eVarSc, iA);
                ExN();
                byte[] bytes = strL.getBytes(p8.a.f73721b);
                bVar.c(bytes, 0, bytes.length);
            }
            ExN();
            File fileA = this.f26026sc.a(this.Qj);
            if (!this.Xc || fileA == null || fileA.length() < bVar.a()) {
                if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                    Log.w("TAG_PROXY_ProxyTask", "can't write to cache file in network task, cache file size: " + fileA.length() + ", from: " + bVar.a());
                }
                qj2 = null;
            } else {
                p8.a.i(eVarSc, this.pFF, this.Qj, this.Ol.f25906c.f25909a);
                try {
                    qj2 = new Qj(fileA, "rwd");
                    try {
                        qj2.c(bVar.a());
                    } catch (Throwable th2) {
                        th = th2;
                        qj3 = qj2;
                    }
                } catch (Qj.sc unused) {
                    qj2 = null;
                }
                if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                    StringBuilder sb2 = new StringBuilder("can write to cache file in network task, cache file size: ");
                    sb2.append(fileA.length());
                    sb2.append(", from: ");
                    sb2.append(bVar.a());
                }
            }
            pFF.e eVarE2 = this.pFF.e(this.Qj, TRI());
            int i12 = eVarE2 == null ? 0 : eVarE2.f26006c;
            byte[] bArr = new byte[8192];
            InputStream inputStreamC = eVarSc.c();
            int i13 = 0;
            while (true) {
                try {
                    int i14 = inputStreamC.read(bArr);
                    if (i14 < 0) {
                        break;
                    }
                    ExN();
                    if (i14 > 0) {
                        bVar.b(bArr, 0, i14);
                        i13 += i14;
                        if (qj2 != null) {
                            try {
                                qj2.d(bArr, 0, i14);
                            } catch (Throwable th3) {
                                qj2.b();
                                try {
                                    if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                                        Log.e("TAG_PROXY_ProxyTask", "append to cache file error in network task!!! " + Log.getStackTraceString(th3));
                                    }
                                    qj2 = null;
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            }
                        }
                        sc(i12, bVar.a());
                    }
                    ExN();
                } catch (Throwable th5) {
                    th = th5;
                    qj3 = qj2;
                }
                th = th5;
                qj3 = qj2;
                i11 = i13;
                p8.a.r(eVarSc.c());
                if (qj3 != null) {
                    qj3.b();
                }
                this.zY.addAndGet(i11);
                this.We.addAndGet(SystemClock.elapsedRealtime() - jElapsedRealtime);
                throw th;
            }
            com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY zYVar = com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25970a;
            zY();
            p8.a.r(eVarSc.c());
            if (qj2 != null) {
                qj2.b();
            }
            this.zY.addAndGet(i13);
            this.We.addAndGet(SystemClock.elapsedRealtime() - jElapsedRealtime);
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private void pFF(b bVar, com.bykv.vk.openvk.sc.sc.pFF.pFF.b.a aVar) throws IOException, com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.We {
        byte[] bArrSc = sc(this.pFF.e(this.Qj, this.Ol.f25906c.f25909a), bVar, aVar);
        if (bArrSc == null) {
            return;
        }
        bVar.c(bArrSc, 0, bArrSc.length);
    }

    private void sc(pFF.e eVar, File file, b bVar, com.bykv.vk.openvk.sc.sc.pFF.pFF.b.a aVar) throws Throwable {
        final com.bytedance.sdk.component.Qj.qr qrVar;
        pFF pff;
        if (!bVar.d()) {
            byte[] bArrSc = sc(eVar, bVar, aVar);
            ExN();
            if (bArrSc == null) {
                return;
            } else {
                bVar.c(bArrSc, 0, bArrSc.length);
            }
        }
        Qj qj2 = null;
        if (eVar == null && (eVar = this.pFF.e(this.Qj, this.Ol.f25906c.f25909a)) == null) {
            if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                Log.e("TAG_PROXY_ProxyTask", "failed to get video header info from db");
            }
            sc(null, bVar, aVar);
            eVar = this.pFF.e(this.Qj, this.Ol.f25906c.f25909a);
            if (eVar == null) {
                throw new com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.zY("failed to get header, rawKey: " + this.f26025qr + ", url: " + aVar);
            }
        }
        if (file.length() >= eVar.f26006c || !((pff = this.dE) == null || pff.pFF() || pff.We())) {
            qrVar = null;
        } else {
            pFF pffK = new pFF.b().g(this.f26026sc).f(this.pFF).i(this.f26025qr).a(this.Qj).d(new com.bykv.vk.openvk.sc.sc.pFF.pFF.b(aVar.f25987a)).j(this.TRI).c(this.Ol).e(new a()).k();
            this.dE = pffK;
            qrVar = new com.bytedance.sdk.component.Qj.qr(pffK, null, 10, 1);
            com.bytedance.sdk.component.Qj.TRI.pFF(new com.bytedance.sdk.component.Qj.Qj("processCacheNetWorkConcurrent") { // from class: com.bykv.vk.openvk.sc.sc.pFF.pFF.qr.2
                @Override // java.lang.Runnable
                public void run() {
                    qrVar.run();
                }
            });
            if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                Log.e("TAG_PROXY_ProxyTask", "fire download in process cache task");
            }
        }
        byte[] bArr = new byte[8192];
        try {
            Qj qj3 = new Qj(file, CampaignEx.JSON_KEY_AD_R);
            try {
                qj3.c(bVar.a());
                int iMin = this.Ol.f25906c.f25913e > 0 ? Math.min(eVar.f26006c, this.Ol.f25906c.f25913e) : eVar.f26006c;
                while (bVar.a() < iMin) {
                    ExN();
                    int iA = qj3.a(bArr);
                    if (iA <= 0) {
                        pFF pff2 = this.dE;
                        if (pff2 != null) {
                            com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.pFF pffOl = pff2.Ol();
                            if (pffOl != null) {
                                throw pffOl;
                            }
                            Qj.sc scVarQj = pff2.Qj();
                            if (scVarQj != null) {
                                throw scVarQj;
                            }
                        }
                        if (pff2 != null && !pff2.pFF() && !pff2.We()) {
                            ExN();
                            synchronized (pff2.Ql) {
                                try {
                                    pff2.Ql.wait(1000L);
                                } catch (InterruptedException unused) {
                                }
                            }
                        }
                        if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                            Log.e("TAG_PROXY_ProxyTask", "download task has finished!!!");
                        }
                        throw new com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.zY("illegal state download task has finished, rawKey: " + this.f26025qr + ", url: " + aVar);
                    }
                    bVar.b(bArr, 0, iA);
                    ExN();
                }
                if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                    StringBuilder sb2 = new StringBuilder("read cache file complete: ");
                    sb2.append(bVar.a());
                    sb2.append(", ");
                    sb2.append(iMin);
                }
                zY();
                qj3.b();
                if (qrVar != null) {
                    try {
                        qrVar.get();
                    } catch (Throwable unused2) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                qj2 = qj3;
                if (qj2 != null) {
                    qj2.b();
                }
                if (qrVar != null) {
                    try {
                        qrVar.get();
                    } catch (Throwable unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void sc(b bVar, com.bykv.vk.openvk.sc.sc.pFF.pFF.b.a aVar) throws Throwable {
        if ("HEAD".equalsIgnoreCase(this.Ol.f25904a.f25916a)) {
            pFF(bVar, aVar);
        } else {
            zY(bVar, aVar);
        }
    }

    private boolean sc(b bVar) throws Throwable {
        while (this.WH.c()) {
            ExN();
            com.bykv.vk.openvk.sc.sc.pFF.pFF.b.a aVarB = this.WH.b();
            try {
                sc(bVar, aVarB);
                return true;
            } catch (Qj.sc e11) {
                if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e11));
                }
                this.Xc = false;
                qr();
            } catch (com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.We e12) {
                if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e12));
                }
                return true;
            } catch (com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.pFF e13) {
                if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e13));
                }
                return false;
            } catch (com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.zY unused) {
                aVarB.b();
                qr();
            } catch (IOException e14) {
                if (e14 instanceof SocketTimeoutException) {
                    aVarB.a();
                }
                if (!pFF()) {
                    qr();
                } else if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                    if ("Canceled".equalsIgnoreCase(e14.getMessage())) {
                        Log.w("TAG_PROXY_ProxyTask", "okhttp call canceled");
                    } else {
                        Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e14));
                    }
                }
            } catch (Exception e15) {
                if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e15));
                }
            }
        }
        return false;
    }

    private byte[] sc(pFF.e eVar, b bVar, com.bykv.vk.openvk.sc.sc.pFF.pFF.b.a aVar) throws IOException {
        if (eVar != null) {
            com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY zYVar = com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25970a;
            return p8.a.k(eVar, bVar.a()).getBytes(p8.a.f73721b);
        }
        e eVarSc = sc(aVar, 0, -1, "HEAD");
        if (eVarSc == null) {
            return null;
        }
        try {
            String strM = p8.a.m(eVarSc, false, false);
            if (strM == null) {
                pFF.e eVarI = p8.a.i(eVarSc, this.pFF, this.Qj, this.Ol.f25906c.f25909a);
                if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                    Log.w("TAG_PROXY_ProxyTask", "get header from network");
                }
                byte[] bytes = p8.a.k(eVarI, bVar.a()).getBytes(p8.a.f73721b);
                p8.a.r(eVarSc.c());
                return bytes;
            }
            throw new com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.zY(strM + ", rawKey: " + this.f26025qr + ", url: " + aVar);
        } catch (Throwable th2) {
            p8.a.r(eVarSc.c());
            throw th2;
        }
    }

    private void zY(b bVar, com.bykv.vk.openvk.sc.sc.pFF.pFF.b.a aVar) throws Throwable {
        if (this.Xc) {
            File fileD = this.f26026sc.d(this.Qj);
            long length = fileD.length();
            pFF.e eVarE = this.pFF.e(this.Qj, this.Ol.f25906c.f25909a);
            int iA = bVar.a();
            if (length > bVar.a()) {
                if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                    new StringBuilder("cache hit, remainSize: ").append(length - ((long) iA));
                }
                sc(eVarE, fileD, bVar, aVar);
                return;
            }
        } else {
            bVar.a();
        }
        We(bVar, aVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        pFF.e eVarE;
        b bVarQj = Qj();
        if (bVarQj == null) {
            return;
        }
        d dVar = this.SR;
        if (dVar != null) {
            dVar.a(this);
        }
        this.f26026sc.c(this.Qj);
        if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25978i != 0 && ((eVarE = this.pFF.e(this.Qj, this.Ol.f25906c.f25909a)) == null || this.f26026sc.d(this.Qj).length() < eVarE.f26006c)) {
            this.BT.k(qr(), this.Qj);
        }
        try {
            sc(bVarQj);
        } catch (com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.sc e11) {
            if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e11));
            }
        } catch (Throwable th2) {
            if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(th2));
            }
        }
        this.f26026sc.b(this.Qj);
        this.BT.k(qr(), null);
        sc();
        p8.a.v(this.Ql);
        d dVar2 = this.SR;
        if (dVar2 != null) {
            dVar2.b(this);
        }
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.pFF.sc
    public void sc() {
        super.sc();
        Ol();
    }
}
