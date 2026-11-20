package com.bytedance.sdk.openadsdk.core.sc;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.Sfl;
import com.bytedance.sdk.openadsdk.core.model.pFF;
import com.bytedance.sdk.openadsdk.dE.We;
import com.bytedance.sdk.openadsdk.dE.zY;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.cJ;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc implements Sfl.sc {
    private final AdSlot pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Sfl.sc f28476sc;

    public sc(Sfl.sc scVar, AdSlot adSlot) {
        this.f28476sc = scVar;
        this.pFF = adSlot;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Sfl.sc
    public void sc(final int i11, final String str) {
        AdSlot adSlot;
        if (this.f28476sc != null) {
            if (Cb.ExN() || !((adSlot = this.pFF) == null || adSlot.getDurationSlotType() == 5 || com.bytedance.sdk.openadsdk.YIK.sc.sc("start_activity_async", 0) != 1)) {
                this.f28476sc.sc(i11, str);
            } else {
                Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.sc.sc.1
                    @Override // java.lang.Runnable
                    public void run() {
                        sc.this.f28476sc.sc(i11, str);
                    }
                });
            }
            AdSlot adSlot2 = this.pFF;
            if (adSlot2 == null || adSlot2.isPreload()) {
                return;
            }
            zY.zY(new We() { // from class: com.bytedance.sdk.openadsdk.core.sc.sc.2
                @Override // com.bytedance.sdk.openadsdk.dE.We
                public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                    com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                    scVar.pFF("load_ad");
                    scVar.zY(sc.this.pFF.getCodeId());
                    scVar.We(cJ.zY(sc.this.pFF.getDurationSlotType()));
                    scVar.sc(BuildConfig.VERSION_NAME);
                    scVar.qr(cJ.sc(sc.this.pFF).toString());
                    return scVar;
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Sfl.sc
    public void sc(final com.bytedance.sdk.openadsdk.core.model.sc scVar, final pFF pff) {
        AdSlot adSlot;
        if (this.f28476sc != null) {
            if (Cb.ExN() || !((adSlot = this.pFF) == null || adSlot.getDurationSlotType() == 5 || com.bytedance.sdk.openadsdk.YIK.sc.sc("start_activity_async", 0) != 1)) {
                this.f28476sc.sc(scVar, pff);
            } else {
                Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.sc.sc.3
                    @Override // java.lang.Runnable
                    public void run() {
                        sc.this.f28476sc.sc(scVar, pff);
                    }
                });
            }
            AdSlot adSlot2 = this.pFF;
            if (adSlot2 == null || adSlot2.isPreload()) {
                return;
            }
            zY.pFF(new We() { // from class: com.bytedance.sdk.openadsdk.core.sc.sc.4
                @Override // com.bytedance.sdk.openadsdk.dE.We
                public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                    com.bytedance.sdk.openadsdk.dE.pFF.sc scVar2 = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                    scVar2.pFF("load_ad");
                    scVar2.zY(sc.this.pFF.getCodeId());
                    scVar2.We(cJ.zY(sc.this.pFF.getDurationSlotType()));
                    scVar2.sc(BuildConfig.VERSION_NAME);
                    scVar2.qr(cJ.sc(sc.this.pFF).toString());
                    return scVar2;
                }
            });
        }
    }
}
