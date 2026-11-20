package androidx.compose.foundation.layout;

import androidx.compose.ui.node.l0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
final class FillElement extends l0<FillNode> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f2389e = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Direction f2390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f2391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2392d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FillElement a(float f11) {
            return new FillElement(Direction.Vertical, f11, "fillMaxHeight");
        }

        public final FillElement b(float f11) {
            return new FillElement(Direction.Both, f11, "fillMaxSize");
        }

        public final FillElement c(float f11) {
            return new FillElement(Direction.Horizontal, f11, "fillMaxWidth");
        }
    }

    public FillElement(Direction direction, float f11, String str) {
        this.f2390b = direction;
        this.f2391c = f11;
        this.f2392d = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FillElement)) {
            return false;
        }
        FillElement fillElement = (FillElement) obj;
        return this.f2390b == fillElement.f2390b && this.f2391c == fillElement.f2391c;
    }

    public int hashCode() {
        return (this.f2390b.hashCode() * 31) + Float.floatToIntBits(this.f2391c);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public FillNode a() {
        return new FillNode(this.f2390b, this.f2391c);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(FillNode fillNode) {
        fillNode.H1(this.f2390b);
        fillNode.I1(this.f2391c);
    }
}
