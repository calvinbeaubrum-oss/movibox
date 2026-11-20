package com.bytedance.sdk.openadsdk.component;

import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.FI;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.core.Qj;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.Sfl;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Dl;
import com.bytedance.sdk.openadsdk.core.model.WP;
import com.bytedance.sdk.openadsdk.core.settings.dE;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.OXF;
import com.hisavana.common.bean.TAdErrorCode;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr implements FI.sc {
    private int Qj;
    private AdSlot TRI;
    private boolean UFX;
    private final Sfl<com.bytedance.sdk.openadsdk.We.sc> pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private PAGAppOpenAdLoadListener f27776qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Context f27777sc;
    private final TRI zY;
    private final AtomicBoolean We = new AtomicBoolean(false);
    private int ExN = 0;
    private volatile int Ol = 0;
    private final WP WH = new WP();

    public qr(Context context) {
        if (context != null) {
            this.f27777sc = context.getApplicationContext();
        } else {
            this.f27777sc = Xc.sc();
        }
        this.pFF = Xc.zY();
        this.zY = TRI.sc(this.f27777sc);
    }

    private void pFF(@NonNull final AdSlot adSlot) {
        final OXF oxfPFF = OXF.pFF();
        this.Ol = 1;
        Dl dl2 = new Dl();
        dl2.WH = this.WH;
        dl2.We = 1;
        dl2.Qj = 2;
        this.pFF.sc(adSlot, dl2, 3, new Sfl.sc() { // from class: com.bytedance.sdk.openadsdk.component.qr.1
            @Override // com.bytedance.sdk.openadsdk.core.Sfl.sc
            public void sc(int i11, String str) {
                qr.this.Ol = 3;
                qr.this.sc(new com.bytedance.sdk.openadsdk.component.ExN.pFF(2, 100, i11, str));
            }

            @Override // com.bytedance.sdk.openadsdk.core.Sfl.sc
            public void sc(final com.bytedance.sdk.openadsdk.core.model.sc scVar, com.bytedance.sdk.openadsdk.core.model.pFF pff) {
                qr.this.Ol = 2;
                if (scVar == null || scVar.We() == null || scVar.We().size() == 0) {
                    qr.this.Ol = 3;
                    qr.this.sc(new com.bytedance.sdk.openadsdk.component.ExN.pFF(2, 100, TAdErrorCode.CODE_FILL_FAILED_WITH_NO_AD, Qj.sc(TAdErrorCode.CODE_FILL_FAILED_WITH_NO_AD)));
                    pff.sc(-3);
                    com.bytedance.sdk.openadsdk.core.model.pFF.sc(pff);
                    return;
                }
                final com.bytedance.sdk.openadsdk.core.model.Sfl sfl = scVar.We().get(0);
                long jBT = sfl.BT();
                qr.this.WH.pFF = jBT;
                boolean zTRI = com.bytedance.sdk.openadsdk.core.model.Sfl.TRI(sfl);
                if (sfl.LVf()) {
                    qr.this.sc(new com.bytedance.sdk.openadsdk.component.ExN.pFF(1, 100, sfl, scVar));
                    return;
                }
                if (zTRI) {
                    qr.this.sc(new com.bytedance.sdk.openadsdk.component.ExN.pFF(1, 100, sfl, scVar));
                    if (com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(sfl)) {
                        qr.this.sc(sfl, adSlot, false, scVar);
                        return;
                    } else {
                        qr.this.sc(sfl, false, scVar);
                        return;
                    }
                }
                if (com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(sfl)) {
                    int iTf = Xc.We().Tf();
                    if (iTf == 1 || iTf == 3) {
                        qr.this.WH.pFF = -1L;
                        qr.this.WH.sc(3);
                        qr.this.sc(new com.bytedance.sdk.openadsdk.component.ExN.pFF(1, 100, sfl, scVar));
                        qr.this.sc(sfl, adSlot, false, scVar);
                        return;
                    }
                    qr qrVar = qr.this;
                    qrVar.sc(sfl, adSlot, !qrVar.WH.f28414sc, scVar);
                } else {
                    if (Xc.We().UFX() == 1) {
                        qr.this.WH.pFF = -1L;
                        qr.this.WH.sc(3);
                        qr.this.sc(new com.bytedance.sdk.openadsdk.component.ExN.pFF(1, 100, sfl, scVar));
                        qr.this.sc(sfl, false, scVar);
                        return;
                    }
                    qr qrVar2 = qr.this;
                    qrVar2.sc(sfl, !qrVar2.WH.f28414sc, scVar);
                }
                if (qr.this.WH.f28414sc) {
                    com.bytedance.sdk.openadsdk.SR.zY.sc(sfl, oxfPFF.We());
                    if (jBT != 0) {
                        SR.pFF().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.qr.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                qr.this.WH.sc(2);
                                qr.this.sc(new com.bytedance.sdk.openadsdk.component.ExN.pFF(1, 100, sfl, scVar));
                            }
                        }, jBT);
                    } else {
                        qr.this.WH.sc(2);
                        qr.this.sc(new com.bytedance.sdk.openadsdk.component.ExN.pFF(1, 100, sfl, scVar));
                    }
                }
            }
        });
    }

    public static qr sc(Context context) {
        return new qr(context);
    }

    private void sc() {
        Cb.pFF(new com.bytedance.sdk.component.Qj.Qj("tryGetAppOpenAdFromCache") { // from class: com.bytedance.sdk.openadsdk.component.qr.2
            @Override // java.lang.Runnable
            public void run() {
                int iTf;
                com.bytedance.sdk.openadsdk.core.model.Sfl sflExN = qr.this.zY.ExN(qr.this.ExN);
                if (sflExN == null) {
                    qr.this.sc(false);
                    return;
                }
                if (sflExN.Cb() == null) {
                    sflExN.sc(qr.this.TRI);
                }
                boolean zExN = com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(sflExN);
                if (sflExN.LVf()) {
                    qr.this.sc(new com.bytedance.sdk.openadsdk.component.ExN.pFF(1, 101, sflExN, (com.bytedance.sdk.openadsdk.core.model.sc) null));
                    return;
                }
                if (!zExN && Xc.We().UFX() == 1) {
                    qr.this.sc(new com.bytedance.sdk.openadsdk.component.ExN.pFF(1, 101, sflExN, (com.bytedance.sdk.openadsdk.core.model.sc) null));
                    return;
                }
                if (zExN && ((iTf = Xc.We().Tf()) == 2 || iTf == 3)) {
                    qr.this.sc(new com.bytedance.sdk.openadsdk.component.ExN.pFF(1, 101, sflExN, (com.bytedance.sdk.openadsdk.core.model.sc) null));
                    return;
                }
                if (!qr.this.zY.pFF(qr.this.ExN) && !qr.this.zY.We(qr.this.ExN)) {
                    qr.this.sc(true);
                    return;
                }
                if (dE.ef().WP(qr.this.TRI.getCodeId()) == 0) {
                    qr.this.zY.qr(qr.this.ExN);
                }
                if (!zExN) {
                    if (qr.this.zY.pFF(sflExN)) {
                        qr.this.sc(new com.bytedance.sdk.openadsdk.component.ExN.pFF(1, 101, sflExN, (com.bytedance.sdk.openadsdk.core.model.sc) null));
                        return;
                    } else {
                        qr.this.sc(false);
                        com.bytedance.sdk.openadsdk.component.We.sc.pFF(sflExN);
                        return;
                    }
                }
                if (!TextUtils.isEmpty(qr.this.zY.sc(sflExN)) || Build.VERSION.SDK_INT < 23) {
                    qr.this.sc(new com.bytedance.sdk.openadsdk.component.ExN.pFF(1, 101, sflExN, (com.bytedance.sdk.openadsdk.core.model.sc) null));
                } else {
                    qr.this.sc(false);
                    com.bytedance.sdk.openadsdk.component.We.sc.pFF(sflExN);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(com.bytedance.sdk.openadsdk.component.ExN.pFF pff) {
        int iZY = pff.zY();
        int iWe = pff.We();
        if (this.We.get()) {
            if (iZY == 1 && iWe == 100 && pff.pFF()) {
                TRI.sc(Xc.sc()).sc(new com.bytedance.sdk.openadsdk.component.ExN.sc(this.ExN, pff.ExN(), pff.sc()));
                if (this.UFX) {
                    return;
                }
                com.bytedance.sdk.openadsdk.component.We.sc.sc(pff.ExN(), 1, this.WH);
                return;
            }
            return;
        }
        if (iZY != 1) {
            if (iZY == 2 || iZY == 3) {
                PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener = this.f27776qr;
                if (pAGAppOpenAdLoadListener != null) {
                    pAGAppOpenAdLoadListener.onError(pff.TRI(), pff.qr());
                }
                this.We.set(true);
                if (iZY == 3) {
                    com.bytedance.sdk.openadsdk.component.We.sc.sc(this.Ol, this.Qj);
                    return;
                }
                return;
            }
            return;
        }
        if (this.f27776qr != null) {
            this.f27776qr.onAdLoaded(new We(this.f27777sc, pff.ExN(), iWe == 101, this.TRI));
        }
        this.We.set(true);
        if (iWe == 101) {
            com.bytedance.sdk.openadsdk.component.We.sc.sc(pff.ExN(), this.WH.sc().We());
            return;
        }
        if (iWe == 100) {
            com.bytedance.sdk.openadsdk.component.We.sc.sc(pff.ExN(), 0, this.WH);
            this.UFX = true;
            if (this.WH.f28414sc || com.bytedance.sdk.openadsdk.core.model.Sfl.TRI(pff.ExN())) {
                return;
            }
            if (dE.ef().WP(this.TRI.getCodeId()) == 0) {
                this.zY.sc(this.TRI);
            } else {
                this.zY.sc(new com.bytedance.sdk.openadsdk.component.ExN.sc(this.ExN, pff.ExN(), pff.sc()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(@NonNull final com.bytedance.sdk.openadsdk.core.model.Sfl sfl, AdSlot adSlot, final boolean z11, final com.bytedance.sdk.openadsdk.core.model.sc scVar) {
        this.zY.sc(sfl, adSlot, this.WH, new TRI.zY() { // from class: com.bytedance.sdk.openadsdk.component.qr.3
            @Override // com.bytedance.sdk.openadsdk.component.TRI.zY
            public void sc() {
                if (z11) {
                    qr.this.Ol = 4;
                    com.bytedance.sdk.openadsdk.component.ExN.pFF pff = new com.bytedance.sdk.openadsdk.component.ExN.pFF(1, 100, sfl, scVar);
                    pff.sc(true);
                    qr.this.sc(pff);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.TRI.zY
            public void sc(int i11, String str) {
                if (z11) {
                    qr.this.Ol = 5;
                    qr.this.sc(new com.bytedance.sdk.openadsdk.component.ExN.pFF(2, 100, 10003, Qj.sc(10003)));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(@NonNull final com.bytedance.sdk.openadsdk.core.model.Sfl sfl, final boolean z11, final com.bytedance.sdk.openadsdk.core.model.sc scVar) {
        this.zY.sc(sfl, this.WH, new TRI.pFF() { // from class: com.bytedance.sdk.openadsdk.component.qr.4
            @Override // com.bytedance.sdk.openadsdk.component.TRI.pFF
            public void sc() {
                if (z11) {
                    qr.this.Ol = 5;
                    qr.this.sc(new com.bytedance.sdk.openadsdk.component.ExN.pFF(2, 100, 10003, Qj.sc(10003)));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.TRI.pFF
            public void sc(com.bytedance.sdk.openadsdk.Xc.sc.pFF pff) {
                if (z11) {
                    qr.this.Ol = 4;
                    com.bytedance.sdk.openadsdk.component.ExN.pFF pff2 = new com.bytedance.sdk.openadsdk.component.ExN.pFF(1, 100, sfl, scVar);
                    pff2.sc(true);
                    qr.this.sc(pff2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(boolean z11) {
        if (z11) {
            this.zY.qr(this.ExN);
        }
        if (dE.ef().WP(this.TRI.getCodeId()) == 1) {
            pFF(this.TRI);
        }
    }

    public int sc(@NonNull AdSlot adSlot) {
        try {
            return Integer.parseInt(adSlot.getCodeId());
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.component.utils.FI.sc
    public void sc(Message message) {
        if (message.what != 1 || this.We.get()) {
            return;
        }
        sc(new com.bytedance.sdk.openadsdk.component.ExN.pFF(3, 102, 10002, Qj.sc(10002)));
    }

    public void sc(@NonNull AdSlot adSlot, com.bytedance.sdk.openadsdk.common.TRI tri, int i11) {
        if (tri == null) {
            return;
        }
        if (i11 <= 0) {
            i11 = 3500;
        }
        this.TRI = adSlot;
        this.WH.f28414sc = !TextUtils.isEmpty(adSlot.getBidAdm());
        if (tri instanceof PAGAppOpenAdLoadListener) {
            this.f27776qr = (PAGAppOpenAdLoadListener) tri;
        }
        this.ExN = sc(this.TRI);
        this.Qj = i11;
        this.WH.sc(OXF.pFF());
        if (this.WH.f28414sc || dE.ef().WP(this.TRI.getCodeId()) == 0) {
            pFF(this.TRI);
        }
        if (this.WH.f28414sc) {
            return;
        }
        new FI(SR.pFF().getLooper(), this).sendEmptyMessageDelayed(1, i11);
        sc();
    }
}
