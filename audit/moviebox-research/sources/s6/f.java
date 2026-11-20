package s6;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f76166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.i<d> f76167b;

    /* JADX INFO: compiled from: source.java */
    public class a extends androidx.room.i<d> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, d dVar) {
            if (dVar.a() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, dVar.a());
            }
            if (dVar.b() == null) {
                kVar.m0(2);
            } else {
                kVar.V(2, dVar.b().longValue());
            }
        }
    }

    public f(RoomDatabase roomDatabase) {
        this.f76166a = roomDatabase;
        this.f76167b = new a(roomDatabase);
    }

    public static List<Class<?>> b() {
        return Collections.emptyList();
    }

    @Override // s6.e
    public void a(d dVar) {
        this.f76166a.d();
        this.f76166a.e();
        try {
            this.f76167b.k(dVar);
            this.f76166a.E();
        } finally {
            this.f76166a.i();
        }
    }

    @Override // s6.e
    public Long getLongValue(String str) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        this.f76166a.d();
        Long lValueOf = null;
        Cursor cursorC = e6.b.c(this.f76166a, vVarC, false, null);
        try {
            if (cursorC.moveToFirst() && !cursorC.isNull(0)) {
                lValueOf = Long.valueOf(cursorC.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorC.close();
            vVarC.release();
        }
    }
}
