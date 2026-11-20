package com.bytedance.sdk.component.TRI.sc.pFF.pFF;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.TRI.sc.Qj;
import com.bytedance.sdk.component.TRI.sc.TRI;
import com.bytedance.sdk.component.TRI.sc.We;
import com.bytedance.sdk.component.TRI.sc.sc.sc.qr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static TRI f26613sc;

    private static String We() {
        return qr.pFF + "/ad_log_event/";
    }

    public static void pFF() {
        if (Qj.qr().TRI() == null) {
            return;
        }
        try {
            TRI triSc = sc(Qj.qr().TRI());
            if (triSc != null) {
                triSc.sc(Uri.parse(We() + "adLogStop"));
            }
        } catch (Throwable unused) {
        }
    }

    public static TRI sc(Context context) {
        try {
            if (f26613sc == null) {
                f26613sc = Qj.qr().dE().UFX();
            }
        } catch (Exception unused) {
        }
        return f26613sc;
    }

    public static void sc() {
        if (Qj.qr().TRI() == null) {
            return;
        }
        try {
            TRI triSc = sc(Qj.qr().TRI());
            if (triSc != null) {
                triSc.sc(Uri.parse(We() + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void sc(com.bytedance.sdk.component.TRI.sc.We.sc scVar) {
        if (scVar == null) {
            return;
        }
        try {
            TRI triSc = sc(Qj.qr().TRI());
            if (triSc != null) {
                triSc.sc(Uri.parse(We() + "adLogDispatch?event=" + com.bytedance.sdk.component.TRI.sc.sc.sc.TRI.sc(scVar.TRI())));
            }
        } catch (Throwable th2) {
            th2.toString();
        }
    }

    public static void sc(String str, List<String> list, boolean z11, int i11, String str2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb2.append(com.bytedance.sdk.component.TRI.sc.sc.sc.TRI.sc(it.next()));
                sb2.append(",");
            }
            String str3 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(com.bytedance.sdk.component.TRI.sc.sc.sc.TRI.sc(sb2.toString())) + "&replace=" + String.valueOf(z11) + "&urlType=" + String.valueOf(i11) + "&adId=" + str2;
            TRI triSc = sc(Qj.qr().TRI());
            if (triSc != null) {
                triSc.sc(Uri.parse(We() + "trackAdUrl" + str3));
            }
        } catch (Throwable unused) {
        }
    }

    public static void sc(String str, boolean z11) {
        if (Qj.qr().dE().TRI() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        try {
            TRI triSc = sc(Qj.qr().TRI());
            if (triSc != null) {
                triSc.sc(Uri.parse(We() + "trackAdFailed?did=" + String.valueOf(str) + "&triggerOnInit=" + z11));
            }
        } catch (Throwable unused) {
        }
    }

    public int sc(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public int sc(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public Cursor sc(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public Uri sc(Uri uri, ContentValues contentValues) {
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0019  */
    public String sc(Uri uri) {
        int i11;
        com.bytedance.sdk.component.TRI.sc.We.sc scVarZY;
        byte b11 = 2;
        String str = uri.getPath().split("/")[2];
        str.hashCode();
        switch (str.hashCode()) {
            case -482705237:
                if (str.equals("trackAdFailed")) {
                    b11 = 0;
                } else {
                    b11 = -1;
                }
                break;
            case -171493183:
                if (str.equals("adLogStart")) {
                    b11 = 1;
                } else {
                    b11 = -1;
                }
                break;
            case 964299715:
                if (!str.equals("adLogStop")) {
                    b11 = -1;
                }
                break;
            case 1025736635:
                if (str.equals("adLogDispatch")) {
                    b11 = 3;
                } else {
                    b11 = -1;
                }
                break;
            case 1131732929:
                if (str.equals("trackAdUrl")) {
                    b11 = 4;
                } else {
                    b11 = -1;
                }
                break;
            default:
                b11 = -1;
                break;
        }
        switch (b11) {
            case 0:
                com.bytedance.sdk.component.TRI.sc.TRI.sc.sc().sc(uri.getQueryParameter("did"), uri.getBooleanQueryParameter("triggerOnInit", false));
                break;
            case 1:
                Qj.qr().Ol();
                break;
            case 2:
                Qj.qr().UFX();
                break;
            case 3:
                String queryParameter = uri.getQueryParameter(NotificationCompat.CATEGORY_EVENT);
                if (!TextUtils.isEmpty(queryParameter) && (scVarZY = com.bytedance.sdk.component.TRI.sc.We.sc.sc.zY(com.bytedance.sdk.component.TRI.sc.sc.sc.TRI.pFF(queryParameter))) != null) {
                    We.f26595sc.sc(scVarZY);
                    break;
                }
                break;
            case 4:
                try {
                    String queryParameter2 = uri.getQueryParameter("did");
                    boolean zBooleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                    String queryParameter3 = uri.getQueryParameter("track");
                    String queryParameter4 = uri.getQueryParameter("urlType");
                    String queryParameter5 = uri.getQueryParameter("adId");
                    String[] strArrSplit = com.bytedance.sdk.component.TRI.sc.sc.sc.TRI.pFF(queryParameter3).split(",");
                    if (strArrSplit.length > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : strArrSplit) {
                            String strPFF = com.bytedance.sdk.component.TRI.sc.sc.sc.TRI.pFF(str2);
                            if (!TextUtils.isEmpty(strPFF)) {
                                arrayList.add(strPFF);
                            }
                        }
                        try {
                            i11 = TextUtils.isEmpty(queryParameter4) ? 0 : Integer.parseInt(queryParameter4);
                        } catch (Exception unused) {
                            i11 = 0;
                        }
                        com.bytedance.sdk.component.TRI.sc.TRI.sc.sc().sc(queryParameter2, arrayList, zBooleanValue, null, i11, queryParameter5);
                    }
                } catch (Throwable unused2) {
                    return null;
                }
                break;
        }
        return null;
    }

    public String zY() {
        return "ad_log_event";
    }
}
