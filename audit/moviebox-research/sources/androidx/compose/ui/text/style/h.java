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
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f6101b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6102c = i(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6103d = i(2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6104e = i(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f6105f = i(4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f6106g = i(5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f6107h = i(6);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f6108i = i(Integer.MIN_VALUE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6109a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return h.f6104e;
        }

        public final int b() {
            return h.f6107h;
        }

        public final int c() {
            return h.f6105f;
        }

        public final int d() {
            return h.f6102c;
        }

        public final int e() {
            return h.f6103d;
        }

        public final int f() {
            return h.f6106g;
        }

        public final int g() {
            return h.f6108i;
        }
    }

    public /* synthetic */ h(int i11) {
        this.f6109a = i11;
    }

    public static final /* synthetic */ h h(int i11) {
        return new h(i11);
    }

    public static int i(int i11) {
        return i11;
    }

    public static boolean j(int i11, Object obj) {
        return (obj instanceof h) && i11 == ((h) obj).n();
    }

    public static final boolean k(int i11, int i12) {
        return i11 == i12;
    }

    public static int l(int i11) {
        return i11;
    }

    public static String m(int i11) {
        if (k(i11, f6102c)) {
            return "Left";
        }
        if (k(i11, f6103d)) {
            return "Right";
        }
        if (k(i11, f6104e)) {
            return "Center";
        }
        if (k(i11, f6105f)) {
            return "Justify";
        }
        if (k(i11, f6106g)) {
            return "Start";
        }
        if (k(i11, f6107h)) {
            return "End";
        }
        return k(i11, f6108i) ? "Unspecified" : "Invalid";
    }

    public boolean equals(Object obj) {
        return j(this.f6109a, obj);
    }

    public int hashCode() {
        return l(this.f6109a);
    }

    public final /* synthetic */ int n() {
        return this.f6109a;
    }

    public String toString() {
        return m(this.f6109a);
    }
}
