package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f6134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o f6135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final o f6136e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6138b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final o a() {
            return o.f6135d;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @JvmInline
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6139a = new a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f6140b = d(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6141c = d(2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f6142d = d(3);

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return b.f6141c;
            }

            public final int b() {
                return b.f6140b;
            }

            public final int c() {
                return b.f6142d;
            }
        }

        public static int d(int i11) {
            return i11;
        }

        public static final boolean e(int i11, int i12) {
            return i11 == i12;
        }

        public static int f(int i11) {
            return i11;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        f6134c = new a(defaultConstructorMarker);
        b.a aVar = b.f6139a;
        f6135d = new o(aVar.a(), false, defaultConstructorMarker);
        f6136e = new o(aVar.b(), true, defaultConstructorMarker);
    }

    public o(int i11, boolean z11) {
        this.f6137a = i11;
        this.f6138b = z11;
    }

    public /* synthetic */ o(int i11, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, z11);
    }

    public final int b() {
        return this.f6137a;
    }

    public final boolean c() {
        return this.f6138b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return b.e(this.f6137a, oVar.f6137a) && this.f6138b == oVar.f6138b;
    }

    public int hashCode() {
        return (b.f(this.f6137a) * 31) + androidx.compose.foundation.e.a(this.f6138b);
    }

    public String toString() {
        if (Intrinsics.b(this, f6135d)) {
            return "TextMotion.Static";
        }
        return Intrinsics.b(this, f6136e) ? "TextMotion.Animated" : "Invalid";
    }
}
