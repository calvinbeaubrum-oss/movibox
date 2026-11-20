package androidx.compose.runtime.snapshots;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
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
public final class n<K, V> extends p<K, V, Map.Entry<K, V>> {
    public n(t<K, V> tVar) {
        super(tVar);
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return ((Boolean) f((Map.Entry) obj)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return ((Boolean) g(collection)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (TypeIntrinsics.m(obj)) {
            return i((Map.Entry) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        Collection<? extends Object> collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Void f(Map.Entry<K, V> entry) {
        u.b();
        throw new KotlinNothingValueException();
    }

    public Void g(Collection<? extends Map.Entry<K, V>> collection) {
        u.b();
        throw new KotlinNothingValueException();
    }

    public boolean i(Map.Entry<K, V> entry) {
        return Intrinsics.b(a().get(entry.getKey()), entry.getValue());
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new x(a(), ((s1.e) a().e().i().entrySet()).iterator());
    }

    public boolean j(Map.Entry<K, V> entry) {
        return a().remove(entry.getKey()) != null;
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean remove(Object obj) {
        if (TypeIntrinsics.m(obj)) {
            return j((Map.Entry) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        Iterator<? extends Object> it = collection.iterator();
        while (true) {
            boolean z11 = false;
            while (it.hasNext()) {
                if (a().remove(((Map.Entry) it.next()).getKey()) != null || z11) {
                    z11 = true;
                }
            }
            return z11;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        s1.g<K, V> gVarI;
        int iJ;
        boolean z11;
        j jVarC;
        Collection<? extends Object> collection2 = collection;
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.a.d(kotlin.collections.r.e(kotlin.collections.h.v(collection2, 10)), 16));
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Pair pairA = TuplesKt.a(entry.getKey(), entry.getValue());
            linkedHashMap.put(pairA.getFirst(), pairA.getSecond());
        }
        t<K, V> tVarA = a();
        boolean z12 = false;
        do {
            synchronized (u.f3705a) {
                e0 firstStateRecord = tVarA.getFirstStateRecord();
                Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                t.a aVar = (t.a) SnapshotKt.F((t.a) firstStateRecord);
                gVarI = aVar.i();
                iJ = aVar.j();
                Unit unit = Unit.f68710a;
            }
            Intrinsics.d(gVarI);
            s1.g.a<K, V> aVarQ = gVarI.q();
            Iterator<Map.Entry<K, V>> it2 = tVarA.entrySet().iterator();
            while (true) {
                z11 = true;
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry<K, V> next = it2.next();
                if (!linkedHashMap.containsKey(next.getKey()) || !Intrinsics.b(linkedHashMap.get(next.getKey()), next.getValue())) {
                    aVarQ.remove(next.getKey());
                    z12 = true;
                }
            }
            Unit unit2 = Unit.f68710a;
            s1.g<K, V> gVarBuild = aVarQ.build();
            if (Intrinsics.b(gVarBuild, gVarI)) {
                break;
            }
            e0 firstStateRecord2 = tVarA.getFirstStateRecord();
            Intrinsics.e(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            t.a aVar2 = (t.a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                jVarC = j.f3684e.c();
                t.a aVar3 = (t.a) SnapshotKt.h0(aVar2, tVarA, jVarC);
                synchronized (u.f3705a) {
                    if (aVar3.j() == iJ) {
                        aVar3.k(gVarBuild);
                        aVar3.l(aVar3.j() + 1);
                    } else {
                        z11 = false;
                    }
                }
            }
            SnapshotKt.Q(jVarC, tVarA);
        } while (!z11);
        return z12;
    }
}
