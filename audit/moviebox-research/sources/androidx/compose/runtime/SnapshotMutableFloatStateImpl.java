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
public class SnapshotMutableFloatStateImpl extends androidx.compose.runtime.snapshots.d0 implements c1, androidx.compose.runtime.snapshots.r<Float> {
    public static final int $stable = 0;
    private a next;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends androidx.compose.runtime.snapshots.e0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f3342c;

        public a(float f11) {
            this.f3342c = f11;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public void c(androidx.compose.runtime.snapshots.e0 e0Var) {
            Intrinsics.e(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
            this.f3342c = ((a) e0Var).f3342c;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public androidx.compose.runtime.snapshots.e0 d() {
            return new a(this.f3342c);
        }

        public final float i() {
            return this.f3342c;
        }

        public final void j(float f11) {
            this.f3342c = f11;
        }
    }

    public SnapshotMutableFloatStateImpl(float f11) {
        a aVar = new a(f11);
        if (androidx.compose.runtime.snapshots.j.f3684e.e()) {
            a aVar2 = new a(f11);
            aVar2.h(1);
            aVar.g(aVar2);
        }
        this.next = aVar;
    }

    /* JADX INFO: renamed from: component1, reason: merged with bridge method [inline-methods] */
    public Float m44component1() {
        return Float.valueOf(getFloatValue());
    }

    public Function1<Float, Unit> component2() {
        return new Function1<Float, Unit>() { // from class: androidx.compose.runtime.SnapshotMutableFloatStateImpl.component2.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f11) {
                invoke(f11.floatValue());
                return Unit.f68710a;
            }

            public final void invoke(float f11) {
                SnapshotMutableFloatStateImpl.this.setFloatValue(f11);
            }
        };
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public androidx.compose.runtime.snapshots.e0 getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.c1, androidx.compose.runtime.h0
    public float getFloatValue() {
        return ((a) SnapshotKt.X(this.next, this)).i();
    }

    @Override // androidx.compose.runtime.snapshots.r
    public q2<Float> getPolicy() {
        return r2.j();
    }

    public /* synthetic */ Float getValue() {
        return b1.a(this);
    }

    public /* bridge */ /* synthetic */ Object getValue() {
        return getValue();
    }

    @Override // androidx.compose.runtime.snapshots.d0, androidx.compose.runtime.snapshots.c0
    public androidx.compose.runtime.snapshots.e0 mergeRecords(androidx.compose.runtime.snapshots.e0 e0Var, androidx.compose.runtime.snapshots.e0 e0Var2, androidx.compose.runtime.snapshots.e0 e0Var3) {
        Intrinsics.e(e0Var2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        Intrinsics.e(e0Var3, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        float fI = ((a) e0Var2).i();
        float fI2 = ((a) e0Var3).i();
        if (Build.VERSION.SDK_INT >= 23) {
            if (fI == fI2) {
                return e0Var2;
            }
        } else if (!androidx.compose.runtime.internal.c.b(fI) && !androidx.compose.runtime.internal.c.b(fI2) && fI == fI2) {
            return e0Var2;
        }
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public void prependStateRecord(androidx.compose.runtime.snapshots.e0 e0Var) {
        Intrinsics.e(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        this.next = (a) e0Var;
    }

    @Override // androidx.compose.runtime.c1
    public void setFloatValue(float f11) {
        androidx.compose.runtime.snapshots.j jVarC;
        a aVar = (a) SnapshotKt.F(this.next);
        float fI = aVar.i();
        if (Build.VERSION.SDK_INT >= 23) {
            if (fI == f11) {
                return;
            }
        } else if (!androidx.compose.runtime.internal.c.b(fI) && !androidx.compose.runtime.internal.c.b(f11) && fI == f11) {
            return;
        }
        a aVar2 = this.next;
        SnapshotKt.J();
        synchronized (SnapshotKt.I()) {
            jVarC = androidx.compose.runtime.snapshots.j.f3684e.c();
            ((a) SnapshotKt.S(aVar2, this, jVarC, aVar)).j(f11);
            Unit unit = Unit.f68710a;
        }
        SnapshotKt.Q(jVarC, this);
    }

    public /* synthetic */ void setValue(float f11) {
        b1.c(this, f11);
    }

    public /* bridge */ /* synthetic */ void setValue(Object obj) {
        setValue(((Number) obj).floatValue());
    }

    public String toString() {
        return "MutableFloatState(value=" + ((a) SnapshotKt.F(this.next)).i() + ")@" + hashCode();
    }
}
