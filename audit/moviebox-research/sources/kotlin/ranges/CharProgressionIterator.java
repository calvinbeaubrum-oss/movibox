package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;

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
public final class CharProgressionIterator extends CharIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f68954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f68955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f68956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f68957d;

    public CharProgressionIterator(char c11, char c12, int i11) {
        this.f68954a = i11;
        this.f68955b = c12;
        boolean z11 = true;
        if (i11 <= 0 ? Intrinsics.i(c11, c12) < 0 : Intrinsics.i(c11, c12) > 0) {
            z11 = false;
        }
        this.f68956c = z11;
        this.f68957d = z11 ? c11 : c12;
    }

    @Override // kotlin.collections.CharIterator
    public char a() {
        int i11 = this.f68957d;
        if (i11 != this.f68955b) {
            this.f68957d = this.f68954a + i11;
        } else {
            if (!this.f68956c) {
                throw new NoSuchElementException();
            }
            this.f68956c = false;
        }
        return (char) i11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f68956c;
    }
}
