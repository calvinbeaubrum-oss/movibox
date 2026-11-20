package com.bytedance.sdk.openadsdk.utils;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.Pair;
import androidx.core.view.GravityCompat;
import androidx.core.view.MotionEventCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import com.transsion.baselib.db.download.DownloadBean;
import com.vungle.warren.error.VungleException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ol {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final Map<String, Pair<? extends Drawable, Integer>> f28737sc = new HashMap();
    private static Integer pFF = null;

    public static Drawable sc(Context context, int i11) {
        return sc(context, Color.parseColor("#1A73E8"), i11);
    }

    public static Drawable sc(Context context, int i11, int i12) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i11);
        gradientDrawable.setCornerRadius(kX.zY(context, i12));
        return gradientDrawable;
    }

    public static Drawable sc(Context context, String str) {
        return sc(context, str, true);
    }

    public static Drawable sc(Context context, String str, boolean z11) {
        Pair<? extends Drawable, Integer> pair;
        pFF = Integer.valueOf(com.bytedance.sdk.openadsdk.core.Xc.We().AZJ());
        "drawable name is: ".concat(String.valueOf(str));
        Map<String, Pair<? extends Drawable, Integer>> map = f28737sc;
        map.size();
        if (!map.containsKey(str) || (pair = map.get(str)) == null) {
            sc();
            return sc(str, context, z11);
        }
        Drawable drawable = (Drawable) pair.first;
        map.put(str, new Pair<>(drawable, Integer.valueOf(((Integer) pair.second).intValue() + 1)));
        return drawable;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0019  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static Drawable sc(String str, Context context, boolean z11) {
        byte b11;
        Drawable layerDrawable;
        Drawable drawableSc;
        str.hashCode();
        switch (str.hashCode()) {
            case -2137782317:
                if (!str.equals("tt_leftbackicon_selector_for_dark")) {
                    b11 = -1;
                } else {
                    b11 = 0;
                }
                break;
            case -2023672829:
                if (!str.equals("tt_dislike_dialog_bg")) {
                    b11 = -1;
                } else {
                    b11 = 1;
                }
                break;
            case -2010340681:
                if (!str.equals("tt_leftbackbutton_titlebar_photo_preview")) {
                    b11 = -1;
                } else {
                    b11 = 2;
                }
                break;
            case -1888785259:
                if (!str.equals("tt_seek_progress")) {
                    b11 = -1;
                } else {
                    b11 = 3;
                }
                break;
            case -1883903877:
                if (!str.equals("tt_dislike_middle_seletor")) {
                    b11 = -1;
                } else {
                    b11 = 4;
                }
                break;
            case -1881901373:
                if (!str.equals("tt_ad_cover_btn_begin_bg")) {
                    b11 = -1;
                } else {
                    b11 = 5;
                }
                break;
            case -1818605128:
                if (!str.equals("tt_leftbackicon_selector")) {
                    b11 = -1;
                } else {
                    b11 = 6;
                }
                break;
            case -1724866088:
                if (!str.equals("tt_seek_thumb_normal")) {
                    b11 = -1;
                } else {
                    b11 = 7;
                }
                break;
            case -1698792361:
                if (!str.equals("tt_stop_movebar_textpage")) {
                    b11 = -1;
                } else {
                    b11 = 8;
                }
                break;
            case -1500492368:
                if (!str.equals("tt_backup_btn_1")) {
                    b11 = -1;
                } else {
                    b11 = 9;
                }
                break;
            case -1308443384:
                if (!str.equals("tt_ad_report_info_bg")) {
                    b11 = -1;
                } else {
                    b11 = 10;
                }
                break;
            case -1222892514:
                if (!str.equals("tt_playable_btn_bk")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.VT;
                }
                break;
            case -1163545839:
                if (!str.equals("tt_dislike_bottom_seletor")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.FF;
                }
                break;
            case -1150582740:
                if (!str.equals("tt_seek_thumb_fullscreen")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.CR;
                }
                break;
            case -1147412691:
                if (!str.equals("tt_custom_dialog_bg")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.SO;
                }
                break;
            case -1107858393:
                if (!str.equals("tt_ad_loading_three_mid")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.SI;
                }
                break;
            case -876774215:
                if (!str.equals("tt_close_move_detail")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.DLE;
                }
                break;
            case -875200849:
                if (!str.equals("tt_mute_btn_bg")) {
                    b11 = -1;
                } else {
                    b11 = 17;
                }
                break;
            case -847552402:
                if (!str.equals("tt_seek_thumb")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.DC2;
                }
                break;
            case -561153052:
                if (!str.equals("tt_reward_countdown_bg")) {
                    b11 = -1;
                } else {
                    b11 = 19;
                }
                break;
            case -508263579:
                if (!str.equals("tt_play_movebar_textpage")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.DC4;
                }
                break;
            case -473198695:
                if (!str.equals("tt_refreshing_video_textpage")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.NAK;
                }
                break;
            case -404284879:
                if (!str.equals("tt_playable_progress_style")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.SYN;
                }
                break;
            case -292612462:
                if (!str.equals("tt_seek_thumb_fullscreen_selector")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.ETB;
                }
                break;
            case -226695937:
                if (!str.equals("tt_ad_landing_loading_three_mid")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.CAN;
                }
                break;
            case -154809169:
                if (!str.equals("tt_pangle_ad_mute_btn_bg")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.EM;
                }
                break;
            case -97103333:
                if (!str.equals("tt_video_black_desc_gradient")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.SUB;
                }
                break;
            case 16094728:
                if (!str.equals("tt_ad_loading_three_left")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.ESC;
                }
                break;
            case 27541452:
                if (!str.equals("tt_mute_wrapper")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.FS;
                }
                break;
            case 57270120:
                if (!str.equals("tt_dislike_top_bg")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.GS;
                }
                break;
            case 106179457:
                if (!str.equals("tt_comment_tv")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.RS;
                }
                break;
            case 242455215:
                if (!str.equals("tt_reward_full_new_bar_bg")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.US;
                }
                break;
            case 247520514:
                if (!str.equals("tt_reward_full_video_backup_btn_bg")) {
                    b11 = -1;
                } else {
                    b11 = 32;
                }
                break;
            case 310787585:
                if (!str.equals("tt_full_reward_loading_progress_style")) {
                    b11 = -1;
                } else {
                    b11 = 33;
                }
                break;
            case 314734139:
                if (!str.equals("tt_detail_video_btn_bg")) {
                    b11 = -1;
                } else {
                    b11 = 34;
                }
                break;
            case 410262782:
                if (!str.equals("tt_pangle_banner_btn_bg")) {
                    b11 = -1;
                } else {
                    b11 = 35;
                }
                break;
            case 484030064:
                if (!str.equals("tt_seek_thumb_fullscreen_press")) {
                    b11 = -1;
                } else {
                    b11 = 36;
                }
                break;
            case 494589792:
                if (!str.equals("tt_browser_download_selector")) {
                    b11 = -1;
                } else {
                    b11 = 37;
                }
                break;
            case 504597563:
                if (!str.equals("tt_ad_loading_three_right")) {
                    b11 = -1;
                } else {
                    b11 = 38;
                }
                break;
            case 507305701:
                if (!str.equals("tt_pangle_btn_bg")) {
                    b11 = -1;
                } else {
                    b11 = 39;
                }
                break;
            case 708409173:
                if (!str.equals("tt_privacy_progress_style")) {
                    b11 = -1;
                } else {
                    b11 = 40;
                }
                break;
            case 991946046:
                if (!str.equals("tt_privacy_btn_bg")) {
                    b11 = -1;
                } else {
                    b11 = 41;
                }
                break;
            case 1054661938:
                if (!str.equals("tt_seek_thumb_press")) {
                    b11 = -1;
                } else {
                    b11 = 42;
                }
                break;
            case 1094767909:
                if (!str.equals("tt_unmute_wrapper")) {
                    b11 = -1;
                } else {
                    b11 = 43;
                }
                break;
            case 1115144587:
                if (!str.equals("tt_titlebar_close_seletor_for_dark")) {
                    b11 = -1;
                } else {
                    b11 = 44;
                }
                break;
            case 1193160467:
                if (!str.equals("tt_ad_landing_loading_three_right")) {
                    b11 = -1;
                } else {
                    b11 = 45;
                }
                break;
            case 1234814491:
                if (!str.equals("tt_landingpage_loading_text_rect")) {
                    b11 = -1;
                } else {
                    b11 = 46;
                }
                break;
            case 1241312517:
                if (!str.equals("tt_shadow_btn_back_withoutnight")) {
                    b11 = -1;
                } else {
                    b11 = 47;
                }
                break;
            case 1360033453:
                if (!str.equals("tt_circle_solid_mian")) {
                    b11 = -1;
                } else {
                    b11 = 48;
                }
                break;
            case 1391934389:
                if (!str.equals("tt_browser_progress_style")) {
                    b11 = -1;
                } else {
                    b11 = 49;
                }
                break;
            case 1459143575:
                if (!str.equals("tt_download_corner_bg")) {
                    b11 = -1;
                } else {
                    b11 = 50;
                }
                break;
            case 1473061455:
                if (!str.equals("tt_ad_report_info_button_bg")) {
                    b11 = -1;
                } else {
                    b11 = 51;
                }
                break;
            case 1562327088:
                if (!str.equals("tt_ad_landing_loading_three_left")) {
                    b11 = -1;
                } else {
                    b11 = 52;
                }
                break;
            case 1635801742:
                if (!str.equals("tt_pangle_ad_close_btn_bg")) {
                    b11 = -1;
                } else {
                    b11 = 53;
                }
                break;
            case 1733712735:
                if (!str.equals("tt_lefterbackicon_titlebar_press_wrapper")) {
                    b11 = -1;
                } else {
                    b11 = 54;
                }
                break;
            case 1859118378:
                if (!str.equals("tt_reward_video_download_btn_bg")) {
                    b11 = -1;
                } else {
                    b11 = 55;
                }
                break;
            case 1908435428:
                if (!str.equals("tt_ad_loading_rect")) {
                    b11 = -1;
                } else {
                    b11 = 56;
                }
                break;
            case 1967077738:
                if (!str.equals("tt_shadow_btn_back")) {
                    b11 = -1;
                } else {
                    b11 = 57;
                }
                break;
            case 1986221289:
                if (!str.equals("tt_dislike_top_seletor")) {
                    b11 = -1;
                } else {
                    b11 = 58;
                }
                break;
            case 1987199879:
                if (!str.equals("tt_video_loading_progress_bar")) {
                    b11 = -1;
                } else {
                    b11 = 59;
                }
                break;
            case 1995246663:
                if (!str.equals("tt_ad_skip_btn_bg2")) {
                    b11 = -1;
                } else {
                    b11 = 60;
                }
                break;
            case 2051103617:
                if (!str.equals("tt_privacy_webview_bg")) {
                    b11 = -1;
                } else {
                    b11 = 61;
                }
                break;
            case 2091139328:
                if (!str.equals("tt_titlebar_close_seletor")) {
                    b11 = -1;
                } else {
                    b11 = 62;
                }
                break;
            default:
                b11 = -1;
                break;
        }
        switch (b11) {
            case 0:
                drawableSc = sc(com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_lefterbackicon_titlebar_press_for_dark"), com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_lefterbackicon_titlebar_for_dark"));
                break;
            case 1:
                drawableSc = sc(0, -1, new int[]{kX.zY(context, 8.0f)}, null, null, null);
                break;
            case 2:
                drawableSc = sc(com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_white_lefterbackicon_titlebar_press"), com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_white_lefterbackicon_titlebar"));
                break;
            case 3:
                layerDrawable = new LayerDrawable(new Drawable[]{sc(0, Integer.valueOf(Color.parseColor("#A5FFFFFF")), new int[]{kX.zY(context, 1.5f)}, new int[]{-1, kX.zY(context, 1.0f)}, null, null), new ClipDrawable(sc(0, -1, new int[]{kX.zY(context, 1.5f)}, new int[]{-1, kX.zY(context, 1.0f)}, null, null), GravityCompat.START, 1), new ClipDrawable(sc(0, Integer.valueOf(Color.parseColor("#fff85959")), new int[]{kX.zY(context, 1.5f)}, new int[]{-1, kX.zY(context, 1.0f)}, null, null), GravityCompat.START, 1)});
                drawableSc = layerDrawable;
                break;
            case 4:
                drawableSc = sc(sc(0, Integer.valueOf(com.bytedance.sdk.component.utils.Sfl.qr(context, "tt_fde6e6e6")), null, null, null, null), sc(0, Integer.valueOf(com.bytedance.sdk.component.utils.Sfl.qr(context, "tt_fdffffff")), null, null, null, null));
                break;
            case 5:
                drawableSc = sc(sc(0, Integer.valueOf(com.bytedance.sdk.component.utils.Sfl.qr(context, "tt_2a90d7")), new int[]{kX.zY(context, 6.0f)}, null, Integer.valueOf(kX.zY(context, 1.0f)), Integer.valueOf(com.bytedance.sdk.component.utils.Sfl.qr(context, "@color/tt_7f2a90d7"))), sc(0, Integer.valueOf(com.bytedance.sdk.component.utils.Sfl.qr(context, "tt_2a90d7")), new int[]{kX.zY(context, 6.0f)}, null, Integer.valueOf(kX.zY(context, 1.0f)), Integer.valueOf(com.bytedance.sdk.component.utils.Sfl.qr(context, "@color/tt_2a90d7"))));
                break;
            case 6:
                drawableSc = com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_lefterbackicon_titlebar");
                break;
            case 7:
                drawableSc = sc(1, -1, null, new int[]{kX.zY(context, 15.0f), kX.zY(context, 15.0f)}, Integer.valueOf(kX.zY(context, 1.0f)), 0);
                break;
            case 8:
                drawableSc = sc(com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_new_pause_video_press"), com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_new_pause_video"));
                break;
            case 9:
                drawableSc = sc(sc(0, Integer.valueOf(Color.parseColor("#33f32830")), new int[]{kX.zY(context, 4.0f)}, null, null, null), sc(0, Integer.valueOf(Color.parseColor("#f32830")), new int[]{kX.zY(context, 4.0f)}, null, null, null));
                break;
            case 10:
                drawableSc = sc(0, -1, new int[]{kX.zY(context, 12.0f), kX.zY(context, 12.0f), 0, 0}, null, null, null);
                break;
            case 11:
                drawableSc = sc(0, Integer.valueOf(com.bytedance.sdk.component.utils.Sfl.qr(context, "tt_00000000")), new int[]{kX.zY(context, 30.0f)}, null, Integer.valueOf(kX.zY(context, 1.0f)), -1);
                break;
            case 12:
                drawableSc = sc(sc(0, Integer.valueOf(com.bytedance.sdk.component.utils.Sfl.qr(context, "tt_fde6e6e6")), new int[]{0, 0, kX.zY(context, 5.0f), kX.zY(context, 5.0f)}, null, null, null), sc(0, Integer.valueOf(com.bytedance.sdk.component.utils.Sfl.qr(context, "tt_fdffffff")), new int[]{0, 0, kX.zY(context, 5.0f), kX.zY(context, 5.0f)}, null, null, null));
                break;
            case 13:
                drawableSc = sc(1, -1, null, new int[]{kX.zY(context, 18.0f), kX.zY(context, 18.0f)}, null, null);
                break;
            case 14:
                drawableSc = sc(0, -1, new int[]{kX.zY(context, 6.0f)}, null, Integer.valueOf(kX.zY(context, 0.8f)), -1);
                break;
            case 15:
                drawableSc = sc(0, null, null, null, Integer.valueOf(kX.zY(context, 1.5f)), -1);
                break;
            case 16:
                drawableSc = sc(com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_close_move_details_pressed"), com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_close_move_details_normal"));
                break;
            case 17:
                drawableSc = sc(1, Integer.valueOf(Color.parseColor("#99333333")), null, new int[]{kX.zY(context, 28.0f), kX.zY(context, 28.0f)}, null, null);
                break;
            case 18:
                drawableSc = sc(sc(1, -1, null, new int[]{kX.zY(context, 22.0f), kX.zY(context, 22.0f)}, Integer.valueOf(kX.zY(context, 1.0f)), 0), sc(1, -1, null, new int[]{kX.zY(context, 15.0f), kX.zY(context, 15.0f)}, Integer.valueOf(kX.zY(context, 1.0f)), 0));
                break;
            case 19:
                drawableSc = sc(1, Integer.valueOf(Color.parseColor("#99333333")), null, new int[]{kX.zY(context, 28.0f), kX.zY(context, 28.0f)}, null, null);
                break;
            case 20:
                drawableSc = sc(com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_new_play_video"), com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_new_play_video"));
                break;
            case 21:
                drawableSc = sc(com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_refreshing_video_textpage_pressed"), com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_refreshing_video_textpage_normal"));
                break;
            case 22:
                layerDrawable = new LayerDrawable(new Drawable[]{sc(0, Integer.valueOf(Color.parseColor("#4DFC625C")), new int[]{kX.zY(context, 3.0f)}, null, null, null), new ClipDrawable(sc(0, Integer.valueOf(Color.parseColor("#FC625C")), new int[]{kX.zY(context, 3.0f)}, null, null, null), GravityCompat.START, 1)});
                drawableSc = layerDrawable;
                break;
            case 23:
                drawableSc = sc(sc(1, -1, null, new int[]{kX.zY(context, 18.0f), kX.zY(context, 18.0f)}, Integer.valueOf(kX.zY(context, 1.0f)), 0), sc(1, -1, null, new int[]{kX.zY(context, 18.0f), kX.zY(context, 18.0f)}, Integer.valueOf(kX.zY(context, 1.0f)), 0));
                break;
            case 24:
                drawableSc = sc(0, null, null, null, Integer.valueOf(kX.zY(context, 1.5f)), Integer.valueOf(Color.parseColor("#ABACB0")));
                break;
            case 25:
                drawableSc = sc(1, Integer.valueOf(Color.parseColor("#99333333")), null, new int[]{kX.zY(context, 28.0f), kX.zY(context, 28.0f)}, null, null);
                break;
            case 26:
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setGradientType(0);
                gradientDrawable.setColors(new int[]{com.bytedance.sdk.component.utils.Sfl.qr(context, "tt_ff1a1a1a"), com.bytedance.sdk.component.utils.Sfl.qr(context, "tt_00000000")});
                gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                layerDrawable = gradientDrawable;
                drawableSc = layerDrawable;
                break;
            case 27:
                drawableSc = sc(0, null, new int[]{kX.zY(context, 6.0f), 0, 0, kX.zY(context, 6.0f)}, null, Integer.valueOf(kX.zY(context, 1.5f)), -1);
                break;
            case 28:
                Drawable drawableZY = com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_mute");
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[0], drawableZY);
                stateListDrawable.setAutoMirrored(true);
                layerDrawable = stateListDrawable;
                drawableSc = layerDrawable;
                break;
            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                drawableSc = sc(0, Integer.valueOf(com.bytedance.sdk.component.utils.Sfl.qr(context, "tt_fdffffff")), new int[]{kX.zY(context, 5.0f), kX.zY(context, 5.0f), 0, 0}, null, null, null);
                break;
            case 30:
                drawableSc = sc(0, -1, new int[]{kX.zY(context, 4.0f)}, null, Integer.valueOf(kX.zY(context, 1.0f)), Integer.valueOf(Color.parseColor("#0F161823")));
                break;
            case VungleException.WEB_CRASH /* 31 */:
                drawableSc = sc(0, Integer.valueOf(Color.parseColor("#ccffffff")), new int[]{kX.zY(context, 18.0f)}, null, null, null);
                break;
            case 32:
                drawableSc = sc(0, Integer.valueOf(Color.parseColor("#ff0088ff")), new int[]{kX.zY(context, 6.0f)}, null, null, null);
                break;
            case 33:
                GradientDrawable gradientDrawableSc = sc(0, Integer.valueOf(Color.parseColor("#EAEAEA")), new int[]{kX.zY(context, 50.0f)}, null, null, null);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(0);
                gradientDrawable2.setCornerRadius(kX.zY(context, 15.0f));
                gradientDrawable2.setColors(new int[]{Color.parseColor("#1A73E8"), Color.parseColor("#569FFF")});
                gradientDrawable2.setGradientType(0);
                gradientDrawable2.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
                drawableSc = new LayerDrawable(new Drawable[]{gradientDrawableSc, new ScaleDrawable(gradientDrawable2, GravityCompat.START, 1.0f, -1.0f)});
                break;
            case 34:
                drawableSc = sc(0, Integer.valueOf(Color.parseColor("#26000000")), new int[]{kX.zY(context, 4.0f)}, null, null, null);
                break;
            case 35:
                drawableSc = sc(0, Integer.valueOf(Color.parseColor("#ff2f87f8")), new int[]{kX.zY(context, 2.0f)}, new int[]{kX.zY(context, 98.0f), kX.zY(context, 25.0f)}, null, null);
                break;
            case 36:
                drawableSc = sc(1, -1, null, new int[]{kX.zY(context, 18.0f), kX.zY(context, 18.0f)}, Integer.valueOf(kX.zY(context, 1.0f)), 0);
                break;
            case 37:
                drawableSc = sc(sc(0, Integer.valueOf(Color.parseColor("#2582c3")), null, null, null, null), sc(0, Integer.valueOf(Color.parseColor("#2a90d7")), null, null, null, null));
                break;
            case 38:
                drawableSc = sc(0, null, new int[]{0, kX.zY(context, 6.0f), kX.zY(context, 6.0f), 0}, null, Integer.valueOf(kX.zY(context, 1.5f)), -1);
                break;
            case 39:
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setShape(0);
                gradientDrawable3.setSize(kX.zY(context, 280.0f), kX.zY(context, 38.0f));
                gradientDrawable3.setCornerRadius(kX.zY(context, 19.0f));
                gradientDrawable3.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                gradientDrawable3.setColors(new int[]{Color.parseColor("#fff02d42"), Color.parseColor("#fffc4b3c")});
                gradientDrawable3.setGradientType(0);
                gradientDrawable3.setUseLevel(true);
                layerDrawable = gradientDrawable3;
                drawableSc = layerDrawable;
                break;
            case 40:
                drawableSc = new LayerDrawable(new Drawable[]{sc(0, Integer.valueOf(Color.parseColor("#33007AFF")), null, null, null, null), new ClipDrawable(sc(0, Integer.valueOf(Color.parseColor("#007AFF")), null, null, null, null), GravityCompat.START, 1)});
                break;
            case 41:
                GradientDrawable gradientDrawable4 = new GradientDrawable();
                gradientDrawable4.setShape(0);
                gradientDrawable4.setSize(kX.zY(context, 258.0f), kX.zY(context, 43.0f));
                gradientDrawable4.setCornerRadius(kX.zY(context, 22.0f));
                gradientDrawable4.setColors(new int[]{Color.parseColor("#73CBFC"), Color.parseColor("#3F9CF7")});
                gradientDrawable4.setGradientType(0);
                layerDrawable = gradientDrawable4;
                drawableSc = layerDrawable;
                break;
            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                drawableSc = sc(1, -1, null, new int[]{kX.zY(context, 22.0f), kX.zY(context, 22.0f)}, Integer.valueOf(kX.zY(context, 1.0f)), 0);
                break;
            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                Drawable drawableZY2 = com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_unmute");
                StateListDrawable stateListDrawable2 = new StateListDrawable();
                stateListDrawable2.addState(new int[0], drawableZY2);
                stateListDrawable2.setAutoMirrored(true);
                layerDrawable = stateListDrawable2;
                drawableSc = layerDrawable;
                break;
            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                drawableSc = sc(com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_titlebar_close_press_for_dark"), com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_titlebar_close_for_dark"));
                break;
            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                drawableSc = sc(0, null, new int[]{0, kX.zY(context, 6.0f), kX.zY(context, 6.0f), 0}, null, Integer.valueOf(kX.zY(context, 1.5f)), Integer.valueOf(Color.parseColor("#ABACB0")));
                break;
            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                drawableSc = sc(0, Integer.valueOf(Color.parseColor("#141A73E8")), new int[]{kX.zY(context, 5.0f)}, null, null, null);
                break;
            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                Drawable drawableZY3 = com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_shadow_lefterback_titlebar_press_withoutnight");
                StateListDrawable stateListDrawableSc = sc(drawableZY3, com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_shadow_lefterback_titlebar_withoutnight"));
                stateListDrawableSc.addState(new int[]{-16842910}, drawableZY3);
                drawableSc = stateListDrawableSc;
                break;
            case 48:
                drawableSc = sc(1, Integer.valueOf(com.bytedance.sdk.component.utils.Sfl.qr(context, "tt_e0e0e0")), null, null, null, null);
                break;
            case 49:
                drawableSc = new LayerDrawable(new Drawable[]{sc(0, -1, new int[]{0}, null, null, null), new ClipDrawable(sc(0, Integer.valueOf(Color.parseColor("#1A73E8")), new int[]{0}, null, null, null), 3, 1)});
                break;
            case 50:
                drawableSc = sc(0, Integer.valueOf(com.bytedance.sdk.component.utils.Sfl.qr(context, "tt_4a90e2")), new int[]{kX.zY(context, 4.0f)}, null, null, null);
                break;
            case 51:
                drawableSc = sc(sc(0, Integer.valueOf(Color.parseColor("#0D000000")), new int[]{kX.zY(context, 2.0f)}, null, Integer.valueOf(kX.zY(context, 1.0f)), Integer.valueOf(Color.parseColor("#1F000000"))), sc(0, -1, new int[]{kX.zY(context, 2.0f)}, null, Integer.valueOf(kX.zY(context, 1.0f)), Integer.valueOf(Color.parseColor("#1618231F"))));
                break;
            case 52:
                drawableSc = sc(0, null, new int[]{kX.zY(context, 6.0f), 0, 0, kX.zY(context, 6.0f)}, null, Integer.valueOf(kX.zY(context, 1.5f)), Integer.valueOf(Color.parseColor("#ABACB0")));
                break;
            case 53:
                drawableSc = sc(1, Integer.valueOf(Color.parseColor("#30333333")), null, new int[]{kX.zY(context, 28.0f), kX.zY(context, 28.0f)}, null, null);
                break;
            case 54:
                Drawable drawableZY4 = com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_lefterbackicon_titlebar_press");
                StateListDrawable stateListDrawable3 = new StateListDrawable();
                stateListDrawable3.addState(new int[0], drawableZY4);
                stateListDrawable3.setAutoMirrored(true);
                layerDrawable = stateListDrawable3;
                drawableSc = layerDrawable;
                break;
            case 55:
                drawableSc = sc(0, Integer.valueOf(Color.parseColor("#ff007aff")), new int[]{kX.zY(context, 18.0f)}, null, null, null);
                break;
            case 56:
                drawableSc = sc(0, Integer.valueOf(Color.parseColor("#33FFFFFF")), new int[]{kX.zY(context, 15.0f)}, null, null, null);
                break;
            case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                Drawable drawableZY5 = com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_shadow_lefterback_titlebar_press");
                StateListDrawable stateListDrawableSc2 = sc(drawableZY5, com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_shadow_lefterback_titlebar"));
                stateListDrawableSc2.addState(new int[]{-16842910}, drawableZY5);
                drawableSc = stateListDrawableSc2;
                break;
            case 58:
                drawableSc = sc(sc(0, Integer.valueOf(com.bytedance.sdk.component.utils.Sfl.qr(context, "tt_fde6e6e6")), new int[]{kX.zY(context, 5.0f), kX.zY(context, 5.0f), 0, 0}, null, null, null), sc(0, Integer.valueOf(com.bytedance.sdk.component.utils.Sfl.qr(context, "tt_fdffffff")), new int[]{kX.zY(context, 5.0f), kX.zY(context, 5.0f), 0, 0}, null, null, null));
                break;
            case 59:
                RotateDrawable rotateDrawable = new RotateDrawable();
                rotateDrawable.setDrawable(com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_normalscreen_loading"));
                rotateDrawable.setFromDegrees(0.0f);
                rotateDrawable.setToDegrees(360.0f);
                rotateDrawable.setPivotX(0.5f);
                rotateDrawable.setPivotY(0.5f);
                layerDrawable = rotateDrawable;
                drawableSc = layerDrawable;
                break;
            case 60:
                drawableSc = sc(0, Integer.valueOf(Color.parseColor("#66161823")), new int[]{kX.zY(context, 14.0f)}, null, null, null);
                break;
            case 61:
                drawableSc = sc(0, -1, new int[]{kX.zY(context, 14.5f)}, null, null, null);
                break;
            case 62:
                drawableSc = com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_titlebar_close_drawable");
                break;
            default:
                drawableSc = null;
                break;
        }
        if (z11) {
            f28737sc.put(str, new Pair<>(drawableSc, 1));
        }
        return drawableSc;
    }

    private static GradientDrawable sc(int i11, Integer num, int[] iArr, int[] iArr2, Integer num2, Integer num3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(i11);
        if (num != null) {
            gradientDrawable.setColor(num.intValue());
        }
        int length = iArr != null ? iArr.length : 0;
        if (length == 1) {
            gradientDrawable.setCornerRadius(iArr[0]);
        } else if (length == 4) {
            int i12 = iArr[0];
            int i13 = iArr[1];
            int i14 = iArr[2];
            int i15 = iArr[3];
            gradientDrawable.setCornerRadii(new float[]{i12, i12, i13, i13, i14, i14, i15, i15});
        }
        if (iArr2 != null && iArr2.length == 2) {
            gradientDrawable.setSize(iArr2[0], iArr2[1]);
        }
        if (num2 != null && num3 != null) {
            gradientDrawable.setStroke(num2.intValue(), num3.intValue());
        }
        return gradientDrawable;
    }

    private static StateListDrawable sc(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (drawable != null) {
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawable);
        }
        if (drawable2 != null) {
            stateListDrawable.addState(new int[0], drawable2);
        }
        return stateListDrawable;
    }

    private static void sc() {
        Map<String, Pair<? extends Drawable, Integer>> map = f28737sc;
        if (map.size() < pFF.intValue()) {
            return;
        }
        String key = null;
        int iIntValue = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (Map.Entry<String, Pair<? extends Drawable, Integer>> entry : map.entrySet()) {
            if (((Integer) entry.getValue().second).intValue() < iIntValue) {
                key = entry.getKey();
                iIntValue = ((Integer) entry.getValue().second).intValue();
                if (iIntValue == 1) {
                    break;
                }
            }
        }
        f28737sc.remove(key);
    }
}
