package com.transsion.lib_web.zip;

import android.net.Network;
import android.net.NetworkCapabilities;
import com.tn.lib.util.networkinfo.f;
import com.tn.lib.util.networkinfo.g;
import hu.h;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ObserveNetworkState implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObserveNetworkState f53068a = new ObserveNetworkState();

    private final String a() {
        String simpleName = ObserveNetworkState.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    private final void b(String str) {
        j.d(l0.a(w0.b()), null, null, new ObserveNetworkState$retryDownload$1(null), 3, null);
    }

    public final void c() {
        f.f49475a.l(this);
        b("冷启动");
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected() {
        g.a.a(this);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
        h.f66795a.a(a() + " --> onConnected() --> 网络重新链接的时候检查一下字幕下载 --> 延迟5秒，优化网络抖动 .....");
        b("网络重新连接");
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onDisconnected() {
    }
}
