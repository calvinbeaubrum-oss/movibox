package q2;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
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
@JvmInline
public final class y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f74261b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f74262c = e(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f74263d = e(4294967296L);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f74264e = e(8589934592L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f74265a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return y.f74264e;
        }

        public final long b() {
            return y.f74263d;
        }

        public final long c() {
            return y.f74262c;
        }
    }

    public /* synthetic */ y(long j11) {
        this.f74265a = j11;
    }

    public static final /* synthetic */ y d(long j11) {
        return new y(j11);
    }

    public static long e(long j11) {
        return j11;
    }

    public static boolean f(long j11, Object obj) {
        return (obj instanceof y) && j11 == ((y) obj).j();
    }

    public static final boolean g(long j11, long j12) {
        return j11 == j12;
    }

    public static int h(long j11) {
        return l.p.a(j11);
    }

    public static String i(long j11) {
        if (g(j11, f74262c)) {
            return "Unspecified";
        }
        if (g(j11, f74263d)) {
            return "Sp";
        }
        return g(j11, f74264e) ? "Em" : "Invalid";
    }

    public boolean equals(Object obj) {
        return f(this.f74265a, obj);
    }

    public int hashCode() {
        return h(this.f74265a);
    }

    public final /* synthetic */ long j() {
        return this.f74265a;
    }

    public String toString() {
        return i(this.f74265a);
    }
}
