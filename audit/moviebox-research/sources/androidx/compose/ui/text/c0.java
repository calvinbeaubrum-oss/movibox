package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
@JvmInline
@SourceDebugExtension
public final class c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5765b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f5766c = d0.a(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5767a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return c0.f5766c;
        }
    }

    public /* synthetic */ c0(long j11) {
        this.f5767a = j11;
    }

    public static final /* synthetic */ c0 b(long j11) {
        return new c0(j11);
    }

    public static long c(long j11) {
        return j11;
    }

    public static boolean d(long j11, Object obj) {
        return (obj instanceof c0) && j11 == ((c0) obj).n();
    }

    public static final boolean e(long j11, long j12) {
        return j11 == j12;
    }

    public static final boolean f(long j11) {
        return k(j11) == g(j11);
    }

    public static final int g(long j11) {
        return (int) (j11 & 4294967295L);
    }

    public static final int h(long j11) {
        return i(j11) - j(j11);
    }

    public static final int i(long j11) {
        return k(j11) > g(j11) ? k(j11) : g(j11);
    }

    public static final int j(long j11) {
        return k(j11) > g(j11) ? g(j11) : k(j11);
    }

    public static final int k(long j11) {
        return (int) (j11 >> 32);
    }

    public static int l(long j11) {
        return l.p.a(j11);
    }

    public static String m(long j11) {
        return "TextRange(" + k(j11) + ", " + g(j11) + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f5767a, obj);
    }

    public int hashCode() {
        return l(this.f5767a);
    }

    public final /* synthetic */ long n() {
        return this.f5767a;
    }

    public String toString() {
        return m(this.f5767a);
    }
}
