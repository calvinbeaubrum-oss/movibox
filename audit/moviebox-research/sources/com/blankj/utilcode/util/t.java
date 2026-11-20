package com.blankj.utilcode.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class t {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f25338b = new a(Utils.a().getPackageName(), Utils.a().getPackageName(), 3);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NotificationChannel f25339a;

        public a(String str, CharSequence charSequence, int i11) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f25339a = k1.h.a(str, charSequence, i11);
            }
        }

        public NotificationChannel b() {
            return this.f25339a;
        }
    }

    public static Notification a(a aVar, Utils.b<NotificationCompat.m> bVar) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            ((NotificationManager) Utils.a().getSystemService("notification")).createNotificationChannel(aVar.b());
        }
        NotificationCompat.m mVar = new NotificationCompat.m(Utils.a());
        if (i11 >= 26) {
            mVar.n(aVar.f25339a.getId());
        }
        if (bVar != null) {
            bVar.accept(mVar);
        }
        return mVar.c();
    }
}
