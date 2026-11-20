package com.bytedance.sdk.openadsdk.core.Ql.sc;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bykv.vk.openvk.sc.sc.sc.TRI.We;
import com.bytedance.sdk.component.utils.FI;
import com.bytedance.sdk.openadsdk.We.ExN.pFF.BT;
import com.bytedance.sdk.openadsdk.We.qr;
import com.bytedance.sdk.openadsdk.core.Ql.We.zY;
import com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN;
import com.bytedance.sdk.openadsdk.core.Tf.TRI;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import q8.b;
import t8.a;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class sc implements c, FI.sc, com.bytedance.sdk.openadsdk.core.Ql.pFF.sc {
    protected boolean Dl;
    protected SurfaceTexture ExN;
    protected boolean FI;
    protected long HJN;
    protected c.InterfaceC0849c II;
    protected pFF JPJ;
    protected TRI McK;

    @NonNull
    protected final Sfl Qj;
    protected zY TRI;

    @NonNull
    protected final Context UFX;
    protected final ViewGroup WP;
    protected SurfaceHolder We;
    private long cD;
    protected WeakReference<c.b> cvk;
    protected boolean dE;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected ExN f28179qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected String f28180sc = "TTAD.VideoController";
    protected final int pFF = 100;
    protected final FI zY = new FI(Looper.getMainLooper(), this);
    protected long Ol = 0;
    protected long WH = 0;
    protected final List<Runnable> Tf = new ArrayList();
    protected boolean Ql = false;
    protected boolean SR = false;
    protected boolean BT = true;
    protected boolean Xc = false;
    protected boolean wjp = false;
    protected boolean Sfl = false;
    protected AtomicBoolean YIK = new AtomicBoolean(false);
    protected boolean uEA = true;
    protected Runnable Gb = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.sc.sc.1
        @Override // java.lang.Runnable
        public void run() {
            boolean z11 = sc.this.Ql;
            sc.this.Dl();
        }
    };
    private long Cb = 0;
    private boolean OXF = true;
    private int cJ = 1;
    private final AtomicBoolean kX = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.Ql.sc.sc$4, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final /* synthetic */ int[] f28184sc;

        static {
            int[] iArr = new int[com.bytedance.sdk.openadsdk.core.widget.Sfl.sc.values().length];
            f28184sc = iArr;
            try {
                iArr[com.bytedance.sdk.openadsdk.core.widget.Sfl.sc.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28184sc[com.bytedance.sdk.openadsdk.core.widget.Sfl.sc.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28184sc[com.bytedance.sdk.openadsdk.core.widget.Sfl.sc.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public sc(Context context, @NonNull Sfl sfl, ViewGroup viewGroup) {
        this.Qj = sfl;
        this.UFX = context;
        this.WP = viewGroup;
        this.f28180sc += hashCode();
    }

    private void Cb() {
        ExN exN = this.f28179qr;
        if (exN != null) {
            exN.We(0);
            this.f28179qr.sc(false, false);
            this.f28179qr.zY(false);
            this.f28179qr.ExN();
            this.f28179qr.qr();
        }
    }

    private void sc(long j11, boolean z11) {
        if (this.TRI == null) {
            return;
        }
        if (z11) {
            Cb();
        }
        this.TRI.sc(j11);
    }

    private boolean wjp() {
        ExN exN = this.f28179qr;
        if (exN != null) {
            return exN.Ql() instanceof We;
        }
        return false;
    }

    private boolean zY(int i11) {
        return this.f28179qr.pFF(i11);
    }

    @Override // t8.c
    public boolean BT() {
        return this.SR;
    }

    public void Dl() {
        this.zY.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.sc.sc.2
            @Override // java.lang.Runnable
            public void run() {
                sc scVar = sc.this;
                if (scVar.TRI != null) {
                    boolean z11 = scVar.Ql;
                    sc.this.TRI.WH();
                }
            }
        });
    }

    @Override // t8.c
    public long ExN() {
        return this.Ol;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.sc, t8.b
    public final void ExN(a aVar, View view) {
        sc(aVar, view, false);
    }

    @Override // t8.c
    public void ExN(boolean z11) {
        this.uEA = z11;
    }

    public boolean FI() {
        return this.OXF;
    }

    public int Gb() {
        return this.cJ;
    }

    public final void HJN() {
        com.bytedance.sdk.openadsdk.We.ExN.sc.sc.sc(this.Qj, this.f28179qr, this.JPJ);
    }

    public final void II() {
        BT.sc scVar = new BT.sc();
        scVar.sc(ExN());
        scVar.zY(Qj() / ((long) Gb()));
        scVar.pFF(TRI());
        com.bytedance.sdk.openadsdk.We.ExN.sc.sc.pFF(Ql(), scVar);
    }

    public boolean JPJ() {
        return this.BT;
    }

    public final void McK() {
        BT.sc scVar = new BT.sc();
        scVar.sc(ExN());
        scVar.zY(Qj() / ((long) Gb()));
        scVar.pFF(TRI());
        com.bytedance.sdk.openadsdk.We.ExN.sc.sc.sc(this.f28179qr, scVar);
    }

    @Override // t8.c
    public final long Ol() {
        return ExN() + TRI();
    }

    @Override // t8.c
    public final long Qj() {
        zY zYVar = this.TRI;
        if (zYVar == null) {
            return 0L;
        }
        return zYVar.dE();
    }

    @Override // t8.c
    public boolean SR() {
        return this.dE;
    }

    public void Sfl() {
        if (this.TRI == null) {
            return;
        }
        if (wjp()) {
            SurfaceTexture surfaceTexture = this.ExN;
            if (surfaceTexture == null || surfaceTexture == this.TRI.Sfl()) {
                return;
            }
            this.TRI.sc(this.ExN);
            return;
        }
        SurfaceHolder surfaceHolder = this.We;
        if (surfaceHolder == null || surfaceHolder == this.TRI.wjp()) {
            return;
        }
        this.TRI.sc(this.We);
    }

    @Override // t8.c
    public final long TRI() {
        zY zYVar = this.TRI;
        if (zYVar == null) {
            return 0L;
        }
        return zYVar.SR();
    }

    public void TRI(boolean z11) {
        this.Sfl = z11;
    }

    @Override // t8.c
    public b Tf() {
        return this.TRI;
    }

    @Override // t8.c
    public boolean UFX() {
        return this.Xc;
    }

    @Override // t8.c
    public final int WH() {
        return k8.b.a(this.WH, this.HJN);
    }

    public final boolean WP() {
        zY zYVar = this.TRI;
        return zYVar == null || zYVar.pFF();
    }

    @Override // t8.c
    public abstract /* synthetic */ void We();

    public final void We(long j11) {
        this.Ol = j11;
        this.WH = Math.max(this.WH, j11);
        ExN exN = this.f28179qr;
        if (exN != null) {
            exN.sc();
        }
        zY zYVar = this.TRI;
        if (zYVar != null) {
            zYVar.sc(true, this.Ol, this.dE);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.sc
    public final void We(a aVar, View view) {
        if (!this.Sfl) {
            sc(true, 3);
            return;
        }
        TRI(false);
        ExN exN = this.f28179qr;
        if (exN != null) {
            exN.pFF(this.WP);
        }
        sc(1);
    }

    @Override // t8.c
    public final void We(boolean z11) {
        this.OXF = z11;
    }

    @Override // t8.c
    public boolean Xc() {
        return true;
    }

    public void YIK() {
        if (this.Tf.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.Tf).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.Tf.clear();
    }

    public final void cD() {
        com.bytedance.sdk.openadsdk.We.sc.We.sc(com.bytedance.sdk.openadsdk.JPJ.sc.sc(this.Qj.Bs(), true, this.Qj), 5, this.Qj.kDg());
    }

    public final boolean cvk() {
        zY zYVar = this.TRI;
        return zYVar != null && zYVar.TRI();
    }

    @Override // t8.c
    public final boolean dE() {
        return this.FI;
    }

    @Override // t8.c
    public abstract /* synthetic */ void pFF();

    public void pFF(int i11) {
        this.cJ = i11;
    }

    @Override // t8.c
    public void pFF(long j11) {
        this.Cb = j11;
    }

    @Override // t8.c
    public void pFF(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar) {
        pFF pff = (pFF) zYVar;
        this.JPJ = pff;
        this.dE = pff.Qj();
        zYVar.We(String.valueOf(this.Qj.QT()));
    }

    public final void pFF(qr qrVar) {
        BT.sc scVar = new BT.sc();
        scVar.sc(ExN());
        scVar.zY(Qj() / ((long) Gb()));
        scVar.pFF(TRI());
        scVar.We(qr());
        com.bytedance.sdk.openadsdk.We.ExN.sc.sc.pFF(this.f28179qr, scVar, qrVar);
    }

    public void pFF(Runnable runnable) {
        this.Tf.add(runnable);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.sc
    public final void pFF(a aVar, int i11) {
        ExN exN = this.f28179qr;
        if (exN != null) {
            exN.TRI();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.sc
    public void pFF(a aVar, SurfaceTexture surfaceTexture) {
        this.Ql = false;
        zY zYVar = this.TRI;
        if (zYVar != null) {
            zYVar.sc(false);
        }
        this.ExN = null;
        YIK();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.sc
    public void pFF(a aVar, SurfaceHolder surfaceHolder) {
        this.Ql = false;
        this.We = null;
        zY zYVar = this.TRI;
        if (zYVar != null) {
            zYVar.sc(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.sc
    public final void pFF(a aVar, View view) {
        pFF(aVar, view, false, false);
    }

    public final void pFF(a aVar, View view, boolean z11, boolean z12) {
        TRI(!this.Sfl);
        Context context = this.UFX;
        if (context != null && (context instanceof Activity)) {
            if (this.Sfl) {
                sc(z11 ? 8 : 0);
                ExN exN = this.f28179qr;
                if (exN != null) {
                    exN.sc(this.WP);
                    this.f28179qr.zY(false);
                }
            } else {
                sc(1);
                ExN exN2 = this.f28179qr;
                if (exN2 != null) {
                    exN2.pFF(this.WP);
                    this.f28179qr.zY(false);
                }
            }
            WeakReference<c.b> weakReference = this.cvk;
            c.b bVar = weakReference != null ? weakReference.get() : null;
            if (bVar != null) {
                bVar.sc(this.Sfl);
            }
        }
    }

    @Override // t8.c
    public final void pFF(final boolean z11) {
        this.dE = z11;
        zY zYVar = this.TRI;
        if (zYVar != null) {
            zYVar.pFF(z11);
            com.bytedance.sdk.openadsdk.We.ExN.sc.sc.sc(this.f28179qr, z11);
        }
        if (this.McK != null) {
            if (p8.a.e()) {
                this.McK.sc(z11);
            } else {
                this.zY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.sc.sc.3
                    @Override // java.lang.Runnable
                    public void run() {
                        sc.this.McK.sc(z11);
                    }
                });
            }
        }
    }

    @Override // t8.c
    public final int qr() {
        zY zYVar = this.TRI;
        if (zYVar == null) {
            return 0;
        }
        return zYVar.BT();
    }

    @Override // t8.c
    public final void sc() {
        zY zYVar = this.TRI;
        if (zYVar != null) {
            zYVar.UFX();
        }
        if (this.Dl || !this.YIK.get()) {
            return;
        }
        McK();
    }

    public final void sc(int i11) {
        Context context = this.UFX;
        if (context == null) {
            return;
        }
        boolean z11 = i11 == 0 || i11 == 8;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            try {
                activity.setRequestedOrientation(i11);
            } catch (Throwable unused) {
            }
            if (z11) {
                activity.getWindow().clearFlags(1024);
            } else {
                activity.getWindow().setFlags(1024, 1024);
            }
        }
    }

    @Override // t8.c
    public void sc(long j11) {
        this.Ol = j11;
        this.WH = Math.max(this.WH, j11);
    }

    public void sc(long j11, long j12) {
        if (!this.kX.get() && com.bytedance.sdk.openadsdk.TRI.sc.sc().zY() && (j11 * 1.0d) / j12 > 0.3d) {
            this.kX.set(true);
            if (this.Qj != null) {
                com.bytedance.sdk.openadsdk.TRI.pFF.sc().sc("videoPercent30", this.Qj);
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.FI.sc
    public void sc(Message message) {
    }

    public final void sc(qr qrVar) {
        if (this.YIK.compareAndSet(false, true)) {
            TRI tri = this.McK;
            if (tri != null) {
                tri.sc(Qj(), SR());
            }
            BT.sc scVar = new BT.sc();
            scVar.sc(FI());
            scVar.zY(Qj());
            com.bytedance.sdk.openadsdk.We.ExN.sc.sc.sc(Xc.sc(), this.f28179qr, scVar, qrVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.sc
    public final void sc(com.bytedance.sdk.openadsdk.core.widget.Sfl.sc scVar, String str) {
        int i11 = AnonymousClass4.f28184sc[scVar.ordinal()];
        if (i11 == 1) {
            sc();
            return;
        }
        if (i11 == 2) {
            zY();
        } else {
            if (i11 != 3) {
                return;
            }
            pFF();
            this.Xc = false;
            this.wjp = true;
        }
    }

    public void sc(Runnable runnable) {
        if (this.f28179qr.uEA() && this.Ql) {
            runnable.run();
        } else {
            pFF(runnable);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.sc
    public final void sc(a aVar, int i11) {
        if (this.TRI == null) {
            return;
        }
        sc(this.cD, zY(i11));
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.sc
    public final void sc(a aVar, int i11, boolean z11) {
        if (this.UFX == null) {
            return;
        }
        long j11 = this.HJN;
        long j12 = (long) (((((long) i11) * j11) * 1.0f) / 100.0f);
        if (j11 > 0) {
            this.cD = (int) j12;
        } else {
            this.cD = 0L;
        }
        ExN exN = this.f28179qr;
        if (exN != null) {
            exN.sc(this.cD);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.sc
    public void sc(a aVar, SurfaceTexture surfaceTexture) {
        this.Ql = true;
        this.ExN = surfaceTexture;
        zY zYVar = this.TRI;
        if (zYVar != null) {
            zYVar.sc(surfaceTexture);
            this.TRI.sc(this.Ql);
        }
        YIK();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.sc
    public void sc(a aVar, SurfaceHolder surfaceHolder) {
        this.Ql = true;
        this.We = surfaceHolder;
        zY zYVar = this.TRI;
        if (zYVar == null) {
            return;
        }
        zYVar.sc(surfaceHolder);
        YIK();
    }

    public abstract /* synthetic */ void sc(a aVar, View view);

    public void sc(a aVar, View view, boolean z11) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.sc
    public final void sc(a aVar, View view, boolean z11, boolean z12) {
        if (this.BT) {
            sc();
        }
        if (z11 && !this.BT && !WP()) {
            this.f28179qr.pFF(!cvk(), false);
            this.f28179qr.sc(z12, true, false);
        }
        zY zYVar = this.TRI;
        if (zYVar == null || !zYVar.TRI()) {
            this.f28179qr.TRI();
        } else {
            this.f28179qr.TRI();
            this.f28179qr.ExN();
        }
    }

    @Override // t8.c
    public void sc(c.a aVar) {
    }

    @Override // t8.c
    public final void sc(c.b bVar) {
        this.cvk = new WeakReference<>(bVar);
    }

    @Override // t8.c
    public final void sc(c.InterfaceC0849c interfaceC0849c) {
        this.II = interfaceC0849c;
    }

    public final void sc(x8.b bVar) {
        BT.sc scVar = new BT.sc();
        scVar.pFF(TRI());
        scVar.zY(Qj() / ((long) Gb()));
        scVar.sc(ExN());
        scVar.sc(bVar);
        com.bytedance.sdk.openadsdk.We.ExN.sc.sc.zY(Ql(), scVar);
    }

    @Override // t8.c
    public void sc(boolean z11) {
        this.BT = z11;
        ExN exN = this.f28179qr;
        if (exN != null) {
            exN.We(z11);
        }
    }

    @Override // t8.c
    public abstract /* synthetic */ void sc(boolean z11, int i11);

    @Override // t8.c
    public abstract /* synthetic */ boolean sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar);

    @Override // t8.c
    /* JADX INFO: renamed from: uEA, reason: merged with bridge method [inline-methods] */
    public final ExN Ql() {
        return this.f28179qr;
    }

    @Override // t8.c
    public abstract /* synthetic */ void zY();

    @Override // t8.c
    public void zY(long j11) {
        this.HJN = j11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.sc
    public final void zY(a aVar, View view) {
        ExN exN = this.f28179qr;
        if (exN != null) {
            exN.Ol();
        }
        sc(true, 3);
    }

    @Override // t8.c
    public final void zY(boolean z11) {
        this.SR = z11;
    }
}
