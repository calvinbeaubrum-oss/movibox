package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.CallSuper;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmSuppressWildcards;
import kotlin.jvm.functions.Function1;
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
public abstract class RoomDatabase {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final c f12769o = new c(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public volatile g6.g f12770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f12771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Executor f12772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g6.h f12773d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f12776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public List<? extends b> f12777h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public androidx.room.c f12780k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, Object> f12782m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<Class<?>, Object> f12783n;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InvalidationTracker f12774e = g();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<Class<? extends d6.a>, d6.a> f12778i = new LinkedHashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ReentrantReadWriteLock f12779j = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ThreadLocal<Integer> f12781l = new ThreadLocal<>();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private final boolean isLowRamDevice(ActivityManager activityManager) {
            return g6.c.b(activityManager);
        }

        public final JournalMode resolve$room_runtime_release(Context context) {
            Intrinsics.g(context, "context");
            if (this != AUTOMATIC) {
                return this;
            }
            Object systemService = context.getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            return (activityManager == null || isLowRamDevice(activityManager)) ? TRUNCATE : WRITE_AHEAD_LOGGING;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static class a<T extends RoomDatabase> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f12784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<T> f12785b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f12786c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<b> f12787d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<Object> f12788e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<d6.a> f12789f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Executor f12790g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Executor f12791h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public g6.h.c f12792i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f12793j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public JournalMode f12794k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Intent f12795l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f12796m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f12797n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f12798o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public TimeUnit f12799p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final d f12800q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Set<Integer> f12801r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Set<Integer> f12802s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public String f12803t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public File f12804u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Callable<InputStream> f12805v;

        public a(Context context, Class<T> klass, String str) {
            Intrinsics.g(context, "context");
            Intrinsics.g(klass, "klass");
            this.f12784a = context;
            this.f12785b = klass;
            this.f12786c = str;
            this.f12787d = new ArrayList();
            this.f12788e = new ArrayList();
            this.f12789f = new ArrayList();
            this.f12794k = JournalMode.AUTOMATIC;
            this.f12796m = true;
            this.f12798o = -1L;
            this.f12800q = new d();
            this.f12801r = new LinkedHashSet();
        }

        public a<T> a(b callback) {
            Intrinsics.g(callback, "callback");
            this.f12787d.add(callback);
            return this;
        }

        public a<T> b(d6.b... migrations) {
            Intrinsics.g(migrations, "migrations");
            if (this.f12802s == null) {
                this.f12802s = new HashSet();
            }
            for (d6.b bVar : migrations) {
                Set<Integer> set = this.f12802s;
                Intrinsics.d(set);
                set.add(Integer.valueOf(bVar.f62933a));
                Set<Integer> set2 = this.f12802s;
                Intrinsics.d(set2);
                set2.add(Integer.valueOf(bVar.f62934b));
            }
            this.f12800q.b((d6.b[]) Arrays.copyOf(migrations, migrations.length));
            return this;
        }

        public a<T> c() {
            this.f12793j = true;
            return this;
        }

        public T d() {
            Executor executor = this.f12790g;
            if (executor == null && this.f12791h == null) {
                Executor executorG = h1.c.g();
                this.f12791h = executorG;
                this.f12790g = executorG;
            } else if (executor != null && this.f12791h == null) {
                this.f12791h = executor;
            } else if (executor == null) {
                this.f12790g = this.f12791h;
            }
            Set<Integer> set = this.f12802s;
            if (set != null) {
                Intrinsics.d(set);
                Iterator<Integer> it = set.iterator();
                while (it.hasNext()) {
                    int iIntValue = it.next().intValue();
                    if (!(!this.f12801r.contains(Integer.valueOf(iIntValue)))) {
                        throw new IllegalArgumentException(("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + iIntValue).toString());
                    }
                }
            }
            g6.h.c a0Var = this.f12792i;
            if (a0Var == null) {
                a0Var = new androidx.sqlite.db.framework.d();
            }
            if (a0Var != null) {
                if (this.f12798o > 0) {
                    if (this.f12786c == null) {
                        throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.".toString());
                    }
                    long j11 = this.f12798o;
                    TimeUnit timeUnit = this.f12799p;
                    if (timeUnit == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    Executor executor2 = this.f12790g;
                    if (executor2 == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    a0Var = new androidx.room.d(a0Var, new androidx.room.c(j11, timeUnit, executor2));
                }
                String str = this.f12803t;
                if (str != null || this.f12804u != null || this.f12805v != null) {
                    if (this.f12786c == null) {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.".toString());
                    }
                    int i11 = str == null ? 0 : 1;
                    File file = this.f12804u;
                    int i12 = file == null ? 0 : 1;
                    Callable<InputStream> callable = this.f12805v;
                    if (i11 + i12 + (callable != null ? 1 : 0) != 1) {
                        throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.".toString());
                    }
                    a0Var = new a0(str, file, callable, a0Var);
                }
            } else {
                a0Var = null;
            }
            g6.h.c cVar = a0Var;
            if (cVar == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            Context context = this.f12784a;
            String str2 = this.f12786c;
            d dVar = this.f12800q;
            List<b> list = this.f12787d;
            boolean z11 = this.f12793j;
            JournalMode journalModeResolve$room_runtime_release = this.f12794k.resolve$room_runtime_release(context);
            Executor executor3 = this.f12790g;
            if (executor3 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            Executor executor4 = this.f12791h;
            if (executor4 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            f fVar = new f(context, str2, cVar, dVar, list, z11, journalModeResolve$room_runtime_release, executor3, executor4, this.f12795l, this.f12796m, this.f12797n, this.f12801r, this.f12803t, this.f12804u, this.f12805v, null, this.f12788e, this.f12789f);
            T t11 = (T) r.b(this.f12785b, "_Impl");
            t11.u(fVar);
            return t11;
        }

        public a<T> e() {
            this.f12796m = false;
            this.f12797n = true;
            return this;
        }

        public a<T> f(g6.h.c cVar) {
            this.f12792i = cVar;
            return this;
        }

        public a<T> g(Executor executor) {
            Intrinsics.g(executor, "executor");
            this.f12790g = executor;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static abstract class b {
        public void a(g6.g db2) {
            Intrinsics.g(db2, "db");
        }

        public void b(g6.g db2) {
            Intrinsics.g(db2, "db");
        }

        public void c(g6.g db2) {
            Intrinsics.g(db2, "db");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Integer, TreeMap<Integer, d6.b>> f12806a = new LinkedHashMap();

        public final void a(d6.b bVar) {
            int i11 = bVar.f62933a;
            int i12 = bVar.f62934b;
            Map<Integer, TreeMap<Integer, d6.b>> map = this.f12806a;
            Integer numValueOf = Integer.valueOf(i11);
            TreeMap<Integer, d6.b> treeMap = map.get(numValueOf);
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                map.put(numValueOf, treeMap);
            }
            TreeMap<Integer, d6.b> treeMap2 = treeMap;
            if (treeMap2.containsKey(Integer.valueOf(i12))) {
                Log.w("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(i12)) + " with " + bVar);
            }
            treeMap2.put(Integer.valueOf(i12), bVar);
        }

        public void b(d6.b... migrations) {
            Intrinsics.g(migrations, "migrations");
            for (d6.b bVar : migrations) {
                a(bVar);
            }
        }

        public final boolean c(int i11, int i12) {
            Map<Integer, Map<Integer, d6.b>> mapF = f();
            if (!mapF.containsKey(Integer.valueOf(i11))) {
                return false;
            }
            Map<Integer, d6.b> mapH = mapF.get(Integer.valueOf(i11));
            if (mapH == null) {
                mapH = kotlin.collections.s.h();
            }
            return mapH.containsKey(Integer.valueOf(i12));
        }

        public List<d6.b> d(int i11, int i12) {
            if (i11 == i12) {
                return kotlin.collections.g.l();
            }
            return e(new ArrayList(), i12 > i11, i11, i12);
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0019  */
        /* JADX WARN: Code duplicated, block: B:11:0x001e  */
        /* JADX WARN: Code duplicated, block: B:15:0x002c  */
        /* JADX WARN: Code duplicated, block: B:31:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:36:0x0044 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:38:0x005f A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:40:0x0036 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:9:0x0017 A[DONT_INVERT] */
        public final List<d6.b> e(List<d6.b> list, boolean z11, int i11, int i12) {
            TreeMap<Integer, d6.b> treeMap;
            Set<Integer> setKeySet;
            Iterator<Integer> it;
            boolean z12;
            Integer targetVersion;
            int i13;
            int iIntValue;
            int iIntValue2;
            do {
                if (!z11) {
                    if (i11 <= i12) {
                        return list;
                    }
                    treeMap = this.f12806a.get(Integer.valueOf(i11));
                    if (treeMap == null) {
                        if (z11) {
                            setKeySet = treeMap.descendingKeySet();
                        } else {
                            setKeySet = treeMap.keySet();
                        }
                        it = setKeySet.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                z12 = false;
                                break;
                                break;
                            }
                            targetVersion = it.next();
                            if (!z11) {
                                i13 = i11 + 1;
                                Intrinsics.f(targetVersion, "targetVersion");
                                iIntValue = targetVersion.intValue();
                                if (i13 <= iIntValue) {
                                    continue;
                                }
                            } else {
                                Intrinsics.f(targetVersion, "targetVersion");
                                iIntValue2 = targetVersion.intValue();
                                if (i12 <= iIntValue2) {
                                    continue;
                                }
                            }
                        }
                    } else {
                        return null;
                    }
                } else {
                    if (i11 >= i12) {
                        return list;
                    }
                    treeMap = this.f12806a.get(Integer.valueOf(i11));
                    if (treeMap == null) {
                        if (z11) {
                            setKeySet = treeMap.descendingKeySet();
                        } else {
                            setKeySet = treeMap.keySet();
                        }
                        it = setKeySet.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                z12 = false;
                                break;
                            }
                            targetVersion = it.next();
                            if (!z11) {
                                Intrinsics.f(targetVersion, "targetVersion");
                                iIntValue2 = targetVersion.intValue();
                                if (i12 <= iIntValue2 && iIntValue2 < i11) {
                                    d6.b bVar = treeMap.get(targetVersion);
                                    Intrinsics.d(bVar);
                                    list.add(bVar);
                                    i11 = targetVersion.intValue();
                                    z12 = true;
                                    break;
                                    break;
                                }
                            } else {
                                i13 = i11 + 1;
                                Intrinsics.f(targetVersion, "targetVersion");
                                iIntValue = targetVersion.intValue();
                                if (i13 <= iIntValue && iIntValue <= i12) {
                                    d6.b bVar2 = treeMap.get(targetVersion);
                                    Intrinsics.d(bVar2);
                                    list.add(bVar2);
                                    i11 = targetVersion.intValue();
                                    z12 = true;
                                    break;
                                }
                            }
                        }
                    } else {
                        return null;
                    }
                }
            } while (z12);
            return null;
        }

        public Map<Integer, Map<Integer, d6.b>> f() {
            return this.f12806a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static abstract class e {
    }

    public RoomDatabase() {
        Map<String, Object> mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.f(mapSynchronizedMap, "synchronizedMap(mutableMapOf())");
        this.f12782m = mapSynchronizedMap;
        this.f12783n = new LinkedHashMap();
    }

    public static /* synthetic */ Cursor B(RoomDatabase roomDatabase, g6.j jVar, CancellationSignal cancellationSignal, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
        }
        if ((i11 & 2) != 0) {
            cancellationSignal = null;
        }
        return roomDatabase.A(jVar, cancellationSignal);
    }

    @JvmOverloads
    public Cursor A(g6.j query, CancellationSignal cancellationSignal) {
        Intrinsics.g(query, "query");
        c();
        d();
        return cancellationSignal != null ? n().getWritableDatabase().Y(query, cancellationSignal) : n().getWritableDatabase().X(query);
    }

    public <V> V C(Callable<V> body) {
        Intrinsics.g(body, "body");
        e();
        try {
            V vCall = body.call();
            E();
            return vCall;
        } finally {
            i();
        }
    }

    public void D(Runnable body) {
        Intrinsics.g(body, "body");
        e();
        try {
            body.run();
            E();
        } finally {
            i();
        }
    }

    @Deprecated
    public void E() {
        n().getWritableDatabase().I();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T F(Class<T> cls, g6.h hVar) {
        if (cls.isInstance(hVar)) {
            return hVar;
        }
        if (hVar instanceof g) {
            return (T) F(cls, ((g) hVar).getDelegate());
        }
        return null;
    }

    public void c() {
        if (!this.f12775f && !(!y())) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.".toString());
        }
    }

    public void d() {
        if (!t() && this.f12781l.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.".toString());
        }
    }

    @Deprecated
    public void e() {
        c();
        androidx.room.c cVar = this.f12780k;
        if (cVar == null) {
            v();
        } else {
            cVar.g(new Function1<g6.g, Object>() { // from class: androidx.room.RoomDatabase$beginTransaction$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(g6.g it) {
                    Intrinsics.g(it, "it");
                    this.this$0.v();
                    return null;
                }
            });
        }
    }

    public g6.k f(String sql) {
        Intrinsics.g(sql, "sql");
        c();
        d();
        return n().getWritableDatabase().S(sql);
    }

    public abstract InvalidationTracker g();

    public abstract g6.h h(f fVar);

    @Deprecated
    public void i() {
        androidx.room.c cVar = this.f12780k;
        if (cVar == null) {
            w();
        } else {
            cVar.g(new Function1<g6.g, Object>() { // from class: androidx.room.RoomDatabase$endTransaction$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(g6.g it) {
                    Intrinsics.g(it, "it");
                    this.this$0.w();
                    return null;
                }
            });
        }
    }

    @JvmSuppressWildcards
    public List<d6.b> j(Map<Class<? extends d6.a>, d6.a> autoMigrationSpecs) {
        Intrinsics.g(autoMigrationSpecs, "autoMigrationSpecs");
        return kotlin.collections.g.l();
    }

    public final Map<String, Object> k() {
        return this.f12782m;
    }

    public final Lock l() {
        ReentrantReadWriteLock.ReadLock lock = this.f12779j.readLock();
        Intrinsics.f(lock, "readWriteLock.readLock()");
        return lock;
    }

    public InvalidationTracker m() {
        return this.f12774e;
    }

    public g6.h n() {
        g6.h hVar = this.f12773d;
        if (hVar != null) {
            return hVar;
        }
        Intrinsics.y("internalOpenHelper");
        return null;
    }

    public Executor o() {
        Executor executor = this.f12771b;
        if (executor != null) {
            return executor;
        }
        Intrinsics.y("internalQueryExecutor");
        return null;
    }

    public Set<Class<? extends d6.a>> p() {
        return kotlin.collections.w.f();
    }

    public Map<Class<?>, List<Class<?>>> q() {
        return kotlin.collections.s.h();
    }

    public final ThreadLocal<Integer> r() {
        return this.f12781l;
    }

    public Executor s() {
        Executor executor = this.f12772c;
        if (executor != null) {
            return executor;
        }
        Intrinsics.y("internalTransactionExecutor");
        return null;
    }

    public boolean t() {
        return n().getWritableDatabase().n0();
    }

    @CallSuper
    public void u(f configuration) {
        Intrinsics.g(configuration, "configuration");
        this.f12773d = h(configuration);
        Set<Class<? extends d6.a>> setP = p();
        BitSet bitSet = new BitSet();
        Iterator<Class<? extends d6.a>> it = setP.iterator();
        while (true) {
            int i11 = -1;
            if (it.hasNext()) {
                Class<? extends d6.a> next = it.next();
                int size = configuration.f12857r.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i12 = size - 1;
                        if (next.isAssignableFrom(configuration.f12857r.get(size).getClass())) {
                            bitSet.set(size);
                            i11 = size;
                            break;
                        } else if (i12 < 0) {
                            break;
                        } else {
                            size = i12;
                        }
                    }
                }
                if (i11 < 0) {
                    throw new IllegalArgumentException(("A required auto migration spec (" + next.getCanonicalName() + ") is missing in the database configuration.").toString());
                }
                this.f12778i.put(next, configuration.f12857r.get(i11));
            } else {
                int size2 = configuration.f12857r.size() - 1;
                if (size2 >= 0) {
                    while (true) {
                        int i13 = size2 - 1;
                        if (!bitSet.get(size2)) {
                            throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.".toString());
                        }
                        if (i13 < 0) {
                            break;
                        } else {
                            size2 = i13;
                        }
                    }
                }
                Iterator<d6.b> it2 = j(this.f12778i).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    d6.b next2 = it2.next();
                    if (!configuration.f12843d.c(next2.f62933a, next2.f62934b)) {
                        configuration.f12843d.b(next2);
                    }
                }
                z zVar = (z) F(z.class, n());
                if (zVar != null) {
                    zVar.c(configuration);
                }
                AutoClosingRoomOpenHelper autoClosingRoomOpenHelper = (AutoClosingRoomOpenHelper) F(AutoClosingRoomOpenHelper.class, n());
                if (autoClosingRoomOpenHelper != null) {
                    this.f12780k = autoClosingRoomOpenHelper.f12724b;
                    m().r(autoClosingRoomOpenHelper.f12724b);
                }
                boolean z11 = configuration.f12846g == JournalMode.WRITE_AHEAD_LOGGING;
                n().setWriteAheadLoggingEnabled(z11);
                this.f12777h = configuration.f12844e;
                this.f12771b = configuration.f12847h;
                this.f12772c = new d0(configuration.f12848i);
                this.f12775f = configuration.f12845f;
                this.f12776g = z11;
                if (configuration.f12849j != null) {
                    if (configuration.f12841b == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    m().s(configuration.f12840a, configuration.f12841b, configuration.f12849j);
                }
                Map<Class<?>, List<Class<?>>> mapQ = q();
                BitSet bitSet2 = new BitSet();
                for (Map.Entry<Class<?>, List<Class<?>>> entry : mapQ.entrySet()) {
                    Class<?> key = entry.getKey();
                    for (Class<?> cls : entry.getValue()) {
                        int size3 = configuration.f12856q.size() - 1;
                        if (size3 < 0) {
                            size3 = -1;
                            break;
                        }
                        while (true) {
                            int i14 = size3 - 1;
                            if (cls.isAssignableFrom(configuration.f12856q.get(size3).getClass())) {
                                bitSet2.set(size3);
                                break;
                            } else {
                                if (i14 < 0) {
                                    size3 = -1;
                                    break;
                                }
                                size3 = i14;
                            }
                        }
                        if (size3 < 0) {
                            throw new IllegalArgumentException(("A required type converter (" + cls + ") for " + key.getCanonicalName() + " is missing in the database configuration.").toString());
                        }
                        this.f12783n.put(cls, configuration.f12856q.get(size3));
                    }
                }
                int size4 = configuration.f12856q.size() - 1;
                if (size4 < 0) {
                    return;
                }
                while (true) {
                    int i15 = size4 - 1;
                    if (!bitSet2.get(size4)) {
                        throw new IllegalArgumentException("Unexpected type converter " + configuration.f12856q.get(size4) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                    }
                    if (i15 < 0) {
                        return;
                    } else {
                        size4 = i15;
                    }
                }
            }
        }
    }

    public final void v() {
        c();
        g6.g writableDatabase = n().getWritableDatabase();
        m().w(writableDatabase);
        if (writableDatabase.r0()) {
            writableDatabase.K();
        } else {
            writableDatabase.A();
        }
    }

    public final void w() {
        n().getWritableDatabase().L();
        if (t()) {
            return;
        }
        m().o();
    }

    public void x(g6.g db2) {
        Intrinsics.g(db2, "db");
        m().l(db2);
    }

    public final boolean y() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public final boolean z() {
        g6.g gVar = this.f12770a;
        return gVar != null && gVar.isOpen();
    }
}
