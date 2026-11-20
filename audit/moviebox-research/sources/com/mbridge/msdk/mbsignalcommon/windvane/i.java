package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class i implements Handler.Callback, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Pattern f45800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f45801b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Context f45803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected WindVaneWebView f45804e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f45802c = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Handler f45805f = new Handler(Looper.getMainLooper(), this);

    public i(Context context) {
        this.f45803d = context;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public final void a(WindVaneWebView windVaneWebView) {
        this.f45804e = windVaneWebView;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public final boolean a(String str) {
        if (!j.a(str)) {
            return false;
        }
        this.f45800a = j.b(str);
        this.f45801b = str;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0068  */
    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public final void b(String str) {
        a aVarA;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str != null) {
            aVarA = com.mbridge.msdk.mbsignalcommon.mraid.c.a(this.f45804e, str);
            if (aVarA != null) {
                aVarA.f45774b = this.f45804e;
            } else {
                Matcher matcher = this.f45800a.matcher(str);
                if (matcher.matches()) {
                    aVarA = new a();
                    int iGroupCount = matcher.groupCount();
                    if (iGroupCount >= 5) {
                        aVarA.f45778f = matcher.group(5);
                    }
                    if (iGroupCount >= 3) {
                        aVarA.f45776d = matcher.group(1);
                        aVarA.f45779g = matcher.group(2);
                        String strGroup = matcher.group(3);
                        aVarA.f45777e = strGroup;
                        HashMap<String, String> map = com.mbridge.msdk.mbsignalcommon.base.e.f45673k;
                        if (map != null && map.containsKey(strGroup)) {
                            aVarA.f45777e = com.mbridge.msdk.mbsignalcommon.base.e.f45673k.get(aVarA.f45777e);
                        }
                        aVarA.f45774b = this.f45804e;
                    } else {
                        aVarA = null;
                    }
                } else {
                    aVarA = null;
                }
            }
        } else {
            aVarA = null;
        }
        if (aVarA == null) {
            return;
        }
        WindVaneWebView windVaneWebView = aVarA.f45774b;
        Object jsObject = windVaneWebView != null ? windVaneWebView.getJsObject(aVarA.f45776d) : null;
        if (jsObject == null) {
            return;
        }
        try {
            com.mbridge.msdk.mbsignalcommon.c.a.d dVarA = com.mbridge.msdk.mbsignalcommon.c.a.a(this.f45803d.getClassLoader(), jsObject.getClass().getName()).a(aVarA.f45777e, Object.class, String.class);
            dVarA.a();
            if (jsObject instanceof h) {
                aVarA.f45773a = dVarA;
                aVarA.f45775c = jsObject;
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = aVarA;
                this.f45805f.sendMessage(messageObtain);
            }
        } catch (com.mbridge.msdk.mbsignalcommon.c.a.b.C0500a e11) {
            e11.printStackTrace();
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        a aVar = (a) message.obj;
        if (aVar == null) {
            return false;
        }
        try {
            if (message.what == 1) {
                Object obj = aVar.f45775c;
                com.mbridge.msdk.mbsignalcommon.c.a.d dVar = aVar.f45773a;
                if (dVar != null && obj != null) {
                    Object[] objArr = new Object[2];
                    objArr[0] = aVar;
                    objArr[1] = TextUtils.isEmpty(aVar.f45778f) ? "{}" : aVar.f45778f;
                    dVar.a(obj, objArr);
                }
                return true;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return false;
    }
}
