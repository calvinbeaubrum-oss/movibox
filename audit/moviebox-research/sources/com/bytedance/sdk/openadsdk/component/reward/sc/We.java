package com.bytedance.sdk.openadsdk.component.reward.sc;

import android.util.SparseArray;
import android.view.View;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We {
    private final com.bytedance.sdk.openadsdk.component.reward.sc.sc ExN;
    private boolean We;
    private final com.bytedance.sdk.openadsdk.core.model.Sfl pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI f27897sc;
    private final String zY;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc(View view, float f11, float f12, float f13, float f14, SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray, int i11, int i12, int i13);

        void sc(String str, JSONObject jSONObject);
    }

    public We(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        this.ExN = scVar;
        this.pFF = scVar.pFF;
        this.zY = scVar.ExN;
    }

    private void We() {
        if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY() && this.pFF.QLv() == 4) {
            this.f27897sc = com.bytedance.sdk.openadsdk.wjp.sc.sc.qr.sc(this.ExN.f27911pc, this.pFF, this.zY);
        }
        if (this.f27897sc == null) {
            this.f27897sc = com.bytedance.sdk.openadsdk.wjp.sc.sc.qr.sc(this.ExN.CYO, this.pFF, this.zY);
        }
    }

    public void pFF() {
        com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI tri = this.f27897sc;
        if (tri != null) {
            tri.We();
        }
    }

    public void sc() {
        if (this.We) {
            return;
        }
        this.We = true;
        We();
    }

    public void sc(View view, float f11, float f12, float f13, float f14, SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray, int i11, int i12, int i13, sc scVar) {
        if (this.f27897sc == null) {
            scVar.sc(view, f11, f12, f13, f14, sparseArray, i11, i12, i13);
            return;
        }
        int id2 = view.getId();
        if (id2 == com.bytedance.sdk.openadsdk.utils.SR.ExN) {
            scVar.sc("click_play_star_level", null);
            return;
        }
        if (id2 == com.bytedance.sdk.openadsdk.utils.SR.We) {
            scVar.sc("click_play_star_nums", null);
        } else if (id2 == com.bytedance.sdk.openadsdk.utils.SR.zY) {
            scVar.sc("click_play_source", null);
        } else if (id2 == com.bytedance.sdk.openadsdk.utils.SR.pFF) {
            scVar.sc("click_play_logo", null);
        }
    }

    public com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI zY() {
        return this.f27897sc;
    }
}
