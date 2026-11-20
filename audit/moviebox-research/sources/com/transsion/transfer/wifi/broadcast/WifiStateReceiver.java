package com.transsion.transfer.wifi.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pDevice;
import com.transsion.transfer.wifi.util.g;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
@Deprecated
@Metadata
public final class WifiStateReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f59116a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final String a() {
        String simpleName = WifiStateReceiver.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            switch (action.hashCode()) {
                case -1875733435:
                    if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                        int intExtra = intent.getIntExtra("wifi_state", 4);
                        if (intExtra == 1) {
                            g.h(g.f59252a, a() + " --> onReceive() --> Wi-Fi 已禁用，系统会发送这个广播。", false, 2, null);
                            break;
                        } else if (intExtra == 3) {
                            g.h(g.f59252a, a() + " --> onReceive() --> Wi-Fi 已启用，系统会发送这个广播。", false, 2, null);
                            break;
                        }
                    }
                    break;
                case -1772632330:
                    if (action.equals("android.net.wifi.p2p.CONNECTION_STATE_CHANGE")) {
                        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                        if (networkInfo != null && networkInfo.isConnected()) {
                            g.h(g.f59252a, a() + " --> onReceive() --> WIFI_P2P_CONNECTION_CHANGED_ACTION --> 当 P2P 连接建立时，系统会发送这个广播。", false, 2, null);
                        } else if ((networkInfo != null ? networkInfo.getState() : null) != NetworkInfo.State.DISCONNECTED) {
                            g.h(g.f59252a, a() + " --> onReceive() --> WIFI_P2P_CONNECTION_CHANGED_ACTION --> networkInfo = " + networkInfo, false, 2, null);
                        } else {
                            g.h(g.f59252a, a() + " --> onReceive() --> WIFI_P2P_CONNECTION_CHANGED_ACTION --> 当 P2P 连接断开时，系统会发送这个广播。", false, 2, null);
                        }
                        break;
                    }
                    break;
                case -1566767901:
                    if (action.equals("android.net.wifi.p2p.THIS_DEVICE_CHANGED")) {
                        WifiP2pDevice wifiP2pDevice = (WifiP2pDevice) intent.getParcelableExtra("wifiP2pDevice");
                        g.h(g.f59252a, a() + " --> onReceive() --> WIFI_P2P_THIS_DEVICE_CHANGED_ACTION --> 当本设备的 Wi-Fi P2P 配置（如设备名称、设备状态、支持的服务等）发生变化时，系统会发送这个广播。--> device = " + wifiP2pDevice, false, 2, null);
                        break;
                    }
                    break;
                case -1394739139:
                    if (action.equals("android.net.wifi.p2p.PEERS_CHANGED")) {
                        g.h(g.f59252a, a() + " --> onReceive() --> WIFI_P2P_PEERS_CHANGED_ACTION --> 当发现新的 P2P 设备或设备离开时，系统会发出这个广播。", false, 2, null);
                        break;
                    }
                    break;
                case 1695662461:
                    if (action.equals("android.net.wifi.p2p.STATE_CHANGED")) {
                        if (intent.getIntExtra("wifi_p2p_state", -1) != 2) {
                            g.h(g.f59252a, a() + " --> onReceive() --> WIFI_P2P_STATE_CHANGED_ACTION --> Wi-Fi P2P 不可用,系统会发送这个广播。", false, 2, null);
                        } else {
                            g.h(g.f59252a, a() + " --> onReceive() --> WIFI_P2P_STATE_CHANGED_ACTION --> Wi-Fi P2P 已启用,系统会发送这个广播。", false, 2, null);
                        }
                        break;
                    }
                    break;
            }
        }
    }
}
