package s6;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f76173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.i<i> f76174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedSQLiteStatement f76175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f76176d;

    /* JADX INFO: compiled from: source.java */
    public class a extends androidx.room.i<i> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, i iVar) {
            String str = iVar.f76170a;
            if (str == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, str);
            }
            kVar.V(2, iVar.a());
            kVar.V(3, iVar.f76172c);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends SharedSQLiteStatement {
        public b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM SystemIdInfo where work_spec_id=? AND generation=?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends SharedSQLiteStatement {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public k(RoomDatabase roomDatabase) {
        this.f76173a = roomDatabase;
        this.f76174b = new a(roomDatabase);
        this.f76175c = new b(roomDatabase);
        this.f76176d = new c(roomDatabase);
    }

    public static List<Class<?>> h() {
        return Collections.emptyList();
    }

    @Override // s6.j
    public void a(m mVar) {
        j.a.b(this, mVar);
    }

    @Override // s6.j
    public i b(String str, int i11) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?", 2);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        vVarC.V(2, i11);
        this.f76173a.d();
        i iVar = null;
        String string = null;
        Cursor cursorC = e6.b.c(this.f76173a, vVarC, false, null);
        try {
            int iE = e6.a.e(cursorC, "work_spec_id");
            int iE2 = e6.a.e(cursorC, "generation");
            int iE3 = e6.a.e(cursorC, "system_id");
            if (cursorC.moveToFirst()) {
                if (!cursorC.isNull(iE)) {
                    string = cursorC.getString(iE);
                }
                iVar = new i(string, cursorC.getInt(iE2), cursorC.getInt(iE3));
            }
            return iVar;
        } finally {
            cursorC.close();
            vVarC.release();
        }
    }

    @Override // s6.j
    public List<String> c() {
        androidx.room.v vVarC = androidx.room.v.c("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.f76173a.d();
        Cursor cursorC = e6.b.c(this.f76173a, vVarC, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorC.getCount());
            while (cursorC.moveToNext()) {
                arrayList.add(cursorC.isNull(0) ? null : cursorC.getString(0));
            }
            return arrayList;
        } finally {
            cursorC.close();
            vVarC.release();
        }
    }

    @Override // s6.j
    public void d(i iVar) {
        this.f76173a.d();
        this.f76173a.e();
        try {
            this.f76174b.k(iVar);
            this.f76173a.E();
        } finally {
            this.f76173a.i();
        }
    }

    @Override // s6.j
    public i e(m mVar) {
        return j.a.a(this, mVar);
    }

    @Override // s6.j
    public void f(String str, int i11) {
        this.f76173a.d();
        g6.k kVarB = this.f76175c.b();
        if (str == null) {
            kVarB.m0(1);
        } else {
            kVarB.s(1, str);
        }
        kVarB.V(2, i11);
        this.f76173a.e();
        try {
            kVarB.F();
            this.f76173a.E();
        } finally {
            this.f76173a.i();
            this.f76175c.h(kVarB);
        }
    }

    @Override // s6.j
    public void g(String str) {
        this.f76173a.d();
        g6.k kVarB = this.f76176d.b();
        if (str == null) {
            kVarB.m0(1);
        } else {
            kVarB.s(1, str);
        }
        this.f76173a.e();
        try {
            kVarB.F();
            this.f76173a.E();
        } finally {
            this.f76173a.i();
            this.f76176d.h(kVarB);
        }
    }
}
