package androidx.compose.foundation.lazy;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
public final class h {
    public static final n a(List<n> list, o oVar, List<Integer> list2, int i11, int i12, int i13) {
        int index = ((n) CollectionsKt___CollectionsKt.e0(list)).getIndex();
        int size = list2.size();
        int i14 = 0;
        int iIntValue = -1;
        int iIntValue2 = -1;
        while (i14 < size && list2.get(i14).intValue() <= index) {
            iIntValue2 = list2.get(i14).intValue();
            i14++;
            iIntValue = ((i14 < 0 || i14 > kotlin.collections.g.n(list2)) ? -1 : list2.get(i14)).intValue();
        }
        int size2 = list.size();
        int iG = Integer.MIN_VALUE;
        int iG2 = Integer.MIN_VALUE;
        int i15 = -1;
        for (int i16 = 0; i16 < size2; i16++) {
            n nVar = list.get(i16);
            if (nVar.getIndex() == iIntValue2) {
                iG = nVar.g();
                i15 = i16;
            } else if (nVar.getIndex() == iIntValue) {
                iG2 = nVar.g();
            }
        }
        if (iIntValue2 == -1) {
            return null;
        }
        n nVarE = o.e(oVar, iIntValue2, 0L, 2, null);
        nVarE.c(true);
        int iMax = iG != Integer.MIN_VALUE ? Math.max(-i11, iG) : -i11;
        if (iG2 != Integer.MIN_VALUE) {
            iMax = Math.min(iMax, iG2 - nVarE.getSize());
        }
        nVarE.r(iMax, i12, i13);
        if (i15 != -1) {
            list.set(i15, nVarE);
        } else {
            list.add(0, nVarE);
        }
        return nVarE;
    }
}
