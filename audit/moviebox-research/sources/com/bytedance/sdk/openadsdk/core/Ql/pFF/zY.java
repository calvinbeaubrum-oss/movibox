package com.bytedance.sdk.openadsdk.core.Ql.pFF;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.sc.sc.sc.TRI.a;
import com.bytedance.sdk.component.utils.BT;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.component.utils.uEA;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.Ql.Ql;
import com.bytedance.sdk.openadsdk.Ql.SR;
import com.bytedance.sdk.openadsdk.We.qr;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.Qj.JPJ;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import q8.b;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY extends com.bytedance.sdk.openadsdk.core.Ql.sc.sc {
    private final boolean BR;
    private WeakReference<c.a> CYO;
    private long Cb;
    private int GI;
    private boolean JoC;
    private qr MxZ;
    private int OKY;
    private final boolean OXF;
    private pFF QLv;
    private final Runnable Yhz;
    private long cD;
    private final String cJ;

    /* JADX INFO: renamed from: eo, reason: collision with root package name */
    private final b.a f28160eo;
    private final boolean kX;

    /* JADX INFO: renamed from: ko, reason: collision with root package name */
    private boolean f28161ko;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    private int f28162pc;
    private WeakReference<sc> qKn;
    private final uEA.sc qfG;
    private int yL;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void TRI();

        void sc(int i11);
    }

    public zY(Context context, ViewGroup viewGroup, Sfl sfl, String str, boolean z11, boolean z12, boolean z13, qr qrVar) {
        super(context, sfl, viewGroup);
        this.cD = 0L;
        this.Cb = 0L;
        this.JoC = true;
        this.f28162pc = 0;
        this.GI = 0;
        this.f28160eo = new b.a() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.zY.1
            @Override // q8.b.a
            public void ExN(b bVar) {
                com.bytedance.sdk.openadsdk.core.Tf.sc scVarGOt = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Qj.GOt();
                if (scVarGOt != null && scVarGOt.sc() != null) {
                    scVarGOt.sc().zY(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Ol);
                }
                if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).McK != null) {
                    ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).McK.sc(1);
                }
            }

            @Override // q8.b.a
            public void We(b bVar) {
                com.bytedance.sdk.openadsdk.core.Tf.sc scVarGOt = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Qj.GOt();
                if (scVarGOt != null && scVarGOt.sc() != null) {
                    scVarGOt.sc().pFF(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Ol);
                }
                com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Qj, 3);
                if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).McK != null) {
                    ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).McK.sc(0);
                }
            }

            @Override // q8.b.a
            public void pFF(b bVar) {
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).zY.removeCallbacks(zY.this.Yhz);
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).zY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.zY.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (zY.this.CYO != null && zY.this.CYO.get() != null) {
                            zY.this.CYO.get();
                        }
                        if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28179qr != null) {
                            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28179qr.pFF();
                        }
                    }
                });
                if (zY.this.OXF) {
                    return;
                }
                zY zYVar = zY.this;
                zYVar.sc(zYVar.MxZ);
            }

            @Override // q8.b.a
            public void pFF(b bVar, int i11) {
            }

            @Override // q8.b.a
            public void sc(b bVar) {
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).zY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.zY.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Qj, 5);
                            com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Qj, 5);
                            if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).McK != null) {
                                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).McK.sc(9);
                            }
                        } catch (Exception unused) {
                        }
                        zY.this.cJ();
                    }
                });
                if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Qj.GOt() == null || ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Qj.GOt().sc() == null) {
                    return;
                }
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Qj.GOt().sc().We(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Ol);
            }

            @Override // q8.b.a
            public void sc(b bVar, int i11) {
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).FI = false;
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).zY.removeCallbacks(zY.this.Yhz);
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).zY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.zY.1.8
                    @Override // java.lang.Runnable
                    public void run() {
                        ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28179qr.pFF();
                    }
                });
                com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Qj, 0);
                if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).McK != null) {
                    ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).McK.sc(5);
                }
            }

            @Override // q8.b.a
            public void sc(b bVar, int i11, int i12) {
                com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.zY.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        zY.this.BR();
                    }
                });
            }

            @Override // q8.b.a
            public void sc(b bVar, int i11, int i12, int i13) {
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).FI = true;
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).zY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.zY.1.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28179qr != null) {
                            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28179qr.Xc();
                            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).zY.postDelayed(zY.this.Yhz, 8000L);
                        }
                    }
                });
                com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Qj, 2);
                if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).McK != null) {
                    ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).McK.sc(4);
                }
            }

            @Override // q8.b.a
            public void sc(b bVar, long j11) {
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).FI = false;
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).zY.removeCallbacks(zY.this.Yhz);
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).zY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.zY.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28179qr != null) {
                            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28179qr.pFF();
                        }
                        if (!((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).BT || zY.this.qKn == null || zY.this.qKn.get() == null) {
                            return;
                        }
                        ((sc) zY.this.qKn.get()).TRI();
                    }
                });
                zY.this.cD();
                com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Qj, 0);
                if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).McK != null) {
                    ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).McK.zY();
                }
                zY zYVar = zY.this;
                zYVar.sc(zYVar.MxZ);
            }

            @Override // q8.b.a
            public void sc(b bVar, final long j11, final long j12) {
                if (Math.abs(j11 - ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Ol) < 50) {
                    return;
                }
                zY zYVar = zY.this;
                zYVar.sc(zYVar.MxZ);
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).zY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.zY.1.9
                    @Override // java.lang.Runnable
                    public void run() {
                        zY.this.sc(j11, j12);
                        zY.this.pFF(j11, j12);
                    }
                });
            }

            @Override // q8.b.a
            public void sc(b bVar, final x8.b bVar2) {
                Tf.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28180sc, "onError: " + bVar2.b() + ", " + bVar2.a() + ", " + bVar2.d());
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).zY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.zY.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        int iB = bVar2.b();
                        int iA = bVar2.a();
                        if (!zY.this.cvk() || iA == -1004) {
                            if (zY.this.zY(iB, iA)) {
                                Tf.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28180sc, "Play video error，show result page、、、、、、、");
                                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28179qr.sc2(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Qj, (WeakReference<Context>) null, false);
                                zY.this.zY(true);
                                zY.this.We();
                            }
                            if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28179qr != null) {
                                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28179qr.pFF();
                            }
                            if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).II != null) {
                                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).II.pFF(zY.this.Cb, k8.b.a(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Ol, ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).HJN));
                            }
                            if (zY.this.CYO == null || zY.this.CYO.get() == null || zY.this.cvk()) {
                                return;
                            }
                            ((c.a) zY.this.CYO.get()).sc(iB, iA);
                        }
                    }
                });
                zY.this.sc(bVar2);
                com.bytedance.sdk.openadsdk.core.Tf.sc scVarGOt = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Qj.GOt();
                if (scVarGOt != null && scVarGOt.sc() != null) {
                    scVarGOt.sc().sc(com.bytedance.sdk.openadsdk.core.Tf.sc.sc.GENERAL_LINEAR_AD_ERROR);
                }
                com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Qj, 6);
                com.bytedance.sdk.openadsdk.JPJ.sc.zY.pFF(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Qj);
                if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).McK != null) {
                    ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).McK.sc(14);
                }
            }

            @Override // q8.b.a
            public void sc(b bVar, boolean z14) {
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).zY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.zY.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28179qr != null) {
                            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28179qr.pFF();
                        }
                    }
                });
            }

            @Override // q8.b.a
            public void zY(b bVar) {
            }
        };
        this.yL = 0;
        this.Yhz = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.zY.4
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28179qr != null) {
                    ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28179qr.sc2(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Qj, (WeakReference<Context>) null, false);
                    ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28179qr.pFF();
                    zY.this.zY(true);
                    Tf.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28180sc, "Show result page after error.......showAdCard");
                }
            }
        };
        this.qfG = new uEA.sc() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.zY.6
            @Override // com.bytedance.sdk.component.utils.uEA.sc
            public void sc(Context context2, Intent intent, boolean z14, final int i11) {
                Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.zY.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        zY.this.ExN(i11);
                    }
                });
            }
        };
        this.f28161ko = false;
        this.OKY = BT.zY(context);
        sc(z11);
        this.cJ = str;
        try {
            this.f28162pc = viewGroup.getWidth();
            this.GI = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        sc(context);
        this.OXF = true;
        this.kX = z12;
        this.BR = z13;
        if (qrVar != null) {
            this.MxZ = qrVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BR() {
        com.bytedance.sdk.openadsdk.core.Ql.We.zY zYVar;
        int i11;
        int i12;
        try {
            if (JoC() != null && (zYVar = this.TRI) != null && this.WP != null) {
                int iWe = zYVar.We();
                int iExN = this.TRI.ExN();
                final int width = this.WP.getWidth();
                final int height = this.WP.getHeight();
                if (width > 0 && height > 0 && iExN > 0 && iWe > 0) {
                    if (iWe == iExN) {
                        i12 = width > height ? height : width;
                        i11 = i12;
                    } else if (iWe > iExN) {
                        i12 = (int) ((((double) width) * 1.0d) / ((double) ((iWe * 1.0f) / iExN)));
                        i11 = width;
                    } else {
                        i11 = (int) ((((double) height) * 1.0d) / ((double) ((iExN * 1.0f) / iWe)));
                        i12 = height;
                    }
                    if (i12 <= height && i12 > 0) {
                        height = i12;
                    }
                    if (i11 <= width && i11 > 0) {
                        width = i11;
                    }
                    this.zY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.zY.5
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
                                layoutParams.addRule(13);
                                if (zY.this.JoC() instanceof TextureView) {
                                    ((TextureView) zY.this.JoC()).setLayoutParams(layoutParams);
                                    String unused = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28180sc;
                                } else if (zY.this.JoC() instanceof SurfaceView) {
                                    ((SurfaceView) zY.this.JoC()).setLayoutParams(layoutParams);
                                    String unused2 = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28180sc;
                                }
                            } catch (Throwable unused3) {
                                String unused4 = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28180sc;
                            }
                        }
                    });
                    return;
                }
                return;
            }
            Objects.toString(this.UFX);
            Objects.toString(JoC());
        } catch (Throwable th2) {
            th2.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ExN(int i11) {
        We(i11);
        if (i11 == 4) {
            this.Xc = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a JoC() {
        ExN exN;
        if (this.UFX.getResources().getConfiguration().orientation != 1 || (exN = this.f28179qr) == null) {
            return null;
        }
        return exN.Ql();
    }

    private void We(int i11) {
        if (this.OKY == i11) {
            return;
        }
        this.OKY = i11;
        if (i11 != 4 && i11 != 0) {
            this.wjp = false;
        }
        if (!this.wjp && !BT() && this.kX) {
            pFF(2, i11);
        }
        WeakReference<sc> weakReference = this.qKn;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.qKn.get().sc(this.OKY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJ() {
        this.yL++;
        ExN exN = this.f28179qr;
        if (exN == null) {
            return;
        }
        exN.pFF();
        c.InterfaceC0849c interfaceC0849c = this.II;
        if (interfaceC0849c != null) {
            interfaceC0849c.sc(this.Cb, k8.b.a(this.Ol, this.HJN));
        }
        this.Cb = System.currentTimeMillis() - this.cD;
        if (this.JoC) {
            this.f28179qr.sc2(this.Qj, (WeakReference<Context>) null, true);
        }
        if (!this.Dl) {
            this.Dl = true;
            long j11 = this.HJN;
            pFF(j11, j11);
            long j12 = this.HJN;
            this.Ol = j12;
            this.WH = j12;
            pFF(this.MxZ);
        }
        if (!this.BT && this.Sfl) {
            ExN(this.f28179qr, null);
        }
        this.SR = true;
    }

    private void kX() {
        com.bytedance.sdk.openadsdk.core.Ql.We.zY zYVar = this.TRI;
        if (zYVar != null) {
            if (!zYVar.qr()) {
                this.TRI.sc(false, this.Ol, this.dE);
            } else if (this.Ql) {
                Dl();
            } else {
                pFF(this.Gb);
            }
        }
        if (this.YIK.get()) {
            II();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(long j11, long j12) {
        this.Qj.zY(j11);
        this.Ol = j11;
        this.HJN = j12;
        this.f28179qr.sc(j11, j12);
        this.f28179qr.sc(k8.b.a(j11, j12));
        try {
            c.InterfaceC0849c interfaceC0849c = this.II;
            if (interfaceC0849c != null) {
                interfaceC0849c.sc(j11, j12);
            }
        } catch (Throwable th2) {
            Tf.sc(this.f28180sc, "onProgressUpdate error: ", th2);
        }
        com.bytedance.sdk.openadsdk.core.Tf.sc scVarGOt = this.Qj.GOt();
        if (scVarGOt == null || scVarGOt.sc() == null) {
            return;
        }
        scVarGOt.sc().sc(j11, j12, this.McK);
    }

    private boolean pFF(int i11, int i12) {
        if (i12 == 0) {
            sc();
            this.Xc = true;
            ExN exN = this.f28179qr;
            if (exN != null) {
                exN.sc2(this.Qj, (WeakReference<Context>) null, false);
            }
        }
        if (i12 != 4 && i12 != 0) {
            ExN exN2 = this.f28179qr;
            if (exN2 != null) {
                exN2.sc();
            }
            sc();
            this.Xc = true;
            this.wjp = false;
            ExN exN3 = this.f28179qr;
            if (exN3 != null) {
                return exN3.sc(i11, this.Qj.GI(), this.BR);
            }
        } else if (i12 == 4) {
            this.Xc = false;
            ExN exN4 = this.f28179qr;
            if (exN4 != null) {
                exN4.BT();
            }
        }
        return true;
    }

    private void sc(Context context) {
        ViewGroup sr2 = this.BT ? new SR(context) : new Ql(context);
        if (this.BT) {
            this.f28179qr = new ExN(context, sr2, true, 17, this.Qj, this, JPJ());
        } else {
            this.f28179qr = new We(context, sr2, true, 17, this.Qj, this, false);
        }
        this.f28179qr.sc(this);
    }

    private void zY(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar) {
        zYVar.zY(0);
        this.TRI.sc(zYVar);
        this.cD = System.currentTimeMillis();
        this.f28179qr.zY(8);
        this.f28179qr.zY(0);
        sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.zY.3
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).TRI == null) {
                    return;
                }
                zY.this.cD = System.currentTimeMillis();
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).f28179qr.We(0);
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).TRI.sc(true, ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).Ol, ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) zY.this).dE);
            }
        });
        if (this.BT) {
            wjp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zY(int i11, int i12) {
        boolean z11 = i11 == -1010 || i11 == -1007 || i11 == -1004 || i11 == -110 || i11 == 100 || i11 == 200;
        if (i12 == 1 || i12 == 700 || i12 == 800) {
            return true;
        }
        return z11;
    }

    public void Cb() {
        if (this.f28161ko && this.uEA) {
            this.f28161ko = false;
            uEA.sc(this.qfG);
        }
    }

    public void OXF() {
        com.bytedance.sdk.openadsdk.core.Tf.TRI tri = this.McK;
        if (tri != null) {
            tri.sc(13);
        }
    }

    public void Qj(boolean z11) {
        ExN exN = this.f28179qr;
        if (exN != null) {
            exN.sc();
        }
        ExN exN2 = this.f28179qr;
        if (exN2 != null && z11) {
            exN2.wjp();
        }
        kX();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.sc.sc, t8.c
    public void We() {
        com.bytedance.sdk.openadsdk.core.Ql.We.zY zYVar = this.TRI;
        if (zYVar != null) {
            zYVar.Tf();
            this.TRI = null;
        }
        if (this.JoC) {
            if ("embeded_ad".equals(this.cJ)) {
                this.f28179qr.YIK();
            } else {
                this.f28179qr.sc2(this.Qj, (WeakReference<Context>) null, true);
            }
            this.zY.removeCallbacksAndMessages(null);
            this.Tf.clear();
            if (this.BT) {
                Cb();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.sc.sc, t8.c
    public void pFF() {
        ExN exN = this.f28179qr;
        if (exN != null) {
            exN.sc();
        }
        ExN exN2 = this.f28179qr;
        if (exN2 != null) {
            exN2.wjp();
        }
        kX();
    }

    public void qr(boolean z11) {
        this.JoC = z11;
    }

    public com.bytedance.sdk.openadsdk.core.Tf.TRI sc(View view, List<Pair<View, FriendlyObstructionPurpose>> list) {
        if (!this.Qj.ymG()) {
            return null;
        }
        if (this.McK == null) {
            this.McK = com.bytedance.sdk.openadsdk.core.Tf.TRI.sc();
        }
        this.McK.sc(view, this.Qj.GOt().SR());
        if (list != null && list.size() > 0) {
            for (Pair<View, FriendlyObstructionPurpose> pair : list) {
                if (pair != null) {
                    Object obj = pair.second;
                    this.McK.sc((View) pair.first, obj == null ? FriendlyObstructionPurpose.OTHER : (FriendlyObstructionPurpose) obj);
                }
            }
        }
        return this.McK;
    }

    public void sc(int i11, int i12) {
        if (i11 == 0 || i12 == 0) {
            return;
        }
        this.f28162pc = i11;
        this.GI = i12;
    }

    public void sc(PAGNativeAd pAGNativeAd) {
        ExN exN;
        if (!this.BT || (exN = this.f28179qr) == null) {
            return;
        }
        exN.sc(pAGNativeAd);
    }

    public void sc(final TRI.sc scVar) {
        ExN exN;
        if (!this.BT || (exN = this.f28179qr) == null) {
            return;
        }
        exN.sc(new TRI.sc() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.zY.2
            @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI.sc
            public void sc(View view, int i11) {
                TRI.sc scVar2 = scVar;
                if (scVar2 != null) {
                    scVar2.sc(view, i11);
                }
            }
        });
    }

    public void sc(pFF pff) {
        this.QLv = pff;
    }

    public void sc(sc scVar) {
        this.qKn = new WeakReference<>(scVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.sc.sc, com.bytedance.sdk.openadsdk.core.Ql.pFF.sc
    public void sc(t8.a aVar, View view) {
        com.bytedance.sdk.openadsdk.core.Ql.We.zY zYVar = this.TRI;
        if (zYVar == null) {
            return;
        }
        if (zYVar.TRI()) {
            sc();
            this.f28179qr.pFF(true, false);
            this.f28179qr.TRI();
            return;
        }
        if (this.TRI.qr()) {
            Qj(false);
            ExN exN = this.f28179qr;
            if (exN != null) {
                exN.pFF(false, false);
                return;
            }
            return;
        }
        ExN exN2 = this.f28179qr;
        if (exN2 != null) {
            exN2.zY(this.WP);
        }
        We(this.Ol);
        ExN exN3 = this.f28179qr;
        if (exN3 != null) {
            exN3.pFF(false, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.sc.sc
    public void sc(t8.a aVar, View view, boolean z11) {
        TRI(!this.Sfl);
        if (this.UFX instanceof Activity) {
            ExN exN = this.f28179qr;
            if (exN != null) {
                exN.pFF(this.WP);
                this.f28179qr.zY(false);
            }
            sc(1);
            WeakReference<c.b> weakReference = this.cvk;
            c.b bVar = weakReference != null ? weakReference.get() : null;
            if (bVar != null) {
                bVar.sc(this.Sfl);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.sc.sc, t8.c
    public void sc(c.a aVar) {
        this.CYO = new WeakReference<>(aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.sc.sc, t8.c
    public void sc(boolean z11, int i11) {
        if (!this.Dl && this.YIK.get()) {
            if (z11) {
                com.bytedance.sdk.openadsdk.We.ExN.pFF.BT.sc scVar = new com.bytedance.sdk.openadsdk.We.ExN.pFF.BT.sc();
                scVar.sc(ExN());
                scVar.zY(Qj());
                scVar.pFF(TRI());
                scVar.zY(i11);
                scVar.We(qr());
                com.bytedance.sdk.openadsdk.We.ExN.sc.sc.sc(this.f28179qr, scVar, this.MxZ);
                this.Dl = false;
            } else {
                McK();
            }
        }
        We();
        com.bytedance.sdk.openadsdk.core.Tf.TRI tri = this.McK;
        if (tri != null) {
            tri.We();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.sc.sc, t8.c
    public boolean sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar) {
        if (this.TRI != null) {
            ApmHelper.reportCustomError("", "twice playVideoUrl", new IllegalStateException());
            return true;
        }
        if (TextUtils.isEmpty(zYVar.Ql())) {
            Tf.sc(this.f28180sc, "[video] play video stop , because no video info");
            return false;
        }
        zY(false);
        zYVar.Ql();
        pFF(zYVar);
        HJN();
        com.bytedance.sdk.openadsdk.core.Tf.TRI tri = this.McK;
        if (tri != null) {
            tri.sc(false, 0.0f);
        }
        if (!JPJ.pFF(this.cJ) || this.Ol <= 0) {
            this.Ol = zYVar.qr();
        }
        if (zYVar.qr() <= 0) {
            this.Dl = false;
            this.YIK.set(false);
        } else {
            long jQr = zYVar.qr();
            this.Ol = jQr;
            this.WH = Math.max(this.WH, jQr);
        }
        ExN exN = this.f28179qr;
        if (exN != null) {
            exN.sc();
            if (this.yL == 0) {
                this.f28179qr.qr();
            }
            this.f28179qr.zY(zYVar.ExN(), zYVar.TRI());
            this.f28179qr.zY(this.WP);
            this.f28179qr.sc(zYVar.ExN(), zYVar.TRI());
        }
        if (this.TRI == null) {
            com.bytedance.sdk.openadsdk.core.Ql.We.zY zYVar2 = new com.bytedance.sdk.openadsdk.core.Ql.We.zY();
            this.TRI = zYVar2;
            zYVar2.sc(this.f28160eo);
        }
        Sfl();
        this.Cb = 0L;
        try {
            zY(zYVar);
            return true;
        } catch (Exception e11) {
            sc(new x8.b(-10, 0, e11.getMessage()));
            Tf.sc(this.f28180sc, "[video] invoke NativeVideoController#playVideo cause exception :".concat(String.valueOf(e11)));
            return false;
        }
    }

    public void wjp() {
        if (this.f28161ko || !this.uEA) {
            return;
        }
        Context applicationContext = Xc.sc().getApplicationContext();
        this.f28161ko = true;
        uEA.sc(this.qfG, applicationContext);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.sc.sc, t8.c
    public void zY() {
        sc(true, 3);
    }

    public void zY(int i11) {
        We(i11);
        if (i11 == 4) {
            this.Xc = false;
            pFF();
        }
    }
}
