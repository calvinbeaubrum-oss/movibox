package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f5761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f5762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f5763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f5764d;

    public b0() {
        this(null, null, null, null, 15, null);
    }

    public b0(y yVar, y yVar2, y yVar3, y yVar4) {
        this.f5761a = yVar;
        this.f5762b = yVar2;
        this.f5763c = yVar3;
        this.f5764d = yVar4;
    }

    public /* synthetic */ b0(y yVar, y yVar2, y yVar3, y yVar4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : yVar, (i11 & 2) != 0 ? null : yVar2, (i11 & 4) != 0 ? null : yVar3, (i11 & 8) != 0 ? null : yVar4);
    }

    public final y a() {
        return this.f5762b;
    }

    public final y b() {
        return this.f5763c;
    }

    public final y c() {
        return this.f5764d;
    }

    public final y d() {
        return this.f5761a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return Intrinsics.b(this.f5761a, b0Var.f5761a) && Intrinsics.b(this.f5762b, b0Var.f5762b) && Intrinsics.b(this.f5763c, b0Var.f5763c) && Intrinsics.b(this.f5764d, b0Var.f5764d);
    }

    public int hashCode() {
        y yVar = this.f5761a;
        int iHashCode = (yVar != null ? yVar.hashCode() : 0) * 31;
        y yVar2 = this.f5762b;
        int iHashCode2 = (iHashCode + (yVar2 != null ? yVar2.hashCode() : 0)) * 31;
        y yVar3 = this.f5763c;
        int iHashCode3 = (iHashCode2 + (yVar3 != null ? yVar3.hashCode() : 0)) * 31;
        y yVar4 = this.f5764d;
        return iHashCode3 + (yVar4 != null ? yVar4.hashCode() : 0);
    }
}
