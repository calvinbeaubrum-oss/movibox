package com.mbridge.msdk.video.dynview.ordercamp.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.dycreator.baseview.MBFrameLayout;
import com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeImageView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeTextView;
import com.mbridge.msdk.dycreator.wrapper.DyAdType;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.n;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.io.File;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f47737a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C0527a f47738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<CampaignEx> f47739c;

    /* JADX INFO: renamed from: com.mbridge.msdk.video.dynview.ordercamp.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0527a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        RelativeLayout f47743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        MBRotationView f47744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        MBridgeImageView f47745c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        RoundImageView f47746d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        TextView f47747e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        TextView f47748f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        TextView f47749g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        TextView f47750h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        MBridgeLevelLayoutView f47751i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        ImageView f47752j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        ImageView f47753k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        MBCusRoundImageView f47754l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        MBCusRoundImageView f47755m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        MBStarLevelLayoutView f47756n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        MBHeatLevelLayoutView f47757o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        MBFrameLayout f47758p;
    }

    public a(List<CampaignEx> list) {
        this.f47739c = list;
    }

    private int a(String str) {
        return v.a(c.m().c().getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }

    private View a() {
        View viewInflate = LayoutInflater.from(c.m().c()).inflate(a("mbridge_order_layout_item"), (ViewGroup) null);
        C0527a c0527a = new C0527a();
        this.f47738b = c0527a;
        c0527a.f47745c = (MBridgeImageView) viewInflate.findViewById(b("mbridge_lv_iv"));
        this.f47738b.f47753k = (ImageView) viewInflate.findViewById(b("mbridge_lv_iv_burl"));
        this.f47738b.f47746d = (RoundImageView) viewInflate.findViewById(b("mbridge_lv_icon_iv"));
        this.f47738b.f47751i = (MBridgeLevelLayoutView) viewInflate.findViewById(b("mbridge_lv_sv_starlevel"));
        this.f47738b.f47744b = (MBRotationView) viewInflate.findViewById(b("mbridge_lv_ration"));
        viewInflate.setTag(this.f47738b);
        return viewInflate;
    }

    private View a(int i11) {
        View viewCreateDynamicView;
        String str;
        try {
            List<CampaignEx> list = this.f47739c;
            String cMPTEntryUrl = "";
            if (list == null || list.get(i11) == null) {
                str = "501";
            } else {
                str = this.f47739c.get(i11).getMof_tplid() + "";
                cMPTEntryUrl = this.f47739c.get(i11).getCMPTEntryUrl();
            }
            if (TextUtils.isEmpty(cMPTEntryUrl)) {
                return a();
            }
            int iR = z.r(c.m().c());
            String strA = n.a(0, str, cMPTEntryUrl);
            if (TextUtils.isEmpty(strA)) {
                return a();
            }
            File file = new File(strA + File.separator + "template_config.json");
            if (file.isFile() && file.exists()) {
                List<String> listA = ab.a(strA, "template_" + str + "_" + iR + "_item");
                if (listA == null) {
                    return a();
                }
                int iR2 = z.r(c.m().c());
                h.a().b(c.m().k());
                viewCreateDynamicView = DynamicViewCreator.getInstance().createDynamicView(new DyOption.Builder().campaignEx(this.f47739c.get(i11)).fileDirs(listA).dyAdType(DyAdType.REWARD).orientation(iR2).adChoiceLink(ai.a(this.f47739c.get(i11))).build());
                if (viewCreateDynamicView != null) {
                    this.f47737a = true;
                    C0527a c0527a = new C0527a();
                    this.f47738b = c0527a;
                    c0527a.f47754l = (MBCusRoundImageView) viewCreateDynamicView.findViewById(c("mbridge_lv_iv"));
                    this.f47738b.f47753k = (ImageView) viewCreateDynamicView.findViewById(c("mbridge_lv_iv_burl"));
                    this.f47738b.f47755m = (MBCusRoundImageView) viewCreateDynamicView.findViewById(c("mbridge_lv_icon_iv"));
                    this.f47738b.f47756n = (MBStarLevelLayoutView) viewCreateDynamicView.findViewById(c("mbridge_lv_sv_starlevel"));
                    this.f47738b.f47758p = (MBFrameLayout) viewCreateDynamicView.findViewById(c("mbridge_lv_ration"));
                    viewCreateDynamicView.setTag(this.f47738b);
                }
                return this.f47737a ? viewCreateDynamicView : a();
            }
            return a();
        } catch (Exception e11) {
            ad.b("OrderCampAdapter", e11.getMessage());
            viewCreateDynamicView = null;
        }
    }

    private void a(final ImageView imageView, String str, final boolean z11) {
        if (imageView == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            b.a(imageView.getContext()).a(str, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.video.dynview.ordercamp.a.a.1
                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onFailedLoad(String str2, String str3) {
                    if (z11) {
                        imageView.setVisibility(8);
                    }
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onSuccessLoad(Bitmap bitmap, String str2) {
                    try {
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        imageView.setImageBitmap(bitmap);
                    } catch (Throwable th2) {
                        ad.b("OrderCampAdapter", th2.getMessage());
                    }
                }
            });
        } else if (z11) {
            imageView.setVisibility(8);
        }
    }

    private int b(String str) {
        return v.a(c.m().c().getApplicationContext(), str, "id");
    }

    private int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    private int d(String str) {
        return this.f47737a ? c(str) : b(str);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<CampaignEx> list = this.f47739c;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.f47739c.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i11) {
        List<CampaignEx> list = this.f47739c;
        if (list != null) {
            return list.get(i11);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i11) {
        return i11;
    }

    /* JADX WARN: Code duplicated, block: B:113:0x0305 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.widget.Adapter
    public final View getView(int i11, View view, ViewGroup viewGroup) {
        View viewA;
        try {
            if (view == null) {
                viewA = a(i11);
            } else {
                this.f47738b = (C0527a) view.getTag();
                viewA = view;
            }
            try {
                this.f47738b.f47743a = (RelativeLayout) viewA.findViewById(d("mbridge_lv_item_rl"));
                this.f47738b.f47747e = (TextView) viewA.findViewById(d("mbridge_lv_title_tv"));
                this.f47738b.f47749g = (TextView) viewA.findViewById(d("mbridge_lv_tv_install"));
                this.f47738b.f47757o = (MBHeatLevelLayoutView) viewA.findViewById(d("mbridge_lv_sv_heat_level"));
                this.f47738b.f47748f = (TextView) viewA.findViewById(d("mbridge_lv_desc_tv"));
                this.f47738b.f47752j = (ImageView) viewA.findViewById(d("mbridge_iv_flag"));
                this.f47738b.f47750h = (TextView) viewA.findViewById(d("mbridge_order_viewed_tv"));
                double d11 = 5.0d;
                if (this.f47737a) {
                    List<CampaignEx> list = this.f47739c;
                    if (list != null && this.f47738b != null && list.size() != 0) {
                        MBCusRoundImageView mBCusRoundImageView = this.f47738b.f47754l;
                        if (mBCusRoundImageView != null && (mBCusRoundImageView instanceof MBCusRoundImageView)) {
                            mBCusRoundImageView.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
                            a(this.f47738b.f47754l, this.f47739c.get(i11).getImageUrl(), false);
                        }
                        ImageView imageView = this.f47738b.f47753k;
                        if (imageView != null) {
                            a(imageView, this.f47739c.get(i11).getImageUrl(), false);
                        }
                        MBCusRoundImageView mBCusRoundImageView2 = this.f47738b.f47755m;
                        if (mBCusRoundImageView2 != null && (mBCusRoundImageView2 instanceof MBCusRoundImageView)) {
                            mBCusRoundImageView2.setBorder(50, 20, -1);
                            a(this.f47738b.f47755m, this.f47739c.get(i11).getIconUrl(), true);
                        }
                        double rating = this.f47739c.get(i11).getRating();
                        if (rating > 0.0d) {
                            d11 = rating;
                        }
                        MBStarLevelLayoutView mBStarLevelLayoutView = this.f47738b.f47756n;
                        if (mBStarLevelLayoutView != null) {
                            mBStarLevelLayoutView.setRating((int) d11);
                            this.f47738b.f47756n.setOrientation(0);
                        }
                        MBHeatLevelLayoutView mBHeatLevelLayoutView = this.f47738b.f47757o;
                        if (mBHeatLevelLayoutView != null) {
                            mBHeatLevelLayoutView.setHeatCount(this.f47739c.get(i11).getNumberRating());
                        }
                    }
                } else {
                    List<CampaignEx> list2 = this.f47739c;
                    if (list2 != null && this.f47738b != null && list2.size() != 0) {
                        MBridgeImageView mBridgeImageView = this.f47738b.f47745c;
                        if (mBridgeImageView != null) {
                            a(mBridgeImageView, this.f47739c.get(i11).getImageUrl(), false);
                        }
                        ImageView imageView2 = this.f47738b.f47753k;
                        if (imageView2 != null) {
                            a(imageView2, this.f47739c.get(i11).getImageUrl(), false);
                        }
                        RoundImageView roundImageView = this.f47738b.f47746d;
                        if (roundImageView != null) {
                            roundImageView.setBorderRadius(25);
                            a(this.f47738b.f47746d, this.f47739c.get(i11).getIconUrl(), true);
                        }
                        double rating2 = this.f47739c.get(i11).getRating();
                        if (rating2 > 0.0d) {
                            d11 = rating2;
                        }
                        MBridgeLevelLayoutView mBridgeLevelLayoutView = this.f47738b.f47751i;
                        if (mBridgeLevelLayoutView != null) {
                            mBridgeLevelLayoutView.setRatingAndUser(d11, this.f47739c.get(i11).getNumberRating());
                            this.f47738b.f47751i.setOrientation(0);
                        }
                        MBRotationView mBRotationView = this.f47738b.f47744b;
                        if (mBRotationView != null) {
                            mBRotationView.setWidthRatio(1.0f);
                            this.f47738b.f47744b.setHeightRatio(1.0f);
                            this.f47738b.f47744b.setAutoscroll(false);
                        }
                        MBridgeImageView mBridgeImageView2 = this.f47738b.f47745c;
                        if (mBridgeImageView2 != null) {
                            mBridgeImageView2.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
                        }
                    }
                }
                C0527a c0527a = this.f47738b;
                if (c0527a != null) {
                    if (c0527a.f47747e != null) {
                        this.f47738b.f47747e.setText(this.f47739c.get(i11).getAppName());
                    }
                    if (this.f47738b.f47748f != null) {
                        this.f47738b.f47748f.setText(this.f47739c.get(i11).getAppDesc());
                    }
                    if (this.f47738b.f47749g != null) {
                        String adCall = this.f47739c.get(i11).getAdCall();
                        if (this.f47738b.f47749g instanceof MBridgeTextView) {
                            ((MBridgeTextView) this.f47738b.f47749g).setObjectAnimator(new com.mbridge.msdk.video.dynview.h.b().c(this.f47738b.f47749g));
                        }
                        this.f47738b.f47749g.setText(adCall);
                    }
                    if (this.f47738b.f47752j != null) {
                        try {
                            String language = Locale.getDefault().getLanguage();
                            Context contextC = c.m().c();
                            if (contextC != null) {
                                if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                                    this.f47738b.f47752j.setImageDrawable(contextC.getResources().getDrawable(contextC.getResources().getIdentifier("mbridge_reward_flag_en", "drawable", c.m().g())));
                                } else {
                                    this.f47738b.f47752j.setImageDrawable(contextC.getResources().getDrawable(contextC.getResources().getIdentifier("mbridge_reward_flag_cn", "drawable", c.m().g())));
                                }
                            }
                        } catch (Exception e11) {
                            ad.b("OrderCampAdapter", e11.getMessage());
                        }
                        ai.a(2, this.f47738b.f47752j, this.f47739c.get(i11), c.m().c(), false, null);
                        if (this.f47738b.f47750h != null) {
                            try {
                                this.f47738b.f47750h.setText(c.m().c().getResources().getString(c.m().c().getResources().getIdentifier("mbridge_reward_viewed_text_str", "string", c.m().g())));
                                this.f47738b.f47750h.setVisibility(0);
                            } catch (Exception e12) {
                                ad.b("OrderCampAdapter", e12.getMessage());
                            }
                        }
                    } else if (this.f47738b.f47750h != null) {
                        this.f47738b.f47750h.setText(c.m().c().getResources().getString(c.m().c().getResources().getIdentifier("mbridge_reward_viewed_text_str", "string", c.m().g())));
                        this.f47738b.f47750h.setVisibility(0);
                    }
                }
            } catch (Exception e13) {
                e = e13;
                ad.b("OrderCampAdapter", e.getMessage());
            }
        } catch (Exception e14) {
            e = e14;
            viewA = view;
        }
        return viewA;
    }
}
