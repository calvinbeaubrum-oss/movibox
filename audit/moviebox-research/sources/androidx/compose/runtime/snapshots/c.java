package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class c extends b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f3654s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f3655t;

    public c(int i11, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1, Function1<Object, Unit> function2, b bVar) {
        super(i11, snapshotIdSet, function1, function2);
        this.f3654s = bVar;
        bVar.m(this);
    }

    @Override // androidx.compose.runtime.snapshots.b
    public k C() {
        Map<e0, ? extends e0> mapR;
        if (this.f3654s.D() || this.f3654s.e()) {
            return new k.a(this);
        }
        MutableScatterSet<c0> mutableScatterSetE = E();
        int iF = f();
        if (mutableScatterSetE != null) {
            b bVar = this.f3654s;
            mapR = SnapshotKt.R(bVar, this, bVar.g());
        } else {
            mapR = null;
        }
        synchronized (SnapshotKt.I()) {
            try {
                SnapshotKt.g0(this);
                if (mutableScatterSetE == null || mutableScatterSetE.c() == 0) {
                    b();
                } else {
                    k kVarI = I(this.f3654s.f(), mapR, this.f3654s.g());
                    if (!Intrinsics.b(kVarI, k.b.f3691a)) {
                        return kVarI;
                    }
                    MutableScatterSet<c0> mutableScatterSetE2 = this.f3654s.E();
                    if (mutableScatterSetE2 != null) {
                        mutableScatterSetE2.i(mutableScatterSetE);
                    } else {
                        this.f3654s.P(mutableScatterSetE);
                        P(null);
                    }
                }
                if (this.f3654s.f() < iF) {
                    this.f3654s.B();
                }
                b bVar2 = this.f3654s;
                bVar2.v(bVar2.g().r(iF).j(F()));
                this.f3654s.J(iF);
                this.f3654s.L(y());
                this.f3654s.K(F());
                this.f3654s.M(G());
                Unit unit = Unit.f68710a;
                O(true);
                T();
                return k.b.f3691a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void T() {
        if (this.f3655t) {
            return;
        }
        this.f3655t = true;
        this.f3654s.n(this);
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public void d() {
        if (e()) {
            return;
        }
        super.d();
        T();
    }
}
