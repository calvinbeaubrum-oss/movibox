package androidx.compose.runtime.snapshots;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
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
public final class o<K, V> extends p<K, V, K> {
    public o(t<K, V> tVar) {
        super(tVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return ((Boolean) f(obj)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return ((Boolean) g(collection)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return a().containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        Collection<? extends Object> collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!a().containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public Void f(K k11) {
        u.b();
        throw new KotlinNothingValueException();
    }

    public Void g(Collection<? extends K> collection) {
        u.b();
        throw new KotlinNothingValueException();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public z<K, V> iterator() {
        return new z<>(a(), ((s1.e) a().e().i().entrySet()).iterator());
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return a().remove(obj) != null;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        Iterator<T> it = collection.iterator();
        while (true) {
            boolean z11 = false;
            while (it.hasNext()) {
                if (a().remove(it.next()) != null || z11) {
                    z11 = true;
                }
            }
            return z11;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        s1.g<K, V> gVarI;
        int iJ;
        boolean z11;
        j jVarC;
        Set setO0 = CollectionsKt___CollectionsKt.O0(collection);
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
            Iterator<Map.Entry<K, V>> it = tVarA.entrySet().iterator();
            while (true) {
                z11 = true;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<K, V> next = it.next();
                if (!setO0.contains(next.getKey())) {
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
