package androidx.compose.runtime;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class k2 implements w1.b, Iterable<w1.b>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j2 f3477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3479c;

    public k2(j2 j2Var, int i11, int i12) {
        this.f3477a = j2Var;
        this.f3478b = i11;
        this.f3479c = i12;
    }

    private final void a() {
        if (this.f3477a.A() != this.f3479c) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<w1.b> iterator() {
        a();
        l0 l0VarI = this.f3477a.I(this.f3478b);
        if (l0VarI != null) {
            j2 j2Var = this.f3477a;
            int i11 = this.f3478b;
            return new w2(j2Var, i11, l0VarI, new d(i11));
        }
        j2 j2Var2 = this.f3477a;
        int i12 = this.f3478b;
        return new j0(j2Var2, i12 + 1, i12 + l2.I(j2Var2.v(), this.f3478b));
    }
}
