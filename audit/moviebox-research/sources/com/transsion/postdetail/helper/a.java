package com.transsion.postdetail.helper;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.applovin.sdk.AppLovinEventTypes;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baselib.report.h;
import com.transsion.baselib.report.m;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Link;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.s;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f55063a = new a();

    public static /* synthetic */ void B(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "postdetail";
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        aVar.A(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void b(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "postdetail";
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        aVar.a(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void d(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "postdetail";
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        aVar.c(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void f(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "postdetail";
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        aVar.e(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void i(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "postdetail";
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        aVar.h(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void k(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "postdetail";
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        aVar.j(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void n(a aVar, PostSubjectItem postSubjectItem, boolean z11, String str, String str2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str = "postdetail";
        }
        if ((i11 & 8) != 0) {
            str2 = null;
        }
        aVar.m(postSubjectItem, z11, str, str2);
    }

    public static /* synthetic */ void r(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "postdetail";
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        aVar.q(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void t(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "postdetail";
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        aVar.s(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void z(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "postdetail";
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        aVar.y(postSubjectItem, str, str2);
    }

    public final void A(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.g(pageName, "pageName");
        o(postSubjectItem, "subject", pageName, str);
    }

    public final void a(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.g(pageName, "pageName");
        o(postSubjectItem, "audio_play", pageName, str);
    }

    public final void c(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.g(pageName, "pageName");
        o(postSubjectItem, "avatar", pageName, str);
    }

    public final void e(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.g(pageName, "pageName");
        o(postSubjectItem, "comment", pageName, str);
    }

    public final void g(String postId, String moduleName, String pageName, String str) {
        Intrinsics.g(postId, "postId");
        Intrinsics.g(moduleName, "moduleName");
        Intrinsics.g(pageName, "pageName");
        HashMap map = new HashMap();
        map.put("module_name", moduleName);
        map.put("post_id", postId);
        if (str != null && str.length() != 0) {
            map.put(WebConstants.PAGE_FROM, str);
        }
        com.transsion.baselib.helper.a.f51183a.f(pageName, map);
    }

    public final void h(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.g(pageName, "pageName");
        o(postSubjectItem, DownloadBaseRunnable.TAG, pageName, str);
    }

    public final void j(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.g(pageName, "pageName");
        o(postSubjectItem, "group", pageName, str);
    }

    public final void l(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.g(pageName, "pageName");
        o(postSubjectItem, "image", pageName, str);
    }

    public final void m(PostSubjectItem postSubjectItem, boolean z11, String pageName, String str) {
        Intrinsics.g(pageName, "pageName");
        o(postSubjectItem, z11 ? "dislike" : "like", pageName, str);
    }

    public final void o(PostSubjectItem postSubjectItem, String str, String str2, String str3) {
        String subjectId;
        String postId;
        String value;
        String value2;
        String value3;
        String groupId;
        String title;
        String url;
        String ops;
        User user;
        String userId;
        Link link;
        Group group;
        Media media;
        Media media2;
        Subject subject;
        Subject subject2;
        HashMap map = new HashMap();
        if (str3 != null && str3.length() != 0) {
            map.put(WebConstants.PAGE_FROM, str3);
        }
        map.put("module_name", str);
        String str4 = "";
        if (postSubjectItem == null || (subject2 = postSubjectItem.getSubject()) == null || (subjectId = subject2.getSubjectId()) == null) {
            subjectId = "";
        }
        map.put("subject_id", subjectId);
        map.put("has_resource", String.valueOf((postSubjectItem == null || (subject = postSubjectItem.getSubject()) == null) ? null : subject.getHasResource()));
        if (postSubjectItem == null || (postId = postSubjectItem.getPostId()) == null) {
            postId = "";
        }
        map.put("post_id", postId);
        if (postSubjectItem == null || (media2 = postSubjectItem.getMedia()) == null || (value = media2.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        map.put("post_media_type", value);
        if (postSubjectItem == null || (value2 = postSubjectItem.getItemType()) == null) {
            value2 = PostItemType.SUBJECT.getValue();
        }
        map.put("item_type", value2);
        if (postSubjectItem == null || (media = postSubjectItem.getMedia()) == null || (value3 = media.getMediaType()) == null) {
            value3 = MediaType.TEXT.getValue();
        }
        map.put("post_media_type", value3);
        if (postSubjectItem == null || (group = postSubjectItem.getGroup()) == null || (groupId = group.getGroupId()) == null) {
            groupId = "";
        }
        map.put("group_id", groupId);
        if (postSubjectItem == null || (title = postSubjectItem.getTitle()) == null) {
            title = "";
        }
        map.put(CampaignEx.JSON_KEY_TITLE, title);
        if (postSubjectItem == null || (link = postSubjectItem.getLink()) == null || (url = link.getUrl()) == null) {
            url = "";
        }
        map.put("link_url", url);
        if (postSubjectItem == null || (ops = postSubjectItem.getOps()) == null) {
            ops = "";
        }
        map.put("ops", ops);
        if (postSubjectItem != null && (user = postSubjectItem.getUser()) != null && (userId = user.getUserId()) != null) {
            str4 = userId;
        }
        map.put("avatar_user_id", str4);
        com.transsion.baselib.helper.a.f51183a.f(str2, map);
    }

    public final void p(String pageName, String subpageName, long j11, h hVar) {
        HashMap<String, String> mapG;
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(subpageName, "subpageName");
        Map<String, String> mapL = s.l(TuplesKt.a("subpage_name", subpageName), TuplesKt.a("duration", String.valueOf(j11)));
        if (hVar != null && (mapG = hVar.g()) != null) {
            for (Map.Entry<String, String> entry : mapG.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                mapL.put(key, value);
            }
        }
        mapL.put("is_load_success", String.valueOf(hVar != null ? Boolean.valueOf(hVar.i()) : null));
        m.f51277a.t(pageName, "browse", mapL);
    }

    public final void q(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.g(pageName, "pageName");
        o(postSubjectItem, "pause", pageName, str);
    }

    public final void s(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.g(pageName, "pageName");
        o(postSubjectItem, MediaItem.MUSIC_FLOAT_STATE_PLAY, pageName, str);
    }

    public final void u(String str, String pageName, String subpageName, int i11, long j11, PostSubjectItem item, String str2) {
        String userId;
        String subjectId;
        String string;
        String value;
        Integer subjectType;
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(subpageName, "subpageName");
        Intrinsics.g(item, "item");
        Pair[] pairArr = new Pair[12];
        String postId = item.getPostId();
        if (postId == null) {
            postId = "";
        }
        pairArr[0] = TuplesKt.a("post_id", postId);
        pairArr[1] = TuplesKt.a(RequestParameters.POSITION, String.valueOf(i11));
        pairArr[2] = TuplesKt.a(WebConstants.PAGE_FROM, str);
        pairArr[3] = TuplesKt.a("browse_duration", String.valueOf(j11));
        pairArr[4] = TuplesKt.a("subpage_name", subpageName);
        pairArr[5] = TuplesKt.a("module_name", WebConstants.FIELD_ITEM);
        User user = item.getUser();
        if (user == null || (userId = user.getUserId()) == null) {
            userId = "";
        }
        pairArr[6] = TuplesKt.a("user_id", userId);
        if (str2 == null) {
            Group group = item.getGroup();
            str2 = group != null ? group.getGroupId() : null;
            if (str2 == null) {
                str2 = "";
            }
        }
        pairArr[7] = TuplesKt.a("group_id", str2);
        Subject subject = item.getSubject();
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            subjectId = "";
        }
        pairArr[8] = TuplesKt.a("subject_id", subjectId);
        Subject subject2 = item.getSubject();
        if (subject2 == null || (subjectType = subject2.getSubjectType()) == null || (string = subjectType.toString()) == null) {
            string = "";
        }
        pairArr[9] = TuplesKt.a("subject_type", string);
        Media media = item.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        pairArr[10] = TuplesKt.a("post_media_type", value);
        String ops = item.getOps();
        pairArr[11] = TuplesKt.a("ops", ops != null ? ops : "");
        m.f51277a.t(pageName, "browse", s.l(pairArr));
    }

    public final void w(String str, String pageName, String subpageName, int i11, String moduleName, PostSubjectItem item, String str2) {
        String userId;
        String subjectId;
        String value;
        Integer subjectType;
        String string;
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(subpageName, "subpageName");
        Intrinsics.g(moduleName, "moduleName");
        Intrinsics.g(item, "item");
        Pair[] pairArr = new Pair[11];
        String postId = item.getPostId();
        String str3 = "";
        if (postId == null) {
            postId = "";
        }
        pairArr[0] = TuplesKt.a("post_id", postId);
        pairArr[1] = TuplesKt.a(RequestParameters.POSITION, String.valueOf(i11));
        pairArr[2] = TuplesKt.a(WebConstants.PAGE_FROM, str);
        pairArr[3] = TuplesKt.a("subpage_name", subpageName);
        pairArr[4] = TuplesKt.a("module_name", moduleName);
        User user = item.getUser();
        if (user == null || (userId = user.getUserId()) == null) {
            userId = "";
        }
        pairArr[5] = TuplesKt.a("user_id", userId);
        if (str2 == null) {
            Group group = item.getGroup();
            str2 = group != null ? group.getGroupId() : null;
            if (str2 == null) {
                str2 = "";
            }
        }
        pairArr[6] = TuplesKt.a("group_id", str2);
        Subject subject = item.getSubject();
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            subjectId = "";
        }
        pairArr[7] = TuplesKt.a("subject_id", subjectId);
        Subject subject2 = item.getSubject();
        if (subject2 != null && (subjectType = subject2.getSubjectType()) != null && (string = subjectType.toString()) != null) {
            str3 = string;
        }
        pairArr[8] = TuplesKt.a("subject_type", str3);
        Media media = item.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        pairArr[9] = TuplesKt.a("post_media_type", value);
        pairArr[10] = TuplesKt.a("ops", item.getOps());
        m.f51277a.t(pageName, "click", s.l(pairArr));
    }

    public final void y(PostSubjectItem postSubjectItem, String pageName, String str) {
        Intrinsics.g(pageName, "pageName");
        o(postSubjectItem, AppLovinEventTypes.USER_SHARED_LINK, pageName, str);
    }
}
