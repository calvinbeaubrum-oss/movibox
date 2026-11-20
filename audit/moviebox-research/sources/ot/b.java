package ot;

import com.applovin.sdk.AppLovinEventTypes;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
    public static final void a(OperateItem operateItem, Map<String, String> map) {
        Intrinsics.g(operateItem, "<this>");
        Intrinsics.g(map, "map");
        map.put("item_type", "opt");
        String type = operateItem.getType();
        if (type == null) {
            type = "";
        }
        map.put("opt_type", type);
        String title = operateItem.getTitle();
        if (title == null) {
            title = "";
        }
        map.put("opTitle", title);
        String opId = operateItem.getOpId();
        map.put("opId", opId != null ? opId : "");
    }

    public static final void b(BannerData bannerData, Map<String, String> map) {
        Intrinsics.g(bannerData, "<this>");
        Intrinsics.g(map, "map");
        String subjectId = bannerData.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        map.put("subject_id", subjectId);
        map.put("has_resource", String.valueOf(bannerData.getHasResource()));
        map.put("subject_type", String.valueOf(bannerData.getSubjectType()));
        map.put("type", String.valueOf(bannerData.getType()));
        String ops = bannerData.getOps();
        if (ops == null) {
            ops = "";
        }
        map.put("ops", ops);
        String content = bannerData.getContent();
        if (content == null) {
            content = "";
        }
        map.put(AppLovinEventTypes.USER_VIEWED_CONTENT, content);
        map.put("builtin", bannerData.getBuiltIn() ? "1" : "0");
        String deepLink = bannerData.getDeepLink();
        map.put(WebConstants.FIELD_DEEPLINK, deepLink != null ? deepLink : "");
        map.put("seenStatus", String.valueOf(bannerData.getSeenStatus()));
    }

    public static final void c(Subject subject, Map<String, String> map) {
        Intrinsics.g(subject, "<this>");
        Intrinsics.g(map, "map");
        String subjectId = subject.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        map.put("subject_id", subjectId);
        map.put("has_resource", String.valueOf(subject.getHasResource()));
        map.put("subject_type", String.valueOf(subject.getSubjectType()));
        String ops = subject.getOps();
        map.put("ops", ops != null ? ops : "");
        map.put("builtin", subject.getBuiltIn() ? "1" : "0");
        map.put("tag", String.valueOf(subject.getTags()));
        map.put("seenStatus", String.valueOf(subject.getSeenStatus()));
    }
}
