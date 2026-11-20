package androidx.collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
public class x<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final m1.b lock;
    private final m1.c<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public x(int i11) {
        this.maxSize = i11;
        if (!(i11 > 0)) {
            m1.d.a("maxSize <= 0");
        }
        this.map = new m1.c<>(0, 0.75f);
        this.lock = new m1.b();
    }

    private final int safeSizeOf(K k11, V v11) {
        int iSizeOf = sizeOf(k11, v11);
        if (!(iSizeOf >= 0)) {
            m1.d.b("Negative size: " + k11 + '=' + v11);
        }
        return iSizeOf;
    }

    public V create(K key) {
        Intrinsics.g(key, "key");
        return null;
    }

    public final int createCount() {
        int i11;
        synchronized (this.lock) {
            i11 = this.createCount;
        }
        return i11;
    }

    public void entryRemoved(boolean z11, K key, V oldValue, V v11) {
        Intrinsics.g(key, "key");
        Intrinsics.g(oldValue, "oldValue");
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        int i11;
        synchronized (this.lock) {
            i11 = this.evictionCount;
        }
        return i11;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final V get(K key) {
        V v11;
        Intrinsics.g(key, "key");
        synchronized (this.lock) {
            V vA = this.map.a(key);
            if (vA != null) {
                this.hitCount++;
                return vA;
            }
            this.missCount++;
            V vCreate = create(key);
            if (vCreate == null) {
                return null;
            }
            synchronized (this.lock) {
                try {
                    this.createCount++;
                    v11 = (V) this.map.d(key, vCreate);
                    if (v11 != null) {
                        this.map.d(key, v11);
                    } else {
                        this.size += safeSizeOf(key, vCreate);
                        Unit unit = Unit.f68710a;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (v11 != null) {
                entryRemoved(false, key, vCreate, v11);
                return v11;
            }
            trimToSize(this.maxSize);
            return vCreate;
        }
    }

    public final int hitCount() {
        int i11;
        synchronized (this.lock) {
            i11 = this.hitCount;
        }
        return i11;
    }

    public final int maxSize() {
        int i11;
        synchronized (this.lock) {
            i11 = this.maxSize;
        }
        return i11;
    }

    public final int missCount() {
        int i11;
        synchronized (this.lock) {
            i11 = this.missCount;
        }
        return i11;
    }

    public final V put(K key, V value) {
        V vD;
        Intrinsics.g(key, "key");
        Intrinsics.g(value, "value");
        synchronized (this.lock) {
            try {
                this.putCount++;
                this.size += safeSizeOf(key, value);
                vD = this.map.d(key, value);
                if (vD != null) {
                    this.size -= safeSizeOf(key, vD);
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (vD != null) {
            entryRemoved(false, key, vD, value);
        }
        trimToSize(this.maxSize);
        return vD;
    }

    public final int putCount() {
        int i11;
        synchronized (this.lock) {
            i11 = this.putCount;
        }
        return i11;
    }

    public final V remove(K key) {
        V vE;
        Intrinsics.g(key, "key");
        synchronized (this.lock) {
            try {
                vE = this.map.e(key);
                if (vE != null) {
                    this.size -= safeSizeOf(key, vE);
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (vE != null) {
            entryRemoved(false, key, vE, null);
        }
        return vE;
    }

    public void resize(int i11) {
        if (!(i11 > 0)) {
            m1.d.a("maxSize <= 0");
        }
        synchronized (this.lock) {
            this.maxSize = i11;
            Unit unit = Unit.f68710a;
        }
        trimToSize(i11);
    }

    public final int size() {
        int i11;
        synchronized (this.lock) {
            i11 = this.size;
        }
        return i11;
    }

    public int sizeOf(K key, V value) {
        Intrinsics.g(key, "key");
        Intrinsics.g(value, "value");
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap;
        synchronized (this.lock) {
            linkedHashMap = new LinkedHashMap(this.map.b().size());
            Iterator<T> it = this.map.b().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public String toString() {
        String str;
        synchronized (this.lock) {
            try {
                int i11 = this.hitCount;
                int i12 = this.missCount + i11;
                str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + (i12 != 0 ? (i11 * 100) / i12 : 0) + "%]";
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void trimToSize(int i11) {
        Object key;
        Object value;
        while (true) {
            synchronized (this.lock) {
                try {
                    if (!(this.size >= 0 && (!this.map.c() || this.size == 0))) {
                        m1.d.b("LruCache.sizeOf() is reporting inconsistent results!");
                    }
                    if (this.size <= i11 || this.map.c()) {
                        break;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) CollectionsKt___CollectionsKt.f0(this.map.b());
                    if (entry == null) {
                        return;
                    }
                    key = entry.getKey();
                    value = entry.getValue();
                    this.map.e((K) key);
                    this.size -= safeSizeOf(key, value);
                    this.evictionCount++;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            entryRemoved(true, key, value, null);
        }
    }
}
