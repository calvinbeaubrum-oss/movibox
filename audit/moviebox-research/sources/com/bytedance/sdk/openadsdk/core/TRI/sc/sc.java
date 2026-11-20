package com.bytedance.sdk.openadsdk.core.TRI.sc;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.component.adexpress.pFF.UFX;
import com.bytedance.sdk.openadsdk.core.model.SR;
import com.bytedance.sdk.openadsdk.core.pFF.zY;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc extends zY implements com.bytedance.sdk.component.adexpress.dynamic.TRI.sc {
    protected WeakReference<View> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected WeakReference<View> f28199sc;
    private UFX zY;

    private void sc(View view, int i11, float f11, float f12, float f13, float f14, SparseArray<zY.sc> sparseArray) {
        if (this.zY != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            WeakReference<View> weakReference = this.pFF;
            if (weakReference != null) {
                int[] iArrSc = kX.sc(weakReference.get());
                if (iArrSc != null) {
                    iArr = iArrSc;
                }
                int[] iArrZY = kX.zY(this.pFF.get());
                if (iArrZY != null) {
                    iArr2 = iArrZY;
                }
            }
            String strValueOf = "";
            try {
                int i12 = com.bytedance.sdk.component.adexpress.dynamic.sc.Dl;
                if (view.getTag(i12) != null) {
                    strValueOf = String.valueOf(view.getTag(i12));
                }
            } catch (Exception unused) {
            }
            this.zY.sc(view, i11, new SR.sc().We(f11).zY(f12).pFF(f13).sc(f14).pFF(this.WP).sc(this.cvk).zY(iArr[0]).We(iArr[1]).ExN(iArr2[0]).TRI(iArr2[1]).sc(sparseArray).sc(this.cD).sc(strValueOf).sc());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.TRI.sc
    public void pFF(View view) {
        this.pFF = new WeakReference<>(view);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.TRI.sc
    public void sc(View view) {
        this.f28199sc = new WeakReference<>(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pFF.zY
    public void sc(View view, float f11, float f12, float f13, float f14, SparseArray<zY.sc> sparseArray, boolean z11) {
        sc(view, ((Integer) view.getTag()).intValue(), f11, f12, f13, f14, sparseArray);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.TRI.sc
    public void sc(UFX ufx) {
        this.zY = ufx;
    }
}
