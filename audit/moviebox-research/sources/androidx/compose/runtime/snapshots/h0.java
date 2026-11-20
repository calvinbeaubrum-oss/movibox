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
public final class h0 extends j {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f3676g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f3677h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f3678i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1<Object, Unit> f3679j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<Object, Unit> f3680k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f3681l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final j f3682m;

    public h0(j jVar, Function1<Object, Unit> function1, boolean z11, boolean z12) {
        Function1<Object, Unit> function1H;
        super(0, SnapshotIdSet.f3596f.a(), null);
        this.f3676g = jVar;
        this.f3677h = z11;
        this.f3678i = z12;
        this.f3679j = SnapshotKt.K(function1, (jVar == null || (function1H = jVar.h()) == null) ? ((GlobalSnapshot) SnapshotKt.f3611j.get()).h() : function1H, z11);
        this.f3681l = androidx.compose.runtime.b.a();
        this.f3682m = this;
    }

    public final j A() {
        j jVar = this.f3676g;
        return jVar == null ? (j) SnapshotKt.f3611j.get() : jVar;
    }

    @Override // androidx.compose.runtime.snapshots.j
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public Function1<Object, Unit> h() {
        return this.f3679j;
    }

    public final long C() {
        return this.f3681l;
    }

    @Override // androidx.compose.runtime.snapshots.j
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public Void m(j jVar) {
        u.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.j
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public Void n(j jVar) {
        u.b();
        throw new KotlinNothingValueException();
    }

    public void F(Function1<Object, Unit> function1) {
        this.f3679j = function1;
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void d() {
        j jVar;
        t(true);
        if (!this.f3678i || (jVar = this.f3676g) == null) {
            return;
        }
        jVar.d();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public int f() {
        return A().f();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public SnapshotIdSet g() {
        return A().g();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public boolean i() {
        return A().i();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public Function1<Object, Unit> k() {
        return this.f3680k;
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void o() {
        A().o();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void p(c0 c0Var) {
        A().p(c0Var);
    }

    @Override // androidx.compose.runtime.snapshots.j
    public j x(Function1<Object, Unit> function1) {
        Function1<Object, Unit> function1L = SnapshotKt.L(function1, h(), false, 4, null);
        return !this.f3677h ? SnapshotKt.D(A().x(null), function1L, true) : A().x(function1L);
    }
}
