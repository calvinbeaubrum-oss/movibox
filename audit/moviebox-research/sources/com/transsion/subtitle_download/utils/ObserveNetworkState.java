package com.transsion.subtitle_download.utils;

import android.net.Network;
import android.net.NetworkCapabilities;
import com.tn.lib.util.networkinfo.f;
import com.tn.lib.util.networkinfo.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ObserveNetworkState implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObserveNetworkState f58373a = new ObserveNetworkState();

    /* JADX INFO: Access modifiers changed from: private */
    public final String b() {
        String simpleName = ObserveNetworkState.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void c(String str) {
        j.d(l0.a(w0.b()), null, null, new ObserveNetworkState$retryDownload$1(str, null), 3, null);
    }

    public final void d() {
        f.f49475a.l(this);
        c("冷启动");
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected() {
        g.a.a(this);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
        b.f58375a.a(b() + " --> onConnected() --> 网络重新链接的时候检查一下字幕下载 --> 延迟5秒，优化网络抖动 .....");
        c("网络重新连接");
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onDisconnected() {
    }
}
