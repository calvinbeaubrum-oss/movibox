package com.cloud.tmc.kernel.service;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@c("com.cloud.tmc.miniapp.defaultimpl.EnvironmentServiceImpl")
public interface EnvironmentService {
    @NonNull
    String defaultPlatform();

    @Nullable
    String getAppLanguage();

    @NonNull
    String getAppName();

    @NonNull
    Application getApplicationContext();

    int getLpid();

    @NonNull
    String getProductVersion();

    @NonNull
    Resources getResources();

    @NonNull
    WeakReference<Activity> getTopActivity();
}
