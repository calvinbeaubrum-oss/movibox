package qq;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.i;
import androidx.room.v;
import com.transsion.ad.db.mcc.LocalMcc;
import g6.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements qq.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f74871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i<LocalMcc> f74872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedSQLiteStatement f74873c;

    /* JADX INFO: compiled from: source.java */
    public class a extends i<LocalMcc> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `local_mcc` (`id`,`Country`,`Mcc`,`Iso`,`CountryCode`) VALUES (nullif(?, 0),?,?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, LocalMcc localMcc) {
            kVar.V(1, localMcc.getId());
            if (localMcc.getCountry() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, localMcc.getCountry());
            }
            if (localMcc.getMcc() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, localMcc.getMcc());
            }
            if (localMcc.getIso() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, localMcc.getIso());
            }
            if (localMcc.getCountryCode() == null) {
                kVar.m0(5);
            } else {
                kVar.s(5, localMcc.getCountryCode());
            }
        }
    }

    /* JADX INFO: renamed from: qq.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0820b extends SharedSQLiteStatement {
        public C0820b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM local_mcc";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f74876a;

        public c(List list) {
            this.f74876a = list;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f74871a.e();
            try {
                b.this.f74872b.j(this.f74876a);
                b.this.f74871a.E();
                return Unit.f68710a;
            } finally {
                b.this.f74871a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Callable<List<LocalMcc>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f74878a;

        public d(v vVar) {
            this.f74878a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<LocalMcc> call() throws Exception {
            Cursor cursorC = e6.b.c(b.this.f74871a, this.f74878a, false, null);
            try {
                int iE = e6.a.e(cursorC, "id");
                int iE2 = e6.a.e(cursorC, "Country");
                int iE3 = e6.a.e(cursorC, "Mcc");
                int iE4 = e6.a.e(cursorC, "Iso");
                int iE5 = e6.a.e(cursorC, "CountryCode");
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new LocalMcc(cursorC.getInt(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : cursorC.getString(iE5)));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.f74878a.release();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Callable<LocalMcc> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f74880a;

        public e(v vVar) {
            this.f74880a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocalMcc call() throws Exception {
            LocalMcc localMcc = null;
            Cursor cursorC = e6.b.c(b.this.f74871a, this.f74880a, false, null);
            try {
                int iE = e6.a.e(cursorC, "id");
                int iE2 = e6.a.e(cursorC, "Country");
                int iE3 = e6.a.e(cursorC, "Mcc");
                int iE4 = e6.a.e(cursorC, "Iso");
                int iE5 = e6.a.e(cursorC, "CountryCode");
                if (cursorC.moveToFirst()) {
                    localMcc = new LocalMcc(cursorC.getInt(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : cursorC.getString(iE5));
                }
                return localMcc;
            } finally {
                cursorC.close();
                this.f74880a.release();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements Callable<LocalMcc> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f74882a;

        public f(v vVar) {
            this.f74882a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocalMcc call() throws Exception {
            LocalMcc localMcc = null;
            Cursor cursorC = e6.b.c(b.this.f74871a, this.f74882a, false, null);
            try {
                int iE = e6.a.e(cursorC, "id");
                int iE2 = e6.a.e(cursorC, "Country");
                int iE3 = e6.a.e(cursorC, "Mcc");
                int iE4 = e6.a.e(cursorC, "Iso");
                int iE5 = e6.a.e(cursorC, "CountryCode");
                if (cursorC.moveToFirst()) {
                    localMcc = new LocalMcc(cursorC.getInt(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : cursorC.getString(iE5));
                }
                return localMcc;
            } finally {
                cursorC.close();
                this.f74882a.release();
            }
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f74871a = roomDatabase;
        this.f74872b = new a(roomDatabase);
        this.f74873c = new C0820b(roomDatabase);
    }

    public static List<Class<?>> g() {
        return Collections.emptyList();
    }

    @Override // qq.a
    public Object a(String str, Continuation<? super LocalMcc> continuation) {
        v vVarC = v.c("SELECT * FROM local_mcc WHERE Iso = ?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f74871a, false, e6.b.a(), new f(vVarC), continuation);
    }

    @Override // qq.a
    public Object b(List<LocalMcc> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f74871a, true, new c(list), continuation);
    }

    @Override // qq.a
    public Object c(Continuation<? super List<LocalMcc>> continuation) {
        v vVarC = v.c("SELECT * FROM local_mcc", 0);
        return CoroutinesRoom.a(this.f74871a, false, e6.b.a(), new d(vVarC), continuation);
    }

    @Override // qq.a
    public Object d(Continuation<? super LocalMcc> continuation) {
        v vVarC = v.c("SELECT * FROM local_mcc LIMIT 1", 0);
        return CoroutinesRoom.a(this.f74871a, false, e6.b.a(), new e(vVarC), continuation);
    }
}
