package com.mbridge.msdk.mbbanner.common.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.ao;
import com.mbridge.msdk.mbbanner.common.util.BannerUtils;
import com.mbridge.msdk.out.MBridgeIds;
import com.transsion.gslb.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f45293a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f45294b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.a.c f45296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.util.a f45297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.b.b f45298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.b.d f45299g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f45295c = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f45300h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Timer f45301i = new Timer();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile List<String> f45302j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f45303k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile boolean f45304l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile boolean f45305m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f45306n = "";

    /* JADX INFO: compiled from: source.java */
    public static class a implements com.mbridge.msdk.foundation.same.c.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b f45318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f45319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CampaignEx f45320c;

        public a(b bVar, String str, CampaignEx campaignEx) {
            this.f45318a = bVar;
            this.f45319b = str;
            this.f45320c = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onFailedLoad(String str, String str2) {
            if (MBridgeConstans.DEBUG) {
                ad.c(b.f45293a, "DownloadImageListener campaign image fail");
            }
            b bVar = this.f45318a;
            if (bVar != null) {
                bVar.a(this.f45319b, 1, str2, false, this.f45320c);
            }
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onSuccessLoad(Bitmap bitmap, String str) {
            if (MBridgeConstans.DEBUG) {
                ad.c(b.f45293a, "DownloadImageListener campaign image success");
            }
            b bVar = this.f45318a;
            if (bVar != null) {
                bVar.a(this.f45319b, 1, str, true, this.f45320c);
            }
        }
    }

    public b(Context context, com.mbridge.msdk.mbbanner.common.a.c cVar, com.mbridge.msdk.mbbanner.common.b.b bVar, com.mbridge.msdk.mbbanner.common.util.a aVar) {
        this.f45294b = context.getApplicationContext();
        this.f45296d = cVar;
        this.f45298f = bVar;
        this.f45297e = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x008c  */
    private String a(String str, String str2, CampaignEx campaignEx) throws Throwable {
        File file;
        Throwable th2;
        String absolutePath = "";
        if (!TextUtils.isEmpty(str2)) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        String strA = e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML);
                        String md5 = SameMD5.getMD5(ao.b(str2));
                        if (TextUtils.isEmpty(md5)) {
                            md5 = String.valueOf(System.currentTimeMillis());
                        }
                        File file2 = new File(strA, md5.concat(".html"));
                        Uri.parse(str2).getPath();
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                        try {
                            fileOutputStream2.write(str2.getBytes());
                            fileOutputStream2.flush();
                            absolutePath = file2.getAbsolutePath();
                            fileOutputStream2.close();
                        } catch (Exception e11) {
                            e = e11;
                            fileOutputStream = fileOutputStream2;
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            } else {
                                file = new File(absolutePath);
                                if (!file.exists()) {
                                    a(str, 2, str2, false, campaignEx);
                                } else {
                                    a(str, 2, str2, false, campaignEx);
                                }
                            }
                            return absolutePath;
                        } catch (Throwable th3) {
                            th2 = th3;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream == null) {
                                throw th2;
                            }
                            try {
                                fileOutputStream.close();
                                throw th2;
                            } catch (Exception e12) {
                                e12.printStackTrace();
                                throw th2;
                            }
                        }
                    } catch (Exception e13) {
                        e = e13;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                }
            } catch (Exception e14) {
                e14.printStackTrace();
            }
            file = new File(absolutePath);
            if (!file.exists() && file.isFile() && file.canRead()) {
                a(str, 2, str2, true, campaignEx);
            } else {
                a(str, 2, str2, false, campaignEx);
            }
        }
        return absolutePath;
    }

    private List<CampaignEx> a(final String str, CampaignUnit campaignUnit) {
        ArrayList arrayList = new ArrayList();
        if (campaignUnit != null) {
            try {
                if (campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0) {
                    ArrayList<CampaignEx> ads = campaignUnit.getAds();
                    ad.c(f45293a, "getNeedShowList 总共返回的campaign有：" + ads.size());
                    for (int i11 = 0; i11 < ads.size(); i11++) {
                        final CampaignEx campaignEx = ads.get(i11);
                        if (campaignEx != null && campaignEx.getOfferType() != 99 && (!TextUtils.isEmpty(campaignEx.getBannerUrl()) || !TextUtils.isEmpty(campaignEx.getBannerHtml()) || !TextUtils.isEmpty(campaignEx.getImageUrl()))) {
                            if (ai.c(campaignEx)) {
                                campaignEx.setRtinsType(ai.c(this.f45294b, campaignEx.getPackageName()) ? 1 : 2);
                            }
                            if (com.mbridge.msdk.foundation.same.b.a(this.f45294b, campaignEx)) {
                                arrayList.add(campaignEx);
                            } else {
                                ai.a(str, campaignEx, com.mbridge.msdk.foundation.same.a.f44388x);
                                this.f45306n = "APP ALREADY INSTALLED";
                            }
                            final Context context = this.f45294b;
                            final com.mbridge.msdk.foundation.same.report.d.a.a aVar = null;
                            try {
                                com.mbridge.msdk.foundation.same.b.a(campaignEx, context, null, new com.mbridge.msdk.foundation.same.b.a() { // from class: com.mbridge.msdk.mbbanner.common.c.b.3
                                    @Override // com.mbridge.msdk.foundation.same.b.a
                                    public final void a(String str2, com.mbridge.msdk.foundation.same.report.d.b bVar) {
                                        if (TextUtils.isEmpty(str2)) {
                                            return;
                                        }
                                        com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                                        dVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                                        bVar.a(str2, dVar);
                                        try {
                                            com.mbridge.msdk.foundation.same.report.d.c.a().a(str2, bVar, campaignEx, context, aVar);
                                        } catch (Exception e11) {
                                            if (MBridgeConstans.DEBUG) {
                                                e11.printStackTrace();
                                            }
                                        }
                                    }
                                });
                            } catch (Exception e11) {
                                if (MBridgeConstans.DEBUG) {
                                    e11.printStackTrace();
                                }
                            }
                        }
                    }
                    ad.c(f45293a, "getNeedShowList 返回有以下带有视频素材的campaign：" + arrayList.size());
                }
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void a(b bVar, final String str, final CampaignUnit campaignUnit) throws Throwable {
        CampaignEx campaignEx;
        if (campaignUnit == null) {
            com.mbridge.msdk.foundation.c.b bVar2 = new com.mbridge.msdk.foundation.c.b(880003);
            MBridgeIds mBridgeIds = new MBridgeIds();
            mBridgeIds.setUnitId(str);
            bVar2.a(mBridgeIds);
            bVar.f45297e.a(bVar.f45298f, bVar2);
            bVar.f45299g.a(str);
            return;
        }
        List<CampaignEx> listA = bVar.a(str, campaignUnit);
        new Thread(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.c.b.4
            @Override // java.lang.Runnable
            public final void run() {
                ad.c(b.f45293a, "在单独子线程保存数据库 开始");
                k.a(h.a(b.this.f45294b)).a();
                CampaignUnit campaignUnit2 = campaignUnit;
                if (campaignUnit2 != null && campaignUnit2.getAds() != null && campaignUnit.getAds().size() > 0) {
                    BannerUtils.uisList(b.this.f45294b, campaignUnit.getAds());
                }
                ad.c(b.f45293a, "在单独子线程保存数据库 完成");
            }
        }).start();
        int i11 = 0;
        if (listA == null || listA.size() == 0) {
            ad.c(f45293a, "tryDownloadOnLoadSuccess 返回的campaign 没有符合下载规则的");
            com.mbridge.msdk.foundation.c.b bVar3 = bVar.f45306n.contains("INSTALLED") ? new com.mbridge.msdk.foundation.c.b(880021, "APP ALREADY INSTALLED") : new com.mbridge.msdk.foundation.c.b(880003);
            MBridgeIds mBridgeIds2 = new MBridgeIds();
            mBridgeIds2.setUnitId(str);
            bVar3.a(mBridgeIds2);
            if (campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0 && (campaignEx = campaignUnit.getAds().get(0)) != null) {
                bVar3.a(campaignEx);
            }
            bVar.f45297e.a(bVar.f45298f, bVar3);
            bVar.f45299g.a(str);
            return;
        }
        String str2 = f45293a;
        ad.c(str2, "在子线程处理业务逻辑 开始");
        final CampaignEx campaignEx2 = listA.get(0);
        bVar.f45301i.schedule(new TimerTask() { // from class: com.mbridge.msdk.mbbanner.common.c.b.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                if (b.this.f45300h) {
                    return;
                }
                b.this.f45300h = true;
                b.this.a(str, -1, "", false, campaignEx2);
            }
        }, 60000);
        bVar.f45296d.a(campaignUnit.getSessionId());
        int size = bVar.f45295c;
        try {
            if (listA.size() > 0) {
                size += listA.size();
            }
            if (size > bVar.f45296d.c()) {
                ad.c(str2, "saveNextOffset 重置offset为0");
                size = 0;
            }
            ad.c(str2, "saveNextOffset 算出 下次的offset是:" + size);
            if (an.b(str)) {
                bVar.f45296d.a(size);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        String strTrim = campaignEx2.getBannerUrl().trim();
        if (TextUtils.isEmpty(strTrim)) {
            String strTrim2 = campaignEx2.getBannerHtml().trim();
            if (TextUtils.isEmpty(strTrim2)) {
                bVar.f45304l = true;
                bVar.f45303k = true;
            } else {
                String strA = bVar.a(str, strTrim2, campaignEx2);
                if (listA.size() > 0) {
                    while (i11 < listA.size()) {
                        listA.get(i11).setBannerHtml(strA);
                        listA.get(i11).setHasMBTplMark(strTrim2.contains("<MBTPLMARK>"));
                        i11++;
                    }
                }
            }
        } else {
            if (!TextUtils.isEmpty(strTrim)) {
                com.mbridge.msdk.mbbanner.common.b.e eVar = new com.mbridge.msdk.mbbanner.common.b.e(bVar, str, campaignEx2);
                com.mbridge.msdk.foundation.same.report.d.b bVar4 = new com.mbridge.msdk.foundation.same.report.d.b();
                bVar4.a(campaignEx2);
                H5DownLoadManager.getInstance().download(bVar4, strTrim, eVar);
            }
            if (listA.size() > 0) {
                while (i11 < listA.size()) {
                    listA.get(i11).setBannerUrl(campaignEx2.getBannerUrl());
                    listA.get(i11).setHasMBTplMark(true);
                    i11++;
                }
            }
        }
        bVar.a(str, listA);
    }

    private void a(String str) {
        if (this.f45305m) {
            return;
        }
        if ((this.f45303k || this.f45304l) && this.f45302j.size() == 0) {
            ad.c(f45293a, "在子线程处理业务逻辑 完成");
            this.f45300h = true;
            this.f45305m = true;
            this.f45301i.cancel();
            this.f45297e.a(this.f45298f, str);
            this.f45299g.a(str);
        }
    }

    private void a(String str, List<CampaignEx> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (CampaignEx campaignEx : list) {
            if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
                this.f45302j.add(campaignEx.getImageUrl());
                com.mbridge.msdk.foundation.same.c.b.a(this.f45294b).a(campaignEx.getImageUrl(), new a(this, str, campaignEx));
            }
        }
    }

    private int b(String str) {
        try {
            int iB = this.f45296d.b();
            if (iB > this.f45296d.c()) {
                return 0;
            }
            return iB;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public final void a(String str, int i11, String str2, boolean z11, CampaignEx campaignEx) {
        if (z11) {
            if (i11 == 1) {
                ad.c(f45293a, "downloadResource--> Success Image");
                synchronized (this) {
                    try {
                        this.f45302j.remove(str2);
                        if (this.f45302j.size() == 0) {
                            a(str);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return;
            }
            if (i11 == 2) {
                ad.c(f45293a, "downloadResource--> Success banner_html");
                this.f45304l = true;
                a(str);
                return;
            } else {
                if (i11 == 3) {
                    ad.c(f45293a, "downloadResource--> Success banner_url");
                    this.f45303k = true;
                    a(str);
                    return;
                }
                return;
            }
        }
        if (i11 == -1) {
            ad.b(f45293a, " unitId =" + str + " --> time out!");
        }
        this.f45301i.cancel();
        String str3 = f45293a;
        ad.c(str3, "在子线程处理业务逻辑 完成");
        ad.c(str3, "downloadResource--> Fail");
        this.f45300h = true;
        com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880027);
        MBridgeIds mBridgeIds = new MBridgeIds();
        mBridgeIds.setUnitId(str);
        bVar.a(mBridgeIds);
        bVar.a(campaignEx);
        this.f45297e.b(this.f45298f, bVar);
        this.f45299g.a(str);
    }

    public final void a(String str, String str2, com.mbridge.msdk.mbbanner.common.a.b bVar, com.mbridge.msdk.mbbanner.common.b.d dVar) {
        boolean z11;
        try {
            ad.c(f45293a, "requestCampaign--> started");
            this.f45299g = dVar;
            com.mbridge.msdk.mbbanner.common.f.a aVar = new com.mbridge.msdk.mbbanner.common.f.a() { // from class: com.mbridge.msdk.mbbanner.common.c.b.2
                @Override // com.mbridge.msdk.mbbanner.common.f.a
                public final void a(int i11, String str3) {
                    ad.c(b.f45293a, "requestCampaign--> Fail errorCode:" + i11 + " msg:" + str3);
                    com.mbridge.msdk.foundation.c.b bVar2 = new com.mbridge.msdk.foundation.c.b(880003);
                    bVar2.a(i11 + Utils.SEPARATOR + str3);
                    bVar2.a(new MBridgeIds(this.placementId, this.unitId));
                    b.this.f45297e.a(b.this.f45298f, bVar2);
                    b.this.f45299g.a(this.unitId);
                }

                @Override // com.mbridge.msdk.mbbanner.common.f.a
                public final void a(CampaignUnit campaignUnit) throws Throwable {
                    try {
                        ad.c(b.f45293a, "requestCampaign--> Succeed");
                        b.this.f45297e.a(b.this.f45298f, campaignUnit, this.unitId);
                        b.a(b.this, this.unitId, campaignUnit);
                    } catch (Exception e11) {
                        ad.c(b.f45293a, "requestCampaign--> Fail with exception = " + e11.getMessage());
                        com.mbridge.msdk.foundation.c.b bVar2 = new com.mbridge.msdk.foundation.c.b(880000);
                        bVar2.a(new MBridgeIds(this.placementId, this.unitId));
                        bVar2.a((campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().isEmpty()) ? null : campaignUnit.getAds().get(0));
                        bVar2.a((Throwable) e11);
                        b.this.f45297e.a(b.this.f45298f, bVar2);
                        b.this.f45299g.a(this.unitId);
                    }
                }
            };
            aVar.setUnitId(str2);
            aVar.setPlacementId(str);
            aVar.setAdType(296);
            com.mbridge.msdk.mbbanner.common.e.a aVar2 = new com.mbridge.msdk.mbbanner.common.e.a(this.f45294b);
            this.f45295c = b(str2);
            com.mbridge.msdk.foundation.same.net.h.e eVarA = com.mbridge.msdk.mbbanner.common.a.d.a(false, this.f45294b, str2, this.f45296d.a(), this.f45295c, bVar);
            String strD = ai.d(str2);
            if (!TextUtils.isEmpty(strD)) {
                eVarA.a("j", strD);
            }
            String strC = bVar.c();
            if (TextUtils.isEmpty(strC)) {
                z11 = false;
            } else {
                aVar.a(strC);
                z11 = true;
            }
            this.f45297e.a(z11);
            aVar2.choiceV3OrV5BySetting(1, eVarA, aVar, strC);
        } catch (Exception e11) {
            ad.b(f45293a, e11.getMessage());
            com.mbridge.msdk.foundation.c.b bVar2 = new com.mbridge.msdk.foundation.c.b(880002);
            bVar2.a(new MBridgeIds(str, str2));
            this.f45297e.a(this.f45298f, bVar2);
            this.f45299g.a(str2);
        }
    }
}
