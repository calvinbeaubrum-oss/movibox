package mg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class u0 extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f71082c = "INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f71083d = 6;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f71084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f71085g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f71086h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f71087i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f71088j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f71089k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final List<a> f71090l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f71091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f71092b;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        a aVar = new a() { // from class: mg.o0
            @Override // mg.u0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                u0.i(sQLiteDatabase);
            }
        };
        f71084f = aVar;
        a aVar2 = new a() { // from class: mg.p0
            @Override // mg.u0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                u0.j(sQLiteDatabase);
            }
        };
        f71085g = aVar2;
        a aVar3 = new a() { // from class: mg.q0
            @Override // mg.u0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
            }
        };
        f71086h = aVar3;
        a aVar4 = new a() { // from class: mg.r0
            @Override // mg.u0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                u0.l(sQLiteDatabase);
            }
        };
        f71087i = aVar4;
        a aVar5 = new a() { // from class: mg.s0
            @Override // mg.u0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                u0.m(sQLiteDatabase);
            }
        };
        f71088j = aVar5;
        a aVar6 = new a() { // from class: mg.t0
            @Override // mg.u0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN product_id INTEGER");
            }
        };
        f71089k = aVar6;
        f71090l = Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5, aVar6);
    }

    public u0(Context context, String str, int i11) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i11);
        this.f71092b = false;
        this.f71091a = i11;
    }

    public static /* synthetic */ void i(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    public static /* synthetic */ void j(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    public static /* synthetic */ void l(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    public static /* synthetic */ void m(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(f71082c);
    }

    public final void h(SQLiteDatabase sQLiteDatabase) {
        if (this.f71092b) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    public final void o(SQLiteDatabase sQLiteDatabase, int i11) {
        h(sQLiteDatabase);
        p(sQLiteDatabase, 0, i11);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f71092b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        o(sQLiteDatabase, this.f71091a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        o(sQLiteDatabase, i12);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        h(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        h(sQLiteDatabase);
        p(sQLiteDatabase, i11, i12);
    }

    public final void p(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        List<a> list = f71090l;
        if (i12 <= list.size()) {
            while (i11 < i12) {
                f71090l.get(i11).a(sQLiteDatabase);
                i11++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i11 + " to " + i12 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }
}
