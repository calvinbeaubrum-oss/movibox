package com.transsion.home.adapter.suboperate.provider;

import android.view.View;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.home.adapter.trending.provider.SubjectItemProvider;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.utils.HomeUtilsKt;
import com.transsion.moviedetailapi.bean.ExplainBean;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
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
public final class j extends BaseItemProvider<OperateItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f52189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f52190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SubjectItemProvider f52191h;

    public j(int i11, boolean z11) {
        this.f52189f = i11;
        this.f52190g = z11;
        this.f52191h = new SubjectItemProvider(z11);
    }

    public static final void x(OperateItem item, j this$0, View view) {
        List<OperateItem> listD;
        Intrinsics.g(item, "$item");
        Intrinsics.g(this$0, "this$0");
        Subject feedsSubject = item.getFeedsSubject();
        if (feedsSubject != null) {
            HomeUtilsKt.b(feedsSubject, "opt_sub_feeds");
            BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = this$0.c();
            this$0.z((baseProviderMultiAdapterC == null || (listD = baseProviderMultiAdapterC.D()) == null) ? -1 : listD.indexOf(item), feedsSubject, false);
        }
    }

    public static final void y(OperateItem item, j this$0, View view) {
        Subject feedsSubject;
        List<OperateItem> listD;
        Intrinsics.g(item, "$item");
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) || (feedsSubject = item.getFeedsSubject()) == null) {
            return;
        }
        HomeUtilsKt.c(feedsSubject, SubTabFragment.f52541r.a(this$0.f52189f), this$0.g(), "opt_sub_feeds");
        BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = this$0.c();
        this$0.z((baseProviderMultiAdapterC == null || (listD = baseProviderMultiAdapterC.D()) == null) ? -1 : listD.indexOf(item), feedsSubject, false);
    }

    private final void z(int i11, Subject subject, boolean z11) {
        HashMap map = new HashMap();
        map.put("event_type", z11 ? "browse_feeds_item" : "click_feeds_item");
        map.put("sequence", String.valueOf(i11));
        map.put("item_type", "rec");
        String ops = subject.getOps();
        if (ops == null) {
            ops = "";
        }
        map.put("ops", ops);
        String subjectId = subject.getSubjectId();
        map.put("subject_id", subjectId != null ? subjectId : "");
        map.put("builtin", subject.getBuiltIn() ? "1" : "0");
        map.put("tabId", String.valueOf(this.f52189f));
        StringBuilder sb2 = new StringBuilder();
        List<ExplainBean> explains = subject.getExplains();
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
        ot.b.c(subject, map);
        if (z11) {
            com.transsion.baselib.helper.a.f51183a.d(SubTabFragment.f52541r.a(this.f52189f), map);
        } else {
            com.transsion.baselib.helper.a.f51183a.e(SubTabFragment.f52541r.a(this.f52189f), map);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.SUBJECT.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return this.f52191h.i();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, final OperateItem item) {
        List<OperateItem> listD;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        Subject feedsSubject = item.getFeedsSubject();
        if (feedsSubject != null) {
            this.f52191h.a(helper, item);
            BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = c();
            z((baseProviderMultiAdapterC == null || (listD = baseProviderMultiAdapterC.D()) == null) ? -1 : listD.indexOf(item), feedsSubject, true);
        }
        helper.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.x(item, this, view);
            }
        });
        View viewA = this.f52191h.A();
        if (viewA != null) {
            viewA.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.y(item, this, view);
                }
            });
        }
    }
}
