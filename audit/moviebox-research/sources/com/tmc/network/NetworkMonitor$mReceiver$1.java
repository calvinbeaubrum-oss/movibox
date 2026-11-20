package com.tmc.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import po.c;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class NetworkMonitor$mReceiver$1 extends BroadcastReceiver {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onReceive$lambda-0, reason: not valid java name */
    public static final void m160onReceive$lambda0(Context c11) {
        Intrinsics.g(c11, "$c");
        NetworkMonitor.INSTANCE.checkNetworkStatus(c11);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context c11, Intent intent) {
        Intrinsics.g(c11, "c");
        Intrinsics.g(intent, "intent");
        c cVarA = c.f73961c.a();
        if (cVarA == null) {
            return;
        }
        cVarA.a(new Runnable() { // from class: com.tmc.network.b
            @Override // java.lang.Runnable
            public final void run() {
                NetworkMonitor$mReceiver$1.m160onReceive$lambda0(c11);
            }
        });
    }
}
