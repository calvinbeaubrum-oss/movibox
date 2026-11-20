package com.transsion.commercialization.pslink;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import com.blankj.utilcode.util.Utils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class PsLinkInstallReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f51714a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static PsLinkInstallReceiver f51715b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            if (PsLinkInstallReceiver.f51715b == null) {
                PsLinkInstallReceiver.f51715b = new PsLinkInstallReceiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            if (Build.VERSION.SDK_INT >= 33) {
                Utils.a().registerReceiver(PsLinkInstallReceiver.f51715b, intentFilter, 2);
            } else {
                Utils.a().registerReceiver(PsLinkInstallReceiver.f51715b, intentFilter);
            }
            com.transsion.commercialization.pslink.a.f51724a.a("PsLinkInstallReceiver --> registerInstallReceiver() --> registerReceiver PsLinkInstallReceiver success");
        }

        public final void b() {
            if (PsLinkInstallReceiver.f51715b != null) {
                Utils.a().unregisterReceiver(PsLinkInstallReceiver.f51715b);
                PsLinkInstallReceiver.f51715b = null;
                com.transsion.commercialization.pslink.a.f51724a.a("PsLinkInstallReceiver --> registerInstallReceiver() --> unregisterReceiver PsLinkInstallReceiver success");
            }
        }
    }

    public final String c(Intent intent, String str) {
        Uri data = intent.getData();
        String schemeSpecificPart = data != null ? data.getSchemeSpecificPart() : null;
        com.transsion.commercialization.pslink.a.f51724a.a("PsLinkInstallReceiver --> onReceive() --> packageName = " + schemeSpecificPart + " -- action = " + str);
        return schemeSpecificPart;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.g(intent, "intent");
        String action = intent.getAction();
        if (Intrinsics.b("android.intent.action.PACKAGE_REPLACED", action) || Intrinsics.b("android.intent.action.PACKAGE_ADDED", action)) {
            String strC = c(intent, action);
            Iterator<T> it = PsLinkServiceHelper.f51717a.i().iterator();
            while (it.hasNext()) {
                ((b) it.next()).a("installApp", "", null, strC);
            }
            return;
        }
        if (Intrinsics.b("android.intent.action.PACKAGE_REMOVED", action)) {
            String strC2 = c(intent, action);
            Iterator<T> it2 = PsLinkServiceHelper.f51717a.i().iterator();
            while (it2.hasNext()) {
                ((b) it2.next()).a("removedApp", "", null, strC2);
            }
        }
    }
}
