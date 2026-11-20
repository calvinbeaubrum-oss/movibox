package androidx.compose.foundation.layout;

import androidx.compose.ui.node.l0;
import androidx.compose.ui.platform.e1;
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
final class SizeElement extends l0<SizeNode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f2414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f2415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f2416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f2417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<e1, Unit> f2419g;

    /* JADX WARN: Multi-variable type inference failed */
    public SizeElement(float f11, float f12, float f13, float f14, boolean z11, Function1<? super e1, Unit> function1) {
        this.f2414b = f11;
        this.f2415c = f12;
        this.f2416d = f13;
        this.f2417e = f14;
        this.f2418f = z11;
        this.f2419g = function1;
    }

    public /* synthetic */ SizeElement(float f11, float f12, float f13, float f14, boolean z11, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? q2.i.f74232b.b() : f11, (i11 & 2) != 0 ? q2.i.f74232b.b() : f12, (i11 & 4) != 0 ? q2.i.f74232b.b() : f13, (i11 & 8) != 0 ? q2.i.f74232b.b() : f14, z11, function1, null);
    }

    public /* synthetic */ SizeElement(float f11, float f12, float f13, float f14, boolean z11, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, z11, function1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeElement)) {
            return false;
        }
        SizeElement sizeElement = (SizeElement) obj;
        return q2.i.j(this.f2414b, sizeElement.f2414b) && q2.i.j(this.f2415c, sizeElement.f2415c) && q2.i.j(this.f2416d, sizeElement.f2416d) && q2.i.j(this.f2417e, sizeElement.f2417e) && this.f2418f == sizeElement.f2418f;
    }

    public int hashCode() {
        return (((((((q2.i.k(this.f2414b) * 31) + q2.i.k(this.f2415c)) * 31) + q2.i.k(this.f2416d)) * 31) + q2.i.k(this.f2417e)) * 31) + androidx.compose.foundation.e.a(this.f2418f);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public SizeNode a() {
        return new SizeNode(this.f2414b, this.f2415c, this.f2416d, this.f2417e, this.f2418f, null);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(SizeNode sizeNode) {
        sizeNode.M1(this.f2414b);
        sizeNode.L1(this.f2415c);
        sizeNode.K1(this.f2416d);
        sizeNode.J1(this.f2417e);
        sizeNode.I1(this.f2418f);
    }
}
