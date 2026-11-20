package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public class SnapshotMutableLongStateImpl extends androidx.compose.runtime.snapshots.d0 implements g1, androidx.compose.runtime.snapshots.r<Long> {
    public static final int $stable = 0;
    private a next;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends androidx.compose.runtime.snapshots.e0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f3344c;

        public a(long j11) {
            this.f3344c = j11;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public void c(androidx.compose.runtime.snapshots.e0 e0Var) {
            Intrinsics.e(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
            this.f3344c = ((a) e0Var).f3344c;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public androidx.compose.runtime.snapshots.e0 d() {
            return new a(this.f3344c);
        }

        public final long i() {
            return this.f3344c;
        }

        public final void j(long j11) {
            this.f3344c = j11;
        }
    }

    public SnapshotMutableLongStateImpl(long j11) {
        a aVar = new a(j11);
        if (androidx.compose.runtime.snapshots.j.f3684e.e()) {
            a aVar2 = new a(j11);
            aVar2.h(1);
            aVar.g(aVar2);
        }
        this.next = aVar;
    }

    /* JADX INFO: renamed from: component1, reason: merged with bridge method [inline-methods] */
    public Long m46component1() {
        return Long.valueOf(getLongValue());
    }

    public Function1<Long, Unit> component2() {
        return new Function1<Long, Unit>() { // from class: androidx.compose.runtime.SnapshotMutableLongStateImpl.component2.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l11) {
                invoke(l11.longValue());
                return Unit.f68710a;
            }

            public final void invoke(long j11) {
                SnapshotMutableLongStateImpl.this.setLongValue(j11);
            }
        };
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public androidx.compose.runtime.snapshots.e0 getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.g1
    public long getLongValue() {
        return ((a) SnapshotKt.X(this.next, this)).i();
    }

    @Override // androidx.compose.runtime.snapshots.r
    public q2<Long> getPolicy() {
        return r2.j();
    }

    public /* synthetic */ Long getValue() {
        return f1.a(this);
    }

    public /* bridge */ /* synthetic */ Object getValue() {
        return getValue();
    }

    @Override // androidx.compose.runtime.snapshots.d0, androidx.compose.runtime.snapshots.c0
    public androidx.compose.runtime.snapshots.e0 mergeRecords(androidx.compose.runtime.snapshots.e0 e0Var, androidx.compose.runtime.snapshots.e0 e0Var2, androidx.compose.runtime.snapshots.e0 e0Var3) {
        Intrinsics.e(e0Var2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
        Intrinsics.e(e0Var3, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
        if (((a) e0Var2).i() == ((a) e0Var3).i()) {
            return e0Var2;
        }
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public void prependStateRecord(androidx.compose.runtime.snapshots.e0 e0Var) {
        Intrinsics.e(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
        this.next = (a) e0Var;
    }

    @Override // androidx.compose.runtime.g1
    public void setLongValue(long j11) {
        androidx.compose.runtime.snapshots.j jVarC;
        a aVar = (a) SnapshotKt.F(this.next);
        if (aVar.i() != j11) {
            a aVar2 = this.next;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                jVarC = androidx.compose.runtime.snapshots.j.f3684e.c();
                ((a) SnapshotKt.S(aVar2, this, jVarC, aVar)).j(j11);
                Unit unit = Unit.f68710a;
            }
            SnapshotKt.Q(jVarC, this);
        }
    }

    public /* synthetic */ void setValue(long j11) {
        f1.c(this, j11);
    }

    public /* bridge */ /* synthetic */ void setValue(Object obj) {
        setValue(((Number) obj).longValue());
    }

    public String toString() {
        return "MutableLongState(value=" + ((a) SnapshotKt.F(this.next)).i() + ")@" + hashCode();
    }
}
