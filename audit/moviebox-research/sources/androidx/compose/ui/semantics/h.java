package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedFloatingPointRange;

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
public final class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f5644d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f5645e = new h(0.0f, b20.c.b(0.0f, 0.0f), 0, 4, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f5646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ClosedFloatingPointRange<Float> f5647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5648c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h a() {
            return h.f5645e;
        }
    }

    public h(float f11, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i11) {
        this.f5646a = f11;
        this.f5647b = closedFloatingPointRange;
        this.f5648c = i11;
        if (!(!Float.isNaN(f11))) {
            throw new IllegalArgumentException("current must not be NaN".toString());
        }
    }

    public /* synthetic */ h(float f11, ClosedFloatingPointRange closedFloatingPointRange, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, closedFloatingPointRange, (i12 & 4) != 0 ? 0 : i11);
    }

    public final float b() {
        return this.f5646a;
    }

    public final ClosedFloatingPointRange<Float> c() {
        return this.f5647b;
    }

    public final int d() {
        return this.f5648c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f5646a == hVar.f5646a && Intrinsics.b(this.f5647b, hVar.f5647b) && this.f5648c == hVar.f5648c;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.f5646a) * 31) + this.f5647b.hashCode()) * 31) + this.f5648c;
    }

    public String toString() {
        return "ProgressBarRangeInfo(current=" + this.f5646a + ", range=" + this.f5647b + ", steps=" + this.f5648c + ')';
    }
}
