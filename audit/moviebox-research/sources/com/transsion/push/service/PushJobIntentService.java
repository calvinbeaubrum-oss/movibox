package com.transsion.push.service;

import android.content.Intent;
import androidx.annotation.NonNull;
import c.a;
import com.transsion.push.utils.PushLogUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class PushJobIntentService extends JobIntentService {
    @Override // com.transsion.push.service.JobIntentService
    public void c(@NonNull Intent intent) {
        a.b(intent);
    }

    @Override // com.transsion.push.service.JobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        PushLogUtils.LOG.g("PushJobIntentService---------->onCreate");
    }

    @Override // com.transsion.push.service.JobIntentService, android.app.Service
    public void onDestroy() {
        PushLogUtils.LOG.g("PushJobIntentService---------->onDestroy");
        super.onDestroy();
    }
}
