package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

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
@Metadata
public final class LongProgressionIterator extends LongIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f68974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f68975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f68976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f68977d;

    public LongProgressionIterator(long j11, long j12, long j13) {
        this.f68974a = j13;
        this.f68975b = j12;
        boolean z11 = true;
        if (j13 <= 0 ? j11 < j12 : j11 > j12) {
            z11 = false;
        }
        this.f68976c = z11;
        this.f68977d = z11 ? j11 : j12;
    }

    @Override // kotlin.collections.LongIterator
    public long a() {
        long j11 = this.f68977d;
        if (j11 != this.f68975b) {
            this.f68977d = this.f68974a + j11;
        } else {
            if (!this.f68976c) {
                throw new NoSuchElementException();
            }
            this.f68976c = false;
        }
        return j11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f68976c;
    }
}
