package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import g6.i;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class e implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteProgram f12995a;

    public e(SQLiteProgram delegate) {
        Intrinsics.g(delegate, "delegate");
        this.f12995a = delegate;
    }

    @Override // g6.i
    public void V(int i11, long j11) {
        this.f12995a.bindLong(i11, j11);
    }

    @Override // g6.i
    public void c0(int i11, byte[] value) {
        Intrinsics.g(value, "value");
        this.f12995a.bindBlob(i11, value);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f12995a.close();
    }

    @Override // g6.i
    public void f(int i11, double d11) {
        this.f12995a.bindDouble(i11, d11);
    }

    @Override // g6.i
    public void m0(int i11) {
        this.f12995a.bindNull(i11);
    }

    @Override // g6.i
    public void s(int i11, String value) {
        Intrinsics.g(value, "value");
        this.f12995a.bindString(i11, value);
    }
}
