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
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5962a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5963b = e(-1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5964c = e(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5965d = e(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5966e = e(2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f5967f = e(3);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return t.f5965d;
        }

        public final int b() {
            return t.f5964c;
        }

        public final int c() {
            return t.f5967f;
        }

        public final int d() {
            return t.f5966e;
        }
    }

    public static int e(int i11) {
        return i11;
    }

    public static final boolean f(int i11, int i12) {
        return i11 == i12;
    }

    public static int g(int i11) {
        return i11;
    }

    public static String h(int i11) {
        if (f(i11, f5963b)) {
            return "Unspecified";
        }
        if (f(i11, f5964c)) {
            return "None";
        }
        if (f(i11, f5965d)) {
            return "Characters";
        }
        if (f(i11, f5966e)) {
            return "Words";
        }
        return f(i11, f5967f) ? "Sentences" : "Invalid";
    }
}
