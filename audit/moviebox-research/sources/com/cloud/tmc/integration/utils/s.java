package com.cloud.tmc.integration.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f31110a = new s();

    @JvmStatic
    public static final int a(Context context) {
        Intrinsics.g(context, "context");
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @JvmStatic
    public static final int b(Context context) {
        Intrinsics.g(context, "context");
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @JvmStatic
    public static final int c(Activity activity) {
        Intrinsics.g(activity, "activity");
        try {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            return r.a(activity, 48.0f) + rect.top;
        } catch (Throwable th2) {
            TmcLogger.f("DisplayUtils", "getTitleAndStatusBarHeight...e=" + th2);
            return r.a(activity, 1.0f) * 73;
        }
    }

    @JvmStatic
    public static final boolean d(Context context) {
        Intrinsics.g(context, "context");
        return a(context) != 0 && (com.cloud.tmc.miniutils.util.w.b() - com.cloud.tmc.miniutils.util.w.a()) - b(context) >= a(context);
    }

    @JvmStatic
    public static final boolean e(Context context) {
        Intrinsics.g(context, "context");
        if (b(context) == 0) {
            return false;
        }
        if (d(context)) {
            return (com.cloud.tmc.miniutils.util.w.b() - com.cloud.tmc.miniutils.util.w.a()) - a(context) >= b(context);
        }
        return com.cloud.tmc.miniutils.util.w.b() - com.cloud.tmc.miniutils.util.w.a() >= b(context);
    }
}
