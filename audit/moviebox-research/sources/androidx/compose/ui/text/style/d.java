package androidx.compose.ui.text.style;

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
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f6061b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6062c = e(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6063d = e(2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6064e = e(Integer.MIN_VALUE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6065a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return d.f6063d;
        }

        public final int b() {
            return d.f6062c;
        }

        public final int c() {
            return d.f6064e;
        }
    }

    public /* synthetic */ d(int i11) {
        this.f6065a = i11;
    }

    public static final /* synthetic */ d d(int i11) {
        return new d(i11);
    }

    public static int e(int i11) {
        return i11;
    }

    public static boolean f(int i11, Object obj) {
        return (obj instanceof d) && i11 == ((d) obj).j();
    }

    public static final boolean g(int i11, int i12) {
        return i11 == i12;
    }

    public static int h(int i11) {
        return i11;
    }

    public static String i(int i11) {
        if (g(i11, f6062c)) {
            return "Hyphens.None";
        }
        if (g(i11, f6063d)) {
            return "Hyphens.Auto";
        }
        return g(i11, f6064e) ? "Hyphens.Unspecified" : "Invalid";
    }

    public boolean equals(Object obj) {
        return f(this.f6065a, obj);
    }

    public int hashCode() {
        return h(this.f6065a);
    }

    public final /* synthetic */ int j() {
        return this.f6065a;
    }

    public String toString() {
        return i(this.f6065a);
    }
}
