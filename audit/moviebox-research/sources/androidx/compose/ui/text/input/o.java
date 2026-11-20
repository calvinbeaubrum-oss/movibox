package androidx.compose.ui.text.input;

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
public final class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5943b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5944c = j(-1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5945d = j(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5946e = j(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f5947f = j(2);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f5948g = j(3);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f5949h = j(4);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5950i = j(5);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f5951j = j(6);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f5952k = j(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5953a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return o.f5945d;
        }

        public final int b() {
            return o.f5952k;
        }

        public final int c() {
            return o.f5947f;
        }

        public final int d() {
            return o.f5951j;
        }

        public final int e() {
            return o.f5946e;
        }

        public final int f() {
            return o.f5950i;
        }

        public final int g() {
            return o.f5948g;
        }

        public final int h() {
            return o.f5949h;
        }
    }

    public /* synthetic */ o(int i11) {
        this.f5953a = i11;
    }

    public static final /* synthetic */ o i(int i11) {
        return new o(i11);
    }

    public static int j(int i11) {
        return i11;
    }

    public static boolean k(int i11, Object obj) {
        return (obj instanceof o) && i11 == ((o) obj).o();
    }

    public static final boolean l(int i11, int i12) {
        return i11 == i12;
    }

    public static int m(int i11) {
        return i11;
    }

    public static String n(int i11) {
        if (l(i11, f5944c)) {
            return "Unspecified";
        }
        if (l(i11, f5946e)) {
            return "None";
        }
        if (l(i11, f5945d)) {
            return "Default";
        }
        if (l(i11, f5947f)) {
            return "Go";
        }
        if (l(i11, f5948g)) {
            return "Search";
        }
        if (l(i11, f5949h)) {
            return "Send";
        }
        if (l(i11, f5950i)) {
            return "Previous";
        }
        if (l(i11, f5951j)) {
            return "Next";
        }
        return l(i11, f5952k) ? "Done" : "Invalid";
    }

    public boolean equals(Object obj) {
        return k(this.f5953a, obj);
    }

    public int hashCode() {
        return m(this.f5953a);
    }

    public final /* synthetic */ int o() {
        return this.f5953a;
    }

    public String toString() {
        return n(this.f5953a);
    }
}
