package com.vungle.warren.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.AdvertisementDBAdapter;
import com.vungle.warren.model.CookieDBAdapter;
import com.vungle.warren.model.ReportDBAdapter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class Repository {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f62250g = "Repository";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DatabaseHelper f62251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.vungle.warren.utility.w f62252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f62253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.vungle.warren.persistence.d f62254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f62255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<Class, com.vungle.warren.persistence.c> f62256f;

    /* JADX INFO: compiled from: source.java */
    public class a implements Callable<List<com.vungle.warren.model.c>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f62257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f62258b;

        public a(String str, String str2) {
            this.f62257a = str;
            this.f62258b = str2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<com.vungle.warren.model.c> call() {
            return Repository.this.F(this.f62257a, this.f62258b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    public class b<T> implements Callable<List<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f62260a;

        public b(Class cls) {
            this.f62260a = cls;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<T> call() {
            return Repository.this.Z(this.f62260a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Callable<List<com.vungle.warren.model.o>> {
        public c() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<com.vungle.warren.model.o> call() {
            List<com.vungle.warren.model.o> listZ = Repository.this.Z(com.vungle.warren.model.o.class);
            for (com.vungle.warren.model.o oVar : listZ) {
                oVar.k(2);
                try {
                    Repository.this.l0(oVar);
                } catch (DatabaseHelper.DBException unused) {
                    return null;
                }
            }
            return listZ;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Callable<List<com.vungle.warren.model.o>> {
        public d() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<com.vungle.warren.model.o> call() {
            com.vungle.warren.persistence.g gVar = new com.vungle.warren.persistence.g("report");
            gVar.f62329c = "status = ?  OR status = ? ";
            gVar.f62330d = new String[]{String.valueOf(1), String.valueOf(3)};
            List<com.vungle.warren.model.o> listZ = Repository.this.z(com.vungle.warren.model.o.class, Repository.this.f62251a.g(gVar));
            for (com.vungle.warren.model.o oVar : listZ) {
                oVar.k(2);
                try {
                    Repository.this.l0(oVar);
                } catch (DatabaseHelper.DBException unused) {
                    return null;
                }
            }
            return listZ;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f62264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f62265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f62266c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f62267d;

        public e(int i11, String str, int i12, String str2) {
            this.f62264a = i11;
            this.f62265b = str;
            this.f62266c = i12;
            this.f62267d = str2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            ContentValues contentValues = new ContentValues();
            contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(this.f62264a));
            com.vungle.warren.persistence.g gVar = new com.vungle.warren.persistence.g("report");
            gVar.f62329c = "placementId = ?  AND status = ?  AND appId = ? ";
            gVar.f62330d = new String[]{this.f62265b, String.valueOf(this.f62266c), this.f62267d};
            Repository.this.f62251a.h(gVar, contentValues);
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements Callable<List<com.vungle.warren.model.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f62269a;

        public f(String str) {
            this.f62269a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<com.vungle.warren.model.a> call() {
            return Repository.this.X(this.f62269a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f62271a;

        public g(Object obj) {
            this.f62271a = obj;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            Repository.this.y(this.f62271a);
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f62273a;

        public h(String str) {
            this.f62273a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            Repository.this.t(this.f62273a);
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i implements Callable<Collection<com.vungle.warren.model.m>> {
        public i() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<com.vungle.warren.model.m> call() {
            List<com.vungle.warren.model.m> listZ;
            synchronized (Repository.this) {
                com.vungle.warren.persistence.g gVar = new com.vungle.warren.persistence.g("placement");
                gVar.f62329c = "is_valid = ?";
                gVar.f62330d = new String[]{"1"};
                listZ = Repository.this.z(com.vungle.warren.model.m.class, Repository.this.f62251a.g(gVar));
            }
            return listZ;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class j implements Callable<File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f62276a;

        public j(String str) {
            this.f62276a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public File call() throws Exception {
            return Repository.this.f62254d.c(this.f62276a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class k implements Callable<Void> {
        public k() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            Repository.this.f62251a.c();
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 3);
            com.vungle.warren.persistence.g gVar = new com.vungle.warren.persistence.g("advertisement");
            gVar.f62329c = "state=?";
            gVar.f62330d = new String[]{String.valueOf(2)};
            Repository.this.f62251a.h(gVar, contentValues);
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class l implements Callable<Collection<String>> {
        public l() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<String> call() throws Exception {
            List listD0;
            synchronized (Repository.this) {
                listD0 = Repository.this.d0();
            }
            return listD0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class m implements Callable<List<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f62280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f62281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f62282c;

        public m(String str, int i11, int i12) {
            this.f62280a = str;
            this.f62281b = i11;
            this.f62282c = i12;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<String> call() {
            ArrayList arrayList;
            synchronized (Repository.this) {
                try {
                    com.vungle.warren.persistence.g gVar = new com.vungle.warren.persistence.g("advertisement");
                    String str = "bid_token != '' AND ( state = ? OR state = ? ) AND expire_time > ?";
                    if (!TextUtils.isEmpty(this.f62280a)) {
                        str = "bid_token != '' AND ( state = ? OR state = ? ) AND expire_time > ? AND placement_id = ?";
                    }
                    gVar.f62329c = str;
                    int length = 0;
                    gVar.f62328b = new String[]{"bid_token"};
                    String[] strArr = {String.valueOf(0), String.valueOf(1), String.valueOf(System.currentTimeMillis() / 1000)};
                    if (!TextUtils.isEmpty(this.f62280a)) {
                        strArr = new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(System.currentTimeMillis() / 1000), this.f62280a};
                    }
                    gVar.f62330d = strArr;
                    Cursor cursorG = Repository.this.f62251a.g(gVar);
                    arrayList = new ArrayList();
                    if (cursorG != null) {
                        while (cursorG.moveToNext() && length < this.f62281b) {
                            try {
                                try {
                                    String string = cursorG.getString(cursorG.getColumnIndex("bid_token"));
                                    if (string.getBytes().length + length <= this.f62281b) {
                                        length += string.getBytes().length + this.f62282c;
                                        arrayList.add(string);
                                    }
                                } catch (Throwable th2) {
                                    cursorG.close();
                                    throw th2;
                                }
                            } catch (Exception e11) {
                                VungleLogger.a(true, Repository.class.getSimpleName(), "getAvailableBidTokens", e11.toString());
                                ArrayList arrayList2 = new ArrayList();
                                cursorG.close();
                                return arrayList2;
                            }
                        }
                        cursorG.close();
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class n implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f62284a;

        public n(List list) {
            this.f62284a = list;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (Repository.class) {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("is_valid", Boolean.FALSE);
                    Repository.this.f62251a.h(new com.vungle.warren.persistence.g("placement"), contentValues);
                    for (com.vungle.warren.model.m mVar : this.f62284a) {
                        com.vungle.warren.model.m mVar2 = (com.vungle.warren.model.m) Repository.this.b0(mVar.d(), com.vungle.warren.model.m.class);
                        if (mVar2 != null && (mVar2.k() != mVar.k() || mVar2.j() != mVar.j())) {
                            Log.w(Repository.f62250g, "Placements data for " + mVar.d() + " is different from disc, deleting old");
                            Iterator it = Repository.this.K(mVar.d()).iterator();
                            while (it.hasNext()) {
                                Repository.this.t((String) it.next());
                            }
                            Repository.this.x(com.vungle.warren.model.m.class, mVar2.d());
                        }
                        if (mVar2 != null) {
                            mVar.q(mVar2.h());
                            mVar.o(mVar2.b());
                        }
                        mVar.p(mVar.f() != 2);
                        if (mVar.e() == Integer.MIN_VALUE) {
                            mVar.p(false);
                        }
                        Repository.this.l0(mVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class o implements Callable<List<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f62286a;

        public o(String str) {
            this.f62286a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<String> call() {
            return Repository.this.K(this.f62286a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class p implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f62288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.vungle.warren.model.c f62289b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f62290c;

        public p(int i11, com.vungle.warren.model.c cVar, String str) {
            this.f62288a = i11;
            this.f62289b = cVar;
            this.f62290c = str;
        }

        /* JADX WARN: Code duplicated, block: B:17:0x005f  */
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            String unused = Repository.f62250g;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Setting ");
            sb2.append(this.f62288a);
            sb2.append(" for adv ");
            sb2.append(this.f62289b.v());
            sb2.append(" and pl ");
            sb2.append(this.f62290c);
            this.f62289b.f0(this.f62288a);
            int i11 = this.f62288a;
            if (i11 == 0 || i11 == 1) {
                this.f62289b.e0(this.f62290c);
                Repository.this.l0(this.f62289b);
            } else if (i11 == 2) {
                this.f62289b.e0(null);
                Repository.this.l0(this.f62289b);
            } else if (i11 == 3 || i11 == 4) {
                Repository.this.t(this.f62289b.v());
            } else if (i11 == 5) {
                this.f62289b.e0(this.f62290c);
                Repository.this.l0(this.f62289b);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class q implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f62292a;

        public q(int i11) {
            this.f62292a = i11;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            com.vungle.warren.persistence.g gVar = new com.vungle.warren.persistence.g("vision_data");
            gVar.f62329c = "_id <= ( SELECT MAX( _id ) FROM vision_data ) - ?";
            gVar.f62330d = new String[]{Integer.toString(this.f62292a)};
            Repository.this.f62251a.a(gVar);
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class r implements Callable<d10.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f62294a;

        public r(long j11) {
            this.f62294a = j11;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d10.b call() {
            com.vungle.warren.persistence.g gVar = new com.vungle.warren.persistence.g("vision_data");
            gVar.f62329c = "timestamp >= ?";
            gVar.f62333g = "_id DESC";
            gVar.f62330d = new String[]{Long.toString(this.f62294a)};
            Cursor cursorG = Repository.this.f62251a.g(gVar);
            com.vungle.warren.model.s sVar = (com.vungle.warren.model.s) Repository.this.f62256f.get(com.vungle.warren.model.r.class);
            if (cursorG != null) {
                if (sVar != null) {
                    try {
                        if (cursorG.moveToFirst()) {
                            ContentValues contentValues = new ContentValues();
                            DatabaseUtils.cursorRowToContentValues(cursorG, contentValues);
                            return new d10.b(cursorG.getCount(), sVar.c(contentValues).f62234b);
                        }
                    } catch (Exception e11) {
                        VungleLogger.a(true, Repository.class.getSimpleName(), "getVisionAggregationInfo", e11.toString());
                        return null;
                    } finally {
                        cursorG.close();
                    }
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class s implements Callable<List<d10.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f62296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f62297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f62298c;

        public s(String str, int i11, long j11) {
            this.f62296a = str;
            this.f62297b = i11;
            this.f62298c = j11;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<d10.a> call() {
            ArrayList arrayList = new ArrayList();
            if (!"advertiser".equals(this.f62296a) && !"campaign".equals(this.f62296a) && !"creative".equals(this.f62296a)) {
                return arrayList;
            }
            com.vungle.warren.persistence.g gVar = new com.vungle.warren.persistence.g("vision_data");
            String str = this.f62296a;
            gVar.f62328b = new String[]{"COUNT ( * ) as viewCount", "MAX ( timestamp ) as lastTimeStamp", str};
            gVar.f62329c = "timestamp >= ?";
            gVar.f62331e = str;
            gVar.f62333g = "_id DESC";
            gVar.f62334h = Integer.toString(this.f62297b);
            gVar.f62330d = new String[]{Long.toString(this.f62298c)};
            Cursor cursorG = Repository.this.f62251a.g(gVar);
            if (cursorG != null) {
                while (cursorG.moveToNext()) {
                    try {
                        try {
                            ContentValues contentValues = new ContentValues();
                            DatabaseUtils.cursorRowToContentValues(cursorG, contentValues);
                            arrayList.add(new d10.a(contentValues.getAsString(this.f62296a), contentValues.getAsInteger("viewCount").intValue(), contentValues.getAsLong("lastTimeStamp").longValue()));
                        } catch (Exception e11) {
                            VungleLogger.a(true, Repository.class.getSimpleName(), "getVisionAggregationInfo", e11.toString());
                            ArrayList arrayList2 = new ArrayList();
                            cursorG.close();
                            return arrayList2;
                        }
                    } catch (Throwable th2) {
                        cursorG.close();
                        throw th2;
                    }
                }
                cursorG.close();
            }
            return arrayList;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    public class t<T> implements Callable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f62300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f62301b;

        public t(String str, Class cls) {
            this.f62300a = str;
            this.f62301b = cls;
        }

        @Override // java.util.concurrent.Callable
        public T call() {
            return (T) Repository.this.b0(this.f62300a, this.f62301b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class u implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f62303a;

        public u(Object obj) {
            this.f62303a = obj;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            Repository.this.l0(this.f62303a);
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class v implements Callable<com.vungle.warren.model.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f62305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f62306b;

        public v(String str, String str2) {
            this.f62305a = str;
            this.f62306b = str2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.vungle.warren.model.c call() {
            return Repository.this.D(this.f62305a, this.f62306b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class w implements Callable<com.vungle.warren.model.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f62308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f62309b;

        public w(String str, String str2) {
            this.f62308a = str;
            this.f62309b = str2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.vungle.warren.model.c call() {
            String[] strArr;
            com.vungle.warren.persistence.g gVar = new com.vungle.warren.persistence.g("advertisement");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("placement_id = ? AND ");
            sb2.append("(state = ? OR ");
            sb2.append("state = ?)");
            if (this.f62308a != null) {
                sb2.append(" AND item_id = ?");
                strArr = new String[]{this.f62309b, String.valueOf(1), String.valueOf(0), this.f62308a};
            } else {
                strArr = new String[]{this.f62309b, String.valueOf(1), String.valueOf(0)};
            }
            gVar.f62329c = sb2.toString();
            gVar.f62330d = strArr;
            Cursor cursorG = Repository.this.f62251a.g(gVar);
            com.vungle.warren.model.c cVarC = null;
            if (cursorG == null) {
                return null;
            }
            try {
                AdvertisementDBAdapter advertisementDBAdapter = (AdvertisementDBAdapter) Repository.this.f62256f.get(com.vungle.warren.model.c.class);
                if (advertisementDBAdapter != null && cursorG.moveToNext()) {
                    ContentValues contentValues = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(cursorG, contentValues);
                    cVarC = advertisementDBAdapter.c(contentValues);
                }
                return cVarC;
            } catch (Exception e11) {
                VungleLogger.a(true, Repository.class.getSimpleName(), "findPotentiallyExpiredAd", e11.toString());
                return null;
            } finally {
                cursorG.close();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface x<T> {
        void a(T t11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface y {
        void a(Exception exc);

        void b();
    }

    /* JADX INFO: compiled from: source.java */
    public static class z implements DatabaseHelper.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f62311a;

        public z(Context context) {
            this.f62311a = context;
        }

        @Override // com.vungle.warren.persistence.DatabaseHelper.a
        public void a(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS advertisement");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cookie");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS placement");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS report");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS adAsset");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS vision_data");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS analytic_url");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cache_bust");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS session_data");
        }

        @Override // com.vungle.warren.persistence.DatabaseHelper.a
        public void b(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
            if (i11 < 2) {
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN status INTEGER DEFAULT 1");
            }
            if (i11 < 3) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS vision_data(_id INTEGER PRIMARY KEY AUTOINCREMENT, timestamp NUMERIC, creative TEXT, campaign TEXT, advertiser TEXT )");
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN ad_size TEXT ");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN tt_download NUMERIC DEFAULT -1");
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN ad_size TEXT ");
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN refresh_duration NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN supported_template_types NUMERIC DEFAULT 0");
            }
            if (i11 < 4) {
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN header_bidding SHORT ");
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN header_bidding SHORT ");
            }
            if (i11 < 5) {
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN autocache_priority NUMERIC DEFAULT 2147483647");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN asset_download_timestamp NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN asset_download_duration NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN ad_request_start_time NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN init_timestamp NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN asset_download_duration NUMERIC DEFAULT 0");
            }
            if (i11 < 6) {
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN column_enable_om_sdk NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN column_om_sdk_extra_vast TEXT ");
            }
            if (i11 < 7) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS analytic_url(_id INTEGER PRIMARY KEY AUTOINCREMENT,  item_id TEXT UNIQUE)");
            }
            if (i11 < 8) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cache_bust(_id INTEGER PRIMARY KEY AUTOINCREMENT, item_id TEXT UNIQUE, id TEXT, time_window_end INTEGER, id_type INTEGER, event_ids TEXT, timestamp_processed INTEGER )");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN column_request_timestamp NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN max_hb_cache NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN recommended_ad_size TEXT ");
            }
            if (i11 < 9) {
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN play_remote_url SHORT DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN column_assets_fully_downloaded SHORT DEFAULT 0");
            }
            if (i11 < 10) {
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN column_click_coordinates_enabled SHORT DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN column_deep_link TEXT ");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN column_notifications TEXT ");
            }
            if (i11 < 11) {
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN column_header_bidding SHORT DEFAULT 0");
            }
        }

        @Override // com.vungle.warren.persistence.DatabaseHelper.a
        public void c(SQLiteDatabase sQLiteDatabase) {
            f();
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS advertisement(_id INTEGER PRIMARY KEY AUTOINCREMENT,  item_id TEXT UNIQUE, ad_config TEXT,ad_type INT, expire_time NUMERIC, delay NUMERIC, show_close_delay INT, show_close_incentivized INT, countdown INT, video_height INT, video_width INT, cta_overlay_enabled SHORT, cta_click_area NUMERIC, retry_count INT, requires_non_market_install SHORT, app_id TEXT, campaign TEXT, video_url TEXT, md5 TEXT, postroll_bundle_url TEXT, cta_destination_url TEXT, cta_url TEXT, ad_token TEXT, video_identifier TEXT, template_url TEXT, TEMPLATE_ID TEXT, TEMPLATE_TYPE TEXT, ad_market_id TEXT,bid_token TEXT,  checkpoints TEXT, template_settings TEXT, mraid_files TEXT, cacheable_assets TEXT, state INT, placement_id TEXT, tt_download NUMERIC,asset_download_timestamp NUMERIC,asset_download_duration NUMERIC,ad_request_start_time NUMERIC,column_enable_om_sdk SHORT,column_om_sdk_extra_vast TEXT,column_request_timestamp NUMERIC,column_click_coordinates_enabled SHORT,dynamic_events_and_urls TEXT, column_deep_link TEXT, column_notifications TEXT, column_assets_fully_downloaded SHORT, column_header_bidding SHORT)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS placement(_id INTEGER PRIMARY KEY AUTOINCREMENT, item_id TEXT UNIQUE, incentivized SHORT, auto_cached SHORT, is_valid SHORT, wakeup_time NUMERIC, header_bidding SHORT, refresh_duration NUMERIC, supported_template_types NUMERIC, ad_size TEXT, autocache_priority NUMERIC, max_hb_cache NUMERIC, recommended_ad_size TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cookie(_id INTEGER PRIMARY KEY AUTOINCREMENT, item_id TEXT UNIQUE, bools TEXT, ints TEXT, longs TEXT, strings TEXT )");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS report(_id INTEGER PRIMARY KEY AUTOINCREMENT, item_id TEXT UNIQUE,appId TEXT, placementId TEXT, adToken TEXT, incentivized SHORT, header_bidding SHORT, adStartTime NUMERIC, url TEXT, ad_duration NUMERIC, tt_download NUMERIC, campaign TEXT, videoViewed NUMERIC, ad_type TEXT, template_id TEXT, was_CTAC_licked SHORT, clicked_through TEXT, errors TEXT, user_actions TEXT, user_id TEXT, ordinal INT, videoLength NUMERIC, status INT, ad_size TEXT, init_timestamp NUMERIC, asset_download_duration NUMERIC,play_remote_url SHORT )");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS adAsset ( _id INTEGER PRIMARY KEY AUTOINCREMENT, item_id TEXT UNIQUE, paren_id TEXT , ad_identifier TEXT NOT NULL, server_path TEXT, local_path TEXT NOT NULL, file_status SHORT, file_type SHORT, file_size INT, retry_count SHORT, retry_error SHORT, unique ( local_path, ad_identifier ));");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS vision_data(_id INTEGER PRIMARY KEY AUTOINCREMENT, timestamp NUMERIC, creative TEXT, campaign TEXT, advertiser TEXT )");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS analytic_url(_id INTEGER PRIMARY KEY AUTOINCREMENT,  item_id TEXT UNIQUE)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cache_bust(_id INTEGER PRIMARY KEY AUTOINCREMENT, item_id TEXT UNIQUE, id TEXT, time_window_end INTEGER, id_type INTEGER, event_ids TEXT, timestamp_processed INTEGER )");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS session_data(_id INTEGER PRIMARY KEY AUTOINCREMENT, item_id TEXT UNIQUE,json_string TEXT, send_attempts INT)");
        }

        @Override // com.vungle.warren.persistence.DatabaseHelper.a
        public void d(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
            ArrayList arrayList = new ArrayList();
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM sqlite_master WHERE type='table'", null);
            while (cursorRawQuery != null && cursorRawQuery.moveToNext()) {
                String string = cursorRawQuery.getString(1);
                if (!string.equals("android_metadata") && !string.startsWith("sqlite_")) {
                    arrayList.add(string);
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ((String) it.next()));
            }
            c(sQLiteDatabase);
        }

        public final void e(String str) {
            this.f62311a.deleteDatabase(str);
        }

        public final void f() {
            e("vungle");
            File externalFilesDir = this.f62311a.getExternalFilesDir(null);
            if (Environment.getExternalStorageState().equals("mounted") && externalFilesDir != null && externalFilesDir.exists()) {
                try {
                    com.vungle.warren.utility.i.b(new File(externalFilesDir, ".vungle"));
                } catch (IOException e11) {
                    Log.e(Repository.f62250g, "IOException ", e11);
                }
            }
            File filesDir = this.f62311a.getFilesDir();
            if (filesDir.exists()) {
                try {
                    com.vungle.warren.utility.i.b(new File(filesDir, "vungle"));
                } catch (IOException e12) {
                    Log.e(Repository.f62250g, "IOException ", e12);
                }
            }
            try {
                com.vungle.warren.utility.i.b(new File(this.f62311a.getCacheDir() + File.separator + "downloads_vungle"));
            } catch (IOException e13) {
                Log.e(Repository.f62250g, "IOException ", e13);
            }
        }
    }

    public Repository(Context context, com.vungle.warren.persistence.d dVar, com.vungle.warren.utility.w wVar, ExecutorService executorService) {
        this(context, dVar, wVar, executorService, 11);
    }

    public Repository(Context context, com.vungle.warren.persistence.d dVar, com.vungle.warren.utility.w wVar, ExecutorService executorService, int i11) {
        this.f62256f = new HashMap();
        Context applicationContext = context.getApplicationContext();
        this.f62255e = applicationContext;
        this.f62252b = wVar;
        this.f62253c = executorService;
        this.f62251a = new DatabaseHelper(context, i11, new z(applicationContext));
        this.f62254d = dVar;
        this.f62256f.put(com.vungle.warren.model.m.class, new com.vungle.warren.model.n());
        this.f62256f.put(com.vungle.warren.model.j.class, new CookieDBAdapter());
        this.f62256f.put(com.vungle.warren.model.o.class, new ReportDBAdapter());
        this.f62256f.put(com.vungle.warren.model.c.class, new AdvertisementDBAdapter());
        this.f62256f.put(com.vungle.warren.model.a.class, new com.vungle.warren.model.b());
        this.f62256f.put(com.vungle.warren.model.r.class, new com.vungle.warren.model.s());
        this.f62256f.put(com.vungle.warren.model.e.class, new com.vungle.warren.model.f());
        this.f62256f.put(com.vungle.warren.model.h.class, new com.vungle.warren.model.i());
        this.f62256f.put(com.vungle.warren.model.p.class, new com.vungle.warren.model.q());
    }

    public com.vungle.warren.persistence.e<List<String>> A(String str) {
        return new com.vungle.warren.persistence.e<>(this.f62252b.submit(new o(str)));
    }

    public com.vungle.warren.persistence.e<com.vungle.warren.model.c> B(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" Searching for valid advertisement for placement with ");
        sb2.append(str);
        sb2.append(" event ID ");
        sb2.append(str2);
        return new com.vungle.warren.persistence.e<>(this.f62252b.submit(new w(str2, str)));
    }

    public com.vungle.warren.persistence.e<com.vungle.warren.model.c> C(String str, @Nullable String str2) {
        return new com.vungle.warren.persistence.e<>(this.f62252b.submit(new v(str, str2)));
    }

    @Nullable
    public final com.vungle.warren.model.c D(@NonNull String str, @Nullable String str2) {
        String[] strArr;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" Searching for valid advertisement for placement with ");
        sb2.append(str);
        sb2.append("event ID ");
        sb2.append(str2);
        com.vungle.warren.persistence.g gVar = new com.vungle.warren.persistence.g("advertisement");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("placement_id = ? AND ");
        sb3.append("(state = ? OR ");
        sb3.append("state = ?) AND ");
        sb3.append("expire_time > ?");
        if (str2 != null) {
            sb3.append(" AND item_id = ?");
            strArr = new String[]{str, String.valueOf(1), String.valueOf(0), String.valueOf(System.currentTimeMillis() / 1000), str2};
        } else {
            strArr = new String[]{str, String.valueOf(1), String.valueOf(0), String.valueOf(System.currentTimeMillis() / 1000)};
        }
        gVar.f62329c = sb3.toString();
        gVar.f62330d = strArr;
        gVar.f62334h = "1";
        Cursor cursorG = this.f62251a.g(gVar);
        com.vungle.warren.model.c cVarC = null;
        try {
            if (cursorG == null) {
                return null;
            }
            AdvertisementDBAdapter advertisementDBAdapter = (AdvertisementDBAdapter) this.f62256f.get(com.vungle.warren.model.c.class);
            if (advertisementDBAdapter != null && cursorG.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                DatabaseUtils.cursorRowToContentValues(cursorG, contentValues);
                cVarC = advertisementDBAdapter.c(contentValues);
            }
            return cVarC;
        } catch (Exception e11) {
            VungleLogger.a(true, Repository.class.getSimpleName(), "findValidAdvertisementForPlacementFromDB", e11.toString());
            return null;
        } finally {
            cursorG.close();
        }
    }

    public com.vungle.warren.persistence.e<List<com.vungle.warren.model.c>> E(String str, @Nullable String str2) {
        return new com.vungle.warren.persistence.e<>(this.f62252b.submit(new a(str, str2)));
    }

    public final List<com.vungle.warren.model.c> F(String str, String str2) {
        String[] strArr;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" Searching for valid advertisement for placement with ");
        sb2.append(str);
        sb2.append("event ID ");
        sb2.append(str2);
        com.vungle.warren.persistence.g gVar = new com.vungle.warren.persistence.g("advertisement");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("placement_id = ? AND ");
        sb3.append("(state = ? OR ");
        sb3.append("state = ?) AND ");
        sb3.append("expire_time > ?");
        if (str2 != null) {
            sb3.append(" AND item_id = ?");
            strArr = new String[]{str, String.valueOf(1), String.valueOf(0), String.valueOf(System.currentTimeMillis() / 1000), str2};
        } else {
            strArr = new String[]{str, String.valueOf(1), String.valueOf(0), String.valueOf(System.currentTimeMillis() / 1000)};
        }
        gVar.f62329c = sb3.toString();
        gVar.f62330d = strArr;
        gVar.f62333g = "state DESC";
        AdvertisementDBAdapter advertisementDBAdapter = (AdvertisementDBAdapter) this.f62256f.get(com.vungle.warren.model.c.class);
        ArrayList arrayList = new ArrayList();
        Cursor cursorG = this.f62251a.g(gVar);
        if (cursorG == null) {
            return arrayList;
        }
        while (advertisementDBAdapter != null) {
            try {
                try {
                    if (!cursorG.moveToNext()) {
                        break;
                    }
                    ContentValues contentValues = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(cursorG, contentValues);
                    arrayList.add(advertisementDBAdapter.c(contentValues));
                } catch (Exception e11) {
                    VungleLogger.a(true, Repository.class.getSimpleName(), "findValidAdvertisementsForPlacementFromDB", e11.toString());
                    ArrayList arrayList2 = new ArrayList();
                    cursorG.close();
                    return arrayList2;
                }
            } catch (Throwable th2) {
                cursorG.close();
                throw th2;
            }
            cursorG.close();
            throw th2;
        }
        cursorG.close();
        return arrayList;
    }

    public List<com.vungle.warren.model.c> G(String str) {
        return H(Collections.singletonList(str));
    }

    public List<com.vungle.warren.model.c> H(Collection<String> collection) {
        HashSet hashSet = new HashSet(collection);
        HashSet hashSet2 = new HashSet();
        for (com.vungle.warren.model.c cVar : Z(com.vungle.warren.model.c.class)) {
            if (hashSet.contains(cVar.o())) {
                hashSet2.add(cVar);
            }
        }
        return new ArrayList(hashSet2);
    }

    public List<com.vungle.warren.model.c> I(String str) {
        return J(Collections.singletonList(str));
    }

    public List<com.vungle.warren.model.c> J(Collection<String> collection) {
        HashSet hashSet = new HashSet(collection);
        HashSet hashSet2 = new HashSet();
        for (com.vungle.warren.model.c cVar : Z(com.vungle.warren.model.c.class)) {
            if (hashSet.contains(cVar.q())) {
                hashSet2.add(cVar);
            }
        }
        return new ArrayList(hashSet2);
    }

    public final List<String> K(String str) {
        com.vungle.warren.persistence.g gVar = new com.vungle.warren.persistence.g("advertisement");
        gVar.f62328b = new String[]{"item_id"};
        gVar.f62329c = "placement_id=?";
        gVar.f62330d = new String[]{str};
        ArrayList arrayList = new ArrayList();
        Cursor cursorG = this.f62251a.g(gVar);
        if (cursorG == null) {
            return arrayList;
        }
        while (cursorG.moveToNext()) {
            try {
                try {
                    arrayList.add(cursorG.getString(cursorG.getColumnIndex("item_id")));
                } catch (Exception e11) {
                    VungleLogger.a(true, Repository.class.getSimpleName(), "getAdsForPlacement", e11.toString());
                    ArrayList arrayList2 = new ArrayList();
                    cursorG.close();
                    return arrayList2;
                }
            } catch (Throwable th2) {
                cursorG.close();
                throw th2;
            }
        }
        cursorG.close();
        return arrayList;
    }

    public com.vungle.warren.persistence.e<File> L(String str) {
        return new com.vungle.warren.persistence.e<>(this.f62252b.submit(new j(str)));
    }

    public com.vungle.warren.persistence.e<List<String>> M(@Nullable String str, int i11, int i12) {
        return new com.vungle.warren.persistence.e<>(this.f62252b.submit(new m(str, i11, i12)));
    }

    public String N(com.vungle.warren.model.c cVar) {
        return cVar.z();
    }

    public List<com.vungle.warren.model.h> O() {
        List<com.vungle.warren.model.h> listZ = Z(com.vungle.warren.model.h.class);
        ArrayList arrayList = new ArrayList();
        for (com.vungle.warren.model.h hVar : listZ) {
            if (hVar.f() == 0) {
                arrayList.add(hVar);
            }
        }
        return arrayList;
    }

    public com.vungle.warren.persistence.e<Collection<String>> P() {
        return new com.vungle.warren.persistence.e<>(this.f62252b.submit(new l()));
    }

    public com.vungle.warren.persistence.e<List<d10.a>> Q(long j11, int i11, String str) {
        return new com.vungle.warren.persistence.e<>(this.f62252b.submit(new s(str, i11, j11)));
    }

    public com.vungle.warren.persistence.e<d10.b> R(long j11) {
        return new com.vungle.warren.persistence.e<>(this.f62252b.submit(new r(j11)));
    }

    public void S() throws DatabaseHelper.DBException {
        g0(new k());
    }

    public <T> com.vungle.warren.persistence.e<T> T(@NonNull String str, @NonNull Class<T> cls) {
        return new com.vungle.warren.persistence.e<>(this.f62252b.submit(new t(str, cls)));
    }

    public <T> void U(@NonNull final String str, @NonNull final Class<T> cls, @NonNull final x<T> xVar) {
        this.f62252b.execute(new Runnable() { // from class: com.vungle.warren.persistence.Repository.3
            @Override // java.lang.Runnable
            public void run() {
                final Object objB0 = Repository.this.b0(str, cls);
                Repository.this.f62253c.execute(new Runnable() { // from class: com.vungle.warren.persistence.Repository.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xVar.a(objB0);
                    }
                });
            }
        });
    }

    public <T> com.vungle.warren.persistence.e<List<T>> V(Class<T> cls) {
        return new com.vungle.warren.persistence.e<>(this.f62252b.submit(new b(cls)));
    }

    public List<com.vungle.warren.model.a> W(@NonNull String str, int i11) {
        com.vungle.warren.persistence.g gVar = new com.vungle.warren.persistence.g("adAsset");
        gVar.f62329c = "ad_identifier = ?  AND file_status = ? ";
        gVar.f62330d = new String[]{str, String.valueOf(i11)};
        return z(com.vungle.warren.model.a.class, this.f62251a.g(gVar));
    }

    public final List<com.vungle.warren.model.a> X(@NonNull String str) {
        com.vungle.warren.persistence.g gVar = new com.vungle.warren.persistence.g("adAsset");
        gVar.f62329c = "ad_identifier = ? ";
        gVar.f62330d = new String[]{str};
        return z(com.vungle.warren.model.a.class, this.f62251a.g(gVar));
    }

    public com.vungle.warren.persistence.e<List<com.vungle.warren.model.a>> Y(@NonNull String str) {
        return new com.vungle.warren.persistence.e<>(this.f62252b.submit(new f(str)));
    }

    public final <T> List<T> Z(Class<T> cls) {
        com.vungle.warren.persistence.c cVar = this.f62256f.get(cls);
        return cVar == null ? Collections.EMPTY_LIST : z(cls, this.f62251a.g(new com.vungle.warren.persistence.g(cVar.b())));
    }

    @Nullable
    public com.vungle.warren.persistence.e<List<com.vungle.warren.model.o>> a0() {
        return new com.vungle.warren.persistence.e<>(this.f62252b.submit(new c()));
    }

    public final <T> T b0(String str, Class<T> cls) {
        com.vungle.warren.persistence.c cVar = this.f62256f.get(cls);
        com.vungle.warren.persistence.g gVar = new com.vungle.warren.persistence.g(cVar.b());
        gVar.f62329c = "item_id = ? ";
        gVar.f62330d = new String[]{str};
        Cursor cursorG = this.f62251a.g(gVar);
        if (cursorG != null) {
            try {
                if (cursorG.moveToNext()) {
                    ContentValues contentValues = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(cursorG, contentValues);
                    return (T) cVar.c(contentValues);
                }
            } catch (Exception e11) {
                VungleLogger.a(true, Repository.class.getSimpleName(), "loadModel", e11.toString());
                return null;
            } finally {
                cursorG.close();
            }
            cursorG.close();
        }
        return null;
    }

    @Nullable
    public com.vungle.warren.persistence.e<List<com.vungle.warren.model.o>> c0() {
        return new com.vungle.warren.persistence.e<>(this.f62252b.submit(new d()));
    }

    public final List<String> d0() {
        com.vungle.warren.persistence.g gVar = new com.vungle.warren.persistence.g("placement");
        gVar.f62329c = "is_valid = ?";
        gVar.f62330d = new String[]{"1"};
        gVar.f62328b = new String[]{"item_id"};
        Cursor cursorG = this.f62251a.g(gVar);
        ArrayList arrayList = new ArrayList();
        if (cursorG != null) {
            while (cursorG.moveToNext()) {
                try {
                    try {
                        arrayList.add(cursorG.getString(cursorG.getColumnIndex("item_id")));
                    } catch (Exception e11) {
                        VungleLogger.a(true, Repository.class.getSimpleName(), "loadValidPlacementIds", e11.toString());
                    }
                } catch (Throwable th2) {
                    cursorG.close();
                    throw th2;
                }
            }
            cursorG.close();
        }
        return arrayList;
    }

    public com.vungle.warren.persistence.e<Collection<com.vungle.warren.model.m>> e0() {
        return new com.vungle.warren.persistence.e<>(this.f62252b.submit(new i()));
    }

    public final void f0(final y yVar, final Exception exc) {
        if (yVar != null) {
            this.f62253c.execute(new Runnable() { // from class: com.vungle.warren.persistence.Repository.7
                @Override // java.lang.Runnable
                public void run() {
                    yVar.a(exc);
                }
            });
        }
    }

    public final void g0(Callable<Void> callable) throws DatabaseHelper.DBException {
        try {
            this.f62252b.submit(callable).get();
        } catch (InterruptedException e11) {
            Log.e(f62250g, "InterruptedException ", e11);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e12) {
            if (e12.getCause() instanceof DatabaseHelper.DBException) {
                throw ((DatabaseHelper.DBException) e12.getCause());
            }
            Log.e(f62250g, "Exception during runAndWait", e12);
        }
    }

    public <T> void h0(T t11) throws DatabaseHelper.DBException {
        g0(new u(t11));
    }

    public <T> void i0(T t11, @Nullable y yVar) {
        j0(t11, yVar, true);
    }

    public <T> void j0(final T t11, @Nullable final y yVar, boolean z11) {
        Future<?> futureB = this.f62252b.b(new Runnable() { // from class: com.vungle.warren.persistence.Repository.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Repository.this.l0(t11);
                    if (yVar != null) {
                        Repository.this.f62253c.execute(new Runnable() { // from class: com.vungle.warren.persistence.Repository.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                yVar.b();
                            }
                        });
                    }
                } catch (DatabaseHelper.DBException e11) {
                    Repository.this.f0(yVar, e11);
                }
            }
        }, new Runnable() { // from class: com.vungle.warren.persistence.Repository.6
            @Override // java.lang.Runnable
            public void run() {
                Repository.this.f0(yVar, new VungleException(39));
            }
        });
        if (z11) {
            try {
                futureB.get();
            } catch (InterruptedException e11) {
                Log.e(f62250g, "InterruptedException ", e11);
                Thread.currentThread().interrupt();
            } catch (ExecutionException e12) {
                Log.e(f62250g, "Error on execution during saving", e12);
            }
        }
    }

    public void k0(@NonNull com.vungle.warren.model.c cVar, @NonNull String str, int i11) throws DatabaseHelper.DBException {
        g0(new p(i11, cVar, str));
    }

    public final <T> void l0(T t11) throws DatabaseHelper.DBException {
        com.vungle.warren.persistence.c cVar = this.f62256f.get(t11.getClass());
        this.f62251a.d(cVar.b(), cVar.a(t11), 5);
    }

    public void m0(@NonNull List<com.vungle.warren.model.m> list) throws DatabaseHelper.DBException {
        g0(new n(list));
    }

    public void n0(int i11) throws DatabaseHelper.DBException {
        g0(new q(i11));
    }

    public void o0(String str, String str2, int i11, int i12) throws DatabaseHelper.DBException {
        g0(new e(i12, str, i11, str2));
    }

    public void r() {
        this.f62251a.b();
        this.f62254d.a();
    }

    public <T> void s(T t11) throws DatabaseHelper.DBException {
        g0(new g(t11));
    }

    public final void t(String str) throws DatabaseHelper.DBException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        w(str);
        x(com.vungle.warren.model.c.class, str);
        try {
            this.f62254d.d(str);
        } catch (IOException e11) {
            Log.e(f62250g, "IOException ", e11);
        }
    }

    public void u(String str) throws DatabaseHelper.DBException {
        g0(new h(str));
    }

    public <T> void v(Class<T> cls) {
        if (cls == com.vungle.warren.model.c.class) {
            Iterator<T> it = V(com.vungle.warren.model.c.class).get().iterator();
            while (it.hasNext()) {
                try {
                    u(((com.vungle.warren.model.c) it.next()).v());
                } catch (DatabaseHelper.DBException e11) {
                    Log.e(f62250g, "DB Exception deleting advertisement", e11);
                }
            }
            return;
        }
        Iterator<T> it2 = V(cls).get().iterator();
        while (it2.hasNext()) {
            try {
                y(it2.next());
            } catch (DatabaseHelper.DBException e12) {
                Log.e(f62250g, "DB Exception deleting db entry", e12);
            }
        }
    }

    public final void w(String str) throws DatabaseHelper.DBException {
        com.vungle.warren.persistence.g gVar = new com.vungle.warren.persistence.g(this.f62256f.get(com.vungle.warren.model.a.class).b());
        gVar.f62329c = "ad_identifier=?";
        gVar.f62330d = new String[]{str};
        this.f62251a.a(gVar);
    }

    public final <T> void x(Class<T> cls, String str) throws DatabaseHelper.DBException {
        com.vungle.warren.persistence.g gVar = new com.vungle.warren.persistence.g(this.f62256f.get(cls).b());
        gVar.f62329c = "item_id=?";
        gVar.f62330d = new String[]{str};
        this.f62251a.a(gVar);
    }

    public final <T> void y(T t11) throws DatabaseHelper.DBException {
        x(t11.getClass(), this.f62256f.get(t11.getClass()).a(t11).getAsString("item_id"));
    }

    @NonNull
    public final <T> List<T> z(Class<T> cls, Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        try {
            com.vungle.warren.persistence.c cVar = this.f62256f.get(cls);
            while (cursor.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                DatabaseUtils.cursorRowToContentValues(cursor, contentValues);
                arrayList.add(cVar.c(contentValues));
            }
            return arrayList;
        } catch (Exception e11) {
            VungleLogger.a(true, Repository.class.getSimpleName(), "extractModels", e11.toString());
            return new ArrayList();
        } finally {
            cursor.close();
        }
    }
}
