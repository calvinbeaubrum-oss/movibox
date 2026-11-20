package sq;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.i;
import androidx.room.v;
import com.transsion.ad.db.pslink.PsLinkAdPlan;
import g6.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements sq.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f76445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i<PsLinkAdPlan> f76446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedSQLiteStatement f76447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f76448d;

    /* JADX INFO: compiled from: source.java */
    public class a extends i<PsLinkAdPlan> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `ps_link_ad` (`id`,`nonId`,`adSource`,`extAdSlot`,`rank`,`psPlanId`,`psLinkAdInfoStr`,`psInfoJson`) VALUES (?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, PsLinkAdPlan psLinkAdPlan) {
            kVar.V(1, psLinkAdPlan.getId());
            if (psLinkAdPlan.getNonId() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, psLinkAdPlan.getNonId());
            }
            if (psLinkAdPlan.getAdSource() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, psLinkAdPlan.getAdSource());
            }
            if (psLinkAdPlan.getExtAdSlot() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, psLinkAdPlan.getExtAdSlot());
            }
            kVar.V(5, psLinkAdPlan.getRank());
            if (psLinkAdPlan.getPsPlanId() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, psLinkAdPlan.getPsPlanId());
            }
            if (psLinkAdPlan.getPsLinkAdInfoStr() == null) {
                kVar.m0(7);
            } else {
                kVar.s(7, psLinkAdPlan.getPsLinkAdInfoStr());
            }
            if (psLinkAdPlan.getPsInfoJson() == null) {
                kVar.m0(8);
            } else {
                kVar.s(8, psLinkAdPlan.getPsInfoJson());
            }
        }
    }

    /* JADX INFO: renamed from: sq.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0840b extends SharedSQLiteStatement {
        public C0840b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM ps_link_ad WHERE extAdSlot =?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends SharedSQLiteStatement {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM ps_link_ad WHERE id =?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PsLinkAdPlan f76452a;

        public d(PsLinkAdPlan psLinkAdPlan) {
            this.f76452a = psLinkAdPlan;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f76445a.e();
            try {
                b.this.f76446b.k(this.f76452a);
                b.this.f76445a.E();
                return Unit.f68710a;
            } finally {
                b.this.f76445a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f76454a;

        public e(String str) {
            this.f76454a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            k kVarB = b.this.f76447c.b();
            String str = this.f76454a;
            if (str == null) {
                kVarB.m0(1);
            } else {
                kVarB.s(1, str);
            }
            b.this.f76445a.e();
            try {
                kVarB.F();
                b.this.f76445a.E();
                return Unit.f68710a;
            } finally {
                b.this.f76445a.i();
                b.this.f76447c.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements Callable<List<PsLinkAdPlan>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f76456a;

        public f(v vVar) {
            this.f76456a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<PsLinkAdPlan> call() throws Exception {
            Cursor cursorC = e6.b.c(b.this.f76445a, this.f76456a, false, null);
            try {
                int iE = e6.a.e(cursorC, "id");
                int iE2 = e6.a.e(cursorC, "nonId");
                int iE3 = e6.a.e(cursorC, "adSource");
                int iE4 = e6.a.e(cursorC, "extAdSlot");
                int iE5 = e6.a.e(cursorC, "rank");
                int iE6 = e6.a.e(cursorC, "psPlanId");
                int iE7 = e6.a.e(cursorC, "psLinkAdInfoStr");
                int iE8 = e6.a.e(cursorC, "psInfoJson");
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new PsLinkAdPlan(cursorC.getInt(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.getInt(iE5), cursorC.isNull(iE6) ? null : cursorC.getString(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : cursorC.getString(iE8)));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.f76456a.release();
            }
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f76445a = roomDatabase;
        this.f76446b = new a(roomDatabase);
        this.f76447c = new C0840b(roomDatabase);
        this.f76448d = new c(roomDatabase);
    }

    public static List<Class<?>> g() {
        return Collections.emptyList();
    }

    @Override // sq.a
    public Object a(String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f76445a, true, new e(str), continuation);
    }

    @Override // sq.a
    public Object b(PsLinkAdPlan psLinkAdPlan, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f76445a, true, new d(psLinkAdPlan), continuation);
    }

    @Override // sq.a
    public Object c(String str, Continuation<? super List<PsLinkAdPlan>> continuation) {
        v vVarC = v.c("SELECT * FROM ps_link_ad where extAdSlot=? order by rank asc", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f76445a, false, e6.b.a(), new f(vVarC), continuation);
    }
}
