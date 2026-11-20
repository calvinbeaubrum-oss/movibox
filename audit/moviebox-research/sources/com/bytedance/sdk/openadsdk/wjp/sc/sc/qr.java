package com.bytedance.sdk.openadsdk.wjp.sc.sc;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.cJ;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr {
    public static TRI sc(Context context, Sfl sfl, String str) {
        if (zY.sc()) {
            return new ExN(context, sfl, str);
        }
        return cJ.Qj(context) ? new We(context, sfl, str) : new sc(context, sfl, str);
    }
}
