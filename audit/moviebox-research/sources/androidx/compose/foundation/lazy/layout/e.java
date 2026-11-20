package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f2703b = androidx.compose.runtime.collection.b.f3357d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<a> f2704a = new androidx.compose.runtime.collection.b<>(new a[16], 0);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2706b;

        public a(int i11, int i12) {
            this.f2705a = i11;
            this.f2706b = i12;
            if (i11 < 0) {
                throw new IllegalArgumentException("negative start index".toString());
            }
            if (i12 < i11) {
                throw new IllegalArgumentException("end index greater than start".toString());
            }
        }

        public final int a() {
            return this.f2706b;
        }

        public final int b() {
            return this.f2705a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f2705a == aVar.f2705a && this.f2706b == aVar.f2706b;
        }

        public int hashCode() {
            return (this.f2705a * 31) + this.f2706b;
        }

        public String toString() {
            return "Interval(start=" + this.f2705a + ", end=" + this.f2706b + ')';
        }
    }

    public final a a(int i11, int i12) {
        a aVar = new a(i11, i12);
        this.f2704a.b(aVar);
        return aVar;
    }

    public final int b() {
        int iA = this.f2704a.p().a();
        androidx.compose.runtime.collection.b<a> bVar = this.f2704a;
        int iR = bVar.r();
        if (iR > 0) {
            a[] aVarArrQ = bVar.q();
            int i11 = 0;
            do {
                a aVar = aVarArrQ[i11];
                if (aVar.a() > iA) {
                    iA = aVar.a();
                }
                i11++;
            } while (i11 < iR);
        }
        return iA;
    }

    public final int c() {
        int iB = this.f2704a.p().b();
        androidx.compose.runtime.collection.b<a> bVar = this.f2704a;
        int iR = bVar.r();
        if (iR > 0) {
            a[] aVarArrQ = bVar.q();
            int i11 = 0;
            do {
                a aVar = aVarArrQ[i11];
                if (aVar.b() < iB) {
                    iB = aVar.b();
                }
                i11++;
            } while (i11 < iR);
        }
        if (iB >= 0) {
            return iB;
        }
        throw new IllegalArgumentException("negative minIndex".toString());
    }

    public final boolean d() {
        return this.f2704a.u();
    }

    public final void e(a aVar) {
        this.f2704a.x(aVar);
    }
}
