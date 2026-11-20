package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.k0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
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
public final class BoxMeasurePolicy implements androidx.compose.ui.layout.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.ui.b f2384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2385b;

    public BoxMeasurePolicy(androidx.compose.ui.b bVar, boolean z11) {
        this.f2384a = bVar;
        this.f2385b = z11;
    }

    @Override // androidx.compose.ui.layout.u
    public androidx.compose.ui.layout.w c(final androidx.compose.ui.layout.y yVar, final List<? extends androidx.compose.ui.layout.t> list, long j11) {
        int iN;
        int iM;
        k0 k0VarL;
        if (list.isEmpty()) {
            return androidx.compose.ui.layout.x.b(yVar, q2.b.n(j11), q2.b.m(j11), null, new Function1<k0.a, Unit>() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(k0.a aVar) {
                    invoke2(aVar);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(k0.a aVar) {
                }
            }, 4, null);
        }
        long jD = this.f2385b ? j11 : q2.b.d(j11, 0, 0, 0, 0, 10, null);
        if (list.size() == 1) {
            final androidx.compose.ui.layout.t tVar = list.get(0);
            if (BoxKt.g(tVar)) {
                iN = q2.b.n(j11);
                iM = q2.b.m(j11);
                k0VarL = tVar.L(q2.b.f74225b.c(q2.b.n(j11), q2.b.m(j11)));
            } else {
                k0VarL = tVar.L(jD);
                iN = Math.max(q2.b.n(j11), k0VarL.s0());
                iM = Math.max(q2.b.m(j11), k0VarL.g0());
            }
            final int i11 = iN;
            final int i12 = iM;
            final k0 k0Var = k0VarL;
            return androidx.compose.ui.layout.x.b(yVar, i11, i12, null, new Function1<k0.a, Unit>() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$2
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
                    BoxKt.i(aVar, k0Var, tVar, yVar.getLayoutDirection(), i11, i12, this.f2384a);
                }
            }, 4, null);
        }
        final k0[] k0VarArr = new k0[list.size()];
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = q2.b.n(j11);
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = q2.b.m(j11);
        int size = list.size();
        boolean z11 = false;
        for (int i13 = 0; i13 < size; i13++) {
            androidx.compose.ui.layout.t tVar2 = list.get(i13);
            if (BoxKt.g(tVar2)) {
                z11 = true;
            } else {
                k0 k0VarL2 = tVar2.L(jD);
                k0VarArr[i13] = k0VarL2;
                intRef.element = Math.max(intRef.element, k0VarL2.s0());
                intRef2.element = Math.max(intRef2.element, k0VarL2.g0());
            }
        }
        if (z11) {
            int i14 = intRef.element;
            int i15 = i14 != Integer.MAX_VALUE ? i14 : 0;
            int i16 = intRef2.element;
            long jA = q2.c.a(i15, i14, i16 != Integer.MAX_VALUE ? i16 : 0, i16);
            int size2 = list.size();
            for (int i17 = 0; i17 < size2; i17++) {
                androidx.compose.ui.layout.t tVar3 = list.get(i17);
                if (BoxKt.g(tVar3)) {
                    k0VarArr[i17] = tVar3.L(jA);
                }
            }
        }
        return androidx.compose.ui.layout.x.b(yVar, intRef.element, intRef2.element, null, new Function1<k0.a, Unit>() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                List<androidx.compose.ui.layout.t> list2 = list;
                androidx.compose.ui.layout.y yVar2 = yVar;
                Ref.IntRef intRef3 = intRef;
                Ref.IntRef intRef4 = intRef2;
                BoxMeasurePolicy boxMeasurePolicy = this;
                int length = k0VarArr2.length;
                int i18 = 0;
                int i19 = 0;
                while (i18 < length) {
                    k0 k0Var2 = k0VarArr2[i18];
                    Intrinsics.e(k0Var2, "null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
                    BoxKt.i(aVar, k0Var2, list2.get(i19), yVar2.getLayoutDirection(), intRef3.element, intRef4.element, boxMeasurePolicy.f2384a);
                    i18++;
                    i19++;
                }
            }
        }, 4, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoxMeasurePolicy)) {
            return false;
        }
        BoxMeasurePolicy boxMeasurePolicy = (BoxMeasurePolicy) obj;
        return Intrinsics.b(this.f2384a, boxMeasurePolicy.f2384a) && this.f2385b == boxMeasurePolicy.f2385b;
    }

    public int hashCode() {
        return (this.f2384a.hashCode() * 31) + androidx.compose.foundation.e.a(this.f2385b);
    }

    public String toString() {
        return "BoxMeasurePolicy(alignment=" + this.f2384a + ", propagateMinConstraints=" + this.f2385b + ')';
    }
}
