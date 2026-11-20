package com.bytedance.sdk.openadsdk.Sfl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.core.app.NotificationCompat;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI {
    private WeakReference<Qj> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Context f27176sc;
    private Map<String, sc> zY = new HashMap();
    private SensorEventListener We = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i11) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Qj qjWe;
            if (sensorEvent.sensor.getType() != 1 || (qjWe = TRI.this.We()) == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f11 = fArr[0];
            float f12 = fArr[1];
            float f13 = fArr[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f11);
                jSONObject.put("y", f12);
                jSONObject.put("z", f13);
                qjWe.sc("accelerometer_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener ExN = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.12
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i11) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Qj qjWe;
            if (sensorEvent.sensor.getType() != 4 || (qjWe = TRI.this.We()) == null) {
                return;
            }
            float degrees = (float) Math.toDegrees(sensorEvent.values[0]);
            float degrees2 = (float) Math.toDegrees(sensorEvent.values[1]);
            float degrees3 = (float) Math.toDegrees(sensorEvent.values[2]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", degrees);
                jSONObject.put("y", degrees2);
                jSONObject.put("z", degrees3);
                qjWe.sc("gyro_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener TRI = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.23
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i11) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Qj qjWe;
            if (sensorEvent.sensor.getType() != 10 || (qjWe = TRI.this.We()) == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f11 = fArr[0];
            float f12 = fArr[1];
            float f13 = fArr[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f11);
                jSONObject.put("y", f12);
                jSONObject.put("z", f13);
                qjWe.sc("accelerometer_grativityless_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private SensorEventListener f27175qr = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.34
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i11) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                float[] fArr2 = WH.pFF;
                System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            } else if (sensorEvent.sensor.getType() == 2) {
                float[] fArr3 = sensorEvent.values;
                float[] fArr4 = WH.zY;
                System.arraycopy(fArr3, 0, fArr4, 0, fArr4.length);
            }
            float[] fArr5 = WH.We;
            SensorManager.getRotationMatrix(fArr5, null, WH.pFF, WH.zY);
            float[] fArr6 = WH.ExN;
            SensorManager.getOrientation(fArr5, fArr6);
            Qj qjWe = TRI.this.We();
            if (qjWe == null) {
                return;
            }
            float f11 = fArr6[0];
            float f12 = fArr6[1];
            float f13 = fArr6[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("alpha", f11);
                jSONObject.put("beta", f12);
                jSONObject.put("gamma", f13);
                qjWe.sc("rotation_vector_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        JSONObject sc(JSONObject jSONObject) throws Throwable;
    }

    public TRI(Qj qj2) {
        this.f27176sc = qj2.sc();
        this.pFF = new WeakReference<>(qj2);
        zY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.Sfl.sc ExN() {
        Qj qjWe = We();
        if (qjWe == null) {
            return null;
        }
        return qjWe.Xc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Qj We() {
        WeakReference<Qj> weakReference = this.pFF;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void zY() {
        this.zY.put("adInfo", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.45
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                if (qjWe == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectSfl = qjWe.Sfl();
                if (jSONObjectSfl != null) {
                    jSONObjectSfl.put(TrackingKey.CODE, 1);
                    return jSONObjectSfl;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(TrackingKey.CODE, -1);
                return jSONObject3;
            }
        });
        this.zY.put("appInfo", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.56
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TrackingKey.CODE, 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.6.0");
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = TRI.this.sc().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put("supportList", jSONArray);
                Qj qjWe = TRI.this.We();
                if (qjWe != null) {
                    jSONObject2.put("deviceId", qjWe.qr());
                    jSONObject2.put("netType", qjWe.dE());
                    jSONObject2.put("innerAppName", qjWe.We());
                    jSONObject2.put("appName", qjWe.ExN());
                    jSONObject2.put("appVersion", qjWe.TRI());
                    Map<String, String> mapPFF = qjWe.pFF();
                    for (String str : mapPFF.keySet()) {
                        jSONObject2.put(str, mapPFF.get(str));
                    }
                }
                return jSONObject2;
            }
        });
        this.zY.put("playableSDKInfo", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.61
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TrackingKey.CODE, 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.6.0");
                jSONObject2.put("os", "android");
                return jSONObject2;
            }
        });
        this.zY.put("subscribe_app_ad", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.62
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.Sfl.sc scVarExN = TRI.this.ExN();
                JSONObject jSONObject2 = new JSONObject();
                if (scVarExN == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("download_app_ad", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.63
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.Sfl.sc scVarExN = TRI.this.ExN();
                JSONObject jSONObject2 = new JSONObject();
                if (scVarExN == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("isViewable", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.2
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                if (qjWe == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(TrackingKey.CODE, 1);
                jSONObject3.put("viewStatus", qjWe.Ol());
                return jSONObject3;
            }
        });
        this.zY.put("getVolume", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.3
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                if (qjWe == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(TrackingKey.CODE, 1);
                jSONObject3.put("endcard_mute", qjWe.Qj());
                return jSONObject3;
            }
        });
        this.zY.put("getScreenSize", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.4
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                if (qjWe == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectWjp = qjWe.wjp();
                jSONObjectWjp.put(TrackingKey.CODE, 1);
                return jSONObjectWjp;
            }
        });
        this.zY.put("start_accelerometer_observer", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.5
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th2) {
                        qr.sc("PlayableJsBridge", "invoke start_accelerometer_observer error", th2);
                        jSONObject2.put(TrackingKey.CODE, -1);
                        jSONObject2.put("codeMsg", th2.toString());
                        return jSONObject2;
                    }
                }
                WH.sc(TRI.this.f27176sc, TRI.this.We, iOptInt);
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("close_accelerometer_observer", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.6
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    WH.sc(TRI.this.f27176sc, TRI.this.We);
                    jSONObject2.put(TrackingKey.CODE, 1);
                    return jSONObject2;
                } catch (Throwable th2) {
                    qr.sc("PlayableJsBridge", "invoke close_accelerometer_observer error", th2);
                    jSONObject2.put(TrackingKey.CODE, -1);
                    jSONObject2.put("codeMsg", th2.toString());
                    return jSONObject2;
                }
            }
        });
        this.zY.put("start_gyro_observer", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.7
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th2) {
                        qr.sc("PlayableJsBridge", "invoke start_gyro_observer error", th2);
                        jSONObject2.put(TrackingKey.CODE, -1);
                        jSONObject2.put("codeMsg", th2.toString());
                        return jSONObject2;
                    }
                }
                WH.pFF(TRI.this.f27176sc, TRI.this.ExN, iOptInt);
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("close_gyro_observer", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.8
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    WH.sc(TRI.this.f27176sc, TRI.this.ExN);
                    jSONObject2.put(TrackingKey.CODE, 1);
                    return jSONObject2;
                } catch (Throwable th2) {
                    qr.sc("PlayableJsBridge", "invoke close_gyro_observer error", th2);
                    jSONObject2.put(TrackingKey.CODE, -1);
                    jSONObject2.put("codeMsg", th2.toString());
                    return jSONObject2;
                }
            }
        });
        this.zY.put("start_accelerometer_grativityless_observer", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.9
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th2) {
                        qr.sc("PlayableJsBridge", "invoke start_accelerometer_grativityless_observer error", th2);
                        jSONObject2.put(TrackingKey.CODE, -1);
                        jSONObject2.put("codeMsg", th2.toString());
                        return jSONObject2;
                    }
                }
                WH.zY(TRI.this.f27176sc, TRI.this.TRI, iOptInt);
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("close_accelerometer_grativityless_observer", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.10
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    WH.sc(TRI.this.f27176sc, TRI.this.TRI);
                    jSONObject2.put(TrackingKey.CODE, 1);
                    return jSONObject2;
                } catch (Throwable th2) {
                    qr.sc("PlayableJsBridge", "invoke close_accelerometer_grativityless_observer error", th2);
                    jSONObject2.put(TrackingKey.CODE, -1);
                    jSONObject2.put("codeMsg", th2.toString());
                    return jSONObject2;
                }
            }
        });
        this.zY.put("start_rotation_vector_observer", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.11
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th2) {
                        qr.sc("PlayableJsBridge", "invoke start_rotation_vector_observer error", th2);
                        jSONObject2.put(TrackingKey.CODE, -1);
                        jSONObject2.put("codeMsg", th2.toString());
                        return jSONObject2;
                    }
                }
                WH.We(TRI.this.f27176sc, TRI.this.f27175qr, iOptInt);
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("close_rotation_vector_observer", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.13
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    WH.sc(TRI.this.f27176sc, TRI.this.f27175qr);
                    jSONObject2.put(TrackingKey.CODE, 1);
                    return jSONObject2;
                } catch (Throwable th2) {
                    qr.sc("PlayableJsBridge", "invoke close_rotation_vector_observer error", th2);
                    jSONObject2.put(TrackingKey.CODE, -1);
                    jSONObject2.put("codeMsg", th2.toString());
                    return jSONObject2;
                }
            }
        });
        this.zY.put("device_shake", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.14
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    WH.sc(TRI.this.f27176sc, 300L);
                    jSONObject2.put(TrackingKey.CODE, 1);
                    return jSONObject2;
                } catch (Throwable th2) {
                    qr.sc("PlayableJsBridge", "invoke device_shake error", th2);
                    jSONObject2.put(TrackingKey.CODE, -1);
                    jSONObject2.put("codeMsg", th2.toString());
                    return jSONObject2;
                }
            }
        });
        this.zY.put("device_shake_short", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.15
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    WH.sc(TRI.this.f27176sc, 150L);
                    jSONObject2.put(TrackingKey.CODE, 1);
                    return jSONObject2;
                } catch (Throwable th2) {
                    qr.sc("PlayableJsBridge", "invoke device_shake error", th2);
                    jSONObject2.put(TrackingKey.CODE, -1);
                    jSONObject2.put("codeMsg", th2.toString());
                    return jSONObject2;
                }
            }
        });
        this.zY.put("playable_style", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.16
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectZY = qjWe.zY();
                jSONObjectZY.put(TrackingKey.CODE, 1);
                return jSONObjectZY;
            }
        });
        this.zY.put("sendReward", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.17
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                qjWe.Dl();
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("webview_time_track", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.18
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                return new JSONObject();
            }
        });
        this.zY.put("playable_event", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.19
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null || jSONObject == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                qjWe.pFF(jSONObject.optString(NotificationCompat.CATEGORY_EVENT, null), jSONObject.optJSONObject("params"));
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("reportAd", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.20
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put(CampaignEx.JSON_NATIVE_VIDEO_CLOSE, new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.21
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("openAdLandPageLinks", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.22
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("get_viewport", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.24
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectYIK = qjWe.YIK();
                jSONObjectYIK.put(TrackingKey.CODE, 1);
                return jSONObjectYIK;
            }
        });
        this.zY.put("jssdk_load_finish", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.25
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                qjWe.Gb();
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_material_render_result", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.26
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                qjWe.Ol(jSONObject);
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("detect_change_playable_click", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.27
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectWH = qjWe.WH();
                jSONObjectWH.put(TrackingKey.CODE, 1);
                return jSONObjectWH;
            }
        });
        this.zY.put("check_camera_permission", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.28
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectQl = qjWe.Ql();
                jSONObjectQl.put(TrackingKey.CODE, 1);
                return jSONObjectQl;
            }
        });
        this.zY.put("check_external_storage", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.29
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectSR = qjWe.SR();
                if (jSONObjectSR.isNull("result")) {
                    jSONObjectSR.put(TrackingKey.CODE, -1);
                } else {
                    jSONObjectSR.put(TrackingKey.CODE, 1);
                }
                return jSONObjectSR;
            }
        });
        this.zY.put("playable_open_camera", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.30
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_pick_photo", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.31
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_download_media_in_photos", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.32
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                qjWe.sc(jSONObject);
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_preventTouchEvent", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.33
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                qjWe.pFF(jSONObject);
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_settings_info", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.35
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectBT = qjWe.BT();
                jSONObjectBT.put(TrackingKey.CODE, 1);
                return jSONObjectBT;
            }
        });
        this.zY.put("playable_load_main_scene", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.36
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                qjWe.uEA();
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_enter_section", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.37
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                qjWe.We(jSONObject);
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_end", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.38
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                qjWe.JPJ();
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_finish_play_playable", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.39
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                qjWe.FI();
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_transfrom_module_show", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.40
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                qjWe.WP();
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_transfrom_module_change_color", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.41
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                qjWe.cvk();
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_set_scroll_rect", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.42
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_click_area", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.43
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                qjWe.ExN(jSONObject);
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_real_play_start", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.44
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_material_first_frame_show", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.46
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                qjWe.II();
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_stuck_check_pong", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.47
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                qjWe.McK();
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_material_adnormal_mask", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.48
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                qjWe.TRI(jSONObject);
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_long_press_panel", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.49
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_alpha_player_play", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.50
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_transfrom_module_highlight", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.51
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_send_click_event", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.52
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_query_media_permission_declare", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.53
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectQr = qjWe.qr(jSONObject);
                jSONObjectQr.put(TrackingKey.CODE, 1);
                return jSONObjectQr;
            }
        });
        this.zY.put("playable_query_media_permission_enable", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.54
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                Qj qjWe = TRI.this.We();
                JSONObject jSONObject2 = new JSONObject();
                if (qjWe == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectQj = qjWe.Qj(jSONObject);
                jSONObjectQj.put(TrackingKey.CODE, 1);
                return jSONObjectQj;
            }
        });
        this.zY.put("playable_apply_media_permission", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.55
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.Sfl.sc scVarExN = TRI.this.ExN();
                JSONObject jSONObject2 = new JSONObject();
                if (scVarExN == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_start_kws", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.57
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.Sfl.sc scVarExN = TRI.this.ExN();
                JSONObject jSONObject2 = new JSONObject();
                if (scVarExN == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_close_kws", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.58
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.Sfl.sc scVarExN = TRI.this.ExN();
                JSONObject jSONObject2 = new JSONObject();
                if (scVarExN == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_video_preload_task_add", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.59
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.Sfl.sc scVarExN = TRI.this.ExN();
                JSONObject jSONObject2 = new JSONObject();
                if (scVarExN == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
        this.zY.put("playable_video_preload_task_cancel", new sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.TRI.60
            @Override // com.bytedance.sdk.openadsdk.Sfl.TRI.sc
            public JSONObject sc(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.Sfl.sc scVarExN = TRI.this.ExN();
                JSONObject jSONObject2 = new JSONObject();
                if (scVarExN == null) {
                    jSONObject2.put(TrackingKey.CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(TrackingKey.CODE, 1);
                return jSONObject2;
            }
        });
    }

    public void pFF() {
        WH.sc(this.f27176sc, this.We);
        WH.sc(this.f27176sc, this.ExN);
        WH.sc(this.f27176sc, this.TRI);
        WH.sc(this.f27176sc, this.f27175qr);
    }

    public Set<String> sc() {
        return this.zY.keySet();
    }

    public JSONObject sc(String str, JSONObject jSONObject) {
        try {
            sc scVar = this.zY.get(str);
            if (scVar != null) {
                return scVar.sc(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(TrackingKey.CODE, -1);
            return jSONObject2;
        } catch (Throwable th2) {
            qr.sc("PlayableJsBridge", "invoke error", th2);
            return null;
        }
    }
}
