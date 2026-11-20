package com.bykv.vk.openvk.sc.sc.pFF.We;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.sc.sc.sc.zY.zY;
import com.bytedance.sdk.component.Qj.Ol;
import com.bytedance.sdk.component.utils.FI;
import com.google.android.gms.common.api.Api;
import com.google.logging.type.LogSeverity;
import com.transsion.gslb.Worker;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We implements e.a, e.b, e.c, e.d, e.InterfaceC0216e, e.f, e.g, q8.b, FI.sc {
    private static final SparseIntArray FI = new SparseIntArray();
    private static boolean qKn = false;
    private ArrayList<Runnable> Dl;
    private boolean Ol;
    private FI Ql;
    private boolean WH;
    private boolean WP;
    private int We;
    private boolean YIK;
    private volatile boolean kX;
    private SurfaceHolder pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private SurfaceTexture f25873sc;
    private int zY = 0;
    private boolean ExN = false;
    private volatile e TRI = null;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final boolean f25872qr = false;
    private boolean Qj = false;
    private volatile int UFX = 201;
    private long Tf = -1;
    private boolean SR = false;
    private long BT = 0;
    private long dE = Long.MIN_VALUE;
    private long Xc = 0;
    private long wjp = 0;
    private long Sfl = 0;
    private int uEA = 0;
    private String JPJ = "0";
    private final List<WeakReference<q8.b.a>> cvk = new CopyOnWriteArrayList();
    private zY II = null;
    private boolean McK = false;
    private CountDownLatch HJN = new CountDownLatch(1);
    private volatile int Gb = 200;
    private AtomicBoolean cD = new AtomicBoolean(false);
    private Surface Cb = null;
    private final Runnable OXF = new Runnable() { // from class: com.bykv.vk.openvk.sc.sc.pFF.We.We.1
        @Override // java.lang.Runnable
        public void run() {
            if (We.this.TRI == null) {
                return;
            }
            long jXc = We.this.Xc();
            if (jXc > 0 && Build.VERSION.SDK_INT >= 23 && We.this.TRI() && We.this.dE != Long.MIN_VALUE) {
                try {
                    if (We.this.dE == jXc) {
                        if (!We.this.SR && We.this.Xc >= 400) {
                            We.this.pFF(701, LogSeverity.EMERGENCY_VALUE);
                            We.this.SR = true;
                        }
                        We.this.Xc += (long) We.this.Gb;
                    } else {
                        if (We.this.SR) {
                            We.this.BT += We.this.Xc;
                            We.this.pFF(702, LogSeverity.EMERGENCY_VALUE);
                            long unused = We.this.BT;
                            int unused2 = We.this.zY;
                        }
                        We.this.Xc = 0L;
                        We.this.SR = false;
                    }
                } catch (Throwable th2) {
                    th2.getMessage();
                }
            }
            if (We.this.dE() > 0) {
                if (We.this.dE != jXc) {
                    if (q8.c.a()) {
                        long unused3 = We.this.dE;
                    }
                    We we2 = We.this;
                    we2.sc(jXc, we2.dE());
                }
                We.this.dE = jXc;
            }
            if (We.this.pFF()) {
                We we3 = We.this;
                we3.sc(we3.dE(), We.this.dE());
            } else if (We.this.Ql != null) {
                We.this.Ql.postDelayed(this, We.this.Gb);
            }
        }
    };
    private final sc cJ = new sc();
    private long BR = 0;
    private long JoC = 0;
    private boolean CYO = false;

    /* JADX INFO: compiled from: source.java */
    public class sc implements Runnable {
        private long pFF;
        private boolean zY;

        public sc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (We.this.TRI != null) {
                try {
                    if (!this.zY) {
                        long jOl = We.this.TRI.Ol();
                        We.this.Tf = Math.max(this.pFF, jOl);
                    }
                    long unused = We.this.Tf;
                } catch (Throwable th2) {
                    th2.toString();
                }
            }
            if (We.this.Ql != null) {
                We.this.Ql.sendEmptyMessageDelayed(100, 0L);
            }
        }

        public void sc(long j11) {
            this.pFF = j11;
        }

        public void sc(boolean z11) {
            this.zY = z11;
        }
    }

    public We() {
        sc("SSMediaPlayerWrapper");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dl() {
        FI fi2 = this.Ql;
        if (fi2 != null) {
            fi2.post(new Runnable() { // from class: com.bykv.vk.openvk.sc.sc.pFF.We.We.10
                @Override // java.lang.Runnable
                public void run() {
                    if (We.this.TRI == null) {
                        try {
                            We.this.TRI = new c();
                        } catch (Throwable th2) {
                            th2.getMessage();
                        }
                        if (We.this.TRI == null) {
                            return;
                        }
                        e unused = We.this.TRI;
                        We.this.JPJ = "0";
                        We.this.TRI.d(We.this);
                        We.this.TRI.c(We.this);
                        We.this.TRI.j(We.this);
                        We.this.TRI.a(We.this);
                        We.this.TRI.i(We.this);
                        We.this.TRI.e(We.this);
                        We.this.TRI.g(We.this);
                        try {
                            We.this.TRI.zY(false);
                        } catch (Throwable unused2) {
                        }
                        We.this.Qj = false;
                    }
                }
            });
        }
    }

    private void FI() {
        FI fi2 = this.Ql;
        if (fi2 == null || fi2.getLooper() == null) {
            return;
        }
        this.Ql.post(new Runnable() { // from class: com.bykv.vk.openvk.sc.sc.pFF.We.We.6
            @Override // java.lang.Runnable
            public void run() {
                if (We.this.Ql == null || We.this.Ql.getLooper() == null) {
                    return;
                }
                try {
                    com.bytedance.sdk.component.Qj.sc.sc.sc().sc(We.this.Ql);
                    We.this.Ql = null;
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void Gb() {
        ArrayList<Runnable> arrayList = this.Dl;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.Dl.clear();
    }

    private void HJN() {
        ArrayList<Runnable> arrayList = this.Dl;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        McK();
    }

    private void II() {
        FI fi2 = this.Ql;
        if (fi2 != null) {
            fi2.post(new Runnable() { // from class: com.bykv.vk.openvk.sc.sc.pFF.We.We.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        We.this.TRI.qr();
                        We.this.UFX = 207;
                        We.this.kX = false;
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private void JPJ() {
        if (this.TRI == null) {
            return;
        }
        try {
            this.TRI.Tf();
        } catch (Throwable unused) {
        }
        this.TRI.c(null);
        this.TRI.g(null);
        this.TRI.a(null);
        this.TRI.e(null);
        this.TRI.j(null);
        this.TRI.d(null);
        this.TRI.i(null);
        try {
            this.TRI.UFX();
        } catch (Throwable unused2) {
        }
    }

    private void McK() {
        if (this.Ol) {
            return;
        }
        this.Ol = true;
        Iterator it = new ArrayList(this.Dl).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.Dl.clear();
        this.Ol = false;
    }

    private void WP() {
        SparseIntArray sparseIntArray = FI;
        Integer numValueOf = Integer.valueOf(sparseIntArray.get(this.uEA));
        if (numValueOf == null) {
            sparseIntArray.put(this.uEA, 1);
        } else {
            sparseIntArray.put(this.uEA, numValueOf.intValue() + 1);
        }
    }

    private void YIK() {
        this.BT = 0L;
        this.zY = 0;
        this.Xc = 0L;
        this.SR = false;
        this.dE = Long.MIN_VALUE;
    }

    private void cvk() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.Sfl;
        for (WeakReference<q8.b.a> weakReference : this.cvk) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().sc(this, jElapsedRealtime);
            }
        }
        this.ExN = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(int i11, int i12) {
        if (i11 == 701) {
            this.BR = SystemClock.elapsedRealtime();
            this.zY++;
            for (WeakReference<q8.b.a> weakReference : this.cvk) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().sc(this, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0, 0);
                }
            }
            return;
        }
        if (i11 != 702) {
            if (this.CYO && i11 == 3) {
                HJN();
                cvk();
                pFF(this.McK);
                return;
            }
            return;
        }
        if (this.BR > 0) {
            this.JoC += SystemClock.elapsedRealtime() - this.BR;
            this.BR = 0L;
        }
        for (WeakReference<q8.b.a> weakReference2 : this.cvk) {
            if (weakReference2 != null && weakReference2.get() != null) {
                weakReference2.get().sc((q8.b) this, Api.BaseClientBuilder.API_PRIORITY_OTHER);
            }
        }
    }

    private void pFF(long j11) {
        this.cJ.sc(j11);
        if (this.WP) {
            pFF(this.cJ);
        } else if (pFF(this.II)) {
            pFF(this.cJ);
        } else {
            sc(this.cJ);
        }
    }

    private void pFF(Runnable runnable) {
        if (runnable == null || Qj()) {
            return;
        }
        if (this.WH) {
            sc(runnable);
        } else {
            runnable.run();
        }
    }

    private void pFF(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.TRI.f(fileInputStream.getFD());
        fileInputStream.close();
    }

    private boolean pFF(zY zYVar) {
        return zYVar != null && zYVar.We();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(long j11, long j12) {
        for (WeakReference<q8.b.a> weakReference : this.cvk) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().sc(this, j11, j12);
            }
        }
    }

    private void sc(Runnable runnable) {
        try {
            if (this.Dl == null) {
                this.Dl = new ArrayList<>();
            }
            this.Dl.add(runnable);
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    private void sc(String str) {
        this.uEA = 0;
        this.Ql = com.bytedance.sdk.component.Qj.sc.sc.sc().sc(this, Ol.THREAD_NAME_PRE.concat(String.valueOf(str)));
        this.CYO = true;
        Dl();
    }

    private boolean sc(int i11, int i12) {
        boolean z11 = i11 == -1010 || i11 == -1007 || i11 == -1004 || i11 == -110 || i11 == 100 || i11 == 200;
        if (i12 == 1 || i12 == 700 || i12 == 800) {
            return true;
        }
        return z11;
    }

    private void uEA() {
        pFF(new Runnable() { // from class: com.bykv.vk.openvk.sc.sc.pFF.We.We.14
            @Override // java.lang.Runnable
            public void run() {
                if (We.this.Ql != null) {
                    We.this.Ql.sendEmptyMessage(104);
                }
            }
        });
    }

    public static void zY(boolean z11) {
        qKn = z11;
    }

    public int BT() {
        return this.zY;
    }

    @Override // q8.b
    public int ExN() {
        if (this.TRI == null || Qj()) {
            return 0;
        }
        return this.TRI.SR();
    }

    public void Ol() {
        if (Qj() || this.TRI == null) {
            return;
        }
        this.cD.set(true);
        if (this.UFX != 206) {
            YIK();
            this.kX = false;
            this.cJ.sc(true);
            pFF(0L);
            FI fi2 = this.Ql;
            if (fi2 != null) {
                fi2.removeCallbacks(this.OXF);
                this.Ql.postDelayed(this.OXF, this.Gb);
            }
        }
        this.HJN.countDown();
    }

    @Override // q8.b
    public boolean Qj() {
        return this.WH;
    }

    public boolean Ql() {
        return this.UFX == 205;
    }

    public long SR() {
        if (Build.VERSION.SDK_INT < 23) {
            return this.JoC;
        }
        if (this.SR) {
            long j11 = this.Xc;
            if (j11 > 0) {
                return this.BT + j11;
            }
        }
        return this.BT;
    }

    public SurfaceTexture Sfl() {
        return this.f25873sc;
    }

    @Override // q8.b
    public boolean TRI() {
        FI fi2;
        return (this.UFX == 206 || ((fi2 = this.Ql) != null && fi2.hasMessages(100))) && !this.kX;
    }

    public void Tf() {
        if (Qj()) {
            return;
        }
        this.WH = true;
        Gb();
        FI fi2 = this.Ql;
        if (fi2 != null) {
            try {
                fi2.removeCallbacksAndMessages(null);
                if (this.TRI != null) {
                    this.Ql.sendEmptyMessage(Worker.WHAT_SYNC_DATA);
                }
                FI();
            } catch (Throwable unused) {
                FI();
            }
        }
    }

    public void UFX() {
        FI fi2;
        if (Qj() || (fi2 = this.Ql) == null) {
            return;
        }
        fi2.removeMessages(100);
        this.kX = true;
        if (this.CYO) {
            if (!this.ExN && !pFF(this.II)) {
                sc(new Runnable() { // from class: com.bykv.vk.openvk.sc.sc.pFF.We.We.13
                    @Override // java.lang.Runnable
                    public void run() {
                        if (We.this.Ql != null) {
                            We.this.Ql.sendEmptyMessage(101);
                        }
                    }
                });
                return;
            }
            FI fi3 = this.Ql;
            if (fi3 != null) {
                fi3.sendEmptyMessage(101);
                return;
            }
            return;
        }
        if (!this.YIK && !pFF(this.II)) {
            sc(new Runnable() { // from class: com.bykv.vk.openvk.sc.sc.pFF.We.We.12
                @Override // java.lang.Runnable
                public void run() {
                    if (We.this.Ql != null) {
                        We.this.Ql.sendEmptyMessage(101);
                    }
                }
            });
            return;
        }
        FI fi4 = this.Ql;
        if (fi4 != null) {
            fi4.sendEmptyMessage(101);
        }
    }

    public void WH() {
        if (Qj() || this.Ql == null) {
            return;
        }
        this.cD.set(true);
        this.Ql.post(new Runnable() { // from class: com.bykv.vk.openvk.sc.sc.pFF.We.We.11
            @Override // java.lang.Runnable
            public void run() {
                if (!We.this.qr() || We.this.TRI == null) {
                    return;
                }
                try {
                    We.this.TRI.ExN();
                    for (WeakReference weakReference : We.this.cvk) {
                        if (weakReference != null && weakReference.get() != null) {
                            ((q8.b.a) weakReference.get()).ExN(We.this);
                        }
                    }
                    We.this.UFX = 206;
                } catch (Throwable th2) {
                    th2.getMessage();
                }
            }
        });
    }

    @Override // q8.b
    public int We() {
        if (this.TRI == null || Qj()) {
            return 0;
        }
        return this.TRI.Ql();
    }

    public long Xc() {
        if (Qj()) {
            return 0L;
        }
        if (this.UFX == 206 || this.UFX == 207) {
            try {
                return this.TRI.Ol();
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public long dE() {
        long j11 = this.wjp;
        if (j11 != 0) {
            return j11;
        }
        if (this.UFX == 206 || this.UFX == 207) {
            try {
                this.wjp = this.TRI.WH();
            } catch (Throwable unused) {
            }
        }
        return this.wjp;
    }

    public void pFF(int i11) {
        this.We = i11;
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e.a
    public void pFF(e eVar) {
        if (Qj()) {
            return;
        }
        this.UFX = 205;
        try {
            zY zYVar = this.II;
            if (zYVar != null) {
                float fTf = zYVar.Tf();
                if (fTf > 0.0f) {
                    q8.a aVar = new q8.a();
                    aVar.b(fTf);
                    this.TRI.h(aVar);
                }
            }
        } catch (Throwable unused) {
        }
        if (this.Ql != null) {
            if (this.kX) {
                II();
            } else {
                FI fi2 = this.Ql;
                fi2.sendMessage(fi2.obtainMessage(100, -1, -1));
            }
        }
        FI.delete(this.uEA);
        boolean z11 = this.CYO;
        boolean z12 = this.YIK;
        if (!z11 && !z12) {
            cvk();
            this.YIK = true;
        }
        for (WeakReference<q8.b.a> weakReference : this.cvk) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().pFF(this);
            }
        }
    }

    public void pFF(final boolean z11) {
        FI fi2;
        if (Qj() || (fi2 = this.Ql) == null) {
            return;
        }
        fi2.post(new Runnable() { // from class: com.bykv.vk.openvk.sc.sc.pFF.We.We.8
            @Override // java.lang.Runnable
            public void run() {
                if (We.this.Qj() || We.this.TRI == null) {
                    return;
                }
                try {
                    We.this.McK = z11;
                    We.this.TRI.We(z11);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // q8.b
    public boolean pFF() {
        return this.UFX == 209;
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e.c
    public boolean pFF(e eVar, int i11, int i12) {
        if (this.TRI != eVar) {
            return false;
        }
        if (i12 == -1004) {
            x8.b bVar = new x8.b(i11, i12);
            for (WeakReference<q8.b.a> weakReference : this.cvk) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().sc(this, bVar);
                }
            }
        }
        pFF(i11, i12);
        return false;
    }

    @Override // q8.b
    public boolean qr() {
        FI fi2;
        return ((this.UFX != 207 && !this.kX) || (fi2 = this.Ql) == null || fi2.hasMessages(100)) ? false : true;
    }

    public void sc(int i11) {
        if (Qj()) {
            return;
        }
        this.Gb = i11;
    }

    public void sc(final long j11) {
        if (Qj()) {
            return;
        }
        if (this.UFX == 207 || this.UFX == 206 || this.UFX == 209) {
            pFF(new Runnable() { // from class: com.bykv.vk.openvk.sc.sc.pFF.We.We.2
                @Override // java.lang.Runnable
                public void run() {
                    if (We.this.Ql != null) {
                        We.this.Ql.obtainMessage(106, Long.valueOf(j11)).sendToTarget();
                    }
                }
            });
        }
    }

    public void sc(final SurfaceTexture surfaceTexture) {
        if (Qj()) {
            return;
        }
        this.f25873sc = surfaceTexture;
        sc(true);
        pFF(new Runnable() { // from class: com.bykv.vk.openvk.sc.sc.pFF.We.We.3
            @Override // java.lang.Runnable
            public void run() {
                We.this.Dl();
                if (We.this.Ql != null) {
                    We.this.Ql.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.utils.FI.sc
    public void sc(Message message) {
        int i11 = this.UFX;
        int i12 = message.what;
        if (this.TRI != null) {
            try {
                switch (message.what) {
                    case 100:
                        if (this.UFX == 205 || this.UFX == 207 || this.UFX == 209) {
                            this.TRI.ExN();
                            this.Sfl = SystemClock.elapsedRealtime();
                            this.UFX = 206;
                            if (this.Tf > 0) {
                                this.TRI.sc(this.Tf, this.We);
                                this.Tf = -1L;
                            }
                            if (this.II != null) {
                                pFF(this.McK);
                                return;
                            }
                            return;
                        }
                        break;
                    case 101:
                        if (this.SR) {
                            this.BT += this.Xc;
                        }
                        this.SR = false;
                        this.Xc = 0L;
                        this.dE = Long.MIN_VALUE;
                        if (this.UFX == 206 || this.UFX == 207 || this.UFX == 209) {
                            this.TRI.qr();
                            this.UFX = 207;
                            this.kX = false;
                            for (WeakReference<q8.b.a> weakReference : this.cvk) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get().We(this);
                                }
                            }
                            return;
                        }
                        break;
                    case 102:
                        this.TRI.Tf();
                        this.UFX = 201;
                        return;
                    case Worker.WHAT_SYNC_DATA /* 103 */:
                        try {
                            JPJ();
                            break;
                        } catch (Throwable unused) {
                        }
                        for (WeakReference<q8.b.a> weakReference2 : this.cvk) {
                            if (weakReference2 != null && weakReference2.get() != null) {
                                weakReference2.get().zY(this);
                            }
                        }
                        this.UFX = 203;
                        return;
                    case 104:
                        if (this.UFX == 202 || this.UFX == 208) {
                            this.TRI.Qj();
                            return;
                        }
                        break;
                    case 105:
                        if (this.UFX == 205 || this.UFX == 206 || this.UFX == 208 || this.UFX == 207 || this.UFX == 209) {
                            this.TRI.TRI();
                            this.UFX = 208;
                            return;
                        }
                        break;
                    case 106:
                        if (this.UFX == 206 || this.UFX == 207 || this.UFX == 209) {
                            this.TRI.sc(((Long) message.obj).longValue(), this.We);
                            return;
                        }
                        break;
                    case 107:
                        YIK();
                        if (this.UFX == 201 || this.UFX == 203) {
                            zY zYVar = (zY) message.obj;
                            if (TextUtils.isEmpty(zYVar.pFF())) {
                                zYVar.sc(q8.c.d());
                            }
                            File file = new File(zYVar.pFF(), zYVar.SR());
                            if (file.exists()) {
                                file.getAbsolutePath();
                                if (q8.c.j()) {
                                    pFF(file.getAbsolutePath());
                                } else {
                                    this.TRI.sc(file.getAbsolutePath());
                                }
                            } else {
                                zYVar.Ql();
                                if ((qKn || zYVar.pFF == 1) && Build.VERSION.SDK_INT < 23) {
                                    this.TRI.sc(zYVar.Ql());
                                    zYVar.Ql();
                                } else if (Build.VERSION.SDK_INT >= 23) {
                                    this.TRI.sc(zYVar);
                                    zYVar.Ql();
                                } else {
                                    String strA = com.bykv.vk.openvk.sc.sc.pFF.pFF.TRI.sc.c().a(zYVar);
                                    if (strA != null && q8.c.j() && strA.startsWith("file")) {
                                        pFF(Uri.parse(strA).getPath());
                                    } else {
                                        this.TRI.sc(strA);
                                    }
                                }
                            }
                            this.UFX = 202;
                            return;
                        }
                        break;
                    case 108:
                    case 109:
                    default:
                        return;
                    case Worker.WHAT_QUIT /* 110 */:
                        this.TRI.sc((SurfaceHolder) message.obj);
                        this.TRI.pFF(true);
                        this.HJN.await(1L, TimeUnit.SECONDS);
                        HJN();
                        return;
                    case 111:
                        this.Cb = new Surface((SurfaceTexture) message.obj);
                        this.TRI.b(this.Cb);
                        this.TRI.pFF(true);
                        this.HJN.await(1L, TimeUnit.SECONDS);
                        HJN();
                        return;
                }
                this.UFX = 200;
                if (this.Qj) {
                    return;
                }
                x8.b bVar = new x8.b(308, i12);
                bVar.c(i11 + "," + i12);
                for (WeakReference<q8.b.a> weakReference3 : this.cvk) {
                    if (weakReference3 != null && weakReference3.get() != null) {
                        weakReference3.get().sc(this, bVar);
                    }
                }
                this.Qj = true;
            } catch (Throwable unused2) {
            }
        }
    }

    public void sc(final SurfaceHolder surfaceHolder) {
        if (Qj()) {
            return;
        }
        this.pFF = surfaceHolder;
        sc(true);
        pFF(new Runnable() { // from class: com.bykv.vk.openvk.sc.sc.pFF.We.We.4
            @Override // java.lang.Runnable
            public void run() {
                We.this.Dl();
                if (We.this.Ql != null) {
                    We.this.Ql.obtainMessage(Worker.WHAT_QUIT, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e.d
    public void sc(e eVar) {
        this.UFX = 209;
        FI.delete(this.uEA);
        FI fi2 = this.Ql;
        if (fi2 != null) {
            fi2.removeCallbacks(this.OXF);
        }
        for (WeakReference<q8.b.a> weakReference : this.cvk) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().sc(this);
            }
        }
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e.f
    public void sc(e eVar, int i11) {
        if (this.TRI != eVar) {
            return;
        }
        for (WeakReference<q8.b.a> weakReference : this.cvk) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().pFF(this, i11);
            }
        }
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e.InterfaceC0216e
    public void sc(e eVar, int i11, int i12, int i13, int i14) {
        for (WeakReference<q8.b.a> weakReference : this.cvk) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().sc((q8.b) this, i11, i12);
            }
        }
    }

    public void sc(final zY zYVar) {
        if (Qj()) {
            return;
        }
        this.II = zYVar;
        if (zYVar != null) {
            this.CYO = this.CYO && !zYVar.We();
        }
        pFF(new Runnable() { // from class: com.bykv.vk.openvk.sc.sc.pFF.We.We.5
            @Override // java.lang.Runnable
            public void run() {
                We.this.Dl();
                if (We.this.Ql != null) {
                    We.this.Ql.obtainMessage(107, zYVar).sendToTarget();
                }
            }
        });
    }

    public void sc(q8.b.a aVar) {
        if (aVar == null) {
            return;
        }
        for (WeakReference<q8.b.a> weakReference : this.cvk) {
            if (weakReference != null && weakReference.get() == aVar) {
                return;
            }
        }
        this.cvk.add(new WeakReference<>(aVar));
    }

    public void sc(final boolean z11) {
        if (Qj()) {
            return;
        }
        this.WP = z11;
        if (this.TRI != null) {
            this.TRI.sc(z11);
            return;
        }
        FI fi2 = this.Ql;
        if (fi2 != null) {
            fi2.post(new Runnable() { // from class: com.bykv.vk.openvk.sc.sc.pFF.We.We.9
                @Override // java.lang.Runnable
                public void run() {
                    if (We.this.TRI != null) {
                        We.this.TRI.sc(z11);
                    }
                }
            });
        }
    }

    public void sc(boolean z11, long j11, boolean z12) {
        if (Qj()) {
            return;
        }
        Dl();
        this.McK = z12;
        this.cD.set(true);
        this.kX = false;
        pFF(z12);
        if (z11) {
            this.Tf = j11;
            uEA();
        } else {
            pFF(j11);
        }
        FI fi2 = this.Ql;
        if (fi2 != null) {
            fi2.removeCallbacks(this.OXF);
            this.Ql.postDelayed(this.OXF, this.Gb);
        }
        this.HJN.countDown();
    }

    @Override // q8.b
    public boolean sc() {
        return this.ExN;
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e.g
    public boolean sc(e eVar, int i11, int i12) {
        WP();
        this.UFX = 200;
        FI fi2 = this.Ql;
        if (fi2 != null) {
            fi2.removeCallbacks(this.OXF);
        }
        if (sc(i11, i12)) {
            FI();
        }
        if (!this.cD.get()) {
            return true;
        }
        this.cD.set(false);
        x8.b bVar = new x8.b(i11, i12);
        for (WeakReference<q8.b.a> weakReference : this.cvk) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().sc(this, bVar);
            }
        }
        return true;
    }

    public SurfaceHolder wjp() {
        return this.pFF;
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e.b
    public void zY(e eVar) {
        for (WeakReference<q8.b.a> weakReference : this.cvk) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().sc((q8.b) this, true);
            }
        }
    }

    @Override // q8.b
    public boolean zY() {
        return Ql() || TRI() || qr();
    }
}
