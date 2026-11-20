package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.an;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f48560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> f48561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f48562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f48563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.c f48564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f48565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CopyOnWriteArrayList<CampaignEx> f48566g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ConcurrentHashMap<String, com.mbridge.msdk.videocommon.download.a> f48567h;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements com.mbridge.msdk.videocommon.listener.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f48568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> f48569b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.mbridge.msdk.videocommon.listener.a f48570c;

        public a(String str, ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap, com.mbridge.msdk.videocommon.listener.a aVar) {
            this.f48568a = str;
            this.f48569b = concurrentHashMap;
            this.f48570c = aVar;
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public final void a(String str) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.f48570c;
            if (aVar != null) {
                try {
                    aVar.a(str);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("RewardVideoRefactorManager", this.f48568a + " videoDownloadListener onDownLoadDone error: " + e11.getMessage());
                    }
                }
            }
            ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap = this.f48569b;
            if (concurrentHashMap != null) {
                Iterator<com.mbridge.msdk.videocommon.listener.a> it = concurrentHashMap.values().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().a(str);
                    } catch (Exception e12) {
                        if (MBridgeConstans.DEBUG) {
                            ad.b("RewardVideoRefactorManager", this.f48568a + " videoDownloadListener onDownLoadDone error: " + e12.getMessage());
                        }
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public final void a(String str, String str2) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.f48570c;
            if (aVar != null) {
                try {
                    aVar.a(str, str2);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("RewardVideoRefactorManager", this.f48568a + " videoDownloadListener onDownLoadFailed error: " + e11.getMessage());
                    }
                }
            }
            ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap = this.f48569b;
            if (concurrentHashMap != null) {
                Iterator<com.mbridge.msdk.videocommon.listener.a> it = concurrentHashMap.values().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().a(str, str2);
                    } catch (Exception e12) {
                        if (MBridgeConstans.DEBUG) {
                            ad.b("RewardVideoRefactorManager", this.f48568a + " videoDownloadListener onDownLoadFailed error: " + e12.getMessage());
                        }
                    }
                }
            }
        }
    }

    public i(CampaignEx campaignEx, String str, int i11) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.f48566g = copyOnWriteArrayList;
        this.f48567h = new ConcurrentHashMap<>();
        this.f48562c = com.mbridge.msdk.foundation.controller.c.m().c();
        this.f48563d = str;
        this.f48565f = i11;
        if (campaignEx != null) {
            copyOnWriteArrayList.add(campaignEx);
        }
    }

    public i(List<CampaignEx> list, String str, int i11) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.f48566g = copyOnWriteArrayList;
        this.f48567h = new ConcurrentHashMap<>();
        this.f48562c = com.mbridge.msdk.foundation.controller.c.m().c();
        this.f48563d = str;
        this.f48565f = i11;
        if (list != null) {
            copyOnWriteArrayList.addAll(list);
        }
    }

    private com.mbridge.msdk.videocommon.download.a a(CampaignEx campaignEx, String str, com.mbridge.msdk.videocommon.download.a aVar) {
        if (aVar != null) {
            return aVar;
        }
        com.mbridge.msdk.videocommon.download.a aVarC = c(campaignEx);
        aVarC.n();
        this.f48567h.put(str, aVarC);
        return aVarC;
    }

    private boolean a(String str, CampaignEx campaignEx, com.mbridge.msdk.videocommon.download.a aVar) {
        if (campaignEx != null && aVar != null) {
            try {
                if (aVar.b()) {
                    ad.a("RewardVideoRefactorManager", this.f48563d + " checkEndCardZipOrSourceDownLoad endCard download success");
                    return true;
                }
                if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                    return true;
                }
                if ((campaignEx.isDynamicView() && !ai.l(str)) || an.a(str) || campaignEx.isMraid() || TextUtils.isEmpty(str) || ((campaignEx.getLoadTimeoutState() == 1 && !e(campaignEx)) || ((campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) || an.b(f.a(str)) || an.b(f.b(str))))) {
                    return true;
                }
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("RewardVideoRefactorManager", this.f48563d + " checkEndCardDownload error " + th2.getMessage());
                }
            }
        }
        return false;
    }

    private String b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return "";
        }
        try {
            CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
            if (rewardTemplateMode != null) {
                return rewardTemplateMode.e();
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a("RewardVideoRefactorManager", this.f48563d + " getVideoTemplateUrl error", e11);
            }
        }
        return "";
    }

    private com.mbridge.msdk.videocommon.d.c c(String str) {
        try {
            if (this.f48564e == null) {
                this.f48564e = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), str, this.f48565f == 287);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a("RewardVideoRefactorManager", this.f48563d + " getRewardUnitSetting error " + e11.getMessage());
            }
        }
        return this.f48564e;
    }

    private com.mbridge.msdk.videocommon.download.a c(CampaignEx campaignEx) {
        com.mbridge.msdk.videocommon.download.a aVar = null;
        try {
            com.mbridge.msdk.videocommon.download.a aVar2 = new com.mbridge.msdk.videocommon.download.a(this.f48562c, campaignEx, this.f48563d, f());
            try {
                aVar2.a(campaignEx);
                aVar2.d(this.f48565f);
                aVar2.c(f(campaignEx));
                aVar2.b(e());
                aVar2.e(d(campaignEx));
                aVar2.a((c) null);
                aVar2.a(new a(this.f48563d, this.f48561b, this.f48560a));
                return aVar2;
            } catch (Exception e11) {
                e = e11;
                aVar = aVar2;
                if (MBridgeConstans.DEBUG) {
                    ad.a("RewardVideoRefactorManager", this.f48563d + " createAndStartCampaignDownloadTask error " + e.getMessage());
                }
                return aVar;
            }
        } catch (Exception e12) {
            e = e12;
        }
    }

    private int d(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 1;
        }
        try {
            return campaignEx.getVideoCtnType();
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return 1;
            }
            ad.a("RewardVideoRefactorManager", this.f48563d + " getVideoCtnType error " + e11.getMessage());
            return 1;
        }
    }

    private int e() {
        com.mbridge.msdk.videocommon.d.c cVarC = c(this.f48563d);
        if (cVarC == null) {
            return 0;
        }
        try {
            return cVarC.s();
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return 0;
            }
            ad.a("RewardVideoRefactorManager", this.f48563d + " getCDRate error " + e11.getMessage());
            return 0;
        }
    }

    private boolean e(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            return campaignEx.getPlayable_ads_without_video() == 2;
        } catch (Throwable th2) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            ad.a("RewardVideoRefactorManager", this.f48563d + " isPlayerAbleAds error:" + th2.getMessage());
            return false;
        }
    }

    private int f() {
        if (TextUtils.isEmpty(this.f48563d)) {
            return 1;
        }
        try {
            com.mbridge.msdk.videocommon.d.c cVarC = c(this.f48563d);
            if (cVarC != null) {
                return cVarC.w();
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a("RewardVideoRefactorManager", this.f48563d + " getDlnet error " + e11.getMessage());
            }
        }
        return 1;
    }

    private int f(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return -1;
        }
        return campaignEx.getReady_rate() != -1 ? campaignEx.getReady_rate() : g();
    }

    private int g() {
        try {
            return c(this.f48563d).r();
        } catch (Throwable th2) {
            if (!MBridgeConstans.DEBUG) {
                return 100;
            }
            ad.a("RewardVideoRefactorManager", this.f48563d + " getRewardReadyRate error:" + th2.getMessage());
            return 100;
        }
    }

    public final com.mbridge.msdk.videocommon.download.a a(String str) {
        if (!TextUtils.isEmpty(str) && this.f48567h.containsKey(str)) {
            return this.f48567h.get(str);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:115:0x019d  */
    /* JADX WARN: Code duplicated, block: B:124:0x01ac A[Catch: Exception -> 0x01c3, TryCatch #4 {Exception -> 0x01c3, blocks: (B:13:0x002d, B:122:0x01a8, B:124:0x01ac, B:127:0x01c6, B:135:0x01d6, B:137:0x01db, B:138:0x01de, B:140:0x01e2, B:142:0x01e8, B:143:0x01ed, B:158:0x02fe), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:129:0x01cc A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:134:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:137:0x01db A[Catch: Exception -> 0x01c3, TryCatch #4 {Exception -> 0x01c3, blocks: (B:13:0x002d, B:122:0x01a8, B:124:0x01ac, B:127:0x01c6, B:135:0x01d6, B:137:0x01db, B:138:0x01de, B:140:0x01e2, B:142:0x01e8, B:143:0x01ed, B:158:0x02fe), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:142:0x01e8 A[Catch: Exception -> 0x01c3, TryCatch #4 {Exception -> 0x01c3, blocks: (B:13:0x002d, B:122:0x01a8, B:124:0x01ac, B:127:0x01c6, B:135:0x01d6, B:137:0x01db, B:138:0x01de, B:140:0x01e2, B:142:0x01e8, B:143:0x01ed, B:158:0x02fe), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:145:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:147:0x02e5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:148:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:150:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:152:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:153:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:154:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:155:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:156:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:157:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:178:0x01e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x001d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b4 A[Catch: Exception -> 0x00f3, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x00f3, blocks: (B:17:0x005c, B:19:0x0066, B:22:0x0076, B:25:0x007e, B:31:0x008f, B:41:0x00b4, B:46:0x00c2, B:48:0x00cc, B:58:0x00e3, B:60:0x00ee, B:63:0x00f6, B:67:0x0103, B:69:0x0109, B:72:0x0118), top: B:172:0x005c }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00c2 A[Catch: Exception -> 0x00f3, TRY_ENTER, TryCatch #3 {Exception -> 0x00f3, blocks: (B:17:0x005c, B:19:0x0066, B:22:0x0076, B:25:0x007e, B:31:0x008f, B:41:0x00b4, B:46:0x00c2, B:48:0x00cc, B:58:0x00e3, B:60:0x00ee, B:63:0x00f6, B:67:0x0103, B:69:0x0109, B:72:0x0118), top: B:172:0x005c }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00cc A[Catch: Exception -> 0x00f3, TryCatch #3 {Exception -> 0x00f3, blocks: (B:17:0x005c, B:19:0x0066, B:22:0x0076, B:25:0x007e, B:31:0x008f, B:41:0x00b4, B:46:0x00c2, B:48:0x00cc, B:58:0x00e3, B:60:0x00ee, B:63:0x00f6, B:67:0x0103, B:69:0x0109, B:72:0x0118), top: B:172:0x005c }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:65:0x0100  */
    /* JADX WARN: Code duplicated, block: B:66:0x0101 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x0103 A[Catch: Exception -> 0x00f3, TryCatch #3 {Exception -> 0x00f3, blocks: (B:17:0x005c, B:19:0x0066, B:22:0x0076, B:25:0x007e, B:31:0x008f, B:41:0x00b4, B:46:0x00c2, B:48:0x00cc, B:58:0x00e3, B:60:0x00ee, B:63:0x00f6, B:67:0x0103, B:69:0x0109, B:72:0x0118), top: B:172:0x005c }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0109 A[Catch: Exception -> 0x00f3, TryCatch #3 {Exception -> 0x00f3, blocks: (B:17:0x005c, B:19:0x0066, B:22:0x0076, B:25:0x007e, B:31:0x008f, B:41:0x00b4, B:46:0x00c2, B:48:0x00cc, B:58:0x00e3, B:60:0x00ee, B:63:0x00f6, B:67:0x0103, B:69:0x0109, B:72:0x0118), top: B:172:0x005c }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0118 A[Catch: Exception -> 0x00f3, TRY_LEAVE, TryCatch #3 {Exception -> 0x00f3, blocks: (B:17:0x005c, B:19:0x0066, B:22:0x0076, B:25:0x007e, B:31:0x008f, B:41:0x00b4, B:46:0x00c2, B:48:0x00cc, B:58:0x00e3, B:60:0x00ee, B:63:0x00f6, B:67:0x0103, B:69:0x0109, B:72:0x0118), top: B:172:0x005c }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0129  */
    /* JADX WARN: Instruction removed from duplicated block: B:124:0x01ac, please report this as an issue */
    public final List<com.mbridge.msdk.videocommon.download.a> a(List<CampaignEx> list, boolean z11) {
        boolean z12;
        boolean z13;
        boolean z14;
        ArrayList<Integer> rsIgnoreCheckRule;
        int iK;
        String str;
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            ad.a("RewardVideoRefactorManager", this.f48563d + " isReady campaignExes is null");
            return arrayList;
        }
        int size = list.size();
        for (CampaignEx campaignEx : list) {
            if (campaignEx != null) {
                try {
                    String str2 = campaignEx.getRequestId() + campaignEx.getId() + campaignEx.getVideoUrlEncode();
                    com.mbridge.msdk.videocommon.download.a aVarA = a(campaignEx, str2, this.f48567h.get(str2));
                    if (aVarA != null) {
                        boolean z15 = false;
                        try {
                            int loadTimeoutState = campaignEx.getLoadTimeoutState();
                            if (aVarA.d()) {
                                z15 = true;
                            } else {
                                int iF = f(campaignEx);
                                int iF2 = f();
                                if (!aVarA.d() && !e(campaignEx) && !TextUtils.isEmpty(aVarA.e()) && iF2 != 3) {
                                    if (campaignEx.getRsIgnoreCheckRule() != null) {
                                        try {
                                            if (campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                if (campaignEx.getIsTimeoutCheckVideoStatus() == 1 || campaignEx.getVideoCheckType() != 1) {
                                                    long jM = aVarA.m();
                                                    long j11 = aVarA.j();
                                                    if (z11 || campaignEx.getVideoCheckType() != 1) {
                                                        if (!TextUtils.isEmpty(aVarA.e())) {
                                                            if (iF == 0) {
                                                                if (aVarA.l() != null || TextUtils.isEmpty(aVarA.l().getVideoUrlEncode())) {
                                                                    z15 = false;
                                                                }
                                                            } else if (Utils.getDownloadRate(aVarA.j(), aVarA.m()) >= iF) {
                                                                z15 = false;
                                                            }
                                                        }
                                                    } else if (iF != 0) {
                                                        if (j11 != 0 || jM != 0) {
                                                            if (jM >= ((long) (iF / 100)) * j11) {
                                                                campaignEx.setIsTimeoutCheckVideoStatus(1);
                                                            }
                                                        }
                                                        if (!TextUtils.isEmpty(aVarA.e())) {
                                                            if (iF == 0) {
                                                                if (aVarA.l() != null) {
                                                                }
                                                                z15 = false;
                                                            } else if (Utils.getDownloadRate(aVarA.j(), aVarA.m()) >= iF) {
                                                                z15 = false;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } catch (Exception e11) {
                                            e = e11;
                                            z12 = false;
                                            z13 = false;
                                            if (MBridgeConstans.DEBUG) {
                                                ad.a("RewardVideoRefactorManager", this.f48563d + " checkResourceReadyState error", e);
                                            }
                                            if (aVarA.a()) {
                                                z14 = true;
                                            } else {
                                                z14 = true;
                                            }
                                            aVarA.a(z14);
                                            if (z14) {
                                                arrayList.add(aVarA);
                                            }
                                            if (MBridgeConstans.DEBUG) {
                                                rsIgnoreCheckRule = campaignEx.getRsIgnoreCheckRule();
                                                if (rsIgnoreCheckRule == null) {
                                                    rsIgnoreCheckRule = new ArrayList<>();
                                                }
                                                StringBuilder sb2 = new StringBuilder();
                                                sb2.append(this.f48563d);
                                                sb2.append("  campaign name = ");
                                                sb2.append(campaignEx.getAppName());
                                                sb2.append("\n\t\tcampaign id = ");
                                                sb2.append(campaignEx.getId());
                                                sb2.append("\n\t\trequest id = ");
                                                sb2.append(campaignEx.getRequestId());
                                                sb2.append("\n\t\tadType = ");
                                                sb2.append(this.f48565f);
                                                sb2.append("\n\t\tunitID = ");
                                                sb2.append(this.f48563d);
                                                sb2.append("\n\t\tisReady = ");
                                                sb2.append(z14);
                                                sb2.append("\n\t\tisDynamicView = ");
                                                sb2.append(campaignEx.isDynamicView());
                                                sb2.append("\n\t\tisTPL = ");
                                                sb2.append(!TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()));
                                                sb2.append("\n\t\tcurrentSuccessSize = ");
                                                sb2.append(arrayList.size());
                                                sb2.append("\n\t\tisReadyCheckSize = ");
                                                sb2.append(size);
                                                sb2.append("\n\t\ttotalCampaignSize = ");
                                                sb2.append(this.f48566g.size());
                                                sb2.append("\n\t\tlinkType = ");
                                                sb2.append(campaignEx.getLinkType());
                                                sb2.append("\n\t\tloadTimeoutState = ");
                                                sb2.append(campaignEx.getLoadTimeoutState());
                                                sb2.append("\n\t\tisVideoReady = ");
                                                sb2.append(z15);
                                                sb2.append("\n\t\t\tisIgnore = ");
                                                sb2.append(rsIgnoreCheckRule.contains(0));
                                                sb2.append("\n\t\t\treadyRate == ");
                                                sb2.append(f(campaignEx));
                                                sb2.append("\n\t\t\tCDRate = ");
                                                sb2.append(e());
                                                sb2.append("\n\t\t\tdlnet = ");
                                                sb2.append(f());
                                                sb2.append("\n\t\t\tctn = ");
                                                sb2.append(d(campaignEx));
                                                sb2.append("\n\t\t\tdownloadState = ");
                                                iK = aVarA.k();
                                                if (iK == 0) {
                                                    str = "DOWNLOAD_READY";
                                                } else if (iK == 1) {
                                                    str = "DOWNLOAD_RUN";
                                                } else if (iK == 2) {
                                                    str = "DOWNLOAD_PAUSE";
                                                } else if (iK == 4) {
                                                    str = "DOWNLOAD_STOP";
                                                } else if (iK != 5) {
                                                    str = "Unknown";
                                                } else {
                                                    str = "DOWNLOAD_DONE";
                                                }
                                                sb2.append(str);
                                                sb2.append("\n\t\tisTemplateReady = ");
                                                sb2.append(z13);
                                                sb2.append("\n\t\t\tisIgnore = ");
                                                sb2.append(rsIgnoreCheckRule.contains(1));
                                                sb2.append("\n\t\tisEndCardReady = ");
                                                sb2.append(z12);
                                                sb2.append("\n\t\t\tisIgnore = ");
                                                sb2.append(rsIgnoreCheckRule.contains(2));
                                                sb2.append("\n\t\t\tisOnlyPlayable = ");
                                                sb2.append(e(campaignEx));
                                                sb2.append("\n\t\t\tisPlayableEndCard(dynamicView) = ");
                                                sb2.append(ai.l(campaignEx.getendcard_url()));
                                                ad.b("RewardVideoRefactorManager", sb2.toString());
                                            }
                                        }
                                    } else if (campaignEx.getIsTimeoutCheckVideoStatus() == 1) {
                                        long jM2 = aVarA.m();
                                        long j12 = aVarA.j();
                                        if (z11) {
                                            if (!TextUtils.isEmpty(aVarA.e())) {
                                                if (iF == 0) {
                                                    if (aVarA.l() != null) {
                                                    }
                                                    z15 = false;
                                                } else if (Utils.getDownloadRate(aVarA.j(), aVarA.m()) >= iF) {
                                                    z15 = false;
                                                }
                                            }
                                        } else if (!TextUtils.isEmpty(aVarA.e())) {
                                            if (iF == 0) {
                                                if (aVarA.l() != null) {
                                                }
                                                z15 = false;
                                            } else if (Utils.getDownloadRate(aVarA.j(), aVarA.m()) >= iF) {
                                                z15 = false;
                                            }
                                        }
                                    } else {
                                        long jM3 = aVarA.m();
                                        long j13 = aVarA.j();
                                        if (z11) {
                                            if (!TextUtils.isEmpty(aVarA.e())) {
                                                if (iF == 0) {
                                                    if (aVarA.l() != null) {
                                                    }
                                                    z15 = false;
                                                } else if (Utils.getDownloadRate(aVarA.j(), aVarA.m()) >= iF) {
                                                    z15 = false;
                                                }
                                            }
                                        } else if (!TextUtils.isEmpty(aVarA.e())) {
                                            if (iF == 0) {
                                                if (aVarA.l() != null) {
                                                }
                                                z15 = false;
                                            } else if (Utils.getDownloadRate(aVarA.j(), aVarA.m()) >= iF) {
                                                z15 = false;
                                            }
                                        }
                                    }
                                }
                                z15 = true;
                            }
                            aVarA.d(z15);
                            z12 = aVarA.b() || a(campaignEx.getendcard_url(), campaignEx, aVarA);
                            if (loadTimeoutState == 0 && z12) {
                                try {
                                    aVarA.b(true);
                                } catch (Exception e12) {
                                    e = e12;
                                    z13 = false;
                                    if (MBridgeConstans.DEBUG) {
                                        ad.a("RewardVideoRefactorManager", this.f48563d + " checkResourceReadyState error", e);
                                    }
                                    if (aVarA.a()) {
                                        z14 = true;
                                    } else {
                                        z14 = true;
                                    }
                                    aVarA.a(z14);
                                    if (z14) {
                                        arrayList.add(aVarA);
                                    }
                                    if (MBridgeConstans.DEBUG) {
                                        rsIgnoreCheckRule = campaignEx.getRsIgnoreCheckRule();
                                        if (rsIgnoreCheckRule == null) {
                                            rsIgnoreCheckRule = new ArrayList<>();
                                        }
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append(this.f48563d);
                                        sb3.append("  campaign name = ");
                                        sb3.append(campaignEx.getAppName());
                                        sb3.append("\n\t\tcampaign id = ");
                                        sb3.append(campaignEx.getId());
                                        sb3.append("\n\t\trequest id = ");
                                        sb3.append(campaignEx.getRequestId());
                                        sb3.append("\n\t\tadType = ");
                                        sb3.append(this.f48565f);
                                        sb3.append("\n\t\tunitID = ");
                                        sb3.append(this.f48563d);
                                        sb3.append("\n\t\tisReady = ");
                                        sb3.append(z14);
                                        sb3.append("\n\t\tisDynamicView = ");
                                        sb3.append(campaignEx.isDynamicView());
                                        sb3.append("\n\t\tisTPL = ");
                                        sb3.append(!TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()));
                                        sb3.append("\n\t\tcurrentSuccessSize = ");
                                        sb3.append(arrayList.size());
                                        sb3.append("\n\t\tisReadyCheckSize = ");
                                        sb3.append(size);
                                        sb3.append("\n\t\ttotalCampaignSize = ");
                                        sb3.append(this.f48566g.size());
                                        sb3.append("\n\t\tlinkType = ");
                                        sb3.append(campaignEx.getLinkType());
                                        sb3.append("\n\t\tloadTimeoutState = ");
                                        sb3.append(campaignEx.getLoadTimeoutState());
                                        sb3.append("\n\t\tisVideoReady = ");
                                        sb3.append(z15);
                                        sb3.append("\n\t\t\tisIgnore = ");
                                        sb3.append(rsIgnoreCheckRule.contains(0));
                                        sb3.append("\n\t\t\treadyRate == ");
                                        sb3.append(f(campaignEx));
                                        sb3.append("\n\t\t\tCDRate = ");
                                        sb3.append(e());
                                        sb3.append("\n\t\t\tdlnet = ");
                                        sb3.append(f());
                                        sb3.append("\n\t\t\tctn = ");
                                        sb3.append(d(campaignEx));
                                        sb3.append("\n\t\t\tdownloadState = ");
                                        iK = aVarA.k();
                                        if (iK == 0) {
                                            str = "DOWNLOAD_READY";
                                        } else if (iK == 1) {
                                            str = "DOWNLOAD_RUN";
                                        } else if (iK == 2) {
                                            str = "DOWNLOAD_PAUSE";
                                        } else if (iK == 4) {
                                            str = "DOWNLOAD_STOP";
                                        } else if (iK != 5) {
                                            str = "Unknown";
                                        } else {
                                            str = "DOWNLOAD_DONE";
                                        }
                                        sb3.append(str);
                                        sb3.append("\n\t\tisTemplateReady = ");
                                        sb3.append(z13);
                                        sb3.append("\n\t\t\tisIgnore = ");
                                        sb3.append(rsIgnoreCheckRule.contains(1));
                                        sb3.append("\n\t\tisEndCardReady = ");
                                        sb3.append(z12);
                                        sb3.append("\n\t\t\tisIgnore = ");
                                        sb3.append(rsIgnoreCheckRule.contains(2));
                                        sb3.append("\n\t\t\tisOnlyPlayable = ");
                                        sb3.append(e(campaignEx));
                                        sb3.append("\n\t\t\tisPlayableEndCard(dynamicView) = ");
                                        sb3.append(ai.l(campaignEx.getendcard_url()));
                                        ad.b("RewardVideoRefactorManager", sb3.toString());
                                    }
                                }
                            }
                            if (aVarA.c()) {
                                z13 = true;
                            } else {
                                String strB = b(campaignEx);
                                if (TextUtils.isEmpty(strB) || aVarA.c() || campaignEx.isDynamicView() || !((campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(1)) && campaignEx.getLoadTimeoutState() == 0 && f.a(strB) == null)) {
                                    z13 = true;
                                } else {
                                    z13 = false;
                                }
                            }
                            if (loadTimeoutState == 0 && z13) {
                                try {
                                    aVarA.c(true);
                                } catch (Exception e13) {
                                    e = e13;
                                    if (MBridgeConstans.DEBUG) {
                                        ad.a("RewardVideoRefactorManager", this.f48563d + " checkResourceReadyState error", e);
                                    }
                                }
                            }
                        } catch (Exception e14) {
                            e = e14;
                            z15 = false;
                        }
                        if (aVarA.a() || (z15 && z12 && z13)) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        aVarA.a(z14);
                        if (z14) {
                            arrayList.add(aVarA);
                        }
                        if (MBridgeConstans.DEBUG) {
                            rsIgnoreCheckRule = campaignEx.getRsIgnoreCheckRule();
                            if (rsIgnoreCheckRule == null) {
                                rsIgnoreCheckRule = new ArrayList<>();
                            }
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(this.f48563d);
                            sb4.append("  campaign name = ");
                            sb4.append(campaignEx.getAppName());
                            sb4.append("\n\t\tcampaign id = ");
                            sb4.append(campaignEx.getId());
                            sb4.append("\n\t\trequest id = ");
                            sb4.append(campaignEx.getRequestId());
                            sb4.append("\n\t\tadType = ");
                            sb4.append(this.f48565f);
                            sb4.append("\n\t\tunitID = ");
                            sb4.append(this.f48563d);
                            sb4.append("\n\t\tisReady = ");
                            sb4.append(z14);
                            sb4.append("\n\t\tisDynamicView = ");
                            sb4.append(campaignEx.isDynamicView());
                            sb4.append("\n\t\tisTPL = ");
                            sb4.append(!TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()));
                            sb4.append("\n\t\tcurrentSuccessSize = ");
                            sb4.append(arrayList.size());
                            sb4.append("\n\t\tisReadyCheckSize = ");
                            sb4.append(size);
                            sb4.append("\n\t\ttotalCampaignSize = ");
                            sb4.append(this.f48566g.size());
                            sb4.append("\n\t\tlinkType = ");
                            sb4.append(campaignEx.getLinkType());
                            sb4.append("\n\t\tloadTimeoutState = ");
                            sb4.append(campaignEx.getLoadTimeoutState());
                            sb4.append("\n\t\tisVideoReady = ");
                            sb4.append(z15);
                            sb4.append("\n\t\t\tisIgnore = ");
                            sb4.append(rsIgnoreCheckRule.contains(0));
                            sb4.append("\n\t\t\treadyRate == ");
                            sb4.append(f(campaignEx));
                            sb4.append("\n\t\t\tCDRate = ");
                            sb4.append(e());
                            sb4.append("\n\t\t\tdlnet = ");
                            sb4.append(f());
                            sb4.append("\n\t\t\tctn = ");
                            sb4.append(d(campaignEx));
                            sb4.append("\n\t\t\tdownloadState = ");
                            iK = aVarA.k();
                            if (iK == 0) {
                                str = "DOWNLOAD_READY";
                            } else if (iK == 1) {
                                str = "DOWNLOAD_RUN";
                            } else if (iK == 2) {
                                str = "DOWNLOAD_PAUSE";
                            } else if (iK == 4) {
                                str = "DOWNLOAD_STOP";
                            } else if (iK != 5) {
                                str = "Unknown";
                            } else {
                                str = "DOWNLOAD_DONE";
                            }
                            sb4.append(str);
                            sb4.append("\n\t\tisTemplateReady = ");
                            sb4.append(z13);
                            sb4.append("\n\t\t\tisIgnore = ");
                            sb4.append(rsIgnoreCheckRule.contains(1));
                            sb4.append("\n\t\tisEndCardReady = ");
                            sb4.append(z12);
                            sb4.append("\n\t\t\tisIgnore = ");
                            sb4.append(rsIgnoreCheckRule.contains(2));
                            sb4.append("\n\t\t\tisOnlyPlayable = ");
                            sb4.append(e(campaignEx));
                            sb4.append("\n\t\t\tisPlayableEndCard(dynamicView) = ");
                            sb4.append(ai.l(campaignEx.getendcard_url()));
                            ad.b("RewardVideoRefactorManager", sb4.toString());
                        }
                    }
                } catch (Exception e15) {
                    if (MBridgeConstans.DEBUG) {
                        ad.a("RewardVideoRefactorManager", this.f48563d + " isReady error", e15);
                    }
                }
            }
        }
        return arrayList;
    }

    public final void a() {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f48566g;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            ad.a("RewardVideoRefactorManager", this.f48563d + " load campaignExes is null");
            return;
        }
        for (CampaignEx campaignEx : copyOnWriteArrayList) {
            if (campaignEx != null) {
                try {
                    String str = campaignEx.getRequestId() + campaignEx.getId() + campaignEx.getVideoUrlEncode();
                    if (!this.f48567h.containsKey(str)) {
                        a(campaignEx, str, (com.mbridge.msdk.videocommon.download.a) null);
                    }
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.a("RewardVideoRefactorManager", this.f48563d + " handlerCampaignLoadEvent error", e11);
                    }
                }
            }
        }
    }

    public final void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                this.f48566g.add(campaignEx);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("RewardVideoRefactorManager", this.f48563d + " update error", e11);
                }
            }
        }
    }

    public final void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.f48560a = aVar;
    }

    public final void a(String str, com.mbridge.msdk.videocommon.listener.a aVar) {
        if (this.f48561b == null) {
            this.f48561b = new ConcurrentHashMap<>();
        }
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f48561b.put(str, aVar);
    }

    public final void a(List<CampaignEx> list) {
        if (list != null) {
            try {
                this.f48566g.addAll(list);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("RewardVideoRefactorManager", this.f48563d + " update error", e11);
                }
            }
        }
    }

    public final com.mbridge.msdk.videocommon.download.a b() {
        List<com.mbridge.msdk.videocommon.download.a> listA;
        if (this.f48566g.size() == 0) {
            ad.a("RewardVideoRefactorManager", this.f48563d + " isReady campaignExes is null");
            return null;
        }
        try {
            listA = a((List<CampaignEx>) this.f48566g, false);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a("RewardVideoRefactorManager", this.f48563d + " isReady error", e11);
            }
            listA = null;
        }
        if (listA == null || listA.size() <= 0) {
            return null;
        }
        return listA.get(0);
    }

    public final void b(String str) {
        com.mbridge.msdk.videocommon.download.a aVarRemove;
        CampaignEx campaignExL;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (!this.f48567h.containsKey(str) || (aVarRemove = this.f48567h.remove(str)) == null || (campaignExL = aVarRemove.l()) == null) {
                return;
            }
            this.f48566g.remove(campaignExL);
            if (MBridgeConstans.DEBUG) {
                ad.a("RewardVideoRefactorManager", this.f48563d + " removeCampaignDownloadTask campaign name: " + campaignExL.getAppName());
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("RewardVideoRefactorManager", this.f48563d + " removeCampaignDownloadTask error:" + e11.getMessage());
            }
        }
    }

    public final com.mbridge.msdk.videocommon.download.a c() {
        try {
            return b();
        } catch (Throwable th2) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            ad.b("RewardVideoRefactorManager", this.f48563d + " getCampaignDownLoadTask error:" + th2.getMessage());
            return null;
        }
    }

    public final CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> d() {
        try {
            CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(this.f48567h);
            return copyOnWriteArrayList;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            ad.b("RewardVideoRefactorManager", this.f48563d + " getCampaignDownLoadTaskList error:" + e11.getMessage());
            return null;
        }
    }
}
