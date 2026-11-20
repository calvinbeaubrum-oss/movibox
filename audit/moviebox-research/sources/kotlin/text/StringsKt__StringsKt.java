package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;

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
@SourceDebugExtension
public class StringsKt__StringsKt extends l {
    public static final List<String> A0(CharSequence charSequence, char[] delimiters, boolean z11, int i11) {
        Intrinsics.g(charSequence, "<this>");
        Intrinsics.g(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return C0(charSequence, String.valueOf(delimiters[0]), z11, i11);
        }
        Iterable iterableH = SequencesKt___SequencesKt.h(r0(charSequence, delimiters, 0, z11, i11, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.h.v(iterableH, 10));
        Iterator it = iterableH.iterator();
        while (it.hasNext()) {
            arrayList.add(J0(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    public static final List<String> B0(CharSequence charSequence, String[] delimiters, boolean z11, int i11) {
        Intrinsics.g(charSequence, "<this>");
        Intrinsics.g(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() != 0) {
                return C0(charSequence, str, z11, i11);
            }
        }
        Iterable iterableH = SequencesKt___SequencesKt.h(s0(charSequence, delimiters, 0, z11, i11, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.h.v(iterableH, 10));
        Iterator it = iterableH.iterator();
        while (it.hasNext()) {
            arrayList.add(J0(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    public static final List<String> C0(CharSequence charSequence, String str, boolean z11, int i11) {
        z0(i11);
        int length = 0;
        int iZ = Z(charSequence, str, 0, z11);
        if (iZ == -1 || i11 == 1) {
            return kotlin.collections.f.e(charSequence.toString());
        }
        boolean z12 = i11 > 0;
        ArrayList arrayList = new ArrayList(z12 ? kotlin.ranges.a.g(i11, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iZ).toString());
            length = str.length() + iZ;
            if (z12 && arrayList.size() == i11 - 1) {
                break;
            }
            iZ = Z(charSequence, str, length, z11);
        } while (iZ != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List D0(CharSequence charSequence, char[] cArr, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        return A0(charSequence, cArr, z11, i11);
    }

    public static /* synthetic */ List E0(CharSequence charSequence, String[] strArr, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        return B0(charSequence, strArr, z11, i11);
    }

    public static final Sequence<String> F0(final CharSequence charSequence, String[] delimiters, boolean z11, int i11) {
        Intrinsics.g(charSequence, "<this>");
        Intrinsics.g(delimiters, "delimiters");
        return SequencesKt___SequencesKt.r(s0(charSequence, delimiters, 0, z11, i11, 2, null), new Function1<IntRange, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(IntRange it) {
                Intrinsics.g(it, "it");
                return StringsKt__StringsKt.J0(charSequence, it);
            }
        });
    }

    public static /* synthetic */ Sequence G0(CharSequence charSequence, String[] strArr, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        return F0(charSequence, strArr, z11, i11);
    }

    public static final boolean H0(CharSequence charSequence, CharSequence prefix, boolean z11) {
        Intrinsics.g(charSequence, "<this>");
        Intrinsics.g(prefix, "prefix");
        return (!z11 && (charSequence instanceof String) && (prefix instanceof String)) ? l.L((String) charSequence, (String) prefix, false, 2, null) : t0(charSequence, 0, prefix, 0, prefix.length(), z11);
    }

    public static /* synthetic */ boolean I0(CharSequence charSequence, CharSequence charSequence2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return H0(charSequence, charSequence2, z11);
    }

    public static final String J0(CharSequence charSequence, IntRange range) {
        Intrinsics.g(charSequence, "<this>");
        Intrinsics.g(range, "range");
        return charSequence.subSequence(range.x().intValue(), range.w().intValue() + 1).toString();
    }

    public static final String K0(String str, char c11, String missingDelimiterValue) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(missingDelimiterValue, "missingDelimiterValue");
        int iC0 = c0(str, c11, 0, false, 6, null);
        if (iC0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iC0 + 1, str.length());
        Intrinsics.f(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String L0(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(delimiter, "delimiter");
        Intrinsics.g(missingDelimiterValue, "missingDelimiterValue");
        int iD0 = d0(str, delimiter, 0, false, 6, null);
        if (iD0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iD0 + delimiter.length(), str.length());
        Intrinsics.f(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String M0(String str, char c11, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = str;
        }
        return K0(str, c11, str2);
    }

    public static final boolean N(CharSequence charSequence, char c11, boolean z11) {
        Intrinsics.g(charSequence, "<this>");
        return c0(charSequence, c11, 0, z11, 2, null) >= 0;
    }

    public static /* synthetic */ String N0(String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str3 = str;
        }
        return L0(str, str2, str3);
    }

    public static boolean O(CharSequence charSequence, CharSequence other, boolean z11) {
        Intrinsics.g(charSequence, "<this>");
        Intrinsics.g(other, "other");
        if (other instanceof String) {
            if (d0(charSequence, (String) other, 0, z11, 2, null) < 0) {
                return false;
            }
        } else if (b0(charSequence, other, 0, charSequence.length(), z11, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    public static String O0(String str, char c11, String missingDelimiterValue) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(missingDelimiterValue, "missingDelimiterValue");
        int iI0 = i0(str, c11, 0, false, 6, null);
        if (iI0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iI0 + 1, str.length());
        Intrinsics.f(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ boolean P(CharSequence charSequence, char c11, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return N(charSequence, c11, z11);
    }

    public static String P0(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(delimiter, "delimiter");
        Intrinsics.g(missingDelimiterValue, "missingDelimiterValue");
        int iJ0 = j0(str, delimiter, 0, false, 6, null);
        if (iJ0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iJ0 + delimiter.length(), str.length());
        Intrinsics.f(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ boolean Q(CharSequence charSequence, CharSequence charSequence2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return O(charSequence, charSequence2, z11);
    }

    public static /* synthetic */ String Q0(String str, char c11, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = str;
        }
        return O0(str, c11, str2);
    }

    public static final boolean R(CharSequence charSequence, char c11, boolean z11) {
        Intrinsics.g(charSequence, "<this>");
        return charSequence.length() > 0 && b.g(charSequence.charAt(X(charSequence)), c11, z11);
    }

    public static /* synthetic */ String R0(String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str3 = str;
        }
        return P0(str, str2, str3);
    }

    public static final boolean S(CharSequence charSequence, CharSequence suffix, boolean z11) {
        Intrinsics.g(charSequence, "<this>");
        Intrinsics.g(suffix, "suffix");
        return (!z11 && (charSequence instanceof String) && (suffix instanceof String)) ? l.u((String) charSequence, (String) suffix, false, 2, null) : t0(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z11);
    }

    public static final String S0(String str, char c11, String missingDelimiterValue) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(missingDelimiterValue, "missingDelimiterValue");
        int iC0 = c0(str, c11, 0, false, 6, null);
        if (iC0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iC0);
        Intrinsics.f(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ boolean T(CharSequence charSequence, char c11, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return R(charSequence, c11, z11);
    }

    public static final String T0(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(delimiter, "delimiter");
        Intrinsics.g(missingDelimiterValue, "missingDelimiterValue");
        int iD0 = d0(str, delimiter, 0, false, 6, null);
        if (iD0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iD0);
        Intrinsics.f(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ boolean U(CharSequence charSequence, CharSequence charSequence2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return S(charSequence, charSequence2, z11);
    }

    public static /* synthetic */ String U0(String str, char c11, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = str;
        }
        return S0(str, c11, str2);
    }

    public static final Pair<Integer, String> V(CharSequence charSequence, Collection<String> collection, int i11, boolean z11, boolean z12) {
        Object next;
        String str;
        Object next2;
        String str2;
        if (!z11 && collection.size() == 1) {
            String str3 = (String) CollectionsKt___CollectionsKt.A0(collection);
            int iD0 = !z12 ? d0(charSequence, str3, i11, false, 4, null) : j0(charSequence, str3, i11, false, 4, null);
            if (iD0 < 0) {
                return null;
            }
            return TuplesKt.a(Integer.valueOf(iD0), str3);
        }
        IntProgression intRange = !z12 ? new IntRange(kotlin.ranges.a.d(i11, 0), charSequence.length()) : kotlin.ranges.a.n(kotlin.ranges.a.g(i11, X(charSequence)), 0);
        if (charSequence instanceof String) {
            int iG = intRange.g();
            int i12 = intRange.i();
            int iR = intRange.r();
            if ((iR > 0 && iG <= i12) || (iR < 0 && i12 <= iG)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    do {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        str2 = (String) next2;
                    } while (!l.z(str2, 0, (String) charSequence, iG, str2.length(), z11));
                    String str4 = (String) next2;
                    if (str4 != null) {
                        return TuplesKt.a(Integer.valueOf(iG), str4);
                    }
                    if (iG != i12) {
                        iG += iR;
                    }
                }
            }
        } else {
            int iG2 = intRange.g();
            int i13 = intRange.i();
            int iR2 = intRange.r();
            if ((iR2 > 0 && iG2 <= i13) || (iR2 < 0 && i13 <= iG2)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        str = (String) next;
                    } while (!t0(str, 0, charSequence, iG2, str.length(), z11));
                    String str5 = (String) next;
                    if (str5 != null) {
                        return TuplesKt.a(Integer.valueOf(iG2), str5);
                    }
                    if (iG2 != i13) {
                        iG2 += iR2;
                    }
                }
            }
        }
        return null;
    }

    public static /* synthetic */ String V0(String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str3 = str;
        }
        return T0(str, str2, str3);
    }

    public static final IntRange W(CharSequence charSequence) {
        Intrinsics.g(charSequence, "<this>");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static String W0(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(delimiter, "delimiter");
        Intrinsics.g(missingDelimiterValue, "missingDelimiterValue");
        int iJ0 = j0(str, delimiter, 0, false, 6, null);
        if (iJ0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iJ0);
        Intrinsics.f(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static int X(CharSequence charSequence) {
        Intrinsics.g(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static /* synthetic */ String X0(String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str3 = str;
        }
        return W0(str, str2, str3);
    }

    public static final int Y(CharSequence charSequence, char c11, int i11, boolean z11) {
        Intrinsics.g(charSequence, "<this>");
        return (z11 || !(charSequence instanceof String)) ? e0(charSequence, new char[]{c11}, i11, z11) : ((String) charSequence).indexOf(c11, i11);
    }

    @SinceKotlin
    public static Boolean Y0(String str) {
        Intrinsics.g(str, "<this>");
        if (Intrinsics.b(str, "true")) {
            return Boolean.TRUE;
        }
        if (Intrinsics.b(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static int Z(CharSequence charSequence, String string, int i11, boolean z11) {
        Intrinsics.g(charSequence, "<this>");
        Intrinsics.g(string, "string");
        return (z11 || !(charSequence instanceof String)) ? b0(charSequence, string, i11, charSequence.length(), z11, false, 16, null) : ((String) charSequence).indexOf(string, i11);
    }

    public static CharSequence Z0(CharSequence charSequence) {
        Intrinsics.g(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i11 = 0;
        boolean z11 = false;
        while (i11 <= length) {
            boolean zC = a.c(charSequence.charAt(!z11 ? i11 : length));
            if (z11) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i11++;
            } else {
                z11 = true;
            }
        }
        return charSequence.subSequence(i11, length + 1);
    }

    public static final int a0(CharSequence charSequence, CharSequence charSequence2, int i11, int i12, boolean z11, boolean z12) {
        IntProgression intRange = !z12 ? new IntRange(kotlin.ranges.a.d(i11, 0), kotlin.ranges.a.g(i12, charSequence.length())) : kotlin.ranges.a.n(kotlin.ranges.a.g(i11, X(charSequence)), kotlin.ranges.a.d(i12, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iG = intRange.g();
            int i13 = intRange.i();
            int iR = intRange.r();
            if ((iR <= 0 || iG > i13) && (iR >= 0 || i13 > iG)) {
                return -1;
            }
            while (!l.z((String) charSequence2, 0, (String) charSequence, iG, charSequence2.length(), z11)) {
                if (iG == i13) {
                    return -1;
                }
                iG += iR;
            }
            return iG;
        }
        int iG2 = intRange.g();
        int i14 = intRange.i();
        int iR2 = intRange.r();
        if ((iR2 <= 0 || iG2 > i14) && (iR2 >= 0 || i14 > iG2)) {
            return -1;
        }
        while (!t0(charSequence2, 0, charSequence, iG2, charSequence2.length(), z11)) {
            if (iG2 == i14) {
                return -1;
            }
            iG2 += iR2;
        }
        return iG2;
    }

    public static CharSequence a1(CharSequence charSequence, char... chars) {
        Intrinsics.g(charSequence, "<this>");
        Intrinsics.g(chars, "chars");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (!kotlin.collections.d.F(chars, charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i11 >= 0) {
                    length = i11;
                }
            }
        }
        return "";
    }

    public static /* synthetic */ int b0(CharSequence charSequence, CharSequence charSequence2, int i11, int i12, boolean z11, boolean z12, int i13, Object obj) {
        return a0(charSequence, charSequence2, i11, i12, z11, (i13 & 16) != 0 ? false : z12);
    }

    public static String b1(String str, char... chars) {
        CharSequence charSequenceSubSequence;
        Intrinsics.g(str, "<this>");
        Intrinsics.g(chars, "chars");
        int length = str.length() - 1;
        if (length < 0) {
            charSequenceSubSequence = "";
            break;
        }
        while (true) {
            int i11 = length - 1;
            if (!kotlin.collections.d.F(chars, str.charAt(length))) {
                charSequenceSubSequence = str.subSequence(0, length + 1);
                break;
            }
            if (i11 < 0) {
                charSequenceSubSequence = "";
                break;
            }
            length = i11;
        }
        return charSequenceSubSequence.toString();
    }

    public static /* synthetic */ int c0(CharSequence charSequence, char c11, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return Y(charSequence, c11, i11, z11);
    }

    public static String c1(String str, char... chars) {
        CharSequence charSequenceSubSequence;
        Intrinsics.g(str, "<this>");
        Intrinsics.g(chars, "chars");
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!kotlin.collections.d.F(chars, str.charAt(i11))) {
                charSequenceSubSequence = str.subSequence(i11, str.length());
                return charSequenceSubSequence.toString();
            }
        }
        charSequenceSubSequence = "";
        return charSequenceSubSequence.toString();
    }

    public static /* synthetic */ int d0(CharSequence charSequence, String str, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return Z(charSequence, str, i11, z11);
    }

    public static final int e0(CharSequence charSequence, char[] chars, int i11, boolean z11) {
        Intrinsics.g(charSequence, "<this>");
        Intrinsics.g(chars, "chars");
        if (!z11 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(kotlin.collections.d.s0(chars), i11);
        }
        IntIterator intIteratorS = new IntRange(kotlin.ranges.a.d(i11, 0), X(charSequence)).iterator();
        while (intIteratorS.hasNext()) {
            int iA = intIteratorS.a();
            char cCharAt = charSequence.charAt(iA);
            for (char c11 : chars) {
                if (b.g(c11, cCharAt, z11)) {
                    return iA;
                }
            }
        }
        return -1;
    }

    public static final CharIterator f0(final CharSequence charSequence) {
        Intrinsics.g(charSequence, "<this>");
        return new CharIterator() { // from class: kotlin.text.StringsKt__StringsKt$iterator$1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f69147a;

            @Override // kotlin.collections.CharIterator
            public char a() {
                CharSequence charSequence2 = charSequence;
                int i11 = this.f69147a;
                this.f69147a = i11 + 1;
                return charSequence2.charAt(i11);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f69147a < charSequence.length();
            }
        };
    }

    public static final int g0(CharSequence charSequence, char c11, int i11, boolean z11) {
        Intrinsics.g(charSequence, "<this>");
        return (z11 || !(charSequence instanceof String)) ? k0(charSequence, new char[]{c11}, i11, z11) : ((String) charSequence).lastIndexOf(c11, i11);
    }

    public static final int h0(CharSequence charSequence, String string, int i11, boolean z11) {
        Intrinsics.g(charSequence, "<this>");
        Intrinsics.g(string, "string");
        return (z11 || !(charSequence instanceof String)) ? a0(charSequence, string, i11, 0, z11, true) : ((String) charSequence).lastIndexOf(string, i11);
    }

    public static /* synthetic */ int i0(CharSequence charSequence, char c11, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = X(charSequence);
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return g0(charSequence, c11, i11, z11);
    }

    public static /* synthetic */ int j0(CharSequence charSequence, String str, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = X(charSequence);
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return h0(charSequence, str, i11, z11);
    }

    public static final int k0(CharSequence charSequence, char[] chars, int i11, boolean z11) {
        Intrinsics.g(charSequence, "<this>");
        Intrinsics.g(chars, "chars");
        if (!z11 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(kotlin.collections.d.s0(chars), i11);
        }
        for (int iG = kotlin.ranges.a.g(i11, X(charSequence)); -1 < iG; iG--) {
            char cCharAt = charSequence.charAt(iG);
            for (char c11 : chars) {
                if (b.g(c11, cCharAt, z11)) {
                    return iG;
                }
            }
        }
        return -1;
    }

    public static final Sequence<String> l0(CharSequence charSequence) {
        Intrinsics.g(charSequence, "<this>");
        return G0(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> m0(CharSequence charSequence) {
        Intrinsics.g(charSequence, "<this>");
        return SequencesKt___SequencesKt.v(l0(charSequence));
    }

    public static final CharSequence n0(CharSequence charSequence, int i11, char c11) {
        Intrinsics.g(charSequence, "<this>");
        if (i11 < 0) {
            throw new IllegalArgumentException("Desired length " + i11 + " is less than zero.");
        }
        if (i11 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb2 = new StringBuilder(i11);
        IntIterator intIteratorS = new IntRange(1, i11 - charSequence.length()).iterator();
        while (intIteratorS.hasNext()) {
            intIteratorS.a();
            sb2.append(c11);
        }
        sb2.append(charSequence);
        return sb2;
    }

    public static String o0(String str, int i11, char c11) {
        Intrinsics.g(str, "<this>");
        return n0(str, i11, c11).toString();
    }

    public static final Sequence<IntRange> p0(CharSequence charSequence, final char[] cArr, int i11, final boolean z11, int i12) {
        z0(i12);
        return new DelimitedRangesSequence(charSequence, i11, i12, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return invoke(charSequence2, num.intValue());
            }

            public final Pair<Integer, Integer> invoke(CharSequence $receiver, int i13) {
                Intrinsics.g($receiver, "$this$$receiver");
                int iE0 = StringsKt__StringsKt.e0($receiver, cArr, i13, z11);
                if (iE0 < 0) {
                    return null;
                }
                return TuplesKt.a(Integer.valueOf(iE0), 1);
            }
        });
    }

    public static final Sequence<IntRange> q0(CharSequence charSequence, String[] strArr, int i11, final boolean z11, int i12) {
        z0(i12);
        final List listG = ArraysKt___ArraysJvmKt.g(strArr);
        return new DelimitedRangesSequence(charSequence, i11, i12, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return invoke(charSequence2, num.intValue());
            }

            public final Pair<Integer, Integer> invoke(CharSequence $receiver, int i13) {
                Intrinsics.g($receiver, "$this$$receiver");
                Pair pairV = StringsKt__StringsKt.V($receiver, listG, i13, z11, false);
                if (pairV != null) {
                    return TuplesKt.a(pairV.getFirst(), Integer.valueOf(((String) pairV.getSecond()).length()));
                }
                return null;
            }
        });
    }

    public static /* synthetic */ Sequence r0(CharSequence charSequence, char[] cArr, int i11, boolean z11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            z11 = false;
        }
        if ((i13 & 8) != 0) {
            i12 = 0;
        }
        return p0(charSequence, cArr, i11, z11, i12);
    }

    public static /* synthetic */ Sequence s0(CharSequence charSequence, String[] strArr, int i11, boolean z11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            z11 = false;
        }
        if ((i13 & 8) != 0) {
            i12 = 0;
        }
        return q0(charSequence, strArr, i11, z11, i12);
    }

    public static final boolean t0(CharSequence charSequence, int i11, CharSequence other, int i12, int i13, boolean z11) {
        Intrinsics.g(charSequence, "<this>");
        Intrinsics.g(other, "other");
        if (i12 < 0 || i11 < 0 || i11 > charSequence.length() - i13 || i12 > other.length() - i13) {
            return false;
        }
        for (int i14 = 0; i14 < i13; i14++) {
            if (!b.g(charSequence.charAt(i11 + i14), other.charAt(i12 + i14), z11)) {
                return false;
            }
        }
        return true;
    }

    public static String u0(String str, CharSequence prefix) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(prefix, "prefix");
        if (!I0(str, prefix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length());
        Intrinsics.f(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String v0(String str, CharSequence suffix) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(suffix, "suffix");
        if (!U(str, suffix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - suffix.length());
        Intrinsics.f(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String w0(String str, CharSequence delimiter) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(delimiter, "delimiter");
        return x0(str, delimiter, delimiter);
    }

    public static final String x0(String str, CharSequence prefix, CharSequence suffix) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(prefix, "prefix");
        Intrinsics.g(suffix, "suffix");
        if (str.length() < prefix.length() + suffix.length() || !I0(str, prefix, false, 2, null) || !U(str, suffix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length(), str.length() - suffix.length());
        Intrinsics.f(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence y0(CharSequence charSequence, int i11, int i12, CharSequence replacement) {
        Intrinsics.g(charSequence, "<this>");
        Intrinsics.g(replacement, "replacement");
        if (i12 >= i11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(charSequence, 0, i11);
            Intrinsics.f(sb2, "append(...)");
            sb2.append(replacement);
            sb2.append(charSequence, i12, charSequence.length());
            Intrinsics.f(sb2, "append(...)");
            return sb2;
        }
        throw new IndexOutOfBoundsException("End index (" + i12 + ") is less than start index (" + i11 + ").");
    }

    public static final void z0(int i11) {
        if (i11 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i11).toString());
    }
}
