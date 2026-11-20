package androidx.compose.foundation.lazy;

import androidx.compose.ui.layout.k0;
import com.google.android.gms.common.api.Api;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public abstract class o implements androidx.compose.foundation.lazy.layout.t<n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f2799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.compose.foundation.lazy.layout.q f2800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f2801c;

    public o(long j11, boolean z11, k kVar, androidx.compose.foundation.lazy.layout.q qVar) {
        this.f2799a = kVar;
        this.f2800b = qVar;
        this.f2801c = q2.c.b(0, z11 ? q2.b.l(j11) : Api.BaseClientBuilder.API_PRIORITY_OTHER, 0, !z11 ? q2.b.k(j11) : Api.BaseClientBuilder.API_PRIORITY_OTHER, 5, null);
    }

    public /* synthetic */ o(long j11, boolean z11, k kVar, androidx.compose.foundation.lazy.layout.q qVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, z11, kVar, qVar);
    }

    public static /* synthetic */ n e(o oVar, int i11, long j11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAndMeasure-0kLqBqw");
        }
        if ((i12 & 2) != 0) {
            j11 = oVar.f2801c;
        }
        return oVar.d(i11, j11);
    }

    public abstract n b(int i11, Object obj, Object obj2, List<? extends k0> list, long j11);

    @Override // androidx.compose.foundation.lazy.layout.t
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n a(int i11, int i12, int i13, long j11) {
        return d(i11, j11);
    }

    public final n d(int i11, long j11) {
        return b(i11, this.f2799a.b(i11), this.f2799a.c(i11), this.f2800b.Z(i11, j11), j11);
    }

    public final long f() {
        return this.f2801c;
    }

    public final androidx.compose.foundation.lazy.layout.p g() {
        return this.f2799a.e();
    }
}
