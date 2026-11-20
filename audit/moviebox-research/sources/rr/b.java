package rr;

import android.database.Cursor;
import androidx.core.app.NotificationCompat;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.v;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baselib.db.audio.AudioBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements rr.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f75699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.i<AudioBean> f75700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.room.h<AudioBean> f75701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.room.h<AudioBean> f75702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f75703e;

    /* JADX INFO: compiled from: source.java */
    public class a implements Callable<AudioBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f75704a;

        public a(v vVar) {
            this.f75704a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AudioBean call() throws Exception {
            AudioBean audioBean;
            a aVar = this;
            Cursor cursorC = e6.b.c(b.this.f75699a, aVar.f75704a, false, null);
            try {
                int iE = e6.a.e(cursorC, "audioId");
                int iE2 = e6.a.e(cursorC, "cover");
                int iE3 = e6.a.e(cursorC, "duration");
                int iE4 = e6.a.e(cursorC, "size");
                int iE5 = e6.a.e(cursorC, "url");
                int iE6 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                int iE7 = e6.a.e(cursorC, CampaignEx.JSON_KEY_DESC);
                int iE8 = e6.a.e(cursorC, "bitrate");
                int iE9 = e6.a.e(cursorC, "updateTimeStamp");
                int iE10 = e6.a.e(cursorC, "readProcess");
                int iE11 = e6.a.e(cursorC, "localPath");
                int iE12 = e6.a.e(cursorC, "ops");
                int iE13 = e6.a.e(cursorC, "resourceId");
                int iE14 = e6.a.e(cursorC, "postId");
                try {
                    int iE15 = e6.a.e(cursorC, "subjectId");
                    int iE16 = e6.a.e(cursorC, "groupId");
                    int iE17 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                    int iE18 = e6.a.e(cursorC, "subjectTitle");
                    int iE19 = e6.a.e(cursorC, "se");
                    int iE20 = e6.a.e(cursorC, "ep");
                    if (cursorC.moveToFirst()) {
                        audioBean = new AudioBean(cursorC.isNull(iE) ? null : cursorC.getString(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : Long.valueOf(cursorC.getLong(iE3)), cursorC.isNull(iE4) ? null : Long.valueOf(cursorC.getLong(iE4)), cursorC.isNull(iE5) ? null : cursorC.getString(iE5), cursorC.isNull(iE6) ? null : cursorC.getString(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : Integer.valueOf(cursorC.getInt(iE8)), cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9)), cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10)), cursorC.isNull(iE11) ? null : cursorC.getString(iE11), cursorC.isNull(iE12) ? null : cursorC.getString(iE12), cursorC.isNull(iE13) ? null : cursorC.getString(iE13), cursorC.isNull(iE14) ? null : cursorC.getString(iE14), cursorC.isNull(r16) ? null : cursorC.getString(iE15), cursorC.isNull(r17) ? null : cursorC.getString(iE16), cursorC.getInt(iE17), cursorC.isNull(iE18) ? null : cursorC.getString(iE18), cursorC.getInt(iE19), cursorC.getInt(iE20));
                    } else {
                        audioBean = null;
                    }
                    cursorC.close();
                    this.f75704a.release();
                    return audioBean;
                } catch (Throwable th2) {
                    th = th2;
                    aVar = this;
                    cursorC.close();
                    aVar.f75704a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: renamed from: rr.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class CallableC0832b implements Callable<AudioBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f75706a;

        public CallableC0832b(v vVar) {
            this.f75706a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AudioBean call() throws Exception {
            AudioBean audioBean;
            CallableC0832b callableC0832b = this;
            Cursor cursorC = e6.b.c(b.this.f75699a, callableC0832b.f75706a, false, null);
            try {
                int iE = e6.a.e(cursorC, "audioId");
                int iE2 = e6.a.e(cursorC, "cover");
                int iE3 = e6.a.e(cursorC, "duration");
                int iE4 = e6.a.e(cursorC, "size");
                int iE5 = e6.a.e(cursorC, "url");
                int iE6 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                int iE7 = e6.a.e(cursorC, CampaignEx.JSON_KEY_DESC);
                int iE8 = e6.a.e(cursorC, "bitrate");
                int iE9 = e6.a.e(cursorC, "updateTimeStamp");
                int iE10 = e6.a.e(cursorC, "readProcess");
                int iE11 = e6.a.e(cursorC, "localPath");
                int iE12 = e6.a.e(cursorC, "ops");
                int iE13 = e6.a.e(cursorC, "resourceId");
                int iE14 = e6.a.e(cursorC, "postId");
                try {
                    int iE15 = e6.a.e(cursorC, "subjectId");
                    int iE16 = e6.a.e(cursorC, "groupId");
                    int iE17 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                    int iE18 = e6.a.e(cursorC, "subjectTitle");
                    int iE19 = e6.a.e(cursorC, "se");
                    int iE20 = e6.a.e(cursorC, "ep");
                    if (cursorC.moveToFirst()) {
                        audioBean = new AudioBean(cursorC.isNull(iE) ? null : cursorC.getString(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : Long.valueOf(cursorC.getLong(iE3)), cursorC.isNull(iE4) ? null : Long.valueOf(cursorC.getLong(iE4)), cursorC.isNull(iE5) ? null : cursorC.getString(iE5), cursorC.isNull(iE6) ? null : cursorC.getString(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : Integer.valueOf(cursorC.getInt(iE8)), cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9)), cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10)), cursorC.isNull(iE11) ? null : cursorC.getString(iE11), cursorC.isNull(iE12) ? null : cursorC.getString(iE12), cursorC.isNull(iE13) ? null : cursorC.getString(iE13), cursorC.isNull(iE14) ? null : cursorC.getString(iE14), cursorC.isNull(r16) ? null : cursorC.getString(iE15), cursorC.isNull(r17) ? null : cursorC.getString(iE16), cursorC.getInt(iE17), cursorC.isNull(iE18) ? null : cursorC.getString(iE18), cursorC.getInt(iE19), cursorC.getInt(iE20));
                    } else {
                        audioBean = null;
                    }
                    cursorC.close();
                    this.f75706a.release();
                    return audioBean;
                } catch (Throwable th2) {
                    th = th2;
                    callableC0832b = this;
                    cursorC.close();
                    callableC0832b.f75706a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Callable<List<AudioBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f75708a;

        public c(v vVar) {
            this.f75708a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<AudioBean> call() throws Exception {
            c cVar;
            Cursor cursorC = e6.b.c(b.this.f75699a, this.f75708a, false, null);
            try {
                int iE = e6.a.e(cursorC, "audioId");
                int iE2 = e6.a.e(cursorC, "cover");
                int iE3 = e6.a.e(cursorC, "duration");
                int iE4 = e6.a.e(cursorC, "size");
                int iE5 = e6.a.e(cursorC, "url");
                int iE6 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                int iE7 = e6.a.e(cursorC, CampaignEx.JSON_KEY_DESC);
                int iE8 = e6.a.e(cursorC, "bitrate");
                int iE9 = e6.a.e(cursorC, "updateTimeStamp");
                int iE10 = e6.a.e(cursorC, "readProcess");
                int iE11 = e6.a.e(cursorC, "localPath");
                int iE12 = e6.a.e(cursorC, "ops");
                int iE13 = e6.a.e(cursorC, "resourceId");
                int iE14 = e6.a.e(cursorC, "postId");
                try {
                    int iE15 = e6.a.e(cursorC, "subjectId");
                    int iE16 = e6.a.e(cursorC, "groupId");
                    int iE17 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                    int iE18 = e6.a.e(cursorC, "subjectTitle");
                    int iE19 = e6.a.e(cursorC, "se");
                    int iE20 = e6.a.e(cursorC, "ep");
                    int i11 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        String string = cursorC.isNull(iE) ? null : cursorC.getString(iE);
                        String string2 = cursorC.isNull(iE2) ? null : cursorC.getString(iE2);
                        Long lValueOf = cursorC.isNull(iE3) ? null : Long.valueOf(cursorC.getLong(iE3));
                        Long lValueOf2 = cursorC.isNull(iE4) ? null : Long.valueOf(cursorC.getLong(iE4));
                        String string3 = cursorC.isNull(iE5) ? null : cursorC.getString(iE5);
                        String string4 = cursorC.isNull(iE6) ? null : cursorC.getString(iE6);
                        String string5 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        Integer numValueOf = cursorC.isNull(iE8) ? null : Integer.valueOf(cursorC.getInt(iE8));
                        Long lValueOf3 = cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9));
                        Long lValueOf4 = cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10));
                        String string6 = cursorC.isNull(iE11) ? null : cursorC.getString(iE11);
                        String string7 = cursorC.isNull(iE12) ? null : cursorC.getString(iE12);
                        String string8 = cursorC.isNull(iE13) ? null : cursorC.getString(iE13);
                        String string9 = cursorC.isNull(i11) ? null : cursorC.getString(i11);
                        int i12 = iE15;
                        int i13 = iE;
                        String string10 = cursorC.isNull(i12) ? null : cursorC.getString(i12);
                        int i14 = iE16;
                        String string11 = cursorC.isNull(i14) ? null : cursorC.getString(i14);
                        int i15 = iE17;
                        int i16 = cursorC.getInt(i15);
                        iE18 = iE18;
                        String string12 = cursorC.isNull(iE18) ? null : cursorC.getString(iE18);
                        int i17 = cursorC.getInt(iE19);
                        iE19 = iE19;
                        int i18 = iE20;
                        iE20 = i18;
                        arrayList.add(new AudioBean(string, string2, lValueOf, lValueOf2, string3, string4, string5, numValueOf, lValueOf3, lValueOf4, string6, string7, string8, string9, string10, string11, i16, string12, i17, cursorC.getInt(i18)));
                        iE = i13;
                        iE15 = i12;
                        iE16 = i14;
                        iE17 = i15;
                        i11 = i11;
                    }
                    cursorC.close();
                    this.f75708a.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    cVar = this;
                    cursorC.close();
                    cVar.f75708a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cVar = this;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends androidx.room.i<AudioBean> {
        public d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `audio` (`audioId`,`cover`,`duration`,`size`,`url`,`title`,`desc`,`bitrate`,`updateTimeStamp`,`readProcess`,`localPath`,`ops`,`resourceId`,`postId`,`subjectId`,`groupId`,`status`,`subjectTitle`,`se`,`ep`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, AudioBean audioBean) {
            if (audioBean.getAudioUrl() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, audioBean.getAudioUrl());
            }
            if (audioBean.getCover() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, audioBean.getCover());
            }
            if (audioBean.getDuration() == null) {
                kVar.m0(3);
            } else {
                kVar.V(3, audioBean.getDuration().longValue());
            }
            if (audioBean.getSize() == null) {
                kVar.m0(4);
            } else {
                kVar.V(4, audioBean.getSize().longValue());
            }
            if (audioBean.getUrl() == null) {
                kVar.m0(5);
            } else {
                kVar.s(5, audioBean.getUrl());
            }
            if (audioBean.getTitle() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, audioBean.getTitle());
            }
            if (audioBean.getDesc() == null) {
                kVar.m0(7);
            } else {
                kVar.s(7, audioBean.getDesc());
            }
            if (audioBean.getBitrate() == null) {
                kVar.m0(8);
            } else {
                kVar.V(8, audioBean.getBitrate().intValue());
            }
            if (audioBean.getUpdateTimeStamp() == null) {
                kVar.m0(9);
            } else {
                kVar.V(9, audioBean.getUpdateTimeStamp().longValue());
            }
            if (audioBean.getReadProcess() == null) {
                kVar.m0(10);
            } else {
                kVar.V(10, audioBean.getReadProcess().longValue());
            }
            if (audioBean.getLocalPath() == null) {
                kVar.m0(11);
            } else {
                kVar.s(11, audioBean.getLocalPath());
            }
            if (audioBean.getOps() == null) {
                kVar.m0(12);
            } else {
                kVar.s(12, audioBean.getOps());
            }
            if (audioBean.getResourceId() == null) {
                kVar.m0(13);
            } else {
                kVar.s(13, audioBean.getResourceId());
            }
            if (audioBean.getPostId() == null) {
                kVar.m0(14);
            } else {
                kVar.s(14, audioBean.getPostId());
            }
            if (audioBean.getSubjectId() == null) {
                kVar.m0(15);
            } else {
                kVar.s(15, audioBean.getSubjectId());
            }
            if (audioBean.getGroupId() == null) {
                kVar.m0(16);
            } else {
                kVar.s(16, audioBean.getGroupId());
            }
            kVar.V(17, audioBean.getStatus());
            if (audioBean.getSubjectTitle() == null) {
                kVar.m0(18);
            } else {
                kVar.s(18, audioBean.getSubjectTitle());
            }
            kVar.V(19, audioBean.getSe());
            kVar.V(20, audioBean.getEp());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends androidx.room.h<AudioBean> {
        public e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM `audio` WHERE `audioId` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, AudioBean audioBean) {
            if (audioBean.getAudioUrl() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, audioBean.getAudioUrl());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends androidx.room.h<AudioBean> {
        public f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE OR ABORT `audio` SET `audioId` = ?,`cover` = ?,`duration` = ?,`size` = ?,`url` = ?,`title` = ?,`desc` = ?,`bitrate` = ?,`updateTimeStamp` = ?,`readProcess` = ?,`localPath` = ?,`ops` = ?,`resourceId` = ?,`postId` = ?,`subjectId` = ?,`groupId` = ?,`status` = ?,`subjectTitle` = ?,`se` = ?,`ep` = ? WHERE `audioId` = ?";
        }

        @Override // androidx.room.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(g6.k kVar, AudioBean audioBean) {
            if (audioBean.getAudioUrl() == null) {
                kVar.m0(1);
            } else {
                kVar.s(1, audioBean.getAudioUrl());
            }
            if (audioBean.getCover() == null) {
                kVar.m0(2);
            } else {
                kVar.s(2, audioBean.getCover());
            }
            if (audioBean.getDuration() == null) {
                kVar.m0(3);
            } else {
                kVar.V(3, audioBean.getDuration().longValue());
            }
            if (audioBean.getSize() == null) {
                kVar.m0(4);
            } else {
                kVar.V(4, audioBean.getSize().longValue());
            }
            if (audioBean.getUrl() == null) {
                kVar.m0(5);
            } else {
                kVar.s(5, audioBean.getUrl());
            }
            if (audioBean.getTitle() == null) {
                kVar.m0(6);
            } else {
                kVar.s(6, audioBean.getTitle());
            }
            if (audioBean.getDesc() == null) {
                kVar.m0(7);
            } else {
                kVar.s(7, audioBean.getDesc());
            }
            if (audioBean.getBitrate() == null) {
                kVar.m0(8);
            } else {
                kVar.V(8, audioBean.getBitrate().intValue());
            }
            if (audioBean.getUpdateTimeStamp() == null) {
                kVar.m0(9);
            } else {
                kVar.V(9, audioBean.getUpdateTimeStamp().longValue());
            }
            if (audioBean.getReadProcess() == null) {
                kVar.m0(10);
            } else {
                kVar.V(10, audioBean.getReadProcess().longValue());
            }
            if (audioBean.getLocalPath() == null) {
                kVar.m0(11);
            } else {
                kVar.s(11, audioBean.getLocalPath());
            }
            if (audioBean.getOps() == null) {
                kVar.m0(12);
            } else {
                kVar.s(12, audioBean.getOps());
            }
            if (audioBean.getResourceId() == null) {
                kVar.m0(13);
            } else {
                kVar.s(13, audioBean.getResourceId());
            }
            if (audioBean.getPostId() == null) {
                kVar.m0(14);
            } else {
                kVar.s(14, audioBean.getPostId());
            }
            if (audioBean.getSubjectId() == null) {
                kVar.m0(15);
            } else {
                kVar.s(15, audioBean.getSubjectId());
            }
            if (audioBean.getGroupId() == null) {
                kVar.m0(16);
            } else {
                kVar.s(16, audioBean.getGroupId());
            }
            kVar.V(17, audioBean.getStatus());
            if (audioBean.getSubjectTitle() == null) {
                kVar.m0(18);
            } else {
                kVar.s(18, audioBean.getSubjectTitle());
            }
            kVar.V(19, audioBean.getSe());
            kVar.V(20, audioBean.getEp());
            if (audioBean.getAudioUrl() == null) {
                kVar.m0(21);
            } else {
                kVar.s(21, audioBean.getAudioUrl());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends SharedSQLiteStatement {
        public g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM Audio";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioBean f75714a;

        public h(AudioBean audioBean) {
            this.f75714a = audioBean;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f75699a.e();
            try {
                b.this.f75700b.k(this.f75714a);
                b.this.f75699a.E();
                return Unit.f68710a;
            } finally {
                b.this.f75699a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioBean f75716a;

        public i(AudioBean audioBean) {
            this.f75716a = audioBean;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f75699a.e();
            try {
                b.this.f75701c.j(this.f75716a);
                b.this.f75699a.E();
                return Unit.f68710a;
            } finally {
                b.this.f75699a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class j implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioBean f75718a;

        public j(AudioBean audioBean) {
            this.f75718a = audioBean;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            b.this.f75699a.e();
            try {
                b.this.f75702d.j(this.f75718a);
                b.this.f75699a.E();
                return Unit.f68710a;
            } finally {
                b.this.f75699a.i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class k implements Callable<Unit> {
        public k() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            g6.k kVarB = b.this.f75703e.b();
            b.this.f75699a.e();
            try {
                kVarB.F();
                b.this.f75699a.E();
                return Unit.f68710a;
            } finally {
                b.this.f75699a.i();
                b.this.f75703e.h(kVarB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class l implements Callable<AudioBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f75721a;

        public l(v vVar) {
            this.f75721a = vVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AudioBean call() throws Exception {
            AudioBean audioBean;
            l lVar = this;
            Cursor cursorC = e6.b.c(b.this.f75699a, lVar.f75721a, false, null);
            try {
                int iE = e6.a.e(cursorC, "audioId");
                int iE2 = e6.a.e(cursorC, "cover");
                int iE3 = e6.a.e(cursorC, "duration");
                int iE4 = e6.a.e(cursorC, "size");
                int iE5 = e6.a.e(cursorC, "url");
                int iE6 = e6.a.e(cursorC, CampaignEx.JSON_KEY_TITLE);
                int iE7 = e6.a.e(cursorC, CampaignEx.JSON_KEY_DESC);
                int iE8 = e6.a.e(cursorC, "bitrate");
                int iE9 = e6.a.e(cursorC, "updateTimeStamp");
                int iE10 = e6.a.e(cursorC, "readProcess");
                int iE11 = e6.a.e(cursorC, "localPath");
                int iE12 = e6.a.e(cursorC, "ops");
                int iE13 = e6.a.e(cursorC, "resourceId");
                int iE14 = e6.a.e(cursorC, "postId");
                try {
                    int iE15 = e6.a.e(cursorC, "subjectId");
                    int iE16 = e6.a.e(cursorC, "groupId");
                    int iE17 = e6.a.e(cursorC, NotificationCompat.CATEGORY_STATUS);
                    int iE18 = e6.a.e(cursorC, "subjectTitle");
                    int iE19 = e6.a.e(cursorC, "se");
                    int iE20 = e6.a.e(cursorC, "ep");
                    if (cursorC.moveToFirst()) {
                        audioBean = new AudioBean(cursorC.isNull(iE) ? null : cursorC.getString(iE), cursorC.isNull(iE2) ? null : cursorC.getString(iE2), cursorC.isNull(iE3) ? null : Long.valueOf(cursorC.getLong(iE3)), cursorC.isNull(iE4) ? null : Long.valueOf(cursorC.getLong(iE4)), cursorC.isNull(iE5) ? null : cursorC.getString(iE5), cursorC.isNull(iE6) ? null : cursorC.getString(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : Integer.valueOf(cursorC.getInt(iE8)), cursorC.isNull(iE9) ? null : Long.valueOf(cursorC.getLong(iE9)), cursorC.isNull(iE10) ? null : Long.valueOf(cursorC.getLong(iE10)), cursorC.isNull(iE11) ? null : cursorC.getString(iE11), cursorC.isNull(iE12) ? null : cursorC.getString(iE12), cursorC.isNull(iE13) ? null : cursorC.getString(iE13), cursorC.isNull(iE14) ? null : cursorC.getString(iE14), cursorC.isNull(r16) ? null : cursorC.getString(iE15), cursorC.isNull(r17) ? null : cursorC.getString(iE16), cursorC.getInt(iE17), cursorC.isNull(iE18) ? null : cursorC.getString(iE18), cursorC.getInt(iE19), cursorC.getInt(iE20));
                    } else {
                        audioBean = null;
                    }
                    cursorC.close();
                    this.f75721a.release();
                    return audioBean;
                } catch (Throwable th2) {
                    th = th2;
                    lVar = this;
                    cursorC.close();
                    lVar.f75721a.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f75699a = roomDatabase;
        this.f75700b = new d(roomDatabase);
        this.f75701c = new e(roomDatabase);
        this.f75702d = new f(roomDatabase);
        this.f75703e = new g(roomDatabase);
    }

    public static List<Class<?>> n() {
        return Collections.emptyList();
    }

    @Override // rr.a
    public Object a(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f75699a, true, new k(), continuation);
    }

    @Override // rr.a
    public Object b(AudioBean audioBean, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f75699a, true, new i(audioBean), continuation);
    }

    @Override // rr.a
    public Object c(String str, Continuation<? super AudioBean> continuation) {
        v vVarC = v.c("SELECT * FROM Audio WHERE audioId = ?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f75699a, false, e6.b.a(), new l(vVarC), continuation);
    }

    @Override // rr.a
    public Object d(String str, Continuation<? super AudioBean> continuation) {
        v vVarC = v.c("SELECT * FROM Audio WHERE resourceId = ?", 1);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        return CoroutinesRoom.a(this.f75699a, false, e6.b.a(), new a(vVarC), continuation);
    }

    @Override // rr.a
    public Object e(Continuation<? super List<AudioBean>> continuation) {
        v vVarC = v.c("SELECT * FROM Audio ORDER BY updateTimeStamp DESC", 0);
        return CoroutinesRoom.a(this.f75699a, false, e6.b.a(), new c(vVarC), continuation);
    }

    @Override // rr.a
    public Object f(AudioBean audioBean, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f75699a, true, new j(audioBean), continuation);
    }

    @Override // rr.a
    public Object g(String str, String str2, Continuation<? super AudioBean> continuation) {
        v vVarC = v.c("SELECT * FROM Audio WHERE postId = ? AND subjectId =?", 2);
        if (str == null) {
            vVarC.m0(1);
        } else {
            vVarC.s(1, str);
        }
        if (str2 == null) {
            vVarC.m0(2);
        } else {
            vVarC.s(2, str2);
        }
        return CoroutinesRoom.a(this.f75699a, false, e6.b.a(), new CallableC0832b(vVarC), continuation);
    }

    @Override // rr.a
    public Object h(AudioBean audioBean, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f75699a, true, new h(audioBean), continuation);
    }
}
