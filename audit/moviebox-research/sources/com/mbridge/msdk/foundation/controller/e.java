package com.mbridge.msdk.foundation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f44101a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f44105e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f44107g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f44108h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f44109i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f44110j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f44111k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private a f44112l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final SharedPreferences f44113m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f44102b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f44103c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f44104d = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f44106f = false;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a();
    }

    public e(Context context) {
        this.f44101a = "";
        this.f44105e = 0;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        this.f44113m = defaultSharedPreferences;
        if (defaultSharedPreferences != null) {
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }
        if (defaultSharedPreferences != null) {
            this.f44101a = defaultSharedPreferences.getString("IABTCF_TCString", "");
            this.f44105e = defaultSharedPreferences.getInt("IABTCF_gdprApplies", 0);
            a(defaultSharedPreferences.getString("IABTCF_PurposeConsents", ""));
            b(defaultSharedPreferences.getString("IABTCF_VendorConsents", ""));
            c(defaultSharedPreferences.getString("IABTCF_AddtlConsent", ""));
        }
    }

    private void a(String str) {
        this.f44107g = a(str, 1);
        this.f44108h = a(str, 2);
        this.f44102b = str;
    }

    private boolean a(String str, int i11) {
        return d(str) && i11 <= str.length() && i11 >= 1 && '1' == str.charAt(i11 - 1);
    }

    private void b(String str) {
        this.f44109i = a(str, 867);
        this.f44103c = str;
    }

    private void c(String str) {
        this.f44104d = str;
        if (TextUtils.isEmpty(str)) {
            this.f44110j = true;
            return;
        }
        if (MBridgeConstans.GOOGLE_ATP_ID == -1) {
            this.f44111k = false;
            return;
        }
        this.f44111k = true;
        try {
            String[] strArrSplit = str.split("~");
            if (strArrSplit.length > 1) {
                if (TextUtils.isEmpty(strArrSplit[1])) {
                    this.f44110j = false;
                } else {
                    this.f44110j = str.contains(String.valueOf(MBridgeConstans.GOOGLE_ATP_ID));
                }
            }
        } catch (Throwable th2) {
            ad.b("TCStringManager", th2.getMessage());
        }
    }

    private boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[01]+");
    }

    public final String a() {
        return this.f44101a;
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.f44112l = aVar;
        }
    }

    public final boolean b() {
        boolean z11 = true;
        if (this.f44105e == 0) {
            this.f44106f = true;
            return true;
        }
        if (!d(this.f44102b) || !d(this.f44103c)) {
            this.f44106f = z11;
        } else if (MBridgeConstans.VERIFY_ATP_CONSENT) {
            this.f44106f = (this.f44109i || (this.f44111k && this.f44110j)) && this.f44107g && this.f44108h;
        } else {
            if (!this.f44109i || !this.f44107g || !this.f44108h) {
                z11 = false;
            }
            this.f44106f = z11;
        }
        return this.f44106f;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:25:0x0047  */
    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        byte b11;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            switch (str) {
                case "IABTCF_PurposeConsents":
                    b11 = 2;
                    break;
                case "IABTCF_gdprApplies":
                    b11 = 1;
                    break;
                case "IABTCF_TCString":
                    b11 = 0;
                    break;
                case "IABTCF_AddtlConsent":
                    b11 = 4;
                    break;
                case "IABTCF_VendorConsents":
                    b11 = 3;
                    break;
                default:
                    b11 = -1;
                    break;
            }
            if (b11 == 0) {
                this.f44101a = sharedPreferences.getString("IABTCF_TCString", "");
            } else if (b11 == 1) {
                this.f44105e = sharedPreferences.getInt("IABTCF_gdprApplies", 0);
            } else if (b11 == 2) {
                a(sharedPreferences.getString("IABTCF_PurposeConsents", ""));
            } else if (b11 == 3) {
                b(sharedPreferences.getString("IABTCF_VendorConsents", ""));
            } else if (b11 == 4) {
                c(sharedPreferences.getString("IABTCF_AddtlConsent", ""));
            }
            a aVar = this.f44112l;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th2) {
            ad.b("TCStringManager", th2.getMessage());
        }
    }
}
