package kotlin.text;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.AbstractList;
import kotlin.collections.IntIterator;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
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
@SourceDebugExtension
public class l extends k {
    public static String B(CharSequence charSequence, int i11) {
        Intrinsics.g(charSequence, "<this>");
        if (i11 < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i11 + '.').toString());
        }
        if (i11 == 0) {
            return "";
        }
        if (i11 == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                cArr[i12] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb2 = new StringBuilder(charSequence.length() * i11);
        IntIterator intIteratorS = new IntRange(1, i11).iterator();
        while (intIteratorS.hasNext()) {
            intIteratorS.a();
            sb2.append(charSequence);
        }
        String string = sb2.toString();
        Intrinsics.d(string);
        return string;
    }

    public static final String C(String str, char c11, char c12, boolean z11) {
        Intrinsics.g(str, "<this>");
        if (!z11) {
            String strReplace = str.replace(c11, c12);
            Intrinsics.f(strReplace, "replace(...)");
            return strReplace;
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        for (int i11 = 0; i11 < str.length(); i11++) {
            char cCharAt = str.charAt(i11);
            if (b.g(cCharAt, c11, z11)) {
                cCharAt = c12;
            }
            sb2.append(cCharAt);
        }
        String string = sb2.toString();
        Intrinsics.f(string, "toString(...)");
        return string;
    }

    public static String D(String str, String oldValue, String newValue, boolean z11) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(oldValue, "oldValue");
        Intrinsics.g(newValue, "newValue");
        int i11 = 0;
        int iZ = StringsKt__StringsKt.Z(str, oldValue, 0, z11);
        if (iZ < 0) {
            return str;
        }
        int length = oldValue.length();
        int iD = kotlin.ranges.a.d(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb2 = new StringBuilder(length2);
        do {
            sb2.append((CharSequence) str, i11, iZ);
            sb2.append(newValue);
            i11 = iZ + length;
            if (iZ >= str.length()) {
                break;
            }
            iZ = StringsKt__StringsKt.Z(str, oldValue, iZ + iD, z11);
        } while (iZ > 0);
        sb2.append((CharSequence) str, i11, str.length());
        String string = sb2.toString();
        Intrinsics.f(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String E(String str, char c11, char c12, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return C(str, c11, c12, z11);
    }

    public static /* synthetic */ String F(String str, String str2, String str3, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return D(str, str2, str3, z11);
    }

    public static String G(String str, String oldValue, String newValue, boolean z11) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(oldValue, "oldValue");
        Intrinsics.g(newValue, "newValue");
        int iD0 = StringsKt__StringsKt.d0(str, oldValue, 0, z11, 2, null);
        return iD0 < 0 ? str : StringsKt__StringsKt.y0(str, iD0, oldValue.length() + iD0, newValue).toString();
    }

    public static /* synthetic */ String H(String str, String str2, String str3, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return G(str, str2, str3, z11);
    }

    public static boolean I(String str, String prefix, int i11, boolean z11) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(prefix, "prefix");
        return !z11 ? str.startsWith(prefix, i11) : z(str, i11, prefix, 0, prefix.length(), z11);
    }

    public static boolean J(String str, String prefix, boolean z11) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(prefix, "prefix");
        return !z11 ? str.startsWith(prefix) : z(str, 0, prefix, 0, prefix.length(), z11);
    }

    public static /* synthetic */ boolean K(String str, String str2, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return I(str, str2, i11, z11);
    }

    public static /* synthetic */ boolean L(String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return J(str, str2, z11);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static String p(String str) {
        Intrinsics.g(str, "<this>");
        Locale locale = Locale.getDefault();
        Intrinsics.f(locale, "getDefault(...)");
        return q(str, locale);
    }

    @SinceKotlin
    @Deprecated
    @LowPriorityInOverloadResolution
    @DeprecatedSinceKotlin
    @WasExperimental
    public static final String q(String str, Locale locale) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(locale, "locale");
        if (str.length() <= 0) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if (!Character.isLowerCase(cCharAt)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        char titleCase = Character.toTitleCase(cCharAt);
        if (titleCase != Character.toUpperCase(cCharAt)) {
            sb2.append(titleCase);
        } else {
            String strSubstring = str.substring(0, 1);
            Intrinsics.f(strSubstring, "substring(...)");
            Intrinsics.e(strSubstring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strSubstring.toUpperCase(locale);
            Intrinsics.f(upperCase, "toUpperCase(...)");
            sb2.append(upperCase);
        }
        String strSubstring2 = str.substring(1);
        Intrinsics.f(strSubstring2, "substring(...)");
        sb2.append(strSubstring2);
        String string = sb2.toString();
        Intrinsics.f(string, "toString(...)");
        return string;
    }

    @SinceKotlin
    @WasExperimental
    public static String r(char[] cArr) {
        Intrinsics.g(cArr, "<this>");
        return new String(cArr);
    }

    @SinceKotlin
    @WasExperimental
    public static String s(char[] cArr, int i11, int i12) {
        Intrinsics.g(cArr, "<this>");
        AbstractList.Companion.a(i11, i12, cArr.length);
        return new String(cArr, i11, i12 - i11);
    }

    public static boolean t(String str, String suffix, boolean z11) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(suffix, "suffix");
        return !z11 ? str.endsWith(suffix) : z(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean u(String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return t(str, str2, z11);
    }

    public static boolean v(String str, String str2, boolean z11) {
        if (str == null) {
            return str2 == null;
        }
        return !z11 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean w(String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return v(str, str2, z11);
    }

    public static Comparator<String> x(StringCompanionObject stringCompanionObject) {
        Intrinsics.g(stringCompanionObject, "<this>");
        Comparator<String> CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.f(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        return CASE_INSENSITIVE_ORDER;
    }

    public static boolean y(CharSequence charSequence) {
        Intrinsics.g(charSequence, "<this>");
        if (charSequence.length() != 0) {
            Iterable iterableW = StringsKt__StringsKt.W(charSequence);
            if (!(iterableW instanceof Collection) || !((Collection) iterableW).isEmpty()) {
                Iterator it = iterableW.iterator();
                while (it.hasNext()) {
                    if (!a.c(charSequence.charAt(((IntIterator) it).a()))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static final boolean z(String str, int i11, String other, int i12, int i13, boolean z11) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(other, "other");
        return !z11 ? str.regionMatches(i11, other, i12, i13) : str.regionMatches(z11, i11, other, i12, i13);
    }
}
