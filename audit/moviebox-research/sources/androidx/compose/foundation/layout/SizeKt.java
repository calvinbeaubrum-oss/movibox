package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.e1;
import com.applovin.sdk.AppLovinMediationProvider;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class SizeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FillElement f2420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FillElement f2421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FillElement f2422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final WrapContentElement f2423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final WrapContentElement f2424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final WrapContentElement f2425f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final WrapContentElement f2426g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final WrapContentElement f2427h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final WrapContentElement f2428i;

    static {
        FillElement.a aVar = FillElement.f2389e;
        f2420a = aVar.c(1.0f);
        f2421b = aVar.a(1.0f);
        f2422c = aVar.b(1.0f);
        WrapContentElement.Companion companion = WrapContentElement.f2464g;
        androidx.compose.ui.b.a aVar2 = androidx.compose.ui.b.f3770a;
        f2423d = companion.c(aVar2.f(), false);
        f2424e = companion.c(aVar2.i(), false);
        f2425f = companion.a(aVar2.h(), false);
        f2426g = companion.a(aVar2.j(), false);
        f2427h = companion.b(aVar2.d(), false);
        f2428i = companion.b(aVar2.m(), false);
    }

    public static final androidx.compose.ui.f a(androidx.compose.ui.f fVar, float f11) {
        return fVar.f(f11 == 1.0f ? f2422c : FillElement.f2389e.b(f11));
    }

    public static /* synthetic */ androidx.compose.ui.f b(androidx.compose.ui.f fVar, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = 1.0f;
        }
        return a(fVar, f11);
    }

    public static final androidx.compose.ui.f c(androidx.compose.ui.f fVar, float f11) {
        return fVar.f(f11 == 1.0f ? f2420a : FillElement.f2389e.c(f11));
    }

    public static /* synthetic */ androidx.compose.ui.f d(androidx.compose.ui.f fVar, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = 1.0f;
        }
        return c(fVar, f11);
    }

    public static final androidx.compose.ui.f e(androidx.compose.ui.f fVar, final float f11) {
        return fVar.f(new SizeElement(0.0f, f11, 0.0f, f11, true, InspectableValueKt.b() ? new Function1<e1, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$height-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e1 e1Var) {
                invoke2(e1Var);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e1 e1Var) {
                e1Var.b("height");
                e1Var.c(q2.i.c(f11));
            }
        } : InspectableValueKt.a(), 5, null));
    }

    public static final androidx.compose.ui.f f(androidx.compose.ui.f fVar, final float f11, final float f12) {
        return fVar.f(new SizeElement(0.0f, f11, 0.0f, f12, true, InspectableValueKt.b() ? new Function1<e1, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$heightIn-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e1 e1Var) {
                invoke2(e1Var);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e1 e1Var) {
                e1Var.b("heightIn");
                e1Var.a().b("min", q2.i.c(f11));
                e1Var.a().b(AppLovinMediationProvider.MAX, q2.i.c(f12));
            }
        } : InspectableValueKt.a(), 5, null));
    }

    public static /* synthetic */ androidx.compose.ui.f g(androidx.compose.ui.f fVar, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = q2.i.f74232b.b();
        }
        if ((i11 & 2) != 0) {
            f12 = q2.i.f74232b.b();
        }
        return f(fVar, f11, f12);
    }

    public static final androidx.compose.ui.f h(androidx.compose.ui.f fVar, final float f11, final float f12, final float f13, final float f14) {
        return fVar.f(new SizeElement(f11, f12, f13, f14, false, InspectableValueKt.b() ? new Function1<e1, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredSizeIn-qDBjuR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e1 e1Var) {
                invoke2(e1Var);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e1 e1Var) {
                e1Var.b("requiredSizeIn");
                e1Var.a().b("minWidth", q2.i.c(f11));
                e1Var.a().b("minHeight", q2.i.c(f12));
                e1Var.a().b("maxWidth", q2.i.c(f13));
                e1Var.a().b("maxHeight", q2.i.c(f14));
            }
        } : InspectableValueKt.a(), null));
    }

    public static /* synthetic */ androidx.compose.ui.f i(androidx.compose.ui.f fVar, float f11, float f12, float f13, float f14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = q2.i.f74232b.b();
        }
        if ((i11 & 2) != 0) {
            f12 = q2.i.f74232b.b();
        }
        if ((i11 & 4) != 0) {
            f13 = q2.i.f74232b.b();
        }
        if ((i11 & 8) != 0) {
            f14 = q2.i.f74232b.b();
        }
        return h(fVar, f11, f12, f13, f14);
    }

    public static final androidx.compose.ui.f j(androidx.compose.ui.f fVar, final float f11) {
        return fVar.f(new SizeElement(f11, f11, f11, f11, true, InspectableValueKt.b() ? new Function1<e1, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$size-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e1 e1Var) {
                invoke2(e1Var);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e1 e1Var) {
                e1Var.b("size");
                e1Var.c(q2.i.c(f11));
            }
        } : InspectableValueKt.a(), null));
    }

    public static final androidx.compose.ui.f k(androidx.compose.ui.f fVar, final float f11, final float f12) {
        return fVar.f(new SizeElement(f11, f12, f11, f12, true, InspectableValueKt.b() ? new Function1<e1, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$size-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e1 e1Var) {
                invoke2(e1Var);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e1 e1Var) {
                e1Var.b("size");
                e1Var.a().b("width", q2.i.c(f11));
                e1Var.a().b("height", q2.i.c(f12));
            }
        } : InspectableValueKt.a(), null));
    }

    public static final androidx.compose.ui.f l(androidx.compose.ui.f fVar, final float f11) {
        return fVar.f(new SizeElement(f11, 0.0f, f11, 0.0f, true, InspectableValueKt.b() ? new Function1<e1, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$width-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e1 e1Var) {
                invoke2(e1Var);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e1 e1Var) {
                e1Var.b("width");
                e1Var.c(q2.i.c(f11));
            }
        } : InspectableValueKt.a(), 10, null));
    }

    public static final androidx.compose.ui.f m(androidx.compose.ui.f fVar, final float f11, final float f12) {
        return fVar.f(new SizeElement(f11, 0.0f, f12, 0.0f, true, InspectableValueKt.b() ? new Function1<e1, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$widthIn-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e1 e1Var) {
                invoke2(e1Var);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e1 e1Var) {
                e1Var.b("widthIn");
                e1Var.a().b("min", q2.i.c(f11));
                e1Var.a().b(AppLovinMediationProvider.MAX, q2.i.c(f12));
            }
        } : InspectableValueKt.a(), 10, null));
    }

    public static /* synthetic */ androidx.compose.ui.f n(androidx.compose.ui.f fVar, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = q2.i.f74232b.b();
        }
        if ((i11 & 2) != 0) {
            f12 = q2.i.f74232b.b();
        }
        return m(fVar, f11, f12);
    }

    public static final androidx.compose.ui.f o(androidx.compose.ui.f fVar, androidx.compose.ui.b.c cVar, boolean z11) {
        WrapContentElement wrapContentElementA;
        androidx.compose.ui.b.a aVar = androidx.compose.ui.b.f3770a;
        if (!Intrinsics.b(cVar, aVar.h()) || z11) {
            wrapContentElementA = (!Intrinsics.b(cVar, aVar.j()) || z11) ? WrapContentElement.f2464g.a(cVar, z11) : f2426g;
        } else {
            wrapContentElementA = f2425f;
        }
        return fVar.f(wrapContentElementA);
    }

    public static /* synthetic */ androidx.compose.ui.f p(androidx.compose.ui.f fVar, androidx.compose.ui.b.c cVar, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cVar = androidx.compose.ui.b.f3770a.h();
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return o(fVar, cVar, z11);
    }
}
