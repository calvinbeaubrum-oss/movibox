package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
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
public class SnapshotMutableIntStateImpl extends androidx.compose.runtime.snapshots.d0 implements e1, androidx.compose.runtime.snapshots.r<Integer> {
    public static final int $stable = 0;
    private a next;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends androidx.compose.runtime.snapshots.e0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3343c;

        public a(int i11) {
            this.f3343c = i11;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public void c(androidx.compose.runtime.snapshots.e0 e0Var) {
            Intrinsics.e(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
            this.f3343c = ((a) e0Var).f3343c;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public androidx.compose.runtime.snapshots.e0 d() {
            return new a(this.f3343c);
        }

        public final int i() {
            return this.f3343c;
        }

        public final void j(int i11) {
            this.f3343c = i11;
        }
    }

    public SnapshotMutableIntStateImpl(int i11) {
        a aVar = new a(i11);
        if (androidx.compose.runtime.snapshots.j.f3684e.e()) {
            a aVar2 = new a(i11);
            aVar2.h(1);
            aVar.g(aVar2);
        }
        this.next = aVar;
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: merged with bridge method [inline-methods] */
    public Integer m45component1() {
        return Integer.valueOf(getIntValue());
    }

    public Function1<Integer, Unit> component2() {
        return new Function1<Integer, Unit>() { // from class: androidx.compose.runtime.SnapshotMutableIntStateImpl.component2.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(int i11) {
                SnapshotMutableIntStateImpl.this.setIntValue(i11);
            }
        };
    }

    @JvmName
    public final int getDebuggerDisplayValue() {
        return ((a) SnapshotKt.F(this.next)).i();
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public androidx.compose.runtime.snapshots.e0 getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.e1, androidx.compose.runtime.n0
    public int getIntValue() {
        return ((a) SnapshotKt.X(this.next, this)).i();
    }

    @Override // androidx.compose.runtime.snapshots.r
    public q2<Integer> getPolicy() {
        return r2.j();
    }

    public /* synthetic */ Integer getValue() {
        return d1.a(this);
    }

    public /* bridge */ /* synthetic */ Object getValue() {
        return getValue();
    }

    @Override // androidx.compose.runtime.snapshots.d0, androidx.compose.runtime.snapshots.c0
    public androidx.compose.runtime.snapshots.e0 mergeRecords(androidx.compose.runtime.snapshots.e0 e0Var, androidx.compose.runtime.snapshots.e0 e0Var2, androidx.compose.runtime.snapshots.e0 e0Var3) {
        Intrinsics.e(e0Var2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
        Intrinsics.e(e0Var3, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
        if (((a) e0Var2).i() == ((a) e0Var3).i()) {
            return e0Var2;
        }
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public void prependStateRecord(androidx.compose.runtime.snapshots.e0 e0Var) {
        Intrinsics.e(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
        this.next = (a) e0Var;
    }

    @Override // androidx.compose.runtime.e1
    public void setIntValue(int i11) {
        androidx.compose.runtime.snapshots.j jVarC;
        a aVar = (a) SnapshotKt.F(this.next);
        if (aVar.i() != i11) {
            a aVar2 = this.next;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                jVarC = androidx.compose.runtime.snapshots.j.f3684e.c();
                ((a) SnapshotKt.S(aVar2, this, jVarC, aVar)).j(i11);
                Unit unit = Unit.f68710a;
            }
            SnapshotKt.Q(jVarC, this);
        }
    }

    public /* synthetic */ void setValue(int i11) {
        d1.c(this, i11);
    }

    public /* bridge */ /* synthetic */ void setValue(Object obj) {
        setValue(((Number) obj).intValue());
    }

    public String toString() {
        return "MutableIntState(value=" + ((a) SnapshotKt.F(this.next)).i() + ")@" + hashCode();
    }
}
