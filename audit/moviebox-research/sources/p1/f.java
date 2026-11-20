package p1;

import androidx.compose.ui.graphics.m4;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y1.i;
import y1.l;
import y1.n;

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
public final class f extends a {
    public f(b bVar, b bVar2, b bVar3, b bVar4) {
        super(bVar, bVar2, bVar3, bVar4);
    }

    @Override // p1.a
    public m4 b(long j11, float f11, float f12, float f13, float f14, LayoutDirection layoutDirection) {
        if (f11 + f12 + f13 + f14 == 0.0f) {
            return new m4.b(n.c(j11));
        }
        i iVarC = n.c(j11);
        LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
        return new m4.c(l.b(iVarC, y1.b.b(layoutDirection == layoutDirection2 ? f11 : f12, 0.0f, 2, null), y1.b.b(layoutDirection == layoutDirection2 ? f12 : f11, 0.0f, 2, null), y1.b.b(layoutDirection == layoutDirection2 ? f13 : f14, 0.0f, 2, null), y1.b.b(layoutDirection == layoutDirection2 ? f14 : f13, 0.0f, 2, null)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Intrinsics.b(f(), fVar.f()) && Intrinsics.b(e(), fVar.e()) && Intrinsics.b(c(), fVar.c()) && Intrinsics.b(d(), fVar.d());
    }

    public int hashCode() {
        return (((((f().hashCode() * 31) + e().hashCode()) * 31) + c().hashCode()) * 31) + d().hashCode();
    }

    public String toString() {
        return "RoundedCornerShape(topStart = " + f() + ", topEnd = " + e() + ", bottomEnd = " + c() + ", bottomStart = " + d() + ')';
    }
}
