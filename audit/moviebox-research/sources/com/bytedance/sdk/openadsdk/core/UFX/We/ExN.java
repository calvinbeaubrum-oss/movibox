package com.bytedance.sdk.openadsdk.core.UFX.We;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.core.Qj;
import com.bytedance.adsdk.ugeno.core.Ql;
import com.bytedance.sdk.component.adexpress.We.qr;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.UFX.pFF.TRI;
import com.bytedance.sdk.openadsdk.core.model.SR;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.cvk;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN extends zY {
    private com.bytedance.adsdk.ugeno.pFF.zY FI;
    private com.bytedance.adsdk.ugeno.pFF.zY WP;
    private boolean cvk;

    public ExN(Context context, Sfl sfl, boolean z11, sc scVar, ViewGroup viewGroup) {
        super(context, sfl, z11, scVar, viewGroup);
        this.cvk = false;
    }

    private void Ol() {
        Qj qj2 = new Qj();
        HashMap map = new HashMap();
        map.put("image_info", this.TRI.UFX());
        map.put("cache_dir", this.TRI.SR());
        qj2.sc(map);
        qj2.sc(this.pFF);
        qj2.sc(this.We);
        qj2.pFF(this.JPJ);
        this.f28261sc.sc("ad", qj2);
    }

    private void Qj() {
        com.bytedance.adsdk.ugeno.pFF.zY zYVar = this.FI;
        if (zYVar != null) {
            zYVar.zY(8);
        }
        com.bytedance.adsdk.ugeno.pFF.zY zYVar2 = this.WP;
        if (zYVar2 != null) {
            zYVar2.zY(8);
        }
    }

    private void pFF(CharSequence charSequence, boolean z11, int i11, boolean z12) {
        com.bytedance.adsdk.ugeno.pFF.zY zYVar = this.WP;
        if (zYVar != null && (zYVar instanceof TRI)) {
            int i12 = 0;
            if (!z11 && !z12) {
                i12 = 8;
            }
            zYVar.zY(i12);
        }
    }

    private void sc(CharSequence charSequence, boolean z11, int i11, boolean z12) {
        int i12;
        com.bytedance.adsdk.ugeno.pFF.zY zYVar = this.FI;
        if (zYVar != null && (zYVar instanceof com.bytedance.sdk.openadsdk.core.UFX.pFF.pFF)) {
            try {
                i12 = Integer.parseInt((String) charSequence);
            } catch (Exception unused) {
                Tf.sc("UGenRender", "parse duration exception", charSequence);
                i12 = 0;
            }
            if (z12 || i12 <= 0 || this.cvk) {
                this.FI.zY(8);
                return;
            }
            this.FI.zY(0);
            if (!z11 && this.TRI.sc() && qr.pFF(this.TRI.We())) {
                ((com.bytedance.sdk.openadsdk.core.UFX.pFF.pFF) this.FI).qr(String.valueOf(i11));
            } else if ("open_ad".equals(this.TRI.We()) || !this.TRI.sc()) {
                ((com.bytedance.sdk.openadsdk.core.UFX.pFF.pFF) this.FI).qr(String.valueOf(charSequence));
            } else {
                this.cvk = true;
                this.FI.zY(8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.UFX.We.zY
    public com.bytedance.adsdk.ugeno.pFF.zY TRI() {
        com.bytedance.adsdk.ugeno.pFF.zY<View> zYVar = this.zY;
        if (zYVar == null) {
            return null;
        }
        return zYVar.We("VideoV3");
    }

    @Override // com.bytedance.sdk.openadsdk.core.UFX.We.zY
    public int We() {
        Ol();
        this.f28261sc.sc((com.bytedance.adsdk.ugeno.core.Tf) this);
        this.f28261sc.sc((Ql) this);
        cvk cvkVarQKn = this.ExN.qKn();
        try {
            if (cvkVarQKn != null) {
                this.zY = this.f28261sc.sc(this.We, this.JPJ, cvkVarQKn.ExN());
            } else {
                this.zY = this.f28261sc.sc(this.We, this.JPJ, null);
            }
            if (this.zY != null) {
                if (TextUtils.equals(this.Dl, "rewarded_video")) {
                    this.FI = this.zY.We("RVCountdown");
                    this.WP = this.zY.We("RVSkipView");
                } else {
                    this.FI = this.zY.We("FVCountdown");
                    this.WP = this.zY.We("FVSkipView");
                }
                Qj();
            }
            this.TRI.HJN().pFF();
            this.TRI.HJN().zY();
            return 0;
        } catch (UnsatisfiedLinkError unused) {
            return 139;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.UFX.We.zY
    public JSONObject pFF() {
        return this.TRI.zY();
    }

    @Override // com.bytedance.sdk.openadsdk.core.UFX.We.zY
    public com.bytedance.adsdk.ugeno.pFF.zY qr() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.UFX.We.zY
    public JSONObject sc() {
        JSONObject jSONObjectZY = this.TRI.zY();
        if (jSONObjectZY != null) {
            return jSONObjectZY.optJSONObject("xTemplate");
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.UFX.We.zY, com.bytedance.adsdk.ugeno.core.Tf
    public void sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar, String str, com.bytedance.adsdk.ugeno.We.pFF.sc scVar) {
        if (this.Qj == null || scVar == null) {
            return;
        }
        String strPFF = scVar.pFF();
        strPFF.hashCode();
        int i11 = 6;
        boolean z11 = true;
        switch (strPFF) {
            case "openPrivacy":
                i11 = 7;
                break;
            case "pauseVideo":
            case "videoControl":
                i11 = 4;
                break;
            case "skip":
                break;
            case "convert":
                i11 = 2;
                break;
            case "muteVideo":
                i11 = 5;
                break;
            case "dislike":
                i11 = 3;
                break;
            default:
                i11 = 0;
                break;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        WeakReference<View> weakReference = this.YIK;
        if (weakReference != null) {
            int[] iArrSc = kX.sc(weakReference.get());
            if (iArrSc != null) {
                iArr = iArrSc;
            }
            int[] iArrZY = kX.zY(this.YIK.get());
            if (iArrZY != null) {
                iArr2 = iArrZY;
            }
        }
        SR.sc scVarSc = new SR.sc().We(this.Tf).zY(this.Ql).pFF(this.SR).sc(this.BT).pFF(this.dE).sc(this.Xc).zY(iArr[0]).We(iArr[1]).ExN(iArr2[0]).TRI(iArr2[1]).sc(this.uEA);
        if (str.equals("tap") && !this.wjp) {
            z11 = false;
        }
        this.Qj.sc(zYVar.Ol(), i11, scVarSc.sc(z11).sc(zYVar.cD()).pFF(false).sc());
    }

    @Override // com.bytedance.sdk.openadsdk.core.UFX.We.zY, com.bytedance.sdk.component.adexpress.dynamic.We
    public void setSoundMute(boolean z11) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.UFX.We.zY, com.bytedance.sdk.component.adexpress.dynamic.We
    public void setTime(CharSequence charSequence, int i11, int i12, boolean z11) {
        if (this.zY == null) {
            return;
        }
        boolean z12 = i11 == 1;
        sc(charSequence, z12, i12, z11);
        pFF(charSequence, z12, i12, z11);
    }
}
