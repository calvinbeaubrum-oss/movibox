package com.mbridge.msdk.video.signal.a;

import android.app.Activity;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f48093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MBridgeBTContainer f48094b;

    public j(Activity activity, MBridgeBTContainer mBridgeBTContainer) {
        this.f48093a = activity;
        this.f48094b = mBridgeBTContainer;
    }

    @Override // com.mbridge.msdk.video.signal.a.c, com.mbridge.msdk.video.signal.e
    public final void click(int i11, String str) {
        super.click(i11, str);
        MBridgeBTContainer mBridgeBTContainer = this.f48094b;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.click(i11, str);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.c, com.mbridge.msdk.video.signal.e
    public final void handlerH5Exception(int i11, String str) {
        super.handlerH5Exception(i11, str);
        MBridgeBTContainer mBridgeBTContainer = this.f48094b;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.handlerH5Exception(i11, str);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.c, com.mbridge.msdk.video.signal.c
    public final void reactDeveloper(Object obj, String str) {
        super.reactDeveloper(obj, str);
        MBridgeBTContainer mBridgeBTContainer = this.f48094b;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.reactDeveloper(obj, str);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.c, com.mbridge.msdk.video.signal.c
    public final void reportUrls(Object obj, String str) {
        super.reportUrls(obj, str);
        MBridgeBTContainer mBridgeBTContainer = this.f48094b;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.reportUrls(obj, str);
        } else {
            com.mbridge.msdk.video.bt.a.d.c().b(obj, str);
        }
    }
}
