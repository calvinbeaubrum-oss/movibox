package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.k0;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
public final class WrapContentNode extends androidx.compose.ui.f.c implements androidx.compose.ui.node.x {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Direction f2470o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2471p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function2<? super q2.t, ? super LayoutDirection, q2.p> f2472q;

    public WrapContentNode(Direction direction, boolean z11, Function2<? super q2.t, ? super LayoutDirection, q2.p> function2) {
        this.f2470o = direction;
        this.f2471p = z11;
        this.f2472q = function2;
    }

    @Override // androidx.compose.ui.node.x
    public androidx.compose.ui.layout.w C(final androidx.compose.ui.layout.y yVar, androidx.compose.ui.layout.t tVar, long j11) {
        Direction direction = this.f2470o;
        Direction direction2 = Direction.Vertical;
        int iN = direction != direction2 ? 0 : q2.b.n(j11);
        Direction direction3 = this.f2470o;
        Direction direction4 = Direction.Horizontal;
        int iM = direction3 == direction4 ? q2.b.m(j11) : 0;
        Direction direction5 = this.f2470o;
        int iK = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int iL = (direction5 == direction2 || !this.f2471p) ? q2.b.l(j11) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (this.f2470o == direction4 || !this.f2471p) {
            iK = q2.b.k(j11);
        }
        final k0 k0VarL = tVar.L(q2.c.a(iN, iL, iM, iK));
        final int iK2 = kotlin.ranges.a.k(k0VarL.s0(), q2.b.n(j11), q2.b.l(j11));
        final int iK3 = kotlin.ranges.a.k(k0VarL.g0(), q2.b.m(j11), q2.b.k(j11));
        return androidx.compose.ui.layout.x.b(yVar, iK2, iK3, null, new Function1<k0.a, Unit>() { // from class: androidx.compose.foundation.layout.WrapContentNode$measure$1
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
                k0.a.j(aVar, k0VarL, this.this$0.H1().invoke(q2.t.b(q2.u.a(iK2 - k0VarL.s0(), iK3 - k0VarL.g0())), yVar.getLayoutDirection()).n(), 0.0f, 2, null);
            }
        }, 4, null);
    }

    public final Function2<q2.t, LayoutDirection, q2.p> H1() {
        return this.f2472q;
    }

    public final void I1(Function2<? super q2.t, ? super LayoutDirection, q2.p> function2) {
        this.f2472q = function2;
    }

    public final void J1(Direction direction) {
        this.f2470o = direction;
    }

    public final void K1(boolean z11) {
        this.f2471p = z11;
    }
}
