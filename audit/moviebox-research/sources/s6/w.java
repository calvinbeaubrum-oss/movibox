package s6;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f76228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.i<u> f76229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.room.h<u> f76230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f76231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f76232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SharedSQLiteStatement f76233f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SharedSQLiteStatement f76234g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SharedSQLiteStatement f76235h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SharedSQLiteStatement f76236i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SharedSQLiteStatement f76237j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SharedSQLiteStatement f76238k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SharedSQLiteStatement f76239l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SharedSQLiteStatement f76240m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SharedSQLiteStatement f76241n;

    /* JADX INFO: compiled from: source.java */
    public class a extends SharedSQLiteStatement {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends SharedSQLiteStatement {
        public b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends SharedSQLiteStatement {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends SharedSQLiteStatement {
        public d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE workspec SET generation=generation+1 WHERE id=?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Callable<List<u.c>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.v f76246a;

        public e(androidx.room.v vVar) {
            this.f76246a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<u.c> call() throws Exception {
            w.this.f76228a.e();
            try {
                Cursor cursorC = e6.b.c(w.this.f76228a, this.f76246a, true, null);
                try {
                    androidx.collection.a aVar = new androidx.collection.a();
                    androidx.collection.a aVar2 = new androidx.collection.a();
                    while (cursorC.moveToNext()) {
                        String string = cursorC.getString(0);
                        if (((ArrayList) aVar.get(string)) == null) {
                            aVar.put(string, new ArrayList());
                        }
                        String string2 = cursorC.getString(0);
                        if (((ArrayList) aVar2.get(string2)) == null) {
                            aVar2.put(string2, new ArrayList());
                        }
                    }
                    cursorC.moveToPosition(-1);
                    w.this.F(aVar);
                    w.this.E(aVar2);
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string3 = cursorC.isNull(0) ? null : cursorC.getString(0);
                        WorkInfo.State stateF = b0.f(cursorC.getInt(1));
                        androidx.work.d dVarG = androidx.work.d.g(cursorC.isNull(2) ? null : cursorC.getBlob(2));
                        int i11 = cursorC.getInt(3);
                        int i12 = cursorC.getInt(4);
                        ArrayList arrayList2 = (ArrayList) aVar.get(cursorC.getString(0));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = arrayList2;
                        ArrayList arrayList4 = (ArrayList) aVar2.get(cursorC.getString(0));
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList.add(new u.c(string3, stateF, dVarG, i11, i12, arrayList3, arrayList4));
                    }
                    w.this.f76228a.E();
                    cursorC.close();
                    w.this.f76228a.i();
                    return arrayList;
                } catch (Throwable th2) {
                    cursorC.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                w.this.f76228a.i();
                throw th3;
            }
        }

        public void finalize() {
            this.f76246a.release();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends androidx.room.i<u> {
        public f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, u uVar) throws Throwable {
            String str = uVar.f76199a;
            if (str == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, str);
            }
            b0 b0Var = b0.f76156a;
            kVar.V(2, b0.j(uVar.f76200b));
            String str2 = uVar.f76201c;
            if (str2 == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, str2);
            }
            String str3 = uVar.f76202d;
            if (str3 == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, str3);
            }
            byte[] bArrK = androidx.work.d.k(uVar.f76203e);
            if (bArrK == null) {
                kVar.m0(5);
            } else {
                kVar.c0(5, bArrK);
            }
            byte[] bArrK2 = androidx.work.d.k(uVar.f76204f);
            if (bArrK2 == null) {
                kVar.m0(6);
            } else {
                kVar.c0(6, bArrK2);
            }
            kVar.V(7, uVar.f76205g);
            kVar.V(8, uVar.f76206h);
            kVar.V(9, uVar.f76207i);
            kVar.V(10, uVar.f76209k);
            kVar.V(11, b0.a(uVar.f76210l));
            kVar.V(12, uVar.f76211m);
            kVar.V(13, uVar.f76212n);
            kVar.V(14, uVar.f76213o);
            kVar.V(15, uVar.f76214p);
            kVar.V(16, uVar.f76215q ? 1L : 0L);
            kVar.V(17, b0.h(uVar.f76216r));
            kVar.V(18, uVar.g());
            kVar.V(19, uVar.f());
            androidx.work.b bVar = uVar.f76208j;
            if (bVar == null) {
                kVar.m0(20);
                kVar.m0(21);
                kVar.m0(22);
                kVar.m0(23);
                kVar.m0(24);
                kVar.m0(25);
                kVar.m0(26);
                kVar.m0(27);
                return;
            }
            kVar.V(20, b0.g(bVar.d()));
            kVar.V(21, bVar.g() ? 1L : 0L);
            kVar.V(22, bVar.h() ? 1L : 0L);
            kVar.V(23, bVar.f() ? 1L : 0L);
            kVar.V(24, bVar.i() ? 1L : 0L);
            kVar.V(25, bVar.b());
            kVar.V(26, bVar.a());
            byte[] bArrI = b0.i(bVar.c());
            if (bArrI == null) {
                kVar.m0(27);
            } else {
                kVar.c0(27, bArrI);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends androidx.room.h<u> {
        public g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`required_network_type` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, u uVar) throws Throwable {
            String str = uVar.f76199a;
            if (str == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, str);
            }
            b0 b0Var = b0.f76156a;
            kVar.V(2, b0.j(uVar.f76200b));
            String str2 = uVar.f76201c;
            if (str2 == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, str2);
            }
            String str3 = uVar.f76202d;
            if (str3 == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, str3);
            }
            byte[] bArrK = androidx.work.d.k(uVar.f76203e);
            if (bArrK == null) {
                kVar.m0(5);
            } else {
                kVar.c0(5, bArrK);
            }
            byte[] bArrK2 = androidx.work.d.k(uVar.f76204f);
            if (bArrK2 == null) {
                kVar.m0(6);
            } else {
                kVar.c0(6, bArrK2);
            }
            kVar.V(7, uVar.f76205g);
            kVar.V(8, uVar.f76206h);
            kVar.V(9, uVar.f76207i);
            kVar.V(10, uVar.f76209k);
            kVar.V(11, b0.a(uVar.f76210l));
            kVar.V(12, uVar.f76211m);
            kVar.V(13, uVar.f76212n);
            kVar.V(14, uVar.f76213o);
            kVar.V(15, uVar.f76214p);
            kVar.V(16, uVar.f76215q ? 1L : 0L);
            kVar.V(17, b0.h(uVar.f76216r));
            kVar.V(18, uVar.g());
            kVar.V(19, uVar.f());
            androidx.work.b bVar = uVar.f76208j;
            if (bVar != null) {
                kVar.V(20, b0.g(bVar.d()));
                kVar.V(21, bVar.g() ? 1L : 0L);
                kVar.V(22, bVar.h() ? 1L : 0L);
                kVar.V(23, bVar.f() ? 1L : 0L);
                kVar.V(24, bVar.i() ? 1L : 0L);
                kVar.V(25, bVar.b());
                kVar.V(26, bVar.a());
                byte[] bArrI = b0.i(bVar.c());
                if (bArrI == null) {
                    kVar.m0(27);
                } else {
                    kVar.c0(27, bArrI);
                }
            } else {
                kVar.m0(20);
                kVar.m0(21);
                kVar.m0(22);
                kVar.m0(23);
                kVar.m0(24);
                kVar.m0(25);
                kVar.m0(26);
                kVar.m0(27);
            }
            String str4 = uVar.f76199a;
            if (str4 == null) {
                kVar.m0(28);
            } else {
                kVar.s(28, str4);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends SharedSQLiteStatement {
        public h(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i extends SharedSQLiteStatement {
        public i(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE workspec SET state=? WHERE id=?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class j extends SharedSQLiteStatement {
        public j(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class k extends SharedSQLiteStatement {
        public k(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class l extends SharedSQLiteStatement {
        public l(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class m extends SharedSQLiteStatement {
        public m(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class n extends SharedSQLiteStatement {
        public n(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    public w(RoomDatabase roomDatabase) {
        this.f76228a = roomDatabase;
        this.f76229b = new f(roomDatabase);
        this.f76230c = new g(roomDatabase);
        this.f76231d = new h(roomDatabase);
        this.f76232e = new i(roomDatabase);
        this.f76233f = new j(roomDatabase);
        this.f76234g = new k(roomDatabase);
        this.f76235h = new l(roomDatabase);
        this.f76236i = new m(roomDatabase);
        this.f76237j = new n(roomDatabase);
        this.f76238k = new a(roomDatabase);
        this.f76239l = new b(roomDatabase);
        this.f76240m = new c(roomDatabase);
        this.f76241n = new d(roomDatabase);
    }

    public static List<Class<?>> J() {
        return Collections.emptyList();
    }

    @Override // s6.v
    public List<u.c> A(String str) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        this.f76228a.d();
        this.f76228a.e();
        try {
            Cursor cursorC = e6.b.c(this.f76228a, vVarC, true, null);
            try {
                androidx.collection.a<String, ArrayList<String>> aVar = new androidx.collection.a<>();
                androidx.collection.a<String, ArrayList<androidx.work.d>> aVar2 = new androidx.collection.a<>();
                while (cursorC.moveToNext()) {
                    String string = cursorC.getString(0);
                    if (aVar.get(string) == null) {
                        aVar.put(string, new ArrayList<>());
                    }
                    String string2 = cursorC.getString(0);
                    if (aVar2.get(string2) == null) {
                        aVar2.put(string2, new ArrayList<>());
                    }
                }
                cursorC.moveToPosition(-1);
                F(aVar);
                E(aVar2);
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    String string3 = cursorC.isNull(0) ? null : cursorC.getString(0);
                    WorkInfo.State stateF = b0.f(cursorC.getInt(1));
                    androidx.work.d dVarG = androidx.work.d.g(cursorC.isNull(2) ? null : cursorC.getBlob(2));
                    int i11 = cursorC.getInt(3);
                    int i12 = cursorC.getInt(4);
                    ArrayList<String> arrayList2 = aVar.get(cursorC.getString(0));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    ArrayList<String> arrayList3 = arrayList2;
                    ArrayList<androidx.work.d> arrayList4 = aVar2.get(cursorC.getString(0));
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList<>();
                    }
                    arrayList.add(new u.c(string3, stateF, dVarG, i11, i12, arrayList3, arrayList4));
                }
                this.f76228a.E();
                cursorC.close();
                vVarC.release();
                this.f76228a.i();
                return arrayList;
            } catch (Throwable th2) {
                cursorC.close();
                vVarC.release();
                throw th2;
            }
        } catch (Throwable th3) {
            this.f76228a.i();
            throw th3;
        }
    }

    @Override // s6.v
    public LiveData<List<u.c>> B(List<String> list) {
        StringBuilder sbB = e6.d.b();
        sbB.append("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (");
        int size = list.size();
        e6.d.a(sbB, size);
        sbB.append(")");
        androidx.room.v vVarC = androidx.room.v.c(sbB.toString(), size);
        int i11 = 1;
        for (String str : list) {
            if (str == null) {
                vVarC.m0(i11);
            } else {
                vVarC.s(i11, str);
            }
            i11++;
        }
        return this.f76228a.m().e(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, new e(vVarC));
    }

    @Override // s6.v
    public int C(String str) {
        this.f76228a.d();
        g6.k kVarB = this.f76236i.b();
        if (str == null) {
            kVarB.m0(1);
        } else {
            kVarB.s(1, str);
        }
        this.f76228a.e();
        try {
            int iF = kVarB.F();
            this.f76228a.E();
            return iF;
        } finally {
            this.f76228a.i();
            this.f76236i.h(kVarB);
        }
    }

    @Override // s6.v
    public List<u.c> D(List<String> list) {
        StringBuilder sbB = e6.d.b();
        sbB.append("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (");
        int size = list.size();
        e6.d.a(sbB, size);
        sbB.append(")");
        androidx.room.v vVarC = androidx.room.v.c(sbB.toString(), size);
        int i11 = 1;
        for (String str : list) {
            if (str == null) {
                vVarC.m0(i11);
            } else {
                vVarC.s(i11, str);
            }
            i11++;
        }
        this.f76228a.d();
        this.f76228a.e();
        try {
            Cursor cursorC = e6.b.c(this.f76228a, vVarC, true, null);
            try {
                androidx.collection.a<String, ArrayList<String>> aVar = new androidx.collection.a<>();
                androidx.collection.a<String, ArrayList<androidx.work.d>> aVar2 = new androidx.collection.a<>();
                while (cursorC.moveToNext()) {
                    String string = cursorC.getString(0);
                    if (aVar.get(string) == null) {
                        aVar.put(string, new ArrayList<>());
                    }
                    String string2 = cursorC.getString(0);
                    if (aVar2.get(string2) == null) {
                        aVar2.put(string2, new ArrayList<>());
                    }
                }
                cursorC.moveToPosition(-1);
                F(aVar);
                E(aVar2);
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    String string3 = cursorC.isNull(0) ? null : cursorC.getString(0);
                    WorkInfo.State stateF = b0.f(cursorC.getInt(1));
                    androidx.work.d dVarG = androidx.work.d.g(cursorC.isNull(2) ? null : cursorC.getBlob(2));
                    int i12 = cursorC.getInt(3);
                    int i13 = cursorC.getInt(4);
                    ArrayList<String> arrayList2 = aVar.get(cursorC.getString(0));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    ArrayList<String> arrayList3 = arrayList2;
                    ArrayList<androidx.work.d> arrayList4 = aVar2.get(cursorC.getString(0));
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList<>();
                    }
                    arrayList.add(new u.c(string3, stateF, dVarG, i12, i13, arrayList3, arrayList4));
                }
                this.f76228a.E();
                cursorC.close();
                vVarC.release();
                this.f76228a.i();
                return arrayList;
            } catch (Throwable th2) {
                cursorC.close();
                vVarC.release();
                throw th2;
            }
        } catch (Throwable th3) {
            this.f76228a.i();
            throw th3;
        }
    }

    public final void E(androidx.collection.a<String, ArrayList<androidx.work.d>> aVar) {
        int i11;
        Set<String> setKeySet = aVar.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (aVar.size() > 999) {
            androidx.collection.a<String, ArrayList<androidx.work.d>> aVar2 = new androidx.collection.a<>(999);
            int size = aVar.size();
            int i12 = 0;
            loop0: while (true) {
                i11 = 0;
                do {
                    if (i12 >= size) {
                        break loop0;
                    }
                    aVar2.put(aVar.keyAt(i12), aVar.valueAt(i12));
                    i12++;
                    i11++;
                } while (i11 != 999);
                E(aVar2);
                aVar2 = new androidx.collection.a<>(999);
            }
            if (i11 > 0) {
                E(aVar2);
                return;
            }
            return;
        }
        StringBuilder sbB = e6.d.b();
        sbB.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int size2 = setKeySet.size();
        e6.d.a(sbB, size2);
        sbB.append(")");
        androidx.room.v vVarC = androidx.room.v.c(sbB.toString(), size2);
        int i13 = 1;
        for (String str : setKeySet) {
            if (str == null) {
                vVarC.m0(i13);
            } else {
                vVarC.s(i13, str);
            }
            i13++;
        }
        Cursor cursorC = e6.b.c(this.f76228a, vVarC, false, null);
        try {
            int iD = e6.a.d(cursorC, "work_spec_id");
            if (iD == -1) {
                return;
            }
            while (cursorC.moveToNext()) {
                ArrayList<androidx.work.d> arrayList = aVar.get(cursorC.getString(iD));
                if (arrayList != null) {
                    arrayList.add(androidx.work.d.g(cursorC.isNull(0) ? null : cursorC.getBlob(0)));
                }
            }
        } finally {
            cursorC.close();
        }
    }

    public final void F(androidx.collection.a<String, ArrayList<String>> aVar) {
        int i11;
        Set<String> setKeySet = aVar.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (aVar.size() > 999) {
            androidx.collection.a<String, ArrayList<String>> aVar2 = new androidx.collection.a<>(999);
            int size = aVar.size();
            int i12 = 0;
            loop0: while (true) {
                i11 = 0;
                do {
                    if (i12 >= size) {
                        break loop0;
                    }
                    aVar2.put(aVar.keyAt(i12), aVar.valueAt(i12));
                    i12++;
                    i11++;
                } while (i11 != 999);
                F(aVar2);
                aVar2 = new androidx.collection.a<>(999);
            }
            if (i11 > 0) {
                F(aVar2);
                return;
            }
            return;
        }
        StringBuilder sbB = e6.d.b();
        sbB.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int size2 = setKeySet.size();
        e6.d.a(sbB, size2);
        sbB.append(")");
        androidx.room.v vVarC = androidx.room.v.c(sbB.toString(), size2);
        int i13 = 1;
        for (String str : setKeySet) {
            if (str == null) {
                vVarC.m0(i13);
            } else {
                vVarC.s(i13, str);
            }
            i13++;
        }
        Cursor cursorC = e6.b.c(this.f76228a, vVarC, false, null);
        try {
            int iD = e6.a.d(cursorC, "work_spec_id");
            if (iD == -1) {
                return;
            }
            while (cursorC.moveToNext()) {
                ArrayList<String> arrayList = aVar.get(cursorC.getString(iD));
                if (arrayList != null) {
                    arrayList.add(cursorC.isNull(0) ? null : cursorC.getString(0));
                }
            }
        } finally {
            cursorC.close();
        }
    }

    @Override // s6.v
    public void a(String str) {
        this.f76228a.d();
        g6.k kVarB = this.f76231d.b();
        if (str == null) {
            kVarB.m0(1);
        } else {
            kVarB.s(1, str);
        }
        this.f76228a.e();
        try {
            kVarB.F();
            this.f76228a.E();
        } finally {
            this.f76228a.i();
            this.f76231d.h(kVarB);
        }
    }

    @Override // s6.v
    public void b() {
        this.f76228a.d();
        g6.k kVarB = this.f76240m.b();
        this.f76228a.e();
        try {
            kVarB.F();
            this.f76228a.E();
        } finally {
            this.f76228a.i();
            this.f76240m.h(kVarB);
        }
    }

    @Override // s6.v
    public void c(String str) {
        this.f76228a.d();
        g6.k kVarB = this.f76233f.b();
        if (str == null) {
            kVarB.m0(1);
        } else {
            kVarB.s(1, str);
        }
        this.f76228a.e();
        try {
            kVarB.F();
            this.f76228a.E();
        } finally {
            this.f76228a.i();
            this.f76233f.h(kVarB);
        }
    }

    @Override // s6.v
    public List<u> d(long j11) throws Throwable {
        androidx.room.v vVar;
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", 1);
        vVarC.V(1, j11);
        this.f76228a.d();
        Cursor cursorC = e6.b.c(this.f76228a, vVarC, false, null);
        try {
            int iE = e6.a.e(cursorC, "id");
            int iE2 = e6.a.e(cursorC, "state");
            int iE3 = e6.a.e(cursorC, "worker_class_name");
            int iE4 = e6.a.e(cursorC, "input_merger_class_name");
            int iE5 = e6.a.e(cursorC, "input");
            int iE6 = e6.a.e(cursorC, "output");
            int iE7 = e6.a.e(cursorC, "initial_delay");
            int iE8 = e6.a.e(cursorC, "interval_duration");
            int iE9 = e6.a.e(cursorC, "flex_duration");
            int iE10 = e6.a.e(cursorC, "run_attempt_count");
            int iE11 = e6.a.e(cursorC, "backoff_policy");
            int iE12 = e6.a.e(cursorC, "backoff_delay_duration");
            int iE13 = e6.a.e(cursorC, "last_enqueue_time");
            int iE14 = e6.a.e(cursorC, "minimum_retention_duration");
            vVar = vVarC;
            try {
                int iE15 = e6.a.e(cursorC, "schedule_requested_at");
                int iE16 = e6.a.e(cursorC, "run_in_foreground");
                int iE17 = e6.a.e(cursorC, "out_of_quota_policy");
                int iE18 = e6.a.e(cursorC, "period_count");
                int iE19 = e6.a.e(cursorC, "generation");
                int iE20 = e6.a.e(cursorC, "required_network_type");
                int iE21 = e6.a.e(cursorC, "requires_charging");
                int iE22 = e6.a.e(cursorC, "requires_device_idle");
                int iE23 = e6.a.e(cursorC, "requires_battery_not_low");
                int iE24 = e6.a.e(cursorC, "requires_storage_not_low");
                int iE25 = e6.a.e(cursorC, "trigger_content_update_delay");
                int iE26 = e6.a.e(cursorC, "trigger_max_content_delay");
                int iE27 = e6.a.e(cursorC, "content_uri_triggers");
                int i11 = iE14;
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                    WorkInfo.State stateF = b0.f(cursorC.getInt(iE2));
                    String string2 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                    String string3 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                    androidx.work.d dVarG = androidx.work.d.g(cursorC.isNull(iE5) ? null : cursorC.getBlob(iE5));
                    androidx.work.d dVarG2 = androidx.work.d.g(cursorC.isNull(iE6) ? null : cursorC.getBlob(iE6));
                    long j12 = cursorC.getLong(iE7);
                    long j13 = cursorC.getLong(iE8);
                    long j14 = cursorC.getLong(iE9);
                    int i12 = cursorC.getInt(iE10);
                    BackoffPolicy backoffPolicyC = b0.c(cursorC.getInt(iE11));
                    long j15 = cursorC.getLong(iE12);
                    long j16 = cursorC.getLong(iE13);
                    int i13 = i11;
                    long j17 = cursorC.getLong(i13);
                    int i14 = iE;
                    int i15 = iE15;
                    long j18 = cursorC.getLong(i15);
                    iE15 = i15;
                    iE16 = iE16;
                    boolean z11 = cursorC.getInt(iE16) != 0;
                    OutOfQuotaPolicy outOfQuotaPolicyE = b0.e(cursorC.getInt(iE17));
                    iE17 = iE17;
                    int i16 = iE18;
                    int i17 = cursorC.getInt(i16);
                    iE18 = i16;
                    int i18 = iE19;
                    int i19 = cursorC.getInt(i18);
                    iE19 = i18;
                    int i21 = iE20;
                    NetworkType networkTypeD = b0.d(cursorC.getInt(i21));
                    iE20 = i21;
                    iE21 = iE21;
                    boolean z12 = cursorC.getInt(iE21) != 0;
                    boolean z13 = cursorC.getInt(iE22) != 0;
                    boolean z14 = cursorC.getInt(iE23) != 0;
                    boolean z15 = cursorC.getInt(iE24) != 0;
                    long j19 = cursorC.getLong(iE25);
                    iE25 = iE25;
                    int i22 = iE26;
                    long j21 = cursorC.getLong(i22);
                    iE26 = i22;
                    int i23 = iE27;
                    iE27 = i23;
                    arrayList.add(new u(string, stateF, string2, string3, dVarG, dVarG2, j12, j13, j14, new androidx.work.b(networkTypeD, z12, z13, z14, z15, j19, j21, b0.b(cursorC.isNull(i23) ? null : cursorC.getBlob(i23))), i12, backoffPolicyC, j15, j16, j17, j18, z11, outOfQuotaPolicyE, i17, i19));
                    iE = i14;
                    i11 = i13;
                }
                cursorC.close();
                vVar.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                cursorC.close();
                vVar.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            vVar = vVarC;
        }
    }

    @Override // s6.v
    public void e(u uVar) {
        this.f76228a.d();
        this.f76228a.e();
        try {
            this.f76229b.k(uVar);
            this.f76228a.E();
        } finally {
            this.f76228a.i();
        }
    }

    @Override // s6.v
    public List<u> f() throws Throwable {
        androidx.room.v vVar;
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f76228a.d();
        Cursor cursorC = e6.b.c(this.f76228a, vVarC, false, null);
        try {
            int iE = e6.a.e(cursorC, "id");
            int iE2 = e6.a.e(cursorC, "state");
            int iE3 = e6.a.e(cursorC, "worker_class_name");
            int iE4 = e6.a.e(cursorC, "input_merger_class_name");
            int iE5 = e6.a.e(cursorC, "input");
            int iE6 = e6.a.e(cursorC, "output");
            int iE7 = e6.a.e(cursorC, "initial_delay");
            int iE8 = e6.a.e(cursorC, "interval_duration");
            int iE9 = e6.a.e(cursorC, "flex_duration");
            int iE10 = e6.a.e(cursorC, "run_attempt_count");
            int iE11 = e6.a.e(cursorC, "backoff_policy");
            int iE12 = e6.a.e(cursorC, "backoff_delay_duration");
            int iE13 = e6.a.e(cursorC, "last_enqueue_time");
            int iE14 = e6.a.e(cursorC, "minimum_retention_duration");
            vVar = vVarC;
            try {
                int iE15 = e6.a.e(cursorC, "schedule_requested_at");
                int iE16 = e6.a.e(cursorC, "run_in_foreground");
                int iE17 = e6.a.e(cursorC, "out_of_quota_policy");
                int iE18 = e6.a.e(cursorC, "period_count");
                int iE19 = e6.a.e(cursorC, "generation");
                int iE20 = e6.a.e(cursorC, "required_network_type");
                int iE21 = e6.a.e(cursorC, "requires_charging");
                int iE22 = e6.a.e(cursorC, "requires_device_idle");
                int iE23 = e6.a.e(cursorC, "requires_battery_not_low");
                int iE24 = e6.a.e(cursorC, "requires_storage_not_low");
                int iE25 = e6.a.e(cursorC, "trigger_content_update_delay");
                int iE26 = e6.a.e(cursorC, "trigger_max_content_delay");
                int iE27 = e6.a.e(cursorC, "content_uri_triggers");
                int i11 = iE14;
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                    WorkInfo.State stateF = b0.f(cursorC.getInt(iE2));
                    String string2 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                    String string3 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                    androidx.work.d dVarG = androidx.work.d.g(cursorC.isNull(iE5) ? null : cursorC.getBlob(iE5));
                    androidx.work.d dVarG2 = androidx.work.d.g(cursorC.isNull(iE6) ? null : cursorC.getBlob(iE6));
                    long j11 = cursorC.getLong(iE7);
                    long j12 = cursorC.getLong(iE8);
                    long j13 = cursorC.getLong(iE9);
                    int i12 = cursorC.getInt(iE10);
                    BackoffPolicy backoffPolicyC = b0.c(cursorC.getInt(iE11));
                    long j14 = cursorC.getLong(iE12);
                    long j15 = cursorC.getLong(iE13);
                    int i13 = i11;
                    long j16 = cursorC.getLong(i13);
                    int i14 = iE;
                    int i15 = iE15;
                    long j17 = cursorC.getLong(i15);
                    iE15 = i15;
                    iE16 = iE16;
                    boolean z11 = cursorC.getInt(iE16) != 0;
                    OutOfQuotaPolicy outOfQuotaPolicyE = b0.e(cursorC.getInt(iE17));
                    iE17 = iE17;
                    int i16 = iE18;
                    int i17 = cursorC.getInt(i16);
                    iE18 = i16;
                    int i18 = iE19;
                    int i19 = cursorC.getInt(i18);
                    iE19 = i18;
                    int i21 = iE20;
                    NetworkType networkTypeD = b0.d(cursorC.getInt(i21));
                    iE20 = i21;
                    iE21 = iE21;
                    boolean z12 = cursorC.getInt(iE21) != 0;
                    boolean z13 = cursorC.getInt(iE22) != 0;
                    boolean z14 = cursorC.getInt(iE23) != 0;
                    boolean z15 = cursorC.getInt(iE24) != 0;
                    long j18 = cursorC.getLong(iE25);
                    iE25 = iE25;
                    int i22 = iE26;
                    long j19 = cursorC.getLong(i22);
                    iE26 = i22;
                    int i23 = iE27;
                    iE27 = i23;
                    arrayList.add(new u(string, stateF, string2, string3, dVarG, dVarG2, j11, j12, j13, new androidx.work.b(networkTypeD, z12, z13, z14, z15, j18, j19, b0.b(cursorC.isNull(i23) ? null : cursorC.getBlob(i23))), i12, backoffPolicyC, j14, j15, j16, j17, z11, outOfQuotaPolicyE, i17, i19));
                    iE = i14;
                    i11 = i13;
                }
                cursorC.close();
                vVar.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                cursorC.close();
                vVar.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            vVar = vVarC;
        }
    }

    @Override // s6.v
    public List<String> g(String str) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        this.f76228a.d();
        Cursor cursorC = e6.b.c(this.f76228a, vVarC, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorC.getCount());
            while (cursorC.moveToNext()) {
                arrayList.add(cursorC.isNull(0) ? null : cursorC.getString(0));
            }
            return arrayList;
        } finally {
            cursorC.close();
            vVarC.release();
        }
    }

    @Override // s6.v
    public u.c h(String str) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id=?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        this.f76228a.d();
        this.f76228a.e();
        try {
            u.c cVar = null;
            byte[] blob = null;
            Cursor cursorC = e6.b.c(this.f76228a, vVarC, true, null);
            try {
                androidx.collection.a<String, ArrayList<String>> aVar = new androidx.collection.a<>();
                androidx.collection.a<String, ArrayList<androidx.work.d>> aVar2 = new androidx.collection.a<>();
                while (cursorC.moveToNext()) {
                    String string = cursorC.getString(0);
                    if (aVar.get(string) == null) {
                        aVar.put(string, new ArrayList<>());
                    }
                    String string2 = cursorC.getString(0);
                    if (aVar2.get(string2) == null) {
                        aVar2.put(string2, new ArrayList<>());
                    }
                }
                cursorC.moveToPosition(-1);
                F(aVar);
                E(aVar2);
                if (cursorC.moveToFirst()) {
                    String string3 = cursorC.isNull(0) ? null : cursorC.getString(0);
                    WorkInfo.State stateF = b0.f(cursorC.getInt(1));
                    if (!cursorC.isNull(2)) {
                        blob = cursorC.getBlob(2);
                    }
                    androidx.work.d dVarG = androidx.work.d.g(blob);
                    int i11 = cursorC.getInt(3);
                    int i12 = cursorC.getInt(4);
                    ArrayList<String> arrayList = aVar.get(cursorC.getString(0));
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    ArrayList<String> arrayList2 = arrayList;
                    ArrayList<androidx.work.d> arrayList3 = aVar2.get(cursorC.getString(0));
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList<>();
                    }
                    cVar = new u.c(string3, stateF, dVarG, i11, i12, arrayList2, arrayList3);
                }
                this.f76228a.E();
                cursorC.close();
                vVarC.release();
                this.f76228a.i();
                return cVar;
            } catch (Throwable th2) {
                cursorC.close();
                vVarC.release();
                throw th2;
            }
        } catch (Throwable th3) {
            this.f76228a.i();
            throw th3;
        }
    }

    @Override // s6.v
    public WorkInfo.State i(String str) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        this.f76228a.d();
        WorkInfo.State stateF = null;
        Cursor cursorC = e6.b.c(this.f76228a, vVarC, false, null);
        try {
            if (cursorC.moveToFirst()) {
                Integer numValueOf = cursorC.isNull(0) ? null : Integer.valueOf(cursorC.getInt(0));
                if (numValueOf != null) {
                    b0 b0Var = b0.f76156a;
                    stateF = b0.f(numValueOf.intValue());
                }
            }
            return stateF;
        } finally {
            cursorC.close();
            vVarC.release();
        }
    }

    @Override // s6.v
    public u j(String str) throws Throwable {
        androidx.room.v vVar;
        u uVar;
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM workspec WHERE id=?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        this.f76228a.d();
        Cursor cursorC = e6.b.c(this.f76228a, vVarC, false, null);
        try {
            int iE = e6.a.e(cursorC, "id");
            int iE2 = e6.a.e(cursorC, "state");
            int iE3 = e6.a.e(cursorC, "worker_class_name");
            int iE4 = e6.a.e(cursorC, "input_merger_class_name");
            int iE5 = e6.a.e(cursorC, "input");
            int iE6 = e6.a.e(cursorC, "output");
            int iE7 = e6.a.e(cursorC, "initial_delay");
            int iE8 = e6.a.e(cursorC, "interval_duration");
            int iE9 = e6.a.e(cursorC, "flex_duration");
            int iE10 = e6.a.e(cursorC, "run_attempt_count");
            int iE11 = e6.a.e(cursorC, "backoff_policy");
            int iE12 = e6.a.e(cursorC, "backoff_delay_duration");
            int iE13 = e6.a.e(cursorC, "last_enqueue_time");
            int iE14 = e6.a.e(cursorC, "minimum_retention_duration");
            vVar = vVarC;
            try {
                int iE15 = e6.a.e(cursorC, "schedule_requested_at");
                int iE16 = e6.a.e(cursorC, "run_in_foreground");
                int iE17 = e6.a.e(cursorC, "out_of_quota_policy");
                int iE18 = e6.a.e(cursorC, "period_count");
                int iE19 = e6.a.e(cursorC, "generation");
                int iE20 = e6.a.e(cursorC, "required_network_type");
                int iE21 = e6.a.e(cursorC, "requires_charging");
                int iE22 = e6.a.e(cursorC, "requires_device_idle");
                int iE23 = e6.a.e(cursorC, "requires_battery_not_low");
                int iE24 = e6.a.e(cursorC, "requires_storage_not_low");
                int iE25 = e6.a.e(cursorC, "trigger_content_update_delay");
                int iE26 = e6.a.e(cursorC, "trigger_max_content_delay");
                int iE27 = e6.a.e(cursorC, "content_uri_triggers");
                if (cursorC.moveToFirst()) {
                    uVar = new u(cursorC.isNull(iE) ? null : cursorC.getString(iE), b0.f(cursorC.getInt(iE2)), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), androidx.work.d.g(cursorC.isNull(iE5) ? null : cursorC.getBlob(iE5)), androidx.work.d.g(cursorC.isNull(iE6) ? null : cursorC.getBlob(iE6)), cursorC.getLong(iE7), cursorC.getLong(iE8), cursorC.getLong(iE9), new androidx.work.b(b0.d(cursorC.getInt(iE20)), cursorC.getInt(iE21) != 0, cursorC.getInt(iE22) != 0, cursorC.getInt(iE23) != 0, cursorC.getInt(iE24) != 0, cursorC.getLong(iE25), cursorC.getLong(iE26), b0.b(cursorC.isNull(iE27) ? null : cursorC.getBlob(iE27))), cursorC.getInt(iE10), b0.c(cursorC.getInt(iE11)), cursorC.getLong(iE12), cursorC.getLong(iE13), cursorC.getLong(iE14), cursorC.getLong(iE15), cursorC.getInt(iE16) != 0, b0.e(cursorC.getInt(iE17)), cursorC.getInt(iE18), cursorC.getInt(iE19));
                } else {
                    uVar = null;
                }
                cursorC.close();
                vVar.release();
                return uVar;
            } catch (Throwable th2) {
                th = th2;
                cursorC.close();
                vVar.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            vVar = vVarC;
        }
    }

    @Override // s6.v
    public void k(String str, long j11) {
        this.f76228a.d();
        g6.k kVarB = this.f76235h.b();
        kVarB.V(1, j11);
        if (str == null) {
            kVarB.m0(2);
        } else {
            kVarB.s(2, str);
        }
        this.f76228a.e();
        try {
            kVarB.F();
            this.f76228a.E();
        } finally {
            this.f76228a.i();
            this.f76235h.h(kVarB);
        }
    }

    @Override // s6.v
    public List<String> l(String str) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        this.f76228a.d();
        Cursor cursorC = e6.b.c(this.f76228a, vVarC, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorC.getCount());
            while (cursorC.moveToNext()) {
                arrayList.add(cursorC.isNull(0) ? null : cursorC.getString(0));
            }
            return arrayList;
        } finally {
            cursorC.close();
            vVarC.release();
        }
    }

    @Override // s6.v
    public List<androidx.work.d> m(String str) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        this.f76228a.d();
        Cursor cursorC = e6.b.c(this.f76228a, vVarC, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorC.getCount());
            while (cursorC.moveToNext()) {
                arrayList.add(androidx.work.d.g(cursorC.isNull(0) ? null : cursorC.getBlob(0)));
            }
            return arrayList;
        } finally {
            cursorC.close();
            vVarC.release();
        }
    }

    @Override // s6.v
    public List<u.c> n(String str) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        this.f76228a.d();
        this.f76228a.e();
        try {
            Cursor cursorC = e6.b.c(this.f76228a, vVarC, true, null);
            try {
                androidx.collection.a<String, ArrayList<String>> aVar = new androidx.collection.a<>();
                androidx.collection.a<String, ArrayList<androidx.work.d>> aVar2 = new androidx.collection.a<>();
                while (cursorC.moveToNext()) {
                    String string = cursorC.getString(0);
                    if (aVar.get(string) == null) {
                        aVar.put(string, new ArrayList<>());
                    }
                    String string2 = cursorC.getString(0);
                    if (aVar2.get(string2) == null) {
                        aVar2.put(string2, new ArrayList<>());
                    }
                }
                cursorC.moveToPosition(-1);
                F(aVar);
                E(aVar2);
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    String string3 = cursorC.isNull(0) ? null : cursorC.getString(0);
                    WorkInfo.State stateF = b0.f(cursorC.getInt(1));
                    androidx.work.d dVarG = androidx.work.d.g(cursorC.isNull(2) ? null : cursorC.getBlob(2));
                    int i11 = cursorC.getInt(3);
                    int i12 = cursorC.getInt(4);
                    ArrayList<String> arrayList2 = aVar.get(cursorC.getString(0));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    ArrayList<String> arrayList3 = arrayList2;
                    ArrayList<androidx.work.d> arrayList4 = aVar2.get(cursorC.getString(0));
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList<>();
                    }
                    arrayList.add(new u.c(string3, stateF, dVarG, i11, i12, arrayList3, arrayList4));
                }
                this.f76228a.E();
                cursorC.close();
                vVarC.release();
                this.f76228a.i();
                return arrayList;
            } catch (Throwable th2) {
                cursorC.close();
                vVarC.release();
                throw th2;
            }
        } catch (Throwable th3) {
            this.f76228a.i();
            throw th3;
        }
    }

    @Override // s6.v
    public List<u> o(int i11) throws Throwable {
        androidx.room.v vVar;
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", 1);
        vVarC.V(1, i11);
        this.f76228a.d();
        Cursor cursorC = e6.b.c(this.f76228a, vVarC, false, null);
        try {
            int iE = e6.a.e(cursorC, "id");
            int iE2 = e6.a.e(cursorC, "state");
            int iE3 = e6.a.e(cursorC, "worker_class_name");
            int iE4 = e6.a.e(cursorC, "input_merger_class_name");
            int iE5 = e6.a.e(cursorC, "input");
            int iE6 = e6.a.e(cursorC, "output");
            int iE7 = e6.a.e(cursorC, "initial_delay");
            int iE8 = e6.a.e(cursorC, "interval_duration");
            int iE9 = e6.a.e(cursorC, "flex_duration");
            int iE10 = e6.a.e(cursorC, "run_attempt_count");
            int iE11 = e6.a.e(cursorC, "backoff_policy");
            int iE12 = e6.a.e(cursorC, "backoff_delay_duration");
            int iE13 = e6.a.e(cursorC, "last_enqueue_time");
            int iE14 = e6.a.e(cursorC, "minimum_retention_duration");
            vVar = vVarC;
            try {
                int iE15 = e6.a.e(cursorC, "schedule_requested_at");
                int iE16 = e6.a.e(cursorC, "run_in_foreground");
                int iE17 = e6.a.e(cursorC, "out_of_quota_policy");
                int iE18 = e6.a.e(cursorC, "period_count");
                int iE19 = e6.a.e(cursorC, "generation");
                int iE20 = e6.a.e(cursorC, "required_network_type");
                int iE21 = e6.a.e(cursorC, "requires_charging");
                int iE22 = e6.a.e(cursorC, "requires_device_idle");
                int iE23 = e6.a.e(cursorC, "requires_battery_not_low");
                int iE24 = e6.a.e(cursorC, "requires_storage_not_low");
                int iE25 = e6.a.e(cursorC, "trigger_content_update_delay");
                int iE26 = e6.a.e(cursorC, "trigger_max_content_delay");
                int iE27 = e6.a.e(cursorC, "content_uri_triggers");
                int i12 = iE14;
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                    WorkInfo.State stateF = b0.f(cursorC.getInt(iE2));
                    String string2 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                    String string3 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                    androidx.work.d dVarG = androidx.work.d.g(cursorC.isNull(iE5) ? null : cursorC.getBlob(iE5));
                    androidx.work.d dVarG2 = androidx.work.d.g(cursorC.isNull(iE6) ? null : cursorC.getBlob(iE6));
                    long j11 = cursorC.getLong(iE7);
                    long j12 = cursorC.getLong(iE8);
                    long j13 = cursorC.getLong(iE9);
                    int i13 = cursorC.getInt(iE10);
                    BackoffPolicy backoffPolicyC = b0.c(cursorC.getInt(iE11));
                    long j14 = cursorC.getLong(iE12);
                    long j15 = cursorC.getLong(iE13);
                    int i14 = i12;
                    long j16 = cursorC.getLong(i14);
                    int i15 = iE;
                    int i16 = iE15;
                    long j17 = cursorC.getLong(i16);
                    iE15 = i16;
                    iE16 = iE16;
                    boolean z11 = cursorC.getInt(iE16) != 0;
                    OutOfQuotaPolicy outOfQuotaPolicyE = b0.e(cursorC.getInt(iE17));
                    iE17 = iE17;
                    int i17 = iE18;
                    int i18 = cursorC.getInt(i17);
                    iE18 = i17;
                    int i19 = iE19;
                    int i21 = cursorC.getInt(i19);
                    iE19 = i19;
                    int i22 = iE20;
                    NetworkType networkTypeD = b0.d(cursorC.getInt(i22));
                    iE20 = i22;
                    iE21 = iE21;
                    boolean z12 = cursorC.getInt(iE21) != 0;
                    boolean z13 = cursorC.getInt(iE22) != 0;
                    boolean z14 = cursorC.getInt(iE23) != 0;
                    boolean z15 = cursorC.getInt(iE24) != 0;
                    long j18 = cursorC.getLong(iE25);
                    iE25 = iE25;
                    int i23 = iE26;
                    long j19 = cursorC.getLong(i23);
                    iE26 = i23;
                    int i24 = iE27;
                    iE27 = i24;
                    arrayList.add(new u(string, stateF, string2, string3, dVarG, dVarG2, j11, j12, j13, new androidx.work.b(networkTypeD, z12, z13, z14, z15, j18, j19, b0.b(cursorC.isNull(i24) ? null : cursorC.getBlob(i24))), i13, backoffPolicyC, j14, j15, j16, j17, z11, outOfQuotaPolicyE, i18, i21));
                    iE = i15;
                    i12 = i14;
                }
                cursorC.close();
                vVar.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                cursorC.close();
                vVar.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            vVar = vVarC;
        }
    }

    @Override // s6.v
    public int p() {
        this.f76228a.d();
        g6.k kVarB = this.f76239l.b();
        this.f76228a.e();
        try {
            int iF = kVarB.F();
            this.f76228a.E();
            return iF;
        } finally {
            this.f76228a.i();
            this.f76239l.h(kVarB);
        }
    }

    @Override // s6.v
    public void q(u uVar) {
        this.f76228a.d();
        this.f76228a.e();
        try {
            this.f76230c.j(uVar);
            this.f76228a.E();
        } finally {
            this.f76228a.i();
        }
    }

    @Override // s6.v
    public int r(String str, long j11) {
        this.f76228a.d();
        g6.k kVarB = this.f76238k.b();
        kVarB.V(1, j11);
        if (str == null) {
            kVarB.m0(2);
        } else {
            kVarB.s(2, str);
        }
        this.f76228a.e();
        try {
            int iF = kVarB.F();
            this.f76228a.E();
            return iF;
        } finally {
            this.f76228a.i();
            this.f76238k.h(kVarB);
        }
    }

    @Override // s6.v
    public List<u.b> s(String str) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        this.f76228a.d();
        Cursor cursorC = e6.b.c(this.f76228a, vVarC, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorC.getCount());
            while (cursorC.moveToNext()) {
                arrayList.add(new u.b(cursorC.isNull(0) ? null : cursorC.getString(0), b0.f(cursorC.getInt(1))));
            }
            return arrayList;
        } finally {
            cursorC.close();
            vVarC.release();
        }
    }

    @Override // s6.v
    public List<u> t(int i11) throws Throwable {
        androidx.room.v vVar;
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        vVarC.V(1, i11);
        this.f76228a.d();
        Cursor cursorC = e6.b.c(this.f76228a, vVarC, false, null);
        try {
            int iE = e6.a.e(cursorC, "id");
            int iE2 = e6.a.e(cursorC, "state");
            int iE3 = e6.a.e(cursorC, "worker_class_name");
            int iE4 = e6.a.e(cursorC, "input_merger_class_name");
            int iE5 = e6.a.e(cursorC, "input");
            int iE6 = e6.a.e(cursorC, "output");
            int iE7 = e6.a.e(cursorC, "initial_delay");
            int iE8 = e6.a.e(cursorC, "interval_duration");
            int iE9 = e6.a.e(cursorC, "flex_duration");
            int iE10 = e6.a.e(cursorC, "run_attempt_count");
            int iE11 = e6.a.e(cursorC, "backoff_policy");
            int iE12 = e6.a.e(cursorC, "backoff_delay_duration");
            int iE13 = e6.a.e(cursorC, "last_enqueue_time");
            int iE14 = e6.a.e(cursorC, "minimum_retention_duration");
            vVar = vVarC;
            try {
                int iE15 = e6.a.e(cursorC, "schedule_requested_at");
                int iE16 = e6.a.e(cursorC, "run_in_foreground");
                int iE17 = e6.a.e(cursorC, "out_of_quota_policy");
                int iE18 = e6.a.e(cursorC, "period_count");
                int iE19 = e6.a.e(cursorC, "generation");
                int iE20 = e6.a.e(cursorC, "required_network_type");
                int iE21 = e6.a.e(cursorC, "requires_charging");
                int iE22 = e6.a.e(cursorC, "requires_device_idle");
                int iE23 = e6.a.e(cursorC, "requires_battery_not_low");
                int iE24 = e6.a.e(cursorC, "requires_storage_not_low");
                int iE25 = e6.a.e(cursorC, "trigger_content_update_delay");
                int iE26 = e6.a.e(cursorC, "trigger_max_content_delay");
                int iE27 = e6.a.e(cursorC, "content_uri_triggers");
                int i12 = iE14;
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                    WorkInfo.State stateF = b0.f(cursorC.getInt(iE2));
                    String string2 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                    String string3 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                    androidx.work.d dVarG = androidx.work.d.g(cursorC.isNull(iE5) ? null : cursorC.getBlob(iE5));
                    androidx.work.d dVarG2 = androidx.work.d.g(cursorC.isNull(iE6) ? null : cursorC.getBlob(iE6));
                    long j11 = cursorC.getLong(iE7);
                    long j12 = cursorC.getLong(iE8);
                    long j13 = cursorC.getLong(iE9);
                    int i13 = cursorC.getInt(iE10);
                    BackoffPolicy backoffPolicyC = b0.c(cursorC.getInt(iE11));
                    long j14 = cursorC.getLong(iE12);
                    long j15 = cursorC.getLong(iE13);
                    int i14 = i12;
                    long j16 = cursorC.getLong(i14);
                    int i15 = iE;
                    int i16 = iE15;
                    long j17 = cursorC.getLong(i16);
                    iE15 = i16;
                    iE16 = iE16;
                    boolean z11 = cursorC.getInt(iE16) != 0;
                    OutOfQuotaPolicy outOfQuotaPolicyE = b0.e(cursorC.getInt(iE17));
                    iE17 = iE17;
                    int i17 = iE18;
                    int i18 = cursorC.getInt(i17);
                    iE18 = i17;
                    int i19 = iE19;
                    int i21 = cursorC.getInt(i19);
                    iE19 = i19;
                    int i22 = iE20;
                    NetworkType networkTypeD = b0.d(cursorC.getInt(i22));
                    iE20 = i22;
                    iE21 = iE21;
                    boolean z12 = cursorC.getInt(iE21) != 0;
                    boolean z13 = cursorC.getInt(iE22) != 0;
                    boolean z14 = cursorC.getInt(iE23) != 0;
                    boolean z15 = cursorC.getInt(iE24) != 0;
                    long j18 = cursorC.getLong(iE25);
                    iE25 = iE25;
                    int i23 = iE26;
                    long j19 = cursorC.getLong(i23);
                    iE26 = i23;
                    int i24 = iE27;
                    iE27 = i24;
                    arrayList.add(new u(string, stateF, string2, string3, dVarG, dVarG2, j11, j12, j13, new androidx.work.b(networkTypeD, z12, z13, z14, z15, j18, j19, b0.b(cursorC.isNull(i24) ? null : cursorC.getBlob(i24))), i13, backoffPolicyC, j14, j15, j16, j17, z11, outOfQuotaPolicyE, i18, i21));
                    iE = i15;
                    i12 = i14;
                }
                cursorC.close();
                vVar.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                cursorC.close();
                vVar.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            vVar = vVarC;
        }
    }

    @Override // s6.v
    public int u(WorkInfo.State state, String str) {
        this.f76228a.d();
        g6.k kVarB = this.f76232e.b();
        kVarB.V(1, b0.j(state));
        if (str == null) {
            kVarB.m0(2);
        } else {
            kVarB.s(2, str);
        }
        this.f76228a.e();
        try {
            int iF = kVarB.F();
            this.f76228a.E();
            return iF;
        } finally {
            this.f76228a.i();
            this.f76232e.h(kVarB);
        }
    }

    @Override // s6.v
    public void v(String str, androidx.work.d dVar) throws Throwable {
        this.f76228a.d();
        g6.k kVarB = this.f76234g.b();
        byte[] bArrK = androidx.work.d.k(dVar);
        if (bArrK == null) {
            kVarB.m0(1);
        } else {
            kVarB.c0(1, bArrK);
        }
        if (str == null) {
            kVarB.m0(2);
        } else {
            kVarB.s(2, str);
        }
        this.f76228a.e();
        try {
            kVarB.F();
            this.f76228a.E();
        } finally {
            this.f76228a.i();
            this.f76234g.h(kVarB);
        }
    }

    @Override // s6.v
    public List<u> w() throws Throwable {
        androidx.room.v vVar;
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM workspec WHERE state=1", 0);
        this.f76228a.d();
        Cursor cursorC = e6.b.c(this.f76228a, vVarC, false, null);
        try {
            int iE = e6.a.e(cursorC, "id");
            int iE2 = e6.a.e(cursorC, "state");
            int iE3 = e6.a.e(cursorC, "worker_class_name");
            int iE4 = e6.a.e(cursorC, "input_merger_class_name");
            int iE5 = e6.a.e(cursorC, "input");
            int iE6 = e6.a.e(cursorC, "output");
            int iE7 = e6.a.e(cursorC, "initial_delay");
            int iE8 = e6.a.e(cursorC, "interval_duration");
            int iE9 = e6.a.e(cursorC, "flex_duration");
            int iE10 = e6.a.e(cursorC, "run_attempt_count");
            int iE11 = e6.a.e(cursorC, "backoff_policy");
            int iE12 = e6.a.e(cursorC, "backoff_delay_duration");
            int iE13 = e6.a.e(cursorC, "last_enqueue_time");
            int iE14 = e6.a.e(cursorC, "minimum_retention_duration");
            vVar = vVarC;
            try {
                int iE15 = e6.a.e(cursorC, "schedule_requested_at");
                int iE16 = e6.a.e(cursorC, "run_in_foreground");
                int iE17 = e6.a.e(cursorC, "out_of_quota_policy");
                int iE18 = e6.a.e(cursorC, "period_count");
                int iE19 = e6.a.e(cursorC, "generation");
                int iE20 = e6.a.e(cursorC, "required_network_type");
                int iE21 = e6.a.e(cursorC, "requires_charging");
                int iE22 = e6.a.e(cursorC, "requires_device_idle");
                int iE23 = e6.a.e(cursorC, "requires_battery_not_low");
                int iE24 = e6.a.e(cursorC, "requires_storage_not_low");
                int iE25 = e6.a.e(cursorC, "trigger_content_update_delay");
                int iE26 = e6.a.e(cursorC, "trigger_max_content_delay");
                int iE27 = e6.a.e(cursorC, "content_uri_triggers");
                int i11 = iE14;
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                    WorkInfo.State stateF = b0.f(cursorC.getInt(iE2));
                    String string2 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                    String string3 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                    androidx.work.d dVarG = androidx.work.d.g(cursorC.isNull(iE5) ? null : cursorC.getBlob(iE5));
                    androidx.work.d dVarG2 = androidx.work.d.g(cursorC.isNull(iE6) ? null : cursorC.getBlob(iE6));
                    long j11 = cursorC.getLong(iE7);
                    long j12 = cursorC.getLong(iE8);
                    long j13 = cursorC.getLong(iE9);
                    int i12 = cursorC.getInt(iE10);
                    BackoffPolicy backoffPolicyC = b0.c(cursorC.getInt(iE11));
                    long j14 = cursorC.getLong(iE12);
                    long j15 = cursorC.getLong(iE13);
                    int i13 = i11;
                    long j16 = cursorC.getLong(i13);
                    int i14 = iE;
                    int i15 = iE15;
                    long j17 = cursorC.getLong(i15);
                    iE15 = i15;
                    iE16 = iE16;
                    boolean z11 = cursorC.getInt(iE16) != 0;
                    OutOfQuotaPolicy outOfQuotaPolicyE = b0.e(cursorC.getInt(iE17));
                    iE17 = iE17;
                    int i16 = iE18;
                    int i17 = cursorC.getInt(i16);
                    iE18 = i16;
                    int i18 = iE19;
                    int i19 = cursorC.getInt(i18);
                    iE19 = i18;
                    int i21 = iE20;
                    NetworkType networkTypeD = b0.d(cursorC.getInt(i21));
                    iE20 = i21;
                    iE21 = iE21;
                    boolean z12 = cursorC.getInt(iE21) != 0;
                    boolean z13 = cursorC.getInt(iE22) != 0;
                    boolean z14 = cursorC.getInt(iE23) != 0;
                    boolean z15 = cursorC.getInt(iE24) != 0;
                    long j18 = cursorC.getLong(iE25);
                    iE25 = iE25;
                    int i22 = iE26;
                    long j19 = cursorC.getLong(i22);
                    iE26 = i22;
                    int i23 = iE27;
                    iE27 = i23;
                    arrayList.add(new u(string, stateF, string2, string3, dVarG, dVarG2, j11, j12, j13, new androidx.work.b(networkTypeD, z12, z13, z14, z15, j18, j19, b0.b(cursorC.isNull(i23) ? null : cursorC.getBlob(i23))), i12, backoffPolicyC, j14, j15, j16, j17, z11, outOfQuotaPolicyE, i17, i19));
                    iE = i14;
                    i11 = i13;
                }
                cursorC.close();
                vVar.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                cursorC.close();
                vVar.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            vVar = vVarC;
        }
    }

    @Override // s6.v
    public List<String> x() {
        androidx.room.v vVarC = androidx.room.v.c("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.f76228a.d();
        Cursor cursorC = e6.b.c(this.f76228a, vVarC, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorC.getCount());
            while (cursorC.moveToNext()) {
                arrayList.add(cursorC.isNull(0) ? null : cursorC.getString(0));
            }
            return arrayList;
        } finally {
            cursorC.close();
            vVarC.release();
        }
    }

    @Override // s6.v
    public boolean y() {
        boolean z11 = false;
        androidx.room.v vVarC = androidx.room.v.c("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.f76228a.d();
        Cursor cursorC = e6.b.c(this.f76228a, vVarC, false, null);
        try {
            if (cursorC.moveToFirst() && cursorC.getInt(0) != 0) {
                z11 = true;
            }
            return z11;
        } finally {
            cursorC.close();
            vVarC.release();
        }
    }

    @Override // s6.v
    public int z(String str) {
        this.f76228a.d();
        g6.k kVarB = this.f76237j.b();
        if (str == null) {
            kVarB.m0(1);
        } else {
            kVarB.s(1, str);
        }
        this.f76228a.e();
        try {
            int iF = kVarB.F();
            this.f76228a.E();
            return iF;
        } finally {
            this.f76228a.i();
            this.f76237j.h(kVarB);
        }
    }
}
