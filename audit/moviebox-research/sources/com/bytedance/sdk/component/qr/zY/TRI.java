package com.bytedance.sdk.component.qr.zY;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.pFF.sc.BT;
import com.bytedance.sdk.component.pFF.sc.Ql;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI {
    private pFF ExN;
    private ExN Qj;
    private int Sfl;
    private boolean We;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private Context f26982qr;
    private sc zY;
    private long pFF = 0;
    private boolean TRI = false;
    private int Ol = 0;
    private long WH = 19700101000L;
    private int UFX = 0;
    private HashMap<String, Integer> Tf = new HashMap<>();
    private HashMap<String, Integer> Ql = new HashMap<>();
    private int SR = 0;
    private HashMap<String, Integer> BT = new HashMap<>();
    private HashMap<String, Integer> dE = new HashMap<>();
    private boolean Xc = true;
    private Map<String, Integer> wjp = new HashMap();

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    Handler f26983sc = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.sdk.component.qr.zY.TRI.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            TRI.this.pFF(message.arg1 != 0);
        }
    };

    private TRI() {
    }

    public TRI(int i11) {
        this.Sfl = i11;
    }

    private void Ol() {
        SharedPreferences sharedPreferences = this.f26982qr.getSharedPreferences(sc(), 0);
        this.Ol = sharedPreferences.getInt("tnc_probe_cmd", 0);
        this.WH = sharedPreferences.getLong("tnc_probe_version", 19700101000L);
    }

    private void WH() {
        this.UFX = 0;
        this.Tf.clear();
        this.Ql.clear();
        this.SR = 0;
        this.BT.clear();
        this.dE.clear();
    }

    private boolean We(String str) {
        Map<String, String> mapQr = qr();
        if (mapQr == null) {
            return false;
        }
        String str2 = mapQr.get(str);
        return (TextUtils.isEmpty(str2) || this.wjp.get(str2) == null || this.wjp.get(str2).intValue() < 3) ? false : true;
    }

    private void pFF(String str) {
        Map<String, String> mapQr;
        if (TextUtils.isEmpty(str) || (mapQr = qr()) == null || !mapQr.containsValue(str)) {
            return;
        }
        if (this.wjp.get(str) == null) {
            this.wjp.put(str, 1);
        } else {
            this.wjp.put(str, Integer.valueOf(this.wjp.get(str).intValue() + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(boolean z11) {
        We weTRI = TRI();
        if (weTRI == null) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (z11 || this.pFF + (((long) weTRI.UFX) * 1000) <= jElapsedRealtime) {
            this.pFF = jElapsedRealtime;
            Qj.sc().sc(this.Sfl, this.f26982qr).zY();
        }
    }

    private boolean pFF(int i11) {
        if (i11 < 100 || i11 >= 1000) {
            return true;
        }
        We weTRI = TRI();
        return (weTRI == null || TextUtils.isEmpty(weTRI.Ql) || !weTRI.Ql.contains(String.valueOf(i11))) ? false : true;
    }

    private String sc(Ql ql2) {
        if (ql2 == null || ql2.pFF() == null || ql2.pFF().sc() == null) {
            return "";
        }
        try {
            return InetAddress.getByName(ql2.pFF().sc().getHost()).getHostAddress();
        } catch (Exception unused) {
            return "";
        }
    }

    private void sc(BT bt2, String str) {
        String[] strArrSplit;
        int i11;
        long j11;
        We weTRI;
        if (bt2 != null && this.Xc) {
            String strSc = bt2.sc("tnc-cmd", null);
            if (TextUtils.isEmpty(strSc) || (strArrSplit = strSc.split("@")) == null || strArrSplit.length != 2) {
                return;
            }
            try {
                i11 = Integer.parseInt(strArrSplit[0]);
                try {
                    j11 = Long.parseLong(strArrSplit[1]);
                } catch (Throwable unused) {
                    j11 = 0;
                }
            } catch (Throwable unused2) {
                i11 = 0;
            }
            if (j11 <= this.WH) {
                return;
            }
            this.Ol = i11;
            this.WH = j11;
            this.f26982qr.getSharedPreferences(sc(), 0).edit().putInt("tnc_probe_cmd", i11).putLong("tnc_probe_version", j11).apply();
            if (this.Ol != 10000 || (weTRI = TRI()) == null) {
                return;
            }
            Random random = new Random(System.currentTimeMillis());
            int i12 = weTRI.Tf;
            sc(true, i12 > 0 ? ((long) random.nextInt(i12)) * 1000 : 0L);
        }
    }

    private void sc(boolean z11, long j11) {
        if (this.f26983sc.hasMessages(10000)) {
            return;
        }
        Message messageObtainMessage = this.f26983sc.obtainMessage();
        messageObtainMessage.what = 10000;
        messageObtainMessage.arg1 = z11 ? 1 : 0;
        if (j11 > 0) {
            this.f26983sc.sendMessageDelayed(messageObtainMessage, j11);
        } else {
            this.f26983sc.sendMessage(messageObtainMessage);
        }
    }

    private boolean sc(int i11) {
        return i11 >= 200 && i11 < 400;
    }

    private void zY(String str) {
        if (!TextUtils.isEmpty(str) && this.wjp.containsKey(str)) {
            this.wjp.put(str, 0);
        }
    }

    public void ExN() {
        this.wjp.clear();
    }

    public ExN Qj() {
        return this.Qj;
    }

    public We TRI() {
        ExN exN = this.Qj;
        if (exN != null) {
            return exN.zY();
        }
        return null;
    }

    public pFF We() {
        return this.ExN;
    }

    public sc pFF() {
        return this.zY;
    }

    public Map<String, String> qr() {
        We weTRI = TRI();
        if (weTRI != null) {
            return weTRI.We;
        }
        return null;
    }

    public String sc() {
        return "ttnet_tnc_config" + this.Sfl;
    }

    public String sc(String str) {
        String protocol;
        Map<String, String> mapQr;
        if (TextUtils.isEmpty(str) || str.contains("/network/get_network") || str.contains("/get_domains/v4") || str.contains("/ies/speed")) {
            return str;
        }
        String host = null;
        try {
            URL url = new URL(str);
            protocol = url.getProtocol();
            try {
                host = url.getHost();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            protocol = null;
        }
        if (TextUtils.isEmpty(protocol)) {
            return str;
        }
        if ((!HttpHost.DEFAULT_SCHEME_NAME.equals(protocol) && !"https".equals(protocol)) || TextUtils.isEmpty(host) || We(host) || (mapQr = qr()) == null || !mapQr.containsKey(host)) {
            return str;
        }
        String str2 = mapQr.get(host);
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        String str3 = protocol + "://" + host;
        return str.startsWith(str3) ? str.replaceFirst(str3, protocol + "://" + str2) : str;
    }

    public synchronized void sc(Context context, boolean z11) {
        try {
            if (!this.TRI) {
                this.f26982qr = context;
                this.Xc = z11;
                this.Qj = new ExN(context, z11, this.Sfl);
                if (z11) {
                    Ol();
                }
                this.zY = Qj.sc().sc(this.Sfl, this.f26982qr);
                this.TRI = true;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void sc(Ql ql2, BT bt2) {
        URL urlSc;
        if (ql2 == null || bt2 == null) {
            return;
        }
        if (this.Xc) {
            if (com.bytedance.sdk.component.qr.We.ExN.sc(this.f26982qr)) {
                try {
                    urlSc = ql2.pFF().sc();
                } catch (Exception unused) {
                    urlSc = null;
                }
                if (urlSc == null) {
                    return;
                }
                String protocol = urlSc.getProtocol();
                String host = urlSc.getHost();
                String path = urlSc.getPath();
                String strSc = sc(ql2);
                int iZY = bt2.zY();
                if (HttpHost.DEFAULT_SCHEME_NAME.equals(protocol) || "https".equals(protocol)) {
                    if (TextUtils.isEmpty(strSc)) {
                        return;
                    }
                    We weTRI = TRI();
                    if (weTRI != null && weTRI.pFF) {
                        sc(bt2, host);
                    }
                    if (weTRI == null) {
                        return;
                    }
                    this.Tf.size();
                    this.Ql.size();
                    this.BT.size();
                    this.dE.size();
                    if (iZY > 0) {
                        if (sc(iZY)) {
                            if (this.UFX > 0 || this.SR > 0) {
                                WH();
                            }
                            zY(host);
                            return;
                        }
                        if (!pFF(iZY)) {
                            this.SR++;
                            this.BT.put(path, 0);
                            this.dE.put(strSc, 0);
                            if (this.SR >= weTRI.Qj && this.BT.size() >= weTRI.Ol && this.dE.size() >= weTRI.WH) {
                                sc(false, 0L);
                                WH();
                            }
                            pFF(host);
                        }
                    }
                }
            }
        }
    }

    public synchronized void sc(Ql ql2, Exception exc) {
        URL urlSc;
        if (ql2 != null) {
            if (ql2.pFF() != null && exc != null) {
                if (this.Xc) {
                    if (com.bytedance.sdk.component.qr.We.ExN.sc(this.f26982qr)) {
                        try {
                            urlSc = ql2.pFF().sc();
                        } catch (Exception unused) {
                            urlSc = null;
                        }
                        if (urlSc == null) {
                            return;
                        }
                        String protocol = urlSc.getProtocol();
                        String host = urlSc.getHost();
                        String path = urlSc.getPath();
                        String strSc = sc(ql2);
                        if (HttpHost.DEFAULT_SCHEME_NAME.equals(protocol) || "https".equals(protocol)) {
                            We weTRI = TRI();
                            if (weTRI == null) {
                                return;
                            }
                            this.Tf.size();
                            this.Ql.size();
                            this.BT.size();
                            this.dE.size();
                            this.UFX++;
                            this.Tf.put(path, 0);
                            this.Ql.put(strSc, 0);
                            if (this.UFX >= weTRI.ExN && this.Tf.size() >= weTRI.TRI && this.Ql.size() >= weTRI.f26985qr) {
                                sc(false, 0L);
                                WH();
                            }
                            pFF(host);
                        }
                    }
                }
            }
        }
    }

    public void sc(pFF pff) {
        this.ExN = pff;
    }

    public void sc(boolean z11) {
        this.We = z11;
    }

    public boolean zY() {
        return this.We;
    }
}
