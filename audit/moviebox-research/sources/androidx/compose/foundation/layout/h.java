package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class h implements g, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q2.e f2498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BoxScopeInstance f2500c;

    public h(q2.e eVar, long j11) {
        this.f2498a = eVar;
        this.f2499b = j11;
        this.f2500c = BoxScopeInstance.f2386a;
    }

    public /* synthetic */ h(q2.e eVar, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(eVar, j11);
    }

    @Override // androidx.compose.foundation.layout.g
    public long a() {
        return this.f2499b;
    }

    @Override // androidx.compose.foundation.layout.f
    public androidx.compose.ui.f b(androidx.compose.ui.f fVar, androidx.compose.ui.b bVar) {
        return this.f2500c.b(fVar, bVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Intrinsics.b(this.f2498a, hVar.f2498a) && q2.b.f(this.f2499b, hVar.f2499b);
    }

    public int hashCode() {
        return (this.f2498a.hashCode() * 31) + q2.b.o(this.f2499b);
    }

    public String toString() {
        return "BoxWithConstraintsScopeImpl(density=" + this.f2498a + ", constraints=" + ((Object) q2.b.q(this.f2499b)) + ')';
    }
}
