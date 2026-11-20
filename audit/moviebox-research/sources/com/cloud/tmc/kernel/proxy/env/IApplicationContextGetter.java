package com.cloud.tmc.kernel.proxy.env;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@c("com.cloud.tmc.miniapp.defaultimpl.TmcApplicationContextGetter")
public interface IApplicationContextGetter {
    @NonNull
    Application getApplication();

    @NonNull
    Context getApplicationContext();
}
