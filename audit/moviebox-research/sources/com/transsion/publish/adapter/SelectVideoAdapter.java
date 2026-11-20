package com.transsion.publish.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$string;
import com.transsion.publish.api.VsMediaInfo;
import com.transsion.publish.ui.VideoPreviewActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;

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
public final class SelectVideoAdapter extends RecyclerView.Adapter<h0> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<Integer, Unit> f56366i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<VsMediaInfo> f56367j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout.LayoutParams f56368k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<VsMediaInfo> f56369l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f56370m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f56371n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f56372o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f56373p;

    /* JADX WARN: Multi-variable type inference failed */
    public SelectVideoAdapter(Function1<? super Integer, Unit> selectItem) {
        Intrinsics.g(selectItem, "selectItem");
        this.f56366i = selectItem;
        this.f56367j = new ArrayList();
        this.f56369l = new ArrayList();
        this.f56370m = 1;
        this.f56371n = 52428800;
        this.f56372o = 1200000;
        this.f56373p = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
        int iB = (com.blankj.utilcode.util.d0.b() - (com.blankj.utilcode.util.f0.a(3.0f) * 5)) / 4;
        this.f56368k = new FrameLayout.LayoutParams(iB, iB);
    }

    private final boolean k() {
        return this.f56369l.size() >= this.f56370m;
    }

    public final void g(List<VsMediaInfo> data) {
        Intrinsics.g(data, "data");
        int size = this.f56367j.size();
        this.f56367j.addAll(data);
        notifyItemRangeInserted(size, data.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f56367j.size();
    }

    public final void h(h0 h0Var, Function0<Unit> function0) {
        if (!k() || h0Var.f().getVisibility() != 0) {
            function0.invoke();
            return;
        }
        String string = Utils.a().getString(R$string.add_video_max_tips);
        Intrinsics.f(string, "getApp().getString(R.string.add_video_max_tips)");
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.f56370m)}, 1));
        Intrinsics.f(str, "format(...)");
        com.tn.lib.widget.toast.core.h.f50034a.l(str);
    }

    public final String i(VsMediaInfo vsMediaInfo) {
        int i11 = 0;
        for (Object obj : this.f56369l) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            if (Intrinsics.b(vsMediaInfo.getVideoPath(), ((VsMediaInfo) obj).getVideoPath())) {
                return String.valueOf(i12);
            }
            i11 = i12;
        }
        return "-1";
    }

    public final List<VsMediaInfo> j() {
        return this.f56369l;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"StringFormatInvalid"})
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final h0 holder, int i11) {
        Intrinsics.g(holder, "holder");
        final VsMediaInfo vsMediaInfo = this.f56367j.get(i11);
        holder.itemView.setLayoutParams(this.f56368k);
        o(holder.h(), vsMediaInfo.getVideoDuration());
        if (TextUtils.isEmpty(vsMediaInfo.getImagePath())) {
            String videoPath = vsMediaInfo.getVideoPath();
            File file = videoPath != null ? new File(videoPath) : null;
            if (file != null) {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = holder.e().getContext();
                Intrinsics.f(context, "holder.ivCover.context");
                companion.g(context, holder.e(), Uri.fromFile(file), (112 & 8) != 0 ? R$color.cl37 : R$mipmap.home_ic_default_res, (112 & 16) != 0 ? 0 : 0, (112 & 32) != 0 ? -1 : 0, (112 & 64) != 0 ? -1 : 0);
            }
        } else {
            ImageHelper.Companion companion2 = ImageHelper.f51371a;
            Context context2 = holder.e().getContext();
            Intrinsics.f(context2, "holder.ivCover.context");
            companion2.g(context2, holder.e(), vsMediaInfo.getImagePath(), (112 & 8) != 0 ? R$color.cl37 : R$mipmap.home_ic_default_res, (112 & 16) != 0 ? 0 : 0, (112 & 32) != 0 ? -1 : 0, (112 & 64) != 0 ? -1 : 0);
        }
        boolean z11 = vsMediaInfo.getVideoSize() >= ((long) this.f56371n);
        boolean z12 = vsMediaInfo.getVideoDuration() >= ((long) this.f56372o);
        boolean z13 = vsMediaInfo.getVideoDuration() < ((long) this.f56373p);
        if (!k()) {
            holder.f().setVisibility(8);
            if (vsMediaInfo.getEnableSelect()) {
                holder.i().setText(i(vsMediaInfo));
                holder.i().setBackgroundResource(R$drawable.bg_linear_r16);
            } else {
                holder.i().setText("");
                holder.i().setBackgroundResource(R$drawable.ic_select_number_bro);
            }
        } else if (vsMediaInfo.getEnableSelect()) {
            holder.f().setVisibility(8);
            holder.i().setText(i(vsMediaInfo));
            holder.i().setBackgroundResource(R$drawable.bg_linear_r16);
        } else {
            holder.f().setVisibility(0);
            holder.i().setText("");
            holder.i().setBackgroundResource(R$drawable.ic_select_number_bro);
        }
        if (z11 || z12 || z13) {
            holder.f().setVisibility(0);
        }
        View view = holder.itemView;
        Intrinsics.f(view, "holder.itemView");
        final boolean z14 = z12;
        final boolean z15 = z11;
        final boolean z16 = z13;
        so.c.c(view, 0L, new Function1<View, Unit>() { // from class: com.transsion.publish.adapter.SelectVideoAdapter.onBindViewHolder.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.g(it, "it");
                if (z14) {
                    zp.b.f82110a.e("Exceeded video length, 20 mins Max");
                    return;
                }
                if (z15) {
                    zp.b.f82110a.e(Utils.a().getResources().getString(R$string.add_media_max_size_tips, 50));
                    return;
                }
                if (z16) {
                    zp.b.f82110a.e("video requires at least 3s");
                    return;
                }
                SelectVideoAdapter selectVideoAdapter = this;
                final h0 h0Var = holder;
                final VsMediaInfo vsMediaInfo2 = vsMediaInfo;
                selectVideoAdapter.h(h0Var, new Function0<Unit>() { // from class: com.transsion.publish.adapter.SelectVideoAdapter.onBindViewHolder.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        VideoPreviewActivity.a aVar = VideoPreviewActivity.f56571g;
                        Context context3 = h0Var.itemView.getContext();
                        Intrinsics.f(context3, "holder.itemView.context");
                        aVar.a(context3, vsMediaInfo2, 2);
                    }
                });
            }
        }, 1, null);
        so.c.c(holder.g(), 0L, new Function1<View, Unit>() { // from class: com.transsion.publish.adapter.SelectVideoAdapter.onBindViewHolder.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.g(it, "it");
                if (z14) {
                    zp.b.f82110a.e("Exceeded video length, 20 mins Max");
                    return;
                }
                if (z15) {
                    zp.b.f82110a.e(Utils.a().getResources().getString(R$string.add_media_max_size_tips, 50));
                    return;
                }
                if (z16) {
                    zp.b.f82110a.e("video requires at least 3s");
                    return;
                }
                final SelectVideoAdapter selectVideoAdapter = this;
                h0 h0Var = holder;
                final VsMediaInfo vsMediaInfo2 = vsMediaInfo;
                selectVideoAdapter.h(h0Var, new Function0<Unit>() { // from class: com.transsion.publish.adapter.SelectVideoAdapter.onBindViewHolder.3.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (vsMediaInfo2.getEnableSelect()) {
                            selectVideoAdapter.s(vsMediaInfo2);
                        } else {
                            selectVideoAdapter.r(vsMediaInfo2);
                        }
                    }
                });
            }
        }, 1, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(h0 holder, int i11, List<Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(payloads, "payloads");
        if (!(CollectionsKt___CollectionsKt.g0(payloads) instanceof Boolean)) {
            super.onBindViewHolder(holder, i11, payloads);
            return;
        }
        VsMediaInfo vsMediaInfo = this.f56367j.get(i11);
        if (vsMediaInfo.getEnableSelect()) {
            holder.i().setText(i(vsMediaInfo));
            holder.i().setBackgroundResource(R$drawable.bg_linear_r16);
        } else {
            holder.i().setText("");
            holder.i().setBackgroundResource(R$drawable.ic_select_number_bro);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public h0 onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R$layout.upload_select_video_item, (ViewGroup) null);
        Intrinsics.f(view, "view");
        return new h0(view);
    }

    public final void o(TextView textView, long j11) {
        if (j11 == 0) {
            return;
        }
        if (2001 <= j11 && j11 < 3000) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            String str = String.format("%02d:%02d", Arrays.copyOf(new Object[]{0, 2}, 2));
            Intrinsics.f(str, "format(...)");
            String str2 = String.format(str, Arrays.copyOf(new Object[0], 0));
            Intrinsics.f(str2, "format(...)");
            textView.setText(str2);
            return;
        }
        if (4001 <= j11 && j11 < 5000) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f68912a;
            String str3 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{0, 4}, 2));
            Intrinsics.f(str3, "format(...)");
            String str4 = String.format(str3, Arrays.copyOf(new Object[0], 0));
            Intrinsics.f(str4, "format(...)");
            textView.setText(str4);
            return;
        }
        int iD = a20.b.d(j11 / 1000);
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.f68912a;
        String str5 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(iD / 60), Integer.valueOf(iD % 60)}, 2));
        Intrinsics.f(str5, "format(...)");
        String str6 = String.format(str5, Arrays.copyOf(new Object[0], 0));
        Intrinsics.f(str6, "format(...)");
        textView.setText(str6);
    }

    public final void p(VsMediaInfo vsMediaInfo) {
        VsMediaInfo vsMediaInfo2 = null;
        for (VsMediaInfo vsMediaInfo3 : this.f56369l) {
            if (TextUtils.equals(vsMediaInfo3.getVideoPath(), vsMediaInfo.getVideoPath())) {
                vsMediaInfo2 = vsMediaInfo3;
            }
        }
        if (this.f56369l.contains(vsMediaInfo)) {
            this.f56369l.remove(vsMediaInfo);
        }
        if (vsMediaInfo2 != null) {
            TypeIntrinsics.a(this.f56369l).remove(vsMediaInfo2);
        }
    }

    public final void q(VsMediaInfo data) {
        Intrinsics.g(data, "data");
        VsMediaInfo vsMediaInfo = data;
        for (VsMediaInfo vsMediaInfo2 : this.f56367j) {
            if (TextUtils.equals(vsMediaInfo2.getVideoPath(), data.getVideoPath())) {
                vsMediaInfo2.setEnableSelect(data.getEnableSelect());
                vsMediaInfo = vsMediaInfo2;
            }
        }
        if (data.getEnableSelect()) {
            r(vsMediaInfo);
        } else {
            s(vsMediaInfo);
        }
        notifyItemRangeChanged(0, this.f56367j.size(), Boolean.TRUE);
    }

    public final void r(VsMediaInfo vsMediaInfo) {
        p(vsMediaInfo);
        this.f56369l.add(vsMediaInfo);
        this.f56366i.invoke(Integer.valueOf(this.f56369l.size()));
        vsMediaInfo.setEnableSelect(true);
        int iIndexOf = this.f56367j.indexOf(vsMediaInfo);
        if (iIndexOf >= 0) {
            notifyItemChanged(iIndexOf, Boolean.TRUE);
        }
        if (k()) {
            notifyDataSetChanged();
        }
    }

    public final void s(VsMediaInfo vsMediaInfo) {
        boolean zK = k();
        p(vsMediaInfo);
        this.f56366i.invoke(Integer.valueOf(this.f56369l.size()));
        vsMediaInfo.setEnableSelect(false);
        int iIndexOf = this.f56367j.indexOf(vsMediaInfo);
        if (iIndexOf >= 0) {
            notifyItemChanged(iIndexOf, Boolean.FALSE);
        }
        if (zK) {
            notifyDataSetChanged();
        }
    }
}
