package kotlin.io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ByteIterator;

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
public final class ByteStreamsKt$iterator$1 extends ByteIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f68827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f68828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f68829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BufferedInputStream f68830d;

    public final void a() throws IOException {
        if (this.f68828b || this.f68829c) {
            return;
        }
        int i11 = this.f68830d.read();
        this.f68827a = i11;
        this.f68828b = true;
        this.f68829c = i11 == -1;
    }

    @Override // kotlin.collections.ByteIterator
    public byte e() throws IOException {
        a();
        if (this.f68829c) {
            throw new NoSuchElementException("Input stream is over.");
        }
        byte b11 = (byte) this.f68827a;
        this.f68828b = false;
        return b11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws IOException {
        a();
        return !this.f68829c;
    }
}
