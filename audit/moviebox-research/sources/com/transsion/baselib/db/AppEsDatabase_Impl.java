package com.transsion.baselib.db;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.f;
import androidx.room.u;
import com.mbridge.msdk.MBridgeConstans;
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
public final class AppEsDatabase_Impl extends AppEsDatabase {

    /* JADX INFO: compiled from: source.java */
    public class a extends u.b {
        public a(int i11) {
            super(i11);
        }

        @Override // androidx.room.u.b
        public void a(g gVar) {
            gVar.E("CREATE TABLE IF NOT EXISTS `download_es_table` (`url` TEXT NOT NULL, `resourceId` TEXT NOT NULL, `name` TEXT, `cover` TEXT, `size` INTEGER, `postId` TEXT, `sizeFormat` TEXT, `path` TEXT, `duration` INTEGER, `updateTimeStamp` INTEGER, `progress` INTEGER NOT NULL, `supportRanges` INTEGER NOT NULL, `status` INTEGER NOT NULL, `type` INTEGER NOT NULL, `readProgress` INTEGER NOT NULL, `createAt` INTEGER NOT NULL, `isRead` INTEGER NOT NULL, `subjectId` TEXT, `groupId` TEXT, PRIMARY KEY(`resourceId`))");
            gVar.E("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            gVar.E("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4287038e8589daee6007cf5dc19a4571')");
        }

        @Override // androidx.room.u.b
        public void b(g gVar) {
            gVar.E("DROP TABLE IF EXISTS `download_es_table`");
            if (AppEsDatabase_Impl.this.f12777h != null) {
                int size = AppEsDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) AppEsDatabase_Impl.this.f12777h.get(i11)).b(gVar);
                }
            }
        }

        @Override // androidx.room.u.b
        public void c(g gVar) {
            if (AppEsDatabase_Impl.this.f12777h != null) {
                int size = AppEsDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) AppEsDatabase_Impl.this.f12777h.get(i11)).a(gVar);
                }
            }
        }

        @Override // androidx.room.u.b
        public void d(g gVar) {
            AppEsDatabase_Impl.this.f12770a = gVar;
            AppEsDatabase_Impl.this.x(gVar);
            if (AppEsDatabase_Impl.this.f12777h != null) {
                int size = AppEsDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) AppEsDatabase_Impl.this.f12777h.get(i11)).c(gVar);
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
            HashMap map = new HashMap(19);
            map.put("url", new e.a("url", "TEXT", true, 0, null, 1));
            map.put("resourceId", new e.a("resourceId", "TEXT", true, 1, null, 1));
            map.put("name", new e.a("name", "TEXT", false, 0, null, 1));
            map.put("cover", new e.a("cover", "TEXT", false, 0, null, 1));
            map.put("size", new e.a("size", "INTEGER", false, 0, null, 1));
            map.put("postId", new e.a("postId", "TEXT", false, 0, null, 1));
            map.put("sizeFormat", new e.a("sizeFormat", "TEXT", false, 0, null, 1));
            map.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, new e.a(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, "TEXT", false, 0, null, 1));
            map.put("duration", new e.a("duration", "INTEGER", false, 0, null, 1));
            map.put("updateTimeStamp", new e.a("updateTimeStamp", "INTEGER", false, 0, null, 1));
            map.put(NotificationCompat.CATEGORY_PROGRESS, new e.a(NotificationCompat.CATEGORY_PROGRESS, "INTEGER", true, 0, null, 1));
            map.put("supportRanges", new e.a("supportRanges", "INTEGER", true, 0, null, 1));
            map.put(NotificationCompat.CATEGORY_STATUS, new e.a(NotificationCompat.CATEGORY_STATUS, "INTEGER", true, 0, null, 1));
            map.put("type", new e.a("type", "INTEGER", true, 0, null, 1));
            map.put("readProgress", new e.a("readProgress", "INTEGER", true, 0, null, 1));
            map.put("createAt", new e.a("createAt", "INTEGER", true, 0, null, 1));
            map.put("isRead", new e.a("isRead", "INTEGER", true, 0, null, 1));
            map.put("subjectId", new e.a("subjectId", "TEXT", false, 0, null, 1));
            map.put("groupId", new e.a("groupId", "TEXT", false, 0, null, 1));
            e eVar = new e("download_es_table", map, new HashSet(0), new HashSet(0));
            e eVarA = e.a(gVar, "download_es_table");
            if (eVar.equals(eVarA)) {
                return new u.c(true, null);
            }
            return new u.c(false, "download_es_table(com.transsion.baselib.db.download.DownloadEsBean).\n Expected:\n" + eVar + "\n Found:\n" + eVarA);
        }
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker g() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "download_es_table");
    }

    @Override // androidx.room.RoomDatabase
    public h h(f fVar) {
        return fVar.f12842c.a(h.b.a(fVar.f12840a).d(fVar.f12841b).c(new u(fVar, new a(2), "4287038e8589daee6007cf5dc19a4571", "a94f3a8f4d60d3a62bc9ff277e23feb3")).b());
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
        map.put(tr.e.class, tr.f.l());
        return map;
    }
}
