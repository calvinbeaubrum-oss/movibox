package androidx.compose.runtime;

import android.os.Build;
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
public class SnapshotMutableDoubleStateImpl extends androidx.compose.runtime.snapshots.d0 implements a1, androidx.compose.runtime.snapshots.r<Double> {
    public static final int $stable = 0;
    private a next;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends androidx.compose.runtime.snapshots.e0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public double f3341c;

        public a(double d11) {
            this.f3341c = d11;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public void c(androidx.compose.runtime.snapshots.e0 e0Var) {
            Intrinsics.e(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord");
            this.f3341c = ((a) e0Var).f3341c;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public androidx.compose.runtime.snapshots.e0 d() {
            return new a(this.f3341c);
        }

        public final double i() {
            return this.f3341c;
        }

        public final void j(double d11) {
            this.f3341c = d11;
        }
    }

    public SnapshotMutableDoubleStateImpl(double d11) {
        a aVar = new a(d11);
        if (androidx.compose.runtime.snapshots.j.f3684e.e()) {
            a aVar2 = new a(d11);
            aVar2.h(1);
            aVar.g(aVar2);
        }
        this.next = aVar;
    }

    /* JADX INFO: renamed from: component1, reason: merged with bridge method [inline-methods] */
    public Double m43component1() {
        return Double.valueOf(getDoubleValue());
    }

    public Function1<Double, Unit> component2() {
        return new Function1<Double, Unit>() { // from class: androidx.compose.runtime.SnapshotMutableDoubleStateImpl.component2.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Double d11) {
                invoke(d11.doubleValue());
                return Unit.f68710a;
            }

            public final void invoke(double d11) {
                SnapshotMutableDoubleStateImpl.this.setDoubleValue(d11);
            }
        };
    }

    @Override // androidx.compose.runtime.a1
    public double getDoubleValue() {
        return ((a) SnapshotKt.X(this.next, this)).i();
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public androidx.compose.runtime.snapshots.e0 getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.snapshots.r
    public q2<Double> getPolicy() {
        return r2.j();
    }

    public /* synthetic */ Double getValue() {
        return z0.a(this);
    }

    public /* bridge */ /* synthetic */ Object getValue() {
        return getValue();
    }

    @Override // androidx.compose.runtime.snapshots.d0, androidx.compose.runtime.snapshots.c0
    public androidx.compose.runtime.snapshots.e0 mergeRecords(androidx.compose.runtime.snapshots.e0 e0Var, androidx.compose.runtime.snapshots.e0 e0Var2, androidx.compose.runtime.snapshots.e0 e0Var3) {
        Intrinsics.e(e0Var2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord");
        Intrinsics.e(e0Var3, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord");
        double dI = ((a) e0Var2).i();
        double dI2 = ((a) e0Var3).i();
        if (Build.VERSION.SDK_INT >= 23) {
            if (dI == dI2) {
                return e0Var2;
            }
        } else if (!androidx.compose.runtime.internal.c.a(dI) && !androidx.compose.runtime.internal.c.a(dI2) && dI == dI2) {
            return e0Var2;
        }
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public void prependStateRecord(androidx.compose.runtime.snapshots.e0 e0Var) {
        Intrinsics.e(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord");
        this.next = (a) e0Var;
    }

    @Override // androidx.compose.runtime.a1
    public void setDoubleValue(double d11) {
        androidx.compose.runtime.snapshots.j jVarC;
        a aVar = (a) SnapshotKt.F(this.next);
        double dI = aVar.i();
        if (Build.VERSION.SDK_INT >= 23) {
            if (dI == d11) {
                return;
            }
        } else if (!androidx.compose.runtime.internal.c.a(dI) && !androidx.compose.runtime.internal.c.a(d11) && dI == d11) {
            return;
        }
        a aVar2 = this.next;
        SnapshotKt.J();
        synchronized (SnapshotKt.I()) {
            jVarC = androidx.compose.runtime.snapshots.j.f3684e.c();
            ((a) SnapshotKt.S(aVar2, this, jVarC, aVar)).j(d11);
            Unit unit = Unit.f68710a;
        }
        SnapshotKt.Q(jVarC, this);
    }

    public /* synthetic */ void setValue(double d11) {
        z0.c(this, d11);
    }

    public /* bridge */ /* synthetic */ void setValue(Object obj) {
        setValue(((Number) obj).doubleValue());
    }

    public String toString() {
        return "MutableDoubleState(value=" + ((a) SnapshotKt.F(this.next)).i() + ")@" + hashCode();
    }
}
