package s6;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f76184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.i<n> f76185b;

    /* JADX INFO: compiled from: source.java */
    public class a extends androidx.room.i<n> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, n nVar) {
            if (nVar.a() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, nVar.a());
            }
            if (nVar.b() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, nVar.b());
            }
        }
    }

    public p(RoomDatabase roomDatabase) {
        this.f76184a = roomDatabase;
        this.f76185b = new a(roomDatabase);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    @Override // s6.o
    public List<String> a(String str) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT name FROM workname WHERE work_spec_id=?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        this.f76184a.d();
        Cursor cursorC = e6.b.c(this.f76184a, vVarC, false, null);
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

    @Override // s6.o
    public void b(n nVar) {
        this.f76184a.d();
        this.f76184a.e();
        try {
            this.f76185b.k(nVar);
            this.f76184a.E();
        } finally {
            this.f76184a.i();
        }
    }
}
