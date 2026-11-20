package com.bytedance.sdk.openadsdk.JPJ.pFF;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY extends pFF {
    private int We;

    public zY(Integer num, View view, Sfl sfl, ExN.sc scVar) {
        super(num, view, sfl, 1000, scVar);
        this.We = -1;
        pFF(view);
    }

    private void pFF(View view) {
        if (view != null) {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            this.We = width * height >= 242500 ? 1 : 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.JPJ.pFF.pFF
    public int TRI() {
        return 100;
    }

    @Override // com.bytedance.sdk.openadsdk.JPJ.pFF.pFF
    public void We() {
        super.We();
    }

    @Override // com.bytedance.sdk.openadsdk.JPJ.pFF.pFF
    public void pFF(int i11) {
    }

    @Override // com.bytedance.sdk.openadsdk.JPJ.pFF.pFF
    public boolean zY() {
        WeakReference<View> weakReference = this.f27093sc;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        View view = this.f27093sc.get();
        if (this.We == -1) {
            pFF(view);
        }
        return TRI.sc(view, this.We == 1, this.pFF.Zn());
    }
}
