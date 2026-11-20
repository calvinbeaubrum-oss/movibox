package com.bytedance.sdk.openadsdk.core.UFX.pFF;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN extends com.bytedance.adsdk.ugeno.pFF.zY<FrameLayout> {
    public ExN(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void pFF() {
        super.pFF();
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public FrameLayout We() {
        FrameLayout frameLayout = new FrameLayout(this.ExN);
        frameLayout.addView(new PAGLogoView(this.ExN));
        return frameLayout;
    }
}
