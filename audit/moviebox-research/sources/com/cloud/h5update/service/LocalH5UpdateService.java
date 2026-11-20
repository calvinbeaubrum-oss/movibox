package com.cloud.h5update.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.cloud.h5update.utils.l;
import k9.b;
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
public final class LocalH5UpdateService extends IntentService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28893a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.g(context, "context");
            try {
                Intent intent = new Intent(context, (Class<?>) LocalH5UpdateService.class);
                intent.setAction("com.cloud.h5update.service.action.LOCAL_UPDATE");
                context.startService(intent);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public LocalH5UpdateService() {
        super("LocalH5UpdateService");
    }

    public final void a() {
        l.f28923a.e(b.f68501g.a());
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (Intrinsics.b("com.cloud.h5update.service.action.LOCAL_UPDATE", action)) {
                a();
                return;
            }
            po.b.f73956a.c("error intent for action: " + action);
        }
    }
}
