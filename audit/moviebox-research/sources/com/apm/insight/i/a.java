package com.apm.insight.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.apm.insight.runtime.q;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile UUID f16829a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f16830b = "";

    @SuppressLint({"MissingPermission", "HardwareIds"})
    private a(Context context) {
        String string;
        if (f16829a == null) {
            synchronized (a.class) {
                if (f16829a == null) {
                    String strC = q.a().c();
                    if (strC != null) {
                        f16829a = UUID.fromString(strC);
                    } else {
                        try {
                            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                        } catch (Throwable unused) {
                            string = null;
                        }
                        try {
                            if (string != null) {
                                f16829a = UUID.nameUUIDFromBytes(string.getBytes("utf8"));
                            } else {
                                f16829a = UUID.randomUUID();
                            }
                        } catch (Throwable unused2) {
                        }
                        try {
                            q.a().b(f16829a.toString());
                        } catch (Throwable unused3) {
                        }
                    }
                }
            }
        }
    }

    public static synchronized String a(Context context) {
        try {
            if (TextUtils.isEmpty(f16830b)) {
                new a(context);
                UUID uuid = f16829a;
                if (uuid != null) {
                    f16830b = uuid.toString();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f16830b;
    }
}
