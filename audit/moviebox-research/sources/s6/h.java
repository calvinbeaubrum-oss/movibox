package s6;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f76169a;

    public h(RoomDatabase roomDatabase) {
        this.f76169a = roomDatabase;
    }

    public static List<Class<?>> d() {
        return Collections.emptyList();
    }

    @Override // s6.g
    public List<u.c> a(g6.j jVar) {
        androidx.work.d dVarG;
        this.f76169a.d();
        Cursor cursorC = e6.b.c(this.f76169a, jVar, true, null);
        try {
            int iD = e6.a.d(cursorC, "id");
            int iD2 = e6.a.d(cursorC, "state");
            int iD3 = e6.a.d(cursorC, "output");
            int iD4 = e6.a.d(cursorC, "run_attempt_count");
            int iD5 = e6.a.d(cursorC, "generation");
            androidx.collection.a<String, ArrayList<String>> aVar = new androidx.collection.a<>();
            androidx.collection.a<String, ArrayList<androidx.work.d>> aVar2 = new androidx.collection.a<>();
            while (cursorC.moveToNext()) {
                String string = cursorC.getString(iD);
                if (aVar.get(string) == null) {
                    aVar.put(string, new ArrayList<>());
                }
                String string2 = cursorC.getString(iD);
                if (aVar2.get(string2) == null) {
                    aVar2.put(string2, new ArrayList<>());
                }
            }
            cursorC.moveToPosition(-1);
            c(aVar);
            b(aVar2);
            ArrayList arrayList = new ArrayList(cursorC.getCount());
            while (cursorC.moveToNext()) {
                String string3 = (iD == -1 || cursorC.isNull(iD)) ? null : cursorC.getString(iD);
                WorkInfo.State stateF = iD2 == -1 ? null : b0.f(cursorC.getInt(iD2));
                if (iD3 == -1) {
                    dVarG = null;
                } else {
                    dVarG = androidx.work.d.g(cursorC.isNull(iD3) ? null : cursorC.getBlob(iD3));
                }
                int i11 = iD4 == -1 ? 0 : cursorC.getInt(iD4);
                int i12 = iD5 == -1 ? 0 : cursorC.getInt(iD5);
                ArrayList<String> arrayList2 = aVar.get(cursorC.getString(iD));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                }
                ArrayList<String> arrayList3 = arrayList2;
                ArrayList<androidx.work.d> arrayList4 = aVar2.get(cursorC.getString(iD));
                if (arrayList4 == null) {
                    arrayList4 = new ArrayList<>();
                }
                arrayList.add(new u.c(string3, stateF, dVarG, i11, i12, arrayList3, arrayList4));
            }
            return arrayList;
        } finally {
            cursorC.close();
        }
    }

    public final void b(androidx.collection.a<String, ArrayList<androidx.work.d>> aVar) {
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
                b(aVar2);
                aVar2 = new androidx.collection.a<>(999);
            }
            if (i11 > 0) {
                b(aVar2);
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
        Cursor cursorC = e6.b.c(this.f76169a, vVarC, false, null);
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

    public final void c(androidx.collection.a<String, ArrayList<String>> aVar) {
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
                c(aVar2);
                aVar2 = new androidx.collection.a<>(999);
            }
            if (i11 > 0) {
                c(aVar2);
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
        Cursor cursorC = e6.b.c(this.f76169a, vVarC, false, null);
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
}
