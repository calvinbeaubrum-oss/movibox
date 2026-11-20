package com.transsion.member.task;

import android.os.Handler;
import android.os.Looper;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.tencent.mmkv.MMKV;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.baselib.utils.ThreadExecute;
import com.transsion.fissionapi.IFissionProvider;
import com.transsion.member.MemberKV;
import com.transsion.member.constants.TaskType;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberTaskGroup;
import com.transsion.memberapi.MemberTaskInfo;
import com.transsion.memberapi.MemberTaskItem;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f53350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ILoginApi f53351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<MemberTaskItem> f53352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f53353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f53354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f53355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f53356g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<MemberTaskItem> f53357h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final IFissionProvider f53358i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f53359j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static MemberTaskItem f53360k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static long f53361l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f53362m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c f53363n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Handler f53364o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Runnable f53365p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f53366q;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements RoomActivityLifecycleCallbacks.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MemberTaskItem f53367a;

        public a(MemberTaskItem memberTaskItem) {
            this.f53367a = memberTaskItem;
        }

        @Override // com.transsion.baselib.report.RoomActivityLifecycleCallbacks.a
        public void onBackgroundStatusChange(boolean z11) {
            if (z11) {
                return;
            }
            TaskCompleteTips taskCompleteTips = new TaskCompleteTips();
            Integer rewardAmount = this.f53367a.getRewardAmount();
            taskCompleteTips.c(rewardAmount != null ? rewardAmount.intValue() : 0);
            RoomActivityLifecycleCallbacks.f51239a.k(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements tr.g {
        @Override // tr.g
        public void a(DownloadBean bean, DownloadException downloadException) {
            Intrinsics.g(bean, "bean");
        }

        @Override // tr.g
        public void b(DownloadBean bean) {
            Intrinsics.g(bean, "bean");
        }

        @Override // tr.g
        public void c(DownloadBean bean, long j11, long j12) {
            Intrinsics.g(bean, "bean");
        }

        @Override // tr.g
        public void d(DownloadBean bean) {
            Intrinsics.g(bean, "bean");
        }

        @Override // tr.g
        public void e(DownloadBean bean, String str) {
            Intrinsics.g(bean, "bean");
            uo.b.a.f(uo.b.f78622a, "TaskManager", "download success " + bean, false, 4, null);
            i iVar = i.f53350a;
            iVar.m();
            iVar.j0(bean.getSubjectType());
        }

        @Override // tr.g
        public void f(DownloadBean bean) {
            Intrinsics.g(bean, "bean");
        }

        @Override // tr.g
        public void g(DownloadBean bean) {
            Intrinsics.g(bean, "bean");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements r00.a {
        @Override // r00.a
        public void onLogin(UserInfo user) {
            Intrinsics.g(user, "user");
            i iVar = i.f53350a;
            iVar.y();
            iVar.O();
            iVar.A();
        }

        @Override // r00.a
        public void onLogout() {
            i iVar = i.f53350a;
            iVar.y();
            iVar.O();
            iVar.A();
        }

        @Override // r00.a
        public void onUpdateUserInfo(UserInfo userInfo) {
            r00.a.C0822a.c(this, userInfo);
        }
    }

    static {
        i iVar = new i();
        f53350a = iVar;
        f53351b = (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        f53352c = new ArrayList();
        f53357h = new ArrayList();
        f53358i = (IFissionProvider) com.alibaba.android.arouter.launcher.a.d().h(IFissionProvider.class);
        iVar.O();
        f53362m = new b();
        f53363n = new c();
        f53364o = new Handler(Looper.getMainLooper());
        f53365p = new Runnable() { // from class: com.transsion.member.task.b
            @Override // java.lang.Runnable
            public final void run() {
                i.C();
            }
        };
        f53366q = 8;
    }

    public static final void C() {
        f53350a.B();
    }

    public static final void P() {
        i iVar = f53350a;
        long jM = iVar.M();
        if (iVar.I("kv_watch_remember_time", 0L) > jM) {
            f53354e = jM;
            long jI = iVar.I("kv_watch_today_time", 0L);
            f53353d = jI;
            f53356g = jI;
            uo.b.a.f(uo.b.f78622a, "TaskManager", "init watch time " + f53353d, false, 4, null);
        }
    }

    public static final void a0() {
        i iVar = f53350a;
        long jM = iVar.M();
        long jI = iVar.I("kv_watch_remember_time", 0L);
        if (1 <= jI && jI < jM) {
            uo.b.a.f(uo.b.f78622a, "TaskManager", "clear last day time " + f53353d, false, 4, null);
            f53353d = 30000L;
        }
        iVar.s();
        f53354e = jM;
        f53356g = f53353d;
        iVar.W("kv_watch_remember_time", System.currentTimeMillis());
        iVar.W("kv_watch_today_time", f53353d);
        uo.b.a.f(uo.b.f78622a, "TaskManager", "save watch time " + f53353d, false, 4, null);
    }

    public static final void n() {
        i iVar = f53350a;
        long jM = iVar.M();
        long jI = iVar.I("kv_watch_download_save_time", 0L);
        int i11 = 0;
        int iH = iVar.H("kv_watch_download_count", 0);
        if (1 > jI || jI >= jM) {
            i11 = iH;
        } else {
            uo.b.a.f(uo.b.f78622a, "TaskManager", "clear download count", false, 4, null);
        }
        iVar.q(i11);
        iVar.W("kv_watch_download_save_time", System.currentTimeMillis());
        iVar.V("kv_watch_download_count", i11 + 1);
        uo.b.a.f(uo.b.f78622a, "TaskManager", "save download count " + f53353d, false, 4, null);
    }

    public static final void p() {
        Integer rewardAmount;
        TaskCompleteTips taskCompleteTips = new TaskCompleteTips();
        MemberTaskItem memberTaskItem = f53360k;
        taskCompleteTips.c((memberTaskItem == null || (rewardAmount = memberTaskItem.getRewardAmount()) == null) ? 0 : rewardAmount.intValue());
    }

    public static final void r(MemberTaskItem taskItem) {
        Intrinsics.g(taskItem, "$taskItem");
        RoomActivityLifecycleCallbacks roomActivityLifecycleCallbacks = RoomActivityLifecycleCallbacks.f51239a;
        if (roomActivityLifecycleCallbacks.i()) {
            roomActivityLifecycleCallbacks.b(new a(taskItem));
            return;
        }
        TaskCompleteTips taskCompleteTips = new TaskCompleteTips();
        Integer rewardAmount = taskItem.getRewardAmount();
        taskCompleteTips.c(rewardAmount != null ? rewardAmount.intValue() : 0);
    }

    public static final void t(MemberTaskItem taskItem) {
        Intrinsics.g(taskItem, "$taskItem");
        TaskCompleteTips taskCompleteTips = new TaskCompleteTips();
        Integer rewardAmount = taskItem.getRewardAmount();
        taskCompleteTips.c(rewardAmount != null ? rewardAmount.intValue() : 0);
    }

    public final void A() {
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).n();
    }

    public final void B() {
        o();
        f53361l = System.currentTimeMillis();
        f53364o.postDelayed(f53365p, 15000L);
    }

    public final boolean D(String str, boolean z11) {
        MMKV mmkvA = MemberKV.f53157a.a();
        UserInfo userInfoP = f53351b.P();
        return mmkvA.getBoolean(str + "_" + (userInfoP != null ? userInfoP.getUserId() : null), z11);
    }

    public final int E() {
        long jI = I("kv_download_app_save_item", 0L);
        int iH = H("kv_download_app_claim", 0);
        if (M() <= jI) {
            return iH;
        }
        u();
        return 0;
    }

    public final int F() {
        int i11 = 0;
        int iH = H("kv_game_download_app_claim", 0);
        if (iH <= 0) {
            return iH;
        }
        long jM = M();
        long jI = I("kv_game_download_app_remember_time", 0L);
        if (1 > jI || jI >= jM) {
            i11 = iH;
        } else {
            uo.b.a.s(uo.b.f78622a, "TaskManager", "游戏app下载，跨天了，重置状态", false, 4, null);
        }
        W("kv_game_download_app_remember_time", System.currentTimeMillis());
        return i11;
    }

    public final long G() {
        long jCurrentTimeMillis = System.currentTimeMillis() - f53361l;
        long jI = I("kv_game_browse_today_time", 0L);
        if (f53361l <= 0 || jCurrentTimeMillis <= 0) {
            jCurrentTimeMillis = 0;
        }
        return (jCurrentTimeMillis + jI) / ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
    }

    public final int H(String str, int i11) {
        MMKV mmkvA = MemberKV.f53157a.a();
        UserInfo userInfoP = f53351b.P();
        return mmkvA.getInt(str + "_" + (userInfoP != null ? userInfoP.getUserId() : null), i11);
    }

    public final long I(String str, long j11) {
        MMKV mmkvA = MemberKV.f53157a.a();
        UserInfo userInfoP = f53351b.P();
        return mmkvA.getLong(str + "_" + (userInfoP != null ? userInfoP.getUserId() : null), j11);
    }

    public final int J() {
        long jI = I("kv_watch_download_save_time", 0L);
        int iH = H("kv_watch_download_count", 0);
        if (M() <= jI) {
            return iH;
        }
        v();
        return 0;
    }

    public final int K() {
        long jI = I("kv_play_save_game_time", 0L);
        long jI2 = I("kv_play_game_time", 0L);
        if (M() <= jI) {
            return (int) (jI2 / ((long) 1000));
        }
        x();
        return 0;
    }

    public final int L() {
        if (f53354e != M()) {
            return 0;
        }
        return (int) (f53353d / ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
    }

    public final long M() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(11, 4);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public final int N() {
        long jI = I("kv_watch_ad_save_item", 0L);
        int iH = H("kv_watch_ad_claim", 0);
        if (M() <= jI) {
            return iH;
        }
        z();
        return 0;
    }

    public final void O() {
        ThreadExecute.f51302b.a().b(new Runnable() { // from class: com.transsion.member.task.c
            @Override // java.lang.Runnable
            public final void run() {
                i.P();
            }
        });
    }

    public final boolean Q() {
        return D("kv_game_browse_complete", false);
    }

    public final void R() {
        f53358i.U(f53359j);
    }

    public final void S(long j11) {
        f53353d += j11 - f53355f;
        f53355f = 0L;
        Z();
    }

    public final void T(long j11) {
        long j12 = f53355f;
        if (j11 > j12) {
            f53353d += j11 - j12;
        }
        f53355f = j11;
        if (f53353d - f53356g > ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) {
            Z();
        }
    }

    public final void U(String str, boolean z11) {
        MMKV mmkvA = MemberKV.f53157a.a();
        UserInfo userInfoP = f53351b.P();
        mmkvA.putBoolean(str + "_" + (userInfoP != null ? userInfoP.getUserId() : null), z11);
    }

    public final void V(String str, int i11) {
        MMKV mmkvA = MemberKV.f53157a.a();
        UserInfo userInfoP = f53351b.P();
        mmkvA.putInt(str + "_" + (userInfoP != null ? userInfoP.getUserId() : null), i11);
    }

    public final void W(String str, long j11) {
        MMKV mmkvA = MemberKV.f53157a.a();
        UserInfo userInfoP = f53351b.P();
        mmkvA.putLong(str + "_" + (userInfoP != null ? userInfoP.getUserId() : null), j11);
    }

    public final void X(MemberTaskInfo memberTaskInfo) {
        List<MemberTaskGroup> arrayList;
        f53352c.clear();
        f53357h.clear();
        if (memberTaskInfo == null || (arrayList = memberTaskInfo.getList()) == null) {
            arrayList = new ArrayList<>();
        }
        Iterator<MemberTaskGroup> it = arrayList.iterator();
        while (it.hasNext()) {
            for (MemberTaskItem memberTaskItem : it.next().getTaskItems()) {
                Integer taskSubType = memberTaskItem.getTaskSubType();
                int value = TaskType.WATCH.getValue();
                if (taskSubType != null && taskSubType.intValue() == value) {
                    f53352c.add(memberTaskItem);
                } else {
                    int value2 = TaskType.DOWNLOAD_MOVIE.getValue();
                    if (taskSubType != null && taskSubType.intValue() == value2) {
                        f53357h.add(memberTaskItem);
                    } else {
                        int value3 = TaskType.GAME_RES_BROWSE.getValue();
                        if (taskSubType != null && taskSubType.intValue() == value3) {
                            f53360k = memberTaskItem;
                        }
                    }
                }
            }
        }
        g0();
    }

    public final void Y(List<MemberTaskItem> list) {
        f53352c.clear();
        f53357h.clear();
        if (list == null) {
            list = new ArrayList<>();
        }
        for (MemberTaskItem memberTaskItem : list) {
            Integer taskSubType = memberTaskItem.getTaskSubType();
            int value = TaskType.WATCH.getValue();
            if (taskSubType != null && taskSubType.intValue() == value) {
                f53352c.add(memberTaskItem);
            } else {
                int value2 = TaskType.DOWNLOAD_MOVIE.getValue();
                if (taskSubType != null && taskSubType.intValue() == value2) {
                    f53357h.add(memberTaskItem);
                } else {
                    int value3 = TaskType.PALM_PAY.getValue();
                    if (taskSubType != null && taskSubType.intValue() == value3) {
                        i0(memberTaskItem);
                    } else {
                        int value4 = TaskType.GAME_RES_BROWSE.getValue();
                        if (taskSubType != null && taskSubType.intValue() == value4) {
                            f53360k = memberTaskItem;
                        } else {
                            uo.b.a.f(uo.b.f78622a, "TaskManager", "taskItem: " + memberTaskItem + " that is not support now, please check it.", false, 4, null);
                        }
                    }
                }
            }
        }
        R();
        g0();
    }

    public final void Z() {
        ThreadExecute.f51302b.a().b(new Runnable() { // from class: com.transsion.member.task.e
            @Override // java.lang.Runnable
            public final void run() {
                i.a0();
            }
        });
    }

    public final void b0() {
        W("kv_download_app_save_item", System.currentTimeMillis());
        V("kv_download_app_claim", 1);
    }

    public final void c0() {
        uo.b.a.f(uo.b.f78622a, "TaskManager", "游戏下载任务完成", false, 4, null);
        W("kv_game_download_app_remember_time", System.currentTimeMillis());
        V("kv_game_download_app_claim", 1);
    }

    public final void d0(long j11) {
        if (j11 > K()) {
            W("kv_play_save_game_time", System.currentTimeMillis());
            W("kv_play_game_time", j11);
        }
    }

    public final void e0() {
        W("kv_watch_ad_save_item", System.currentTimeMillis());
        V("kv_watch_ad_claim", 1);
    }

    public final void f0() {
        if (f53360k == null) {
            return;
        }
        uo.b.a.f(uo.b.f78622a, "TaskManager", "游戏，startGameResDurationTracking", false, 4, null);
        f53361l = System.currentTimeMillis();
        f53364o.post(f53365p);
    }

    public final void g0() {
        com.transsnet.downloader.manager.b.a aVar = com.transsnet.downloader.manager.b.f61062a;
        com.transsnet.downloader.manager.a aVarA = aVar.a(Utils.a());
        b bVar = f53362m;
        aVarA.v(bVar);
        aVar.a(Utils.a()).f(bVar);
        ILoginApi iLoginApi = f53351b;
        c cVar = f53363n;
        iLoginApi.t1(cVar);
        iLoginApi.F(cVar);
    }

    public final void h0() {
        if (f53360k == null) {
            return;
        }
        uo.b.a.f(uo.b.f78622a, "TaskManager", "游戏，stopGameResDurationTracking", false, 4, null);
        o();
        f53364o.removeCallbacksAndMessages(null);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x000f  */
    public final void i0(MemberTaskItem memberTaskItem) {
        boolean z11;
        Integer status = memberTaskItem.getStatus();
        if (status != null) {
            z11 = status.intValue() == 1;
        }
        f53359j = z11;
    }

    public final void j0(int i11) {
        if (f53359j) {
            f53358i.C0(i11);
        }
    }

    public final void m() {
        ThreadExecute.f51302b.a().b(new Runnable() { // from class: com.transsion.member.task.f
            @Override // java.lang.Runnable
            public final void run() {
                i.n();
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:27:0x009a  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a7  */
    public final void o() {
        MemberTaskItem memberTaskItem;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j11 = f53361l;
        long j12 = jCurrentTimeMillis - j11;
        long j13 = 0;
        if (j11 <= 0 || j12 <= 0) {
            return;
        }
        long jM = M();
        long jI = I("kv_game_browse_remember_time", 0L);
        long jI2 = j12 + I("kv_game_browse_today_time", 0L);
        boolean zD = D("kv_game_browse_complete", false);
        if (jM > jI) {
            U("kv_game_browse_complete", false);
            zD = false;
        } else {
            j13 = jI2;
        }
        W("kv_game_browse_remember_time", System.currentTimeMillis());
        if (zD || ((memberTaskItem = f53360k) != null && memberTaskItem.isClaimCompleted())) {
            uo.b.a.s(uo.b.f78622a, "TaskManager", "游戏，统计浏览时长任务已经完成", false, 4, null);
            f53364o.removeCallbacksAndMessages(null);
            return;
        }
        MemberTaskItem memberTaskItem2 = f53360k;
        if (memberTaskItem2 != null) {
            long j14 = j13 / ((long) 1000);
            Intrinsics.d(memberTaskItem2);
            Integer durationCondition = memberTaskItem2.getDurationCondition();
            if (j14 >= (durationCondition != null ? durationCondition.intValue() : 300000)) {
                U("kv_game_browse_complete", true);
                uo.b.a.o(uo.b.f78622a, "TaskManager", new String[]{"游戏，统计浏览时长，任务完成"}, false, 4, null);
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.transsion.member.task.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.p();
                    }
                });
                f53364o.removeCallbacksAndMessages(null);
            } else {
                uo.b.a aVar = uo.b.f78622a;
                String[] strArr = new String[1];
                long j15 = j13 / ((long) 1000);
                MemberTaskItem memberTaskItem3 = f53360k;
                strArr[0] = "游戏，统计浏览时长，任务未完成，curDuration:" + j15 + ", target:" + (memberTaskItem3 != null ? memberTaskItem3.getDurationCondition() : null);
                uo.b.a.o(aVar, "TaskManager", strArr, false, 4, null);
                U("kv_game_browse_complete", false);
            }
        } else {
            uo.b.a aVar2 = uo.b.f78622a;
            String[] strArr2 = new String[1];
            long j16 = j13 / ((long) 1000);
            MemberTaskItem memberTaskItem4 = f53360k;
            if (memberTaskItem4 != null) {
            }
            strArr2[0] = "游戏，统计浏览时长，任务未完成，curDuration:" + j16 + ", target:" + (memberTaskItem4 != null ? memberTaskItem4.getDurationCondition() : null);
            uo.b.a.o(aVar2, "TaskManager", strArr2, false, 4, null);
            U("kv_game_browse_complete", false);
        }
        W("kv_game_browse_today_time", j13);
    }

    public final void q(int i11) {
        for (final MemberTaskItem memberTaskItem : f53357h) {
            Integer timesCondition = memberTaskItem.getTimesCondition();
            if (i11 == (timesCondition != null ? timesCondition.intValue() : 0) - 1) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.transsion.member.task.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.r(memberTaskItem);
                    }
                });
            }
        }
    }

    public final void s() {
        if (f53355f == 0) {
            return;
        }
        for (final MemberTaskItem memberTaskItem : f53352c) {
            Integer durationCondition = memberTaskItem.getDurationCondition();
            long j11 = 1000;
            long jIntValue = durationCondition != null ? durationCondition.intValue() : 0;
            if (f53356g / j11 < jIntValue && f53353d / j11 >= jIntValue) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.transsion.member.task.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.t(memberTaskItem);
                    }
                });
            }
        }
    }

    public final void u() {
        W("kv_download_app_save_item", System.currentTimeMillis());
        V("kv_download_app_claim", 0);
    }

    public final void v() {
        W("kv_watch_download_save_time", System.currentTimeMillis());
        V("kv_watch_download_count", 0);
    }

    public final void w() {
        W("kv_game_download_app_remember_time", System.currentTimeMillis());
        V("kv_game_download_app_claim", 0);
    }

    public final void x() {
        W("kv_play_save_game_time", System.currentTimeMillis());
        W("kv_play_game_time", 0L);
    }

    public final void y() {
        f53353d = 0L;
        f53354e = 0L;
        f53355f = 0L;
        f53356g = 0L;
    }

    public final void z() {
        W("kv_watch_ad_save_item", System.currentTimeMillis());
        V("kv_watch_ad_claim", 0);
    }
}
