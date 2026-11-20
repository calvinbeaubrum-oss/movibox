package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
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
public interface e {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        boolean a();
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @JvmInline
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4862a = new a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f4863b = g(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f4864c = g(2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f4865d = g(3);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f4866e = g(4);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f4867f = g(5);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f4868g = g(6);

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return b.f4867f;
            }

            public final int b() {
                return b.f4864c;
            }

            public final int c() {
                return b.f4863b;
            }

            public final int d() {
                return b.f4868g;
            }

            public final int e() {
                return b.f4865d;
            }

            public final int f() {
                return b.f4866e;
            }
        }

        public static int g(int i11) {
            return i11;
        }

        public static final boolean h(int i11, int i12) {
            return i11 == i12;
        }
    }

    <T> T a(int i11, Function1<? super a, ? extends T> function1);
}
