package com.bytedance.sdk.openadsdk.multipro.aidl.sc;

import android.content.ContentValues;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.settings.Tf;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI extends com.bytedance.sdk.component.TRI.sc.TRI.sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile TRI f28644sc;

    public static TRI pFF() {
        if (f28644sc == null) {
            synchronized (TRI.class) {
                try {
                    if (f28644sc == null) {
                        f28644sc = new TRI();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f28644sc;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.TRI
    public int sc(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (Tf.sc()) {
            return com.bytedance.sdk.openadsdk.multipro.ExN.sc(Xc.sc()).sc(uri, contentValues, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.TRI
    public int sc(Uri uri, String str, String[] strArr) {
        if (Tf.sc()) {
            return com.bytedance.sdk.openadsdk.multipro.ExN.sc(Xc.sc()).sc(uri, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.TRI
    public String sc(Uri uri) {
        if (Tf.sc()) {
            return com.bytedance.sdk.openadsdk.multipro.ExN.sc(Xc.sc()).sc(uri);
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.TRI
    public String sc(Uri uri, ContentValues contentValues) {
        Uri uriSc;
        if (Tf.sc() && (uriSc = com.bytedance.sdk.openadsdk.multipro.ExN.sc(Xc.sc()).sc(uri, contentValues)) != null) {
            return uriSc.toString();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.TRI
    public Map sc(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!Tf.sc()) {
            return null;
        }
        try {
            return com.bytedance.sdk.openadsdk.multipro.sc.sc.sc(com.bytedance.sdk.openadsdk.multipro.ExN.sc(Xc.sc()).sc(uri, strArr, str, strArr2, str2));
        } catch (Throwable unused) {
            return null;
        }
    }
}
