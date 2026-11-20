package com.tmc.network;

import java.util.concurrent.atomic.AtomicBoolean;
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
public final class NetworkAdapter {
    private static final int MAX_PRE_CONNECT = 3;
    public static final NetworkAdapter INSTANCE = new NetworkAdapter();
    private static final AtomicBoolean isInit = new AtomicBoolean(false);

    private NetworkAdapter() {
    }

    private final void startPreConnect() {
        NetworkConfig networkConfig = NetworkConfig.INSTANCE;
        if (!networkConfig.isNetworkImproveEnable()) {
            po.b.f73956a.c("isNetworkImprove is disable.");
            return;
        }
        if (networkConfig.getPreConnectList().isEmpty()) {
            po.b.f73956a.c("preConnectList is empty");
            return;
        }
        c cVarA = c.f73961c.a();
        if (cVarA == null) {
            return;
        }
        cVarA.a(new Runnable() { // from class: com.tmc.network.a
            @Override // java.lang.Runnable
            public final void run() {
                NetworkAdapter.m159startPreConnect$lambda0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startPreConnect$lambda-0, reason: not valid java name */
    public static final void m159startPreConnect$lambda0() {
        int i11 = 0;
        for (String url : NetworkConfig.INSTANCE.getPreConnectList()) {
            if (i11 >= 3) {
                return;
            }
            Intrinsics.f(url, "url");
            new com.tmc.network.strategy.c(url).a();
            i11++;
        }
    }

    public final void init() {
        po.b.f73956a.c("NetworkAdapter init");
        if (isInit.compareAndSet(false, true)) {
            startPreConnect();
        }
    }
}
