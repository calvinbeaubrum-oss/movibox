package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import q2.w;
import q2.x;

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
public final class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f6130c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f6131d = new n(0, 0, 3, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6133b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final n a() {
            return n.f6131d;
        }
    }

    public n(long j11, long j12) {
        this.f6132a = j11;
        this.f6133b = j12;
    }

    public /* synthetic */ n(long j11, long j12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? x.c(0) : j11, (i11 & 2) != 0 ? x.c(0) : j12, null);
    }

    public /* synthetic */ n(long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12);
    }

    public final long b() {
        return this.f6132a;
    }

    public final long c() {
        return this.f6133b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return w.e(this.f6132a, nVar.f6132a) && w.e(this.f6133b, nVar.f6133b);
    }

    public int hashCode() {
        return (w.i(this.f6132a) * 31) + w.i(this.f6133b);
    }

    public String toString() {
        return "TextIndent(firstLine=" + ((Object) w.j(this.f6132a)) + ", restLine=" + ((Object) w.j(this.f6133b)) + ')';
    }
}
