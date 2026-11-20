package ds;

import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventTypes;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.transsion.baselib.report.recent_event.ActionEvent;
import com.transsion.home.p003enum.HomeTabType;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.collections.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f63534a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ds.a<ActionEvent> f63535b = new ds.a<>(30);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, Integer> f63536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap<String, Integer> f63537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap<String, Integer> f63538e;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ActionEvent a(Map<String, String> map, String str) {
            String str2 = map.get("module_name");
            if (TextUtils.isEmpty(str2) || !b.f63536c.containsKey(str2)) {
                if (!TextUtils.equals(str, HomeTabType.TAB_CODE_TRENDING)) {
                    return null;
                }
                Integer num = (Integer) b.f63537d.get(str);
                return new ActionEvent(1, (num != null ? num : 0).intValue(), f(map.get("post_id")), f(map.get("subject_id")), f(map.get("group_id")), 0, 0, 96, null);
            }
            Integer num2 = (Integer) b.f63537d.get(str);
            int iIntValue = (num2 != null ? num2 : 0).intValue();
            String strF = f(map.get("post_id"));
            String strF2 = f(map.get("subject_id"));
            String strF3 = f(map.get("group_id"));
            HashMap map2 = b.f63536c;
            if (str2 == null) {
                str2 = "0";
            }
            return new ActionEvent(((Number) s.i(map2, str2)).intValue(), iIntValue, strF, strF2, strF3, 0, 0, 96, null);
        }

        public final ActionEvent b(Map<String, String> map, String str) {
            if (TextUtils.equals(str, "postdetail")) {
                Integer num = (Integer) b.f63537d.get(str);
                return new ActionEvent(15, (num != null ? num : 0).intValue(), f(map.get("post_id")), f(map.get("subject_id")), f(map.get("group_id")), 0, 0, 96, null);
            }
            if (!TextUtils.equals(str, "searchpage")) {
                return null;
            }
            Integer num2 = (Integer) b.f63537d.get(str);
            return new ActionEvent(19, (num2 != null ? num2 : 0).intValue(), "0", "0", "0", 0, 0, 96, null);
        }

        public final ActionEvent c(String str, Map<String, String> map, String str2) {
            if (!b.f63537d.containsKey(str2)) {
                return null;
            }
            Integer num = (Integer) b.f63537d.get(str2);
            if (num == null) {
                num = 0;
            }
            int iIntValue = num.intValue();
            String strF = f(map.get("post_id"));
            String strF2 = f(map.get("subject_id"));
            String strF3 = f(map.get("group_id"));
            String str3 = map.get("play_duration");
            int i11 = str3 != null ? Integer.parseInt(str3) : 0;
            String str4 = map.get("completeCount");
            int i12 = str4 != null ? Integer.parseInt(str4) : 0;
            Integer num2 = (Integer) b.f63538e.get(str);
            if (num2 != null) {
                return new ActionEvent(num2.intValue(), iIntValue, strF, strF2, strF3, i11, i12);
            }
            return null;
        }

        public final void d(String pageName, String event, Map<String, String> map) {
            ActionEvent actionEventC;
            Intrinsics.g(pageName, "pageName");
            Intrinsics.g(event, "event");
            Intrinsics.g(map, "map");
            if (TextUtils.equals(event, "click")) {
                actionEventC = a(map, pageName);
            } else if (TextUtils.equals(event, "pt")) {
                actionEventC = b(map, pageName);
            } else {
                actionEventC = (TextUtils.equals(event, "video_play") || TextUtils.equals(event, "audio_play")) ? c(event, map, pageName) : null;
            }
            if (actionEventC != null) {
                b.f63535b.offer(actionEventC);
            }
        }

        public final Queue<ActionEvent> e() {
            return b.f63535b;
        }

        public final String f(String str) {
            return (TextUtils.isEmpty(str) || str == null) ? "0" : str;
        }
    }

    static {
        HashMap<String, Integer> map = new HashMap<>();
        f63536c = map;
        HashMap<String, Integer> map2 = new HashMap<>();
        f63537d = map2;
        HashMap<String, Integer> map3 = new HashMap<>();
        f63538e = map3;
        map.put("unknow", 0);
        map.put("like", 3);
        map.put("dislike", 4);
        map.put("want_to_see", 5);
        map.put("i_have_seen", 6);
        map.put("create_review", 7);
        map.put("copylink", 8);
        map.put("whatsup", 8);
        map.put("Telegram", 8);
        map.put("create_post", 9);
        map.put("checkin", 10);
        map.put(AppLovinEventTypes.USER_COMPLETED_CHECKOUT, 11);
        map.put(DownloadBaseRunnable.TAG, 12);
        map.put("comment", 13);
        map.put("want_to_see_cancel", 17);
        map.put("searchpage", 19);
        map.put(AppLovinEventTypes.USER_EXECUTED_SEARCH, 20);
        map.put("download_subject", 21);
        map2.put(TmcEngineFactory.ENGINE_TYPE_DEFAULT, 0);
        map2.put(HomeTabType.TAB_CODE_TRENDING, 1);
        map2.put("roomdetail", 2);
        map2.put("subjectdetail", 3);
        map2.put("postdetail", 4);
        map3.put("click", 1);
        map3.put("audio_play", 2);
        map3.put("video_play", 2);
        map3.put("PT", 15);
    }
}
