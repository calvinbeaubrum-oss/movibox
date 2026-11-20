package com.cloud.tmc.integration.utils;

import android.graphics.Bitmap;
import android.os.Build;
import com.cloud.tmc.miniutils.util.ImageUtils;
import com.cloud.tmc.miniutils.util.PermissionUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
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
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f31136a = new y();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements PermissionUtils.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f31137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ua.h f31138b;

        public a(Bitmap bitmap, ua.h hVar) {
            this.f31137a = bitmap;
            this.f31138b = hVar;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void a() {
            ua.h hVar = this.f31138b;
            if (hVar != null) {
                hVar.b(2, "no Permission");
            }
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void onGranted() {
            File fileF = ImageUtils.f(this.f31137a, "MiniApp", Bitmap.CompressFormat.PNG, true);
            if (fileF == null) {
                ua.h hVar = this.f31138b;
                if (hVar != null) {
                    hVar.b(1, "Image File NULL");
                    return;
                }
                return;
            }
            ua.h hVar2 = this.f31138b;
            if (hVar2 != null) {
                hVar2.a(fileF);
            }
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void a(Bitmap bitmap, ua.h hVar) {
        c(bitmap, hVar, null, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void b(Bitmap bitmap, ua.h hVar, Bitmap.CompressFormat compressFormat) {
        Intrinsics.g(compressFormat, "compressFormat");
        if (Build.VERSION.SDK_INT < 29) {
            PermissionUtils.y("STORAGE_WRITE").m(new a(bitmap, hVar)).z();
            return;
        }
        File fileF = ImageUtils.f(bitmap, "MiniApp", Bitmap.CompressFormat.PNG, true);
        if (hVar != null) {
            hVar.a(fileF);
        }
    }

    public static /* synthetic */ void c(Bitmap bitmap, ua.h hVar, Bitmap.CompressFormat compressFormat, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            compressFormat = Bitmap.CompressFormat.PNG;
        }
        b(bitmap, hVar, compressFormat);
    }
}
