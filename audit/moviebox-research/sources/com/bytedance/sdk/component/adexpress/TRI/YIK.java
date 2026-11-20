package com.bytedance.sdk.component.adexpress.TRI;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class YIK extends Sfl {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private TextView f26706sc;

    public YIK(@NonNull Context context, View view, int i11, int i12, int i13, JSONObject jSONObject) {
        super(context, view, i11, i12, i13, jSONObject);
    }

    @Override // com.bytedance.sdk.component.adexpress.TRI.Sfl
    public void sc(Context context, View view) {
        addView(view);
        this.f26706sc = (TextView) findViewById(2097610747);
    }

    @Override // com.bytedance.sdk.component.adexpress.TRI.Sfl
    public void setShakeText(String str) {
        if (this.f26706sc == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f26706sc.setText(str);
            return;
        }
        try {
            this.f26706sc.setText(com.bytedance.sdk.component.utils.Sfl.pFF(this.f26706sc.getContext(), "tt_splash_default_click_shake"));
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("shakeClickView", e11.getMessage());
        }
    }
}
