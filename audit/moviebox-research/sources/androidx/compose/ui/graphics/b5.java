package androidx.compose.ui.graphics;

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
public final class b5 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f3990d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b5 f3991e = new b5(0, 0, 0.0f, 7, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f3994c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b5 a() {
            return b5.f3991e;
        }
    }

    public b5(long j11, long j12, float f11) {
        this.f3992a = j11;
        this.f3993b = j12;
        this.f3994c = f11;
    }

    public /* synthetic */ b5(long j11, long j12, float f11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? y1.d(4278190080L) : j11, (i11 & 2) != 0 ? y1.g.f81070b.c() : j12, (i11 & 4) != 0 ? 0.0f : f11, null);
    }

    public /* synthetic */ b5(long j11, long j12, float f11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, f11);
    }

    public final float b() {
        return this.f3994c;
    }

    public final long c() {
        return this.f3992a;
    }

    public final long d() {
        return this.f3993b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b5)) {
            return false;
        }
        b5 b5Var = (b5) obj;
        return w1.m(this.f3992a, b5Var.f3992a) && y1.g.j(this.f3993b, b5Var.f3993b) && this.f3994c == b5Var.f3994c;
    }

    public int hashCode() {
        return (((w1.s(this.f3992a) * 31) + y1.g.o(this.f3993b)) * 31) + Float.floatToIntBits(this.f3994c);
    }

    public String toString() {
        return "Shadow(color=" + ((Object) w1.t(this.f3992a)) + ", offset=" + ((Object) y1.g.t(this.f3993b)) + ", blurRadius=" + this.f3994c + ')';
    }
}
