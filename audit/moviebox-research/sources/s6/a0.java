package s6;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a0 implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f76151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.i<y> f76152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedSQLiteStatement f76153c;

    /* JADX INFO: compiled from: source.java */
    public class a extends androidx.room.i<y> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, y yVar) {
            if (yVar.a() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, yVar.a());
            }
            if (yVar.b() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, yVar.b());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends SharedSQLiteStatement {
        public b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM worktag WHERE work_spec_id=?";
        }
    }

    public a0(RoomDatabase roomDatabase) {
        this.f76151a = roomDatabase;
        this.f76152b = new a(roomDatabase);
        this.f76153c = new b(roomDatabase);
    }

    public static List<Class<?>> e() {
        return Collections.emptyList();
    }

    @Override // s6.z
    public void a(y yVar) {
        this.f76151a.d();
        this.f76151a.e();
        try {
            this.f76152b.k(yVar);
            this.f76151a.E();
        } finally {
            this.f76151a.i();
        }
    }

    @Override // s6.z
    public List<String> b(String str) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        this.f76151a.d();
        Cursor cursorC = e6.b.c(this.f76151a, vVarC, false, null);
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

    @Override // s6.z
    public void c(String str) {
        this.f76151a.d();
        g6.k kVarB = this.f76153c.b();
        if (str == null) {
            kVarB.m0(1);
        } else {
            kVarB.s(1, str);
        }
        this.f76151a.e();
        try {
            kVarB.F();
            this.f76151a.E();
        } finally {
            this.f76151a.i();
            this.f76153c.h(kVarB);
        }
    }

    @Override // s6.z
    public void d(String str, Set<String> set) {
        z.a.a(this, str, set);
    }
}
