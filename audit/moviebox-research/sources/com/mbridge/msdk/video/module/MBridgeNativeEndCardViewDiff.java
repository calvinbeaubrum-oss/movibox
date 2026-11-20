package com.mbridge.msdk.video.module;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class MBridgeNativeEndCardViewDiff extends MBridgeBaseView {
    public TextView ctaView;

    public MBridgeNativeEndCardViewDiff(Context context) {
        super(context);
    }

    public MBridgeNativeEndCardViewDiff(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBridgeNativeEndCardViewDiff(Context context, AttributeSet attributeSet, boolean z11, int i11, boolean z12, int i12, int i13) {
        super(context, attributeSet, z11, i11, z12, i12, i13);
    }

    public boolean checkChinaShakeState() {
        return false;
    }

    public boolean checkProgressBarIntercepted() {
        return false;
    }

    public boolean ctaViewCanGet(View view, boolean z11) {
        try {
            View viewFindViewById = view.findViewById(filterFindViewId(z11, "mbridge_tv_cta"));
            if (viewFindViewById instanceof TextView) {
                this.ctaView = (TextView) viewFindViewById;
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
        return this.ctaView != null;
    }
}
