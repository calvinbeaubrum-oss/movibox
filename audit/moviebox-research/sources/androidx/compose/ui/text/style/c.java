package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.w1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class c implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6060b;

    public c(long j11) {
        this.f6060b = j11;
        if (j11 == 16) {
            throw new IllegalArgumentException("ColorStyle value must be specified, use TextForegroundStyle.Unspecified instead.".toString());
        }
    }

    public /* synthetic */ c(long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11);
    }

    @Override // androidx.compose.ui.text.style.l
    public long a() {
        return this.f6060b;
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
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && w1.m(this.f6060b, ((c) obj).f6060b);
    }

    @Override // androidx.compose.ui.text.style.l
    public float getAlpha() {
        return w1.n(a());
    }

    public int hashCode() {
        return w1.s(this.f6060b);
    }

    public String toString() {
        return "ColorStyle(value=" + ((Object) w1.t(this.f6060b)) + ')';
    }
}
