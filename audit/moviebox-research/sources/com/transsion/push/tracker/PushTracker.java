package com.transsion.push.tracker;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.transsion.core.deviceinfo.DeviceInfo;
import com.transsion.core.utils.a;
import com.transsion.push.PushConstants;
import com.transsion.push.PushManager;
import com.transsion.push.bean.PushPointInfo;
import com.transsion.push.bean.PushRequest;
import com.transsion.push.bean.TrackerResponse;
import com.transsion.push.config.PushRepository;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.ThreadManager;
import d.f;
import d.g;
import d.i;
import d.n;
import d.x;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ys.b;
import ys.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
final class PushTracker {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static PushTracker f57014b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f57015a;

    public static PushTracker getInstance() {
        if (f57014b == null) {
            f57014b = new PushTracker();
        }
        return f57014b;
    }

    public final JSONObject a() {
        JSONException e11;
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("app_id", x.d());
                jSONObject.put("app_ver", a.c());
                jSONObject.put("app_ver_code", a.b());
                jSONObject.put("gaid", DeviceInfo.e());
                jSONObject.put("pkg_name", a.a());
                jSONObject.put("sdk_ver", "1.8.5.02");
                jSONObject.put("sdk_ver_code", 17004);
                jSONObject.put("tz", f.a());
                jSONObject.put(PlaceTypes.COUNTRY, Locale.getDefault().getCountry());
                String strReplace = Build.BRAND;
                if (!TextUtils.isEmpty(strReplace)) {
                    strReplace = strReplace.toUpperCase().replace(" ", "");
                }
                jSONObject.put("brand", strReplace);
                jSONObject.put("mcc", f.e());
                jSONObject.put("mnc", f.e());
                jSONObject.put("device_type", f.f(this.f57015a) ? "pad" : "phone");
                jSONObject.put("android_ver", Build.VERSION.RELEASE);
                jSONObject.put("os_ver", Build.VERSION.SDK_INT);
            } catch (JSONException e12) {
                e11 = e12;
                e11.printStackTrace();
            }
        } catch (JSONException e13) {
            e11 = e13;
            jSONObject = null;
        }
        return jSONObject;
    }

    public final JSONObject d(Tracker.KEY key, Bundle bundle) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("name", key.event);
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put("network_type", i.b());
                if (bundle != null && !bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str : bundle.keySet()) {
                        jSONObject2.put(str, bundle.get(str));
                    }
                    jSONObject.put("extra", jSONObject2);
                    return jSONObject;
                }
                return jSONObject;
            } catch (JSONException e11) {
                e = e11;
                e.printStackTrace();
            }
        } catch (JSONException e12) {
            e = e12;
            jSONObject = null;
        }
    }

    public final void g(JSONObject jSONObject, List<PushPointInfo> list) {
        String str;
        if (jSONObject == null || list == null || list.size() <= 0) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<PushPointInfo> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(new JSONObject(it.next().evt));
            }
            jSONObject.put("evt", jSONArray);
            String string = jSONObject.toString();
            PushLogUtils.LOG.g("request body:" + string);
            if (PushManager.getInstance().getTestEnv()) {
                str = PushConstants.TEST_POINT_REPORT;
            } else {
                str = PushManager.getInstance().getDebug() ? PushConstants.DEBUG_POINT_REPORT : PushConstants.RELEASE_POINT_REPORT;
            }
            PushLogUtils.LOG.g("request url:" + str);
            b bVar = new b();
            c cVar = new c(PushConstants.RSA_PUB_KEY);
            PushRequest pushRequest = new PushRequest();
            String strC = bVar.c(bVar.e(string));
            String strC2 = bVar.c(cVar.d(bVar.i()));
            pushRequest.data = strC;
            pushRequest.key = strC2;
            byte[] bArrD = g.d(str, com.transsion.json.b.b(pushRequest).getBytes());
            if (bArrD == null) {
                PushLogUtils.LOG.i("the response data is empty");
                return;
            }
            TrackerResponse trackerResponse = (TrackerResponse) com.transsion.json.b.a(new String(bArrD), TrackerResponse.class);
            if (trackerResponse != null && trackerResponse.config != null) {
                PushLogUtils.LOG.g("post points response:" + trackerResponse);
                if (trackerResponse.status == 200) {
                    PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_IMMEDIATELY_TRACK, Boolean.valueOf(trackerResponse.config.reportType == 0));
                    PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_TRACKER_REPORT_INTERVAL, Long.valueOf(trackerResponse.config.reportTime));
                    PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_TRACKER_REPORT_TIME, Long.valueOf(System.currentTimeMillis() + n.f()));
                    v6.a.a().c(list);
                    return;
                }
                PushLogUtils.LOG.i("post points response status error, status:" + trackerResponse.status + ", " + trackerResponse.message);
                return;
            }
            PushLogUtils.LOG.i("parse post points BaseResponse failed");
        } catch (Exception e11) {
            PushLogUtils.LOG.i("post points Exception: " + e11.getMessage());
        }
    }

    public final void h(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("evt", jSONArray);
            String string = jSONObject.toString();
            PushLogUtils.LOG.g("request body:" + string);
            if (PushManager.getInstance().getTestEnv()) {
                str = PushConstants.TEST_POINT_REPORT;
            } else {
                str = PushManager.getInstance().getDebug() ? PushConstants.DEBUG_POINT_REPORT : PushConstants.RELEASE_POINT_REPORT;
            }
            PushLogUtils.LOG.g("request url:" + str);
            b bVar = new b();
            c cVar = new c(PushConstants.RSA_PUB_KEY);
            PushRequest pushRequest = new PushRequest();
            String strC = bVar.c(bVar.e(string));
            String strC2 = bVar.c(cVar.d(bVar.i()));
            pushRequest.data = strC;
            pushRequest.key = strC2;
            byte[] bArrD = g.d(str, com.transsion.json.b.b(pushRequest).getBytes());
            if (bArrD == null) {
                PushLogUtils.LOG.i("the response data is empty");
                v6.a.a().b(jSONObject2.toString());
                return;
            }
            TrackerResponse trackerResponse = (TrackerResponse) com.transsion.json.b.a(new String(bArrD), TrackerResponse.class);
            if (trackerResponse == null) {
                PushLogUtils.LOG.i("parse post point BaseResponse failed");
                v6.a.a().b(jSONObject2.toString());
                return;
            }
            PushLogUtils.LOG.g("post point response:" + trackerResponse);
            if (trackerResponse.status == 200) {
                PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_IMMEDIATELY_TRACK, Boolean.valueOf(trackerResponse.config.reportType == 0));
                PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_TRACKER_REPORT_INTERVAL, Long.valueOf(trackerResponse.config.reportTime));
                return;
            }
            PushLogUtils.LOG.i("post point response status error, status:" + trackerResponse.status + ", " + trackerResponse.message);
            v6.a.a().b(jSONObject2.toString());
        } catch (Exception e11) {
            PushLogUtils.LOG.i("post point Exception: " + e11.getMessage());
            v6.a.a().b(jSONObject2.toString());
        }
    }

    public void i(final Tracker.KEY key, final Bundle bundle) {
        boolean zBooleanValue = ((Boolean) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_START_POINT_REPORT, Boolean.FALSE)).booleanValue();
        PushLogUtils.LOG.g("push tracker isStartPointReport:" + zBooleanValue + ", key:" + key.event);
        if (zBooleanValue) {
            ThreadManager.executeInBackground(new Runnable() { // from class: com.transsion.push.tracker.PushTracker.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObjectD = PushTracker.this.d(key, bundle);
                    if (!n.g()) {
                        v6.a.a().b(jSONObjectD.toString());
                    } else {
                        PushTracker.this.h(PushTracker.this.a(), jSONObjectD);
                    }
                }
            });
        }
    }

    public void tracks() {
        boolean zBooleanValue = ((Boolean) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_START_POINT_REPORT, Boolean.FALSE)).booleanValue();
        PushLogUtils.LOG.g("push trackers isStartPointReport:" + zBooleanValue);
        if (!zBooleanValue) {
            PushLogUtils.LOG.g("check tracker report");
        } else if (x.x()) {
            PushLogUtils.LOG.g("check tracker report");
            ThreadManager.executeInBackground(new Runnable() { // from class: com.transsion.push.tracker.PushTracker.2
                @Override // java.lang.Runnable
                public void run() {
                    List<PushPointInfo> listD = v6.a.a().d();
                    if (listD == null || listD.size() <= 0) {
                        PushLogUtils.LOG.g("No tracker content reporting");
                    } else {
                        PushTracker.this.g(PushTracker.this.a(), listD);
                    }
                }
            });
        }
    }
}
