package com.bytedance.sdk.openadsdk.Dl;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN implements We {
    private We pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    Handler f27065sc = null;

    public ExN(We we2) {
        this.pFF = we2;
    }

    private Context Qj() {
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, new Object[0]);
            return (Application) objInvoke.getClass().getMethod("getApplication", new Class[0]).invoke(objInvoke, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.Dl.We
    public String ExN() {
        We we2 = this.pFF;
        if (we2 != null) {
            return we2.ExN();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.Dl.We
    public JSONObject TRI() {
        We we2 = this.pFF;
        if (we2 != null) {
            return we2.TRI();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.Dl.We
    public Handler We() {
        We we2 = this.pFF;
        if (we2 != null && we2.qr() != null) {
            return this.pFF.We();
        }
        HandlerThread handlerThread = new HandlerThread("pag_strategy", -1);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.f27065sc = handler;
        return handler;
    }

    @Override // com.bytedance.sdk.openadsdk.Dl.We
    public Context pFF() {
        We we2 = this.pFF;
        return (we2 == null || we2.pFF() == null) ? Qj() : this.pFF.pFF();
    }

    @Override // com.bytedance.sdk.openadsdk.Dl.We
    public Map<String, String> qr() {
        We we2 = this.pFF;
        return (we2 == null || we2.qr() == null) ? new HashMap() : this.pFF.qr();
    }

    @Override // com.bytedance.sdk.openadsdk.Dl.We
    public ExecutorService sc() {
        We we2 = this.pFF;
        return (we2 == null || we2.sc() == null) ? Executors.newCachedThreadPool() : this.pFF.sc();
    }

    @Override // com.bytedance.sdk.openadsdk.Dl.We
    public JSONObject sc(JSONObject jSONObject) {
        We we2 = this.pFF;
        return we2 != null ? we2.sc(jSONObject) : jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.Dl.We
    public String zY() {
        We we2 = this.pFF;
        return (we2 == null || TextUtils.isEmpty(we2.zY())) ? "null" : this.pFF.zY();
    }
}
