package com.mbridge.msdk.foundation.d;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f44148a = -2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f44149b = -2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f44150c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RelativeLayout.LayoutParams f44151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<String, com.mbridge.msdk.foundation.d.a.a> f44152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private g f44153f;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f44154a = new b();
    }

    private b() {
        this.f44151d = new RelativeLayout.LayoutParams(f44149b, f44148a);
        this.f44152e = new ConcurrentHashMap<>();
    }

    public static b a() {
        return a.f44154a;
    }

    private boolean a(Context context, MBFeedBackDialog mBFeedBackDialog) {
        Activity activityA = a(context);
        if (activityA == null || mBFeedBackDialog == null || activityA.isDestroyed()) {
            return false;
        }
        try {
            if (mBFeedBackDialog.isShowing() || activityA.isFinishing()) {
                return false;
            }
            mBFeedBackDialog.show();
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    private com.mbridge.msdk.foundation.d.a.a d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = c.m().k();
        }
        if (this.f44152e.containsKey(str)) {
            return this.f44152e.get(str);
        }
        return null;
    }

    public final Activity a(Context context) {
        Activity activity;
        Context contextE = c.m().e();
        Activity activity2 = null;
        try {
            Activity activity3 = contextE instanceof Activity ? (Activity) contextE : null;
            try {
                if ((context instanceof Activity) && !((Activity) context).isDestroyed()) {
                    activity3 = (Activity) context;
                }
                WeakReference<Activity> weakReferenceA = c.m().a();
                if (weakReferenceA != null && (activity = weakReferenceA.get()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                    activity3 = activity;
                }
                if (activity3 == null || activity3.isFinishing() || activity3.isDestroyed()) {
                    return null;
                }
                return activity3;
            } catch (Exception e11) {
                e = e11;
                activity2 = activity3;
                e.printStackTrace();
                return activity2;
            }
        } catch (Exception e12) {
            e = e12;
        }
    }

    public final com.mbridge.msdk.foundation.d.a.a a(String str) {
        com.mbridge.msdk.foundation.d.a.a aVar;
        if (TextUtils.isEmpty(str)) {
            str = c.m().k();
        }
        if (this.f44152e.containsKey(str)) {
            aVar = this.f44152e.get(str);
        } else {
            aVar = new com.mbridge.msdk.foundation.d.a.a(str);
            this.f44152e.put(str, aVar);
        }
        if (aVar != null) {
            return aVar;
        }
        com.mbridge.msdk.foundation.d.a.a aVar2 = new com.mbridge.msdk.foundation.d.a.a(str);
        this.f44152e.put(str, aVar2);
        return aVar2;
    }

    public final void a(String str, int i11) {
        a(str).a(i11);
    }

    public final void a(String str, int i11, int i12, int i13, float f11, float f12, float f13, String str2, String str3, float f14, JSONArray jSONArray) {
        com.mbridge.msdk.foundation.d.a.a aVarA = a(str);
        Context contextC = c.m().c();
        aVarA.a(ai.a(contextC, f11), ai.a(contextC, f12), ai.a(contextC, i11), ai.a(contextC, i12), ai.a(contextC, i13), f13, str2, str3, f14, jSONArray);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x006e A[PHI: r2
  0x006e: PHI (r2v8 com.mbridge.msdk.foundation.d.a.a) = 
  (r2v7 com.mbridge.msdk.foundation.d.a.a)
  (r2v11 com.mbridge.msdk.foundation.d.a.a)
  (r2v14 com.mbridge.msdk.foundation.d.a.a)
 binds: [B:5:0x0035, B:7:0x004e, B:9:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    public final void a(String str, int i11, int i12, String str2, String str3) {
        com.mbridge.msdk.foundation.d.a.a aVarD = d(str + "_1");
        if (aVarD == null) {
            aVarD = d(str + "_2");
            if (aVarD == null) {
                aVarD = d(str + "_3");
                if (aVarD == null) {
                    aVarD = d(str + "_4");
                    if (aVarD == null) {
                        aVarD = a(str);
                    } else {
                        aVarD.b(0);
                    }
                } else {
                    aVarD.b(0);
                }
            } else {
                aVarD.b(0);
            }
        }
        if (aVarD != null) {
            CampaignEx campaignExC = aVarD.c();
            q.a(campaignExC, campaignExC != null ? campaignExC.getCampaignUnitId() : "", aVarD.g(), aVarD.f(), !TextUtils.isEmpty(str2) ? str2 : "", i11, campaignExC != null ? campaignExC.getAdType() : 0, i12, str3);
        }
    }

    public final void a(String str, int i11, ViewGroup viewGroup) {
        com.mbridge.msdk.foundation.d.a.a aVarA = a(str);
        if (aVarA.d() != null) {
            aVarA.c(i11);
            if (i11 == 0) {
                a(str, c.m().c(), viewGroup, (ViewGroup.LayoutParams) null, (com.mbridge.msdk.foundation.d.a) null);
            }
        }
    }

    public final void a(String str, int i11, com.mbridge.msdk.foundation.d.a aVar) {
        com.mbridge.msdk.foundation.d.a.a aVarA = a(str);
        aVarA.a(new com.mbridge.msdk.foundation.d.a.a.C0485a(str, aVar));
        if (i11 == 1) {
            aVarA.b();
        } else {
            aVarA.e();
        }
    }

    public final void a(String str, Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, com.mbridge.msdk.foundation.d.a aVar) {
        if (b()) {
            com.mbridge.msdk.foundation.d.a.a aVarA = a(str);
            if (aVar != null) {
                aVarA.a(new com.mbridge.msdk.foundation.d.a.a.C0485a(str, aVar));
            }
            FeedBackButton feedBackButtonD = aVarA.d();
            if (feedBackButtonD != null) {
                if (layoutParams == null) {
                    int iA = ai.a(c.m().c(), 10.0f);
                    this.f44151d.setMargins(iA, iA, iA, iA);
                    layoutParams = this.f44151d;
                }
                ViewGroup viewGroup2 = (ViewGroup) feedBackButtonD.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(feedBackButtonD);
                }
                Activity activityA = a(context);
                if (activityA != null && viewGroup == null) {
                    viewGroup = (ViewGroup) activityA.findViewById(R.id.content);
                }
                if (viewGroup != null) {
                    viewGroup.removeView(feedBackButtonD);
                    viewGroup.addView(feedBackButtonD, layoutParams);
                }
            }
        }
    }

    public final void a(String str, com.mbridge.msdk.foundation.d.a aVar) {
        com.mbridge.msdk.foundation.d.a.a aVarA = a(str);
        if (aVar != null) {
            aVarA.a(new com.mbridge.msdk.foundation.d.a.a.C0485a(str, aVar));
        }
    }

    public final void a(String str, CampaignEx campaignEx) {
        a(str).a(campaignEx);
    }

    public final void a(String str, FeedBackButton feedBackButton) {
        a(str).a(feedBackButton);
    }

    public final void a(String str, String str2) {
        a(str).a(str2);
    }

    public final boolean a(String str, Context context, MBFeedBackDialog mBFeedBackDialog) {
        if (mBFeedBackDialog != null) {
            return a(context, mBFeedBackDialog);
        }
        ad.c("", "mbAlertDialog  is null");
        return false;
    }

    public final FeedBackButton b(String str) {
        return a(str).d();
    }

    public final void b(String str, int i11) {
        a(str).b(i11);
    }

    public final boolean b() {
        g gVarB = h.a().b(c.m().k());
        this.f44153f = gVarB;
        if (gVarB != null) {
            return false;
        }
        h.a();
        this.f44153f = i.a();
        return false;
    }

    public final void c(String str) {
        try {
            com.mbridge.msdk.foundation.d.a.a aVarD = d(str);
            if (aVarD != null) {
                aVarD.a();
            }
            this.f44152e.remove(str);
            f44150c = false;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
