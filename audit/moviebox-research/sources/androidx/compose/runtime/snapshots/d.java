package androidx.compose.runtime.snapshots;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
public final class d extends j {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<Object, Unit> f3656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j f3657h;

    public d(int i11, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1, j jVar) {
        super(i11, snapshotIdSet, null);
        this.f3656g = function1;
        this.f3657h = jVar;
        jVar.m(this);
    }

    @Override // androidx.compose.runtime.snapshots.j
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public Function1<Object, Unit> h() {
        return this.f3656g;
    }

    @Override // androidx.compose.runtime.snapshots.j
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public Void m(j jVar) {
        u.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.j
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public Void n(j jVar) {
        u.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.j
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public Void p(c0 c0Var) {
        SnapshotKt.Z();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.j
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public d x(Function1<Object, Unit> function1) {
        return new d(f(), g(), SnapshotKt.L(function1, h(), false, 4, null), this.f3657h);
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void d() {
        if (e()) {
            return;
        }
        if (f() != this.f3657h.f()) {
            b();
        }
        this.f3657h.n(this);
        super.d();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public boolean i() {
        return true;
    }

    @Override // androidx.compose.runtime.snapshots.j
    public Function1<Object, Unit> k() {
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void o() {
    }
}
