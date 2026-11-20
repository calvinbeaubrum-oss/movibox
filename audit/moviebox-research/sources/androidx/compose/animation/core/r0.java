package androidx.compose.animation.core;

import com.google.logging.type.LogSeverity;
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
public final class r0<T> implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f2133c;

    public r0() {
        this(0, 0, null, 7, null);
    }

    public r0(int i11, int i12, z zVar) {
        this.f2131a = i11;
        this.f2132b = i12;
        this.f2133c = zVar;
    }

    public /* synthetic */ r0(int i11, int i12, z zVar, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? LogSeverity.NOTICE_VALUE : i11, (i13 & 2) != 0 ? 0 : i12, (i13 & 4) != 0 ? b0.c() : zVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r0)) {
            return false;
        }
        r0 r0Var = (r0) obj;
        return r0Var.f2131a == this.f2131a && r0Var.f2132b == this.f2132b && Intrinsics.b(r0Var.f2133c, this.f2133c);
    }

    @Override // androidx.compose.animation.core.g
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public <V extends o> f1<V> a(s0<T, V> s0Var) {
        return new f1<>(this.f2131a, this.f2132b, this.f2133c);
    }

    public int hashCode() {
        return (((this.f2131a * 31) + this.f2133c.hashCode()) * 31) + this.f2132b;
    }
}
