package androidx.collection;

import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f1918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1921d;

    @JvmOverloads
    public e() {
        this(0, 1, null);
    }

    @JvmOverloads
    public e(int i11) {
        if (!(i11 >= 1)) {
            m1.d.a("capacity must be >= 1");
        }
        if (!(i11 <= 1073741824)) {
            m1.d.a("capacity must be <= 2^30");
        }
        i11 = Integer.bitCount(i11) != 1 ? Integer.highestOneBit(i11 - 1) << 1 : i11;
        this.f1921d = i11 - 1;
        this.f1918a = new int[i11];
    }

    public /* synthetic */ e(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 8 : i11);
    }

    public final void a(int i11) {
        int[] iArr = this.f1918a;
        int i12 = this.f1920c;
        iArr[i12] = i11;
        int i13 = this.f1921d & (i12 + 1);
        this.f1920c = i13;
        if (i13 == this.f1919b) {
            c();
        }
    }

    public final void b() {
        this.f1920c = this.f1919b;
    }

    public final void c() {
        int[] iArr = this.f1918a;
        int length = iArr.length;
        int i11 = this.f1919b;
        int i12 = length - i11;
        int i13 = length << 1;
        if (i13 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i13];
        ArraysKt___ArraysJvmKt.j(iArr, iArr2, 0, i11, length);
        ArraysKt___ArraysJvmKt.j(this.f1918a, iArr2, i12, 0, this.f1919b);
        this.f1918a = iArr2;
        this.f1919b = 0;
        this.f1920c = length;
        this.f1921d = i13 - 1;
    }

    public final boolean d() {
        return this.f1919b == this.f1920c;
    }

    public final int e() {
        int i11 = this.f1919b;
        if (i11 == this.f1920c) {
            f fVar = f.f1922a;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i12 = this.f1918a[i11];
        this.f1919b = (i11 + 1) & this.f1921d;
        return i12;
    }
}
