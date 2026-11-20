package com.bytedance.sdk.component.adexpress.dynamic.zY;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.TRI.cvk;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Sfl implements qr<cvk> {
    private String ExN;
    private com.bytedance.sdk.component.adexpress.dynamic.We.WH TRI;
    private com.bytedance.sdk.component.adexpress.dynamic.We.qr We;
    private Context pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private cvk f26853sc;
    private com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN zY;

    public Sfl(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN exN, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar, String str, com.bytedance.sdk.component.adexpress.dynamic.We.WH wh2) {
        this.pFF = context;
        this.zY = exN;
        this.We = qrVar;
        this.ExN = str;
        this.TRI = wh2;
        ExN();
    }

    private void ExN() {
        int iEo = this.We.eo();
        final com.bytedance.sdk.component.adexpress.dynamic.TRI.sc dynamicClickListener = this.zY.getDynamicClickListener();
        try {
            new JSONObject().put("convertActionType", 2);
        } catch (Throwable unused) {
        }
        if ("18".equals(this.ExN)) {
            Context context = this.pFF;
            cvk cvkVar = new cvk(context, com.bytedance.sdk.component.adexpress.zY.sc.Ol(context), this.TRI);
            this.f26853sc = cvkVar;
            if (cvkVar.getWriggleLayout() != null) {
                this.f26853sc.getWriggleLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
            if (this.f26853sc.getTopTextView() != null) {
                if (TextUtils.isEmpty(this.We.DNB())) {
                    this.f26853sc.getTopTextView().setText(com.bytedance.sdk.component.utils.Sfl.pFF(this.pFF, "tt_splash_wriggle_top_text_style_17"));
                } else {
                    this.f26853sc.getTopTextView().setText(this.We.DNB());
                }
            }
        } else {
            Context context2 = this.pFF;
            this.f26853sc = new cvk(context2, com.bytedance.sdk.component.adexpress.zY.sc.Ol(context2), this.TRI);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        this.f26853sc.setTranslationY(-((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.pFF, iEo)));
        this.f26853sc.setLayoutParams(layoutParams);
        this.f26853sc.setShakeText(this.We.OKY());
        this.f26853sc.setClipChildren(false);
        final View wriggleProgressIv = this.f26853sc.getWriggleProgressIv();
        this.f26853sc.setOnShakeViewListener(new cvk.sc() { // from class: com.bytedance.sdk.component.adexpress.dynamic.zY.Sfl.1
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    /* JADX INFO: renamed from: We, reason: merged with bridge method [inline-methods] */
    public cvk zY() {
        return this.f26853sc;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void pFF() {
        this.f26853sc.clearAnimation();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.qr
    public void sc() {
        this.f26853sc.sc();
    }
}
