package androidx.compose.ui.semantics;

import androidx.compose.ui.node.l0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class AppendedSemanticsElement extends l0<d> implements m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<q, Unit> f5584c;

    /* JADX WARN: Multi-variable type inference failed */
    public AppendedSemanticsElement(boolean z11, Function1<? super q, Unit> function1) {
        this.f5583b = z11;
        this.f5584c = function1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppendedSemanticsElement)) {
            return false;
        }
        AppendedSemanticsElement appendedSemanticsElement = (AppendedSemanticsElement) obj;
        return this.f5583b == appendedSemanticsElement.f5583b && Intrinsics.b(this.f5584c, appendedSemanticsElement.f5584c);
    }

    public int hashCode() {
        return (androidx.compose.foundation.e.a(this.f5583b) * 31) + this.f5584c.hashCode();
    }

    @Override // androidx.compose.ui.semantics.m
    public l n() {
        l lVar = new l();
        lVar.y(this.f5583b);
        this.f5584c.invoke(lVar);
        return lVar;
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public d a() {
        return new d(this.f5583b, false, this.f5584c);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(d dVar) {
        dVar.H1(this.f5583b);
        dVar.I1(this.f5584c);
    }

    public String toString() {
        return "AppendedSemanticsElement(mergeDescendants=" + this.f5583b + ", properties=" + this.f5584c + ')';
    }
}
