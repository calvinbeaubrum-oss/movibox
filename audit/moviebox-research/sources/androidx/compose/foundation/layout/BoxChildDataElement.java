package androidx.compose.foundation.layout;

import androidx.compose.ui.node.l0;
import androidx.compose.ui.platform.e1;
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
final class BoxChildDataElement extends l0<e> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.compose.ui.b f2376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<e1, Unit> f2378d;

    /* JADX WARN: Multi-variable type inference failed */
    public BoxChildDataElement(androidx.compose.ui.b bVar, boolean z11, Function1<? super e1, Unit> function1) {
        this.f2376b = bVar;
        this.f2377c = z11;
        this.f2378d = function1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        BoxChildDataElement boxChildDataElement = obj instanceof BoxChildDataElement ? (BoxChildDataElement) obj : null;
        return boxChildDataElement != null && Intrinsics.b(this.f2376b, boxChildDataElement.f2376b) && this.f2377c == boxChildDataElement.f2377c;
    }

    public int hashCode() {
        return (this.f2376b.hashCode() * 31) + androidx.compose.foundation.e.a(this.f2377c);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public e a() {
        return new e(this.f2376b, this.f2377c);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(e eVar) {
        eVar.K1(this.f2376b);
        eVar.L1(this.f2377c);
    }
}
