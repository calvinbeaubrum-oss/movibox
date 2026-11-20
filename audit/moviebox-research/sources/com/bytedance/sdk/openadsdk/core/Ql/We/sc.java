package com.bytedance.sdk.openadsdk.core.Ql.We;

import android.content.Context;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bykv.vk.openvk.sc.sc.sc.TRI.a;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.JPJ.pFF.ExN;
import com.bytedance.sdk.openadsdk.Ql.SR;
import com.bytedance.sdk.openadsdk.We.qr;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.Tf.TRI;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.Xc;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.Objects;
import q8.b;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc extends com.bytedance.sdk.openadsdk.core.Ql.sc.sc {
    private long BR;
    private final int CYO;
    protected boolean Cb;
    private boolean JoC;
    final zY.pFF OXF;
    protected long cD;
    private final qr cJ;
    private long kX;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    private InterfaceC0288sc f28114pc;
    private final Runnable qKn;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.Ql.We.sc$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass1 implements zY.pFF {
        private boolean pFF = true;

        public AnonymousClass1() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.Ql.We.zY.pFF, q8.b.a
        public void ExN(b bVar) {
            ExN.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Qj, 0);
            if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).McK != null) {
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).McK.sc(1);
            }
            if (sc.this.f28114pc != null) {
                sc.this.f28114pc.sc(1);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.Ql.We.zY.pFF, q8.b.a
        public void We(b bVar) {
            com.bytedance.sdk.openadsdk.core.Tf.sc scVarGOt = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Qj.GOt();
            if (scVarGOt != null && scVarGOt.sc() != null) {
                scVarGOt.sc().pFF(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Ol);
            }
            ExN.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Qj, 3);
            if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).McK != null) {
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).McK.sc(0);
            }
            if (sc.this.f28114pc != null) {
                sc.this.f28114pc.sc(2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.Ql.We.zY.pFF, q8.b.a
        public void pFF(b bVar) {
            String unused = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28180sc;
            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).zY.removeCallbacks(sc.this.qKn);
            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).zY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.We.sc.1.3
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28179qr != null) {
                        ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28179qr.pFF();
                    }
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.core.Ql.We.zY.pFF, q8.b.a
        public void pFF(b bVar, int i11) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.Ql.We.zY.pFF
        public void sc(int i11, int i12) {
            sc scVar = sc.this;
            scVar.pFF(scVar.cJ);
            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).JPJ.We = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).TRI.YIK();
            sc.this.HJN();
            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).YIK.set(false);
            sc scVar2 = sc.this;
            scVar2.sc(scVar2.cJ);
        }

        @Override // com.bytedance.sdk.openadsdk.core.Ql.We.zY.pFF, q8.b.a
        public void sc(b bVar) {
            String unused = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28180sc;
            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).zY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.We.sc.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).McK != null) {
                        try {
                            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).McK.sc(9);
                        } catch (Exception unused2) {
                        }
                    }
                    sc.this.qKn();
                }
            });
            com.bytedance.sdk.openadsdk.core.Tf.sc scVarGOt = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Qj.GOt();
            if (scVarGOt != null && scVarGOt.sc() != null) {
                long jExN = sc.this.ExN();
                scVarGOt.sc().We(jExN);
                scVarGOt.sc().ExN(jExN);
            }
            ExN.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Qj, 5);
            com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Qj, 5);
            if (sc.this.f28114pc != null) {
                sc.this.f28114pc.sc(3);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.Ql.We.zY.pFF, q8.b.a
        public void sc(b bVar, int i11) {
            String unused = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28180sc;
            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).FI = false;
            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).zY.removeCallbacks(sc.this.qKn);
            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).zY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.We.sc.1.8
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28179qr != null) {
                        ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28179qr.pFF();
                    }
                }
            });
            ExN.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Qj, 0);
            if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).McK != null) {
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).McK.sc(5);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.Ql.We.zY.pFF, q8.b.a
        public void sc(b bVar, int i11, int i12) {
            String unused = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28180sc;
            com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.We.sc.1.6
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).TRI == null) {
                        return;
                    }
                    try {
                        final float fWe = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).TRI.We();
                        final float fExN = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).TRI.ExN();
                        if (fWe == 0.0f || fExN == 0.0f) {
                            return;
                        }
                        ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).zY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.We.sc.1.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (!sc.this.pc()) {
                                    sc.this.sc(fWe, fExN);
                                    return;
                                }
                                if (Xc.pFF(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Qj) || ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).JPJ.ExN == 4) {
                                    sc.this.sc(true, fWe, fExN);
                                    return;
                                }
                                if (Xc.zY(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Qj)) {
                                    sc.this.sc(true, fWe, fExN);
                                    return;
                                }
                                if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Qj.HJN() == 3) {
                                    sc.this.sc(true, fWe, fExN);
                                } else if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Qj.HJN() == 0) {
                                    sc.this.zY(fWe, fExN);
                                } else {
                                    sc.this.pFF(fWe, fExN);
                                }
                            }
                        });
                    } catch (Throwable th2) {
                        Tf.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28180sc, th2.getMessage());
                    }
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.core.Ql.We.zY.pFF, q8.b.a
        public void sc(b bVar, int i11, int i12, int i13) {
            String unused = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28180sc;
            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).FI = true;
            sc.this.CYO();
            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).zY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.We.sc.1.7
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28179qr != null) {
                        ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28179qr.Xc();
                    }
                }
            });
            ExN.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Qj, 3);
            if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).McK != null) {
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).McK.sc(4);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.Ql.We.zY.pFF, q8.b.a
        public void sc(b bVar, long j11) {
            String unused = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28180sc;
            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).FI = false;
            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).zY.removeCallbacks(sc.this.qKn);
            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).zY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.We.sc.1.2
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28179qr != null) {
                        ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28179qr.pFF();
                    }
                }
            });
            if (!((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).YIK.get()) {
                sc scVar = sc.this;
                scVar.cD = j11;
                scVar.sc(scVar.cJ);
                sc.this.cD();
            }
            if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).McK != null) {
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).McK.zY();
            }
            ExN.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Qj, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.Ql.We.zY.pFF, q8.b.a
        public void sc(b bVar, long j11, long j12) {
            if (Math.abs(j11 - ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Ol) < 50) {
                return;
            }
            sc scVar = sc.this;
            scVar.sc(scVar.cJ);
            sc.this.sc(j11, j12);
            sc.this.pFF(j11, j12);
            com.bytedance.sdk.openadsdk.core.Tf.sc scVarGOt = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Qj.GOt();
            if (scVarGOt != null && scVarGOt.sc() != null) {
                scVarGOt.sc().sc(j11, j12, ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).McK);
            }
            if (!this.pFF || j12 - j11 >= 500) {
                return;
            }
            this.pFF = false;
            sc(bVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.Ql.We.zY.pFF, q8.b.a
        public void sc(b bVar, x8.b bVar2) {
            Tf.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28180sc, "onError: " + bVar2.b() + "," + bVar2.a() + "," + bVar2.d());
            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).zY.removeCallbacks(sc.this.qKn);
            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).zY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.We.sc.1.4
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28179qr != null) {
                        ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28179qr.pFF();
                    }
                    if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).II != null) {
                        ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).II.pFF(sc.this.BR, k8.b.a(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Ol, ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).HJN));
                    }
                }
            });
            sc.this.sc(bVar2);
            ExN.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Qj, 6);
            com.bytedance.sdk.openadsdk.JPJ.sc.zY.pFF(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Qj);
            if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).McK != null) {
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).McK.sc(14);
            }
            if (sc.this.f28114pc != null) {
                sc.this.f28114pc.sc(4);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.Ql.We.zY.pFF, q8.b.a
        public void sc(b bVar, boolean z11) {
            String unused = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28180sc;
            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).zY.removeCallbacks(sc.this.qKn);
            ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).zY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.We.sc.1.5
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28179qr != null) {
                        ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28179qr.pFF();
                    }
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.core.Ql.We.zY.pFF, q8.b.a
        public void zY(b bVar) {
            String unused = ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28180sc;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.Ql.We.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0288sc {
        void sc(int i11);
    }

    public sc(Context context, ViewGroup viewGroup, Sfl sfl, qr qrVar) {
        super(context, sfl, viewGroup);
        this.kX = 0L;
        this.BR = 0L;
        this.JoC = false;
        this.cD = 0L;
        this.Cb = false;
        this.OXF = new AnonymousClass1();
        this.qKn = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.We.sc.3
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).II != null) {
                    sc.this.wjp();
                    ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).II.sc();
                }
            }
        };
        this.cJ = qrVar;
        this.CYO = sfl.QT();
        if (sfl.ymG() && sfl.GOt() != null && this.WP != null) {
            if (this.McK == null) {
                this.McK = TRI.sc();
            }
            this.McK.sc(this.WP, sfl.GOt().SR());
        }
        com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN exN = new com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN(context.getApplicationContext(), new SR(context), true, 17, this.Qj, this);
        this.f28179qr = exN;
        exN.sc(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CYO() {
        int iQKn;
        int i11 = this.JPJ.ExN;
        if (i11 == 2 || i11 == 1) {
            iQKn = com.bytedance.sdk.openadsdk.core.Xc.We().qKn() * 1000;
        } else {
            iQKn = i11 == 4 ? com.bytedance.sdk.openadsdk.core.Xc.We().Ol(String.valueOf(this.CYO)) : 5000;
        }
        this.zY.removeCallbacks(this.qKn);
        this.zY.postDelayed(this.qKn, iQKn);
    }

    private boolean GI() {
        return cJ() == null || this.TRI == null || (!com.bytedance.sdk.openadsdk.core.UFX.zY.sc(this.Qj.cvk()) ? this.Qj.JoC() != null : this.Qj.qKn() != null) || this.Qj.Gb() == 1;
    }

    private void JoC() {
        this.TRI.zY(Gb());
        this.TRI.sc(this.JPJ);
        this.kX = System.currentTimeMillis();
        this.f28179qr.zY(8);
        this.f28179qr.zY(0);
        sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.We.sc.2
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).TRI == null) {
                    return;
                }
                sc.this.kX = System.currentTimeMillis();
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28179qr.We(0);
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).TRI.sc(true, ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).Ol, ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).dE);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(float f11, float f12) {
        try {
            Objects.toString(this.Qj.Cb());
            if (GI()) {
                return;
            }
            int[] iArrPFF = kX.pFF(com.bytedance.sdk.openadsdk.core.Xc.sc());
            boolean z11 = false;
            boolean z12 = this.Qj.gx() == 1;
            float f13 = iArrPFF[0];
            float f14 = iArrPFF[1];
            if (z12) {
                if (f11 > f12) {
                    sc(f13, f14, f11, f12, true);
                    return;
                }
            } else if (f11 < f12) {
                sc(f13, f14, f11, f12, false);
                return;
            }
            float f15 = f11 / f12;
            float f16 = f13 / f14;
            if (z12) {
                if (f16 < 0.5625f && f15 == 0.5625f) {
                    f11 = (9.0f * f14) / 16.0f;
                    f12 = f14;
                    z11 = true;
                }
            } else if (f16 > 1.7777778f && f15 == 1.7777778f) {
                f12 = (9.0f * f13) / 16.0f;
                f11 = f13;
                z11 = true;
            }
            if (z11) {
                f13 = f11;
                f14 = f12;
            }
            int i11 = (int) f13;
            int i12 = (int) f14;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i11, i12);
            layoutParams.addRule(13);
            if (cJ() != null) {
                if (cJ() instanceof TextureView) {
                    ((TextureView) cJ()).setLayoutParams(layoutParams);
                } else if (cJ() instanceof SurfaceView) {
                    ((SurfaceView) cJ()).setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams2 = this.WP.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = i12;
                    layoutParams2.width = i11;
                    this.WP.setLayoutParams(layoutParams2);
                }
            }
        } catch (Throwable th2) {
            Tf.sc(this.f28180sc, "changeSize error", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(final long j11, final long j12) {
        this.Qj.zY(j11);
        this.Ol = j11;
        this.HJN = j12;
        final int iA = k8.b.a(j11, j12);
        this.zY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.We.sc.4
            @Override // java.lang.Runnable
            public void run() {
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28179qr.sc(j11, j12);
                ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28179qr.sc(iA);
                try {
                    if (((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).II != null) {
                        ((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).II.sc(j11, j12);
                    }
                } catch (Throwable th2) {
                    Tf.sc(((com.bytedance.sdk.openadsdk.core.Ql.sc.sc) sc.this).f28180sc, "onProgressUpdate error: ", th2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pc() {
        return this.Qj.AZJ() == 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qKn() {
        if (this.f28179qr == null) {
            return;
        }
        this.zY.removeCallbacks(this.qKn);
        this.f28179qr.pFF();
        this.BR = System.currentTimeMillis() - this.kX;
        if (!this.JoC) {
            this.JoC = true;
            long j11 = this.HJN;
            pFF(j11, j11);
            long j12 = this.HJN;
            this.Ol = j12;
            this.WH = j12;
            pFF(this.cJ);
        }
        c.InterfaceC0849c interfaceC0849c = this.II;
        if (interfaceC0849c != null) {
            interfaceC0849c.sc(this.BR, k8.b.a(this.Ol, this.HJN));
        }
        this.SR = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(float f11, float f12) {
        ViewGroup viewGroup;
        try {
            if (cJ() != null && this.TRI != null && (viewGroup = this.WP) != null) {
                float width = viewGroup.getWidth();
                float f13 = f11 / (width * 1.0f);
                float height = this.WP.getHeight();
                if (f13 <= f12 / (1.0f * height)) {
                    width = f11 * (height / f12);
                } else {
                    height = f12 * (width / f11);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) width, (int) height);
                layoutParams.addRule(13);
                if (cJ() instanceof TextureView) {
                    ((TextureView) cJ()).setLayoutParams(layoutParams);
                } else if (cJ() instanceof SurfaceView) {
                    ((SurfaceView) cJ()).setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th2) {
            Tf.sc(this.f28180sc, "changeVideoSizeSupportInteraction error", th2);
        }
    }

    private void sc(float f11, float f12, float f13, float f14, boolean z11) {
        RelativeLayout.LayoutParams layoutParams;
        if (f13 <= 0.0f || f14 <= 0.0f) {
            try {
                f13 = this.Qj.GI().L();
                f14 = this.Qj.GI().z();
            } catch (Throwable unused) {
                return;
            }
        }
        if (f14 > 0.0f && f13 > 0.0f) {
            if (z11) {
                if (f13 < f14) {
                    return;
                }
                layoutParams = new RelativeLayout.LayoutParams((int) f11, (int) ((f14 * f11) / f13));
            } else if (f13 > f14) {
                return;
            } else {
                layoutParams = new RelativeLayout.LayoutParams((int) ((f13 * f12) / f14), (int) f12);
            }
            layoutParams.addRule(13);
            if (cJ() != null) {
                if (cJ() instanceof TextureView) {
                    ((TextureView) cJ()).setLayoutParams(layoutParams);
                } else if (cJ() instanceof SurfaceView) {
                    ((SurfaceView) cJ()).setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams2 = this.WP.getLayoutParams();
                if (!com.bytedance.sdk.component.adexpress.We.pFF.sc(com.bytedance.sdk.openadsdk.core.Xc.sc()) || this.WP.getHeight() <= 0 || layoutParams2 == null) {
                    return;
                }
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
                this.WP.setLayoutParams(layoutParams2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY(float f11, float f12) {
        try {
            if (cJ() != null && this.TRI != null) {
                boolean z11 = this.Qj.gx() == 1;
                int[] iArrPFF = kX.pFF(com.bytedance.sdk.openadsdk.core.Xc.sc());
                sc(iArrPFF[0], iArrPFF[1], f11, f12, z11);
            }
        } catch (Throwable unused) {
        }
    }

    public void BR() {
        TRI tri = this.McK;
        if (tri != null) {
            tri.sc(13);
        }
    }

    public void Cb() {
        this.OXF.sc((b) null, 0, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.sc.sc
    public boolean FI() {
        return true;
    }

    public void OXF() {
        if (this.JoC || !this.YIK.get()) {
            return;
        }
        II();
        com.bytedance.sdk.openadsdk.core.Tf.sc scVarGOt = this.Qj.GOt();
        if (scVarGOt == null || scVarGOt.sc() == null) {
            return;
        }
        scVarGOt.sc().zY(ExN());
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.sc.sc, t8.c
    public void We() {
        zY();
    }

    public a cJ() {
        com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN exN = this.f28179qr;
        if (exN != null) {
            return exN.Ql();
        }
        return null;
    }

    public void kX() {
        TRI tri = this.McK;
        if (tri != null) {
            tri.sc(2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.sc.sc, t8.c
    public void pFF() {
        com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN exN = this.f28179qr;
        if (exN != null) {
            exN.sc();
            this.f28179qr.BT();
            this.f28179qr.wjp();
        }
        zY zYVar = this.TRI;
        if (zYVar != null) {
            if (!zYVar.qr()) {
                this.TRI.sc(false, this.Ol, this.dE);
            } else if (!this.Ql) {
                pFF(this.Gb);
            } else if (Ol.uEA()) {
                this.TRI.pFF(3);
                zY zYVar2 = this.TRI;
                zYVar2.sc(false, zYVar2.Xc(), this.dE);
            } else {
                Dl();
            }
        }
        if (this.JoC || !this.YIK.get()) {
            return;
        }
        II();
        com.bytedance.sdk.openadsdk.core.Tf.sc scVarGOt = this.Qj.GOt();
        if (scVarGOt == null || scVarGOt.sc() == null) {
            return;
        }
        scVarGOt.sc().zY(ExN());
    }

    public void sc(InterfaceC0288sc interfaceC0288sc) {
        this.f28114pc = interfaceC0288sc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.sc.sc, com.bytedance.sdk.openadsdk.core.Ql.pFF.sc
    public void sc(t8.a aVar, View view) {
        zY zYVar = this.TRI;
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
            pFF();
            com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN exN = this.f28179qr;
            if (exN != null) {
                exN.pFF(false, false);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN exN2 = this.f28179qr;
        if (exN2 != null) {
            exN2.zY(this.WP);
        }
        We(this.Ol);
        com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN exN3 = this.f28179qr;
        if (exN3 != null) {
            exN3.pFF(false, false);
        }
    }

    public void sc(boolean z11, float f11, float f12) {
        try {
            Objects.toString(this.Qj.Cb());
            if (!GI() || z11) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f11, (int) f12);
                layoutParams.addRule(13);
                if (cJ() != null) {
                    if (cJ() instanceof TextureView) {
                        ((TextureView) cJ()).setLayoutParams(layoutParams);
                    } else if (cJ() instanceof SurfaceView) {
                        ((SurfaceView) cJ()).setLayoutParams(layoutParams);
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.WP.getLayoutParams();
                    if (this.WP.getHeight() > 0) {
                        float fMin = Math.min(this.WP.getWidth() / f11, this.WP.getHeight() / f12);
                        if (layoutParams2 != null) {
                            layoutParams.width = (int) (f11 * fMin);
                            layoutParams.height = (int) (f12 * fMin);
                            if (cJ() instanceof TextureView) {
                                ((TextureView) cJ()).setLayoutParams(layoutParams);
                            } else if (cJ() instanceof SurfaceView) {
                                ((SurfaceView) cJ()).setLayoutParams(layoutParams);
                            }
                            if (this.JPJ.ExN == 4) {
                                layoutParams2.width = layoutParams.width;
                                layoutParams2.height = layoutParams.height;
                                this.WP.setLayoutParams(layoutParams2);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            Tf.sc(this.f28180sc, "changeSize error", th2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.sc.sc, t8.c
    public void sc(boolean z11, int i11) {
        zY();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.sc.sc, t8.c
    public boolean sc(@NonNull com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar) {
        View view;
        if (this.TRI != null) {
            Tf.sc(this.f28180sc, "playVideoUrl: already invoked");
            return false;
        }
        zYVar.Ql();
        if (TextUtils.isEmpty(zYVar.Ql())) {
            Tf.sc(this.f28180sc, "No video info");
            return false;
        }
        pFF(zYVar);
        zYVar.zY(1);
        this.Cb = !zYVar.Ql().startsWith(HttpHost.DEFAULT_SCHEME_NAME);
        if (this.McK != null) {
            int iWH = this.JPJ.ExN == 1 ? com.bytedance.sdk.openadsdk.core.Xc.We().WH(String.valueOf(this.CYO)) : com.bytedance.sdk.openadsdk.core.Xc.We().Sfl(String.valueOf(this.CYO));
            ViewGroup viewGroup = this.WP;
            if (viewGroup != null && (view = (View) viewGroup.getParent()) != null) {
                try {
                    View viewFindViewById = view.findViewById(com.bytedance.sdk.openadsdk.utils.SR.Tf);
                    View viewFindViewById2 = view.findViewById(com.bytedance.sdk.openadsdk.utils.SR.Cwg);
                    TRI tri = this.McK;
                    FriendlyObstructionPurpose friendlyObstructionPurpose = FriendlyObstructionPurpose.OTHER;
                    tri.sc(viewFindViewById2, friendlyObstructionPurpose);
                    this.McK.sc(viewFindViewById, friendlyObstructionPurpose);
                } catch (Throwable unused) {
                }
            }
            this.McK.sc(iWH > 0, iWH / 1000.0f);
        }
        HJN();
        if (zYVar.qr() > 0) {
            long jQr = zYVar.qr();
            this.Ol = jQr;
            this.WH = Math.max(this.WH, jQr);
        }
        com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN exN = this.f28179qr;
        if (exN != null) {
            exN.sc();
            this.f28179qr.qr();
            this.f28179qr.zY(zYVar.ExN(), zYVar.TRI());
            this.f28179qr.zY(this.WP);
        }
        zY zYVar2 = new zY();
        this.TRI = zYVar2;
        zYVar2.sc(this.OXF);
        Sfl();
        this.BR = 0L;
        JoC();
        return true;
    }

    public void wjp() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.sc.sc, t8.c
    public void zY() {
        zY zYVar = this.TRI;
        if (zYVar == null) {
            return;
        }
        zYVar.Tf();
        this.TRI = null;
        com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN exN = this.f28179qr;
        if (exN != null) {
            exN.Ol();
        }
        this.zY.removeCallbacks(this.qKn);
        this.zY.removeCallbacksAndMessages(null);
        TRI tri = this.McK;
        if (tri != null) {
            tri.We();
        }
    }
}
