package com.transsion.publish;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;
import uo.b;

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
public final class NetworkReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f56334d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f56331a = -3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f56332b = PublishManager.TAG;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f56333c = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f56335e = 1;

    public final int a(Context context) {
        Object systemService = context != null ? context.getSystemService("connectivity") : null;
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return this.f56333c;
        }
        if (activeNetworkInfo.getType() == 1) {
            return this.f56334d;
        }
        return activeNetworkInfo.getType() == 0 ? this.f56335e : this.f56333c;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.d(intent);
        if (l.w(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE", false, 2, null)) {
            int iA = a(context);
            if (iA == 0 && this.f56331a != 0) {
                this.f56331a = iA;
                PublishManager.Companion.a().onConnected(null);
                return;
            }
            if (iA == 1 && this.f56331a != 1) {
                this.f56331a = iA;
                b.a.f(b.f78622a, this.f56332b, "数据网络", false, 4, null);
                PublishManager.Companion.a().onConnected(null);
            } else {
                if (iA != -1 || this.f56331a == -1) {
                    return;
                }
                this.f56331a = iA;
                b.a.f(b.f78622a, this.f56332b, "无网络", false, 4, null);
                PublishManager.Companion.a().onDisconnected();
            }
        }
    }
}
