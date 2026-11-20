package androidx.compose.ui.node;

import androidx.compose.ui.platform.r2;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

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
@PublishedApi
public interface ComposeUiNode {

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public static final Companion f4919a8 = Companion.f4920a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f4920a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Function0<ComposeUiNode> f4921b = LayoutNode.L.a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Function0<ComposeUiNode> f4922c = new Function0<LayoutNode>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$VirtualConstructor$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LayoutNode invoke() {
                return new LayoutNode(true, 0, 2, null);
            }
        };

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Function2<ComposeUiNode, androidx.compose.ui.f, Unit> f4923d = new Function2<ComposeUiNode, androidx.compose.ui.f, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ComposeUiNode composeUiNode, androidx.compose.ui.f fVar) {
                invoke2(composeUiNode, fVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ComposeUiNode composeUiNode, androidx.compose.ui.f fVar) {
                composeUiNode.h(fVar);
            }
        };

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Function2<ComposeUiNode, q2.e, Unit> f4924e = new Function2<ComposeUiNode, q2.e, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetDensity$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ComposeUiNode composeUiNode, q2.e eVar) {
                invoke2(composeUiNode, eVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ComposeUiNode composeUiNode, q2.e eVar) {
                composeUiNode.b(eVar);
            }
        };

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Function2<ComposeUiNode, androidx.compose.runtime.s, Unit> f4925f = new Function2<ComposeUiNode, androidx.compose.runtime.s, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ComposeUiNode composeUiNode, androidx.compose.runtime.s sVar) {
                invoke2(composeUiNode, sVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ComposeUiNode composeUiNode, androidx.compose.runtime.s sVar) {
                composeUiNode.i(sVar);
            }
        };

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Function2<ComposeUiNode, androidx.compose.ui.layout.u, Unit> f4926g = new Function2<ComposeUiNode, androidx.compose.ui.layout.u, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ComposeUiNode composeUiNode, androidx.compose.ui.layout.u uVar) {
                invoke2(composeUiNode, uVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ComposeUiNode composeUiNode, androidx.compose.ui.layout.u uVar) {
                composeUiNode.g(uVar);
            }
        };

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final Function2<ComposeUiNode, LayoutDirection, Unit> f4927h = new Function2<ComposeUiNode, LayoutDirection, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetLayoutDirection$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ComposeUiNode composeUiNode, LayoutDirection layoutDirection) {
                invoke2(composeUiNode, layoutDirection);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ComposeUiNode composeUiNode, LayoutDirection layoutDirection) {
                composeUiNode.a(layoutDirection);
            }
        };

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final Function2<ComposeUiNode, r2, Unit> f4928i = new Function2<ComposeUiNode, r2, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetViewConfiguration$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ComposeUiNode composeUiNode, r2 r2Var) {
                invoke2(composeUiNode, r2Var);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ComposeUiNode composeUiNode, r2 r2Var) {
                composeUiNode.e(r2Var);
            }
        };

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final Function2<ComposeUiNode, Integer, Unit> f4929j = new Function2<ComposeUiNode, Integer, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ComposeUiNode composeUiNode, Integer num) {
                invoke(composeUiNode, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(ComposeUiNode composeUiNode, int i11) {
                composeUiNode.c(i11);
            }
        };

        public final Function0<ComposeUiNode> a() {
            return f4921b;
        }

        public final Function2<ComposeUiNode, Integer, Unit> b() {
            return f4929j;
        }

        public final Function2<ComposeUiNode, androidx.compose.ui.layout.u, Unit> c() {
            return f4926g;
        }

        public final Function2<ComposeUiNode, androidx.compose.ui.f, Unit> d() {
            return f4923d;
        }

        public final Function2<ComposeUiNode, androidx.compose.runtime.s, Unit> e() {
            return f4925f;
        }
    }

    void a(LayoutDirection layoutDirection);

    void b(q2.e eVar);

    void c(int i11);

    void e(r2 r2Var);

    void g(androidx.compose.ui.layout.u uVar);

    void h(androidx.compose.ui.f fVar);

    void i(androidx.compose.runtime.s sVar);
}
