package yd;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f81320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f81321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f81322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f81323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f81324e;

    /* JADX INFO: renamed from: yd.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0915a extends a<String> {
        public C0915a(int i11, String str, boolean z11) {
            super(null, 0L, i11, str, z11, 3, null);
        }

        public /* synthetic */ C0915a(int i11, String str, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? 1000 : i11, (i12 & 2) != 0 ? "" : str, (i12 & 4) != 0 ? false : z11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b<T> extends a<T> {
        public b(T t11, boolean z11) {
            super(t11, 0L, 200, null, z11, 10, null);
        }

        public /* synthetic */ b(Object obj, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : obj, (i11 & 2) != 0 ? false : z11);
        }
    }

    public a(T t11, long j11, int i11, String str, boolean z11) {
        this.f81320a = t11;
        this.f81321b = j11;
        this.f81322c = i11;
        this.f81323d = str;
        this.f81324e = z11;
    }

    public /* synthetic */ a(Object obj, long j11, int i11, String str, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? null : obj, (i12 & 2) != 0 ? 100L : j11, (i12 & 4) != 0 ? 200 : i11, (i12 & 8) == 0 ? str : null, (i12 & 16) != 0 ? false : z11, null);
    }

    public /* synthetic */ a(Object obj, long j11, int i11, String str, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, j11, i11, str, z11);
    }

    public final T a() {
        return this.f81320a;
    }

    public final int b() {
        return this.f81322c;
    }

    public final String c() {
        return this.f81323d;
    }

    public final boolean d() {
        return this.f81324e;
    }

    public String toString() {
        if (this instanceof b) {
            return "Success[data=" + this.f81320a + ']';
        }
        if (!(this instanceof C0915a)) {
            throw new NoWhenBranchMatchedException();
        }
        return "Failure[errorCode=" + this.f81322c + ", errorMsg=" + this.f81323d + ']';
    }
}
