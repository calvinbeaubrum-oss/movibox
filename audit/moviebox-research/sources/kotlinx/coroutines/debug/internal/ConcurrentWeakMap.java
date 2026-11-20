package kotlinx.coroutines.debug.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class ConcurrentWeakMap<K, V> extends AbstractMutableMap<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f69265b = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69266c = AtomicReferenceFieldUpdater.newUpdater(ConcurrentWeakMap.class, Object.class, "core$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReferenceQueue<K> f69267a;
    private volatile /* synthetic */ Object core$volatile;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f69268g = AtomicIntegerFieldUpdater.newUpdater(a.class, "load$volatile");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f69269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f69270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f69271c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AtomicReferenceArray f69272d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AtomicReferenceArray f69273e;
        private volatile /* synthetic */ int load$volatile;

        /* JADX INFO: renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @SourceDebugExtension
        public final class C0742a<E> implements Iterator<E>, KMutableIterator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Function2<K, V, E> f69275a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f69276b = -1;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public K f69277c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public V f69278d;

            /* JADX WARN: Multi-variable type inference failed */
            public C0742a(Function2<? super K, ? super V, ? extends E> function2) {
                this.f69275a = function2;
                a();
            }

            public final void a() {
                K k11;
                while (true) {
                    int i11 = this.f69276b + 1;
                    this.f69276b = i11;
                    if (i11 >= a.this.f69269a) {
                        return;
                    }
                    e eVar = (e) a.this.e().get(this.f69276b);
                    if (eVar != null && (k11 = (K) eVar.get()) != null) {
                        this.f69277c = k11;
                        Object obj = (V) a.this.g().get(this.f69276b);
                        if (obj instanceof f) {
                            obj = (V) ((f) obj).f69311a;
                        }
                        if (obj != null) {
                            this.f69278d = (V) obj;
                            return;
                        }
                    }
                }
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Void remove() {
                kotlinx.coroutines.debug.internal.a.e();
                throw new KotlinNothingValueException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f69276b < a.this.f69269a;
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
            @Override // java.util.Iterator
            public E next() {
                if (this.f69276b >= a.this.f69269a) {
                    throw new NoSuchElementException();
                }
                Function2<K, V, E> function2 = this.f69275a;
                K k11 = this.f69277c;
                if (k11 == false) {
                    Intrinsics.y("key");
                    k11 = (K) Unit.f68710a;
                }
                V v11 = this.f69278d;
                if (v11 == false) {
                    Intrinsics.y(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                    v11 = (V) Unit.f68710a;
                }
                E e11 = (E) function2.invoke(k11, v11);
                a();
                return e11;
            }
        }

        public a(int i11) {
            this.f69269a = i11;
            this.f69270b = Integer.numberOfLeadingZeros(i11) + 1;
            this.f69271c = (i11 * 2) / 3;
            this.f69272d = new AtomicReferenceArray(i11);
            this.f69273e = new AtomicReferenceArray(i11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object k(a aVar, Object obj, Object obj2, e eVar, int i11, Object obj3) {
            if ((i11 & 4) != 0) {
                eVar = null;
            }
            return aVar.j(obj, obj2, eVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final V d(K k11) {
            int iH = h(k11.hashCode());
            while (true) {
                e eVar = (e) e().get(iH);
                if (eVar == null) {
                    return null;
                }
                T t11 = eVar.get();
                if (Intrinsics.b(k11, t11)) {
                    V v11 = (V) g().get(iH);
                    return v11 instanceof f ? (V) ((f) v11).f69311a : v11;
                }
                if (t11 == 0) {
                    m(iH);
                }
                if (iH == 0) {
                    iH = this.f69269a;
                }
                iH--;
            }
        }

        public final /* synthetic */ AtomicReferenceArray e() {
            return this.f69272d;
        }

        public final /* synthetic */ AtomicReferenceArray g() {
            return this.f69273e;
        }

        public final int h(int i11) {
            return (i11 * (-1640531527)) >>> this.f69270b;
        }

        public final <E> Iterator<E> i(Function2<? super K, ? super V, ? extends E> function2) {
            return new C0742a(function2);
        }

        public final Object j(K k11, V v11, e<K> eVar) {
            int i11;
            Object obj;
            int iH = h(k11.hashCode());
            boolean z11 = false;
            while (true) {
                e eVar2 = (e) e().get(iH);
                if (eVar2 != null) {
                    T t11 = eVar2.get();
                    if (Intrinsics.b(k11, t11)) {
                        if (!z11) {
                            break;
                        }
                        f69268g.decrementAndGet(this);
                        break;
                    }
                    if (t11 == 0) {
                        m(iH);
                    }
                    if (iH == 0) {
                        iH = this.f69269a;
                    }
                    iH--;
                } else if (v11 != null) {
                    if (!z11) {
                        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f69268g;
                        do {
                            i11 = atomicIntegerFieldUpdater.get(this);
                            if (i11 >= this.f69271c) {
                                return kotlinx.coroutines.debug.internal.a.f69284a;
                            }
                        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i11, i11 + 1));
                        z11 = true;
                    }
                    if (eVar == null) {
                        eVar = new e<>(k11, ConcurrentWeakMap.this.f69267a);
                    }
                    if (kotlinx.coroutines.channels.f.a(e(), iH, null, eVar)) {
                        break;
                    }
                } else {
                    return null;
                }
            }
            do {
                obj = g().get(iH);
                if (obj instanceof f) {
                    return kotlinx.coroutines.debug.internal.a.f69284a;
                }
            } while (!kotlinx.coroutines.channels.f.a(g(), iH, obj, v11));
            return obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final ConcurrentWeakMap<K, V>.a l() {
            Object obj;
            while (true) {
                ConcurrentWeakMap<K, V>.a aVar = (ConcurrentWeakMap<K, V>.a) ConcurrentWeakMap.this.new a(Integer.highestOneBit(kotlin.ranges.a.d(ConcurrentWeakMap.this.size(), 4)) * 4);
                int i11 = this.f69269a;
                for (int i12 = 0; i12 < i11; i12++) {
                    e eVar = (e) e().get(i12);
                    Object obj2 = eVar != null ? eVar.get() : null;
                    if (eVar != null && obj2 == null) {
                        m(i12);
                    }
                    do {
                        obj = g().get(i12);
                        if (obj instanceof f) {
                            obj = ((f) obj).f69311a;
                            break;
                        }
                    } while (!kotlinx.coroutines.channels.f.a(g(), i12, obj, kotlinx.coroutines.debug.internal.a.d(obj)));
                    if (obj2 == null || obj == null || aVar.j(obj2, obj, eVar) != kotlinx.coroutines.debug.internal.a.f69284a) {
                    }
                }
                return aVar;
            }
        }

        public final void m(int i11) {
            Object obj;
            do {
                obj = g().get(i11);
                if (obj == null || (obj instanceof f)) {
                    return;
                }
            } while (!kotlinx.coroutines.channels.f.a(g(), i11, obj, null));
            ConcurrentWeakMap.this.j();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f69280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f69281b;

        public b(K k11, V v11) {
            this.f69280a = k11;
            this.f69281b = v11;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f69280a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f69281b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v11) {
            kotlinx.coroutines.debug.internal.a.e();
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class c<E> extends AbstractMutableSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function2<K, V, E> f69282a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function2<? super K, ? super V, ? extends E> function2) {
            this.f69282a = function2;
        }

        @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e11) {
            kotlinx.coroutines.debug.internal.a.e();
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.collections.AbstractMutableSet
        public int getSize() {
            return ConcurrentWeakMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return ((a) ConcurrentWeakMap.k().get(ConcurrentWeakMap.this)).i(this.f69282a);
        }
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    public ConcurrentWeakMap(boolean z11) {
        this.core$volatile = new a(16);
        this.f69267a = z11 ? new ReferenceQueue<>() : null;
    }

    public /* synthetic */ ConcurrentWeakMap(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11);
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater k() {
        return f69266c;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<Map.Entry<K, V>> a() {
        return new c(new Function2<K, V, Map.Entry<K, V>>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$entries$1
            @Override // kotlin.jvm.functions.Function2
            public final Map.Entry<K, V> invoke(K k11, V v11) {
                return new ConcurrentWeakMap.b(k11, v11);
            }
        });
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<K> c() {
        return new c(new Function2<K, V, K>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$keys$1
            @Override // kotlin.jvm.functions.Function2
            public final K invoke(K k11, V v11) {
                return k11;
            }
        });
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int d() {
        return f69265b.get(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        return (V) ((a) f69266c.get(this)).d(obj);
    }

    public final void j() {
        f69265b.decrementAndGet(this);
    }

    public final synchronized V m(K k11, V v11) {
        V v12;
        a aVarL = (a) f69266c.get(this);
        while (true) {
            v12 = (V) a.k(aVarL, k11, v11, null, 4, null);
            if (v12 == kotlinx.coroutines.debug.internal.a.f69284a) {
                aVarL = aVarL.l();
                f69266c.set(this, aVarL);
            }
        }
        return v12;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k11, V v11) {
        V vM = (V) a.k((a) f69266c.get(this), k11, v11, null, 4, null);
        if (vM == kotlinx.coroutines.debug.internal.a.f69284a) {
            vM = m(k11, v11);
        }
        if (vM == null) {
            f69265b.incrementAndGet(this);
        }
        return vM;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj == 0) {
            return null;
        }
        V vM = (V) a.k((a) f69266c.get(this), obj, null, null, 4, null);
        if (vM == kotlinx.coroutines.debug.internal.a.f69284a) {
            vM = m(obj, null);
        }
        if (vM != null) {
            f69265b.decrementAndGet(this);
        }
        return vM;
    }
}
