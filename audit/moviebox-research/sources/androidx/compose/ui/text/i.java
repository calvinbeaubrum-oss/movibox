package androidx.compose.ui.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
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
public final class i {
    public static final int a(List<m> list, int i11) {
        byte b11;
        int size = list.size() - 1;
        int i12 = 0;
        while (i12 <= size) {
            int i13 = (i12 + size) >>> 1;
            m mVar = list.get(i13);
            if (mVar.f() > i11) {
                b11 = 1;
            } else {
                b11 = mVar.b() <= i11 ? (byte) -1 : (byte) 0;
            }
            if (b11 < 0) {
                i12 = i13 + 1;
            } else {
                if (b11 <= 0) {
                    return i13;
                }
                size = i13 - 1;
            }
        }
        return -(i12 + 1);
    }

    public static final int b(List<m> list, int i11) {
        byte b11;
        int size = list.size() - 1;
        int i12 = 0;
        while (i12 <= size) {
            int i13 = (i12 + size) >>> 1;
            m mVar = list.get(i13);
            if (mVar.g() > i11) {
                b11 = 1;
            } else {
                b11 = mVar.c() <= i11 ? (byte) -1 : (byte) 0;
            }
            if (b11 < 0) {
                i12 = i13 + 1;
            } else {
                if (b11 <= 0) {
                    return i13;
                }
                size = i13 - 1;
            }
        }
        return -(i12 + 1);
    }

    public static final int c(List<m> list, float f11) {
        byte b11;
        if (f11 <= 0.0f) {
            return 0;
        }
        if (f11 >= ((m) CollectionsKt___CollectionsKt.q0(list)).a()) {
            return kotlin.collections.g.n(list);
        }
        int size = list.size() - 1;
        int i11 = 0;
        while (i11 <= size) {
            int i12 = (i11 + size) >>> 1;
            m mVar = list.get(i12);
            if (mVar.h() > f11) {
                b11 = 1;
            } else {
                b11 = mVar.a() <= f11 ? (byte) -1 : (byte) 0;
            }
            if (b11 < 0) {
                i11 = i12 + 1;
            } else {
                if (b11 <= 0) {
                    return i12;
                }
                size = i12 - 1;
            }
        }
        return -(i11 + 1);
    }

    public static final void d(List<m> list, long j11, Function1<? super m, Unit> function1) {
        int size = list.size();
        for (int iA = a(list, c0.j(j11)); iA < size; iA++) {
            m mVar = list.get(iA);
            if (mVar.f() >= c0.i(j11)) {
                return;
            }
            if (mVar.f() != mVar.b()) {
                function1.invoke(mVar);
            }
        }
    }
}
