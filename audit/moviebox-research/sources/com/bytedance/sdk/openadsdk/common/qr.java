package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr extends Button {
    public qr(Context context) {
        super(context);
        sc();
    }

    private void sc() {
        setId(com.bytedance.sdk.openadsdk.utils.SR.QST);
        Context context = getContext();
        setLayoutParams(new ViewGroup.LayoutParams(-1, kX.zY(context, 48.0f)));
        setBackground(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_browser_download_selector"));
        setText(Sfl.sc(context, "tt_video_download_apk"));
        setTextColor(-1);
        setTextSize(2, 16.0f);
    }
}
