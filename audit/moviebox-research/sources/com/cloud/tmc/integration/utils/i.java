package com.cloud.tmc.integration.utils;

import android.text.TextUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f31064a = "";

    public static String a() {
        try {
            if (TextUtils.isEmpty(f31064a) && ws.a.a().getApplicationContext() != null) {
                f31064a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS Z").format(new Date(ws.a.a().getApplicationContext().getPackageManager().getPackageInfo(ws.a.a().getApplicationContext().getPackageName(), 0).firstInstallTime));
            }
        } catch (Throwable th2) {
            TmcLogger.f("ApplicationUtil", "获取安装时间失败：" + th2);
        }
        return f31064a;
    }
}
