package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

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
public final class IntProgressionIterator extends IntIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f68964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f68965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f68966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f68967d;

    public IntProgressionIterator(int i11, int i12, int i13) {
        this.f68964a = i13;
        this.f68965b = i12;
        boolean z11 = true;
        if (i13 <= 0 ? i11 < i12 : i11 > i12) {
            z11 = false;
        }
        this.f68966c = z11;
        this.f68967d = z11 ? i11 : i12;
    }

    @Override // kotlin.collections.IntIterator
    public int a() {
        int i11 = this.f68967d;
        if (i11 != this.f68965b) {
            this.f68967d = this.f68964a + i11;
        } else {
            if (!this.f68966c) {
                throw new NoSuchElementException();
            }
            this.f68966c = false;
        }
        return i11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f68966c;
    }
}
