package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.k0;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class SizeNode extends androidx.compose.ui.f.c implements androidx.compose.ui.node.x {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f2429o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f2430p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f2431q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f2432r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f2433s;

    public SizeNode(float f11, float f12, float f13, float f14, boolean z11) {
        this.f2429o = f11;
        this.f2430p = f12;
        this.f2431q = f13;
        this.f2432r = f14;
        this.f2433s = z11;
    }

    public /* synthetic */ SizeNode(float f11, float f12, float f13, float f14, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, z11);
    }

    @Override // androidx.compose.ui.node.x
    public androidx.compose.ui.layout.w C(androidx.compose.ui.layout.y yVar, androidx.compose.ui.layout.t tVar, long j11) {
        long jA;
        long jH1 = H1(yVar);
        if (this.f2433s) {
            jA = q2.c.g(j11, jH1);
        } else {
            float f11 = this.f2429o;
            q2.i.a aVar = q2.i.f74232b;
            jA = q2.c.a(!q2.i.j(f11, aVar.b()) ? q2.b.n(jH1) : kotlin.ranges.a.g(q2.b.n(j11), q2.b.l(jH1)), !q2.i.j(this.f2431q, aVar.b()) ? q2.b.l(jH1) : kotlin.ranges.a.d(q2.b.l(j11), q2.b.n(jH1)), !q2.i.j(this.f2430p, aVar.b()) ? q2.b.m(jH1) : kotlin.ranges.a.g(q2.b.m(j11), q2.b.k(jH1)), !q2.i.j(this.f2432r, aVar.b()) ? q2.b.k(jH1) : kotlin.ranges.a.d(q2.b.k(j11), q2.b.m(jH1)));
        }
        final k0 k0VarL = tVar.L(jA);
        return androidx.compose.ui.layout.x.b(yVar, k0VarL.s0(), k0VarL.g0(), null, new Function1<k0.a, Unit>() { // from class: androidx.compose.foundation.layout.SizeNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(k0.a aVar2) {
                invoke2(aVar2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(k0.a aVar2) {
                k0.a.l(aVar2, k0VarL, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    public final long H1(q2.e eVar) {
        int iD;
        int iD2;
        float f11 = this.f2431q;
        q2.i.a aVar = q2.i.f74232b;
        int i11 = 0;
        int iD3 = !q2.i.j(f11, aVar.b()) ? kotlin.ranges.a.d(eVar.k0(this.f2431q), 0) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int iD4 = !q2.i.j(this.f2432r, aVar.b()) ? kotlin.ranges.a.d(eVar.k0(this.f2432r), 0) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (q2.i.j(this.f2429o, aVar.b()) || (iD = kotlin.ranges.a.d(kotlin.ranges.a.g(eVar.k0(this.f2429o), iD3), 0)) == Integer.MAX_VALUE) {
            iD = 0;
        }
        if (!q2.i.j(this.f2430p, aVar.b()) && (iD2 = kotlin.ranges.a.d(kotlin.ranges.a.g(eVar.k0(this.f2430p), iD4), 0)) != Integer.MAX_VALUE) {
            i11 = iD2;
        }
        return q2.c.a(iD, iD3, i11, iD4);
    }

    public final void I1(boolean z11) {
        this.f2433s = z11;
    }

    public final void J1(float f11) {
        this.f2432r = f11;
    }

    public final void K1(float f11) {
        this.f2431q = f11;
    }

    public final void L1(float f11) {
        this.f2430p = f11;
    }

    public final void M1(float f11) {
        this.f2429o = f11;
    }
}
