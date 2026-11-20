package com.transsion.sdk.oneid.data;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.transsion.sdk.oneid.f;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class RomInfo extends OneBaseInfo implements Serializable {
    public String api;
    public String aver;
    public String build_id;
    public String build_spv;
    public String buildt;
    public String buildv;

    /* JADX INFO: renamed from: fp, reason: collision with root package name */
    public String f57402fp;
    public String gsmv;
    public String osver;

    public RomInfo(Context context) {
        this.aver = "";
        this.api = "";
        this.buildv = "";
        this.buildt = "";
        this.osver = "";
        this.build_id = "";
        this.build_spv = "";
        this.gsmv = "";
        this.f57402fp = "";
        this.aver = Build.VERSION.RELEASE;
        this.api = "" + Build.VERSION.SDK_INT;
        try {
            this.buildv = f.e(context, "ro.product.build.id");
        } catch (Exception unused) {
        }
        try {
            this.buildt = f.e(context, "ro.system.build.date.utc");
        } catch (Exception unused2) {
        }
        try {
            String strE = f.e(context, "ro.tranos.version");
            this.osver = strE;
            if (TextUtils.isEmpty(strE)) {
                this.osver = f.e(context, "ro.os_product.version");
            }
        } catch (Exception unused3) {
        }
        try {
            this.build_id = f.e(context, "ro.system.build.id");
        } catch (Exception unused4) {
        }
        try {
            this.build_spv = f.e(context, "ro.vendor.build.security_patch");
        } catch (Exception unused5) {
        }
        try {
            this.gsmv = f.e(context, "gsm.version.baseband");
        } catch (Exception unused6) {
        }
        try {
            this.f57402fp = f.e(context, "ro.build.fingerprint");
        } catch (Exception unused7) {
        }
    }
}
