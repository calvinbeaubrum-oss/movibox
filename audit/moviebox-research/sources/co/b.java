package co;

import android.annotation.TargetApi;
import com.vungle.warren.error.VungleException;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.r;
import kotlin.collections.s;
import kotlin.collections.w;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f15005a = w.i("android.permission.ACCESS_BACKGROUND_LOCATION", "android.permission.SYSTEM_ALERT_WINDOW", "android.permission.WRITE_SETTINGS", "android.permission.MANAGE_EXTERNAL_STORAGE", "android.permission.REQUEST_INSTALL_PACKAGES", "android.permission.POST_NOTIFICATIONS", "android.permission.PICTURE_IN_PICTURE", "android.permission.BODY_SENSORS_BACKGROUND");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @TargetApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static final Map<String, String> f15006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @TargetApi(30)
    public static final Map<String, String> f15007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @TargetApi(VungleException.WEB_CRASH)
    public static final Map<String, String> f15008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @TargetApi(33)
    public static final Map<String, String> f15009e;

    static {
        Map<String, String> mapK = s.k(TuplesKt.a("android.permission.READ_CALENDAR", "android.permission-group.CALENDAR"), TuplesKt.a("android.permission.WRITE_CALENDAR", "android.permission-group.CALENDAR"), TuplesKt.a("android.permission.READ_CALL_LOG", "android.permission-group.CALL_LOG"), TuplesKt.a("android.permission.WRITE_CALL_LOG", "android.permission-group.CALL_LOG"), TuplesKt.a("android.permission.PROCESS_OUTGOING_CALLS", "android.permission-group.CALL_LOG"), TuplesKt.a("android.permission.CAMERA", "android.permission-group.CAMERA"), TuplesKt.a("android.permission.READ_CONTACTS", "android.permission-group.CONTACTS"), TuplesKt.a("android.permission.WRITE_CONTACTS", "android.permission-group.CONTACTS"), TuplesKt.a("android.permission.GET_ACCOUNTS", "android.permission-group.CONTACTS"), TuplesKt.a("android.permission.ACCESS_FINE_LOCATION", "android.permission-group.LOCATION"), TuplesKt.a("android.permission.ACCESS_COARSE_LOCATION", "android.permission-group.LOCATION"), TuplesKt.a("android.permission.ACCESS_BACKGROUND_LOCATION", "android.permission-group.LOCATION"), TuplesKt.a("android.permission.RECORD_AUDIO", "android.permission-group.MICROPHONE"), TuplesKt.a("android.permission.READ_PHONE_STATE", "android.permission-group.PHONE"), TuplesKt.a("android.permission.READ_PHONE_NUMBERS", "android.permission-group.PHONE"), TuplesKt.a("android.permission.CALL_PHONE", "android.permission-group.PHONE"), TuplesKt.a("android.permission.ANSWER_PHONE_CALLS", "android.permission-group.PHONE"), TuplesKt.a("com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission-group.PHONE"), TuplesKt.a("android.permission.USE_SIP", "android.permission-group.PHONE"), TuplesKt.a("android.permission.ACCEPT_HANDOVER", "android.permission-group.PHONE"), TuplesKt.a("android.permission.BODY_SENSORS", "android.permission-group.SENSORS"), TuplesKt.a("android.permission.ACTIVITY_RECOGNITION", "android.permission-group.ACTIVITY_RECOGNITION"), TuplesKt.a("android.permission.SEND_SMS", "android.permission-group.SMS"), TuplesKt.a("android.permission.RECEIVE_SMS", "android.permission-group.SMS"), TuplesKt.a("android.permission.READ_SMS", "android.permission-group.SMS"), TuplesKt.a("android.permission.RECEIVE_WAP_PUSH", "android.permission-group.SMS"), TuplesKt.a("android.permission.RECEIVE_MMS", "android.permission-group.SMS"), TuplesKt.a("android.permission.READ_EXTERNAL_STORAGE", "android.permission-group.STORAGE"), TuplesKt.a("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission-group.STORAGE"), TuplesKt.a("android.permission.ACCESS_MEDIA_LOCATION", "android.permission-group.STORAGE"));
        f15006b = mapK;
        Map mapV = s.v(r.f(TuplesKt.a("android.permission.MANAGE_EXTERNAL_STORAGE", "android.permission-group.STORAGE")));
        mapV.putAll(mapK);
        Map<String, String> mapT = s.t(mapV);
        f15007c = mapT;
        Map mapV2 = s.v(s.k(TuplesKt.a("android.permission.BLUETOOTH_SCAN", "android.permission-group.NEARBY_DEVICES"), TuplesKt.a("android.permission.BLUETOOTH_ADVERTISE", "android.permission-group.NEARBY_DEVICES"), TuplesKt.a("android.permission.BLUETOOTH_CONNECT", "android.permission-group.NEARBY_DEVICES")));
        mapV2.putAll(mapT);
        Map<String, String> mapT2 = s.t(mapV2);
        f15008d = mapT2;
        Map mapV3 = s.v(s.k(TuplesKt.a("android.permission.READ_MEDIA_IMAGES", "android.permission-group.READ_MEDIA_VISUAL"), TuplesKt.a("android.permission.READ_MEDIA_VIDEO", "android.permission-group.READ_MEDIA_VISUAL"), TuplesKt.a("android.permission.READ_MEDIA_AUDIO", "android.permission-group.READ_MEDIA_AURAL"), TuplesKt.a("android.permission.POST_NOTIFICATIONS", "android.permission-group.NOTIFICATIONS"), TuplesKt.a("android.permission.NEARBY_WIFI_DEVICES", "android.permission-group.NEARBY_DEVICES"), TuplesKt.a("android.permission.BODY_SENSORS_BACKGROUND", "android.permission-group.SENSORS")));
        mapV3.putAll(mapT2);
        f15009e = s.t(mapV3);
    }

    public static final Set<String> a() {
        return f15005a;
    }
}
