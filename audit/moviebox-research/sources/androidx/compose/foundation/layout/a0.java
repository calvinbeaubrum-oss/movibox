package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.PublishedApi;
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
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final androidx.compose.ui.layout.u f2477a = new RowMeasurePolicy(b.f2478a.c(), androidx.compose.ui.b.f3770a.j());

    public static final long a(boolean z11, int i11, int i12, int i13, int i14) {
        return !z11 ? q2.c.a(i11, i13, i12, i14) : q2.b.f74225b.b(i11, i13, i12, i14);
    }

    @PublishedApi
    public static final androidx.compose.ui.layout.u b(b.d dVar, androidx.compose.ui.b.c cVar, androidx.compose.runtime.i iVar, int i11) {
        androidx.compose.ui.layout.u uVar;
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(-837807694, i11, -1, "androidx.compose.foundation.layout.rowMeasurePolicy (Row.kt:122)");
        }
        if (Intrinsics.b(dVar, b.f2478a.c()) && Intrinsics.b(cVar, androidx.compose.ui.b.f3770a.j())) {
            iVar.R(-849081669);
            iVar.L();
            uVar = f2477a;
        } else {
            iVar.R(-849030798);
            boolean z11 = ((((i11 & 14) ^ 6) > 4 && iVar.Q(dVar)) || (i11 & 6) == 4) | ((((i11 & 112) ^ 48) > 32 && iVar.Q(cVar)) || (i11 & 48) == 32);
            Object objY = iVar.y();
            if (z11 || objY == androidx.compose.runtime.i.f3413a.a()) {
                objY = new RowMeasurePolicy(dVar, cVar);
                iVar.p(objY);
            }
            uVar = (RowMeasurePolicy) objY;
            iVar.L();
        }
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return uVar;
    }
}
