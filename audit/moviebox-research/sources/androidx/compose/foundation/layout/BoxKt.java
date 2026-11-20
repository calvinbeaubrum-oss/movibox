package androidx.compose.foundation.layout;

import androidx.compose.runtime.f3;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.v1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.layout.k0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class BoxKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<androidx.compose.ui.b, androidx.compose.ui.layout.u> f2379a = d(true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<androidx.compose.ui.b, androidx.compose.ui.layout.u> f2380b = d(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final androidx.compose.ui.layout.u f2381c = new BoxMeasurePolicy(androidx.compose.ui.b.f3770a.m(), false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final androidx.compose.ui.layout.u f2382d = new androidx.compose.ui.layout.u() { // from class: androidx.compose.foundation.layout.BoxKt$EmptyBoxMeasurePolicy$1
        @Override // androidx.compose.ui.layout.u
        public final androidx.compose.ui.layout.w c(androidx.compose.ui.layout.y yVar, List<? extends androidx.compose.ui.layout.t> list, long j11) {
            return androidx.compose.ui.layout.x.b(yVar, q2.b.n(j11), q2.b.m(j11), null, new Function1<k0.a, Unit>() { // from class: androidx.compose.foundation.layout.BoxKt$EmptyBoxMeasurePolicy$1.1
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
    };

    public static final void a(final androidx.compose.ui.f fVar, androidx.compose.runtime.i iVar, final int i11) {
        int i12;
        androidx.compose.runtime.i iVarG = iVar.g(-211209833);
        if ((i11 & 6) == 0) {
            i12 = (iVarG.Q(fVar) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i12 & 3) == 2 && iVarG.h()) {
            iVarG.H();
        } else {
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-211209833, i12, -1, "androidx.compose.foundation.layout.Box (Box.kt:236)");
            }
            androidx.compose.ui.layout.u uVar = f2382d;
            int iA = androidx.compose.runtime.g.a(iVarG, 0);
            androidx.compose.ui.f fVarE = ComposedModifierKt.e(iVarG, fVar);
            androidx.compose.runtime.s sVarN = iVarG.n();
            ComposeUiNode.Companion companion = ComposeUiNode.f4919a8;
            Function0<ComposeUiNode> function0A = companion.a();
            if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            iVarG.D();
            if (iVarG.e()) {
                iVarG.G(function0A);
            } else {
                iVarG.o();
            }
            androidx.compose.runtime.i iVarA = f3.a(iVarG);
            f3.b(iVarA, uVar, companion.c());
            f3.b(iVarA, sVarN, companion.e());
            f3.b(iVarA, fVarE, companion.d());
            Function2<ComposeUiNode, Integer, Unit> function2B = companion.b();
            if (iVarA.e() || !Intrinsics.b(iVarA.y(), Integer.valueOf(iA))) {
                iVarA.p(Integer.valueOf(iA));
                iVarA.k(Integer.valueOf(iA), function2B);
            }
            iVarG.r();
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
        }
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.layout.BoxKt$Box$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i13) {
                    BoxKt.a(fVar, iVar2, v1.a(i11 | 1));
                }
            });
        }
    }

    public static final HashMap<androidx.compose.ui.b, androidx.compose.ui.layout.u> d(boolean z11) {
        HashMap<androidx.compose.ui.b, androidx.compose.ui.layout.u> map = new HashMap<>(9);
        androidx.compose.ui.b.a aVar = androidx.compose.ui.b.f3770a;
        e(map, z11, aVar.m());
        e(map, z11, aVar.k());
        e(map, z11, aVar.l());
        e(map, z11, aVar.g());
        e(map, z11, aVar.d());
        e(map, z11, aVar.e());
        e(map, z11, aVar.c());
        e(map, z11, aVar.a());
        e(map, z11, aVar.b());
        return map;
    }

    public static final void e(HashMap<androidx.compose.ui.b, androidx.compose.ui.layout.u> map, boolean z11, androidx.compose.ui.b bVar) {
        map.put(bVar, new BoxMeasurePolicy(bVar, z11));
    }

    public static final e f(androidx.compose.ui.layout.t tVar) {
        Object objF = tVar.F();
        if (objF instanceof e) {
            return (e) objF;
        }
        return null;
    }

    public static final boolean g(androidx.compose.ui.layout.t tVar) {
        e eVarF = f(tVar);
        if (eVarF != null) {
            return eVarF.I1();
        }
        return false;
    }

    @PublishedApi
    public static final androidx.compose.ui.layout.u h(androidx.compose.ui.b bVar, boolean z11) {
        androidx.compose.ui.layout.u uVar = (z11 ? f2379a : f2380b).get(bVar);
        return uVar == null ? new BoxMeasurePolicy(bVar, z11) : uVar;
    }

    public static final void i(k0.a aVar, k0 k0Var, androidx.compose.ui.layout.t tVar, LayoutDirection layoutDirection, int i11, int i12, androidx.compose.ui.b bVar) {
        androidx.compose.ui.b bVarH1;
        e eVarF = f(tVar);
        k0.a.j(aVar, k0Var, ((eVarF == null || (bVarH1 = eVarF.H1()) == null) ? bVar : bVarH1).a(q2.u.a(k0Var.s0(), k0Var.g0()), q2.u.a(i11, i12), layoutDirection), 0.0f, 2, null);
    }

    @PublishedApi
    public static final androidx.compose.ui.layout.u j(androidx.compose.ui.b bVar, boolean z11, androidx.compose.runtime.i iVar, int i11) {
        androidx.compose.ui.layout.u uVar;
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(56522820, i11, -1, "androidx.compose.foundation.layout.rememberBoxMeasurePolicy (Box.kt:113)");
        }
        if (!Intrinsics.b(bVar, androidx.compose.ui.b.f3770a.m()) || z11) {
            iVar.R(-1710100211);
            boolean z12 = ((((i11 & 14) ^ 6) > 4 && iVar.Q(bVar)) || (i11 & 6) == 4) | ((((i11 & 112) ^ 48) > 32 && iVar.a(z11)) || (i11 & 48) == 32);
            Object objY = iVar.y();
            if (z12 || objY == androidx.compose.runtime.i.f3413a.a()) {
                objY = new BoxMeasurePolicy(bVar, z11);
                iVar.p(objY);
            }
            uVar = (BoxMeasurePolicy) objY;
            iVar.L();
        } else {
            iVar.R(-1710139705);
            iVar.L();
            uVar = f2381c;
        }
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return uVar;
    }
}
