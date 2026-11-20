package com.transsion.baselib.db.video;

import android.database.Cursor;
import androidx.core.app.NotificationCompat;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.h;
import androidx.room.i;
import androidx.room.v;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import g6.k;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements ShortTVPlayDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f51106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i<ShortTVPlayBean> f51107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h<ShortTVPlayBean> f51108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f51109d;

    /* JADX INFO: compiled from: source.java */
    public class a extends i<ShortTVPlayBean> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `short_tv_play` (`subjectId`,`id`,`ep`,`se`,`totalEp`,`progress`,`title`,`description`,`coverUrl`,`thumbnail`,`videoId`,`videoUrl`,`timeStamp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, ShortTVPlayBean shortTVPlayBean) {
            if (shortTVPlayBean.getSubjectId() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, shortTVPlayBean.getSubjectId());
            }
            if (shortTVPlayBean.getId() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, shortTVPlayBean.getId());
            }
            kVar.V(3, shortTVPlayBean.getEp());
            kVar.V(4, shortTVPlayBean.getSe());
            kVar.V(5, shortTVPlayBean.getTotalEp());
            kVar.V(6, shortTVPlayBean.getProgress());
            if (shortTVPlayBean.getTitle() == null) {
                kVar.m0(7);
            } else {
                kVar.s(7, shortTVPlayBean.getTitle());
            }
            if (shortTVPlayBean.getDescription() == null) {
                kVar.m0(8);
            } else {
                kVar.s(8, shortTVPlayBean.getDescription());
            }
            if (shortTVPlayBean.getCoverUrl() == null) {
                kVar.m0(9);
            } else {
                kVar.s(9, shortTVPlayBean.getCoverUrl());
            }
            if (shortTVPlayBean.getThumbnail() == null) {
                kVar.m0(10);
            } else {
                kVar.s(10, shortTVPlayBean.getThumbnail());
            }
            if (shortTVPlayBean.getVideoId() == null) {
                kVar.m0(11);
            } else {
                kVar.s(11, shortTVPlayBean.getVideoId());
            }
            if (shortTVPlayBean.getVideoUrl() == null) {
                kVar.m0(12);
            } else {
                kVar.s(12, shortTVPlayBean.getVideoUrl());
            }
            kVar.V(13, shortTVPlayBean.getTimeStamp());
        }
    }

    /* JADX INFO: renamed from: com.transsion.baselib.db.video.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0555b extends h<ShortTVPlayBean> {
        public C0555b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE OR ABORT `short_tv_play` SET `subjectId` = ?,`id` = ?,`ep` = ?,`se` = ?,`totalEp` = ?,`progress` = ?,`title` = ?,`description` = ?,`coverUrl` = ?,`thumbnail` = ?,`videoId` = ?,`videoUrl` = ?,`timeStamp` = ? WHERE `subjectId` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, ShortTVPlayBean shortTVPlayBean) {
            if (shortTVPlayBean.getSubjectId() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, shortTVPlayBean.getSubjectId());
            }
            if (shortTVPlayBean.getId() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, shortTVPlayBean.getId());
            }
            kVar.V(3, shortTVPlayBean.getEp());
            kVar.V(4, shortTVPlayBean.getSe());
            kVar.V(5, shortTVPlayBean.getTotalEp());
            kVar.V(6, shortTVPlayBean.getProgress());
            if (shortTVPlayBean.getTitle() == null) {
                kVar.m0(7);
            } else {
                kVar.s(7, shortTVPlayBean.getTitle());
            }
            if (shortTVPlayBean.getDescription() == null) {
                kVar.m0(8);
            } else {
                kVar.s(8, shortTVPlayBean.getDescription());
            }
            if (shortTVPlayBean.getCoverUrl() == null) {
                kVar.m0(9);
            } else {
                kVar.s(9, shortTVPlayBean.getCoverUrl());
            }
            if (shortTVPlayBean.getThumbnail() == null) {
                kVar.m0(10);
            } else {
                kVar.s(10, shortTVPlayBean.getThumbnail());
            }
            if (shortTVPlayBean.getVideoId() == null) {
                kVar.m0(11);
            } else {
                kVar.s(11, shortTVPlayBean.getVideoId());
            }
            if (shortTVPlayBean.getVideoUrl() == null) {
                kVar.m0(12);
            } else {
                kVar.s(12, shortTVPlayBean.getVideoUrl());
            }
            kVar.V(13, shortTVPlayBean.getTimeStamp());
            if (shortTVPlayBean.getSubjectId() == null) {
                kVar.m0(14);
            } else {
                kVar.s(14, shortTVPlayBean.getSubjectId());
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
            return "UPDATE SHORT_TV_PLAY SET progress = ? AND ep = ? WHERE subjectId = ? ";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShortTVPlayBean f51113a;

        public d(ShortTVPlayBean shortTVPlayBean) {
            this.f51113a = shortTVPlayBean;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f51106a.e();
            try {
                b.this.f51107b.k(this.f51113a);
                b.this.f51106a.E();
                return Unit.f68710a;
            } finally {
                b.this.f51106a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShortTVPlayBean f51115a;

        public e(ShortTVPlayBean shortTVPlayBean) {
            this.f51115a = shortTVPlayBean;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f51106a.e();
            try {
                b.this.f51108c.j(this.f51115a);
                b.this.f51106a.E();
                return Unit.f68710a;
            } finally {
                b.this.f51106a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f51117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f51118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f51119c;

        public f(long j11, int i11, String str) {
            this.f51117a = j11;
            this.f51118b = i11;
            this.f51119c = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            k kVarB = b.this.f51109d.b();
            kVarB.V(1, this.f51117a);
            kVarB.V(2, this.f51118b);
            String str = this.f51119c;
            if (str == null) {
                kVarB.m0(3);
            } else {
                kVarB.s(3, str);
            }
            b.this.f51106a.e();
            try {
                kVarB.F();
                b.this.f51106a.E();
                return Unit.f68710a;
            } finally {
                b.this.f51106a.i();
                b.this.f51109d.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements Callable<ShortTVPlayBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f51121a;

        public g(v vVar) {
            this.f51121a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShortTVPlayBean call() throws Exception {
            ShortTVPlayBean shortTVPlayBean = null;
            Cursor cursorC = e6.b.c(b.this.f51106a, this.f51121a, false, null);
            try {
                int iE = e6.a.e(cursorC, "subjectId");
                int iE2 = e6.a.e(cursorC, "id");
                int iE3 = e6.a.e(cursorC, "ep");
                int iE4 = e6.a.e(cursorC, "se");
                int iE5 = e6.a.e(cursorC, "totalEp");
                int iE6 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE7 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                int iE8 = e6.a.e(cursorC, TrackingKey.DESCRIPTION);
                int iE9 = e6.a.e(cursorC, "coverUrl");
                int iE10 = e6.a.e(cursorC, "thumbnail");
                int iE11 = e6.a.e(cursorC, "videoId");
                int iE12 = e6.a.e(cursorC, "videoUrl");
                int iE13 = e6.a.e(cursorC, "timeStamp");
                if (cursorC.moveToFirst()) {
                    shortTVPlayBean = new ShortTVPlayBean(cursorC.isNull(iE) ? null : cursorC.getString(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.getInt(iE3), cursorC.getInt(iE4), cursorC.getInt(iE5), cursorC.getLong(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : cursorC.getString(iE8), cursorC.isNull(iE9) ? null : cursorC.getString(iE9), cursorC.isNull(iE10) ? null : cursorC.getString(iE10), cursorC.isNull(iE11) ? null : cursorC.getString(iE11), cursorC.isNull(iE12) ? null : cursorC.getString(iE12), cursorC.getLong(iE13));
                }
                return shortTVPlayBean;
            } finally {
                cursorC.close();
                this.f51121a.release();
            }
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f51106a = roomDatabase;
        this.f51107b = new a(roomDatabase);
        this.f51108c = new C0555b(roomDatabase);
        this.f51109d = new c(roomDatabase);
    }

    public static List<Class<?>> j() {
        return Collections.emptyList();
    }

    @Override // com.transsion.baselib.db.video.ShortTVPlayDao
    public Object b(String str, Continuation<? super ShortTVPlayBean> continuation) {
        v vVarC = v.c("SELECT * FROM SHORT_TV_PLAY WHERE subjectId = ?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f51106a, false, e6.b.a(), new g(vVarC), continuation);
    }

    @Override // com.transsion.baselib.db.video.ShortTVPlayDao
    public Object c(ShortTVPlayBean shortTVPlayBean, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f51106a, true, new d(shortTVPlayBean), continuation);
    }

    @Override // com.transsion.baselib.db.video.ShortTVPlayDao
    public Object d(ShortTVPlayBean shortTVPlayBean, Continuation<? super Unit> continuation) {
        return ShortTVPlayDao.DefaultImpls.a(this, shortTVPlayBean, continuation);
    }

    @Override // com.transsion.baselib.db.video.ShortTVPlayDao
    public Object e(String str, int i11, long j11, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f51106a, true, new f(j11, i11, str), continuation);
    }

    @Override // com.transsion.baselib.db.video.ShortTVPlayDao
    public Object f(ShortTVPlayBean shortTVPlayBean, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f51106a, true, new e(shortTVPlayBean), continuation);
    }
}
