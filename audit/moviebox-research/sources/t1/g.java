package t1;

import java.util.ConcurrentModificationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

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
public class g<K, V, T> extends e<K, V, T> implements KMutableIterator {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f<K, V> f76685d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public K f76686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f76687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f76688h;

    public g(f<K, V> fVar, u<K, V, T>[] uVarArr) {
        super(fVar.i(), uVarArr);
        this.f76685d = fVar;
        this.f76688h = fVar.g();
    }

    private final void j() {
        if (this.f76685d.g() != this.f76688h) {
            throw new ConcurrentModificationException();
        }
    }

    public final void k() {
        if (!this.f76687g) {
            throw new IllegalStateException();
        }
    }

    public final void l(int i11, t<?, ?> tVar, K k11, int i12) {
        int i13 = i12 * 5;
        if (i13 > 30) {
            f()[i12].m(tVar.p(), tVar.p().length, 0);
            while (!Intrinsics.b(f()[i12].a(), k11)) {
                f()[i12].j();
            }
            i(i12);
            return;
        }
        int iF = 1 << x.f(i11, i13);
        if (tVar.q(iF)) {
            f()[i12].m(tVar.p(), tVar.m() * 2, tVar.n(iF));
            i(i12);
        } else {
            int iO = tVar.O(iF);
            t<?, ?> tVarN = tVar.N(iO);
            f()[i12].m(tVar.p(), tVar.m() * 2, iO);
            l(i11, tVarN, k11, i12 + 1);
        }
    }

    public final void m(K k11, V v11) {
        if (this.f76685d.containsKey(k11)) {
            if (hasNext()) {
                K kC = c();
                this.f76685d.put(k11, v11);
                l(kC != null ? kC.hashCode() : 0, this.f76685d.i(), kC, 0);
            } else {
                this.f76685d.put(k11, v11);
            }
            this.f76688h = this.f76685d.g();
        }
    }

    @Override // t1.e, java.util.Iterator
    public T next() {
        j();
        this.f76686f = c();
        this.f76687g = true;
        return (T) super.next();
    }

    @Override // t1.e, java.util.Iterator
    public void remove() {
        k();
        if (hasNext()) {
            K kC = c();
            TypeIntrinsics.d(this.f76685d).remove(this.f76686f);
            l(kC != null ? kC.hashCode() : 0, this.f76685d.i(), kC, 0);
        } else {
            TypeIntrinsics.d(this.f76685d).remove(this.f76686f);
        }
        this.f76686f = null;
        this.f76687g = false;
        this.f76688h = this.f76685d.g();
    }
}
