package uv;

import com.transsion.baselib.report.m;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.ui.adapter.c;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uo.b;

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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet<PostSubjectItem> f78644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f78645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f78646c;

    public a(String page, String postId) {
        Intrinsics.g(page, "page");
        Intrinsics.g(postId, "postId");
        this.f78645b = page;
        this.f78646c = postId;
    }

    public final void a(c adapter, int i11, long j11) {
        Boolean hasResource;
        Intrinsics.g(adapter, "adapter");
        if (i11 >= adapter.D().size()) {
            return;
        }
        PostSubjectItem item = adapter.getItem(i11);
        if (this.f78644a == null) {
            this.f78644a = new HashSet<>();
        }
        HashMap map = new HashMap();
        HashSet<PostSubjectItem> hashSet = this.f78644a;
        String string = null;
        if (hashSet != null && hashSet.contains(item)) {
            b.a aVar = b.f78622a;
            String postId = item.getPostId();
            Media media = item.getMedia();
            b.a.f(aVar, "reportExposure", "trendFragment position:" + i11 + ",videoId: + " + postId + "  mediaType: " + (media != null ? media.getMediaType() : null), false, 4, null);
            return;
        }
        HashSet<PostSubjectItem> hashSet2 = this.f78644a;
        if (hashSet2 != null) {
            hashSet2.add(item);
        }
        map.put("post_id", item.getPostId());
        map.put("origin_post_id", this.f78646c);
        map.put("sequence", String.valueOf(i11));
        map.put("item_type", item.getItemType());
        map.put("ops", item.getOps());
        Media media2 = item.getMedia();
        map.put("post_media_type", media2 != null ? media2.getMediaType() : null);
        Subject subject = item.getSubject();
        map.put("subject_id", subject != null ? subject.getSubjectId() : null);
        Group group = item.getGroup();
        map.put("group_id", group != null ? group.getGroupId() : null);
        map.put("browse_duration", String.valueOf(j11));
        Subject subject2 = item.getSubject();
        if (subject2 != null && (hasResource = subject2.getHasResource()) != null) {
            string = hasResource.toString();
        }
        map.put("has_resource", string);
        m.f51277a.t(this.f78645b, "browse", map);
    }

    public final void b(int i11, PostSubjectItem item) {
        Intrinsics.g(item, "item");
        HashMap map = new HashMap();
        map.put("post_id", item.getPostId());
        map.put("origin_post_id", this.f78646c);
        map.put("sequence", String.valueOf(i11));
        map.put("item_type", item.getItemType());
        map.put("ops", item.getOps());
        Media media = item.getMedia();
        map.put("post_media_type", media != null ? media.getMediaType() : null);
        Subject subject = item.getSubject();
        map.put("subject_id", subject != null ? subject.getSubjectId() : null);
        Group group = item.getGroup();
        map.put("group_id", group != null ? group.getGroupId() : null);
        m.f51277a.m(this.f78645b, "click", map);
    }
}
