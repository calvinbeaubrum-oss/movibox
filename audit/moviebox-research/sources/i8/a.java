package i8;

import android.annotation.SuppressLint;
import android.os.Build;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"InlinedApi"})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f67162a = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f67163b = {"android.permission.CAMERA"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f67164c = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f67165d = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f67166e = {"android.permission.RECORD_AUDIO"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f67167f = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.ANSWER_PHONE_CALLS"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f67168g = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f67169h = {"android.permission.BODY_SENSORS"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f67170i = {"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f67171j = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f67172k = {"android.permission.ACTIVITY_RECOGNITION"};

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:8:0x000e  */
    public static String[] a(String str) {
        if (str == null) {
            return new String[0];
        }
        switch (str) {
            case "LOCATION":
                return f67165d;
            case "SENSORS":
                return f67169h;
            case "STORAGE":
                return f67171j;
            case "SMS":
                return f67170i;
            case "PHONE":
                return Build.VERSION.SDK_INT < 26 ? f67168g : f67167f;
            case "ACTIVITY_RECOGNITION":
                return f67172k;
            case "CONTACTS":
                return f67164c;
            case "CALENDAR":
                return f67162a;
            case "MICROPHONE":
                return f67166e;
            case "CAMERA":
                return f67163b;
            default:
                return new String[]{str};
        }
    }
}
