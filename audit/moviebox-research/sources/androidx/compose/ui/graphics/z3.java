package androidx.compose.ui.graphics;

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
public final class z3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4590a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f4591b = c(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4592c = c(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4593d = c(2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4594e = c(3);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return z3.f4592c;
        }

        public final int b() {
            return z3.f4591b;
        }
    }

    public static int c(int i11) {
        return i11;
    }

    public static final boolean d(int i11, int i12) {
        return i11 == i12;
    }

    public static int e(int i11) {
        return i11;
    }

    public static String f(int i11) {
        if (d(i11, f4591b)) {
            return "None";
        }
        if (d(i11, f4592c)) {
            return "Low";
        }
        if (d(i11, f4593d)) {
            return "Medium";
        }
        return d(i11, f4594e) ? "High" : "Unknown";
    }
}
