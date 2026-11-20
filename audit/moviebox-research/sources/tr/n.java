package tr;

import android.database.Cursor;
import androidx.core.app.NotificationCompat;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.v;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.baselib.db.download.SubtitleBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class n implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f77389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.i<SubtitleBean> f77390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.room.h<SubtitleBean> f77391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f77392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f77393e;

    /* JADX INFO: compiled from: source.java */
    public class a implements Callable<List<SubtitleBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f77394a;

        public a(v vVar) {
            this.f77394a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<SubtitleBean> call() throws Exception {
            a aVar;
            Cursor cursorC = e6.b.c(n.this.f77389a, this.f77394a, false, null);
            try {
                int iE = e6.a.e(cursorC, "resourceId");
                int iE2 = e6.a.e(cursorC, "postId");
                int iE3 = e6.a.e(cursorC, "url");
                int iE4 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE5 = e6.a.e(cursorC, "lan");
                int iE6 = e6.a.e(cursorC, "lanName");
                int iE7 = e6.a.e(cursorC, "subtitleName");
                int iE8 = e6.a.e(cursorC, "size");
                int iE9 = e6.a.e(cursorC, "delayDuration");
                int iE10 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE11 = e6.a.e(cursorC, "type");
                int iE12 = e6.a.e(cursorC, "fileCharsetName");
                int iE13 = e6.a.e(cursorC, "subjectId");
                int iE14 = e6.a.e(cursorC, "ep");
                try {
                    int iE15 = e6.a.e(cursorC, "se");
                    int iE16 = e6.a.e(cursorC, "resolution");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string3 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string4 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        String string5 = cursorC.isNull(iE5) ? null : cursorC.getString(iE5);
                        String string6 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string7 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        Long lValueOf = cursorC.isNull(iE8) ? null : Long.valueOf(cursorC.getLong(iE8));
                        Long lValueOf2 = cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9));
                        int i12 = cursorC.getInt(iE10);
                        int i13 = cursorC.getInt(iE11);
                        String string8 = cursorC.isNull(iE12) ? null : cursorC.getString(iE12);
                        String string9 = cursorC.isNull(iE13) ? null : cursorC.getString(iE13);
                        int i14 = cursorC.getInt(i11);
                        int i15 = iE;
                        int i16 = iE15;
                        int i17 = cursorC.getInt(i16);
                        iE15 = i16;
                        int i18 = iE16;
                        iE16 = i18;
                        arrayList.add(new SubtitleBean(string, string2, string3, string4, string5, string6, string7, lValueOf, lValueOf2, i12, i13, string8, string9, i14, i17, cursorC.getInt(i18)));
                        iE = i15;
                        i11 = i11;
                    }
                    cursorC.close();
                    this.f77394a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    aVar = this;
                    cursorC.close();
                    aVar.f77394a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                aVar = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Callable<List<SubtitleBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f77396a;

        public b(v vVar) {
            this.f77396a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<SubtitleBean> call() throws Exception {
            b bVar;
            Cursor cursorC = e6.b.c(n.this.f77389a, this.f77396a, false, null);
            try {
                int iE = e6.a.e(cursorC, "resourceId");
                int iE2 = e6.a.e(cursorC, "postId");
                int iE3 = e6.a.e(cursorC, "url");
                int iE4 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE5 = e6.a.e(cursorC, "lan");
                int iE6 = e6.a.e(cursorC, "lanName");
                int iE7 = e6.a.e(cursorC, "subtitleName");
                int iE8 = e6.a.e(cursorC, "size");
                int iE9 = e6.a.e(cursorC, "delayDuration");
                int iE10 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE11 = e6.a.e(cursorC, "type");
                int iE12 = e6.a.e(cursorC, "fileCharsetName");
                int iE13 = e6.a.e(cursorC, "subjectId");
                int iE14 = e6.a.e(cursorC, "ep");
                try {
                    int iE15 = e6.a.e(cursorC, "se");
                    int iE16 = e6.a.e(cursorC, "resolution");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string3 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string4 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        String string5 = cursorC.isNull(iE5) ? null : cursorC.getString(iE5);
                        String string6 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string7 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        Long lValueOf = cursorC.isNull(iE8) ? null : Long.valueOf(cursorC.getLong(iE8));
                        Long lValueOf2 = cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9));
                        int i12 = cursorC.getInt(iE10);
                        int i13 = cursorC.getInt(iE11);
                        String string8 = cursorC.isNull(iE12) ? null : cursorC.getString(iE12);
                        String string9 = cursorC.isNull(iE13) ? null : cursorC.getString(iE13);
                        int i14 = cursorC.getInt(i11);
                        int i15 = iE;
                        int i16 = iE15;
                        int i17 = cursorC.getInt(i16);
                        iE15 = i16;
                        int i18 = iE16;
                        iE16 = i18;
                        arrayList.add(new SubtitleBean(string, string2, string3, string4, string5, string6, string7, lValueOf, lValueOf2, i12, i13, string8, string9, i14, i17, cursorC.getInt(i18)));
                        iE = i15;
                        i11 = i11;
                    }
                    cursorC.close();
                    this.f77396a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    bVar = this;
                    cursorC.close();
                    bVar.f77396a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bVar = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Callable<List<SubtitleBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f77398a;

        public c(v vVar) {
            this.f77398a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<SubtitleBean> call() throws Exception {
            c cVar;
            Cursor cursorC = e6.b.c(n.this.f77389a, this.f77398a, false, null);
            try {
                int iE = e6.a.e(cursorC, "resourceId");
                int iE2 = e6.a.e(cursorC, "postId");
                int iE3 = e6.a.e(cursorC, "url");
                int iE4 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE5 = e6.a.e(cursorC, "lan");
                int iE6 = e6.a.e(cursorC, "lanName");
                int iE7 = e6.a.e(cursorC, "subtitleName");
                int iE8 = e6.a.e(cursorC, "size");
                int iE9 = e6.a.e(cursorC, "delayDuration");
                int iE10 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE11 = e6.a.e(cursorC, "type");
                int iE12 = e6.a.e(cursorC, "fileCharsetName");
                int iE13 = e6.a.e(cursorC, "subjectId");
                int iE14 = e6.a.e(cursorC, "ep");
                try {
                    int iE15 = e6.a.e(cursorC, "se");
                    int iE16 = e6.a.e(cursorC, "resolution");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string3 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string4 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        String string5 = cursorC.isNull(iE5) ? null : cursorC.getString(iE5);
                        String string6 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string7 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        Long lValueOf = cursorC.isNull(iE8) ? null : Long.valueOf(cursorC.getLong(iE8));
                        Long lValueOf2 = cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9));
                        int i12 = cursorC.getInt(iE10);
                        int i13 = cursorC.getInt(iE11);
                        String string8 = cursorC.isNull(iE12) ? null : cursorC.getString(iE12);
                        String string9 = cursorC.isNull(iE13) ? null : cursorC.getString(iE13);
                        int i14 = cursorC.getInt(i11);
                        int i15 = iE;
                        int i16 = iE15;
                        int i17 = cursorC.getInt(i16);
                        iE15 = i16;
                        int i18 = iE16;
                        iE16 = i18;
                        arrayList.add(new SubtitleBean(string, string2, string3, string4, string5, string6, string7, lValueOf, lValueOf2, i12, i13, string8, string9, i14, i17, cursorC.getInt(i18)));
                        iE = i15;
                        i11 = i11;
                    }
                    cursorC.close();
                    this.f77398a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    cVar = this;
                    cursorC.close();
                    cVar.f77398a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cVar = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends androidx.room.i<SubtitleBean> {
        public d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `download_subtitle_table` (`resourceId`,`postId`,`url`,`path`,`lan`,`lanName`,`subtitleName`,`size`,`delayDuration`,`status`,`type`,`fileCharsetName`,`subjectId`,`ep`,`se`,`resolution`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, SubtitleBean subtitleBean) {
            if (subtitleBean.getResourceId() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, subtitleBean.getResourceId());
            }
            if (subtitleBean.getPostId() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, subtitleBean.getPostId());
            }
            if (subtitleBean.getUrl() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, subtitleBean.getUrl());
            }
            if (subtitleBean.getPath() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, subtitleBean.getPath());
            }
            if (subtitleBean.getLan() == null) {
                kVar.m0(5);
            } else {
                kVar.s(5, subtitleBean.getLan());
            }
            if (subtitleBean.getLanName() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, subtitleBean.getLanName());
            }
            if (subtitleBean.getSubtitleName() == null) {
                kVar.m0(7);
            } else {
                kVar.s(7, subtitleBean.getSubtitleName());
            }
            if (subtitleBean.getSize() == null) {
                kVar.m0(8);
            } else {
                kVar.V(8, subtitleBean.getSize().longValue());
            }
            if (subtitleBean.getDelayDuration() == null) {
                kVar.m0(9);
            } else {
                kVar.V(9, subtitleBean.getDelayDuration().longValue());
            }
            kVar.V(10, subtitleBean.getStatus());
            kVar.V(11, subtitleBean.getType());
            if (subtitleBean.getFileCharsetName() == null) {
                kVar.m0(12);
            } else {
                kVar.s(12, subtitleBean.getFileCharsetName());
            }
            if (subtitleBean.getSubjectId() == null) {
                kVar.m0(13);
            } else {
                kVar.s(13, subtitleBean.getSubjectId());
            }
            kVar.V(14, subtitleBean.getEp());
            kVar.V(15, subtitleBean.getSe());
            kVar.V(16, subtitleBean.getResolution());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends androidx.room.h<SubtitleBean> {
        public e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE OR ABORT `download_subtitle_table` SET `resourceId` = ?,`postId` = ?,`url` = ?,`path` = ?,`lan` = ?,`lanName` = ?,`subtitleName` = ?,`size` = ?,`delayDuration` = ?,`status` = ?,`type` = ?,`fileCharsetName` = ?,`subjectId` = ?,`ep` = ?,`se` = ?,`resolution` = ? WHERE `resourceId` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, SubtitleBean subtitleBean) {
            if (subtitleBean.getResourceId() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, subtitleBean.getResourceId());
            }
            if (subtitleBean.getPostId() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, subtitleBean.getPostId());
            }
            if (subtitleBean.getUrl() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, subtitleBean.getUrl());
            }
            if (subtitleBean.getPath() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, subtitleBean.getPath());
            }
            if (subtitleBean.getLan() == null) {
                kVar.m0(5);
            } else {
                kVar.s(5, subtitleBean.getLan());
            }
            if (subtitleBean.getLanName() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, subtitleBean.getLanName());
            }
            if (subtitleBean.getSubtitleName() == null) {
                kVar.m0(7);
            } else {
                kVar.s(7, subtitleBean.getSubtitleName());
            }
            if (subtitleBean.getSize() == null) {
                kVar.m0(8);
            } else {
                kVar.V(8, subtitleBean.getSize().longValue());
            }
            if (subtitleBean.getDelayDuration() == null) {
                kVar.m0(9);
            } else {
                kVar.V(9, subtitleBean.getDelayDuration().longValue());
            }
            kVar.V(10, subtitleBean.getStatus());
            kVar.V(11, subtitleBean.getType());
            if (subtitleBean.getFileCharsetName() == null) {
                kVar.m0(12);
            } else {
                kVar.s(12, subtitleBean.getFileCharsetName());
            }
            if (subtitleBean.getSubjectId() == null) {
                kVar.m0(13);
            } else {
                kVar.s(13, subtitleBean.getSubjectId());
            }
            kVar.V(14, subtitleBean.getEp());
            kVar.V(15, subtitleBean.getSe());
            kVar.V(16, subtitleBean.getResolution());
            if (subtitleBean.getResourceId() == null) {
                kVar.m0(17);
            } else {
                kVar.s(17, subtitleBean.getResourceId());
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
            return "DELETE FROM DOWNLOAD_SUBTITLE_TABLE WHERE postId=?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends SharedSQLiteStatement {
        public g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM DOWNLOAD_SUBTITLE_TABLE WHERE resourceId=?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubtitleBean f77404a;

        public h(SubtitleBean subtitleBean) {
            this.f77404a = subtitleBean;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            n.this.f77389a.e();
            try {
                n.this.f77391c.j(this.f77404a);
                n.this.f77389a.E();
                return Unit.f68710a;
            } finally {
                n.this.f77389a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f77406a;

        public i(String str) {
            this.f77406a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            g6.k kVarB = n.this.f77392d.b();
            String str = this.f77406a;
            if (str == null) {
                kVarB.m0(1);
            } else {
                kVarB.s(1, str);
            }
            n.this.f77389a.e();
            try {
                kVarB.F();
                n.this.f77389a.E();
                return Unit.f68710a;
            } finally {
                n.this.f77389a.i();
                n.this.f77392d.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class j implements Callable<List<SubtitleBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f77408a;

        public j(v vVar) {
            this.f77408a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<SubtitleBean> call() throws Exception {
            j jVar;
            Cursor cursorC = e6.b.c(n.this.f77389a, this.f77408a, false, null);
            try {
                int iE = e6.a.e(cursorC, "resourceId");
                int iE2 = e6.a.e(cursorC, "postId");
                int iE3 = e6.a.e(cursorC, "url");
                int iE4 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE5 = e6.a.e(cursorC, "lan");
                int iE6 = e6.a.e(cursorC, "lanName");
                int iE7 = e6.a.e(cursorC, "subtitleName");
                int iE8 = e6.a.e(cursorC, "size");
                int iE9 = e6.a.e(cursorC, "delayDuration");
                int iE10 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE11 = e6.a.e(cursorC, "type");
                int iE12 = e6.a.e(cursorC, "fileCharsetName");
                int iE13 = e6.a.e(cursorC, "subjectId");
                int iE14 = e6.a.e(cursorC, "ep");
                try {
                    int iE15 = e6.a.e(cursorC, "se");
                    int iE16 = e6.a.e(cursorC, "resolution");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string3 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string4 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        String string5 = cursorC.isNull(iE5) ? null : cursorC.getString(iE5);
                        String string6 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string7 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        Long lValueOf = cursorC.isNull(iE8) ? null : Long.valueOf(cursorC.getLong(iE8));
                        Long lValueOf2 = cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9));
                        int i12 = cursorC.getInt(iE10);
                        int i13 = cursorC.getInt(iE11);
                        String string8 = cursorC.isNull(iE12) ? null : cursorC.getString(iE12);
                        String string9 = cursorC.isNull(iE13) ? null : cursorC.getString(iE13);
                        int i14 = cursorC.getInt(i11);
                        int i15 = iE;
                        int i16 = iE15;
                        int i17 = cursorC.getInt(i16);
                        iE15 = i16;
                        int i18 = iE16;
                        iE16 = i18;
                        arrayList.add(new SubtitleBean(string, string2, string3, string4, string5, string6, string7, lValueOf, lValueOf2, i12, i13, string8, string9, i14, i17, cursorC.getInt(i18)));
                        iE = i15;
                        i11 = i11;
                    }
                    cursorC.close();
                    this.f77408a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    jVar = this;
                    cursorC.close();
                    jVar.f77408a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                jVar = this;
            }
        }
    }

    public n(RoomDatabase roomDatabase) {
        this.f77389a = roomDatabase;
        this.f77390b = new d(roomDatabase);
        this.f77391c = new e(roomDatabase);
        this.f77392d = new f(roomDatabase);
        this.f77393e = new g(roomDatabase);
    }

    public static List<Class<?>> j() {
        return Collections.emptyList();
    }

    @Override // tr.m
    public Object a(String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f77389a, true, new i(str), continuation);
    }

    @Override // tr.m
    public Object b(SubtitleBean subtitleBean, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f77389a, true, new h(subtitleBean), continuation);
    }

    @Override // tr.m
    public Object c(Continuation<? super List<SubtitleBean>> continuation) {
        v vVarC = v.c("SELECT * FROM DOWNLOAD_SUBTITLE_TABLE", 0);
        return CoroutinesRoom.a(this.f77389a, false, e6.b.a(), new c(vVarC), continuation);
    }

    @Override // tr.m
    public Object d(String str, Continuation<? super List<SubtitleBean>> continuation) {
        v vVarC = v.c("SELECT * FROM DOWNLOAD_SUBTITLE_TABLE WHERE subjectId = ? ", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f77389a, false, e6.b.a(), new a(vVarC), continuation);
    }

    @Override // tr.m
    public Object e(String str, int i11, int i12, Continuation<? super List<SubtitleBean>> continuation) {
        v vVarC = v.c("SELECT * FROM DOWNLOAD_SUBTITLE_TABLE WHERE subjectId = ? AND ep = ? AND se = ?", 3);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        vVarC.V(2, i11);
        vVarC.V(3, i12);
        return CoroutinesRoom.a(this.f77389a, false, e6.b.a(), new b(vVarC), continuation);
    }

    @Override // tr.m
    public Object f(String str, Continuation<? super List<SubtitleBean>> continuation) {
        v vVarC = v.c("SELECT * FROM DOWNLOAD_SUBTITLE_TABLE WHERE postId = ? ", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f77389a, false, e6.b.a(), new j(vVarC), continuation);
    }
}
