package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.k0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class FillNode extends androidx.compose.ui.f.c implements androidx.compose.ui.node.x {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Direction f2393o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f2394p;

    public FillNode(Direction direction, float f11) {
        this.f2393o = direction;
        this.f2394p = f11;
    }

    @Override // androidx.compose.ui.node.x
    public androidx.compose.ui.layout.w C(androidx.compose.ui.layout.y yVar, androidx.compose.ui.layout.t tVar, long j11) {
        int iN;
        int iL;
        int iK;
        int iK2;
        if (!q2.b.h(j11) || this.f2393o == Direction.Vertical) {
            iN = q2.b.n(j11);
            iL = q2.b.l(j11);
        } else {
            iN = kotlin.ranges.a.k(Math.round(q2.b.l(j11) * this.f2394p), q2.b.n(j11), q2.b.l(j11));
            iL = iN;
        }
        if (!q2.b.g(j11) || this.f2393o == Direction.Horizontal) {
            int iM = q2.b.m(j11);
            iK = q2.b.k(j11);
            iK2 = iM;
        } else {
            iK2 = kotlin.ranges.a.k(Math.round(q2.b.k(j11) * this.f2394p), q2.b.m(j11), q2.b.k(j11));
            iK = iK2;
        }
        final k0 k0VarL = tVar.L(q2.c.a(iN, iL, iK2, iK));
        return androidx.compose.ui.layout.x.b(yVar, k0VarL.s0(), k0VarL.g0(), null, new Function1<k0.a, Unit>() { // from class: androidx.compose.foundation.layout.FillNode$measure$1
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
                k0.a.l(aVar, k0VarL, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    public final void H1(Direction direction) {
        this.f2393o = direction;
    }

    public final void I1(float f11) {
        this.f2394p = f11;
    }
}
