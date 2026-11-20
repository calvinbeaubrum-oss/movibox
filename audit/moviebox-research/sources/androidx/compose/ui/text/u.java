package androidx.compose.ui.text;

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
    public static final a f6150a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6151b = h(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6152c = h(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6153d = h(3);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6154e = h(4);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f6155f = h(5);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f6156g = h(6);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f6157h = h(7);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return u.f6151b;
        }

        public final int b() {
            return u.f6153d;
        }

        public final int c() {
            return u.f6154e;
        }

        public final int d() {
            return u.f6156g;
        }

        public final int e() {
            return u.f6157h;
        }

        public final int f() {
            return u.f6155f;
        }

        public final int g() {
            return u.f6152c;
        }
    }

    public static int h(int i11) {
        return i11;
    }

    public static final boolean i(int i11, int i12) {
        return i11 == i12;
    }

    public static int j(int i11) {
        return i11;
    }

    public static String k(int i11) {
        if (i(i11, f6151b)) {
            return "AboveBaseline";
        }
        if (i(i11, f6152c)) {
            return "Top";
        }
        if (i(i11, f6153d)) {
            return "Bottom";
        }
        if (i(i11, f6154e)) {
            return "Center";
        }
        if (i(i11, f6155f)) {
            return "TextTop";
        }
        if (i(i11, f6156g)) {
            return "TextBottom";
        }
        return i(i11, f6157h) ? "TextCenter" : "Invalid";
    }
}
