package com.mbridge.msdk.splash.c;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.splash.view.MBSplashView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.mbridge.msdk.foundation.db.f f47040a = com.mbridge.msdk.foundation.db.f.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f47041b = "ResManager";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f47042c = 1;

    private static CampaignEx a(CampaignEx campaignEx) {
        if (!TextUtils.isEmpty(campaignEx.getAdZip()) || (!TextUtils.isEmpty(campaignEx.getAdHtml()) && campaignEx.getAdHtml().contains("<MBTPLMARK>"))) {
            campaignEx.setHasMBTplMark(true);
            campaignEx.setIsMraid(false);
        } else {
            campaignEx.setHasMBTplMark(false);
            campaignEx.setIsMraid(true);
        }
        return campaignEx;
    }

    public static CampaignEx a(MBSplashView mBSplashView, String str, String str2, String str3, boolean z11, int i11, boolean z12, boolean z13) {
        if (f47040a == null) {
            f47040a = com.mbridge.msdk.foundation.db.f.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        }
        com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        if (gVarB == null) {
            com.mbridge.msdk.c.h.a();
            gVarB = i.a();
        }
        long jAb = gVarB.ab() * 1000;
        long jAc = gVarB.ac() * 1000;
        if (f47040a == null) {
            f47040a = com.mbridge.msdk.foundation.db.f.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        }
        f47040a.b(jAc, str2);
        List<CampaignEx> listA = f47040a.a(str2, 0, 0, f47042c, !TextUtils.isEmpty(str3));
        if (listA == null || listA.size() <= 0) {
            return null;
        }
        CampaignEx campaignEx = listA.get(0);
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j11 = jCurrentTimeMillis - jAb;
        if (!z12) {
            if (((campaignEx.getPlct() <= 0 || (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() < jCurrentTimeMillis) && (campaignEx.getPlct() > 0 || campaignEx.getTimestamp() < j11)) || !a(mBSplashView, campaignEx, str, str2, z11, i11, z13)) {
                return null;
            }
            return a(campaignEx);
        }
        if ((campaignEx.getPlct() > 0 && (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() >= jCurrentTimeMillis) || (campaignEx.getPlct() <= 0 && campaignEx.getTimestamp() >= j11)) {
            if (a(mBSplashView, campaignEx, str, str2, z11, i11, z13)) {
                return a(campaignEx);
            }
            return null;
        }
        if (a(mBSplashView, campaignEx, str, str2, z11, i11, z13) && campaignEx.isSpareOffer(jAb, jAc)) {
            return a(campaignEx);
        }
        return null;
    }

    public static void a(CampaignEx campaignEx, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        if (f47040a == null) {
            f47040a = com.mbridge.msdk.foundation.db.f.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        }
        f47040a.b(arrayList, str);
    }

    public static void a(final MBSplashView mBSplashView, CampaignEx campaignEx, final com.mbridge.msdk.splash.view.nativeview.a aVar) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(campaignEx.getImageUrl(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.splash.c.d.2
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str, String str2) {
                com.mbridge.msdk.splash.view.nativeview.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b();
                }
                MBSplashView mBSplashView2 = mBSplashView;
                if (mBSplashView2 != null) {
                    mBSplashView2.setImageReady(false);
                }
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str) {
                com.mbridge.msdk.splash.view.nativeview.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
                MBSplashView mBSplashView2 = mBSplashView;
                if (mBSplashView2 != null) {
                    mBSplashView2.setImageReady(true);
                }
            }
        });
        if (TextUtils.isEmpty(campaignEx.getIconUrl())) {
            return;
        }
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(campaignEx.getIconUrl(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.splash.c.d.3
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str, String str2) {
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str) {
            }
        });
    }

    private static void a(final MBSplashView mBSplashView, CampaignEx campaignEx, String str) {
        com.mbridge.msdk.videocommon.listener.a aVar = new com.mbridge.msdk.videocommon.listener.a() { // from class: com.mbridge.msdk.splash.c.d.1
            @Override // com.mbridge.msdk.videocommon.listener.a
            public final void a(String str2) {
                mBSplashView.setVideoReady(true);
            }

            @Override // com.mbridge.msdk.videocommon.listener.a
            public final void a(String str2, String str3) {
                mBSplashView.setVideoReady(false);
            }
        };
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(campaignEx);
        com.mbridge.msdk.videocommon.download.b.getInstance().createUnitCache(com.mbridge.msdk.foundation.controller.c.m().c(), str, copyOnWriteArrayList, 297, aVar);
        if (com.mbridge.msdk.videocommon.download.b.getInstance().a(297, str, campaignEx.isBidCampaign())) {
            mBSplashView.setVideoReady(true);
        } else {
            com.mbridge.msdk.videocommon.download.b.getInstance().load(str);
        }
    }

    private static void a(MBSplashView mBSplashView, String str, CampaignEx campaignEx, String str2, String str3, boolean z11, int i11) {
        g.c cVar = new g.c();
        cVar.c(str3);
        cVar.b(str2);
        cVar.a(campaignEx);
        cVar.a(str);
        cVar.a(z11);
        cVar.a(i11);
        g.a.f47106a.a(mBSplashView, cVar, null);
    }

    public static void a(String str) {
        if (f47040a == null) {
            f47040a = com.mbridge.msdk.foundation.db.f.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        }
        f47040a.a(str, 0, f47042c);
    }

    public static boolean a(MBSplashView mBSplashView, CampaignEx campaignEx) {
        if (mBSplashView == null) {
            return false;
        }
        boolean zIsVideoReady = !TextUtils.isEmpty(campaignEx.getVideoUrlEncode()) ? mBSplashView.isVideoReady() : true;
        if (zIsVideoReady && !TextUtils.isEmpty(campaignEx.getAdZip())) {
            zIsVideoReady = mBSplashView.isH5Ready();
        }
        if (zIsVideoReady && TextUtils.isEmpty(campaignEx.getAdZip()) && !TextUtils.isEmpty(campaignEx.getAdHtml())) {
            zIsVideoReady = mBSplashView.isH5Ready();
        }
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            zIsVideoReady = false;
        }
        if (!campaignEx.isDynamicView()) {
            return zIsVideoReady;
        }
        if (TextUtils.isEmpty(campaignEx.getImageUrl())) {
            return false;
        }
        return mBSplashView.isImageReady();
    }

    private static boolean a(MBSplashView mBSplashView, CampaignEx campaignEx, String str, String str2, boolean z11, int i11, boolean z12) {
        boolean z13;
        if (campaignEx == null) {
            return false;
        }
        mBSplashView.clearResState();
        if (TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            z13 = true;
        } else {
            boolean z14 = mBSplashView.isVideoReady() || com.mbridge.msdk.videocommon.download.b.getInstance().a(297, str2, campaignEx.isBidCampaign());
            if (z14) {
                mBSplashView.setVideoReady(true);
            } else {
                a(mBSplashView, campaignEx, str2);
            }
            z13 = z14;
        }
        if (!TextUtils.isEmpty(campaignEx.getAdZip()) && !mBSplashView.isH5Ready()) {
            String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(campaignEx.getAdZip());
            if (TextUtils.isEmpty(h5ResAddress)) {
                z13 = false;
            } else if (!z12) {
                a(mBSplashView, h5ResAddress, campaignEx, str, str2, z11, i11);
            }
        }
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && !TextUtils.isEmpty(campaignEx.getAdHtml()) && !mBSplashView.isH5Ready()) {
            String strB = b(campaignEx.getAdHtml());
            if (TextUtils.isEmpty(strB)) {
                z13 = false;
            } else if (!z12) {
                a(mBSplashView, strB, campaignEx, str, str2, z11, i11);
            }
        }
        if (campaignEx.isDynamicView()) {
            if (TextUtils.isEmpty(campaignEx.getImageUrl()) || mBSplashView.isImageReady()) {
                return false;
            }
            if (com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).c(campaignEx.getImageUrl())) {
                mBSplashView.setImageReady(true);
                return true;
            }
            a(mBSplashView, campaignEx, (com.mbridge.msdk.splash.view.nativeview.a) null);
        }
        return z13;
    }

    private static String b(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return "";
            }
            return "file:///" + file.getAbsolutePath();
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Exception e11) {
                e11.getMessage();
                return "";
            }
        }
    }
}
