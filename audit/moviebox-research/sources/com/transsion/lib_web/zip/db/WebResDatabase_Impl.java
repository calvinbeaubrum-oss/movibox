package com.transsion.lib_web.zip.db;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.f;
import androidx.room.u;
import e6.b;
import e6.e;
import g6.g;
import g6.h;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class WebResDatabase_Impl extends WebResDatabase {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile ju.a f53076s;

    /* JADX INFO: compiled from: source.java */
    public class a extends u.b {
        public a(int i11) {
            super(i11);
        }

        @Override // androidx.room.u.b
        public void a(g gVar) {
            gVar.E("CREATE TABLE IF NOT EXISTS `mb_web_res_db` (`scene` TEXT NOT NULL, `htmlUrl` TEXT NOT NULL, `zipUrl` TEXT NOT NULL, `zipMd5` TEXT NOT NULL, `sourceType` INTEGER NOT NULL, `updateTime` TEXT, PRIMARY KEY(`scene`))");
            gVar.E("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            gVar.E("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8fb9548e62ef8b007d7fa7c9d6d00479')");
        }

        @Override // androidx.room.u.b
        public void b(g gVar) {
            gVar.E("DROP TABLE IF EXISTS `mb_web_res_db`");
            if (WebResDatabase_Impl.this.f12777h != null) {
                int size = WebResDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) WebResDatabase_Impl.this.f12777h.get(i11)).b(gVar);
                }
            }
        }

        @Override // androidx.room.u.b
        public void c(g gVar) {
            if (WebResDatabase_Impl.this.f12777h != null) {
                int size = WebResDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) WebResDatabase_Impl.this.f12777h.get(i11)).a(gVar);
                }
            }
        }

        @Override // androidx.room.u.b
        public void d(g gVar) {
            WebResDatabase_Impl.this.f12770a = gVar;
            WebResDatabase_Impl.this.x(gVar);
            if (WebResDatabase_Impl.this.f12777h != null) {
                int size = WebResDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) WebResDatabase_Impl.this.f12777h.get(i11)).c(gVar);
                }
            }
        }

        @Override // androidx.room.u.b
        public void e(g gVar) {
        }

        @Override // androidx.room.u.b
        public void f(g gVar) {
            b.b(gVar);
        }

        @Override // androidx.room.u.b
        public u.c g(g gVar) {
            HashMap map = new HashMap(6);
            map.put("scene", new e.a("scene", "TEXT", true, 1, null, 1));
            map.put("htmlUrl", new e.a("htmlUrl", "TEXT", true, 0, null, 1));
            map.put("zipUrl", new e.a("zipUrl", "TEXT", true, 0, null, 1));
            map.put("zipMd5", new e.a("zipMd5", "TEXT", true, 0, null, 1));
            map.put("sourceType", new e.a("sourceType", "INTEGER", true, 0, null, 1));
            map.put("updateTime", new e.a("updateTime", "TEXT", false, 0, null, 1));
            e eVar = new e("mb_web_res_db", map, new HashSet(0), new HashSet(0));
            e eVarA = e.a(gVar, "mb_web_res_db");
            if (eVar.equals(eVarA)) {
                return new u.c(true, null);
            }
            return new u.c(false, "mb_web_res_db(com.transsion.lib_web.zip.db.WebViewCacheConfigData).\n Expected:\n" + eVar + "\n Found:\n" + eVarA);
        }
    }

    @Override // com.transsion.lib_web.zip.db.WebResDatabase
    public ju.a I() {
        ju.a aVar;
        if (this.f53076s != null) {
            return this.f53076s;
        }
        synchronized (this) {
            try {
                if (this.f53076s == null) {
                    this.f53076s = new ju.b(this);
                }
                aVar = this.f53076s;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker g() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "mb_web_res_db");
    }

    @Override // androidx.room.RoomDatabase
    public h h(f fVar) {
        return fVar.f12842c.a(h.b.a(fVar.f12840a).d(fVar.f12841b).c(new u(fVar, new a(1), "8fb9548e62ef8b007d7fa7c9d6d00479", "a675d4e34806d9830871c01a4db0b4d7")).b());
    }

    @Override // androidx.room.RoomDatabase
    public List<d6.b> j(@NonNull Map<Class<? extends d6.a>, d6.a> map) {
        return Arrays.asList(new d6.b[0]);
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends d6.a>> p() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> q() {
        HashMap map = new HashMap();
        map.put(ju.a.class, ju.b.i());
        return map;
    }
}
