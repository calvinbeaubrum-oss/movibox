package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.lifecycle.LiveData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public class InvalidationTracker {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f12733q = new a(null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String[] f12734r = {"UPDATE", "DELETE", "INSERT"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f12735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f12736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Set<String>> f12737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Integer> f12738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f12739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.room.c f12740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f12741g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f12742h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile g6.k f12743i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f12744j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l f12745k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i1.b<c, d> f12746l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public p f12747m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f12748n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Object f12749o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @JvmField
    public final Runnable f12750p;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(g6.g database) {
            Intrinsics.g(database, "database");
            if (database.r0()) {
                database.K();
            } else {
                database.A();
            }
        }

        public final String b(String tableName, String triggerType) {
            Intrinsics.g(tableName, "tableName");
            Intrinsics.g(triggerType, "triggerType");
            return "`room_table_modification_trigger_" + tableName + '_' + triggerType + '`';
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f12751e = new a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f12752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f12753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f12754c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f12755d;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public b(int i11) {
            this.f12752a = new long[i11];
            this.f12753b = new boolean[i11];
            this.f12754c = new int[i11];
        }

        @JvmName
        public final int[] a() {
            synchronized (this) {
                try {
                    if (!this.f12755d) {
                        return null;
                    }
                    long[] jArr = this.f12752a;
                    int length = jArr.length;
                    int i11 = 0;
                    int i12 = 0;
                    while (i11 < length) {
                        int i13 = i12 + 1;
                        int i14 = 1;
                        boolean z11 = jArr[i11] > 0;
                        boolean[] zArr = this.f12753b;
                        if (z11 != zArr[i12]) {
                            int[] iArr = this.f12754c;
                            if (!z11) {
                                i14 = 2;
                            }
                            iArr[i12] = i14;
                        } else {
                            this.f12754c[i12] = 0;
                        }
                        zArr[i12] = z11;
                        i11++;
                        i12 = i13;
                    }
                    this.f12755d = false;
                    return (int[]) this.f12754c.clone();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public final boolean b(int... tableIds) {
            boolean z11;
            Intrinsics.g(tableIds, "tableIds");
            synchronized (this) {
                try {
                    z11 = false;
                    for (int i11 : tableIds) {
                        long[] jArr = this.f12752a;
                        long j11 = jArr[i11];
                        jArr[i11] = 1 + j11;
                        if (j11 == 0) {
                            z11 = true;
                            this.f12755d = true;
                        }
                    }
                    Unit unit = Unit.f68710a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return z11;
        }

        public final boolean c(int... tableIds) {
            boolean z11;
            Intrinsics.g(tableIds, "tableIds");
            synchronized (this) {
                try {
                    z11 = false;
                    for (int i11 : tableIds) {
                        long[] jArr = this.f12752a;
                        long j11 = jArr[i11];
                        jArr[i11] = j11 - 1;
                        if (j11 == 1) {
                            z11 = true;
                            this.f12755d = true;
                        }
                    }
                    Unit unit = Unit.f68710a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return z11;
        }

        public final void d() {
            synchronized (this) {
                Arrays.fill(this.f12753b, false);
                this.f12755d = true;
                Unit unit = Unit.f68710a;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f12756a;

        public c(String[] tables) {
            Intrinsics.g(tables, "tables");
            this.f12756a = tables;
        }

        public final String[] a() {
            return this.f12756a;
        }

        public boolean b() {
            return false;
        }

        public abstract void c(Set<String> set);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f12757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f12758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String[] f12759c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Set<String> f12760d;

        public d(c observer, int[] tableIds, String[] tableNames) {
            Intrinsics.g(observer, "observer");
            Intrinsics.g(tableIds, "tableIds");
            Intrinsics.g(tableNames, "tableNames");
            this.f12757a = observer;
            this.f12758b = tableIds;
            this.f12759c = tableNames;
            this.f12760d = (tableNames.length == 0) ^ true ? kotlin.collections.v.d(tableNames[0]) : kotlin.collections.w.f();
            if (tableIds.length != tableNames.length) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        public final int[] a() {
            return this.f12758b;
        }

        public final void b(Set<Integer> invalidatedTablesIds) {
            Set<String> setF;
            Intrinsics.g(invalidatedTablesIds, "invalidatedTablesIds");
            int[] iArr = this.f12758b;
            int length = iArr.length;
            if (length != 0) {
                int i11 = 0;
                if (length != 1) {
                    Set setB = kotlin.collections.v.b();
                    int[] iArr2 = this.f12758b;
                    int length2 = iArr2.length;
                    int i12 = 0;
                    while (i11 < length2) {
                        int i13 = i12 + 1;
                        if (invalidatedTablesIds.contains(Integer.valueOf(iArr2[i11]))) {
                            setB.add(this.f12759c[i12]);
                        }
                        i11++;
                        i12 = i13;
                    }
                    setF = kotlin.collections.v.a(setB);
                } else {
                    setF = invalidatedTablesIds.contains(Integer.valueOf(iArr[0])) ? this.f12760d : kotlin.collections.w.f();
                }
            } else {
                setF = kotlin.collections.w.f();
            }
            if (!setF.isEmpty()) {
                this.f12757a.c(setF);
            }
        }

        public final void c(String[] tables) {
            Set<String> setF;
            Intrinsics.g(tables, "tables");
            int length = this.f12759c.length;
            if (length == 0) {
                setF = kotlin.collections.w.f();
            } else if (length == 1) {
                int length2 = tables.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length2) {
                        setF = kotlin.collections.w.f();
                        break;
                    } else {
                        if (kotlin.text.l.v(tables[i11], this.f12759c[0], true)) {
                            setF = this.f12760d;
                            break;
                        }
                        i11++;
                    }
                }
            } else {
                Set setB = kotlin.collections.v.b();
                for (String str : tables) {
                    for (String str2 : this.f12759c) {
                        if (kotlin.text.l.v(str2, str, true)) {
                            setB.add(str2);
                        }
                    }
                }
                setF = kotlin.collections.v.a(setB);
            }
            if (!setF.isEmpty()) {
                this.f12757a.c(setF);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InvalidationTracker f12761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakReference<c> f12762c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(InvalidationTracker tracker, c delegate) {
            super(delegate.a());
            Intrinsics.g(tracker, "tracker");
            Intrinsics.g(delegate, "delegate");
            this.f12761b = tracker;
            this.f12762c = new WeakReference<>(delegate);
        }

        @Override // androidx.room.InvalidationTracker.c
        public void c(Set<String> tables) {
            Intrinsics.g(tables, "tables");
            c cVar = this.f12762c.get();
            if (cVar == null) {
                this.f12761b.p(this);
            } else {
                cVar.c(tables);
            }
        }
    }

    public InvalidationTracker(RoomDatabase database, Map<String, String> shadowTablesMap, Map<String, Set<String>> viewTables, String... tableNames) {
        String lowerCase;
        Intrinsics.g(database, "database");
        Intrinsics.g(shadowTablesMap, "shadowTablesMap");
        Intrinsics.g(viewTables, "viewTables");
        Intrinsics.g(tableNames, "tableNames");
        this.f12735a = database;
        this.f12736b = shadowTablesMap;
        this.f12737c = viewTables;
        this.f12741g = new AtomicBoolean(false);
        this.f12744j = new b(tableNames.length);
        this.f12745k = new l(database);
        this.f12746l = new i1.b<>();
        this.f12748n = new Object();
        this.f12749o = new Object();
        this.f12738d = new LinkedHashMap();
        int length = tableNames.length;
        String[] strArr = new String[length];
        for (int i11 = 0; i11 < length; i11++) {
            String str = tableNames[i11];
            Locale US = Locale.US;
            Intrinsics.f(US, "US");
            String lowerCase2 = str.toLowerCase(US);
            Intrinsics.f(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            this.f12738d.put(lowerCase2, Integer.valueOf(i11));
            String str2 = this.f12736b.get(tableNames[i11]);
            if (str2 != null) {
                Intrinsics.f(US, "US");
                lowerCase = str2.toLowerCase(US);
                Intrinsics.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr[i11] = lowerCase2;
        }
        this.f12739e = strArr;
        for (Map.Entry<String, String> entry : this.f12736b.entrySet()) {
            String value = entry.getValue();
            Locale US2 = Locale.US;
            Intrinsics.f(US2, "US");
            String lowerCase3 = value.toLowerCase(US2);
            Intrinsics.f(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
            if (this.f12738d.containsKey(lowerCase3)) {
                String key = entry.getKey();
                Intrinsics.f(US2, "US");
                String lowerCase4 = key.toLowerCase(US2);
                Intrinsics.f(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
                Map<String, Integer> map = this.f12738d;
                map.put(lowerCase4, (Integer) kotlin.collections.s.i(map, lowerCase3));
            }
        }
        this.f12750p = new Runnable() { // from class: androidx.room.InvalidationTracker$refreshRunnable$1
            private final Set<Integer> checkUpdatedTable() {
                InvalidationTracker invalidationTracker = this.this$0;
                Set setB = kotlin.collections.v.b();
                Cursor cursorB = RoomDatabase.B(invalidationTracker.h(), new g6.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"), null, 2, null);
                while (cursorB.moveToNext()) {
                    try {
                        setB.add(Integer.valueOf(cursorB.getInt(0)));
                    } catch (Throwable th2) {
                        try {
                            throw th2;
                        } catch (Throwable th3) {
                            CloseableKt.a(cursorB, th2);
                            throw th3;
                        }
                    }
                }
                Unit unit = Unit.f68710a;
                CloseableKt.a(cursorB, null);
                Set<Integer> setA = kotlin.collections.v.a(setB);
                if (!setA.isEmpty()) {
                    if (this.this$0.g() == null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    g6.k kVarG = this.this$0.g();
                    if (kVarG == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    kVarG.F();
                }
                return setA;
            }

            @Override // java.lang.Runnable
            public void run() {
                Set<Integer> setF;
                c cVar;
                Lock lockL = this.this$0.h().l();
                lockL.lock();
                try {
                    try {
                        if (!this.this$0.f()) {
                            lockL.unlock();
                            c cVar2 = this.this$0.f12740f;
                            if (cVar2 != null) {
                                cVar2.e();
                                return;
                            }
                            return;
                        }
                        if (!this.this$0.j().compareAndSet(true, false)) {
                            lockL.unlock();
                            c cVar3 = this.this$0.f12740f;
                            if (cVar3 != null) {
                                cVar3.e();
                                return;
                            }
                            return;
                        }
                        if (this.this$0.h().t()) {
                            lockL.unlock();
                            c cVar4 = this.this$0.f12740f;
                            if (cVar4 != null) {
                                cVar4.e();
                                return;
                            }
                            return;
                        }
                        g6.g writableDatabase = this.this$0.h().n().getWritableDatabase();
                        writableDatabase.K();
                        try {
                            setF = checkUpdatedTable();
                            writableDatabase.I();
                            writableDatabase.L();
                            lockL.unlock();
                            cVar = this.this$0.f12740f;
                            if (cVar != null) {
                                cVar.e();
                            }
                            if (!setF.isEmpty()) {
                                i1.b<InvalidationTracker.c, InvalidationTracker.d> bVarI = this.this$0.i();
                                InvalidationTracker invalidationTracker = this.this$0;
                                synchronized (bVarI) {
                                    try {
                                        Iterator<Map.Entry<K, V>> it = invalidationTracker.i().iterator();
                                        while (it.hasNext()) {
                                            ((InvalidationTracker.d) ((Map.Entry) it.next()).getValue()).b(setF);
                                        }
                                        Unit unit = Unit.f68710a;
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            writableDatabase.L();
                            throw th3;
                        }
                    } catch (Throwable th4) {
                        lockL.unlock();
                        c cVar5 = this.this$0.f12740f;
                        if (cVar5 != null) {
                            cVar5.e();
                        }
                        throw th4;
                    }
                } catch (SQLiteException e11) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e11);
                    setF = kotlin.collections.w.f();
                    lockL.unlock();
                    cVar = this.this$0.f12740f;
                    if (cVar != null) {
                    }
                } catch (IllegalStateException e12) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e12);
                    setF = kotlin.collections.w.f();
                    lockL.unlock();
                    cVar = this.this$0.f12740f;
                    if (cVar != null) {
                    }
                }
            }
        };
    }

    @SuppressLint({"RestrictedApi"})
    public void c(c observer) {
        d dVarI;
        Intrinsics.g(observer, "observer");
        String[] strArrQ = q(observer.a());
        ArrayList arrayList = new ArrayList(strArrQ.length);
        for (String str : strArrQ) {
            Map<String, Integer> map = this.f12738d;
            Locale US = Locale.US;
            Intrinsics.f(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Integer num = map.get(lowerCase);
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
            arrayList.add(Integer.valueOf(num.intValue()));
        }
        int[] iArrI0 = CollectionsKt___CollectionsKt.I0(arrayList);
        d dVar = new d(observer, iArrI0, strArrQ);
        synchronized (this.f12746l) {
            dVarI = this.f12746l.i(observer, dVar);
        }
        if (dVarI == null && this.f12744j.b(Arrays.copyOf(iArrI0, iArrI0.length))) {
            v();
        }
    }

    public void d(c observer) {
        Intrinsics.g(observer, "observer");
        c(new e(this, observer));
    }

    public <T> LiveData<T> e(String[] tableNames, boolean z11, Callable<T> computeFunction) {
        Intrinsics.g(tableNames, "tableNames");
        Intrinsics.g(computeFunction, "computeFunction");
        return this.f12745k.a(x(tableNames), z11, computeFunction);
    }

    public final boolean f() {
        if (!this.f12735a.z()) {
            return false;
        }
        if (!this.f12742h) {
            this.f12735a.n().getWritableDatabase();
        }
        if (this.f12742h) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public final g6.k g() {
        return this.f12743i;
    }

    public final RoomDatabase h() {
        return this.f12735a;
    }

    public final i1.b<c, d> i() {
        return this.f12746l;
    }

    public final AtomicBoolean j() {
        return this.f12741g;
    }

    public final Map<String, Integer> k() {
        return this.f12738d;
    }

    public final void l(g6.g database) {
        Intrinsics.g(database, "database");
        synchronized (this.f12749o) {
            if (this.f12742h) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            database.E("PRAGMA temp_store = MEMORY;");
            database.E("PRAGMA recursive_triggers='ON';");
            database.E("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            w(database);
            this.f12743i = database.S("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
            this.f12742h = true;
            Unit unit = Unit.f68710a;
        }
    }

    public final void m(String... tables) {
        Intrinsics.g(tables, "tables");
        synchronized (this.f12746l) {
            try {
                Iterator<Map.Entry<K, V>> it = this.f12746l.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Intrinsics.f(entry, "(observer, wrapper)");
                    c cVar = (c) entry.getKey();
                    d dVar = (d) entry.getValue();
                    if (!cVar.b()) {
                        dVar.c(tables);
                    }
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void n() {
        synchronized (this.f12749o) {
            this.f12742h = false;
            this.f12744j.d();
            g6.k kVar = this.f12743i;
            if (kVar != null) {
                kVar.close();
                Unit unit = Unit.f68710a;
            }
        }
    }

    public void o() {
        if (this.f12741g.compareAndSet(false, true)) {
            androidx.room.c cVar = this.f12740f;
            if (cVar != null) {
                cVar.j();
            }
            this.f12735a.o().execute(this.f12750p);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void p(c observer) {
        d dVarJ;
        Intrinsics.g(observer, "observer");
        synchronized (this.f12746l) {
            dVarJ = this.f12746l.j(observer);
        }
        if (dVarJ != null) {
            b bVar = this.f12744j;
            int[] iArrA = dVarJ.a();
            if (bVar.c(Arrays.copyOf(iArrA, iArrA.length))) {
                v();
            }
        }
    }

    public final String[] q(String[] strArr) {
        Set setB = kotlin.collections.v.b();
        for (String str : strArr) {
            Map<String, Set<String>> map = this.f12737c;
            Locale US = Locale.US;
            Intrinsics.f(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                Map<String, Set<String>> map2 = this.f12737c;
                Intrinsics.f(US, "US");
                String lowerCase2 = str.toLowerCase(US);
                Intrinsics.f(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                Set<String> set = map2.get(lowerCase2);
                Intrinsics.d(set);
                setB.addAll(set);
            } else {
                setB.add(str);
            }
        }
        Object[] array = kotlin.collections.v.a(setB).toArray(new String[0]);
        Intrinsics.e(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    public final void r(androidx.room.c autoCloser) {
        Intrinsics.g(autoCloser, "autoCloser");
        this.f12740f = autoCloser;
        autoCloser.l(new Runnable() { // from class: androidx.room.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f12863a.n();
            }
        });
    }

    public final void s(Context context, String name, Intent serviceIntent) {
        Intrinsics.g(context, "context");
        Intrinsics.g(name, "name");
        Intrinsics.g(serviceIntent, "serviceIntent");
        this.f12747m = new p(context, name, serviceIntent, this, this.f12735a.o());
    }

    public final void t(g6.g gVar, int i11) {
        gVar.E("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i11 + ", 0)");
        String str = this.f12739e[i11];
        for (String str2 : f12734r) {
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + f12733q.b(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i11 + " AND invalidated = 0; END";
            Intrinsics.f(str3, "StringBuilder().apply(builderAction).toString()");
            gVar.E(str3);
        }
    }

    public final void u(g6.g gVar, int i11) {
        String str = this.f12739e[i11];
        for (String str2 : f12734r) {
            String str3 = "DROP TRIGGER IF EXISTS " + f12733q.b(str, str2);
            Intrinsics.f(str3, "StringBuilder().apply(builderAction).toString()");
            gVar.E(str3);
        }
    }

    public final void v() {
        if (this.f12735a.z()) {
            w(this.f12735a.n().getWritableDatabase());
        }
    }

    public final void w(g6.g database) {
        Intrinsics.g(database, "database");
        if (database.n0()) {
            return;
        }
        try {
            Lock lockL = this.f12735a.l();
            lockL.lock();
            try {
                synchronized (this.f12748n) {
                    int[] iArrA = this.f12744j.a();
                    if (iArrA == null) {
                        lockL.unlock();
                        return;
                    }
                    f12733q.a(database);
                    try {
                        int length = iArrA.length;
                        int i11 = 0;
                        int i12 = 0;
                        while (i11 < length) {
                            int i13 = iArrA[i11];
                            int i14 = i12 + 1;
                            if (i13 == 1) {
                                t(database, i12);
                            } else if (i13 == 2) {
                                u(database, i12);
                            }
                            i11++;
                            i12 = i14;
                        }
                        database.I();
                        database.L();
                        Unit unit = Unit.f68710a;
                        lockL.unlock();
                    } catch (Throwable th2) {
                        database.L();
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                lockL.unlock();
                throw th3;
            }
        } catch (SQLiteException e11) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e11);
        } catch (IllegalStateException e12) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e12);
        }
    }

    public final String[] x(String[] strArr) {
        String[] strArrQ = q(strArr);
        for (String str : strArrQ) {
            Map<String, Integer> map = this.f12738d;
            Locale US = Locale.US;
            Intrinsics.f(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (!map.containsKey(lowerCase)) {
                throw new IllegalArgumentException(("There is no table with name " + str).toString());
            }
        }
        return strArrQ;
    }
}
