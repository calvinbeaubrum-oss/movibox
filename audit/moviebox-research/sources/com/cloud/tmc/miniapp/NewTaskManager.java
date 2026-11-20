package com.cloud.tmc.miniapp;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.service.EnvironmentService;
import com.cloud.tmc.miniapp.process.AppRecord;
import com.cloud.tmc.miniapp.ui.multiprogress.MiniAppMiniProcessActivity;
import com.cloud.tmc.miniapp.ui.multiprogress.MiniSubActivity1;
import com.cloud.tmc.miniapp.ui.multiprogress.MiniSubActivity2;
import com.cloud.tmc.miniapp.ui.multiprogress.MiniSubActivity3;
import com.cloud.tmc.miniapp.ui.multiprogress.MiniSubActivity4;
import com.cloud.tmc.miniutils.util.e0;
import hd.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class NewTaskManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f31301b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<NewTaskManager> f31302c = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<NewTaskManager>() { // from class: com.cloud.tmc.miniapp.NewTaskManager$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NewTaskManager invoke() {
            return new NewTaskManager(null);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<Boolean> f31303d = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<Boolean>() { // from class: com.cloud.tmc.miniapp.NewTaskManager$Companion$enableTaskStorage$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            boolean zB = true;
            try {
                zB = MiniAppConfigHelper.f30370a.b("miniesti", true);
            } catch (Throwable unused) {
            }
            return Boolean.valueOf(zB);
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<b> f31304e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<TaskModel> f31305f = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f31306g = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f31307a;

    /* JADX INFO: compiled from: source.java */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getCurrentIdleProcessNum() {
            b.a aVar = b.f31311f;
            return getCurrentProcessNumByStatus(aVar.b()) + getCurrentProcessNumByStatus(aVar.c());
        }

        private final int getCurrentProcessNumByStatus(int i11) {
            Iterator it = NewTaskManager.f31304e.iterator();
            int i12 = 0;
            while (it.hasNext()) {
                if (((b) it.next()).h() == i11) {
                    i12++;
                }
            }
            return i12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getCurrentRunningProcessNum() {
            return getCurrentProcessNumByStatus(b.f31311f.d());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getEnableTaskStorage() {
            return ((Boolean) NewTaskManager.f31303d.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void resetProcessInfoToStatus(b bVar, int i11) {
            if (bVar != null) {
                bVar.i(null);
            }
            if (bVar != null) {
                bVar.j(0L);
            }
            if (bVar == null) {
                return;
            }
            bVar.k(i11);
        }

        public final NewTaskManager getInstance() {
            return (NewTaskManager) NewTaskManager.f31302c.getValue();
        }

        public final void updateTaskIdByAppId(String str, int i11) {
            if (getInstance().h(str) && !getInstance().f(str)) {
                int i12 = 0;
                for (b bVar : NewTaskManager.f31304e) {
                    if (!TextUtils.isEmpty(str) && Intrinsics.b(str, bVar.g())) {
                        bVar.l(i11);
                        if (getEnableTaskStorage()) {
                            KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
                            Application applicationA = e0.a();
                            String str2 = "miniapp_task_info_" + i12;
                            if (str == null) {
                                str = "";
                            }
                            kVStorageProxy.putString(applicationA, "minisdk_storage", str2, str);
                            TmcLogger.c("NewTaskManager", "saveUpdateTaskIdByAppId:" + bVar.g());
                            return;
                        }
                        return;
                    }
                    i12++;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class TaskModel extends rc.b {
        private String childAppId;
        private String rootAppId;

        public TaskModel(String rootAppId, String childAppId) {
            Intrinsics.g(rootAppId, "rootAppId");
            Intrinsics.g(childAppId, "childAppId");
            this.rootAppId = rootAppId;
            this.childAppId = childAppId;
        }

        public /* synthetic */ TaskModel(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i11 & 2) != 0 ? "" : str2);
        }

        public static /* synthetic */ TaskModel copy$default(TaskModel taskModel, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = taskModel.rootAppId;
            }
            if ((i11 & 2) != 0) {
                str2 = taskModel.childAppId;
            }
            return taskModel.copy(str, str2);
        }

        public final String component1() {
            return this.rootAppId;
        }

        public final String component2() {
            return this.childAppId;
        }

        public final TaskModel copy(String rootAppId, String childAppId) {
            Intrinsics.g(rootAppId, "rootAppId");
            Intrinsics.g(childAppId, "childAppId");
            return new TaskModel(rootAppId, childAppId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaskModel)) {
                return false;
            }
            TaskModel taskModel = (TaskModel) obj;
            return Intrinsics.b(this.rootAppId, taskModel.rootAppId) && Intrinsics.b(this.childAppId, taskModel.childAppId);
        }

        public final String getChildAppId() {
            return this.childAppId;
        }

        public final String getRootAppId() {
            return this.rootAppId;
        }

        public int hashCode() {
            return this.childAppId.hashCode() + (this.rootAppId.hashCode() * 31);
        }

        public final void setChildAppId(String str) {
            Intrinsics.g(str, "<set-?>");
            this.childAppId = str;
        }

        public final void setRootAppId(String str) {
            Intrinsics.g(str, "<set-?>");
            this.rootAppId = str;
        }

        public String toString() {
            StringBuilder sbA = j.a("TaskModel(rootAppId=");
            sbA.append(this.rootAppId);
            sbA.append(", childAppId=");
            sbA.append(this.childAppId);
            sbA.append(')');
            return sbA.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Class<? extends MiniAppMiniProcessActivity> f31308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Void f31309b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f31310c;

        public final Class<? extends MiniAppMiniProcessActivity> a() {
            return this.f31308a;
        }

        public final String b() {
            return this.f31310c;
        }

        public final void c(Class<? extends MiniAppMiniProcessActivity> cls) {
            this.f31308a = cls;
        }

        public final void d(String str) {
            this.f31310c = str;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.b(this.f31308a, aVar.f31308a) && Intrinsics.b(this.f31309b, aVar.f31309b) && Intrinsics.b(this.f31310c, aVar.f31310c);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static int f31312g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f31318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f31319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f31320c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f31321d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f31322e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f31311f = new a(null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static int f31313h = 1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static int f31314i = 2;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static int f31315j = 3;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static int f31316k = 4;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static int f31317l = 5;

        /* JADX INFO: compiled from: source.java */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return b.f31312g;
            }

            public final int b() {
                return b.f31313h;
            }

            public final int c() {
                return b.f31317l;
            }

            public final int d() {
                return b.f31314i;
            }

            public final int e() {
                return b.f31316k;
            }
        }

        public b(a activityInfo) {
            Intrinsics.g(activityInfo, "activityInfo");
            this.f31319b = f31312g;
            this.f31318a = activityInfo;
        }

        public final a f() {
            return this.f31318a;
        }

        public final String g() {
            return this.f31320c;
        }

        public final int h() {
            return this.f31319b;
        }

        public final void i(String str) {
            this.f31320c = str;
        }

        public final void j(long j11) {
            this.f31321d = j11;
        }

        public final void k(int i11) {
            this.f31319b = i11;
        }

        public final void l(int i11) {
            this.f31322e = i11;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("ProcessInfo:");
            sb2.append(this.f31318a.b());
            sb2.append(",activityName:");
            Class<? extends MiniAppMiniProcessActivity> clsA = this.f31318a.a();
            sb2.append(clsA != null ? clsA.getSimpleName() : null);
            sb2.append(",status:");
            sb2.append(this.f31319b);
            sb2.append(",appId:");
            sb2.append(this.f31320c);
            sb2.append(",apptoken:");
            sb2.append(this.f31321d);
            String string = sb2.toString();
            Intrinsics.f(string, "builder.append(mActivity…end(mAppToken).toString()");
            return string;
        }
    }

    public NewTaskManager() {
        a aVar = new a();
        aVar.c(MiniSubActivity1.class);
        aVar.d(":mini");
        b bVar = new b(aVar);
        List<b> list = f31304e;
        list.add(bVar);
        a aVar2 = new a();
        aVar2.c(MiniSubActivity2.class);
        aVar2.d(":mini");
        list.add(new b(aVar2));
        a aVar3 = new a();
        aVar3.c(MiniSubActivity3.class);
        aVar3.d(":mini");
        list.add(new b(aVar3));
        a aVar4 = new a();
        aVar4.c(MiniSubActivity4.class);
        aVar4.d(":mini");
        list.add(new b(aVar4));
    }

    public /* synthetic */ NewTaskManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void A(String appId, String childAppId) {
        Object next;
        Intrinsics.g(appId, "appId");
        Intrinsics.g(childAppId, "childAppId");
        if (h(appId)) {
            synchronized (f31301b.getInstance()) {
                try {
                    TmcLogger.c("NewTaskManager", "moveToForeground:" + appId);
                    b bVarY = y(appId);
                    if (bVarY != null) {
                        if (bVarY.f() != null) {
                            bVarY.k(b.f31311f.d());
                            Iterator<T> it = f31305f.iterator();
                            do {
                                if (!it.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it.next();
                            } while (!Intrinsics.b(appId, ((TaskModel) next).getRootAppId()));
                            TaskModel taskModel = (TaskModel) next;
                            if (taskModel == null) {
                                taskModel = new TaskModel(appId, childAppId);
                            }
                            taskModel.setChildAppId(childAppId);
                            ConcurrentLinkedQueue<TaskModel> concurrentLinkedQueue = f31305f;
                            concurrentLinkedQueue.remove(taskModel);
                            concurrentLinkedQueue.add(taskModel);
                        } else {
                            TmcLogger.f("NewTaskManager", "moveToForeground:Can't find target in sActivityStack?");
                            Unit unit = Unit.f68710a;
                        }
                    }
                    TmcLogger.c("NewTaskManager", "moveToForeground finish");
                } catch (Throwable th2) {
                    try {
                        TmcLogger.g("NewTaskManager", "moveToForeground exception:", th2);
                        Unit unit2 = Unit.f68710a;
                        TmcLogger.c("NewTaskManager", "moveToForeground finish");
                    } catch (Throwable th3) {
                        TmcLogger.c("NewTaskManager", "moveToForeground finish");
                        C();
                        throw th3;
                    }
                }
                C();
            }
        }
    }

    public final a B(Context context, AppRecord appRecord) {
        Object next;
        String rootAppId;
        Intrinsics.g(context, "context");
        Intrinsics.g(appRecord, "appRecord");
        try {
            if (!h(appRecord.getAppId()) || j(appRecord.getAppId())) {
                return null;
            }
        } catch (Throwable th2) {
            TmcLogger.g("NewTaskManager", "getNextLaunchActivityInfo error", th2);
        }
        try {
            synchronized (f31301b.getInstance()) {
                try {
                    if (!this.f31307a) {
                        this.f31307a = true;
                        J();
                    }
                } catch (Throwable th3) {
                    try {
                        TmcLogger.g("NewTaskManager", "updateConfig error", th3);
                    } catch (Throwable th4) {
                        throw th4;
                    }
                }
                String appId = appRecord.getAppId();
                Iterator<T> it = f31304e.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.b(((b) next).g(), appId));
                b bVar = (b) next;
                if (bVar != null) {
                    TmcLogger.c("NewTaskManager", "preLaunchActivity: current activity , appId:" + appId);
                    a aVarF = bVar.f();
                    TmcLogger.c("NewTaskManager", "preLaunchActivity finish");
                    C();
                    return aVarF;
                }
                int currentRunningProcessNum = f31301b.getCurrentRunningProcessNum();
                if (currentRunningProcessNum >= t()) {
                    TmcLogger.c("NewTaskManager", "currentRunningProcessNum：" + currentRunningProcessNum);
                    TaskModel taskModelPoll = f31305f.poll();
                    if (taskModelPoll == null || (rootAppId = taskModelPoll.getRootAppId()) == null) {
                        rootAppId = "";
                    }
                    TmcLogger.c("NewTaskManager", "oldAppId：" + rootAppId);
                    H(rootAppId, true);
                }
                a aVarU = u();
                if (aVarU == null) {
                    Unit unit = Unit.f68710a;
                    return null;
                }
                e(appId, appRecord.getStartToken(), aVarU);
                TmcLogger.c("NewTaskManager", "preLaunchActivity finish");
                C();
                return aVarU;
            }
        } catch (Throwable th5) {
            try {
                TmcLogger.g("NewTaskManager", "preLaunchActivity exception:", th5);
            } finally {
                TmcLogger.c("NewTaskManager", "preLaunchActivity finish");
                C();
            }
        }
    }

    public final void C() {
    }

    public final synchronized void D(b bVar) {
        if (bVar != null) {
            bVar.k(b.f31311f.e());
        }
    }

    public final void E(String appId) {
        Intrinsics.g(appId, "appId");
        Companion companion = f31301b;
        synchronized (companion.getInstance()) {
            if (j(appId)) {
                TaskModel taskModelPeek = f31305f.peek();
                if (Intrinsics.b(taskModelPeek != null ? taskModelPeek.getChildAppId() : null, appId)) {
                    taskModelPeek.setChildAppId("");
                    return;
                }
            }
            b bVarY = y(appId);
            if (bVarY == null) {
                return;
            }
            I(appId);
            companion.resetProcessInfoToStatus(bVarY, b.f31311f.a());
            Unit unit = Unit.f68710a;
        }
    }

    public final void F(String str) {
        Object next;
        try {
            if (h(str)) {
                return;
            }
            Iterator<T> it = f31305f.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.b(str, ((TaskModel) next).getRootAppId()));
            TaskModel taskModel = (TaskModel) next;
            if (taskModel != null) {
                f31305f.remove(taskModel);
            }
            TmcLogger.c("NewTaskManager", "removeActivityStack: remove appId:" + str);
        } catch (Throwable th2) {
            TmcLogger.h("NewTaskManager", th2);
        }
    }

    public final boolean G(Class<?> cls, b bVar) {
        if (cls == null) {
            TmcLogger.c("NewTaskManager", "removeFromRecentTasksList: className null");
            return false;
        }
        try {
            f31301b.resetProcessInfoToStatus(bVar, b.f31311f.a());
        } catch (Throwable unused) {
        }
        try {
            Object systemService = e0.a().getSystemService("activity");
            Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            List<ActivityManager.AppTask> appTasks = ((ActivityManager) systemService).getAppTasks();
            Intrinsics.f(appTasks, "activityManager.appTasks");
            for (ActivityManager.AppTask appTask : appTasks) {
                ActivityManager.RecentTaskInfo taskInfo = appTask.getTaskInfo();
                Intrinsics.f(taskInfo, "appTask.taskInfo");
                String className = null;
                if (taskInfo.baseIntent.getComponent() != null) {
                    String canonicalName = cls.getCanonicalName();
                    ComponentName component = taskInfo.baseIntent.getComponent();
                    if (l.v(canonicalName, component != null ? component.getClassName() : null, true)) {
                        appTask.finishAndRemoveTask();
                        TmcLogger.c("NewTaskManager", "removeFromRecentTasksList: finishAndRemoveTask success");
                        return true;
                    }
                    TmcLogger.c("NewTaskManager", "removeFromRecentTasksList: recentTaskInfo null");
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("removeFromRecentTasksList: recentTaskInfo ");
                sb2.append(cls.getCanonicalName());
                sb2.append(',');
                ComponentName component2 = taskInfo.baseIntent.getComponent();
                if (component2 != null) {
                    className = component2.getClassName();
                }
                sb2.append(className);
                TmcLogger.c("NewTaskManager", sb2.toString());
            }
        } catch (Throwable th2) {
            TmcLogger.g("NewTaskManager", "removeFromRecentTasksList exception", th2);
            f31301b.resetProcessInfoToStatus(bVar, b.f31311f.a());
            l(cls);
        }
        return false;
    }

    public final void H(String appId, boolean z11) {
        Intrinsics.g(appId, "appId");
        Companion companion = f31301b;
        synchronized (companion.getInstance()) {
            try {
                if (j(appId)) {
                    TaskModel taskModelPeek = f31305f.peek();
                    if (Intrinsics.b(taskModelPeek != null ? taskModelPeek.getChildAppId() : null, appId)) {
                        taskModelPeek.setChildAppId("");
                        TmcLogger.c("NewTaskManager", "removeFromStack finish");
                        C();
                        return;
                    }
                }
                TmcLogger.c("NewTaskManager", "removeFromStack:" + appId);
                b bVarY = y(appId);
                if (bVarY == null) {
                    TmcLogger.c("NewTaskManager", "removeFromStack finish");
                    C();
                    return;
                }
                String strW = w(bVarY);
                a aVarF = bVarY.f();
                if (TextUtils.isEmpty(strW) || aVarF == null) {
                    TmcLogger.f("NewTaskManager", "removeFromStack:Can't find target in sActivityStack?");
                } else {
                    TmcLogger.c("NewTaskManager", "removeFromStack:" + strW);
                    I(appId);
                    G(aVarF.a(), bVarY);
                    if (z11) {
                        companion.resetProcessInfoToStatus(bVarY, b.f31311f.a());
                    } else {
                        b bVarP = p();
                        if (bVarP == null || Intrinsics.b(bVarP.f(), aVarF)) {
                            if ((bVarP == null || !Intrinsics.b(bVarP.f(), aVarF)) && bVarP == null) {
                                companion.resetProcessInfoToStatus(bVarY, b.f31311f.c());
                            }
                        } else if (companion.getCurrentIdleProcessNum() >= f31306g) {
                            D(bVarY);
                        } else {
                            companion.resetProcessInfoToStatus(bVarY, b.f31311f.b());
                        }
                        k(false);
                    }
                }
                TmcLogger.c("NewTaskManager", "removeFromStack finish");
                C();
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                try {
                    TmcLogger.g("NewTaskManager", "removeFromStack exception:", th2);
                    TmcLogger.c("NewTaskManager", "removeFromStack finish");
                } catch (Throwable th3) {
                    TmcLogger.c("NewTaskManager", "removeFromStack finish");
                    C();
                    throw th3;
                }
            }
        }
    }

    public final void I(String appId) {
        Intrinsics.g(appId, "appId");
        try {
            for (Object obj : f31305f) {
                if (Intrinsics.b(appId, ((TaskModel) obj).getRootAppId())) {
                    f31305f.remove((TaskModel) obj);
                }
            }
            obj = null;
            f31305f.remove((TaskModel) obj);
        } catch (Throwable th2) {
            TmcLogger.h("NewTaskManager", th2);
        }
    }

    public final void J() {
        b bVar;
        String strG;
        try {
            if (!f31301b.getEnableTaskStorage()) {
                TmcLogger.c("NewTaskManager", "init updateTaskInfoConfig:enableTaskStorage is false");
                return;
            }
            Iterator<Integer> it = kotlin.ranges.a.r(0, t()).iterator();
            while (it.hasNext()) {
                int iA = ((IntIterator) it).a();
                String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(e0.a(), "minisdk_storage", "miniapp_task_info_" + iA);
                if (string != null && string.length() > 0 && ((strG = (bVar = f31304e.get(iA)).g()) == null || strG.length() == 0)) {
                    bVar.i(string);
                    TmcLogger.c("NewTaskManager", " init updateTaskInfoConfig:MiniappActivity" + (iA + 1) + " -> " + bVar.g());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void K(String appId) {
        Object next;
        String childAppId;
        Intrinsics.g(appId, "appId");
        for (b bVar : f31304e) {
            if (!TextUtils.isEmpty(appId) && Intrinsics.b(appId, bVar.g())) {
                Iterator<T> it = f31305f.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.b(((TaskModel) next).getRootAppId(), appId));
                TaskModel taskModel = (TaskModel) next;
                if (taskModel == null || (childAppId = taskModel.getChildAppId()) == null) {
                    childAppId = "";
                }
                TmcLogger.c("NewTaskManager", "current root id -> " + appId + " ,new root id -> " + childAppId);
                if (childAppId.length() > 0) {
                    bVar.i(childAppId);
                }
            }
        }
    }

    public final void d(String str) {
        Object next;
        try {
            if (h(str)) {
                return;
            }
            Iterator<T> it = f31305f.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.b(str, ((TaskModel) next).getRootAppId()));
            TaskModel taskModel = (TaskModel) next;
            if (taskModel != null) {
                f31305f.remove(taskModel);
            }
            f31305f.add(new TaskModel(str == null ? "" : str, ""));
            TmcLogger.c("NewTaskManager", "removeActivityStack: remove appId:" + str);
        } catch (Throwable th2) {
            TmcLogger.f("NewTaskManager", "removeActivityStack:" + th2);
        }
    }

    public final void e(String appId, long j11, a aVar) {
        Intrinsics.g(appId, "appId");
        try {
            if (!h(appId)) {
                TmcLogger.c("NewTaskManager", "addStack finish");
                C();
                return;
            }
            if (aVar == null) {
                TmcLogger.c("NewTaskManager", "addStack finish");
                C();
                return;
            }
            TmcLogger.c("NewTaskManager", "addStack:" + aVar.a() + ' ' + appId);
            b bVarX = x(aVar);
            if (bVarX != null) {
                String strG = bVarX.g();
                if (strG != null && !Intrinsics.b(strG, appId)) {
                    TmcLogger.c("NewTaskManager", "addStack oldAppid:" + strG + ",new appId:" + appId);
                    H(strG, true);
                }
                bVarX.k(b.f31311f.d());
                bVarX.i(appId);
                bVarX.j(j11);
            }
            TmcLogger.c("NewTaskManager", "addStack finish");
            C();
        } catch (Throwable th2) {
            try {
                TmcLogger.g("NewTaskManager", "addStack exception:", th2);
            } finally {
                TmcLogger.c("NewTaskManager", "addStack finish");
                C();
            }
        }
    }

    public final boolean f(String str) {
        String configString = "1000391591855976448";
        try {
            configString = ((ConfigService) tc.a.a(ConfigService.class)).getConfigString("miniFeedbackId", "1000391591855976448");
        } catch (Throwable unused) {
        }
        return Intrinsics.b(str, configString) && h(str);
    }

    public final boolean g(String str) {
        String configString = "1000550440273772544";
        try {
            configString = ((ConfigService) tc.a.a(ConfigService.class)).getConfigString("miniAppServerId", "1000550440273772544");
        } catch (Throwable unused) {
        }
        return Intrinsics.b(str, configString) && h(str);
    }

    public final boolean h(String str) {
        IPackageConfig iPackageConfig = (IPackageConfig) tc.a.a(IPackageConfig.class);
        return (iPackageConfig == null || !iPackageConfig.getOpenMutipleTask() || t() == 0) ? false : true;
    }

    public final void i(String str, Class<?> cls) {
        try {
            if (h(str)) {
                for (b bVar : f31304e) {
                    Class<? extends MiniAppMiniProcessActivity> clsA = bVar.f().a();
                    if (Intrinsics.b(clsA != null ? clsA.getSimpleName() : null, cls != null ? cls.getSimpleName() : null)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("checkTaskId:");
                        sb2.append(bVar.g());
                        sb2.append(',');
                        sb2.append(cls != null ? cls.getSimpleName() : null);
                        TmcLogger.c("NewTaskManager", sb2.toString());
                        if (Intrinsics.b(str, bVar.g())) {
                            return;
                        }
                        TmcLogger.c("NewTaskManager", "removeFromRecentTasksList activity appid:" + str + ",processInfo.mAppId:" + bVar.g());
                        if (TextUtils.isEmpty(bVar.g())) {
                            TmcLogger.c("NewTaskManager", "removeFromRecentTasksList, update");
                            bVar.i(str);
                            return;
                        } else {
                            TmcLogger.c("NewTaskManager", "removeFromRecentTasksList,remove");
                            G(cls, bVar);
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            TmcLogger.h("NewTaskManager", th2);
        }
    }

    public final boolean j(String str) {
        return f(str);
    }

    public final void k(boolean z11) {
        synchronized (f31301b.getInstance()) {
            try {
                for (b bVar : f31304e) {
                    if (bVar.h() == b.f31311f.b() && (z11 || f31301b.getCurrentIdleProcessNum() > f31306g)) {
                        D(bVar);
                    }
                }
                for (b bVar2 : f31304e) {
                    if (bVar2.h() == b.f31311f.c() && (z11 || f31301b.getCurrentIdleProcessNum() > f31306g)) {
                        D(bVar2);
                    }
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void l(Class<?> cls) {
        try {
            Activity activityC = com.cloud.tmc.miniutils.util.a.c();
            if (Intrinsics.b(cls != null ? cls.getSimpleName() : null, activityC != null ? activityC.getClass().getSimpleName() : null)) {
                activityC.finishAndRemoveTask();
                return;
            }
            if (cls == null) {
                cls = null;
            }
            if (cls != null) {
                com.cloud.tmc.miniutils.util.a.a(cls);
            }
        } catch (Throwable th2) {
            TmcLogger.h("NewTaskManager", th2);
        }
    }

    public final List<String> m() {
        ArrayList arrayList = new ArrayList();
        for (TaskModel it : f31305f) {
            if (it != null) {
                Intrinsics.f(it, "it");
                arrayList.add(it.getRootAppId());
            }
        }
        return arrayList;
    }

    public final b n() {
        return q(b.f31311f.a());
    }

    public final b o() {
        return q(b.f31311f.b());
    }

    public final b p() {
        return q(b.f31311f.c());
    }

    public final b q(int i11) {
        for (b bVar : f31304e) {
            if (bVar.h() == i11) {
                return bVar;
            }
        }
        return null;
    }

    public final b r() {
        return q(b.f31311f.d());
    }

    public final String s() {
        ConcurrentLinkedQueue<TaskModel> concurrentLinkedQueue = f31305f;
        if (concurrentLinkedQueue.size() <= 0) {
            return null;
        }
        TaskModel taskModel = (TaskModel) CollectionsKt___CollectionsKt.p0(concurrentLinkedQueue);
        String childAppId = taskModel.getChildAppId();
        return childAppId.length() == 0 ? taskModel.getRootAppId() : childAppId;
    }

    public final int t() {
        try {
            return ((ConfigService) tc.a.a(ConfigService.class)).getConfigInt("mutipleTask", 2);
        } catch (Exception e11) {
            TmcLogger.h("NewTaskManager", e11);
            return 0;
        }
    }

    public final a u() {
        a aVarF;
        Companion companion = f31301b;
        synchronized (companion.getInstance()) {
            try {
                if (t() == 0) {
                    TmcLogger.c("NewTaskManager", "getNextLaunchActivityInfo finish");
                    C();
                    return null;
                }
                b bVarP = p();
                if (bVarP != null) {
                    a aVarF2 = bVarP.f();
                    TmcLogger.c("NewTaskManager", "Use last process: " + w(bVarP));
                    TmcLogger.c("NewTaskManager", "getNextLaunchActivityInfo finish");
                    C();
                    return aVarF2;
                }
                b bVarO = o();
                if (bVarO != null) {
                    TmcLogger.c("NewTaskManager", "Use idle process: " + w(bVarO));
                    a aVarF3 = bVarO.f();
                    TmcLogger.c("NewTaskManager", "getNextLaunchActivityInfo finish");
                    C();
                    return aVarF3;
                }
                b bVarN = n();
                if (companion.getCurrentRunningProcessNum() < t() && bVarN != null) {
                    TmcLogger.c("NewTaskManager", "Use new process: " + w(bVarN));
                    a aVarF4 = bVarN.f();
                    TmcLogger.c("NewTaskManager", "getNextLaunchActivityInfo finish");
                    C();
                    return aVarF4;
                }
                b bVarR = r();
                if (bVarR != null && (aVarF = bVarR.f()) != null) {
                    TmcLogger.c("NewTaskManager", "Reuse background info: " + w(bVarR));
                    TmcLogger.c("NewTaskManager", "getNextLaunchActivityInfo finish");
                    C();
                    return aVarF;
                }
                b bVarR2 = r();
                if (bVarR2 == null) {
                    TmcLogger.f("NewTaskManager", "Error, Can't find container to launch, please Check");
                    TmcLogger.c("NewTaskManager", "getNextLaunchActivityInfo finish");
                    C();
                    return null;
                }
                TmcLogger.c("NewTaskManager", "Fallback: Reuse info:" + w(bVarR2));
                a aVarF5 = bVarR2.f();
                TmcLogger.c("NewTaskManager", "getNextLaunchActivityInfo finish");
                C();
                return aVarF5;
            } catch (Throwable th2) {
                TmcLogger.c("NewTaskManager", "getNextLaunchActivityInfo finish");
                C();
                throw th2;
            }
        }
    }

    public final String v(a aVar) {
        String strB;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(((EnvironmentService) tc.a.a(EnvironmentService.class)).getApplicationContext().getPackageName());
            if (aVar == null || (strB = aVar.b()) == null) {
                strB = "";
            }
            sb2.append(strB);
            return sb2.toString();
        } catch (Throwable unused) {
            return "unknown process";
        }
    }

    public final String w(b bVar) {
        return v(bVar != null ? bVar.f() : null);
    }

    public final b x(a aVar) {
        for (b bVar : f31304e) {
            if (bVar.f() == aVar) {
                return bVar;
            }
        }
        return null;
    }

    public final b y(String appId) {
        Intrinsics.g(appId, "appId");
        for (b bVar : f31304e) {
            if (!TextUtils.isEmpty(appId) && Intrinsics.b(appId, bVar.g())) {
                return bVar;
            }
        }
        return null;
    }

    public final String z() {
        ConcurrentLinkedQueue<TaskModel> concurrentLinkedQueue = f31305f;
        if (concurrentLinkedQueue.size() > 0) {
            return ((TaskModel) CollectionsKt___CollectionsKt.p0(concurrentLinkedQueue)).getRootAppId();
        }
        return null;
    }
}
