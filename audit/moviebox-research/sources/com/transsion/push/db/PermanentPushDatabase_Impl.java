package com.transsion.push.db;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.f;
import androidx.room.u;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.web.api.WebConstants;
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
public final class PermanentPushDatabase_Impl extends PermanentPushDatabase {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile com.transsion.push.db.a f56859r;

    /* JADX INFO: compiled from: source.java */
    public class a extends u.b {
        public a(int i11) {
            super(i11);
        }

        @Override // androidx.room.u.b
        public void a(g gVar) {
            gVar.E("CREATE TABLE IF NOT EXISTS `permanent_item` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `deeplink` TEXT, `subject_id` TEXT, `image` TEXT, `title` TEXT)");
            gVar.E("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            gVar.E("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '1fffbd46e501ef2aa1bccfc7df8cf2d6')");
        }

        @Override // androidx.room.u.b
        public void b(g gVar) {
            gVar.E("DROP TABLE IF EXISTS `permanent_item`");
            if (PermanentPushDatabase_Impl.this.f12777h != null) {
                int size = PermanentPushDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) PermanentPushDatabase_Impl.this.f12777h.get(i11)).b(gVar);
                }
            }
        }

        @Override // androidx.room.u.b
        public void c(g gVar) {
            if (PermanentPushDatabase_Impl.this.f12777h != null) {
                int size = PermanentPushDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) PermanentPushDatabase_Impl.this.f12777h.get(i11)).a(gVar);
                }
            }
        }

        @Override // androidx.room.u.b
        public void d(g gVar) {
            PermanentPushDatabase_Impl.this.f12770a = gVar;
            PermanentPushDatabase_Impl.this.x(gVar);
            if (PermanentPushDatabase_Impl.this.f12777h != null) {
                int size = PermanentPushDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) PermanentPushDatabase_Impl.this.f12777h.get(i11)).c(gVar);
                }
            }
        }

        @Override // androidx.room.u.b
        public void e(g gVar) {
        }

        @Override // androidx.room.u.b
        public void f(g gVar) {
            e6.b.b(gVar);
        }

        @Override // androidx.room.u.b
        public u.c g(g gVar) {
            HashMap map = new HashMap(5);
            map.put("id", new e.a("id", "INTEGER", true, 1, null, 1));
            map.put(WebConstants.FIELD_DEEPLINK, new e.a(WebConstants.FIELD_DEEPLINK, "TEXT", false, 0, null, 1));
            map.put("subject_id", new e.a("subject_id", "TEXT", false, 0, null, 1));
            map.put("image", new e.a("image", "TEXT", false, 0, null, 1));
            map.put(CampaignEx.JSON_KEY_TITLE, new e.a(CampaignEx.JSON_KEY_TITLE, "TEXT", false, 0, null, 1));
            e eVar = new e("permanent_item", map, new HashSet(0), new HashSet(0));
            e eVarA = e.a(gVar, "permanent_item");
            if (eVar.equals(eVarA)) {
                return new u.c(true, null);
            }
            return new u.c(false, "permanent_item(com.transsion.push.bean.PermanentItemBean).\n Expected:\n" + eVar + "\n Found:\n" + eVarA);
        }
    }

    @Override // com.transsion.push.db.PermanentPushDatabase
    public com.transsion.push.db.a I() {
        com.transsion.push.db.a aVar;
        if (this.f56859r != null) {
            return this.f56859r;
        }
        synchronized (this) {
            try {
                if (this.f56859r == null) {
                    this.f56859r = new b(this);
                }
                aVar = this.f56859r;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker g() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "permanent_item");
    }

    @Override // androidx.room.RoomDatabase
    public h h(f fVar) {
        return fVar.f12842c.a(h.b.a(fVar.f12840a).d(fVar.f12841b).c(new u(fVar, new a(1), "1fffbd46e501ef2aa1bccfc7df8cf2d6", "ea621e991f9e4353c74e708cec62b4ff")).b());
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
        map.put(com.transsion.push.db.a.class, b.i());
        return map;
    }
}
