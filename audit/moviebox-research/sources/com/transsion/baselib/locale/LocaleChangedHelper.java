package com.transsion.baselib.locale;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LocaleChangedHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LocaleChangedHelper f51197a = new LocaleChangedHelper();

    public final void a(Context context, String str) {
        Intrinsics.g(context, "context");
        Intent intent = new Intent(context.getPackageName() + "_LOCALE_CHANGED_ACTION");
        intent.putExtra("key.string.language", str);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    public final void b(Context context) {
        Intrinsics.g(context, "context");
        IntentFilter intentFilter = new IntentFilter(context.getPackageName() + "_LOCALE_CHANGED_ACTION");
        if (Build.VERSION.SDK_INT >= 33) {
            context.getApplicationContext().registerReceiver(new BroadcastReceiver() { // from class: com.transsion.baselib.locale.LocaleChangedHelper$registerLocalChangeReceiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    Intrinsics.g(context2, "context");
                    Intrinsics.g(intent, "intent");
                    LocaleManager.f51198f.e().l(intent.getStringExtra("key.string.language"));
                }
            }, intentFilter, 2);
        } else {
            context.getApplicationContext().registerReceiver(new BroadcastReceiver() { // from class: com.transsion.baselib.locale.LocaleChangedHelper$registerLocalChangeReceiver$2
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    Intrinsics.g(context2, "context");
                    Intrinsics.g(intent, "intent");
                    LocaleManager.f51198f.e().l(intent.getStringExtra("key.string.language"));
                }
            }, intentFilter);
        }
    }
}
