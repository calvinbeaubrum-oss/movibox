package androidx.compose.material;

import androidx.compose.foundation.b0;
import androidx.compose.foundation.w;
import androidx.compose.foundation.y;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.z1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class i implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f3091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z1 f3092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f3093d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements z1 {
        public a() {
        }

        @Override // androidx.compose.ui.graphics.z1
        public final long a() {
            return i.this.f3093d;
        }
    }

    public i(boolean z11, float f11, long j11) {
        this(z11, f11, (z1) null, j11);
    }

    public /* synthetic */ i(boolean z11, float f11, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, f11, j11);
    }

    public i(boolean z11, float f11, z1 z1Var, long j11) {
        this.f3090a = z11;
        this.f3091b = f11;
        this.f3092c = z1Var;
        this.f3093d = j11;
    }

    @Override // androidx.compose.foundation.b0
    public androidx.compose.ui.node.f a(o1.g gVar) {
        z1 aVar = this.f3092c;
        if (aVar == null) {
            aVar = new a();
        }
        return new DelegatingThemeAwareRippleNode(gVar, this.f3090a, this.f3091b, aVar, null);
    }

    @Override // androidx.compose.foundation.x
    public /* synthetic */ y b(o1.g gVar, androidx.compose.runtime.i iVar, int i11) {
        return w.a(this, gVar, iVar, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f3090a == iVar.f3090a && q2.i.j(this.f3091b, iVar.f3091b) && Intrinsics.b(this.f3092c, iVar.f3092c)) {
            return w1.m(this.f3093d, iVar.f3093d);
        }
        return false;
    }

    public int hashCode() {
        int iA = ((androidx.compose.foundation.e.a(this.f3090a) * 31) + q2.i.k(this.f3091b)) * 31;
        z1 z1Var = this.f3092c;
        return ((iA + (z1Var != null ? z1Var.hashCode() : 0)) * 31) + w1.s(this.f3093d);
    }
}
