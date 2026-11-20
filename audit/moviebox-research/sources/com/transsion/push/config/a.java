package com.transsion.push.config;

import android.os.Build;
import android.text.TextUtils;
import com.transsion.core.deviceinfo.DeviceInfo;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.push.ITopicListener;
import com.transsion.push.PushConstants;
import com.transsion.push.bean.ConfigInfo;
import com.transsion.push.bean.PushRequest;
import com.transsion.push.bean.PushResponse;
import com.transsion.push.bean.SelfDestroyInfo;
import com.transsion.push.utils.NotificationAssistUtils;
import com.transsion.push.utils.PushLogUtils;
import d.f;
import d.g;
import d.i;
import d.n;
import d.t;
import d.x;
import d.y;
import d.z;
import java.util.ArrayList;
import java.util.Locale;
import ys.b;
import ys.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final PushRequest.ReportContentData a() {
        PushRequest.ReportContentData reportContentData = new PushRequest.ReportContentData();
        Locale locale = Locale.getDefault();
        reportContentData.vaid = AthenaAnalytics.x(ws.a.a(), true);
        reportContentData.gaid = DeviceInfo.e();
        reportContentData.sdkVersion = "1.8.5.02";
        reportContentData.sdkVersionCode = 17004;
        reportContentData.pkg = f.h();
        reportContentData.confVersion = n.a();
        reportContentData.whitelistVersion = z.a();
        if (t.j()) {
            reportContentData.platVer = t.a();
        }
        boolean zBooleanValue = ((Boolean) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_IS_REPORT_DETAIL, Boolean.TRUE)).booleanValue();
        if (TextUtils.isEmpty(reportContentData.clientId)) {
            zBooleanValue = true;
        }
        reportContentData.withDetail = zBooleanValue;
        if (zBooleanValue) {
            reportContentData.aid = DeviceInfo.c();
            String strReplace = Build.BRAND;
            if (!TextUtils.isEmpty(strReplace)) {
                strReplace = strReplace.toUpperCase().replace(" ", "");
            }
            reportContentData.brand = strReplace;
            reportContentData.androidVersion = Build.VERSION.RELEASE;
            reportContentData.cid = 0;
            reportContentData.lac = 0;
            reportContentData.language = locale.getLanguage() == null ? null : locale.getLanguage().toLowerCase();
            reportContentData.mcc = f.e();
            reportContentData.mnc = f.g();
            String strReplace2 = Build.MODEL;
            if (!TextUtils.isEmpty(strReplace2)) {
                strReplace2 = strReplace2.toUpperCase().replace(" ", "");
            }
            reportContentData.model = strReplace2;
            reportContentData.network = i.a();
            reportContentData.osVersion = String.valueOf(Build.VERSION.SDK_INT);
            reportContentData.appVersion = f.b(ws.a.a());
            reportContentData.appVersionCode = com.transsion.core.utils.a.b();
            reportContentData.token = (String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_FCM_TOKEN, "");
            reportContentData.country = locale.getCountry() != null ? locale.getCountry().toUpperCase() : null;
        }
        t.g(reportContentData);
        reportContentData.appId = x.d();
        reportContentData.appKey = x.l();
        reportContentData.clientId = (String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_CLIENT_ID, "");
        reportContentData.noticeEnable = NotificationAssistUtils.isOpenNotification(ws.a.a()) ? 1 : 2;
        return reportContentData;
    }

    public final PushRequest.TopicContentData b(String str, String str2) {
        PushRequest.TopicContentData topicContentData = new PushRequest.TopicContentData();
        topicContentData.clientId = (String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_CLIENT_ID, "");
        topicContentData.gaid = DeviceInfo.e();
        topicContentData.appId = x.d();
        topicContentData.appKey = x.l();
        topicContentData.appVersion = com.transsion.core.utils.a.c();
        topicContentData.appVersionCode = com.transsion.core.utils.a.b();
        topicContentData.sdkVersion = "1.8.5.02";
        topicContentData.sdkVersionCode = 17004;
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            topicContentData.topics = arrayList;
            arrayList.add(str.toLowerCase());
        }
        topicContentData.action = str2;
        return topicContentData;
    }

    public final <T> void c(ITopicListener iTopicListener, String str) {
        if (iTopicListener != null) {
            iTopicListener.onFail(str);
        }
    }

    public void d(String str, String str2, ITopicListener iTopicListener) {
        PushRequest.TopicContentData topicContentDataB = b(str, str2);
        PushLogUtils.LOG.g("topics request data: " + topicContentDataB.toString());
        b bVar = new b();
        c cVar = new c(PushConstants.RSA_PUB_KEY);
        PushRequest pushRequest = new PushRequest();
        try {
            String strC = bVar.c(bVar.e(com.transsion.json.b.b(topicContentDataB)));
            String strC2 = bVar.c(cVar.d(bVar.i()));
            pushRequest.data = strC;
            pushRequest.key = strC2;
            byte[] bytes = com.transsion.json.b.b(pushRequest).getBytes();
            String strI = t.i();
            if (TextUtils.isEmpty(strI)) {
                return;
            }
            String str3 = strI + x.d() + PushConstants.TOPICS_URL_PATH;
            PushLogUtils.LOG.g("topics request url:" + str3);
            byte[] bArrD = g.d(str3, bytes);
            if (bArrD == null) {
                PushLogUtils.LOG.i("the response data is empty");
                c(iTopicListener, "the response data is empty");
                return;
            }
            PushResponse pushResponse = (PushResponse) com.transsion.json.b.a(new String(bArrD), PushResponse.class);
            if (pushResponse == null) {
                PushLogUtils.LOG.i("parse topics BaseResponse failed");
                c(iTopicListener, "parse topics BaseResponse failed");
                return;
            }
            if (pushResponse.status == 200) {
                if (iTopicListener != null) {
                    iTopicListener.onSuccess();
                    return;
                }
                return;
            }
            PushLogUtils.LOG.i("topics BaseResponse status error, status:" + pushResponse.status + ", " + pushResponse.message);
            c(iTopicListener, "topics BaseResponse status error, status:" + pushResponse.status + ", " + pushResponse.message);
        } catch (Exception e11) {
            PushLogUtils.LOG.z("topics Exception: " + e11.getMessage());
            c(iTopicListener, "topics Exception: " + e11.getMessage());
        }
    }

    public final PushRequest.SelfDestroyContentData e() {
        PushRequest.SelfDestroyContentData selfDestroyContentData = new PushRequest.SelfDestroyContentData();
        selfDestroyContentData.appId = x.d();
        selfDestroyContentData.appKey = x.l();
        selfDestroyContentData.clientId = (String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_CLIENT_ID, "");
        selfDestroyContentData.sdkVersion = "1.8.5.02";
        selfDestroyContentData.sdkVersionCode = 17004;
        selfDestroyContentData.appVersion = f.b(ws.a.a());
        selfDestroyContentData.appVersionCode = com.transsion.core.utils.a.b();
        selfDestroyContentData.confVersion = n.a();
        selfDestroyContentData.whitelistVersion = z.a();
        return selfDestroyContentData;
    }

    public SelfDestroyInfo f() {
        try {
            PushRequest.SelfDestroyContentData selfDestroyContentDataE = e();
            PushLogUtils.LOG.g("get self-destroying request data: " + selfDestroyContentDataE.toString());
            b bVar = new b();
            c cVar = new c(PushConstants.RSA_PUB_KEY);
            PushRequest pushRequest = new PushRequest();
            String strC = bVar.c(bVar.e(com.transsion.json.b.b(selfDestroyContentDataE)));
            String strC2 = bVar.c(cVar.d(bVar.i()));
            pushRequest.data = strC;
            pushRequest.key = strC2;
            byte[] bytes = com.transsion.json.b.b(pushRequest).getBytes();
            String strI = t.i();
            if (TextUtils.isEmpty(strI)) {
                return null;
            }
            String str = strI + x.d() + PushConstants.CONFIG_URL_PATH;
            PushLogUtils.LOG.g("self-destroying request url:" + str);
            byte[] bArrD = g.d(str, bytes);
            if (bArrD == null) {
                PushLogUtils.LOG.i("the response data is empty");
                return null;
            }
            PushResponse pushResponse = (PushResponse) com.transsion.json.b.a(new String(bArrD), PushResponse.class);
            if (pushResponse == null) {
                PushLogUtils.LOG.i("parse self-destroying BaseResponse failed");
                return null;
            }
            if (pushResponse.status != 200) {
                PushLogUtils.LOG.i("self-destroying BaseResponse status error, status:" + pushResponse.status + ", " + pushResponse.message);
                return null;
            }
            PushResponse.SignedEncryptedData signedEncryptedData = pushResponse.data;
            if (signedEncryptedData == null) {
                PushLogUtils.LOG.i("parse self-destroying signedResponse failed");
                return null;
            }
            if (!cVar.g(y.b(bVar.a(signedEncryptedData.data)), bVar.a(signedEncryptedData.sign))) {
                PushLogUtils.LOG.i("self-destroying verify signature failed");
                return null;
            }
            SelfDestroyInfo selfDestroyInfo = (SelfDestroyInfo) com.transsion.json.b.a(new String(bVar.d(bVar.a(signedEncryptedData.data))), SelfDestroyInfo.class);
            if (selfDestroyInfo != null) {
                return selfDestroyInfo;
            }
            PushLogUtils.LOG.i("parse self-destroying info failed");
            return null;
        } catch (Exception e11) {
            PushLogUtils.LOG.z("self-destroying Exception: " + e11.getMessage());
            return null;
        }
    }

    public ConfigInfo g() {
        StringBuilder sb2;
        String str;
        try {
            PushRequest.ReportContentData reportContentDataA = a();
            PushLogUtils.LOG.g("get config request data: " + reportContentDataA.toString());
            b bVar = new b();
            c cVar = new c(PushConstants.RSA_PUB_KEY);
            PushRequest pushRequest = new PushRequest();
            String strC = bVar.c(bVar.e(com.transsion.json.b.b(reportContentDataA)));
            String strC2 = bVar.c(cVar.d(bVar.i()));
            pushRequest.data = strC;
            pushRequest.key = strC2;
            byte[] bytes = com.transsion.json.b.b(pushRequest).getBytes();
            String strI = t.i();
            if (TextUtils.isEmpty(strI)) {
                return null;
            }
            if (t.j()) {
                sb2 = new StringBuilder();
                sb2.append(strI);
                str = PushConstants.TPMS_URL_PATH;
            } else {
                sb2 = new StringBuilder();
                sb2.append(strI);
                sb2.append(x.d());
                str = PushConstants.UPDATE_URL_PATH;
            }
            sb2.append(str);
            String string = sb2.toString();
            PushLogUtils.LOG.g("request url:" + string);
            byte[] bArrD = g.d(string, bytes);
            if (bArrD == null) {
                PushLogUtils.LOG.i("the response data is empty");
                return null;
            }
            PushResponse pushResponse = (PushResponse) com.transsion.json.b.a(new String(bArrD), PushResponse.class);
            if (pushResponse == null) {
                PushLogUtils.LOG.i("parse syncActive BaseResponse failed");
                return null;
            }
            if (pushResponse.status != 200) {
                PushLogUtils.LOG.i("syncActive BaseResponse status error, status:" + pushResponse.status + ", " + pushResponse.message);
                return null;
            }
            PushResponse.SignedEncryptedData signedEncryptedData = pushResponse.data;
            if (signedEncryptedData == null) {
                PushLogUtils.LOG.i("parse syncActive signedResponse failed");
                return null;
            }
            if (!cVar.g(y.b(bVar.a(signedEncryptedData.data)), bVar.a(signedEncryptedData.sign))) {
                PushLogUtils.LOG.i("syncActive verify signature failed");
                return null;
            }
            ConfigInfo configInfo = (ConfigInfo) com.transsion.json.b.a(new String(bVar.d(bVar.a(signedEncryptedData.data))), ConfigInfo.class);
            if (configInfo != null) {
                return configInfo;
            }
            PushLogUtils.LOG.i("parse syncActive reportResponse failed");
            return null;
        } catch (Exception e11) {
            PushLogUtils.LOG.i("syncActive Exception: " + e11.getMessage());
            return null;
        }
    }
}
