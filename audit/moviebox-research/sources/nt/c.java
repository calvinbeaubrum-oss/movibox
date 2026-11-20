package nt;

import com.transsion.baselib.report.m;
import com.transsion.home.adapter.trending.TrendingAdapter;
import com.transsion.moviedetailapi.bean.ExplainBean;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet<String> f72162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f72163b;

    public c(String page) {
        Intrinsics.g(page, "page");
        this.f72163b = page;
    }

    public final void a(TrendingAdapter adapter, int i11, long j11) {
        List<ExplainBean> explains;
        Boolean hasResource;
        String subjectId;
        HashSet<String> hashSet;
        Intrinsics.g(adapter, "adapter");
        if (i11 >= adapter.D().size()) {
            return;
        }
        OperateItem item = adapter.getItem(i11);
        if (Intrinsics.b(item.getType(), PostItemType.SINGLE_SUBJECT.getValue()) || Intrinsics.b(item.getType(), PostItemType.SUBJECT.getValue())) {
            if (this.f72162a == null) {
                this.f72162a = new HashSet<>();
            }
            HashMap map = new HashMap();
            HashSet<String> hashSet2 = this.f72162a;
            if (hashSet2 != null) {
                Subject feedsSubject = item.getFeedsSubject();
                if (CollectionsKt___CollectionsKt.X(hashSet2, feedsSubject != null ? feedsSubject.getSubjectId() : null)) {
                    uo.b.a aVar = uo.b.f78622a;
                    Subject feedsSubject2 = item.getFeedsSubject();
                    uo.b.a.f(aVar, "reportExposure", "trendFragment position:" + i11 + ",subjectId: + " + (feedsSubject2 != null ? feedsSubject2.getSubjectId() : null) + "}", false, 4, null);
                    return;
                }
            }
            Subject feedsSubject3 = item.getFeedsSubject();
            if (feedsSubject3 != null && (subjectId = feedsSubject3.getSubjectId()) != null && subjectId.length() > 0 && (hashSet = this.f72162a) != null) {
                Subject feedsSubject4 = item.getFeedsSubject();
                String subjectId2 = feedsSubject4 != null ? feedsSubject4.getSubjectId() : null;
                Intrinsics.d(subjectId2);
                hashSet.add(subjectId2);
            }
            map.put("sequence", String.valueOf(i11));
            map.put("item_type", "rec");
            Subject feedsSubject5 = item.getFeedsSubject();
            map.put("ops", feedsSubject5 != null ? feedsSubject5.getOps() : null);
            Subject feedsSubject6 = item.getFeedsSubject();
            map.put("subject_id", feedsSubject6 != null ? feedsSubject6.getSubjectId() : null);
            map.put("browse_duration", String.valueOf(j11));
            Subject feedsSubject7 = item.getFeedsSubject();
            map.put("has_resource", (feedsSubject7 == null || (hasResource = feedsSubject7.getHasResource()) == null) ? null : hasResource.toString());
            Subject feedsSubject8 = item.getFeedsSubject();
            map.put("is_cache", String.valueOf(feedsSubject8 != null ? Boolean.valueOf(feedsSubject8.isCache()) : null));
            Subject feedsSubject9 = item.getFeedsSubject();
            map.put("load_cover_success", String.valueOf(feedsSubject9 != null ? Boolean.valueOf(feedsSubject9.getLoadCoverSuccess()) : null));
            Subject feedsSubject10 = item.getFeedsSubject();
            map.put("load_cover_duration", String.valueOf(feedsSubject10 != null ? Long.valueOf(feedsSubject10.getLoadCoverDuration()) : null));
            Subject feedsSubject11 = item.getFeedsSubject();
            map.put("cover_cache", String.valueOf(feedsSubject11 != null ? Boolean.valueOf(feedsSubject11.getCoverCache()) : null));
            Subject feedsSubject12 = item.getFeedsSubject();
            map.put("builtin", (feedsSubject12 == null || !feedsSubject12.getBuiltIn()) ? "0" : "1");
            StringBuilder sb2 = new StringBuilder();
            Subject feedsSubject13 = item.getFeedsSubject();
            if (feedsSubject13 != null && (explains = feedsSubject13.getExplains()) != null) {
                Iterator<T> it = explains.iterator();
                while (it.hasNext()) {
                    sb2.append(((ExplainBean) it.next()).getType());
                    sb2.append(",");
                }
            }
            String string = sb2.toString();
            Intrinsics.f(string, "explains.toString()");
            map.put("rec_explain_type", StringsKt__StringsKt.b1(string, ','));
            m.f51277a.t(this.f72163b, "browse", map);
        }
    }

    public final void b(int i11, Subject item) {
        Intrinsics.g(item, "item");
        HashMap map = new HashMap();
        map.put("sequence", String.valueOf(i11));
        map.put("item_type", "rec");
        map.put("ops", item.getOps());
        map.put("subject_id", item.getSubjectId());
        map.put("builtin", item.getBuiltIn() ? "1" : "0");
        StringBuilder sb2 = new StringBuilder();
        List<ExplainBean> explains = item.getExplains();
        if (explains != null) {
            Iterator<T> it = explains.iterator();
            while (it.hasNext()) {
                sb2.append(((ExplainBean) it.next()).getType());
                sb2.append(",");
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "explains.toString()");
        map.put("rec_explain_type", StringsKt__StringsKt.b1(string, ','));
        m.f51277a.m(this.f72163b, "click", map);
    }
}
