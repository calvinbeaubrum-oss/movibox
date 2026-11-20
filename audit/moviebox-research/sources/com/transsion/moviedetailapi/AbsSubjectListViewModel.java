package com.transsion.moviedetailapi;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.LikeBean;
import com.transsion.moviedetailapi.bean.Link;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.moviedetailapi.p005enum.PostListSource;
import com.transsion.moviedetailapi.p005enum.ProfileSubSource;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public abstract class AbsSubjectListViewModel extends b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f53866k = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f53867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f53868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f53869d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f53870f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f53871g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f53872h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f53873i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PostRankType f53874j;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsSubjectListViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f53867b = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<yu.a>() { // from class: com.transsion.moviedetailapi.AbsSubjectListViewModel$service$2
            @Override // kotlin.jvm.functions.Function0
            public final yu.a invoke() {
                return (yu.a) NetServiceGenerator.f49399d.a().i(yu.a.class);
            }
        });
        this.f53868c = LazyKt__LazyJVMKt.b(new Function0<c0<PostSubjectBean>>() { // from class: com.transsion.moviedetailapi.AbsSubjectListViewModel$postSubjectLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<PostSubjectBean> invoke() {
                return new c0<>();
            }
        });
        this.f53869d = LazyKt__LazyJVMKt.b(new Function0<c0<List<? extends PostSubjectItem>>>() { // from class: com.transsion.moviedetailapi.AbsSubjectListViewModel$addSubjectLiveData$2
            @Override // kotlin.jvm.functions.Function0
            public final c0<List<? extends PostSubjectItem>> invoke() {
                return new c0<>();
            }
        });
        this.f53870f = LazyKt__LazyJVMKt.b(new Function0<c0<List<? extends PostSubjectItem>>>() { // from class: com.transsion.moviedetailapi.AbsSubjectListViewModel$delSubjectLiveData$2
            @Override // kotlin.jvm.functions.Function0
            public final c0<List<? extends PostSubjectItem>> invoke() {
                return new c0<>();
            }
        });
        this.f53871g = LazyKt__LazyJVMKt.b(new Function0<c0<LikeBean>>() { // from class: com.transsion.moviedetailapi.AbsSubjectListViewModel$likeLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<LikeBean> invoke() {
                return new c0<>();
            }
        });
        this.f53872h = LazyKt__LazyJVMKt.b(new Function0<c0<BaseDto<String>>>() { // from class: com.transsion.moviedetailapi.AbsSubjectListViewModel$deleteLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<BaseDto<String>> invoke() {
                return new c0<>();
            }
        });
        this.f53873i = "";
        this.f53874j = PostRankType.POST_RANK_TYPE_DEFAULT;
    }

    public final void A(PostRankType postRankType) {
        Intrinsics.g(postRankType, "<set-?>");
        this.f53874j = postRankType;
    }

    public final void B(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f53873i = str;
    }

    public final void d(String str) {
        j.d(u0.a(this), null, null, new AbsSubjectListViewModel$deletePost$1(str, this, null), 3, null);
    }

    public final LiveData<List<PostSubjectItem>> e() {
        return f();
    }

    public final c0<List<PostSubjectItem>> f() {
        return (c0) this.f53869d.getValue();
    }

    public final c0<BaseDto<String>> g() {
        return (c0) this.f53872h.getValue();
    }

    public Map<String, String> h(int i11) {
        return null;
    }

    public final LiveData<LikeBean> i() {
        return j();
    }

    public final c0<LikeBean> j() {
        return (c0) this.f53871g.getValue();
    }

    public final PostRankType k() {
        return this.f53874j;
    }

    public Map<String, String> l(int i11) {
        return null;
    }

    public final String m() {
        return this.f53873i;
    }

    public String n(int i11) {
        return "";
    }

    public final LiveData<PostSubjectBean> o() {
        return p();
    }

    public final c0<PostSubjectBean> p() {
        return (c0) this.f53868c.getValue();
    }

    public final yu.a q() {
        return (yu.a) this.f53867b.getValue();
    }

    public abstract PostListSource r();

    public ProfileSubSource s() {
        return null;
    }

    public void t(String str, int i11) {
        j.d(u0.a(this), null, null, new AbsSubjectListViewModel$like$1(str, i11, this, null), 3, null);
    }

    public abstract void u(boolean z11);

    public abstract void v(Bundle bundle);

    public void w(PostSubjectItem postSubjectItem, int i11) {
        String subjectId;
        String value;
        String groupId;
        String subjectId2;
        String url;
        String userId;
        Intrinsics.g(postSubjectItem, "postSubjectItem");
        HashMap map = new HashMap();
        Subject subject = postSubjectItem.getSubject();
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            subjectId = "";
        }
        map.put("subject_id", subjectId);
        Subject subject2 = postSubjectItem.getSubject();
        map.put("has_resource", String.valueOf(subject2 != null ? subject2.getHasResource() : null));
        String postId = postSubjectItem.getPostId();
        if (postId == null) {
            postId = "";
        }
        map.put("post_id", postId);
        Media media = postSubjectItem.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        map.put("post_media_type", value);
        Group group = postSubjectItem.getGroup();
        if (group == null || (groupId = group.getGroupId()) == null) {
            groupId = "";
        }
        map.put("group_id", groupId);
        Subject subject3 = postSubjectItem.getSubject();
        if (subject3 == null || (subjectId2 = subject3.getSubjectId()) == null) {
            subjectId2 = "";
        }
        map.put("subject_id", subjectId2);
        String content = postSubjectItem.getContent();
        if (content == null) {
            content = "";
        }
        map.put("link_url", content);
        Link link = postSubjectItem.getLink();
        if (link == null || (url = link.getUrl()) == null) {
            url = "";
        }
        map.put("link_url", url);
        User user = postSubjectItem.getUser();
        if (user == null || (userId = user.getUserId()) == null) {
            userId = "";
        }
        map.put("avatar_user_id", userId);
        map.put("sequence", String.valueOf(i11));
        String ops = postSubjectItem.getOps();
        if (ops == null) {
            ops = "";
        }
        map.put("ops", ops);
        map.put(WebConstants.PAGE_FROM, this.f53873i);
        Map<String, String> mapH = h(this.f53874j.ordinal());
        if (mapH != null) {
            for (Map.Entry<String, String> entry : mapH.entrySet()) {
                String key = entry.getKey();
                String value2 = entry.getValue();
                if (value2 == null) {
                    value2 = "";
                }
                map.put(key, value2);
            }
        }
        com.transsion.baselib.helper.a.f51183a.d(n(this.f53874j.ordinal()), map);
    }

    public void x(PostSubjectItem postSubjectItem, int i11, String subPageName) {
        String subjectId;
        String value;
        String groupId;
        String subjectId2;
        String url;
        String userId;
        Intrinsics.g(postSubjectItem, "postSubjectItem");
        Intrinsics.g(subPageName, "subPageName");
        HashMap map = new HashMap();
        Subject subject = postSubjectItem.getSubject();
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            subjectId = "";
        }
        map.put("subject_id", subjectId);
        Subject subject2 = postSubjectItem.getSubject();
        map.put("has_resource", String.valueOf(subject2 != null ? subject2.getHasResource() : null));
        String postId = postSubjectItem.getPostId();
        if (postId == null) {
            postId = "";
        }
        map.put("post_id", postId);
        Media media = postSubjectItem.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        map.put("post_media_type", value);
        Group group = postSubjectItem.getGroup();
        if (group == null || (groupId = group.getGroupId()) == null) {
            groupId = "";
        }
        map.put("group_id", groupId);
        Subject subject3 = postSubjectItem.getSubject();
        if (subject3 == null || (subjectId2 = subject3.getSubjectId()) == null) {
            subjectId2 = "";
        }
        map.put("subject_id", subjectId2);
        String title = postSubjectItem.getTitle();
        if (title == null) {
            title = "";
        }
        map.put(CampaignEx.JSON_KEY_TITLE, title);
        Link link = postSubjectItem.getLink();
        if (link == null || (url = link.getUrl()) == null) {
            url = "";
        }
        map.put("link_url", url);
        User user = postSubjectItem.getUser();
        if (user == null || (userId = user.getUserId()) == null) {
            userId = "";
        }
        map.put("avatar_user_id", userId);
        map.put("sequence", String.valueOf(i11));
        String ops = postSubjectItem.getOps();
        if (ops == null) {
            ops = "";
        }
        map.put("ops", ops);
        map.put(WebConstants.PAGE_FROM, this.f53873i);
        map.put("module_name", WebConstants.FIELD_ITEM);
        map.put("subpage_name", subPageName);
        Map<String, String> mapH = h(this.f53874j.ordinal());
        if (mapH != null) {
            for (Map.Entry<String, String> entry : mapH.entrySet()) {
                String key = entry.getKey();
                String value2 = entry.getValue();
                if (value2 == null) {
                    value2 = "";
                }
                map.put(key, value2);
            }
        }
        com.transsion.baselib.helper.a.f51183a.e(n(this.f53874j.ordinal()), map);
    }

    public void y(PostSubjectItem postSubjectItem, int i11, String moduleName, String subPageName) {
        Intrinsics.g(postSubjectItem, "postSubjectItem");
        Intrinsics.g(moduleName, "moduleName");
        Intrinsics.g(subPageName, "subPageName");
        Link link = postSubjectItem.getLink();
        z(postSubjectItem, i11, moduleName, link != null ? link.getUrl() : null, subPageName);
    }

    public void z(PostSubjectItem postSubjectItem, int i11, String moduleName, String str, String str2) {
        String subjectId;
        String value;
        String value2;
        String groupId;
        String userId;
        Intrinsics.g(postSubjectItem, "postSubjectItem");
        Intrinsics.g(moduleName, "moduleName");
        HashMap map = new HashMap();
        map.put("module_name", moduleName);
        if (str2 == null) {
            str2 = "";
        }
        map.put("subpage_name", str2);
        Subject subject = postSubjectItem.getSubject();
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            subjectId = "";
        }
        map.put("subject_id", subjectId);
        Subject subject2 = postSubjectItem.getSubject();
        map.put("has_resource", String.valueOf(subject2 != null ? subject2.getHasResource() : null));
        String postId = postSubjectItem.getPostId();
        if (postId == null) {
            postId = "";
        }
        map.put("post_id", postId);
        Media media = postSubjectItem.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        map.put("post_media_type", value);
        String itemType = postSubjectItem.getItemType();
        if (itemType == null) {
            itemType = PostItemType.SUBJECT.getValue();
        }
        map.put("item_type", itemType);
        Media media2 = postSubjectItem.getMedia();
        if (media2 == null || (value2 = media2.getMediaType()) == null) {
            value2 = MediaType.TEXT.getValue();
        }
        map.put("post_media_type", value2);
        Group group = postSubjectItem.getGroup();
        if (group == null || (groupId = group.getGroupId()) == null) {
            groupId = "";
        }
        map.put("group_id", groupId);
        String title = postSubjectItem.getTitle();
        if (title == null) {
            title = "";
        }
        map.put(CampaignEx.JSON_KEY_TITLE, title);
        if (str == null) {
            str = "";
        }
        map.put("link_url", str);
        String ops = postSubjectItem.getOps();
        if (ops == null) {
            ops = "";
        }
        map.put("ops", ops);
        map.put(WebConstants.PAGE_FROM, this.f53873i);
        User user = postSubjectItem.getUser();
        if (user == null || (userId = user.getUserId()) == null) {
            userId = "";
        }
        map.put("avatar_user_id", userId);
        map.put("sequence", String.valueOf(i11));
        Map<String, String> mapL = l(this.f53874j.ordinal());
        if (mapL != null) {
            for (Map.Entry<String, String> entry : mapL.entrySet()) {
                String key = entry.getKey();
                String value3 = entry.getValue();
                if (value3 == null) {
                    value3 = "";
                }
                map.put(key, value3);
            }
        }
        com.transsion.baselib.helper.a.f51183a.f(n(this.f53874j.ordinal()), map);
    }
}
