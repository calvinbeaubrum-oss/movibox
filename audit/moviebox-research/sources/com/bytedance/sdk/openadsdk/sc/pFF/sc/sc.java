package com.bytedance.sdk.openadsdk.sc.pFF.sc;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.Qj.Sfl;
import com.bytedance.sdk.openadsdk.core.model.SR;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc extends com.bytedance.sdk.openadsdk.core.Qj.sc {
    private com.bytedance.sdk.openadsdk.sc.pFF.sc Ql;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Sfl f28692sc;

    public sc(@NonNull Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.sc
    public void sc(View view, int i11, SR sr2) {
        Sfl sfl = this.f28692sc;
        if (sfl != null) {
            sfl.sc(view, i11, sr2);
        }
    }

    public void sc(Sfl sfl) {
        this.f28692sc = sfl;
        sfl.addView(this, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setExtraFuncationHelper(com.bytedance.sdk.openadsdk.sc.pFF.sc scVar) {
        this.Ql = scVar;
    }
}
