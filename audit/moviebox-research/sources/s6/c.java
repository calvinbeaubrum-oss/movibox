package s6;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f76161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.i<s6.a> f76162b;

    /* JADX INFO: compiled from: source.java */
    public class a extends androidx.room.i<s6.a> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, s6.a aVar) {
            if (aVar.b() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, aVar.b());
            }
            if (aVar.a() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, aVar.a());
            }
        }
    }

    public c(RoomDatabase roomDatabase) {
        this.f76161a = roomDatabase;
        this.f76162b = new a(roomDatabase);
    }

    public static List<Class<?>> e() {
        return Collections.emptyList();
    }

    @Override // s6.b
    public List<String> a(String str) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        this.f76161a.d();
        Cursor cursorC = e6.b.c(this.f76161a, vVarC, false, null);
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

    @Override // s6.b
    public boolean b(String str) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        this.f76161a.d();
        boolean z11 = false;
        Cursor cursorC = e6.b.c(this.f76161a, vVarC, false, null);
        try {
            if (cursorC.moveToFirst()) {
                z11 = cursorC.getInt(0) != 0;
            }
            return z11;
        } finally {
            cursorC.close();
            vVarC.release();
        }
    }

    @Override // s6.b
    public void c(s6.a aVar) {
        this.f76161a.d();
        this.f76161a.e();
        try {
            this.f76162b.k(aVar);
            this.f76161a.E();
        } finally {
            this.f76161a.i();
        }
    }

    @Override // s6.b
    public boolean d(String str) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        this.f76161a.d();
        boolean z11 = false;
        Cursor cursorC = e6.b.c(this.f76161a, vVarC, false, null);
        try {
            if (cursorC.moveToFirst()) {
                z11 = cursorC.getInt(0) != 0;
            }
            return z11;
        } finally {
            cursorC.close();
            vVarC.release();
        }
    }
}
