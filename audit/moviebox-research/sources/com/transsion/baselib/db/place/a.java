package com.transsion.baselib.db.place;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.h;
import androidx.room.i;
import androidx.room.v;
import com.google.android.libraries.places.api.model.PlaceTypes;
import g6.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements PlaceDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f51077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i<PlaceDBBean> f51078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h<PlaceDBBean> f51079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f51080d;

    /* JADX INFO: renamed from: com.transsion.baselib.db.place.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0553a extends i<PlaceDBBean> {
        public C0553a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `place_list` (`latitude`,`longitude`,`name`,`address`,`distance`) VALUES (?,?,?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, PlaceDBBean placeDBBean) {
            kVar.f(1, placeDBBean.getLatitude());
            kVar.f(2, placeDBBean.getLongitude());
            if (placeDBBean.getName() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, placeDBBean.getName());
            }
            if (placeDBBean.getAddress() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, placeDBBean.getAddress());
            }
            if (placeDBBean.getDistance() == null) {
                kVar.m0(5);
            } else {
                kVar.s(5, placeDBBean.getDistance());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends h<PlaceDBBean> {
        public b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM `place_list` WHERE `latitude` = ? AND `longitude` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, PlaceDBBean placeDBBean) {
            kVar.f(1, placeDBBean.getLatitude());
            kVar.f(2, placeDBBean.getLongitude());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends SharedSQLiteStatement {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM place_list";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f51084a;

        public d(List list) {
            this.f51084a = list;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            a.this.f51077a.e();
            try {
                a.this.f51078b.j(this.f51084a);
                a.this.f51077a.E();
                return Unit.f68710a;
            } finally {
                a.this.f51077a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Callable<Unit> {
        public e() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            k kVarB = a.this.f51080d.b();
            a.this.f51077a.e();
            try {
                kVarB.F();
                a.this.f51077a.E();
                return Unit.f68710a;
            } finally {
                a.this.f51077a.i();
                a.this.f51080d.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements Callable<List<PlaceDBBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f51087a;

        public f(v vVar) {
            this.f51087a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<PlaceDBBean> call() throws Exception {
            Cursor cursorC = e6.b.c(a.this.f51077a, this.f51087a, false, null);
            try {
                int iE = e6.a.e(cursorC, "latitude");
                int iE2 = e6.a.e(cursorC, "longitude");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, PlaceTypes.ADDRESS);
                int iE5 = e6.a.e(cursorC, "distance");
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new PlaceDBBean(cursorC.getDouble(iE), cursorC.getDouble(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : cursorC.getString(iE5)));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.f51087a.release();
            }
        }
    }

    public a(RoomDatabase roomDatabase) {
        this.f51077a = roomDatabase;
        this.f51078b = new C0553a(roomDatabase);
        this.f51079c = new b(roomDatabase);
        this.f51080d = new c(roomDatabase);
    }

    public static List<Class<?>> h() {
        return Collections.emptyList();
    }

    @Override // com.transsion.baselib.db.place.PlaceDao
    public Object a(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f51077a, true, new e(), continuation);
    }

    @Override // com.transsion.baselib.db.place.PlaceDao
    public Object b(List<PlaceDBBean> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f51077a, true, new d(list), continuation);
    }

    @Override // com.transsion.baselib.db.place.PlaceDao
    public Object c(List<PlaceDBBean> list, Continuation<? super Unit> continuation) {
        return PlaceDao.DefaultImpls.a(this, list, continuation);
    }

    @Override // com.transsion.baselib.db.place.PlaceDao
    public Object d(Continuation<? super List<PlaceDBBean>> continuation) {
        v vVarC = v.c("SELECT * FROM place_list", 0);
        return CoroutinesRoom.a(this.f51077a, false, e6.b.a(), new f(vVarC), continuation);
    }
}
