package com.bytedance.sdk.openadsdk.JPJ.pFF;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.Gb;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI {
    public static boolean sc(View view, int i11) {
        return sc(view, false, i11);
    }

    public static boolean sc(View view, boolean z11, int i11) {
        if (view == null) {
            return false;
        }
        return Gb.sc(view, z11 ? 30 : 50, i11);
    }
}
