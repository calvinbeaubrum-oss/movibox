package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
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
public final class g0 extends b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f3669s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f3670t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f3671u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Function1<Object, Unit> f3672v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Function1<Object, Unit> f3673w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f3674x;

    public g0(b bVar, Function1<Object, Unit> function1, Function1<Object, Unit> function2, boolean z11, boolean z12) {
        Function1<Object, Unit> function1K;
        Function1<Object, Unit> function1H;
        super(0, SnapshotIdSet.f3596f.a(), SnapshotKt.K(function1, (bVar == null || (function1H = bVar.h()) == null) ? ((GlobalSnapshot) SnapshotKt.f3611j.get()).h() : function1H, z11), SnapshotKt.M(function2, (bVar == null || (function1K = bVar.k()) == null) ? ((GlobalSnapshot) SnapshotKt.f3611j.get()).k() : function1K));
        this.f3669s = bVar;
        this.f3670t = z11;
        this.f3671u = z12;
        this.f3672v = super.h();
        this.f3673w = super.k();
        this.f3674x = androidx.compose.runtime.b.a();
    }

    @Override // androidx.compose.runtime.snapshots.b
    public k C() {
        return T().C();
    }

    @Override // androidx.compose.runtime.snapshots.b
    public MutableScatterSet<c0> E() {
        return T().E();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public Function1<Object, Unit> h() {
        return this.f3672v;
    }

    @Override // androidx.compose.runtime.snapshots.b
    public void P(MutableScatterSet<c0> mutableScatterSet) {
        u.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.b
    public b Q(Function1<Object, Unit> function1, Function1<Object, Unit> function2) {
        Function1<Object, Unit> function1L = SnapshotKt.L(function1, h(), false, 4, null);
        Function1<Object, Unit> function1M = SnapshotKt.M(function2, k());
        return !this.f3670t ? new g0(T().Q(null, function1M), function1L, function1M, false, true) : T().Q(function1L, function1M);
    }

    public final b T() {
        b bVar = this.f3669s;
        return bVar == null ? (b) SnapshotKt.f3611j.get() : bVar;
    }

    public final long U() {
        return this.f3674x;
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public Void m(j jVar) {
        u.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public Void n(j jVar) {
        u.b();
        throw new KotlinNothingValueException();
    }

    public void X(Function1<Object, Unit> function1) {
        this.f3672v = function1;
    }

    public void Y(Function1<Object, Unit> function1) {
        this.f3673w = function1;
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public void d() {
        b bVar;
        t(true);
        if (!this.f3671u || (bVar = this.f3669s) == null) {
            return;
        }
        bVar.d();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public int f() {
        return T().f();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public SnapshotIdSet g() {
        return T().g();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public boolean i() {
        return T().i();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public int j() {
        return T().j();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public Function1<Object, Unit> k() {
        return this.f3673w;
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public void o() {
        T().o();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public void p(c0 c0Var) {
        T().p(c0Var);
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void u(int i11) {
        u.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void v(SnapshotIdSet snapshotIdSet) {
        u.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public void w(int i11) {
        T().w(i11);
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public j x(Function1<Object, Unit> function1) {
        Function1<Object, Unit> function1L = SnapshotKt.L(function1, h(), false, 4, null);
        return !this.f3670t ? SnapshotKt.D(T().x(null), function1L, true) : T().x(function1L);
    }
}
