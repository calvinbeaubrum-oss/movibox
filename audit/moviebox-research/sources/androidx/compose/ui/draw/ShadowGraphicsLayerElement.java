package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.BlockGraphicsLayerModifier;
import androidx.compose.ui.graphics.c5;
import androidx.compose.ui.graphics.e4;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.node.l0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class ShadowGraphicsLayerElement extends l0<BlockGraphicsLayerModifier> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f3846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c5 f3847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f3849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f3850f;

    public ShadowGraphicsLayerElement(float f11, c5 c5Var, boolean z11, long j11, long j12) {
        this.f3846b = f11;
        this.f3847c = c5Var;
        this.f3848d = z11;
        this.f3849e = j11;
        this.f3850f = j12;
    }

    public /* synthetic */ ShadowGraphicsLayerElement(float f11, c5 c5Var, boolean z11, long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, c5Var, z11, j11, j12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShadowGraphicsLayerElement)) {
            return false;
        }
        ShadowGraphicsLayerElement shadowGraphicsLayerElement = (ShadowGraphicsLayerElement) obj;
        return q2.i.j(this.f3846b, shadowGraphicsLayerElement.f3846b) && Intrinsics.b(this.f3847c, shadowGraphicsLayerElement.f3847c) && this.f3848d == shadowGraphicsLayerElement.f3848d && w1.m(this.f3849e, shadowGraphicsLayerElement.f3849e) && w1.m(this.f3850f, shadowGraphicsLayerElement.f3850f);
    }

    public int hashCode() {
        return (((((((q2.i.k(this.f3846b) * 31) + this.f3847c.hashCode()) * 31) + androidx.compose.foundation.e.a(this.f3848d)) * 31) + w1.s(this.f3849e)) * 31) + w1.s(this.f3850f);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public BlockGraphicsLayerModifier a() {
        return new BlockGraphicsLayerModifier(q());
    }

    public final Function1<e4, Unit> q() {
        return new Function1<e4, Unit>() { // from class: androidx.compose.ui.draw.ShadowGraphicsLayerElement$createBlock$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e4 e4Var) {
                invoke2(e4Var);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e4 e4Var) {
                e4Var.w(e4Var.N0(this.this$0.t()));
                e4Var.K0(this.this$0.u());
                e4Var.t(this.this$0.s());
                e4Var.r(this.this$0.r());
                e4Var.u(this.this$0.v());
            }
        };
    }

    public final long r() {
        return this.f3849e;
    }

    public final boolean s() {
        return this.f3848d;
    }

    public final float t() {
        return this.f3846b;
    }

    public String toString() {
        return "ShadowGraphicsLayerElement(elevation=" + ((Object) q2.i.l(this.f3846b)) + ", shape=" + this.f3847c + ", clip=" + this.f3848d + ", ambientColor=" + ((Object) w1.t(this.f3849e)) + ", spotColor=" + ((Object) w1.t(this.f3850f)) + ')';
    }

    public final c5 u() {
        return this.f3847c;
    }

    public final long v() {
        return this.f3850f;
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void o(BlockGraphicsLayerModifier blockGraphicsLayerModifier) {
        blockGraphicsLayerModifier.J1(q());
        blockGraphicsLayerModifier.I1();
    }
}
