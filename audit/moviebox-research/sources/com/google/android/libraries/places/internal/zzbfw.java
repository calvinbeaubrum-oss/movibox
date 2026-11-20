package com.google.android.libraries.places.internal;

import java.io.Closeable;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public interface zzbfw extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    zzbgf zza(SocketAddress socketAddress, zzbfv zzbfvVar, zzaym zzaymVar);

    ScheduledExecutorService zzb();
}
