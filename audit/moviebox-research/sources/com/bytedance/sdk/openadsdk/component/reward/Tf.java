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
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Dl;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import r8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Tf {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile Tf f27810sc;
    private com.bytedance.sdk.component.Qj.Qj ExN;
    private final Context pFF;
    private final AtomicBoolean zY = new AtomicBoolean(false);
    private final List<pFF> We = Collections.synchronizedList(new ArrayList());
    private final uEA.sc TRI = new uEA.sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.Tf.7
        @Override // com.bytedance.sdk.component.utils.uEA.sc
        public void sc(Context context, Intent intent, boolean z11, int i11) {
            if (z11) {
                if (Tf.this.ExN == null) {
                    Tf tf2 = Tf.this;
                    tf2.ExN = new com.bytedance.sdk.openadsdk.component.reward.pFF("net connect task", tf2.We);
                }
                com.bytedance.sdk.component.utils.qr.sc().post(Tf.this.ExN);
            }
        }
    };

    /* JADX INFO: compiled from: source.java */
    public static class pFF extends com.bytedance.sdk.component.Qj.Qj {
        final AdSlot pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        final Sfl f27820sc;
        final com.bytedance.sdk.openadsdk.core.model.sc zY;

        public pFF(Sfl sfl, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.sc scVar) {
            super("Reward Task");
            this.f27820sc = sfl;
            this.pFF = adSlot;
            this.zY = scVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Sfl sfl = this.f27820sc;
            if (sfl == null) {
                return;
            }
            if (Build.VERSION.SDK_INT < 23) {
                UFX.sc(Xc.sc()).sc(this.f27820sc, new com.bytedance.sdk.openadsdk.common.sc.InterfaceC0281sc<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.Tf.pFF.2
                    @Override // com.bytedance.sdk.openadsdk.common.sc.InterfaceC0281sc
                    public void sc(boolean z11, Object obj) {
                        if (z11) {
                            UFX ufxSc = UFX.sc(Xc.sc());
                            pFF pff = pFF.this;
                            ufxSc.sc(pff.pFF, pff.zY);
                        }
                    }
                });
            } else if (sfl.GI() != null) {
                com.bytedance.sdk.openadsdk.core.Ql.sc.pFF pffSc = Sfl.sc(CacheDirFactory.getICacheDir(this.f27820sc.Flm()).sc(), this.f27820sc);
                pffSc.sc("material_meta", this.f27820sc);
                pffSc.sc("ad_slot", this.pFF);
                com.bytedance.sdk.openadsdk.core.Ql.ExN.sc.sc(pffSc, new a() { // from class: com.bytedance.sdk.openadsdk.component.reward.Tf.pFF.1
                    @Override // r8.b.a
                    public void sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar, int i11) {
                        UFX ufxSc = UFX.sc(Xc.sc());
                        pFF pff = pFF.this;
                        ufxSc.sc(pff.pFF, pff.zY);
                    }

                    @Override // r8.b.a
                    public void sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar, int i11, String str) {
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc implements PAGRewardedAdLoadListener {
        private final boolean ExN;
        private final PAGRewardedAdLoadListener We;
        private final AdSlot pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final Context f27823sc;
        private final com.bytedance.sdk.openadsdk.core.model.sc zY;

        public sc(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.sc scVar, PAGRewardedAdLoadListener pAGRewardedAdLoadListener, boolean z11) {
            this.f27823sc = context;
            this.pFF = adSlot;
            this.zY = scVar;
            this.We = pAGRewardedAdLoadListener;
            this.ExN = z11;
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.TRI
        public void onError(int i11, String str) {
            PAGRewardedAdLoadListener pAGRewardedAdLoadListener = this.We;
            if (pAGRewardedAdLoadListener != null) {
                pAGRewardedAdLoadListener.onError(i11, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
            Tf.sc(this.f27823sc).sc(this.pFF, this.zY, this.We, pAGRewardedAd, this.ExN);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class zY implements PAGRewardedAdLoadListener {
        private final com.bytedance.sdk.openadsdk.core.model.sc We;
        private final AtomicBoolean pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final PAGRewardedAdLoadListener f27824sc;
        private final AtomicInteger zY;

        private zY(PAGRewardedAdLoadListener pAGRewardedAdLoadListener, com.bytedance.sdk.openadsdk.core.model.sc scVar) {
            this.pFF = new AtomicBoolean(false);
            this.f27824sc = pAGRewardedAdLoadListener;
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
            if (this.zY.decrementAndGet() > 0 || this.f27824sc == null || !this.pFF.compareAndSet(false, true)) {
                return;
            }
            this.f27824sc.onError(i11, str);
            com.bytedance.sdk.openadsdk.SR.zY.sc("choose_ad_load_error", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.component.reward.Tf.zY.1
                @Override // com.bytedance.sdk.openadsdk.SR.pFF
                @Nullable
                public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("req_id", zY.this.We.pFF());
                    return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc("choose_ad_load_error").pFF(jSONObject.toString());
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
            this.zY.decrementAndGet();
            if (this.f27824sc == null || !this.pFF.compareAndSet(false, true)) {
                return;
            }
            this.f27824sc.onAdLoaded(pAGRewardedAd);
        }
    }

    private Tf(Context context) {
        this.pFF = context == null ? Xc.sc() : context.getApplicationContext();
        pFF();
    }

    private void pFF() {
        if (this.zY.get()) {
            return;
        }
        this.zY.set(true);
        uEA.sc(this.TRI, this.pFF);
    }

    private void pFF(AdSlot adSlot) {
        if (ExN.pFF() != 2) {
            return;
        }
        UFX.sc(this.pFF).sc(adSlot.getCodeId());
    }

    private void pFF(AdSlot adSlot, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        com.bytedance.sdk.openadsdk.core.model.sc scVarSc;
        if (!TextUtils.isEmpty(adSlot.getBidAdm()) || (scVarSc = UFX.sc(this.pFF).sc(adSlot.getCodeId(), true)) == null || !scVarSc.ExN()) {
            sc(adSlot, false, pAGRewardedAdLoadListener);
            return;
        }
        Sfl sflTRI = scVarSc.TRI();
        for (Sfl sfl : scVarSc.We()) {
            if (sfl.Cb() == null) {
                sfl.sc(adSlot);
            }
        }
        SR sr2 = new SR(this.pFF, scVarSc, adSlot);
        if (!scVarSc.qr() && !JPJ.zY(sflTRI)) {
            sr2.pFF();
        }
        if (pAGRewardedAdLoadListener != null) {
            if (!scVarSc.qr() && Xc.We().Sfl() == 0) {
                sc(adSlot, scVarSc, pAGRewardedAdLoadListener, (PAGRewardedAd) sr2.sc(), true);
            }
            zY zYVar = new zY(new sc(this.pFF, adSlot, scVarSc, pAGRewardedAdLoadListener, true), scVarSc);
            for (int i11 = 0; i11 < scVarSc.We().size(); i11++) {
                sc(scVarSc.We().get(i11), adSlot, zYVar, sr2, scVarSc.qr());
                if (scVarSc.Tf()) {
                    break;
                }
            }
        }
        for (int i12 = 0; i12 < scVarSc.We().size(); i12++) {
            com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().sc(scVarSc.We().get(i12), new com.bytedance.sdk.openadsdk.core.Ql.zY.sc.InterfaceC0290sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.Tf.1
            });
        }
    }

    public static Tf sc(Context context) {
        if (f27810sc == null) {
            synchronized (Tf.class) {
                try {
                    if (f27810sc == null) {
                        f27810sc = new Tf(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f27810sc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.sc scVar, PAGRewardedAdLoadListener pAGRewardedAdLoadListener, PAGRewardedAd pAGRewardedAd, boolean z11) {
        if (pAGRewardedAdLoadListener != null) {
            pAGRewardedAdLoadListener.onAdLoaded(pAGRewardedAd);
        }
        int iPFF = ExN.pFF();
        if (!z11) {
            if (iPFF == 2) {
                UFX.sc(this.pFF).sc(adSlot, scVar);
                pFF(adSlot);
                return;
            }
            return;
        }
        if (iPFF == 2) {
            pFF(adSlot);
        } else if (iPFF == 1) {
            UFX.sc(this.pFF).sc(adSlot.getCodeId(), (Sfl) null);
        }
    }

    private void sc(final AdSlot adSlot, final boolean z11, final PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        if (com.bytedance.sdk.component.utils.Tf.We()) {
            v8.a.a(adSlot.getBidAdm());
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        Dl dl2 = new Dl();
        dl2.pFF = z11 ? 2 : 1;
        if (Xc.We().Tf(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            dl2.Qj = 2;
        }
        Xc.zY().sc(adSlot, dl2, 7, new com.bytedance.sdk.openadsdk.core.Sfl.sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.Tf.3
            @Override // com.bytedance.sdk.openadsdk.core.Sfl.sc
            public void sc(int i11, String str) {
                PAGRewardedAdLoadListener pAGRewardedAdLoadListener2;
                if (z11 || (pAGRewardedAdLoadListener2 = pAGRewardedAdLoadListener) == null) {
                    return;
                }
                pAGRewardedAdLoadListener2.onError(i11, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.Sfl.sc
            public void sc(com.bytedance.sdk.openadsdk.core.model.sc scVar, com.bytedance.sdk.openadsdk.core.model.pFF pff) {
                PAGRewardedAdLoadListener pAGRewardedAdLoadListener2;
                if (scVar.We() == null || scVar.We().isEmpty()) {
                    if (z11 || (pAGRewardedAdLoadListener2 = pAGRewardedAdLoadListener) == null) {
                        return;
                    }
                    pAGRewardedAdLoadListener2.onError(-3, com.bytedance.sdk.openadsdk.core.Qj.sc(-3));
                    pff.sc(-3);
                    com.bytedance.sdk.openadsdk.core.model.pFF.sc(pff);
                    return;
                }
                SR sr2 = new SR(Tf.this.pFF, scVar, adSlot);
                if (!z11) {
                    if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                        com.bytedance.sdk.openadsdk.Sfl.sc.We.sc().sc(scVar.We().isEmpty() ? null : scVar.We().get(0));
                        com.bytedance.sdk.openadsdk.SR.zY.sc(scVar.TRI(), System.currentTimeMillis() - jCurrentTimeMillis);
                    }
                    if (!scVar.qr() && pAGRewardedAdLoadListener != null && Xc.We().Sfl() == 0) {
                        Tf.this.sc(adSlot, scVar, pAGRewardedAdLoadListener, (PAGRewardedAd) sr2.sc(), false);
                    }
                }
                zY zYVar = new zY(new sc(Tf.this.pFF, adSlot, scVar, pAGRewardedAdLoadListener, false), scVar);
                for (int i11 = 0; i11 < scVar.We().size(); i11++) {
                    Tf.this.sc(scVar, scVar.We().get(i11), sr2, adSlot, z11, zYVar, scVar.qr());
                    if (scVar.Tf()) {
                        return;
                    }
                }
            }
        });
    }

    private void sc(pFF pff) {
        if (pff == null) {
            return;
        }
        if (this.We.size() > 0) {
            this.We.remove(0);
        }
        this.We.add(pff);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0010  */
    private void sc(Sfl sfl, AdSlot adSlot, final zY zYVar, final SR sr2, final boolean z11) {
        boolean z12;
        if (zYVar != null) {
            z12 = true;
            if (!z11 && Xc.We().Sfl() != 1) {
                z12 = false;
            }
        } else {
            z12 = false;
        }
        if (JPJ.zY(sfl) || Build.VERSION.SDK_INT < 23) {
            if (z12) {
                zYVar.onAdLoaded(sr2.sc());
            }
        } else {
            com.bytedance.sdk.openadsdk.core.Ql.sc.pFF pffSc = Sfl.sc(CacheDirFactory.getICacheDir(sfl.Flm()).sc(), sfl);
            pffSc.sc("material_meta", sfl);
            pffSc.sc("ad_slot", adSlot);
            com.bytedance.sdk.openadsdk.core.Ql.ExN.sc.sc(pffSc, new a() { // from class: com.bytedance.sdk.openadsdk.component.reward.Tf.2
                @Override // r8.b.a
                public void sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar2, int i11) {
                    if (zYVar != null) {
                        if (z11 || Xc.We().Sfl() == 1) {
                            zYVar.onAdLoaded(sr2.sc());
                        }
                    }
                }

                @Override // r8.b.a
                public void sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar2, int i11, String str) {
                    if (zYVar != null) {
                        if (z11 || Xc.We().Sfl() == 1) {
                            zYVar.onError(i11, str);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(final com.bytedance.sdk.openadsdk.core.model.sc scVar, Sfl sfl, final SR sr2, final AdSlot adSlot, final boolean z11, final zY zYVar, final boolean z12) {
        com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().sc(sfl, new com.bytedance.sdk.openadsdk.core.Ql.zY.sc.InterfaceC0290sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.Tf.4
        });
        boolean z13 = true;
        if (z11 && !JPJ.zY(sfl) && Xc.We().II(adSlot.getCodeId()).We == 1 && !BT.We(this.pFF)) {
            sc(new pFF(sfl, adSlot, scVar));
            return;
        }
        if (zYVar == null || (!z12 && Xc.We().Sfl() != 1)) {
            z13 = false;
        }
        if (JPJ.zY(sfl)) {
            if (z11) {
                UFX.sc(this.pFF).sc(adSlot, scVar);
            }
        } else if (Build.VERSION.SDK_INT < 23) {
            UFX.sc(this.pFF).sc(sfl, new com.bytedance.sdk.openadsdk.common.sc.InterfaceC0281sc<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.Tf.6
                @Override // com.bytedance.sdk.openadsdk.common.sc.InterfaceC0281sc
                public void sc(boolean z14, Object obj) {
                    if (z14) {
                        sr2.pFF();
                    }
                    if (z11) {
                        if (z14) {
                            UFX.sc(Tf.this.pFF).sc(adSlot, scVar);
                        }
                    } else {
                        if (z14) {
                            if (zYVar != null) {
                                if (z12 || Xc.We().Sfl() == 1) {
                                    zYVar.onAdLoaded(sr2.sc());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        if (zYVar != null) {
                            if (z12 || Xc.We().Sfl() == 1) {
                                zYVar.onError(-1, "");
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
            com.bytedance.sdk.openadsdk.core.Ql.ExN.sc.sc(pffSc, new a() { // from class: com.bytedance.sdk.openadsdk.component.reward.Tf.5
                @Override // r8.b.a
                public void sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar2, int i11) {
                    sr2.pFF();
                    if (z11) {
                        UFX.sc(Tf.this.pFF).sc(adSlot, scVar);
                    } else if (zYVar != null) {
                        if (z12 || Xc.We().Sfl() == 1) {
                            zYVar.onAdLoaded(sr2.sc());
                        }
                    }
                }

                @Override // r8.b.a
                public void sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar2, int i11, String str) {
                    if (zYVar != null) {
                        if (z12 || Xc.We().Sfl() == 1) {
                            zYVar.onError(i11, str);
                        }
                    }
                }
            });
            return;
        }
        if (z13) {
            zYVar.onAdLoaded(sr2.sc());
        }
    }

    private void zY() {
        if (this.zY.get()) {
            this.zY.set(false);
            try {
                uEA.sc(this.TRI);
            } catch (Exception unused) {
            }
        }
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
        zY();
    }

    public void sc() {
        try {
            UFX.sc(this.pFF).sc();
        } catch (Throwable unused) {
        }
    }

    public void sc(AdSlot adSlot) {
        if (adSlot == null || TextUtils.isEmpty(adSlot.getCodeId()) || !TextUtils.isEmpty(adSlot.getBidAdm()) || UFX.sc(this.pFF).sc(adSlot.getCodeId(), false) != null) {
            return;
        }
        sc(adSlot, true, null);
    }

    public void sc(AdSlot adSlot, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        pFF(adSlot, pAGRewardedAdLoadListener);
    }

    public void sc(String str, Sfl sfl) {
        UFX.sc(this.pFF).sc(str, sfl);
    }
}
