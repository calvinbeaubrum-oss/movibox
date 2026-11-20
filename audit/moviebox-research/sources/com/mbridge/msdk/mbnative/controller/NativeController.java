package com.mbridge.msdk.mbnative.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.c.j;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.nativex.view.MBMediaView;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class NativeController extends com.mbridge.msdk.mbnative.controller.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, Long> f45460b = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f45461f = "NativeController";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f45462g;
    private boolean A;
    private int B;
    private int C;
    private int D;
    private int E;
    private com.mbridge.msdk.foundation.same.e.b F;
    private List<com.mbridge.msdk.mbnative.controller.c> G;
    private List<com.mbridge.msdk.mbnative.controller.c.a> H;
    private CopyOnWriteArrayList<com.mbridge.msdk.foundation.same.e.a> I;
    private Hashtable<String, kn.b> J;
    private int K;
    private int L;
    private a M;
    private boolean N;
    private boolean O;
    private Timer P;
    private String Q;
    private String R;
    private ViewTreeObserver.OnGlobalLayoutListener S;
    private k T;
    private long U;
    private int V;
    private int W;
    private boolean X;
    private int Y;
    private int Z;

    /* JADX INFO: renamed from: aa, reason: collision with root package name */
    private boolean f45463aa;

    /* JADX INFO: renamed from: ab, reason: collision with root package name */
    private List<Campaign> f45464ab;

    /* JADX INFO: renamed from: ac, reason: collision with root package name */
    private String f45465ac;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected List<Integer> f45466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected List<Integer> f45467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Map<String, Object> f45468e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private j f45469h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.mbridge.msdk.mbnative.d.a f45470i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private NativeListener.NativeTrackingListener f45471j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Context f45472k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f45473l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f45474m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Queue<Integer> f45475n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Queue<Long> f45476o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f45477p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private o f45478q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f45479r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private com.mbridge.msdk.click.a f45480s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f45481t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f45482u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f45483v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f45484w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f45485x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f45486y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f45487z;

    /* JADX INFO: compiled from: source.java */
    public class a extends com.mbridge.msdk.mbnative.f.a.b implements com.mbridge.msdk.foundation.same.e.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Runnable f45527c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f45526b = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f45528d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private List<String> f45529e = null;

        public a() {
        }

        @Override // com.mbridge.msdk.mbnative.f.a.b
        public final void a(int i11, String str) {
            NativeController.this.X = true;
            if (this.f45526b) {
                if (NativeController.this.f45486y || !this.f45528d) {
                    return;
                }
                NativeController.this.a(str, b(), a(), (CampaignEx) null);
                return;
            }
            if (i11 == -1) {
                com.mbridge.msdk.mbnative.controller.d.b(NativeController.this.f45483v, this.unitId);
                NativeController.this.f45484w = 0;
            }
            Runnable runnable = this.f45527c;
            if (runnable != null) {
                NativeController.this.f45552a.removeCallbacks(runnable);
            }
            if (NativeController.this.f45486y) {
                return;
            }
            if (b() == 1 || this.f45528d) {
                NativeController.this.a(str, b(), a(), (CampaignEx) null);
            }
        }

        public final void a(Runnable runnable) {
            this.f45527c = runnable;
        }

        public final void a(List<String> list) {
            this.f45529e = list;
        }

        @Override // com.mbridge.msdk.mbnative.f.a.b
        public final void a(List<com.mbridge.msdk.foundation.same.net.d.b> list, CampaignUnit campaignUnit) {
            Integer num;
            int iIntValue = 1;
            NativeController.this.X = true;
            com.mbridge.msdk.foundation.db.k kVarA = com.mbridge.msdk.foundation.db.k.a(h.a(NativeController.this.f45472k));
            kVarA.a();
            Runnable runnable = this.f45527c;
            if (runnable != null) {
                NativeController.this.f45552a.removeCallbacks(runnable);
            }
            com.mbridge.msdk.f.b.a();
            if (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0) {
                this.unitId = "0_" + this.unitId;
                com.mbridge.msdk.mbnative.controller.d.b(NativeController.this.f45483v, this.unitId);
                NativeController.this.f45484w = 0;
                return;
            }
            NativeController.this.f45479r = campaignUnit.getSessionId();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (NativeController.this.V <= 0) {
                if (NativeController.this.V == -3) {
                    NativeController.this.V = campaignUnit.getAds().size();
                } else {
                    NativeController nativeController = NativeController.this;
                    nativeController.V = nativeController.f45482u;
                }
                if (NativeController.this.Y != 0 && campaignUnit.getTemplate() == 2) {
                    NativeController nativeController2 = NativeController.this;
                    nativeController2.V = nativeController2.Y;
                }
                if (NativeController.this.Z != 0 && campaignUnit.getTemplate() == 3) {
                    NativeController nativeController3 = NativeController.this;
                    nativeController3.V = nativeController3.Z;
                }
            }
            for (int i11 = 0; i11 < campaignUnit.getAds().size(); i11++) {
                final CampaignEx campaignEx = campaignUnit.getAds().get(i11);
                campaignEx.setCampaignUnitId(this.unitId);
                if (!TextUtils.isEmpty(NativeController.this.Q)) {
                    campaignEx.setBidToken(NativeController.this.Q);
                    campaignEx.setIsBidCampaign(true);
                }
                final com.mbridge.msdk.foundation.same.report.d.a.a aVar = null;
                if (NativeController.f45462g) {
                    campaignEx.loadIconUrlAsyncWithBlock(null);
                    campaignEx.loadImageUrlAsyncWithBlock(null);
                }
                boolean zC = ai.c(NativeController.this.f45472k, campaignEx.getPackageName());
                Context unused = NativeController.this.f45472k;
                if (i11 < NativeController.this.f45482u && campaignEx.getOfferType() != 99) {
                    if (ai.c(campaignEx)) {
                        campaignEx.setRtinsType(zC ? 1 : 2);
                    }
                    if (com.mbridge.msdk.foundation.same.b.a(NativeController.this.f45472k, campaignEx)) {
                        arrayList.add(campaignEx);
                        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                            arrayList3.add(campaignEx);
                        }
                    } else {
                        ai.a(this.unitId, campaignEx, com.mbridge.msdk.foundation.same.a.f44388x);
                        NativeController.this.f45465ac = "APP ALREADY INSTALLED";
                    }
                    try {
                        com.mbridge.msdk.foundation.same.b.a(campaignEx, NativeController.this.f45472k, null, new com.mbridge.msdk.foundation.same.b.a() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.a.1
                            @Override // com.mbridge.msdk.foundation.same.b.a
                            public final void a(String str, com.mbridge.msdk.foundation.same.report.d.b bVar) {
                                com.mbridge.msdk.mbnative.e.a.a(str, bVar, campaignEx, NativeController.this.f45472k, aVar);
                            }
                        });
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            e11.printStackTrace();
                        }
                    }
                }
                if (i11 < NativeController.this.V && campaignEx.getOfferType() != 99) {
                    if (ai.c(campaignEx)) {
                        campaignEx.setRtinsType(zC ? 1 : 2);
                    }
                    if (!zC || ai.c(campaignEx)) {
                        arrayList2.add(campaignEx);
                    }
                }
                if (!kVarA.b(campaignEx.getId())) {
                    com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                    gVar.a(campaignEx.getId());
                    gVar.b(campaignEx.getFca());
                    gVar.c(campaignEx.getFcb());
                    gVar.a(0);
                    gVar.d(0);
                    gVar.a(System.currentTimeMillis());
                    kVarA.a(gVar);
                }
                com.mbridge.msdk.click.c.a(NativeController.this.f45472k, campaignEx.getMaitve(), campaignEx.getMaitve_src());
            }
            NativeController.c(NativeController.this, arrayList3);
            int type = campaignUnit.getAds().get(0) != null ? campaignUnit.getAds().get(0).getType() : 1;
            com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA = com.mbridge.msdk.mbnative.a.c.a(type);
            if (bVarA != null) {
                bVarA.a(this.unitId, arrayList2, NativeController.this.Q);
            }
            if (arrayList.size() == 0) {
                if (NativeController.this.f45465ac.contains("INSTALLED")) {
                    NativeController.this.a("APP ALREADY INSTALLED", b(), a(), campaignUnit.getAds().get(0));
                    new com.mbridge.msdk.foundation.c.b(880021, "APP ALREADY INSTALLED");
                    return;
                } else {
                    NativeController.this.a("v3 response error", b(), a(), campaignUnit.getAds().get(0));
                    new com.mbridge.msdk.foundation.c.b(880003);
                    return;
                }
            }
            NativeController nativeController4 = NativeController.this;
            nativeController4.a((List<Campaign>) nativeController4.a(type, (List<Campaign>) nativeController4.d(arrayList)));
            if (com.mbridge.msdk.mbnative.controller.d.b().containsKey(this.unitId) && Boolean.TRUE.equals(com.mbridge.msdk.mbnative.controller.d.b().get(this.unitId))) {
                com.mbridge.msdk.mbnative.controller.d.a(NativeController.this.f45483v, this.unitId);
                return;
            }
            if (com.mbridge.msdk.mbnative.controller.d.e().containsKey(this.unitId) && (num = com.mbridge.msdk.mbnative.controller.d.e().get(this.unitId)) != null) {
                iIntValue = num.intValue();
            }
            int i12 = NativeController.this.f45482u + NativeController.this.f45484w;
            NativeController.this.f45484w = i12 <= iIntValue ? i12 : 0;
        }

        @Override // com.mbridge.msdk.foundation.same.e.d
        public final void a(boolean z11) {
            this.f45526b = z11;
        }

        @Override // com.mbridge.msdk.mbnative.f.a.b
        public final void b(List<Frame> list) {
            if (this.f45526b) {
                return;
            }
            Runnable runnable = this.f45527c;
            if (runnable != null) {
                NativeController.this.f45552a.removeCallbacks(runnable);
            }
            if (list == null || list.size() == 0) {
                if (NativeController.this.f45470i != null) {
                    NativeController.this.f45486y = true;
                    NativeController.this.f45470i.onAdLoadError("frame is empty");
                    return;
                }
                return;
            }
            Iterator<Frame> it = list.iterator();
            while (it.hasNext()) {
                List<CampaignEx> campaigns = it.next().getCampaigns();
                if (campaigns == null || campaigns.size() == 0) {
                    if (NativeController.this.f45470i != null) {
                        NativeController.this.f45486y = true;
                        NativeController.this.f45470i.onAdLoadError("ads in frame is empty");
                        return;
                    }
                    return;
                }
                for (CampaignEx campaignEx : campaigns) {
                    if (NativeController.f45462g) {
                        campaignEx.loadImageUrlAsyncWithBlock(null);
                        campaignEx.loadIconUrlAsyncWithBlock(null);
                    }
                }
            }
            if (NativeController.this.f45470i != null) {
                NativeController.this.f45470i.onAdFramesLoaded(list);
            }
        }

        public final void b(boolean z11) {
            this.f45528d = z11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a();
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f45534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.e.d f45535c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f45536d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f45537e;

        public c(int i11, com.mbridge.msdk.foundation.same.e.d dVar, int i12, String str) {
            this.f45534b = i11;
            this.f45535c = dVar;
            this.f45536d = i12;
            this.f45537e = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f45535c.a(true);
            int i11 = this.f45534b;
            if (i11 == 1) {
                NativeController.this.X = true;
                NativeController.this.a("REQUEST_TIMEOUT", this.f45536d, this.f45537e, (CampaignEx) null);
            } else {
                if (i11 != 2) {
                    return;
                }
                if (!NativeController.this.f45486y || this.f45536d == 1) {
                    NativeController.this.a("REQUEST_TIMEOUT", this.f45536d, this.f45537e, (CampaignEx) null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements H5DownLoadManager.IH5SourceDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f45538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CampaignEx f45539b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f45540c = System.currentTimeMillis();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f45541d;

        public d(String str, CampaignEx campaignEx, boolean z11) {
            this.f45541d = true;
            this.f45538a = str;
            this.f45539b = campaignEx;
            this.f45541d = z11;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public final void onFailed(String str, String str2) {
            try {
                if (this.f45541d) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - this.f45540c;
                    q.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                    n nVar = new n("2000043", 3, jCurrentTimeMillis + "", str, this.f45539b.getId(), this.f45538a, str2, "2");
                    nVar.f(this.f45539b.getRequestId());
                    nVar.s(this.f45539b.getCurrentLocalRid());
                    nVar.g(this.f45539b.getRequestIdNotice());
                    CampaignEx campaignEx = this.f45539b;
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getId())) {
                        nVar.e(this.f45539b.getId());
                    }
                    CampaignEx campaignEx2 = this.f45539b;
                    if (campaignEx2 != null) {
                        nVar.c(campaignEx2.getAdSpaceT());
                    }
                    nVar.d("1");
                    m.a(nVar, this.f45538a, this.f45539b);
                }
            } catch (Exception e11) {
                ad.b(NativeController.f45461f, com.mbridge.msdk.mbnative.b.a.a(e11));
            }
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public final void onSuccess(String str, String str2, boolean z11) {
            try {
                if (this.f45541d) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - this.f45540c;
                    q.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                    n nVar = new n("2000043", 1, jCurrentTimeMillis + "", str, this.f45539b.getId(), this.f45538a, "", "2");
                    CampaignEx campaignEx = this.f45539b;
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getId())) {
                        nVar.e(this.f45539b.getId());
                    }
                    CampaignEx campaignEx2 = this.f45539b;
                    if (campaignEx2 != null) {
                        nVar.f(campaignEx2.getRequestId());
                        nVar.g(this.f45539b.getRequestIdNotice());
                        nVar.s(this.f45539b.getCurrentLocalRid());
                        nVar.c(this.f45539b.getAdSpaceT());
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        nVar.t(str2);
                    }
                    nVar.d("1");
                    m.a(nVar, this.f45538a, this.f45539b);
                }
            } catch (Exception e11) {
                ad.b(NativeController.f45461f, com.mbridge.msdk.mbnative.b.a.a(e11));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<NativeController> f45542a;

        public e(NativeController nativeController) {
            this.f45542a = new WeakReference<>(nativeController);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            WeakReference<NativeController> weakReference;
            NativeController nativeController;
            super.handleMessage(message);
            try {
                if (message.what == 0 && (weakReference = this.f45542a) != null && (nativeController = weakReference.get()) != null) {
                    nativeController.f45478q.a(message.arg1, (String) message.obj);
                }
                if (message.what == 1) {
                    WeakReference<NativeController> weakReference2 = this.f45542a;
                    NativeController nativeController2 = (weakReference2 == null || weakReference2.get() == null) ? null : this.f45542a.get();
                    if (nativeController2 != null) {
                        nativeController2.f45487z = true;
                        List<Campaign> listA = nativeController2.a(nativeController2.f45473l, nativeController2.f45482u, nativeController2.Q);
                        if (nativeController2.f45486y) {
                            return;
                        }
                        nativeController2.a(listA);
                    }
                }
            } catch (Exception e11) {
                ad.b(NativeController.f45461f, com.mbridge.msdk.mbnative.b.a.a(e11));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f extends com.mbridge.msdk.foundation.same.e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CampaignEx f45543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WeakReference<View> f45544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private WeakReference<List<View>> f45545c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private WeakReference<NativeController> f45546d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private WeakReference<kn.b> f45547e;

        public f(CampaignEx campaignEx, View view, List<View> list, NativeController nativeController, kn.b bVar) {
            this.f45543a = campaignEx;
            this.f45544b = new WeakReference<>(view);
            this.f45545c = new WeakReference<>(list);
            this.f45546d = new WeakReference<>(nativeController);
            this.f45547e = new WeakReference<>(bVar);
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void cancelTask() {
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void pauseTask(boolean z11) {
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void runTask() {
            WeakReference<View> weakReference;
            try {
                if (this.f45546d == null || (weakReference = this.f45544b) == null || this.f45545c == null) {
                    return;
                }
                View view = weakReference.get();
                List<View> list = this.f45545c.get();
                NativeController nativeController = this.f45546d.get();
                WeakReference<kn.b> weakReference2 = this.f45547e;
                kn.b bVar = weakReference2 != null ? weakReference2.get() : null;
                if (view == null || nativeController == null) {
                    return;
                }
                NativeController.a(nativeController, this.f45543a, view, list, bVar);
            } catch (Exception e11) {
                ad.b(NativeController.f45461f, com.mbridge.msdk.mbnative.b.a.a(e11));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g implements H5DownLoadManager.ZipDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f45548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        CampaignEx f45549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f45550c = System.currentTimeMillis();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f45551d;

        public g(String str, CampaignEx campaignEx, boolean z11) {
            this.f45551d = true;
            this.f45548a = str;
            this.f45549b = campaignEx;
            this.f45551d = z11;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public final void onFailed(String str, String str2) {
            try {
                if (this.f45551d) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - this.f45550c;
                    q.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                    n nVar = new n("2000043", 3, jCurrentTimeMillis + "", str2, this.f45549b.getId(), this.f45548a, str, "1");
                    CampaignEx campaignEx = this.f45549b;
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getId())) {
                        nVar.e(this.f45549b.getId());
                    }
                    CampaignEx campaignEx2 = this.f45549b;
                    if (campaignEx2 != null) {
                        nVar.f(campaignEx2.getRequestId());
                        nVar.s(this.f45549b.getCurrentLocalRid());
                        nVar.g(this.f45549b.getRequestIdNotice());
                        nVar.c(this.f45549b.getAdSpaceT());
                    }
                    nVar.d("2");
                    m.a(nVar, this.f45548a, this.f45549b);
                }
            } catch (Exception e11) {
                ad.b(NativeController.f45461f, com.mbridge.msdk.mbnative.b.a.a(e11));
            }
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public final void onSuccess(String str, String str2, boolean z11) {
            try {
                if (this.f45551d) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - this.f45550c;
                    q.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                    n nVar = new n("2000043", 1, jCurrentTimeMillis + "", str, this.f45549b.getId(), this.f45548a, "", "1");
                    CampaignEx campaignEx = this.f45549b;
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getId())) {
                        nVar.e(this.f45549b.getId());
                    }
                    CampaignEx campaignEx2 = this.f45549b;
                    if (campaignEx2 != null) {
                        nVar.f(campaignEx2.getRequestId());
                        nVar.s(this.f45549b.getCurrentLocalRid());
                        nVar.g(this.f45549b.getRequestIdNotice());
                        nVar.c(this.f45549b.getAdSpaceT());
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        nVar.t(str2);
                    }
                    nVar.d("2");
                    m.a(nVar, this.f45548a, this.f45549b);
                }
            } catch (Exception e11) {
                ad.b(NativeController.f45461f, com.mbridge.msdk.mbnative.b.a.a(e11));
            }
        }
    }

    public NativeController() {
        this.f45481t = 1;
        this.f45482u = 1;
        this.f45483v = -1;
        this.f45484w = 0;
        this.f45486y = false;
        this.f45487z = false;
        this.A = false;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.I = new CopyOnWriteArrayList<>();
        this.J = new Hashtable<>();
        this.K = 1;
        this.L = 2;
        this.Q = "";
        this.R = "";
        this.f45465ac = "";
    }

    public NativeController(com.mbridge.msdk.mbnative.d.a aVar, NativeListener.NativeTrackingListener nativeTrackingListener, Map<String, Object> map, Context context) {
        com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA;
        int iIntValue;
        Object obj;
        this.f45481t = 1;
        this.f45482u = 1;
        this.f45483v = -1;
        this.f45484w = 0;
        this.f45486y = false;
        this.f45487z = false;
        this.A = false;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.I = new CopyOnWriteArrayList<>();
        this.J = new Hashtable<>();
        this.K = 1;
        this.L = 2;
        this.Q = "";
        this.R = "";
        this.f45465ac = "";
        this.f45472k = context;
        this.f45468e = map;
        this.f45469h = new j();
        this.f45470i = aVar;
        this.f45471j = nativeTrackingListener;
        this.G = new ArrayList();
        this.H = new ArrayList();
        String str = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
        this.f45473l = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!map.containsKey(MBridgeConstans.PLACEMENT_ID) || map.get(MBridgeConstans.PLACEMENT_ID) == null) {
            this.f45474m = "";
        } else {
            this.f45474m = (String) map.get(MBridgeConstans.PLACEMENT_ID);
        }
        if (map.containsKey(MBridgeConstans.PREIMAGE) && (obj = map.get(MBridgeConstans.PREIMAGE)) != null) {
            f45462g = ((Boolean) obj).booleanValue();
        }
        this.f45475n = new LinkedList();
        this.f45476o = new LinkedList();
        this.F = new com.mbridge.msdk.foundation.same.e.b(this.f45472k);
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        this.f45552a = new e(this);
        if (map.containsKey(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY)) {
            this.f45485x = (String) map.get(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY);
        }
        try {
            boolean zEquals = com.mbridge.msdk.mbnative.controller.d.b().containsKey(this.f45473l) ? Boolean.TRUE.equals(com.mbridge.msdk.mbnative.controller.d.b().get(this.f45473l)) : false;
            Object obj2 = map.get("ad_num");
            Object obj3 = map.get(MBridgeConstans.PROPERTIES_AD_FRAME_NUM);
            if (zEquals) {
                if (com.mbridge.msdk.mbnative.controller.d.d().containsKey(this.f45473l)) {
                    Integer num = com.mbridge.msdk.mbnative.controller.d.d().get(this.f45473l);
                    if (num != null) {
                        this.f45482u = num.intValue();
                    }
                    if (map.containsKey("ad_num") && obj2 != null) {
                        int iIntValue2 = ((Integer) obj2).intValue();
                        this.B = iIntValue2;
                        this.f45481t = iIntValue2;
                    }
                    if (map.containsKey(MBridgeConstans.PROPERTIES_AD_FRAME_NUM) && obj3 != null) {
                        int iIntValue3 = ((Integer) obj3).intValue();
                        this.C = iIntValue3;
                        this.D = iIntValue3;
                    }
                }
            } else if (map.containsKey("ad_num") && obj2 != null) {
                try {
                    iIntValue = ((Integer) obj2).intValue();
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b(f45461f, e11.getMessage());
                    }
                    iIntValue = 1;
                }
                iIntValue = iIntValue < 1 ? 1 : iIntValue;
                iIntValue = iIntValue > 10 ? 10 : iIntValue;
                this.f45482u = iIntValue;
                this.f45481t = iIntValue;
                if (map.containsKey(MBridgeConstans.PROPERTIES_AD_FRAME_NUM)) {
                    this.D = ((Integer) obj3).intValue();
                }
            } else if (map.containsKey(MBridgeConstans.PROPERTIES_AD_FRAME_NUM) && obj3 != null) {
                try {
                    this.D = ((Integer) obj3).intValue();
                } catch (Exception e12) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b(f45461f, e12.getMessage());
                    }
                }
            }
        } catch (Exception e13) {
            ad.b(f45461f, com.mbridge.msdk.mbnative.b.a.a(e13));
        }
        this.f45478q = new o(this.f45472k);
        this.f45480s = new com.mbridge.msdk.click.a(this.f45472k, this.f45473l);
        try {
            int i11 = MBMediaView.f45890a0;
            this.O = true;
            Map<String, Object> map2 = this.f45468e;
            if (map2 != null && (map2.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH) || this.f45468e.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT) || map.containsKey(MBridgeConstans.NATIVE_VIDEO_SUPPORT))) {
                this.N = true;
            }
            com.mbridge.msdk.mbnative.controller.e.a(this.f45472k, this.f45473l);
            ab.a();
            if (TextUtils.isEmpty(this.f45473l)) {
                return;
            }
            com.mbridge.msdk.foundation.db.f.a(h.a(this.f45472k)).a();
            int iA = a(map.containsKey(MBridgeConstans.NATIVE_INFO) ? (String) map.get(MBridgeConstans.NATIVE_INFO) : null);
            String str2 = this.f45473l;
            iA = iA <= 0 ? this.f45481t : iA;
            k kVarD = com.mbridge.msdk.c.h.a().d("", str2);
            this.T = kVarD;
            if (kVarD == null) {
                this.T = k.d(str2);
            }
            List<Integer> listB = this.T.b();
            this.f45466c = listB;
            List<Campaign> listB2 = (listB == null || listB.size() <= 0 || !this.f45466c.contains(1) || (bVarA = com.mbridge.msdk.mbnative.a.c.a(1)) == null) ? null : bVarA.b(str2, iA);
            if (listB2 != null) {
                ArrayList arrayList = new ArrayList();
                for (int i12 = 0; i12 < listB2.size(); i12++) {
                    CampaignEx campaignEx = (CampaignEx) listB2.get(i12);
                    if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                        arrayList.add(campaignEx);
                    }
                }
                if (arrayList.size() > 0) {
                    Object objInvoke = com.mbridge.msdk.videocommon.download.b.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                    com.mbridge.msdk.videocommon.download.b.class.getMethod("createUnitCache", Context.class, String.class, CopyOnWriteArrayList.class, Integer.TYPE, com.mbridge.msdk.videocommon.listener.a.class).invoke(objInvoke, context, this.f45473l, new CopyOnWriteArrayList(arrayList), 1, null);
                    com.mbridge.msdk.videocommon.download.b.class.getMethod("load", String.class).invoke(objInvoke, this.f45473l);
                }
            }
        } catch (Throwable unused) {
            ad.b(f45461f, "please import the nativex aar");
        }
    }

    private int a(String str) {
        if (str == null) {
            return 0;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i11);
                    if (2 == jSONObject.optInt("id", 0)) {
                        return jSONObject.optInt("ad_num");
                    }
                }
            }
        } catch (Exception e11) {
            ad.b(f45461f, com.mbridge.msdk.mbnative.b.a.a(e11));
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Campaign> a(int i11, List<Campaign> list) {
        if (i11 != 1 || !this.f45468e.containsKey(MBridgeConstans.NATIVE_INFO) || list == null || list.size() <= 0) {
            return list;
        }
        CampaignEx campaignEx = (CampaignEx) list.get(0);
        int template = campaignEx != null ? campaignEx.getTemplate() : 1;
        if (template == 2) {
            int size = list.size();
            int i12 = this.Y;
            return size >= i12 ? list.subList(0, i12) : list;
        }
        if (template != 3) {
            return list;
        }
        int size2 = list.size();
        int i13 = this.Z;
        return size2 >= i13 ? list.subList(0, i13) : list;
    }

    public static /* synthetic */ List a(NativeController nativeController, List list, boolean z11) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                Campaign campaign = (Campaign) list.get(size);
                String id2 = campaign.getId();
                boolean z12 = campaign instanceof CampaignEx;
                if (z12) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(id2);
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    sb2.append(campaignEx.getVideoUrlEncode());
                    sb2.append(campaignEx.getBidToken());
                    id2 = sb2.toString();
                }
                com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.b.getInstance().a(nativeController.f45473l, id2);
                if (z11) {
                    if (aVarA == null || !com.mbridge.msdk.videocommon.download.j.a(aVarA, nativeController.f().p())) {
                        com.mbridge.msdk.mbnative.a.c.a(campaign.getType()).a(nativeController.f45473l, (Campaign) list.remove(size), nativeController.Q);
                    }
                } else if (z12) {
                    CampaignEx campaignEx2 = (CampaignEx) campaign;
                    if (TextUtils.isEmpty(campaignEx2.getImageUrl()) && !TextUtils.isEmpty(campaignEx2.getVideoUrlEncode()) && (aVarA == null || !com.mbridge.msdk.videocommon.download.j.a(aVarA, nativeController.f().p()))) {
                        com.mbridge.msdk.mbnative.a.c.a(campaign.getType()).a(nativeController.f45473l, (Campaign) list.remove(size), nativeController.Q);
                    }
                }
            }
        }
        return list;
    }

    private void a(View view, View.OnClickListener onClickListener, Class cls) {
        if (view == null || onClickListener == null) {
            return;
        }
        if (cls != null) {
            try {
                if (cls.isInstance(view)) {
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        view.setOnClickListener(onClickListener);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                a(viewGroup.getChildAt(i11), onClickListener, cls);
            }
        }
    }

    private void a(final View view, CampaignEx campaignEx) {
        BitmapDrawable bitmapDrawableA;
        final ImageView imageView;
        if (!(view instanceof FrameLayout) || (bitmapDrawableA = com.mbridge.msdk.foundation.controller.c.m().a(this.f45473l, campaignEx.getAdType())) == null) {
            return;
        }
        try {
            int childCount = ((ViewGroup) view).getChildCount();
            int i11 = 0;
            while (true) {
                if (i11 >= childCount) {
                    imageView = null;
                    break;
                }
                View childAt = ((ViewGroup) view).getChildAt(i11);
                if ((childAt instanceof ImageView) && childAt.getTag() != null && "mb_wm".equals((String) childAt.getTag())) {
                    ((ImageView) childAt).setLayoutParams(new FrameLayout.LayoutParams(view.getWidth(), view.getHeight()));
                    imageView = (ImageView) childAt;
                    break;
                }
                i11++;
            }
            if (imageView == null) {
                imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
                imageView.setTag("mb_wm");
                ai.a(imageView, bitmapDrawableA, view.getResources().getDisplayMetrics());
                if (imageView.getParent() == null) {
                    ((FrameLayout) view).addView(imageView, new FrameLayout.LayoutParams(view.getWidth(), view.getHeight()));
                }
            }
            this.S = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    if (imageView != null) {
                        imageView.setLayoutParams(new FrameLayout.LayoutParams(view.getWidth(), view.getHeight()));
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.S);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void a(View view, Class cls) {
        if (view == null) {
            return;
        }
        if (cls != null) {
            try {
                if (cls.isInstance(view)) {
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        view.setOnClickListener(null);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                a(viewGroup.getChildAt(i11), cls);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.isReportClick()) {
            return;
        }
        campaignEx.setReportClick(true);
        if (campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().l() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(this.f45472k, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().l(), false, false);
    }

    private void a(CampaignEx campaignEx, View view, List<View> list) {
        kn.b bVarB;
        try {
            if (this.f45472k == null || campaignEx == null) {
                bVarB = null;
            } else {
                bVarB = b(campaignEx);
                if (bVarB != null) {
                    bVarB.d(view);
                    bVarB.g();
                }
            }
            kn.b bVar = bVarB;
            k kVar = this.T;
            int iL = kVar != null ? kVar.l() : 0;
            if (campaignEx != null && campaignEx.getImpReportType() == 1) {
                iL = 0;
            }
            final f fVar = new f(campaignEx, view, list, this, bVar);
            if (this.I == null) {
                this.I = new CopyOnWriteArrayList<>();
            }
            this.I.add(fVar);
            fVar.setOnStateChangeListener(new com.mbridge.msdk.foundation.same.e.a.InterfaceC0489a() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.10
                @Override // com.mbridge.msdk.foundation.same.e.a.InterfaceC0489a
                public final void a(com.mbridge.msdk.foundation.same.e.a.b bVar2) {
                    if (bVar2 != com.mbridge.msdk.foundation.same.e.a.b.FINISH || NativeController.this.I == null || NativeController.this.I.size() <= 0 || !NativeController.this.I.contains(fVar)) {
                        return;
                    }
                    NativeController.this.I.remove(fVar);
                }
            });
            Handler handler = this.f45552a;
            if (handler != null) {
                handler.postDelayed(fVar, iL * 1000);
            }
        } catch (Exception e11) {
            ad.b(f45461f, com.mbridge.msdk.mbnative.b.a.a(e11));
        }
    }

    public static /* synthetic */ void a(NativeController nativeController, Context context, final CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (campaignEx.needShowIDialog() && com.mbridge.msdk.f.b.a()) {
                    new com.mbridge.msdk.widget.dialog.a() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.8
                        @Override // com.mbridge.msdk.widget.dialog.a
                        public final void a() {
                            NativeController.this.f45480s.a(campaignEx, NativeController.this.f45470i);
                            NativeController.this.a(campaignEx);
                        }

                        @Override // com.mbridge.msdk.widget.dialog.a
                        public final void b() {
                        }

                        @Override // com.mbridge.msdk.widget.dialog.a
                        public final void c() {
                        }
                    };
                    if (com.mbridge.msdk.click.c.a(campaignEx) && campaignEx.needShowIDialog()) {
                        com.mbridge.msdk.click.a aVar = nativeController.f45480s;
                        nativeController.a(campaignEx);
                        nativeController.f45470i.onAdClick(campaignEx);
                        return;
                    }
                }
            } catch (Throwable th2) {
                ad.a(f45461f, th2.getMessage());
            }
        }
        nativeController.f45480s.a(campaignEx, nativeController.f45470i);
        nativeController.a(campaignEx);
    }

    public static /* synthetic */ void a(NativeController nativeController, final CampaignEx campaignEx, View view, List list, kn.b bVar) {
        try {
            com.mbridge.msdk.mbnative.controller.c.a aVar = new com.mbridge.msdk.mbnative.controller.c.a() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.11
                @Override // com.mbridge.msdk.mbnative.controller.c.a
                public final void a(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
                    if (arrayList == null || arrayList.size() <= 0) {
                        return;
                    }
                    com.mbridge.msdk.mbnative.e.b.a(campaignEx, NativeController.this.f45472k, NativeController.this.f45473l, NativeController.this.f45470i);
                }
            };
            com.mbridge.msdk.mbnative.controller.c cVar = new com.mbridge.msdk.mbnative.controller.c(list, aVar, new Handler(Looper.getMainLooper()), campaignEx.getImpReportType());
            cVar.a(view);
            List<com.mbridge.msdk.mbnative.controller.c> list2 = nativeController.G;
            if (list2 != null) {
                list2.add(cVar);
            }
            List<com.mbridge.msdk.mbnative.controller.c.a> list3 = nativeController.H;
            if (list3 != null) {
                list3.add(aVar);
            }
            if (bVar != null) {
                kn.a.a(bVar).b();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.mbridge.msdk.mbnative.d.a aVar, final String str, final CampaignEx campaignEx) {
        this.f45552a.post(new Runnable() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.3
            @Override // java.lang.Runnable
            public final void run() {
                aVar.a(campaignEx, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final List<Campaign> list, final int i11, final NativeListener.NativeAdListener nativeAdListener) {
        this.f45552a.post(new Runnable() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.2
            @Override // java.lang.Runnable
            public final void run() {
                List list2 = list;
                if (list2 != null && list2.size() > 0) {
                    CampaignEx campaignEx = (CampaignEx) list.get(0);
                    NativeController.this.R = campaignEx.getRequestId();
                    NativeController.this.f45464ab = list;
                }
                NativeController.this.f45486y = true;
                nativeAdListener.onAdLoaded(list, i11);
                com.mbridge.msdk.mbnative.e.a.a(NativeController.this.f45472k, list, NativeController.this.f45473l);
            }
        });
    }

    private void a(final List<Campaign> list, final b bVar) {
        g();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        Timer timer = new Timer();
        this.P = timer;
        timer.schedule(new TimerTask() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                boolean z11;
                if (System.currentTimeMillis() - jCurrentTimeMillis >= ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) {
                    bVar.a();
                    NativeController.this.g();
                    return;
                }
                int iL = z.l(NativeController.this.f45472k);
                int iK = NativeController.this.f().k();
                if (iL != 9 && iK == 2) {
                    bVar.a();
                    NativeController.this.g();
                    return;
                }
                if (iK == 3) {
                    bVar.a();
                    NativeController.this.g();
                    return;
                }
                loop0: while (true) {
                    z11 = false;
                    for (Campaign campaign : list) {
                        String id2 = campaign.getId();
                        if (campaign instanceof CampaignEx) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(id2);
                            CampaignEx campaignEx = (CampaignEx) campaign;
                            sb2.append(campaignEx.getVideoUrlEncode());
                            sb2.append(campaignEx.getBidToken());
                            id2 = sb2.toString();
                        }
                        com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.b.getInstance().a(NativeController.this.f45473l, id2);
                        if (aVarA != null && com.mbridge.msdk.videocommon.download.j.a(aVarA, NativeController.this.f().p())) {
                            z11 = true;
                        }
                    }
                    break loop0;
                }
                if (z11) {
                    bVar.a();
                    NativeController.this.g();
                }
            }
        }, 0L, 1000L);
    }

    private boolean a(int i11) {
        int iMin;
        int iOptInt;
        int iOptInt2;
        com.mbridge.msdk.mbnative.d.a aVar;
        int i12 = 0;
        if (com.mbridge.msdk.mbnative.controller.d.b().containsKey(this.f45473l) && Boolean.TRUE.equals(com.mbridge.msdk.mbnative.controller.d.b().get(this.f45473l))) {
            Map<String, Map<Long, Object>> mapA = com.mbridge.msdk.mbnative.controller.d.a();
            Map<Long, Object> map = mapA.get(i11 + "_" + this.f45473l);
            Integer num = com.mbridge.msdk.mbnative.controller.d.d().get(this.f45473l);
            com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (num != null) {
                this.f45482u = num.intValue();
            }
            if (map != null && map.size() > 0) {
                Long next = map.keySet().iterator().next();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (gVarB == null) {
                    com.mbridge.msdk.c.h.a();
                    gVarB = i.a();
                }
                if (jCurrentTimeMillis - next.longValue() >= gVarB.ab() * 1000) {
                    mapA.remove(i11 + "_" + this.f45473l);
                } else {
                    if (i11 == 1) {
                        List<Frame> list = (List) map.get(next);
                        if (list == null || list.size() <= 0 || (aVar = this.f45470i) == null) {
                            return false;
                        }
                        if (this.D >= list.size()) {
                            mapA.remove(i11 + "_" + this.f45473l);
                            aVar.onAdFramesLoaded(list);
                            return true;
                        }
                        if (this.D == 0) {
                            return false;
                        }
                        List<Frame> listSubList = list.subList(0, this.C);
                        aVar.onAdFramesLoaded(list);
                        list.removeAll(listSubList);
                        map.put(next, listSubList);
                        ArrayList arrayList = new ArrayList();
                        for (Frame frame : list) {
                            if (i12 >= this.D) {
                                arrayList.add(frame);
                            }
                            i12++;
                        }
                        map.put(next, arrayList);
                        mapA.put(i11 + "_" + this.f45473l, map);
                        aVar.onAdFramesLoaded(listSubList);
                        return true;
                    }
                    List list2 = (List) map.get(next);
                    if (list2 != null && list2.size() > 0) {
                        List<Campaign> arrayList2 = new ArrayList<>();
                        if (((CampaignEx) list2.get(0)).getType() == 1) {
                            if (TextUtils.isEmpty(this.f45477p)) {
                                iMin = Math.min(this.B, list2.size());
                            } else {
                                try {
                                    JSONArray jSONArray = new JSONArray(this.f45477p);
                                    if (jSONArray.length() > 0) {
                                        iOptInt = 0;
                                        iOptInt2 = 0;
                                        for (int i13 = 0; i13 < jSONArray.length(); i13++) {
                                            JSONObject jSONObject = (JSONObject) jSONArray.opt(i13);
                                            int iOptInt3 = jSONObject.optInt("id", 0);
                                            if (2 == iOptInt3) {
                                                iOptInt = jSONObject.optInt("ad_num");
                                            } else if (3 == iOptInt3) {
                                                iOptInt2 = jSONObject.optInt("ad_num");
                                            }
                                        }
                                    } else {
                                        iOptInt = 0;
                                        iOptInt2 = 0;
                                    }
                                    iMin = 3 == ((CampaignEx) list2.get(0)).getTemplate() ? Math.min(iOptInt2, list2.size()) : Math.min(iOptInt, list2.size());
                                } catch (Exception unused) {
                                    ad.b(f45461f, "load from catch error in get nativeinfo adnum");
                                    iMin = 0;
                                }
                            }
                            if (iMin <= 0) {
                                return false;
                            }
                            Iterator it = list2.iterator();
                            while (it.hasNext() && i12 != iMin) {
                                CampaignEx campaignEx = (CampaignEx) it.next();
                                campaignEx.getTemplate();
                                arrayList2.add(campaignEx);
                                it.remove();
                                i12++;
                            }
                        } else {
                            int iMin2 = Math.min(this.B, list2.size());
                            if (iMin2 > 0) {
                                Iterator it2 = list2.iterator();
                                while (it2.hasNext() && i12 != iMin2) {
                                    CampaignEx campaignEx2 = (CampaignEx) it2.next();
                                    campaignEx2.getTemplate();
                                    arrayList2.add(campaignEx2);
                                    it2.remove();
                                    i12++;
                                }
                            }
                        }
                        a(arrayList2);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(final List<Campaign> list) {
        if ((!TextUtils.isEmpty(this.Q) && list != null && list.size() == 0) || list == null || list.size() <= 0) {
            return false;
        }
        final com.mbridge.msdk.mbnative.d.a aVar = this.f45470i;
        if (aVar == null) {
            return true;
        }
        CampaignEx campaignEx = (CampaignEx) list.get(0);
        final int template = campaignEx != null ? campaignEx.getTemplate() : 2;
        com.mbridge.msdk.foundation.db.k kVarA = com.mbridge.msdk.foundation.db.k.a(h.a(this.f45472k));
        kVarA.a();
        for (int i11 = 0; i11 < list.size(); i11++) {
            CampaignEx campaignEx2 = (CampaignEx) list.get(i11);
            if (!kVarA.b(campaignEx2.getId())) {
                com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                gVar.a(campaignEx2.getId());
                gVar.b(campaignEx2.getFca());
                gVar.c(campaignEx2.getFcb());
                gVar.a(0);
                gVar.d(0);
                gVar.a(System.currentTimeMillis());
                kVarA.a(gVar);
            }
        }
        if (!this.O || !this.N) {
            if (list.size() <= 0) {
                a(aVar, "has no ads", (CampaignEx) null);
                return true;
            }
            Iterator<Campaign> it = list.iterator();
            while (it.hasNext()) {
                it.next().setVideoLength(0);
            }
            a(list, template, aVar);
            return true;
        }
        if (f().h() == 3) {
            final List<Campaign> listB = b(list);
            if (list.size() > 0) {
                a(list, new b() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.12
                    @Override // com.mbridge.msdk.mbnative.controller.NativeController.b
                    public final void a() {
                        List listA = NativeController.a(NativeController.this, listB, true);
                        if (listA == null || listA.size() <= 0) {
                            NativeController.this.a(aVar, "has no ads", (CampaignEx) list.get(0));
                        } else {
                            NativeController.this.a((List<Campaign>) listA, template, aVar);
                        }
                    }
                });
                return true;
            }
            a(aVar, "has no ads", (CampaignEx) null);
            return true;
        }
        List<Campaign> listC = c(list);
        if (listC == null || listC.size() <= 0) {
            a(list, template, aVar);
            return true;
        }
        a(listC, new b() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.13
            @Override // com.mbridge.msdk.mbnative.controller.NativeController.b
            public final void a() {
                List listA = NativeController.a(NativeController.this, list, false);
                if (listA == null || listA.size() <= 0) {
                    NativeController.this.a(aVar, "has no ads", (CampaignEx) null);
                } else {
                    NativeController.this.a((List<Campaign>) listA, template, aVar);
                }
            }
        });
        return true;
    }

    public static boolean a(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        try {
            return map.containsKey("app_id") && map.containsKey(MBridgeConstans.APP_KEY) && map.containsKey(MBridgeConstans.KEY_WORD) && map.get(MBridgeConstans.KEY_WORD) != null;
        } catch (Exception e11) {
            ad.b(f45461f, com.mbridge.msdk.mbnative.b.a.a(e11));
            return false;
        }
    }

    private List<Campaign> b(List<Campaign> list) {
        if (list != null) {
            CampaignEx campaignEx = null;
            for (int size = list.size() - 1; size >= 0; size--) {
                try {
                    campaignEx = (CampaignEx) list.get(size);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                if (campaignEx != null && TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                    Campaign campaignRemove = list.remove(size);
                    com.mbridge.msdk.mbnative.a.c.a(campaignEx.getType()).a(this.f45473l, campaignRemove, this.Q);
                    ad.a(f45461f, "remove no videoURL ads:" + campaignRemove);
                }
            }
        }
        return list;
    }

    public static List<String> b(Map<String, Object> map) {
        ArrayList arrayList = null;
        try {
            if (!(map.get(MBridgeConstans.KEY_WORD) instanceof String)) {
                return null;
            }
            String str = (String) map.get(MBridgeConstans.KEY_WORD);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString = jSONObjectOptJSONObject.optString(TtmlNode.TAG_P);
                        if (TextUtils.isEmpty(strOptString)) {
                            continue;
                        } else {
                            arrayList2.add(strOptString);
                        }
                    }
                } catch (Exception e11) {
                    e = e11;
                    arrayList = arrayList2;
                }
            }
            return arrayList2;
        } catch (Exception e12) {
            e = e12;
        }
        ad.b(f45461f, com.mbridge.msdk.mbnative.b.a.a(e));
        return arrayList;
    }

    private kn.b b(CampaignEx campaignEx) {
        if (this.J == null) {
            this.J = new Hashtable<>();
        }
        String requestIdNotice = campaignEx.getRequestIdNotice();
        kn.b bVarA = this.J.get(requestIdNotice);
        if (bVarA == null && campaignEx.isActiveOm()) {
            bVarA = com.mbridge.msdk.a.b.a(this.f45472k, true, campaignEx.getOmid(), campaignEx.getRequestId(), campaignEx.getId(), this.f45473l, "", campaignEx.getRequestIdNotice());
        }
        if (bVarA != null) {
            this.J.put(requestIdNotice, bVarA);
        }
        return bVarA;
    }

    private void b(int i11, long j11, int i12, String str) {
        com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA;
        if (i12 == 0 && (bVarA = com.mbridge.msdk.mbnative.a.c.a(i11)) != null) {
            if ((i11 == 1 || i11 == 2) && this.f45468e.containsKey(MBridgeConstans.NATIVE_INFO)) {
                this.f45482u = this.K;
            } else {
                this.f45482u = this.f45481t;
            }
            if (a(a(i11, d(bVarA.b(this.f45473l, this.f45482u))))) {
                return;
            }
        }
        if (i11 == 1) {
            a(j11, i12, true, this.f45473l, str);
        } else if (i11 != 2) {
            a(i11, j11, i12, str);
        } else {
            a(2, j11, i12, str);
        }
    }

    private void b(int i11, String str) {
        com.mbridge.msdk.mbnative.d.a aVar;
        Long lPoll;
        Queue<Integer> queue = this.f45475n;
        if (queue == null || queue.size() <= 0) {
            if (this.f45486y || (aVar = this.f45470i) == null) {
                return;
            }
            this.f45486y = true;
            aVar.onAdLoadError("no ad source");
            return;
        }
        Integer numPoll = this.f45475n.poll();
        int iIntValue = numPoll != null ? numPoll.intValue() : 1;
        this.U = MBridgeConstans.REQUEST_TIME_OUT;
        Queue<Long> queue2 = this.f45476o;
        if (queue2 != null && queue2.size() > 0 && (lPoll = this.f45476o.poll()) != null) {
            this.U = lPoll.longValue();
        }
        b(iIntValue, this.U, i11, str);
    }

    private List<Campaign> c(List<Campaign> list) {
        ArrayList arrayList = null;
        if (list != null) {
            for (Campaign campaign : list) {
                if (campaign instanceof CampaignEx) {
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    if (TextUtils.isEmpty(campaignEx.getImageUrl()) && !TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(campaign);
                    }
                }
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void c(NativeController nativeController, List list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    try {
                        int i11 = MBMediaView.f45890a0;
                        Object objInvoke = com.mbridge.msdk.videocommon.download.b.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                        if (objInvoke != null) {
                            com.mbridge.msdk.videocommon.download.b.class.getMethod("createUnitCache", Context.class, String.class, CopyOnWriteArrayList.class, Integer.TYPE, com.mbridge.msdk.videocommon.listener.a.class).invoke(objInvoke, nativeController.f45472k, nativeController.f45473l, new CopyOnWriteArrayList(list), 1, null);
                            com.mbridge.msdk.videocommon.download.b.class.getMethod("load", String.class).invoke(objInvoke, nativeController.f45473l);
                        }
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            CampaignEx campaignEx = (CampaignEx) it.next();
                            if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getImageUrl())) {
                                com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(campaignEx.getImageUrl(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.4
                                    @Override // com.mbridge.msdk.foundation.same.c.c
                                    public final void onFailedLoad(String str, String str2) {
                                    }

                                    @Override // com.mbridge.msdk.foundation.same.c.c
                                    public final void onSuccessLoad(Bitmap bitmap, String str) {
                                    }
                                });
                            }
                            String str = "";
                            if (campaignEx != null) {
                                try {
                                    str = campaignEx.getendcard_url();
                                } catch (Exception unused) {
                                }
                            }
                            com.mbridge.msdk.foundation.same.report.d.b bVar = new com.mbridge.msdk.foundation.same.report.d.b();
                            bVar.a(campaignEx);
                            if (!TextUtils.isEmpty(str)) {
                                bVar.c((campaignEx == null || campaignEx.getAabEntity() == null) ? 0 : campaignEx.getAabEntity().h3c);
                                if (str.contains(".zip") && str.contains(ResourceManager.KEY_MD5FILENAME)) {
                                    H5DownLoadManager.getInstance().downloadH5Res(bVar, str, new g(nativeController.f45473l, campaignEx, TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str))));
                                } else {
                                    H5DownLoadManager.getInstance().downloadH5Res(bVar, str, new d(nativeController.f45473l, campaignEx, TextUtils.isEmpty(HTMLResourceManager.getInstance().getHtmlContentFromUrl(str))));
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                        ad.b(f45461f, "please import the videocommon and nativex aar");
                    }
                }
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    th2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Campaign> d(List<Campaign> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        for (Campaign campaign : list) {
            if (campaign instanceof CampaignEx) {
                CampaignEx campaignEx = (CampaignEx) campaign;
                if (TextUtils.isEmpty(this.Q) && TextUtils.isEmpty(campaignEx.getBidToken()) && !campaignEx.isBidCampaign()) {
                    arrayList2.add(campaignEx);
                } else if (!TextUtils.isEmpty(this.Q) && TextUtils.equals(campaignEx.getBidToken(), this.Q)) {
                    arrayList.add(campaign);
                }
            } else {
                arrayList2.add(campaign);
            }
        }
        return TextUtils.isEmpty(this.Q) ? arrayList2 : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public k f() {
        k kVarD = com.mbridge.msdk.c.h.a().d("", this.f45473l);
        this.T = kVarD;
        if (kVarD == null) {
            this.T = k.d(this.f45473l);
        }
        return this.T;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Timer timer = this.P;
        if (timer != null) {
            timer.cancel();
            this.P = null;
        }
    }

    public static void insertExcludeId(String str, CampaignEx campaignEx) {
        if (TextUtils.isEmpty(str) || campaignEx == null || com.mbridge.msdk.foundation.controller.c.m().c() == null) {
            return;
        }
        com.mbridge.msdk.foundation.db.j jVarA = com.mbridge.msdk.foundation.db.j.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
        fVar.a(System.currentTimeMillis());
        fVar.b(str);
        fVar.a(campaignEx.getId());
        jVarA.a(fVar);
    }

    public final List<Campaign> a(String str, int i11, String str2) {
        List<Campaign> listA = null;
        if (this.f45466c != null) {
            ArrayList arrayList = new ArrayList(this.f45466c);
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA = com.mbridge.msdk.mbnative.a.c.a(((Integer) arrayList.get(i12)).intValue());
                if (bVarA != null) {
                    listA = a(((Integer) arrayList.get(i12)).intValue(), bVarA.b(str, ((((Integer) arrayList.get(i12)).intValue() == 1 || ((Integer) arrayList.get(i12)).intValue() == 2) && this.f45468e.containsKey(MBridgeConstans.NATIVE_INFO)) ? this.K : this.f45481t));
                    if (listA != null) {
                        break;
                    }
                }
            }
            if (listA == null) {
                for (int i13 = 0; i13 < arrayList.size(); i13++) {
                    listA = a(((Integer) arrayList.get(i13)).intValue(), com.mbridge.msdk.mbnative.a.c.a(((Integer) arrayList.get(i13)).intValue()).a(str, ((((Integer) arrayList.get(i13)).intValue() == 1 || ((Integer) arrayList.get(i13)).intValue() == 2) && this.f45468e.containsKey(MBridgeConstans.NATIVE_INFO)) ? this.K : this.f45481t));
                    if (listA != null) {
                        break;
                    }
                }
            }
        }
        return d(listA);
    }

    public final void a() {
        com.mbridge.msdk.foundation.same.e.a next;
        com.mbridge.msdk.foundation.same.e.b bVar = this.F;
        if (bVar != null) {
            bVar.a();
            this.F = null;
        }
        Hashtable<String, kn.b> hashtable = this.J;
        if (hashtable != null) {
            for (kn.b bVar2 : hashtable.values()) {
                if (bVar2 != null) {
                    bVar2.c();
                }
            }
            this.J.clear();
        }
        Handler handler = this.f45552a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f45471j = null;
        this.f45480s.a();
        try {
            Context context = this.f45472k;
            if (context != null) {
                com.mbridge.msdk.foundation.same.c.b.a(context).b();
            }
            List<com.mbridge.msdk.mbnative.controller.c> list = this.G;
            if (list != null && list.size() > 0) {
                Iterator<com.mbridge.msdk.mbnative.controller.c> it = this.G.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.G.clear();
                this.G = null;
            }
            List<com.mbridge.msdk.mbnative.controller.c.a> list2 = this.H;
            if (list2 != null && list2.size() > 0) {
                for (com.mbridge.msdk.mbnative.controller.c.a aVar : this.H) {
                }
                this.H.clear();
                this.H = null;
            }
            CopyOnWriteArrayList<com.mbridge.msdk.foundation.same.e.a> copyOnWriteArrayList = this.I;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                return;
            }
            Iterator<com.mbridge.msdk.foundation.same.e.a> it2 = this.I.iterator();
            if (it2.hasNext() && (next = it2.next()) != null) {
                next.cancel();
                this.f45552a.removeCallbacks(next);
            }
            this.I.clear();
        } catch (Exception unused) {
        }
    }

    @Override // com.mbridge.msdk.mbnative.controller.a
    public final synchronized void a(int i11, long j11, int i12, String str) {
        com.mbridge.msdk.foundation.entity.k kVar;
        try {
            try {
                if (this.f45468e.containsKey(MBridgeConstans.NATIVE_INFO)) {
                    this.f45482u = Math.max(this.Y, this.Z);
                }
                if (i12 == 0) {
                    com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA = com.mbridge.msdk.mbnative.a.c.a(i11);
                    if (bVarA != null && a(a(1, d(bVarA.b(this.f45473l, this.f45482u))))) {
                        return;
                    }
                    a aVar = this.M;
                    if (aVar != null && !this.X) {
                        aVar.b(true);
                    }
                    if (this.X && !this.f45486y) {
                        a("mb load failed", i12, str, (CampaignEx) null);
                    }
                    if (!this.f45463aa) {
                        return;
                    }
                }
                int i13 = this.f45483v;
                if (i13 == -1) {
                    this.f45483v = i11;
                } else if (i13 != i11) {
                    this.f45484w = 0;
                }
                com.mbridge.msdk.foundation.db.f.a(h.a(this.f45472k)).a();
                com.mbridge.msdk.mbnative.f.a.a aVar2 = new com.mbridge.msdk.mbnative.f.a.a(this.f45472k);
                com.mbridge.msdk.foundation.same.net.h.e eVar = new com.mbridge.msdk.foundation.same.net.h.e();
                String strK = com.mbridge.msdk.foundation.controller.c.m().k();
                String strB = com.mbridge.msdk.foundation.controller.c.m().b();
                Map<String, Object> map = this.f45468e;
                if (map != null && map.containsKey("app_id") && this.f45468e.containsKey(MBridgeConstans.APP_KEY) && this.f45468e.containsKey(MBridgeConstans.KEY_WORD) && this.f45468e.get(MBridgeConstans.KEY_WORD) != null) {
                    if (this.f45468e.get("app_id") instanceof String) {
                        strK = (String) this.f45468e.get("app_id");
                    }
                    if (this.f45468e.get(MBridgeConstans.APP_KEY) instanceof String) {
                        strB = (String) this.f45468e.get(MBridgeConstans.APP_KEY);
                    }
                    String str2 = this.f45468e.get(MBridgeConstans.KEY_WORD) instanceof String ? (String) this.f45468e.get(MBridgeConstans.KEY_WORD) : null;
                    if (!TextUtils.isEmpty(str2)) {
                        eVar.a("smart", x.b(str2));
                    }
                }
                eVar.a("app_id", strK);
                eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, this.f45473l);
                if (!TextUtils.isEmpty(this.f45474m)) {
                    eVar.a(MBridgeConstans.PLACEMENT_ID, this.f45474m);
                }
                eVar.a("req_type", "2");
                if (!TextUtils.isEmpty(this.f45485x)) {
                    eVar.a("category", this.f45485x);
                }
                eVar.a("sign", SameMD5.getMD5(strK + strB));
                if (this.W <= 0 || i12 != 0) {
                    eVar.a("ad_num", this.f45481t + "");
                } else {
                    eVar.a("ad_num", this.W + "");
                }
                String strD = ai.d(this.f45473l);
                if (!TextUtils.isEmpty(strD)) {
                    eVar.a("j", strD);
                }
                eVar.a("only_impression", "1");
                eVar.a("ping_mode", "1");
                if (this.D != 0) {
                    eVar.a("frame_num", this.D + "");
                }
                if (!TextUtils.isEmpty(this.f45477p)) {
                    eVar.a(MBridgeConstans.NATIVE_INFO, this.f45477p);
                    if (i11 == 1) {
                        eVar.a("tnum", this.K + "");
                    }
                } else if (i11 == 1) {
                    eVar.a("tnum", this.f45481t + "");
                }
                String strA = com.mbridge.msdk.foundation.same.a.d.a(this.f45473l, "native");
                if (!TextUtils.isEmpty(strA)) {
                    eVar.a(com.mbridge.msdk.foundation.same.net.h.e.f44659d, strA);
                }
                if (this.f45468e.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH) && (this.f45468e.get(MBridgeConstans.NATIVE_VIDEO_WIDTH) instanceof Integer)) {
                    eVar.a("video_width", ((Integer) this.f45468e.get(MBridgeConstans.NATIVE_VIDEO_WIDTH)).intValue() + "");
                }
                if (this.f45468e.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT) && (this.f45468e.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT) instanceof Integer)) {
                    eVar.a("video_height", ((Integer) this.f45468e.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT)).intValue() + "");
                }
                if (this.f45468e.containsKey(MBridgeConstans.NATIVE_VIDEO_SUPPORT) && (this.f45468e.get(MBridgeConstans.NATIVE_VIDEO_SUPPORT) instanceof Boolean)) {
                    ((Boolean) this.f45468e.get(MBridgeConstans.NATIVE_VIDEO_SUPPORT)).booleanValue();
                }
                eVar.a("video_version", MBridgeConstans.NATIVE_VIDEO_VERSION);
                if (com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k()) == null) {
                    com.mbridge.msdk.c.h.a();
                    i.a();
                }
                if (!a(this.f45468e)) {
                    JSONArray jSONArrayB = ai.b(this.f45472k, this.f45473l);
                    if (jSONArrayB.length() > 0) {
                        eVar.a(com.mbridge.msdk.foundation.same.net.h.e.f44660e, ai.a(jSONArrayB));
                    }
                }
                if (com.mbridge.msdk.mbnative.controller.d.b().containsKey(this.f45473l) && com.mbridge.msdk.mbnative.controller.d.b().get(this.f45473l).booleanValue() && com.mbridge.msdk.mbnative.controller.d.c().get(this.f45473l) != null && (kVar = com.mbridge.msdk.mbnative.controller.d.c().get(this.f45473l)) != null) {
                    if (i11 == 1) {
                        this.f45484w = kVar.a();
                    } else if (i11 == 2) {
                        this.f45484w = kVar.b();
                    }
                }
                eVar.a("offset", this.f45484w + "");
                eVar.a("ad_type", "42");
                eVar.a(CampaignEx.JSON_KEY_AD_SOURCE_ID, i11 + "");
                if (!TextUtils.isEmpty(this.f45479r)) {
                    eVar.a(com.mbridge.msdk.foundation.same.net.h.e.f44661f, this.f45479r);
                }
                a aVar3 = new a();
                aVar3.a(b(this.f45468e));
                aVar3.setUnitId(this.f45473l);
                aVar3.setPlacementId(this.f45474m);
                aVar3.setAdType(42);
                aVar3.b(true);
                c cVar = new c(1, aVar3, i12, str);
                aVar3.a(cVar);
                aVar3.e(i12);
                aVar3.a(str);
                if (i12 == 0) {
                    if (!TextUtils.isEmpty(str)) {
                        eVar.a("token", str);
                    }
                    aVar2.choiceV3OrV5BySetting(1, eVar, aVar3, str);
                }
                if (i12 == 1) {
                    aVar2.getLoadOrSetting(1, com.mbridge.msdk.foundation.same.net.g.d.f().N, eVar, aVar3);
                }
                this.f45552a.postDelayed(cVar, j11);
            } catch (Exception e11) {
                String str3 = f45461f;
                ad.b(str3, com.mbridge.msdk.mbnative.b.a.a(e11));
                ad.b(str3, e11.getMessage());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void a(int i11, String str) {
        this.f45486y = false;
        this.f45487z = false;
        this.A = false;
        this.X = false;
        this.Q = str;
        this.f45470i.a(!TextUtils.isEmpty(str));
        this.M = null;
        Map<String, Long> map = f45460b;
        if (map != null && map.size() > 0) {
            f45460b.clear();
        }
        if (com.mbridge.msdk.mbnative.controller.d.b() != null && com.mbridge.msdk.mbnative.controller.d.b().containsKey(this.f45473l) && Boolean.TRUE.equals(com.mbridge.msdk.mbnative.controller.d.b().get(this.f45473l)) && i11 == 1 && a(i11)) {
            return;
        }
        String strK = com.mbridge.msdk.foundation.controller.c.m().k();
        String strB = com.mbridge.msdk.foundation.controller.c.m().b();
        if (this.f45468e.containsKey("app_id") && this.f45468e.containsKey(MBridgeConstans.APP_KEY) && this.f45468e.containsKey(MBridgeConstans.KEY_WORD)) {
            strK = (String) this.f45468e.get("app_id");
            strB = (String) this.f45468e.get(MBridgeConstans.APP_KEY);
        }
        this.f45469h.a(this.f45472k, strK, strB, this.f45473l);
        k kVarD = com.mbridge.msdk.c.h.a().d(strK, this.f45473l);
        this.T = kVarD;
        if (kVarD == null) {
            this.T = k.d(this.f45473l);
        }
        com.mbridge.msdk.mbnative.controller.d.e().put(this.f45473l, Integer.valueOf(this.T.w() * this.f45482u));
        this.f45466c = this.T.b();
        this.f45467d = this.T.c();
        this.W = this.T.e();
        this.V = this.T.d();
        this.f45482u = this.f45481t;
        List<Integer> list = this.f45466c;
        if (list == null || list.size() == 0) {
            com.mbridge.msdk.mbnative.d.a aVar = this.f45470i;
            if (aVar != null) {
                this.f45486y = true;
                aVar.onAdLoadError("do not have sorceList");
                return;
            }
            return;
        }
        try {
            if (com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.a(com.mbridge.msdk.foundation.controller.c.m().c())) {
                if (this.f45468e.containsKey(MBridgeConstans.NATIVE_INFO) && this.f45477p == null) {
                    String str2 = (String) this.f45468e.get(MBridgeConstans.NATIVE_INFO);
                    this.f45477p = str2;
                    if (str2 != null) {
                        try {
                            JSONArray jSONArray = new JSONArray(this.f45477p);
                            if (jSONArray.length() > 0) {
                                for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i12);
                                    int iOptInt = jSONObject.optInt("id", 0);
                                    if (2 == iOptInt) {
                                        this.Y = jSONObject.optInt("ad_num");
                                        if (this.W > 0) {
                                            jSONObject.remove("ad_num");
                                            jSONObject.put("ad_num", this.W);
                                        }
                                    } else if (3 == iOptInt) {
                                        this.Z = jSONObject.optInt("ad_num");
                                        if (this.W > 0) {
                                            jSONObject.remove("ad_num");
                                            jSONObject.put("ad_num", this.W);
                                        }
                                    }
                                }
                            }
                            this.K = Math.max(this.Y, this.Z);
                            this.f45477p = jSONArray.toString();
                        } catch (JSONException e11) {
                            ad.b(f45461f, com.mbridge.msdk.mbnative.b.a.a(e11));
                        }
                    }
                }
                if ((!this.f45466c.contains(1) || this.f45466c.get(0).intValue() == 1) && i11 == 0 && a(a(this.f45473l, this.f45482u, this.Q))) {
                    return;
                }
                this.f45463aa = true;
                if (this.f45466c.contains(1) && i11 == 0 && this.f45466c.get(0).intValue() != 1) {
                    int iIntValue = this.f45466c.get(0).intValue();
                    com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA = com.mbridge.msdk.mbnative.a.c.a(iIntValue);
                    if (iIntValue == 2 && this.f45468e.containsKey(MBridgeConstans.NATIVE_INFO)) {
                        this.f45482u = this.K;
                    } else {
                        this.f45482u = this.f45481t;
                    }
                    if (bVarA != null && a(a(iIntValue, d(bVarA.b(this.f45473l, this.f45482u))))) {
                        return;
                    }
                    this.f45463aa = false;
                    try {
                        a(this.f45467d.get(this.f45466c.indexOf(1)).intValue() * 1000, i11, false, this.f45473l, this.Q);
                    } catch (Exception unused) {
                    }
                }
                this.f45552a.sendEmptyMessageDelayed(1, this.T.u() * 1000);
                List<Integer> list2 = this.f45466c;
                if (list2 != null && list2.size() > 0) {
                    Queue<Integer> queue = this.f45475n;
                    if (queue != null && queue.size() > 0) {
                        this.f45475n.clear();
                    }
                    for (Integer num : this.f45466c) {
                        Queue<Integer> queue2 = this.f45475n;
                        if (queue2 != null) {
                            queue2.add(num);
                        }
                    }
                }
                List<Integer> list3 = this.f45467d;
                if (list3 != null && list3.size() > 0) {
                    Queue<Long> queue3 = this.f45476o;
                    if (queue3 != null && queue3.size() > 0) {
                        this.f45476o.clear();
                    }
                    for (Integer num2 : this.f45467d) {
                        Queue<Long> queue4 = this.f45476o;
                        if (queue4 != null) {
                            queue4.add(Long.valueOf(num2.intValue() * 1000));
                        }
                    }
                }
                b(i11, this.Q);
                return;
            }
        } catch (Exception unused2) {
        }
        com.mbridge.msdk.mbnative.d.a aVar2 = this.f45470i;
        if (aVar2 != null) {
            aVar2.onAdLoadError("webview is not available");
        }
    }

    public final void a(Campaign campaign, View view) {
        try {
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f45471j;
            if (nativeTrackingListener != null) {
                this.f45480s.a(nativeTrackingListener);
            }
            com.mbridge.msdk.mbnative.a.c.a(campaign.getType()).a(this.f45473l, campaign, this.Q);
            final CampaignEx campaignEx = (CampaignEx) campaign;
            com.mbridge.msdk.foundation.same.a.d.a(this.f45473l, campaignEx, "native");
            com.mbridge.msdk.widget.a aVar = new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.9
                @Override // com.mbridge.msdk.widget.a
                public final void a(View view2) {
                    NativeController.a(NativeController.this, view2.getContext(), campaignEx);
                }
            };
            try {
                int i11 = MBMediaView.f45890a0;
                a(view, aVar, MBMediaView.class);
            } catch (Throwable unused) {
                a(view, aVar, (Class) null);
            }
            if (!com.mbridge.msdk.f.b.a()) {
                a(view, (CampaignEx) campaign);
            }
            if (campaignEx.isReport()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(view);
            a(campaignEx, view, (List<View>) arrayList);
            ad.c(f45461f, "sendImpression" + campaignEx);
        } catch (Exception unused2) {
            ad.b(f45461f, "registerview exception!");
        }
    }

    public final void a(Campaign campaign, View view, List<View> list) {
        Class<MBMediaView> cls;
        try {
            a(view, (CampaignEx) campaign);
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f45471j;
            if (nativeTrackingListener != null) {
                this.f45480s.a(nativeTrackingListener);
            }
            com.mbridge.msdk.mbnative.a.c.a(campaign.getType()).a(this.f45473l, campaign, this.Q);
            final CampaignEx campaignEx = (CampaignEx) campaign;
            try {
                cls = MBMediaView.class;
                int i11 = MBMediaView.f45890a0;
            } catch (Throwable unused) {
                cls = null;
            }
            com.mbridge.msdk.foundation.same.a.d.a(this.f45473l, campaignEx, "native");
            if (view != null) {
                if (cls != null && cls.isInstance(view)) {
                    return;
                } else {
                    view.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.6
                        @Override // com.mbridge.msdk.widget.a
                        public final void a(View view2) {
                            NativeController.a(NativeController.this, view2.getContext(), campaignEx);
                        }
                    });
                }
            }
            if (list != null && list.size() > 0) {
                for (View view2 : list) {
                    if (cls != null && cls.isInstance(view2)) {
                        break;
                    } else {
                        view2.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.mbnative.controller.NativeController.7
                            @Override // com.mbridge.msdk.widget.a
                            public final void a(View view3) {
                                NativeController.a(NativeController.this, view3.getContext(), campaignEx);
                            }
                        });
                    }
                }
            }
            if (campaignEx.isReport()) {
                return;
            }
            a(campaignEx, view, list);
            Log.e(f45461f, "sendImpression" + campaignEx);
        } catch (Exception unused2) {
            ad.b(f45461f, "registerview exception!");
        }
    }

    public final void a(String str, int i11, String str2, CampaignEx campaignEx) {
        Queue<Integer> queue = this.f45475n;
        if ((queue == null || queue.size() > 0) && this.f45475n != null) {
            b(i11, str2);
            return;
        }
        com.mbridge.msdk.mbnative.d.a aVar = this.f45470i;
        if (aVar == null || this.f45486y) {
            return;
        }
        this.f45486y = true;
        aVar.a(campaignEx, str);
    }

    public final String b() {
        return this.R;
    }

    public final void b(Campaign campaign, View view) {
        b(campaign, view, null);
    }

    public final void b(Campaign campaign, View view, List<View> list) {
        Class<MBMediaView> cls;
        if (view != null && this.S != null) {
            try {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.S);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        if (campaign != null) {
            int type = campaign.getType();
            if (type == 1 || type == 2) {
                try {
                    cls = MBMediaView.class;
                    int i11 = MBMediaView.f45890a0;
                } catch (Throwable unused) {
                    cls = null;
                }
                if (list == null || list.size() <= 0) {
                    if (view != null) {
                        a(view, cls);
                    }
                } else {
                    Iterator<View> it = list.iterator();
                    while (it.hasNext()) {
                        a(it.next(), cls);
                    }
                }
            }
        }
    }

    public final String c() {
        ArrayList arrayList = new ArrayList();
        List<Campaign> list = this.f45464ab;
        if (list != null) {
            for (Campaign campaign : list) {
                CampaignEx campaignEx = new CampaignEx();
                campaignEx.setCreativeId(campaign.getCreativeId());
                arrayList.add(campaignEx);
            }
        }
        return com.mbridge.msdk.foundation.same.b.a(arrayList);
    }
}
