package b20;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
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
public final class e implements Iterator<ULong>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f13945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f13946d;

    public e(long j11, long j12, long j13) {
        this.f13943a = j12;
        boolean z11 = true;
        if (j13 <= 0 ? Long.compare(j11 ^ Long.MIN_VALUE, j12 ^ Long.MIN_VALUE) < 0 : Long.compare(j11 ^ Long.MIN_VALUE, j12 ^ Long.MIN_VALUE) > 0) {
            z11 = false;
        }
        this.f13944b = z11;
        this.f13945c = ULong.b(j13);
        this.f13946d = this.f13944b ? j11 : j12;
    }

    public /* synthetic */ e(long j11, long j12, long j13, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13);
    }

    public long a() {
        long j11 = this.f13946d;
        if (j11 != this.f13943a) {
            this.f13946d = ULong.b(this.f13945c + j11);
        } else {
            if (!this.f13944b) {
                throw new NoSuchElementException();
            }
            this.f13944b = false;
        }
        return j11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f13944b;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ ULong next() {
        return ULong.a(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
