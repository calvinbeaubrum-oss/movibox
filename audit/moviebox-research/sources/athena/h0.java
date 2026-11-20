package athena;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.cloud.config.utils.CommonUtils;
import com.transsion.api.gateway.utils.SafeStringUtils;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class h0 extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13677d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f13678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f13679g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f13680h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f13681i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f13682j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f13683k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f13684a;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CREATE TABLE ");
        k.a aVar = k.a.f13712a;
        sb2.append(aVar.a());
        sb2.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb2.append("tid");
        sb2.append(" INTEGER NOT NULL,");
        sb2.append(NotificationCompat.CATEGORY_EVENT);
        sb2.append(" TEXT NOT NULL,");
        sb2.append("et");
        sb2.append(" INTEGER NOT NULL,");
        sb2.append("pi");
        sb2.append(" INTEGER NOT NULL,");
        sb2.append("created_at");
        sb2.append(" INTEGER NOT NULL,");
        sb2.append(CommonUtils.PARAM_UID);
        sb2.append(" TEXT,");
        sb2.append("ext");
        sb2.append(" TEXT,");
        sb2.append("er_ts");
        sb2.append(" INTEGER DEFAULT 0,");
        sb2.append("boot_id");
        sb2.append(" TEXT)");
        f13675b = sb2.toString();
        f13676c = "CREATE TABLE " + k.a.f13714c.a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, tid INTEGER NOT NULL UNIQUE,ev TEXT,pt INTEGER DEFAULT 0,cf TEXT,ext TEXT)";
        f13677d = "CREATE TABLE " + k.a.f13715d.a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + SafeStringUtils.SP_APPID + " INTEGER NOT NULL UNIQUE,base TEXT,cfg TEXT," + CommonUtils.PARAM_UID + " TEXT,try INTEGER DEFAULT 0,date TEXT,cnt INTEGER DEFAULT 0,ext TEXT)";
        StringBuilder sb3 = new StringBuilder();
        sb3.append("ALTER TABLE ");
        sb3.append(aVar.a());
        sb3.append(" ADD COLUMN ");
        sb3.append(CommonUtils.PARAM_UID);
        sb3.append(" TEXT");
        f13678f = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("ALTER TABLE ");
        sb4.append(aVar.a());
        sb4.append(" ADD COLUMN ");
        sb4.append("ext");
        sb4.append(" TEXT");
        f13679g = sb4.toString();
        f13680h = "ALTER TABLE " + aVar.a() + " ADD COLUMN er_ts INTEGER";
        f13681i = "ALTER TABLE " + aVar.a() + " ADD COLUMN boot_id TEXT";
        f13682j = "CREATE INDEX IF NOT EXISTS t_idx ON " + aVar.a() + " (tid,created_at)";
        StringBuilder sb5 = new StringBuilder();
        sb5.append("DROP TABLE ");
        sb5.append(aVar.a());
        f13683k = sb5.toString();
    }

    public h0(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 6);
        this.f13684a = context.getDatabasePath(str);
    }

    public boolean a() {
        return !this.f13684a.exists() || this.f13684a.length() <= ((long) br.g.x());
    }

    public void b() {
        close();
        if (this.f13684a.delete()) {
            a0.a("mDatabaseFile deleted");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a0.a("Creating a new Athena DB");
        try {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL(f13675b);
                sQLiteDatabase.execSQL(f13682j);
                sQLiteDatabase.execSQL(f13676c);
                sQLiteDatabase.execSQL(f13677d);
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e11) {
                a0.a(Log.getStackTraceString(e11));
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0037 A[Catch: all -> 0x0025, Exception -> 0x0027, SQLiteException -> 0x0032, TryCatch #1 {Exception -> 0x0027, blocks: (B:3:0x0014, B:5:0x001a, B:13:0x002c, B:18:0x0037, B:21:0x003f, B:24:0x005b, B:23:0x004a), top: B:31:0x0014, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x003f A[Catch: all -> 0x0025, Exception -> 0x0027, SQLiteException -> 0x0032, TRY_LEAVE, TryCatch #1 {Exception -> 0x0027, blocks: (B:3:0x0014, B:5:0x001a, B:13:0x002c, B:18:0x0037, B:21:0x003f, B:24:0x005b, B:23:0x004a), top: B:31:0x0014, outer: #0 }] */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        a0.a("Upgrading app, replacing Athena DB oldVersion = " + i11);
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (i11 < 4) {
                    sQLiteDatabase.execSQL(f13676c);
                    sQLiteDatabase.execSQL(f13677d);
                }
                if (i11 < 3) {
                    try {
                        sQLiteDatabase.execSQL(f13678f);
                        if (i11 < 5) {
                            sQLiteDatabase.execSQL(f13679g);
                        }
                        if (i11 < 6) {
                            sQLiteDatabase.execSQL(f13680h);
                            sQLiteDatabase.execSQL(f13681i);
                        }
                    } catch (SQLiteException e11) {
                        a0.c(Log.getStackTraceString(e11));
                        sQLiteDatabase.execSQL(f13683k);
                        sQLiteDatabase.execSQL(f13675b);
                    }
                } else {
                    if (i11 < 5) {
                        sQLiteDatabase.execSQL(f13679g);
                    }
                    if (i11 < 6) {
                        sQLiteDatabase.execSQL(f13680h);
                        sQLiteDatabase.execSQL(f13681i);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e12) {
                a0.c(Log.getStackTraceString(e12));
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
