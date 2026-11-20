package androidx.compose.ui.graphics.vector;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
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
public final class f {
    public static final void a(char c11, ArrayList<e> arrayList, float[] fArr, int i11) {
        if (c11 == 'z' || c11 == 'Z') {
            arrayList.add(e.b.f4478c);
            return;
        }
        if (c11 == 'm') {
            c(arrayList, fArr, i11);
            return;
        }
        if (c11 == 'M') {
            b(arrayList, fArr, i11);
            return;
        }
        int i12 = 0;
        if (c11 == 'l') {
            int i13 = i11 - 2;
            while (i12 <= i13) {
                arrayList.add(new e.m(fArr[i12], fArr[i12 + 1]));
                i12 += 2;
            }
            return;
        }
        if (c11 == 'L') {
            int i14 = i11 - 2;
            while (i12 <= i14) {
                arrayList.add(new e.C0057e(fArr[i12], fArr[i12 + 1]));
                i12 += 2;
            }
            return;
        }
        if (c11 == 'h') {
            int i15 = i11 - 1;
            while (i12 <= i15) {
                arrayList.add(new e.l(fArr[i12]));
                i12++;
            }
            return;
        }
        if (c11 == 'H') {
            int i16 = i11 - 1;
            while (i12 <= i16) {
                arrayList.add(new e.d(fArr[i12]));
                i12++;
            }
            return;
        }
        if (c11 == 'v') {
            int i17 = i11 - 1;
            while (i12 <= i17) {
                arrayList.add(new e.r(fArr[i12]));
                i12++;
            }
            return;
        }
        if (c11 == 'V') {
            int i18 = i11 - 1;
            while (i12 <= i18) {
                arrayList.add(new e.s(fArr[i12]));
                i12++;
            }
            return;
        }
        if (c11 == 'c') {
            int i19 = i11 - 6;
            while (i12 <= i19) {
                arrayList.add(new e.k(fArr[i12], fArr[i12 + 1], fArr[i12 + 2], fArr[i12 + 3], fArr[i12 + 4], fArr[i12 + 5]));
                i12 += 6;
            }
            return;
        }
        if (c11 == 'C') {
            int i21 = i11 - 6;
            while (i12 <= i21) {
                arrayList.add(new e.c(fArr[i12], fArr[i12 + 1], fArr[i12 + 2], fArr[i12 + 3], fArr[i12 + 4], fArr[i12 + 5]));
                i12 += 6;
            }
            return;
        }
        if (c11 == 's') {
            int i22 = i11 - 4;
            while (i12 <= i22) {
                arrayList.add(new e.p(fArr[i12], fArr[i12 + 1], fArr[i12 + 2], fArr[i12 + 3]));
                i12 += 4;
            }
            return;
        }
        if (c11 == 'S') {
            int i23 = i11 - 4;
            while (i12 <= i23) {
                arrayList.add(new e.h(fArr[i12], fArr[i12 + 1], fArr[i12 + 2], fArr[i12 + 3]));
                i12 += 4;
            }
            return;
        }
        if (c11 == 'q') {
            int i24 = i11 - 4;
            while (i12 <= i24) {
                arrayList.add(new e.o(fArr[i12], fArr[i12 + 1], fArr[i12 + 2], fArr[i12 + 3]));
                i12 += 4;
            }
            return;
        }
        if (c11 == 'Q') {
            int i25 = i11 - 4;
            while (i12 <= i25) {
                arrayList.add(new e.g(fArr[i12], fArr[i12 + 1], fArr[i12 + 2], fArr[i12 + 3]));
                i12 += 4;
            }
            return;
        }
        if (c11 == 't') {
            int i26 = i11 - 2;
            while (i12 <= i26) {
                arrayList.add(new e.q(fArr[i12], fArr[i12 + 1]));
                i12 += 2;
            }
            return;
        }
        if (c11 == 'T') {
            int i27 = i11 - 2;
            while (i12 <= i27) {
                arrayList.add(new e.i(fArr[i12], fArr[i12 + 1]));
                i12 += 2;
            }
            return;
        }
        if (c11 == 'a') {
            int i28 = i11 - 7;
            for (int i29 = 0; i29 <= i28; i29 += 7) {
                arrayList.add(new e.j(fArr[i29], fArr[i29 + 1], fArr[i29 + 2], Float.compare(fArr[i29 + 3], 0.0f) != 0, Float.compare(fArr[i29 + 4], 0.0f) != 0, fArr[i29 + 5], fArr[i29 + 6]));
            }
            return;
        }
        if (c11 != 'A') {
            throw new IllegalArgumentException("Unknown command for: " + c11);
        }
        int i31 = i11 - 7;
        for (int i32 = 0; i32 <= i31; i32 += 7) {
            arrayList.add(new e.a(fArr[i32], fArr[i32 + 1], fArr[i32 + 2], Float.compare(fArr[i32 + 3], 0.0f) != 0, Float.compare(fArr[i32 + 4], 0.0f) != 0, fArr[i32 + 5], fArr[i32 + 6]));
        }
    }

    public static final void b(List<e> list, float[] fArr, int i11) {
        int i12 = i11 - 2;
        if (i12 >= 0) {
            list.add(new e.f(fArr[0], fArr[1]));
            for (int i13 = 2; i13 <= i12; i13 += 2) {
                list.add(new e.C0057e(fArr[i13], fArr[i13 + 1]));
            }
        }
    }

    public static final void c(List<e> list, float[] fArr, int i11) {
        int i12 = i11 - 2;
        if (i12 >= 0) {
            list.add(new e.n(fArr[0], fArr[1]));
            for (int i13 = 2; i13 <= i12; i13 += 2) {
                list.add(new e.m(fArr[i13], fArr[i13 + 1]));
            }
        }
    }
}
