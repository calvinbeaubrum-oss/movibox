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
public class SnapshotMutableStateImpl<T> extends androidx.compose.runtime.snapshots.d0 implements androidx.compose.runtime.snapshots.r<T> {
    public static final int $stable = 0;
    private a<T> next;
    private final q2<T> policy;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T> extends androidx.compose.runtime.snapshots.e0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public T f3345c;

        public a(T t11) {
            this.f3345c = t11;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public void c(androidx.compose.runtime.snapshots.e0 e0Var) {
            Intrinsics.e(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord>");
            this.f3345c = ((a) e0Var).f3345c;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public androidx.compose.runtime.snapshots.e0 d() {
            return new a(this.f3345c);
        }

        public final T i() {
            return this.f3345c;
        }

        public final void j(T t11) {
            this.f3345c = t11;
        }
    }

    public SnapshotMutableStateImpl(T t11, q2<T> q2Var) {
        this.policy = q2Var;
        a<T> aVar = new a<>(t11);
        if (androidx.compose.runtime.snapshots.j.f3684e.e()) {
            a aVar2 = new a(t11);
            aVar2.h(1);
            aVar.g(aVar2);
        }
        this.next = aVar;
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    public T component1() {
        return getValue();
    }

    public Function1<T, Unit> component2() {
        return new Function1<T, Unit>(this) { // from class: androidx.compose.runtime.SnapshotMutableStateImpl.component2.1
            final /* synthetic */ SnapshotMutableStateImpl<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(T t11) {
                this.this$0.setValue(t11);
            }
        };
    }

    @JvmName
    public final T getDebuggerDisplayValue() {
        return (T) ((a) SnapshotKt.F(this.next)).i();
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public androidx.compose.runtime.snapshots.e0 getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.snapshots.r
    public q2<T> getPolicy() {
        return this.policy;
    }

    @Override // androidx.compose.runtime.i1, androidx.compose.runtime.a3
    public T getValue() {
        return (T) ((a) SnapshotKt.X(this.next, this)).i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.snapshots.d0, androidx.compose.runtime.snapshots.c0
    public androidx.compose.runtime.snapshots.e0 mergeRecords(androidx.compose.runtime.snapshots.e0 e0Var, androidx.compose.runtime.snapshots.e0 e0Var2, androidx.compose.runtime.snapshots.e0 e0Var3) {
        Intrinsics.e(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        a aVar = (a) e0Var;
        Intrinsics.e(e0Var2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        a aVar2 = (a) e0Var2;
        Intrinsics.e(e0Var3, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        a aVar3 = (a) e0Var3;
        if (getPolicy().b(aVar2.i(), aVar3.i())) {
            return e0Var2;
        }
        Object objA = getPolicy().a(aVar.i(), aVar2.i(), aVar3.i());
        if (objA == null) {
            return null;
        }
        androidx.compose.runtime.snapshots.e0 e0VarD = aVar3.d();
        Intrinsics.e(e0VarD, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl.mergeRecords$lambda$4>");
        ((a) e0VarD).j(objA);
        return e0VarD;
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public void prependStateRecord(androidx.compose.runtime.snapshots.e0 e0Var) {
        Intrinsics.e(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        this.next = (a) e0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.i1
    public void setValue(T t11) {
        androidx.compose.runtime.snapshots.j jVarC;
        a aVar = (a) SnapshotKt.F(this.next);
        if (getPolicy().b(aVar.i(), t11)) {
            return;
        }
        a<T> aVar2 = this.next;
        SnapshotKt.J();
        synchronized (SnapshotKt.I()) {
            jVarC = androidx.compose.runtime.snapshots.j.f3684e.c();
            ((a) SnapshotKt.S(aVar2, this, jVarC, aVar)).j(t11);
            Unit unit = Unit.f68710a;
        }
        SnapshotKt.Q(jVarC, this);
    }

    public String toString() {
        return "MutableState(value=" + ((a) SnapshotKt.F(this.next)).i() + ")@" + hashCode();
    }
}
