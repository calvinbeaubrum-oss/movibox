package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cb extends TRI implements com.bytedance.sdk.component.adexpress.dynamic.ExN {
    boolean YIK;
    FrameLayout pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    TextView f26789sc;

    public Cb(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        this.YIK = false;
        View view = new View(context);
        this.BT = view;
        view.setTag(Integer.valueOf(getClickArea()));
        this.f26789sc = new TextView(context);
        this.pFF = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, 40.0f), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, 15.0f));
        layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_END;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        this.f26789sc.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.f26789sc.setBackground(gradientDrawable);
        this.f26789sc.setTextSize(10.0f);
        this.f26789sc.setGravity(17);
        this.f26789sc.setTextColor(-1);
        this.f26789sc.setVisibility(8);
        if (com.bytedance.sdk.component.adexpress.We.pFF()) {
            addView(this.pFF, new FrameLayout.LayoutParams(-1, -1));
        }
        addView(this.f26789sc);
        addView(this.BT, getWidgetLayoutParams());
        if (!com.bytedance.sdk.component.adexpress.We.pFF()) {
            addView(this.pFF, getWidgetLayoutParams());
        }
        dynamicRootView.videoView = this.pFF;
        dynamicRootView.setVideoListener(this);
    }

    private void zY(View view) {
        if (view == this.f26789sc || view == ((TRI) this).Sfl) {
            return;
        }
        try {
            if (((Integer) view.getTag(com.bytedance.sdk.component.adexpress.dynamic.sc.TRI)).intValue() == 1) {
                return;
            }
        } catch (Throwable unused) {
        }
        int i11 = 0;
        view.setVisibility(0);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i11 >= viewGroup.getChildCount()) {
                return;
            }
            zY(viewGroup.getChildAt(i11));
            i11++;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN
    public boolean ExN() {
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.OXF
    public boolean Ol() {
        super.Ol();
        double dExN = 0.0d;
        double dWe = 0.0d;
        for (com.bytedance.sdk.component.adexpress.dynamic.We.Qj qjTf = this.Ql; qjTf != null; qjTf = qjTf.Tf()) {
            double dTRI = dWe + ((double) qjTf.TRI());
            double dQr = dExN + ((double) qjTf.qr());
            dWe = dTRI - ((double) qjTf.We());
            dExN = dQr - ((double) qjTf.ExN());
        }
        try {
            float f11 = (float) dWe;
            int iSc = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(getContext(), f11);
            int iSc2 = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(getContext(), f11 + this.ExN);
            if (com.bytedance.sdk.component.adexpress.We.pFF.sc(getContext())) {
                int dynamicWidth = ((wjp) this.SR.getChildAt(0)).getDynamicWidth();
                int i11 = dynamicWidth - iSc2;
                iSc2 = dynamicWidth - iSc;
                iSc = i11;
            }
            if ("open_ad".equals(this.SR.getRenderRequest().We())) {
                this.SR.videoView = this.pFF;
            } else {
                float f12 = (float) dExN;
                ((wjp) this.SR.getChildAt(0)).f26829sc.sc(iSc, (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(getContext(), f12), iSc2, (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(getContext(), f12 + this.TRI));
            }
        } catch (Exception unused) {
        }
        this.SR.updateRenderInfoForVideo(dWe, dExN, this.ExN, this.TRI, this.Tf.BT());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ExN
    public void sc() {
        this.f26789sc.setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ExN
    public void setTimeUpdate(int i11) {
        if (!this.Ql.WH().ExN().bp() || i11 <= 0 || this.YIK) {
            this.YIK = true;
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                zY(getChildAt(i12));
            }
            this.f26789sc.setVisibility(8);
            return;
        }
        String str = (i11 >= 60 ? "0" + (i11 / 60) : "00") + ":";
        int i13 = i11 % 60;
        this.f26789sc.setText(i13 > 9 ? str + i13 : str + "0" + i13);
        this.f26789sc.setVisibility(0);
    }
}
