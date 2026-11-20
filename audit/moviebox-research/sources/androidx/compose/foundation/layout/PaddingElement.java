package androidx.compose.foundation.layout;

import androidx.compose.ui.node.l0;
import androidx.compose.ui.platform.e1;
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
final class PaddingElement extends l0<PaddingNode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f2402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f2403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f2404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<e1, Unit> f2406g;

    /* JADX WARN: Multi-variable type inference failed */
    public PaddingElement(float f11, float f12, float f13, float f14, boolean z11, Function1<? super e1, Unit> function1) {
        this.f2401b = f11;
        this.f2402c = f12;
        this.f2403d = f13;
        this.f2404e = f14;
        this.f2405f = z11;
        this.f2406g = function1;
        if (f11 >= 0.0f || q2.i.j(f11, q2.i.f74232b.b())) {
            float f15 = this.f2402c;
            if (f15 >= 0.0f || q2.i.j(f15, q2.i.f74232b.b())) {
                float f16 = this.f2403d;
                if (f16 >= 0.0f || q2.i.j(f16, q2.i.f74232b.b())) {
                    float f17 = this.f2404e;
                    if (f17 >= 0.0f || q2.i.j(f17, q2.i.f74232b.b())) {
                        return;
                    }
                }
            }
        }
        throw new IllegalArgumentException("Padding must be non-negative".toString());
    }

    public /* synthetic */ PaddingElement(float f11, float f12, float f13, float f14, boolean z11, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, z11, function1);
    }

    public boolean equals(Object obj) {
        PaddingElement paddingElement = obj instanceof PaddingElement ? (PaddingElement) obj : null;
        return paddingElement != null && q2.i.j(this.f2401b, paddingElement.f2401b) && q2.i.j(this.f2402c, paddingElement.f2402c) && q2.i.j(this.f2403d, paddingElement.f2403d) && q2.i.j(this.f2404e, paddingElement.f2404e) && this.f2405f == paddingElement.f2405f;
    }

    public int hashCode() {
        return (((((((q2.i.k(this.f2401b) * 31) + q2.i.k(this.f2402c)) * 31) + q2.i.k(this.f2403d)) * 31) + q2.i.k(this.f2404e)) * 31) + androidx.compose.foundation.e.a(this.f2405f);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public PaddingNode a() {
        return new PaddingNode(this.f2401b, this.f2402c, this.f2403d, this.f2404e, this.f2405f, null);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(PaddingNode paddingNode) {
        paddingNode.N1(this.f2401b);
        paddingNode.O1(this.f2402c);
        paddingNode.L1(this.f2403d);
        paddingNode.K1(this.f2404e);
        paddingNode.M1(this.f2405f);
    }
}
