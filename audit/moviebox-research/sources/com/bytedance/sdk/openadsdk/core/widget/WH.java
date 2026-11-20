package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class WH extends FrameLayout {
    private TextView ExN;
    private String Ol;
    private com.bytedance.sdk.openadsdk.core.model.Sfl Qj;
    private PAGLogoView TRI;
    private com.bytedance.sdk.openadsdk.core.pFF.sc WH;
    private dE We;
    private Xc pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ExN.Qj f28543qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private boolean f28544sc;
    private TextView zY;

    public WH(@NonNull Context context) {
        super(context);
        setVisibility(8);
        setId(com.bytedance.sdk.openadsdk.utils.SR.f28748gx);
    }

    private void pFF() {
        Context context = getContext();
        boolean z11 = this.Qj.gx() == 1;
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN.setGravity(1);
        exN.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = z11 ? new FrameLayout.LayoutParams(-1, -2) : new FrameLayout.LayoutParams(kX.zY(context, 327.0f), -2);
        layoutParams.gravity = 17;
        int iZY = kX.zY(context, 24.0f);
        layoutParams.rightMargin = iZY;
        layoutParams.leftMargin = iZY;
        addView(exN, layoutParams);
        Xc xc2 = new Xc(context);
        this.pFF = xc2;
        xc2.setBackgroundColor(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(kX.zY(context, 80.0f), kX.zY(context, 80.0f));
        layoutParams2.bottomMargin = kX.zY(context, 12.0f);
        exN.addView(this.pFF, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        this.zY = qj2;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        qj2.setEllipsize(truncateAt);
        this.zY.setGravity(17);
        this.zY.setMaxLines(2);
        this.zY.setMaxWidth(kX.zY(context, 180.0f));
        this.zY.setTextColor(-1);
        this.zY.setTextSize(2, 24.0f);
        exN.addView(this.zY, new LinearLayout.LayoutParams(-1, -2));
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj3 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        this.f28543qr = qj3;
        qj3.setEllipsize(truncateAt);
        this.f28543qr.setGravity(17);
        this.f28543qr.setMaxLines(2);
        this.f28543qr.setTextColor(Color.parseColor("#BFFFFFFF"));
        this.f28543qr.setTextSize(2, 16.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = kX.zY(context, 8.0f);
        exN.addView(this.f28543qr, layoutParams3);
        this.We = new dE(context, true);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, kX.zY(context, 16.0f));
        layoutParams4.topMargin = kX.zY(context, 12.0f);
        this.We.setVisibility(8);
        exN.addView(this.We, layoutParams4);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj4 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        this.ExN = qj4;
        qj4.setId(520093707);
        this.ExN.setGravity(17);
        this.ExN.setText(com.bytedance.sdk.component.utils.Sfl.sc(context, "tt_video_download_apk"));
        this.ExN.setTextColor(-1);
        this.ExN.setTextSize(2, 16.0f);
        this.ExN.setBackground(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_reward_full_video_backup_btn_bg"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, kX.zY(context, 44.0f));
        layoutParams5.topMargin = kX.zY(context, 54.0f);
        exN.addView(this.ExN, layoutParams5);
        this.TRI = new PAGLogoView(context);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, kX.zY(context, 14.0f));
        layoutParams6.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
        layoutParams6.leftMargin = kX.zY(context, 18.0f);
        if (z11) {
            layoutParams6.bottomMargin = kX.zY(context, 61.0f);
        } else {
            layoutParams6.bottomMargin = kX.zY(context, 24.0f);
        }
        addView(this.TRI, layoutParams6);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void sc() {
        if (this.f28544sc) {
            return;
        }
        this.f28544sc = true;
        pFF();
        this.ExN.setOnClickListener(this.WH);
        this.ExN.setOnTouchListener(this.WH);
        String strNQ = this.Qj.NQ();
        if (!TextUtils.isEmpty(strNQ)) {
            this.ExN.setText(strNQ);
        }
        if (this.pFF != null && this.Qj.qfG() != null && !TextUtils.isEmpty(this.Qj.qfG().sc())) {
            com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.Qj.qfG(), this.pFF, this.Qj);
        }
        dE dEVar = this.We;
        if (dEVar != null) {
            kX.sc((TextView) null, dEVar, this.Qj);
            if (this.Qj.NP() != null) {
                this.We.setVisibility(0);
            }
        }
        if (this.zY != null) {
            if (this.Qj.NP() != null && !TextUtils.isEmpty(this.Qj.NP().pFF())) {
                this.zY.setText(this.Qj.NP().pFF());
            } else if (TextUtils.isEmpty(this.Qj.MxZ())) {
                this.zY.setVisibility(8);
            } else {
                this.zY.setText(this.Qj.MxZ());
            }
        }
        if (this.f28543qr != null) {
            String strYdT = this.Qj.YdT();
            if (TextUtils.isEmpty(strYdT)) {
                this.f28543qr.setVisibility(8);
            } else {
                this.f28543qr.setText(strYdT);
            }
        }
        this.TRI.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.WH.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.sc(WH.this.getContext(), WH.this.Qj, WH.this.Ol);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, String str, com.bytedance.sdk.openadsdk.core.pFF.sc scVar) {
        this.Qj = sfl;
        this.Ol = str;
        this.WH = scVar;
    }

    public void setClickListener(com.bytedance.sdk.openadsdk.core.pFF.sc scVar) {
        this.WH = scVar;
        TextView textView = this.ExN;
        if (textView != null) {
            textView.setOnClickListener(scVar);
            this.ExN.setOnTouchListener(this.WH);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        if (i11 == 0) {
            sc();
        }
    }
}
