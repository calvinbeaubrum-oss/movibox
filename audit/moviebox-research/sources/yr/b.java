package yr;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.h;
import androidx.room.i;
import androidx.room.v;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.baselib.db.room.RoomItemBean;
import g6.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements yr.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f81607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i<RoomItemBean> f81608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h<RoomItemBean> f81609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f81610d;

    /* JADX INFO: compiled from: source.java */
    public class a extends i<RoomItemBean> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `room_table` (`groupId`,`name`,`avatar`,`hasJoin`,`newPostCount`,`description`,`postCount`,`userCount`,`level`,`updateTimeStamp`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, RoomItemBean roomItemBean) {
            if (roomItemBean.getGroupId() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, roomItemBean.getGroupId());
            }
            if (roomItemBean.getName() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, roomItemBean.getName());
            }
            if (roomItemBean.getAvatar() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, roomItemBean.getAvatar());
            }
            Integer numValueOf = roomItemBean.getHasJoin() == null ? null : Integer.valueOf(roomItemBean.getHasJoin().booleanValue() ? 1 : 0);
            if (numValueOf == null) {
                kVar.m0(4);
            } else {
                kVar.V(4, numValueOf.intValue());
            }
            if (roomItemBean.getNewPostCount() == null) {
                kVar.m0(5);
            } else {
                kVar.V(5, roomItemBean.getNewPostCount().longValue());
            }
            if (roomItemBean.getDescription() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, roomItemBean.getDescription());
            }
            if (roomItemBean.getPostCount() == null) {
                kVar.m0(7);
            } else {
                kVar.V(7, roomItemBean.getPostCount().longValue());
            }
            if (roomItemBean.getUserCount() == null) {
                kVar.m0(8);
            } else {
                kVar.V(8, roomItemBean.getUserCount().longValue());
            }
            if (roomItemBean.getLevel() == null) {
                kVar.m0(9);
            } else {
                kVar.s(9, roomItemBean.getLevel());
            }
            kVar.V(10, roomItemBean.getUpdateTimeStamp());
        }
    }

    /* JADX INFO: renamed from: yr.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0917b extends h<RoomItemBean> {
        public C0917b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM `room_table` WHERE `groupId` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, RoomItemBean roomItemBean) {
            if (roomItemBean.getGroupId() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, roomItemBean.getGroupId());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends SharedSQLiteStatement {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM ROOM_TABLE";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomItemBean f81614a;

        public d(RoomItemBean roomItemBean) {
            this.f81614a = roomItemBean;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f81607a.e();
            try {
                b.this.f81608b.k(this.f81614a);
                b.this.f81607a.E();
                return Unit.f68710a;
            } finally {
                b.this.f81607a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomItemBean f81616a;

        public e(RoomItemBean roomItemBean) {
            this.f81616a = roomItemBean;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f81607a.e();
            try {
                b.this.f81609c.j(this.f81616a);
                b.this.f81607a.E();
                return Unit.f68710a;
            } finally {
                b.this.f81607a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements Callable<List<RoomItemBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f81618a;

        public f(v vVar) {
            this.f81618a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<RoomItemBean> call() throws Exception {
            Boolean boolValueOf;
            Cursor cursorC = e6.b.c(b.this.f81607a, this.f81618a, false, null);
            try {
                int iE = e6.a.e(cursorC, "groupId");
                int iE2 = e6.a.e(cursorC, "name");
                int iE3 = e6.a.e(cursorC, "avatar");
                int iE4 = e6.a.e(cursorC, "hasJoin");
                int iE5 = e6.a.e(cursorC, "newPostCount");
                int iE6 = e6.a.e(cursorC, TrackingKey.DESCRIPTION);
                int iE7 = e6.a.e(cursorC, "postCount");
                int iE8 = e6.a.e(cursorC, "userCount");
                int iE9 = e6.a.e(cursorC, "level");
                int iE10 = e6.a.e(cursorC, "updateTimeStamp");
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                    String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                    String string3 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                    Integer numValueOf = cursorC.isNull(iE4) ? null : Integer.valueOf(cursorC.getInt(iE4));
                    if (numValueOf == null) {
                        boolValueOf = null;
                    } else {
                        boolValueOf = Boolean.valueOf(numValueOf.intValue() != 0);
                    }
                    arrayList.add(new RoomItemBean(string, string2, string3, boolValueOf, cursorC.isNull(iE5) ? null : Long.valueOf(cursorC.getLong(iE5)), cursorC.isNull(iE6) ? null : cursorC.getString(iE6), cursorC.isNull(iE7) ? null : Long.valueOf(cursorC.getLong(iE7)), cursorC.isNull(iE8) ? null : Long.valueOf(cursorC.getLong(iE8)), cursorC.isNull(iE9) ? null : cursorC.getString(iE9), cursorC.getLong(iE10)));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.f81618a.release();
            }
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f81607a = roomDatabase;
        this.f81608b = new a(roomDatabase);
        this.f81609c = new C0917b(roomDatabase);
        this.f81610d = new c(roomDatabase);
    }

    public static List<Class<?>> g() {
        return Collections.emptyList();
    }

    @Override // yr.a
    public Object a(Continuation<? super List<RoomItemBean>> continuation) {
        v vVarC = v.c("SELECT * FROM ROOM_TABLE ORDER BY updateTimeStamp DESC", 0);
        return CoroutinesRoom.a(this.f81607a, false, e6.b.a(), new f(vVarC), continuation);
    }

    @Override // yr.a
    public Object b(RoomItemBean roomItemBean, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f81607a, true, new d(roomItemBean), continuation);
    }

    @Override // yr.a
    public Object c(RoomItemBean roomItemBean, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f81607a, true, new e(roomItemBean), continuation);
    }
}
