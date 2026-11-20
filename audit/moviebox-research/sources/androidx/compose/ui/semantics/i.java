package androidx.compose.ui.semantics;

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
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5649b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5650c = i(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5651d = i(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5652e = i(2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f5653f = i(3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f5654g = i(4);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f5655h = i(5);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5656i = i(6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5657a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return i.f5650c;
        }

        public final int b() {
            return i.f5651d;
        }

        public final int c() {
            return i.f5656i;
        }

        public final int d() {
            return i.f5655h;
        }

        public final int e() {
            return i.f5653f;
        }

        public final int f() {
            return i.f5652e;
        }

        public final int g() {
            return i.f5654g;
        }
    }

    public /* synthetic */ i(int i11) {
        this.f5657a = i11;
    }

    public static final /* synthetic */ i h(int i11) {
        return new i(i11);
    }

    public static int i(int i11) {
        return i11;
    }

    public static boolean j(int i11, Object obj) {
        return (obj instanceof i) && i11 == ((i) obj).n();
    }

    public static final boolean k(int i11, int i12) {
        return i11 == i12;
    }

    public static int l(int i11) {
        return i11;
    }

    public static String m(int i11) {
        if (k(i11, f5650c)) {
            return "Button";
        }
        if (k(i11, f5651d)) {
            return "Checkbox";
        }
        if (k(i11, f5652e)) {
            return "Switch";
        }
        if (k(i11, f5653f)) {
            return "RadioButton";
        }
        if (k(i11, f5654g)) {
            return "Tab";
        }
        if (k(i11, f5655h)) {
            return "Image";
        }
        return k(i11, f5656i) ? "DropdownList" : "Unknown";
    }

    public boolean equals(Object obj) {
        return j(this.f5657a, obj);
    }

    public int hashCode() {
        return l(this.f5657a);
    }

    public final /* synthetic */ int n() {
        return this.f5657a;
    }

    public String toString() {
        return m(this.f5657a);
    }
}
