package com.transsion.sdk.oneid;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.logging.type.LogSeverity;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.gslb.GslbSdk;
import com.transsion.sdk.oneid.data.AppIdInfo;
import com.transsion.sdk.oneid.data.GroupFpInfo;
import com.transsion.sdk.oneid.data.GroupHashInfo;
import com.transsion.sdk.oneid.data.IdChangeInfo;
import com.transsion.sdk.oneid.data.OdIdInfo;
import com.transsion.sdk.oneid.data.UniqueIdInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import k20.g;
import k20.h;
import k20.i;
import k20.j;
import k20.l;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements Handler.Callback {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile e f57403o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f57404a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GroupFpInfo f57406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GroupHashInfo f57407d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.transsion.sdk.oneid.b f57410h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f57413k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OdIdInfo f57414l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ConcurrentHashMap<Integer, AppIdInfo> f57415m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HandlerThread f57405b = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f57408f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f57409g = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ReentrantLock f57412j = new ReentrantLock();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicBoolean f57416n = new AtomicBoolean(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<IdChangeInfo> f57411i = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: source.java */
    public class a extends TypeToken<ConcurrentHashMap<Integer, AppIdInfo>> {
        public a(e eVar) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends TypeToken<ConcurrentHashMap<Integer, AppIdInfo>> {
        public b(e eVar) {
        }
    }

    public e(Context context) {
        this.f57413k = context;
        j();
        if (this.f57404a != null) {
            String string = context.getResources().getString(R$string.oneid_process_name);
            string = TextUtils.isEmpty(string) ? context.getPackageName() : string;
            if (!TextUtils.isEmpty(k20.b.b(context).h("one_id_first_launch")) || OneID.f57390d <= 0 || !TextUtils.equals(string, f.j(context))) {
                this.f57404a.sendEmptyMessage(200);
                return;
            }
            f.f57417a.g("First launch delay " + OneID.f57390d + " sec init");
            this.f57404a.sendEmptyMessageDelayed(200, ((long) OneID.f57390d) * 1000);
            k20.b.b(context).g("one_id_first_launch", String.valueOf(System.currentTimeMillis()));
        }
    }

    public static e a(Context context) {
        if (f57403o == null) {
            synchronized (e.class) {
                try {
                    if (f57403o == null) {
                        f57403o = new e(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f57403o;
    }

    public void b(int i11) {
        f.f57417a.g("Check appId record : " + i11);
        HandlerThread handlerThread = this.f57405b;
        if (handlerThread == null || !handlerThread.isAlive()) {
            return;
        }
        Message messageObtain = Message.obtain(this.f57404a, 304);
        messageObtain.obj = Integer.valueOf(i11);
        if (this.f57416n.get()) {
            this.f57404a.sendMessage(messageObtain);
        } else {
            this.f57404a.sendMessageDelayed(messageObtain, ((long) OneID.f57390d) * 1000);
        }
    }

    public final void c(int i11, AppIdInfo appIdInfo) {
        f.f57417a.g("onOdidRequestRetry");
        appIdInfo.retryTimes++;
        long j11 = appIdInfo.retryRequestDelay;
        if (j11 == 0) {
            appIdInfo.retryRequestDelay = 3000L;
        } else {
            appIdInfo.retryRequestDelay = Math.min((j11 * 2) + 1000, TTAdConstant.AD_MAX_EVENT_TIME);
        }
        Message messageObtain = Message.obtain(this.f57404a, 303);
        messageObtain.obj = appIdInfo;
        messageObtain.arg1 = i11;
        this.f57404a.sendMessageDelayed(messageObtain, appIdInfo.retryRequestDelay);
    }

    public final void d(Message message) {
        long j11 = this.f57408f;
        if (j11 == 0) {
            this.f57408f = 3000L;
        } else {
            this.f57408f = Math.min((j11 * 2) + 1000, TTAdConstant.AD_MAX_EVENT_TIME);
        }
        this.f57404a.sendMessageDelayed(message, this.f57408f);
    }

    public void e(IdChangeInfo idChangeInfo) {
        IdChangeInfo next;
        f.f57417a.g("onFpIdChanged type = " + idChangeInfo.id_type);
        List<IdChangeInfo> list = this.f57411i;
        if (list != null) {
            Iterator<IdChangeInfo> it = list.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!next.id_type.equals(idChangeInfo.id_type));
            if (next != null) {
                this.f57411i.remove(next);
            }
            this.f57411i.add(idChangeInfo);
        }
    }

    public final void f(String str) {
        f.f57417a.g("onFpPostComplete");
        this.f57409g = System.currentTimeMillis();
        try {
            k20.b bVarB = k20.b.b(this.f57413k);
            bVarB.c("last_post_time", Long.valueOf(this.f57409g / 1000).intValue());
            if (TextUtils.isEmpty(str)) {
                return;
            }
            bVarB.d("fp_hash", str);
        } catch (Exception e11) {
            f.f57417a.i(Log.getStackTraceString(e11));
        }
    }

    public final void g(String str, int i11, AppIdInfo appIdInfo) {
        f.f57417a.g("onOdidRequestComplete appId : " + i11);
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optInt(TrackingKey.CODE, 0);
            String strOptString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, "");
            long jOptLong = jSONObject.optLong("time", 0L);
            appIdInfo.odid = jSONObject.optString("odid", "");
            appIdInfo.retryTimes = 0;
            appIdInfo.retryRequestDelay = 0L;
            appIdInfo.lastRequestTime = System.currentTimeMillis();
            long j11 = jOptLong * 1000;
            appIdInfo.waitTime = j11;
            appIdInfo.msg = strOptString;
            k20.b bVarB = k20.b.b(this.f57413k);
            String json = new Gson().toJson(this.f57415m, new b(this).getType());
            f.f57417a.g("appIdInfoListJson : " + json);
            bVarB.g("appid_info_list", json);
            Message messageObtain = Message.obtain(this.f57404a, 303);
            messageObtain.obj = appIdInfo;
            messageObtain.arg1 = i11;
            this.f57404a.sendMessageDelayed(messageObtain, j11);
        } catch (Exception e11) {
            f.f57417a.i(Log.getStackTraceString(e11));
        }
    }

    public String h() {
        try {
            GroupFpInfo groupFpInfo = this.f57406c;
            return groupFpInfo != null ? groupFpInfo.vaid : "";
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        GroupFpInfo groupFpInfo;
        int i11;
        long j11;
        String strF;
        Message message2;
        try {
            int i12 = message.what;
            if (i12 == 100) {
                f.f57417a.g("-->WHAT_GET_PROP_RET");
                String string = message.getData().getString("oneid");
                if (TextUtils.isEmpty(string) || TextUtils.equals(string, "UNKNOWN") || (groupFpInfo = this.f57406c) == null) {
                    return false;
                }
                if (!TextUtils.isEmpty(groupFpInfo.dids.tsid)) {
                    if (TextUtils.equals(this.f57406c.dids.tsid, string)) {
                        return false;
                    }
                    e(new IdChangeInfo("tsid", this.f57406c.dids.tsid, string));
                    UniqueIdInfo uniqueIdInfo = this.f57406c.dids;
                    uniqueIdInfo.tsid = string;
                    this.f57407d.updateDidsHash(uniqueIdInfo);
                    this.f57414l.tsid = string;
                    return false;
                }
                UniqueIdInfo uniqueIdInfo2 = this.f57406c.dids;
                uniqueIdInfo2.tsid = string;
                this.f57407d.updateDidsHash(uniqueIdInfo2);
                this.f57414l.tsid = string;
                k20.b bVarB = k20.b.b(this.f57413k);
                int iIntValue = Long.valueOf(System.currentTimeMillis() / 1000).intValue();
                try {
                    bVarB.d("oneid", string);
                    bVarB.c("oneid_time", iIntValue);
                    return false;
                } catch (Exception e11) {
                    f.f57417a.i(Log.getStackTraceString(e11));
                    return false;
                }
            }
            if (i12 == 200) {
                f.f57417a.g("-->WHAT_INIT 2.0.1.1");
                String string2 = this.f57413k.getResources().getString(R$string.oneid_process_name);
                if (TextUtils.isEmpty(string2)) {
                    string2 = this.f57413k.getPackageName();
                }
                if (!TextUtils.equals(string2, f.j(this.f57413k))) {
                    f.f57417a.g("Only works in the main process");
                    this.f57404a.sendEmptyMessageDelayed(201, 1000L);
                    return false;
                }
                try {
                    if (this.f57410h == null) {
                        this.f57410h = new com.transsion.sdk.oneid.b();
                        this.f57413k.registerReceiver(this.f57410h, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    }
                } catch (Exception e12) {
                    f.f57417a.i(Log.getStackTraceString(e12));
                }
                GslbSdk.init(this.f57413k, new String[]{"ire-oneid.shalltry.com", "oneid-dev-sg.shalltry.com"}, (GslbSdk.InitListener) null);
                GroupFpInfo groupFpInfo2 = new GroupFpInfo(this.f57413k, this);
                this.f57406c = groupFpInfo2;
                this.f57407d = new GroupHashInfo(groupFpInfo2);
                this.f57414l = new OdIdInfo(this.f57406c);
                f.f57417a.g("--> new OdidInfo " + this.f57414l);
                if (this.f57409g == 0) {
                    this.f57409g = ((long) k20.b.b(this.f57413k).a("last_post_time")) * 1000;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j12 = this.f57409g;
                if (jCurrentTimeMillis >= j12 && jCurrentTimeMillis - j12 < ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
                    f.f57417a.g("Post time not yet reached");
                } else if (!this.f57404a.hasMessages(LogSeverity.NOTICE_VALUE)) {
                    Handler handler = this.f57404a;
                    if (GslbSdk.isInitSuccess(l.d().c())) {
                        i11 = LogSeverity.NOTICE_VALUE;
                        j11 = 3000;
                    } else {
                        i11 = LogSeverity.NOTICE_VALUE;
                        j11 = 6000;
                    }
                    handler.sendEmptyMessageDelayed(i11, j11);
                }
                this.f57416n.set(true);
                return false;
            }
            if (i12 == 201) {
                f.f57417a.g("-->WHAT_QUIT");
                if (!this.f57412j.tryLock()) {
                    return false;
                }
                try {
                    HandlerThread handlerThread = this.f57405b;
                    if (handlerThread != null) {
                        handlerThread.quit();
                        this.f57405b = null;
                    }
                    return false;
                } finally {
                    this.f57412j.unlock();
                }
            }
            switch (i12) {
                case NOTICE_VALUE:
                    f.f57417a.g("-->WHAT_POST_FP_HASH");
                    this.f57404a.removeMessages(LogSeverity.NOTICE_VALUE);
                    if (OneID.f57389c && f.m(this.f57413k)) {
                        if (!GslbSdk.isInitSuccess(l.d().c())) {
                            f.f57417a.g("GslbSdk new domain is not ready");
                            d(Message.obtain(this.f57404a, LogSeverity.NOTICE_VALUE));
                            return false;
                        }
                        try {
                            strF = k20.b.b(this.f57413k).f("fp_hash");
                            break;
                        } catch (Exception unused) {
                            strF = "";
                        }
                        String strG = f.g(this.f57407d.toString());
                        f.f57417a.g(strF + " vs " + strG);
                        if (TextUtils.equals(strF, strG)) {
                            f(null);
                            return false;
                        }
                        Message.obtain(this.f57404a, 301, strG).sendToTarget();
                        return false;
                    }
                    f.f57417a.g("OneID disable or network unavailable");
                    this.f57408f = 0L;
                    this.f57404a.sendEmptyMessage(201);
                    return false;
                case 301:
                    f.f57417a.g("-->WHAT_POST_FP_DATA");
                    this.f57404a.removeMessages(301);
                    if (OneID.f57389c && f.m(this.f57413k)) {
                        String str = (String) message.obj;
                        i<String> iVarA = new g(this.f57406c).a();
                        f.f57417a.g("code = " + iVarA.f68222a + " data = " + iVarA.f68223b);
                        int i13 = iVarA.f68222a;
                        if (i13 != 0) {
                            if (i13 == 4) {
                                return false;
                            }
                            d(Message.obtain(this.f57404a, 301, str));
                            return false;
                        }
                        this.f57408f = 0L;
                        try {
                            if (new JSONObject(iVarA.f68223b).optInt(TrackingKey.CODE, 0) == 0) {
                                if (this.f57411i.isEmpty()) {
                                    f(str);
                                } else {
                                    Message.obtain(this.f57404a, 302, str).sendToTarget();
                                }
                            }
                            return false;
                        } catch (Exception e13) {
                            f.f57417a.i(Log.getStackTraceString(e13));
                            return false;
                        }
                    }
                    f.f57417a.g("OneID disable or network unavailable");
                    this.f57408f = 0L;
                    this.f57404a.sendEmptyMessage(201);
                    return false;
                case 302:
                    f.f57417a.g("-->WHAT_POST_ID_CHANGE");
                    this.f57404a.removeMessages(302);
                    String str2 = (String) message.obj;
                    ArrayList arrayList = new ArrayList();
                    for (IdChangeInfo idChangeInfo : this.f57411i) {
                        if (!TextUtils.isEmpty(idChangeInfo.pre_id)) {
                            arrayList.add(idChangeInfo);
                        }
                    }
                    if (arrayList.size() <= 0) {
                        if (this.f57411i.size() > 0) {
                            f.h(this.f57413k, this.f57411i);
                            this.f57411i.clear();
                        }
                        f(str2);
                        return false;
                    }
                    try {
                        i<String> iVarA2 = new h(arrayList).a();
                        f.f57417a.g("code = " + iVarA2.f68222a + " data = " + iVarA2.f68223b);
                        int i14 = iVarA2.f68222a;
                        if (i14 == 0) {
                            this.f57408f = 0L;
                            try {
                                if (new JSONObject(iVarA2.f68223b).optInt(TrackingKey.CODE, 0) == 0) {
                                    f.h(this.f57413k, this.f57411i);
                                    this.f57411i.clear();
                                    f(str2);
                                }
                            } catch (Exception e14) {
                                f.f57417a.i(Log.getStackTraceString(e14));
                            }
                            break;
                        } else if (i14 != 4) {
                            d(Message.obtain(this.f57404a, 302, str2));
                        }
                        return false;
                    } catch (Exception e15) {
                        f.f57417a.i(Log.getStackTraceString(e15));
                        return false;
                    }
                case 303:
                    f.f57417a.g("-->WHAT_REQUEST_ODID");
                    int i15 = message.arg1;
                    AppIdInfo appIdInfo = (AppIdInfo) message.obj;
                    this.f57404a.removeMessages(303, appIdInfo);
                    if (OneID.f57389c && f.m(this.f57413k)) {
                        OdIdInfo odIdInfo = this.f57414l;
                        if (odIdInfo == null) {
                            return false;
                        }
                        odIdInfo.appid = i15;
                        f.f57417a.g("--> mOdidInfo set appID :" + this.f57414l.toString());
                        i<String> iVarA3 = new j(this.f57414l).a();
                        f.f57417a.g("code = " + iVarA3.f68222a + " data = " + iVarA3.f68223b);
                        int i16 = iVarA3.f68222a;
                        if (i16 == 0) {
                            g(iVarA3.f68223b, i15, appIdInfo);
                            return false;
                        }
                        if (i16 != 3) {
                            if (i16 == 4) {
                                return false;
                            }
                            c(i15, appIdInfo);
                            return false;
                        }
                        f.f57417a.g("onOdidRequestGatewayError");
                        Message messageObtain = Message.obtain(this.f57404a, 303);
                        messageObtain.obj = appIdInfo;
                        messageObtain.arg1 = i15;
                        this.f57404a.sendMessageDelayed(messageObtain, 1000L);
                        return false;
                    }
                    f.f57417a.g("OneID disable or network unavailable");
                    this.f57404a.sendEmptyMessage(201);
                    return false;
                case 304:
                    int iIntValue2 = ((Integer) message.obj).intValue();
                    this.f57404a.removeMessages(304, Integer.valueOf(iIntValue2));
                    if (OneID.f57389c && f.m(this.f57413k)) {
                        k();
                        AppIdInfo appIdInfo2 = this.f57415m.get(Integer.valueOf(iIntValue2));
                        if (appIdInfo2 == null) {
                            appIdInfo2 = new AppIdInfo();
                            this.f57415m.put(Integer.valueOf(iIntValue2), appIdInfo2);
                            this.f57414l.appid = iIntValue2;
                        }
                        Message messageObtain2 = Message.obtain(this.f57404a, 303);
                        messageObtain2.arg1 = iIntValue2;
                        messageObtain2.obj = appIdInfo2;
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        long jMax = GslbSdk.isInitSuccess(l.d().c()) ? 3000L : 6000L;
                        long j13 = appIdInfo2.lastRequestTime;
                        if (jCurrentTimeMillis2 >= j13) {
                            long j14 = jCurrentTimeMillis2 - j13;
                            message2 = messageObtain2;
                            long j15 = appIdInfo2.waitTime;
                            if (j14 < j15) {
                                jMax = Math.max((j13 + j15) - jCurrentTimeMillis2, jMax);
                            }
                        } else {
                            message2 = messageObtain2;
                        }
                        if (this.f57404a.hasMessages(303, appIdInfo2)) {
                            return false;
                        }
                        this.f57404a.sendMessageDelayed(message2, jMax);
                        f.f57417a.g("Appid : " + iIntValue2 + " delay " + jMax + " ms refresh odid ");
                        return false;
                    }
                    f.f57417a.g("OneID disable or network unavailable");
                    this.f57404a.sendEmptyMessage(201);
                    return false;
                default:
                    return false;
            }
        } catch (Exception e16) {
            f.f57417a.i(Log.getStackTraceString(e16));
            return false;
        }
        f.f57417a.i(Log.getStackTraceString(e16));
        return false;
    }

    public String i(int i11) {
        AppIdInfo appIdInfo;
        String str;
        ConcurrentHashMap<Integer, AppIdInfo> concurrentHashMap = this.f57415m;
        return (concurrentHashMap == null || (appIdInfo = concurrentHashMap.get(Integer.valueOf(i11))) == null || (str = appIdInfo.odid) == null) ? "" : str;
    }

    public final void j() {
        try {
            if (this.f57412j.tryLock()) {
                Handler handler = this.f57404a;
                if (handler == null || this.f57405b == null) {
                    HandlerThread handlerThread = new HandlerThread("OneID Worker");
                    this.f57405b = handlerThread;
                    handlerThread.setPriority(10);
                    this.f57405b.start();
                    this.f57404a = new Handler(this.f57405b.getLooper(), this);
                } else if (handler.hasMessages(201)) {
                    this.f57404a.removeMessages(201);
                }
            }
        } catch (Exception e11) {
            f.f57417a.i(Log.getStackTraceString(e11));
        } finally {
            this.f57412j.unlock();
        }
    }

    public final void k() {
        ConcurrentHashMap<Integer, AppIdInfo> concurrentHashMap = this.f57415m;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            String strH = k20.b.b(this.f57413k).h("appid_info_list");
            if (!TextUtils.isEmpty(strH)) {
                f.f57417a.g("AppId Records : " + strH);
                try {
                    this.f57415m = (ConcurrentHashMap) new Gson().fromJson(strH, new a(this).getType());
                } catch (Exception e11) {
                    f.f57417a.i(Log.getStackTraceString(e11));
                }
            }
            if (this.f57415m == null) {
                this.f57415m = new ConcurrentHashMap<>();
            }
        }
    }

    public void l() {
        f.f57417a.g("retry");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (OneID.f57389c) {
            long j11 = this.f57409g;
            if (jCurrentTimeMillis < j11 || jCurrentTimeMillis - j11 >= ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
                if (this.f57412j.tryLock()) {
                    try {
                        if (this.f57405b == null) {
                            j();
                        }
                        this.f57412j.unlock();
                    } catch (Throwable th2) {
                        this.f57412j.unlock();
                        throw th2;
                    }
                }
                Handler handler = this.f57404a;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                    this.f57404a.sendEmptyMessage(200);
                    return;
                }
                return;
            }
        }
        f.f57417a.g(OneID.f57389c ? "Post time not yet reached" : "OneID disable");
    }
}
