package com.bytedance.sdk.openadsdk.component.reward.sc;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.FI;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Tf {
    private sc We;
    private final com.bytedance.sdk.openadsdk.component.reward.sc.sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected int f27883sc;
    private boolean zY = true;

    /* JADX INFO: compiled from: source.java */
    public static abstract class sc implements View.OnLayoutChangeListener {
        private int pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private int f27888sc;

        private sc() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            int i19 = i13 - i11;
            int i21 = i14 - i12;
            if (i19 == this.f27888sc && i21 == this.pFF) {
                return;
            }
            this.f27888sc = i19;
            this.pFF = i21;
            sc(i19, i21);
        }

        public abstract void sc(int i11, int i12);
    }

    public Tf(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        this.f27883sc = 0;
        this.pFF = scVar;
        zY();
        if (scVar.f27913sc == 2) {
            return;
        }
        try {
            this.f27883sc = kX.We(scVar.CYO, kX.sc());
            if (!scVar.CYO.getWindow().hasFeature(1)) {
                scVar.CYO.requestWindowFeature(1);
            }
            scVar.CYO.getWindow().addFlags(16777344);
            if (scVar.OKY == 2 || !kX.zY(scVar.CYO)) {
                scVar.CYO.getWindow().addFlags(1024);
            }
        } catch (Throwable th2) {
            Log.e("TTAD.RFSM", "init: ", th2);
        }
    }

    private float ExN() {
        return kX.We(this.pFF.CYO, kX.WH(this.pFF.CYO));
    }

    private float TRI() {
        return kX.We(this.pFF.CYO, kX.Ol(this.pFF.CYO));
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private void We() {
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
        if (scVar.OKY != 2) {
            sc(scVar.CYO, 1);
        } else if (scVar.idT) {
            sc(scVar.CYO, 8);
        } else {
            sc(scVar.CYO, 0);
        }
    }

    private float[] pFF(int i11) {
        float fTRI = TRI();
        float fExN = ExN();
        int i12 = this.pFF.OKY;
        if ((i12 == 1) != (fTRI > fExN)) {
            float f11 = fTRI + fExN;
            fExN = f11 - fExN;
            fTRI = f11 - fExN;
        }
        if (i12 == 1) {
            fTRI -= i11;
        } else {
            fExN -= i11;
        }
        return new float[]{fExN, fTRI};
    }

    private static void sc(Activity activity, int i11) {
        if (activity.getRequestedOrientation() == i11) {
            return;
        }
        activity.setRequestedOrientation(i11);
    }

    private void zY() {
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
        scVar.f27910ko = scVar.pFF.AZJ();
        if (26 != Build.VERSION.SDK_INT) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.pFF;
            scVar2.OKY = scVar2.pFF.gx();
        } else if (this.pFF.CYO.getResources().getConfiguration().orientation == 1) {
            this.pFF.OKY = 1;
        } else {
            this.pFF.OKY = 2;
        }
    }

    public void pFF() {
        if (this.We != null) {
            this.pFF.CYO.getWindow().getDecorView().removeOnLayoutChangeListener(this.We);
            this.We = null;
        }
    }

    public void pFF(FI fi2) {
        try {
            com.bytedance.sdk.openadsdk.activity.TRI tri = this.pFF.dix;
            if (tri == null || tri.Ol <= 0) {
                final boolean z11 = true;
                final boolean z12 = this.zY && com.bytedance.sdk.openadsdk.core.Xc.We().kX() == 1;
                if (!this.zY || !kX.zY(this.pFF.CYO)) {
                    z11 = false;
                }
                if (z11 || z12) {
                    if (this.We == null) {
                        this.We = new sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.Tf.2

                            /* JADX INFO: renamed from: sc, reason: collision with root package name */
                            boolean f27885sc;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super();
                            }

                            /* JADX WARN: Code duplicated, block: B:28:0x00e9 A[Catch: all -> 0x010c, TryCatch #0 {all -> 0x010c, blocks: (B:2:0x0000, B:4:0x000b, B:6:0x001f, B:8:0x006a, B:10:0x0088, B:12:0x0097, B:14:0x00ab, B:15:0x00af, B:26:0x00e3, B:28:0x00e9, B:29:0x00ee, B:31:0x00fc, B:16:0x00b2, B:18:0x00bc, B:20:0x00d0, B:22:0x00d4, B:23:0x00da, B:25:0x00de, B:33:0x0102, B:35:0x0106, B:7:0x0045), top: B:38:0x0000 }] */
                            /* JADX WARN: Code duplicated, block: B:31:0x00fc A[Catch: all -> 0x010c, TryCatch #0 {all -> 0x010c, blocks: (B:2:0x0000, B:4:0x000b, B:6:0x001f, B:8:0x006a, B:10:0x0088, B:12:0x0097, B:14:0x00ab, B:15:0x00af, B:26:0x00e3, B:28:0x00e9, B:29:0x00ee, B:31:0x00fc, B:16:0x00b2, B:18:0x00bc, B:20:0x00d0, B:22:0x00d4, B:23:0x00da, B:25:0x00de, B:33:0x0102, B:35:0x0106, B:7:0x0045), top: B:38:0x0000 }] */
                            /* JADX WARN: Code duplicated, block: B:39:? A[RETURN, SYNTHETIC] */
                            @Override // com.bytedance.sdk.openadsdk.component.reward.sc.Tf.sc
                            public void sc(int i11, int i12) {
                                int iAbs;
                                float fSc;
                                try {
                                    if (Tf.this.pFF.OKY == 2 && Tf.this.pFF.CYO.getResources().getConfiguration().orientation == 2) {
                                        iAbs = Math.abs(kX.WH(Tf.this.pFF.CYO) - Tf.this.pFF.CYO.getWindow().getDecorView().getWidth());
                                    } else {
                                        iAbs = Math.abs(kX.Ol(Tf.this.pFF.CYO) - Tf.this.pFF.CYO.getWindow().getDecorView().getHeight());
                                    }
                                    View decorView = Tf.this.pFF.CYO.getWindow().getDecorView();
                                    int paddingLeft = decorView.getPaddingLeft();
                                    int paddingRight = decorView.getPaddingRight();
                                    int paddingBottom = decorView.getPaddingBottom();
                                    if (iAbs != 0) {
                                        if (this.f27885sc) {
                                            decorView.setPadding(paddingLeft, 0, paddingRight, paddingBottom);
                                            this.f27885sc = false;
                                            return;
                                        }
                                        return;
                                    }
                                    int paddingTop = decorView.getPaddingTop();
                                    if (Tf.this.pFF.OKY != 1 || Tf.this.pFF.CYO.getResources().getConfiguration().orientation != 1) {
                                        if (Tf.this.pFF.OKY == 2 && Tf.this.pFF.CYO.getResources().getConfiguration().orientation == 2) {
                                            if (z11) {
                                                paddingLeft += (int) kX.sc();
                                            }
                                            if (z12) {
                                                fSc = kX.sc();
                                            }
                                        }
                                        if (decorView.isAttachedToWindow()) {
                                            decorView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                                            this.f27885sc = true;
                                        }
                                        if (Tf.this.pFF.f27910ko == 100.0f) {
                                            decorView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                                        }
                                    }
                                    fSc = kX.sc();
                                    paddingTop += (int) fSc;
                                    if (decorView.isAttachedToWindow()) {
                                        decorView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                                        this.f27885sc = true;
                                    }
                                    if (Tf.this.pFF.f27910ko == 100.0f) {
                                        decorView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        };
                    }
                    this.pFF.CYO.getWindow().getDecorView().addOnLayoutChangeListener(this.We);
                }
                this.zY = false;
            }
        } catch (Exception unused) {
        }
    }

    public void sc() {
        kX.sc(this.pFF.CYO);
        this.pFF.CYO.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.Tf.3
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i11) {
                if (i11 == 0) {
                    try {
                        if (Tf.this.pFF.CYO.isFinishing()) {
                            return;
                        }
                        Tf.this.pFF.CYO.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.Tf.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                kX.sc(Tf.this.pFF.CYO);
                            }
                        }, 2500L);
                    } catch (Exception e11) {
                        com.bytedance.sdk.component.utils.Tf.sc("TTAD.RFSM", e11.getMessage());
                    }
                }
            }
        });
    }

    public void sc(FI fi2) {
        if (fi2 == null) {
            return;
        }
        fi2.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.Tf.1
            @Override // java.lang.Runnable
            public void run() {
                View viewFindViewById;
                try {
                    View decorView = Tf.this.pFF.CYO.getWindow().getDecorView();
                    if (decorView == null || (viewFindViewById = decorView.findViewById(R.id.statusBarBackground)) == null) {
                        return;
                    }
                    viewFindViewById.setVisibility(8);
                } catch (Exception unused) {
                }
            }
        }, 300L);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00a8  */
    public void sc(boolean z11) {
        float fMin;
        float fMax;
        int iMax;
        int iMax2;
        int i11;
        int i12 = Build.VERSION.SDK_INT;
        if (i12 != 26) {
            if (i12 == 27) {
                try {
                    We();
                } catch (Throwable unused) {
                }
            } else {
                We();
            }
        }
        float fExN = ExN();
        float fTRI = TRI();
        if (this.pFF.OKY == 2) {
            fMin = Math.max(fExN, fTRI);
            fMax = Math.min(fExN, fTRI);
        } else {
            fMin = Math.min(fExN, fTRI);
            fMax = Math.max(fExN, fTRI);
        }
        Activity activity = this.pFF.CYO;
        int iWe = kX.We(activity, kX.sc());
        if (this.pFF.OKY != 2) {
            if (kX.zY(activity)) {
                fMax -= iWe;
            }
        } else if (kX.zY(activity)) {
            fMin -= iWe;
        }
        if (z11) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
            scVar.f27909ht = (int) fMin;
            scVar.ZM = (int) fMax;
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.pFF;
        int i13 = 20;
        if (scVar2.OKY != 2) {
            float f11 = scVar2.f27910ko;
            if (f11 == 0.0f || f11 == 100.0f) {
                i13 = 0;
                iMax = 0;
                iMax2 = 0;
                i11 = 0;
            } else {
                iMax2 = (int) Math.max((fMax - (((fMin - 20.0f) - 20.0f) / f11)) / 2.0f, 0.0f);
                i11 = iMax2;
                iMax = 20;
            }
        } else {
            float f12 = scVar2.f27910ko;
            if (f12 == 0.0f || f12 == 100.0f) {
                i13 = 0;
                iMax = 0;
                iMax2 = 0;
                i11 = 0;
            } else {
                iMax = (int) Math.max((fMin - (((fMax - 20.0f) - 20.0f) * f12)) / 2.0f, 0.0f);
                i13 = iMax;
                iMax2 = 20;
                i11 = 20;
            }
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = this.pFF;
        float f13 = i13;
        float f14 = iMax;
        scVar3.f27909ht = (int) ((fMin - f13) - f14);
        float f15 = iMax2;
        float f16 = i11;
        scVar3.ZM = (int) ((fMax - f15) - f16);
        com.bytedance.sdk.openadsdk.activity.TRI tri = scVar3.dix;
        if (tri == null || tri.Ol <= 0) {
            activity.getWindow().getDecorView().setPadding(kX.zY(activity, f13), kX.zY(activity, f15), kX.zY(activity, f14), kX.zY(activity, f16));
        }
    }

    public float[] sc(int i11) {
        float[] fArrPFF = new float[2];
        Activity activity = this.pFF.CYO;
        View decorView = activity.getWindow().getDecorView();
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 35 || this.pFF.pFF.AZJ() != 100.0f) {
            fArrPFF[0] = decorView.getWidth() - (decorView.getPaddingLeft() * 2);
            fArrPFF[1] = decorView.getHeight() - (decorView.getPaddingTop() * 2);
        } else {
            fArrPFF[0] = decorView.getWidth() - decorView.getPaddingLeft();
            fArrPFF[1] = decorView.getHeight() - decorView.getPaddingTop();
        }
        fArrPFF[0] = kX.We(activity, fArrPFF[0]);
        float fWe = kX.We(activity, fArrPFF[1]);
        fArrPFF[1] = fWe;
        if (fArrPFF[0] < 10.0f || fWe < 10.0f) {
            fArrPFF = pFF(this.f27883sc);
        }
        if (i12 != 26 && i12 != 27 && activity.getResources() != null && activity.getResources().getConfiguration() != null) {
            if ((activity.getResources().getConfiguration().orientation == 2 ? 2 : 1) != i11) {
                if (i11 == 2) {
                    float f11 = fArrPFF[0];
                    float f12 = fArrPFF[1];
                    if (f11 < f12) {
                        fArrPFF[1] = f11;
                        fArrPFF[0] = f12;
                    }
                } else {
                    float f13 = fArrPFF[0];
                    float f14 = fArrPFF[1];
                    if (f13 > f14) {
                        fArrPFF[1] = f13;
                        fArrPFF[0] = f14;
                    }
                }
            }
        }
        return fArrPFF;
    }
}
