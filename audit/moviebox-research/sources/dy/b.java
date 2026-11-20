package dy;

import android.database.Cursor;
import androidx.core.app.NotificationCompat;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.i;
import androidx.room.v;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import g6.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b implements dy.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f63549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i<SubtitleDownloadTable> f63550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.room.h<SubtitleDownloadTable> f63551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.room.h<SubtitleDownloadTable> f63552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f63553e;

    /* JADX INFO: compiled from: source.java */
    public class a implements Callable<List<SubtitleDownloadTable>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f63554a;

        public a(v vVar) {
            this.f63554a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<SubtitleDownloadTable> call() throws Exception {
            a aVar;
            Cursor cursorC = e6.b.c(b.this.f63549a, this.f63554a, false, null);
            try {
                int iE = e6.a.e(cursorC, "id");
                int iE2 = e6.a.e(cursorC, "resourceStreamType");
                int iE3 = e6.a.e(cursorC, "resourceId");
                int iE4 = e6.a.e(cursorC, "lan");
                int iE5 = e6.a.e(cursorC, "lanName");
                int iE6 = e6.a.e(cursorC, "url");
                int iE7 = e6.a.e(cursorC, "size");
                int iE8 = e6.a.e(cursorC, "delay");
                int iE9 = e6.a.e(cursorC, "downloads");
                int iE10 = e6.a.e(cursorC, "type");
                int iE11 = e6.a.e(cursorC, "postId");
                int iE12 = e6.a.e(cursorC, "subtitleName");
                int iE13 = e6.a.e(cursorC, "subjectId");
                int iE14 = e6.a.e(cursorC, "ep");
                try {
                    int iE15 = e6.a.e(cursorC, "se");
                    int iE16 = e6.a.e(cursorC, "resolution");
                    int iE17 = e6.a.e(cursorC, "subjectName");
                    int iE18 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                    int iE19 = e6.a.e(cursorC, "fileCharsetName");
                    int iE20 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                    int iE21 = e6.a.e(cursorC, "zipPath");
                    int iE22 = e6.a.e(cursorC, "taskId");
                    int iE23 = e6.a.e(cursorC, "failCount");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        int i12 = cursorC.getInt(iE2);
                        String string2 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string3 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        String string4 = cursorC.isNull(iE5) ? null : cursorC.getString(iE5);
                        String string5 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        Long lValueOf = cursorC.isNull(iE7) ? null : Long.valueOf(cursorC.getLong(iE7));
                        Long lValueOf2 = cursorC.isNull(iE8) ? null : Long.valueOf(cursorC.getLong(iE8));
                        Integer numValueOf = cursorC.isNull(iE9) ? null : Integer.valueOf(cursorC.getInt(iE9));
                        int i13 = cursorC.getInt(iE10);
                        String string6 = cursorC.isNull(iE11) ? null : cursorC.getString(iE11);
                        String string7 = cursorC.isNull(iE12) ? null : cursorC.getString(iE12);
                        String string8 = cursorC.isNull(iE13) ? null : cursorC.getString(iE13);
                        int i14 = cursorC.getInt(i11);
                        int i15 = iE;
                        int i16 = iE15;
                        int i17 = cursorC.getInt(i16);
                        iE15 = i16;
                        int i18 = iE16;
                        int i19 = cursorC.getInt(i18);
                        iE16 = i18;
                        iE17 = iE17;
                        String string9 = cursorC.isNull(iE17) ? null : cursorC.getString(iE17);
                        int i21 = cursorC.getInt(iE18);
                        iE18 = iE18;
                        iE19 = iE19;
                        String string10 = cursorC.isNull(iE19) ? null : cursorC.getString(iE19);
                        String string11 = cursorC.isNull(iE20) ? null : cursorC.getString(iE20);
                        String string12 = cursorC.isNull(iE21) ? null : cursorC.getString(iE21);
                        String string13 = cursorC.isNull(iE22) ? null : cursorC.getString(iE22);
                        int i22 = cursorC.getInt(iE23);
                        iE23 = iE23;
                        arrayList.add(new SubtitleDownloadTable(string, i12, string2, string3, string4, string5, lValueOf, lValueOf2, numValueOf, i13, string6, string7, string8, i14, i17, i19, string9, i21, string10, string11, string12, string13, i22));
                        iE = i15;
                        i11 = i11;
                    }
                    cursorC.close();
                    this.f63554a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    aVar = this;
                    cursorC.close();
                    aVar.f63554a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                aVar = this;
            }
        }
    }

    /* JADX INFO: renamed from: dy.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0652b extends i<SubtitleDownloadTable> {
        public C0652b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `st_download_table` (`id`,`resourceStreamType`,`resourceId`,`lan`,`lanName`,`url`,`size`,`delay`,`downloads`,`type`,`postId`,`subtitleName`,`subjectId`,`ep`,`se`,`resolution`,`subjectName`,`status`,`fileCharsetName`,`path`,`zipPath`,`taskId`,`failCount`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, SubtitleDownloadTable subtitleDownloadTable) {
            if (subtitleDownloadTable.getId() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, subtitleDownloadTable.getId());
            }
            kVar.V(2, subtitleDownloadTable.getResourceStreamType());
            if (subtitleDownloadTable.getResourceId() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, subtitleDownloadTable.getResourceId());
            }
            if (subtitleDownloadTable.getLan() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, subtitleDownloadTable.getLan());
            }
            if (subtitleDownloadTable.getLanName() == null) {
                kVar.m0(5);
            } else {
                kVar.s(5, subtitleDownloadTable.getLanName());
            }
            if (subtitleDownloadTable.getUrl() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, subtitleDownloadTable.getUrl());
            }
            if (subtitleDownloadTable.getSize() == null) {
                kVar.m0(7);
            } else {
                kVar.V(7, subtitleDownloadTable.getSize().longValue());
            }
            if (subtitleDownloadTable.getDelay() == null) {
                kVar.m0(8);
            } else {
                kVar.V(8, subtitleDownloadTable.getDelay().longValue());
            }
            if (subtitleDownloadTable.getDownloads() == null) {
                kVar.m0(9);
            } else {
                kVar.V(9, subtitleDownloadTable.getDownloads().intValue());
            }
            kVar.V(10, subtitleDownloadTable.getType());
            if (subtitleDownloadTable.getPostId() == null) {
                kVar.m0(11);
            } else {
                kVar.s(11, subtitleDownloadTable.getPostId());
            }
            if (subtitleDownloadTable.getSubtitleName() == null) {
                kVar.m0(12);
            } else {
                kVar.s(12, subtitleDownloadTable.getSubtitleName());
            }
            if (subtitleDownloadTable.getSubjectId() == null) {
                kVar.m0(13);
            } else {
                kVar.s(13, subtitleDownloadTable.getSubjectId());
            }
            kVar.V(14, subtitleDownloadTable.getEp());
            kVar.V(15, subtitleDownloadTable.getSe());
            kVar.V(16, subtitleDownloadTable.getResolution());
            if (subtitleDownloadTable.getSubjectName() == null) {
                kVar.m0(17);
            } else {
                kVar.s(17, subtitleDownloadTable.getSubjectName());
            }
            kVar.V(18, subtitleDownloadTable.getStatus());
            if (subtitleDownloadTable.getFileCharsetName() == null) {
                kVar.m0(19);
            } else {
                kVar.s(19, subtitleDownloadTable.getFileCharsetName());
            }
            if (subtitleDownloadTable.getPath() == null) {
                kVar.m0(20);
            } else {
                kVar.s(20, subtitleDownloadTable.getPath());
            }
            if (subtitleDownloadTable.getZipPath() == null) {
                kVar.m0(21);
            } else {
                kVar.s(21, subtitleDownloadTable.getZipPath());
            }
            if (subtitleDownloadTable.getTaskId() == null) {
                kVar.m0(22);
            } else {
                kVar.s(22, subtitleDownloadTable.getTaskId());
            }
            kVar.V(23, subtitleDownloadTable.getFailCount());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends androidx.room.h<SubtitleDownloadTable> {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM `st_download_table` WHERE `id` = ? AND `resourceStreamType` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, SubtitleDownloadTable subtitleDownloadTable) {
            if (subtitleDownloadTable.getId() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, subtitleDownloadTable.getId());
            }
            kVar.V(2, subtitleDownloadTable.getResourceStreamType());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends androidx.room.h<SubtitleDownloadTable> {
        public d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE OR ABORT `st_download_table` SET `id` = ?,`resourceStreamType` = ?,`resourceId` = ?,`lan` = ?,`lanName` = ?,`url` = ?,`size` = ?,`delay` = ?,`downloads` = ?,`type` = ?,`postId` = ?,`subtitleName` = ?,`subjectId` = ?,`ep` = ?,`se` = ?,`resolution` = ?,`subjectName` = ?,`status` = ?,`fileCharsetName` = ?,`path` = ?,`zipPath` = ?,`taskId` = ?,`failCount` = ? WHERE `id` = ? AND `resourceStreamType` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, SubtitleDownloadTable subtitleDownloadTable) {
            if (subtitleDownloadTable.getId() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, subtitleDownloadTable.getId());
            }
            kVar.V(2, subtitleDownloadTable.getResourceStreamType());
            if (subtitleDownloadTable.getResourceId() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, subtitleDownloadTable.getResourceId());
            }
            if (subtitleDownloadTable.getLan() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, subtitleDownloadTable.getLan());
            }
            if (subtitleDownloadTable.getLanName() == null) {
                kVar.m0(5);
            } else {
                kVar.s(5, subtitleDownloadTable.getLanName());
            }
            if (subtitleDownloadTable.getUrl() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, subtitleDownloadTable.getUrl());
            }
            if (subtitleDownloadTable.getSize() == null) {
                kVar.m0(7);
            } else {
                kVar.V(7, subtitleDownloadTable.getSize().longValue());
            }
            if (subtitleDownloadTable.getDelay() == null) {
                kVar.m0(8);
            } else {
                kVar.V(8, subtitleDownloadTable.getDelay().longValue());
            }
            if (subtitleDownloadTable.getDownloads() == null) {
                kVar.m0(9);
            } else {
                kVar.V(9, subtitleDownloadTable.getDownloads().intValue());
            }
            kVar.V(10, subtitleDownloadTable.getType());
            if (subtitleDownloadTable.getPostId() == null) {
                kVar.m0(11);
            } else {
                kVar.s(11, subtitleDownloadTable.getPostId());
            }
            if (subtitleDownloadTable.getSubtitleName() == null) {
                kVar.m0(12);
            } else {
                kVar.s(12, subtitleDownloadTable.getSubtitleName());
            }
            if (subtitleDownloadTable.getSubjectId() == null) {
                kVar.m0(13);
            } else {
                kVar.s(13, subtitleDownloadTable.getSubjectId());
            }
            kVar.V(14, subtitleDownloadTable.getEp());
            kVar.V(15, subtitleDownloadTable.getSe());
            kVar.V(16, subtitleDownloadTable.getResolution());
            if (subtitleDownloadTable.getSubjectName() == null) {
                kVar.m0(17);
            } else {
                kVar.s(17, subtitleDownloadTable.getSubjectName());
            }
            kVar.V(18, subtitleDownloadTable.getStatus());
            if (subtitleDownloadTable.getFileCharsetName() == null) {
                kVar.m0(19);
            } else {
                kVar.s(19, subtitleDownloadTable.getFileCharsetName());
            }
            if (subtitleDownloadTable.getPath() == null) {
                kVar.m0(20);
            } else {
                kVar.s(20, subtitleDownloadTable.getPath());
            }
            if (subtitleDownloadTable.getZipPath() == null) {
                kVar.m0(21);
            } else {
                kVar.s(21, subtitleDownloadTable.getZipPath());
            }
            if (subtitleDownloadTable.getTaskId() == null) {
                kVar.m0(22);
            } else {
                kVar.s(22, subtitleDownloadTable.getTaskId());
            }
            kVar.V(23, subtitleDownloadTable.getFailCount());
            if (subtitleDownloadTable.getId() == null) {
                kVar.m0(24);
            } else {
                kVar.s(24, subtitleDownloadTable.getId());
            }
            kVar.V(25, subtitleDownloadTable.getResourceStreamType());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends SharedSQLiteStatement {
        public e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM st_download_table WHERE resourceId =?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubtitleDownloadTable f63560a;

        public f(SubtitleDownloadTable subtitleDownloadTable) {
            this.f63560a = subtitleDownloadTable;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f63549a.e();
            try {
                b.this.f63550b.k(this.f63560a);
                b.this.f63549a.E();
                return Unit.f68710a;
            } finally {
                b.this.f63549a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f63562a;

        public g(String str) {
            this.f63562a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            k kVarB = b.this.f63553e.b();
            String str = this.f63562a;
            if (str == null) {
                kVarB.m0(1);
            } else {
                kVarB.s(1, str);
            }
            b.this.f63549a.e();
            try {
                kVarB.F();
                b.this.f63549a.E();
                return Unit.f68710a;
            } finally {
                b.this.f63549a.i();
                b.this.f63553e.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements Callable<List<SubtitleDownloadTable>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f63564a;

        public h(v vVar) {
            this.f63564a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<SubtitleDownloadTable> call() throws Exception {
            h hVar;
            Cursor cursorC = e6.b.c(b.this.f63549a, this.f63564a, false, null);
            try {
                int iE = e6.a.e(cursorC, "id");
                int iE2 = e6.a.e(cursorC, "resourceStreamType");
                int iE3 = e6.a.e(cursorC, "resourceId");
                int iE4 = e6.a.e(cursorC, "lan");
                int iE5 = e6.a.e(cursorC, "lanName");
                int iE6 = e6.a.e(cursorC, "url");
                int iE7 = e6.a.e(cursorC, "size");
                int iE8 = e6.a.e(cursorC, "delay");
                int iE9 = e6.a.e(cursorC, "downloads");
                int iE10 = e6.a.e(cursorC, "type");
                int iE11 = e6.a.e(cursorC, "postId");
                int iE12 = e6.a.e(cursorC, "subtitleName");
                int iE13 = e6.a.e(cursorC, "subjectId");
                int iE14 = e6.a.e(cursorC, "ep");
                try {
                    int iE15 = e6.a.e(cursorC, "se");
                    int iE16 = e6.a.e(cursorC, "resolution");
                    int iE17 = e6.a.e(cursorC, "subjectName");
                    int iE18 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                    int iE19 = e6.a.e(cursorC, "fileCharsetName");
                    int iE20 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                    int iE21 = e6.a.e(cursorC, "zipPath");
                    int iE22 = e6.a.e(cursorC, "taskId");
                    int iE23 = e6.a.e(cursorC, "failCount");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        int i12 = cursorC.getInt(iE2);
                        String string2 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string3 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        String string4 = cursorC.isNull(iE5) ? null : cursorC.getString(iE5);
                        String string5 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        Long lValueOf = cursorC.isNull(iE7) ? null : Long.valueOf(cursorC.getLong(iE7));
                        Long lValueOf2 = cursorC.isNull(iE8) ? null : Long.valueOf(cursorC.getLong(iE8));
                        Integer numValueOf = cursorC.isNull(iE9) ? null : Integer.valueOf(cursorC.getInt(iE9));
                        int i13 = cursorC.getInt(iE10);
                        String string6 = cursorC.isNull(iE11) ? null : cursorC.getString(iE11);
                        String string7 = cursorC.isNull(iE12) ? null : cursorC.getString(iE12);
                        String string8 = cursorC.isNull(iE13) ? null : cursorC.getString(iE13);
                        int i14 = cursorC.getInt(i11);
                        int i15 = iE;
                        int i16 = iE15;
                        int i17 = cursorC.getInt(i16);
                        iE15 = i16;
                        int i18 = iE16;
                        int i19 = cursorC.getInt(i18);
                        iE16 = i18;
                        iE17 = iE17;
                        String string9 = cursorC.isNull(iE17) ? null : cursorC.getString(iE17);
                        int i21 = cursorC.getInt(iE18);
                        iE18 = iE18;
                        iE19 = iE19;
                        String string10 = cursorC.isNull(iE19) ? null : cursorC.getString(iE19);
                        String string11 = cursorC.isNull(iE20) ? null : cursorC.getString(iE20);
                        String string12 = cursorC.isNull(iE21) ? null : cursorC.getString(iE21);
                        String string13 = cursorC.isNull(iE22) ? null : cursorC.getString(iE22);
                        int i22 = cursorC.getInt(iE23);
                        iE23 = iE23;
                        arrayList.add(new SubtitleDownloadTable(string, i12, string2, string3, string4, string5, lValueOf, lValueOf2, numValueOf, i13, string6, string7, string8, i14, i17, i19, string9, i21, string10, string11, string12, string13, i22));
                        iE = i15;
                        i11 = i11;
                    }
                    cursorC.close();
                    this.f63564a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    hVar = this;
                    cursorC.close();
                    hVar.f63564a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                hVar = this;
            }
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f63549a = roomDatabase;
        this.f63550b = new C0652b(roomDatabase);
        this.f63551c = new c(roomDatabase);
        this.f63552d = new d(roomDatabase);
        this.f63553e = new e(roomDatabase);
    }

    public static List<Class<?>> k() {
        return Collections.emptyList();
    }

    @Override // dy.a
    public Object a(String str, Continuation<? super List<SubtitleDownloadTable>> continuation) {
        v vVarC = v.c("SELECT * FROM st_download_table WHERE resourceId = ?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f63549a, false, e6.b.a(), new a(vVarC), continuation);
    }

    @Override // dy.a
    public Object b(String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f63549a, true, new g(str), continuation);
    }

    @Override // dy.a
    public SubtitleDownloadTable c(String str, int i11) throws Throwable {
        v vVar;
        SubtitleDownloadTable subtitleDownloadTable;
        v vVarC = v.c("SELECT * FROM st_download_table WHERE id = ? AND resourceStreamType = ?", 2);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        vVarC.V(2, i11);
        this.f63549a.d();
        Cursor cursorC = e6.b.c(this.f63549a, vVarC, false, null);
        try {
            int iE = e6.a.e(cursorC, "id");
            int iE2 = e6.a.e(cursorC, "resourceStreamType");
            int iE3 = e6.a.e(cursorC, "resourceId");
            int iE4 = e6.a.e(cursorC, "lan");
            int iE5 = e6.a.e(cursorC, "lanName");
            int iE6 = e6.a.e(cursorC, "url");
            int iE7 = e6.a.e(cursorC, "size");
            int iE8 = e6.a.e(cursorC, "delay");
            int iE9 = e6.a.e(cursorC, "downloads");
            int iE10 = e6.a.e(cursorC, "type");
            int iE11 = e6.a.e(cursorC, "postId");
            int iE12 = e6.a.e(cursorC, "subtitleName");
            int iE13 = e6.a.e(cursorC, "subjectId");
            int iE14 = e6.a.e(cursorC, "ep");
            vVar = vVarC;
            try {
                int iE15 = e6.a.e(cursorC, "se");
                int iE16 = e6.a.e(cursorC, "resolution");
                int iE17 = e6.a.e(cursorC, "subjectName");
                int iE18 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE19 = e6.a.e(cursorC, "fileCharsetName");
                int iE20 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE21 = e6.a.e(cursorC, "zipPath");
                int iE22 = e6.a.e(cursorC, "taskId");
                int iE23 = e6.a.e(cursorC, "failCount");
                if (cursorC.moveToFirst()) {
                    subtitleDownloadTable = new SubtitleDownloadTable(cursorC.isNull(iE) ? null : cursorC.getString(iE), cursorC.getInt(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : cursorC.getString(iE5), cursorC.isNull(iE6) ? null : cursorC.getString(iE6), cursorC.isNull(iE7) ? null : Long.valueOf(cursorC.getLong(iE7)), cursorC.isNull(iE8) ? null : Long.valueOf(cursorC.getLong(iE8)), cursorC.isNull(iE9) ? null : Integer.valueOf(cursorC.getInt(iE9)), cursorC.getInt(iE10), cursorC.isNull(iE11) ? null : cursorC.getString(iE11), cursorC.isNull(iE12) ? null : cursorC.getString(iE12), cursorC.isNull(iE13) ? null : cursorC.getString(iE13), cursorC.getInt(iE14), cursorC.getInt(iE15), cursorC.getInt(iE16), cursorC.isNull(iE17) ? null : cursorC.getString(iE17), cursorC.getInt(iE18), cursorC.isNull(iE19) ? null : cursorC.getString(iE19), cursorC.isNull(r21) ? null : cursorC.getString(iE20), cursorC.isNull(r22) ? null : cursorC.getString(iE21), cursorC.isNull(r23) ? null : cursorC.getString(iE22), cursorC.getInt(iE23));
                } else {
                    subtitleDownloadTable = null;
                }
                cursorC.close();
                vVar.release();
                return subtitleDownloadTable;
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

    @Override // dy.a
    public Object d(int i11, Continuation<? super List<SubtitleDownloadTable>> continuation) {
        v vVarC = v.c("SELECT * FROM st_download_table WHERE status = ?", 1);
        vVarC.V(1, i11);
        return CoroutinesRoom.a(this.f63549a, false, e6.b.a(), new h(vVarC), continuation);
    }

    @Override // dy.a
    public Object e(SubtitleDownloadTable subtitleDownloadTable, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f63549a, true, new f(subtitleDownloadTable), continuation);
    }

    @Override // dy.a
    public void f(SubtitleDownloadTable subtitleDownloadTable) {
        this.f63549a.d();
        this.f63549a.e();
        try {
            this.f63552d.j(subtitleDownloadTable);
            this.f63549a.E();
        } finally {
            this.f63549a.i();
        }
    }

    @Override // dy.a
    public void g(SubtitleDownloadTable subtitleDownloadTable) {
        this.f63549a.d();
        this.f63549a.e();
        try {
            this.f63551c.j(subtitleDownloadTable);
            this.f63549a.E();
        } finally {
            this.f63549a.i();
        }
    }
}
