package androidx.compose.ui.platform;

import java.util.List;
import kotlin.Metadata;

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
public final class f2 implements androidx.compose.ui.node.z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<f2> f5471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Float f5472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Float f5473d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.compose.ui.semantics.j f5474f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public androidx.compose.ui.semantics.j f5475g;

    public f2(int i11, List<f2> list, Float f11, Float f12, androidx.compose.ui.semantics.j jVar, androidx.compose.ui.semantics.j jVar2) {
        this.f5470a = i11;
        this.f5471b = list;
        this.f5472c = f11;
        this.f5473d = f12;
        this.f5474f = jVar;
        this.f5475g = jVar2;
    }

    public final androidx.compose.ui.semantics.j a() {
        return this.f5474f;
    }

    public final Float b() {
        return this.f5472c;
    }

    public final Float c() {
        return this.f5473d;
    }

    public final int d() {
        return this.f5470a;
    }

    public final androidx.compose.ui.semantics.j e() {
        return this.f5475g;
    }

    public final void f(androidx.compose.ui.semantics.j jVar) {
        this.f5474f = jVar;
    }

    public final void g(Float f11) {
        this.f5472c = f11;
    }

    public final void h(Float f11) {
        this.f5473d = f11;
    }

    public final void i(androidx.compose.ui.semantics.j jVar) {
        this.f5475g = jVar;
    }

    @Override // androidx.compose.ui.node.z0
    public boolean isValidOwnerScope() {
        return this.f5471b.contains(this);
    }
}
