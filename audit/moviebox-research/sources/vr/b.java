package vr;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.v;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baselib.db.music.MusicLikedDbBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements vr.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f79054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.i<MusicLikedDbBean> f79055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.room.h<MusicLikedDbBean> f79056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f79057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f79058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SharedSQLiteStatement f79059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SharedSQLiteStatement f79060g;

    /* JADX INFO: compiled from: source.java */
    public class a implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f79061a;

        public a(String str) {
            this.f79061a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            g6.k kVarB = b.this.f79058e.b();
            String str = this.f79061a;
            if (str == null) {
                kVarB.m0(1);
            } else {
                kVarB.s(1, str);
            }
            b.this.f79054a.e();
            try {
                kVarB.F();
                b.this.f79054a.E();
                return Unit.f68710a;
            } finally {
                b.this.f79054a.i();
                b.this.f79058e.h(kVarB);
            }
        }
    }

    /* JADX INFO: renamed from: vr.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class CallableC0878b implements Callable<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f79063a;

        public CallableC0878b(v vVar) {
            this.f79063a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer call() throws Exception {
            Integer numValueOf = null;
            Cursor cursorC = e6.b.c(b.this.f79054a, this.f79063a, false, null);
            try {
                if (cursorC.moveToFirst() && !cursorC.isNull(0)) {
                    numValueOf = Integer.valueOf(cursorC.getInt(0));
                }
                return numValueOf;
            } finally {
                cursorC.close();
                this.f79063a.release();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Callable<List<MusicLikedDbBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f79065a;

        public c(v vVar) {
            this.f79065a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<MusicLikedDbBean> call() throws Exception {
            Cursor cursorC = e6.b.c(b.this.f79054a, this.f79065a, false, null);
            try {
                int iE = e6.a.e(cursorC, "subjectId");
                int iE2 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                int iE3 = e6.a.e(cursorC, "coverUrl");
                int iE4 = e6.a.e(cursorC, "countryName");
                int iE5 = e6.a.e(cursorC, "genre");
                int iE6 = e6.a.e(cursorC, "releaseDate");
                int iE7 = e6.a.e(cursorC, "durationSeconds");
                int iE8 = e6.a.e(cursorC, "singerName");
                int iE9 = e6.a.e(cursorC, "singerAvatar");
                int iE10 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE11 = e6.a.e(cursorC, "timeStamp");
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new MusicLikedDbBean(cursorC.isNull(iE) ? null : cursorC.getString(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : cursorC.getString(iE5), cursorC.isNull(iE6) ? null : cursorC.getString(iE6), cursorC.getInt(iE7), cursorC.isNull(iE8) ? null : cursorC.getString(iE8), cursorC.isNull(iE9) ? null : cursorC.getString(iE9), cursorC.isNull(iE10) ? null : cursorC.getString(iE10), cursorC.getLong(iE11)));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.f79065a.release();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Callable<MusicLikedDbBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f79067a;

        public d(v vVar) {
            this.f79067a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MusicLikedDbBean call() throws Exception {
            MusicLikedDbBean musicLikedDbBean = null;
            Cursor cursorC = e6.b.c(b.this.f79054a, this.f79067a, false, null);
            try {
                int iE = e6.a.e(cursorC, "subjectId");
                int iE2 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                int iE3 = e6.a.e(cursorC, "coverUrl");
                int iE4 = e6.a.e(cursorC, "countryName");
                int iE5 = e6.a.e(cursorC, "genre");
                int iE6 = e6.a.e(cursorC, "releaseDate");
                int iE7 = e6.a.e(cursorC, "durationSeconds");
                int iE8 = e6.a.e(cursorC, "singerName");
                int iE9 = e6.a.e(cursorC, "singerAvatar");
                int iE10 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE11 = e6.a.e(cursorC, "timeStamp");
                if (cursorC.moveToFirst()) {
                    musicLikedDbBean = new MusicLikedDbBean(cursorC.isNull(iE) ? null : cursorC.getString(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : cursorC.getString(iE5), cursorC.isNull(iE6) ? null : cursorC.getString(iE6), cursorC.getInt(iE7), cursorC.isNull(iE8) ? null : cursorC.getString(iE8), cursorC.isNull(iE9) ? null : cursorC.getString(iE9), cursorC.isNull(iE10) ? null : cursorC.getString(iE10), cursorC.getLong(iE11));
                }
                return musicLikedDbBean;
            } finally {
                cursorC.close();
                this.f79067a.release();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends androidx.room.i<MusicLikedDbBean> {
        public e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `music_liked` (`subjectId`,`title`,`coverUrl`,`countryName`,`genre`,`releaseDate`,`durationSeconds`,`singerName`,`singerAvatar`,`path`,`timeStamp`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, MusicLikedDbBean musicLikedDbBean) {
            if (musicLikedDbBean.getSubjectId() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, musicLikedDbBean.getSubjectId());
            }
            if (musicLikedDbBean.getTitle() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, musicLikedDbBean.getTitle());
            }
            if (musicLikedDbBean.getCoverUrl() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, musicLikedDbBean.getCoverUrl());
            }
            if (musicLikedDbBean.getCountryName() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, musicLikedDbBean.getCountryName());
            }
            if (musicLikedDbBean.getGenre() == null) {
                kVar.m0(5);
            } else {
                kVar.s(5, musicLikedDbBean.getGenre());
            }
            if (musicLikedDbBean.getReleaseDate() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, musicLikedDbBean.getReleaseDate());
            }
            kVar.V(7, musicLikedDbBean.getDurationSeconds());
            if (musicLikedDbBean.getSingerName() == null) {
                kVar.m0(8);
            } else {
                kVar.s(8, musicLikedDbBean.getSingerName());
            }
            if (musicLikedDbBean.getSingerAvatar() == null) {
                kVar.m0(9);
            } else {
                kVar.s(9, musicLikedDbBean.getSingerAvatar());
            }
            if (musicLikedDbBean.getPath() == null) {
                kVar.m0(10);
            } else {
                kVar.s(10, musicLikedDbBean.getPath());
            }
            kVar.V(11, musicLikedDbBean.getTimeStamp());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends androidx.room.h<MusicLikedDbBean> {
        public f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE OR ABORT `music_liked` SET `subjectId` = ?,`title` = ?,`coverUrl` = ?,`countryName` = ?,`genre` = ?,`releaseDate` = ?,`durationSeconds` = ?,`singerName` = ?,`singerAvatar` = ?,`path` = ?,`timeStamp` = ? WHERE `subjectId` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, MusicLikedDbBean musicLikedDbBean) {
            if (musicLikedDbBean.getSubjectId() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, musicLikedDbBean.getSubjectId());
            }
            if (musicLikedDbBean.getTitle() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, musicLikedDbBean.getTitle());
            }
            if (musicLikedDbBean.getCoverUrl() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, musicLikedDbBean.getCoverUrl());
            }
            if (musicLikedDbBean.getCountryName() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, musicLikedDbBean.getCountryName());
            }
            if (musicLikedDbBean.getGenre() == null) {
                kVar.m0(5);
            } else {
                kVar.s(5, musicLikedDbBean.getGenre());
            }
            if (musicLikedDbBean.getReleaseDate() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, musicLikedDbBean.getReleaseDate());
            }
            kVar.V(7, musicLikedDbBean.getDurationSeconds());
            if (musicLikedDbBean.getSingerName() == null) {
                kVar.m0(8);
            } else {
                kVar.s(8, musicLikedDbBean.getSingerName());
            }
            if (musicLikedDbBean.getSingerAvatar() == null) {
                kVar.m0(9);
            } else {
                kVar.s(9, musicLikedDbBean.getSingerAvatar());
            }
            if (musicLikedDbBean.getPath() == null) {
                kVar.m0(10);
            } else {
                kVar.s(10, musicLikedDbBean.getPath());
            }
            kVar.V(11, musicLikedDbBean.getTimeStamp());
            if (musicLikedDbBean.getSubjectId() == null) {
                kVar.m0(12);
            } else {
                kVar.s(12, musicLikedDbBean.getSubjectId());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends SharedSQLiteStatement {
        public g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT INTO music_liked(subjectId,title,coverUrl,countryName,genre,releaseDate,durationSeconds,singerName,path,timeStamp) VALUES(?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends SharedSQLiteStatement {
        public h(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM music_liked WHERE subjectId = ?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i extends SharedSQLiteStatement {
        public i(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM music_liked";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class j extends SharedSQLiteStatement {
        public j(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE music_liked SET path = ? WHERE subjectId = ?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class k implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MusicLikedDbBean f79075a;

        public k(MusicLikedDbBean musicLikedDbBean) {
            this.f79075a = musicLikedDbBean;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f79054a.e();
            try {
                b.this.f79055b.k(this.f79075a);
                b.this.f79054a.E();
                return Unit.f68710a;
            } finally {
                b.this.f79054a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class l implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f79077a;

        public l(List list) {
            this.f79077a = list;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f79054a.e();
            try {
                b.this.f79055b.j(this.f79077a);
                b.this.f79054a.E();
                return Unit.f68710a;
            } finally {
                b.this.f79054a.i();
            }
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f79054a = roomDatabase;
        this.f79055b = new e(roomDatabase);
        this.f79056c = new f(roomDatabase);
        this.f79057d = new g(roomDatabase);
        this.f79058e = new h(roomDatabase);
        this.f79059f = new i(roomDatabase);
        this.f79060g = new j(roomDatabase);
    }

    public static List<Class<?>> j() {
        return Collections.emptyList();
    }

    @Override // vr.a
    public Object a(Continuation<? super Integer> continuation) {
        v vVarC = v.c("SELECT COUNT(*) FROM music_liked", 0);
        return CoroutinesRoom.a(this.f79054a, false, e6.b.a(), new CallableC0878b(vVarC), continuation);
    }

    @Override // vr.a
    public Object b(List<MusicLikedDbBean> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f79054a, true, new l(list), continuation);
    }

    @Override // vr.a
    public Object c(Continuation<? super List<MusicLikedDbBean>> continuation) {
        v vVarC = v.c("SELECT * FROM music_liked ORDER BY timeStamp DESC", 0);
        return CoroutinesRoom.a(this.f79054a, false, e6.b.a(), new c(vVarC), continuation);
    }

    @Override // vr.a
    public Object d(String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f79054a, true, new a(str), continuation);
    }

    @Override // vr.a
    public Object e(String str, Continuation<? super MusicLikedDbBean> continuation) {
        v vVarC = v.c("SELECT * FROM music_liked WHERE subjectId = ?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f79054a, false, e6.b.a(), new d(vVarC), continuation);
    }

    @Override // vr.a
    public Object f(MusicLikedDbBean musicLikedDbBean, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f79054a, true, new k(musicLikedDbBean), continuation);
    }
}
