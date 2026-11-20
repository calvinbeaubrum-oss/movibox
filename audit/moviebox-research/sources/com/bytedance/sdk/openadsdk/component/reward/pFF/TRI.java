package com.bytedance.sdk.openadsdk.component.reward.pFF;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.pFF.SR;
import com.bytedance.sdk.openadsdk.core.HJN;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.YIK;
import com.bytedance.sdk.openadsdk.utils.Cb;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI extends pFF implements com.bytedance.sdk.openadsdk.Tf.TRI {
    private final YIK BT;
    private boolean dE;

    public TRI(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        super(scVar);
        this.BT = (YIK) scVar.pFF;
    }

    public static void sc(Sfl sfl, boolean z11, String str) {
        HashMap map = new HashMap();
        map.put("is_backup", Boolean.valueOf(z11));
        com.bytedance.sdk.openadsdk.We.zY.sc("choose_ad_start_show", sfl, str, map);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("req_id", sfl.ofL());
            jSONObject.put("is_backup", z11);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.SR.zY.sc().sc("choose_ad_start_show", jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public boolean ExN() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public boolean McK() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public boolean TRI() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void cvk() {
        HJN jsObject;
        if (this.f27845sc.CYO.isFinishing()) {
            return;
        }
        if (this.f27845sc.cvk.Qj() || this.dE) {
            super.cvk();
            if (this.f27845sc.cvk.Qj()) {
                II();
                this.f27845sc.kX.pFF();
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.view.pFF pffSc = this.f27845sc.cvk.sc();
        if (pffSc == null || (jsObject = pffSc.getJsObject()) == null) {
            return;
        }
        jsObject.sc(this);
    }

    public void pFF(boolean z11) {
        if (this.dE) {
            return;
        }
        HashMap map = new HashMap();
        map.put("has_focus", Boolean.valueOf(z11));
        com.bytedance.sdk.openadsdk.We.zY.sc("choose_ad_focus_changed", this.BT, this.f27845sc.ExN, map);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.sc
    public boolean pFF() {
        return this.dE;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void qr() {
    }

    @Override // com.bytedance.sdk.openadsdk.Tf.TRI
    public void sc(int i11, long j11) {
        this.dE = true;
        int i12 = i11 - 1;
        this.BT.QLv(i12);
        com.bytedance.sdk.openadsdk.We.zY.sc(this.BT, this.f27845sc.ExN, i11, j11);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc(this.BT.vBa(), i12, this.f27845sc.We);
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.pFF.TRI.1
            @Override // java.lang.Runnable
            public void run() {
                TRI.this.cvk();
                TRI tri = TRI.this;
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = tri.f27845sc;
                if (scVar.MxZ) {
                    tri.II();
                    TRI.this.f27845sc.kX.pFF();
                } else {
                    com.bytedance.sdk.openadsdk.component.reward.sc.ExN.sc scVarTRI = scVar.kX.TRI();
                    if (scVarTRI != null) {
                        scVarTRI.dE();
                    }
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void sc(FrameLayout frameLayout) {
    }

    @Override // com.bytedance.sdk.openadsdk.Tf.TRI
    public void sc(SR sr2) {
        this.f27845sc.cvk.sc().pFF(sr2);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void sc(com.bytedance.sdk.openadsdk.component.reward.view.qr qrVar) {
        if (We.sc(this.BT)) {
            We.sc(this.BT, qrVar, this.f27845sc);
        } else {
            super.sc(qrVar);
        }
    }
}
