package com.bykv.vk.openvk.sc.sc.pFF.pFF;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF.zY;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import l8.e;
import l8.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class sc implements UFX {
    private static final AtomicLong Ql = new AtomicLong();
    protected m8.a ExN;
    protected volatile Ol Ol;
    protected volatile String Qj;
    protected volatile List<Ol.a> TRI;
    protected volatile b WH;
    protected final zY pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected volatile String f26025qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected volatile com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.b f26026sc;
    protected final AtomicInteger zY = new AtomicInteger();
    protected final AtomicLong We = new AtomicLong();
    protected volatile boolean UFX = false;
    public final long Tf = Ql.incrementAndGet();
    private final AtomicInteger SR = new AtomicInteger(0);
    private int BT = -1;

    public sc(com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.b bVar, zY zYVar) {
        this.f26026sc = bVar;
        this.pFF = zYVar;
    }

    public void ExN() throws com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.sc {
        if (pFF()) {
            throw new com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.sc();
        }
    }

    public int TRI() {
        if (this.Ol != null) {
            return this.Ol.f25906c.f25909a;
        }
        return 0;
    }

    public boolean We() {
        return this.SR.get() == 2;
    }

    public boolean pFF() {
        return this.SR.get() == 1;
    }

    public boolean qr() {
        return TRI() == 1;
    }

    public e sc(b.a aVar, int i11, int i12, String str) throws IOException {
        l8.d dVarA = f.b().a();
        l8.a aVar2 = new l8.a();
        HashMap map = new HashMap();
        aVar2.f70153b = aVar.f25987a;
        aVar2.f70152a = 0;
        if ("HEAD".equalsIgnoreCase(str)) {
            aVar2.f70152a = 4;
        }
        List<Ol.a> list = this.TRI;
        if (list != null && !list.isEmpty()) {
            for (Ol.a aVar3 : list) {
                if (!"Range".equalsIgnoreCase(aVar3.f25907a) && !"Connection".equalsIgnoreCase(aVar3.f25907a) && !"Proxy-Connection".equalsIgnoreCase(aVar3.f25907a) && !HttpHeaders.HOST.equalsIgnoreCase(aVar3.f25907a)) {
                    map.put(aVar3.f25907a, aVar3.f25908b);
                }
            }
        }
        String strJ = p8.a.j(i11, i12);
        if (strJ != null) {
            map.put("Range", strJ);
        }
        if (a.f25976g) {
            map.put(HttpHeaders.CACHE_CONTROL, "no-cache");
        }
        We weO = We.o();
        TRI triQ = TRI.q();
        boolean z11 = this.Ol == null;
        if (z11) {
            weO.e();
        } else {
            triQ.k();
        }
        if (z11) {
            weO.c();
        } else {
            triQ.x();
        }
        aVar2.f70156e = map;
        if (!this.UFX) {
            return dVarA.a(aVar2);
        }
        this.UFX = false;
        return null;
    }

    public void sc() {
        this.SR.compareAndSet(0, 1);
    }

    public void sc(int i11, int i12) {
        if (i11 <= 0 || i12 < 0) {
            return;
        }
        int i13 = a.f25977h;
        int iTRI = TRI();
        if (i13 == 1 || (i13 == 2 && iTRI == 1)) {
            int i14 = (int) ((i12 / i11) * 100.0f);
            if (i14 > 100) {
                i14 = 100;
            }
            synchronized (this) {
                try {
                    if (i14 <= this.BT) {
                        return;
                    }
                    this.BT = i14;
                    p8.a.t(new Runnable() { // from class: com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.1
                        @Override // java.lang.Runnable
                        public void run() {
                            sc.this.getClass();
                        }
                    });
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void zY() {
        this.SR.compareAndSet(0, 2);
    }
}
