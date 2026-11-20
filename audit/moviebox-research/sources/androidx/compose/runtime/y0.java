package androidx.compose.runtime;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

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
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w0<Object> f3749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f3751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j2 f3752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f3753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<? extends Pair<RecomposeScopeImpl, ? extends Object>> f3754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n1 f3755g;

    public y0(w0<Object> w0Var, Object obj, y yVar, j2 j2Var, c cVar, List<? extends Pair<RecomposeScopeImpl, ? extends Object>> list, n1 n1Var) {
        this.f3749a = w0Var;
        this.f3750b = obj;
        this.f3751c = yVar;
        this.f3752d = j2Var;
        this.f3753e = cVar;
        this.f3754f = list;
        this.f3755g = n1Var;
    }

    public final c a() {
        return this.f3753e;
    }

    public final y b() {
        return this.f3751c;
    }

    public final w0<Object> c() {
        return this.f3749a;
    }

    public final List<Pair<RecomposeScopeImpl, Object>> d() {
        return this.f3754f;
    }

    public final n1 e() {
        return this.f3755g;
    }

    public final Object f() {
        return this.f3750b;
    }

    public final j2 g() {
        return this.f3752d;
    }

    public final void h(List<? extends Pair<RecomposeScopeImpl, ? extends Object>> list) {
        this.f3754f = list;
    }
}
