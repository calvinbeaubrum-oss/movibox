package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.o1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableList;

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
public final class SnapshotStateList<T> implements c0, List<T>, RandomAccess, KMutableList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e0 f3614a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a<T> extends e0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public s1.f<? extends T> f3615c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3616d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3617e;

        public a(s1.f<? extends T> fVar) {
            this.f3615c = fVar;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public void c(e0 e0Var) {
            synchronized (s.f3698a) {
                Intrinsics.e(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord.assign$lambda$0>");
                this.f3615c = ((a) e0Var).f3615c;
                this.f3616d = ((a) e0Var).f3616d;
                this.f3617e = ((a) e0Var).f3617e;
                Unit unit = Unit.f68710a;
            }
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public e0 d() {
            return new a(this.f3615c);
        }

        public final s1.f<T> i() {
            return this.f3615c;
        }

        public final int j() {
            return this.f3616d;
        }

        public final int k() {
            return this.f3617e;
        }

        public final void l(s1.f<? extends T> fVar) {
            this.f3615c = fVar;
        }

        public final void m(int i11) {
            this.f3616d = i11;
        }

        public final void n(int i11) {
            this.f3617e = i11;
        }
    }

    public SnapshotStateList() {
        s1.f fVarB = s1.a.b();
        a aVar = new a(fVarB);
        if (j.f3684e.e()) {
            a aVar2 = new a(fVarB);
            aVar2.h(1);
            aVar.g(aVar2);
        }
        this.f3614a = aVar;
    }

    public final a<T> a() {
        e0 firstStateRecord = getFirstStateRecord();
        Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (a) SnapshotKt.X((a) firstStateRecord, this);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0079 */
    @Override // java.util.List
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void add(int i11, T t11) {
        int iJ;
        s1.f<T> fVarI;
        j jVarC;
        boolean z11;
        do {
            synchronized (s.f3698a) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                iJ = aVar.j();
                fVarI = aVar.i();
                Unit unit = Unit.f68710a;
            }
            Intrinsics.d(fVarI);
            s1.f<T> fVarAdd = fVarI.add(i11, t11);
            if (Intrinsics.b(fVarAdd, fVarI)) {
                return;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.e(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                jVarC = j.f3684e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, jVarC);
                synchronized (s.f3698a) {
                    try {
                        if (aVar3.j() == iJ) {
                            aVar3.l(fVarAdd);
                            z11 = true;
                            aVar3.n(aVar3.k() + 1);
                            aVar3.m(aVar3.j() + 1);
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

    /* JADX WARN: Bottom block not found for handler: all -> 0x007b */
    @Override // java.util.List, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean add(T t11) {
        int iJ;
        s1.f<T> fVarI;
        boolean z11;
        j jVarC;
        do {
            synchronized (s.f3698a) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                iJ = aVar.j();
                fVarI = aVar.i();
                Unit unit = Unit.f68710a;
            }
            Intrinsics.d(fVarI);
            s1.f<T> fVarAdd = fVarI.add(t11);
            z11 = false;
            if (Intrinsics.b(fVarAdd, fVarI)) {
                return false;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.e(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                jVarC = j.f3684e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, jVarC);
                synchronized (s.f3698a) {
                    try {
                        if (aVar3.j() == iJ) {
                            aVar3.l(fVarAdd);
                            aVar3.n(aVar3.k() + 1);
                            aVar3.m(aVar3.j() + 1);
                            z11 = true;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            SnapshotKt.Q(jVarC, this);
        } while (!z11);
        return true;
    }

    @Override // java.util.List
    public boolean addAll(final int i11, final Collection<? extends T> collection) {
        return g(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList.addAll.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(List<T> list) {
                return Boolean.valueOf(list.addAll(i11, collection));
            }
        });
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x007b */
    @Override // java.util.List, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean addAll(Collection<? extends T> collection) {
        int iJ;
        s1.f<T> fVarI;
        boolean z11;
        j jVarC;
        do {
            synchronized (s.f3698a) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                iJ = aVar.j();
                fVarI = aVar.i();
                Unit unit = Unit.f68710a;
            }
            Intrinsics.d(fVarI);
            s1.f<T> fVarAddAll = fVarI.addAll(collection);
            z11 = false;
            if (Intrinsics.b(fVarAddAll, fVarI)) {
                return false;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.e(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                jVarC = j.f3684e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, jVarC);
                synchronized (s.f3698a) {
                    try {
                        if (aVar3.j() == iJ) {
                            aVar3.l(fVarAddAll);
                            aVar3.n(aVar3.k() + 1);
                            aVar3.m(aVar3.j() + 1);
                            z11 = true;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            SnapshotKt.Q(jVarC, this);
        } while (!z11);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        j jVarC;
        e0 firstStateRecord = getFirstStateRecord();
        Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        a aVar = (a) firstStateRecord;
        SnapshotKt.J();
        synchronized (SnapshotKt.I()) {
            jVarC = j.f3684e.c();
            a aVar2 = (a) SnapshotKt.h0(aVar, this, jVarC);
            synchronized (s.f3698a) {
                aVar2.l(s1.a.b());
                aVar2.m(aVar2.j() + 1);
                aVar2.n(aVar2.k() + 1);
            }
        }
        SnapshotKt.Q(jVarC, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return a().i().contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        return a().i().containsAll(collection);
    }

    public int e() {
        return a().i().size();
    }

    public final int f() {
        e0 firstStateRecord = getFirstStateRecord();
        Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((a) SnapshotKt.F((a) firstStateRecord)).k();
    }

    public final boolean g(Function1<? super List<T>, Boolean> function1) {
        int iJ;
        s1.f<T> fVarI;
        Boolean boolInvoke;
        j jVarC;
        boolean z11;
        do {
            synchronized (s.f3698a) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                iJ = aVar.j();
                fVarI = aVar.i();
                Unit unit = Unit.f68710a;
            }
            Intrinsics.d(fVarI);
            s1.f.a<T> aVarBuilder = fVarI.builder();
            boolInvoke = function1.invoke(aVarBuilder);
            s1.f<T> fVarBuild = aVarBuilder.build();
            if (Intrinsics.b(fVarBuild, fVarI)) {
                break;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.e(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                jVarC = j.f3684e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, jVarC);
                synchronized (s.f3698a) {
                    if (aVar3.j() == iJ) {
                        aVar3.l(fVarBuild);
                        z11 = true;
                        aVar3.m(aVar3.j() + 1);
                        aVar3.n(aVar3.k() + 1);
                    } else {
                        z11 = false;
                    }
                }
            }
            SnapshotKt.Q(jVarC, this);
        } while (!z11);
        return boolInvoke.booleanValue();
    }

    @Override // java.util.List
    public T get(int i11) {
        return a().i().get(i11);
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public e0 getFirstStateRecord() {
        return this.f3614a;
    }

    public T i(int i11) {
        int iJ;
        s1.f<T> fVarI;
        j jVarC;
        boolean z11;
        T t11 = get(i11);
        do {
            synchronized (s.f3698a) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                iJ = aVar.j();
                fVarI = aVar.i();
                Unit unit = Unit.f68710a;
            }
            Intrinsics.d(fVarI);
            s1.f<T> fVarH = fVarI.h(i11);
            if (Intrinsics.b(fVarH, fVarI)) {
                break;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.e(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                jVarC = j.f3684e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, jVarC);
                synchronized (s.f3698a) {
                    if (aVar3.j() == iJ) {
                        aVar3.l(fVarH);
                        z11 = true;
                        aVar3.n(aVar3.k() + 1);
                        aVar3.m(aVar3.j() + 1);
                    } else {
                        z11 = false;
                    }
                }
            }
            SnapshotKt.Q(jVarC, this);
        } while (!z11);
        return t11;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return a().i().indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return a().i().isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0083 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(int i11, int i12) {
        int iJ;
        s1.f<T> fVarI;
        j jVarC;
        boolean z11;
        do {
            synchronized (s.f3698a) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                iJ = aVar.j();
                fVarI = aVar.i();
                Unit unit = Unit.f68710a;
            }
            Intrinsics.d(fVarI);
            s1.f.a<T> aVarBuilder = fVarI.builder();
            aVarBuilder.subList(i11, i12).clear();
            s1.f<T> fVarBuild = aVarBuilder.build();
            if (Intrinsics.b(fVarBuild, fVarI)) {
                return;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.e(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                jVarC = j.f3684e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, jVarC);
                synchronized (s.f3698a) {
                    try {
                        if (aVar3.j() == iJ) {
                            aVar3.l(fVarBuild);
                            z11 = true;
                            aVar3.m(aVar3.j() + 1);
                            aVar3.n(aVar3.k() + 1);
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

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return a().i().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return new w(this, 0);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i11) {
        return new w(this, i11);
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public /* synthetic */ e0 mergeRecords(e0 e0Var, e0 e0Var2, e0 e0Var3) {
        return b0.a(this, e0Var, e0Var2, e0Var3);
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public void prependStateRecord(e0 e0Var) {
        e0Var.g(getFirstStateRecord());
        Intrinsics.e(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        this.f3614a = (a) e0Var;
    }

    public final int r(Collection<? extends T> collection, int i11, int i12) {
        int iJ;
        s1.f<T> fVarI;
        j jVarC;
        boolean z11;
        int size = size();
        do {
            synchronized (s.f3698a) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                iJ = aVar.j();
                fVarI = aVar.i();
                Unit unit = Unit.f68710a;
            }
            Intrinsics.d(fVarI);
            s1.f.a<T> aVarBuilder = fVarI.builder();
            aVarBuilder.subList(i11, i12).retainAll(collection);
            s1.f<T> fVarBuild = aVarBuilder.build();
            if (Intrinsics.b(fVarBuild, fVarI)) {
                break;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.e(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                jVarC = j.f3684e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, jVarC);
                synchronized (s.f3698a) {
                    if (aVar3.j() == iJ) {
                        aVar3.l(fVarBuild);
                        z11 = true;
                        aVar3.m(aVar3.j() + 1);
                        aVar3.n(aVar3.k() + 1);
                    } else {
                        z11 = false;
                    }
                }
            }
            SnapshotKt.Q(jVarC, this);
        } while (!z11);
        return size - size();
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i11) {
        return i(i11);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x007b */
    @Override // java.util.List, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean remove(Object obj) {
        int iJ;
        s1.f<T> fVarI;
        boolean z11;
        j jVarC;
        do {
            synchronized (s.f3698a) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                iJ = aVar.j();
                fVarI = aVar.i();
                Unit unit = Unit.f68710a;
            }
            Intrinsics.d(fVarI);
            s1.f<T> fVarRemove = fVarI.remove(obj);
            z11 = false;
            if (Intrinsics.b(fVarRemove, fVarI)) {
                return false;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.e(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                jVarC = j.f3684e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, jVarC);
                synchronized (s.f3698a) {
                    try {
                        if (aVar3.j() == iJ) {
                            aVar3.l(fVarRemove);
                            aVar3.n(aVar3.k() + 1);
                            aVar3.m(aVar3.j() + 1);
                            z11 = true;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            SnapshotKt.Q(jVarC, this);
        } while (!z11);
        return true;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x007b */
    @Override // java.util.List, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean removeAll(Collection<? extends Object> collection) {
        int iJ;
        s1.f<T> fVarI;
        boolean z11;
        j jVarC;
        do {
            synchronized (s.f3698a) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                iJ = aVar.j();
                fVarI = aVar.i();
                Unit unit = Unit.f68710a;
            }
            Intrinsics.d(fVarI);
            s1.f<T> fVarRemoveAll = fVarI.removeAll((Collection<? extends T>) collection);
            z11 = false;
            if (Intrinsics.b(fVarRemoveAll, fVarI)) {
                return false;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.e(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                jVarC = j.f3684e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, jVarC);
                synchronized (s.f3698a) {
                    try {
                        if (aVar3.j() == iJ) {
                            aVar3.l(fVarRemoveAll);
                            aVar3.n(aVar3.k() + 1);
                            aVar3.m(aVar3.j() + 1);
                            z11 = true;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            SnapshotKt.Q(jVarC, this);
        } while (!z11);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(final Collection<? extends Object> collection) {
        return g(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList.retainAll.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(List<T> list) {
                return Boolean.valueOf(list.retainAll(collection));
            }
        });
    }

    @Override // java.util.List
    public T set(int i11, T t11) {
        int iJ;
        s1.f<T> fVarI;
        j jVarC;
        boolean z11;
        T t12 = get(i11);
        do {
            synchronized (s.f3698a) {
                e0 firstStateRecord = getFirstStateRecord();
                Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) SnapshotKt.F((a) firstStateRecord);
                iJ = aVar.j();
                fVarI = aVar.i();
                Unit unit = Unit.f68710a;
            }
            Intrinsics.d(fVarI);
            s1.f<T> fVar = fVarI.set(i11, t11);
            if (Intrinsics.b(fVar, fVarI)) {
                break;
            }
            e0 firstStateRecord2 = getFirstStateRecord();
            Intrinsics.e(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) firstStateRecord2;
            SnapshotKt.J();
            synchronized (SnapshotKt.I()) {
                jVarC = j.f3684e.c();
                a aVar3 = (a) SnapshotKt.h0(aVar2, this, jVarC);
                synchronized (s.f3698a) {
                    if (aVar3.j() == iJ) {
                        aVar3.l(fVar);
                        z11 = true;
                        aVar3.m(aVar3.j() + 1);
                    } else {
                        z11 = false;
                    }
                }
            }
            SnapshotKt.Q(jVarC, this);
        } while (!z11);
        return t12;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return e();
    }

    @Override // java.util.List
    public List<T> subList(int i11, int i12) {
        if (!(i11 >= 0 && i11 <= i12 && i12 <= size())) {
            o1.a("fromIndex or toIndex are out of bounds");
        }
        return new f0(this, i11, i12);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.b(this, tArr);
    }

    public String toString() {
        e0 firstStateRecord = getFirstStateRecord();
        Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return "SnapshotStateList(value=" + ((a) SnapshotKt.F((a) firstStateRecord)).i() + ")@" + hashCode();
    }
}
