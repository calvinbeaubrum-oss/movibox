package androidx.compose.material;

import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.z1;
import androidx.compose.ui.node.u0;
import androidx.compose.ui.node.v0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class DelegatingThemeAwareRippleNode extends androidx.compose.ui.node.i implements androidx.compose.ui.node.d, u0 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final o1.g f3027q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f3028r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f3029s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final z1 f3030t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public androidx.compose.ui.node.f f3031u;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements z1 {
        public a() {
        }

        @Override // androidx.compose.ui.graphics.z1
        public final long a() {
            long jA = DelegatingThemeAwareRippleNode.this.f3030t.a();
            if (jA != 16) {
                return jA;
            }
            g gVar = (g) androidx.compose.ui.node.e.a(DelegatingThemeAwareRippleNode.this, RippleKt.d());
            return (gVar == null || gVar.a() == 16) ? h.f3089a.b(((w1) androidx.compose.ui.node.e.a(DelegatingThemeAwareRippleNode.this, ContentColorKt.a())).u(), ((b) androidx.compose.ui.node.e.a(DelegatingThemeAwareRippleNode.this, ColorsKt.c())).m()) : gVar.a();
        }
    }

    public DelegatingThemeAwareRippleNode(o1.g gVar, boolean z11, float f11, z1 z1Var) {
        this.f3027q = gVar;
        this.f3028r = z11;
        this.f3029s = f11;
        this.f3030t = z1Var;
    }

    public /* synthetic */ DelegatingThemeAwareRippleNode(o1.g gVar, boolean z11, float f11, z1 z1Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, z11, f11, z1Var);
    }

    public final void R1() {
        this.f3031u = H1(androidx.compose.material.ripple.h.c(this.f3027q, this.f3028r, this.f3029s, new a(), new Function0<androidx.compose.material.ripple.c>() { // from class: androidx.compose.material.DelegatingThemeAwareRippleNode$attachNewRipple$calculateRippleAlpha$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final androidx.compose.material.ripple.c invoke() {
                androidx.compose.material.ripple.c cVarB;
                g gVar = (g) androidx.compose.ui.node.e.a(this.this$0, RippleKt.d());
                return (gVar == null || (cVarB = gVar.b()) == null) ? h.f3089a.a(((w1) androidx.compose.ui.node.e.a(this.this$0, ContentColorKt.a())).u(), ((b) androidx.compose.ui.node.e.a(this.this$0, ColorsKt.c())).m()) : cVarB;
            }
        }));
    }

    public final void S1() {
        androidx.compose.ui.node.f fVar = this.f3031u;
        if (fVar != null) {
            K1(fVar);
        }
    }

    public final void T1() {
        v0.a(this, new Function0<Unit>() { // from class: androidx.compose.material.DelegatingThemeAwareRippleNode$updateConfiguration$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (((g) androidx.compose.ui.node.e.a(this.this$0, RippleKt.d())) == null) {
                    this.this$0.S1();
                } else if (this.this$0.f3031u == null) {
                    this.this$0.R1();
                }
            }
        });
    }

    @Override // androidx.compose.ui.node.u0
    public void g0() {
        T1();
    }

    @Override // androidx.compose.ui.f.c
    public void r1() {
        T1();
    }
}
