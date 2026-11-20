package com.transsion.push.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.service.JobIntentService;
import com.transsion.push.service.PushJobIntentService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceUtils {

    /* JADX INFO: compiled from: source.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f57040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f57041b;

        public a(Bundle bundle, Context context) {
            this.f57040a = bundle;
            this.f57041b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent();
            intent.putExtras(this.f57040a);
            ServiceUtils.c(this.f57041b, intent);
        }
    }

    public static void b(Context context, Intent intent) {
        try {
            JobIntentService.enqueueWork(context, PushJobIntentService.class, 1003, intent.setComponent(new ComponentName(context, (Class<?>) PushJobIntentService.class)));
        } catch (Exception e11) {
            PushLogUtils.LOG.i("start job intent service exception, e:" + e11.getMessage());
        }
    }

    public static void c(Context context, Intent intent) {
        try {
            c.a.b(intent);
        } catch (Exception e11) {
            PushLogUtils.LOG.i("start job intent service exception, e:" + e11.getMessage());
        }
    }

    public static void startJobThread(Context context, Bundle bundle) {
        ThreadManager.executeInBackground(new a(bundle, context));
    }

    public static void startTargetIntentService(Context context, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        b(context, intent);
    }

    public static void startTargetIntentService(PushMessage pushMessage) {
    }
}
