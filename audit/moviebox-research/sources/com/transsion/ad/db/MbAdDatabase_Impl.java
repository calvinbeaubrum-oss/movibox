package com.transsion.ad.db;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.f;
import androidx.room.u;
import com.google.android.libraries.places.api.model.PlaceTypes;
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
public final class MbAdDatabase_Impl extends MbAdDatabase {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile rq.a f50393v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile qq.a f50394w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile sq.a f50395x;

    /* JADX INFO: compiled from: source.java */
    public class a extends u.b {
        public a(int i11) {
            super(i11);
        }

        @Override // androidx.room.u.b
        public void a(g gVar) {
            gVar.E("CREATE TABLE IF NOT EXISTS `mb_ad_db_plans` (`id` TEXT NOT NULL, `version` TEXT, `name` TEXT, `startTime` TEXT, `endTime` TEXT, `extraConfig` TEXT, `displayTimes` INTEGER, `showedTimes` INTEGER, `showDate` TEXT, `advertiserName` TEXT, `advertiserAvatar` TEXT, `advertiserAvatarPath` TEXT, `brand` TEXT, `denyBrand` TEXT, `model` TEXT, `denyModel` TEXT, `country` TEXT, `scenes` TEXT, `adSource` TEXT, `extAdSlot` TEXT, `adMaterialList` TEXT, `adPlanUpdateTime` TEXT, `sort` INTEGER, `adShowLevel` TEXT, `filterClientVersion` TEXT, `adPlanCreateTime` TEXT, `appStarDesc` TEXT, `appSizeDesc` TEXT, `ctxEnableExpr` TEXT, `ctxDisableExpr` TEXT, `ctxAttributeConfig` TEXT, `dispatchTimeStart` TEXT, `dispatchTimeEnd` TEXT, `extImage` TEXT, `bidEcpmCent` REAL, `ecpmCent` INTEGER, PRIMARY KEY(`id`))");
            gVar.E("CREATE TABLE IF NOT EXISTS `local_mcc` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Country` TEXT NOT NULL, `Mcc` TEXT NOT NULL, `Iso` TEXT NOT NULL, `CountryCode` TEXT NOT NULL)");
            gVar.E("CREATE TABLE IF NOT EXISTS `ps_link_ad` (`id` INTEGER NOT NULL, `nonId` TEXT NOT NULL, `adSource` TEXT NOT NULL, `extAdSlot` TEXT NOT NULL, `rank` INTEGER NOT NULL, `psPlanId` TEXT, `psLinkAdInfoStr` TEXT, `psInfoJson` TEXT, PRIMARY KEY(`id`))");
            gVar.E("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            gVar.E("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f7fea39ad883a9756002ffde8cbb952c')");
        }

        @Override // androidx.room.u.b
        public void b(g gVar) {
            gVar.E("DROP TABLE IF EXISTS `mb_ad_db_plans`");
            gVar.E("DROP TABLE IF EXISTS `local_mcc`");
            gVar.E("DROP TABLE IF EXISTS `ps_link_ad`");
            if (MbAdDatabase_Impl.this.f12777h != null) {
                int size = MbAdDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) MbAdDatabase_Impl.this.f12777h.get(i11)).b(gVar);
                }
            }
        }

        @Override // androidx.room.u.b
        public void c(g gVar) {
            if (MbAdDatabase_Impl.this.f12777h != null) {
                int size = MbAdDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) MbAdDatabase_Impl.this.f12777h.get(i11)).a(gVar);
                }
            }
        }

        @Override // androidx.room.u.b
        public void d(g gVar) {
            MbAdDatabase_Impl.this.f12770a = gVar;
            MbAdDatabase_Impl.this.x(gVar);
            if (MbAdDatabase_Impl.this.f12777h != null) {
                int size = MbAdDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) MbAdDatabase_Impl.this.f12777h.get(i11)).c(gVar);
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
            HashMap map = new HashMap(36);
            map.put("id", new e.a("id", "TEXT", true, 1, null, 1));
            map.put("version", new e.a("version", "TEXT", false, 0, null, 1));
            map.put("name", new e.a("name", "TEXT", false, 0, null, 1));
            map.put("startTime", new e.a("startTime", "TEXT", false, 0, null, 1));
            map.put("endTime", new e.a("endTime", "TEXT", false, 0, null, 1));
            map.put("extraConfig", new e.a("extraConfig", "TEXT", false, 0, null, 1));
            map.put("displayTimes", new e.a("displayTimes", "INTEGER", false, 0, null, 1));
            map.put("showedTimes", new e.a("showedTimes", "INTEGER", false, 0, null, 1));
            map.put("showDate", new e.a("showDate", "TEXT", false, 0, null, 1));
            map.put("advertiserName", new e.a("advertiserName", "TEXT", false, 0, null, 1));
            map.put("advertiserAvatar", new e.a("advertiserAvatar", "TEXT", false, 0, null, 1));
            map.put("advertiserAvatarPath", new e.a("advertiserAvatarPath", "TEXT", false, 0, null, 1));
            map.put("brand", new e.a("brand", "TEXT", false, 0, null, 1));
            map.put("denyBrand", new e.a("denyBrand", "TEXT", false, 0, null, 1));
            map.put("model", new e.a("model", "TEXT", false, 0, null, 1));
            map.put("denyModel", new e.a("denyModel", "TEXT", false, 0, null, 1));
            map.put(PlaceTypes.COUNTRY, new e.a(PlaceTypes.COUNTRY, "TEXT", false, 0, null, 1));
            map.put("scenes", new e.a("scenes", "TEXT", false, 0, null, 1));
            map.put("adSource", new e.a("adSource", "TEXT", false, 0, null, 1));
            map.put("extAdSlot", new e.a("extAdSlot", "TEXT", false, 0, null, 1));
            map.put("adMaterialList", new e.a("adMaterialList", "TEXT", false, 0, null, 1));
            map.put("adPlanUpdateTime", new e.a("adPlanUpdateTime", "TEXT", false, 0, null, 1));
            map.put("sort", new e.a("sort", "INTEGER", false, 0, null, 1));
            map.put("adShowLevel", new e.a("adShowLevel", "TEXT", false, 0, null, 1));
            map.put("filterClientVersion", new e.a("filterClientVersion", "TEXT", false, 0, null, 1));
            map.put("adPlanCreateTime", new e.a("adPlanCreateTime", "TEXT", false, 0, null, 1));
            map.put("appStarDesc", new e.a("appStarDesc", "TEXT", false, 0, null, 1));
            map.put("appSizeDesc", new e.a("appSizeDesc", "TEXT", false, 0, null, 1));
            map.put("ctxEnableExpr", new e.a("ctxEnableExpr", "TEXT", false, 0, null, 1));
            map.put("ctxDisableExpr", new e.a("ctxDisableExpr", "TEXT", false, 0, null, 1));
            map.put("ctxAttributeConfig", new e.a("ctxAttributeConfig", "TEXT", false, 0, null, 1));
            map.put("dispatchTimeStart", new e.a("dispatchTimeStart", "TEXT", false, 0, null, 1));
            map.put("dispatchTimeEnd", new e.a("dispatchTimeEnd", "TEXT", false, 0, null, 1));
            map.put("extImage", new e.a("extImage", "TEXT", false, 0, null, 1));
            map.put("bidEcpmCent", new e.a("bidEcpmCent", "REAL", false, 0, null, 1));
            map.put("ecpmCent", new e.a("ecpmCent", "INTEGER", false, 0, null, 1));
            e eVar = new e("mb_ad_db_plans", map, new HashSet(0), new HashSet(0));
            e eVarA = e.a(gVar, "mb_ad_db_plans");
            if (!eVar.equals(eVarA)) {
                return new u.c(false, "mb_ad_db_plans(com.transsion.ad.db.plan.MbAdDbPlans).\n Expected:\n" + eVar + "\n Found:\n" + eVarA);
            }
            HashMap map2 = new HashMap(5);
            map2.put("id", new e.a("id", "INTEGER", true, 1, null, 1));
            map2.put("Country", new e.a("Country", "TEXT", true, 0, null, 1));
            map2.put("Mcc", new e.a("Mcc", "TEXT", true, 0, null, 1));
            map2.put("Iso", new e.a("Iso", "TEXT", true, 0, null, 1));
            map2.put("CountryCode", new e.a("CountryCode", "TEXT", true, 0, null, 1));
            e eVar2 = new e("local_mcc", map2, new HashSet(0), new HashSet(0));
            e eVarA2 = e.a(gVar, "local_mcc");
            if (!eVar2.equals(eVarA2)) {
                return new u.c(false, "local_mcc(com.transsion.ad.db.mcc.LocalMcc).\n Expected:\n" + eVar2 + "\n Found:\n" + eVarA2);
            }
            HashMap map3 = new HashMap(8);
            map3.put("id", new e.a("id", "INTEGER", true, 1, null, 1));
            map3.put("nonId", new e.a("nonId", "TEXT", true, 0, null, 1));
            map3.put("adSource", new e.a("adSource", "TEXT", true, 0, null, 1));
            map3.put("extAdSlot", new e.a("extAdSlot", "TEXT", true, 0, null, 1));
            map3.put("rank", new e.a("rank", "INTEGER", true, 0, null, 1));
            map3.put("psPlanId", new e.a("psPlanId", "TEXT", false, 0, null, 1));
            map3.put("psLinkAdInfoStr", new e.a("psLinkAdInfoStr", "TEXT", false, 0, null, 1));
            map3.put("psInfoJson", new e.a("psInfoJson", "TEXT", false, 0, null, 1));
            e eVar3 = new e("ps_link_ad", map3, new HashSet(0), new HashSet(0));
            e eVarA3 = e.a(gVar, "ps_link_ad");
            if (eVar3.equals(eVarA3)) {
                return new u.c(true, null);
            }
            return new u.c(false, "ps_link_ad(com.transsion.ad.db.pslink.PsLinkAdPlan).\n Expected:\n" + eVar3 + "\n Found:\n" + eVarA3);
        }
    }

    @Override // com.transsion.ad.db.MbAdDatabase
    public qq.a M() {
        qq.a aVar;
        if (this.f50394w != null) {
            return this.f50394w;
        }
        synchronized (this) {
            try {
                if (this.f50394w == null) {
                    this.f50394w = new qq.b(this);
                }
                aVar = this.f50394w;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    @Override // com.transsion.ad.db.MbAdDatabase
    public rq.a N() {
        rq.a aVar;
        if (this.f50393v != null) {
            return this.f50393v;
        }
        synchronized (this) {
            try {
                if (this.f50393v == null) {
                    this.f50393v = new rq.b(this);
                }
                aVar = this.f50393v;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    @Override // com.transsion.ad.db.MbAdDatabase
    public sq.a O() {
        sq.a aVar;
        if (this.f50395x != null) {
            return this.f50395x;
        }
        synchronized (this) {
            try {
                if (this.f50395x == null) {
                    this.f50395x = new sq.b(this);
                }
                aVar = this.f50395x;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker g() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "mb_ad_db_plans", "local_mcc", "ps_link_ad");
    }

    @Override // androidx.room.RoomDatabase
    public h h(f fVar) {
        return fVar.f12842c.a(h.b.a(fVar.f12840a).d(fVar.f12841b).c(new u(fVar, new a(5), "f7fea39ad883a9756002ffde8cbb952c", "0c9cf1c283ef75b75b73520a93381d32")).b());
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
        map.put(rq.a.class, rq.b.n());
        map.put(qq.a.class, qq.b.g());
        map.put(sq.a.class, sq.b.g());
        return map;
    }
}
