package androidx.compose.ui.input.rotary;

import androidx.compose.ui.node.l0;
import g2.b;
import g2.c;
import kotlin.Metadata;
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
final class RotaryInputElement extends l0<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<c, Boolean> f4783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<c, Boolean> f4784c;

    /* JADX WARN: Multi-variable type inference failed */
    public RotaryInputElement(Function1<? super c, Boolean> function1, Function1<? super c, Boolean> function2) {
        this.f4783b = function1;
        this.f4784c = function2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RotaryInputElement)) {
            return false;
        }
        RotaryInputElement rotaryInputElement = (RotaryInputElement) obj;
        return Intrinsics.b(this.f4783b, rotaryInputElement.f4783b) && Intrinsics.b(this.f4784c, rotaryInputElement.f4784c);
    }

    public int hashCode() {
        Function1<c, Boolean> function1 = this.f4783b;
        int iHashCode = (function1 == null ? 0 : function1.hashCode()) * 31;
        Function1<c, Boolean> function2 = this.f4784c;
        return iHashCode + (function2 != null ? function2.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public b a() {
        return new b(this.f4783b, this.f4784c);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(b bVar) {
        bVar.H1(this.f4783b);
        bVar.I1(this.f4784c);
    }

    public String toString() {
        return "RotaryInputElement(onRotaryScrollEvent=" + this.f4783b + ", onPreRotaryScrollEvent=" + this.f4784c + ')';
    }
}
