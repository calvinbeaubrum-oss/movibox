package ku;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f69642a = new b();

    public final String a(String url) {
        int iI0;
        Intrinsics.g(url, "url");
        Locale locale = Locale.getDefault();
        Intrinsics.f(locale, "getDefault()");
        String lowerCase = url.toLowerCase(locale);
        Intrinsics.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (TextUtils.isEmpty(lowerCase)) {
            return "";
        }
        int iI1 = StringsKt__StringsKt.i0(lowerCase, '#', 0, false, 6, null);
        if (iI1 > 0) {
            lowerCase = lowerCase.substring(0, iI1);
            Intrinsics.f(lowerCase, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        int iI2 = StringsKt__StringsKt.i0(lowerCase, '?', 0, false, 6, null);
        if (iI2 > 0) {
            lowerCase = lowerCase.substring(0, iI2);
            Intrinsics.f(lowerCase, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        int iI3 = StringsKt__StringsKt.i0(lowerCase, '/', 0, false, 6, null);
        if (iI3 >= 0) {
            lowerCase = lowerCase.substring(iI3 + 1);
            Intrinsics.f(lowerCase, "this as java.lang.String).substring(startIndex)");
        }
        if (lowerCase.length() <= 0 || (iI0 = StringsKt__StringsKt.i0(lowerCase, '.', 0, false, 6, null)) < 0) {
            return "";
        }
        String strSubstring = lowerCase.substring(iI0 + 1);
        Intrinsics.f(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public final String b(String url) {
        Intrinsics.g(url, "url");
        String strA = a(url);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(strA);
        return (mimeTypeFromExtension == null && TextUtils.equals(strA, "js")) ? "application/javascript" : mimeTypeFromExtension;
    }
}
