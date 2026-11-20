package com.cloud.tmc.kernel.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.mvel2.ast.ASTNode;

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
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f31292a = new q();

    @JvmStatic
    public static final boolean a(Context context, String str) {
        if (context != null && str != null) {
            try {
                if (str.length() != 0) {
                    Uri uri = Uri.parse(str);
                    Intent intent = new Intent();
                    intent.setData(uri);
                    intent.setAction("android.intent.action.VIEW");
                    intent.setFlags(ASTNode.DEOP);
                    context.startActivity(intent);
                    return true;
                }
            } catch (Throwable th2) {
                TmcLogger.g("UrlLauncher", "", th2);
            }
        }
        return false;
    }
}
