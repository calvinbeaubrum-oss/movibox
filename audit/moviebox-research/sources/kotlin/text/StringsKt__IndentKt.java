package kotlin.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public class StringsKt__IndentKt extends e {
    public static final Function1<String, String> b(final String str) {
        return str.length() == 0 ? new Function1<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String line) {
                Intrinsics.g(line, "line");
                return line;
            }
        } : new Function1<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String line) {
                Intrinsics.g(line, "line");
                return str + line;
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001b  */
    /* JADX WARN: Code duplicated, block: B:15:? A[RETURN, SYNTHETIC] */
    public static final int c(String str) {
        int length = str.length();
        int i11 = 0;
        while (i11 < length) {
            if (!a.c(str.charAt(i11))) {
                if (i11 == -1) {
                    return str.length();
                }
                return i11;
            }
            i11++;
        }
        i11 = -1;
        if (i11 == -1) {
            return str.length();
        }
        return i11;
    }

    public static final String d(String str, String newIndent) {
        String strInvoke;
        Intrinsics.g(str, "<this>");
        Intrinsics.g(newIndent, "newIndent");
        List<String> listM0 = StringsKt__StringsKt.m0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM0) {
            if (!l.y((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.h.v(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(c((String) it.next())));
        }
        Integer num = (Integer) CollectionsKt___CollectionsKt.u0(arrayList2);
        int i11 = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * listM0.size());
        Function1<String, String> function1B = b(newIndent);
        int iN = kotlin.collections.g.n(listM0);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listM0) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            String str2 = (String) obj2;
            if ((i11 == 0 || i11 == iN) && l.y(str2)) {
                str2 = null;
            } else {
                String strD1 = n.d1(str2, iIntValue);
                if (strD1 != null && (strInvoke = function1B.invoke(strD1)) != null) {
                    str2 = strInvoke;
                }
            }
            if (str2 != null) {
                arrayList3.add(str2);
            }
            i11 = i12;
        }
        String string = ((StringBuilder) CollectionsKt___CollectionsKt.m0(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics.f(string, "toString(...)");
        return string;
    }

    public static final String e(String str, String newIndent, String marginPrefix) {
        int i11;
        String strInvoke;
        Intrinsics.g(str, "<this>");
        Intrinsics.g(newIndent, "newIndent");
        Intrinsics.g(marginPrefix, "marginPrefix");
        if (!(!l.y(marginPrefix))) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        List<String> listM0 = StringsKt__StringsKt.m0(str);
        int length = str.length() + (newIndent.length() * listM0.size());
        Function1<String, String> function1B = b(newIndent);
        int iN = kotlin.collections.g.n(listM0);
        ArrayList arrayList = new ArrayList();
        int i12 = 0;
        for (Object obj : listM0) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                kotlin.collections.g.u();
            }
            String str2 = (String) obj;
            String strSubstring = null;
            if ((i12 == 0 || i12 == iN) && l.y(str2)) {
                str2 = null;
            } else {
                int length2 = str2.length();
                int i14 = 0;
                while (true) {
                    if (i14 >= length2) {
                        i11 = -1;
                        break;
                    }
                    if (!a.c(str2.charAt(i14))) {
                        i11 = i14;
                        break;
                    }
                    i14++;
                }
                if (i11 != -1) {
                    int i15 = i11;
                    if (l.K(str2, marginPrefix, i11, false, 4, null)) {
                        int length3 = i15 + marginPrefix.length();
                        Intrinsics.e(str2, "null cannot be cast to non-null type java.lang.String");
                        strSubstring = str2.substring(length3);
                        Intrinsics.f(strSubstring, "substring(...)");
                    }
                }
                if (strSubstring != null && (strInvoke = function1B.invoke(strSubstring)) != null) {
                    str2 = strInvoke;
                }
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            i12 = i13;
        }
        String string = ((StringBuilder) CollectionsKt___CollectionsKt.m0(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics.f(string, "toString(...)");
        return string;
    }

    @IntrinsicConstEvaluation
    public static String f(String str) {
        Intrinsics.g(str, "<this>");
        return d(str, "");
    }

    @IntrinsicConstEvaluation
    public static final String g(String str, String marginPrefix) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(marginPrefix, "marginPrefix");
        return e(str, "", marginPrefix);
    }

    public static /* synthetic */ String h(String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str2 = "|";
        }
        return g(str, str2);
    }
}
