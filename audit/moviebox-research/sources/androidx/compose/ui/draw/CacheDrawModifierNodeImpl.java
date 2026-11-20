package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.c4;
import androidx.compose.ui.node.o;
import androidx.compose.ui.node.s0;
import androidx.compose.ui.node.u0;
import androidx.compose.ui.node.v0;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import q2.u;

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
public final class CacheDrawModifierNodeImpl extends androidx.compose.ui.f.c implements b, u0, a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f3829o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f3830p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public l f3831q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Function1<? super c, i> f3832r;

    public CacheDrawModifierNodeImpl(c cVar, Function1<? super c, i> function1) {
        this.f3829o = cVar;
        this.f3832r = function1;
        cVar.m(this);
        cVar.C(new Function0<c4>() { // from class: androidx.compose.ui.draw.CacheDrawModifierNodeImpl.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c4 invoke() {
                return CacheDrawModifierNodeImpl.this.I1();
            }
        });
    }

    @Override // androidx.compose.ui.node.n
    public void A(z1.c cVar) {
        J1(cVar).a().invoke(cVar);
    }

    @Override // androidx.compose.ui.node.n
    public void F0() {
        x0();
    }

    public final Function1<c, i> H1() {
        return this.f3832r;
    }

    public final c4 I1() {
        l lVar = this.f3831q;
        if (lVar == null) {
            lVar = new l();
            this.f3831q = lVar;
        }
        if (lVar.c() == null) {
            lVar.e(androidx.compose.ui.node.g.j(this));
        }
        return lVar;
    }

    public final i J1(z1.c cVar) {
        if (!this.f3830p) {
            final c cVar2 = this.f3829o;
            cVar2.A(null);
            cVar2.x(cVar);
            v0.a(this, new Function0<Unit>() { // from class: androidx.compose.ui.draw.CacheDrawModifierNodeImpl$getOrBuildCachedDrawBlock$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    this.this$0.H1().invoke(cVar2);
                }
            });
            if (cVar2.k() == null) {
                h2.a.c("DrawResult not defined, did you forget to call onDraw?");
                throw new KotlinNothingValueException();
            }
            this.f3830p = true;
        }
        i iVarK = this.f3829o.k();
        Intrinsics.d(iVarK);
        return iVarK;
    }

    @Override // androidx.compose.ui.node.u0
    public void g0() {
        x0();
    }

    @Override // androidx.compose.ui.draw.a
    public q2.e getDensity() {
        return androidx.compose.ui.node.g.i(this);
    }

    @Override // androidx.compose.ui.draw.a
    public LayoutDirection getLayoutDirection() {
        return androidx.compose.ui.node.g.l(this);
    }

    @Override // androidx.compose.ui.draw.a
    public long i() {
        return u.d(androidx.compose.ui.node.g.h(this, s0.a(128)).p());
    }

    @Override // androidx.compose.ui.f.c
    public void s1() {
        super.s1();
        l lVar = this.f3831q;
        if (lVar != null) {
            lVar.d();
        }
    }

    @Override // androidx.compose.ui.draw.b
    public void x0() {
        l lVar = this.f3831q;
        if (lVar != null) {
            lVar.d();
        }
        this.f3830p = false;
        this.f3829o.A(null);
        o.a(this);
    }
}
