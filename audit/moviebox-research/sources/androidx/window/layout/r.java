package androidx.window.layout;

import com.transsion.moviedetailapi.bean.BannerBean;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
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
public interface r extends l {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0122a f13199b = new C0122a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public static final a f13200c = new a("NONE");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @JvmField
        public static final a f13201d = new a("FULL");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13202a;

        /* JADX INFO: renamed from: androidx.window.layout.r$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0122a {
            public C0122a() {
            }

            public /* synthetic */ C0122a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public a(String str) {
            this.f13202a = str;
        }

        public String toString() {
            return this.f13202a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f13203b = new a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public static final b f13204c = new b("VERTICAL");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @JvmField
        public static final b f13205d = new b(BannerBean.BANNER_STYLE_HORIZONTAL);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13206a;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public b(String str) {
            this.f13206a = str;
        }

        public String toString() {
            return this.f13206a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f13207b = new a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public static final c f13208c = new c("FLAT");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @JvmField
        public static final c f13209d = new c("HALF_OPENED");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13210a;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public c(String str) {
            this.f13210a = str;
        }

        public String toString() {
            return this.f13210a;
        }
    }

    b getOrientation();

    c getState();

    boolean isSeparating();
}
