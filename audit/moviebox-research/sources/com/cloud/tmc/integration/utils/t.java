package com.cloud.tmc.integration.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.mvel2.ast.ASTNode;

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
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31130a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean a(Context context, String str) {
            Intrinsics.g(context, "context");
            if (str != null) {
                try {
                    if (str.length() != 0) {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.addCategory("android.intent.category.DEFAULT");
                        intent.setData(Uri.parse(str));
                        intent.addFlags(ASTNode.DEOP);
                        if (b.f31131a.a(context, "com.android.chrome")) {
                            intent.setPackage("com.android.chrome");
                        }
                        context.startActivity(intent);
                        return true;
                    }
                } catch (Throwable th2) {
                    TmcLogger.g("EnvironmentUtil", "openByBrowser: ", th2);
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f31131a = new b();

        public final boolean a(Context context, String str) {
            ApplicationInfo applicationInfo;
            Intrinsics.g(context, "context");
            if (str != null && str.length() != 0) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(str, 0)) != null) {
                        return applicationInfo.enabled;
                    }
                    return false;
                } catch (Throwable unused) {
                    TmcLogger.f("EnvironmentUtil", "Name not found for " + str);
                }
            }
            return false;
        }
    }

    @JvmStatic
    public static final boolean a(Context context, String str) {
        return f31130a.a(context, str);
    }
}
