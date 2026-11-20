package com.mbridge.msdk.videocommon;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0532a> f48431a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0532a> f48432b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0532a> f48433c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0532a> f48434d = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0532a> f48435e = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0532a> f48436f = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0532a> f48437g = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0532a> f48438h = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0532a> f48439i = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0532a> f48440j = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: com.mbridge.msdk.videocommon.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0532a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WindVaneWebView f48441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f48442b;

        public final WindVaneWebView a() {
            return this.f48441a;
        }

        public final void a(WindVaneWebView windVaneWebView) {
            this.f48441a = windVaneWebView;
        }

        public final void a(String str) {
            WindVaneWebView windVaneWebView = this.f48441a;
            if (windVaneWebView != null) {
                windVaneWebView.setTag(str);
            }
        }

        public final void a(boolean z11) {
            this.f48442b = z11;
        }

        public final String b() {
            WindVaneWebView windVaneWebView = this.f48441a;
            return windVaneWebView != null ? (String) windVaneWebView.getTag() : "";
        }

        public final boolean c() {
            return this.f48442b;
        }
    }

    public static C0532a a(int i11, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        try {
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (i11 == 288) {
                requestIdNotice = campaignEx.getKeyIaUrl();
            }
            if (i11 != 94) {
                if (i11 != 287) {
                    if (i11 != 288) {
                        ConcurrentHashMap<String, C0532a> concurrentHashMap = f48431a;
                        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                            return f48431a.get(requestIdNotice);
                        }
                    } else {
                        ConcurrentHashMap<String, C0532a> concurrentHashMap2 = f48434d;
                        if (concurrentHashMap2 != null && concurrentHashMap2.size() > 0) {
                            return f48434d.get(requestIdNotice);
                        }
                    }
                } else if (campaignEx.isBidCampaign()) {
                    ConcurrentHashMap<String, C0532a> concurrentHashMap3 = f48433c;
                    if (concurrentHashMap3 != null && concurrentHashMap3.size() > 0) {
                        return f48433c.get(requestIdNotice);
                    }
                } else {
                    ConcurrentHashMap<String, C0532a> concurrentHashMap4 = f48436f;
                    if (concurrentHashMap4 != null && concurrentHashMap4.size() > 0) {
                        return f48436f.get(requestIdNotice);
                    }
                }
            } else if (campaignEx.isBidCampaign()) {
                ConcurrentHashMap<String, C0532a> concurrentHashMap5 = f48432b;
                if (concurrentHashMap5 != null && concurrentHashMap5.size() > 0) {
                    return f48432b.get(requestIdNotice);
                }
            } else {
                ConcurrentHashMap<String, C0532a> concurrentHashMap6 = f48435e;
                if (concurrentHashMap6 != null && concurrentHashMap6.size() > 0) {
                    return f48435e.get(requestIdNotice);
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    public static C0532a a(String str) {
        if (f48437g.containsKey(str)) {
            return f48437g.get(str);
        }
        if (f48438h.containsKey(str)) {
            return f48438h.get(str);
        }
        if (f48439i.containsKey(str)) {
            return f48439i.get(str);
        }
        if (f48440j.containsKey(str)) {
            return f48440j.get(str);
        }
        return null;
    }

    public static void a() {
        f48439i.clear();
        f48440j.clear();
    }

    public static void a(int i11, String str, C0532a c0532a) {
        try {
            if (i11 == 94) {
                if (f48432b == null) {
                    f48432b = new ConcurrentHashMap<>();
                }
                f48432b.put(str, c0532a);
            } else {
                if (i11 != 287) {
                    return;
                }
                if (f48433c == null) {
                    f48433c = new ConcurrentHashMap<>();
                }
                f48433c.put(str, c0532a);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public static void a(String str, C0532a c0532a, boolean z11, boolean z12) {
        if (z11) {
            if (z12) {
                f48438h.put(str, c0532a);
                return;
            } else {
                f48437g.put(str, c0532a);
                return;
            }
        }
        if (z12) {
            f48440j.put(str, c0532a);
        } else {
            f48439i.put(str, c0532a);
        }
    }

    public static void b(int i11, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return;
        }
        try {
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (i11 == 288) {
                requestIdNotice = campaignEx.getKeyIaUrl();
            }
            if (i11 == 94) {
                if (campaignEx.isBidCampaign()) {
                    ConcurrentHashMap<String, C0532a> concurrentHashMap = f48432b;
                    if (concurrentHashMap != null) {
                        concurrentHashMap.remove(requestIdNotice);
                        return;
                    }
                    return;
                }
                ConcurrentHashMap<String, C0532a> concurrentHashMap2 = f48435e;
                if (concurrentHashMap2 != null) {
                    concurrentHashMap2.remove(requestIdNotice);
                    return;
                }
                return;
            }
            if (i11 != 287) {
                if (i11 != 288) {
                    ConcurrentHashMap<String, C0532a> concurrentHashMap3 = f48431a;
                    if (concurrentHashMap3 != null) {
                        concurrentHashMap3.remove(requestIdNotice);
                        return;
                    }
                    return;
                }
                ConcurrentHashMap<String, C0532a> concurrentHashMap4 = f48434d;
                if (concurrentHashMap4 != null) {
                    concurrentHashMap4.remove(requestIdNotice);
                    return;
                }
                return;
            }
            if (campaignEx.isBidCampaign()) {
                ConcurrentHashMap<String, C0532a> concurrentHashMap5 = f48433c;
                if (concurrentHashMap5 != null) {
                    concurrentHashMap5.remove(requestIdNotice);
                    return;
                }
                return;
            }
            ConcurrentHashMap<String, C0532a> concurrentHashMap6 = f48436f;
            if (concurrentHashMap6 != null) {
                concurrentHashMap6.remove(requestIdNotice);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public static void b(int i11, String str, C0532a c0532a) {
        try {
            if (i11 == 94) {
                if (f48435e == null) {
                    f48435e = new ConcurrentHashMap<>();
                }
                f48435e.put(str, c0532a);
            } else if (i11 == 287) {
                if (f48436f == null) {
                    f48436f = new ConcurrentHashMap<>();
                }
                f48436f.put(str, c0532a);
            } else if (i11 != 288) {
                if (f48431a == null) {
                    f48431a = new ConcurrentHashMap<>();
                }
                f48431a.put(str, c0532a);
            } else {
                if (f48434d == null) {
                    f48434d = new ConcurrentHashMap<>();
                }
                f48434d.put(str, c0532a);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public static void b(String str) {
        if (f48437g.containsKey(str)) {
            f48437g.remove(str);
        }
        if (f48439i.containsKey(str)) {
            f48439i.remove(str);
        }
        if (f48438h.containsKey(str)) {
            f48438h.remove(str);
        }
        if (f48440j.containsKey(str)) {
            f48440j.remove(str);
        }
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            f48437g.clear();
        } else {
            for (String str2 : f48437g.keySet()) {
                if (!TextUtils.isEmpty(str2) && str2.startsWith(str)) {
                    f48437g.remove(str2);
                }
            }
        }
        f48438h.clear();
    }

    public static void d(String str) {
        for (Map.Entry<String, C0532a> entry : f48437g.entrySet()) {
            if (entry.getKey().contains(str)) {
                f48437g.remove(entry.getKey());
            }
        }
    }

    public static void e(String str) {
        for (Map.Entry<String, C0532a> entry : f48438h.entrySet()) {
            if (entry.getKey().contains(str)) {
                f48438h.remove(entry.getKey());
            }
        }
    }
}
