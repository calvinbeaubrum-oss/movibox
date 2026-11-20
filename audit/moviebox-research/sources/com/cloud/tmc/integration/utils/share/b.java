package com.cloud.tmc.integration.utils.share;

import android.content.Context;
import android.content.Intent;
import com.cloud.tmc.kernel.log.TmcLogger;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f31113b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f31114a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(Context context) {
        Intrinsics.g(context, "context");
        this.f31114a = context;
    }

    public void a(c shareParams, com.cloud.tmc.integration.utils.share.a aVar) {
        Intrinsics.g(shareParams, "shareParams");
        Context context = this.f31114a;
        if (b(context, g.a(context, shareParams))) {
            if (aVar != null) {
                aVar.a(1, 1);
            }
        } else if (aVar != null) {
            aVar.a(1, 2);
        }
    }

    public final boolean b(Context context, Intent intent) {
        try {
            context.startActivity(intent);
            return true;
        } catch (Throwable th2) {
            TmcLogger.g("ShareBySystem", "startActivity: ", th2);
            return false;
        }
    }
}
