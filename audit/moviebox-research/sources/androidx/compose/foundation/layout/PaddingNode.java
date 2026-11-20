package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.k0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class PaddingNode extends androidx.compose.ui.f.c implements androidx.compose.ui.node.x {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f2407o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f2408p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f2409q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f2410r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f2411s;

    public PaddingNode(float f11, float f12, float f13, float f14, boolean z11) {
        this.f2407o = f11;
        this.f2408p = f12;
        this.f2409q = f13;
        this.f2410r = f14;
        this.f2411s = z11;
    }

    public /* synthetic */ PaddingNode(float f11, float f12, float f13, float f14, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, z11);
    }

    @Override // androidx.compose.ui.node.x
    public androidx.compose.ui.layout.w C(final androidx.compose.ui.layout.y yVar, androidx.compose.ui.layout.t tVar, long j11) {
        int iK0 = yVar.k0(this.f2407o) + yVar.k0(this.f2409q);
        int iK1 = yVar.k0(this.f2408p) + yVar.k0(this.f2410r);
        final k0 k0VarL = tVar.L(q2.c.n(j11, -iK0, -iK1));
        return androidx.compose.ui.layout.x.b(yVar, q2.c.i(j11, k0VarL.s0() + iK0), q2.c.h(j11, k0VarL.g0() + iK1), null, new Function1<k0.a, Unit>() { // from class: androidx.compose.foundation.layout.PaddingNode$measure$1
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
                if (this.this$0.H1()) {
                    k0.a.l(aVar, k0VarL, yVar.k0(this.this$0.I1()), yVar.k0(this.this$0.J1()), 0.0f, 4, null);
                } else {
                    k0.a.h(aVar, k0VarL, yVar.k0(this.this$0.I1()), yVar.k0(this.this$0.J1()), 0.0f, 4, null);
                }
            }
        }, 4, null);
    }

    public final boolean H1() {
        return this.f2411s;
    }

    public final float I1() {
        return this.f2407o;
    }

    public final float J1() {
        return this.f2408p;
    }

    public final void K1(float f11) {
        this.f2410r = f11;
    }

    public final void L1(float f11) {
        this.f2409q = f11;
    }

    public final void M1(boolean z11) {
        this.f2411s = z11;
    }

    public final void N1(float f11) {
        this.f2407o = f11;
    }

    public final void O1(float f11) {
        this.f2408p = f11;
    }
}
