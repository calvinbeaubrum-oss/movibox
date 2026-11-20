package tr;

import android.database.Cursor;
import androidx.core.app.NotificationCompat;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.baselib.db.download.DownloadBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements tr.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f77271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.i<DownloadBean> f77272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.room.h<DownloadBean> f77273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.room.h<DownloadBean> f77274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f77275e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SharedSQLiteStatement f77276f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SharedSQLiteStatement f77277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SharedSQLiteStatement f77278h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SharedSQLiteStatement f77279i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SharedSQLiteStatement f77280j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SharedSQLiteStatement f77281k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SharedSQLiteStatement f77282l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SharedSQLiteStatement f77283m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SharedSQLiteStatement f77284n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SharedSQLiteStatement f77285o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final SharedSQLiteStatement f77286p;

    /* JADX INFO: compiled from: source.java */
    public class a extends SharedSQLiteStatement {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE DOWNLOAD_TABLE SET subtitleSelectId = ? WHERE resourceId = ? ";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a0 implements Callable<DownloadBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.v f77288a;

        public a0(androidx.room.v vVar) {
            this.f77288a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadBean call() throws Exception {
            DownloadBean downloadBean;
            a0 a0Var = this;
            Cursor cursorC = e6.b.c(d.this.f77271a, a0Var.f77288a, false, null);
            try {
                int iE = e6.a.e(cursorC, "url");
                int iE2 = e6.a.e(cursorC, "resourceId");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "cover");
                int iE5 = e6.a.e(cursorC, "size");
                int iE6 = e6.a.e(cursorC, "postId");
                int iE7 = e6.a.e(cursorC, "sizeFormat");
                int iE8 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE9 = e6.a.e(cursorC, "duration");
                int iE10 = e6.a.e(cursorC, "updateTimeStamp");
                int iE11 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE12 = e6.a.e(cursorC, "supportRanges");
                int iE13 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE14 = e6.a.e(cursorC, "type");
                try {
                    int iE15 = e6.a.e(cursorC, "readProgress");
                    int iE16 = e6.a.e(cursorC, "createAt");
                    int iE17 = e6.a.e(cursorC, "isRead");
                    int iE18 = e6.a.e(cursorC, "episode");
                    int iE19 = e6.a.e(cursorC, "ep");
                    int iE20 = e6.a.e(cursorC, "se");
                    int iE21 = e6.a.e(cursorC, "resolution");
                    int iE22 = e6.a.e(cursorC, "resourcePosition");
                    int iE23 = e6.a.e(cursorC, "multiresolution");
                    int iE24 = e6.a.e(cursorC, "videoWidth");
                    int iE25 = e6.a.e(cursorC, "videoHeight");
                    int iE26 = e6.a.e(cursorC, "downloadErrorCount");
                    int iE27 = e6.a.e(cursorC, "subtitleStarted");
                    int iE28 = e6.a.e(cursorC, "subjectId");
                    int iE29 = e6.a.e(cursorC, "pageFrom");
                    int iE30 = e6.a.e(cursorC, "lastPageFrom");
                    int iE31 = e6.a.e(cursorC, "subjectName");
                    int iE32 = e6.a.e(cursorC, "lastPlayTimeStamp");
                    int iE33 = e6.a.e(cursorC, "fileType");
                    int iE34 = e6.a.e(cursorC, "totalEpisode");
                    int iE35 = e6.a.e(cursorC, "uploadBy");
                    int iE36 = e6.a.e(cursorC, "sourceUrl");
                    int iE37 = e6.a.e(cursorC, "urlCreateAt");
                    int iE38 = e6.a.e(cursorC, "subtitleSelectId");
                    int iE39 = e6.a.e(cursorC, "taskId");
                    int iE40 = e6.a.e(cursorC, "sessionTime");
                    int iE41 = e6.a.e(cursorC, "reportStatus");
                    int iE42 = e6.a.e(cursorC, "downloadHeaderSize");
                    int iE43 = e6.a.e(cursorC, "rootPath");
                    int iE44 = e6.a.e(cursorC, "rootPathType");
                    int iE45 = e6.a.e(cursorC, "thumbnail");
                    int iE46 = e6.a.e(cursorC, "averageHueLight");
                    int iE47 = e6.a.e(cursorC, "isTransferFailed");
                    int iE48 = e6.a.e(cursorC, "isClosedTransferFailed");
                    int iE49 = e6.a.e(cursorC, "subjectType");
                    int iE50 = e6.a.e(cursorC, "genre");
                    int iE51 = e6.a.e(cursorC, "subjectDurationSeconds");
                    int iE52 = e6.a.e(cursorC, "currentDubLanName");
                    int iE53 = e6.a.e(cursorC, "currentDubLanCode");
                    int iE54 = e6.a.e(cursorC, "ops");
                    int iE55 = e6.a.e(cursorC, "restrictLevel");
                    int iE56 = e6.a.e(cursorC, "releaseDate");
                    int iE57 = e6.a.e(cursorC, "countryName");
                    int iE58 = e6.a.e(cursorC, "seNum");
                    int iE59 = e6.a.e(cursorC, "subtitles");
                    int iE60 = e6.a.e(cursorC, "imdbRate");
                    int iE61 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE62 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    if (cursorC.moveToFirst()) {
                        downloadBean = new DownloadBean(cursorC.isNull(iE) ? null : cursorC.getString(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : Long.valueOf(cursorC.getLong(iE5)), cursorC.isNull(iE6) ? null : cursorC.getString(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : cursorC.getString(iE8), cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9)), cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10)), cursorC.getLong(iE11), cursorC.getInt(iE12), cursorC.getInt(iE13), cursorC.getInt(iE14), cursorC.getLong(iE15), cursorC.getLong(iE16), cursorC.getInt(iE17), cursorC.getInt(iE18), cursorC.getInt(iE19), cursorC.getInt(iE20), cursorC.getInt(iE21), cursorC.getInt(iE22), cursorC.getInt(iE23), cursorC.getInt(iE24), cursorC.getInt(iE25), cursorC.getInt(iE26), cursorC.getInt(iE27), cursorC.isNull(iE28) ? null : cursorC.getString(iE28), cursorC.isNull(r30) ? null : cursorC.getString(iE29), cursorC.isNull(r31) ? null : cursorC.getString(iE30), cursorC.isNull(r32) ? null : cursorC.getString(iE31), cursorC.getLong(iE32), cursorC.getInt(iE33), cursorC.getInt(iE34), cursorC.isNull(iE35) ? null : cursorC.getString(iE35), cursorC.isNull(r37) ? null : cursorC.getString(iE36), cursorC.getLong(iE37), cursorC.isNull(iE38) ? null : cursorC.getString(iE38), cursorC.isNull(r40) ? null : cursorC.getString(iE39), cursorC.getLong(iE40), cursorC.getInt(iE41), cursorC.getLong(iE42), cursorC.isNull(iE43) ? null : cursorC.getString(iE43), cursorC.getInt(iE44), cursorC.isNull(iE45) ? null : cursorC.getString(iE45), cursorC.isNull(r47) ? null : cursorC.getString(iE46), cursorC.getInt(iE47) != 0, cursorC.getInt(iE48) != 0, cursorC.getInt(iE49), cursorC.isNull(iE50) ? null : cursorC.getString(iE50), cursorC.isNull(r52) ? null : Integer.valueOf(cursorC.getInt(iE51)), cursorC.isNull(r53) ? null : cursorC.getString(iE52), cursorC.isNull(r54) ? null : cursorC.getString(iE53), cursorC.isNull(r55) ? null : cursorC.getString(iE54), cursorC.isNull(r56) ? null : cursorC.getString(iE55), cursorC.isNull(r57) ? null : cursorC.getString(iE56), cursorC.isNull(r58) ? null : cursorC.getString(iE57), cursorC.isNull(r59) ? null : Integer.valueOf(cursorC.getInt(iE58)), cursorC.isNull(r60) ? null : cursorC.getString(iE59), cursorC.isNull(r61) ? null : cursorC.getString(iE60), cursorC.isNull(r62) ? null : Long.valueOf(cursorC.getLong(iE61)), cursorC.isNull(iE62) ? null : Long.valueOf(cursorC.getLong(iE62)));
                    } else {
                        downloadBean = null;
                    }
                    cursorC.close();
                    this.f77288a.release();
                    return downloadBean;
                } catch (Throwable th2) {
                    th = th2;
                    a0Var = this;
                    cursorC.close();
                    a0Var.f77288a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends SharedSQLiteStatement {
        public b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM DOWNLOAD_TABLE";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b0 implements Callable<List<? extends DownloadBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.v f77291a;

        public b0(androidx.room.v vVar) {
            this.f77291a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<? extends DownloadBean> call() throws Exception {
            b0 b0Var;
            Cursor cursorC = e6.b.c(d.this.f77271a, this.f77291a, false, null);
            try {
                int iE = e6.a.e(cursorC, "url");
                int iE2 = e6.a.e(cursorC, "resourceId");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "cover");
                int iE5 = e6.a.e(cursorC, "size");
                int iE6 = e6.a.e(cursorC, "postId");
                int iE7 = e6.a.e(cursorC, "sizeFormat");
                int iE8 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE9 = e6.a.e(cursorC, "duration");
                int iE10 = e6.a.e(cursorC, "updateTimeStamp");
                int iE11 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE12 = e6.a.e(cursorC, "supportRanges");
                int iE13 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE14 = e6.a.e(cursorC, "type");
                try {
                    int iE15 = e6.a.e(cursorC, "readProgress");
                    int iE16 = e6.a.e(cursorC, "createAt");
                    int iE17 = e6.a.e(cursorC, "isRead");
                    int iE18 = e6.a.e(cursorC, "episode");
                    int iE19 = e6.a.e(cursorC, "ep");
                    int iE20 = e6.a.e(cursorC, "se");
                    int iE21 = e6.a.e(cursorC, "resolution");
                    int iE22 = e6.a.e(cursorC, "resourcePosition");
                    int iE23 = e6.a.e(cursorC, "multiresolution");
                    int iE24 = e6.a.e(cursorC, "videoWidth");
                    int iE25 = e6.a.e(cursorC, "videoHeight");
                    int iE26 = e6.a.e(cursorC, "downloadErrorCount");
                    int iE27 = e6.a.e(cursorC, "subtitleStarted");
                    int iE28 = e6.a.e(cursorC, "subjectId");
                    int iE29 = e6.a.e(cursorC, "pageFrom");
                    int iE30 = e6.a.e(cursorC, "lastPageFrom");
                    int iE31 = e6.a.e(cursorC, "subjectName");
                    int iE32 = e6.a.e(cursorC, "lastPlayTimeStamp");
                    int iE33 = e6.a.e(cursorC, "fileType");
                    int iE34 = e6.a.e(cursorC, "totalEpisode");
                    int iE35 = e6.a.e(cursorC, "uploadBy");
                    int iE36 = e6.a.e(cursorC, "sourceUrl");
                    int iE37 = e6.a.e(cursorC, "urlCreateAt");
                    int iE38 = e6.a.e(cursorC, "subtitleSelectId");
                    int iE39 = e6.a.e(cursorC, "taskId");
                    int iE40 = e6.a.e(cursorC, "sessionTime");
                    int iE41 = e6.a.e(cursorC, "reportStatus");
                    int iE42 = e6.a.e(cursorC, "downloadHeaderSize");
                    int iE43 = e6.a.e(cursorC, "rootPath");
                    int iE44 = e6.a.e(cursorC, "rootPathType");
                    int iE45 = e6.a.e(cursorC, "thumbnail");
                    int iE46 = e6.a.e(cursorC, "averageHueLight");
                    int iE47 = e6.a.e(cursorC, "isTransferFailed");
                    int iE48 = e6.a.e(cursorC, "isClosedTransferFailed");
                    int iE49 = e6.a.e(cursorC, "subjectType");
                    int iE50 = e6.a.e(cursorC, "genre");
                    int iE51 = e6.a.e(cursorC, "subjectDurationSeconds");
                    int iE52 = e6.a.e(cursorC, "currentDubLanName");
                    int iE53 = e6.a.e(cursorC, "currentDubLanCode");
                    int iE54 = e6.a.e(cursorC, "ops");
                    int iE55 = e6.a.e(cursorC, "restrictLevel");
                    int iE56 = e6.a.e(cursorC, "releaseDate");
                    int iE57 = e6.a.e(cursorC, "countryName");
                    int iE58 = e6.a.e(cursorC, "seNum");
                    int iE59 = e6.a.e(cursorC, "subtitles");
                    int iE60 = e6.a.e(cursorC, "imdbRate");
                    int iE61 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE62 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string3 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string4 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        Long lValueOf = cursorC.isNull(iE5) ? null : Long.valueOf(cursorC.getLong(iE5));
                        String string5 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string6 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string7 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        Long lValueOf2 = cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9));
                        Long lValueOf3 = cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10));
                        long j11 = cursorC.getLong(iE11);
                        int i12 = cursorC.getInt(iE12);
                        int i13 = cursorC.getInt(iE13);
                        int i14 = i11;
                        int i15 = cursorC.getInt(i14);
                        int i16 = iE;
                        int i17 = iE15;
                        long j12 = cursorC.getLong(i17);
                        iE15 = i17;
                        int i18 = iE16;
                        long j13 = cursorC.getLong(i18);
                        iE16 = i18;
                        int i19 = iE17;
                        int i21 = cursorC.getInt(i19);
                        iE17 = i19;
                        int i22 = iE18;
                        int i23 = cursorC.getInt(i22);
                        iE18 = i22;
                        int i24 = iE19;
                        int i25 = cursorC.getInt(i24);
                        iE19 = i24;
                        int i26 = iE20;
                        int i27 = cursorC.getInt(i26);
                        iE20 = i26;
                        int i28 = iE21;
                        int i29 = cursorC.getInt(i28);
                        iE21 = i28;
                        int i31 = iE22;
                        int i32 = cursorC.getInt(i31);
                        iE22 = i31;
                        int i33 = iE23;
                        int i34 = cursorC.getInt(i33);
                        iE23 = i33;
                        int i35 = iE24;
                        int i36 = cursorC.getInt(i35);
                        iE24 = i35;
                        int i37 = iE25;
                        int i38 = cursorC.getInt(i37);
                        iE25 = i37;
                        int i39 = iE26;
                        int i40 = cursorC.getInt(i39);
                        iE26 = i39;
                        int i41 = iE27;
                        int i42 = cursorC.getInt(i41);
                        iE27 = i41;
                        iE28 = iE28;
                        String string8 = cursorC.isNull(iE28) ? null : cursorC.getString(iE28);
                        String string9 = cursorC.isNull(iE29) ? null : cursorC.getString(iE29);
                        String string10 = cursorC.isNull(iE30) ? null : cursorC.getString(iE30);
                        String string11 = cursorC.isNull(iE31) ? null : cursorC.getString(iE31);
                        long j14 = cursorC.getLong(iE32);
                        iE32 = iE32;
                        int i43 = iE33;
                        int i44 = cursorC.getInt(i43);
                        iE33 = i43;
                        int i45 = iE34;
                        int i46 = cursorC.getInt(i45);
                        iE34 = i45;
                        iE35 = iE35;
                        String string12 = cursorC.isNull(iE35) ? null : cursorC.getString(iE35);
                        String string13 = cursorC.isNull(iE36) ? null : cursorC.getString(iE36);
                        long j15 = cursorC.getLong(iE37);
                        iE37 = iE37;
                        iE38 = iE38;
                        String string14 = cursorC.isNull(iE38) ? null : cursorC.getString(iE38);
                        String string15 = cursorC.isNull(iE39) ? null : cursorC.getString(iE39);
                        long j16 = cursorC.getLong(iE40);
                        iE40 = iE40;
                        int i47 = iE41;
                        int i48 = cursorC.getInt(i47);
                        iE41 = i47;
                        int i49 = iE42;
                        long j17 = cursorC.getLong(i49);
                        iE42 = i49;
                        iE43 = iE43;
                        String string16 = cursorC.isNull(iE43) ? null : cursorC.getString(iE43);
                        int i50 = cursorC.getInt(iE44);
                        iE44 = iE44;
                        iE45 = iE45;
                        String string17 = cursorC.isNull(iE45) ? null : cursorC.getString(iE45);
                        String string18 = cursorC.isNull(iE46) ? null : cursorC.getString(iE46);
                        boolean z11 = cursorC.getInt(iE47) != 0;
                        boolean z12 = cursorC.getInt(iE48) != 0;
                        int i51 = cursorC.getInt(iE49);
                        iE49 = iE49;
                        iE50 = iE50;
                        arrayList.add(new DownloadBean(string, string2, string3, string4, lValueOf, string5, string6, string7, lValueOf2, lValueOf3, j11, i12, i13, i15, j12, j13, i21, i23, i25, i27, i29, i32, i34, i36, i38, i40, i42, string8, string9, string10, string11, j14, i44, i46, string12, string13, j15, string14, string15, j16, i48, j17, string16, i50, string17, string18, z11, z12, i51, cursorC.isNull(iE50) ? null : cursorC.getString(iE50), cursorC.isNull(iE51) ? null : Integer.valueOf(cursorC.getInt(iE51)), cursorC.isNull(iE52) ? null : cursorC.getString(iE52), cursorC.isNull(iE53) ? null : cursorC.getString(iE53), cursorC.isNull(iE54) ? null : cursorC.getString(iE54), cursorC.isNull(iE55) ? null : cursorC.getString(iE55), cursorC.isNull(iE56) ? null : cursorC.getString(iE56), cursorC.isNull(iE57) ? null : cursorC.getString(iE57), cursorC.isNull(iE58) ? null : Integer.valueOf(cursorC.getInt(iE58)), cursorC.isNull(iE59) ? null : cursorC.getString(iE59), cursorC.isNull(iE60) ? null : cursorC.getString(iE60), cursorC.isNull(iE61) ? null : Long.valueOf(cursorC.getLong(iE61)), cursorC.isNull(iE62) ? null : Long.valueOf(cursorC.getLong(iE62))));
                        iE = i16;
                        i11 = i14;
                    }
                    cursorC.close();
                    this.f77291a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    b0Var = this;
                    cursorC.close();
                    b0Var.f77291a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                b0Var = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends SharedSQLiteStatement {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM DOWNLOAD_TABLE WHERE resourceId=?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c0 implements Callable<List<? extends DownloadBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.v f77294a;

        public c0(androidx.room.v vVar) {
            this.f77294a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<? extends DownloadBean> call() throws Exception {
            c0 c0Var;
            Cursor cursorC = e6.b.c(d.this.f77271a, this.f77294a, false, null);
            try {
                int iE = e6.a.e(cursorC, "url");
                int iE2 = e6.a.e(cursorC, "resourceId");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "cover");
                int iE5 = e6.a.e(cursorC, "size");
                int iE6 = e6.a.e(cursorC, "postId");
                int iE7 = e6.a.e(cursorC, "sizeFormat");
                int iE8 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE9 = e6.a.e(cursorC, "duration");
                int iE10 = e6.a.e(cursorC, "updateTimeStamp");
                int iE11 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE12 = e6.a.e(cursorC, "supportRanges");
                int iE13 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE14 = e6.a.e(cursorC, "type");
                try {
                    int iE15 = e6.a.e(cursorC, "readProgress");
                    int iE16 = e6.a.e(cursorC, "createAt");
                    int iE17 = e6.a.e(cursorC, "isRead");
                    int iE18 = e6.a.e(cursorC, "episode");
                    int iE19 = e6.a.e(cursorC, "ep");
                    int iE20 = e6.a.e(cursorC, "se");
                    int iE21 = e6.a.e(cursorC, "resolution");
                    int iE22 = e6.a.e(cursorC, "resourcePosition");
                    int iE23 = e6.a.e(cursorC, "multiresolution");
                    int iE24 = e6.a.e(cursorC, "videoWidth");
                    int iE25 = e6.a.e(cursorC, "videoHeight");
                    int iE26 = e6.a.e(cursorC, "downloadErrorCount");
                    int iE27 = e6.a.e(cursorC, "subtitleStarted");
                    int iE28 = e6.a.e(cursorC, "subjectId");
                    int iE29 = e6.a.e(cursorC, "pageFrom");
                    int iE30 = e6.a.e(cursorC, "lastPageFrom");
                    int iE31 = e6.a.e(cursorC, "subjectName");
                    int iE32 = e6.a.e(cursorC, "lastPlayTimeStamp");
                    int iE33 = e6.a.e(cursorC, "fileType");
                    int iE34 = e6.a.e(cursorC, "totalEpisode");
                    int iE35 = e6.a.e(cursorC, "uploadBy");
                    int iE36 = e6.a.e(cursorC, "sourceUrl");
                    int iE37 = e6.a.e(cursorC, "urlCreateAt");
                    int iE38 = e6.a.e(cursorC, "subtitleSelectId");
                    int iE39 = e6.a.e(cursorC, "taskId");
                    int iE40 = e6.a.e(cursorC, "sessionTime");
                    int iE41 = e6.a.e(cursorC, "reportStatus");
                    int iE42 = e6.a.e(cursorC, "downloadHeaderSize");
                    int iE43 = e6.a.e(cursorC, "rootPath");
                    int iE44 = e6.a.e(cursorC, "rootPathType");
                    int iE45 = e6.a.e(cursorC, "thumbnail");
                    int iE46 = e6.a.e(cursorC, "averageHueLight");
                    int iE47 = e6.a.e(cursorC, "isTransferFailed");
                    int iE48 = e6.a.e(cursorC, "isClosedTransferFailed");
                    int iE49 = e6.a.e(cursorC, "subjectType");
                    int iE50 = e6.a.e(cursorC, "genre");
                    int iE51 = e6.a.e(cursorC, "subjectDurationSeconds");
                    int iE52 = e6.a.e(cursorC, "currentDubLanName");
                    int iE53 = e6.a.e(cursorC, "currentDubLanCode");
                    int iE54 = e6.a.e(cursorC, "ops");
                    int iE55 = e6.a.e(cursorC, "restrictLevel");
                    int iE56 = e6.a.e(cursorC, "releaseDate");
                    int iE57 = e6.a.e(cursorC, "countryName");
                    int iE58 = e6.a.e(cursorC, "seNum");
                    int iE59 = e6.a.e(cursorC, "subtitles");
                    int iE60 = e6.a.e(cursorC, "imdbRate");
                    int iE61 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE62 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string3 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string4 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        Long lValueOf = cursorC.isNull(iE5) ? null : Long.valueOf(cursorC.getLong(iE5));
                        String string5 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string6 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string7 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        Long lValueOf2 = cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9));
                        Long lValueOf3 = cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10));
                        long j11 = cursorC.getLong(iE11);
                        int i12 = cursorC.getInt(iE12);
                        int i13 = cursorC.getInt(iE13);
                        int i14 = i11;
                        int i15 = cursorC.getInt(i14);
                        int i16 = iE;
                        int i17 = iE15;
                        long j12 = cursorC.getLong(i17);
                        iE15 = i17;
                        int i18 = iE16;
                        long j13 = cursorC.getLong(i18);
                        iE16 = i18;
                        int i19 = iE17;
                        int i21 = cursorC.getInt(i19);
                        iE17 = i19;
                        int i22 = iE18;
                        int i23 = cursorC.getInt(i22);
                        iE18 = i22;
                        int i24 = iE19;
                        int i25 = cursorC.getInt(i24);
                        iE19 = i24;
                        int i26 = iE20;
                        int i27 = cursorC.getInt(i26);
                        iE20 = i26;
                        int i28 = iE21;
                        int i29 = cursorC.getInt(i28);
                        iE21 = i28;
                        int i31 = iE22;
                        int i32 = cursorC.getInt(i31);
                        iE22 = i31;
                        int i33 = iE23;
                        int i34 = cursorC.getInt(i33);
                        iE23 = i33;
                        int i35 = iE24;
                        int i36 = cursorC.getInt(i35);
                        iE24 = i35;
                        int i37 = iE25;
                        int i38 = cursorC.getInt(i37);
                        iE25 = i37;
                        int i39 = iE26;
                        int i40 = cursorC.getInt(i39);
                        iE26 = i39;
                        int i41 = iE27;
                        int i42 = cursorC.getInt(i41);
                        iE27 = i41;
                        iE28 = iE28;
                        String string8 = cursorC.isNull(iE28) ? null : cursorC.getString(iE28);
                        String string9 = cursorC.isNull(iE29) ? null : cursorC.getString(iE29);
                        String string10 = cursorC.isNull(iE30) ? null : cursorC.getString(iE30);
                        String string11 = cursorC.isNull(iE31) ? null : cursorC.getString(iE31);
                        long j14 = cursorC.getLong(iE32);
                        iE32 = iE32;
                        int i43 = iE33;
                        int i44 = cursorC.getInt(i43);
                        iE33 = i43;
                        int i45 = iE34;
                        int i46 = cursorC.getInt(i45);
                        iE34 = i45;
                        iE35 = iE35;
                        String string12 = cursorC.isNull(iE35) ? null : cursorC.getString(iE35);
                        String string13 = cursorC.isNull(iE36) ? null : cursorC.getString(iE36);
                        long j15 = cursorC.getLong(iE37);
                        iE37 = iE37;
                        iE38 = iE38;
                        String string14 = cursorC.isNull(iE38) ? null : cursorC.getString(iE38);
                        String string15 = cursorC.isNull(iE39) ? null : cursorC.getString(iE39);
                        long j16 = cursorC.getLong(iE40);
                        iE40 = iE40;
                        int i47 = iE41;
                        int i48 = cursorC.getInt(i47);
                        iE41 = i47;
                        int i49 = iE42;
                        long j17 = cursorC.getLong(i49);
                        iE42 = i49;
                        iE43 = iE43;
                        String string16 = cursorC.isNull(iE43) ? null : cursorC.getString(iE43);
                        int i50 = cursorC.getInt(iE44);
                        iE44 = iE44;
                        iE45 = iE45;
                        String string17 = cursorC.isNull(iE45) ? null : cursorC.getString(iE45);
                        String string18 = cursorC.isNull(iE46) ? null : cursorC.getString(iE46);
                        boolean z11 = cursorC.getInt(iE47) != 0;
                        boolean z12 = cursorC.getInt(iE48) != 0;
                        int i51 = cursorC.getInt(iE49);
                        iE49 = iE49;
                        iE50 = iE50;
                        arrayList.add(new DownloadBean(string, string2, string3, string4, lValueOf, string5, string6, string7, lValueOf2, lValueOf3, j11, i12, i13, i15, j12, j13, i21, i23, i25, i27, i29, i32, i34, i36, i38, i40, i42, string8, string9, string10, string11, j14, i44, i46, string12, string13, j15, string14, string15, j16, i48, j17, string16, i50, string17, string18, z11, z12, i51, cursorC.isNull(iE50) ? null : cursorC.getString(iE50), cursorC.isNull(iE51) ? null : Integer.valueOf(cursorC.getInt(iE51)), cursorC.isNull(iE52) ? null : cursorC.getString(iE52), cursorC.isNull(iE53) ? null : cursorC.getString(iE53), cursorC.isNull(iE54) ? null : cursorC.getString(iE54), cursorC.isNull(iE55) ? null : cursorC.getString(iE55), cursorC.isNull(iE56) ? null : cursorC.getString(iE56), cursorC.isNull(iE57) ? null : cursorC.getString(iE57), cursorC.isNull(iE58) ? null : Integer.valueOf(cursorC.getInt(iE58)), cursorC.isNull(iE59) ? null : cursorC.getString(iE59), cursorC.isNull(iE60) ? null : cursorC.getString(iE60), cursorC.isNull(iE61) ? null : Long.valueOf(cursorC.getLong(iE61)), cursorC.isNull(iE62) ? null : Long.valueOf(cursorC.getLong(iE62))));
                        iE = i16;
                        i11 = i14;
                    }
                    cursorC.close();
                    this.f77294a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    c0Var = this;
                    cursorC.close();
                    c0Var.f77294a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                c0Var = this;
            }
        }
    }

    /* JADX INFO: renamed from: tr.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0856d extends SharedSQLiteStatement {
        public C0856d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM DOWNLOAD_TABLE WHERE url=?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d0 implements Callable<List<? extends DownloadBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.v f77297a;

        public d0(androidx.room.v vVar) {
            this.f77297a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<? extends DownloadBean> call() throws Exception {
            d0 d0Var;
            Cursor cursorC = e6.b.c(d.this.f77271a, this.f77297a, false, null);
            try {
                int iE = e6.a.e(cursorC, "url");
                int iE2 = e6.a.e(cursorC, "resourceId");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "cover");
                int iE5 = e6.a.e(cursorC, "size");
                int iE6 = e6.a.e(cursorC, "postId");
                int iE7 = e6.a.e(cursorC, "sizeFormat");
                int iE8 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE9 = e6.a.e(cursorC, "duration");
                int iE10 = e6.a.e(cursorC, "updateTimeStamp");
                int iE11 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE12 = e6.a.e(cursorC, "supportRanges");
                int iE13 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE14 = e6.a.e(cursorC, "type");
                try {
                    int iE15 = e6.a.e(cursorC, "readProgress");
                    int iE16 = e6.a.e(cursorC, "createAt");
                    int iE17 = e6.a.e(cursorC, "isRead");
                    int iE18 = e6.a.e(cursorC, "episode");
                    int iE19 = e6.a.e(cursorC, "ep");
                    int iE20 = e6.a.e(cursorC, "se");
                    int iE21 = e6.a.e(cursorC, "resolution");
                    int iE22 = e6.a.e(cursorC, "resourcePosition");
                    int iE23 = e6.a.e(cursorC, "multiresolution");
                    int iE24 = e6.a.e(cursorC, "videoWidth");
                    int iE25 = e6.a.e(cursorC, "videoHeight");
                    int iE26 = e6.a.e(cursorC, "downloadErrorCount");
                    int iE27 = e6.a.e(cursorC, "subtitleStarted");
                    int iE28 = e6.a.e(cursorC, "subjectId");
                    int iE29 = e6.a.e(cursorC, "pageFrom");
                    int iE30 = e6.a.e(cursorC, "lastPageFrom");
                    int iE31 = e6.a.e(cursorC, "subjectName");
                    int iE32 = e6.a.e(cursorC, "lastPlayTimeStamp");
                    int iE33 = e6.a.e(cursorC, "fileType");
                    int iE34 = e6.a.e(cursorC, "totalEpisode");
                    int iE35 = e6.a.e(cursorC, "uploadBy");
                    int iE36 = e6.a.e(cursorC, "sourceUrl");
                    int iE37 = e6.a.e(cursorC, "urlCreateAt");
                    int iE38 = e6.a.e(cursorC, "subtitleSelectId");
                    int iE39 = e6.a.e(cursorC, "taskId");
                    int iE40 = e6.a.e(cursorC, "sessionTime");
                    int iE41 = e6.a.e(cursorC, "reportStatus");
                    int iE42 = e6.a.e(cursorC, "downloadHeaderSize");
                    int iE43 = e6.a.e(cursorC, "rootPath");
                    int iE44 = e6.a.e(cursorC, "rootPathType");
                    int iE45 = e6.a.e(cursorC, "thumbnail");
                    int iE46 = e6.a.e(cursorC, "averageHueLight");
                    int iE47 = e6.a.e(cursorC, "isTransferFailed");
                    int iE48 = e6.a.e(cursorC, "isClosedTransferFailed");
                    int iE49 = e6.a.e(cursorC, "subjectType");
                    int iE50 = e6.a.e(cursorC, "genre");
                    int iE51 = e6.a.e(cursorC, "subjectDurationSeconds");
                    int iE52 = e6.a.e(cursorC, "currentDubLanName");
                    int iE53 = e6.a.e(cursorC, "currentDubLanCode");
                    int iE54 = e6.a.e(cursorC, "ops");
                    int iE55 = e6.a.e(cursorC, "restrictLevel");
                    int iE56 = e6.a.e(cursorC, "releaseDate");
                    int iE57 = e6.a.e(cursorC, "countryName");
                    int iE58 = e6.a.e(cursorC, "seNum");
                    int iE59 = e6.a.e(cursorC, "subtitles");
                    int iE60 = e6.a.e(cursorC, "imdbRate");
                    int iE61 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE62 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string3 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string4 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        Long lValueOf = cursorC.isNull(iE5) ? null : Long.valueOf(cursorC.getLong(iE5));
                        String string5 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string6 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string7 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        Long lValueOf2 = cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9));
                        Long lValueOf3 = cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10));
                        long j11 = cursorC.getLong(iE11);
                        int i12 = cursorC.getInt(iE12);
                        int i13 = cursorC.getInt(iE13);
                        int i14 = i11;
                        int i15 = cursorC.getInt(i14);
                        int i16 = iE;
                        int i17 = iE15;
                        long j12 = cursorC.getLong(i17);
                        iE15 = i17;
                        int i18 = iE16;
                        long j13 = cursorC.getLong(i18);
                        iE16 = i18;
                        int i19 = iE17;
                        int i21 = cursorC.getInt(i19);
                        iE17 = i19;
                        int i22 = iE18;
                        int i23 = cursorC.getInt(i22);
                        iE18 = i22;
                        int i24 = iE19;
                        int i25 = cursorC.getInt(i24);
                        iE19 = i24;
                        int i26 = iE20;
                        int i27 = cursorC.getInt(i26);
                        iE20 = i26;
                        int i28 = iE21;
                        int i29 = cursorC.getInt(i28);
                        iE21 = i28;
                        int i31 = iE22;
                        int i32 = cursorC.getInt(i31);
                        iE22 = i31;
                        int i33 = iE23;
                        int i34 = cursorC.getInt(i33);
                        iE23 = i33;
                        int i35 = iE24;
                        int i36 = cursorC.getInt(i35);
                        iE24 = i35;
                        int i37 = iE25;
                        int i38 = cursorC.getInt(i37);
                        iE25 = i37;
                        int i39 = iE26;
                        int i40 = cursorC.getInt(i39);
                        iE26 = i39;
                        int i41 = iE27;
                        int i42 = cursorC.getInt(i41);
                        iE27 = i41;
                        iE28 = iE28;
                        String string8 = cursorC.isNull(iE28) ? null : cursorC.getString(iE28);
                        String string9 = cursorC.isNull(iE29) ? null : cursorC.getString(iE29);
                        String string10 = cursorC.isNull(iE30) ? null : cursorC.getString(iE30);
                        String string11 = cursorC.isNull(iE31) ? null : cursorC.getString(iE31);
                        long j14 = cursorC.getLong(iE32);
                        iE32 = iE32;
                        int i43 = iE33;
                        int i44 = cursorC.getInt(i43);
                        iE33 = i43;
                        int i45 = iE34;
                        int i46 = cursorC.getInt(i45);
                        iE34 = i45;
                        iE35 = iE35;
                        String string12 = cursorC.isNull(iE35) ? null : cursorC.getString(iE35);
                        String string13 = cursorC.isNull(iE36) ? null : cursorC.getString(iE36);
                        long j15 = cursorC.getLong(iE37);
                        iE37 = iE37;
                        iE38 = iE38;
                        String string14 = cursorC.isNull(iE38) ? null : cursorC.getString(iE38);
                        String string15 = cursorC.isNull(iE39) ? null : cursorC.getString(iE39);
                        long j16 = cursorC.getLong(iE40);
                        iE40 = iE40;
                        int i47 = iE41;
                        int i48 = cursorC.getInt(i47);
                        iE41 = i47;
                        int i49 = iE42;
                        long j17 = cursorC.getLong(i49);
                        iE42 = i49;
                        iE43 = iE43;
                        String string16 = cursorC.isNull(iE43) ? null : cursorC.getString(iE43);
                        int i50 = cursorC.getInt(iE44);
                        iE44 = iE44;
                        iE45 = iE45;
                        String string17 = cursorC.isNull(iE45) ? null : cursorC.getString(iE45);
                        String string18 = cursorC.isNull(iE46) ? null : cursorC.getString(iE46);
                        boolean z11 = cursorC.getInt(iE47) != 0;
                        boolean z12 = cursorC.getInt(iE48) != 0;
                        int i51 = cursorC.getInt(iE49);
                        iE49 = iE49;
                        iE50 = iE50;
                        arrayList.add(new DownloadBean(string, string2, string3, string4, lValueOf, string5, string6, string7, lValueOf2, lValueOf3, j11, i12, i13, i15, j12, j13, i21, i23, i25, i27, i29, i32, i34, i36, i38, i40, i42, string8, string9, string10, string11, j14, i44, i46, string12, string13, j15, string14, string15, j16, i48, j17, string16, i50, string17, string18, z11, z12, i51, cursorC.isNull(iE50) ? null : cursorC.getString(iE50), cursorC.isNull(iE51) ? null : Integer.valueOf(cursorC.getInt(iE51)), cursorC.isNull(iE52) ? null : cursorC.getString(iE52), cursorC.isNull(iE53) ? null : cursorC.getString(iE53), cursorC.isNull(iE54) ? null : cursorC.getString(iE54), cursorC.isNull(iE55) ? null : cursorC.getString(iE55), cursorC.isNull(iE56) ? null : cursorC.getString(iE56), cursorC.isNull(iE57) ? null : cursorC.getString(iE57), cursorC.isNull(iE58) ? null : Integer.valueOf(cursorC.getInt(iE58)), cursorC.isNull(iE59) ? null : cursorC.getString(iE59), cursorC.isNull(iE60) ? null : cursorC.getString(iE60), cursorC.isNull(iE61) ? null : Long.valueOf(cursorC.getLong(iE61)), cursorC.isNull(iE62) ? null : Long.valueOf(cursorC.getLong(iE62))));
                        iE = i16;
                        i11 = i14;
                    }
                    cursorC.close();
                    this.f77297a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    d0Var = this;
                    cursorC.close();
                    d0Var.f77297a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                d0Var = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends SharedSQLiteStatement {
        public e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM DOWNLOAD_TABLE WHERE resourceId=? AND fileType =  3 ";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e0 implements Callable<DownloadBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.v f77300a;

        public e0(androidx.room.v vVar) {
            this.f77300a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadBean call() throws Exception {
            DownloadBean downloadBean;
            e0 e0Var = this;
            Cursor cursorC = e6.b.c(d.this.f77271a, e0Var.f77300a, false, null);
            try {
                int iE = e6.a.e(cursorC, "url");
                int iE2 = e6.a.e(cursorC, "resourceId");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "cover");
                int iE5 = e6.a.e(cursorC, "size");
                int iE6 = e6.a.e(cursorC, "postId");
                int iE7 = e6.a.e(cursorC, "sizeFormat");
                int iE8 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE9 = e6.a.e(cursorC, "duration");
                int iE10 = e6.a.e(cursorC, "updateTimeStamp");
                int iE11 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE12 = e6.a.e(cursorC, "supportRanges");
                int iE13 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE14 = e6.a.e(cursorC, "type");
                try {
                    int iE15 = e6.a.e(cursorC, "readProgress");
                    int iE16 = e6.a.e(cursorC, "createAt");
                    int iE17 = e6.a.e(cursorC, "isRead");
                    int iE18 = e6.a.e(cursorC, "episode");
                    int iE19 = e6.a.e(cursorC, "ep");
                    int iE20 = e6.a.e(cursorC, "se");
                    int iE21 = e6.a.e(cursorC, "resolution");
                    int iE22 = e6.a.e(cursorC, "resourcePosition");
                    int iE23 = e6.a.e(cursorC, "multiresolution");
                    int iE24 = e6.a.e(cursorC, "videoWidth");
                    int iE25 = e6.a.e(cursorC, "videoHeight");
                    int iE26 = e6.a.e(cursorC, "downloadErrorCount");
                    int iE27 = e6.a.e(cursorC, "subtitleStarted");
                    int iE28 = e6.a.e(cursorC, "subjectId");
                    int iE29 = e6.a.e(cursorC, "pageFrom");
                    int iE30 = e6.a.e(cursorC, "lastPageFrom");
                    int iE31 = e6.a.e(cursorC, "subjectName");
                    int iE32 = e6.a.e(cursorC, "lastPlayTimeStamp");
                    int iE33 = e6.a.e(cursorC, "fileType");
                    int iE34 = e6.a.e(cursorC, "totalEpisode");
                    int iE35 = e6.a.e(cursorC, "uploadBy");
                    int iE36 = e6.a.e(cursorC, "sourceUrl");
                    int iE37 = e6.a.e(cursorC, "urlCreateAt");
                    int iE38 = e6.a.e(cursorC, "subtitleSelectId");
                    int iE39 = e6.a.e(cursorC, "taskId");
                    int iE40 = e6.a.e(cursorC, "sessionTime");
                    int iE41 = e6.a.e(cursorC, "reportStatus");
                    int iE42 = e6.a.e(cursorC, "downloadHeaderSize");
                    int iE43 = e6.a.e(cursorC, "rootPath");
                    int iE44 = e6.a.e(cursorC, "rootPathType");
                    int iE45 = e6.a.e(cursorC, "thumbnail");
                    int iE46 = e6.a.e(cursorC, "averageHueLight");
                    int iE47 = e6.a.e(cursorC, "isTransferFailed");
                    int iE48 = e6.a.e(cursorC, "isClosedTransferFailed");
                    int iE49 = e6.a.e(cursorC, "subjectType");
                    int iE50 = e6.a.e(cursorC, "genre");
                    int iE51 = e6.a.e(cursorC, "subjectDurationSeconds");
                    int iE52 = e6.a.e(cursorC, "currentDubLanName");
                    int iE53 = e6.a.e(cursorC, "currentDubLanCode");
                    int iE54 = e6.a.e(cursorC, "ops");
                    int iE55 = e6.a.e(cursorC, "restrictLevel");
                    int iE56 = e6.a.e(cursorC, "releaseDate");
                    int iE57 = e6.a.e(cursorC, "countryName");
                    int iE58 = e6.a.e(cursorC, "seNum");
                    int iE59 = e6.a.e(cursorC, "subtitles");
                    int iE60 = e6.a.e(cursorC, "imdbRate");
                    int iE61 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE62 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    if (cursorC.moveToFirst()) {
                        downloadBean = new DownloadBean(cursorC.isNull(iE) ? null : cursorC.getString(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : Long.valueOf(cursorC.getLong(iE5)), cursorC.isNull(iE6) ? null : cursorC.getString(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : cursorC.getString(iE8), cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9)), cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10)), cursorC.getLong(iE11), cursorC.getInt(iE12), cursorC.getInt(iE13), cursorC.getInt(iE14), cursorC.getLong(iE15), cursorC.getLong(iE16), cursorC.getInt(iE17), cursorC.getInt(iE18), cursorC.getInt(iE19), cursorC.getInt(iE20), cursorC.getInt(iE21), cursorC.getInt(iE22), cursorC.getInt(iE23), cursorC.getInt(iE24), cursorC.getInt(iE25), cursorC.getInt(iE26), cursorC.getInt(iE27), cursorC.isNull(iE28) ? null : cursorC.getString(iE28), cursorC.isNull(r30) ? null : cursorC.getString(iE29), cursorC.isNull(r31) ? null : cursorC.getString(iE30), cursorC.isNull(r32) ? null : cursorC.getString(iE31), cursorC.getLong(iE32), cursorC.getInt(iE33), cursorC.getInt(iE34), cursorC.isNull(iE35) ? null : cursorC.getString(iE35), cursorC.isNull(r37) ? null : cursorC.getString(iE36), cursorC.getLong(iE37), cursorC.isNull(iE38) ? null : cursorC.getString(iE38), cursorC.isNull(r40) ? null : cursorC.getString(iE39), cursorC.getLong(iE40), cursorC.getInt(iE41), cursorC.getLong(iE42), cursorC.isNull(iE43) ? null : cursorC.getString(iE43), cursorC.getInt(iE44), cursorC.isNull(iE45) ? null : cursorC.getString(iE45), cursorC.isNull(r47) ? null : cursorC.getString(iE46), cursorC.getInt(iE47) != 0, cursorC.getInt(iE48) != 0, cursorC.getInt(iE49), cursorC.isNull(iE50) ? null : cursorC.getString(iE50), cursorC.isNull(r52) ? null : Integer.valueOf(cursorC.getInt(iE51)), cursorC.isNull(r53) ? null : cursorC.getString(iE52), cursorC.isNull(r54) ? null : cursorC.getString(iE53), cursorC.isNull(r55) ? null : cursorC.getString(iE54), cursorC.isNull(r56) ? null : cursorC.getString(iE55), cursorC.isNull(r57) ? null : cursorC.getString(iE56), cursorC.isNull(r58) ? null : cursorC.getString(iE57), cursorC.isNull(r59) ? null : Integer.valueOf(cursorC.getInt(iE58)), cursorC.isNull(r60) ? null : cursorC.getString(iE59), cursorC.isNull(r61) ? null : cursorC.getString(iE60), cursorC.isNull(r62) ? null : Long.valueOf(cursorC.getLong(iE61)), cursorC.isNull(iE62) ? null : Long.valueOf(cursorC.getLong(iE62)));
                    } else {
                        downloadBean = null;
                    }
                    cursorC.close();
                    this.f77300a.release();
                    return downloadBean;
                } catch (Throwable th2) {
                    th = th2;
                    e0Var = this;
                    cursorC.close();
                    e0Var.f77300a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
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
            return "UPDATE DOWNLOAD_TABLE SET restrictLevel = ?, releaseDate = ?, countryName = ?, subtitles = ?, seNum = ?, genre = ?, imdbRate = ? WHERE resourceId = ?";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f0 extends SharedSQLiteStatement {
        public f0(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE DOWNLOAD_TABLE SET status = ? WHERE resourceId = ? ";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadBean f77304a;

        public g(DownloadBean downloadBean) {
            this.f77304a = downloadBean;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            d.this.f77271a.e();
            try {
                d.this.f77272b.k(this.f77304a);
                d.this.f77271a.E();
                return Unit.f68710a;
            } finally {
                d.this.f77271a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g0 implements Callable<DownloadBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.v f77306a;

        public g0(androidx.room.v vVar) {
            this.f77306a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadBean call() throws Exception {
            DownloadBean downloadBean;
            g0 g0Var = this;
            Cursor cursorC = e6.b.c(d.this.f77271a, g0Var.f77306a, false, null);
            try {
                int iE = e6.a.e(cursorC, "url");
                int iE2 = e6.a.e(cursorC, "resourceId");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "cover");
                int iE5 = e6.a.e(cursorC, "size");
                int iE6 = e6.a.e(cursorC, "postId");
                int iE7 = e6.a.e(cursorC, "sizeFormat");
                int iE8 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE9 = e6.a.e(cursorC, "duration");
                int iE10 = e6.a.e(cursorC, "updateTimeStamp");
                int iE11 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE12 = e6.a.e(cursorC, "supportRanges");
                int iE13 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE14 = e6.a.e(cursorC, "type");
                try {
                    int iE15 = e6.a.e(cursorC, "readProgress");
                    int iE16 = e6.a.e(cursorC, "createAt");
                    int iE17 = e6.a.e(cursorC, "isRead");
                    int iE18 = e6.a.e(cursorC, "episode");
                    int iE19 = e6.a.e(cursorC, "ep");
                    int iE20 = e6.a.e(cursorC, "se");
                    int iE21 = e6.a.e(cursorC, "resolution");
                    int iE22 = e6.a.e(cursorC, "resourcePosition");
                    int iE23 = e6.a.e(cursorC, "multiresolution");
                    int iE24 = e6.a.e(cursorC, "videoWidth");
                    int iE25 = e6.a.e(cursorC, "videoHeight");
                    int iE26 = e6.a.e(cursorC, "downloadErrorCount");
                    int iE27 = e6.a.e(cursorC, "subtitleStarted");
                    int iE28 = e6.a.e(cursorC, "subjectId");
                    int iE29 = e6.a.e(cursorC, "pageFrom");
                    int iE30 = e6.a.e(cursorC, "lastPageFrom");
                    int iE31 = e6.a.e(cursorC, "subjectName");
                    int iE32 = e6.a.e(cursorC, "lastPlayTimeStamp");
                    int iE33 = e6.a.e(cursorC, "fileType");
                    int iE34 = e6.a.e(cursorC, "totalEpisode");
                    int iE35 = e6.a.e(cursorC, "uploadBy");
                    int iE36 = e6.a.e(cursorC, "sourceUrl");
                    int iE37 = e6.a.e(cursorC, "urlCreateAt");
                    int iE38 = e6.a.e(cursorC, "subtitleSelectId");
                    int iE39 = e6.a.e(cursorC, "taskId");
                    int iE40 = e6.a.e(cursorC, "sessionTime");
                    int iE41 = e6.a.e(cursorC, "reportStatus");
                    int iE42 = e6.a.e(cursorC, "downloadHeaderSize");
                    int iE43 = e6.a.e(cursorC, "rootPath");
                    int iE44 = e6.a.e(cursorC, "rootPathType");
                    int iE45 = e6.a.e(cursorC, "thumbnail");
                    int iE46 = e6.a.e(cursorC, "averageHueLight");
                    int iE47 = e6.a.e(cursorC, "isTransferFailed");
                    int iE48 = e6.a.e(cursorC, "isClosedTransferFailed");
                    int iE49 = e6.a.e(cursorC, "subjectType");
                    int iE50 = e6.a.e(cursorC, "genre");
                    int iE51 = e6.a.e(cursorC, "subjectDurationSeconds");
                    int iE52 = e6.a.e(cursorC, "currentDubLanName");
                    int iE53 = e6.a.e(cursorC, "currentDubLanCode");
                    int iE54 = e6.a.e(cursorC, "ops");
                    int iE55 = e6.a.e(cursorC, "restrictLevel");
                    int iE56 = e6.a.e(cursorC, "releaseDate");
                    int iE57 = e6.a.e(cursorC, "countryName");
                    int iE58 = e6.a.e(cursorC, "seNum");
                    int iE59 = e6.a.e(cursorC, "subtitles");
                    int iE60 = e6.a.e(cursorC, "imdbRate");
                    int iE61 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE62 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    if (cursorC.moveToFirst()) {
                        downloadBean = new DownloadBean(cursorC.isNull(iE) ? null : cursorC.getString(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : Long.valueOf(cursorC.getLong(iE5)), cursorC.isNull(iE6) ? null : cursorC.getString(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : cursorC.getString(iE8), cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9)), cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10)), cursorC.getLong(iE11), cursorC.getInt(iE12), cursorC.getInt(iE13), cursorC.getInt(iE14), cursorC.getLong(iE15), cursorC.getLong(iE16), cursorC.getInt(iE17), cursorC.getInt(iE18), cursorC.getInt(iE19), cursorC.getInt(iE20), cursorC.getInt(iE21), cursorC.getInt(iE22), cursorC.getInt(iE23), cursorC.getInt(iE24), cursorC.getInt(iE25), cursorC.getInt(iE26), cursorC.getInt(iE27), cursorC.isNull(iE28) ? null : cursorC.getString(iE28), cursorC.isNull(r30) ? null : cursorC.getString(iE29), cursorC.isNull(r31) ? null : cursorC.getString(iE30), cursorC.isNull(r32) ? null : cursorC.getString(iE31), cursorC.getLong(iE32), cursorC.getInt(iE33), cursorC.getInt(iE34), cursorC.isNull(iE35) ? null : cursorC.getString(iE35), cursorC.isNull(r37) ? null : cursorC.getString(iE36), cursorC.getLong(iE37), cursorC.isNull(iE38) ? null : cursorC.getString(iE38), cursorC.isNull(r40) ? null : cursorC.getString(iE39), cursorC.getLong(iE40), cursorC.getInt(iE41), cursorC.getLong(iE42), cursorC.isNull(iE43) ? null : cursorC.getString(iE43), cursorC.getInt(iE44), cursorC.isNull(iE45) ? null : cursorC.getString(iE45), cursorC.isNull(r47) ? null : cursorC.getString(iE46), cursorC.getInt(iE47) != 0, cursorC.getInt(iE48) != 0, cursorC.getInt(iE49), cursorC.isNull(iE50) ? null : cursorC.getString(iE50), cursorC.isNull(r52) ? null : Integer.valueOf(cursorC.getInt(iE51)), cursorC.isNull(r53) ? null : cursorC.getString(iE52), cursorC.isNull(r54) ? null : cursorC.getString(iE53), cursorC.isNull(r55) ? null : cursorC.getString(iE54), cursorC.isNull(r56) ? null : cursorC.getString(iE55), cursorC.isNull(r57) ? null : cursorC.getString(iE56), cursorC.isNull(r58) ? null : cursorC.getString(iE57), cursorC.isNull(r59) ? null : Integer.valueOf(cursorC.getInt(iE58)), cursorC.isNull(r60) ? null : cursorC.getString(iE59), cursorC.isNull(r61) ? null : cursorC.getString(iE60), cursorC.isNull(r62) ? null : Long.valueOf(cursorC.getLong(iE61)), cursorC.isNull(iE62) ? null : Long.valueOf(cursorC.getLong(iE62)));
                    } else {
                        downloadBean = null;
                    }
                    cursorC.close();
                    this.f77306a.release();
                    return downloadBean;
                } catch (Throwable th2) {
                    th = th2;
                    g0Var = this;
                    cursorC.close();
                    g0Var.f77306a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadBean f77308a;

        public h(DownloadBean downloadBean) {
            this.f77308a = downloadBean;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            d.this.f77271a.e();
            try {
                d.this.f77274d.j(this.f77308a);
                d.this.f77271a.E();
                return Unit.f68710a;
            } finally {
                d.this.f77271a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h0 implements Callable<List<? extends DownloadBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.v f77310a;

        public h0(androidx.room.v vVar) {
            this.f77310a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<? extends DownloadBean> call() throws Exception {
            h0 h0Var;
            Cursor cursorC = e6.b.c(d.this.f77271a, this.f77310a, false, null);
            try {
                int iE = e6.a.e(cursorC, "url");
                int iE2 = e6.a.e(cursorC, "resourceId");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "cover");
                int iE5 = e6.a.e(cursorC, "size");
                int iE6 = e6.a.e(cursorC, "postId");
                int iE7 = e6.a.e(cursorC, "sizeFormat");
                int iE8 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE9 = e6.a.e(cursorC, "duration");
                int iE10 = e6.a.e(cursorC, "updateTimeStamp");
                int iE11 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE12 = e6.a.e(cursorC, "supportRanges");
                int iE13 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE14 = e6.a.e(cursorC, "type");
                try {
                    int iE15 = e6.a.e(cursorC, "readProgress");
                    int iE16 = e6.a.e(cursorC, "createAt");
                    int iE17 = e6.a.e(cursorC, "isRead");
                    int iE18 = e6.a.e(cursorC, "episode");
                    int iE19 = e6.a.e(cursorC, "ep");
                    int iE20 = e6.a.e(cursorC, "se");
                    int iE21 = e6.a.e(cursorC, "resolution");
                    int iE22 = e6.a.e(cursorC, "resourcePosition");
                    int iE23 = e6.a.e(cursorC, "multiresolution");
                    int iE24 = e6.a.e(cursorC, "videoWidth");
                    int iE25 = e6.a.e(cursorC, "videoHeight");
                    int iE26 = e6.a.e(cursorC, "downloadErrorCount");
                    int iE27 = e6.a.e(cursorC, "subtitleStarted");
                    int iE28 = e6.a.e(cursorC, "subjectId");
                    int iE29 = e6.a.e(cursorC, "pageFrom");
                    int iE30 = e6.a.e(cursorC, "lastPageFrom");
                    int iE31 = e6.a.e(cursorC, "subjectName");
                    int iE32 = e6.a.e(cursorC, "lastPlayTimeStamp");
                    int iE33 = e6.a.e(cursorC, "fileType");
                    int iE34 = e6.a.e(cursorC, "totalEpisode");
                    int iE35 = e6.a.e(cursorC, "uploadBy");
                    int iE36 = e6.a.e(cursorC, "sourceUrl");
                    int iE37 = e6.a.e(cursorC, "urlCreateAt");
                    int iE38 = e6.a.e(cursorC, "subtitleSelectId");
                    int iE39 = e6.a.e(cursorC, "taskId");
                    int iE40 = e6.a.e(cursorC, "sessionTime");
                    int iE41 = e6.a.e(cursorC, "reportStatus");
                    int iE42 = e6.a.e(cursorC, "downloadHeaderSize");
                    int iE43 = e6.a.e(cursorC, "rootPath");
                    int iE44 = e6.a.e(cursorC, "rootPathType");
                    int iE45 = e6.a.e(cursorC, "thumbnail");
                    int iE46 = e6.a.e(cursorC, "averageHueLight");
                    int iE47 = e6.a.e(cursorC, "isTransferFailed");
                    int iE48 = e6.a.e(cursorC, "isClosedTransferFailed");
                    int iE49 = e6.a.e(cursorC, "subjectType");
                    int iE50 = e6.a.e(cursorC, "genre");
                    int iE51 = e6.a.e(cursorC, "subjectDurationSeconds");
                    int iE52 = e6.a.e(cursorC, "currentDubLanName");
                    int iE53 = e6.a.e(cursorC, "currentDubLanCode");
                    int iE54 = e6.a.e(cursorC, "ops");
                    int iE55 = e6.a.e(cursorC, "restrictLevel");
                    int iE56 = e6.a.e(cursorC, "releaseDate");
                    int iE57 = e6.a.e(cursorC, "countryName");
                    int iE58 = e6.a.e(cursorC, "seNum");
                    int iE59 = e6.a.e(cursorC, "subtitles");
                    int iE60 = e6.a.e(cursorC, "imdbRate");
                    int iE61 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE62 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string3 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string4 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        Long lValueOf = cursorC.isNull(iE5) ? null : Long.valueOf(cursorC.getLong(iE5));
                        String string5 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string6 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string7 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        Long lValueOf2 = cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9));
                        Long lValueOf3 = cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10));
                        long j11 = cursorC.getLong(iE11);
                        int i12 = cursorC.getInt(iE12);
                        int i13 = cursorC.getInt(iE13);
                        int i14 = i11;
                        int i15 = cursorC.getInt(i14);
                        int i16 = iE;
                        int i17 = iE15;
                        long j12 = cursorC.getLong(i17);
                        iE15 = i17;
                        int i18 = iE16;
                        long j13 = cursorC.getLong(i18);
                        iE16 = i18;
                        int i19 = iE17;
                        int i21 = cursorC.getInt(i19);
                        iE17 = i19;
                        int i22 = iE18;
                        int i23 = cursorC.getInt(i22);
                        iE18 = i22;
                        int i24 = iE19;
                        int i25 = cursorC.getInt(i24);
                        iE19 = i24;
                        int i26 = iE20;
                        int i27 = cursorC.getInt(i26);
                        iE20 = i26;
                        int i28 = iE21;
                        int i29 = cursorC.getInt(i28);
                        iE21 = i28;
                        int i31 = iE22;
                        int i32 = cursorC.getInt(i31);
                        iE22 = i31;
                        int i33 = iE23;
                        int i34 = cursorC.getInt(i33);
                        iE23 = i33;
                        int i35 = iE24;
                        int i36 = cursorC.getInt(i35);
                        iE24 = i35;
                        int i37 = iE25;
                        int i38 = cursorC.getInt(i37);
                        iE25 = i37;
                        int i39 = iE26;
                        int i40 = cursorC.getInt(i39);
                        iE26 = i39;
                        int i41 = iE27;
                        int i42 = cursorC.getInt(i41);
                        iE27 = i41;
                        iE28 = iE28;
                        String string8 = cursorC.isNull(iE28) ? null : cursorC.getString(iE28);
                        String string9 = cursorC.isNull(iE29) ? null : cursorC.getString(iE29);
                        String string10 = cursorC.isNull(iE30) ? null : cursorC.getString(iE30);
                        String string11 = cursorC.isNull(iE31) ? null : cursorC.getString(iE31);
                        long j14 = cursorC.getLong(iE32);
                        iE32 = iE32;
                        int i43 = iE33;
                        int i44 = cursorC.getInt(i43);
                        iE33 = i43;
                        int i45 = iE34;
                        int i46 = cursorC.getInt(i45);
                        iE34 = i45;
                        iE35 = iE35;
                        String string12 = cursorC.isNull(iE35) ? null : cursorC.getString(iE35);
                        String string13 = cursorC.isNull(iE36) ? null : cursorC.getString(iE36);
                        long j15 = cursorC.getLong(iE37);
                        iE37 = iE37;
                        iE38 = iE38;
                        String string14 = cursorC.isNull(iE38) ? null : cursorC.getString(iE38);
                        String string15 = cursorC.isNull(iE39) ? null : cursorC.getString(iE39);
                        long j16 = cursorC.getLong(iE40);
                        iE40 = iE40;
                        int i47 = iE41;
                        int i48 = cursorC.getInt(i47);
                        iE41 = i47;
                        int i49 = iE42;
                        long j17 = cursorC.getLong(i49);
                        iE42 = i49;
                        iE43 = iE43;
                        String string16 = cursorC.isNull(iE43) ? null : cursorC.getString(iE43);
                        int i50 = cursorC.getInt(iE44);
                        iE44 = iE44;
                        iE45 = iE45;
                        String string17 = cursorC.isNull(iE45) ? null : cursorC.getString(iE45);
                        String string18 = cursorC.isNull(iE46) ? null : cursorC.getString(iE46);
                        boolean z11 = cursorC.getInt(iE47) != 0;
                        boolean z12 = cursorC.getInt(iE48) != 0;
                        int i51 = cursorC.getInt(iE49);
                        iE49 = iE49;
                        iE50 = iE50;
                        arrayList.add(new DownloadBean(string, string2, string3, string4, lValueOf, string5, string6, string7, lValueOf2, lValueOf3, j11, i12, i13, i15, j12, j13, i21, i23, i25, i27, i29, i32, i34, i36, i38, i40, i42, string8, string9, string10, string11, j14, i44, i46, string12, string13, j15, string14, string15, j16, i48, j17, string16, i50, string17, string18, z11, z12, i51, cursorC.isNull(iE50) ? null : cursorC.getString(iE50), cursorC.isNull(iE51) ? null : Integer.valueOf(cursorC.getInt(iE51)), cursorC.isNull(iE52) ? null : cursorC.getString(iE52), cursorC.isNull(iE53) ? null : cursorC.getString(iE53), cursorC.isNull(iE54) ? null : cursorC.getString(iE54), cursorC.isNull(iE55) ? null : cursorC.getString(iE55), cursorC.isNull(iE56) ? null : cursorC.getString(iE56), cursorC.isNull(iE57) ? null : cursorC.getString(iE57), cursorC.isNull(iE58) ? null : Integer.valueOf(cursorC.getInt(iE58)), cursorC.isNull(iE59) ? null : cursorC.getString(iE59), cursorC.isNull(iE60) ? null : cursorC.getString(iE60), cursorC.isNull(iE61) ? null : Long.valueOf(cursorC.getLong(iE61)), cursorC.isNull(iE62) ? null : Long.valueOf(cursorC.getLong(iE62))));
                        iE = i16;
                        i11 = i14;
                    }
                    cursorC.close();
                    this.f77310a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    h0Var = this;
                    cursorC.close();
                    h0Var.f77310a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                h0Var = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i extends androidx.room.i<DownloadBean> {
        public i(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `download_table` (`url`,`resourceId`,`name`,`cover`,`size`,`postId`,`sizeFormat`,`path`,`duration`,`updateTimeStamp`,`progress`,`supportRanges`,`status`,`type`,`readProgress`,`createAt`,`isRead`,`episode`,`ep`,`se`,`resolution`,`resourcePosition`,`multiresolution`,`videoWidth`,`videoHeight`,`downloadErrorCount`,`subtitleStarted`,`subjectId`,`pageFrom`,`lastPageFrom`,`subjectName`,`lastPlayTimeStamp`,`fileType`,`totalEpisode`,`uploadBy`,`sourceUrl`,`urlCreateAt`,`subtitleSelectId`,`taskId`,`sessionTime`,`reportStatus`,`downloadHeaderSize`,`rootPath`,`rootPathType`,`thumbnail`,`averageHueLight`,`isTransferFailed`,`isClosedTransferFailed`,`subjectType`,`genre`,`subjectDurationSeconds`,`currentDubLanName`,`currentDubLanCode`,`ops`,`restrictLevel`,`releaseDate`,`countryName`,`seNum`,`subtitles`,`imdbRate`,`lastAdStartTimeStamp`,`lastAdEndTimeStamp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, DownloadBean downloadBean) {
            if (downloadBean.getUrl() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, downloadBean.getUrl());
            }
            if (downloadBean.getResourceId() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, downloadBean.getResourceId());
            }
            if (downloadBean.getName() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, downloadBean.getName());
            }
            if (downloadBean.getCover() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, downloadBean.getCover());
            }
            if (downloadBean.getSize() == null) {
                kVar.m0(5);
            } else {
                kVar.V(5, downloadBean.getSize().longValue());
            }
            if (downloadBean.getPostId() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, downloadBean.getPostId());
            }
            if (downloadBean.getSizeFormat() == null) {
                kVar.m0(7);
            } else {
                kVar.s(7, downloadBean.getSizeFormat());
            }
            if (downloadBean.getPath() == null) {
                kVar.m0(8);
            } else {
                kVar.s(8, downloadBean.getPath());
            }
            if (downloadBean.getDuration() == null) {
                kVar.m0(9);
            } else {
                kVar.V(9, downloadBean.getDuration().longValue());
            }
            if (downloadBean.getUpdateTimeStamp() == null) {
                kVar.m0(10);
            } else {
                kVar.V(10, downloadBean.getUpdateTimeStamp().longValue());
            }
            kVar.V(11, downloadBean.getProgress());
            kVar.V(12, downloadBean.getSupportRanges());
            kVar.V(13, downloadBean.getStatus());
            kVar.V(14, downloadBean.getType());
            kVar.V(15, downloadBean.getReadProgress());
            kVar.V(16, downloadBean.getCreateAt());
            kVar.V(17, downloadBean.isRead());
            kVar.V(18, downloadBean.getEpse());
            kVar.V(19, downloadBean.getEp());
            kVar.V(20, downloadBean.getSe());
            kVar.V(21, downloadBean.getResolution());
            kVar.V(22, downloadBean.getResourcePosition());
            kVar.V(23, downloadBean.getMultiresolution());
            kVar.V(24, downloadBean.getVideoWidth());
            kVar.V(25, downloadBean.getVideoHeight());
            kVar.V(26, downloadBean.getDownloadErrorCount());
            kVar.V(27, downloadBean.getSubtitleStarted());
            if (downloadBean.getSubjectId() == null) {
                kVar.m0(28);
            } else {
                kVar.s(28, downloadBean.getSubjectId());
            }
            if (downloadBean.getPageFrom() == null) {
                kVar.m0(29);
            } else {
                kVar.s(29, downloadBean.getPageFrom());
            }
            if (downloadBean.getLastPageFrom() == null) {
                kVar.m0(30);
            } else {
                kVar.s(30, downloadBean.getLastPageFrom());
            }
            if (downloadBean.getSubjectName() == null) {
                kVar.m0(31);
            } else {
                kVar.s(31, downloadBean.getSubjectName());
            }
            kVar.V(32, downloadBean.getLastPlayTimeStamp());
            kVar.V(33, downloadBean.getFileType());
            kVar.V(34, downloadBean.getTotalEpisode());
            if (downloadBean.getUploadBy() == null) {
                kVar.m0(35);
            } else {
                kVar.s(35, downloadBean.getUploadBy());
            }
            if (downloadBean.getSourceUrl() == null) {
                kVar.m0(36);
            } else {
                kVar.s(36, downloadBean.getSourceUrl());
            }
            kVar.V(37, downloadBean.getUrlCreateAt());
            if (downloadBean.getSubtitleSelectId() == null) {
                kVar.m0(38);
            } else {
                kVar.s(38, downloadBean.getSubtitleSelectId());
            }
            if (downloadBean.getTaskId() == null) {
                kVar.m0(39);
            } else {
                kVar.s(39, downloadBean.getTaskId());
            }
            kVar.V(40, downloadBean.getSessionTime());
            kVar.V(41, downloadBean.getReportStatus());
            kVar.V(42, downloadBean.getDownloadHeaderSize());
            if (downloadBean.getRootPath() == null) {
                kVar.m0(43);
            } else {
                kVar.s(43, downloadBean.getRootPath());
            }
            kVar.V(44, downloadBean.getRootPathType());
            if (downloadBean.getThumbnail() == null) {
                kVar.m0(45);
            } else {
                kVar.s(45, downloadBean.getThumbnail());
            }
            if (downloadBean.getAverageHueLight() == null) {
                kVar.m0(46);
            } else {
                kVar.s(46, downloadBean.getAverageHueLight());
            }
            kVar.V(47, downloadBean.isTransferFailed() ? 1L : 0L);
            kVar.V(48, downloadBean.isClosedTransferFailed() ? 1L : 0L);
            kVar.V(49, downloadBean.getSubjectType());
            if (downloadBean.getGenre() == null) {
                kVar.m0(50);
            } else {
                kVar.s(50, downloadBean.getGenre());
            }
            if (downloadBean.getSubjectDurationSeconds() == null) {
                kVar.m0(51);
            } else {
                kVar.V(51, downloadBean.getSubjectDurationSeconds().intValue());
            }
            if (downloadBean.getCurrentDubLanName() == null) {
                kVar.m0(52);
            } else {
                kVar.s(52, downloadBean.getCurrentDubLanName());
            }
            if (downloadBean.getCurrentDubLanCode() == null) {
                kVar.m0(53);
            } else {
                kVar.s(53, downloadBean.getCurrentDubLanCode());
            }
            if (downloadBean.getOps() == null) {
                kVar.m0(54);
            } else {
                kVar.s(54, downloadBean.getOps());
            }
            if (downloadBean.getRestrictLevel() == null) {
                kVar.m0(55);
            } else {
                kVar.s(55, downloadBean.getRestrictLevel());
            }
            if (downloadBean.getReleaseDate() == null) {
                kVar.m0(56);
            } else {
                kVar.s(56, downloadBean.getReleaseDate());
            }
            if (downloadBean.getCountryName() == null) {
                kVar.m0(57);
            } else {
                kVar.s(57, downloadBean.getCountryName());
            }
            if (downloadBean.getSeNum() == null) {
                kVar.m0(58);
            } else {
                kVar.V(58, downloadBean.getSeNum().intValue());
            }
            if (downloadBean.getSubtitles() == null) {
                kVar.m0(59);
            } else {
                kVar.s(59, downloadBean.getSubtitles());
            }
            if (downloadBean.getImdbRate() == null) {
                kVar.m0(60);
            } else {
                kVar.s(60, downloadBean.getImdbRate());
            }
            if (downloadBean.getLastAdStartTimeStamp() == null) {
                kVar.m0(61);
            } else {
                kVar.V(61, downloadBean.getLastAdStartTimeStamp().longValue());
            }
            if (downloadBean.getLastAdEndTimeStamp() == null) {
                kVar.m0(62);
            } else {
                kVar.V(62, downloadBean.getLastAdEndTimeStamp().longValue());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i0 implements Callable<List<? extends DownloadBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.v f77313a;

        public i0(androidx.room.v vVar) {
            this.f77313a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<? extends DownloadBean> call() throws Exception {
            i0 i0Var;
            Cursor cursorC = e6.b.c(d.this.f77271a, this.f77313a, false, null);
            try {
                int iE = e6.a.e(cursorC, "url");
                int iE2 = e6.a.e(cursorC, "resourceId");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "cover");
                int iE5 = e6.a.e(cursorC, "size");
                int iE6 = e6.a.e(cursorC, "postId");
                int iE7 = e6.a.e(cursorC, "sizeFormat");
                int iE8 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE9 = e6.a.e(cursorC, "duration");
                int iE10 = e6.a.e(cursorC, "updateTimeStamp");
                int iE11 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE12 = e6.a.e(cursorC, "supportRanges");
                int iE13 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE14 = e6.a.e(cursorC, "type");
                try {
                    int iE15 = e6.a.e(cursorC, "readProgress");
                    int iE16 = e6.a.e(cursorC, "createAt");
                    int iE17 = e6.a.e(cursorC, "isRead");
                    int iE18 = e6.a.e(cursorC, "episode");
                    int iE19 = e6.a.e(cursorC, "ep");
                    int iE20 = e6.a.e(cursorC, "se");
                    int iE21 = e6.a.e(cursorC, "resolution");
                    int iE22 = e6.a.e(cursorC, "resourcePosition");
                    int iE23 = e6.a.e(cursorC, "multiresolution");
                    int iE24 = e6.a.e(cursorC, "videoWidth");
                    int iE25 = e6.a.e(cursorC, "videoHeight");
                    int iE26 = e6.a.e(cursorC, "downloadErrorCount");
                    int iE27 = e6.a.e(cursorC, "subtitleStarted");
                    int iE28 = e6.a.e(cursorC, "subjectId");
                    int iE29 = e6.a.e(cursorC, "pageFrom");
                    int iE30 = e6.a.e(cursorC, "lastPageFrom");
                    int iE31 = e6.a.e(cursorC, "subjectName");
                    int iE32 = e6.a.e(cursorC, "lastPlayTimeStamp");
                    int iE33 = e6.a.e(cursorC, "fileType");
                    int iE34 = e6.a.e(cursorC, "totalEpisode");
                    int iE35 = e6.a.e(cursorC, "uploadBy");
                    int iE36 = e6.a.e(cursorC, "sourceUrl");
                    int iE37 = e6.a.e(cursorC, "urlCreateAt");
                    int iE38 = e6.a.e(cursorC, "subtitleSelectId");
                    int iE39 = e6.a.e(cursorC, "taskId");
                    int iE40 = e6.a.e(cursorC, "sessionTime");
                    int iE41 = e6.a.e(cursorC, "reportStatus");
                    int iE42 = e6.a.e(cursorC, "downloadHeaderSize");
                    int iE43 = e6.a.e(cursorC, "rootPath");
                    int iE44 = e6.a.e(cursorC, "rootPathType");
                    int iE45 = e6.a.e(cursorC, "thumbnail");
                    int iE46 = e6.a.e(cursorC, "averageHueLight");
                    int iE47 = e6.a.e(cursorC, "isTransferFailed");
                    int iE48 = e6.a.e(cursorC, "isClosedTransferFailed");
                    int iE49 = e6.a.e(cursorC, "subjectType");
                    int iE50 = e6.a.e(cursorC, "genre");
                    int iE51 = e6.a.e(cursorC, "subjectDurationSeconds");
                    int iE52 = e6.a.e(cursorC, "currentDubLanName");
                    int iE53 = e6.a.e(cursorC, "currentDubLanCode");
                    int iE54 = e6.a.e(cursorC, "ops");
                    int iE55 = e6.a.e(cursorC, "restrictLevel");
                    int iE56 = e6.a.e(cursorC, "releaseDate");
                    int iE57 = e6.a.e(cursorC, "countryName");
                    int iE58 = e6.a.e(cursorC, "seNum");
                    int iE59 = e6.a.e(cursorC, "subtitles");
                    int iE60 = e6.a.e(cursorC, "imdbRate");
                    int iE61 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE62 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string3 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string4 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        Long lValueOf = cursorC.isNull(iE5) ? null : Long.valueOf(cursorC.getLong(iE5));
                        String string5 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string6 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string7 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        Long lValueOf2 = cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9));
                        Long lValueOf3 = cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10));
                        long j11 = cursorC.getLong(iE11);
                        int i12 = cursorC.getInt(iE12);
                        int i13 = cursorC.getInt(iE13);
                        int i14 = i11;
                        int i15 = cursorC.getInt(i14);
                        int i16 = iE;
                        int i17 = iE15;
                        long j12 = cursorC.getLong(i17);
                        iE15 = i17;
                        int i18 = iE16;
                        long j13 = cursorC.getLong(i18);
                        iE16 = i18;
                        int i19 = iE17;
                        int i21 = cursorC.getInt(i19);
                        iE17 = i19;
                        int i22 = iE18;
                        int i23 = cursorC.getInt(i22);
                        iE18 = i22;
                        int i24 = iE19;
                        int i25 = cursorC.getInt(i24);
                        iE19 = i24;
                        int i26 = iE20;
                        int i27 = cursorC.getInt(i26);
                        iE20 = i26;
                        int i28 = iE21;
                        int i29 = cursorC.getInt(i28);
                        iE21 = i28;
                        int i31 = iE22;
                        int i32 = cursorC.getInt(i31);
                        iE22 = i31;
                        int i33 = iE23;
                        int i34 = cursorC.getInt(i33);
                        iE23 = i33;
                        int i35 = iE24;
                        int i36 = cursorC.getInt(i35);
                        iE24 = i35;
                        int i37 = iE25;
                        int i38 = cursorC.getInt(i37);
                        iE25 = i37;
                        int i39 = iE26;
                        int i40 = cursorC.getInt(i39);
                        iE26 = i39;
                        int i41 = iE27;
                        int i42 = cursorC.getInt(i41);
                        iE27 = i41;
                        iE28 = iE28;
                        String string8 = cursorC.isNull(iE28) ? null : cursorC.getString(iE28);
                        String string9 = cursorC.isNull(iE29) ? null : cursorC.getString(iE29);
                        String string10 = cursorC.isNull(iE30) ? null : cursorC.getString(iE30);
                        String string11 = cursorC.isNull(iE31) ? null : cursorC.getString(iE31);
                        long j14 = cursorC.getLong(iE32);
                        iE32 = iE32;
                        int i43 = iE33;
                        int i44 = cursorC.getInt(i43);
                        iE33 = i43;
                        int i45 = iE34;
                        int i46 = cursorC.getInt(i45);
                        iE34 = i45;
                        iE35 = iE35;
                        String string12 = cursorC.isNull(iE35) ? null : cursorC.getString(iE35);
                        String string13 = cursorC.isNull(iE36) ? null : cursorC.getString(iE36);
                        long j15 = cursorC.getLong(iE37);
                        iE37 = iE37;
                        iE38 = iE38;
                        String string14 = cursorC.isNull(iE38) ? null : cursorC.getString(iE38);
                        String string15 = cursorC.isNull(iE39) ? null : cursorC.getString(iE39);
                        long j16 = cursorC.getLong(iE40);
                        iE40 = iE40;
                        int i47 = iE41;
                        int i48 = cursorC.getInt(i47);
                        iE41 = i47;
                        int i49 = iE42;
                        long j17 = cursorC.getLong(i49);
                        iE42 = i49;
                        iE43 = iE43;
                        String string16 = cursorC.isNull(iE43) ? null : cursorC.getString(iE43);
                        int i50 = cursorC.getInt(iE44);
                        iE44 = iE44;
                        iE45 = iE45;
                        String string17 = cursorC.isNull(iE45) ? null : cursorC.getString(iE45);
                        String string18 = cursorC.isNull(iE46) ? null : cursorC.getString(iE46);
                        boolean z11 = cursorC.getInt(iE47) != 0;
                        boolean z12 = cursorC.getInt(iE48) != 0;
                        int i51 = cursorC.getInt(iE49);
                        iE49 = iE49;
                        iE50 = iE50;
                        arrayList.add(new DownloadBean(string, string2, string3, string4, lValueOf, string5, string6, string7, lValueOf2, lValueOf3, j11, i12, i13, i15, j12, j13, i21, i23, i25, i27, i29, i32, i34, i36, i38, i40, i42, string8, string9, string10, string11, j14, i44, i46, string12, string13, j15, string14, string15, j16, i48, j17, string16, i50, string17, string18, z11, z12, i51, cursorC.isNull(iE50) ? null : cursorC.getString(iE50), cursorC.isNull(iE51) ? null : Integer.valueOf(cursorC.getInt(iE51)), cursorC.isNull(iE52) ? null : cursorC.getString(iE52), cursorC.isNull(iE53) ? null : cursorC.getString(iE53), cursorC.isNull(iE54) ? null : cursorC.getString(iE54), cursorC.isNull(iE55) ? null : cursorC.getString(iE55), cursorC.isNull(iE56) ? null : cursorC.getString(iE56), cursorC.isNull(iE57) ? null : cursorC.getString(iE57), cursorC.isNull(iE58) ? null : Integer.valueOf(cursorC.getInt(iE58)), cursorC.isNull(iE59) ? null : cursorC.getString(iE59), cursorC.isNull(iE60) ? null : cursorC.getString(iE60), cursorC.isNull(iE61) ? null : Long.valueOf(cursorC.getLong(iE61)), cursorC.isNull(iE62) ? null : Long.valueOf(cursorC.getLong(iE62))));
                        iE = i16;
                        i11 = i14;
                    }
                    cursorC.close();
                    this.f77313a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    i0Var = this;
                    cursorC.close();
                    i0Var.f77313a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                i0Var = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class j implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f77315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f77316b;

        public j(int i11, String str) {
            this.f77315a = i11;
            this.f77316b = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            g6.k kVarB = d.this.f77275e.b();
            kVarB.V(1, this.f77315a);
            String str = this.f77316b;
            if (str == null) {
                kVarB.m0(2);
            } else {
                kVarB.s(2, str);
            }
            d.this.f77271a.e();
            try {
                kVarB.F();
                d.this.f77271a.E();
                return Unit.f68710a;
            } finally {
                d.this.f77271a.i();
                d.this.f77275e.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class j0 implements Callable<List<? extends DownloadBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.v f77318a;

        public j0(androidx.room.v vVar) {
            this.f77318a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<? extends DownloadBean> call() throws Exception {
            j0 j0Var;
            Cursor cursorC = e6.b.c(d.this.f77271a, this.f77318a, false, null);
            try {
                int iE = e6.a.e(cursorC, "url");
                int iE2 = e6.a.e(cursorC, "resourceId");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "cover");
                int iE5 = e6.a.e(cursorC, "size");
                int iE6 = e6.a.e(cursorC, "postId");
                int iE7 = e6.a.e(cursorC, "sizeFormat");
                int iE8 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE9 = e6.a.e(cursorC, "duration");
                int iE10 = e6.a.e(cursorC, "updateTimeStamp");
                int iE11 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE12 = e6.a.e(cursorC, "supportRanges");
                int iE13 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE14 = e6.a.e(cursorC, "type");
                try {
                    int iE15 = e6.a.e(cursorC, "readProgress");
                    int iE16 = e6.a.e(cursorC, "createAt");
                    int iE17 = e6.a.e(cursorC, "isRead");
                    int iE18 = e6.a.e(cursorC, "episode");
                    int iE19 = e6.a.e(cursorC, "ep");
                    int iE20 = e6.a.e(cursorC, "se");
                    int iE21 = e6.a.e(cursorC, "resolution");
                    int iE22 = e6.a.e(cursorC, "resourcePosition");
                    int iE23 = e6.a.e(cursorC, "multiresolution");
                    int iE24 = e6.a.e(cursorC, "videoWidth");
                    int iE25 = e6.a.e(cursorC, "videoHeight");
                    int iE26 = e6.a.e(cursorC, "downloadErrorCount");
                    int iE27 = e6.a.e(cursorC, "subtitleStarted");
                    int iE28 = e6.a.e(cursorC, "subjectId");
                    int iE29 = e6.a.e(cursorC, "pageFrom");
                    int iE30 = e6.a.e(cursorC, "lastPageFrom");
                    int iE31 = e6.a.e(cursorC, "subjectName");
                    int iE32 = e6.a.e(cursorC, "lastPlayTimeStamp");
                    int iE33 = e6.a.e(cursorC, "fileType");
                    int iE34 = e6.a.e(cursorC, "totalEpisode");
                    int iE35 = e6.a.e(cursorC, "uploadBy");
                    int iE36 = e6.a.e(cursorC, "sourceUrl");
                    int iE37 = e6.a.e(cursorC, "urlCreateAt");
                    int iE38 = e6.a.e(cursorC, "subtitleSelectId");
                    int iE39 = e6.a.e(cursorC, "taskId");
                    int iE40 = e6.a.e(cursorC, "sessionTime");
                    int iE41 = e6.a.e(cursorC, "reportStatus");
                    int iE42 = e6.a.e(cursorC, "downloadHeaderSize");
                    int iE43 = e6.a.e(cursorC, "rootPath");
                    int iE44 = e6.a.e(cursorC, "rootPathType");
                    int iE45 = e6.a.e(cursorC, "thumbnail");
                    int iE46 = e6.a.e(cursorC, "averageHueLight");
                    int iE47 = e6.a.e(cursorC, "isTransferFailed");
                    int iE48 = e6.a.e(cursorC, "isClosedTransferFailed");
                    int iE49 = e6.a.e(cursorC, "subjectType");
                    int iE50 = e6.a.e(cursorC, "genre");
                    int iE51 = e6.a.e(cursorC, "subjectDurationSeconds");
                    int iE52 = e6.a.e(cursorC, "currentDubLanName");
                    int iE53 = e6.a.e(cursorC, "currentDubLanCode");
                    int iE54 = e6.a.e(cursorC, "ops");
                    int iE55 = e6.a.e(cursorC, "restrictLevel");
                    int iE56 = e6.a.e(cursorC, "releaseDate");
                    int iE57 = e6.a.e(cursorC, "countryName");
                    int iE58 = e6.a.e(cursorC, "seNum");
                    int iE59 = e6.a.e(cursorC, "subtitles");
                    int iE60 = e6.a.e(cursorC, "imdbRate");
                    int iE61 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE62 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string3 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string4 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        Long lValueOf = cursorC.isNull(iE5) ? null : Long.valueOf(cursorC.getLong(iE5));
                        String string5 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string6 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string7 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        Long lValueOf2 = cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9));
                        Long lValueOf3 = cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10));
                        long j11 = cursorC.getLong(iE11);
                        int i12 = cursorC.getInt(iE12);
                        int i13 = cursorC.getInt(iE13);
                        int i14 = i11;
                        int i15 = cursorC.getInt(i14);
                        int i16 = iE;
                        int i17 = iE15;
                        long j12 = cursorC.getLong(i17);
                        iE15 = i17;
                        int i18 = iE16;
                        long j13 = cursorC.getLong(i18);
                        iE16 = i18;
                        int i19 = iE17;
                        int i21 = cursorC.getInt(i19);
                        iE17 = i19;
                        int i22 = iE18;
                        int i23 = cursorC.getInt(i22);
                        iE18 = i22;
                        int i24 = iE19;
                        int i25 = cursorC.getInt(i24);
                        iE19 = i24;
                        int i26 = iE20;
                        int i27 = cursorC.getInt(i26);
                        iE20 = i26;
                        int i28 = iE21;
                        int i29 = cursorC.getInt(i28);
                        iE21 = i28;
                        int i31 = iE22;
                        int i32 = cursorC.getInt(i31);
                        iE22 = i31;
                        int i33 = iE23;
                        int i34 = cursorC.getInt(i33);
                        iE23 = i33;
                        int i35 = iE24;
                        int i36 = cursorC.getInt(i35);
                        iE24 = i35;
                        int i37 = iE25;
                        int i38 = cursorC.getInt(i37);
                        iE25 = i37;
                        int i39 = iE26;
                        int i40 = cursorC.getInt(i39);
                        iE26 = i39;
                        int i41 = iE27;
                        int i42 = cursorC.getInt(i41);
                        iE27 = i41;
                        iE28 = iE28;
                        String string8 = cursorC.isNull(iE28) ? null : cursorC.getString(iE28);
                        String string9 = cursorC.isNull(iE29) ? null : cursorC.getString(iE29);
                        String string10 = cursorC.isNull(iE30) ? null : cursorC.getString(iE30);
                        String string11 = cursorC.isNull(iE31) ? null : cursorC.getString(iE31);
                        long j14 = cursorC.getLong(iE32);
                        iE32 = iE32;
                        int i43 = iE33;
                        int i44 = cursorC.getInt(i43);
                        iE33 = i43;
                        int i45 = iE34;
                        int i46 = cursorC.getInt(i45);
                        iE34 = i45;
                        iE35 = iE35;
                        String string12 = cursorC.isNull(iE35) ? null : cursorC.getString(iE35);
                        String string13 = cursorC.isNull(iE36) ? null : cursorC.getString(iE36);
                        long j15 = cursorC.getLong(iE37);
                        iE37 = iE37;
                        iE38 = iE38;
                        String string14 = cursorC.isNull(iE38) ? null : cursorC.getString(iE38);
                        String string15 = cursorC.isNull(iE39) ? null : cursorC.getString(iE39);
                        long j16 = cursorC.getLong(iE40);
                        iE40 = iE40;
                        int i47 = iE41;
                        int i48 = cursorC.getInt(i47);
                        iE41 = i47;
                        int i49 = iE42;
                        long j17 = cursorC.getLong(i49);
                        iE42 = i49;
                        iE43 = iE43;
                        String string16 = cursorC.isNull(iE43) ? null : cursorC.getString(iE43);
                        int i50 = cursorC.getInt(iE44);
                        iE44 = iE44;
                        iE45 = iE45;
                        String string17 = cursorC.isNull(iE45) ? null : cursorC.getString(iE45);
                        String string18 = cursorC.isNull(iE46) ? null : cursorC.getString(iE46);
                        boolean z11 = cursorC.getInt(iE47) != 0;
                        boolean z12 = cursorC.getInt(iE48) != 0;
                        int i51 = cursorC.getInt(iE49);
                        iE49 = iE49;
                        iE50 = iE50;
                        arrayList.add(new DownloadBean(string, string2, string3, string4, lValueOf, string5, string6, string7, lValueOf2, lValueOf3, j11, i12, i13, i15, j12, j13, i21, i23, i25, i27, i29, i32, i34, i36, i38, i40, i42, string8, string9, string10, string11, j14, i44, i46, string12, string13, j15, string14, string15, j16, i48, j17, string16, i50, string17, string18, z11, z12, i51, cursorC.isNull(iE50) ? null : cursorC.getString(iE50), cursorC.isNull(iE51) ? null : Integer.valueOf(cursorC.getInt(iE51)), cursorC.isNull(iE52) ? null : cursorC.getString(iE52), cursorC.isNull(iE53) ? null : cursorC.getString(iE53), cursorC.isNull(iE54) ? null : cursorC.getString(iE54), cursorC.isNull(iE55) ? null : cursorC.getString(iE55), cursorC.isNull(iE56) ? null : cursorC.getString(iE56), cursorC.isNull(iE57) ? null : cursorC.getString(iE57), cursorC.isNull(iE58) ? null : Integer.valueOf(cursorC.getInt(iE58)), cursorC.isNull(iE59) ? null : cursorC.getString(iE59), cursorC.isNull(iE60) ? null : cursorC.getString(iE60), cursorC.isNull(iE61) ? null : Long.valueOf(cursorC.getLong(iE61)), cursorC.isNull(iE62) ? null : Long.valueOf(cursorC.getLong(iE62))));
                        iE = i16;
                        i11 = i14;
                    }
                    cursorC.close();
                    this.f77318a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    j0Var = this;
                    cursorC.close();
                    j0Var.f77318a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                j0Var = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class k implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f77320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f77321b;

        public k(long j11, String str) {
            this.f77320a = j11;
            this.f77321b = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            g6.k kVarB = d.this.f77276f.b();
            kVarB.V(1, this.f77320a);
            String str = this.f77321b;
            if (str == null) {
                kVarB.m0(2);
            } else {
                kVarB.s(2, str);
            }
            d.this.f77271a.e();
            try {
                kVarB.F();
                d.this.f77271a.E();
                return Unit.f68710a;
            } finally {
                d.this.f77271a.i();
                d.this.f77276f.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class k0 implements Callable<DownloadBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.v f77323a;

        public k0(androidx.room.v vVar) {
            this.f77323a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadBean call() throws Exception {
            DownloadBean downloadBean;
            k0 k0Var = this;
            Cursor cursorC = e6.b.c(d.this.f77271a, k0Var.f77323a, false, null);
            try {
                int iE = e6.a.e(cursorC, "url");
                int iE2 = e6.a.e(cursorC, "resourceId");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "cover");
                int iE5 = e6.a.e(cursorC, "size");
                int iE6 = e6.a.e(cursorC, "postId");
                int iE7 = e6.a.e(cursorC, "sizeFormat");
                int iE8 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE9 = e6.a.e(cursorC, "duration");
                int iE10 = e6.a.e(cursorC, "updateTimeStamp");
                int iE11 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE12 = e6.a.e(cursorC, "supportRanges");
                int iE13 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE14 = e6.a.e(cursorC, "type");
                try {
                    int iE15 = e6.a.e(cursorC, "readProgress");
                    int iE16 = e6.a.e(cursorC, "createAt");
                    int iE17 = e6.a.e(cursorC, "isRead");
                    int iE18 = e6.a.e(cursorC, "episode");
                    int iE19 = e6.a.e(cursorC, "ep");
                    int iE20 = e6.a.e(cursorC, "se");
                    int iE21 = e6.a.e(cursorC, "resolution");
                    int iE22 = e6.a.e(cursorC, "resourcePosition");
                    int iE23 = e6.a.e(cursorC, "multiresolution");
                    int iE24 = e6.a.e(cursorC, "videoWidth");
                    int iE25 = e6.a.e(cursorC, "videoHeight");
                    int iE26 = e6.a.e(cursorC, "downloadErrorCount");
                    int iE27 = e6.a.e(cursorC, "subtitleStarted");
                    int iE28 = e6.a.e(cursorC, "subjectId");
                    int iE29 = e6.a.e(cursorC, "pageFrom");
                    int iE30 = e6.a.e(cursorC, "lastPageFrom");
                    int iE31 = e6.a.e(cursorC, "subjectName");
                    int iE32 = e6.a.e(cursorC, "lastPlayTimeStamp");
                    int iE33 = e6.a.e(cursorC, "fileType");
                    int iE34 = e6.a.e(cursorC, "totalEpisode");
                    int iE35 = e6.a.e(cursorC, "uploadBy");
                    int iE36 = e6.a.e(cursorC, "sourceUrl");
                    int iE37 = e6.a.e(cursorC, "urlCreateAt");
                    int iE38 = e6.a.e(cursorC, "subtitleSelectId");
                    int iE39 = e6.a.e(cursorC, "taskId");
                    int iE40 = e6.a.e(cursorC, "sessionTime");
                    int iE41 = e6.a.e(cursorC, "reportStatus");
                    int iE42 = e6.a.e(cursorC, "downloadHeaderSize");
                    int iE43 = e6.a.e(cursorC, "rootPath");
                    int iE44 = e6.a.e(cursorC, "rootPathType");
                    int iE45 = e6.a.e(cursorC, "thumbnail");
                    int iE46 = e6.a.e(cursorC, "averageHueLight");
                    int iE47 = e6.a.e(cursorC, "isTransferFailed");
                    int iE48 = e6.a.e(cursorC, "isClosedTransferFailed");
                    int iE49 = e6.a.e(cursorC, "subjectType");
                    int iE50 = e6.a.e(cursorC, "genre");
                    int iE51 = e6.a.e(cursorC, "subjectDurationSeconds");
                    int iE52 = e6.a.e(cursorC, "currentDubLanName");
                    int iE53 = e6.a.e(cursorC, "currentDubLanCode");
                    int iE54 = e6.a.e(cursorC, "ops");
                    int iE55 = e6.a.e(cursorC, "restrictLevel");
                    int iE56 = e6.a.e(cursorC, "releaseDate");
                    int iE57 = e6.a.e(cursorC, "countryName");
                    int iE58 = e6.a.e(cursorC, "seNum");
                    int iE59 = e6.a.e(cursorC, "subtitles");
                    int iE60 = e6.a.e(cursorC, "imdbRate");
                    int iE61 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE62 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    if (cursorC.moveToFirst()) {
                        downloadBean = new DownloadBean(cursorC.isNull(iE) ? null : cursorC.getString(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : Long.valueOf(cursorC.getLong(iE5)), cursorC.isNull(iE6) ? null : cursorC.getString(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : cursorC.getString(iE8), cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9)), cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10)), cursorC.getLong(iE11), cursorC.getInt(iE12), cursorC.getInt(iE13), cursorC.getInt(iE14), cursorC.getLong(iE15), cursorC.getLong(iE16), cursorC.getInt(iE17), cursorC.getInt(iE18), cursorC.getInt(iE19), cursorC.getInt(iE20), cursorC.getInt(iE21), cursorC.getInt(iE22), cursorC.getInt(iE23), cursorC.getInt(iE24), cursorC.getInt(iE25), cursorC.getInt(iE26), cursorC.getInt(iE27), cursorC.isNull(iE28) ? null : cursorC.getString(iE28), cursorC.isNull(r30) ? null : cursorC.getString(iE29), cursorC.isNull(r31) ? null : cursorC.getString(iE30), cursorC.isNull(r32) ? null : cursorC.getString(iE31), cursorC.getLong(iE32), cursorC.getInt(iE33), cursorC.getInt(iE34), cursorC.isNull(iE35) ? null : cursorC.getString(iE35), cursorC.isNull(r37) ? null : cursorC.getString(iE36), cursorC.getLong(iE37), cursorC.isNull(iE38) ? null : cursorC.getString(iE38), cursorC.isNull(r40) ? null : cursorC.getString(iE39), cursorC.getLong(iE40), cursorC.getInt(iE41), cursorC.getLong(iE42), cursorC.isNull(iE43) ? null : cursorC.getString(iE43), cursorC.getInt(iE44), cursorC.isNull(iE45) ? null : cursorC.getString(iE45), cursorC.isNull(r47) ? null : cursorC.getString(iE46), cursorC.getInt(iE47) != 0, cursorC.getInt(iE48) != 0, cursorC.getInt(iE49), cursorC.isNull(iE50) ? null : cursorC.getString(iE50), cursorC.isNull(r52) ? null : Integer.valueOf(cursorC.getInt(iE51)), cursorC.isNull(r53) ? null : cursorC.getString(iE52), cursorC.isNull(r54) ? null : cursorC.getString(iE53), cursorC.isNull(r55) ? null : cursorC.getString(iE54), cursorC.isNull(r56) ? null : cursorC.getString(iE55), cursorC.isNull(r57) ? null : cursorC.getString(iE56), cursorC.isNull(r58) ? null : cursorC.getString(iE57), cursorC.isNull(r59) ? null : Integer.valueOf(cursorC.getInt(iE58)), cursorC.isNull(r60) ? null : cursorC.getString(iE59), cursorC.isNull(r61) ? null : cursorC.getString(iE60), cursorC.isNull(r62) ? null : Long.valueOf(cursorC.getLong(iE61)), cursorC.isNull(iE62) ? null : Long.valueOf(cursorC.getLong(iE62)));
                    } else {
                        downloadBean = null;
                    }
                    cursorC.close();
                    this.f77323a.release();
                    return downloadBean;
                } catch (Throwable th2) {
                    th = th2;
                    k0Var = this;
                    cursorC.close();
                    k0Var.f77323a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class l implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f77325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f77326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f77327c;

        public l(int i11, int i12, String str) {
            this.f77325a = i11;
            this.f77326b = i12;
            this.f77327c = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            g6.k kVarB = d.this.f77278h.b();
            kVarB.V(1, this.f77325a);
            kVarB.V(2, this.f77326b);
            String str = this.f77327c;
            if (str == null) {
                kVarB.m0(3);
            } else {
                kVarB.s(3, str);
            }
            d.this.f77271a.e();
            try {
                kVarB.F();
                d.this.f77271a.E();
                return Unit.f68710a;
            } finally {
                d.this.f77271a.i();
                d.this.f77278h.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class l0 implements Callable<DownloadBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.v f77329a;

        public l0(androidx.room.v vVar) {
            this.f77329a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadBean call() throws Exception {
            DownloadBean downloadBean;
            l0 l0Var = this;
            Cursor cursorC = e6.b.c(d.this.f77271a, l0Var.f77329a, false, null);
            try {
                int iE = e6.a.e(cursorC, "url");
                int iE2 = e6.a.e(cursorC, "resourceId");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "cover");
                int iE5 = e6.a.e(cursorC, "size");
                int iE6 = e6.a.e(cursorC, "postId");
                int iE7 = e6.a.e(cursorC, "sizeFormat");
                int iE8 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE9 = e6.a.e(cursorC, "duration");
                int iE10 = e6.a.e(cursorC, "updateTimeStamp");
                int iE11 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE12 = e6.a.e(cursorC, "supportRanges");
                int iE13 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE14 = e6.a.e(cursorC, "type");
                try {
                    int iE15 = e6.a.e(cursorC, "readProgress");
                    int iE16 = e6.a.e(cursorC, "createAt");
                    int iE17 = e6.a.e(cursorC, "isRead");
                    int iE18 = e6.a.e(cursorC, "episode");
                    int iE19 = e6.a.e(cursorC, "ep");
                    int iE20 = e6.a.e(cursorC, "se");
                    int iE21 = e6.a.e(cursorC, "resolution");
                    int iE22 = e6.a.e(cursorC, "resourcePosition");
                    int iE23 = e6.a.e(cursorC, "multiresolution");
                    int iE24 = e6.a.e(cursorC, "videoWidth");
                    int iE25 = e6.a.e(cursorC, "videoHeight");
                    int iE26 = e6.a.e(cursorC, "downloadErrorCount");
                    int iE27 = e6.a.e(cursorC, "subtitleStarted");
                    int iE28 = e6.a.e(cursorC, "subjectId");
                    int iE29 = e6.a.e(cursorC, "pageFrom");
                    int iE30 = e6.a.e(cursorC, "lastPageFrom");
                    int iE31 = e6.a.e(cursorC, "subjectName");
                    int iE32 = e6.a.e(cursorC, "lastPlayTimeStamp");
                    int iE33 = e6.a.e(cursorC, "fileType");
                    int iE34 = e6.a.e(cursorC, "totalEpisode");
                    int iE35 = e6.a.e(cursorC, "uploadBy");
                    int iE36 = e6.a.e(cursorC, "sourceUrl");
                    int iE37 = e6.a.e(cursorC, "urlCreateAt");
                    int iE38 = e6.a.e(cursorC, "subtitleSelectId");
                    int iE39 = e6.a.e(cursorC, "taskId");
                    int iE40 = e6.a.e(cursorC, "sessionTime");
                    int iE41 = e6.a.e(cursorC, "reportStatus");
                    int iE42 = e6.a.e(cursorC, "downloadHeaderSize");
                    int iE43 = e6.a.e(cursorC, "rootPath");
                    int iE44 = e6.a.e(cursorC, "rootPathType");
                    int iE45 = e6.a.e(cursorC, "thumbnail");
                    int iE46 = e6.a.e(cursorC, "averageHueLight");
                    int iE47 = e6.a.e(cursorC, "isTransferFailed");
                    int iE48 = e6.a.e(cursorC, "isClosedTransferFailed");
                    int iE49 = e6.a.e(cursorC, "subjectType");
                    int iE50 = e6.a.e(cursorC, "genre");
                    int iE51 = e6.a.e(cursorC, "subjectDurationSeconds");
                    int iE52 = e6.a.e(cursorC, "currentDubLanName");
                    int iE53 = e6.a.e(cursorC, "currentDubLanCode");
                    int iE54 = e6.a.e(cursorC, "ops");
                    int iE55 = e6.a.e(cursorC, "restrictLevel");
                    int iE56 = e6.a.e(cursorC, "releaseDate");
                    int iE57 = e6.a.e(cursorC, "countryName");
                    int iE58 = e6.a.e(cursorC, "seNum");
                    int iE59 = e6.a.e(cursorC, "subtitles");
                    int iE60 = e6.a.e(cursorC, "imdbRate");
                    int iE61 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE62 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    if (cursorC.moveToFirst()) {
                        downloadBean = new DownloadBean(cursorC.isNull(iE) ? null : cursorC.getString(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : Long.valueOf(cursorC.getLong(iE5)), cursorC.isNull(iE6) ? null : cursorC.getString(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : cursorC.getString(iE8), cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9)), cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10)), cursorC.getLong(iE11), cursorC.getInt(iE12), cursorC.getInt(iE13), cursorC.getInt(iE14), cursorC.getLong(iE15), cursorC.getLong(iE16), cursorC.getInt(iE17), cursorC.getInt(iE18), cursorC.getInt(iE19), cursorC.getInt(iE20), cursorC.getInt(iE21), cursorC.getInt(iE22), cursorC.getInt(iE23), cursorC.getInt(iE24), cursorC.getInt(iE25), cursorC.getInt(iE26), cursorC.getInt(iE27), cursorC.isNull(iE28) ? null : cursorC.getString(iE28), cursorC.isNull(r30) ? null : cursorC.getString(iE29), cursorC.isNull(r31) ? null : cursorC.getString(iE30), cursorC.isNull(r32) ? null : cursorC.getString(iE31), cursorC.getLong(iE32), cursorC.getInt(iE33), cursorC.getInt(iE34), cursorC.isNull(iE35) ? null : cursorC.getString(iE35), cursorC.isNull(r37) ? null : cursorC.getString(iE36), cursorC.getLong(iE37), cursorC.isNull(iE38) ? null : cursorC.getString(iE38), cursorC.isNull(r40) ? null : cursorC.getString(iE39), cursorC.getLong(iE40), cursorC.getInt(iE41), cursorC.getLong(iE42), cursorC.isNull(iE43) ? null : cursorC.getString(iE43), cursorC.getInt(iE44), cursorC.isNull(iE45) ? null : cursorC.getString(iE45), cursorC.isNull(r47) ? null : cursorC.getString(iE46), cursorC.getInt(iE47) != 0, cursorC.getInt(iE48) != 0, cursorC.getInt(iE49), cursorC.isNull(iE50) ? null : cursorC.getString(iE50), cursorC.isNull(r52) ? null : Integer.valueOf(cursorC.getInt(iE51)), cursorC.isNull(r53) ? null : cursorC.getString(iE52), cursorC.isNull(r54) ? null : cursorC.getString(iE53), cursorC.isNull(r55) ? null : cursorC.getString(iE54), cursorC.isNull(r56) ? null : cursorC.getString(iE55), cursorC.isNull(r57) ? null : cursorC.getString(iE56), cursorC.isNull(r58) ? null : cursorC.getString(iE57), cursorC.isNull(r59) ? null : Integer.valueOf(cursorC.getInt(iE58)), cursorC.isNull(r60) ? null : cursorC.getString(iE59), cursorC.isNull(r61) ? null : cursorC.getString(iE60), cursorC.isNull(r62) ? null : Long.valueOf(cursorC.getLong(iE61)), cursorC.isNull(iE62) ? null : Long.valueOf(cursorC.getLong(iE62)));
                    } else {
                        downloadBean = null;
                    }
                    cursorC.close();
                    this.f77329a.release();
                    return downloadBean;
                } catch (Throwable th2) {
                    th = th2;
                    l0Var = this;
                    cursorC.close();
                    l0Var.f77329a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class m implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f77331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f77332b;

        public m(long j11, String str) {
            this.f77331a = j11;
            this.f77332b = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            g6.k kVarB = d.this.f77279i.b();
            kVarB.V(1, this.f77331a);
            String str = this.f77332b;
            if (str == null) {
                kVarB.m0(2);
            } else {
                kVarB.s(2, str);
            }
            d.this.f77271a.e();
            try {
                kVarB.F();
                d.this.f77271a.E();
                return Unit.f68710a;
            } finally {
                d.this.f77271a.i();
                d.this.f77279i.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class m0 implements Callable<List<? extends DownloadBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.v f77334a;

        public m0(androidx.room.v vVar) {
            this.f77334a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<? extends DownloadBean> call() throws Exception {
            m0 m0Var;
            Cursor cursorC = e6.b.c(d.this.f77271a, this.f77334a, false, null);
            try {
                int iE = e6.a.e(cursorC, "url");
                int iE2 = e6.a.e(cursorC, "resourceId");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "cover");
                int iE5 = e6.a.e(cursorC, "size");
                int iE6 = e6.a.e(cursorC, "postId");
                int iE7 = e6.a.e(cursorC, "sizeFormat");
                int iE8 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE9 = e6.a.e(cursorC, "duration");
                int iE10 = e6.a.e(cursorC, "updateTimeStamp");
                int iE11 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE12 = e6.a.e(cursorC, "supportRanges");
                int iE13 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE14 = e6.a.e(cursorC, "type");
                try {
                    int iE15 = e6.a.e(cursorC, "readProgress");
                    int iE16 = e6.a.e(cursorC, "createAt");
                    int iE17 = e6.a.e(cursorC, "isRead");
                    int iE18 = e6.a.e(cursorC, "episode");
                    int iE19 = e6.a.e(cursorC, "ep");
                    int iE20 = e6.a.e(cursorC, "se");
                    int iE21 = e6.a.e(cursorC, "resolution");
                    int iE22 = e6.a.e(cursorC, "resourcePosition");
                    int iE23 = e6.a.e(cursorC, "multiresolution");
                    int iE24 = e6.a.e(cursorC, "videoWidth");
                    int iE25 = e6.a.e(cursorC, "videoHeight");
                    int iE26 = e6.a.e(cursorC, "downloadErrorCount");
                    int iE27 = e6.a.e(cursorC, "subtitleStarted");
                    int iE28 = e6.a.e(cursorC, "subjectId");
                    int iE29 = e6.a.e(cursorC, "pageFrom");
                    int iE30 = e6.a.e(cursorC, "lastPageFrom");
                    int iE31 = e6.a.e(cursorC, "subjectName");
                    int iE32 = e6.a.e(cursorC, "lastPlayTimeStamp");
                    int iE33 = e6.a.e(cursorC, "fileType");
                    int iE34 = e6.a.e(cursorC, "totalEpisode");
                    int iE35 = e6.a.e(cursorC, "uploadBy");
                    int iE36 = e6.a.e(cursorC, "sourceUrl");
                    int iE37 = e6.a.e(cursorC, "urlCreateAt");
                    int iE38 = e6.a.e(cursorC, "subtitleSelectId");
                    int iE39 = e6.a.e(cursorC, "taskId");
                    int iE40 = e6.a.e(cursorC, "sessionTime");
                    int iE41 = e6.a.e(cursorC, "reportStatus");
                    int iE42 = e6.a.e(cursorC, "downloadHeaderSize");
                    int iE43 = e6.a.e(cursorC, "rootPath");
                    int iE44 = e6.a.e(cursorC, "rootPathType");
                    int iE45 = e6.a.e(cursorC, "thumbnail");
                    int iE46 = e6.a.e(cursorC, "averageHueLight");
                    int iE47 = e6.a.e(cursorC, "isTransferFailed");
                    int iE48 = e6.a.e(cursorC, "isClosedTransferFailed");
                    int iE49 = e6.a.e(cursorC, "subjectType");
                    int iE50 = e6.a.e(cursorC, "genre");
                    int iE51 = e6.a.e(cursorC, "subjectDurationSeconds");
                    int iE52 = e6.a.e(cursorC, "currentDubLanName");
                    int iE53 = e6.a.e(cursorC, "currentDubLanCode");
                    int iE54 = e6.a.e(cursorC, "ops");
                    int iE55 = e6.a.e(cursorC, "restrictLevel");
                    int iE56 = e6.a.e(cursorC, "releaseDate");
                    int iE57 = e6.a.e(cursorC, "countryName");
                    int iE58 = e6.a.e(cursorC, "seNum");
                    int iE59 = e6.a.e(cursorC, "subtitles");
                    int iE60 = e6.a.e(cursorC, "imdbRate");
                    int iE61 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE62 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string3 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string4 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        Long lValueOf = cursorC.isNull(iE5) ? null : Long.valueOf(cursorC.getLong(iE5));
                        String string5 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string6 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string7 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        Long lValueOf2 = cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9));
                        Long lValueOf3 = cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10));
                        long j11 = cursorC.getLong(iE11);
                        int i12 = cursorC.getInt(iE12);
                        int i13 = cursorC.getInt(iE13);
                        int i14 = i11;
                        int i15 = cursorC.getInt(i14);
                        int i16 = iE;
                        int i17 = iE15;
                        long j12 = cursorC.getLong(i17);
                        iE15 = i17;
                        int i18 = iE16;
                        long j13 = cursorC.getLong(i18);
                        iE16 = i18;
                        int i19 = iE17;
                        int i21 = cursorC.getInt(i19);
                        iE17 = i19;
                        int i22 = iE18;
                        int i23 = cursorC.getInt(i22);
                        iE18 = i22;
                        int i24 = iE19;
                        int i25 = cursorC.getInt(i24);
                        iE19 = i24;
                        int i26 = iE20;
                        int i27 = cursorC.getInt(i26);
                        iE20 = i26;
                        int i28 = iE21;
                        int i29 = cursorC.getInt(i28);
                        iE21 = i28;
                        int i31 = iE22;
                        int i32 = cursorC.getInt(i31);
                        iE22 = i31;
                        int i33 = iE23;
                        int i34 = cursorC.getInt(i33);
                        iE23 = i33;
                        int i35 = iE24;
                        int i36 = cursorC.getInt(i35);
                        iE24 = i35;
                        int i37 = iE25;
                        int i38 = cursorC.getInt(i37);
                        iE25 = i37;
                        int i39 = iE26;
                        int i40 = cursorC.getInt(i39);
                        iE26 = i39;
                        int i41 = iE27;
                        int i42 = cursorC.getInt(i41);
                        iE27 = i41;
                        iE28 = iE28;
                        String string8 = cursorC.isNull(iE28) ? null : cursorC.getString(iE28);
                        String string9 = cursorC.isNull(iE29) ? null : cursorC.getString(iE29);
                        String string10 = cursorC.isNull(iE30) ? null : cursorC.getString(iE30);
                        String string11 = cursorC.isNull(iE31) ? null : cursorC.getString(iE31);
                        long j14 = cursorC.getLong(iE32);
                        iE32 = iE32;
                        int i43 = iE33;
                        int i44 = cursorC.getInt(i43);
                        iE33 = i43;
                        int i45 = iE34;
                        int i46 = cursorC.getInt(i45);
                        iE34 = i45;
                        iE35 = iE35;
                        String string12 = cursorC.isNull(iE35) ? null : cursorC.getString(iE35);
                        String string13 = cursorC.isNull(iE36) ? null : cursorC.getString(iE36);
                        long j15 = cursorC.getLong(iE37);
                        iE37 = iE37;
                        iE38 = iE38;
                        String string14 = cursorC.isNull(iE38) ? null : cursorC.getString(iE38);
                        String string15 = cursorC.isNull(iE39) ? null : cursorC.getString(iE39);
                        long j16 = cursorC.getLong(iE40);
                        iE40 = iE40;
                        int i47 = iE41;
                        int i48 = cursorC.getInt(i47);
                        iE41 = i47;
                        int i49 = iE42;
                        long j17 = cursorC.getLong(i49);
                        iE42 = i49;
                        iE43 = iE43;
                        String string16 = cursorC.isNull(iE43) ? null : cursorC.getString(iE43);
                        int i50 = cursorC.getInt(iE44);
                        iE44 = iE44;
                        iE45 = iE45;
                        String string17 = cursorC.isNull(iE45) ? null : cursorC.getString(iE45);
                        String string18 = cursorC.isNull(iE46) ? null : cursorC.getString(iE46);
                        boolean z11 = cursorC.getInt(iE47) != 0;
                        boolean z12 = cursorC.getInt(iE48) != 0;
                        int i51 = cursorC.getInt(iE49);
                        iE49 = iE49;
                        iE50 = iE50;
                        arrayList.add(new DownloadBean(string, string2, string3, string4, lValueOf, string5, string6, string7, lValueOf2, lValueOf3, j11, i12, i13, i15, j12, j13, i21, i23, i25, i27, i29, i32, i34, i36, i38, i40, i42, string8, string9, string10, string11, j14, i44, i46, string12, string13, j15, string14, string15, j16, i48, j17, string16, i50, string17, string18, z11, z12, i51, cursorC.isNull(iE50) ? null : cursorC.getString(iE50), cursorC.isNull(iE51) ? null : Integer.valueOf(cursorC.getInt(iE51)), cursorC.isNull(iE52) ? null : cursorC.getString(iE52), cursorC.isNull(iE53) ? null : cursorC.getString(iE53), cursorC.isNull(iE54) ? null : cursorC.getString(iE54), cursorC.isNull(iE55) ? null : cursorC.getString(iE55), cursorC.isNull(iE56) ? null : cursorC.getString(iE56), cursorC.isNull(iE57) ? null : cursorC.getString(iE57), cursorC.isNull(iE58) ? null : Integer.valueOf(cursorC.getInt(iE58)), cursorC.isNull(iE59) ? null : cursorC.getString(iE59), cursorC.isNull(iE60) ? null : cursorC.getString(iE60), cursorC.isNull(iE61) ? null : Long.valueOf(cursorC.getLong(iE61)), cursorC.isNull(iE62) ? null : Long.valueOf(cursorC.getLong(iE62))));
                        iE = i16;
                        i11 = i14;
                    }
                    cursorC.close();
                    this.f77334a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    m0Var = this;
                    cursorC.close();
                    m0Var.f77334a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                m0Var = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class n implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f77336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f77337b;

        public n(long j11, String str) {
            this.f77336a = j11;
            this.f77337b = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            g6.k kVarB = d.this.f77280j.b();
            kVarB.V(1, this.f77336a);
            String str = this.f77337b;
            if (str == null) {
                kVarB.m0(2);
            } else {
                kVarB.s(2, str);
            }
            d.this.f77271a.e();
            try {
                kVarB.F();
                d.this.f77271a.E();
                return Unit.f68710a;
            } finally {
                d.this.f77271a.i();
                d.this.f77280j.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class n0 implements Callable<List<? extends DownloadBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.v f77339a;

        public n0(androidx.room.v vVar) {
            this.f77339a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<? extends DownloadBean> call() throws Exception {
            n0 n0Var;
            Cursor cursorC = e6.b.c(d.this.f77271a, this.f77339a, false, null);
            try {
                int iE = e6.a.e(cursorC, "url");
                int iE2 = e6.a.e(cursorC, "resourceId");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "cover");
                int iE5 = e6.a.e(cursorC, "size");
                int iE6 = e6.a.e(cursorC, "postId");
                int iE7 = e6.a.e(cursorC, "sizeFormat");
                int iE8 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE9 = e6.a.e(cursorC, "duration");
                int iE10 = e6.a.e(cursorC, "updateTimeStamp");
                int iE11 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE12 = e6.a.e(cursorC, "supportRanges");
                int iE13 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE14 = e6.a.e(cursorC, "type");
                try {
                    int iE15 = e6.a.e(cursorC, "readProgress");
                    int iE16 = e6.a.e(cursorC, "createAt");
                    int iE17 = e6.a.e(cursorC, "isRead");
                    int iE18 = e6.a.e(cursorC, "episode");
                    int iE19 = e6.a.e(cursorC, "ep");
                    int iE20 = e6.a.e(cursorC, "se");
                    int iE21 = e6.a.e(cursorC, "resolution");
                    int iE22 = e6.a.e(cursorC, "resourcePosition");
                    int iE23 = e6.a.e(cursorC, "multiresolution");
                    int iE24 = e6.a.e(cursorC, "videoWidth");
                    int iE25 = e6.a.e(cursorC, "videoHeight");
                    int iE26 = e6.a.e(cursorC, "downloadErrorCount");
                    int iE27 = e6.a.e(cursorC, "subtitleStarted");
                    int iE28 = e6.a.e(cursorC, "subjectId");
                    int iE29 = e6.a.e(cursorC, "pageFrom");
                    int iE30 = e6.a.e(cursorC, "lastPageFrom");
                    int iE31 = e6.a.e(cursorC, "subjectName");
                    int iE32 = e6.a.e(cursorC, "lastPlayTimeStamp");
                    int iE33 = e6.a.e(cursorC, "fileType");
                    int iE34 = e6.a.e(cursorC, "totalEpisode");
                    int iE35 = e6.a.e(cursorC, "uploadBy");
                    int iE36 = e6.a.e(cursorC, "sourceUrl");
                    int iE37 = e6.a.e(cursorC, "urlCreateAt");
                    int iE38 = e6.a.e(cursorC, "subtitleSelectId");
                    int iE39 = e6.a.e(cursorC, "taskId");
                    int iE40 = e6.a.e(cursorC, "sessionTime");
                    int iE41 = e6.a.e(cursorC, "reportStatus");
                    int iE42 = e6.a.e(cursorC, "downloadHeaderSize");
                    int iE43 = e6.a.e(cursorC, "rootPath");
                    int iE44 = e6.a.e(cursorC, "rootPathType");
                    int iE45 = e6.a.e(cursorC, "thumbnail");
                    int iE46 = e6.a.e(cursorC, "averageHueLight");
                    int iE47 = e6.a.e(cursorC, "isTransferFailed");
                    int iE48 = e6.a.e(cursorC, "isClosedTransferFailed");
                    int iE49 = e6.a.e(cursorC, "subjectType");
                    int iE50 = e6.a.e(cursorC, "genre");
                    int iE51 = e6.a.e(cursorC, "subjectDurationSeconds");
                    int iE52 = e6.a.e(cursorC, "currentDubLanName");
                    int iE53 = e6.a.e(cursorC, "currentDubLanCode");
                    int iE54 = e6.a.e(cursorC, "ops");
                    int iE55 = e6.a.e(cursorC, "restrictLevel");
                    int iE56 = e6.a.e(cursorC, "releaseDate");
                    int iE57 = e6.a.e(cursorC, "countryName");
                    int iE58 = e6.a.e(cursorC, "seNum");
                    int iE59 = e6.a.e(cursorC, "subtitles");
                    int iE60 = e6.a.e(cursorC, "imdbRate");
                    int iE61 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE62 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string3 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string4 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        Long lValueOf = cursorC.isNull(iE5) ? null : Long.valueOf(cursorC.getLong(iE5));
                        String string5 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string6 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string7 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        Long lValueOf2 = cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9));
                        Long lValueOf3 = cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10));
                        long j11 = cursorC.getLong(iE11);
                        int i12 = cursorC.getInt(iE12);
                        int i13 = cursorC.getInt(iE13);
                        int i14 = i11;
                        int i15 = cursorC.getInt(i14);
                        int i16 = iE;
                        int i17 = iE15;
                        long j12 = cursorC.getLong(i17);
                        iE15 = i17;
                        int i18 = iE16;
                        long j13 = cursorC.getLong(i18);
                        iE16 = i18;
                        int i19 = iE17;
                        int i21 = cursorC.getInt(i19);
                        iE17 = i19;
                        int i22 = iE18;
                        int i23 = cursorC.getInt(i22);
                        iE18 = i22;
                        int i24 = iE19;
                        int i25 = cursorC.getInt(i24);
                        iE19 = i24;
                        int i26 = iE20;
                        int i27 = cursorC.getInt(i26);
                        iE20 = i26;
                        int i28 = iE21;
                        int i29 = cursorC.getInt(i28);
                        iE21 = i28;
                        int i31 = iE22;
                        int i32 = cursorC.getInt(i31);
                        iE22 = i31;
                        int i33 = iE23;
                        int i34 = cursorC.getInt(i33);
                        iE23 = i33;
                        int i35 = iE24;
                        int i36 = cursorC.getInt(i35);
                        iE24 = i35;
                        int i37 = iE25;
                        int i38 = cursorC.getInt(i37);
                        iE25 = i37;
                        int i39 = iE26;
                        int i40 = cursorC.getInt(i39);
                        iE26 = i39;
                        int i41 = iE27;
                        int i42 = cursorC.getInt(i41);
                        iE27 = i41;
                        iE28 = iE28;
                        String string8 = cursorC.isNull(iE28) ? null : cursorC.getString(iE28);
                        String string9 = cursorC.isNull(iE29) ? null : cursorC.getString(iE29);
                        String string10 = cursorC.isNull(iE30) ? null : cursorC.getString(iE30);
                        String string11 = cursorC.isNull(iE31) ? null : cursorC.getString(iE31);
                        long j14 = cursorC.getLong(iE32);
                        iE32 = iE32;
                        int i43 = iE33;
                        int i44 = cursorC.getInt(i43);
                        iE33 = i43;
                        int i45 = iE34;
                        int i46 = cursorC.getInt(i45);
                        iE34 = i45;
                        iE35 = iE35;
                        String string12 = cursorC.isNull(iE35) ? null : cursorC.getString(iE35);
                        String string13 = cursorC.isNull(iE36) ? null : cursorC.getString(iE36);
                        long j15 = cursorC.getLong(iE37);
                        iE37 = iE37;
                        iE38 = iE38;
                        String string14 = cursorC.isNull(iE38) ? null : cursorC.getString(iE38);
                        String string15 = cursorC.isNull(iE39) ? null : cursorC.getString(iE39);
                        long j16 = cursorC.getLong(iE40);
                        iE40 = iE40;
                        int i47 = iE41;
                        int i48 = cursorC.getInt(i47);
                        iE41 = i47;
                        int i49 = iE42;
                        long j17 = cursorC.getLong(i49);
                        iE42 = i49;
                        iE43 = iE43;
                        String string16 = cursorC.isNull(iE43) ? null : cursorC.getString(iE43);
                        int i50 = cursorC.getInt(iE44);
                        iE44 = iE44;
                        iE45 = iE45;
                        String string17 = cursorC.isNull(iE45) ? null : cursorC.getString(iE45);
                        String string18 = cursorC.isNull(iE46) ? null : cursorC.getString(iE46);
                        boolean z11 = cursorC.getInt(iE47) != 0;
                        boolean z12 = cursorC.getInt(iE48) != 0;
                        int i51 = cursorC.getInt(iE49);
                        iE49 = iE49;
                        iE50 = iE50;
                        arrayList.add(new DownloadBean(string, string2, string3, string4, lValueOf, string5, string6, string7, lValueOf2, lValueOf3, j11, i12, i13, i15, j12, j13, i21, i23, i25, i27, i29, i32, i34, i36, i38, i40, i42, string8, string9, string10, string11, j14, i44, i46, string12, string13, j15, string14, string15, j16, i48, j17, string16, i50, string17, string18, z11, z12, i51, cursorC.isNull(iE50) ? null : cursorC.getString(iE50), cursorC.isNull(iE51) ? null : Integer.valueOf(cursorC.getInt(iE51)), cursorC.isNull(iE52) ? null : cursorC.getString(iE52), cursorC.isNull(iE53) ? null : cursorC.getString(iE53), cursorC.isNull(iE54) ? null : cursorC.getString(iE54), cursorC.isNull(iE55) ? null : cursorC.getString(iE55), cursorC.isNull(iE56) ? null : cursorC.getString(iE56), cursorC.isNull(iE57) ? null : cursorC.getString(iE57), cursorC.isNull(iE58) ? null : Integer.valueOf(cursorC.getInt(iE58)), cursorC.isNull(iE59) ? null : cursorC.getString(iE59), cursorC.isNull(iE60) ? null : cursorC.getString(iE60), cursorC.isNull(iE61) ? null : Long.valueOf(cursorC.getLong(iE61)), cursorC.isNull(iE62) ? null : Long.valueOf(cursorC.getLong(iE62))));
                        iE = i16;
                        i11 = i14;
                    }
                    cursorC.close();
                    this.f77339a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    n0Var = this;
                    cursorC.close();
                    n0Var.f77339a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                n0Var = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class o implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f77341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f77342b;

        public o(String str, String str2) {
            this.f77341a = str;
            this.f77342b = str2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            g6.k kVarB = d.this.f77281k.b();
            String str = this.f77341a;
            if (str == null) {
                kVarB.m0(1);
            } else {
                kVarB.s(1, str);
            }
            String str2 = this.f77342b;
            if (str2 == null) {
                kVarB.m0(2);
            } else {
                kVarB.s(2, str2);
            }
            d.this.f77271a.e();
            try {
                kVarB.F();
                d.this.f77271a.E();
                return Unit.f68710a;
            } finally {
                d.this.f77271a.i();
                d.this.f77281k.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class o0 extends SharedSQLiteStatement {
        public o0(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE DOWNLOAD_TABLE SET duration = ? WHERE resourceId = ? ";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class p implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f77345a;

        public p(String str) {
            this.f77345a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            g6.k kVarB = d.this.f77283m.b();
            String str = this.f77345a;
            if (str == null) {
                kVarB.m0(1);
            } else {
                kVarB.s(1, str);
            }
            d.this.f77271a.e();
            try {
                kVarB.F();
                d.this.f77271a.E();
                return Unit.f68710a;
            } finally {
                d.this.f77271a.i();
                d.this.f77283m.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class p0 extends SharedSQLiteStatement {
        public p0(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE DOWNLOAD_TABLE SET isClosedTransferFailed = ? WHERE resourceId = ? ";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class q implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f77348a;

        public q(String str) {
            this.f77348a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            g6.k kVarB = d.this.f77284n.b();
            String str = this.f77348a;
            if (str == null) {
                kVarB.m0(1);
            } else {
                kVarB.s(1, str);
            }
            d.this.f77271a.e();
            try {
                kVarB.F();
                d.this.f77271a.E();
                return Unit.f68710a;
            } finally {
                d.this.f77271a.i();
                d.this.f77284n.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class q0 extends SharedSQLiteStatement {
        public q0(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE DOWNLOAD_TABLE SET videoWidth = ? AND videoHeight = ? WHERE resourceId = ? ";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class r extends androidx.room.h<DownloadBean> {
        public r(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM `download_table` WHERE `url` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, DownloadBean downloadBean) {
            if (downloadBean.getUrl() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, downloadBean.getUrl());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class r0 extends SharedSQLiteStatement {
        public r0(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE DOWNLOAD_TABLE SET readProgress = ? WHERE resourceId = ? ";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class s implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f77353a;

        public s(String str) {
            this.f77353a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            g6.k kVarB = d.this.f77285o.b();
            String str = this.f77353a;
            if (str == null) {
                kVarB.m0(1);
            } else {
                kVarB.s(1, str);
            }
            d.this.f77271a.e();
            try {
                kVarB.F();
                d.this.f77271a.E();
                return Unit.f68710a;
            } finally {
                d.this.f77271a.i();
                d.this.f77285o.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class s0 extends SharedSQLiteStatement {
        public s0(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE DOWNLOAD_TABLE SET lastPlayTimeStamp = ? WHERE resourceId = ? ";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class t implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f77356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f77357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f77358c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f77359d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Integer f77360f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f77361g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f77362h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f77363i;

        public t(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7) {
            this.f77356a = str;
            this.f77357b = str2;
            this.f77358c = str3;
            this.f77359d = str4;
            this.f77360f = num;
            this.f77361g = str5;
            this.f77362h = str6;
            this.f77363i = str7;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            g6.k kVarB = d.this.f77286p.b();
            String str = this.f77356a;
            if (str == null) {
                kVarB.m0(1);
            } else {
                kVarB.s(1, str);
            }
            String str2 = this.f77357b;
            if (str2 == null) {
                kVarB.m0(2);
            } else {
                kVarB.s(2, str2);
            }
            String str3 = this.f77358c;
            if (str3 == null) {
                kVarB.m0(3);
            } else {
                kVarB.s(3, str3);
            }
            String str4 = this.f77359d;
            if (str4 == null) {
                kVarB.m0(4);
            } else {
                kVarB.s(4, str4);
            }
            Integer num = this.f77360f;
            if (num == null) {
                kVarB.m0(5);
            } else {
                kVarB.V(5, num.intValue());
            }
            String str5 = this.f77361g;
            if (str5 == null) {
                kVarB.m0(6);
            } else {
                kVarB.s(6, str5);
            }
            String str6 = this.f77362h;
            if (str6 == null) {
                kVarB.m0(7);
            } else {
                kVarB.s(7, str6);
            }
            String str7 = this.f77363i;
            if (str7 == null) {
                kVarB.m0(8);
            } else {
                kVarB.s(8, str7);
            }
            d.this.f77271a.e();
            try {
                kVarB.F();
                d.this.f77271a.E();
                return Unit.f68710a;
            } finally {
                d.this.f77271a.i();
                d.this.f77286p.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class u implements Callable<DownloadBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.v f77365a;

        public u(androidx.room.v vVar) {
            this.f77365a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadBean call() throws Exception {
            DownloadBean downloadBean;
            u uVar = this;
            Cursor cursorC = e6.b.c(d.this.f77271a, uVar.f77365a, false, null);
            try {
                int iE = e6.a.e(cursorC, "url");
                int iE2 = e6.a.e(cursorC, "resourceId");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "cover");
                int iE5 = e6.a.e(cursorC, "size");
                int iE6 = e6.a.e(cursorC, "postId");
                int iE7 = e6.a.e(cursorC, "sizeFormat");
                int iE8 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE9 = e6.a.e(cursorC, "duration");
                int iE10 = e6.a.e(cursorC, "updateTimeStamp");
                int iE11 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE12 = e6.a.e(cursorC, "supportRanges");
                int iE13 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE14 = e6.a.e(cursorC, "type");
                try {
                    int iE15 = e6.a.e(cursorC, "readProgress");
                    int iE16 = e6.a.e(cursorC, "createAt");
                    int iE17 = e6.a.e(cursorC, "isRead");
                    int iE18 = e6.a.e(cursorC, "episode");
                    int iE19 = e6.a.e(cursorC, "ep");
                    int iE20 = e6.a.e(cursorC, "se");
                    int iE21 = e6.a.e(cursorC, "resolution");
                    int iE22 = e6.a.e(cursorC, "resourcePosition");
                    int iE23 = e6.a.e(cursorC, "multiresolution");
                    int iE24 = e6.a.e(cursorC, "videoWidth");
                    int iE25 = e6.a.e(cursorC, "videoHeight");
                    int iE26 = e6.a.e(cursorC, "downloadErrorCount");
                    int iE27 = e6.a.e(cursorC, "subtitleStarted");
                    int iE28 = e6.a.e(cursorC, "subjectId");
                    int iE29 = e6.a.e(cursorC, "pageFrom");
                    int iE30 = e6.a.e(cursorC, "lastPageFrom");
                    int iE31 = e6.a.e(cursorC, "subjectName");
                    int iE32 = e6.a.e(cursorC, "lastPlayTimeStamp");
                    int iE33 = e6.a.e(cursorC, "fileType");
                    int iE34 = e6.a.e(cursorC, "totalEpisode");
                    int iE35 = e6.a.e(cursorC, "uploadBy");
                    int iE36 = e6.a.e(cursorC, "sourceUrl");
                    int iE37 = e6.a.e(cursorC, "urlCreateAt");
                    int iE38 = e6.a.e(cursorC, "subtitleSelectId");
                    int iE39 = e6.a.e(cursorC, "taskId");
                    int iE40 = e6.a.e(cursorC, "sessionTime");
                    int iE41 = e6.a.e(cursorC, "reportStatus");
                    int iE42 = e6.a.e(cursorC, "downloadHeaderSize");
                    int iE43 = e6.a.e(cursorC, "rootPath");
                    int iE44 = e6.a.e(cursorC, "rootPathType");
                    int iE45 = e6.a.e(cursorC, "thumbnail");
                    int iE46 = e6.a.e(cursorC, "averageHueLight");
                    int iE47 = e6.a.e(cursorC, "isTransferFailed");
                    int iE48 = e6.a.e(cursorC, "isClosedTransferFailed");
                    int iE49 = e6.a.e(cursorC, "subjectType");
                    int iE50 = e6.a.e(cursorC, "genre");
                    int iE51 = e6.a.e(cursorC, "subjectDurationSeconds");
                    int iE52 = e6.a.e(cursorC, "currentDubLanName");
                    int iE53 = e6.a.e(cursorC, "currentDubLanCode");
                    int iE54 = e6.a.e(cursorC, "ops");
                    int iE55 = e6.a.e(cursorC, "restrictLevel");
                    int iE56 = e6.a.e(cursorC, "releaseDate");
                    int iE57 = e6.a.e(cursorC, "countryName");
                    int iE58 = e6.a.e(cursorC, "seNum");
                    int iE59 = e6.a.e(cursorC, "subtitles");
                    int iE60 = e6.a.e(cursorC, "imdbRate");
                    int iE61 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE62 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    if (cursorC.moveToFirst()) {
                        downloadBean = new DownloadBean(cursorC.isNull(iE) ? null : cursorC.getString(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : Long.valueOf(cursorC.getLong(iE5)), cursorC.isNull(iE6) ? null : cursorC.getString(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : cursorC.getString(iE8), cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9)), cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10)), cursorC.getLong(iE11), cursorC.getInt(iE12), cursorC.getInt(iE13), cursorC.getInt(iE14), cursorC.getLong(iE15), cursorC.getLong(iE16), cursorC.getInt(iE17), cursorC.getInt(iE18), cursorC.getInt(iE19), cursorC.getInt(iE20), cursorC.getInt(iE21), cursorC.getInt(iE22), cursorC.getInt(iE23), cursorC.getInt(iE24), cursorC.getInt(iE25), cursorC.getInt(iE26), cursorC.getInt(iE27), cursorC.isNull(iE28) ? null : cursorC.getString(iE28), cursorC.isNull(r30) ? null : cursorC.getString(iE29), cursorC.isNull(r31) ? null : cursorC.getString(iE30), cursorC.isNull(r32) ? null : cursorC.getString(iE31), cursorC.getLong(iE32), cursorC.getInt(iE33), cursorC.getInt(iE34), cursorC.isNull(iE35) ? null : cursorC.getString(iE35), cursorC.isNull(r37) ? null : cursorC.getString(iE36), cursorC.getLong(iE37), cursorC.isNull(iE38) ? null : cursorC.getString(iE38), cursorC.isNull(r40) ? null : cursorC.getString(iE39), cursorC.getLong(iE40), cursorC.getInt(iE41), cursorC.getLong(iE42), cursorC.isNull(iE43) ? null : cursorC.getString(iE43), cursorC.getInt(iE44), cursorC.isNull(iE45) ? null : cursorC.getString(iE45), cursorC.isNull(r47) ? null : cursorC.getString(iE46), cursorC.getInt(iE47) != 0, cursorC.getInt(iE48) != 0, cursorC.getInt(iE49), cursorC.isNull(iE50) ? null : cursorC.getString(iE50), cursorC.isNull(r52) ? null : Integer.valueOf(cursorC.getInt(iE51)), cursorC.isNull(r53) ? null : cursorC.getString(iE52), cursorC.isNull(r54) ? null : cursorC.getString(iE53), cursorC.isNull(r55) ? null : cursorC.getString(iE54), cursorC.isNull(r56) ? null : cursorC.getString(iE55), cursorC.isNull(r57) ? null : cursorC.getString(iE56), cursorC.isNull(r58) ? null : cursorC.getString(iE57), cursorC.isNull(r59) ? null : Integer.valueOf(cursorC.getInt(iE58)), cursorC.isNull(r60) ? null : cursorC.getString(iE59), cursorC.isNull(r61) ? null : cursorC.getString(iE60), cursorC.isNull(r62) ? null : Long.valueOf(cursorC.getLong(iE61)), cursorC.isNull(iE62) ? null : Long.valueOf(cursorC.getLong(iE62)));
                    } else {
                        downloadBean = null;
                    }
                    cursorC.close();
                    this.f77365a.release();
                    return downloadBean;
                } catch (Throwable th2) {
                    th = th2;
                    uVar = this;
                    cursorC.close();
                    uVar.f77365a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class v implements Callable<DownloadBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.v f77367a;

        public v(androidx.room.v vVar) {
            this.f77367a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadBean call() throws Exception {
            DownloadBean downloadBean;
            v vVar = this;
            Cursor cursorC = e6.b.c(d.this.f77271a, vVar.f77367a, false, null);
            try {
                int iE = e6.a.e(cursorC, "url");
                int iE2 = e6.a.e(cursorC, "resourceId");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "cover");
                int iE5 = e6.a.e(cursorC, "size");
                int iE6 = e6.a.e(cursorC, "postId");
                int iE7 = e6.a.e(cursorC, "sizeFormat");
                int iE8 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE9 = e6.a.e(cursorC, "duration");
                int iE10 = e6.a.e(cursorC, "updateTimeStamp");
                int iE11 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE12 = e6.a.e(cursorC, "supportRanges");
                int iE13 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE14 = e6.a.e(cursorC, "type");
                try {
                    int iE15 = e6.a.e(cursorC, "readProgress");
                    int iE16 = e6.a.e(cursorC, "createAt");
                    int iE17 = e6.a.e(cursorC, "isRead");
                    int iE18 = e6.a.e(cursorC, "episode");
                    int iE19 = e6.a.e(cursorC, "ep");
                    int iE20 = e6.a.e(cursorC, "se");
                    int iE21 = e6.a.e(cursorC, "resolution");
                    int iE22 = e6.a.e(cursorC, "resourcePosition");
                    int iE23 = e6.a.e(cursorC, "multiresolution");
                    int iE24 = e6.a.e(cursorC, "videoWidth");
                    int iE25 = e6.a.e(cursorC, "videoHeight");
                    int iE26 = e6.a.e(cursorC, "downloadErrorCount");
                    int iE27 = e6.a.e(cursorC, "subtitleStarted");
                    int iE28 = e6.a.e(cursorC, "subjectId");
                    int iE29 = e6.a.e(cursorC, "pageFrom");
                    int iE30 = e6.a.e(cursorC, "lastPageFrom");
                    int iE31 = e6.a.e(cursorC, "subjectName");
                    int iE32 = e6.a.e(cursorC, "lastPlayTimeStamp");
                    int iE33 = e6.a.e(cursorC, "fileType");
                    int iE34 = e6.a.e(cursorC, "totalEpisode");
                    int iE35 = e6.a.e(cursorC, "uploadBy");
                    int iE36 = e6.a.e(cursorC, "sourceUrl");
                    int iE37 = e6.a.e(cursorC, "urlCreateAt");
                    int iE38 = e6.a.e(cursorC, "subtitleSelectId");
                    int iE39 = e6.a.e(cursorC, "taskId");
                    int iE40 = e6.a.e(cursorC, "sessionTime");
                    int iE41 = e6.a.e(cursorC, "reportStatus");
                    int iE42 = e6.a.e(cursorC, "downloadHeaderSize");
                    int iE43 = e6.a.e(cursorC, "rootPath");
                    int iE44 = e6.a.e(cursorC, "rootPathType");
                    int iE45 = e6.a.e(cursorC, "thumbnail");
                    int iE46 = e6.a.e(cursorC, "averageHueLight");
                    int iE47 = e6.a.e(cursorC, "isTransferFailed");
                    int iE48 = e6.a.e(cursorC, "isClosedTransferFailed");
                    int iE49 = e6.a.e(cursorC, "subjectType");
                    int iE50 = e6.a.e(cursorC, "genre");
                    int iE51 = e6.a.e(cursorC, "subjectDurationSeconds");
                    int iE52 = e6.a.e(cursorC, "currentDubLanName");
                    int iE53 = e6.a.e(cursorC, "currentDubLanCode");
                    int iE54 = e6.a.e(cursorC, "ops");
                    int iE55 = e6.a.e(cursorC, "restrictLevel");
                    int iE56 = e6.a.e(cursorC, "releaseDate");
                    int iE57 = e6.a.e(cursorC, "countryName");
                    int iE58 = e6.a.e(cursorC, "seNum");
                    int iE59 = e6.a.e(cursorC, "subtitles");
                    int iE60 = e6.a.e(cursorC, "imdbRate");
                    int iE61 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE62 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    if (cursorC.moveToFirst()) {
                        downloadBean = new DownloadBean(cursorC.isNull(iE) ? null : cursorC.getString(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : Long.valueOf(cursorC.getLong(iE5)), cursorC.isNull(iE6) ? null : cursorC.getString(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : cursorC.getString(iE8), cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9)), cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10)), cursorC.getLong(iE11), cursorC.getInt(iE12), cursorC.getInt(iE13), cursorC.getInt(iE14), cursorC.getLong(iE15), cursorC.getLong(iE16), cursorC.getInt(iE17), cursorC.getInt(iE18), cursorC.getInt(iE19), cursorC.getInt(iE20), cursorC.getInt(iE21), cursorC.getInt(iE22), cursorC.getInt(iE23), cursorC.getInt(iE24), cursorC.getInt(iE25), cursorC.getInt(iE26), cursorC.getInt(iE27), cursorC.isNull(iE28) ? null : cursorC.getString(iE28), cursorC.isNull(r30) ? null : cursorC.getString(iE29), cursorC.isNull(r31) ? null : cursorC.getString(iE30), cursorC.isNull(r32) ? null : cursorC.getString(iE31), cursorC.getLong(iE32), cursorC.getInt(iE33), cursorC.getInt(iE34), cursorC.isNull(iE35) ? null : cursorC.getString(iE35), cursorC.isNull(r37) ? null : cursorC.getString(iE36), cursorC.getLong(iE37), cursorC.isNull(iE38) ? null : cursorC.getString(iE38), cursorC.isNull(r40) ? null : cursorC.getString(iE39), cursorC.getLong(iE40), cursorC.getInt(iE41), cursorC.getLong(iE42), cursorC.isNull(iE43) ? null : cursorC.getString(iE43), cursorC.getInt(iE44), cursorC.isNull(iE45) ? null : cursorC.getString(iE45), cursorC.isNull(r47) ? null : cursorC.getString(iE46), cursorC.getInt(iE47) != 0, cursorC.getInt(iE48) != 0, cursorC.getInt(iE49), cursorC.isNull(iE50) ? null : cursorC.getString(iE50), cursorC.isNull(r52) ? null : Integer.valueOf(cursorC.getInt(iE51)), cursorC.isNull(r53) ? null : cursorC.getString(iE52), cursorC.isNull(r54) ? null : cursorC.getString(iE53), cursorC.isNull(r55) ? null : cursorC.getString(iE54), cursorC.isNull(r56) ? null : cursorC.getString(iE55), cursorC.isNull(r57) ? null : cursorC.getString(iE56), cursorC.isNull(r58) ? null : cursorC.getString(iE57), cursorC.isNull(r59) ? null : Integer.valueOf(cursorC.getInt(iE58)), cursorC.isNull(r60) ? null : cursorC.getString(iE59), cursorC.isNull(r61) ? null : cursorC.getString(iE60), cursorC.isNull(r62) ? null : Long.valueOf(cursorC.getLong(iE61)), cursorC.isNull(iE62) ? null : Long.valueOf(cursorC.getLong(iE62)));
                    } else {
                        downloadBean = null;
                    }
                    cursorC.close();
                    this.f77367a.release();
                    return downloadBean;
                } catch (Throwable th2) {
                    th = th2;
                    vVar = this;
                    cursorC.close();
                    vVar.f77367a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class w extends androidx.room.h<DownloadBean> {
        public w(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE OR ABORT `download_table` SET `url` = ?,`resourceId` = ?,`name` = ?,`cover` = ?,`size` = ?,`postId` = ?,`sizeFormat` = ?,`path` = ?,`duration` = ?,`updateTimeStamp` = ?,`progress` = ?,`supportRanges` = ?,`status` = ?,`type` = ?,`readProgress` = ?,`createAt` = ?,`isRead` = ?,`episode` = ?,`ep` = ?,`se` = ?,`resolution` = ?,`resourcePosition` = ?,`multiresolution` = ?,`videoWidth` = ?,`videoHeight` = ?,`downloadErrorCount` = ?,`subtitleStarted` = ?,`subjectId` = ?,`pageFrom` = ?,`lastPageFrom` = ?,`subjectName` = ?,`lastPlayTimeStamp` = ?,`fileType` = ?,`totalEpisode` = ?,`uploadBy` = ?,`sourceUrl` = ?,`urlCreateAt` = ?,`subtitleSelectId` = ?,`taskId` = ?,`sessionTime` = ?,`reportStatus` = ?,`downloadHeaderSize` = ?,`rootPath` = ?,`rootPathType` = ?,`thumbnail` = ?,`averageHueLight` = ?,`isTransferFailed` = ?,`isClosedTransferFailed` = ?,`subjectType` = ?,`genre` = ?,`subjectDurationSeconds` = ?,`currentDubLanName` = ?,`currentDubLanCode` = ?,`ops` = ?,`restrictLevel` = ?,`releaseDate` = ?,`countryName` = ?,`seNum` = ?,`subtitles` = ?,`imdbRate` = ?,`lastAdStartTimeStamp` = ?,`lastAdEndTimeStamp` = ? WHERE `url` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, DownloadBean downloadBean) {
            if (downloadBean.getUrl() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, downloadBean.getUrl());
            }
            if (downloadBean.getResourceId() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, downloadBean.getResourceId());
            }
            if (downloadBean.getName() == null) {
                kVar.m0(3);
            } else {
                kVar.s(3, downloadBean.getName());
            }
            if (downloadBean.getCover() == null) {
                kVar.m0(4);
            } else {
                kVar.s(4, downloadBean.getCover());
            }
            if (downloadBean.getSize() == null) {
                kVar.m0(5);
            } else {
                kVar.V(5, downloadBean.getSize().longValue());
            }
            if (downloadBean.getPostId() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, downloadBean.getPostId());
            }
            if (downloadBean.getSizeFormat() == null) {
                kVar.m0(7);
            } else {
                kVar.s(7, downloadBean.getSizeFormat());
            }
            if (downloadBean.getPath() == null) {
                kVar.m0(8);
            } else {
                kVar.s(8, downloadBean.getPath());
            }
            if (downloadBean.getDuration() == null) {
                kVar.m0(9);
            } else {
                kVar.V(9, downloadBean.getDuration().longValue());
            }
            if (downloadBean.getUpdateTimeStamp() == null) {
                kVar.m0(10);
            } else {
                kVar.V(10, downloadBean.getUpdateTimeStamp().longValue());
            }
            kVar.V(11, downloadBean.getProgress());
            kVar.V(12, downloadBean.getSupportRanges());
            kVar.V(13, downloadBean.getStatus());
            kVar.V(14, downloadBean.getType());
            kVar.V(15, downloadBean.getReadProgress());
            kVar.V(16, downloadBean.getCreateAt());
            kVar.V(17, downloadBean.isRead());
            kVar.V(18, downloadBean.getEpse());
            kVar.V(19, downloadBean.getEp());
            kVar.V(20, downloadBean.getSe());
            kVar.V(21, downloadBean.getResolution());
            kVar.V(22, downloadBean.getResourcePosition());
            kVar.V(23, downloadBean.getMultiresolution());
            kVar.V(24, downloadBean.getVideoWidth());
            kVar.V(25, downloadBean.getVideoHeight());
            kVar.V(26, downloadBean.getDownloadErrorCount());
            kVar.V(27, downloadBean.getSubtitleStarted());
            if (downloadBean.getSubjectId() == null) {
                kVar.m0(28);
            } else {
                kVar.s(28, downloadBean.getSubjectId());
            }
            if (downloadBean.getPageFrom() == null) {
                kVar.m0(29);
            } else {
                kVar.s(29, downloadBean.getPageFrom());
            }
            if (downloadBean.getLastPageFrom() == null) {
                kVar.m0(30);
            } else {
                kVar.s(30, downloadBean.getLastPageFrom());
            }
            if (downloadBean.getSubjectName() == null) {
                kVar.m0(31);
            } else {
                kVar.s(31, downloadBean.getSubjectName());
            }
            kVar.V(32, downloadBean.getLastPlayTimeStamp());
            kVar.V(33, downloadBean.getFileType());
            kVar.V(34, downloadBean.getTotalEpisode());
            if (downloadBean.getUploadBy() == null) {
                kVar.m0(35);
            } else {
                kVar.s(35, downloadBean.getUploadBy());
            }
            if (downloadBean.getSourceUrl() == null) {
                kVar.m0(36);
            } else {
                kVar.s(36, downloadBean.getSourceUrl());
            }
            kVar.V(37, downloadBean.getUrlCreateAt());
            if (downloadBean.getSubtitleSelectId() == null) {
                kVar.m0(38);
            } else {
                kVar.s(38, downloadBean.getSubtitleSelectId());
            }
            if (downloadBean.getTaskId() == null) {
                kVar.m0(39);
            } else {
                kVar.s(39, downloadBean.getTaskId());
            }
            kVar.V(40, downloadBean.getSessionTime());
            kVar.V(41, downloadBean.getReportStatus());
            kVar.V(42, downloadBean.getDownloadHeaderSize());
            if (downloadBean.getRootPath() == null) {
                kVar.m0(43);
            } else {
                kVar.s(43, downloadBean.getRootPath());
            }
            kVar.V(44, downloadBean.getRootPathType());
            if (downloadBean.getThumbnail() == null) {
                kVar.m0(45);
            } else {
                kVar.s(45, downloadBean.getThumbnail());
            }
            if (downloadBean.getAverageHueLight() == null) {
                kVar.m0(46);
            } else {
                kVar.s(46, downloadBean.getAverageHueLight());
            }
            kVar.V(47, downloadBean.isTransferFailed() ? 1L : 0L);
            kVar.V(48, downloadBean.isClosedTransferFailed() ? 1L : 0L);
            kVar.V(49, downloadBean.getSubjectType());
            if (downloadBean.getGenre() == null) {
                kVar.m0(50);
            } else {
                kVar.s(50, downloadBean.getGenre());
            }
            if (downloadBean.getSubjectDurationSeconds() == null) {
                kVar.m0(51);
            } else {
                kVar.V(51, downloadBean.getSubjectDurationSeconds().intValue());
            }
            if (downloadBean.getCurrentDubLanName() == null) {
                kVar.m0(52);
            } else {
                kVar.s(52, downloadBean.getCurrentDubLanName());
            }
            if (downloadBean.getCurrentDubLanCode() == null) {
                kVar.m0(53);
            } else {
                kVar.s(53, downloadBean.getCurrentDubLanCode());
            }
            if (downloadBean.getOps() == null) {
                kVar.m0(54);
            } else {
                kVar.s(54, downloadBean.getOps());
            }
            if (downloadBean.getRestrictLevel() == null) {
                kVar.m0(55);
            } else {
                kVar.s(55, downloadBean.getRestrictLevel());
            }
            if (downloadBean.getReleaseDate() == null) {
                kVar.m0(56);
            } else {
                kVar.s(56, downloadBean.getReleaseDate());
            }
            if (downloadBean.getCountryName() == null) {
                kVar.m0(57);
            } else {
                kVar.s(57, downloadBean.getCountryName());
            }
            if (downloadBean.getSeNum() == null) {
                kVar.m0(58);
            } else {
                kVar.V(58, downloadBean.getSeNum().intValue());
            }
            if (downloadBean.getSubtitles() == null) {
                kVar.m0(59);
            } else {
                kVar.s(59, downloadBean.getSubtitles());
            }
            if (downloadBean.getImdbRate() == null) {
                kVar.m0(60);
            } else {
                kVar.s(60, downloadBean.getImdbRate());
            }
            if (downloadBean.getLastAdStartTimeStamp() == null) {
                kVar.m0(61);
            } else {
                kVar.V(61, downloadBean.getLastAdStartTimeStamp().longValue());
            }
            if (downloadBean.getLastAdEndTimeStamp() == null) {
                kVar.m0(62);
            } else {
                kVar.V(62, downloadBean.getLastAdEndTimeStamp().longValue());
            }
            if (downloadBean.getUrl() == null) {
                kVar.m0(63);
            } else {
                kVar.s(63, downloadBean.getUrl());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class x implements Callable<DownloadBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.v f77370a;

        public x(androidx.room.v vVar) {
            this.f77370a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadBean call() throws Exception {
            DownloadBean downloadBean;
            x xVar = this;
            Cursor cursorC = e6.b.c(d.this.f77271a, xVar.f77370a, false, null);
            try {
                int iE = e6.a.e(cursorC, "url");
                int iE2 = e6.a.e(cursorC, "resourceId");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "cover");
                int iE5 = e6.a.e(cursorC, "size");
                int iE6 = e6.a.e(cursorC, "postId");
                int iE7 = e6.a.e(cursorC, "sizeFormat");
                int iE8 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE9 = e6.a.e(cursorC, "duration");
                int iE10 = e6.a.e(cursorC, "updateTimeStamp");
                int iE11 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE12 = e6.a.e(cursorC, "supportRanges");
                int iE13 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE14 = e6.a.e(cursorC, "type");
                try {
                    int iE15 = e6.a.e(cursorC, "readProgress");
                    int iE16 = e6.a.e(cursorC, "createAt");
                    int iE17 = e6.a.e(cursorC, "isRead");
                    int iE18 = e6.a.e(cursorC, "episode");
                    int iE19 = e6.a.e(cursorC, "ep");
                    int iE20 = e6.a.e(cursorC, "se");
                    int iE21 = e6.a.e(cursorC, "resolution");
                    int iE22 = e6.a.e(cursorC, "resourcePosition");
                    int iE23 = e6.a.e(cursorC, "multiresolution");
                    int iE24 = e6.a.e(cursorC, "videoWidth");
                    int iE25 = e6.a.e(cursorC, "videoHeight");
                    int iE26 = e6.a.e(cursorC, "downloadErrorCount");
                    int iE27 = e6.a.e(cursorC, "subtitleStarted");
                    int iE28 = e6.a.e(cursorC, "subjectId");
                    int iE29 = e6.a.e(cursorC, "pageFrom");
                    int iE30 = e6.a.e(cursorC, "lastPageFrom");
                    int iE31 = e6.a.e(cursorC, "subjectName");
                    int iE32 = e6.a.e(cursorC, "lastPlayTimeStamp");
                    int iE33 = e6.a.e(cursorC, "fileType");
                    int iE34 = e6.a.e(cursorC, "totalEpisode");
                    int iE35 = e6.a.e(cursorC, "uploadBy");
                    int iE36 = e6.a.e(cursorC, "sourceUrl");
                    int iE37 = e6.a.e(cursorC, "urlCreateAt");
                    int iE38 = e6.a.e(cursorC, "subtitleSelectId");
                    int iE39 = e6.a.e(cursorC, "taskId");
                    int iE40 = e6.a.e(cursorC, "sessionTime");
                    int iE41 = e6.a.e(cursorC, "reportStatus");
                    int iE42 = e6.a.e(cursorC, "downloadHeaderSize");
                    int iE43 = e6.a.e(cursorC, "rootPath");
                    int iE44 = e6.a.e(cursorC, "rootPathType");
                    int iE45 = e6.a.e(cursorC, "thumbnail");
                    int iE46 = e6.a.e(cursorC, "averageHueLight");
                    int iE47 = e6.a.e(cursorC, "isTransferFailed");
                    int iE48 = e6.a.e(cursorC, "isClosedTransferFailed");
                    int iE49 = e6.a.e(cursorC, "subjectType");
                    int iE50 = e6.a.e(cursorC, "genre");
                    int iE51 = e6.a.e(cursorC, "subjectDurationSeconds");
                    int iE52 = e6.a.e(cursorC, "currentDubLanName");
                    int iE53 = e6.a.e(cursorC, "currentDubLanCode");
                    int iE54 = e6.a.e(cursorC, "ops");
                    int iE55 = e6.a.e(cursorC, "restrictLevel");
                    int iE56 = e6.a.e(cursorC, "releaseDate");
                    int iE57 = e6.a.e(cursorC, "countryName");
                    int iE58 = e6.a.e(cursorC, "seNum");
                    int iE59 = e6.a.e(cursorC, "subtitles");
                    int iE60 = e6.a.e(cursorC, "imdbRate");
                    int iE61 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE62 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    if (cursorC.moveToFirst()) {
                        downloadBean = new DownloadBean(cursorC.isNull(iE) ? null : cursorC.getString(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : cursorC.getString(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : Long.valueOf(cursorC.getLong(iE5)), cursorC.isNull(iE6) ? null : cursorC.getString(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : cursorC.getString(iE8), cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9)), cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10)), cursorC.getLong(iE11), cursorC.getInt(iE12), cursorC.getInt(iE13), cursorC.getInt(iE14), cursorC.getLong(iE15), cursorC.getLong(iE16), cursorC.getInt(iE17), cursorC.getInt(iE18), cursorC.getInt(iE19), cursorC.getInt(iE20), cursorC.getInt(iE21), cursorC.getInt(iE22), cursorC.getInt(iE23), cursorC.getInt(iE24), cursorC.getInt(iE25), cursorC.getInt(iE26), cursorC.getInt(iE27), cursorC.isNull(iE28) ? null : cursorC.getString(iE28), cursorC.isNull(r30) ? null : cursorC.getString(iE29), cursorC.isNull(r31) ? null : cursorC.getString(iE30), cursorC.isNull(r32) ? null : cursorC.getString(iE31), cursorC.getLong(iE32), cursorC.getInt(iE33), cursorC.getInt(iE34), cursorC.isNull(iE35) ? null : cursorC.getString(iE35), cursorC.isNull(r37) ? null : cursorC.getString(iE36), cursorC.getLong(iE37), cursorC.isNull(iE38) ? null : cursorC.getString(iE38), cursorC.isNull(r40) ? null : cursorC.getString(iE39), cursorC.getLong(iE40), cursorC.getInt(iE41), cursorC.getLong(iE42), cursorC.isNull(iE43) ? null : cursorC.getString(iE43), cursorC.getInt(iE44), cursorC.isNull(iE45) ? null : cursorC.getString(iE45), cursorC.isNull(r47) ? null : cursorC.getString(iE46), cursorC.getInt(iE47) != 0, cursorC.getInt(iE48) != 0, cursorC.getInt(iE49), cursorC.isNull(iE50) ? null : cursorC.getString(iE50), cursorC.isNull(r52) ? null : Integer.valueOf(cursorC.getInt(iE51)), cursorC.isNull(r53) ? null : cursorC.getString(iE52), cursorC.isNull(r54) ? null : cursorC.getString(iE53), cursorC.isNull(r55) ? null : cursorC.getString(iE54), cursorC.isNull(r56) ? null : cursorC.getString(iE55), cursorC.isNull(r57) ? null : cursorC.getString(iE56), cursorC.isNull(r58) ? null : cursorC.getString(iE57), cursorC.isNull(r59) ? null : Integer.valueOf(cursorC.getInt(iE58)), cursorC.isNull(r60) ? null : cursorC.getString(iE59), cursorC.isNull(r61) ? null : cursorC.getString(iE60), cursorC.isNull(r62) ? null : Long.valueOf(cursorC.getLong(iE61)), cursorC.isNull(iE62) ? null : Long.valueOf(cursorC.getLong(iE62)));
                    } else {
                        downloadBean = null;
                    }
                    cursorC.close();
                    this.f77370a.release();
                    return downloadBean;
                } catch (Throwable th2) {
                    th = th2;
                    xVar = this;
                    cursorC.close();
                    xVar.f77370a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class y implements Callable<List<? extends DownloadBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.v f77372a;

        public y(androidx.room.v vVar) {
            this.f77372a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<? extends DownloadBean> call() throws Exception {
            y yVar;
            Cursor cursorC = e6.b.c(d.this.f77271a, this.f77372a, false, null);
            try {
                int iE = e6.a.e(cursorC, "url");
                int iE2 = e6.a.e(cursorC, "resourceId");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "cover");
                int iE5 = e6.a.e(cursorC, "size");
                int iE6 = e6.a.e(cursorC, "postId");
                int iE7 = e6.a.e(cursorC, "sizeFormat");
                int iE8 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE9 = e6.a.e(cursorC, "duration");
                int iE10 = e6.a.e(cursorC, "updateTimeStamp");
                int iE11 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE12 = e6.a.e(cursorC, "supportRanges");
                int iE13 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE14 = e6.a.e(cursorC, "type");
                try {
                    int iE15 = e6.a.e(cursorC, "readProgress");
                    int iE16 = e6.a.e(cursorC, "createAt");
                    int iE17 = e6.a.e(cursorC, "isRead");
                    int iE18 = e6.a.e(cursorC, "episode");
                    int iE19 = e6.a.e(cursorC, "ep");
                    int iE20 = e6.a.e(cursorC, "se");
                    int iE21 = e6.a.e(cursorC, "resolution");
                    int iE22 = e6.a.e(cursorC, "resourcePosition");
                    int iE23 = e6.a.e(cursorC, "multiresolution");
                    int iE24 = e6.a.e(cursorC, "videoWidth");
                    int iE25 = e6.a.e(cursorC, "videoHeight");
                    int iE26 = e6.a.e(cursorC, "downloadErrorCount");
                    int iE27 = e6.a.e(cursorC, "subtitleStarted");
                    int iE28 = e6.a.e(cursorC, "subjectId");
                    int iE29 = e6.a.e(cursorC, "pageFrom");
                    int iE30 = e6.a.e(cursorC, "lastPageFrom");
                    int iE31 = e6.a.e(cursorC, "subjectName");
                    int iE32 = e6.a.e(cursorC, "lastPlayTimeStamp");
                    int iE33 = e6.a.e(cursorC, "fileType");
                    int iE34 = e6.a.e(cursorC, "totalEpisode");
                    int iE35 = e6.a.e(cursorC, "uploadBy");
                    int iE36 = e6.a.e(cursorC, "sourceUrl");
                    int iE37 = e6.a.e(cursorC, "urlCreateAt");
                    int iE38 = e6.a.e(cursorC, "subtitleSelectId");
                    int iE39 = e6.a.e(cursorC, "taskId");
                    int iE40 = e6.a.e(cursorC, "sessionTime");
                    int iE41 = e6.a.e(cursorC, "reportStatus");
                    int iE42 = e6.a.e(cursorC, "downloadHeaderSize");
                    int iE43 = e6.a.e(cursorC, "rootPath");
                    int iE44 = e6.a.e(cursorC, "rootPathType");
                    int iE45 = e6.a.e(cursorC, "thumbnail");
                    int iE46 = e6.a.e(cursorC, "averageHueLight");
                    int iE47 = e6.a.e(cursorC, "isTransferFailed");
                    int iE48 = e6.a.e(cursorC, "isClosedTransferFailed");
                    int iE49 = e6.a.e(cursorC, "subjectType");
                    int iE50 = e6.a.e(cursorC, "genre");
                    int iE51 = e6.a.e(cursorC, "subjectDurationSeconds");
                    int iE52 = e6.a.e(cursorC, "currentDubLanName");
                    int iE53 = e6.a.e(cursorC, "currentDubLanCode");
                    int iE54 = e6.a.e(cursorC, "ops");
                    int iE55 = e6.a.e(cursorC, "restrictLevel");
                    int iE56 = e6.a.e(cursorC, "releaseDate");
                    int iE57 = e6.a.e(cursorC, "countryName");
                    int iE58 = e6.a.e(cursorC, "seNum");
                    int iE59 = e6.a.e(cursorC, "subtitles");
                    int iE60 = e6.a.e(cursorC, "imdbRate");
                    int iE61 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE62 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string3 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string4 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        Long lValueOf = cursorC.isNull(iE5) ? null : Long.valueOf(cursorC.getLong(iE5));
                        String string5 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string6 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string7 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        Long lValueOf2 = cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9));
                        Long lValueOf3 = cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10));
                        long j11 = cursorC.getLong(iE11);
                        int i12 = cursorC.getInt(iE12);
                        int i13 = cursorC.getInt(iE13);
                        int i14 = i11;
                        int i15 = cursorC.getInt(i14);
                        int i16 = iE;
                        int i17 = iE15;
                        long j12 = cursorC.getLong(i17);
                        iE15 = i17;
                        int i18 = iE16;
                        long j13 = cursorC.getLong(i18);
                        iE16 = i18;
                        int i19 = iE17;
                        int i21 = cursorC.getInt(i19);
                        iE17 = i19;
                        int i22 = iE18;
                        int i23 = cursorC.getInt(i22);
                        iE18 = i22;
                        int i24 = iE19;
                        int i25 = cursorC.getInt(i24);
                        iE19 = i24;
                        int i26 = iE20;
                        int i27 = cursorC.getInt(i26);
                        iE20 = i26;
                        int i28 = iE21;
                        int i29 = cursorC.getInt(i28);
                        iE21 = i28;
                        int i31 = iE22;
                        int i32 = cursorC.getInt(i31);
                        iE22 = i31;
                        int i33 = iE23;
                        int i34 = cursorC.getInt(i33);
                        iE23 = i33;
                        int i35 = iE24;
                        int i36 = cursorC.getInt(i35);
                        iE24 = i35;
                        int i37 = iE25;
                        int i38 = cursorC.getInt(i37);
                        iE25 = i37;
                        int i39 = iE26;
                        int i40 = cursorC.getInt(i39);
                        iE26 = i39;
                        int i41 = iE27;
                        int i42 = cursorC.getInt(i41);
                        iE27 = i41;
                        iE28 = iE28;
                        String string8 = cursorC.isNull(iE28) ? null : cursorC.getString(iE28);
                        String string9 = cursorC.isNull(iE29) ? null : cursorC.getString(iE29);
                        String string10 = cursorC.isNull(iE30) ? null : cursorC.getString(iE30);
                        String string11 = cursorC.isNull(iE31) ? null : cursorC.getString(iE31);
                        long j14 = cursorC.getLong(iE32);
                        iE32 = iE32;
                        int i43 = iE33;
                        int i44 = cursorC.getInt(i43);
                        iE33 = i43;
                        int i45 = iE34;
                        int i46 = cursorC.getInt(i45);
                        iE34 = i45;
                        iE35 = iE35;
                        String string12 = cursorC.isNull(iE35) ? null : cursorC.getString(iE35);
                        String string13 = cursorC.isNull(iE36) ? null : cursorC.getString(iE36);
                        long j15 = cursorC.getLong(iE37);
                        iE37 = iE37;
                        iE38 = iE38;
                        String string14 = cursorC.isNull(iE38) ? null : cursorC.getString(iE38);
                        String string15 = cursorC.isNull(iE39) ? null : cursorC.getString(iE39);
                        long j16 = cursorC.getLong(iE40);
                        iE40 = iE40;
                        int i47 = iE41;
                        int i48 = cursorC.getInt(i47);
                        iE41 = i47;
                        int i49 = iE42;
                        long j17 = cursorC.getLong(i49);
                        iE42 = i49;
                        iE43 = iE43;
                        String string16 = cursorC.isNull(iE43) ? null : cursorC.getString(iE43);
                        int i50 = cursorC.getInt(iE44);
                        iE44 = iE44;
                        iE45 = iE45;
                        String string17 = cursorC.isNull(iE45) ? null : cursorC.getString(iE45);
                        String string18 = cursorC.isNull(iE46) ? null : cursorC.getString(iE46);
                        boolean z11 = cursorC.getInt(iE47) != 0;
                        boolean z12 = cursorC.getInt(iE48) != 0;
                        int i51 = cursorC.getInt(iE49);
                        iE49 = iE49;
                        iE50 = iE50;
                        arrayList.add(new DownloadBean(string, string2, string3, string4, lValueOf, string5, string6, string7, lValueOf2, lValueOf3, j11, i12, i13, i15, j12, j13, i21, i23, i25, i27, i29, i32, i34, i36, i38, i40, i42, string8, string9, string10, string11, j14, i44, i46, string12, string13, j15, string14, string15, j16, i48, j17, string16, i50, string17, string18, z11, z12, i51, cursorC.isNull(iE50) ? null : cursorC.getString(iE50), cursorC.isNull(iE51) ? null : Integer.valueOf(cursorC.getInt(iE51)), cursorC.isNull(iE52) ? null : cursorC.getString(iE52), cursorC.isNull(iE53) ? null : cursorC.getString(iE53), cursorC.isNull(iE54) ? null : cursorC.getString(iE54), cursorC.isNull(iE55) ? null : cursorC.getString(iE55), cursorC.isNull(iE56) ? null : cursorC.getString(iE56), cursorC.isNull(iE57) ? null : cursorC.getString(iE57), cursorC.isNull(iE58) ? null : Integer.valueOf(cursorC.getInt(iE58)), cursorC.isNull(iE59) ? null : cursorC.getString(iE59), cursorC.isNull(iE60) ? null : cursorC.getString(iE60), cursorC.isNull(iE61) ? null : Long.valueOf(cursorC.getLong(iE61)), cursorC.isNull(iE62) ? null : Long.valueOf(cursorC.getLong(iE62))));
                        iE = i16;
                        i11 = i14;
                    }
                    cursorC.close();
                    this.f77372a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    yVar = this;
                    cursorC.close();
                    yVar.f77372a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                yVar = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class z implements Callable<List<? extends DownloadBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.v f77374a;

        public z(androidx.room.v vVar) {
            this.f77374a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<? extends DownloadBean> call() throws Exception {
            z zVar;
            Cursor cursorC = e6.b.c(d.this.f77271a, this.f77374a, false, null);
            try {
                int iE = e6.a.e(cursorC, "url");
                int iE2 = e6.a.e(cursorC, "resourceId");
                int iE3 = e6.a.e(cursorC, "name");
                int iE4 = e6.a.e(cursorC, "cover");
                int iE5 = e6.a.e(cursorC, "size");
                int iE6 = e6.a.e(cursorC, "postId");
                int iE7 = e6.a.e(cursorC, "sizeFormat");
                int iE8 = e6.a.e(cursorC, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
                int iE9 = e6.a.e(cursorC, "duration");
                int iE10 = e6.a.e(cursorC, "updateTimeStamp");
                int iE11 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE12 = e6.a.e(cursorC, "supportRanges");
                int iE13 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                int iE14 = e6.a.e(cursorC, "type");
                try {
                    int iE15 = e6.a.e(cursorC, "readProgress");
                    int iE16 = e6.a.e(cursorC, "createAt");
                    int iE17 = e6.a.e(cursorC, "isRead");
                    int iE18 = e6.a.e(cursorC, "episode");
                    int iE19 = e6.a.e(cursorC, "ep");
                    int iE20 = e6.a.e(cursorC, "se");
                    int iE21 = e6.a.e(cursorC, "resolution");
                    int iE22 = e6.a.e(cursorC, "resourcePosition");
                    int iE23 = e6.a.e(cursorC, "multiresolution");
                    int iE24 = e6.a.e(cursorC, "videoWidth");
                    int iE25 = e6.a.e(cursorC, "videoHeight");
                    int iE26 = e6.a.e(cursorC, "downloadErrorCount");
                    int iE27 = e6.a.e(cursorC, "subtitleStarted");
                    int iE28 = e6.a.e(cursorC, "subjectId");
                    int iE29 = e6.a.e(cursorC, "pageFrom");
                    int iE30 = e6.a.e(cursorC, "lastPageFrom");
                    int iE31 = e6.a.e(cursorC, "subjectName");
                    int iE32 = e6.a.e(cursorC, "lastPlayTimeStamp");
                    int iE33 = e6.a.e(cursorC, "fileType");
                    int iE34 = e6.a.e(cursorC, "totalEpisode");
                    int iE35 = e6.a.e(cursorC, "uploadBy");
                    int iE36 = e6.a.e(cursorC, "sourceUrl");
                    int iE37 = e6.a.e(cursorC, "urlCreateAt");
                    int iE38 = e6.a.e(cursorC, "subtitleSelectId");
                    int iE39 = e6.a.e(cursorC, "taskId");
                    int iE40 = e6.a.e(cursorC, "sessionTime");
                    int iE41 = e6.a.e(cursorC, "reportStatus");
                    int iE42 = e6.a.e(cursorC, "downloadHeaderSize");
                    int iE43 = e6.a.e(cursorC, "rootPath");
                    int iE44 = e6.a.e(cursorC, "rootPathType");
                    int iE45 = e6.a.e(cursorC, "thumbnail");
                    int iE46 = e6.a.e(cursorC, "averageHueLight");
                    int iE47 = e6.a.e(cursorC, "isTransferFailed");
                    int iE48 = e6.a.e(cursorC, "isClosedTransferFailed");
                    int iE49 = e6.a.e(cursorC, "subjectType");
                    int iE50 = e6.a.e(cursorC, "genre");
                    int iE51 = e6.a.e(cursorC, "subjectDurationSeconds");
                    int iE52 = e6.a.e(cursorC, "currentDubLanName");
                    int iE53 = e6.a.e(cursorC, "currentDubLanCode");
                    int iE54 = e6.a.e(cursorC, "ops");
                    int iE55 = e6.a.e(cursorC, "restrictLevel");
                    int iE56 = e6.a.e(cursorC, "releaseDate");
                    int iE57 = e6.a.e(cursorC, "countryName");
                    int iE58 = e6.a.e(cursorC, "seNum");
                    int iE59 = e6.a.e(cursorC, "subtitles");
                    int iE60 = e6.a.e(cursorC, "imdbRate");
                    int iE61 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE62 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        String string3 = cursorC.isNull(iE3) ? null : cursorC.getString(iE3);
                        String string4 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        Long lValueOf = cursorC.isNull(iE5) ? null : Long.valueOf(cursorC.getLong(iE5));
                        String string5 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string6 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string7 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        Long lValueOf2 = cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9));
                        Long lValueOf3 = cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10));
                        long j11 = cursorC.getLong(iE11);
                        int i12 = cursorC.getInt(iE12);
                        int i13 = cursorC.getInt(iE13);
                        int i14 = i11;
                        int i15 = cursorC.getInt(i14);
                        int i16 = iE;
                        int i17 = iE15;
                        long j12 = cursorC.getLong(i17);
                        iE15 = i17;
                        int i18 = iE16;
                        long j13 = cursorC.getLong(i18);
                        iE16 = i18;
                        int i19 = iE17;
                        int i21 = cursorC.getInt(i19);
                        iE17 = i19;
                        int i22 = iE18;
                        int i23 = cursorC.getInt(i22);
                        iE18 = i22;
                        int i24 = iE19;
                        int i25 = cursorC.getInt(i24);
                        iE19 = i24;
                        int i26 = iE20;
                        int i27 = cursorC.getInt(i26);
                        iE20 = i26;
                        int i28 = iE21;
                        int i29 = cursorC.getInt(i28);
                        iE21 = i28;
                        int i31 = iE22;
                        int i32 = cursorC.getInt(i31);
                        iE22 = i31;
                        int i33 = iE23;
                        int i34 = cursorC.getInt(i33);
                        iE23 = i33;
                        int i35 = iE24;
                        int i36 = cursorC.getInt(i35);
                        iE24 = i35;
                        int i37 = iE25;
                        int i38 = cursorC.getInt(i37);
                        iE25 = i37;
                        int i39 = iE26;
                        int i40 = cursorC.getInt(i39);
                        iE26 = i39;
                        int i41 = iE27;
                        int i42 = cursorC.getInt(i41);
                        iE27 = i41;
                        iE28 = iE28;
                        String string8 = cursorC.isNull(iE28) ? null : cursorC.getString(iE28);
                        String string9 = cursorC.isNull(iE29) ? null : cursorC.getString(iE29);
                        String string10 = cursorC.isNull(iE30) ? null : cursorC.getString(iE30);
                        String string11 = cursorC.isNull(iE31) ? null : cursorC.getString(iE31);
                        long j14 = cursorC.getLong(iE32);
                        iE32 = iE32;
                        int i43 = iE33;
                        int i44 = cursorC.getInt(i43);
                        iE33 = i43;
                        int i45 = iE34;
                        int i46 = cursorC.getInt(i45);
                        iE34 = i45;
                        iE35 = iE35;
                        String string12 = cursorC.isNull(iE35) ? null : cursorC.getString(iE35);
                        String string13 = cursorC.isNull(iE36) ? null : cursorC.getString(iE36);
                        long j15 = cursorC.getLong(iE37);
                        iE37 = iE37;
                        iE38 = iE38;
                        String string14 = cursorC.isNull(iE38) ? null : cursorC.getString(iE38);
                        String string15 = cursorC.isNull(iE39) ? null : cursorC.getString(iE39);
                        long j16 = cursorC.getLong(iE40);
                        iE40 = iE40;
                        int i47 = iE41;
                        int i48 = cursorC.getInt(i47);
                        iE41 = i47;
                        int i49 = iE42;
                        long j17 = cursorC.getLong(i49);
                        iE42 = i49;
                        iE43 = iE43;
                        String string16 = cursorC.isNull(iE43) ? null : cursorC.getString(iE43);
                        int i50 = cursorC.getInt(iE44);
                        iE44 = iE44;
                        iE45 = iE45;
                        String string17 = cursorC.isNull(iE45) ? null : cursorC.getString(iE45);
                        String string18 = cursorC.isNull(iE46) ? null : cursorC.getString(iE46);
                        boolean z11 = cursorC.getInt(iE47) != 0;
                        boolean z12 = cursorC.getInt(iE48) != 0;
                        int i51 = cursorC.getInt(iE49);
                        iE49 = iE49;
                        iE50 = iE50;
                        arrayList.add(new DownloadBean(string, string2, string3, string4, lValueOf, string5, string6, string7, lValueOf2, lValueOf3, j11, i12, i13, i15, j12, j13, i21, i23, i25, i27, i29, i32, i34, i36, i38, i40, i42, string8, string9, string10, string11, j14, i44, i46, string12, string13, j15, string14, string15, j16, i48, j17, string16, i50, string17, string18, z11, z12, i51, cursorC.isNull(iE50) ? null : cursorC.getString(iE50), cursorC.isNull(iE51) ? null : Integer.valueOf(cursorC.getInt(iE51)), cursorC.isNull(iE52) ? null : cursorC.getString(iE52), cursorC.isNull(iE53) ? null : cursorC.getString(iE53), cursorC.isNull(iE54) ? null : cursorC.getString(iE54), cursorC.isNull(iE55) ? null : cursorC.getString(iE55), cursorC.isNull(iE56) ? null : cursorC.getString(iE56), cursorC.isNull(iE57) ? null : cursorC.getString(iE57), cursorC.isNull(iE58) ? null : Integer.valueOf(cursorC.getInt(iE58)), cursorC.isNull(iE59) ? null : cursorC.getString(iE59), cursorC.isNull(iE60) ? null : cursorC.getString(iE60), cursorC.isNull(iE61) ? null : Long.valueOf(cursorC.getLong(iE61)), cursorC.isNull(iE62) ? null : Long.valueOf(cursorC.getLong(iE62))));
                        iE = i16;
                        i11 = i14;
                    }
                    cursorC.close();
                    this.f77374a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    zVar = this;
                    cursorC.close();
                    zVar.f77374a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                zVar = this;
            }
        }
    }

    public d(RoomDatabase roomDatabase) {
        this.f77271a = roomDatabase;
        this.f77272b = new i(roomDatabase);
        this.f77273c = new r(roomDatabase);
        this.f77274d = new w(roomDatabase);
        this.f77275e = new f0(roomDatabase);
        this.f77276f = new o0(roomDatabase);
        this.f77277g = new p0(roomDatabase);
        this.f77278h = new q0(roomDatabase);
        this.f77279i = new r0(roomDatabase);
        this.f77280j = new s0(roomDatabase);
        this.f77281k = new a(roomDatabase);
        this.f77282l = new b(roomDatabase);
        this.f77283m = new c(roomDatabase);
        this.f77284n = new C0856d(roomDatabase);
        this.f77285o = new e(roomDatabase);
        this.f77286p = new f(roomDatabase);
    }

    public static List<Class<?>> R() {
        return Collections.emptyList();
    }

    @Override // tr.c
    public Object A(String str, int i11, int i12, Continuation<? super DownloadBean> continuation) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ?  AND se =? AND ep =? ORDER BY resolution DESC LIMIT 1", 3);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        vVarC.V(2, i11);
        vVarC.V(3, i12);
        return CoroutinesRoom.a(this.f77271a, false, e6.b.a(), new l0(vVarC), continuation);
    }

    @Override // tr.c
    public Object B(String str, Continuation<? super DownloadBean> continuation) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM DOWNLOAD_TABLE WHERE type = 2 AND fileType = 2 AND path = ?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f77271a, false, e6.b.a(), new u(vVarC), continuation);
    }

    @Override // tr.c
    public Object C(String str, Continuation<? super List<? extends DownloadBean>> continuation) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ? ORDER BY ep ASC ", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f77271a, false, e6.b.a(), new j0(vVarC), continuation);
    }

    @Override // tr.c
    public Object D(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f77271a, true, new t(str2, str3, str4, str6, num, str5, str7, str), continuation);
    }

    @Override // tr.c
    public Object a(String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f77271a, true, new p(str), continuation);
    }

    @Override // tr.c
    public Object b(String str, Continuation<? super DownloadBean> continuation) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM DOWNLOAD_TABLE WHERE resourceId = ? ORDER BY createAt DESC", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f77271a, false, e6.b.a(), new x(vVarC), continuation);
    }

    @Override // tr.c
    public Object c(String str, String str2, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f77271a, true, new o(str2, str), continuation);
    }

    @Override // tr.c
    public Object d(Continuation<? super List<? extends DownloadBean>> continuation) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM DOWNLOAD_TABLE WHERE fileType == 1", 0);
        return CoroutinesRoom.a(this.f77271a, false, e6.b.a(), new c0(vVarC), continuation);
    }

    @Override // tr.c
    public Object e(int i11, Continuation<? super List<? extends DownloadBean>> continuation) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM DOWNLOAD_TABLE WHERE fileType == 1 ORDER BY updateTimeStamp DESC Limit ?", 1);
        vVarC.V(1, i11);
        return CoroutinesRoom.a(this.f77271a, false, e6.b.a(), new y(vVarC), continuation);
    }

    @Override // tr.c
    public Object f(Continuation<? super List<? extends DownloadBean>> continuation) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM DOWNLOAD_TABLE WHERE status = 6 OR status = 3 AND fileType == 1 ORDER BY updateTimeStamp DESC ", 0);
        return CoroutinesRoom.a(this.f77271a, false, e6.b.a(), new b0(vVarC), continuation);
    }

    @Override // tr.c
    public Object g(Continuation<? super List<? extends DownloadBean>> continuation) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM DOWNLOAD_TABLE WHERE status = 5 AND fileType == 1 ORDER BY updateTimeStamp DESC ", 0);
        return CoroutinesRoom.a(this.f77271a, false, e6.b.a(), new z(vVarC), continuation);
    }

    @Override // tr.c
    public Object h(String str, int i11, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f77271a, true, new j(i11, str), continuation);
    }

    @Override // tr.c
    public Object i(Continuation<? super List<? extends DownloadBean>> continuation) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM DOWNLOAD_TABLE WHERE status !=5 AND fileType == 1 ORDER BY createAt ASC ", 0);
        return CoroutinesRoom.a(this.f77271a, false, e6.b.a(), new d0(vVarC), continuation);
    }

    @Override // tr.c
    public Object j(String str, long j11, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f77271a, true, new k(j11, str), continuation);
    }

    @Override // tr.c
    public Object k(String str, Continuation<? super List<? extends DownloadBean>> continuation) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ?  ORDER BY episode ASC ", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f77271a, false, e6.b.a(), new h0(vVarC), continuation);
    }

    @Override // tr.c
    public Object l(String str, Continuation<? super List<? extends DownloadBean>> continuation) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ? AND status = 5  ORDER BY episode ASC ", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f77271a, false, e6.b.a(), new i0(vVarC), continuation);
    }

    @Override // tr.c
    public Object m(String str, int i11, Continuation<? super DownloadBean> continuation) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ? AND ep =? ", 2);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        vVarC.V(2, i11);
        return CoroutinesRoom.a(this.f77271a, false, e6.b.a(), new k0(vVarC), continuation);
    }

    @Override // tr.c
    public Object n(String str, int i11, int i12, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f77271a, true, new l(i11, i12, str), continuation);
    }

    @Override // tr.c
    public Object o(Continuation<? super List<? extends DownloadBean>> continuation) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM DOWNLOAD_TABLE WHERE fileType = 3 ORDER BY updateTimeStamp DESC ", 0);
        return CoroutinesRoom.a(this.f77271a, false, e6.b.a(), new n0(vVarC), continuation);
    }

    @Override // tr.c
    public Object p(String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f77271a, true, new s(str), continuation);
    }

    @Override // tr.c
    public Object q(String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f77271a, true, new q(str), continuation);
    }

    @Override // tr.c
    public Object r(String str, Continuation<? super List<? extends DownloadBean>> continuation) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ? ORDER BY createAt DESC", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f77271a, false, e6.b.a(), new m0(vVarC), continuation);
    }

    @Override // tr.c
    public Object s(String str, long j11, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f77271a, true, new m(j11, str), continuation);
    }

    @Override // tr.c
    public Object t(DownloadBean downloadBean, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f77271a, true, new g(downloadBean), continuation);
    }

    @Override // tr.c
    public Object u(String str, long j11, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f77271a, true, new n(j11, str), continuation);
    }

    @Override // tr.c
    public Object v(Continuation<? super DownloadBean> continuation) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM DOWNLOAD_TABLE WHERE status ==5 AND fileType == 1 AND type != 1 ORDER BY updateTimeStamp DESC LIMIT 1", 0);
        return CoroutinesRoom.a(this.f77271a, false, e6.b.a(), new e0(vVarC), continuation);
    }

    @Override // tr.c
    public Object w(DownloadBean downloadBean, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f77271a, true, new h(downloadBean), continuation);
    }

    @Override // tr.c
    public Object x(String str, int i11, Continuation<? super DownloadBean> continuation) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ? AND ep = ?", 2);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        vVarC.V(2, i11);
        return CoroutinesRoom.a(this.f77271a, false, e6.b.a(), new g0(vVarC), continuation);
    }

    @Override // tr.c
    public Object y(Continuation<? super DownloadBean> continuation) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM DOWNLOAD_TABLE WHERE status = 5 AND fileType == 1 Limit 1 ", 0);
        return CoroutinesRoom.a(this.f77271a, false, e6.b.a(), new a0(vVarC), continuation);
    }

    @Override // tr.c
    public Object z(String str, Continuation<? super DownloadBean> continuation) {
        androidx.room.v vVarC = androidx.room.v.c("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f77271a, false, e6.b.a(), new v(vVarC), continuation);
    }
}
