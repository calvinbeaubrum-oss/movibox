package com.bytedance.sdk.openadsdk.multipro.zY;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.TRI.sc.TRI;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.multipro.We;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc implements com.bytedance.sdk.openadsdk.multipro.sc {
    private static String ExN() {
        return We.pFF + "/t_frequent/";
    }

    private static TRI We() {
        try {
            if (Xc.sc() != null) {
                return com.bytedance.sdk.openadsdk.multipro.sc.sc.sc(Xc.sc());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean pFF() {
        if (Xc.sc() == null) {
            return false;
        }
        try {
            TRI triWe = We();
            if (triWe != null) {
                return "true".equals(triWe.sc(Uri.parse(ExN() + "isSilent")));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean sc(String str) {
        if (Xc.sc() == null) {
            return false;
        }
        try {
            TRI triWe = We();
            if (triWe != null) {
                return "true".equals(triWe.sc(Uri.parse(ExN() + "checkFrequency?rit=" + str)));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String zY() {
        if (Xc.sc() == null) {
            return null;
        }
        try {
            TRI triWe = We();
            if (triWe != null) {
                return triWe.sc(Uri.parse(ExN() + "maxRit"));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public int sc(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public int sc(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public Cursor sc(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public Uri sc(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    @NonNull
    public String sc() {
        return "t_frequent";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public String sc(@NonNull Uri uri) {
        Objects.toString(uri);
        String str = uri.getPath().split("/")[2];
        if ("checkFrequency".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.qr.sc.sc().sc(uri.getQueryParameter("rit")) ? "true" : "false";
        }
        if ("isSilent".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.qr.sc.sc().pFF() ? "true" : "false";
        }
        if ("maxRit".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.qr.sc.sc().zY();
        }
        return null;
    }
}
