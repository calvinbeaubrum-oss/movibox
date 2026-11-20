package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcdr {
    public static final ThreadPoolExecutor zza = new ThreadPoolExecutor(2, Api.BaseClientBuilder.API_PRIORITY_OTHER, 10, TimeUnit.SECONDS, new SynchronousQueue(), new zzcdq("ClientDefault"));
    public static final ExecutorService zzb = Executors.newSingleThreadExecutor(new zzcdq("ClientSingle"));
}
