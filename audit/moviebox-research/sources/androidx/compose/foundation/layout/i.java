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
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final androidx.compose.ui.layout.u f2501a = new ColumnMeasurePolicy(b.f2478a.d(), androidx.compose.ui.b.f3770a.i());

    @PublishedApi
    public static final androidx.compose.ui.layout.u a(b.k kVar, androidx.compose.ui.b.InterfaceC0052b interfaceC0052b, androidx.compose.runtime.i iVar, int i11) {
        androidx.compose.ui.layout.u uVar;
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(1089876336, i11, -1, "androidx.compose.foundation.layout.columnMeasurePolicy (Column.kt:106)");
        }
        if (Intrinsics.b(kVar, b.f2478a.d()) && Intrinsics.b(interfaceC0052b, androidx.compose.ui.b.f3770a.i())) {
            iVar.R(345962472);
            iVar.L();
            uVar = f2501a;
        } else {
            iVar.R(346016319);
            boolean z11 = ((((i11 & 14) ^ 6) > 4 && iVar.Q(kVar)) || (i11 & 6) == 4) | ((((i11 & 112) ^ 48) > 32 && iVar.Q(interfaceC0052b)) || (i11 & 48) == 32);
            Object objY = iVar.y();
            if (z11 || objY == androidx.compose.runtime.i.f3413a.a()) {
                objY = new ColumnMeasurePolicy(kVar, interfaceC0052b);
                iVar.p(objY);
            }
            uVar = (ColumnMeasurePolicy) objY;
            iVar.L();
        }
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return uVar;
    }

    public static final long b(boolean z11, int i11, int i12, int i13, int i14) {
        return !z11 ? q2.c.a(i12, i14, i11, i13) : q2.b.f74225b.a(i12, i14, i11, i13);
    }
}
