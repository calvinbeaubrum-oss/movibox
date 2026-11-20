package com.cloud.sdk.commonutil.util;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f30275a;

    public static String a() {
        if (TextUtils.isEmpty(f30275a) && f.a().getApplicationContext() != null) {
            try {
                f30275a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS Z").format(new Date(f.a().getApplicationContext().getPackageManager().getPackageInfo(f.a().getApplicationContext().getPackageName(), 0).firstInstallTime));
            } catch (Exception e11) {
                c.Log().d("ssp", "get installTime is error: " + e11.getMessage());
            }
        }
        return f30275a;
    }
}
