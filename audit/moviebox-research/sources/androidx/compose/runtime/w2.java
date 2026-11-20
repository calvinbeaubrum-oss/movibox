package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
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
public final class w2 implements Iterator<w1.b>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j2 f3739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l0 f3741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x2 f3742d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3744g;

    public w2(j2 j2Var, int i11, l0 l0Var, x2 x2Var) {
        this.f3739a = j2Var;
        this.f3740b = i11;
        this.f3741c = l0Var;
        this.f3742d = x2Var;
        this.f3743f = j2Var.A();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public w1.b next() {
        Object obj;
        ArrayList<Object> arrayListC = this.f3741c.c();
        if (arrayListC != null) {
            int i11 = this.f3744g;
            this.f3744g = i11 + 1;
            obj = arrayListC.get(i11);
        } else {
            obj = null;
        }
        if (obj instanceof c) {
            return new k2(this.f3739a, ((c) obj).a(), this.f3743f);
        }
        if (obj instanceof l0) {
            return new y2(this.f3739a, this.f3740b, (l0) obj, new z1(this.f3742d, this.f3744g - 1));
        }
        k.t("Unexpected group information structure");
        throw new KotlinNothingValueException();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        ArrayList<Object> arrayListC = this.f3741c.c();
        return arrayListC != null && this.f3744g < arrayListC.size();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
