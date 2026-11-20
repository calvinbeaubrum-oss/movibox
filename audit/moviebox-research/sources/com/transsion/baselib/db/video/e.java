package com.transsion.baselib.db.video;

import android.database.Cursor;
import androidx.core.app.NotificationCompat;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.v;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements VideoDetailPlayDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f51123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.i<VideoDetailPlayBean> f51124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qr.a f51125c = new qr.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.room.h<VideoDetailPlayBean> f51126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.room.h<VideoDetailPlayBean> f51127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SharedSQLiteStatement f51128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SharedSQLiteStatement f51129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SharedSQLiteStatement f51130h;

    /* JADX INFO: compiled from: source.java */
    public class a implements Callable<Unit> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            g6.k kVarB = e.this.f51128f.b();
            e.this.f51123a.e();
            try {
                kVarB.F();
                e.this.f51123a.E();
                return Unit.f68710a;
            } finally {
                e.this.f51123a.i();
                e.this.f51128f.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f51132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f51133b;

        public b(String str, String str2) {
            this.f51132a = str;
            this.f51133b = str2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            g6.k kVarB = e.this.f51129g.b();
            String str = this.f51132a;
            if (str == null) {
                kVarB.m0(1);
            } else {
                kVarB.s(1, str);
            }
            String str2 = this.f51133b;
            if (str2 == null) {
                kVarB.m0(2);
            } else {
                kVarB.s(2, str2);
            }
            e.this.f51123a.e();
            try {
                kVarB.F();
                e.this.f51123a.E();
                return Unit.f68710a;
            } finally {
                e.this.f51123a.i();
                e.this.f51129g.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Callable<VideoDetailPlayBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f51135a;

        public c(v vVar) {
            this.f51135a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoDetailPlayBean call() throws Exception {
            c cVar;
            VideoDetailPlayBean videoDetailPlayBean;
            Cursor cursorC = e6.b.c(e.this.f51123a, this.f51135a, false, null);
            try {
                int iE = e6.a.e(cursorC, "subjectId");
                int iE2 = e6.a.e(cursorC, "id");
                int iE3 = e6.a.e(cursorC, "ep");
                int iE4 = e6.a.e(cursorC, "se");
                int iE5 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE6 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                int iE7 = e6.a.e(cursorC, "coverUrl");
                int iE8 = e6.a.e(cursorC, "thumbnail");
                int iE9 = e6.a.e(cursorC, "videoUrl");
                int iE10 = e6.a.e(cursorC, "timeStamp");
                int iE11 = e6.a.e(cursorC, "subtitleSelectId");
                int iE12 = e6.a.e(cursorC, "totalDuration");
                int iE13 = e6.a.e(cursorC, "subjectDurationSeconds");
                int iE14 = e6.a.e(cursorC, "averageHueLight");
                try {
                    int iE15 = e6.a.e(cursorC, "subjectType");
                    int iE16 = e6.a.e(cursorC, "hasDelete");
                    int iE17 = e6.a.e(cursorC, "playMode");
                    int iE18 = e6.a.e(cursorC, "downloadUrl");
                    int iE19 = e6.a.e(cursorC, "downloadFilePath");
                    int iE20 = e6.a.e(cursorC, "downloadSize");
                    int iE21 = e6.a.e(cursorC, "dubs");
                    int iE22 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE23 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    int iE24 = e6.a.e(cursorC, "rewardPlayed");
                    int iE25 = e6.a.e(cursorC, "rewardUnlock");
                    int iE26 = e6.a.e(cursorC, "rewardFree");
                    if (cursorC.moveToFirst()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        int i11 = cursorC.getInt(iE3);
                        int i12 = cursorC.getInt(iE4);
                        long j11 = cursorC.getLong(iE5);
                        String string3 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string4 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string5 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        String string6 = cursorC.isNull(iE9) ? null : cursorC.getString(iE9);
                        long j12 = cursorC.getLong(iE10);
                        String string7 = cursorC.isNull(iE11) ? null : cursorC.getString(iE11);
                        Long lValueOf = cursorC.isNull(iE12) ? null : Long.valueOf(cursorC.getLong(iE12));
                        Long lValueOf2 = cursorC.isNull(iE13) ? null : Long.valueOf(cursorC.getLong(iE13));
                        String string8 = cursorC.isNull(iE14) ? null : cursorC.getString(iE14);
                        cVar = this;
                        try {
                            videoDetailPlayBean = new VideoDetailPlayBean(string, string2, i11, i12, j11, string3, string4, string5, string6, j12, string7, lValueOf, lValueOf2, string8, cursorC.isNull(r16) ? null : Integer.valueOf(cursorC.getInt(iE15)), cursorC.getInt(iE16) != 0, cursorC.isNull(r18) ? null : cursorC.getString(iE17), cursorC.isNull(r19) ? null : cursorC.getString(iE18), cursorC.isNull(r20) ? null : cursorC.getString(iE19), cursorC.getLong(iE20), e.this.f51125c.b(cursorC.isNull(iE21) ? null : cursorC.getString(iE21)), cursorC.isNull(iE22) ? null : Long.valueOf(cursorC.getLong(iE22)), cursorC.isNull(r24) ? null : Long.valueOf(cursorC.getLong(iE23)), cursorC.getInt(iE24) != 0, cursorC.getInt(iE25) != 0, cursorC.getInt(iE26) != 0);
                        } catch (Throwable th2) {
                            th = th2;
                            cursorC.close();
                            cVar.f51135a.release();
                            throw th;
                        }
                    } else {
                        cVar = this;
                        videoDetailPlayBean = null;
                    }
                    cursorC.close();
                    cVar.f51135a.release();
                    return videoDetailPlayBean;
                } catch (Throwable th3) {
                    th = th3;
                    cVar = this;
                }
            } catch (Throwable th4) {
                th = th4;
                cVar = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Callable<VideoDetailPlayBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f51137a;

        public d(v vVar) {
            this.f51137a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoDetailPlayBean call() throws Exception {
            d dVar;
            VideoDetailPlayBean videoDetailPlayBean;
            Cursor cursorC = e6.b.c(e.this.f51123a, this.f51137a, false, null);
            try {
                int iE = e6.a.e(cursorC, "subjectId");
                int iE2 = e6.a.e(cursorC, "id");
                int iE3 = e6.a.e(cursorC, "ep");
                int iE4 = e6.a.e(cursorC, "se");
                int iE5 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE6 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                int iE7 = e6.a.e(cursorC, "coverUrl");
                int iE8 = e6.a.e(cursorC, "thumbnail");
                int iE9 = e6.a.e(cursorC, "videoUrl");
                int iE10 = e6.a.e(cursorC, "timeStamp");
                int iE11 = e6.a.e(cursorC, "subtitleSelectId");
                int iE12 = e6.a.e(cursorC, "totalDuration");
                int iE13 = e6.a.e(cursorC, "subjectDurationSeconds");
                int iE14 = e6.a.e(cursorC, "averageHueLight");
                try {
                    int iE15 = e6.a.e(cursorC, "subjectType");
                    int iE16 = e6.a.e(cursorC, "hasDelete");
                    int iE17 = e6.a.e(cursorC, "playMode");
                    int iE18 = e6.a.e(cursorC, "downloadUrl");
                    int iE19 = e6.a.e(cursorC, "downloadFilePath");
                    int iE20 = e6.a.e(cursorC, "downloadSize");
                    int iE21 = e6.a.e(cursorC, "dubs");
                    int iE22 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE23 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    int iE24 = e6.a.e(cursorC, "rewardPlayed");
                    int iE25 = e6.a.e(cursorC, "rewardUnlock");
                    int iE26 = e6.a.e(cursorC, "rewardFree");
                    if (cursorC.moveToFirst()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        int i11 = cursorC.getInt(iE3);
                        int i12 = cursorC.getInt(iE4);
                        long j11 = cursorC.getLong(iE5);
                        String string3 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string4 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string5 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        String string6 = cursorC.isNull(iE9) ? null : cursorC.getString(iE9);
                        long j12 = cursorC.getLong(iE10);
                        String string7 = cursorC.isNull(iE11) ? null : cursorC.getString(iE11);
                        Long lValueOf = cursorC.isNull(iE12) ? null : Long.valueOf(cursorC.getLong(iE12));
                        Long lValueOf2 = cursorC.isNull(iE13) ? null : Long.valueOf(cursorC.getLong(iE13));
                        String string8 = cursorC.isNull(iE14) ? null : cursorC.getString(iE14);
                        dVar = this;
                        try {
                            videoDetailPlayBean = new VideoDetailPlayBean(string, string2, i11, i12, j11, string3, string4, string5, string6, j12, string7, lValueOf, lValueOf2, string8, cursorC.isNull(r16) ? null : Integer.valueOf(cursorC.getInt(iE15)), cursorC.getInt(iE16) != 0, cursorC.isNull(r18) ? null : cursorC.getString(iE17), cursorC.isNull(r19) ? null : cursorC.getString(iE18), cursorC.isNull(r20) ? null : cursorC.getString(iE19), cursorC.getLong(iE20), e.this.f51125c.b(cursorC.isNull(iE21) ? null : cursorC.getString(iE21)), cursorC.isNull(iE22) ? null : Long.valueOf(cursorC.getLong(iE22)), cursorC.isNull(r24) ? null : Long.valueOf(cursorC.getLong(iE23)), cursorC.getInt(iE24) != 0, cursorC.getInt(iE25) != 0, cursorC.getInt(iE26) != 0);
                        } catch (Throwable th2) {
                            th = th2;
                            cursorC.close();
                            dVar.f51137a.release();
                            throw th;
                        }
                    } else {
                        dVar = this;
                        videoDetailPlayBean = null;
                    }
                    cursorC.close();
                    dVar.f51137a.release();
                    return videoDetailPlayBean;
                } catch (Throwable th3) {
                    th = th3;
                    dVar = this;
                }
            } catch (Throwable th4) {
                th = th4;
                dVar = this;
            }
        }
    }

    /* JADX INFO: renamed from: com.transsion.baselib.db.video.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class CallableC0556e implements Callable<List<VideoDetailPlayBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f51139a;

        public CallableC0556e(v vVar) {
            this.f51139a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<VideoDetailPlayBean> call() throws Exception {
            CallableC0556e callableC0556e;
            Cursor cursorC = e6.b.c(e.this.f51123a, this.f51139a, false, null);
            try {
                int iE = e6.a.e(cursorC, "subjectId");
                int iE2 = e6.a.e(cursorC, "id");
                int iE3 = e6.a.e(cursorC, "ep");
                int iE4 = e6.a.e(cursorC, "se");
                int iE5 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE6 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                int iE7 = e6.a.e(cursorC, "coverUrl");
                int iE8 = e6.a.e(cursorC, "thumbnail");
                int iE9 = e6.a.e(cursorC, "videoUrl");
                int iE10 = e6.a.e(cursorC, "timeStamp");
                int iE11 = e6.a.e(cursorC, "subtitleSelectId");
                int iE12 = e6.a.e(cursorC, "totalDuration");
                int iE13 = e6.a.e(cursorC, "subjectDurationSeconds");
                int iE14 = e6.a.e(cursorC, "averageHueLight");
                try {
                    int iE15 = e6.a.e(cursorC, "subjectType");
                    int iE16 = e6.a.e(cursorC, "hasDelete");
                    int iE17 = e6.a.e(cursorC, "playMode");
                    int iE18 = e6.a.e(cursorC, "downloadUrl");
                    int iE19 = e6.a.e(cursorC, "downloadFilePath");
                    int iE20 = e6.a.e(cursorC, "downloadSize");
                    int iE21 = e6.a.e(cursorC, "dubs");
                    int iE22 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE23 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    int iE24 = e6.a.e(cursorC, "rewardPlayed");
                    int iE25 = e6.a.e(cursorC, "rewardUnlock");
                    int iE26 = e6.a.e(cursorC, "rewardFree");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        int i12 = cursorC.getInt(iE3);
                        int i13 = cursorC.getInt(iE4);
                        long j11 = cursorC.getLong(iE5);
                        String string3 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string4 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string5 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        String string6 = cursorC.isNull(iE9) ? null : cursorC.getString(iE9);
                        long j12 = cursorC.getLong(iE10);
                        String string7 = cursorC.isNull(iE11) ? null : cursorC.getString(iE11);
                        Long lValueOf = cursorC.isNull(iE12) ? null : Long.valueOf(cursorC.getLong(iE12));
                        Long lValueOf2 = cursorC.isNull(iE13) ? null : Long.valueOf(cursorC.getLong(iE13));
                        String string8 = cursorC.isNull(i11) ? null : cursorC.getString(i11);
                        int i14 = iE15;
                        int i15 = iE;
                        Integer numValueOf = cursorC.isNull(i14) ? null : Integer.valueOf(cursorC.getInt(i14));
                        int i16 = iE16;
                        boolean z11 = cursorC.getInt(i16) != 0;
                        int i17 = iE17;
                        String string9 = cursorC.isNull(i17) ? null : cursorC.getString(i17);
                        int i18 = iE18;
                        String string10 = cursorC.isNull(i18) ? null : cursorC.getString(i18);
                        int i19 = iE19;
                        String string11 = cursorC.isNull(i19) ? null : cursorC.getString(i19);
                        int i21 = iE20;
                        long j13 = cursorC.getLong(i21);
                        int i22 = iE21;
                        callableC0556e = this;
                        try {
                            ArrayList<String> arrayListB = e.this.f51125c.b(cursorC.isNull(i22) ? null : cursorC.getString(i22));
                            iE22 = iE22;
                            Long lValueOf3 = cursorC.isNull(iE22) ? null : Long.valueOf(cursorC.getLong(iE22));
                            Long lValueOf4 = cursorC.isNull(iE23) ? null : Long.valueOf(cursorC.getLong(iE23));
                            int i23 = cursorC.getInt(iE24);
                            iE24 = iE24;
                            int i24 = iE25;
                            boolean z12 = i23 != 0;
                            int i25 = cursorC.getInt(i24);
                            iE25 = i24;
                            int i26 = iE26;
                            iE26 = i26;
                            arrayList.add(new VideoDetailPlayBean(string, string2, i12, i13, j11, string3, string4, string5, string6, j12, string7, lValueOf, lValueOf2, string8, numValueOf, z11, string9, string10, string11, j13, arrayListB, lValueOf3, lValueOf4, z12, i25 != 0, cursorC.getInt(i26) != 0));
                            iE23 = iE23;
                            iE = i15;
                            iE15 = i14;
                            iE16 = i16;
                            iE17 = i17;
                            iE18 = i18;
                            iE19 = i19;
                            iE13 = iE13;
                            iE20 = i21;
                            iE21 = i22;
                            i11 = i11;
                        } catch (Throwable th2) {
                            th = th2;
                            cursorC.close();
                            callableC0556e.f51139a.release();
                            throw th;
                        }
                    }
                    cursorC.close();
                    this.f51139a.release();
                    return arrayList;
                } catch (Throwable th3) {
                    th = th3;
                    callableC0556e = this;
                }
            } catch (Throwable th4) {
                th = th4;
                callableC0556e = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements Callable<VideoDetailPlayBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f51141a;

        public f(v vVar) {
            this.f51141a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoDetailPlayBean call() throws Exception {
            f fVar;
            VideoDetailPlayBean videoDetailPlayBean;
            Cursor cursorC = e6.b.c(e.this.f51123a, this.f51141a, false, null);
            try {
                int iE = e6.a.e(cursorC, "subjectId");
                int iE2 = e6.a.e(cursorC, "id");
                int iE3 = e6.a.e(cursorC, "ep");
                int iE4 = e6.a.e(cursorC, "se");
                int iE5 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE6 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                int iE7 = e6.a.e(cursorC, "coverUrl");
                int iE8 = e6.a.e(cursorC, "thumbnail");
                int iE9 = e6.a.e(cursorC, "videoUrl");
                int iE10 = e6.a.e(cursorC, "timeStamp");
                int iE11 = e6.a.e(cursorC, "subtitleSelectId");
                int iE12 = e6.a.e(cursorC, "totalDuration");
                int iE13 = e6.a.e(cursorC, "subjectDurationSeconds");
                int iE14 = e6.a.e(cursorC, "averageHueLight");
                try {
                    int iE15 = e6.a.e(cursorC, "subjectType");
                    int iE16 = e6.a.e(cursorC, "hasDelete");
                    int iE17 = e6.a.e(cursorC, "playMode");
                    int iE18 = e6.a.e(cursorC, "downloadUrl");
                    int iE19 = e6.a.e(cursorC, "downloadFilePath");
                    int iE20 = e6.a.e(cursorC, "downloadSize");
                    int iE21 = e6.a.e(cursorC, "dubs");
                    int iE22 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE23 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    int iE24 = e6.a.e(cursorC, "rewardPlayed");
                    int iE25 = e6.a.e(cursorC, "rewardUnlock");
                    int iE26 = e6.a.e(cursorC, "rewardFree");
                    if (cursorC.moveToFirst()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        int i11 = cursorC.getInt(iE3);
                        int i12 = cursorC.getInt(iE4);
                        long j11 = cursorC.getLong(iE5);
                        String string3 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string4 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string5 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        String string6 = cursorC.isNull(iE9) ? null : cursorC.getString(iE9);
                        long j12 = cursorC.getLong(iE10);
                        String string7 = cursorC.isNull(iE11) ? null : cursorC.getString(iE11);
                        Long lValueOf = cursorC.isNull(iE12) ? null : Long.valueOf(cursorC.getLong(iE12));
                        Long lValueOf2 = cursorC.isNull(iE13) ? null : Long.valueOf(cursorC.getLong(iE13));
                        String string8 = cursorC.isNull(iE14) ? null : cursorC.getString(iE14);
                        fVar = this;
                        try {
                            videoDetailPlayBean = new VideoDetailPlayBean(string, string2, i11, i12, j11, string3, string4, string5, string6, j12, string7, lValueOf, lValueOf2, string8, cursorC.isNull(r16) ? null : Integer.valueOf(cursorC.getInt(iE15)), cursorC.getInt(iE16) != 0, cursorC.isNull(r18) ? null : cursorC.getString(iE17), cursorC.isNull(r19) ? null : cursorC.getString(iE18), cursorC.isNull(r20) ? null : cursorC.getString(iE19), cursorC.getLong(iE20), e.this.f51125c.b(cursorC.isNull(iE21) ? null : cursorC.getString(iE21)), cursorC.isNull(iE22) ? null : Long.valueOf(cursorC.getLong(iE22)), cursorC.isNull(r24) ? null : Long.valueOf(cursorC.getLong(iE23)), cursorC.getInt(iE24) != 0, cursorC.getInt(iE25) != 0, cursorC.getInt(iE26) != 0);
                        } catch (Throwable th2) {
                            th = th2;
                            cursorC.close();
                            fVar.f51141a.release();
                            throw th;
                        }
                    } else {
                        fVar = this;
                        videoDetailPlayBean = null;
                    }
                    cursorC.close();
                    fVar.f51141a.release();
                    return videoDetailPlayBean;
                } catch (Throwable th3) {
                    th = th3;
                    fVar = this;
                }
            } catch (Throwable th4) {
                th = th4;
                fVar = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements Callable<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f51143a;

        public g(v vVar) {
            this.f51143a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long call() throws Exception {
            Long lValueOf = null;
            Cursor cursorC = e6.b.c(e.this.f51123a, this.f51143a, false, null);
            try {
                if (cursorC.moveToFirst() && !cursorC.isNull(0)) {
                    lValueOf = Long.valueOf(cursorC.getLong(0));
                }
                return lValueOf;
            } finally {
                cursorC.close();
                this.f51143a.release();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements Callable<List<VideoDetailPlayBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f51145a;

        public h(v vVar) {
            this.f51145a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<VideoDetailPlayBean> call() throws Exception {
            h hVar;
            Cursor cursorC = e6.b.c(e.this.f51123a, this.f51145a, false, null);
            try {
                int iE = e6.a.e(cursorC, "subjectId");
                int iE2 = e6.a.e(cursorC, "id");
                int iE3 = e6.a.e(cursorC, "ep");
                int iE4 = e6.a.e(cursorC, "se");
                int iE5 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE6 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                int iE7 = e6.a.e(cursorC, "coverUrl");
                int iE8 = e6.a.e(cursorC, "thumbnail");
                int iE9 = e6.a.e(cursorC, "videoUrl");
                int iE10 = e6.a.e(cursorC, "timeStamp");
                int iE11 = e6.a.e(cursorC, "subtitleSelectId");
                int iE12 = e6.a.e(cursorC, "totalDuration");
                int iE13 = e6.a.e(cursorC, "subjectDurationSeconds");
                int iE14 = e6.a.e(cursorC, "averageHueLight");
                try {
                    int iE15 = e6.a.e(cursorC, "subjectType");
                    int iE16 = e6.a.e(cursorC, "hasDelete");
                    int iE17 = e6.a.e(cursorC, "playMode");
                    int iE18 = e6.a.e(cursorC, "downloadUrl");
                    int iE19 = e6.a.e(cursorC, "downloadFilePath");
                    int iE20 = e6.a.e(cursorC, "downloadSize");
                    int iE21 = e6.a.e(cursorC, "dubs");
                    int iE22 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE23 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    int iE24 = e6.a.e(cursorC, "rewardPlayed");
                    int iE25 = e6.a.e(cursorC, "rewardUnlock");
                    int iE26 = e6.a.e(cursorC, "rewardFree");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        int i12 = cursorC.getInt(iE3);
                        int i13 = cursorC.getInt(iE4);
                        long j11 = cursorC.getLong(iE5);
                        String string3 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string4 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string5 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        String string6 = cursorC.isNull(iE9) ? null : cursorC.getString(iE9);
                        long j12 = cursorC.getLong(iE10);
                        String string7 = cursorC.isNull(iE11) ? null : cursorC.getString(iE11);
                        Long lValueOf = cursorC.isNull(iE12) ? null : Long.valueOf(cursorC.getLong(iE12));
                        Long lValueOf2 = cursorC.isNull(iE13) ? null : Long.valueOf(cursorC.getLong(iE13));
                        String string8 = cursorC.isNull(i11) ? null : cursorC.getString(i11);
                        int i14 = iE15;
                        int i15 = iE;
                        Integer numValueOf = cursorC.isNull(i14) ? null : Integer.valueOf(cursorC.getInt(i14));
                        int i16 = iE16;
                        boolean z11 = cursorC.getInt(i16) != 0;
                        int i17 = iE17;
                        String string9 = cursorC.isNull(i17) ? null : cursorC.getString(i17);
                        int i18 = iE18;
                        String string10 = cursorC.isNull(i18) ? null : cursorC.getString(i18);
                        int i19 = iE19;
                        String string11 = cursorC.isNull(i19) ? null : cursorC.getString(i19);
                        int i21 = iE20;
                        long j13 = cursorC.getLong(i21);
                        int i22 = iE21;
                        hVar = this;
                        try {
                            ArrayList<String> arrayListB = e.this.f51125c.b(cursorC.isNull(i22) ? null : cursorC.getString(i22));
                            iE22 = iE22;
                            Long lValueOf3 = cursorC.isNull(iE22) ? null : Long.valueOf(cursorC.getLong(iE22));
                            Long lValueOf4 = cursorC.isNull(iE23) ? null : Long.valueOf(cursorC.getLong(iE23));
                            int i23 = cursorC.getInt(iE24);
                            iE24 = iE24;
                            int i24 = iE25;
                            boolean z12 = i23 != 0;
                            int i25 = cursorC.getInt(i24);
                            iE25 = i24;
                            int i26 = iE26;
                            iE26 = i26;
                            arrayList.add(new VideoDetailPlayBean(string, string2, i12, i13, j11, string3, string4, string5, string6, j12, string7, lValueOf, lValueOf2, string8, numValueOf, z11, string9, string10, string11, j13, arrayListB, lValueOf3, lValueOf4, z12, i25 != 0, cursorC.getInt(i26) != 0));
                            iE23 = iE23;
                            iE = i15;
                            iE15 = i14;
                            iE16 = i16;
                            iE17 = i17;
                            iE18 = i18;
                            iE19 = i19;
                            iE13 = iE13;
                            iE20 = i21;
                            iE21 = i22;
                            i11 = i11;
                        } catch (Throwable th2) {
                            th = th2;
                            cursorC.close();
                            hVar.f51145a.release();
                            throw th;
                        }
                    }
                    cursorC.close();
                    this.f51145a.release();
                    return arrayList;
                } catch (Throwable th3) {
                    th = th3;
                    hVar = this;
                }
            } catch (Throwable th4) {
                th = th4;
                hVar = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i extends androidx.room.i<VideoDetailPlayBean> {
        public i(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `video_detail_play` (`subjectId`,`id`,`ep`,`se`,`progress`,`title`,`coverUrl`,`thumbnail`,`videoUrl`,`timeStamp`,`subtitleSelectId`,`totalDuration`,`subjectDurationSeconds`,`averageHueLight`,`subjectType`,`hasDelete`,`playMode`,`downloadUrl`,`downloadFilePath`,`downloadSize`,`dubs`,`lastAdStartTimeStamp`,`lastAdEndTimeStamp`,`rewardPlayed`,`rewardUnlock`,`rewardFree`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, VideoDetailPlayBean videoDetailPlayBean) {
            if (videoDetailPlayBean.getSubjectId() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, videoDetailPlayBean.getSubjectId());
            }
            if (videoDetailPlayBean.getId() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, videoDetailPlayBean.getId());
            }
            kVar.V(3, videoDetailPlayBean.getEp());
            kVar.V(4, videoDetailPlayBean.getSe());
            kVar.V(5, videoDetailPlayBean.getProgress());
            if (videoDetailPlayBean.getTitle() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, videoDetailPlayBean.getTitle());
            }
            if (videoDetailPlayBean.getCoverUrl() == null) {
                kVar.m0(7);
            } else {
                kVar.s(7, videoDetailPlayBean.getCoverUrl());
            }
            if (videoDetailPlayBean.getThumbnail() == null) {
                kVar.m0(8);
            } else {
                kVar.s(8, videoDetailPlayBean.getThumbnail());
            }
            if (videoDetailPlayBean.getVideoUrl() == null) {
                kVar.m0(9);
            } else {
                kVar.s(9, videoDetailPlayBean.getVideoUrl());
            }
            kVar.V(10, videoDetailPlayBean.getTimeStamp());
            if (videoDetailPlayBean.getSubtitleSelectId() == null) {
                kVar.m0(11);
            } else {
                kVar.s(11, videoDetailPlayBean.getSubtitleSelectId());
            }
            if (videoDetailPlayBean.getTotalDuration() == null) {
                kVar.m0(12);
            } else {
                kVar.V(12, videoDetailPlayBean.getTotalDuration().longValue());
            }
            if (videoDetailPlayBean.getSubjectDurationSeconds() == null) {
                kVar.m0(13);
            } else {
                kVar.V(13, videoDetailPlayBean.getSubjectDurationSeconds().longValue());
            }
            if (videoDetailPlayBean.getAverageHueLight() == null) {
                kVar.m0(14);
            } else {
                kVar.s(14, videoDetailPlayBean.getAverageHueLight());
            }
            if (videoDetailPlayBean.getSubjectType() == null) {
                kVar.m0(15);
            } else {
                kVar.V(15, videoDetailPlayBean.getSubjectType().intValue());
            }
            kVar.V(16, videoDetailPlayBean.getHasDelete() ? 1L : 0L);
            if (videoDetailPlayBean.getPlayMode() == null) {
                kVar.m0(17);
            } else {
                kVar.s(17, videoDetailPlayBean.getPlayMode());
            }
            if (videoDetailPlayBean.getDownloadUrl() == null) {
                kVar.m0(18);
            } else {
                kVar.s(18, videoDetailPlayBean.getDownloadUrl());
            }
            if (videoDetailPlayBean.getDownloadFilePath() == null) {
                kVar.m0(19);
            } else {
                kVar.s(19, videoDetailPlayBean.getDownloadFilePath());
            }
            kVar.V(20, videoDetailPlayBean.getDownloadSize());
            String strA = e.this.f51125c.a(videoDetailPlayBean.getDubs());
            if (strA == null) {
                kVar.m0(21);
            } else {
                kVar.s(21, strA);
            }
            if (videoDetailPlayBean.getLastAdStartTimeStamp() == null) {
                kVar.m0(22);
            } else {
                kVar.V(22, videoDetailPlayBean.getLastAdStartTimeStamp().longValue());
            }
            if (videoDetailPlayBean.getLastAdEndTimeStamp() == null) {
                kVar.m0(23);
            } else {
                kVar.V(23, videoDetailPlayBean.getLastAdEndTimeStamp().longValue());
            }
            kVar.V(24, videoDetailPlayBean.getRewardPlayed() ? 1L : 0L);
            kVar.V(25, videoDetailPlayBean.getRewardUnlock() ? 1L : 0L);
            kVar.V(26, videoDetailPlayBean.getRewardFree() ? 1L : 0L);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class j implements Callable<List<VideoDetailPlayBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f51148a;

        public j(v vVar) {
            this.f51148a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<VideoDetailPlayBean> call() throws Exception {
            j jVar;
            Cursor cursorC = e6.b.c(e.this.f51123a, this.f51148a, false, null);
            try {
                int iE = e6.a.e(cursorC, "subjectId");
                int iE2 = e6.a.e(cursorC, "id");
                int iE3 = e6.a.e(cursorC, "ep");
                int iE4 = e6.a.e(cursorC, "se");
                int iE5 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE6 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                int iE7 = e6.a.e(cursorC, "coverUrl");
                int iE8 = e6.a.e(cursorC, "thumbnail");
                int iE9 = e6.a.e(cursorC, "videoUrl");
                int iE10 = e6.a.e(cursorC, "timeStamp");
                int iE11 = e6.a.e(cursorC, "subtitleSelectId");
                int iE12 = e6.a.e(cursorC, "totalDuration");
                int iE13 = e6.a.e(cursorC, "subjectDurationSeconds");
                int iE14 = e6.a.e(cursorC, "averageHueLight");
                try {
                    int iE15 = e6.a.e(cursorC, "subjectType");
                    int iE16 = e6.a.e(cursorC, "hasDelete");
                    int iE17 = e6.a.e(cursorC, "playMode");
                    int iE18 = e6.a.e(cursorC, "downloadUrl");
                    int iE19 = e6.a.e(cursorC, "downloadFilePath");
                    int iE20 = e6.a.e(cursorC, "downloadSize");
                    int iE21 = e6.a.e(cursorC, "dubs");
                    int iE22 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE23 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    int iE24 = e6.a.e(cursorC, "rewardPlayed");
                    int iE25 = e6.a.e(cursorC, "rewardUnlock");
                    int iE26 = e6.a.e(cursorC, "rewardFree");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        int i12 = cursorC.getInt(iE3);
                        int i13 = cursorC.getInt(iE4);
                        long j11 = cursorC.getLong(iE5);
                        String string3 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string4 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string5 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        String string6 = cursorC.isNull(iE9) ? null : cursorC.getString(iE9);
                        long j12 = cursorC.getLong(iE10);
                        String string7 = cursorC.isNull(iE11) ? null : cursorC.getString(iE11);
                        Long lValueOf = cursorC.isNull(iE12) ? null : Long.valueOf(cursorC.getLong(iE12));
                        Long lValueOf2 = cursorC.isNull(iE13) ? null : Long.valueOf(cursorC.getLong(iE13));
                        String string8 = cursorC.isNull(i11) ? null : cursorC.getString(i11);
                        int i14 = iE15;
                        int i15 = iE;
                        Integer numValueOf = cursorC.isNull(i14) ? null : Integer.valueOf(cursorC.getInt(i14));
                        int i16 = iE16;
                        boolean z11 = cursorC.getInt(i16) != 0;
                        int i17 = iE17;
                        String string9 = cursorC.isNull(i17) ? null : cursorC.getString(i17);
                        int i18 = iE18;
                        String string10 = cursorC.isNull(i18) ? null : cursorC.getString(i18);
                        int i19 = iE19;
                        String string11 = cursorC.isNull(i19) ? null : cursorC.getString(i19);
                        int i21 = iE20;
                        long j13 = cursorC.getLong(i21);
                        int i22 = iE21;
                        jVar = this;
                        try {
                            ArrayList<String> arrayListB = e.this.f51125c.b(cursorC.isNull(i22) ? null : cursorC.getString(i22));
                            iE22 = iE22;
                            Long lValueOf3 = cursorC.isNull(iE22) ? null : Long.valueOf(cursorC.getLong(iE22));
                            Long lValueOf4 = cursorC.isNull(iE23) ? null : Long.valueOf(cursorC.getLong(iE23));
                            int i23 = cursorC.getInt(iE24);
                            iE24 = iE24;
                            int i24 = iE25;
                            boolean z12 = i23 != 0;
                            int i25 = cursorC.getInt(i24);
                            iE25 = i24;
                            int i26 = iE26;
                            iE26 = i26;
                            arrayList.add(new VideoDetailPlayBean(string, string2, i12, i13, j11, string3, string4, string5, string6, j12, string7, lValueOf, lValueOf2, string8, numValueOf, z11, string9, string10, string11, j13, arrayListB, lValueOf3, lValueOf4, z12, i25 != 0, cursorC.getInt(i26) != 0));
                            iE23 = iE23;
                            iE = i15;
                            iE15 = i14;
                            iE16 = i16;
                            iE17 = i17;
                            iE18 = i18;
                            iE19 = i19;
                            iE13 = iE13;
                            iE20 = i21;
                            iE21 = i22;
                            i11 = i11;
                        } catch (Throwable th2) {
                            th = th2;
                            cursorC.close();
                            jVar.f51148a.release();
                            throw th;
                        }
                    }
                    cursorC.close();
                    this.f51148a.release();
                    return arrayList;
                } catch (Throwable th3) {
                    th = th3;
                    jVar = this;
                }
            } catch (Throwable th4) {
                th = th4;
                jVar = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class k implements Callable<List<VideoDetailPlayBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f51150a;

        public k(v vVar) {
            this.f51150a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<VideoDetailPlayBean> call() throws Exception {
            k kVar;
            Cursor cursorC = e6.b.c(e.this.f51123a, this.f51150a, false, null);
            try {
                int iE = e6.a.e(cursorC, "subjectId");
                int iE2 = e6.a.e(cursorC, "id");
                int iE3 = e6.a.e(cursorC, "ep");
                int iE4 = e6.a.e(cursorC, "se");
                int iE5 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE6 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                int iE7 = e6.a.e(cursorC, "coverUrl");
                int iE8 = e6.a.e(cursorC, "thumbnail");
                int iE9 = e6.a.e(cursorC, "videoUrl");
                int iE10 = e6.a.e(cursorC, "timeStamp");
                int iE11 = e6.a.e(cursorC, "subtitleSelectId");
                int iE12 = e6.a.e(cursorC, "totalDuration");
                int iE13 = e6.a.e(cursorC, "subjectDurationSeconds");
                int iE14 = e6.a.e(cursorC, "averageHueLight");
                try {
                    int iE15 = e6.a.e(cursorC, "subjectType");
                    int iE16 = e6.a.e(cursorC, "hasDelete");
                    int iE17 = e6.a.e(cursorC, "playMode");
                    int iE18 = e6.a.e(cursorC, "downloadUrl");
                    int iE19 = e6.a.e(cursorC, "downloadFilePath");
                    int iE20 = e6.a.e(cursorC, "downloadSize");
                    int iE21 = e6.a.e(cursorC, "dubs");
                    int iE22 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE23 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    int iE24 = e6.a.e(cursorC, "rewardPlayed");
                    int iE25 = e6.a.e(cursorC, "rewardUnlock");
                    int iE26 = e6.a.e(cursorC, "rewardFree");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        int i12 = cursorC.getInt(iE3);
                        int i13 = cursorC.getInt(iE4);
                        long j11 = cursorC.getLong(iE5);
                        String string3 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string4 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string5 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        String string6 = cursorC.isNull(iE9) ? null : cursorC.getString(iE9);
                        long j12 = cursorC.getLong(iE10);
                        String string7 = cursorC.isNull(iE11) ? null : cursorC.getString(iE11);
                        Long lValueOf = cursorC.isNull(iE12) ? null : Long.valueOf(cursorC.getLong(iE12));
                        Long lValueOf2 = cursorC.isNull(iE13) ? null : Long.valueOf(cursorC.getLong(iE13));
                        String string8 = cursorC.isNull(i11) ? null : cursorC.getString(i11);
                        int i14 = iE15;
                        int i15 = iE;
                        Integer numValueOf = cursorC.isNull(i14) ? null : Integer.valueOf(cursorC.getInt(i14));
                        int i16 = iE16;
                        boolean z11 = cursorC.getInt(i16) != 0;
                        int i17 = iE17;
                        String string9 = cursorC.isNull(i17) ? null : cursorC.getString(i17);
                        int i18 = iE18;
                        String string10 = cursorC.isNull(i18) ? null : cursorC.getString(i18);
                        int i19 = iE19;
                        String string11 = cursorC.isNull(i19) ? null : cursorC.getString(i19);
                        int i21 = iE20;
                        long j13 = cursorC.getLong(i21);
                        int i22 = iE21;
                        kVar = this;
                        try {
                            ArrayList<String> arrayListB = e.this.f51125c.b(cursorC.isNull(i22) ? null : cursorC.getString(i22));
                            iE22 = iE22;
                            Long lValueOf3 = cursorC.isNull(iE22) ? null : Long.valueOf(cursorC.getLong(iE22));
                            Long lValueOf4 = cursorC.isNull(iE23) ? null : Long.valueOf(cursorC.getLong(iE23));
                            int i23 = cursorC.getInt(iE24);
                            iE24 = iE24;
                            int i24 = iE25;
                            boolean z12 = i23 != 0;
                            int i25 = cursorC.getInt(i24);
                            iE25 = i24;
                            int i26 = iE26;
                            iE26 = i26;
                            arrayList.add(new VideoDetailPlayBean(string, string2, i12, i13, j11, string3, string4, string5, string6, j12, string7, lValueOf, lValueOf2, string8, numValueOf, z11, string9, string10, string11, j13, arrayListB, lValueOf3, lValueOf4, z12, i25 != 0, cursorC.getInt(i26) != 0));
                            iE23 = iE23;
                            iE = i15;
                            iE15 = i14;
                            iE16 = i16;
                            iE17 = i17;
                            iE18 = i18;
                            iE19 = i19;
                            iE13 = iE13;
                            iE20 = i21;
                            iE21 = i22;
                            i11 = i11;
                        } catch (Throwable th2) {
                            th = th2;
                            cursorC.close();
                            kVar.f51150a.release();
                            throw th;
                        }
                    }
                    cursorC.close();
                    this.f51150a.release();
                    return arrayList;
                } catch (Throwable th3) {
                    th = th3;
                    kVar = this;
                }
            } catch (Throwable th4) {
                th = th4;
                kVar = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class l implements Callable<VideoDetailPlayBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f51152a;

        public l(v vVar) {
            this.f51152a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoDetailPlayBean call() throws Exception {
            l lVar;
            VideoDetailPlayBean videoDetailPlayBean;
            Cursor cursorC = e6.b.c(e.this.f51123a, this.f51152a, false, null);
            try {
                int iE = e6.a.e(cursorC, "subjectId");
                int iE2 = e6.a.e(cursorC, "id");
                int iE3 = e6.a.e(cursorC, "ep");
                int iE4 = e6.a.e(cursorC, "se");
                int iE5 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
                int iE6 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                int iE7 = e6.a.e(cursorC, "coverUrl");
                int iE8 = e6.a.e(cursorC, "thumbnail");
                int iE9 = e6.a.e(cursorC, "videoUrl");
                int iE10 = e6.a.e(cursorC, "timeStamp");
                int iE11 = e6.a.e(cursorC, "subtitleSelectId");
                int iE12 = e6.a.e(cursorC, "totalDuration");
                int iE13 = e6.a.e(cursorC, "subjectDurationSeconds");
                int iE14 = e6.a.e(cursorC, "averageHueLight");
                try {
                    int iE15 = e6.a.e(cursorC, "subjectType");
                    int iE16 = e6.a.e(cursorC, "hasDelete");
                    int iE17 = e6.a.e(cursorC, "playMode");
                    int iE18 = e6.a.e(cursorC, "downloadUrl");
                    int iE19 = e6.a.e(cursorC, "downloadFilePath");
                    int iE20 = e6.a.e(cursorC, "downloadSize");
                    int iE21 = e6.a.e(cursorC, "dubs");
                    int iE22 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE23 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    int iE24 = e6.a.e(cursorC, "rewardPlayed");
                    int iE25 = e6.a.e(cursorC, "rewardUnlock");
                    int iE26 = e6.a.e(cursorC, "rewardFree");
                    if (cursorC.moveToFirst()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        int i11 = cursorC.getInt(iE3);
                        int i12 = cursorC.getInt(iE4);
                        long j11 = cursorC.getLong(iE5);
                        String string3 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string4 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string5 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        String string6 = cursorC.isNull(iE9) ? null : cursorC.getString(iE9);
                        long j12 = cursorC.getLong(iE10);
                        String string7 = cursorC.isNull(iE11) ? null : cursorC.getString(iE11);
                        Long lValueOf = cursorC.isNull(iE12) ? null : Long.valueOf(cursorC.getLong(iE12));
                        Long lValueOf2 = cursorC.isNull(iE13) ? null : Long.valueOf(cursorC.getLong(iE13));
                        String string8 = cursorC.isNull(iE14) ? null : cursorC.getString(iE14);
                        lVar = this;
                        try {
                            videoDetailPlayBean = new VideoDetailPlayBean(string, string2, i11, i12, j11, string3, string4, string5, string6, j12, string7, lValueOf, lValueOf2, string8, cursorC.isNull(r16) ? null : Integer.valueOf(cursorC.getInt(iE15)), cursorC.getInt(iE16) != 0, cursorC.isNull(r18) ? null : cursorC.getString(iE17), cursorC.isNull(r19) ? null : cursorC.getString(iE18), cursorC.isNull(r20) ? null : cursorC.getString(iE19), cursorC.getLong(iE20), e.this.f51125c.b(cursorC.isNull(iE21) ? null : cursorC.getString(iE21)), cursorC.isNull(iE22) ? null : Long.valueOf(cursorC.getLong(iE22)), cursorC.isNull(r24) ? null : Long.valueOf(cursorC.getLong(iE23)), cursorC.getInt(iE24) != 0, cursorC.getInt(iE25) != 0, cursorC.getInt(iE26) != 0);
                        } catch (Throwable th2) {
                            th = th2;
                            cursorC.close();
                            lVar.f51152a.release();
                            throw th;
                        }
                    } else {
                        lVar = this;
                        videoDetailPlayBean = null;
                    }
                    cursorC.close();
                    lVar.f51152a.release();
                    return videoDetailPlayBean;
                } catch (Throwable th3) {
                    th = th3;
                    lVar = this;
                }
            } catch (Throwable th4) {
                th = th4;
                lVar = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class m extends androidx.room.h<VideoDetailPlayBean> {
        public m(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM `video_detail_play` WHERE `subjectId` = ? AND `ep` = ? AND `se` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, VideoDetailPlayBean videoDetailPlayBean) {
            if (videoDetailPlayBean.getSubjectId() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, videoDetailPlayBean.getSubjectId());
            }
            kVar.V(2, videoDetailPlayBean.getEp());
            kVar.V(3, videoDetailPlayBean.getSe());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class n extends androidx.room.h<VideoDetailPlayBean> {
        public n(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE OR ABORT `video_detail_play` SET `subjectId` = ?,`id` = ?,`ep` = ?,`se` = ?,`progress` = ?,`title` = ?,`coverUrl` = ?,`thumbnail` = ?,`videoUrl` = ?,`timeStamp` = ?,`subtitleSelectId` = ?,`totalDuration` = ?,`subjectDurationSeconds` = ?,`averageHueLight` = ?,`subjectType` = ?,`hasDelete` = ?,`playMode` = ?,`downloadUrl` = ?,`downloadFilePath` = ?,`downloadSize` = ?,`dubs` = ?,`lastAdStartTimeStamp` = ?,`lastAdEndTimeStamp` = ?,`rewardPlayed` = ?,`rewardUnlock` = ?,`rewardFree` = ? WHERE `subjectId` = ? AND `ep` = ? AND `se` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, VideoDetailPlayBean videoDetailPlayBean) {
            if (videoDetailPlayBean.getSubjectId() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, videoDetailPlayBean.getSubjectId());
            }
            if (videoDetailPlayBean.getId() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, videoDetailPlayBean.getId());
            }
            kVar.V(3, videoDetailPlayBean.getEp());
            kVar.V(4, videoDetailPlayBean.getSe());
            kVar.V(5, videoDetailPlayBean.getProgress());
            if (videoDetailPlayBean.getTitle() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, videoDetailPlayBean.getTitle());
            }
            if (videoDetailPlayBean.getCoverUrl() == null) {
                kVar.m0(7);
            } else {
                kVar.s(7, videoDetailPlayBean.getCoverUrl());
            }
            if (videoDetailPlayBean.getThumbnail() == null) {
                kVar.m0(8);
            } else {
                kVar.s(8, videoDetailPlayBean.getThumbnail());
            }
            if (videoDetailPlayBean.getVideoUrl() == null) {
                kVar.m0(9);
            } else {
                kVar.s(9, videoDetailPlayBean.getVideoUrl());
            }
            kVar.V(10, videoDetailPlayBean.getTimeStamp());
            if (videoDetailPlayBean.getSubtitleSelectId() == null) {
                kVar.m0(11);
            } else {
                kVar.s(11, videoDetailPlayBean.getSubtitleSelectId());
            }
            if (videoDetailPlayBean.getTotalDuration() == null) {
                kVar.m0(12);
            } else {
                kVar.V(12, videoDetailPlayBean.getTotalDuration().longValue());
            }
            if (videoDetailPlayBean.getSubjectDurationSeconds() == null) {
                kVar.m0(13);
            } else {
                kVar.V(13, videoDetailPlayBean.getSubjectDurationSeconds().longValue());
            }
            if (videoDetailPlayBean.getAverageHueLight() == null) {
                kVar.m0(14);
            } else {
                kVar.s(14, videoDetailPlayBean.getAverageHueLight());
            }
            if (videoDetailPlayBean.getSubjectType() == null) {
                kVar.m0(15);
            } else {
                kVar.V(15, videoDetailPlayBean.getSubjectType().intValue());
            }
            kVar.V(16, videoDetailPlayBean.getHasDelete() ? 1L : 0L);
            if (videoDetailPlayBean.getPlayMode() == null) {
                kVar.m0(17);
            } else {
                kVar.s(17, videoDetailPlayBean.getPlayMode());
            }
            if (videoDetailPlayBean.getDownloadUrl() == null) {
                kVar.m0(18);
            } else {
                kVar.s(18, videoDetailPlayBean.getDownloadUrl());
            }
            if (videoDetailPlayBean.getDownloadFilePath() == null) {
                kVar.m0(19);
            } else {
                kVar.s(19, videoDetailPlayBean.getDownloadFilePath());
            }
            kVar.V(20, videoDetailPlayBean.getDownloadSize());
            String strA = e.this.f51125c.a(videoDetailPlayBean.getDubs());
            if (strA == null) {
                kVar.m0(21);
            } else {
                kVar.s(21, strA);
            }
            if (videoDetailPlayBean.getLastAdStartTimeStamp() == null) {
                kVar.m0(22);
            } else {
                kVar.V(22, videoDetailPlayBean.getLastAdStartTimeStamp().longValue());
            }
            if (videoDetailPlayBean.getLastAdEndTimeStamp() == null) {
                kVar.m0(23);
            } else {
                kVar.V(23, videoDetailPlayBean.getLastAdEndTimeStamp().longValue());
            }
            kVar.V(24, videoDetailPlayBean.getRewardPlayed() ? 1L : 0L);
            kVar.V(25, videoDetailPlayBean.getRewardUnlock() ? 1L : 0L);
            kVar.V(26, videoDetailPlayBean.getRewardFree() ? 1L : 0L);
            if (videoDetailPlayBean.getSubjectId() == null) {
                kVar.m0(27);
            } else {
                kVar.s(27, videoDetailPlayBean.getSubjectId());
            }
            kVar.V(28, videoDetailPlayBean.getEp());
            kVar.V(29, videoDetailPlayBean.getSe());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class o extends SharedSQLiteStatement {
        public o(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM VIDEO_DETAIL_PLAY";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class p extends SharedSQLiteStatement {
        public p(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE VIDEO_DETAIL_PLAY SET subtitleSelectId = ? WHERE subjectId = ? ";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class q extends SharedSQLiteStatement {
        public q(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE VIDEO_DETAIL_PLAY SET progress = ? WHERE se = ? AND ep = ? AND timeStamp =? AND subjectId = ? ";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class r implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoDetailPlayBean f51159a;

        public r(VideoDetailPlayBean videoDetailPlayBean) {
            this.f51159a = videoDetailPlayBean;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            e.this.f51123a.e();
            try {
                e.this.f51124b.k(this.f51159a);
                e.this.f51123a.E();
                return Unit.f68710a;
            } finally {
                e.this.f51123a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class s implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoDetailPlayBean f51161a;

        public s(VideoDetailPlayBean videoDetailPlayBean) {
            this.f51161a = videoDetailPlayBean;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            e.this.f51123a.e();
            try {
                e.this.f51126d.j(this.f51161a);
                e.this.f51123a.E();
                return Unit.f68710a;
            } finally {
                e.this.f51123a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class t implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoDetailPlayBean f51163a;

        public t(VideoDetailPlayBean videoDetailPlayBean) {
            this.f51163a = videoDetailPlayBean;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            e.this.f51123a.e();
            try {
                e.this.f51127e.j(this.f51163a);
                e.this.f51123a.E();
                return Unit.f68710a;
            } finally {
                e.this.f51123a.i();
            }
        }
    }

    public e(RoomDatabase roomDatabase) {
        this.f51123a = roomDatabase;
        this.f51124b = new i(roomDatabase);
        this.f51126d = new m(roomDatabase);
        this.f51127e = new n(roomDatabase);
        this.f51128f = new o(roomDatabase);
        this.f51129g = new p(roomDatabase);
        this.f51130h = new q(roomDatabase);
    }

    public static List<Class<?>> z() {
        return Collections.emptyList();
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object a(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f51123a, true, new a(), continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object b(String str, Continuation<? super VideoDetailPlayBean> continuation) {
        v vVarC = v.c("SELECT * FROM VIDEO_DETAIL_PLAY WHERE subjectId = ? ORDER BY timeStamp DESC LIMIT 1", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f51123a, false, e6.b.a(), new c(vVarC), continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object c(String str, String str2, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f51123a, true, new b(str2, str), continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object d(String str, Continuation<? super VideoDetailPlayBean> continuation) {
        return VideoDetailPlayDao.DefaultImpls.a(this, str, continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object e(String str, int i11, int i12, long j11, long j12, Continuation<? super Unit> continuation) {
        return VideoDetailPlayDao.DefaultImpls.c(this, str, i11, i12, j11, j12, continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object f(String str, Continuation<? super Long> continuation) {
        v vVarC = v.c("SELECT SUM(progress) AS totalProgress FROM VIDEO_DETAIL_PLAY WHERE subjectId = ?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f51123a, false, e6.b.a(), new g(vVarC), continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object g(VideoDetailPlayBean videoDetailPlayBean, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f51123a, true, new s(videoDetailPlayBean), continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object h(int i11, int i12, int i13, Continuation<? super List<VideoDetailPlayBean>> continuation) {
        v vVarC = v.c("SELECT * FROM VIDEO_DETAIL_PLAY WHERE coverUrl IS NOT NULL AND subjectType=? AND subjectDurationSeconds > 0 AND rowid IN (SELECT rowid FROM (SELECT rowid, subjectId, MAX(timeStamp) as maxTimeStamp FROM VIDEO_DETAIL_PLAY WHERE coverUrl IS NOT NULL GROUP BY subjectId)) ORDER BY timeStamp DESC LIMIT ? OFFSET ?;", 3);
        vVarC.V(1, i13);
        vVarC.V(2, i12);
        vVarC.V(3, i11);
        return CoroutinesRoom.a(this.f51123a, false, e6.b.a(), new k(vVarC), continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object i(String str, Continuation<? super List<VideoDetailPlayBean>> continuation) {
        v vVarC = v.c("SELECT * FROM VIDEO_DETAIL_PLAY WHERE subjectId = ? ORDER BY timeStamp DESC", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f51123a, false, e6.b.a(), new CallableC0556e(vVarC), continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object j(VideoDetailPlayBean videoDetailPlayBean, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f51123a, true, new t(videoDetailPlayBean), continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object k(String str, int i11, int i12, Continuation<? super VideoDetailPlayBean> continuation) {
        v vVarC = v.c("SELECT * FROM VIDEO_DETAIL_PLAY WHERE se = ? AND ep = ? AND subjectId = ? ORDER BY timeStamp DESC LIMIT 1", 3);
        vVarC.V(1, i11);
        vVarC.V(2, i12);
        if (str == null) {
            vVarC.m0(3);
        } else {
            vVarC.s(3, str);
        }
        return CoroutinesRoom.a(this.f51123a, false, e6.b.a(), new d(vVarC), continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object l(String str, int i11, int i12, Continuation<? super VideoDetailPlayBean> continuation) {
        v vVarC = v.c("SELECT * FROM VIDEO_DETAIL_PLAY WHERE subjectId = ? AND se = ? AND ep = ?", 3);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        vVarC.V(2, i11);
        vVarC.V(3, i12);
        return CoroutinesRoom.a(this.f51123a, false, e6.b.a(), new f(vVarC), continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object m(long j11, Continuation<? super List<VideoDetailPlayBean>> continuation) {
        v vVarC = v.c("SELECT * FROM VIDEO_DETAIL_PLAY WHERE timeStamp > ? AND coverUrl IS NOT NULL AND subjectId <> '' AND (subjectType = 1 OR subjectType = 2) ORDER BY timeStamp DESC", 1);
        vVarC.V(1, j11);
        return CoroutinesRoom.a(this.f51123a, false, e6.b.a(), new h(vVarC), continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object n(int i11, int i12, Continuation<? super List<VideoDetailPlayBean>> continuation) {
        v vVarC = v.c("SELECT * FROM VIDEO_DETAIL_PLAY WHERE coverUrl IS NOT NULL AND rowid IN (SELECT rowid FROM (SELECT rowid, subjectId, MAX(timeStamp) as maxTimeStamp FROM VIDEO_DETAIL_PLAY WHERE coverUrl IS NOT NULL GROUP BY subjectId)) ORDER BY timeStamp DESC LIMIT ? OFFSET ?;", 2);
        vVarC.V(1, i12);
        vVarC.V(2, i11);
        return CoroutinesRoom.a(this.f51123a, false, e6.b.a(), new j(vVarC), continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object o(String str, Continuation<? super VideoDetailPlayBean> continuation) {
        v vVarC = v.c("SELECT * FROM VIDEO_DETAIL_PLAY WHERE dubs LIKE '%' || ? || '%' ORDER BY timeStamp DESC LIMIT 1", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f51123a, false, e6.b.a(), new l(vVarC), continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object p(VideoDetailPlayBean videoDetailPlayBean, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f51123a, true, new r(videoDetailPlayBean), continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object q(VideoDetailPlayBean videoDetailPlayBean, Continuation<? super Unit> continuation) {
        return VideoDetailPlayDao.DefaultImpls.b(this, videoDetailPlayBean, continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public List<VideoDetailPlayBean> r(long j11) throws Throwable {
        v vVar;
        v vVarC = v.c("SELECT * FROM VIDEO_DETAIL_PLAY WHERE timeStamp > ? AND coverUrl IS NOT NULL AND subjectId <> '' AND (subjectType = 1 OR subjectType = 2) ORDER BY timeStamp DESC", 1);
        vVarC.V(1, j11);
        this.f51123a.d();
        Cursor cursorC = e6.b.c(this.f51123a, vVarC, false, null);
        try {
            int iE = e6.a.e(cursorC, "subjectId");
            int iE2 = e6.a.e(cursorC, "id");
            int iE3 = e6.a.e(cursorC, "ep");
            int iE4 = e6.a.e(cursorC, "se");
            int iE5 = e6.a.e(cursorC, NotificationCompat.CATEGORY_PROGRESS);
            int iE6 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
            int iE7 = e6.a.e(cursorC, "coverUrl");
            int iE8 = e6.a.e(cursorC, "thumbnail");
            int iE9 = e6.a.e(cursorC, "videoUrl");
            int iE10 = e6.a.e(cursorC, "timeStamp");
            int iE11 = e6.a.e(cursorC, "subtitleSelectId");
            int iE12 = e6.a.e(cursorC, "totalDuration");
            int iE13 = e6.a.e(cursorC, "subjectDurationSeconds");
            vVar = vVarC;
            try {
                int iE14 = e6.a.e(cursorC, "averageHueLight");
                try {
                    int iE15 = e6.a.e(cursorC, "subjectType");
                    int iE16 = e6.a.e(cursorC, "hasDelete");
                    int iE17 = e6.a.e(cursorC, "playMode");
                    int iE18 = e6.a.e(cursorC, "downloadUrl");
                    int iE19 = e6.a.e(cursorC, "downloadFilePath");
                    int iE20 = e6.a.e(cursorC, "downloadSize");
                    int iE21 = e6.a.e(cursorC, "dubs");
                    int iE22 = e6.a.e(cursorC, "lastAdStartTimeStamp");
                    int iE23 = e6.a.e(cursorC, "lastAdEndTimeStamp");
                    int iE24 = e6.a.e(cursorC, "rewardPlayed");
                    int iE25 = e6.a.e(cursorC, "rewardUnlock");
                    int iE26 = e6.a.e(cursorC, "rewardFree");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        int i12 = cursorC.getInt(iE3);
                        int i13 = cursorC.getInt(iE4);
                        long j12 = cursorC.getLong(iE5);
                        String string3 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string4 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        String string5 = cursorC.isNull(iE8) ? null : cursorC.getString(iE8);
                        String string6 = cursorC.isNull(iE9) ? null : cursorC.getString(iE9);
                        long j13 = cursorC.getLong(iE10);
                        String string7 = cursorC.isNull(iE11) ? null : cursorC.getString(iE11);
                        Long lValueOf = cursorC.isNull(iE12) ? null : Long.valueOf(cursorC.getLong(iE12));
                        Long lValueOf2 = cursorC.isNull(iE13) ? null : Long.valueOf(cursorC.getLong(iE13));
                        String string8 = cursorC.isNull(i11) ? null : cursorC.getString(i11);
                        int i14 = iE15;
                        int i15 = iE;
                        Integer numValueOf = cursorC.isNull(i14) ? null : Integer.valueOf(cursorC.getInt(i14));
                        int i16 = iE16;
                        boolean z11 = cursorC.getInt(i16) != 0;
                        int i17 = iE17;
                        String string9 = cursorC.isNull(i17) ? null : cursorC.getString(i17);
                        int i18 = iE18;
                        String string10 = cursorC.isNull(i18) ? null : cursorC.getString(i18);
                        int i19 = iE19;
                        String string11 = cursorC.isNull(i19) ? null : cursorC.getString(i19);
                        int i21 = iE20;
                        long j14 = cursorC.getLong(i21);
                        int i22 = iE21;
                        try {
                            ArrayList<String> arrayListB = this.f51125c.b(cursorC.isNull(i22) ? null : cursorC.getString(i22));
                            iE22 = iE22;
                            Long lValueOf3 = cursorC.isNull(iE22) ? null : Long.valueOf(cursorC.getLong(iE22));
                            Long lValueOf4 = cursorC.isNull(iE23) ? null : Long.valueOf(cursorC.getLong(iE23));
                            int i23 = cursorC.getInt(iE24);
                            iE24 = iE24;
                            int i24 = iE25;
                            boolean z12 = i23 != 0;
                            int i25 = cursorC.getInt(i24);
                            iE25 = i24;
                            int i26 = iE26;
                            iE26 = i26;
                            arrayList.add(new VideoDetailPlayBean(string, string2, i12, i13, j12, string3, string4, string5, string6, j13, string7, lValueOf, lValueOf2, string8, numValueOf, z11, string9, string10, string11, j14, arrayListB, lValueOf3, lValueOf4, z12, i25 != 0, cursorC.getInt(i26) != 0));
                            iE23 = iE23;
                            iE = i15;
                            iE15 = i14;
                            iE16 = i16;
                            iE17 = i17;
                            iE18 = i18;
                            iE19 = i19;
                            iE11 = iE11;
                            iE20 = i21;
                            iE21 = i22;
                            i11 = i11;
                        } catch (Throwable th2) {
                            th = th2;
                            cursorC.close();
                            vVar.release();
                            throw th;
                        }
                    }
                    cursorC.close();
                    vVar.release();
                    return arrayList;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            vVar = vVarC;
        }
    }
}
