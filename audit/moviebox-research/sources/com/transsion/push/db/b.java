package com.transsion.push.db;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.v;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.push.bean.PermanentItemBean;
import com.transsion.web.api.WebConstants;
import g6.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b implements com.transsion.push.db.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f56863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.i<PermanentItemBean> f56864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.room.h<PermanentItemBean> f56865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.room.h<PermanentItemBean> f56866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f56867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SharedSQLiteStatement f56868f;

    /* JADX INFO: compiled from: source.java */
    public class a implements Callable<Unit> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            k kVarB = b.this.f56867e.b();
            b.this.f56863a.e();
            try {
                kVarB.F();
                b.this.f56863a.E();
                return Unit.f68710a;
            } finally {
                b.this.f56863a.i();
                b.this.f56867e.h(kVarB);
            }
        }
    }

    /* JADX INFO: renamed from: com.transsion.push.db.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class CallableC0594b implements Callable<List<PermanentItemBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f56870a;

        public CallableC0594b(v vVar) {
            this.f56870a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<PermanentItemBean> call() throws Exception {
            Cursor cursorC = e6.b.c(b.this.f56863a, this.f56870a, false, null);
            try {
                int iE = e6.a.e(cursorC, "id");
                int iE2 = e6.a.e(cursorC, WebConstants.FIELD_DEEPLINK);
                int iE3 = e6.a.e(cursorC, "subject_id");
                int iE4 = e6.a.e(cursorC, "image");
                int iE5 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new PermanentItemBean(cursorC.getInt(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : cursorC.getString(iE5)));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.f56870a.release();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends androidx.room.i<PermanentItemBean> {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `permanent_item` (`id`,`deeplink`,`subject_id`,`image`,`title`) VALUES (nullif(?, 0),?,?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, PermanentItemBean permanentItemBean) {
            kVar.V(1, permanentItemBean.getId());
            if (permanentItemBean.getDeeplink() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, permanentItemBean.getDeeplink());
            }
            if (permanentItemBean.getSubjectId() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, permanentItemBean.getSubjectId());
            }
            if (permanentItemBean.getImage() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, permanentItemBean.getImage());
            }
            if (permanentItemBean.getTitle() == null) {
                kVar.m0(5);
            } else {
                kVar.s(5, permanentItemBean.getTitle());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends androidx.room.h<PermanentItemBean> {
        public d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM `permanent_item` WHERE `id` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, PermanentItemBean permanentItemBean) {
            kVar.V(1, permanentItemBean.getId());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends androidx.room.h<PermanentItemBean> {
        public e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE OR ABORT `permanent_item` SET `id` = ?,`deeplink` = ?,`subject_id` = ?,`image` = ?,`title` = ? WHERE `id` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, PermanentItemBean permanentItemBean) {
            kVar.V(1, permanentItemBean.getId());
            if (permanentItemBean.getDeeplink() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, permanentItemBean.getDeeplink());
            }
            if (permanentItemBean.getSubjectId() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, permanentItemBean.getSubjectId());
            }
            if (permanentItemBean.getImage() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, permanentItemBean.getImage());
            }
            if (permanentItemBean.getTitle() == null) {
                kVar.m0(5);
            } else {
                kVar.s(5, permanentItemBean.getTitle());
            }
            kVar.V(6, permanentItemBean.getId());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends SharedSQLiteStatement {
        public f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM PERMANENT_ITEM";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends SharedSQLiteStatement {
        public g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM PERMANENT_ITEM WHERE subject_id = ?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f56877a;

        public h(List list) {
            this.f56877a = list;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f56863a.e();
            try {
                b.this.f56864b.j(this.f56877a);
                b.this.f56863a.E();
                return Unit.f68710a;
            } finally {
                b.this.f56863a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PermanentItemBean f56879a;

        public i(PermanentItemBean permanentItemBean) {
            this.f56879a = permanentItemBean;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f56863a.e();
            try {
                b.this.f56865c.j(this.f56879a);
                b.this.f56863a.E();
                return Unit.f68710a;
            } finally {
                b.this.f56863a.i();
            }
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f56863a = roomDatabase;
        this.f56864b = new c(roomDatabase);
        this.f56865c = new d(roomDatabase);
        this.f56866d = new e(roomDatabase);
        this.f56867e = new f(roomDatabase);
        this.f56868f = new g(roomDatabase);
    }

    public static List<Class<?>> i() {
        return Collections.emptyList();
    }

    @Override // com.transsion.push.db.a
    public Object a(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f56863a, true, new a(), continuation);
    }

    @Override // com.transsion.push.db.a
    public Object b(List<PermanentItemBean> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f56863a, true, new h(list), continuation);
    }

    @Override // com.transsion.push.db.a
    public Object c(Continuation<? super List<PermanentItemBean>> continuation) {
        v vVarC = v.c("SELECT * FROM permanent_item", 0);
        return CoroutinesRoom.a(this.f56863a, false, e6.b.a(), new CallableC0594b(vVarC), continuation);
    }

    @Override // com.transsion.push.db.a
    public Object d(PermanentItemBean permanentItemBean, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f56863a, true, new i(permanentItemBean), continuation);
    }
}
