package com.bytedance.sdk.openadsdk.component.reward;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.BT;
import com.bytedance.sdk.component.utils.uEA;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Dl;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.OXF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import r8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile ExN f27783sc;
    private com.bytedance.sdk.component.Qj.Qj ExN;
    private final Context pFF;
    private final AtomicBoolean zY = new AtomicBoolean(false);
    private final List<zY> We = Collections.synchronizedList(new ArrayList());
    private final uEA.sc TRI = new uEA.sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.ExN.7
        @Override // com.bytedance.sdk.component.utils.uEA.sc
        public void sc(Context context, Intent intent, boolean z11, int i11) {
            if (z11) {
                if (ExN.this.ExN == null) {
                    ExN exN = ExN.this;
                    exN.ExN = new com.bytedance.sdk.openadsdk.component.reward.pFF("fsv net connect task", exN.We);
                }
                com.bytedance.sdk.component.utils.qr.sc().post(ExN.this.ExN);
            }
        }
    };

    /* JADX INFO: compiled from: source.java */
    public static class pFF implements PAGInterstitialAdLoadListener {
        private final com.bytedance.sdk.openadsdk.core.model.sc We;
        private final AtomicBoolean pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final PAGInterstitialAdLoadListener f27793sc;
        private final AtomicInteger zY;

        private pFF(PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener, com.bytedance.sdk.openadsdk.core.model.sc scVar) {
            this.pFF = new AtomicBoolean(false);
            this.f27793sc = pAGInterstitialAdLoadListener;
            this.We = scVar;
            this.zY = new AtomicInteger(sc());
        }

        private int sc() {
            if (!this.We.ExN()) {
                return 0;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.We.We().size(); i12++) {
                Sfl sfl = this.We.We().get(i12);
                if (sfl != null && !JPJ.zY(sfl) && sfl.GI() != null) {
                    i11++;
                }
            }
            return i11;
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.TRI
        public void onError(int i11, String str) {
            if (this.zY.decrementAndGet() > 0 || !this.pFF.compareAndSet(false, true)) {
                return;
            }
            this.f27793sc.onError(i11, str);
            com.bytedance.sdk.openadsdk.SR.zY.sc("choose_ad_load_error", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.component.reward.ExN.pFF.1
                @Override // com.bytedance.sdk.openadsdk.SR.pFF
                @Nullable
                public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("req_id", pFF.this.We.pFF());
                    return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc("choose_ad_load_error").pFF(jSONObject.toString());
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
            this.zY.decrementAndGet();
            if (this.f27793sc == null || !this.pFF.compareAndSet(false, true)) {
                return;
            }
            this.f27793sc.onAdLoaded(pAGInterstitialAd);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc implements PAGInterstitialAdLoadListener {
        private final boolean ExN;
        private final PAGInterstitialAdLoadListener We;
        private final AdSlot pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final Context f27795sc;
        private final com.bytedance.sdk.openadsdk.core.model.sc zY;

        public sc(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.sc scVar, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener, boolean z11) {
            this.f27795sc = context;
            this.pFF = adSlot;
            this.zY = scVar;
            this.We = pAGInterstitialAdLoadListener;
            this.ExN = z11;
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.TRI
        public void onError(int i11, String str) {
            PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener = this.We;
            if (pAGInterstitialAdLoadListener != null) {
                pAGInterstitialAdLoadListener.onError(i11, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
            ExN.sc(this.f27795sc).sc(this.pFF, this.zY, this.We, pAGInterstitialAd, this.ExN);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class zY extends com.bytedance.sdk.component.Qj.Qj {
        final AdSlot pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        final Sfl f27796sc;
        final com.bytedance.sdk.openadsdk.core.model.sc zY;

        public zY(Sfl sfl, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.sc scVar) {
            super("Fullscreen Task");
            this.f27796sc = sfl;
            this.pFF = adSlot;
            this.zY = scVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Sfl sfl = this.f27796sc;
            if (sfl == null) {
                return;
            }
            if (Build.VERSION.SDK_INT < 23) {
                We.sc(Xc.sc()).sc(this.f27796sc, new com.bytedance.sdk.openadsdk.common.sc.InterfaceC0281sc<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.ExN.zY.2
                    @Override // com.bytedance.sdk.openadsdk.common.sc.InterfaceC0281sc
                    public void sc(boolean z11, Object obj) {
                        if (z11) {
                            We weSc = We.sc(Xc.sc());
                            zY zYVar = zY.this;
                            weSc.sc(zYVar.pFF, zYVar.zY);
                        }
                    }
                });
            } else if (sfl.GI() != null) {
                com.bytedance.sdk.openadsdk.core.Ql.sc.pFF pffSc = Sfl.sc(CacheDirFactory.getICacheDir(this.f27796sc.Flm()).sc(), this.f27796sc);
                pffSc.sc("material_meta", this.f27796sc);
                pffSc.sc("ad_slot", this.pFF);
                com.bytedance.sdk.openadsdk.core.Ql.ExN.sc.sc(pffSc, new a() { // from class: com.bytedance.sdk.openadsdk.component.reward.ExN.zY.1
                    @Override // r8.b.a
                    public void sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar, int i11) {
                        We weSc = We.sc(Xc.sc());
                        zY zYVar2 = zY.this;
                        weSc.sc(zYVar2.pFF, zYVar2.zY);
                    }

                    @Override // r8.b.a
                    public void sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar, int i11, String str) {
                    }
                });
            }
        }
    }

    private ExN(Context context) {
        this.pFF = context == null ? Xc.sc() : context.getApplicationContext();
        zY();
    }

    private void We() {
        if (this.zY.get()) {
            this.zY.set(false);
            try {
                uEA.sc(this.TRI);
            } catch (Exception unused) {
            }
        }
    }

    public static int pFF() {
        return com.bytedance.sdk.openadsdk.YIK.sc.sc("ivrv_load_ad_cache_strategy", 0);
    }

    private void pFF(AdSlot adSlot) {
        if (pFF() != 2) {
            return;
        }
        We.sc(this.pFF).sc(adSlot.getCodeId());
    }

    private void pFF(AdSlot adSlot, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        com.bytedance.sdk.openadsdk.core.model.sc scVarSc;
        OXF oxfPFF = OXF.pFF();
        if (!TextUtils.isEmpty(adSlot.getBidAdm()) || (scVarSc = We.sc(this.pFF).sc(adSlot.getCodeId(), true)) == null || !scVarSc.ExN()) {
            sc(adSlot, false, oxfPFF, pAGInterstitialAdLoadListener);
            return;
        }
        Sfl sflTRI = scVarSc.TRI();
        for (Sfl sfl : scVarSc.We()) {
            if (sfl.Cb() == null) {
                sfl.sc(adSlot);
            }
        }
        Ql ql2 = new Ql(this.pFF, scVarSc);
        if (!scVarSc.qr() && !JPJ.zY(sflTRI)) {
            ql2.pFF();
        }
        if (pAGInterstitialAdLoadListener != null) {
            if (!scVarSc.qr() && Xc.We().Sfl() == 0) {
                sc(adSlot, scVarSc, pAGInterstitialAdLoadListener, ql2.sc(), true);
            }
            pFF pff = new pFF(new sc(this.pFF, adSlot, scVarSc, pAGInterstitialAdLoadListener, true), scVarSc);
            for (int i11 = 0; i11 < scVarSc.We().size(); i11++) {
                sc(scVarSc.We().get(i11), adSlot, pff, oxfPFF, ql2, scVarSc.qr());
                if (scVarSc.Tf()) {
                    break;
                }
            }
        }
        for (int i12 = 0; i12 < scVarSc.We().size(); i12++) {
            com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().sc(scVarSc.We().get(i12), new com.bytedance.sdk.openadsdk.core.Ql.zY.sc.InterfaceC0290sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.ExN.1
            });
        }
    }

    public static ExN sc(Context context) {
        if (f27783sc == null) {
            synchronized (ExN.class) {
                try {
                    if (f27783sc == null) {
                        f27783sc = new ExN(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f27783sc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.sc scVar, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener, PAGInterstitialAd pAGInterstitialAd, boolean z11) {
        if (pAGInterstitialAdLoadListener != null) {
            pAGInterstitialAdLoadListener.onAdLoaded(pAGInterstitialAd);
        }
        int iPFF = pFF();
        if (!z11) {
            if (iPFF == 2) {
                We.sc(this.pFF).sc(adSlot, scVar);
                pFF(adSlot);
                return;
            }
            return;
        }
        if (iPFF == 2) {
            pFF(adSlot);
        } else if (iPFF == 1) {
            We.sc(this.pFF).sc(adSlot.getCodeId(), (Sfl) null);
        }
    }

    private void sc(final AdSlot adSlot, final boolean z11, final OXF oxf, final PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        Dl dl2 = new Dl();
        dl2.zY = z11 ? 2 : 1;
        if (Xc.We().Tf(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            dl2.Qj = 2;
        }
        Xc.zY().sc(adSlot, dl2, 8, new com.bytedance.sdk.openadsdk.core.Sfl.sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.ExN.3
            @Override // com.bytedance.sdk.openadsdk.core.Sfl.sc
            public void sc(int i11, String str) {
                PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener2;
                if (z11 || (pAGInterstitialAdLoadListener2 = pAGInterstitialAdLoadListener) == null) {
                    return;
                }
                pAGInterstitialAdLoadListener2.onError(i11, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.Sfl.sc
            public void sc(com.bytedance.sdk.openadsdk.core.model.sc scVar, com.bytedance.sdk.openadsdk.core.model.pFF pff) {
                PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener2;
                if (scVar.We() == null || scVar.We().isEmpty()) {
                    if (z11 || (pAGInterstitialAdLoadListener2 = pAGInterstitialAdLoadListener) == null) {
                        return;
                    }
                    pAGInterstitialAdLoadListener2.onError(-3, com.bytedance.sdk.openadsdk.core.Qj.sc(-3));
                    pff.sc(-3);
                    com.bytedance.sdk.openadsdk.core.model.pFF.sc(pff);
                    return;
                }
                Ql ql2 = new Ql(ExN.this.pFF, scVar);
                if (!z11) {
                    if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                        com.bytedance.sdk.openadsdk.Sfl.sc.We.sc().sc(scVar.We().isEmpty() ? null : scVar.We().get(0));
                        com.bytedance.sdk.openadsdk.SR.zY.sc(scVar.TRI(), System.currentTimeMillis() - jCurrentTimeMillis);
                    }
                    if (!scVar.qr() && pAGInterstitialAdLoadListener != null && Xc.We().Sfl() == 0) {
                        ExN.this.sc(adSlot, scVar, pAGInterstitialAdLoadListener, ql2.sc(), false);
                    }
                }
                pFF pff2 = new pFF(new sc(ExN.this.pFF, adSlot, scVar, pAGInterstitialAdLoadListener, false), scVar);
                for (int i11 = 0; i11 < scVar.We().size(); i11++) {
                    ExN.this.sc(scVar, scVar.We().get(i11), ql2, adSlot, z11, oxf, pff2, scVar.qr());
                    if (scVar.Tf()) {
                        return;
                    }
                }
            }
        });
    }

    private void sc(zY zYVar) {
        if (zYVar == null) {
            return;
        }
        if (this.We.size() > 0) {
            this.We.remove(0);
        }
        this.We.add(zYVar);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0010  */
    private void sc(Sfl sfl, AdSlot adSlot, final pFF pff, OXF oxf, final Ql ql2, final boolean z11) {
        boolean z12;
        if (pff != null) {
            z12 = true;
            if (!z11 && Xc.We().Sfl() != 1) {
                z12 = false;
            }
        } else {
            z12 = false;
        }
        if (JPJ.zY(sfl) || !Sfl.ExN(sfl) || Build.VERSION.SDK_INT < 23) {
            if (z12) {
                pff.onAdLoaded(ql2.sc());
            }
        } else {
            sfl.GI();
            com.bytedance.sdk.openadsdk.core.Ql.sc.pFF pffSc = Sfl.sc(CacheDirFactory.getICacheDir(sfl.Flm()).sc(), sfl);
            pffSc.sc("material_meta", sfl);
            pffSc.sc("ad_slot", adSlot);
            com.bytedance.sdk.openadsdk.core.Ql.ExN.sc.sc(pffSc, new a() { // from class: com.bytedance.sdk.openadsdk.component.reward.ExN.2
                @Override // r8.b.a
                public void sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar, int i11) {
                    if (pff != null) {
                        if (z11 || Xc.We().Sfl() == 1) {
                            pff.onAdLoaded(ql2.sc());
                        }
                    }
                }

                @Override // r8.b.a
                public void sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar, int i11, String str) {
                    if (pff != null) {
                        if (z11 || Xc.We().Sfl() == 1) {
                            pff.onError(i11, str);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(final com.bytedance.sdk.openadsdk.core.model.sc scVar, Sfl sfl, final Ql ql2, final AdSlot adSlot, final boolean z11, OXF oxf, final pFF pff, final boolean z12) {
        com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().sc(sfl, new com.bytedance.sdk.openadsdk.core.Ql.zY.sc.InterfaceC0290sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.ExN.4
        });
        boolean z13 = true;
        if (z11 && !JPJ.zY(sfl) && Sfl.ExN(sfl) && Xc.We().II(adSlot.getCodeId()).We == 1 && !BT.We(this.pFF)) {
            sc(new zY(sfl, adSlot, scVar));
            return;
        }
        if (pff == null || (!z12 && Xc.We().Sfl() != 1)) {
            z13 = false;
        }
        if (JPJ.zY(sfl)) {
            if (z11) {
                We.sc(this.pFF).sc(adSlot, scVar);
            }
        } else if (Sfl.ExN(sfl)) {
            if (Build.VERSION.SDK_INT < 23) {
                We.sc(this.pFF).sc(sfl, new com.bytedance.sdk.openadsdk.common.sc.InterfaceC0281sc<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.ExN.6
                    @Override // com.bytedance.sdk.openadsdk.common.sc.InterfaceC0281sc
                    public void sc(boolean z14, Object obj) {
                        if (z14) {
                            ql2.pFF();
                        }
                        if (z11) {
                            if (z14) {
                                We.sc(ExN.this.pFF).sc(adSlot, scVar);
                            }
                        } else {
                            if (z14) {
                                if (pff != null) {
                                    if (z12 || Xc.We().Sfl() == 1) {
                                        pff.onAdLoaded(ql2.sc());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            if (pff != null) {
                                if (z12 || Xc.We().Sfl() == 1) {
                                    pff.onError(-1, "");
                                }
                            }
                        }
                    }
                });
                return;
            } else if (sfl.GI() != null) {
                com.bytedance.sdk.openadsdk.core.Ql.sc.pFF pffSc = Sfl.sc(CacheDirFactory.getICacheDir(sfl.Flm()).sc(), sfl);
                pffSc.sc("material_meta", sfl);
                pffSc.sc("ad_slot", adSlot);
                com.bytedance.sdk.openadsdk.core.Ql.ExN.sc.sc(pffSc, new a() { // from class: com.bytedance.sdk.openadsdk.component.reward.ExN.5
                    @Override // r8.b.a
                    public void sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar, int i11) {
                        ql2.pFF();
                        if (z11) {
                            We.sc(ExN.this.pFF).sc(adSlot, scVar);
                        } else if (pff != null) {
                            if (z12 || Xc.We().Sfl() == 1) {
                                pff.onAdLoaded(ql2.sc());
                            }
                        }
                    }

                    @Override // r8.b.a
                    public void sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar, int i11, String str) {
                        if (pff != null) {
                            if (z12 || Xc.We().Sfl() == 1) {
                                pff.onError(i11, str);
                            }
                        }
                    }
                });
                return;
            }
        } else if (z11) {
            We.sc(this.pFF).sc(adSlot, scVar);
        }
        if (z13) {
            pff.onAdLoaded(ql2.sc());
        }
    }

    private void zY() {
        if (this.zY.get()) {
            return;
        }
        this.zY.set(true);
        uEA.sc(this.TRI, this.pFF);
    }

    public void finalize() throws Throwable {
        super.finalize();
        if (this.ExN != null) {
            try {
                com.bytedance.sdk.component.utils.qr.sc().removeCallbacks(this.ExN);
            } catch (Exception unused) {
            }
            this.ExN = null;
        }
        We();
    }

    public void sc() {
        try {
            We.sc(this.pFF).sc();
        } catch (Throwable unused) {
        }
    }

    public void sc(AdSlot adSlot) {
        if (adSlot == null || TextUtils.isEmpty(adSlot.getCodeId()) || !TextUtils.isEmpty(adSlot.getBidAdm()) || We.sc(this.pFF).sc(adSlot.getCodeId(), false) != null) {
            return;
        }
        sc(adSlot, true, OXF.pFF(), null);
    }

    public void sc(AdSlot adSlot, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        pFF(adSlot, pAGInterstitialAdLoadListener);
    }

    public void sc(String str, Sfl sfl) {
        We.sc(this.pFF).sc(str, sfl);
    }
}
