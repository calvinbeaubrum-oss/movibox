package com.transsion.push.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.blankj.utilcode.util.ImageUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.transsion.push.R$mipmap;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f57057a = new a();

    public static /* synthetic */ Bitmap c(a aVar, Context context, Bitmap bitmap, int i11, int i12, boolean z11, int i13, int i14, int i15, Object obj) {
        return aVar.b(context, bitmap, i11, i12, z11, i13, (i15 & 64) != 0 ? 8 : i14);
    }

    public static /* synthetic */ Bitmap f(a aVar, Context context, Bitmap bitmap, int i11, int i12, boolean z11, int i13, int i14, Object obj) {
        if ((i14 & 32) != 0) {
            i13 = gs.a.a(8);
        }
        return aVar.e(context, bitmap, i11, i12, z11, i13);
    }

    public final Bitmap a(Context context, Bitmap bitmap, int i11, int i12, boolean z11) {
        Intrinsics.g(context, "context");
        return c(this, context, bitmap, i11, i12, z11, R$mipmap.notification_placeholder, 0, 64, null);
    }

    public final Bitmap b(Context context, Bitmap bitmap, int i11, int i12, boolean z11, int i13, int i14) {
        Intrinsics.g(context, "context");
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
                    Intrinsics.f(bitmapPool, "get(context).bitmapPool");
                    Bitmap bitmapCenterCrop = TransformationUtils.centerCrop(bitmapPool, bitmap, i11, i12);
                    Bitmap bitmapRoundedCorners = TransformationUtils.roundedCorners(bitmapPool, bitmapCenterCrop, i14);
                    d(bitmapCenterCrop);
                    if (z11) {
                        d(bitmap);
                    }
                    return bitmapRoundedCorners;
                }
            } catch (Throwable unused) {
                return ImageUtils.g(bitmap, i11, i12, z11);
            }
        }
        return BitmapFactory.decodeResource(context.getResources(), i13);
    }

    public final void d(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public final Bitmap e(Context context, Bitmap bitmap, int i11, int i12, boolean z11, int i13) {
        Intrinsics.g(context, "context");
        return (bitmap == null || bitmap.isRecycled()) ? BitmapFactory.decodeResource(context.getResources(), R$mipmap.notification_placeholder) : b(context, bitmap, i11, i12, z11, R$mipmap.notification_placeholder, i13);
    }
}
