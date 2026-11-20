package com.transsion.push.config;

import android.text.TextUtils;
import android.util.Base64;
import com.transsion.core.utils.f;
import com.transsion.crypto.TCrypterSdk;
import com.transsion.gslb.GslbSdk;
import com.transsion.push.IClientIdListener;
import com.transsion.push.ITopicListener;
import com.transsion.push.PushConstants;
import com.transsion.push.PushManager;
import com.transsion.push.bean.ConfigInfo;
import com.transsion.push.bean.SelfDestroyInfo;
import com.transsion.push.tracker.Tracker;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.ThreadManager;
import d.e;
import d.n;
import d.t;
import d.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class PushRepository implements IDataSource {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static PushRepository f56837e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f56838f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f56839g = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f56840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.transsion.push.config.a f56841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConfigInfo.Config f56842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f56843d;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f56844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ITopicListener f56845b;

        /* JADX INFO: renamed from: com.transsion.push.config.PushRepository$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0592a implements ITopicListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ HashSet f56847a;

            public C0592a(HashSet hashSet) {
                this.f56847a = hashSet;
            }

            @Override // com.transsion.push.ITopicListener
            public void onFail(String str) {
                ITopicListener iTopicListener = a.this.f56845b;
                if (iTopicListener != null) {
                    iTopicListener.onFail(str);
                }
            }

            @Override // com.transsion.push.ITopicListener
            public void onSuccess() {
                this.f56847a.add(a.this.f56844a);
                PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_SUBSCRIBE_TOPICS, this.f56847a);
                ITopicListener iTopicListener = a.this.f56845b;
                if (iTopicListener != null) {
                    iTopicListener.onSuccess();
                }
            }
        }

        public a(String str, ITopicListener iTopicListener) {
            this.f56844a = str;
            this.f56845b = iTopicListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashSet hashSet = (HashSet) PushRepository.this.getSpValue(PushConstants.SP_KEY_SUBSCRIBE_TOPICS, new HashSet());
            if (!hashSet.contains(this.f56844a)) {
                PushRepository.this.f56841b.d(this.f56844a, PushConstants.TOPIC_SUBSCRIBE, new C0592a(hashSet));
                return;
            }
            PushLogUtils.LOG.g("subscribe topic, " + this.f56844a + " has been subscribed");
            ITopicListener iTopicListener = this.f56845b;
            if (iTopicListener != null) {
                iTopicListener.onSuccess();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f56849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ITopicListener f56850b;

        /* JADX INFO: compiled from: source.java */
        public class a implements ITopicListener {
            public a() {
            }

            @Override // com.transsion.push.ITopicListener
            public void onFail(String str) {
                ITopicListener iTopicListener = b.this.f56850b;
                if (iTopicListener != null) {
                    iTopicListener.onFail(str);
                }
            }

            @Override // com.transsion.push.ITopicListener
            public void onSuccess() {
                HashSet hashSet = (HashSet) PushRepository.this.getSpValue(PushConstants.SP_KEY_SUBSCRIBE_TOPICS, new HashSet());
                hashSet.remove(b.this.f56849a);
                PushRepository.this.putSpValue(PushConstants.SP_KEY_SUBSCRIBE_TOPICS, hashSet);
                ITopicListener iTopicListener = b.this.f56850b;
                if (iTopicListener != null) {
                    iTopicListener.onSuccess();
                }
            }
        }

        public b(String str, ITopicListener iTopicListener) {
            this.f56849a = str;
            this.f56850b = iTopicListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            PushRepository.this.f56841b.d(this.f56849a, PushConstants.TOPIC_UNSUBSCRIBE, new a());
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public class c implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IClientIdListener f56853a;

        public c(IClientIdListener iClientIdListener) {
            this.f56853a = iClientIdListener;
        }

        @Override // d.e.c
        public void a() {
            IClientIdListener iClientIdListener = this.f56853a;
            if (iClientIdListener != null) {
                iClientIdListener.onFail("get token fail");
            }
        }

        @Override // d.e.c
        public void onSuccess() {
            PushRepository.this.c(this.f56853a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IClientIdListener f56855a;

        public d(IClientIdListener iClientIdListener) {
            this.f56855a = iClientIdListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            ConfigInfo.Whitelist whitelist;
            ConfigInfo.Config config;
            ConfigInfo configInfoG = PushRepository.this.f56841b.g();
            if (configInfoG == null) {
                IClientIdListener iClientIdListener = this.f56855a;
                if (iClientIdListener != null) {
                    iClientIdListener.onFail("get client id fail");
                }
                PushLogUtils.LOG.g("get client id fail");
                return;
            }
            PushLogUtils.LOG.g("get config response data: " + configInfoG.toString());
            PushRepository.this.putSpValue(PushConstants.SP_KEY_IS_NEXT_WITH_APP, Boolean.valueOf(configInfoG.nextWithApp));
            PushRepository.this.putSpValue(PushConstants.SP_KEY_IS_REPORT_DETAIL, Boolean.valueOf(configInfoG.nextWithDetail));
            PushRepository.this.putSpValue(PushConstants.SP_KEY_CLIENT_ID, configInfoG.clientId);
            t.h(configInfoG.destroyAppIds, configInfoG.syncInfoInterval);
            if (configInfoG.configRefresh && (config = configInfoG.config) != null && config.version > 0) {
                PushRepository.this.saveConfig(config);
                PushRepository.this.putSpValue(PushConstants.SP_KEY_SELF_DESTROYING, Integer.valueOf(configInfoG.config.destroy));
            }
            if (configInfoG.whitelistRefresh && (whitelist = configInfoG.whitelist) != null && whitelist.version > 0) {
                PushRepository.this.saveWhiteList(whitelist);
            }
            IClientIdListener iClientIdListener2 = this.f56855a;
            if (iClientIdListener2 != null) {
                iClientIdListener2.onSuccess(configInfoG.clientId);
            }
        }
    }

    public PushRepository() {
        try {
            this.f56840a = f.e(PushConstants.SP_FILENAME);
        } catch (Exception unused) {
        }
        this.f56841b = new com.transsion.push.config.a();
    }

    public static synchronized PushRepository getInstance() {
        try {
            if (f56837e == null) {
                f56837e = new PushRepository();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f56837e;
    }

    public final void b() {
        int iIntValue = ((Integer) getSpValue(PushConstants.SP_KEY_RETRY_COUNT, 0)).intValue();
        int iC = n.c();
        PushLogUtils.LOG.g("Reporting Failure, Retry Reporting,retryCount：" + iIntValue + ", max retryCount：" + iC);
        if (iIntValue < iC) {
            putSpValue(PushConstants.SP_KEY_RETRY_COUNT, Integer.valueOf(iIntValue + 1));
            saveReportTime(System.currentTimeMillis() + n.d());
        } else {
            PushLogUtils.LOG.g("More than the maximum number of retries");
            saveReportTime(System.currentTimeMillis() + n.b());
            putSpValue(PushConstants.SP_KEY_RETRY_COUNT, 0);
        }
    }

    public final void c(IClientIdListener iClientIdListener) {
        if (this.f56841b != null) {
            ThreadManager.executeInBackground(new d(iClientIdListener));
            return;
        }
        if (iClientIdListener != null) {
            iClientIdListener.onFail("mRemoteDataSource is null");
        }
        PushLogUtils.LOG.z("mRemoteDataSource is null");
    }

    @Override // com.transsion.push.config.IDataSource
    public void getClientId(IClientIdListener iClientIdListener) {
        PushLogUtils.LOG.g("get client id");
        String str = (String) getSpValue(PushConstants.SP_KEY_CLIENT_ID, "");
        if (!TextUtils.isEmpty(str) && iClientIdListener != null) {
            iClientIdListener.onSuccess(str);
        } else if (TextUtils.isEmpty((CharSequence) getSpValue(PushConstants.SP_KEY_FCM_TOKEN, ""))) {
            e.a(new c(iClientIdListener));
        } else {
            c(iClientIdListener);
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public ConfigInfo.Config getConfig() {
        ConfigInfo.Config config = this.f56842c;
        if (config != null) {
            return config;
        }
        f fVar = this.f56840a;
        if (fVar == null) {
            return null;
        }
        String strJ = fVar.j(PushConstants.SP_KEY_CONFIG, null);
        if (TextUtils.isEmpty(strJ)) {
            return null;
        }
        try {
            return (ConfigInfo.Config) com.transsion.json.b.a(new String(Base64.decode(strJ, 0)), ConfigInfo.Config.class);
        } catch (Exception e11) {
            PushLogUtils.LOG.i("get config fail, e:" + e11.getMessage());
            return null;
        }
    }

    public long getLastTpmsReportTime() {
        long jCurrentTimeMillis = System.currentTimeMillis() - 1;
        long j11 = f56839g;
        if (j11 > 0) {
            return j11;
        }
        f fVar = this.f56840a;
        if (fVar == null) {
            return jCurrentTimeMillis;
        }
        f56839g = fVar.h(PushConstants.SP_KEY_REPORT_TPMS_TIME, 0L);
        PushLogUtils.LOG.g("sLocalTpmsReportTime" + f56839g);
        if (f56839g <= 0) {
            this.f56840a.o(PushConstants.SP_KEY_REPORT_TPMS_TIME, jCurrentTimeMillis);
            f56839g = jCurrentTimeMillis;
        }
        return f56839g;
    }

    @Override // com.transsion.push.config.IDataSource
    public long getReportTime() {
        long jCurrentTimeMillis = System.currentTimeMillis() - 1;
        long j11 = f56838f;
        if (j11 > 0) {
            return j11;
        }
        f fVar = this.f56840a;
        if (fVar == null) {
            return jCurrentTimeMillis;
        }
        long jH = fVar.h(PushConstants.SP_KEY_REPORT_ACTIVE_TIME, 0L);
        f56838f = jH;
        if (jH <= 0) {
            this.f56840a.o(PushConstants.SP_KEY_REPORT_ACTIVE_TIME, jCurrentTimeMillis);
            f56838f = jCurrentTimeMillis;
        }
        return f56838f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.push.config.IDataSource
    public <T> T getSpValue(String str, T t11) {
        f fVar = this.f56840a;
        if (fVar == null) {
            return t11;
        }
        try {
            if (t11 instanceof String) {
                return (T) fVar.j(str, (String) t11);
            }
            if (t11 instanceof Boolean) {
                return (T) Boolean.valueOf(fVar.c(str, ((Boolean) t11).booleanValue()));
            }
            if (t11 instanceof Integer) {
                return (T) Integer.valueOf(fVar.f(str, ((Integer) t11).intValue()));
            }
            if (t11 instanceof Long) {
                return (T) Long.valueOf(fVar.h(str, ((Long) t11).longValue()));
            }
            if (t11 instanceof Float) {
                return (T) Float.valueOf(fVar.d(str, ((Float) t11).floatValue()));
            }
            if (t11 instanceof Set) {
                return (T) fVar.k(str, new HashSet());
            }
            PushLogUtils.LOG.i("Type of " + t11.getClass().getSimpleName() + " is not supported.");
            return t11;
        } catch (ClassCastException e11) {
            PushLogUtils.LOG.i("Type of default value is not match with value stored." + System.lineSeparator() + e11.getMessage());
            return t11;
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public ConfigInfo.Whitelist getWhiteList() {
        if (!TextUtils.isEmpty(this.f56843d)) {
            try {
                return (ConfigInfo.Whitelist) com.transsion.json.b.a(this.f56843d, ConfigInfo.Whitelist.class);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        try {
            String strA = TCrypterSdk.a(ws.a.a(), PushConstants.SP_KEY_WHITE_LIST);
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            this.f56843d = strA;
            return (ConfigInfo.Whitelist) com.transsion.json.b.a(strA, ConfigInfo.Whitelist.class);
        } catch (Exception e12) {
            PushLogUtils.LOG.i("get white list fail, e:" + e12.getMessage());
            return null;
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public boolean isReported() {
        f fVar = this.f56840a;
        if (fVar == null) {
            return false;
        }
        try {
            return fVar.b(PushConstants.SP_KEY_REPORT_ACTIVE_SUCCESS);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void putSpValue(String str, Object obj) {
        f fVar = this.f56840a;
        if (fVar == null) {
            return;
        }
        try {
            if (obj instanceof String) {
                fVar.p(str, (String) obj);
            } else if (obj instanceof Boolean) {
                fVar.l(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                fVar.n(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                fVar.o(str, ((Long) obj).longValue());
            } else if (obj instanceof Float) {
                fVar.m(str, ((Float) obj).floatValue());
            } else if (obj instanceof Set) {
                fVar.q(str, (Set) obj);
            }
        } catch (Exception e11) {
            PushLogUtils.LOG.i("put sp, Type of default value is not match with value stored." + System.lineSeparator() + e11.getMessage());
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void removeSpValue(String str) {
        try {
            f fVar = this.f56840a;
            if (fVar != null) {
                fVar.r(str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void saveConfig(ConfigInfo.Config config) {
        f fVar;
        if (config == null || (fVar = this.f56840a) == null) {
            return;
        }
        try {
            this.f56842c = config;
            fVar.p(PushConstants.SP_KEY_CONFIG, new String(Base64.encode(com.transsion.json.b.b(config).getBytes(), 0)));
        } catch (Exception e11) {
            PushLogUtils.LOG.i("save config fail, e:" + e11.getMessage());
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void saveReportTime(long j11) {
        if (this.f56840a == null) {
            return;
        }
        PushLogUtils.LOG.g("Update reporting time，reportTime:" + j11);
        f56838f = j11;
        this.f56840a.o(PushConstants.SP_KEY_REPORT_ACTIVE_TIME, j11);
    }

    public void saveTpmsReportTime(long j11) {
        if (this.f56840a == null) {
            return;
        }
        PushLogUtils.LOG.g("Update reporting time，reportTime:" + j11);
        f56839g = j11;
        this.f56840a.o(PushConstants.SP_KEY_REPORT_TPMS_TIME, j11);
    }

    @Override // com.transsion.push.config.IDataSource
    public void saveWhiteList(ConfigInfo.Whitelist whitelist) {
        List<ConfigInfo.Apps> list;
        if (whitelist == null || (list = whitelist.apps) == null || list.size() == 0) {
            return;
        }
        try {
            if (TextUtils.isEmpty(this.f56843d)) {
                this.f56843d = com.transsion.json.b.b(whitelist);
                TCrypterSdk.c(ws.a.a(), PushConstants.SP_KEY_WHITE_LIST, this.f56843d);
                return;
            }
            List<ConfigInfo.Apps> list2 = ((ConfigInfo.Whitelist) com.transsion.json.b.a(this.f56843d, ConfigInfo.Whitelist.class)).apps;
            for (ConfigInfo.Apps apps : whitelist.apps) {
                if (!list2.contains(apps)) {
                    list2.add(apps);
                }
            }
            ConfigInfo.Whitelist whitelist2 = new ConfigInfo.Whitelist();
            whitelist2.version = whitelist.version;
            whitelist2.apps = new ArrayList(list2);
            this.f56843d = com.transsion.json.b.b(whitelist2);
            TCrypterSdk.c(ws.a.a(), PushConstants.SP_KEY_WHITE_LIST, this.f56843d);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void subscribeToTopic(String str, ITopicListener iTopicListener) {
        if (TextUtils.isEmpty(str)) {
            if (iTopicListener != null) {
                iTopicListener.onFail("subscribe topic is empty");
                PushLogUtils.LOG.i("subscribe topic is empty");
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty((CharSequence) getInstance().getSpValue(PushConstants.SP_KEY_CLIENT_ID, ""))) {
            ThreadManager.executeInBackground(new a(str, iTopicListener));
        } else if (iTopicListener != null) {
            iTopicListener.onFail("subscribe clientId is empty");
            PushLogUtils.LOG.i("subscribe clientId is empty");
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void syncActive() {
        ConfigInfo.Whitelist whitelist;
        ConfigInfo.Config config;
        if (TextUtils.isEmpty((CharSequence) getSpValue(PushConstants.SP_KEY_FCM_TOKEN, ""))) {
            PushLogUtils.LOG.z("Token is empty");
            return;
        }
        if (this.f56841b == null) {
            PushLogUtils.LOG.z("mRemoteDataSource is null");
            return;
        }
        if (!PushManager.getInstance().getDebug() && !PushManager.getInstance().getTestEnv() && !GslbSdk.isInitSuccess(PushConstants.BASE_RELEASE_URL_V2)) {
            GslbSdk.getDomain(PushConstants.BASE_RELEASE_URL_V2, true);
        }
        ConfigInfo configInfoG = this.f56841b.g();
        if (configInfoG == null) {
            PushLogUtils.LOG.g("syncActive onFail");
            if (TextUtils.isEmpty((CharSequence) getSpValue(PushConstants.SP_KEY_CLIENT_ID, ""))) {
                return;
            }
            b();
            return;
        }
        putSpValue(PushConstants.SP_KEY_RETRY_COUNT, 0);
        PushLogUtils.LOG.g("get config response data: " + configInfoG.toString());
        putSpValue(PushConstants.SP_KEY_IS_NEXT_WITH_APP, Boolean.valueOf(configInfoG.nextWithApp));
        putSpValue(PushConstants.SP_KEY_IS_REPORT_DETAIL, Boolean.valueOf(configInfoG.nextWithDetail));
        putSpValue(PushConstants.SP_KEY_CLIENT_ID, configInfoG.clientId);
        putSpValue(PushConstants.SP_KEY_START_POINT_REPORT, Boolean.valueOf(configInfoG.startPointReport));
        t.h(configInfoG.destroyAppIds, configInfoG.syncInfoInterval);
        x.y();
        if (configInfoG.configRefresh && (config = configInfoG.config) != null && config.version > 0) {
            saveConfig(config);
            putSpValue(PushConstants.SP_KEY_SELF_DESTROYING, Integer.valueOf(configInfoG.config.destroy));
        }
        if (configInfoG.whitelistRefresh && (whitelist = configInfoG.whitelist) != null && whitelist.version > 0) {
            saveWhiteList(whitelist);
        }
        saveReportTime(System.currentTimeMillis() + n.b());
        putSpValue(PushConstants.SP_KEY_REPORT_ACTIVE_SUCCESS, Boolean.TRUE);
    }

    @Override // com.transsion.push.config.IDataSource
    public void syncSelfDestroying() {
        if (this.f56841b == null) {
            PushLogUtils.LOG.z("mRemoteDataSource is null");
            return;
        }
        if (!PushManager.getInstance().getDebug() && !PushManager.getInstance().getTestEnv() && !GslbSdk.isInitSuccess(PushConstants.BASE_RELEASE_URL_V2)) {
            PushLogUtils.LOG.z("gslb not inited");
            return;
        }
        Tracker.getInstance().trackReport();
        SelfDestroyInfo selfDestroyInfoF = this.f56841b.f();
        if (selfDestroyInfoF == null) {
            PushLogUtils.LOG.i("sync self-destroying fail");
            putSpValue(PushConstants.SP_KEY_SELF_DESTROYING_TIME, Long.valueOf(System.currentTimeMillis() + n.e()));
            return;
        }
        PushLogUtils.LOG.g("get self-destroying response data: " + selfDestroyInfoF.toString());
        putSpValue(PushConstants.SP_KEY_SELF_DESTROYING, Integer.valueOf(selfDestroyInfoF.destroy));
        putSpValue(PushConstants.SP_KEY_SELF_DESTROYING_INTERVAL, Integer.valueOf(selfDestroyInfoF.interval));
        putSpValue(PushConstants.SP_KEY_SELF_DESTROYING_TIME, Long.valueOf(System.currentTimeMillis() + n.e()));
    }

    @Override // com.transsion.push.config.IDataSource
    public void unsubscribeFromTopic(String str, ITopicListener iTopicListener) {
        if (TextUtils.isEmpty(str)) {
            if (iTopicListener != null) {
                iTopicListener.onFail("unsubscribe topic is empty");
                PushLogUtils.LOG.i("unsubscribe topic is empty");
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty((CharSequence) getInstance().getSpValue(PushConstants.SP_KEY_CLIENT_ID, ""))) {
            ThreadManager.executeInBackground(new b(str, iTopicListener));
        } else if (iTopicListener != null) {
            iTopicListener.onFail("unsubscribe clientId is empty");
            PushLogUtils.LOG.i("unsubscribe clientId is empty");
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void updateNewToken(String str) {
        putSpValue(PushConstants.SP_KEY_FCM_TOKEN, str);
        putSpValue(PushConstants.SP_KEY_IS_REPORT_DETAIL, Boolean.TRUE);
        putSpValue(PushConstants.SP_KEY_REPORT_ACTIVE_SUCCESS, Boolean.FALSE);
    }
}
