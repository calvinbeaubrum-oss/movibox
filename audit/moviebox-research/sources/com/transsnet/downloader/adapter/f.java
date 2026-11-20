package com.transsnet.downloader.adapter;

import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class f extends BaseQuickAdapter<DownloadBean, BaseViewHolder> implements h9.j {
    public final int H;
    public String I;
    public Integer J;
    public Boolean K;
    public final Function0<Boolean> L;
    public String M;
    public com.transsnet.downloader.manager.a N;
    public final CopyOnWriteArrayList<DownloadBean> O;
    public Function2<? super Long, ? super Boolean, Unit> P;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements su.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppCompatImageView f60366b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DownloadBean f60367c;

        public a(AppCompatImageView appCompatImageView, DownloadBean downloadBean) {
            this.f60366b = appCompatImageView;
            this.f60367c = downloadBean;
        }

        @Override // su.a
        public void a(MemberCheckResult memberCheckResult) {
            su.a.C0841a.f(this, memberCheckResult);
        }

        @Override // su.a
        public void b(MemberCheckResult memberCheckResult) {
            su.a.C0841a.d(this, memberCheckResult);
        }

        @Override // su.a
        public void c(MemberCheckResult memberCheckResult) {
            su.a.C0841a.e(this, memberCheckResult);
        }

        @Override // su.a
        public void d() {
            su.a.C0841a.c(this);
            f.this.P0(this.f60366b, this.f60367c);
        }

        @Override // su.a
        public void e(MemberCheckResult memberCheckResult) {
            su.a.C0841a.a(this, memberCheckResult);
        }

        @Override // su.a
        public void onFail(String errorMsg) {
            Intrinsics.g(errorMsg, "errorMsg");
            su.a.C0841a.b(this, errorMsg);
            uo.b.a.f(uo.b.f78622a, "co_mem", "DownloadBottomAnaGroupAdapter --> convert() --> 多集多分辨率 --> " + errorMsg, false, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(int i11, List<DownloadBean> dataList, String page_from, String str, Integer num, Boolean bool, Function0<Boolean> hasMore) {
        super(R$layout.item_bottom_dialog_download_ana_group, dataList);
        Intrinsics.g(dataList, "dataList");
        Intrinsics.g(page_from, "page_from");
        Intrinsics.g(hasMore, "hasMore");
        this.H = i11;
        this.I = str;
        this.J = num;
        this.K = bool;
        this.L = hasMore;
        this.M = "";
        this.O = new CopyOnWriteArrayList<>();
        this.N = com.transsnet.downloader.manager.b.f61062a.a(Utils.a());
        this.M = page_from;
    }

    public static final void K0(f this$0, AppCompatImageView checkView, DownloadBean item, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(checkView, "$checkView");
        Intrinsics.g(item, "$item");
        if (this$0.Q().q()) {
            return;
        }
        if (checkView.isSelected() || !Intrinsics.b(this$0.K, Boolean.TRUE)) {
            this$0.P0(checkView, item);
        } else {
            ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).i(Integer.valueOf(item.getResolution()), this$0.new a(checkView, item));
        }
    }

    public final void I0(DownloadBean item, boolean z11) {
        Intrinsics.g(item, "item");
        if (!z11) {
            uo.b.a.f(uo.b.f78622a, "DownloadReDete ", "==remove, epName:" + item.getEpName(), false, 4, null);
            this.O.remove(item);
            return;
        }
        if (this.O.contains(item)) {
            uo.b.a.f(uo.b.f78622a, "DownloadReDete ", "==add contains, epName:" + item.getEpName(), false, 4, null);
            return;
        }
        uo.b.a.f(uo.b.f78622a, "DownloadReDete ", "==add, epName:" + item.getEpName(), false, 4, null);
        this.O.add(item);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0050  */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, final DownloadBean item) {
        String sizeFormat;
        Integer requireMemberType;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        Integer num = this.J;
        int value = SubjectType.TV.getValue();
        if (num != null && num.intValue() == value) {
            holder.setText(R$id.tv_title, item.getEpTitleName(this.L.invoke().booleanValue()));
        } else {
            Integer num2 = this.J;
            int value2 = SubjectType.EDUCATION.getValue();
            if (num2 != null && num2.intValue() == value2) {
                holder.setText(R$id.tv_title, item.getEpTitleName(this.L.invoke().booleanValue()));
            } else {
                holder.setText(R$id.tv_title, item.getTitleName());
                holder.setText(R$id.tv_ep, " " + item.getEpName());
            }
        }
        if (TextUtils.isEmpty(item.getSizeFormat())) {
            Long size = item.getSize();
            sizeFormat = size != null ? tp.a.a(size.longValue(), 1) : null;
        } else {
            sizeFormat = item.getSizeFormat();
        }
        holder.setText(R$id.tv_size, sizeFormat);
        int i11 = R$id.tv_time;
        Long duration = item.getDuration();
        holder.setText(i11, TimeUtilKt.i((duration != null ? duration.longValue() : 0L) * ((long) 1000)));
        final AppCompatImageView appCompatImageView = (AppCompatImageView) holder.getView(R$id.iv_check);
        if (item.isUnable()) {
            holder.itemView.setClickable(false);
            appCompatImageView.setSelected(false);
            appCompatImageView.setEnabled(false);
        } else {
            appCompatImageView.setEnabled(true);
            appCompatImageView.setSelected(item.isCheck());
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.adapter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.K0(this.f60362a, appCompatImageView, item, view);
                }
            });
        }
        boolean zE1 = ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).e1();
        if (Intrinsics.b(this.K, Boolean.TRUE) && zE1 && (requireMemberType = item.getRequireMemberType()) != null && requireMemberType.intValue() == 1) {
            so.c.k(holder.getView(R$id.iv_premium));
        } else {
            so.c.g(holder.getView(R$id.iv_premium));
        }
        N0(item);
    }

    public final CopyOnWriteArrayList<DownloadBean> L0() {
        return this.O;
    }

    public final void M0() {
        long jLongValue = 0;
        for (DownloadBean downloadBean : this.O) {
            if (!downloadBean.isUnable()) {
                Long size = downloadBean.getSize();
                jLongValue += size != null ? size.longValue() : 0L;
            }
        }
        Function2<? super Long, ? super Boolean, Unit> function2 = this.P;
        if (function2 != null) {
            function2.invoke(Long.valueOf(jLongValue), Boolean.FALSE);
        }
        uo.b.a.f(uo.b.f78622a, "downloadAna", "onItemSelect, totalSize = " + jLongValue + ", checkList.size = " + this.O.size() + ", itemCount = " + D().size(), false, 4, null);
    }

    public final void N0(DownloadBean downloadBean) {
        HashMap map = new HashMap();
        map.put("url", downloadBean.getUrl());
        String postId = downloadBean.getPostId();
        if (postId == null) {
            postId = "";
        }
        map.put("post_id", postId);
        map.put(WebConstants.PAGE_FROM, this.M);
        map.put("sequence", String.valueOf(P(downloadBean)));
        map.put("item_type", String.valueOf(downloadBean.getType()));
        String name = downloadBean.getName();
        if (name == null) {
            name = "";
        }
        map.put("item_title", name);
        String str = this.I;
        map.put("subject_id", str != null ? str : "");
        map.put("subject_type", String.valueOf(this.J));
    }

    public final void O0(DownloadBean downloadBean) {
        HashMap map = new HashMap();
        map.put("url", downloadBean.getUrl());
        String postId = downloadBean.getPostId();
        if (postId == null) {
            postId = "";
        }
        map.put("post_id", postId);
        map.put(WebConstants.PAGE_FROM, this.M);
        map.put("sequence", String.valueOf(P(downloadBean)));
        map.put("item_type", String.valueOf(downloadBean.getType()));
        String name = downloadBean.getName();
        if (name == null) {
            name = "";
        }
        map.put("item_title", name);
        String str = this.I;
        map.put("subject_id", str != null ? str : "");
        map.put("subject_type", String.valueOf(this.J));
    }

    public final void P0(AppCompatImageView appCompatImageView, DownloadBean downloadBean) {
        if (appCompatImageView.isSelected()) {
            I0(downloadBean, false);
            appCompatImageView.setSelected(false);
        } else {
            I0(downloadBean, true);
            appCompatImageView.setSelected(true);
        }
        downloadBean.setCheck(appCompatImageView.isSelected());
        M0();
        O0(downloadBean);
    }

    public final void Q0(Function2<? super Long, ? super Boolean, Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.P = listener;
    }

    @Override // h9.j
    public /* synthetic */ h9.f a(BaseQuickAdapter baseQuickAdapter) {
        return h9.i.a(this, baseQuickAdapter);
    }
}
