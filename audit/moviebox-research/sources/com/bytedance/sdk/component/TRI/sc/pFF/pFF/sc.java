package com.bytedance.sdk.component.TRI.sc.pFF.pFF;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.TRI.sc.Qj;
import com.bytedance.sdk.component.TRI.sc.sc.sc.TRI;
import com.bytedance.sdk.component.TRI.sc.sc.sc.qr;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    private static String We() {
        return qr.pFF + "/ad_log_event/";
    }

    public static void pFF() {
        if (Qj.qr().TRI() == null) {
            return;
        }
        try {
            ContentResolver contentResolverZY = zY();
            if (contentResolverZY != null) {
                contentResolverZY.getType(Uri.parse(We() + "adLogStop"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void sc() {
        if (Qj.qr().TRI() == null) {
            return;
        }
        try {
            ContentResolver contentResolverZY = zY();
            if (contentResolverZY != null) {
                contentResolverZY.getType(Uri.parse(We() + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void sc(com.bytedance.sdk.component.TRI.sc.We.sc scVar) {
        if (scVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverZY = zY();
            if (contentResolverZY != null) {
                contentResolverZY.getType(Uri.parse(We() + "adLogDispatch?event=" + TRI.sc(scVar.TRI())));
            }
        } catch (Throwable th2) {
            th2.toString();
        }
    }

    public static void sc(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverZY = zY();
            if (contentResolverZY != null) {
                contentResolverZY.getType(Uri.parse(We() + "trackAdFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }

    public static void sc(String str, List<String> list, boolean z11) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb2.append(TRI.sc(it.next()));
                sb2.append(",");
            }
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(TRI.sc(sb2.toString())) + "&replace=" + String.valueOf(z11);
            ContentResolver contentResolverZY = zY();
            if (contentResolverZY != null) {
                contentResolverZY.getType(Uri.parse(We() + "trackAdUrl" + str2));
            }
        } catch (Throwable unused) {
        }
    }

    private static ContentResolver zY() {
        try {
            if (Qj.qr().TRI() != null) {
                return Qj.qr().TRI().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
