package b20;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

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
/* JADX INFO: loaded from: classes8.dex */
@SinceKotlin
@Metadata
public final class d implements Iterator<UInt>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13942d;

    public d(int i11, int i12, int i13) {
        this.f13939a = i12;
        boolean z11 = true;
        if (i13 <= 0 ? Integer.compare(i11 ^ Integer.MIN_VALUE, i12 ^ Integer.MIN_VALUE) < 0 : Integer.compare(i11 ^ Integer.MIN_VALUE, i12 ^ Integer.MIN_VALUE) > 0) {
            z11 = false;
        }
        this.f13940b = z11;
        this.f13941c = UInt.b(i13);
        this.f13942d = this.f13940b ? i11 : i12;
    }

    public /* synthetic */ d(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12, i13);
    }

    public int a() {
        int i11 = this.f13942d;
        if (i11 != this.f13939a) {
            this.f13942d = UInt.b(this.f13941c + i11);
        } else {
            if (!this.f13940b) {
                throw new NoSuchElementException();
            }
            this.f13940b = false;
        }
        return i11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f13940b;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ UInt next() {
        return UInt.a(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
