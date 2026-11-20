package com.cloud.tmc.integration.utils;

import android.content.Context;
import com.cloud.tmc.integration.bridge.FrameworkStorageBridge;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f31062a = new h0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f31063b = new AtomicBoolean(false);

    public final void a(Context context) {
        Intrinsics.g(context, "context");
        if (f31063b.compareAndSet(true, false)) {
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, "100000", "isNewUser", false);
        }
    }

    public final void b(Context context, String str) {
        Intrinsics.g(context, "context");
        boolean z11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getBoolean(context, "100000", "privacy_agreement", false);
        String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, FrameworkStorageBridge.FRAMEWORK_STORAGE_KEY, "dlt-privacy-aggrement");
        boolean z12 = string != null && kotlin.text.l.v(string, "true", true);
        boolean zD = AppUtils.f31011a.d(str);
        TmcLogger.c("privacy", "updateNewUserStatus -> inPrivacyWhiteList:" + zD + ", fwPackageAgree:" + string + ", agree:" + z11);
        if (!zD && !z12 && !z11) {
            f31063b.set(true);
            return;
        }
        if (zD && f0.f31050a.f(str)) {
            TmcLogger.c("privacy", "mfah is true,return");
            return;
        }
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, "100000", "isNewUser", false);
        try {
            Boolean bool = f0.f31050a.i().get(str);
            if (bool == null || !bool.booleanValue()) {
                q.f31091a.r("");
            }
        } catch (Throwable unused) {
        }
    }
}
