package s6;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f76189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.i<q> f76190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedSQLiteStatement f76191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f76192d;

    /* JADX INFO: compiled from: source.java */
    public class a extends androidx.room.i<q> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, q qVar) throws Throwable {
            if (qVar.b() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, qVar.b());
            }
            byte[] bArrK = androidx.work.d.k(qVar.a());
            if (bArrK == null) {
                kVar.m0(2);
            } else {
                kVar.c0(2, bArrK);
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
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends SharedSQLiteStatement {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM WorkProgress";
        }
    }

    public s(RoomDatabase roomDatabase) {
        this.f76189a = roomDatabase;
        this.f76190b = new a(roomDatabase);
        this.f76191c = new b(roomDatabase);
        this.f76192d = new c(roomDatabase);
    }

    public static List<Class<?>> d() {
        return Collections.emptyList();
    }

    @Override // s6.r
    public void a(String str) {
        this.f76189a.d();
        g6.k kVarB = this.f76191c.b();
        if (str == null) {
            kVarB.m0(1);
        } else {
            kVarB.s(1, str);
        }
        this.f76189a.e();
        try {
            kVarB.F();
            this.f76189a.E();
        } finally {
            this.f76189a.i();
            this.f76191c.h(kVarB);
        }
    }

    @Override // s6.r
    public void b(q qVar) {
        this.f76189a.d();
        this.f76189a.e();
        try {
            this.f76190b.k(qVar);
            this.f76189a.E();
        } finally {
            this.f76189a.i();
        }
    }

    @Override // s6.r
    public void c() {
        this.f76189a.d();
        g6.k kVarB = this.f76192d.b();
        this.f76189a.e();
        try {
            kVarB.F();
            this.f76189a.E();
        } finally {
            this.f76189a.i();
            this.f76192d.h(kVarB);
        }
    }
}
