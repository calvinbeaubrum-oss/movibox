package com.mbridge.msdk.out;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.splash.d.c;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBSplashHandler implements BaseExtraInterfaceForHandler {
    private static final String TAG = "MBSplashHandler";
    private static boolean canSkip = true;
    private static int defCountDownS = 5;
    private static int logoSizeH = 0;
    private static int logoSizeW = 0;
    private static int orientation = 1;
    private c splashProvider;
    private String unitId;

    public MBSplashHandler(Activity activity, String str, String str2) {
        this(activity, str, str2, canSkip, defCountDownS);
    }

    public MBSplashHandler(Activity activity, String str, String str2, boolean z11, int i11) {
        this(activity, str, str2, z11, i11, orientation, logoSizeH, logoSizeW);
    }

    public MBSplashHandler(Activity activity, String str, String str2, boolean z11, int i11, int i12, int i13, int i14) {
        String strE = ai.e(str2);
        if (!TextUtils.isEmpty(strE)) {
            ai.b(str2, strE);
        }
        c cVar = new c(activity, str, str2);
        this.splashProvider = cVar;
        cVar.b(z11);
        this.splashProvider.b(i11);
        this.splashProvider.a(i12);
        this.splashProvider.a(i13, i14);
    }

    public MBSplashHandler(String str, String str2) {
        this(str, str2, canSkip, defCountDownS);
    }

    public MBSplashHandler(String str, String str2, boolean z11, int i11) {
        this(str, str2, z11, i11, orientation, logoSizeH, logoSizeW);
    }

    public MBSplashHandler(String str, String str2, boolean z11, int i11, int i12, int i13, int i14) {
        String strE = ai.e(str2);
        if (!TextUtils.isEmpty(strE)) {
            ai.b(str2, strE);
        }
        this.unitId = str2;
        c cVar = new c(null, str, str2);
        this.splashProvider = cVar;
        cVar.b(z11);
        this.splashProvider.b(i11);
        this.splashProvider.a(i12);
        this.splashProvider.a(i13, i14);
    }

    public void allowClickSplash(boolean z11) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.d(z11);
        }
    }

    public ViewGroup createZoomOutByType(ZoomOutTypeEnum zoomOutTypeEnum) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            return cVar.a(zoomOutTypeEnum);
        }
        return null;
    }

    public String getCreativeIdWithUnitId() {
        c cVar = this.splashProvider;
        return cVar != null ? cVar.f() : "";
    }

    public String getRequestId() {
        c cVar = this.splashProvider;
        return cVar != null ? cVar.e() : "";
    }

    public boolean isReady() {
        return isReady("");
    }

    public boolean isReady(String str) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            return cVar.c(str);
        }
        return false;
    }

    public void loadAndShow(Activity activity) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.b("", activity);
        }
    }

    public void loadAndShow(ViewGroup viewGroup) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.b("", viewGroup);
        }
    }

    public void loadAndShowByToken(String str, Activity activity) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(str, activity);
        }
    }

    public void loadAndShowByToken(String str, ViewGroup viewGroup) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(str, viewGroup);
        }
    }

    public void onDestroy() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.k();
        }
    }

    public void onPause() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.j();
        }
    }

    public void onResume() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.i();
        }
    }

    public void preLoad() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.b("");
        }
    }

    public void preLoadByToken(String str) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void setDevCloseView(ViewGroup viewGroup) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(viewGroup);
        }
    }

    @Override // com.mbridge.msdk.out.BaseExtraInterfaceForHandler
    public void setExtraInfo(JSONObject jSONObject) {
        com.mbridge.msdk.foundation.controller.c.m().a(this.unitId, jSONObject);
    }

    public void setLoadTimeOut(long j11) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(j11);
        }
    }

    public void setLogoView(View view, int i11, int i12) {
        if (this.splashProvider != null) {
            this.splashProvider.a(view, new RelativeLayout.LayoutParams(i11, i12));
        }
    }

    public void setNotchScreenParameter(int i11, int i12, int i13, int i14) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(i11, i13, i12, i14);
        }
    }

    public void setOrientation(int i11) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(i11);
        }
    }

    public void setSplashLoadListener(MBSplashLoadListener mBSplashLoadListener) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(mBSplashLoadListener);
        }
    }

    public void setSplashShowListener(MBSplashShowListener mBSplashShowListener) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(mBSplashShowListener);
        }
    }

    public void setSupportZoomOut(boolean z11) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.c(z11);
        }
    }

    public void show(Activity activity) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.d("", activity);
        }
    }

    public void show(Activity activity, String str) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.c(str, activity);
        }
    }

    public void show(ViewGroup viewGroup) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.d("", viewGroup);
        }
    }

    public void show(ViewGroup viewGroup, String str) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.c(str, viewGroup);
        }
    }

    public void zoomOutAttacked() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.g();
        }
    }

    public void zoomOutPlayFinish() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.h();
        }
    }
}
