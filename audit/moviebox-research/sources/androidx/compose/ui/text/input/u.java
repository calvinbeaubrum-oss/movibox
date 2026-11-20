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
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5968a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5969b = j(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5970c = j(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5971d = j(2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5972e = j(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f5973f = j(4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f5974g = j(5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f5975h = j(6);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5976i = j(7);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f5977j = j(8);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f5978k = j(9);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return u.f5971d;
        }

        public final int b() {
            return u.f5978k;
        }

        public final int c() {
            return u.f5975h;
        }

        public final int d() {
            return u.f5972e;
        }

        public final int e() {
            return u.f5977j;
        }

        public final int f() {
            return u.f5976i;
        }

        public final int g() {
            return u.f5973f;
        }

        public final int h() {
            return u.f5970c;
        }

        public final int i() {
            return u.f5974g;
        }
    }

    public static int j(int i11) {
        return i11;
    }

    public static final boolean k(int i11, int i12) {
        return i11 == i12;
    }

    public static int l(int i11) {
        return i11;
    }

    public static String m(int i11) {
        if (k(i11, f5969b)) {
            return "Unspecified";
        }
        if (k(i11, f5970c)) {
            return "Text";
        }
        if (k(i11, f5971d)) {
            return "Ascii";
        }
        if (k(i11, f5972e)) {
            return "Number";
        }
        if (k(i11, f5973f)) {
            return "Phone";
        }
        if (k(i11, f5974g)) {
            return "Uri";
        }
        if (k(i11, f5975h)) {
            return "Email";
        }
        if (k(i11, f5976i)) {
            return "Password";
        }
        if (k(i11, f5977j)) {
            return "NumberPassword";
        }
        return k(i11, f5978k) ? "Decimal" : "Invalid";
    }
}
