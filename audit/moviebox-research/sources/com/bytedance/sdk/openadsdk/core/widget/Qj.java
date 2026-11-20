package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.cvk;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Qj extends com.bytedance.sdk.openadsdk.core.ExN.qr {
    private com.bytedance.sdk.openadsdk.core.ExN.We ExN;
    private boolean TRI;
    private com.bytedance.sdk.openadsdk.core.ExN.Qj We;
    private com.bytedance.sdk.openadsdk.core.ExN.Qj pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private boolean f28532qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Xc f28533sc;
    private Ol zY;

    public Qj(Context context) {
        super(context);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (sc()) {
            pFF();
        }
    }

    @Nullable
    public com.bytedance.sdk.openadsdk.core.ExN.Qj getDownloadButton() {
        return this.We;
    }

    @Nullable
    public Ol getLoadingProgressBar() {
        return this.zY;
    }

    public void pFF() {
        if (this.TRI) {
            return;
        }
        this.TRI = true;
        Context context = getContext();
        setBackgroundColor(Color.parseColor("#2E2E2E"));
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        Xc xc2 = new Xc(context);
        this.f28533sc = xc2;
        xc2.setId(520093745);
        int iZY = kX.zY(context, 64.0f);
        this.f28533sc.setLayoutParams(new RelativeLayout.LayoutParams(iZY, iZY));
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        this.pFF = qj2;
        qj2.setId(520093746);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(kX.zY(context, 219.0f), -2);
        layoutParams2.topMargin = kX.zY(context, 16.0f);
        this.pFF.setLayoutParams(layoutParams2);
        this.pFF.setEllipsize(TextUtils.TruncateAt.END);
        this.pFF.setGravity(17);
        this.pFF.setMaxWidth(kX.zY(context, 150.0f));
        this.pFF.setMaxLines(2);
        this.pFF.setTextColor(-1);
        this.pFF.setTextSize(1, 16.0f);
        Ol ol2 = new Ol(context);
        this.zY = ol2;
        ol2.setId(520093748);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(kX.zY(context, 219.0f), kX.zY(context, 6.0f));
        layoutParams3.topMargin = kX.zY(context, 24.0f);
        this.zY.setLayoutParams(layoutParams3);
        this.We = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(kX.zY(context, 138.0f), kX.zY(context, 42.0f));
        layoutParams4.topMargin = kX.zY(context, 48.0f);
        this.We.setLayoutParams(layoutParams4);
        this.We.setTextColor(-1);
        this.We.setTextSize(16.0f);
        this.We.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(2, -1);
        gradientDrawable.setCornerRadius(layoutParams4.height / 2);
        this.We.setBackground(gradientDrawable);
        linearLayout.addView(this.f28533sc);
        linearLayout.addView(this.pFF);
        linearLayout.addView(this.zY);
        linearLayout.addView(this.We);
        sc(context);
        addView(linearLayout);
        addView(this.ExN);
    }

    public void sc(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        this.ExN = we2;
        we2.setImageDrawable(com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_ad_logo_big"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(kX.zY(context, 64.0f), kX.zY(context, 24.0f));
        layoutParams.bottomMargin = kX.zY(context, 60.0f);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.ExN.setLayoutParams(layoutParams);
    }

    public void sc(final com.bytedance.sdk.openadsdk.core.model.Sfl sfl, int i11) {
        if (!this.TRI || sfl == null || this.f28532qr) {
            return;
        }
        this.f28532qr = true;
        boolean zYL = sfl.yL();
        if (zYL || sfl.qfG() == null || TextUtils.isEmpty(sfl.qfG().sc())) {
            this.f28533sc.setVisibility(8);
        } else {
            try {
                com.bytedance.sdk.openadsdk.Ol.We.sc(sfl.qfG()).sc(new com.bytedance.sdk.openadsdk.Ol.pFF(sfl, sfl.qfG().sc(), new cvk(this.f28533sc)));
            } catch (Throwable unused) {
                this.f28533sc.setVisibility(8);
            }
        }
        if (zYL) {
            this.pFF.setText("Loading");
        } else if (TextUtils.isEmpty(sfl.YdT())) {
            this.pFF.setVisibility(8);
        } else {
            this.pFF.setText(sfl.YdT());
        }
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = this.We;
        if (qj2 != null) {
            qj2.setText(sfl.NQ());
        }
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = this.ExN;
        if (we2 != null) {
            we2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.Qj.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Context context = Qj.this.getContext();
                    com.bytedance.sdk.openadsdk.core.model.Sfl sfl2 = sfl;
                    TTWebsiteActivity.sc(context, sfl2, cJ.sc(sfl2));
                }
            });
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ExN.getLayoutParams();
            if (i11 == 1) {
                marginLayoutParams.width = kX.zY(getContext(), 64.0f);
                marginLayoutParams.height = kX.zY(getContext(), 24.0f);
                marginLayoutParams.bottomMargin = kX.zY(getContext(), 60.0f);
            } else {
                marginLayoutParams.width = kX.zY(getContext(), 41.0f);
                marginLayoutParams.height = kX.zY(getContext(), 15.0f);
                marginLayoutParams.bottomMargin = kX.zY(getContext(), 24.0f);
            }
            this.ExN.setLayoutParams(marginLayoutParams);
        }
    }

    public boolean sc() {
        return true;
    }

    public void setProgress(int i11) {
        Ol ol2 = this.zY;
        if (ol2 != null) {
            ol2.setProgress(i11);
        }
    }
}
