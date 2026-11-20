package androidx.compose.ui.text.font;

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
public final class r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5854b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5855c = c(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5856d = c(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5857e = c(2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f5858f = c(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5859a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return r.f5856d;
        }
    }

    public /* synthetic */ r(int i11) {
        this.f5859a = i11;
    }

    public static final /* synthetic */ r b(int i11) {
        return new r(i11);
    }

    public static int c(int i11) {
        return i11;
    }

    public static boolean d(int i11, Object obj) {
        return (obj instanceof r) && i11 == ((r) obj).j();
    }

    public static final boolean e(int i11, int i12) {
        return i11 == i12;
    }

    public static int f(int i11) {
        return i11;
    }

    public static final boolean g(int i11) {
        return e(i11, f5856d) || e(i11, f5858f);
    }

    public static final boolean h(int i11) {
        return e(i11, f5856d) || e(i11, f5857e);
    }

    public static String i(int i11) {
        if (e(i11, f5855c)) {
            return "None";
        }
        if (e(i11, f5856d)) {
            return "All";
        }
        if (e(i11, f5857e)) {
            return "Weight";
        }
        return e(i11, f5858f) ? "Style" : "Invalid";
    }

    public boolean equals(Object obj) {
        return d(this.f5859a, obj);
    }

    public int hashCode() {
        return f(this.f5859a);
    }

    public final /* synthetic */ int j() {
        return this.f5859a;
    }

    public String toString() {
        return i(this.f5859a);
    }
}
