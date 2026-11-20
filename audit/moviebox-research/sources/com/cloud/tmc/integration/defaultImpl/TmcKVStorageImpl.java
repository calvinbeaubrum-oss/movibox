package com.cloud.tmc.integration.defaultImpl;

import android.content.Context;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.tencent.mmkv.MMKV;
import ke.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class TmcKVStorageImpl implements KVStorageProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f30723a = "TmcKVStorageImpl";

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public void clear(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        new a(context, appId, true, null, 8, null).a();
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public String[] getAllKeys(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        return new a(context, appId, true, null, 8, null).c().allKeys();
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public boolean getBoolean(Context context, String appId, String key, boolean z11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(key, "key");
        return new a(context, appId, true, null, 8, null).b(key, z11);
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public int getInt(Context context, String appId, String key) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(key, "key");
        return le.a.C0753a.a(new a(context, appId, true, null, 8, null), key, 0, 2, null);
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public long getKVSize(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        try {
            MMKV mmkvC = new a(context, appId, true, null, 8, null).c();
            String[] strArrAllKeys = mmkvC.allKeys();
            if (strArrAllKeys == null) {
                return 0L;
            }
            long jS = 0;
            for (String str : strArrAllKeys) {
                jS += (long) mmkvC.s(str);
            }
            return jS;
        } catch (Throwable th2) {
            TmcLogger.h("TmcKVStorageImpl", th2);
            return 0L;
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public long getLong(Context context, String appId, String key) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(key, "key");
        return le.a.C0753a.b(new a(context, appId, true, null, 8, null), key, 0L, 2, null);
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public String[] getMMKVFileAllKeys(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        try {
            return new a(context, appId, true, null, 8, null).c().allKeys();
        } catch (Throwable th2) {
            TmcLogger.h("TmcKVStorageImpl", th2);
            return null;
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public String getString(Context context, String appId, String key) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(key, "key");
        return le.a.C0753a.c(new a(context, appId, true, null, 8, null), key, null, 2, null);
    }

    public final String getTAG() {
        return this.f30723a;
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public void putBoolean(Context context, String appId, String key, boolean z11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(key, "key");
        try {
            new a(context, appId, true, null, 8, null).d(key, z11);
        } catch (Throwable th2) {
            TmcLogger.h(this.f30723a, th2);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public void putInt(Context context, String appId, String key, int i11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(key, "key");
        try {
            new a(context, appId, true, null, 8, null).e(key, i11);
        } catch (Throwable th2) {
            TmcLogger.h(this.f30723a, th2);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public void putLong(Context context, String appId, String key, long j11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(key, "key");
        try {
            new a(context, appId, true, null, 8, null).f(key, j11);
        } catch (Throwable th2) {
            TmcLogger.h(this.f30723a, th2);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public void putString(Context context, String appId, String key, String value) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(key, "key");
        Intrinsics.g(value, "value");
        try {
            new a(context, appId, true, null, 8, null).g(key, value);
        } catch (Throwable th2) {
            TmcLogger.h(this.f30723a, th2);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public void remove(Context context, String appId, String key) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(key, "key");
        try {
            new a(context, appId, true, null, 8, null).h(key);
        } catch (Throwable unused) {
            TmcLogger.e(this.f30723a);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public void warmUpMMKVFile(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        try {
            new a(context, appId, true, null, 8, null);
        } catch (Throwable th2) {
            TmcLogger.e("warmUpMMKVFile error: " + th2.getMessage());
        }
    }
}
