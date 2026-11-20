package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.a5;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.w1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class b implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a5 f6058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f6059c;

    public b(a5 a5Var, float f11) {
        this.f6058b = a5Var;
        this.f6059c = f11;
    }

    @Override // androidx.compose.ui.text.style.l
    public long a() {
        return w1.f4564b.e();
    }

    @Override // androidx.compose.ui.text.style.l
    public /* synthetic */ l b(Function0 function0) {
        return TextForegroundStyle$CC.b(this, function0);
    }

    @Override // androidx.compose.ui.text.style.l
    public /* synthetic */ l c(l lVar) {
        return TextForegroundStyle$CC.a(this, lVar);
    }

    @Override // androidx.compose.ui.text.style.l
    public l1 d() {
        return this.f6058b;
    }

    public final a5 e() {
        return this.f6058b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.b(this.f6058b, bVar.f6058b) && Float.compare(this.f6059c, bVar.f6059c) == 0;
    }

    @Override // androidx.compose.ui.text.style.l
    public float getAlpha() {
        return this.f6059c;
    }

    public int hashCode() {
        return (this.f6058b.hashCode() * 31) + Float.floatToIntBits(this.f6059c);
    }

    public String toString() {
        return "BrushStyle(value=" + this.f6058b + ", alpha=" + this.f6059c + ')';
    }
}
