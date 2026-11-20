package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.t0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class o implements t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LazyLayoutItemContentFactory f2728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Object, Integer> f2729b = new LinkedHashMap();

    public o(LazyLayoutItemContentFactory lazyLayoutItemContentFactory) {
        this.f2728a = lazyLayoutItemContentFactory;
    }

    @Override // androidx.compose.ui.layout.t0
    public void a(t0.a aVar) {
        this.f2729b.clear();
        Iterator<Object> it = aVar.iterator();
        while (it.hasNext()) {
            Object objC = this.f2728a.c(it.next());
            Integer num = this.f2729b.get(objC);
            int iIntValue = num != null ? num.intValue() : 0;
            if (iIntValue == 7) {
                it.remove();
            } else {
                this.f2729b.put(objC, Integer.valueOf(iIntValue + 1));
            }
        }
    }

    @Override // androidx.compose.ui.layout.t0
    public boolean b(Object obj, Object obj2) {
        return Intrinsics.b(this.f2728a.c(obj), this.f2728a.c(obj2));
    }
}
