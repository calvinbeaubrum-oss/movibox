package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We {
    private static volatile int We = 0;
    private static volatile String pFF = "";

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile String f28497sc = "";
    private static String zY;

    public static String We() {
        if (TextUtils.isEmpty(zY)) {
            zY = Xc.sc().getPackageManager().getInstallerPackageName(cJ.ExN());
        }
        if (zY == null) {
            zY = "";
        }
        return zY;
    }

    public static String pFF() {
        if (We != 0) {
            return f28497sc;
        }
        sc();
        return f28497sc;
    }

    public static void sc() {
        try {
            AppSet.getClient(Xc.sc()).getAppSetIdInfo().addOnSuccessListener(new OnSuccessListener<AppSetIdInfo>() { // from class: com.bytedance.sdk.openadsdk.core.settings.AppSetIdAndScope$1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                @Keep
                public void onSuccess(AppSetIdInfo appSetIdInfo) {
                    String unused = We.f28497sc = Integer.toString(appSetIdInfo.getScope());
                    String unused2 = We.pFF = appSetIdInfo.getId();
                    int unused3 = We.We = 1;
                }
            });
        } catch (Throwable unused) {
            We = 2;
        }
    }

    public static String zY() {
        if (We != 0) {
            return pFF;
        }
        sc();
        return pFF;
    }
}
