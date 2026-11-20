package yv;

import android.content.Context;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;

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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f81647a = "main/operating.json";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f81648b = "main/trending.json";

    public final String a(Context context) {
        Intrinsics.g(context, "context");
        try {
            InputStream it = context.getAssets().open(this.f81647a);
            try {
                Intrinsics.f(it, "it");
                String utf8 = Okio.buffer(Okio.source(it)).readUtf8();
                CloseableKt.a(it, null);
                return utf8;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(it, th2);
                    throw th3;
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public final String b(Context context) {
        Intrinsics.g(context, "context");
        try {
            InputStream it = context.getAssets().open(this.f81648b);
            try {
                Intrinsics.f(it, "it");
                String utf8 = Okio.buffer(Okio.source(it)).readUtf8();
                CloseableKt.a(it, null);
                return utf8;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(it, th2);
                    throw th3;
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
