package com.bytedance.sdk.openadsdk.component.Ol;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr extends com.bytedance.sdk.openadsdk.core.ExN.qr {
    private final com.bytedance.sdk.openadsdk.core.ExN.We pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.ExN.We f27745sc;

    public qr(@NonNull Context context) {
        super(context);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        kX.zY(context, 12.0f);
        int iZY = kX.zY(context, 16.0f);
        int iZY2 = kX.zY(context, 20.0f);
        kX.zY(context, 24.0f);
        int iZY3 = kX.zY(context, 28.0f);
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        this.f27745sc = we2;
        we2.setId(520093713);
        int iZY4 = kX.zY(getContext(), 5.0f);
        we2.setPadding(iZY4, iZY4, iZY4, iZY4);
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;
        we2.setScaleType(scaleType);
        we2.setBackground(com.bytedance.sdk.openadsdk.core.widget.We.sc());
        we2.setImageResource(Sfl.We(Xc.sc(), "tt_reward_full_feedback"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iZY3, iZY3);
        layoutParams.topMargin = iZY2;
        layoutParams.leftMargin = iZY;
        layoutParams.setMarginStart(iZY);
        we2.setLayoutParams(layoutParams);
        com.bytedance.sdk.openadsdk.core.ExN.We we3 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        this.pFF = we3;
        we3.setId(520093714);
        we3.setPadding(iZY4, iZY4, iZY4, iZY4);
        we3.setScaleType(scaleType);
        we3.setBackground(com.bytedance.sdk.openadsdk.core.widget.We.sc());
        we3.setImageResource(Sfl.We(Xc.sc(), "tt_close_btn"));
        if (we3.getDrawable() != null) {
            we3.getDrawable().setAutoMirrored(true);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iZY3, iZY3);
        layoutParams2.topMargin = iZY2;
        layoutParams2.rightMargin = iZY;
        layoutParams2.setMarginEnd(iZY);
        layoutParams2.addRule(11);
        layoutParams2.addRule(21);
        we3.setLayoutParams(layoutParams2);
        addView(we2);
        addView(we3);
    }

    public View getTopDislike() {
        return this.f27745sc;
    }

    public com.bytedance.sdk.openadsdk.core.ExN.We getTopSkip() {
        return this.pFF;
    }
}
