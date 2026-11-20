package hu;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
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
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f66792a = new e();

    public final boolean a(String url) {
        Object objM163constructorimpl;
        Intrinsics.g(url, "url");
        try {
            Result.Companion companion = Result.Companion;
            Uri uri = Uri.parse(url);
            Intrinsics.f(uri, "parse(url)");
            objM163constructorimpl = Result.m163constructorimpl(Boolean.valueOf(Boolean.parseBoolean(uri.getQueryParameter("h5_bar"))));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = Boolean.TRUE;
        }
        return ((Boolean) objM163constructorimpl).booleanValue();
    }
}
