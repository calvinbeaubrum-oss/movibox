package com.cloud.tmc.kernel.proxy.storage;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@c("com.cloud.tmc.integration.defaultImpl.TmcKVStorageImpl")
public interface KVStorageProxy {
    void clear(@NonNull Context context, @NonNull String str);

    String[] getAllKeys(@NonNull Context context, @NonNull String str);

    @Nullable
    boolean getBoolean(@NonNull Context context, @NonNull String str, @NonNull String str2, @Nullable boolean z11);

    int getInt(@NonNull Context context, @NonNull String str, @NonNull String str2);

    long getKVSize(@NonNull Context context, @NonNull String str);

    long getLong(@NonNull Context context, @NonNull String str, @NonNull String str2);

    String[] getMMKVFileAllKeys(@NonNull Context context, @NonNull String str);

    @Nullable
    String getString(@NonNull Context context, @NonNull String str, @NonNull String str2);

    @Nullable
    void putBoolean(@NonNull Context context, @NonNull String str, @NonNull String str2, boolean z11);

    void putInt(@NonNull Context context, @NonNull String str, @NonNull String str2, int i11);

    void putLong(@NonNull Context context, @NonNull String str, @NonNull String str2, long j11);

    void putString(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3);

    void remove(@NonNull Context context, @NonNull String str, @NonNull String str2);

    void warmUpMMKVFile(@NonNull Context context, @NonNull String str);
}
