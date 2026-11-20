package androidx.compose.foundation.lazy.layout;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class i {
    public static final List<Integer> a(m mVar, w wVar, e eVar) {
        if (!eVar.d() && wVar.isEmpty()) {
            return kotlin.collections.g.l();
        }
        ArrayList arrayList = new ArrayList();
        IntRange intRange = eVar.d() ? new IntRange(eVar.c(), Math.min(eVar.b(), mVar.getItemCount() - 1)) : IntRange.f68968f.a();
        int size = wVar.size();
        for (int i11 = 0; i11 < size; i11++) {
            w.a aVar = wVar.get(i11);
            int iA = n.a(mVar, aVar.getKey(), aVar.getIndex());
            int iG = intRange.g();
            if ((iA > intRange.i() || iG > iA) && iA >= 0 && iA < mVar.getItemCount()) {
                arrayList.add(Integer.valueOf(iA));
            }
        }
        int iG2 = intRange.g();
        int i12 = intRange.i();
        if (iG2 <= i12) {
            while (true) {
                arrayList.add(Integer.valueOf(iG2));
                if (iG2 == i12) {
                    break;
                }
                iG2++;
            }
        }
        return arrayList;
    }
}
