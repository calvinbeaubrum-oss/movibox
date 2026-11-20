package com.cloud.tmc.ad.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class MitNetUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MitNetUtil f30346a = new MitNetUtil();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum NetworkType {
        NETWORK_UNKNOWN,
        NETWORK_WIFI,
        NETWORK_2G,
        NETWORK_3G,
        NETWORK_4G,
        NETWORK_5G,
        NETWORK_ETHERNET
    }

    public final NetworkType a(Context context) {
        NetworkInfo.State state;
        NetworkInfo.State state2;
        if (context == null) {
            return NetworkType.NETWORK_UNKNOWN;
        }
        Object systemService = context.getApplicationContext().getSystemService("connectivity");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        try {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || ((state2 = networkInfo.getState()) != NetworkInfo.State.CONNECTED && state2 != NetworkInfo.State.CONNECTING)) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(9);
                if (networkInfo2 != null && ((state = networkInfo2.getState()) == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                    return NetworkType.NETWORK_ETHERNET;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    if (activeNetworkInfo.getType() != 0) {
                        return NetworkType.NETWORK_UNKNOWN;
                    }
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return NetworkType.NETWORK_2G;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                        case 17:
                            return NetworkType.NETWORK_3G;
                        case 13:
                        case 18:
                            return NetworkType.NETWORK_4G;
                        case 19:
                        default:
                            String subtypeName = activeNetworkInfo.getSubtypeName();
                            if (!l.v(subtypeName, "TD-SCDMA", true) && !l.v(subtypeName, "WCDMA", true) && !l.v(subtypeName, "CDMA2000", true)) {
                                return NetworkType.NETWORK_UNKNOWN;
                            }
                            return NetworkType.NETWORK_3G;
                        case 20:
                            return NetworkType.NETWORK_5G;
                    }
                }
                return NetworkType.NETWORK_UNKNOWN;
            }
            return NetworkType.NETWORK_WIFI;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
