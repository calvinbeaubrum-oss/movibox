package androidx.work;

import android.net.Uri;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.w;
import kotlin.jvm.JvmField;
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
public final class b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0124b f13283i = new C0124b(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @JvmField
    public static final b f13284j = new b(null, false, false, false, false, 0, 0, null, 255, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetworkType f13285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f13286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f13287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f13288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f13289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f13290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f13291g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<c> f13292h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f13294b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f13296d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f13297e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public NetworkType f13295c = NetworkType.NOT_REQUIRED;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f13298f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f13299g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Set<c> f13300h = new LinkedHashSet();

        public final b a() {
            Set setF;
            long j11;
            long j12;
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 24) {
                setF = CollectionsKt___CollectionsKt.O0(this.f13300h);
                j11 = this.f13298f;
                j12 = this.f13299g;
            } else {
                setF = w.f();
                j11 = -1;
                j12 = -1;
            }
            return new b(this.f13295c, this.f13293a, i11 >= 23 && this.f13294b, this.f13296d, this.f13297e, j11, j12, setF);
        }

        public final a b(NetworkType networkType) {
            Intrinsics.g(networkType, "networkType");
            this.f13295c = networkType;
            return this;
        }
    }

    /* JADX INFO: renamed from: androidx.work.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0124b {
        public C0124b() {
        }

        public /* synthetic */ C0124b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f13301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f13302b;

        public c(Uri uri, boolean z11) {
            Intrinsics.g(uri, "uri");
            this.f13301a = uri;
            this.f13302b = z11;
        }

        public final Uri a() {
            return this.f13301a;
        }

        public final boolean b() {
            return this.f13302b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.b(c.class, obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.e(obj, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
            c cVar = (c) obj;
            return Intrinsics.b(this.f13301a, cVar.f13301a) && this.f13302b == cVar.f13302b;
        }

        public int hashCode() {
            return (this.f13301a.hashCode() * 31) + androidx.compose.foundation.e.a(this.f13302b);
        }
    }

    public b() {
        this(null, false, false, false, false, 0L, 0L, null, 255, null);
    }

    public b(NetworkType requiredNetworkType, boolean z11, boolean z12, boolean z13, boolean z14, long j11, long j12, Set<c> contentUriTriggers) {
        Intrinsics.g(requiredNetworkType, "requiredNetworkType");
        Intrinsics.g(contentUriTriggers, "contentUriTriggers");
        this.f13285a = requiredNetworkType;
        this.f13286b = z11;
        this.f13287c = z12;
        this.f13288d = z13;
        this.f13289e = z14;
        this.f13290f = j11;
        this.f13291g = j12;
        this.f13292h = contentUriTriggers;
    }

    public /* synthetic */ b(NetworkType networkType, boolean z11, boolean z12, boolean z13, boolean z14, long j11, long j12, Set set, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i11 & 2) != 0 ? false : z11, (i11 & 4) != 0 ? false : z12, (i11 & 8) != 0 ? false : z13, (i11 & 16) == 0 ? z14 : false, (i11 & 32) != 0 ? -1L : j11, (i11 & 64) == 0 ? j12 : -1L, (i11 & 128) != 0 ? w.f() : set);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(b other) {
        Intrinsics.g(other, "other");
        boolean z11 = other.f13286b;
        boolean z12 = other.f13287c;
        this(other.f13285a, z11, z12, other.f13288d, other.f13289e, other.f13290f, other.f13291g, other.f13292h);
    }

    public final long a() {
        return this.f13291g;
    }

    public final long b() {
        return this.f13290f;
    }

    public final Set<c> c() {
        return this.f13292h;
    }

    public final NetworkType d() {
        return this.f13285a;
    }

    public final boolean e() {
        return !this.f13292h.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.b(b.class, obj.getClass())) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f13286b == bVar.f13286b && this.f13287c == bVar.f13287c && this.f13288d == bVar.f13288d && this.f13289e == bVar.f13289e && this.f13290f == bVar.f13290f && this.f13291g == bVar.f13291g && this.f13285a == bVar.f13285a) {
            return Intrinsics.b(this.f13292h, bVar.f13292h);
        }
        return false;
    }

    public final boolean f() {
        return this.f13288d;
    }

    public final boolean g() {
        return this.f13286b;
    }

    @RequiresApi(23)
    public final boolean h() {
        return this.f13287c;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.f13285a.hashCode() * 31) + (this.f13286b ? 1 : 0)) * 31) + (this.f13287c ? 1 : 0)) * 31) + (this.f13288d ? 1 : 0)) * 31) + (this.f13289e ? 1 : 0)) * 31;
        long j11 = this.f13290f;
        int i11 = (iHashCode + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        long j12 = this.f13291g;
        return ((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + this.f13292h.hashCode();
    }

    public final boolean i() {
        return this.f13289e;
    }
}
