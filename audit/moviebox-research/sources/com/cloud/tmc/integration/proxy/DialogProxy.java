package com.cloud.tmc.integration.proxy;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import ua.k;
import ua.l;

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
public interface DialogProxy {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(DialogProxy dialogProxy, Context context, Function0 function0, Function0 function1, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showStoragePermissionDialog");
            }
            if ((i11 & 2) != 0) {
                function0 = null;
            }
            if ((i11 & 4) != 0) {
                function1 = null;
            }
            dialogProxy.showStoragePermissionDialog(context, function0, function1);
        }
    }

    void hideLoadingDialog(Context context);

    void showAddHomeConfirmDialog(Context context, String str, String str2, String str3, String str4, k kVar);

    void showCameraPermissionDialog(Context context, String str, Function0<Unit> function0, Function0<Unit> function1);

    void showLoadingDialog(Context context);

    void showLocationPermissionDialog(Context context);

    void showPermissionDialog(Context context, String str, String str2, String str3, String str4, l lVar);

    void showStoragePermissionDialog(Context context, Function0<Unit> function0, Function0<Unit> function1);
}
