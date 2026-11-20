package com.bytedance.sdk.openadsdk.zY;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.Sfl;
import com.bytedance.sdk.openadsdk.core.Xc;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile pFF f28822sc;
    private final Sfl<com.bytedance.sdk.openadsdk.We.sc> pFF = Xc.zY();

    private pFF() {
    }

    public static pFF sc() {
        if (f28822sc == null) {
            synchronized (pFF.class) {
                try {
                    if (f28822sc == null) {
                        f28822sc = new pFF();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f28822sc;
    }

    public void sc(@NonNull String str, List<FilterWord> list, String str2) {
        sc(str, list, null, null, str2);
    }

    public void sc(@NonNull String str, List<FilterWord> list, String str2, String str3, String str4) {
        this.pFF.sc(str, list, str2, str3, str4);
    }
}
