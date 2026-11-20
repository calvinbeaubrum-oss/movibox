package androidx.compose.ui.graphics.vector;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

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
public final class j extends l implements Iterable<l>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f4534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f4535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f4536d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f4537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f4538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f4539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f4540i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<e> f4541j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<l> f4542k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Iterator<l>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<l> f4543a;

        public a(j jVar) {
            this.f4543a = jVar.f4542k.iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public l next() {
            return this.f4543a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4543a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public j() {
        this(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(String str, float f11, float f12, float f13, float f14, float f15, float f16, float f17, List<? extends e> list, List<? extends l> list2) {
        super(null);
        this.f4533a = str;
        this.f4534b = f11;
        this.f4535c = f12;
        this.f4536d = f13;
        this.f4537f = f14;
        this.f4538g = f15;
        this.f4539h = f16;
        this.f4540i = f17;
        this.f4541j = list;
        this.f4542k = list2;
    }

    public /* synthetic */ j(String str, float f11, float f12, float f13, float f14, float f15, float f16, float f17, List list, List list2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? 0.0f : f11, (i11 & 4) != 0 ? 0.0f : f12, (i11 & 8) != 0 ? 0.0f : f13, (i11 & 16) != 0 ? 1.0f : f14, (i11 & 32) == 0 ? f15 : 1.0f, (i11 & 64) != 0 ? 0.0f : f16, (i11 & 128) == 0 ? f17 : 0.0f, (i11 & 256) != 0 ? k.d() : list, (i11 & 512) != 0 ? kotlin.collections.g.l() : list2);
    }

    public final l e(int i11) {
        return this.f4542k.get(i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof j)) {
            j jVar = (j) obj;
            return Intrinsics.b(this.f4533a, jVar.f4533a) && this.f4534b == jVar.f4534b && this.f4535c == jVar.f4535c && this.f4536d == jVar.f4536d && this.f4537f == jVar.f4537f && this.f4538g == jVar.f4538g && this.f4539h == jVar.f4539h && this.f4540i == jVar.f4540i && Intrinsics.b(this.f4541j, jVar.f4541j) && Intrinsics.b(this.f4542k, jVar.f4542k);
        }
        return false;
    }

    public final List<e> f() {
        return this.f4541j;
    }

    public final String g() {
        return this.f4533a;
    }

    public int hashCode() {
        return (((((((((((((((((this.f4533a.hashCode() * 31) + Float.floatToIntBits(this.f4534b)) * 31) + Float.floatToIntBits(this.f4535c)) * 31) + Float.floatToIntBits(this.f4536d)) * 31) + Float.floatToIntBits(this.f4537f)) * 31) + Float.floatToIntBits(this.f4538g)) * 31) + Float.floatToIntBits(this.f4539h)) * 31) + Float.floatToIntBits(this.f4540i)) * 31) + this.f4541j.hashCode()) * 31) + this.f4542k.hashCode();
    }

    public final float i() {
        return this.f4535c;
    }

    @Override // java.lang.Iterable
    public Iterator<l> iterator() {
        return new a(this);
    }

    public final float j() {
        return this.f4536d;
    }

    public final float r() {
        return this.f4534b;
    }

    public final float s() {
        return this.f4537f;
    }

    public final float u() {
        return this.f4538g;
    }

    public final int v() {
        return this.f4542k.size();
    }

    public final float w() {
        return this.f4539h;
    }

    public final float x() {
        return this.f4540i;
    }
}
