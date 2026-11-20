package com.bytedance.sdk.openadsdk.component.pFF;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.common.TRI;
import com.bytedance.sdk.openadsdk.core.Qj;
import com.bytedance.sdk.openadsdk.core.Sfl;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Dl;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.sc.pFF.pFF;
import com.bytedance.sdk.openadsdk.sc.pFF.sc.zY;
import com.bytedance.sdk.openadsdk.utils.OXF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile sc f27774sc;
    private final Sfl pFF = Xc.zY();

    private sc() {
    }

    public static sc sc() {
        if (f27774sc == null) {
            synchronized (sc.class) {
                try {
                    if (f27774sc == null) {
                        f27774sc = new sc();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f27774sc;
    }

    public void sc(final Context context, final AdSlot adSlot, final TRI tri) {
        final OXF oxfPFF = OXF.pFF();
        this.pFF.sc(adSlot, new Dl(), 5, new Sfl.sc() { // from class: com.bytedance.sdk.openadsdk.component.pFF.sc.1
            private PAGNativeAd sc(Context context2, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, AdSlot adSlot2) {
                if (sfl.JPJ() != 2) {
                    return new pFF(context2, sfl, 5, adSlot2);
                }
                return sfl.GI() != null ? new com.bytedance.sdk.openadsdk.sc.pFF.sc.pFF(context2, sfl, adSlot2) : new zY(context2, sfl, adSlot2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.Sfl.sc
            public void sc(int i11, String str) {
                tri.onError(i11, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.Sfl.sc
            public void sc(com.bytedance.sdk.openadsdk.core.model.sc scVar, com.bytedance.sdk.openadsdk.core.model.pFF pff) {
                if (scVar.We() == null || scVar.We().isEmpty()) {
                    tri.onError(-3, Qj.sc(-3));
                    pff.sc(-3);
                    com.bytedance.sdk.openadsdk.core.model.pFF.sc(pff);
                    return;
                }
                List<com.bytedance.sdk.openadsdk.core.model.Sfl> listWe = scVar.We();
                ArrayList arrayList = new ArrayList(listWe.size());
                for (com.bytedance.sdk.openadsdk.core.model.Sfl sfl : listWe) {
                    if (com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(sfl) || (sfl != null && sfl.mbO())) {
                        PAGNativeAd pAGNativeAdSc = sc(context, sfl, adSlot);
                        if (tri instanceof PAGNativeAdLoadListener) {
                            arrayList.add(pAGNativeAdSc);
                        }
                    }
                    if (com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(sfl) && sfl.GI() != null && sfl.GI().q() != null) {
                        if (Xc.We().ExN(String.valueOf(sfl.QT())) && Xc.We().OKY()) {
                            if (sfl.GI() != null) {
                                sfl.GI().n(1);
                            }
                            if (sfl.auq() != null) {
                                sfl.auq().n(1);
                            }
                            com.bytedance.sdk.openadsdk.core.Ql.sc.pFF pffSc = com.bytedance.sdk.openadsdk.core.model.Sfl.sc(CacheDirFactory.getICacheDir(sfl.Flm()).zY(), sfl);
                            pffSc.sc("material_meta", sfl);
                            pffSc.sc("ad_slot", adSlot);
                            com.bytedance.sdk.openadsdk.core.Ql.ExN.sc.sc(pffSc, null);
                        }
                        IPMiBroadcastReceiver.sc(context, sfl);
                    }
                }
                if (!(tri instanceof PAGNativeAdLoadListener) || arrayList.isEmpty()) {
                    tri.onError(-4, Qj.sc(-4));
                    pff.sc(-4);
                    com.bytedance.sdk.openadsdk.core.model.pFF.sc(pff);
                    return;
                }
                AdSlot adSlot2 = adSlot;
                if (adSlot2 != null && !TextUtils.isEmpty(adSlot2.getBidAdm())) {
                    com.bytedance.sdk.openadsdk.SR.zY.sc(listWe.get(0), oxfPFF.We());
                }
                TRI tri2 = tri;
                if (tri2 instanceof PAGNativeAdLoadListener) {
                    ((PAGNativeAdLoadListener) tri2).onAdLoaded(arrayList.get(0));
                }
                if (pff.ExN() == null || pff.ExN().isEmpty()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.model.pFF.sc(pff);
            }
        });
    }
}
