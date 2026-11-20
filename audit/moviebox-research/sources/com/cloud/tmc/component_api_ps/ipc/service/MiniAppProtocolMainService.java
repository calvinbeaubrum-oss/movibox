package com.cloud.tmc.component_api_ps.ipc.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import la.b;

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
public final class MiniAppProtocolMainService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30357a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.g(intent, "intent");
        b.a("MiniAppCrossProcessServerService", "Lifecycle:onBind");
        return new pa.a();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b.a("MiniAppCrossProcessServerService", "Lifecycle:onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        b.a("MiniAppCrossProcessServerService", "Lifecycle:onDestroy");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i11, int i12) {
        b.a("MiniAppCrossProcessServerService", "Lifecycle:onStartCommand");
        return super.onStartCommand(intent, i11, i12);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        b.a("MiniAppCrossProcessServerService", "Lifecycle:onUnbind");
        return super.onUnbind(intent);
    }
}
