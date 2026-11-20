package com.bytedance.sdk.openadsdk.Dl;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {
    private sc We;
    private pFF pFF;
    private We zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f27067sc = "StrategyCenter";
    private int ExN = 0;
    private Runnable TRI = new Runnable() { // from class: com.bytedance.sdk.openadsdk.Dl.zY.2
        @Override // java.lang.Runnable
        public void run() {
            zY.this.pFF();
        }
    };

    public zY(We we2) {
        this.pFF = null;
        ExN exN = new ExN(we2);
        this.zY = exN;
        String strZY = exN.zY();
        if (!TextUtils.isEmpty(strZY) && !strZY.startsWith("pag")) {
            strZY = "pag_".concat(strZY);
        }
        this.pFF = new pFF(this.zY.pFF(), strZY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF() {
        We we2 = this.zY;
        if (we2 == null || we2.ExN() == null || this.zY.TRI() == null) {
            return;
        }
        this.zY.sc().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Dl.zY.1
            @Override // java.lang.Runnable
            public void run() {
                OutputStream outputStream;
                zY.this.ExN++;
                try {
                    if (zY.this.We != null) {
                        zY.this.We.sc();
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(zY.this.zY.ExN()).openConnection()));
                    if (zY.this.zY.qr() != null && zY.this.zY.qr().size() > 0) {
                        for (Map.Entry<String, String> entry : zY.this.zY.qr().entrySet()) {
                            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
                    try {
                        outputStream = httpURLConnection.getOutputStream();
                        try {
                            outputStream.write(zY.this.zY.TRI().toString().getBytes());
                            outputStream.close();
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode == 200) {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                                StringBuffer stringBuffer = new StringBuffer();
                                while (true) {
                                    String line = bufferedReader.readLine();
                                    if (line == null) {
                                        break;
                                    } else {
                                        stringBuffer.append(line);
                                    }
                                }
                                bufferedReader.close();
                                JSONObject jSONObjectSc = zY.this.zY.sc(new JSONObject(stringBuffer.toString()));
                                zY.this.pFF.sc();
                                zY.this.pFF.sc(jSONObjectSc);
                                if (zY.this.We != null) {
                                    zY.this.We.pFF();
                                }
                            } else if (zY.this.We != null) {
                                zY.this.We.sc(responseCode, httpURLConnection.getResponseMessage());
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        outputStream = null;
                    }
                } catch (Throwable th4) {
                    Log.e("StrategyCenter", th4.getMessage() == null ? "error " : th4.getMessage());
                    if (zY.this.We != null) {
                        zY.this.We.sc(-1, th4.getMessage());
                    }
                }
                zY.this.pFF.sc("local_last_update_time", System.currentTimeMillis());
                zY.this.sc();
            }
        });
    }

    public int sc(String str, int i11) {
        pFF pff = this.pFF;
        return pff == null ? i11 : pff.sc(str, i11);
    }

    public String sc(String str, String str2) {
        pFF pff = this.pFF;
        return pff == null ? str2 : pff.sc(str, str2);
    }

    public void sc() {
        if (this.zY != null) {
            int i11 = 3600000;
            int iSc = this.pFF.sc("req_interval", 3600000);
            long j11 = 0;
            long jPFF = this.pFF.pFF("local_last_update_time", 0L);
            if (iSc >= 600000 && iSc <= 86400000) {
                i11 = iSc;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - jPFF;
            "before  realInterval=".concat(String.valueOf(jCurrentTimeMillis));
            if (jCurrentTimeMillis >= 0) {
                long j12 = i11;
                if (jCurrentTimeMillis <= j12) {
                    j11 = j12 - jCurrentTimeMillis;
                }
            }
            "after  realInterval=".concat(String.valueOf(j11));
            this.zY.We().removeCallbacks(this.TRI);
            if (this.ExN > 24) {
                return;
            }
            this.zY.We().postDelayed(this.TRI, j11);
        }
    }

    public void sc(sc scVar) {
        this.We = scVar;
    }

    public boolean sc(String str, boolean z11) {
        pFF pff = this.pFF;
        return pff == null ? z11 : pff.sc(str, z11);
    }
}
