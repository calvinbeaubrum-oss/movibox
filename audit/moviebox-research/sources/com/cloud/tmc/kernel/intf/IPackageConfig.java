package com.cloud.tmc.kernel.intf;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@c("com.cloud.tmc.miniapp.GlobalPackageConfig")
public interface IPackageConfig {
    String getAppId();

    String getDevSDKVersion();

    @Nullable
    String getFrameworkVersion();

    boolean getOpenMutipleTask();

    String getSDKVersion();

    void setAppId(@NonNull String str);

    void setFrameworkVersion(@Nullable String str);

    void setOpenMutipleTask(boolean z11);
}
