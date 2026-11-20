package com.bytedance.sdk.component.adexpress.dynamic.zY;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.transsion.baselib.db.download.DownloadBean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WH {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static qr sc(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN exN, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar, com.bytedance.sdk.component.adexpress.dynamic.We.WH wh2, com.bytedance.sdk.component.adexpress.pFF.Ql ql2) {
        if (context == null || exN == null || qrVar == null) {
            return null;
        }
        String strPc = qrVar.pc();
        String strFI = ql2.FI();
        strPc.hashCode();
        byte b11 = -1;
        switch (strPc.hashCode()) {
            case 48:
                if (strPc.equals("0")) {
                    b11 = 0;
                }
                break;
            case 49:
                if (strPc.equals("1")) {
                    b11 = 1;
                }
                break;
            case 50:
                if (strPc.equals("2")) {
                    b11 = 2;
                }
                break;
            case 53:
                if (strPc.equals("5")) {
                    b11 = 3;
                }
                break;
            case 54:
                if (strPc.equals(PrepareException.ERROR_NO_URL)) {
                    b11 = 4;
                }
                break;
            case 55:
                if (strPc.equals("7")) {
                    b11 = 5;
                }
                break;
            case 56:
                if (strPc.equals(PrepareException.ERROR_MANIFEST_INFO)) {
                    b11 = 6;
                }
                break;
            case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                if (strPc.equals(PrepareException.ERROR_MINI_APP_CLOSE)) {
                    b11 = 7;
                }
                break;
            case 1567:
                if (strPc.equals(PrepareException.ERROR_MINI_APPID)) {
                    b11 = 8;
                }
                break;
            case 1568:
                if (strPc.equals(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY)) {
                    b11 = 9;
                }
                break;
            case 1569:
                if (strPc.equals(PrepareException.ERROR_LOCAL_DATA_FILE_SCAN)) {
                    b11 = 10;
                }
                break;
            case 1570:
                if (strPc.equals(PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION)) {
                    b11 = Ascii.VT;
                }
                break;
            case 1571:
                if (strPc.equals(PrepareException.ERROR_FILE2VURL_FRAMEWORK_FILE_EXCEPTION)) {
                    b11 = Ascii.FF;
                }
                break;
            case 1573:
                if (strPc.equals("16")) {
                    b11 = Ascii.CR;
                }
                break;
            case 1574:
                if (strPc.equals("17")) {
                    b11 = Ascii.SO;
                }
                break;
            case 1575:
                if (strPc.equals("18")) {
                    b11 = Ascii.SI;
                }
                break;
            case 1598:
                if (strPc.equals("20")) {
                    b11 = Ascii.DLE;
                }
                break;
            case 1600:
                if (strPc.equals("22")) {
                    b11 = 17;
                }
                break;
            case 1601:
                if (strPc.equals("23")) {
                    b11 = Ascii.DC2;
                }
                break;
            case 1602:
                if (strPc.equals("24")) {
                    b11 = 19;
                }
                break;
            case 1603:
                if (strPc.equals("25")) {
                    b11 = Ascii.DC4;
                }
                break;
            case 1607:
                if (strPc.equals("29")) {
                    b11 = Ascii.NAK;
                }
                break;
        }
        switch (b11) {
            case 0:
                return new ExN(context, exN, qrVar);
            case 1:
                return new zY(context, exN, qrVar);
            case 2:
                return new pFF(context, exN, qrVar);
            case 3:
                return qrVar.MxZ() == 1 ? new Xc(context, exN, qrVar, qrVar.Bs()) : new dE(context, exN, qrVar);
            case 4:
            case 9:
                return new SR(context, exN, qrVar);
            case 5:
            case 12:
                return new Tf(context, exN, qrVar);
            case 6:
                return new Ql(context, exN, qrVar);
            case 7:
            case 13:
                return new BT(context, exN, qrVar, strPc, wh2.sc(), wh2.pFF(), wh2.We(), wh2.qr());
            case 8:
                return new We(context, exN, qrVar);
            case 10:
                return new dE(context, exN, qrVar);
            case 11:
                return new Xc(context, exN, qrVar);
            case 14:
            case 15:
                return new Sfl(context, exN, qrVar, strPc, wh2);
            case 16:
                if (com.bytedance.sdk.component.adexpress.We.pFF()) {
                    return new UFX(context, exN, qrVar, strFI + "static/lotties/glass-swipe/glass-swipe.json", "20");
                }
                return new UFX(context, exN, qrVar, TextUtils.isEmpty(strFI) ? null : strFI + "brush_mask.json", "20");
            case 17:
                if (!com.bytedance.sdk.component.adexpress.We.pFF()) {
                    return new wjp(context, exN, qrVar);
                }
                return new UFX(context, exN, qrVar, strFI + "static/lotties/202327swiper-up-star/index.json", "22");
            case 18:
                if (!com.bytedance.sdk.component.adexpress.We.pFF()) {
                    return null;
                }
                return new UFX(context, exN, qrVar, strFI + "static/lotties/202327swiper-up-star/click.json", "23");
            case 19:
                if (com.bytedance.sdk.component.adexpress.We.pFF()) {
                    return new sc(context, exN, qrVar);
                }
                return new UFX(context, exN, qrVar, TextUtils.isEmpty(strFI) ? null : strFI + "swiper_up_star.json", "24");
            case 20:
                if (!com.bytedance.sdk.component.adexpress.We.pFF()) {
                    return null;
                }
                return new UFX(context, exN, qrVar, strFI + "static/lotties/gesture-slide.json", "25");
            case 21:
                return new TRI(context, exN, qrVar, wh2.sc(), wh2.pFF(), wh2.We(), wh2.qr());
            default:
                return null;
        }
    }
}
