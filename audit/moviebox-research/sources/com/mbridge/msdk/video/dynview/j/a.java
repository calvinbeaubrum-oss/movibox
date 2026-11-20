package com.mbridge.msdk.video.dynview.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeImageView;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.ao;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.video.dynview.e.d;
import com.mbridge.msdk.video.dynview.e.e;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f47638j = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.i.c.b f47640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, Bitmap> f47641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f47642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f47643e = "#FFFFFFFF";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f47644f = "#60000000";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f47645g = "#FF5F5F5F";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f47646h = "#90ECECEC";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile long f47647i = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.i.c.a f47648k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f47649l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f47650m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.mbridge.msdk.video.dynview.d.a f47639a = new com.mbridge.msdk.video.dynview.d.a() { // from class: com.mbridge.msdk.video.dynview.j.a.1
        @Override // com.mbridge.msdk.video.dynview.d.a
        public final void a() {
            if (!a.this.f47649l || a.this.f47640b == null) {
                return;
            }
            a.this.f47640b.a(a.this.f47650m * 1000, a.this.f47648k);
            a.this.f47649l = false;
        }

        @Override // com.mbridge.msdk.video.dynview.d.a
        public final void b() {
            if (a.this.f47640b != null) {
                a.this.f47640b.b();
                a.this.f47649l = true;
            }
        }

        @Override // com.mbridge.msdk.video.dynview.d.a
        public final void c() {
            if (a.this.f47640b != null) {
                a.this.f47640b.b();
                a.this.f47649l = true;
            }
        }
    };

    /* JADX INFO: renamed from: com.mbridge.msdk.video.dynview.j.a$9, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass9 implements com.mbridge.msdk.foundation.same.c.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f47680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImageView f47681b;

        public AnonymousClass9(int i11, ImageView imageView) {
            this.f47680a = i11;
            this.f47681b = imageView;
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onFailedLoad(String str, String str2) {
            try {
                int iA = v.a(this.f47681b.getContext(), "mbridge_icon_play_bg", "drawable");
                this.f47681b.setBackgroundColor(Color.parseColor(a.this.f47645g));
                this.f47681b.setImageResource(iA);
                this.f47681b.setScaleType(ImageView.ScaleType.CENTER);
            } catch (Exception e11) {
                ad.a("DataEnergizeWrapper", e11.getMessage());
            }
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onSuccessLoad(final Bitmap bitmap, String str) {
            if (bitmap == null || bitmap.isRecycled()) {
                int iA = v.a(this.f47681b.getContext(), "mbridge_icon_play_bg", "drawable");
                this.f47681b.setBackgroundColor(Color.parseColor(a.this.f47645g));
                this.f47681b.setImageResource(iA);
                this.f47681b.setScaleType(ImageView.ScaleType.CENTER);
                return;
            }
            int i11 = this.f47680a;
            if (i11 != 501 && i11 != 802) {
                this.f47681b.setImageBitmap(bitmap);
            } else {
                com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.video.dynview.j.a.9.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            final Bitmap bitmapA = o.a(bitmap, 10);
                            AnonymousClass9.this.f47681b.post(new Runnable() { // from class: com.mbridge.msdk.video.dynview.j.a.9.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    AnonymousClass9.this.f47681b.setImageBitmap(bitmapA);
                                }
                            });
                        } catch (Exception e11) {
                            ad.b("DataEnergizeWrapper", e11.getMessage());
                        }
                    }
                });
            }
        }
    }

    private int a(boolean z11, String str) {
        try {
            if (!z11) {
                return v.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, "id");
            }
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return str.hashCode();
        } catch (Exception e11) {
            ad.b("DataEnergizeWrapper", e11.getMessage());
            return -1;
        }
    }

    private Bitmap a() {
        Bitmap bitmapCreateBitmap = null;
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_4444);
            bitmapCreateBitmap.eraseColor(Color.parseColor(this.f47646h));
            return bitmapCreateBitmap;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return bitmapCreateBitmap;
            }
            e11.printStackTrace();
            return bitmapCreateBitmap;
        }
    }

    private void a(ImageView imageView, String str, int i11) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        com.mbridge.msdk.foundation.same.c.b.a(imageView.getContext()).a(str, new AnonymousClass9(i11, imageView));
    }

    private void a(com.mbridge.msdk.video.dynview.c cVar, View view) {
        com.mbridge.msdk.video.dynview.g.a.C0524a c0524aA = com.mbridge.msdk.video.dynview.g.a.a();
        c0524aA.a(cVar.e()).a(true);
        if (cVar.e() != 2 || cVar.d() > cVar.c()) {
            c0524aA.a(cVar.d()).b(cVar.c());
        } else {
            c0524aA.a(cVar.c()).b(cVar.d());
        }
        if (view.getBackground() == null) {
            view.setBackground(c0524aA.a());
        }
    }

    public static /* synthetic */ void a(a aVar, com.mbridge.msdk.video.dynview.c cVar, View view) {
        Map<String, Bitmap> map = aVar.f47641c;
        if (map == null || map.size() <= 1) {
            return;
        }
        new com.mbridge.msdk.video.dynview.h.b();
        Map<String, Bitmap> map2 = aVar.f47641c;
        if (view != null) {
            com.mbridge.msdk.video.dynview.i.a.a.a().a(map2, cVar, view);
        }
    }

    public static /* synthetic */ void a(a aVar, Map map) {
        if (map != null) {
            try {
                if (map.containsKey("order_view_callback") && (map.get("order_view_callback") instanceof com.mbridge.msdk.video.dynview.e.c)) {
                    ((com.mbridge.msdk.video.dynview.e.c) map.get("order_view_callback")).a();
                    aVar.b();
                }
            } catch (Exception e11) {
                ad.b("DataEnergizeWrapper", e11.getMessage());
            }
        }
    }

    public static /* synthetic */ void a(a aVar, Map map, List list, int i11) {
        if (map == null || list == null || list.size() <= 1) {
            return;
        }
        if (!map.containsKey("choice_one_callback") || !(map.get("choice_one_callback") instanceof d)) {
            if (map.containsKey("order_view_callback") && (map.get("order_view_callback") instanceof com.mbridge.msdk.video.dynview.e.c)) {
                com.mbridge.msdk.video.dynview.e.c cVar = (com.mbridge.msdk.video.dynview.e.c) map.get("order_view_callback");
                if (cVar != null) {
                    cVar.a((CampaignEx) list.get(i11), i11);
                }
                aVar.b();
                return;
            }
            return;
        }
        d dVar = (d) map.get("choice_one_callback");
        if (dVar != null) {
            dVar.a((CampaignEx) list.get(i11));
            try {
                CampaignEx campaignEx = (CampaignEx) list.get(i11);
                com.mbridge.msdk.foundation.same.report.d.d dVar2 = new com.mbridge.msdk.foundation.same.report.d.d();
                dVar2.a("click", "0");
                dVar2.a("time", Long.valueOf(aVar.f47647i));
                dVar2.a("choose_cid", campaignEx.getId());
                dVar2.a(RequestParameters.POSITION, Integer.valueOf(i11));
                dVar2.a("type", "choseFromTwoSelect");
                com.mbridge.msdk.video.module.b.a.a("2000103", campaignEx, dVar2);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }
        aVar.b();
    }

    private void a(String str, ImageView imageView) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        a(imageView, str, -1);
    }

    private void a(final String str, final ImageView imageView, final com.mbridge.msdk.video.dynview.c cVar, final View view) {
        com.mbridge.msdk.foundation.same.c.b.a(imageView.getContext()).a(str, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.video.dynview.j.a.10
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str2, String str3) {
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str2) {
                ImageView imageView2;
                if (bitmap == null || bitmap.isRecycled() || (imageView2 = imageView) == null) {
                    return;
                }
                imageView2.setImageBitmap(bitmap);
                if (a.this.f47641c != null) {
                    a.this.f47641c.put(SameMD5.getMD5(str), bitmap);
                    a.a(a.this, cVar, view);
                }
            }
        });
        try {
            Bitmap bitmapA = a();
            if (bitmapA == null || bitmapA.isRecycled()) {
                return;
            }
            a(cVar, view);
        } catch (Exception e11) {
            ad.b("DataEnergizeWrapper", e11.getMessage());
        }
    }

    private void b() {
        com.mbridge.msdk.video.dynview.i.a.a.a().b();
        com.mbridge.msdk.video.dynview.i.c.b bVar = this.f47640b;
        if (bVar != null) {
            bVar.b();
            this.f47640b = null;
        }
        com.mbridge.msdk.video.dynview.b.a.a().f47541a = null;
        if (this.f47639a != null) {
            this.f47639a = null;
        }
        Map<String, Bitmap> map = this.f47641c;
        if (map != null) {
            if (map.entrySet() != null) {
                try {
                    Iterator<Map.Entry<String, Bitmap>> it = this.f47641c.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<String, Bitmap> next = it.next();
                        if (next != null && next.getValue() != null && !next.getValue().isRecycled()) {
                            next.getValue().recycle();
                        }
                        it.remove();
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            this.f47641c.clear();
        }
    }

    public static /* synthetic */ void b(a aVar, Map map) {
        if (map != null) {
            try {
                if (map.containsKey("choice_one_callback") && (map.get("choice_one_callback") instanceof d)) {
                    ((d) map.get("choice_one_callback")).a();
                    aVar.b();
                }
            } catch (Exception e11) {
                ad.b("DataEnergizeWrapper", e11.getMessage());
            }
        }
    }

    public final void a(com.mbridge.msdk.video.dynview.c cVar, View view, e eVar) {
        if (eVar == null) {
            return;
        }
        if (cVar == null) {
            eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
            return;
        }
        try {
            ImageView imageView = (ImageView) view.findViewById(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_iv_adbanner_bg", "id"));
            if (imageView != null) {
                imageView.setBackgroundColor(Color.parseColor(this.f47646h));
            }
            ImageView imageView2 = (ImageView) view.findViewById(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_iv_adbanner", "id"));
            if (imageView2 != null) {
                imageView2.setBackgroundColor(Color.parseColor(this.f47646h));
            }
            eVar.a(view, new ArrayList());
        } catch (Exception e11) {
            ad.a("DataEnergizeWrapper", e11.getMessage());
            eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:71:0x0278  */
    public final void a(com.mbridge.msdk.video.dynview.c cVar, View view, final Map map, e eVar) {
        CampaignEx campaignEx;
        final CampaignEx campaignEx2;
        RoundImageView roundImageView;
        RoundImageView roundImageView2;
        ImageView imageView;
        ImageView imageView2;
        int i11;
        int i12;
        if (this.f47641c == null) {
            this.f47641c = new HashMap();
        }
        final List<CampaignEx> listG = cVar.g();
        if (view == null) {
            eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_ROOTVIEW);
            return;
        }
        Context context = view.getContext();
        if (context == null) {
            eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_CONTEXT);
            return;
        }
        if (listG == null || listG.size() <= 1) {
            campaignEx = null;
            campaignEx2 = null;
        } else {
            CampaignEx campaignEx3 = listG.get(0);
            campaignEx3.setShowIndex(1);
            campaignEx = listG.get(1);
            campaignEx.setShowIndex(2);
            campaignEx2 = campaignEx3;
        }
        if (campaignEx2 == null && eVar != null) {
            eVar.a(com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL);
            return;
        }
        if (campaignEx == null && eVar != null) {
            eVar.a(com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL);
            return;
        }
        if (map != null && map.containsKey("is_dy_success")) {
            f47638j = ((Boolean) map.get("is_dy_success")).booleanValue();
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(a(f47638j, "mbridge_top_item_rl"));
        MBridgeImageView mBridgeImageView = (MBridgeImageView) view.findViewById(a(f47638j, "mbridge_top_iv"));
        MBRotationView mBRotationView = (MBRotationView) view.findViewById(a(f47638j, "mbridge_top_ration"));
        TextView textView = (TextView) view.findViewById(a(f47638j, "mbridge_top_title_tv"));
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(a(f47638j, "mbridge_bottom_item_rl"));
        MBRotationView mBRotationView2 = (MBRotationView) view.findViewById(a(f47638j, "mbridge_bottom_ration"));
        MBridgeImageView mBridgeImageView2 = (MBridgeImageView) view.findViewById(a(f47638j, "mbridge_bottom_iv"));
        boolean z11 = f47638j;
        if (z11) {
            imageView = (MBCusRoundImageView) view.findViewById(a(z11, "mbridge_top_icon_iv"));
            imageView2 = (MBCusRoundImageView) view.findViewById(a(f47638j, "mbridge_bottom_icon_iv"));
            roundImageView2 = null;
            roundImageView = null;
        } else {
            RoundImageView roundImageView3 = (RoundImageView) view.findViewById(a(z11, "mbridge_top_icon_iv"));
            roundImageView = (RoundImageView) view.findViewById(a(f47638j, "mbridge_bottom_icon_iv"));
            roundImageView2 = roundImageView3;
            imageView = null;
            imageView2 = null;
        }
        CampaignEx campaignEx4 = campaignEx;
        TextView textView2 = (TextView) view.findViewById(a(f47638j, "mbridge_bottom_title_tv"));
        ImageView imageView3 = (ImageView) view.findViewById(a(f47638j, "mbridge_reward_choice_one_like_iv"));
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.dynview.j.a.4
                @Override // com.mbridge.msdk.widget.a
                public final void a(View view2) {
                    if (a.this.f47642d) {
                        return;
                    }
                    a.this.f47642d = true;
                    a.a(a.this, map, listG, 0);
                }
            });
        }
        if (mBridgeImageView != null) {
            mBridgeImageView.setCustomBorder(20, 20, 0, 0, 10, ViewCompat.MEASURED_STATE_MASK);
            a(campaignEx2.getImageUrl(), mBridgeImageView, cVar, view);
            if (mBRotationView != null) {
                if (!campaignEx2.getCanStart2C1Anim()) {
                    imageView3 = imageView3;
                    i11 = 0;
                    mBRotationView.setWidthRatio(1.0f);
                    mBRotationView.setHeightRatio(1.0f);
                    mBRotationView.setAutoscroll(false);
                } else if (TextUtils.isEmpty(campaignEx2.getIconUrl())) {
                    imageView3 = imageView3;
                    mBRotationView.setWidthRatio(1.0f);
                    mBRotationView.setHeightRatio(1.0f);
                    i11 = 0;
                    mBRotationView.setAutoscroll(false);
                } else {
                    ImageView imageView4 = new ImageView(cVar.a());
                    imageView4.setLayoutParams(new FrameLayout.LayoutParams(-1, ai.a(cVar.a(), 200.0f)));
                    imageView4.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    mBRotationView.addView(imageView4);
                    a(campaignEx2.getIconUrl(), imageView4);
                    mBRotationView.setWidthRatio(0.45f);
                    mBRotationView.setHeightRatio(0.9f);
                    mBRotationView.setAutoscroll(true);
                }
            }
            i11 = 0;
        } else {
            i11 = 0;
        }
        if (roundImageView2 != null) {
            roundImageView2.setType(i11);
            a(campaignEx2.getIconUrl(), roundImageView2);
        }
        if (imageView != null) {
            a(campaignEx2.getIconUrl(), imageView);
        }
        if (textView != null) {
            if (TextUtils.isEmpty(campaignEx2.getAppName())) {
                textView.setVisibility(8);
            } else {
                textView.setText(campaignEx2.getAppName());
            }
        }
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.dynview.j.a.5
                @Override // com.mbridge.msdk.widget.a
                public final void a(View view2) {
                    if (a.this.f47642d) {
                        return;
                    }
                    a.this.f47642d = true;
                    a.a(a.this, map, listG, 1);
                }
            });
        }
        if (mBridgeImageView2 != null) {
            mBridgeImageView2.setCustomBorder(20, 20, 0, 0, 10, ViewCompat.MEASURED_STATE_MASK);
            a(campaignEx4.getImageUrl(), mBridgeImageView2, cVar, view);
            if (mBRotationView2 == null) {
                i12 = 0;
            } else if (!campaignEx4.getCanStart2C1Anim()) {
                i12 = 0;
                mBRotationView2.setWidthRatio(1.0f);
                mBRotationView2.setHeightRatio(1.0f);
                mBRotationView2.setAutoscroll(false);
            } else if (TextUtils.isEmpty(campaignEx4.getIconUrl())) {
                mBRotationView2.setWidthRatio(1.0f);
                mBRotationView2.setHeightRatio(1.0f);
                i12 = 0;
                mBRotationView2.setAutoscroll(false);
            } else {
                ImageView imageView5 = new ImageView(cVar.a());
                imageView5.setLayoutParams(new FrameLayout.LayoutParams(-1, ai.a(cVar.a(), 200.0f)));
                imageView5.setScaleType(ImageView.ScaleType.CENTER_CROP);
                mBRotationView2.addView(imageView5);
                a(campaignEx4.getIconUrl(), imageView5);
                mBRotationView2.setWidthRatio(0.45f);
                mBRotationView2.setHeightRatio(0.9f);
                mBRotationView2.setAutoscroll(true);
                i12 = 0;
            }
        } else {
            i12 = 0;
        }
        if (roundImageView != null) {
            RoundImageView roundImageView4 = roundImageView;
            roundImageView4.setType(i12);
            a(campaignEx4.getIconUrl(), roundImageView4);
        }
        if (imageView2 != null) {
            a(campaignEx4.getIconUrl(), imageView2);
        }
        if (textView2 != null) {
            textView2.setText(campaignEx4.getAppName());
        }
        String cMPTEntryUrl = campaignEx2.getCMPTEntryUrl();
        cVar.e();
        String strA = ao.a(cMPTEntryUrl, "cltp");
        final String strA2 = ao.a(cMPTEntryUrl, "xt");
        long j11 = !TextUtils.isEmpty(strA) ? Long.parseLong(strA) : 0L;
        if (j11 != 0) {
            if (map != null && map.containsKey("is_dy_success")) {
                f47638j = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            final TextView textView3 = (TextView) view.findViewById(a(f47638j, "mbridge_choice_one_countdown_tv"));
            if (textView3 != null) {
                textView3.setTextSize(11.0f);
                textView3.setTextColor(Color.parseColor(this.f47643e));
                String str = this.f47644f;
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor(str));
                gradientDrawable.setCornerRadius(ai.a(textView3.getContext(), 12));
                gradientDrawable.setStroke(ai.a(textView3.getContext(), 1), Color.parseColor(str));
                textView3.setBackground(gradientDrawable);
                textView3.setVisibility(0);
                textView3.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.dynview.j.a.11
                    @Override // com.mbridge.msdk.widget.a
                    public final void a(View view2) {
                        if (a.this.f47642d) {
                            return;
                        }
                        a.this.f47642d = true;
                        campaignEx2.setShowType(2);
                        a.b(a.this, map);
                    }
                });
                final CampaignEx campaignEx5 = campaignEx2;
                this.f47648k = new com.mbridge.msdk.video.dynview.i.c.a() { // from class: com.mbridge.msdk.video.dynview.j.a.2
                    @Override // com.mbridge.msdk.video.dynview.i.c.a
                    public final void a() {
                        campaignEx5.setShowType(1);
                        a.b(a.this, map);
                    }

                    @Override // com.mbridge.msdk.video.dynview.i.c.a
                    public final void a(long j12) {
                        String str2;
                        a.this.f47650m = (int) (j12 / 1000);
                        long j13 = a.this.f47650m;
                        String strS = z.s(textView3.getContext());
                        if (strS.startsWith("zh")) {
                            if (strS.contains("TW") || strS.contains("HK")) {
                                str2 = j13 + " 秒後自動播放";
                            } else {
                                str2 = j13 + " 秒后自动播放";
                            }
                        } else if (strS.startsWith("ja")) {
                            str2 = j13 + " 秒後自動的に再生 ";
                        } else if (strS.startsWith(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR)) {
                            str2 = "Automatische Wiedergabe nach " + j13 + " Sekunden";
                        } else if (strS.startsWith("ko")) {
                            str2 = j13 + " 초 후 자동 재생 ";
                        } else if (strS.startsWith("fr")) {
                            str2 = "Lecture de vidéo dans " + j13 + " secondes";
                        } else if (strS.startsWith("ar")) {
                            str2 = " ثوان" + j13 + "لعب تلقائيا بعد ";
                        } else if (strS.startsWith("ru")) {
                            str2 = "Автовоспроизведение через " + j13 + " секунд";
                        } else {
                            str2 = "Auto play after " + j13 + " s";
                        }
                        textView3.setText(str2);
                        a.this.f47647i++;
                        if (TextUtils.isEmpty(strA2) || !strA2.equals("1")) {
                            return;
                        }
                        com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                        dVar.a("type", "choseFromTwoHeartbeat");
                        dVar.a("xtSecond", "countTimeForReport");
                        dVar.a("autoPlayCountDownTime", "mLeftOverCountTime");
                        com.mbridge.msdk.video.module.b.a.a("2000103", campaignEx5, dVar);
                    }
                };
                com.mbridge.msdk.video.dynview.i.c.b bVarA = new com.mbridge.msdk.video.dynview.i.c.b().b(j11 * 1000).a(1000L).a(this.f47648k);
                this.f47640b = bVarA;
                bVarA.a();
            }
            ImageView imageView6 = (ImageView) view.findViewById(a(f47638j, "mbridge_iv_link"));
            if (campaignEx2.getAdchoice() != null) {
                campaignEx2.getAdchoice().b("");
            }
            ai.a(4, imageView6, campaignEx2, com.mbridge.msdk.foundation.controller.c.m().c(), false, new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.video.dynview.j.a.3
                @Override // com.mbridge.msdk.foundation.d.a
                public final void a() {
                    if (a.this.f47640b != null) {
                        a.this.f47640b.b();
                        a.this.f47649l = true;
                    }
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void a(String str2) {
                    if (!a.this.f47649l || a.this.f47640b == null) {
                        return;
                    }
                    a.this.f47640b.a(a.this.f47650m * 1000, a.this.f47648k);
                    a.this.f47649l = false;
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void b() {
                    if (!a.this.f47649l || a.this.f47640b == null) {
                        return;
                    }
                    a.this.f47640b.a(a.this.f47650m * 1000, a.this.f47648k);
                    a.this.f47649l = false;
                }
            });
        } else {
            imageView3 = imageView3;
        }
        if (imageView3 != null) {
            if (cVar.e() == 1) {
                imageView3.setImageResource(v.a(context.getApplicationContext(), com.mbridge.msdk.video.dynview.i.a.a(context, 1), "drawable"));
            } else {
                imageView3.setImageResource(v.a(context.getApplicationContext(), com.mbridge.msdk.video.dynview.i.a.a(context, 2), "drawable"));
            }
        }
        if (eVar != null) {
            eVar.a(view, null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:83:0x0191 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x0193  */
    public final void b(com.mbridge.msdk.video.dynview.c cVar, View view, Map map, e eVar) {
        if (eVar == null) {
            return;
        }
        if (cVar == null) {
            eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
            return;
        }
        if (map != null && map.containsKey("is_dy_success")) {
            f47638j = ((Boolean) map.get("is_dy_success")).booleanValue();
        }
        boolean z11 = f47638j;
        LinearLayout linearLayout = z11 ? (LinearLayout) view.findViewById(a(z11, "mbridge_reward_heat_mllv")) : null;
        ImageView imageView = (ImageView) view.findViewById(a(f47638j, "mbridge_reward_icon_riv"));
        TextView textView = (TextView) view.findViewById(a(f47638j, "mbridge_reward_title_tv"));
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(a(f47638j, "mbridge_reward_stars_mllv"));
        TextView textView2 = (TextView) view.findViewById(a(f47638j, "mbridge_reward_click_tv"));
        ImageView imageView2 = (ImageView) view.findViewById(a(f47638j, "mbridge_videoview_bg"));
        TextView textView3 = (TextView) view.findViewById(a(f47638j, "mbridge_reward_desc_tv"));
        View view2 = (RelativeLayout) view.findViewById(a(f47638j, "mbridge_reward_bottom_layout"));
        List<View> arrayList = new ArrayList<>();
        List<CampaignEx> listG = cVar.g();
        if (listG == null || listG.size() <= 0) {
            eVar.a(com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL);
            return;
        }
        CampaignEx campaignEx = listG.get(0);
        if (campaignEx == null) {
            eVar.a(com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL);
            return;
        }
        if (imageView != null) {
            if (!f47638j) {
                ((RoundImageView) imageView).setBorderRadius(10);
            } else if (imageView instanceof MBCusRoundImageView) {
                ((MBCusRoundImageView) imageView).setCustomBorder(30, 30, 30, 30, 10, -1);
            }
            a(campaignEx.getIconUrl(), imageView);
        }
        if (textView != null) {
            textView.setText(campaignEx.getAppName());
        }
        if (textView3 != null) {
            textView3.setText(campaignEx.getAppDesc());
        }
        if (linearLayout2 != null) {
            double rating = campaignEx.getRating();
            if (rating <= 0.0d) {
                rating = 5.0d;
            }
            if (f47638j) {
                if (linearLayout2 instanceof MBStarLevelLayoutView) {
                    MBStarLevelLayoutView mBStarLevelLayoutView = (MBStarLevelLayoutView) linearLayout2;
                    mBStarLevelLayoutView.setRating((int) rating);
                    mBStarLevelLayoutView.setOrientation(0);
                }
                if (linearLayout != null && (linearLayout instanceof MBHeatLevelLayoutView)) {
                    ((MBHeatLevelLayoutView) linearLayout).setHeatCount(campaignEx.getNumberRating());
                }
            } else {
                ((MBridgeLevelLayoutView) linearLayout2).setRatingAndUser(rating, campaignEx.getNumberRating());
            }
        }
        if (textView2 != null) {
            textView2.setText(campaignEx.getAdCall());
        }
        int i11 = cVar.i();
        if (i11 == 102 || i11 == 202 || i11 == 302) {
            if (textView2 != null) {
                arrayList.add(textView2);
            }
        } else if (i11 == 802) {
            if (imageView != null) {
                arrayList.add(imageView);
            }
            if (textView2 != null) {
                arrayList.add(textView2);
            }
            a(imageView2, campaignEx.getImageUrl(), i11);
        } else if (i11 != 902) {
            if (i11 != 904) {
                if (i11 == 5002010) {
                    if (cVar.k() && view2 != null && view2.getVisibility() == 0) {
                        arrayList.add(view2);
                    } else {
                        if (imageView != null) {
                            arrayList.add(imageView);
                        }
                        if (textView2 != null) {
                            arrayList.add(textView2);
                        }
                    }
                }
            } else if (cVar.k()) {
                arrayList.add(view);
            }
        } else if (textView2 != null) {
            arrayList.add(textView2);
        }
        eVar.a(view, arrayList);
    }

    public final void c(com.mbridge.msdk.video.dynview.c cVar, View view, final Map map, e eVar) {
        try {
            if (this.f47641c == null) {
                this.f47641c = new HashMap();
            }
            final List<CampaignEx> listG = cVar.g();
            if (view.getContext() == null) {
                eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_CONTEXT);
                return;
            }
            if (map != null && map.containsKey("is_dy_success")) {
                f47638j = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            for (CampaignEx campaignEx : listG) {
                if (campaignEx != null) {
                    campaignEx.setECTemplateRenderSucc(f47638j);
                }
            }
            ListView listView = (ListView) view.findViewById(a(f47638j, "mbridge_order_view_lv"));
            GridView gridView = (GridView) view.findViewById(a(f47638j, "mbridge_order_view_h_lv"));
            ImageView imageView = (ImageView) view.findViewById(a(f47638j, "mbridge_order_view_iv_close"));
            com.mbridge.msdk.video.dynview.ordercamp.a.a aVar = new com.mbridge.msdk.video.dynview.ordercamp.a.a(listG);
            if (cVar.e() == 1) {
                if (listView != null) {
                    try {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) listView.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.height = -1;
                            float fC = (cVar.c() - ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 720.0f)) / 2.0f;
                            int iA = ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 10.0f);
                            int i11 = (int) fC;
                            layoutParams.setMargins(iA, i11, iA, i11);
                            listView.setLayoutParams(layoutParams);
                        }
                    } catch (Exception e11) {
                        ad.b("DataEnergizeWrapper", e11.getMessage());
                    }
                    listView.setAdapter((ListAdapter) aVar);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.mbridge.msdk.video.dynview.j.a.6
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView<?> adapterView, View view2, int i12, long j11) {
                            a.a(a.this, map, listG, i12);
                        }
                    });
                }
            } else if (gridView != null) {
                int iD = (int) cVar.d();
                int size = iD / listG.size();
                int i12 = size / 9;
                int i13 = i12 / 2;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gridView.getLayoutParams();
                layoutParams2.width = iD - (i12 * 2);
                gridView.setLayoutParams(layoutParams2);
                gridView.setColumnWidth((size - i12) - (i13 / 2));
                gridView.setHorizontalSpacing(i13);
                gridView.setStretchMode(0);
                gridView.setNumColumns(listG.size());
                gridView.setAdapter((ListAdapter) aVar);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.mbridge.msdk.video.dynview.j.a.7
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView<?> adapterView, View view2, int i14, long j11) {
                        a.a(a.this, map, listG, i14);
                    }
                });
            }
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.dynview.j.a.8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        a.a(a.this, map);
                    }
                });
            }
            if (eVar != null) {
                eVar.a(view, null);
            }
        } catch (Exception unused) {
            if (eVar != null) {
                eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
            }
        }
    }
}
