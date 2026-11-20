package ud;

import android.annotation.SuppressLint;
import android.os.Build;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.stats.CodePackage;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"InlinedApi"})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f78499a = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f78500b = {"android.permission.CAMERA"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f78501c = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f78502d = {"android.permission.ACCESS_COARSE_LOCATION"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f78503e = {"android.permission.RECORD_AUDIO"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f78504f = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.ANSWER_PHONE_CALLS"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f78505g = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f78506h = {"android.permission.BODY_SENSORS"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f78507i = {"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f78508j = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f78509k = {"android.permission.READ_EXTERNAL_STORAGE"};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f78510l = {"android.permission.WRITE_EXTERNAL_STORAGE"};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f78511m = {"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f78512n = {"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f78513o = {"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String[] f78514p = {"android.permission.READ_MEDIA_IMAGES"};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String[] f78515q = {"android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String[] f78516r = {"android.permission.READ_MEDIA_VIDEO"};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String[] f78517s = {"android.permission.READ_MEDIA_AUDIO"};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String[] f78518t = {"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String[] f78519u = {"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String[] f78520v = {"android.permission.ACTIVITY_RECOGNITION"};

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:8:0x000e  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String[] a(String str) {
        byte b11 = 0;
        if (str == null) {
            return new String[0];
        }
        switch (str.hashCode()) {
            case -1611296843:
                if (!str.equals(CodePackage.LOCATION)) {
                    b11 = -1;
                }
                break;
            case -1596608551:
                if (!str.equals("SENSORS")) {
                    b11 = -1;
                } else {
                    b11 = 1;
                }
                break;
            case -1236952197:
                if (!str.equals("MEDIA_AUDIO")) {
                    b11 = -1;
                } else {
                    b11 = 2;
                }
                break;
            case -1217915872:
                if (!str.equals("MEDIA_VIDEO")) {
                    b11 = -1;
                } else {
                    b11 = 3;
                }
                break;
            case -1166291365:
                if (!str.equals("STORAGE")) {
                    b11 = -1;
                } else {
                    b11 = 4;
                }
                break;
            case -1050739462:
                if (!str.equals("STORAGE_READ")) {
                    b11 = -1;
                } else {
                    b11 = 5;
                }
                break;
            case 82233:
                if (!str.equals("SMS")) {
                    b11 = -1;
                } else {
                    b11 = 6;
                }
                break;
            case 73234372:
                if (!str.equals("MEDIA")) {
                    b11 = -1;
                } else {
                    b11 = 7;
                }
                break;
            case 76105038:
                if (!str.equals("PHONE")) {
                    b11 = -1;
                } else {
                    b11 = 8;
                }
                break;
            case 140654183:
                if (!str.equals("ACTIVITY_RECOGNITION")) {
                    b11 = -1;
                } else {
                    b11 = 9;
                }
                break;
            case 215175251:
                if (!str.equals("CONTACTS")) {
                    b11 = -1;
                } else {
                    b11 = 10;
                }
                break;
            case 530741075:
                if (!str.equals("MEDIA_IMAGES")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.VT;
                }
                break;
            case 604302142:
                if (!str.equals("CALENDAR")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.FF;
                }
                break;
            case 827124847:
                if (!str.equals("MEDIA_IMAGES_VIDEO")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.CR;
                }
                break;
            case 1791828187:
                if (!str.equals("STORAGE_WRITE")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.SO;
                }
                break;
            case 1856013610:
                if (!str.equals("MICROPHONE")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.SI;
                }
                break;
            case 1980544805:
                if (!str.equals("CAMERA")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.DLE;
                }
                break;
            default:
                b11 = -1;
                break;
        }
        switch (b11) {
            case 0:
                return f78502d;
            case 1:
                return f78506h;
            case 2:
                return Build.VERSION.SDK_INT >= 33 ? f78517s : f78508j;
            case 3:
                int i11 = Build.VERSION.SDK_INT;
                if (i11 >= 34) {
                    return f78515q;
                }
                return i11 >= 33 ? f78516r : f78508j;
            case 4:
            case 7:
                int i12 = Build.VERSION.SDK_INT;
                if (i12 >= 34) {
                    return f78511m;
                }
                return i12 >= 33 ? f78512n : f78508j;
            case 5:
                return Build.VERSION.SDK_INT >= 33 ? f78512n : f78509k;
            case 6:
                return f78507i;
            case 8:
                return Build.VERSION.SDK_INT < 26 ? f78505g : f78504f;
            case 9:
                return f78520v;
            case 10:
                return f78501c;
            case 11:
                int i13 = Build.VERSION.SDK_INT;
                if (i13 >= 34) {
                    return f78513o;
                }
                return i13 >= 33 ? f78514p : f78508j;
            case 12:
                return f78499a;
            case 13:
                int i14 = Build.VERSION.SDK_INT;
                if (i14 >= 34) {
                    return f78518t;
                }
                return i14 >= 33 ? f78519u : f78508j;
            case 14:
                return Build.VERSION.SDK_INT >= 33 ? f78512n : f78510l;
            case 15:
                return f78503e;
            case 16:
                return f78500b;
            default:
                return new String[]{str};
        }
    }
}
