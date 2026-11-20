package com.transsion.wrapperad.middle.nativead;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.i;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.mediation.ad.TStoreMarkView;
import com.hisavana.mediation.ad.ViewBinder;
import com.transsion.ad.hi.MaskLayout;
import com.transsion.ad.view.AdTagView;
import com.transsion.wrapperad.R$id;
import com.transsion.wrapperad.R$layout;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;
import org.json.JSONObject;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
@Metadata
public final class AdViewBinderFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AdViewBinderFactory f60243a = new AdViewBinderFactory();

    public static final void e(AppCompatTextView this_apply) {
        Intrinsics.g(this_apply, "$this_apply");
        try {
            Result.Companion companion = Result.Companion;
            String lowerCase = this_apply.getText().toString().toLowerCase(Locale.ROOT);
            Intrinsics.f(lowerCase, "toLowerCase(...)");
            if (xq.c.f80663a.c(lowerCase)) {
                this_apply.setText(l.p(lowerCase));
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public static final void j(AppCompatTextView this_apply) {
        Intrinsics.g(this_apply, "$this_apply");
        try {
            Result.Companion companion = Result.Companion;
            String lowerCase = this_apply.getText().toString().toLowerCase(Locale.ROOT);
            Intrinsics.f(lowerCase, "toLowerCase(...)");
            if (xq.c.f80663a.c(lowerCase)) {
                this_apply.setText(l.p(lowerCase));
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final ViewBinder c(String str, boolean z11, TAdNativeInfo tAdNativeInfo, Context context) {
        if (context == null) {
            context = Utils.a();
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.native_adalysing_result_tips_dialog_ad_layout, (ViewGroup) null);
        if (z11) {
            ((CardView) viewInflate.findViewById(R$id.adChoicesViewCard)).setVisibility(8);
            ((ConstraintLayout) viewInflate.findViewById(R$id.store_mark_container)).setVisibility(8);
            AdTagView adTagView = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView != null) {
                com.transsion.ad.strategy.e.f50608a.a(adTagView);
            }
        } else {
            TStoreMarkView tStoreMarkView = (TStoreMarkView) viewInflate.findViewById(R$id.store_mark_view);
            xq.c cVar = xq.c.f80663a;
            Intrinsics.f(tStoreMarkView, "this");
            xq.c.h(cVar, tStoreMarkView, 0.0f, 0, null, 14, null);
            AdTagView adTagView2 = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView2 != null) {
                adTagView2.setVisibility(8);
            }
        }
        ViewBinder viewBinderBuild = new ViewBinder.Builder(viewInflate).titleId(R$id.native_ad_title).iconId(R$id.native_ad_icon).callToActionId(R$id.native_ad_action).descriptionId(R$id.native_ad_des).mediaId(R$id.native_ad_media).adChoicesView(R$id.native_ad_choices).storeMarkView(R$id.store_mark_view).contextMode(0).build();
        Intrinsics.f(viewBinderBuild, "Builder(inflate).titleId…ntextMode.NORMAL).build()");
        return viewBinderBuild;
    }

    public final ViewBinder d(String str, boolean z11, TAdNativeInfo tAdNativeInfo, Context context) {
        String appInfo;
        if (context == null) {
            context = Utils.a();
        }
        Unit unit = null;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.download_intercept_ad_layout, (ViewGroup) null);
        try {
            Result.Companion companion = Result.Companion;
            if (tAdNativeInfo != null && (appInfo = tAdNativeInfo.getAppInfo()) != null) {
                JSONObject jSONObject = new JSONObject(appInfo);
                ((TextView) viewInflate.findViewById(R$id.tvStarNum)).setText(jSONObject.getString("star"));
                ((TextView) viewInflate.findViewById(R$id.tvSizeNum)).setText(i.b(jSONObject.getLong("size"), 1));
                unit = Unit.f68710a;
            }
            Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        ViewBinder viewBinderBuild = new ViewBinder.Builder(viewInflate).titleId(R$id.native_ad_title).iconId(R$id.native_ad_icon).callToActionId(R$id.call_to_action).descriptionId(R$id.native_ad_body).mediaId(R$id.coverview).adChoicesView(R$id.adChoicesView).storeMarkView(R$id.store_mark_view).contextMode(1).build();
        Intrinsics.f(viewBinderBuild, "Builder(inflate).titleId…ContextMode.LIST).build()");
        final AppCompatTextView appCompatTextView = (AppCompatTextView) viewInflate.findViewById(R$id.call_to_action);
        if (appCompatTextView != null) {
            appCompatTextView.post(new Runnable() { // from class: com.transsion.wrapperad.middle.nativead.b
                @Override // java.lang.Runnable
                public final void run() {
                    AdViewBinderFactory.e(appCompatTextView);
                }
            });
        }
        return viewBinderBuild;
    }

    public final ViewBinder f(String str, boolean z11, TAdNativeInfo tAdNativeInfo, Context context) {
        String appInfo;
        if (context == null) {
            context = Utils.a();
        }
        Unit unit = null;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.icon_download_movie_ad_layout, (ViewGroup) null);
        ViewBinder viewBinderBuild = new ViewBinder.Builder(viewInflate).titleId(R$id.tvDes).mediaId(R$id.ivIcon).ratingId(R$id.tvStarNum).contextMode(1).build();
        Intrinsics.f(viewBinderBuild, "Builder(inflate).titleId…ContextMode.LIST).build()");
        try {
            Result.Companion companion = Result.Companion;
            if (tAdNativeInfo != null && (appInfo = tAdNativeInfo.getAppInfo()) != null) {
                JSONObject jSONObject = new JSONObject(appInfo);
                ((TextView) viewInflate.findViewById(R$id.tvStarNum)).setText(jSONObject.getString("star"));
                ((TextView) viewInflate.findViewById(R$id.tvSize)).setText(i.b(jSONObject.getLong("size"), 1));
                unit = Unit.f68710a;
            }
            Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        return viewBinderBuild;
    }

    public final ViewBinder g(String str, boolean z11, TAdNativeInfo tAdNativeInfo, Context context) {
        if (context == null) {
            context = Utils.a();
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.native_download_page_top_card_ad_layout, (ViewGroup) null);
        if (z11) {
            ((CardView) viewInflate.findViewById(R$id.adChoicesViewCard)).setVisibility(8);
            AdTagView adTagView = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView != null) {
                com.transsion.ad.strategy.e.f50608a.a(adTagView);
            }
        } else {
            TStoreMarkView tStoreMarkView = (TStoreMarkView) viewInflate.findViewById(R$id.store_mark_view);
            xq.c cVar = xq.c.f80663a;
            Intrinsics.f(tStoreMarkView, "this");
            xq.c.h(cVar, tStoreMarkView, 0.0f, 0, null, 14, null);
            AdTagView adTagView2 = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView2 != null) {
                adTagView2.setVisibility(8);
            }
        }
        ViewBinder viewBinderBuild = new ViewBinder.Builder(viewInflate).callToActionId(R$id.call_to_action).mediaId(R$id.coverview).adChoicesView(R$id.adChoicesView).storeMarkView(R$id.store_mark_view).contextMode(0).build();
        Intrinsics.f(viewBinderBuild, "Builder(inflate)\n       …ntextMode.NORMAL).build()");
        return viewBinderBuild;
    }

    public final ViewBinder h(String str, boolean z11, TAdNativeInfo tAdNativeInfo, Context context) {
        if (context == null) {
            context = Utils.a();
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.native_download_tab_downloaded_layout, (ViewGroup) null);
        if (z11) {
            ((CardView) viewInflate.findViewById(R$id.adChoicesViewCard)).setVisibility(8);
            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R$id.store_mark_container);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            AdTagView adTagView = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView != null) {
                com.transsion.ad.strategy.e.f50608a.a(adTagView);
            }
        } else {
            TStoreMarkView tStoreMarkView = (TStoreMarkView) viewInflate.findViewById(R$id.store_mark_view);
            xq.c cVar = xq.c.f80663a;
            Intrinsics.f(tStoreMarkView, "this");
            xq.c.h(cVar, tStoreMarkView, 0.0f, 0, null, 14, null);
            AdTagView adTagView2 = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView2 != null) {
                adTagView2.setVisibility(8);
            }
        }
        ViewBinder viewBinderBuild = new ViewBinder.Builder(viewInflate).titleId(R$id.native_ad_title).iconId(R$id.native_ad_icon).callToActionId(R$id.call_to_action).descriptionId(R$id.native_ad_body).mediaId(R$id.coverview).adChoicesView(R$id.adChoicesView).storeMarkView(R$id.store_mark_view).contextMode(0).build();
        Intrinsics.f(viewBinderBuild, "Builder(inflate).titleId…ntextMode.NORMAL).build()");
        return viewBinderBuild;
    }

    public final ViewBinder i(String str, boolean z11, TAdNativeInfo tAdNativeInfo, Context context) {
        if (context == null) {
            context = Utils.a();
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.native_home_tab_apps_linear_layout, (ViewGroup) null);
        ViewBinder viewBinderBuild = new ViewBinder.Builder(viewInflate).titleId(R$id.native_ad_title).iconId(R$id.native_ad_icon).callToActionId(R$id.call_to_action).descriptionId(R$id.native_ad_body).mediaId(R$id.coverview).adChoicesView(R$id.adChoicesView).storeMarkView(R$id.store_mark_view).contextMode(1).build();
        Intrinsics.f(viewBinderBuild, "Builder(inflate).titleId…ContextMode.LIST).build()");
        final AppCompatTextView appCompatTextView = (AppCompatTextView) viewInflate.findViewById(R$id.call_to_action);
        if (appCompatTextView != null) {
            appCompatTextView.post(new Runnable() { // from class: com.transsion.wrapperad.middle.nativead.a
                @Override // java.lang.Runnable
                public final void run() {
                    AdViewBinderFactory.j(appCompatTextView);
                }
            });
        }
        return viewBinderBuild;
    }

    public final ViewBinder k(String str, boolean z11, TAdNativeInfo tAdNativeInfo, Context context) {
        if (context == null) {
            context = Utils.a();
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.native_home_tab_grid_3_layout, (ViewGroup) null);
        final ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R$id.store_mark_container);
        if (z11) {
            CardView cardView = (CardView) viewInflate.findViewById(R$id.adChoicesViewCard);
            if (cardView != null) {
                cardView.setVisibility(8);
            }
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            AdTagView adTagView = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView != null) {
                com.transsion.ad.strategy.e.f50608a.a(adTagView);
            }
        } else {
            TStoreMarkView tStoreMarkView = (TStoreMarkView) viewInflate.findViewById(R$id.store_mark_view);
            if (tStoreMarkView != null) {
                xq.c.h(xq.c.f80663a, tStoreMarkView, 8.0f, 0, new Function1<Boolean, Unit>() { // from class: com.transsion.wrapperad.middle.nativead.AdViewBinderFactory$getHomeTabGridThree$3$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(boolean z12) {
                        if (z12) {
                            ConstraintLayout constraintLayout2 = constraintLayout;
                            if (constraintLayout2 == null) {
                                return;
                            }
                            constraintLayout2.setVisibility(8);
                            return;
                        }
                        ConstraintLayout constraintLayout3 = constraintLayout;
                        if (constraintLayout3 == null) {
                            return;
                        }
                        constraintLayout3.setVisibility(0);
                    }
                }, 4, null);
            }
            AdTagView adTagView2 = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView2 != null) {
                adTagView2.setVisibility(8);
            }
        }
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R$id.flRoot);
        if (frameLayout != null) {
            xq.c.f80663a.e(frameLayout, 107.0f, 149.0f, 40.0f, 3);
        }
        ViewBinder viewBinderBuild = new ViewBinder.Builder(viewInflate).titleId(R$id.native_ad_title).mediaId(R$id.coverview).adChoicesView(R$id.adChoicesView).storeMarkView(R$id.store_mark_view).contextMode(1).build();
        Intrinsics.f(viewBinderBuild, "Builder(inflate).titleId…ContextMode.LIST).build()");
        return viewBinderBuild;
    }

    public final ViewBinder l(String str, boolean z11, TAdNativeInfo tAdNativeInfo, Context context) {
        if (context == null) {
            context = Utils.a();
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.native_home_tab_grid_2_layout, (ViewGroup) null);
        final ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R$id.store_mark_container);
        if (z11) {
            ((CardView) viewInflate.findViewById(R$id.adChoicesViewCard)).setVisibility(8);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            AdTagView adTagView = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView != null) {
                com.transsion.ad.strategy.e.f50608a.a(adTagView);
            }
        } else {
            TStoreMarkView tStoreMarkView = (TStoreMarkView) viewInflate.findViewById(R$id.store_mark_view);
            xq.c cVar = xq.c.f80663a;
            Intrinsics.f(tStoreMarkView, "this");
            xq.c.h(cVar, tStoreMarkView, 0.0f, 0, new Function1<Boolean, Unit>() { // from class: com.transsion.wrapperad.middle.nativead.AdViewBinderFactory$getHomeTabGridTwo$2$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z12) {
                    if (z12) {
                        ConstraintLayout constraintLayout2 = constraintLayout;
                        if (constraintLayout2 == null) {
                            return;
                        }
                        constraintLayout2.setVisibility(8);
                        return;
                    }
                    ConstraintLayout constraintLayout3 = constraintLayout;
                    if (constraintLayout3 == null) {
                        return;
                    }
                    constraintLayout3.setVisibility(0);
                }
            }, 6, null);
            AdTagView adTagView2 = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView2 != null) {
                adTagView2.setVisibility(8);
            }
        }
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R$id.flRoot);
        if (frameLayout != null) {
            xq.c.f80663a.e(frameLayout, 164.0f, 92.0f, 32.0f, 2);
        }
        ViewBinder viewBinderBuild = new ViewBinder.Builder(viewInflate).titleId(R$id.native_ad_title).mediaId(R$id.coverview).adChoicesView(R$id.adChoicesView).storeMarkView(R$id.store_mark_view).contextMode(1).build();
        Intrinsics.f(viewBinderBuild, "Builder(inflate).titleId…ContextMode.LIST).build()");
        return viewBinderBuild;
    }

    public final ViewBinder m(String str, boolean z11, TAdNativeInfo tAdNativeInfo, Context context) {
        if (context == null) {
            context = Utils.a();
        }
        ViewBinder viewBinderBuild = new ViewBinder.Builder(LayoutInflater.from(context).inflate(R$layout.nonstandard_home_top_native_layout, (ViewGroup) null)).titleId(R$id.native_ad_title).mediaId(R$id.coverview).contextMode(0).build();
        Intrinsics.f(viewBinderBuild, "Builder(inflate).titleId…ntextMode.NORMAL).build()");
        return viewBinderBuild;
    }

    public final ViewBinder n(String str, boolean z11, TAdNativeInfo tAdNativeInfo, Context context) {
        if (context == null) {
            context = Utils.a();
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.native_home_video_tab_page_layout, (ViewGroup) null);
        if (z11) {
            ((CardView) viewInflate.findViewById(R$id.adChoicesViewCard)).setVisibility(8);
            ((ConstraintLayout) viewInflate.findViewById(R$id.store_mark_container)).setVisibility(8);
            AdTagView adTagView = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView != null) {
                com.transsion.ad.strategy.e.f50608a.a(adTagView);
            }
        } else {
            TStoreMarkView tStoreMarkView = (TStoreMarkView) viewInflate.findViewById(R$id.store_mark_view);
            xq.c cVar = xq.c.f80663a;
            Intrinsics.f(tStoreMarkView, "this");
            xq.c.h(cVar, tStoreMarkView, 0.0f, 0, null, 14, null);
            AdTagView adTagView2 = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView2 != null) {
                adTagView2.setVisibility(8);
            }
        }
        ViewBinder viewBinderBuild = new ViewBinder.Builder(viewInflate).titleId(R$id.native_ad_title).iconId(R$id.native_ad_icon).callToActionId(R$id.call_to_action).descriptionId(R$id.native_ad_body).mediaId(R$id.coverview).adChoicesView(R$id.adChoicesView).storeMarkView(R$id.store_mark_view).contextMode(1).build();
        Intrinsics.f(viewBinderBuild, "Builder(inflate).titleId…ContextMode.LIST).build()");
        return viewBinderBuild;
    }

    public final ViewBinder o(String str, boolean z11, TAdNativeInfo tAdNativeInfo, Context context) {
        if (context == null) {
            context = Utils.a();
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.native_local_video_land_native_layout, (ViewGroup) null);
        final ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R$id.store_mark_container);
        if (z11) {
            ((CardView) viewInflate.findViewById(R$id.adChoicesViewCard)).setVisibility(8);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            AdTagView adTagView = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView != null) {
                com.transsion.ad.strategy.e.f50608a.a(adTagView);
            }
        } else {
            TStoreMarkView tStoreMarkView = (TStoreMarkView) viewInflate.findViewById(R$id.store_mark_view);
            if (tStoreMarkView != null) {
                xq.c.h(xq.c.f80663a, tStoreMarkView, 8.0f, 0, new Function1<Boolean, Unit>() { // from class: com.transsion.wrapperad.middle.nativead.AdViewBinderFactory$getLocalVideoLandViewBinder$2$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(boolean z12) {
                        if (z12) {
                            ConstraintLayout constraintLayout2 = constraintLayout;
                            if (constraintLayout2 == null) {
                                return;
                            }
                            constraintLayout2.setVisibility(8);
                            return;
                        }
                        ConstraintLayout constraintLayout3 = constraintLayout;
                        if (constraintLayout3 == null) {
                            return;
                        }
                        constraintLayout3.setVisibility(8);
                    }
                }, 4, null);
            }
            AdTagView adTagView2 = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView2 != null) {
                adTagView2.setVisibility(8);
            }
            View viewFindViewById = viewInflate.findViewById(R$id.learn_more);
            Intrinsics.f(viewFindViewById, "inflate.findViewById<App…extView>(R.id.learn_more)");
            so.c.g(viewFindViewById);
        }
        ViewBinder viewBinderBuild = new ViewBinder.Builder(viewInflate).titleId(R$id.native_ad_title).iconId(R$id.native_ad_icon).descriptionId(R$id.native_ad_des).mediaId(R$id.native_ad_media).adChoicesView(R$id.adChoicesView).storeMarkView(R$id.store_mark_view).contextMode(0).build();
        Intrinsics.f(viewBinderBuild, "Builder(inflate).titleId…ntextMode.NORMAL).build()");
        return viewBinderBuild;
    }

    public final ViewBinder p(String str, boolean z11, TAdNativeInfo tAdNativeInfo, Context context) {
        return r(str, z11, tAdNativeInfo, context);
    }

    public final ViewBinder q(String str, boolean z11, TAdNativeInfo tAdNativeInfo, Context context) {
        if (context == null) {
            context = Utils.a();
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.native_local_video_pause_native_layout, (ViewGroup) null);
        if (z11) {
            ((CardView) viewInflate.findViewById(R$id.adChoicesViewCard)).setVisibility(8);
            ((ConstraintLayout) viewInflate.findViewById(R$id.store_mark_container)).setVisibility(8);
            AdTagView adTagView = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView != null) {
                com.transsion.ad.strategy.e.f50608a.a(adTagView);
            }
        } else {
            TStoreMarkView tStoreMarkView = (TStoreMarkView) viewInflate.findViewById(R$id.store_mark_view);
            xq.c cVar = xq.c.f80663a;
            Intrinsics.f(tStoreMarkView, "this");
            xq.c.h(cVar, tStoreMarkView, 0.0f, 0, null, 14, null);
            tStoreMarkView.setVisibility(8);
            AdTagView adTagView2 = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView2 != null) {
                adTagView2.setVisibility(8);
            }
            View viewFindViewById = viewInflate.findViewById(R$id.learn_more);
            Intrinsics.f(viewFindViewById, "inflate.findViewById<App…extView>(R.id.learn_more)");
            so.c.g(viewFindViewById);
        }
        ViewBinder viewBinderBuild = new ViewBinder.Builder(viewInflate).titleId(R$id.native_ad_title).iconId(R$id.native_ad_icon).descriptionId(R$id.native_ad_body).mediaId(R$id.coverview).adChoicesView(R$id.adChoicesView).storeMarkView(R$id.store_mark_view).contextMode(0).build();
        Intrinsics.f(viewBinderBuild, "Builder(inflate).titleId…ntextMode.NORMAL).build()");
        return viewBinderBuild;
    }

    public final ViewBinder r(String str, boolean z11, TAdNativeInfo tAdNativeInfo, Context context) {
        if (context == null) {
            context = Utils.a();
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.native_media_player_mid_native_layout, (ViewGroup) null);
        if (z11) {
            ((CardView) viewInflate.findViewById(R$id.adChoicesViewCard)).setVisibility(8);
            TStoreMarkView tStoreMarkView = (TStoreMarkView) viewInflate.findViewById(R$id.store_mark_view);
            if (tStoreMarkView != null) {
                tStoreMarkView.setVisibility(8);
            }
            AdTagView adTagView = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView != null) {
                com.transsion.ad.strategy.e.f50608a.a(adTagView);
            }
        } else {
            TStoreMarkView tStoreMarkView2 = (TStoreMarkView) viewInflate.findViewById(R$id.store_mark_view);
            xq.c cVar = xq.c.f80663a;
            Intrinsics.f(tStoreMarkView2, "this");
            xq.c.h(cVar, tStoreMarkView2, 0.0f, 0, null, 14, null);
            AdTagView adTagView2 = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView2 != null) {
                adTagView2.setVisibility(8);
            }
        }
        ViewBinder viewBinderBuild = new ViewBinder.Builder(viewInflate).titleId(R$id.native_ad_title).iconId(R$id.native_ad_icon).callToActionId(R$id.call_to_action).mediaId(R$id.coverview).adChoicesView(R$id.adChoicesView).storeMarkView(R$id.store_mark_view).contextMode(0).build();
        Intrinsics.f(viewBinderBuild, "Builder(inflate).titleId…ntextMode.NORMAL).build()");
        return viewBinderBuild;
    }

    public final ViewBinder s(String str, boolean z11, TAdNativeInfo tAdNativeInfo, Context context) {
        return u(str, z11, tAdNativeInfo, context);
    }

    public final ViewBinder t(String str, boolean z11, TAdNativeInfo tAdNativeInfo, Context context) {
        if (context == null) {
            context = Utils.a();
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.native_subject_detail_page_layout, (ViewGroup) null);
        if ((tAdNativeInfo != null ? tAdNativeInfo.getIcon() : null) == null) {
            ((MaskLayout) viewInflate.findViewById(R$id.maskLayoutIcon)).setVisibility(8);
        }
        if (z11) {
            ((CardView) viewInflate.findViewById(R$id.adChoicesViewCard)).setVisibility(8);
            ((ConstraintLayout) viewInflate.findViewById(R$id.store_mark_container)).setVisibility(8);
            AdTagView adTagView = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView != null) {
                com.transsion.ad.strategy.e.f50608a.a(adTagView);
            }
        } else {
            TStoreMarkView tStoreMarkView = (TStoreMarkView) viewInflate.findViewById(R$id.store_mark_view);
            xq.c cVar = xq.c.f80663a;
            Intrinsics.f(tStoreMarkView, "this");
            xq.c.h(cVar, tStoreMarkView, 0.0f, 0, null, 14, null);
            AdTagView adTagView2 = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView2 != null) {
                adTagView2.setVisibility(8);
            }
        }
        ViewBinder viewBinderBuild = new ViewBinder.Builder(viewInflate).titleId(R$id.native_ad_title).iconId(R$id.native_ad_icon).callToActionId(R$id.call_to_action).descriptionId(R$id.native_ad_body).mediaId(R$id.coverview).adChoicesView(R$id.adChoicesView).storeMarkView(R$id.store_mark_view).contextMode(1).build();
        Intrinsics.f(viewBinderBuild, "Builder(inflate).titleId…ContextMode.LIST).build()");
        return viewBinderBuild;
    }

    public final ViewBinder u(String str, boolean z11, TAdNativeInfo tAdNativeInfo, Context context) {
        if (context == null) {
            context = Utils.a();
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.native_trending_native_layout, (ViewGroup) null);
        if ((tAdNativeInfo != null ? tAdNativeInfo.getIcon() : null) == null) {
            ((MaskLayout) viewInflate.findViewById(R$id.maskLayoutIcon)).setVisibility(8);
        }
        if (z11) {
            ((CardView) viewInflate.findViewById(R$id.adChoicesViewCard)).setVisibility(8);
            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R$id.store_mark_container);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            AdTagView adTagView = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView != null) {
                com.transsion.ad.strategy.e.f50608a.a(adTagView);
            }
        } else {
            TStoreMarkView tStoreMarkView = (TStoreMarkView) viewInflate.findViewById(R$id.store_mark_view);
            xq.c cVar = xq.c.f80663a;
            Intrinsics.f(tStoreMarkView, "this");
            xq.c.h(cVar, tStoreMarkView, 0.0f, 0, null, 14, null);
            AdTagView adTagView2 = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView2 != null) {
                adTagView2.setVisibility(8);
            }
        }
        ViewBinder viewBinderBuild = new ViewBinder.Builder(viewInflate).titleId(R$id.native_ad_title).iconId(R$id.native_ad_icon).callToActionId(R$id.call_to_action).descriptionId(R$id.native_ad_body).mediaId(R$id.coverview).adChoicesView(R$id.adChoicesView).storeMarkView(R$id.store_mark_view).contextMode(1).build();
        Intrinsics.f(viewBinderBuild, "Builder(inflate).titleId…ContextMode.LIST).build()");
        return viewBinderBuild;
    }

    public final ViewBinder v(String str, boolean z11, TAdNativeInfo tAdNativeInfo, Context context) {
        if (context == null) {
            context = Utils.a();
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.native_local_play_list_layout, (ViewGroup) null);
        if (z11) {
            CardView cardView = (CardView) viewInflate.findViewById(R$id.adChoicesViewCard);
            if (cardView != null) {
                cardView.setVisibility(8);
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R$id.store_mark_container);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            AdTagView adTagView = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView != null) {
                com.transsion.ad.strategy.e.f50608a.a(adTagView);
            }
        } else {
            TStoreMarkView tStoreMarkView = (TStoreMarkView) viewInflate.findViewById(R$id.store_mark_view);
            xq.c cVar = xq.c.f80663a;
            Intrinsics.f(tStoreMarkView, "this");
            xq.c.h(cVar, tStoreMarkView, 0.0f, 0, null, 14, null);
            AdTagView adTagView2 = (AdTagView) viewInflate.findViewById(R$id.adIcon);
            if (adTagView2 != null) {
                adTagView2.setVisibility(8);
            }
        }
        ViewBinder viewBinderBuild = new ViewBinder.Builder(viewInflate).titleId(R$id.native_ad_title).iconId(R$id.native_ad_icon).callToActionId(R$id.call_to_action).descriptionId(R$id.native_ad_body).mediaId(R$id.coverview).adChoicesView(R$id.adChoicesView).storeMarkView(R$id.store_mark_view).contextMode(1).build();
        Intrinsics.f(viewBinderBuild, "Builder(inflate).titleId…ContextMode.LIST).build()");
        return viewBinderBuild;
    }
}
