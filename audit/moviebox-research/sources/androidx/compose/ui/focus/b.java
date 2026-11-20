package androidx.compose.ui.focus;

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
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3922b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f3923c = j(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f3924d = j(2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f3925e = j(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f3926f = j(4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f3927g = j(5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f3928h = j(6);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f3929i = j(7);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f3930j = j(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3931a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return b.f3928h;
        }

        public final int b() {
            return b.f3929i;
        }

        public final int c() {
            return b.f3930j;
        }

        public final int d() {
            return b.f3925e;
        }

        public final int e() {
            return b.f3923c;
        }

        public final int f() {
            return b.f3924d;
        }

        public final int g() {
            return b.f3926f;
        }

        public final int h() {
            return b.f3927g;
        }
    }

    public /* synthetic */ b(int i11) {
        this.f3931a = i11;
    }

    public static final /* synthetic */ b i(int i11) {
        return new b(i11);
    }

    public static int j(int i11) {
        return i11;
    }

    public static boolean k(int i11, Object obj) {
        return (obj instanceof b) && i11 == ((b) obj).o();
    }

    public static final boolean l(int i11, int i12) {
        return i11 == i12;
    }

    public static int m(int i11) {
        return i11;
    }

    public static String n(int i11) {
        if (l(i11, f3923c)) {
            return "Next";
        }
        if (l(i11, f3924d)) {
            return "Previous";
        }
        if (l(i11, f3925e)) {
            return "Left";
        }
        if (l(i11, f3926f)) {
            return "Right";
        }
        if (l(i11, f3927g)) {
            return "Up";
        }
        if (l(i11, f3928h)) {
            return "Down";
        }
        if (l(i11, f3929i)) {
            return "Enter";
        }
        return l(i11, f3930j) ? "Exit" : "Invalid FocusDirection";
    }

    public boolean equals(Object obj) {
        return k(this.f3931a, obj);
    }

    public int hashCode() {
        return m(this.f3931a);
    }

    public final /* synthetic */ int o() {
        return this.f3931a;
    }

    public String toString() {
        return n(this.f3931a);
    }
}
