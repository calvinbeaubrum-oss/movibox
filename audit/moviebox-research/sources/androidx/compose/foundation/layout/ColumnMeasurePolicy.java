package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.k0;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
public final class ColumnMeasurePolicy implements androidx.compose.ui.layout.u, x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b.k f2387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.compose.ui.b.InterfaceC0052b f2388b;

    public ColumnMeasurePolicy(b.k kVar, androidx.compose.ui.b.InterfaceC0052b interfaceC0052b) {
        this.f2387a = kVar;
        this.f2388b = interfaceC0052b;
    }

    @Override // androidx.compose.foundation.layout.x
    public long a(int i11, int i12, int i13, int i14, boolean z11) {
        return i.b(z11, i11, i12, i13, i14);
    }

    @Override // androidx.compose.foundation.layout.x
    public void b(int i11, int[] iArr, int[] iArr2, androidx.compose.ui.layout.y yVar) {
        this.f2387a.b(yVar, i11, iArr, iArr2);
    }

    @Override // androidx.compose.ui.layout.u
    public androidx.compose.ui.layout.w c(androidx.compose.ui.layout.y yVar, List<? extends androidx.compose.ui.layout.t> list, long j11) {
        return y.a(this, q2.b.m(j11), q2.b.n(j11), q2.b.k(j11), q2.b.l(j11), yVar.k0(this.f2387a.a()), yVar, list, new k0[list.size()], 0, list.size(), (3072 & 1024) != 0 ? null : null, (3072 & 2048) != 0 ? 0 : 0);
    }

    @Override // androidx.compose.foundation.layout.x
    public androidx.compose.ui.layout.w d(final k0[] k0VarArr, final androidx.compose.ui.layout.y yVar, final int i11, final int[] iArr, int i12, final int i13, int[] iArr2, int i14, int i15, int i16) {
        return androidx.compose.ui.layout.x.b(yVar, i13, i12, null, new Function1<k0.a, Unit>() { // from class: androidx.compose.foundation.layout.ColumnMeasurePolicy$placeHelper$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(k0.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(k0.a aVar) {
                k0[] k0VarArr2 = k0VarArr;
                ColumnMeasurePolicy columnMeasurePolicy = this;
                int i17 = i13;
                int i18 = i11;
                androidx.compose.ui.layout.y yVar2 = yVar;
                int[] iArr3 = iArr;
                int length = k0VarArr2.length;
                int i19 = 0;
                int i21 = 0;
                while (i19 < length) {
                    k0 k0Var = k0VarArr2[i19];
                    Intrinsics.d(k0Var);
                    k0.a.h(aVar, k0Var, columnMeasurePolicy.h(k0Var, v.d(k0Var), i17, i18, yVar2.getLayoutDirection()), iArr3[i21], 0.0f, 4, null);
                    i19++;
                    i21++;
                }
            }
        }, 4, null);
    }

    @Override // androidx.compose.foundation.layout.x
    public int e(k0 k0Var) {
        return k0Var.g0();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColumnMeasurePolicy)) {
            return false;
        }
        ColumnMeasurePolicy columnMeasurePolicy = (ColumnMeasurePolicy) obj;
        return Intrinsics.b(this.f2387a, columnMeasurePolicy.f2387a) && Intrinsics.b(this.f2388b, columnMeasurePolicy.f2388b);
    }

    @Override // androidx.compose.foundation.layout.x
    public int f(k0 k0Var) {
        return k0Var.s0();
    }

    public final int h(k0 k0Var, z zVar, int i11, int i12, LayoutDirection layoutDirection) {
        m mVarA = zVar != null ? zVar.a() : null;
        return mVarA != null ? mVarA.a(i11 - k0Var.s0(), layoutDirection, k0Var, i12) : this.f2388b.a(0, i11 - k0Var.s0(), layoutDirection);
    }

    public int hashCode() {
        return (this.f2387a.hashCode() * 31) + this.f2388b.hashCode();
    }

    public String toString() {
        return "ColumnMeasurePolicy(verticalArrangement=" + this.f2387a + ", horizontalAlignment=" + this.f2388b + ')';
    }
}
