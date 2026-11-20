package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF extends Dialog {
    private com.bytedance.sdk.openadsdk.core.ExN.sc ExN;
    private String Ol;
    private final Context Qj;
    private int Ql;
    private boolean SR;
    private com.bytedance.sdk.openadsdk.core.ExN.sc TRI;
    private String Tf;
    private String UFX;
    private String WH;
    private com.bytedance.sdk.openadsdk.core.ExN.Qj We;
    private com.bytedance.sdk.openadsdk.core.ExN.We pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private View f28548qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public sc f28549sc;
    private com.bytedance.sdk.openadsdk.core.ExN.Qj zY;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void pFF();

        void sc();
    }

    public pFF(Context context) {
        super(context, com.bytedance.sdk.component.utils.Sfl.TRI(context, "tt_custom_dialog"));
        this.Ql = -1;
        this.SR = false;
        this.Qj = context;
    }

    private void pFF() {
        if (TextUtils.isEmpty(this.WH)) {
            this.zY.setVisibility(8);
        } else {
            this.zY.setText(this.WH);
            this.zY.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.Ol)) {
            this.We.setText(this.Ol);
        }
        if (TextUtils.isEmpty(this.UFX)) {
            this.TRI.setText(com.bytedance.sdk.component.utils.Sfl.sc(com.bytedance.sdk.openadsdk.core.Xc.sc(), "tt_postive_txt"));
        } else {
            this.TRI.setText(this.UFX);
        }
        if (TextUtils.isEmpty(this.Tf)) {
            this.ExN.setText(com.bytedance.sdk.component.utils.Sfl.sc(com.bytedance.sdk.openadsdk.core.Xc.sc(), "tt_negtive_txt"));
        } else {
            this.ExN.setText(this.Tf);
        }
        int i11 = this.Ql;
        if (i11 != -1) {
            this.pFF.setImageResource(i11);
            this.pFF.setVisibility(0);
        } else {
            this.pFF.setVisibility(8);
        }
        if (this.SR) {
            this.f28548qr.setVisibility(8);
            this.ExN.setVisibility(8);
        } else {
            this.ExN.setVisibility(0);
            this.f28548qr.setVisibility(0);
        }
    }

    private int sc(float f11) {
        return kX.zY(getContext(), f11);
    }

    private View sc(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.qr qrVar = new com.bytedance.sdk.openadsdk.core.ExN.qr(context);
        qrVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        exN.setMinimumWidth(sc(260.0f));
        exN.setPadding(0, sc(32.0f), 0, 0);
        exN.setBackground(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_custom_dialog_bg"));
        exN.setOrientation(1);
        exN.setLayoutParams(layoutParams);
        this.zY = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.leftMargin = sc(16.0f);
        layoutParams2.rightMargin = sc(16.0f);
        layoutParams2.bottomMargin = sc(16.0f);
        this.zY.setGravity(17);
        this.zY.setVisibility(0);
        this.zY.setTextColor(Color.parseColor("#333333"));
        this.zY.setTextSize(18.0f);
        this.zY.setLayoutParams(layoutParams2);
        this.pFF = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        layoutParams3.leftMargin = sc(16.0f);
        layoutParams3.rightMargin = sc(16.0f);
        layoutParams3.bottomMargin = sc(10.0f);
        this.pFF.setMaxHeight(sc(150.0f));
        this.pFF.setMaxWidth(sc(150.0f));
        this.pFF.setVisibility(0);
        this.pFF.setLayoutParams(layoutParams3);
        this.We = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.leftMargin = sc(20.0f);
        layoutParams4.rightMargin = sc(20.0f);
        this.We.setGravity(17);
        this.We.setLineSpacing(sc(3.0f), 1.2f);
        this.We.setTextSize(18.0f);
        this.We.setTextColor(Color.parseColor("#000000"));
        this.We.setLayoutParams(layoutParams4);
        View view = new View(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, 1);
        layoutParams5.topMargin = sc(32.0f);
        view.setBackgroundColor(Color.parseColor("#E4E4E4"));
        view.setLayoutParams(layoutParams5);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN2 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        exN2.setOrientation(0);
        exN2.setLayoutParams(layoutParams6);
        com.bytedance.sdk.openadsdk.core.ExN.sc scVar = new com.bytedance.sdk.openadsdk.core.ExN.sc(context);
        this.ExN = scVar;
        scVar.setId(520093718);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -2);
        layoutParams7.leftMargin = sc(10.0f);
        layoutParams7.weight = 1.0f;
        this.ExN.setPadding(0, sc(16.0f), 0, sc(16.0f));
        this.ExN.setBackground(null);
        this.ExN.setGravity(17);
        this.ExN.setSingleLine(true);
        this.ExN.setTextColor(Color.parseColor("#999999"));
        this.ExN.setTextSize(16.0f);
        this.ExN.setLayoutParams(layoutParams7);
        this.f28548qr = new View(context);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(1, -1);
        this.f28548qr.setBackgroundColor(Color.parseColor("#E4E4E4"));
        this.f28548qr.setLayoutParams(layoutParams8);
        this.TRI = new com.bytedance.sdk.openadsdk.core.ExN.sc(context);
        this.ExN.setId(520093719);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(0, -2);
        layoutParams9.rightMargin = sc(10.0f);
        layoutParams9.weight = 1.0f;
        this.TRI.setPadding(0, sc(16.0f), 0, sc(16.0f));
        this.TRI.setBackground(null);
        this.TRI.setGravity(17);
        this.TRI.setSingleLine(true);
        this.TRI.setTextColor(Color.parseColor("#38ADFF"));
        this.TRI.setTextSize(16.0f);
        this.TRI.setLayoutParams(layoutParams9);
        qrVar.addView(exN);
        exN.addView(this.zY);
        exN.addView(this.pFF);
        exN.addView(this.We);
        exN.addView(view);
        exN.addView(exN2);
        exN2.addView(this.ExN);
        exN2.addView(this.f28548qr);
        exN2.addView(this.TRI);
        return qrVar;
    }

    private void sc() {
        this.TRI.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.pFF.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                sc scVar = pFF.this.f28549sc;
                if (scVar != null) {
                    scVar.sc();
                }
            }
        });
        this.ExN.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.pFF.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                sc scVar = pFF.this.f28549sc;
                if (scVar != null) {
                    scVar.pFF();
                }
            }
        });
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(sc(this.Qj));
        setCanceledOnTouchOutside(false);
        pFF();
        sc();
    }

    public pFF pFF(String str) {
        this.UFX = str;
        return this;
    }

    public pFF sc(sc scVar) {
        this.f28549sc = scVar;
        return this;
    }

    public pFF sc(String str) {
        this.Ol = str;
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        pFF();
    }

    public pFF zY(String str) {
        this.Tf = str;
        return this;
    }
}
