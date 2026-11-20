package ju;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.v;
import com.transsion.lib_web.zip.db.WebViewCacheConfigData;
import g6.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements ju.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f68134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.i<WebViewCacheConfigData> f68135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.room.h<WebViewCacheConfigData> f68136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.room.h<WebViewCacheConfigData> f68137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f68138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SharedSQLiteStatement f68139f;

    /* JADX INFO: compiled from: source.java */
    public class a implements Callable<List<WebViewCacheConfigData>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f68140a;

        public a(v vVar) {
            this.f68140a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<WebViewCacheConfigData> call() throws Exception {
            Cursor cursorC = e6.b.c(b.this.f68134a, this.f68140a, false, null);
            try {
                int iE = e6.a.e(cursorC, "scene");
                int iE2 = e6.a.e(cursorC, "htmlUrl");
                int iE3 = e6.a.e(cursorC, "zipUrl");
                int iE4 = e6.a.e(cursorC, "zipMd5");
                int iE5 = e6.a.e(cursorC, "sourceType");
                int iE6 = e6.a.e(cursorC, "updateTime");
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new WebViewCacheConfigData(cursorC.isNull(iE) ? null : cursorC.getString(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.getInt(iE5), cursorC.isNull(iE6) ? null : cursorC.getString(iE6)));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.f68140a.release();
            }
        }
    }

    /* JADX INFO: renamed from: ju.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class CallableC0732b implements Callable<WebViewCacheConfigData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f68142a;

        public CallableC0732b(v vVar) {
            this.f68142a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WebViewCacheConfigData call() throws Exception {
            WebViewCacheConfigData webViewCacheConfigData = null;
            Cursor cursorC = e6.b.c(b.this.f68134a, this.f68142a, false, null);
            try {
                int iE = e6.a.e(cursorC, "scene");
                int iE2 = e6.a.e(cursorC, "htmlUrl");
                int iE3 = e6.a.e(cursorC, "zipUrl");
                int iE4 = e6.a.e(cursorC, "zipMd5");
                int iE5 = e6.a.e(cursorC, "sourceType");
                int iE6 = e6.a.e(cursorC, "updateTime");
                if (cursorC.moveToFirst()) {
                    webViewCacheConfigData = new WebViewCacheConfigData(cursorC.isNull(iE) ? null : cursorC.getString(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.getInt(iE5), cursorC.isNull(iE6) ? null : cursorC.getString(iE6));
                }
                return webViewCacheConfigData;
            } finally {
                cursorC.close();
                this.f68142a.release();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends androidx.room.i<WebViewCacheConfigData> {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `mb_web_res_db` (`scene`,`htmlUrl`,`zipUrl`,`zipMd5`,`sourceType`,`updateTime`) VALUES (?,?,?,?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, WebViewCacheConfigData webViewCacheConfigData) {
            if (webViewCacheConfigData.getScene() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, webViewCacheConfigData.getScene());
            }
            if (webViewCacheConfigData.getHtmlUrl() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, webViewCacheConfigData.getHtmlUrl());
            }
            if (webViewCacheConfigData.getZipUrl() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, webViewCacheConfigData.getZipUrl());
            }
            if (webViewCacheConfigData.getZipMd5() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, webViewCacheConfigData.getZipMd5());
            }
            kVar.V(5, webViewCacheConfigData.getSourceType());
            if (webViewCacheConfigData.getUpdateTime() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, webViewCacheConfigData.getUpdateTime());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends androidx.room.h<WebViewCacheConfigData> {
        public d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM `mb_web_res_db` WHERE `scene` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, WebViewCacheConfigData webViewCacheConfigData) {
            if (webViewCacheConfigData.getScene() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, webViewCacheConfigData.getScene());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends androidx.room.h<WebViewCacheConfigData> {
        public e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE OR ABORT `mb_web_res_db` SET `scene` = ?,`htmlUrl` = ?,`zipUrl` = ?,`zipMd5` = ?,`sourceType` = ?,`updateTime` = ? WHERE `scene` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, WebViewCacheConfigData webViewCacheConfigData) {
            if (webViewCacheConfigData.getScene() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, webViewCacheConfigData.getScene());
            }
            if (webViewCacheConfigData.getHtmlUrl() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, webViewCacheConfigData.getHtmlUrl());
            }
            if (webViewCacheConfigData.getZipUrl() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, webViewCacheConfigData.getZipUrl());
            }
            if (webViewCacheConfigData.getZipMd5() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, webViewCacheConfigData.getZipMd5());
            }
            kVar.V(5, webViewCacheConfigData.getSourceType());
            if (webViewCacheConfigData.getUpdateTime() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, webViewCacheConfigData.getUpdateTime());
            }
            if (webViewCacheConfigData.getScene() == null) {
                kVar.m0(7);
            } else {
                kVar.s(7, webViewCacheConfigData.getScene());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends SharedSQLiteStatement {
        public f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM mb_web_res_db";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends SharedSQLiteStatement {
        public g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM mb_web_res_db WHERE scene =?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebViewCacheConfigData f68149a;

        public h(WebViewCacheConfigData webViewCacheConfigData) {
            this.f68149a = webViewCacheConfigData;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f68134a.e();
            try {
                b.this.f68135b.k(this.f68149a);
                b.this.f68134a.E();
                return Unit.f68710a;
            } finally {
                b.this.f68134a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f68151a;

        public i(List list) {
            this.f68151a = list;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f68134a.e();
            try {
                b.this.f68136c.k(this.f68151a);
                b.this.f68134a.E();
                return Unit.f68710a;
            } finally {
                b.this.f68134a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class j implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebViewCacheConfigData f68153a;

        public j(WebViewCacheConfigData webViewCacheConfigData) {
            this.f68153a = webViewCacheConfigData;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f68134a.e();
            try {
                b.this.f68136c.j(this.f68153a);
                b.this.f68134a.E();
                return Unit.f68710a;
            } finally {
                b.this.f68134a.i();
            }
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f68134a = roomDatabase;
        this.f68135b = new c(roomDatabase);
        this.f68136c = new d(roomDatabase);
        this.f68137d = new e(roomDatabase);
        this.f68138e = new f(roomDatabase);
        this.f68139f = new g(roomDatabase);
    }

    public static List<Class<?>> i() {
        return Collections.emptyList();
    }

    @Override // ju.a
    public Object a(Continuation<? super List<WebViewCacheConfigData>> continuation) {
        v vVarC = v.c("SELECT * FROM mb_web_res_db", 0);
        return CoroutinesRoom.a(this.f68134a, false, e6.b.a(), new a(vVarC), continuation);
    }

    @Override // ju.a
    public Object b(String str, Continuation<? super WebViewCacheConfigData> continuation) {
        v vVarC = v.c("SELECT * FROM mb_web_res_db WHERE scene =?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f68134a, false, e6.b.a(), new CallableC0732b(vVarC), continuation);
    }

    @Override // ju.a
    public Object c(WebViewCacheConfigData webViewCacheConfigData, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f68134a, true, new h(webViewCacheConfigData), continuation);
    }

    @Override // ju.a
    public Object d(WebViewCacheConfigData webViewCacheConfigData, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f68134a, true, new j(webViewCacheConfigData), continuation);
    }

    @Override // ju.a
    public Object e(List<WebViewCacheConfigData> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f68134a, true, new i(list), continuation);
    }
}
