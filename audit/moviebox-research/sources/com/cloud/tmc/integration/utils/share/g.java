package com.cloud.tmc.integration.utils.share;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f31129a = new g();

    @JvmStatic
    public static final Intent a(Context context, c shareParams) {
        Intrinsics.g(context, "context");
        Intrinsics.g(shareParams, "shareParams");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(shareParams.e());
        CharSequence charSequenceJ = shareParams.j();
        if (charSequenceJ != null) {
            intent.putExtra("android.intent.extra.TITLE", charSequenceJ);
        }
        if (shareParams.b().length() > 0) {
            intent.putExtra("android.intent.extra.TEXT", shareParams.b());
        }
        CharSequence charSequenceG = shareParams.g();
        if (charSequenceG != null) {
            intent.putExtra("android.intent.extra.SUBJECT", charSequenceG);
        }
        Uri uriC = shareParams.c();
        if (uriC != null) {
            intent.putExtra("android.intent.extra.STREAM", uriC);
        }
        ClipData clipDataI = shareParams.i();
        if (clipDataI != null) {
            intent.setClipData(clipDataI);
            intent.setFlags(1);
        }
        String strH = shareParams.h();
        if (strH != null) {
            intent.setPackage(strH);
        }
        Intent intentCreateChooser = Intent.createChooser(intent, f31129a.b(context));
        Intrinsics.f(intentCreateChooser, "createChooser(Intent(Int…  }, getAppName(context))");
        return intentCreateChooser;
    }

    @JvmStatic
    public static final boolean c(Context context, String... permission) {
        Intrinsics.g(context, "context");
        Intrinsics.g(permission, "permission");
        ArrayList arrayList = new ArrayList();
        int length = permission.length;
        int i11 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 >= length) {
                break;
            }
            if (z2.a.checkSelfPermission(context, permission[i11]) != 0) {
                z11 = false;
            }
            arrayList.add(Boolean.valueOf(z11));
            i11++;
        }
        return (arrayList.isEmpty() || arrayList.contains(Boolean.FALSE)) ? false : true;
    }

    @JvmStatic
    public static final void e(Context context, File shareFile, String str, String str2, String str3, boolean z11, a aVar) {
        Intrinsics.g(context, "context");
        Intrinsics.g(shareFile, "shareFile");
        f31129a.d(context, new c(str2 == null ? "" : str2, str == null ? xb.b.c(shareFile) : str, shareFile, 0, null, null, null, str3, null, z11, null, 1400, null), aVar);
    }

    @JvmStatic
    public static final void g(Context context, CharSequence text, String str, a aVar) {
        Intrinsics.g(context, "context");
        Intrinsics.g(text, "text");
        f31129a.d(context, new c(text, "text/plain", null, 0, null, null, null, str, null, false, null, 1916, null), aVar);
    }

    public static /* synthetic */ void h(Context context, CharSequence charSequence, String str, a aVar, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str = null;
        }
        if ((i11 & 8) != 0) {
            aVar = null;
        }
        g(context, charSequence, str, aVar);
    }

    public final String b(Context context) {
        ApplicationInfo applicationInfo;
        CharSequence charSequenceLoadLabel;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            String string = (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (charSequenceLoadLabel = applicationInfo.loadLabel(packageManager)) == null) ? null : charSequenceLoadLabel.toString();
            return string == null ? "" : string;
        } catch (Throwable th2) {
            TmcLogger.g("ShareUtils", "getAppName failed!", th2);
            return "";
        }
    }

    public final void d(Context context, c cVar, a aVar) {
        if (cVar.f() == null) {
            cVar.m(new ShareStrategy());
        }
        yb.a aVarF = cVar.f();
        if (aVarF != null) {
            aVarF.a(context, cVar, aVar);
        }
    }
}
