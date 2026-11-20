package kotlin.text;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public class a {
    @PublishedApi
    public static int a(int i11) {
        if (new IntRange(2, 36).v(i11)) {
            return i11;
        }
        throw new IllegalArgumentException("radix " + i11 + " was not in valid range " + new IntRange(2, 36));
    }

    public static final int b(char c11, int i11) {
        return Character.digit((int) c11, i11);
    }

    public static boolean c(char c11) {
        return Character.isWhitespace(c11) || Character.isSpaceChar(c11);
    }

    @SinceKotlin
    @WasExperimental
    public static String d(char c11, Locale locale) {
        Intrinsics.g(locale, "locale");
        String strE = e(c11, locale);
        if (strE.length() <= 1) {
            String strValueOf = String.valueOf(c11);
            Intrinsics.e(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            Intrinsics.f(upperCase, "toUpperCase(...)");
            return !Intrinsics.b(strE, upperCase) ? strE : String.valueOf(Character.toTitleCase(c11));
        }
        if (c11 == 329) {
            return strE;
        }
        char cCharAt = strE.charAt(0);
        Intrinsics.e(strE, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = strE.substring(1);
        Intrinsics.f(strSubstring, "substring(...)");
        Intrinsics.e(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
        Intrinsics.f(lowerCase, "toLowerCase(...)");
        return cCharAt + lowerCase;
    }

    @SinceKotlin
    @WasExperimental
    public static final String e(char c11, Locale locale) {
        Intrinsics.g(locale, "locale");
        String strValueOf = String.valueOf(c11);
        Intrinsics.e(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(locale);
        Intrinsics.f(upperCase, "toUpperCase(...)");
        return upperCase;
    }
}
