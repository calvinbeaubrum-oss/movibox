package androidx.compose.ui.input.key;

import androidx.compose.ui.node.l0;
import e2.b;
import e2.f;
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
final class KeyInputElement extends l0<f> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<b, Boolean> f4617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<b, Boolean> f4618c;

    /* JADX WARN: Multi-variable type inference failed */
    public KeyInputElement(Function1<? super b, Boolean> function1, Function1<? super b, Boolean> function2) {
        this.f4617b = function1;
        this.f4618c = function2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyInputElement)) {
            return false;
        }
        KeyInputElement keyInputElement = (KeyInputElement) obj;
        return Intrinsics.b(this.f4617b, keyInputElement.f4617b) && Intrinsics.b(this.f4618c, keyInputElement.f4618c);
    }

    public int hashCode() {
        Function1<b, Boolean> function1 = this.f4617b;
        int iHashCode = (function1 == null ? 0 : function1.hashCode()) * 31;
        Function1<b, Boolean> function2 = this.f4618c;
        return iHashCode + (function2 != null ? function2.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public f a() {
        return new f(this.f4617b, this.f4618c);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(f fVar) {
        fVar.H1(this.f4617b);
        fVar.I1(this.f4618c);
    }

    public String toString() {
        return "KeyInputElement(onKeyEvent=" + this.f4617b + ", onPreKeyEvent=" + this.f4618c + ')';
    }
}
