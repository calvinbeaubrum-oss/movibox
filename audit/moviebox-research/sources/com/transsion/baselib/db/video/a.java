package com.transsion.baselib.db.video;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.h;
import androidx.room.i;
import androidx.room.v;
import g6.k;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements IShortTvFavoriteStateDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f51095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i<ShortTvFavoriteState> f51096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h<ShortTvFavoriteState> f51097c;

    /* JADX INFO: renamed from: com.transsion.baselib.db.video.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0554a extends i<ShortTvFavoriteState> {
        public C0554a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `ShortTvFavoriteState` (`subjectId`,`favoriteNum`,`hasFavorite`,`favoriteTime`) VALUES (?,?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, ShortTvFavoriteState shortTvFavoriteState) {
            if (shortTvFavoriteState.getSubjectId() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, shortTvFavoriteState.getSubjectId());
            }
            if (shortTvFavoriteState.getFavoriteNum() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, shortTvFavoriteState.getFavoriteNum());
            }
            kVar.V(3, shortTvFavoriteState.getHasFavorite() ? 1L : 0L);
            if (shortTvFavoriteState.getFavoriteTime() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, shortTvFavoriteState.getFavoriteTime());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends h<ShortTvFavoriteState> {
        public b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE OR ABORT `ShortTvFavoriteState` SET `subjectId` = ?,`favoriteNum` = ?,`hasFavorite` = ?,`favoriteTime` = ? WHERE `subjectId` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, ShortTvFavoriteState shortTvFavoriteState) {
            if (shortTvFavoriteState.getSubjectId() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, shortTvFavoriteState.getSubjectId());
            }
            if (shortTvFavoriteState.getFavoriteNum() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, shortTvFavoriteState.getFavoriteNum());
            }
            kVar.V(3, shortTvFavoriteState.getHasFavorite() ? 1L : 0L);
            if (shortTvFavoriteState.getFavoriteTime() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, shortTvFavoriteState.getFavoriteTime());
            }
            if (shortTvFavoriteState.getSubjectId() == null) {
                kVar.m0(5);
            } else {
                kVar.s(5, shortTvFavoriteState.getSubjectId());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShortTvFavoriteState f51100a;

        public c(ShortTvFavoriteState shortTvFavoriteState) {
            this.f51100a = shortTvFavoriteState;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            a.this.f51095a.e();
            try {
                a.this.f51096b.k(this.f51100a);
                a.this.f51095a.E();
                return Unit.f68710a;
            } finally {
                a.this.f51095a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShortTvFavoriteState f51102a;

        public d(ShortTvFavoriteState shortTvFavoriteState) {
            this.f51102a = shortTvFavoriteState;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            a.this.f51095a.e();
            try {
                a.this.f51097c.j(this.f51102a);
                a.this.f51095a.E();
                return Unit.f68710a;
            } finally {
                a.this.f51095a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Callable<ShortTvFavoriteState> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f51104a;

        public e(v vVar) {
            this.f51104a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShortTvFavoriteState call() throws Exception {
            ShortTvFavoriteState shortTvFavoriteState = null;
            String string = null;
            Cursor cursorC = e6.b.c(a.this.f51095a, this.f51104a, false, null);
            try {
                int iE = e6.a.e(cursorC, "subjectId");
                int iE2 = e6.a.e(cursorC, "favoriteNum");
                int iE3 = e6.a.e(cursorC, "hasFavorite");
                int iE4 = e6.a.e(cursorC, "favoriteTime");
                if (cursorC.moveToFirst()) {
                    ShortTvFavoriteState shortTvFavoriteState2 = new ShortTvFavoriteState();
                    shortTvFavoriteState2.setSubjectId(cursorC.isNull(iE) ? null : cursorC.getString(iE));
                    shortTvFavoriteState2.setFavoriteNum(cursorC.isNull(iE2) ? null : cursorC.getString(iE2));
                    shortTvFavoriteState2.setHasFavorite(cursorC.getInt(iE3) != 0);
                    if (!cursorC.isNull(iE4)) {
                        string = cursorC.getString(iE4);
                    }
                    shortTvFavoriteState2.setFavoriteTime(string);
                    shortTvFavoriteState = shortTvFavoriteState2;
                }
                return shortTvFavoriteState;
            } finally {
                cursorC.close();
                this.f51104a.release();
            }
        }
    }

    public a(RoomDatabase roomDatabase) {
        this.f51095a = roomDatabase;
        this.f51096b = new C0554a(roomDatabase);
        this.f51097c = new b(roomDatabase);
    }

    public static List<Class<?>> h() {
        return Collections.emptyList();
    }

    @Override // com.transsion.baselib.db.video.IShortTvFavoriteStateDao
    public Object a(ShortTvFavoriteState shortTvFavoriteState, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f51095a, true, new d(shortTvFavoriteState), continuation);
    }

    @Override // com.transsion.baselib.db.video.IShortTvFavoriteStateDao
    public Object b(String str, Continuation<? super ShortTvFavoriteState> continuation) {
        v vVarC = v.c("SELECT * FROM ShortTvFavoriteState WHERE subjectId=?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f51095a, false, e6.b.a(), new e(vVarC), continuation);
    }

    @Override // com.transsion.baselib.db.video.IShortTvFavoriteStateDao
    public Object c(ShortTvFavoriteState shortTvFavoriteState, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f51095a, true, new c(shortTvFavoriteState), continuation);
    }

    @Override // com.transsion.baselib.db.video.IShortTvFavoriteStateDao
    public Object d(ShortTvFavoriteState shortTvFavoriteState, Continuation<? super Unit> continuation) {
        return IShortTvFavoriteStateDao.DefaultImpls.a(this, shortTvFavoriteState, continuation);
    }
}
