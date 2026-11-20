package com.bytedance.sdk.openadsdk.core.Qj;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.utils.kX;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ol extends com.bytedance.sdk.openadsdk.core.pFF.pFF {
    public Ol(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.model.Sfl sfl, @NonNull String str, int i11) {
        super(context, sfl, str, i11);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pFF.pFF
    public com.bytedance.sdk.openadsdk.core.model.WH sc(float f11, float f12, float f13, float f14, SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray, long j11, long j12, View view, View view2, String str, float f15, int i11, float f16, int i12, JSONObject jSONObject, JSONObject jSONObject2) {
        float f17;
        float f18;
        float f19;
        float fZY;
        int i13;
        int i14;
        long j13;
        long j14;
        char c11;
        char c12;
        int iZY;
        int iZY2;
        int[] iArrSc = kX.sc(view);
        int i15 = 0;
        if (iArrSc == null || iArrSc.length != 2) {
            f17 = f11;
            f18 = f12;
            f19 = f13;
            fZY = f14;
            i13 = 0;
            i14 = 0;
        } else {
            i13 = iArrSc[0];
            i14 = iArrSc[1];
            if (this.YIK == 0) {
                float fZY2 = (kX.zY(this.We, f11) + i13) - 0.5f;
                float fZY3 = (kX.zY(this.We, f12) + i14) - 0.5f;
                float fZY4 = (kX.zY(this.We, f13) + i13) - 0.5f;
                fZY = (kX.zY(this.We, f14) + i14) - 0.5f;
                f19 = fZY4;
                f17 = fZY2;
                f18 = fZY3;
            } else {
                f17 = f11;
                f18 = f12;
                f19 = f13;
                fZY = f14;
            }
        }
        int[] iArrSc2 = new int[2];
        int[] iArrZY = new int[2];
        com.bytedance.sdk.openadsdk.core.model.SR sr2 = this.ExN;
        if (sr2 != null) {
            j13 = sr2.ExN;
            j14 = sr2.TRI;
            if (this.YIK == 0) {
                iArrSc2[0] = kX.zY(this.We, sr2.f28399qr) + i13;
                iArrSc2[1] = kX.zY(this.We, this.ExN.Qj) + i14;
                iZY = kX.zY(this.We, this.ExN.Ol);
                iZY2 = kX.zY(this.We, this.ExN.WH);
                c11 = 0;
                c12 = 1;
            } else {
                c11 = 0;
                iArrSc2[0] = sr2.f28399qr;
                c12 = 1;
                iArrSc2[1] = sr2.Qj;
                iZY = sr2.Ol;
                iZY2 = sr2.WH;
            }
            iArrZY[c11] = iZY;
            iArrZY[c12] = iZY2;
            if (iZY == 0 && iZY2 == 0 && view2 != null) {
                iArrSc2 = kX.sc(view2);
                iArrZY = kX.zY(view2);
            }
            i15 = 0;
        } else {
            j13 = j11;
            j14 = j12;
        }
        this.YIK = i15;
        return new com.bytedance.sdk.openadsdk.core.model.WH.sc().TRI(f17).ExN(f18).We(f19).zY(fZY).pFF(j13).sc(j14).pFF(iArrSc).sc(iArrSc2).zY(kX.zY(view)).We(iArrZY).We(this.II).ExN(this.McK).TRI(this.HJN).pFF(com.bytedance.sdk.openadsdk.core.Ol.pFF().sc() ? 1 : 2).sc(sparseArray).sc(str).sc(i12).sc(jSONObject).pFF(jSONObject2).sc();
    }

    public void sc(com.bytedance.sdk.openadsdk.core.model.SR sr2) {
        this.ExN = sr2;
    }
}
