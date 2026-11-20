package androidx.compose.ui.input.pointer;

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
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4712a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f4713b = f(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4714c = f(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4715d = f(2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4716e = f(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f4717f = f(4);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return k0.f4717f;
        }

        public final int b() {
            return k0.f4715d;
        }

        public final int c() {
            return k0.f4716e;
        }

        public final int d() {
            return k0.f4714c;
        }

        public final int e() {
            return k0.f4713b;
        }
    }

    public static int f(int i11) {
        return i11;
    }

    public static final boolean g(int i11, int i12) {
        return i11 == i12;
    }

    public static int h(int i11) {
        return i11;
    }

    public static String i(int i11) {
        if (i11 == 1) {
            return "Touch";
        }
        if (i11 == 2) {
            return "Mouse";
        }
        if (i11 != 3) {
            return i11 != 4 ? "Unknown" : "Eraser";
        }
        return "Stylus";
    }
}
