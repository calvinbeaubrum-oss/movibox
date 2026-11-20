package androidx.work.impl;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile s6.v f13328q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile s6.b f13329r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile s6.z f13330s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile s6.j f13331t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile s6.o f13332u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile s6.r f13333v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile s6.e f13334w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile s6.g f13335x;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a extends androidx.room.u.b {
        public a(int i11) {
            super(i11);
        }

        @Override // androidx.room.u.b
        public void a(g6.g gVar) {
            gVar.E("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            gVar.E("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
            gVar.E("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
            gVar.E("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `required_network_type` INTEGER NOT NULL, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
            gVar.E("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
            gVar.E("CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
            gVar.E("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            gVar.E("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            gVar.E("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            gVar.E("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            gVar.E("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
            gVar.E("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            gVar.E("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            gVar.E("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            gVar.E("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5181942b9ebc31ce68dacb56c16fd79f')");
        }

        @Override // androidx.room.u.b
        public void b(g6.g gVar) {
            gVar.E("DROP TABLE IF EXISTS `Dependency`");
            gVar.E("DROP TABLE IF EXISTS `WorkSpec`");
            gVar.E("DROP TABLE IF EXISTS `WorkTag`");
            gVar.E("DROP TABLE IF EXISTS `SystemIdInfo`");
            gVar.E("DROP TABLE IF EXISTS `WorkName`");
            gVar.E("DROP TABLE IF EXISTS `WorkProgress`");
            gVar.E("DROP TABLE IF EXISTS `Preference`");
            if (WorkDatabase_Impl.this.f12777h != null) {
                int size = WorkDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) WorkDatabase_Impl.this.f12777h.get(i11)).b(gVar);
                }
            }
        }

        @Override // androidx.room.u.b
        public void c(g6.g gVar) {
            if (WorkDatabase_Impl.this.f12777h != null) {
                int size = WorkDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) WorkDatabase_Impl.this.f12777h.get(i11)).a(gVar);
                }
            }
        }

        @Override // androidx.room.u.b
        public void d(g6.g gVar) {
            WorkDatabase_Impl.this.f12770a = gVar;
            gVar.E("PRAGMA foreign_keys = ON");
            WorkDatabase_Impl.this.x(gVar);
            if (WorkDatabase_Impl.this.f12777h != null) {
                int size = WorkDatabase_Impl.this.f12777h.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((RoomDatabase.b) WorkDatabase_Impl.this.f12777h.get(i11)).c(gVar);
                }
            }
        }

        @Override // androidx.room.u.b
        public void e(g6.g gVar) {
        }

        @Override // androidx.room.u.b
        public void f(g6.g gVar) {
            e6.b.b(gVar);
        }

        @Override // androidx.room.u.b
        public androidx.room.u.c g(g6.g gVar) {
            HashMap map = new HashMap(2);
            map.put("work_spec_id", new e6.e.a("work_spec_id", "TEXT", true, 1, null, 1));
            map.put("prerequisite_id", new e6.e.a("prerequisite_id", "TEXT", true, 2, null, 1));
            HashSet hashSet = new HashSet(2);
            hashSet.add(new e6.e.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            hashSet.add(new e6.e.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new e6.e.C0658e("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
            hashSet2.add(new e6.e.C0658e("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id"), Arrays.asList("ASC")));
            e6.e eVar = new e6.e("Dependency", map, hashSet, hashSet2);
            e6.e eVarA = e6.e.a(gVar, "Dependency");
            if (!eVar.equals(eVarA)) {
                return new androidx.room.u.c(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + eVar + "\n Found:\n" + eVarA);
            }
            HashMap map2 = new HashMap(27);
            map2.put("id", new e6.e.a("id", "TEXT", true, 1, null, 1));
            map2.put("state", new e6.e.a("state", "INTEGER", true, 0, null, 1));
            map2.put("worker_class_name", new e6.e.a("worker_class_name", "TEXT", true, 0, null, 1));
            map2.put("input_merger_class_name", new e6.e.a("input_merger_class_name", "TEXT", false, 0, null, 1));
            map2.put("input", new e6.e.a("input", "BLOB", true, 0, null, 1));
            map2.put("output", new e6.e.a("output", "BLOB", true, 0, null, 1));
            map2.put("initial_delay", new e6.e.a("initial_delay", "INTEGER", true, 0, null, 1));
            map2.put("interval_duration", new e6.e.a("interval_duration", "INTEGER", true, 0, null, 1));
            map2.put("flex_duration", new e6.e.a("flex_duration", "INTEGER", true, 0, null, 1));
            map2.put("run_attempt_count", new e6.e.a("run_attempt_count", "INTEGER", true, 0, null, 1));
            map2.put("backoff_policy", new e6.e.a("backoff_policy", "INTEGER", true, 0, null, 1));
            map2.put("backoff_delay_duration", new e6.e.a("backoff_delay_duration", "INTEGER", true, 0, null, 1));
            map2.put("last_enqueue_time", new e6.e.a("last_enqueue_time", "INTEGER", true, 0, null, 1));
            map2.put("minimum_retention_duration", new e6.e.a("minimum_retention_duration", "INTEGER", true, 0, null, 1));
            map2.put("schedule_requested_at", new e6.e.a("schedule_requested_at", "INTEGER", true, 0, null, 1));
            map2.put("run_in_foreground", new e6.e.a("run_in_foreground", "INTEGER", true, 0, null, 1));
            map2.put("out_of_quota_policy", new e6.e.a("out_of_quota_policy", "INTEGER", true, 0, null, 1));
            map2.put("period_count", new e6.e.a("period_count", "INTEGER", true, 0, "0", 1));
            map2.put("generation", new e6.e.a("generation", "INTEGER", true, 0, "0", 1));
            map2.put("required_network_type", new e6.e.a("required_network_type", "INTEGER", true, 0, null, 1));
            map2.put("requires_charging", new e6.e.a("requires_charging", "INTEGER", true, 0, null, 1));
            map2.put("requires_device_idle", new e6.e.a("requires_device_idle", "INTEGER", true, 0, null, 1));
            map2.put("requires_battery_not_low", new e6.e.a("requires_battery_not_low", "INTEGER", true, 0, null, 1));
            map2.put("requires_storage_not_low", new e6.e.a("requires_storage_not_low", "INTEGER", true, 0, null, 1));
            map2.put("trigger_content_update_delay", new e6.e.a("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
            map2.put("trigger_max_content_delay", new e6.e.a("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
            map2.put("content_uri_triggers", new e6.e.a("content_uri_triggers", "BLOB", true, 0, null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(2);
            hashSet4.add(new e6.e.C0658e("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at"), Arrays.asList("ASC")));
            hashSet4.add(new e6.e.C0658e("index_WorkSpec_last_enqueue_time", false, Arrays.asList("last_enqueue_time"), Arrays.asList("ASC")));
            e6.e eVar2 = new e6.e("WorkSpec", map2, hashSet3, hashSet4);
            e6.e eVarA2 = e6.e.a(gVar, "WorkSpec");
            if (!eVar2.equals(eVarA2)) {
                return new androidx.room.u.c(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + eVar2 + "\n Found:\n" + eVarA2);
            }
            HashMap map3 = new HashMap(2);
            map3.put("tag", new e6.e.a("tag", "TEXT", true, 1, null, 1));
            map3.put("work_spec_id", new e6.e.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet5 = new HashSet(1);
            hashSet5.add(new e6.e.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new e6.e.C0658e("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
            e6.e eVar3 = new e6.e("WorkTag", map3, hashSet5, hashSet6);
            e6.e eVarA3 = e6.e.a(gVar, "WorkTag");
            if (!eVar3.equals(eVarA3)) {
                return new androidx.room.u.c(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + eVar3 + "\n Found:\n" + eVarA3);
            }
            HashMap map4 = new HashMap(3);
            map4.put("work_spec_id", new e6.e.a("work_spec_id", "TEXT", true, 1, null, 1));
            map4.put("generation", new e6.e.a("generation", "INTEGER", true, 2, "0", 1));
            map4.put("system_id", new e6.e.a("system_id", "INTEGER", true, 0, null, 1));
            HashSet hashSet7 = new HashSet(1);
            hashSet7.add(new e6.e.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            e6.e eVar4 = new e6.e("SystemIdInfo", map4, hashSet7, new HashSet(0));
            e6.e eVarA4 = e6.e.a(gVar, "SystemIdInfo");
            if (!eVar4.equals(eVarA4)) {
                return new androidx.room.u.c(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + eVar4 + "\n Found:\n" + eVarA4);
            }
            HashMap map5 = new HashMap(2);
            map5.put("name", new e6.e.a("name", "TEXT", true, 1, null, 1));
            map5.put("work_spec_id", new e6.e.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet8 = new HashSet(1);
            hashSet8.add(new e6.e.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet9 = new HashSet(1);
            hashSet9.add(new e6.e.C0658e("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
            e6.e eVar5 = new e6.e("WorkName", map5, hashSet8, hashSet9);
            e6.e eVarA5 = e6.e.a(gVar, "WorkName");
            if (!eVar5.equals(eVarA5)) {
                return new androidx.room.u.c(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + eVar5 + "\n Found:\n" + eVarA5);
            }
            HashMap map6 = new HashMap(2);
            map6.put("work_spec_id", new e6.e.a("work_spec_id", "TEXT", true, 1, null, 1));
            map6.put(NotificationCompat.CATEGORY_PROGRESS, new e6.e.a(NotificationCompat.CATEGORY_PROGRESS, "BLOB", true, 0, null, 1));
            HashSet hashSet10 = new HashSet(1);
            hashSet10.add(new e6.e.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            e6.e eVar6 = new e6.e("WorkProgress", map6, hashSet10, new HashSet(0));
            e6.e eVarA6 = e6.e.a(gVar, "WorkProgress");
            if (!eVar6.equals(eVarA6)) {
                return new androidx.room.u.c(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + eVar6 + "\n Found:\n" + eVarA6);
            }
            HashMap map7 = new HashMap(2);
            map7.put("key", new e6.e.a("key", "TEXT", true, 1, null, 1));
            map7.put("long_value", new e6.e.a("long_value", "INTEGER", false, 0, null, 1));
            e6.e eVar7 = new e6.e("Preference", map7, new HashSet(0), new HashSet(0));
            e6.e eVarA7 = e6.e.a(gVar, "Preference");
            if (eVar7.equals(eVarA7)) {
                return new androidx.room.u.c(true, null);
            }
            return new androidx.room.u.c(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + eVar7 + "\n Found:\n" + eVarA7);
        }
    }

    @Override // androidx.work.impl.WorkDatabase
    public s6.b H() {
        s6.b bVar;
        if (this.f13329r != null) {
            return this.f13329r;
        }
        synchronized (this) {
            try {
                if (this.f13329r == null) {
                    this.f13329r = new s6.c(this);
                }
                bVar = this.f13329r;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public s6.e I() {
        s6.e eVar;
        if (this.f13334w != null) {
            return this.f13334w;
        }
        synchronized (this) {
            try {
                if (this.f13334w == null) {
                    this.f13334w = new s6.f(this);
                }
                eVar = this.f13334w;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return eVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public s6.g J() {
        s6.g gVar;
        if (this.f13335x != null) {
            return this.f13335x;
        }
        synchronized (this) {
            try {
                if (this.f13335x == null) {
                    this.f13335x = new s6.h(this);
                }
                gVar = this.f13335x;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return gVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public s6.j K() {
        s6.j jVar;
        if (this.f13331t != null) {
            return this.f13331t;
        }
        synchronized (this) {
            try {
                if (this.f13331t == null) {
                    this.f13331t = new s6.k(this);
                }
                jVar = this.f13331t;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return jVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public s6.o L() {
        s6.o oVar;
        if (this.f13332u != null) {
            return this.f13332u;
        }
        synchronized (this) {
            try {
                if (this.f13332u == null) {
                    this.f13332u = new s6.p(this);
                }
                oVar = this.f13332u;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return oVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public s6.r M() {
        s6.r rVar;
        if (this.f13333v != null) {
            return this.f13333v;
        }
        synchronized (this) {
            try {
                if (this.f13333v == null) {
                    this.f13333v = new s6.s(this);
                }
                rVar = this.f13333v;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return rVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public s6.v N() {
        s6.v vVar;
        if (this.f13328q != null) {
            return this.f13328q;
        }
        synchronized (this) {
            try {
                if (this.f13328q == null) {
                    this.f13328q = new s6.w(this);
                }
                vVar = this.f13328q;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return vVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public s6.z O() {
        s6.z zVar;
        if (this.f13330s != null) {
            return this.f13330s;
        }
        synchronized (this) {
            try {
                if (this.f13330s == null) {
                    this.f13330s = new s6.a0(this);
                }
                zVar = this.f13330s;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zVar;
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker g() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // androidx.room.RoomDatabase
    public g6.h h(androidx.room.f fVar) {
        return fVar.f12842c.a(g6.h.b.a(fVar.f12840a).d(fVar.f12841b).c(new androidx.room.u(fVar, new a(16), "5181942b9ebc31ce68dacb56c16fd79f", "ae2044fb577e65ee8bb576ca48a2f06e")).b());
    }

    @Override // androidx.room.RoomDatabase
    public List<d6.b> j(@NonNull Map<Class<? extends d6.a>, d6.a> map) {
        return Arrays.asList(new b0(), new c0());
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends d6.a>> p() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> q() {
        HashMap map = new HashMap();
        map.put(s6.v.class, s6.w.J());
        map.put(s6.b.class, s6.c.e());
        map.put(s6.z.class, s6.a0.e());
        map.put(s6.j.class, s6.k.h());
        map.put(s6.o.class, s6.p.c());
        map.put(s6.r.class, s6.s.d());
        map.put(s6.e.class, s6.f.b());
        map.put(s6.g.class, s6.h.d());
        return map;
    }
}
