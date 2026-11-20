package com.transsion.home.adapter.suboperate.provider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blankj.utilcode.util.d0;
import com.bumptech.glide.Priority;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.edcation.CourseManager;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p003enum.HomeTabId;
import com.transsion.home.utils.HomeUtilsKt;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ExplainBean;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.widget.DownloadView;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.w0;

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
@SourceDebugExtension
public final class SubFeedsEducationProvider extends BaseItemProvider<OperateItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f52117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f52118g = d0.e();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class MyViewHolder extends BaseViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f52119b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public q1 f52120c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public OperateItem f52121d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyViewHolder(int i11, View view) {
            super(view);
            Intrinsics.g(view, "view");
            this.f52119b = i11;
        }

        public final void g() {
            if (this.f52119b != HomeTabId.Education.getValue()) {
                return;
            }
            this.f52120c = kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new SubFeedsEducationProvider$MyViewHolder$registerCourse$1(this, null), 3, null);
        }

        public final void h(OperateItem item) {
            Intrinsics.g(item, "item");
            this.f52121d = item;
        }

        public final void i() {
            q1 q1Var = this.f52120c;
            if (q1Var != null) {
                q1.a.b(q1Var, null, 1, null);
            }
            this.f52120c = null;
        }

        public final void j() {
            Subject feedsSubject;
            Integer seenStatus;
            OperateItem operateItem = this.f52121d;
            if (operateItem == null || (feedsSubject = operateItem.getFeedsSubject()) == null || (seenStatus = feedsSubject.getSeenStatus()) == null || seenStatus.intValue() != 1) {
                DownloadView downloadView = (DownloadView) getViewOrNull(R$id.ll_download);
                if (downloadView != null) {
                    downloadView.setAddCourse();
                    return;
                }
                return;
            }
            DownloadView downloadView2 = (DownloadView) getViewOrNull(R$id.ll_download);
            if (downloadView2 != null) {
                downloadView2.setCourseAdded();
            }
        }
    }

    public SubFeedsEducationProvider(int i11) {
        this.f52117f = i11;
    }

    public static final void x(OperateItem item, SubFeedsEducationProvider this$0, View view) {
        List<OperateItem> listD;
        Intrinsics.g(item, "$item");
        Intrinsics.g(this$0, "this$0");
        Subject feedsSubject = item.getFeedsSubject();
        if (feedsSubject != null) {
            HomeUtilsKt.b(feedsSubject, "opt_sub_feeds");
            BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = this$0.c();
            this$0.A((baseProviderMultiAdapterC == null || (listD = baseProviderMultiAdapterC.D()) == null) ? -1 : listD.indexOf(item), feedsSubject, false);
        }
    }

    public static final void y(OperateItem item, Subject subject, SubFeedsEducationProvider this$0, View view) {
        Intrinsics.g(item, "$item");
        Intrinsics.g(this$0, "this$0");
        CourseManager.q(CourseManager.f51853a, item.getFeedsSubject(), null, 2, null);
        ct.a.b(subject, SubTabFragment.f52541r.a(this$0.f52117f), "opt_feeds");
    }

    private final String z(int i11) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String str = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i11 / 3600), Integer.valueOf((i11 % 3600) / 60), Integer.valueOf(i11 % 60)}, 3));
        Intrinsics.f(str, "format(...)");
        return str;
    }

    public final void A(int i11, Subject subject, boolean z11) {
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
        map.put("tabId", String.valueOf(this.f52117f));
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
            com.transsion.baselib.helper.a.f51183a.d(SubTabFragment.f52541r.a(this.f52117f), map);
        } else {
            com.transsion.baselib.helper.a.f51183a.e(SubTabFragment.f52541r.a(this.f52117f), map);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.EDUCATION_SUBJECT.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.post_list_item_subject_education;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder n(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        return new MyViewHolder(this.f52117f, i9.a.a(parent, i()));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void p(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.p(holder);
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).g();
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void q(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.q(holder);
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).i();
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, final OperateItem item) {
        String subjectId;
        List<OperateItem> listD;
        Integer seenStatus;
        String url;
        String thumbnail;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        if (helper instanceof MyViewHolder) {
            ((MyViewHolder) helper).h(item);
        }
        final Subject feedsSubject = item.getFeedsSubject();
        if (feedsSubject == null || (subjectId = feedsSubject.getSubjectId()) == null || subjectId.length() == 0) {
            return;
        }
        ShapeableImageView shapeableImageView = (ShapeableImageView) helper.getViewOrNull(R$id.iv_cover);
        if (shapeableImageView != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = shapeableImageView.getContext();
            Intrinsics.f(context, "context");
            Cover cover = feedsSubject.getCover();
            if (cover == null || (url = cover.getUrl()) == null) {
                url = "";
            }
            int i11 = R$color.skeleton;
            int i12 = this.f52118g;
            Cover cover2 = feedsSubject.getCover();
            if (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) {
                thumbnail = "";
            }
            companion.p(context, shapeableImageView, url, (65480 & 8) != 0 ? R$color.skeleton : i11, (65480 & 16) != 0 ? companion.d() : i12, (65480 & 32) != 0 ? companion.c() : 0, (65480 & 64) != 0 ? 0 : 0, (65480 & 128) != 0, (65480 & 256) != 0 ? "" : thumbnail, (65480 & 512) != 0, (65480 & 1024) != 0, (65480 & 2048) != 0 ? false : false, (65480 & 4096) != 0 ? false : false, (65480 & 8192) != 0 ? false : false, (65480 & 16384) != 0 ? 25 : 0, (32768 & 65480) != 0 ? Priority.NORMAL : null, (65480 & 65536) != 0 ? null : new Function3<Boolean, Boolean, Long, Unit>() { // from class: com.transsion.home.adapter.suboperate.provider.SubFeedsEducationProvider$convert$1$1
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2, Long l11) {
                    invoke(bool.booleanValue(), bool2.booleanValue(), l11.longValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11, boolean z12, long j11) {
                    feedsSubject.setLoadCoverSuccess(z11);
                    feedsSubject.setCoverCache(z12);
                    feedsSubject.setLoadCoverDuration(j11);
                }
            });
        }
        helper.setText(R$id.tv_subject, feedsSubject.getTitle());
        helper.setText(R$id.tv_subject_year, defpackage.a.b(g(), feedsSubject));
        TextView textView = (TextView) helper.getView(R$id.tv_duration);
        so.c.k(textView);
        Integer durationSeconds = feedsSubject.getDurationSeconds();
        textView.setText(z(durationSeconds != null ? durationSeconds.intValue() : 0));
        helper.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubFeedsEducationProvider.x(item, this, view);
            }
        });
        DownloadView downloadView = (DownloadView) helper.getViewOrNull(R$id.ll_download);
        if (downloadView != null) {
            if (Intrinsics.b(feedsSubject.getHasResource(), Boolean.TRUE)) {
                so.c.k(downloadView);
            } else {
                so.c.g(downloadView);
            }
            downloadView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubFeedsEducationProvider.y(item, feedsSubject, this, view);
                }
            });
        }
        Subject feedsSubject2 = item.getFeedsSubject();
        if (feedsSubject2 == null || (seenStatus = feedsSubject2.getSeenStatus()) == null || seenStatus.intValue() != 1) {
            DownloadView downloadView2 = (DownloadView) helper.getViewOrNull(R$id.ll_download);
            if (downloadView2 != null) {
                downloadView2.setAddCourse();
            }
        } else {
            DownloadView downloadView3 = (DownloadView) helper.getViewOrNull(R$id.ll_download);
            if (downloadView3 != null) {
                downloadView3.setCourseAdded();
            }
        }
        BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = c();
        A((baseProviderMultiAdapterC == null || (listD = baseProviderMultiAdapterC.D()) == null) ? -1 : listD.indexOf(item), feedsSubject, true);
    }
}
