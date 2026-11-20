package mg;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hisavana.common.tracking.TrackingKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class m0 implements mg.d, ng.a, mg.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final cg.c f71055g = cg.c.b("proto");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u0 f71056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final og.a f71057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final og.a f71058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f71059d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u10.a<String> f71060f;

    /* JADX INFO: compiled from: source.java */
    public interface b<T, U> {
        U apply(T t11);
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f71061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f71062b;

        public c(String str, String str2) {
            this.f71061a = str;
            this.f71062b = str2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d<T> {
        T a();
    }

    public m0(og.a aVar, og.a aVar2, e eVar, u0 u0Var, u10.a<String> aVar3) {
        this.f71056a = u0Var;
        this.f71057b = aVar;
        this.f71058c = aVar2;
        this.f71059d = eVar;
        this.f71060f = aVar3;
    }

    public static /* synthetic */ Object A0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    public static /* synthetic */ Object B0(Throwable th2) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th2);
    }

    public static /* synthetic */ SQLiteDatabase C0(Throwable th2) {
        throw new SynchronizationException("Timed out while trying to open db.", th2);
    }

    public static /* synthetic */ Long D0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    public static /* synthetic */ hg.e E0(long j11, Cursor cursor) {
        cursor.moveToNext();
        return hg.e.c().c(cursor.getLong(0)).b(j11).a();
    }

    public static /* synthetic */ hg.e F0(final long j11, SQLiteDatabase sQLiteDatabase) {
        return (hg.e) f1(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new b() { // from class: mg.d0
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return m0.E0(j11, (Cursor) obj);
            }
        });
    }

    public static /* synthetic */ Long G0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    public static /* synthetic */ List I0(SQLiteDatabase sQLiteDatabase) {
        return (List) f1(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new b() { // from class: mg.k0
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return m0.J0((Cursor) obj);
            }
        });
    }

    public static /* synthetic */ List J0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(com.google.android.datatransport.runtime.o.a().b(cursor.getString(1)).d(pg.a.b(cursor.getInt(2))).c(Z0(cursor.getString(3))).a());
        }
        return arrayList;
    }

    public static /* synthetic */ Object O0(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j11 = cursor.getLong(0);
            Set hashSet = (Set) map.get(Long.valueOf(j11));
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(Long.valueOf(j11), hashSet);
            }
            hashSet.add(new c(cursor.getString(1), cursor.getString(2)));
        }
    }

    public static /* synthetic */ byte[] Q0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            length += blob.length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            byte[] bArr2 = (byte[]) arrayList.get(i11);
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }

    public static /* synthetic */ Boolean T0(Cursor cursor) {
        return Boolean.valueOf(cursor.getCount() > 0);
    }

    public static /* synthetic */ Object U0(String str, LogEventDropped.Reason reason, long j11, SQLiteDatabase sQLiteDatabase) {
        if (((Boolean) f1(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.getNumber())}), new b() { // from class: mg.v
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return m0.T0((Cursor) obj);
            }
        })).booleanValue()) {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j11 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.getNumber())});
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(reason.getNumber()));
            contentValues.put("events_dropped_count", Long.valueOf(j11));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
        }
        return null;
    }

    public static /* synthetic */ Object V0(long j11, com.google.android.datatransport.runtime.o oVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j11));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{oVar.b(), String.valueOf(pg.a.a(oVar.d()))}) < 1) {
            contentValues.put("backend_name", oVar.b());
            contentValues.put(TrackingKey.PRIORITY, Integer.valueOf(pg.a.a(oVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    public static byte[] Z0(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    public static cg.c d1(@Nullable String str) {
        return str == null ? f71055g : cg.c.b(str);
    }

    public static String e1(Iterable<k> iterable) {
        StringBuilder sb2 = new StringBuilder("(");
        Iterator<k> it = iterable.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().c());
            if (it.hasNext()) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    public static <T> T f1(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    @Override // mg.d
    public int B() {
        final long jA = this.f71057b.a() - this.f71059d.c();
        return ((Integer) v0(new b() { // from class: mg.j0
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return this.f71048a.z0(jA, (SQLiteDatabase) obj);
            }
        })).intValue();
    }

    @Override // mg.d
    public void C(Iterable<k> iterable) {
        if (iterable.iterator().hasNext()) {
            l0().compileStatement("DELETE FROM events WHERE _id in " + e1(iterable)).execute();
        }
    }

    @Override // mg.d
    public void G(final com.google.android.datatransport.runtime.o oVar, final long j11) {
        v0(new b() { // from class: mg.n
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return m0.V0(j11, oVar, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // mg.d
    public Iterable<com.google.android.datatransport.runtime.o> H() {
        return (Iterable) v0(new b() { // from class: mg.l
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return m0.I0((SQLiteDatabase) obj);
            }
        });
    }

    public final /* synthetic */ Boolean H0(com.google.android.datatransport.runtime.o oVar, SQLiteDatabase sQLiteDatabase) {
        Long lU0 = u0(sQLiteDatabase, oVar);
        return lU0 == null ? Boolean.FALSE : (Boolean) f1(l0().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lU0.toString()}), new b() { // from class: mg.z
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            }
        });
    }

    public final /* synthetic */ List K0(com.google.android.datatransport.runtime.o oVar, SQLiteDatabase sQLiteDatabase) {
        List<k> listX0 = X0(sQLiteDatabase, oVar, this.f71059d.d());
        for (Priority priority : Priority.values()) {
            if (priority != oVar.d()) {
                int iD = this.f71059d.d() - listX0.size();
                if (iD <= 0) {
                    break;
                }
                listX0.addAll(X0(sQLiteDatabase, oVar.f(priority), iD));
            }
        }
        return x0(listX0, Y0(sQLiteDatabase, listX0));
    }

    public final /* synthetic */ hg.a L0(Map map, hg.a.C0695a c0695a, Cursor cursor) {
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            LogEventDropped.Reason reasonH0 = h0(cursor.getInt(1));
            long j11 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(LogEventDropped.c().c(reasonH0).b(j11).a());
        }
        a1(c0695a, map);
        return c0695a.e(t0()).d(p0()).c(this.f71060f.get()).b();
    }

    public final /* synthetic */ hg.a M0(String str, final Map map, final hg.a.C0695a c0695a, SQLiteDatabase sQLiteDatabase) {
        return (hg.a) f1(sQLiteDatabase.rawQuery(str, new String[0]), new b() { // from class: mg.b0
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return this.f71034a.L0(map, c0695a, (Cursor) obj);
            }
        });
    }

    public final /* synthetic */ Object N0(List list, com.google.android.datatransport.runtime.o oVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j11 = cursor.getLong(0);
            boolean z11 = cursor.getInt(7) != 0;
            com.google.android.datatransport.runtime.i.a aVarL = com.google.android.datatransport.runtime.i.a().k(cursor.getString(1)).i(cursor.getLong(2)).l(cursor.getLong(3));
            if (z11) {
                aVarL.h(new com.google.android.datatransport.runtime.h(d1(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                aVarL.h(new com.google.android.datatransport.runtime.h(d1(cursor.getString(4)), b1(j11)));
            }
            if (!cursor.isNull(6)) {
                aVarL.g(Integer.valueOf(cursor.getInt(6)));
            }
            if (!cursor.isNull(8)) {
                aVarL.j(Integer.valueOf(cursor.getInt(8)));
            }
            list.add(k.a(j11, oVar, aVarL.d()));
        }
        return null;
    }

    @Override // mg.d
    public long O(com.google.android.datatransport.runtime.o oVar) {
        return ((Long) f1(l0().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{oVar.b(), String.valueOf(pg.a.a(oVar.d()))}), new b() { // from class: mg.f0
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return m0.D0((Cursor) obj);
            }
        })).longValue();
    }

    @Override // mg.d
    public boolean P(final com.google.android.datatransport.runtime.o oVar) {
        return ((Boolean) v0(new b() { // from class: mg.l0
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return this.f71050a.H0(oVar, (SQLiteDatabase) obj);
            }
        })).booleanValue();
    }

    public final /* synthetic */ Long P0(com.google.android.datatransport.runtime.i iVar, com.google.android.datatransport.runtime.o oVar, SQLiteDatabase sQLiteDatabase) {
        if (w0()) {
            c(1L, LogEventDropped.Reason.CACHE_FULL, iVar.k());
            return -1L;
        }
        long jJ0 = j0(sQLiteDatabase, oVar);
        int iE = this.f71059d.e();
        byte[] bArrA = iVar.e().a();
        boolean z11 = bArrA.length <= iE;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(jJ0));
        contentValues.put("transport_name", iVar.k());
        contentValues.put("timestamp_ms", Long.valueOf(iVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(iVar.l()));
        contentValues.put("payload_encoding", iVar.e().b().a());
        contentValues.put(TrackingKey.CODE, iVar.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z11));
        contentValues.put("payload", z11 ? bArrA : new byte[0]);
        contentValues.put("product_id", iVar.j());
        long jInsert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z11) {
            int iCeil = (int) Math.ceil(((double) bArrA.length) / ((double) iE));
            for (int i11 = 1; i11 <= iCeil; i11++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrA, (i11 - 1) * iE, Math.min(i11 * iE, bArrA.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(jInsert));
                contentValues2.put("sequence_num", Integer.valueOf(i11));
                contentValues2.put("bytes", bArrCopyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry<String, String> entry : iVar.i().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(jInsert));
            contentValues3.put("name", entry.getKey());
            contentValues3.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(jInsert);
    }

    @Override // mg.d
    public void Q(Iterable<k> iterable) {
        if (iterable.iterator().hasNext()) {
            final String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + e1(iterable);
            final String str2 = "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name";
            v0(new b() { // from class: mg.q
                @Override // mg.m0.b
                public final Object apply(Object obj) {
                    return this.f71073a.S0(str, str2, (SQLiteDatabase) obj);
                }
            });
        }
    }

    public final /* synthetic */ Object R0(Cursor cursor) {
        while (cursor.moveToNext()) {
            c(cursor.getInt(0), LogEventDropped.Reason.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    public final /* synthetic */ Object S0(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        f1(sQLiteDatabase.rawQuery(str2, null), new b() { // from class: mg.x
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return this.f71097a.R0((Cursor) obj);
            }
        });
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    @Override // mg.d
    public Iterable<k> T(final com.google.android.datatransport.runtime.o oVar) {
        return (Iterable) v0(new b() { // from class: mg.p
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return this.f71071a.K0(oVar, (SQLiteDatabase) obj);
            }
        });
    }

    public final /* synthetic */ Object W0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.f71057b.a()).execute();
        return null;
    }

    public final List<k> X0(SQLiteDatabase sQLiteDatabase, final com.google.android.datatransport.runtime.o oVar, int i11) {
        final ArrayList arrayList = new ArrayList();
        Long lU0 = u0(sQLiteDatabase, oVar);
        if (lU0 == null) {
            return arrayList;
        }
        f1(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", TrackingKey.CODE, "inline", "product_id"}, "context_id = ?", new String[]{lU0.toString()}, null, null, null, String.valueOf(i11)), new b() { // from class: mg.y
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return this.f71098a.N0(arrayList, oVar, (Cursor) obj);
            }
        });
        return arrayList;
    }

    public final Map<Long, Set<c>> Y0(SQLiteDatabase sQLiteDatabase, List<k> list) {
        final HashMap map = new HashMap();
        StringBuilder sb2 = new StringBuilder("event_id IN (");
        for (int i11 = 0; i11 < list.size(); i11++) {
            sb2.append(list.get(i11).c());
            if (i11 < list.size() - 1) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        f1(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", AppMeasurementSdk.ConditionalUserProperty.VALUE}, sb2.toString(), null, null, null, null), new b() { // from class: mg.t
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return m0.O0(map, (Cursor) obj);
            }
        });
        return map;
    }

    @Override // mg.c
    public void a() {
        v0(new b() { // from class: mg.o
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return this.f71070a.W0((SQLiteDatabase) obj);
            }
        });
    }

    public final void a1(hg.a.C0695a c0695a, Map<String, List<LogEventDropped>> map) {
        for (Map.Entry<String, List<LogEventDropped>> entry : map.entrySet()) {
            c0695a.a(hg.c.c().c(entry.getKey()).b(entry.getValue()).a());
        }
    }

    @Override // mg.c
    public hg.a b() {
        final hg.a.C0695a c0695aE = hg.a.e();
        final HashMap map = new HashMap();
        final String str = "SELECT log_source, reason, events_dropped_count FROM log_event_dropped";
        return (hg.a) v0(new b() { // from class: mg.u
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return this.f71078a.M0(str, map, c0695aE, (SQLiteDatabase) obj);
            }
        });
    }

    public final byte[] b1(long j11) {
        return (byte[]) f1(l0().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j11)}, null, null, "sequence_num"), new b() { // from class: mg.a0
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return m0.Q0((Cursor) obj);
            }
        });
    }

    @Override // mg.c
    public void c(final long j11, final LogEventDropped.Reason reason, final String str) {
        v0(new b() { // from class: mg.m
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return m0.U0(str, reason, j11, (SQLiteDatabase) obj);
            }
        });
    }

    public final <T> T c1(d<T> dVar, b<Throwable, T> bVar) {
        long jA = this.f71058c.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e11) {
                if (this.f71058c.a() >= ((long) this.f71059d.b()) + jA) {
                    return bVar.apply(e11);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f71056a.close();
    }

    @Override // ng.a
    public <T> T d(ng.a.InterfaceC0770a<T> interfaceC0770a) {
        SQLiteDatabase sQLiteDatabaseL0 = l0();
        i0(sQLiteDatabaseL0);
        try {
            T tExecute = interfaceC0770a.execute();
            sQLiteDatabaseL0.setTransactionSuccessful();
            return tExecute;
        } finally {
            sQLiteDatabaseL0.endTransaction();
        }
    }

    public final LogEventDropped.Reason h0(int i11) {
        LogEventDropped.Reason reason = LogEventDropped.Reason.REASON_UNKNOWN;
        if (i11 == reason.getNumber()) {
            return reason;
        }
        LogEventDropped.Reason reason2 = LogEventDropped.Reason.MESSAGE_TOO_OLD;
        if (i11 == reason2.getNumber()) {
            return reason2;
        }
        LogEventDropped.Reason reason3 = LogEventDropped.Reason.CACHE_FULL;
        if (i11 == reason3.getNumber()) {
            return reason3;
        }
        LogEventDropped.Reason reason4 = LogEventDropped.Reason.PAYLOAD_TOO_BIG;
        if (i11 == reason4.getNumber()) {
            return reason4;
        }
        LogEventDropped.Reason reason5 = LogEventDropped.Reason.MAX_RETRIES_REACHED;
        if (i11 == reason5.getNumber()) {
            return reason5;
        }
        LogEventDropped.Reason reason6 = LogEventDropped.Reason.INVALID_PAYLOD;
        if (i11 == reason6.getNumber()) {
            return reason6;
        }
        LogEventDropped.Reason reason7 = LogEventDropped.Reason.SERVER_ERROR;
        if (i11 == reason7.getNumber()) {
            return reason7;
        }
        ig.a.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i11));
        return reason;
    }

    public final void i0(final SQLiteDatabase sQLiteDatabase) {
        c1(new d() { // from class: mg.g0
            @Override // mg.m0.d
            public final Object a() {
                return m0.A0(sQLiteDatabase);
            }
        }, new b() { // from class: mg.h0
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return m0.B0((Throwable) obj);
            }
        });
    }

    public final long j0(SQLiteDatabase sQLiteDatabase, com.google.android.datatransport.runtime.o oVar) {
        Long lU0 = u0(sQLiteDatabase, oVar);
        if (lU0 != null) {
            return lU0.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", oVar.b());
        contentValues.put(TrackingKey.PRIORITY, Integer.valueOf(pg.a.a(oVar.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (oVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(oVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    public long k0() {
        return q0() * s0();
    }

    public SQLiteDatabase l0() {
        final u0 u0Var = this.f71056a;
        Objects.requireNonNull(u0Var);
        return (SQLiteDatabase) c1(new d() { // from class: mg.w
            @Override // mg.m0.d
            public final Object a() {
                return u0Var.getWritableDatabase();
            }
        }, new b() { // from class: mg.e0
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return m0.C0((Throwable) obj);
            }
        });
    }

    @Override // mg.d
    @Nullable
    public k o0(final com.google.android.datatransport.runtime.o oVar, final com.google.android.datatransport.runtime.i iVar) {
        ig.a.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", oVar.d(), iVar.k(), oVar.b());
        long jLongValue = ((Long) v0(new b() { // from class: mg.i0
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return this.f71044a.P0(iVar, oVar, (SQLiteDatabase) obj);
            }
        })).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return k.a(jLongValue, oVar, iVar);
    }

    public final hg.b p0() {
        return hg.b.b().b(hg.d.c().b(k0()).c(e.f71039a.f()).a()).a();
    }

    public final long q0() {
        return l0().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    public final long s0() {
        return l0().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    public final hg.e t0() {
        final long jA = this.f71057b.a();
        return (hg.e) v0(new b() { // from class: mg.c0
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return m0.F0(jA, (SQLiteDatabase) obj);
            }
        });
    }

    @Nullable
    public final Long u0(SQLiteDatabase sQLiteDatabase, com.google.android.datatransport.runtime.o oVar) {
        StringBuilder sb2 = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(oVar.b(), String.valueOf(pg.a.a(oVar.d()))));
        if (oVar.c() != null) {
            sb2.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(oVar.c(), 0));
        } else {
            sb2.append(" and extras is null");
        }
        return (Long) f1(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb2.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new b() { // from class: mg.s
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return m0.G0((Cursor) obj);
            }
        });
    }

    public <T> T v0(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase sQLiteDatabaseL0 = l0();
        sQLiteDatabaseL0.beginTransaction();
        try {
            T tApply = bVar.apply(sQLiteDatabaseL0);
            sQLiteDatabaseL0.setTransactionSuccessful();
            return tApply;
        } finally {
            sQLiteDatabaseL0.endTransaction();
        }
    }

    public final boolean w0() {
        return q0() * s0() >= this.f71059d.f();
    }

    public final List<k> x0(List<k> list, Map<Long, Set<c>> map) {
        ListIterator<k> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            k next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.c()))) {
                com.google.android.datatransport.runtime.i.a aVarM = next.b().m();
                for (c cVar : map.get(Long.valueOf(next.c()))) {
                    aVarM.c(cVar.f71061a, cVar.f71062b);
                }
                listIterator.set(k.a(next.c(), next.d(), aVarM.d()));
            }
        }
        return list;
    }

    public final /* synthetic */ Object y0(Cursor cursor) {
        while (cursor.moveToNext()) {
            c(cursor.getInt(0), LogEventDropped.Reason.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    public final /* synthetic */ Integer z0(long j11, SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {String.valueOf(j11)};
        f1(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new b() { // from class: mg.r
            @Override // mg.m0.b
            public final Object apply(Object obj) {
                return this.f71076a.y0((Cursor) obj);
            }
        });
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }
}
