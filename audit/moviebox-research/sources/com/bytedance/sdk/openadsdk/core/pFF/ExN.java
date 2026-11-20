package com.bytedance.sdk.openadsdk.core.pFF;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.model.Sfl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ExN extends sc {
    public ExN(@NonNull Context context, @NonNull Sfl sfl, @NonNull String str, int i11) {
        super(context, sfl, str, i11);
    }

    public abstract void sc(View view, float f11, float f12, float f13, float f14, SparseArray<zY.sc> sparseArray, int i11, int i12, int i13, boolean z11);

    @Override // com.bytedance.sdk.openadsdk.core.pFF.sc, com.bytedance.sdk.openadsdk.core.pFF.pFF, com.bytedance.sdk.openadsdk.core.pFF.zY
    public void sc(View view, float f11, float f12, float f13, float f14, SparseArray<zY.sc> sparseArray, boolean z11) {
        if (sc(view, z11)) {
            sc(view, f11, f12, f13, f14, sparseArray, this.HJN, this.II, this.McK, z11);
        }
        super.sc(view, f11, f12, f13, f14, sparseArray, z11);
    }
}
