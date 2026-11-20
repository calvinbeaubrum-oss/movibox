package o2;

import androidx.compose.ui.text.platform.p;
import androidx.compose.ui.text.platform.q;
import java.util.HashMap;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;

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
public class b<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f72262a = p.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<K, V> f72263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<K> f72264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f72265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f72266e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f72267f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f72268g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f72269h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f72270i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f72271j;

    public b(int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        this.f72266e = i11;
        this.f72263b = new HashMap<>(0, 0.75f);
        this.f72264c = new LinkedHashSet<>();
    }

    public V b(K k11) {
        return null;
    }

    public void c(boolean z11, K k11, V v11, V v12) {
    }

    public final V d(K k11) {
        synchronized (this.f72262a) {
            V v11 = this.f72263b.get(k11);
            if (v11 != null) {
                this.f72264c.remove(k11);
                this.f72264c.add(k11);
                this.f72270i++;
                return v11;
            }
            this.f72271j++;
            V vB = b(k11);
            if (vB == null) {
                return null;
            }
            synchronized (this.f72262a) {
                try {
                    this.f72268g++;
                    V vPut = this.f72263b.put(k11, vB);
                    this.f72264c.remove(k11);
                    this.f72264c.add(k11);
                    if (vPut != null) {
                        this.f72263b.put(k11, vPut);
                        v11 = vPut;
                    } else {
                        this.f72265d = h() + g(k11, vB);
                    }
                    Unit unit = Unit.f68710a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (v11 != null) {
                c(false, k11, vB, v11);
                return v11;
            }
            j(this.f72266e);
            return vB;
        }
    }

    public final V e(K k11, V v11) {
        V vPut;
        if (k11 == null || v11 == null) {
            throw null;
        }
        synchronized (this.f72262a) {
            try {
                this.f72267f++;
                this.f72265d = h() + g(k11, v11);
                vPut = this.f72263b.put(k11, v11);
                if (vPut != null) {
                    this.f72265d = h() - g(k11, vPut);
                }
                if (this.f72264c.contains(k11)) {
                    this.f72264c.remove(k11);
                }
                this.f72264c.add(k11);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (vPut != null) {
            c(false, k11, vPut, v11);
        }
        j(this.f72266e);
        return vPut;
    }

    public final V f(K k11) {
        V vRemove;
        k11.getClass();
        synchronized (this.f72262a) {
            try {
                vRemove = this.f72263b.remove(k11);
                this.f72264c.remove(k11);
                if (vRemove != null) {
                    this.f72265d = h() - g(k11, vRemove);
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (vRemove != null) {
            c(false, k11, vRemove, null);
        }
        return vRemove;
    }

    public final int g(K k11, V v11) {
        int i11 = i(k11, v11);
        if (i11 >= 0) {
            return i11;
        }
        throw new IllegalStateException(("Negative size: " + k11 + '=' + v11).toString());
    }

    @JvmName
    public final int h() {
        int i11;
        synchronized (this.f72262a) {
            i11 = this.f72265d;
        }
        return i11;
    }

    public int i(K k11, V v11) {
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j(int i11) {
        Object objD0;
        V v11;
        while (true) {
            synchronized (this.f72262a) {
                try {
                    if (h() >= 0 && (!this.f72263b.isEmpty() || h() == 0)) {
                        if (this.f72263b.isEmpty() != this.f72264c.isEmpty()) {
                            break;
                        }
                        if (h() <= i11 || this.f72263b.isEmpty()) {
                            objD0 = null;
                            v11 = null;
                        } else {
                            objD0 = CollectionsKt___CollectionsKt.d0(this.f72264c);
                            v11 = this.f72263b.get(objD0);
                            if (v11 == null) {
                                throw new IllegalStateException("inconsistent state");
                            }
                            TypeIntrinsics.d(this.f72263b).remove(objD0);
                            TypeIntrinsics.a(this.f72264c).remove(objD0);
                            int iH = h();
                            Intrinsics.d(objD0);
                            Intrinsics.d(v11);
                            this.f72265d = iH - g(objD0, v11);
                            this.f72269h++;
                        }
                        Unit unit = Unit.f68710a;
                    } else {
                        break;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (objD0 == null && v11 == null) {
                return;
            }
            Intrinsics.d(objD0);
            Intrinsics.d(v11);
            c(true, objD0, v11, null);
        }
        throw new IllegalStateException("map/keySet size inconsistency");
    }

    public String toString() {
        String str;
        synchronized (this.f72262a) {
            try {
                int i11 = this.f72270i;
                int i12 = this.f72271j + i11;
                str = "LruCache[maxSize=" + this.f72266e + ",hits=" + this.f72270i + ",misses=" + this.f72271j + ",hitRate=" + (i12 != 0 ? (i11 * 100) / i12 : 0) + "%]";
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return str;
    }
}
