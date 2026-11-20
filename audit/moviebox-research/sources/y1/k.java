package y1;

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
public final class k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f81081i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final k f81082j = l.c(0.0f, 0.0f, 0.0f, 0.0f, y1.a.f81064a.a());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f81083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f81084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f81085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f81086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f81087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f81088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f81089g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f81090h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public k(float f11, float f12, float f13, float f14, long j11, long j12, long j13, long j14) {
        this.f81083a = f11;
        this.f81084b = f12;
        this.f81085c = f13;
        this.f81086d = f14;
        this.f81087e = j11;
        this.f81088f = j12;
        this.f81089g = j13;
        this.f81090h = j14;
    }

    public /* synthetic */ k(float f11, float f12, float f13, float f14, long j11, long j12, long j13, long j14, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, j11, j12, j13, j14);
    }

    public final float a() {
        return this.f81086d;
    }

    public final long b() {
        return this.f81090h;
    }

    public final long c() {
        return this.f81089g;
    }

    public final float d() {
        return this.f81086d - this.f81084b;
    }

    public final float e() {
        return this.f81083a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return Float.compare(this.f81083a, kVar.f81083a) == 0 && Float.compare(this.f81084b, kVar.f81084b) == 0 && Float.compare(this.f81085c, kVar.f81085c) == 0 && Float.compare(this.f81086d, kVar.f81086d) == 0 && y1.a.c(this.f81087e, kVar.f81087e) && y1.a.c(this.f81088f, kVar.f81088f) && y1.a.c(this.f81089g, kVar.f81089g) && y1.a.c(this.f81090h, kVar.f81090h);
    }

    public final float f() {
        return this.f81085c;
    }

    public final float g() {
        return this.f81084b;
    }

    public final long h() {
        return this.f81087e;
    }

    public int hashCode() {
        return (((((((((((((Float.floatToIntBits(this.f81083a) * 31) + Float.floatToIntBits(this.f81084b)) * 31) + Float.floatToIntBits(this.f81085c)) * 31) + Float.floatToIntBits(this.f81086d)) * 31) + y1.a.f(this.f81087e)) * 31) + y1.a.f(this.f81088f)) * 31) + y1.a.f(this.f81089g)) * 31) + y1.a.f(this.f81090h);
    }

    public final long i() {
        return this.f81088f;
    }

    public final float j() {
        return this.f81085c - this.f81083a;
    }

    public String toString() {
        long j11 = this.f81087e;
        long j12 = this.f81088f;
        long j13 = this.f81089g;
        long j14 = this.f81090h;
        String str = c.a(this.f81083a, 1) + ", " + c.a(this.f81084b, 1) + ", " + c.a(this.f81085c, 1) + ", " + c.a(this.f81086d, 1);
        if (!y1.a.c(j11, j12) || !y1.a.c(j12, j13) || !y1.a.c(j13, j14)) {
            return "RoundRect(rect=" + str + ", topLeft=" + ((Object) y1.a.g(j11)) + ", topRight=" + ((Object) y1.a.g(j12)) + ", bottomRight=" + ((Object) y1.a.g(j13)) + ", bottomLeft=" + ((Object) y1.a.g(j14)) + ')';
        }
        if (y1.a.d(j11) == y1.a.e(j11)) {
            return "RoundRect(rect=" + str + ", radius=" + c.a(y1.a.d(j11), 1) + ')';
        }
        return "RoundRect(rect=" + str + ", x=" + c.a(y1.a.d(j11), 1) + ", y=" + c.a(y1.a.e(j11), 1) + ')';
    }
}
