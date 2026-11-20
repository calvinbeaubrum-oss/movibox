package androidx.compose.runtime.snapshots;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class t<K, V> implements c0, Map<K, V>, KMutableMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e0 f3699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Map.Entry<K, V>> f3700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<K> f3701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Collection<V> f3702d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a<K, V> extends e0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public s1.g<K, ? extends V> f3703c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3704d;

        public a(s1.g<K, ? extends V> gVar) {
            this.f3703c = gVar;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public void c(e0 e0Var) {
            Intrinsics.e(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord, V of androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord>");
            a aVar = (a) e0Var;
            synchronized (u.f3705a) {
                this.f3703c = aVar.f3703c;
                this.f3704d = aVar.f3704d;
                Unit unit = Unit.f68710a;
            }
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public e0 d() {
            return new a(this.f3703c);
        }

        public final s1.g<K, V> i() {
            return this.f3703c;
        }

        public final int j() {
            return this.f3704d;
        }

        public final void k(s1.g<K, ? extends V> gVar) {
            this.f3703c = gVar;
        }

        public final void l(int i11) {
            this.f3704d = i11;
        }
    }

    public t() {
        s1.g gVarA = s1.a.a();
        a aVar = new a(gVarA);
        if (j.f3684e.e()) {
            a aVar2 = new a(gVarA);
            aVar2.h(1);
            aVar.g(aVar2);
        }
        this.f3699a = aVar;
        this.f3700b = new n(this);
        this.f3701c = new o(this);
        this.f3702d = new q(this);
    }

    public Set<Map.Entry<K, V>> a() {
        return this.f3700b;
    }

    public Set<K> c() {
        return this.f3701c;
    }

    @Override // java.util.Map
    public void clear() {
        j jVarC;
        e0 firstStateRecord = getFirstStateRecord();
        Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        a aVar = (a) SnapshotKt.F((a) firstStateRecord);
        aVar.i();
        s1.g<K, V> gVarA = s1.a.a();
        if (gVarA != aVar.i()) {
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.e(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                jVarC = j.f3684e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, jVarC);
                synchronized (u.f3705a) {
                    aVar3.k(gVarA);
                    aVar3.l(aVar3.j() + 1);
                }
            }
            SnapshotKt.Q(jVarC, this);
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return e().i().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return e().i().containsValue(obj);
    }

    public final int d() {
        return e().j();
    }

    public final a<K, V> e() {
        e0 firstStateRecord = getFirstStateRecord();
        Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return (a) SnapshotKt.X((a) firstStateRecord, this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return a();
    }

    public int f() {
        return e().i().size();
    }

    public Collection<V> g() {
        return this.f3702d;
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return e().i().get(obj);
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public e0 getFirstStateRecord() {
        return this.f3699a;
    }

    public final boolean i(V v11) {
        Object next;
        Iterator<T> it = entrySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.b(((Map.Entry) next).getValue(), v11));
        Map.Entry entry = (Map.Entry) next;
        if (entry == null) {
            return false;
        }
        remove(entry.getKey());
        return true;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return e().i().isEmpty();
    }

    public final Map<K, V> j() {
        return e().i();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return c();
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public /* synthetic */ e0 mergeRecords(e0 e0Var, e0 e0Var2, e0 e0Var3) {
        return b0.a(this, e0Var, e0Var2, e0Var3);
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public void prependStateRecord(e0 e0Var) {
        Intrinsics.e(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        this.f3699a = (a) e0Var;
    }

    @Override // java.util.Map
    public V put(K k11, V v11) {
        s1.g<K, V> gVarI;
        int iJ;
        V vPut;
        j jVarC;
        boolean z11;
        do {
            synchronized (u.f3705a) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                gVarI = aVar.i();
                iJ = aVar.j();
                Unit unit = Unit.f68710a;
            }
            Intrinsics.d(gVarI);
            s1.g.a<K, V> aVarQ = gVarI.q();
            vPut = aVarQ.put(k11, v11);
            s1.g<K, V> gVarBuild = aVarQ.build();
            if (Intrinsics.b(gVarBuild, gVarI)) {
                break;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.e(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                jVarC = j.f3684e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, jVarC);
                synchronized (u.f3705a) {
                    if (aVar3.j() == iJ) {
                        aVar3.k(gVarBuild);
                        z11 = true;
                        aVar3.l(aVar3.j() + 1);
                    } else {
                        z11 = false;
                    }
                }
            }
            SnapshotKt.Q(jVarC, this);
        } while (!z11);
        return vPut;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0077 */
    @Override // java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void putAll(Map<? extends K, ? extends V> map) {
        s1.g<K, V> gVarI;
        int iJ;
        j jVarC;
        boolean z11;
        do {
            synchronized (u.f3705a) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                gVarI = aVar.i();
                iJ = aVar.j();
                Unit unit = Unit.f68710a;
            }
            Intrinsics.d(gVarI);
            s1.g.a<K, V> aVarQ = gVarI.q();
            aVarQ.putAll(map);
            s1.g<K, V> gVarBuild = aVarQ.build();
            if (Intrinsics.b(gVarBuild, gVarI)) {
                return;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.e(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                jVarC = j.f3684e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, jVarC);
                synchronized (u.f3705a) {
                    try {
                        if (aVar3.j() == iJ) {
                            aVar3.k(gVarBuild);
                            z11 = true;
                            aVar3.l(aVar3.j() + 1);
                        } else {
                            z11 = false;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            SnapshotKt.Q(jVarC, this);
        } while (!z11);
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        s1.g<K, V> gVarI;
        int iJ;
        V vRemove;
        j jVarC;
        boolean z11;
        do {
            synchronized (u.f3705a) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                gVarI = aVar.i();
                iJ = aVar.j();
                Unit unit = Unit.f68710a;
            }
            Intrinsics.d(gVarI);
            s1.g.a<K, V> aVarQ = gVarI.q();
            vRemove = aVarQ.remove(obj);
            s1.g<K, V> gVarBuild = aVarQ.build();
            if (Intrinsics.b(gVarBuild, gVarI)) {
                break;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.e(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                jVarC = j.f3684e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, jVarC);
                synchronized (u.f3705a) {
                    if (aVar3.j() == iJ) {
                        aVar3.k(gVarBuild);
                        z11 = true;
                        aVar3.l(aVar3.j() + 1);
                    } else {
                        z11 = false;
                    }
                }
            }
            SnapshotKt.Q(jVarC, this);
        } while (!z11);
        return vRemove;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return f();
    }

    public String toString() {
        e0 firstStateRecord = getFirstStateRecord();
        Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return "SnapshotStateMap(value=" + ((a) SnapshotKt.F((a) firstStateRecord)).i() + ")@" + hashCode();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return g();
    }
}
