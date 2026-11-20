package com.transsion.publish.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$layout;
import com.transsion.publish.api.VsMediaInfo;
import com.transsion.publish.ui.SelectVideoActivity;
import com.transsion.publish.ui.VideoPreviewActivity;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.mvel2.ast.ASTNode;

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
public final class v extends RecyclerView.Adapter<g0> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f56465m = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout.LayoutParams f56467j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f56469l;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<VsMediaInfo> f56466i = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f56468k = (com.blankj.utilcode.util.d0.b() - (com.blankj.utilcode.util.f0.a(3.0f) * 5)) / 4;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public v() {
        int i11 = this.f56468k;
        this.f56467j = new FrameLayout.LayoutParams(i11, i11);
    }

    public static final void h(g0 holder, View view) {
        Intrinsics.g(holder, "$holder");
        Intent intent = new Intent(holder.itemView.getContext(), (Class<?>) SelectVideoActivity.class);
        intent.setFlags(ASTNode.DEOP);
        holder.itemView.getContext().startActivity(intent);
    }

    public static final void m(g0 holder, VsMediaInfo info, View view) {
        Intrinsics.g(holder, "$holder");
        Intrinsics.g(info, "$info");
        VideoPreviewActivity.a aVar = VideoPreviewActivity.f56571g;
        Context context = holder.itemView.getContext();
        Intrinsics.f(context, "holder.itemView.context");
        aVar.a(context, info, 1);
    }

    public static final void n(v this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f56469l) {
            return;
        }
        this$0.f56469l = false;
        cw.a aVar = new cw.a();
        aVar.o(1);
        aVar.n(2);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = cw.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, aVar, 0L);
        this$0.notifyDataSetChanged();
        this$0.f56469l = false;
    }

    public final void g(final g0 g0Var, VsMediaInfo vsMediaInfo) {
        TextView textViewH = g0Var.h();
        if (textViewH != null) {
            textViewH.setVisibility(4);
        }
        View viewE = g0Var.e();
        if (viewE != null) {
            viewE.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v.h(g0Var, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f56466i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i11) {
        return this.f56466i.get(i11).isAdd() ? 2 : 1;
    }

    public final List<VsMediaInfo> i() {
        ArrayList arrayList = new ArrayList();
        List<VsMediaInfo> list = this.f56466i;
        if (list != null) {
            for (VsMediaInfo vsMediaInfo : list) {
                if (!vsMediaInfo.isAdd()) {
                    arrayList.add(vsMediaInfo);
                }
            }
        }
        return arrayList;
    }

    public final List<VsMediaInfo> j() {
        return this.f56466i;
    }

    public final boolean k() {
        List<VsMediaInfo> list = this.f56466i;
        return list != null && list.isEmpty();
    }

    public final void l(final g0 g0Var, final VsMediaInfo vsMediaInfo, int i11) {
        g0Var.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v.m(g0Var, vsMediaInfo, view);
            }
        });
        View viewF = g0Var.f();
        if (viewF != null) {
            viewF.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v.n(this.f56464a, view);
                }
            });
        }
        if (!TextUtils.isEmpty(vsMediaInfo.getImagePath())) {
            ImageView imageViewG = g0Var.g();
            if (imageViewG != null) {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = g0Var.itemView.getContext();
                Intrinsics.f(context, "holder.itemView.context");
                companion.g(context, imageViewG, vsMediaInfo.getImagePath(), (112 & 8) != 0 ? R$color.cl37 : R$drawable.upload_error_cover, (112 & 16) != 0 ? 0 : 4, (112 & 32) != 0 ? -1 : 0, (112 & 64) != 0 ? -1 : 0);
                return;
            }
            return;
        }
        File file = new File(vsMediaInfo.getVideoPath());
        ImageView imageViewG2 = g0Var.g();
        if (imageViewG2 != null) {
            ImageHelper.Companion companion2 = ImageHelper.f51371a;
            Context context2 = g0Var.itemView.getContext();
            Intrinsics.f(context2, "holder.itemView.context");
            companion2.g(context2, imageViewG2, Uri.fromFile(file), (112 & 8) != 0 ? R$color.cl37 : R$drawable.upload_error_cover, (112 & 16) != 0 ? 0 : 4, (112 & 32) != 0 ? -1 : 0, (112 & 64) != 0 ? -1 : 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(g0 holder, int i11) {
        Intrinsics.g(holder, "holder");
        VsMediaInfo vsMediaInfo = this.f56466i.get(i11);
        if (vsMediaInfo.isAdd()) {
            g(holder, vsMediaInfo);
        } else {
            l(holder, vsMediaInfo, i11);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public g0 onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        if (i11 != 1) {
            return i11 != 2 ? new g0(null) : new g0(LayoutInflater.from(parent.getContext()).inflate(R$layout.item_publish_add_video, (ViewGroup) null));
        }
        return new g0(LayoutInflater.from(parent.getContext()).inflate(R$layout.item_publish_video, (ViewGroup) null));
    }

    public final void q() {
        List<VsMediaInfo> list = this.f56466i;
        if (list != null) {
            list.clear();
        }
        notifyDataSetChanged();
    }

    public final void r(List<VsMediaInfo> data) {
        Intrinsics.g(data, "data");
        this.f56466i.clear();
        this.f56466i.addAll(data);
        notifyDataSetChanged();
    }
}
