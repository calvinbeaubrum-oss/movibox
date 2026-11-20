package androidx.compose.foundation;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.y1;
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
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.compose.foundation.layout.t f2266b;

    public e0(long j11, androidx.compose.foundation.layout.t tVar) {
        this.f2265a = j11;
        this.f2266b = tVar;
    }

    public /* synthetic */ e0(long j11, androidx.compose.foundation.layout.t tVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? y1.d(4284900966L) : j11, (i11 & 2) != 0 ? PaddingKt.c(0.0f, 0.0f, 3, null) : tVar, null);
    }

    public /* synthetic */ e0(long j11, androidx.compose.foundation.layout.t tVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, tVar);
    }

    public final androidx.compose.foundation.layout.t a() {
        return this.f2266b;
    }

    public final long b() {
        return this.f2265a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.b(e0.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.e(obj, "null cannot be cast to non-null type androidx.compose.foundation.OverscrollConfiguration");
        e0 e0Var = (e0) obj;
        return w1.m(this.f2265a, e0Var.f2265a) && Intrinsics.b(this.f2266b, e0Var.f2266b);
    }

    public int hashCode() {
        return (w1.s(this.f2265a) * 31) + this.f2266b.hashCode();
    }

    public String toString() {
        return "OverscrollConfiguration(glowColor=" + ((Object) w1.t(this.f2265a)) + ", drawPadding=" + this.f2266b + ')';
    }
}
