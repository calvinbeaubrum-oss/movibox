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
public final class i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f81075e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final i f81076f = new i(0.0f, 0.0f, 0.0f, 0.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f81077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f81078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f81079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f81080d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i a() {
            return i.f81076f;
        }
    }

    public i(float f11, float f12, float f13, float f14) {
        this.f81077a = f11;
        this.f81078b = f12;
        this.f81079c = f13;
        this.f81080d = f14;
    }

    public final boolean b(long j11) {
        return g.m(j11) >= this.f81077a && g.m(j11) < this.f81079c && g.n(j11) >= this.f81078b && g.n(j11) < this.f81080d;
    }

    public final float c() {
        return this.f81080d;
    }

    public final long d() {
        return h.a(this.f81077a + (k() / 2.0f), this.f81078b + (e() / 2.0f));
    }

    public final float e() {
        return this.f81080d - this.f81078b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Float.compare(this.f81077a, iVar.f81077a) == 0 && Float.compare(this.f81078b, iVar.f81078b) == 0 && Float.compare(this.f81079c, iVar.f81079c) == 0 && Float.compare(this.f81080d, iVar.f81080d) == 0;
    }

    public final float f() {
        return this.f81077a;
    }

    public final float g() {
        return this.f81079c;
    }

    public final long h() {
        return n.a(k(), e());
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f81077a) * 31) + Float.floatToIntBits(this.f81078b)) * 31) + Float.floatToIntBits(this.f81079c)) * 31) + Float.floatToIntBits(this.f81080d);
    }

    public final float i() {
        return this.f81078b;
    }

    public final long j() {
        return h.a(this.f81077a, this.f81078b);
    }

    public final float k() {
        return this.f81079c - this.f81077a;
    }

    public final i l(float f11, float f12, float f13, float f14) {
        return new i(Math.max(this.f81077a, f11), Math.max(this.f81078b, f12), Math.min(this.f81079c, f13), Math.min(this.f81080d, f14));
    }

    public final i m(i iVar) {
        return new i(Math.max(this.f81077a, iVar.f81077a), Math.max(this.f81078b, iVar.f81078b), Math.min(this.f81079c, iVar.f81079c), Math.min(this.f81080d, iVar.f81080d));
    }

    public final boolean n() {
        return this.f81077a >= this.f81079c || this.f81078b >= this.f81080d;
    }

    public final boolean o(i iVar) {
        return this.f81079c > iVar.f81077a && iVar.f81079c > this.f81077a && this.f81080d > iVar.f81078b && iVar.f81080d > this.f81078b;
    }

    public final i p(float f11, float f12) {
        return new i(this.f81077a + f11, this.f81078b + f12, this.f81079c + f11, this.f81080d + f12);
    }

    public final i q(long j11) {
        return new i(this.f81077a + g.m(j11), this.f81078b + g.n(j11), this.f81079c + g.m(j11), this.f81080d + g.n(j11));
    }

    public String toString() {
        return "Rect.fromLTRB(" + c.a(this.f81077a, 1) + ", " + c.a(this.f81078b, 1) + ", " + c.a(this.f81079c, 1) + ", " + c.a(this.f81080d, 1) + ')';
    }
}
