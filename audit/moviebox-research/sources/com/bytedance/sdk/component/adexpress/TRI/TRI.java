package com.bytedance.sdk.component.adexpress.TRI;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI extends uEA {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private YIK f26688sc;

    public TRI(Context context, int i11, int i12, int i13, JSONObject jSONObject) {
        super(context);
        sc(context, i11, i12, i13, jSONObject);
    }

    private void sc(Context context, int i11, int i12, int i13, JSONObject jSONObject) {
        YIK yik = new YIK(context, com.bytedance.sdk.component.adexpress.zY.sc.zY(context), i11, i12, i13, jSONObject);
        this.f26688sc = yik;
        addView(yik);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.f26688sc.setLayoutParams(layoutParams);
    }

    public YIK getShakeView() {
        return this.f26688sc;
    }

    public void setShakeText(String str) {
        if (this.f26688sc == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f26688sc.setShakeText("");
        } else {
            this.f26688sc.setShakeText(str);
        }
    }
}
