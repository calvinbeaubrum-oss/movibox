package com.transsion.transfer.wifi.util;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import com.applovin.sdk.AppLovinMediationProvider;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f59253a = new i();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements WifiP2pManager.ActionListener {
        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onFailure(int i11) {
            g gVar = g.f59252a;
            i iVar = i.f59253a;
            g.b(gVar, iVar.c() + " --> release() --> clearLocalServices() --> onFailure() --> reason = " + iVar.b(i11), false, 2, null);
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onSuccess() {
            g.b(g.f59252a, i.f59253a.c() + " --> release() --> clearLocalServices() --> onSuccess()", false, 2, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements WifiP2pManager.ActionListener {
        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onFailure(int i11) {
            g gVar = g.f59252a;
            i iVar = i.f59253a;
            g.b(gVar, iVar.c() + " --> release() --> removeGroup() --> onFailure() --> reason = " + iVar.b(i11), false, 2, null);
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onSuccess() {
            g.b(g.f59252a, i.f59253a.c() + " --> release() --> removeGroup() --> onSuccess()", false, 2, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements WifiP2pManager.ActionListener {
        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onFailure(int i11) {
            g gVar = g.f59252a;
            i iVar = i.f59253a;
            g.b(gVar, iVar.c() + " --> release() --> cancelConnect() --> onFailure() --> reason = " + iVar.b(i11), false, 2, null);
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onSuccess() {
            g.b(g.f59252a, i.f59253a.c() + " --> release() --> cancelConnect() --> onSuccess()", false, 2, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements WifiP2pManager.ActionListener {
        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onFailure(int i11) {
            g gVar = g.f59252a;
            i iVar = i.f59253a;
            g.b(gVar, iVar.c() + " --> release() --> stopPeerDiscovery() --> onFailure() --> reason = " + iVar.b(i11), false, 2, null);
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onSuccess() {
            g.b(g.f59252a, i.f59253a.c() + " --> release() --> stopPeerDiscovery() --> onSuccess()", false, 2, null);
        }
    }

    public final String b(int i11) {
        if (i11 == 0) {
            return "0 -- 表示操作由于内部错误而失败。";
        }
        if (i11 == 1) {
            return "1 -- 表示操作失败，因为设备不支持 p2p。";
        }
        if (i11 != 2) {
            return i11 != 3 ? AppLovinMediationProvider.UNKNOWN : "3 -- 表示 {@link discoveryServices} 失败，因为没有添加服务请求。使用 {@link addServiceRequest} 添加服务请求。";
        }
        return "2 -- 表示操作失败，因为框架正忙，无法处理请求";
    }

    public final String c() {
        String simpleName = i.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void d(WifiP2pManager wifiP2pManager, WifiP2pManager.Channel channel, boolean z11, boolean z12, boolean z13, boolean z14) {
        if (channel != null) {
            if (Build.VERSION.SDK_INT > 26) {
                channel.close();
                g.b(g.f59252a, f59253a.c() + " --> release() --> WifiP2pManager.close() --> API27才有这个方法 --> 成功", false, 2, null);
            }
            if (z14 && wifiP2pManager != null) {
                wifiP2pManager.clearLocalServices(channel, new a());
            }
            if (z11 && wifiP2pManager != null) {
                wifiP2pManager.removeGroup(channel, new b());
            }
            if (z12 && wifiP2pManager != null) {
                wifiP2pManager.cancelConnect(channel, new c());
            }
            if (!z13 || wifiP2pManager == null) {
                return;
            }
            wifiP2pManager.stopPeerDiscovery(channel, new d());
        }
    }
}
