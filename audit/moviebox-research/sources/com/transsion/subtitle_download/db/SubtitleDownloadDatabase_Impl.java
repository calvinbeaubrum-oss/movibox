package com.transsion.subtitle_download.db;

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
/* JADX INFO: loaded from: classes8.dex */
public final class SubtitleDownloadDatabase_Impl extends SubtitleDownloadDatabase {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile dy.a f58355s;

    /* JADX INFO: compiled from: source.java */
    public class a extends u.b {
        public a(int i11) {
            super(i11);
        }

        @Override // androidx.room.u.b
        public void a(g gVar) {
            gVar.E("CREATE TABLE IF NOT EXISTS `st_download_table` (`id` TEXT NOT NULL, `resourceStreamType` INTEGER NOT NULL, `resourceId` TEXT NOT NULL, `lan` TEXT, `lanName` TEXT, `url` TEXT, `size` INTEGER, `delay` INTEGER, `downloads` INTEGER, `type` INTEGER NOT NULL, `postId` TEXT, `subtitleName` TEXT, `subjectId` TEXT, `ep` INTEGER NOT NULL, `se` INTEGER NOT NULL, `resolution` INTEGER NOT NULL, `subjectName` TEXT, `status` INTEGER NOT NULL, `fileCharsetName` TEXT, `path` TEXT, `zipPath` TEXT NOT NULL, `taskId` TEXT, `failCount` INTEGER NOT NULL, PRIMARY KEY(`id`, `resourceStreamType`))");
            gVar.E("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            gVar.E("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '2a6980ede6ae77ce66f55b52702a3b6b')");
        }

        @Override // androidx.room.u.b
        public void b(g gVar) {
            gVar.E("DROP TABLE IF EXISTS `st_download_table`");
            if (SubtitleDownloadDatabase_Impl.this.f12777h != null) {
                int size = SubtitleDownloadDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) SubtitleDownloadDatabase_Impl.this.f12777h.get(i11)).b(gVar);
                }
            }
        }

        @Override // androidx.room.u.b
        public void c(g gVar) {
            if (SubtitleDownloadDatabase_Impl.this.f12777h != null) {
                int size = SubtitleDownloadDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) SubtitleDownloadDatabase_Impl.this.f12777h.get(i11)).a(gVar);
                }
            }
        }

        @Override // androidx.room.u.b
        public void d(g gVar) {
            SubtitleDownloadDatabase_Impl.this.f12770a = gVar;
            SubtitleDownloadDatabase_Impl.this.x(gVar);
            if (SubtitleDownloadDatabase_Impl.this.f12777h != null) {
                int size = SubtitleDownloadDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) SubtitleDownloadDatabase_Impl.this.f12777h.get(i11)).c(gVar);
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
            HashMap map = new HashMap(23);
            map.put("id", new e.a("id", "TEXT", true, 1, null, 1));
            map.put("resourceStreamType", new e.a("resourceStreamType", "INTEGER", true, 2, null, 1));
            map.put("resourceId", new e.a("resourceId", "TEXT", true, 0, null, 1));
            map.put("lan", new e.a("lan", "TEXT", false, 0, null, 1));
            map.put("lanName", new e.a("lanName", "TEXT", false, 0, null, 1));
            map.put("url", new e.a("url", "TEXT", false, 0, null, 1));
            map.put("size", new e.a("size", "INTEGER", false, 0, null, 1));
            map.put("delay", new e.a("delay", "INTEGER", false, 0, null, 1));
            map.put("downloads", new e.a("downloads", "INTEGER", false, 0, null, 1));
            map.put("type", new e.a("type", "INTEGER", true, 0, null, 1));
            map.put("postId", new e.a("postId", "TEXT", false, 0, null, 1));
            map.put("subtitleName", new e.a("subtitleName", "TEXT", false, 0, null, 1));
            map.put("subjectId", new e.a("subjectId", "TEXT", false, 0, null, 1));
            map.put("ep", new e.a("ep", "INTEGER", true, 0, null, 1));
            map.put("se", new e.a("se", "INTEGER", true, 0, null, 1));
            map.put("resolution", new e.a("resolution", "INTEGER", true, 0, null, 1));
            map.put("subjectName", new e.a("subjectName", "TEXT", false, 0, null, 1));
            map.put(NotificationCompat.CATEGORY_STATUS, new e.a(NotificationCompat.CATEGORY_STATUS, "INTEGER", true, 0, null, 1));
            map.put("fileCharsetName", new e.a("fileCharsetName", "TEXT", false, 0, null, 1));
            map.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, new e.a(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, "TEXT", false, 0, null, 1));
            map.put("zipPath", new e.a("zipPath", "TEXT", true, 0, null, 1));
            map.put("taskId", new e.a("taskId", "TEXT", false, 0, null, 1));
            map.put("failCount", new e.a("failCount", "INTEGER", true, 0, null, 1));
            e eVar = new e("st_download_table", map, new HashSet(0), new HashSet(0));
            e eVarA = e.a(gVar, "st_download_table");
            if (eVar.equals(eVarA)) {
                return new u.c(true, null);
            }
            return new u.c(false, "st_download_table(com.transsion.subtitle_download.db.SubtitleDownloadTable).\n Expected:\n" + eVar + "\n Found:\n" + eVarA);
        }
    }

    @Override // com.transsion.subtitle_download.db.SubtitleDownloadDatabase
    public dy.a J() {
        dy.a aVar;
        if (this.f58355s != null) {
            return this.f58355s;
        }
        synchronized (this) {
            try {
                if (this.f58355s == null) {
                    this.f58355s = new dy.b(this);
                }
                aVar = this.f58355s;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker g() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "st_download_table");
    }

    @Override // androidx.room.RoomDatabase
    public h h(f fVar) {
        return fVar.f12842c.a(h.b.a(fVar.f12840a).d(fVar.f12841b).c(new u(fVar, new a(2), "2a6980ede6ae77ce66f55b52702a3b6b", "6bc9377253249575a8d9767c13dacf0a")).b());
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
        map.put(dy.a.class, dy.b.k());
        return map;
    }
}
