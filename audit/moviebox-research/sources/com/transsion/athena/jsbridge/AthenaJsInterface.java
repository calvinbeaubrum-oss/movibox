package com.transsion.athena.jsbridge;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.webkit.JavascriptInterface;
import athena.a0;
import athena.i0;
import athena.j0;
import athena.u0;
import br.g;
import cr.b;
import dr.a;
import java.util.Iterator;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class AthenaJsInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f50758a;

    public AthenaJsInterface(Context context) {
        this.f50758a = context;
    }

    @JavascriptInterface
    public String getAccountId() {
        return g.h();
    }

    @JavascriptInterface
    public String getAppIds() {
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = b.a().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            return jSONArray.toString();
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    @JavascriptInterface
    public String getGAID() {
        return j0.c();
    }

    @JavascriptInterface
    public long getRealTime() {
        try {
            return u0.b(this.f50758a).a(System.currentTimeMillis(), SystemClock.elapsedRealtime());
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
            return System.currentTimeMillis();
        }
    }

    @JavascriptInterface
    public String getVAID() {
        try {
            return i0.a();
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
            return "";
        }
    }

    @JavascriptInterface
    public void track(int i11, String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("track appid = ");
        sb2.append(i11);
        sb2.append(", eventName = ");
        sb2.append(str);
        try {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject(str2);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                bundle.putString(next, jSONObject.get(next).toString());
            }
            new a(str, i11).c(bundle, null).b();
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
        }
    }
}
