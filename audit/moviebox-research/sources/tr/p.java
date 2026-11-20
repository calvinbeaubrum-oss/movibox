package tr;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.v;
import com.transsion.baselib.db.download.SubtitleLanguageMapBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f77410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.i<SubtitleLanguageMapBean> f77411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedSQLiteStatement f77412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f77413d;

    /* JADX INFO: compiled from: source.java */
    public class a extends androidx.room.i<SubtitleLanguageMapBean> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `subtitle_language_map_table` (`lan`,`lanIOS3`,`lanName`,`inSearch`) VALUES (?,?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, SubtitleLanguageMapBean subtitleLanguageMapBean) {
            if (subtitleLanguageMapBean.getLan() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, subtitleLanguageMapBean.getLan());
            }
            if (subtitleLanguageMapBean.getLanIOS3() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, subtitleLanguageMapBean.getLanIOS3());
            }
            if (subtitleLanguageMapBean.getLanName() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, subtitleLanguageMapBean.getLanName());
            }
            kVar.V(4, subtitleLanguageMapBean.getInSearch() ? 1L : 0L);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends SharedSQLiteStatement {
        public b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE SUBTITLE_LANGUAGE_MAP_TABLE SET inSearch = 1  WHERE lan = ?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends SharedSQLiteStatement {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE SUBTITLE_LANGUAGE_MAP_TABLE SET inSearch = ?  WHERE lan = ?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubtitleLanguageMapBean f77417a;

        public d(SubtitleLanguageMapBean subtitleLanguageMapBean) {
            this.f77417a = subtitleLanguageMapBean;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            p.this.f77410a.e();
            try {
                p.this.f77411b.k(this.f77417a);
                p.this.f77410a.E();
                return Unit.f68710a;
            } finally {
                p.this.f77410a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f77419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f77420b;

        public e(boolean z11, String str) {
            this.f77419a = z11;
            this.f77420b = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            g6.k kVarB = p.this.f77413d.b();
            kVarB.V(1, this.f77419a ? 1L : 0L);
            String str = this.f77420b;
            if (str == null) {
                kVarB.m0(2);
            } else {
                kVarB.s(2, str);
            }
            p.this.f77410a.e();
            try {
                kVarB.F();
                p.this.f77410a.E();
                return Unit.f68710a;
            } finally {
                p.this.f77410a.i();
                p.this.f77413d.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements Callable<List<SubtitleLanguageMapBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f77422a;

        public f(v vVar) {
            this.f77422a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<SubtitleLanguageMapBean> call() throws Exception {
            Cursor cursorC = e6.b.c(p.this.f77410a, this.f77422a, false, null);
            try {
                int iE = e6.a.e(cursorC, "lan");
                int iE2 = e6.a.e(cursorC, "lanIOS3");
                int iE3 = e6.a.e(cursorC, "lanName");
                int iE4 = e6.a.e(cursorC, "inSearch");
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new SubtitleLanguageMapBean(cursorC.isNull(iE) ? null : cursorC.getString(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.getInt(iE4) != 0));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.f77422a.release();
            }
        }
    }

    public p(RoomDatabase roomDatabase) {
        this.f77410a = roomDatabase;
        this.f77411b = new a(roomDatabase);
        this.f77412c = new b(roomDatabase);
        this.f77413d = new c(roomDatabase);
    }

    public static List<Class<?>> g() {
        return Collections.emptyList();
    }

    @Override // tr.o
    public Object a(Continuation<? super List<SubtitleLanguageMapBean>> continuation) {
        v vVarC = v.c("SELECT * FROM SUBTITLE_LANGUAGE_MAP_TABLE ", 0);
        return CoroutinesRoom.a(this.f77410a, false, e6.b.a(), new f(vVarC), continuation);
    }

    @Override // tr.o
    public Object b(String str, boolean z11, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f77410a, true, new e(z11, str), continuation);
    }

    @Override // tr.o
    public Object c(SubtitleLanguageMapBean subtitleLanguageMapBean, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f77410a, true, new d(subtitleLanguageMapBean), continuation);
    }
}
