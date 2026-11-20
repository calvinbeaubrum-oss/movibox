package com.transsion.baselib.helper;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class e extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Boolean, Unit> f51195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f51196b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e(Handler handler, Context context, Function1<? super Boolean, Unit> callback) {
        super(handler);
        Intrinsics.g(context, "context");
        Intrinsics.g(callback, "callback");
        this.f51195a = callback;
        this.f51196b = context;
    }

    public final boolean a(Context context) {
        Intrinsics.g(context, "context");
        try {
            return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation") == 1;
        } catch (Settings.SettingNotFoundException e11) {
            e11.printStackTrace();
            Log.e("ScreenRotationObserver", "Setting not found: " + e11.getMessage());
            return false;
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z11) {
        super.onChange(z11);
        boolean zA = a(this.f51196b);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Auto-rotate is now isAutoRotateEnabled：");
        sb2.append(zA);
        this.f51195a.invoke(Boolean.valueOf(zA));
    }
}
