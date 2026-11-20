package o8;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.bykv.vk.openvk.sc.sc.sc.zY.zY;
import com.bytedance.sdk.component.pFF.sc.BT;
import com.bytedance.sdk.component.pFF.sc.Ql;
import com.bytedance.sdk.component.pFF.sc.UFX;
import com.bytedance.sdk.component.pFF.sc.dE;
import com.bytedance.sdk.component.pFF.sc.pFF;
import com.cloud.tmc.miniapp.bridge.PermissionScopeBridge;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f72382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zY f72383b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public File f72385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public File f72386e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f72384c = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<r8.b.a> f72387f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f72388g = false;

    /* JADX INFO: renamed from: o8.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0778a implements com.bytedance.sdk.component.pFF.sc.zY {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f72389a;

        public C0778a(long j11) {
            this.f72389a = j11;
        }

        /* JADX WARN: Code duplicated, block: B:65:0x0159 A[Catch: all -> 0x015e, TryCatch #6 {all -> 0x015e, blocks: (B:63:0x014c, B:65:0x0159, B:68:0x0160), top: B:83:0x014c }] */
        @Override // com.bytedance.sdk.component.pFF.sc.zY
        public void sc(pFF pff, BT bt2) throws IOException {
            int iZY;
            InputStream inputStreamZY;
            RandomAccessFile randomAccessFile;
            dE dEVarTRI;
            long jSc;
            long j11 = this.f72389a;
            dE dEVar = null;
            dEVar = null;
            randomAccessFile = null;
            randomAccessFile = null;
            dEVar = null;
            RandomAccessFile randomAccessFile2 = null;
            if (bt2 != null) {
                try {
                    boolean zWe = bt2.We();
                    if (!zWe) {
                        a aVar = a.this;
                        aVar.l(aVar.f72383b, bt2.zY(), bt2.ExN());
                        a.this.m(null);
                        a.this.m(null);
                        a.this.m(dEVar);
                    }
                    dEVarTRI = bt2.TRI();
                    try {
                        dEVarTRI = bt2.TRI();
                        if (!zWe || dEVarTRI == null) {
                            inputStreamZY = null;
                            jSc = 0;
                        } else {
                            jSc = this.f72389a + dEVarTRI.sc();
                            inputStreamZY = dEVarTRI.zY();
                        }
                        try {
                            if (inputStreamZY == null) {
                                a aVar2 = a.this;
                                aVar2.l(aVar2.f72383b, bt2.zY(), bt2.ExN());
                            } else {
                                randomAccessFile = new RandomAccessFile(a.this.f72385d, "rw");
                                try {
                                    byte[] bArr = new byte[8192];
                                    long j12 = 0;
                                    while (true) {
                                        int i11 = 0;
                                        while (true) {
                                            int i12 = inputStreamZY.read(bArr, i11, 8192 - i11);
                                            if (i12 == -1) {
                                                if (a.this.f72383b.WH() && jSc == a.this.f72385d.length()) {
                                                    a.this.a();
                                                }
                                                a aVar3 = a.this;
                                                aVar3.k(aVar3.f72383b, bt2.zY());
                                                randomAccessFile2 = randomAccessFile;
                                            } else if (a.this.f72384c) {
                                                a aVar4 = a.this;
                                                aVar4.f(aVar4.f72383b, bt2.zY());
                                                a.this.m(randomAccessFile);
                                            } else {
                                                i11 += i12;
                                                j12 += (long) i12;
                                                if (j12 % PlaybackStateCompat.ACTION_PLAY_FROM_URI == 0 || j12 == jSc - this.f72389a) {
                                                    k8.a.c(randomAccessFile, bArr, Long.valueOf(j11).intValue(), i11, a.this.f72383b.SR());
                                                    j11 += (long) i11;
                                                }
                                            }
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    dEVar = dEVarTRI;
                                    iZY = PermissionScopeBridge.ERROR_CODE_SCOPE_NAME_IS_EMPTY;
                                    try {
                                        a.this.c();
                                        a aVar5 = a.this;
                                        zY zYVar = aVar5.f72383b;
                                        if (bt2 != null) {
                                            iZY = bt2.zY();
                                        }
                                        aVar5.l(zYVar, iZY, th.getMessage());
                                        a.this.m(randomAccessFile);
                                        a.this.m(inputStreamZY);
                                        a.this.m(dEVar);
                                    } finally {
                                        a.this.m(randomAccessFile);
                                        a.this.m(inputStreamZY);
                                        a.this.m(dEVar);
                                        a.this.m(bt2);
                                        a.this.f72383b.Ql();
                                        a.this.f72383b.zY();
                                        c.b(a.this.f72383b);
                                    }
                                }
                            }
                            a.this.m(randomAccessFile2);
                        } catch (Throwable th3) {
                            th = th3;
                            randomAccessFile = randomAccessFile2;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStreamZY = null;
                        randomAccessFile = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    inputStreamZY = null;
                    randomAccessFile = null;
                }
            } else {
                try {
                    a aVar6 = a.this;
                    zY zYVar2 = aVar6.f72383b;
                    iZY = PermissionScopeBridge.ERROR_CODE_SCOPE_NAME_IS_EMPTY;
                    try {
                        aVar6.l(zYVar2, PermissionScopeBridge.ERROR_CODE_SCOPE_NAME_IS_EMPTY, "Network link failed.");
                        dEVarTRI = null;
                        inputStreamZY = null;
                        a.this.m(randomAccessFile2);
                    } catch (Throwable th6) {
                        th = th6;
                        inputStreamZY = null;
                        randomAccessFile = null;
                        a.this.c();
                        a aVar7 = a.this;
                        zY zYVar3 = aVar7.f72383b;
                        if (bt2 != null) {
                            iZY = bt2.zY();
                        }
                        aVar7.l(zYVar3, iZY, th.getMessage());
                        a.this.m(randomAccessFile);
                        a.this.m(inputStreamZY);
                        a.this.m(dEVar);
                    }
                } catch (Throwable th7) {
                    th = th7;
                    iZY = PermissionScopeBridge.ERROR_CODE_SCOPE_NAME_IS_EMPTY;
                }
            }
            a.this.m(inputStreamZY);
            a.this.m(dEVarTRI);
        }

        @Override // com.bytedance.sdk.component.pFF.sc.zY
        public void sc(pFF pff, IOException iOException) {
            a aVar = a.this;
            aVar.l(aVar.f72383b, PermissionScopeBridge.ERROR_CODE_SCOPE_NAME_IS_EMPTY, iOException.getMessage());
            c.b(a.this.f72383b);
        }
    }

    public a(Context context, zY zYVar) {
        this.f72385d = null;
        this.f72386e = null;
        this.f72382a = context;
        this.f72383b = zYVar;
        this.f72385d = k8.a.a(zYVar.pFF(), zYVar.SR());
        this.f72386e = k8.a.d(zYVar.pFF(), zYVar.SR());
    }

    public final void a() {
        try {
            if (this.f72385d.renameTo(this.f72386e)) {
                return;
            }
            throw new IOException("Error renaming file " + this.f72385d + " to " + this.f72386e + " for completion!");
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    public final void c() {
        try {
            this.f72386e.delete();
            this.f72385d.delete();
        } catch (Throwable unused) {
        }
    }

    public final void f(zY zYVar, int i11) {
        synchronized (r8.b.a.class) {
            try {
                for (r8.b.a aVar : this.f72387f) {
                    if (aVar != null) {
                        aVar.pFF(zYVar, i11);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean h() {
        if (this.f72386e.exists()) {
            return true;
        }
        if (!this.f72383b.WH()) {
            if (this.f72385d.length() >= this.f72383b.zY()) {
                return true;
            }
            if (this.f72383b.sc() > 0 && this.f72385d.length() >= this.f72383b.sc()) {
                return true;
            }
        }
        return false;
    }

    public zY i() {
        return this.f72383b;
    }

    public final void k(zY zYVar, int i11) {
        synchronized (r8.b.a.class) {
            try {
                for (r8.b.a aVar : this.f72387f) {
                    if (aVar != null) {
                        aVar.sc(zYVar, i11);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void l(zY zYVar, int i11, String str) {
        synchronized (r8.b.a.class) {
            try {
                for (r8.b.a aVar : this.f72387f) {
                    if (aVar != null) {
                        aVar.sc(zYVar, i11, str);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void m(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public void q(r8.b.a aVar) {
        if (this.f72388g) {
            synchronized (r8.b.a.class) {
                this.f72387f.add(aVar);
            }
            return;
        }
        this.f72387f.add(aVar);
        if (h()) {
            this.f72383b.qr(1);
            k(this.f72383b, 200);
            c.b(this.f72383b);
        } else {
            this.f72388g = true;
            this.f72383b.qr(0);
            s();
        }
    }

    public void r(boolean z11) {
        this.f72384c = z11;
    }

    public final void s() {
        UFX.sc scVarPFF = q8.c.c() != null ? q8.c.c().pFF() : new UFX.sc("v_preload");
        long jDE = this.f72383b.dE();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        scVarPFF.sc(jDE, timeUnit).pFF(this.f72383b.Xc(), timeUnit).zY(this.f72383b.wjp(), timeUnit);
        UFX ufxSc = scVarPFF.sc();
        Ql.sc scVar = new Ql.sc();
        long length = this.f72385d.length();
        int iZY = this.f72383b.zY();
        boolean zWH = this.f72383b.WH();
        int iSc = this.f72383b.sc();
        if (iSc > 0) {
            if (iSc >= this.f72383b.Ol()) {
                zWH = true;
            } else {
                iZY = iSc;
            }
        }
        scVar.sc("videoPreload").sc(6);
        if (zWH) {
            scVar.sc("RANGE", "bytes=" + length + "-").pFF(this.f72383b.Ql()).sc().pFF();
        } else {
            scVar.sc("RANGE", "bytes=" + length + "-" + iZY).pFF(this.f72383b.Ql()).sc().pFF();
        }
        ufxSc.sc(scVar.pFF()).sc(new C0778a(length));
    }
}
