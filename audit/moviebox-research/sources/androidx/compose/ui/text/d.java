package androidx.compose.ui.text;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnnotatedString f5768a = new AnnotatedString("", null, null, 6, null);

    public static final boolean c(int i11, int i12, int i13, int i14) {
        if (i11 > i13 || i14 > i12) {
            return false;
        }
        if (i12 == i14) {
            if ((i13 == i14) != (i11 == i12)) {
                return false;
            }
        }
        return true;
    }

    public static final <T> List<AnnotatedString.b<T>> d(List<? extends AnnotatedString.b<? extends T>> list, int i11, int i12) {
        if (i11 > i12) {
            throw new IllegalArgumentException(("start (" + i11 + ") should be less than or equal to end (" + i12 + ')').toString());
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i13 = 0; i13 < size; i13++) {
            AnnotatedString.b<? extends T> bVar = list.get(i13);
            AnnotatedString.b<? extends T> bVar2 = bVar;
            if (f(i11, i12, bVar2.f(), bVar2.d())) {
                arrayList.add(bVar);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i14 = 0; i14 < size2; i14++) {
            AnnotatedString.b bVar3 = (AnnotatedString.b) arrayList.get(i14);
            arrayList2.add(new AnnotatedString.b(bVar3.e(), Math.max(i11, bVar3.f()) - i11, Math.min(i12, bVar3.d()) - i11, bVar3.g()));
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        return arrayList2;
    }

    public static final List<AnnotatedString.b<y>> e(AnnotatedString annotatedString, int i11, int i12) {
        List<AnnotatedString.b<y>> listH;
        if (i11 == i12 || (listH = annotatedString.h()) == null) {
            return null;
        }
        if (i11 == 0 && i12 >= annotatedString.i().length()) {
            return listH;
        }
        ArrayList arrayList = new ArrayList(listH.size());
        int size = listH.size();
        for (int i13 = 0; i13 < size; i13++) {
            AnnotatedString.b<y> bVar = listH.get(i13);
            AnnotatedString.b<y> bVar2 = bVar;
            if (f(i11, i12, bVar2.f(), bVar2.d())) {
                arrayList.add(bVar);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i14 = 0; i14 < size2; i14++) {
            AnnotatedString.b bVar3 = (AnnotatedString.b) arrayList.get(i14);
            arrayList2.add(new AnnotatedString.b(bVar3.e(), kotlin.ranges.a.k(bVar3.f(), i11, i12) - i11, kotlin.ranges.a.k(bVar3.d(), i11, i12) - i11));
        }
        return arrayList2;
    }

    public static final boolean f(int i11, int i12, int i13, int i14) {
        return Math.max(i11, i13) < Math.min(i12, i14) || c(i11, i12, i13, i14) || c(i13, i14, i11, i12);
    }

    public static final List<AnnotatedString.b<r>> g(AnnotatedString annotatedString, r rVar) {
        int length = annotatedString.i().length();
        List<AnnotatedString.b<r>> listF = annotatedString.f();
        if (listF == null) {
            listF = kotlin.collections.g.l();
        }
        ArrayList arrayList = new ArrayList();
        int size = listF.size();
        int i11 = 0;
        int i12 = 0;
        while (i11 < size) {
            AnnotatedString.b<r> bVar = listF.get(i11);
            r rVarA = bVar.a();
            int iB = bVar.b();
            int iC = bVar.c();
            if (iB != i12) {
                arrayList.add(new AnnotatedString.b(rVar, i12, iB));
            }
            arrayList.add(new AnnotatedString.b(rVar.l(rVarA), iB, iC));
            i11++;
            i12 = iC;
        }
        if (i12 != length) {
            arrayList.add(new AnnotatedString.b(rVar, i12, length));
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new AnnotatedString.b(rVar, 0, 0));
        }
        return arrayList;
    }

    public static final AnnotatedString h(AnnotatedString annotatedString, int i11, int i12) {
        String strSubstring;
        if (i11 != i12) {
            strSubstring = annotatedString.i().substring(i11, i12);
            Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            strSubstring = "";
        }
        return new AnnotatedString(strSubstring, e(annotatedString, i11, i12), null, null, 12, null);
    }
}
