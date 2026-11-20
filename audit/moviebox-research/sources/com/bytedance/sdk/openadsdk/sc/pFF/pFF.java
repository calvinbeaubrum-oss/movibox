package com.bytedance.sdk.openadsdk.sc.pFF;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.BT;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.dE;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.List;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF extends Qj implements c.a, c.d, com.bytedance.sdk.openadsdk.multipro.pFF.sc.InterfaceC0311sc {
    private final com.bytedance.sdk.openadsdk.multipro.pFF.sc Ol;
    private zY Qj;
    private long Ql;
    private AdSlot Tf;
    private boolean UFX;
    private boolean WH;

    public pFF(@NonNull Context context, @NonNull Sfl sfl, int i11, AdSlot adSlot) {
        super(context, sfl, i11, true);
        this.WH = false;
        this.UFX = true;
        this.ExN = i11;
        this.Tf = adSlot;
        this.Ol = new com.bytedance.sdk.openadsdk.multipro.pFF.sc();
        sc(this.TRI);
        sc("embeded_ad");
        this.We.sc(this);
    }

    public pFF(@NonNull Context context, @NonNull Sfl sfl, int i11, AdSlot adSlot, sc scVar, dE dEVar) {
        super(context, sfl, i11, false);
        this.WH = false;
        this.UFX = true;
        this.We = scVar;
        this.f28677sc = dEVar;
        this.ExN = i11;
        this.Tf = adSlot;
        this.Ol = new com.bytedance.sdk.openadsdk.multipro.pFF.sc();
        sc(this.TRI);
        sc("embeded_ad");
        scVar.sc(this);
    }

    private void sc(int i11) {
        int iPFF = Xc.We().pFF(i11);
        int iZY = BT.zY(Xc.sc());
        if (3 == iPFF) {
            this.WH = false;
            this.UFX = false;
        } else {
            if (1 == iPFF && cJ.We(iZY)) {
                this.WH = false;
            } else if (2 == iPFF) {
                if (cJ.ExN(iZY) || cJ.We(iZY) || cJ.TRI(iZY)) {
                    this.WH = false;
                }
            } else if (4 == iPFF) {
                this.WH = true;
            } else if (5 == iPFF && (cJ.We(iZY) || cJ.TRI(iZY))) {
            }
            this.UFX = true;
        }
        sc scVar = this.We;
        if (scVar != null) {
            scVar.sc(this.WH);
        }
    }

    public View ExN() {
        com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI tri;
        Sfl sfl = this.pFF;
        if (sfl != null && this.zY != null) {
            if (Sfl.ExN(sfl)) {
                try {
                    tri = new com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI(this.zY, this.pFF, this.f28677sc.sc());
                    Sfl sfl2 = this.pFF;
                    if (sfl2 != null && sfl2.ymG()) {
                        com.bytedance.sdk.openadsdk.core.Tf.TRI triSc = tri.sc((List<Pair<View, FriendlyObstructionPurpose>>) null);
                        sc scVar = this.We;
                        if (scVar != null) {
                            scVar.sc(triSc);
                        }
                    }
                    this.f28677sc.sc(tri.getNativeVideoController());
                    sc scVar2 = this.We;
                    if (scVar2 != null) {
                        scVar2.sc(tri);
                    }
                    tri.setVideoAdClickListenerTTNativeAd(this);
                    tri.setAdCreativeClickListener(new com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI.sc() { // from class: com.bytedance.sdk.openadsdk.sc.pFF.pFF.1
                        @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI.sc
                        public void sc(View view, int i11) {
                            dE dEVar = pFF.this.f28677sc;
                            if (dEVar != null) {
                                dEVar.sc(view, i11);
                            }
                        }
                    });
                    tri.setControllerStatusCallBack(new com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI.pFF() { // from class: com.bytedance.sdk.openadsdk.sc.pFF.pFF.2
                        @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI.pFF
                        public void sc(boolean z11, long j11, long j12, long j13, boolean z12) {
                            pFF.this.Ol.f28652sc = z11;
                            pFF.this.Ol.ExN = j11;
                            pFF.this.Ol.TRI = j12;
                            pFF.this.Ol.f28651qr = j13;
                            pFF.this.Ol.We = z12;
                        }
                    });
                    tri.setVideoAdLoadListener(this);
                    tri.setVideoAdInteractionListener(this);
                    if (5 == this.ExN) {
                        tri.setIsAutoPlay(this.WH ? this.Tf.isAutoPlay() : this.UFX);
                    } else {
                        tri.setIsAutoPlay(this.UFX);
                    }
                    tri.setIsQuiet(Xc.We().zY(String.valueOf(this.TRI)));
                } catch (Exception e11) {
                    ApmHelper.reportCustomError("", "getAdView null", e11);
                    tri = null;
                }
            } else {
                tri = null;
            }
            if (Sfl.ExN(this.pFF) && tri != null && tri.sc(0L, true, false)) {
                return tri;
            }
            ApmHelper.reportCustomError(this.pFF.dix() + "," + tri, "getAdView null", new RuntimeException());
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pFF.sc.InterfaceC0311sc
    public com.bytedance.sdk.openadsdk.multipro.pFF.sc TRI() {
        return this.Ol;
    }

    @Override // t8.c.d
    public void d_() {
        zY zYVar = this.Qj;
        if (zYVar != null) {
            zYVar.sc(this);
        }
    }

    @Override // t8.c.d
    public void g_() {
        zY zYVar = this.Qj;
        if (zYVar != null) {
            zYVar.pFF(this);
        }
    }

    @Override // t8.c.d
    public void h_() {
    }

    @Override // t8.c.d
    public void i_() {
        zY zYVar = this.Qj;
        if (zYVar != null) {
            zYVar.zY(this);
        }
    }

    @Override // t8.c.a
    public void sc(int i11, int i12) {
        zY zYVar = this.Qj;
        if (zYVar != null) {
            zYVar.sc(i11, i12);
        }
    }

    @Override // t8.c.d
    public void sc(long j11, long j12) {
        this.Ql = j11;
    }

    public void sc(zY zYVar) {
        this.Qj = zYVar;
    }

    @Override // com.bytedance.sdk.openadsdk.sc.pFF.Qj
    public void sc(String str) {
        super.sc(str);
    }

    @Override // com.bytedance.sdk.openadsdk.sc.pFF.Qj, com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void showPrivacyActivity() {
        sc scVar = this.We;
        if (scVar != null) {
            scVar.Tf();
        }
    }
}
