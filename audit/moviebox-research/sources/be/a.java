package be;

import kotlin.Metadata;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public interface a {

    /* JADX INFO: renamed from: be.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface InterfaceC0143a {
        b a();

        c b(b bVar);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f14092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f14093b;

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public b(String str, String str2) {
            this.f14092a = str;
            this.f14093b = str2;
        }

        public /* synthetic */ b(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
        }

        public final String a() {
            return this.f14092a;
        }

        public final String b() {
            return this.f14093b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.b(this.f14092a, bVar.f14092a) && Intrinsics.b(this.f14093b, bVar.f14093b);
        }

        public int hashCode() {
            String str = this.f14092a;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f14093b;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Params(appId=" + this.f14092a + ", url=" + this.f14093b + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f14094a;

        /* JADX WARN: Illegal instructions before constructor call */
        public c() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            this(defaultConstructorMarker, 1, defaultConstructorMarker);
        }

        public c(Object obj) {
            this.f14094a = obj;
        }

        public /* synthetic */ c(Object obj, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : obj);
        }

        public final Object a() {
            return this.f14094a;
        }

        public final void b(Object obj) {
            this.f14094a = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.b(this.f14094a, ((c) obj).f14094a);
        }

        public int hashCode() {
            Object obj = this.f14094a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public String toString() {
            return "Result(body=" + this.f14094a + ')';
        }
    }

    c a(InterfaceC0143a interfaceC0143a);
}
