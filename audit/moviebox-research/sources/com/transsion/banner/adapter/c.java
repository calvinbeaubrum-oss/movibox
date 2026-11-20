package com.transsion.banner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.JoinAnimationView;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.transsion.banner.OpSubBannerNew;
import com.transsion.banner.R$id;
import com.transsion.banner.R$layout;
import com.transsion.banner.R$string;
import com.transsion.baseui.R$drawable;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Group;
import java.util.List;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class c extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Group> f50949i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f50950j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends RecyclerView.a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ShapeableImageView f50951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AppCompatTextView f50952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AppCompatTextView f50953d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public AppCompatTextView f50954f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public AppCompatTextView f50955g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public JoinAnimationView f50956h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            Intrinsics.g(view, "view");
            this.f50951b = (ShapeableImageView) view.findViewById(R$id.iv_cover);
            this.f50952c = (AppCompatTextView) view.findViewById(R$id.tv_score);
            this.f50953d = (AppCompatTextView) view.findViewById(R$id.tv_title);
            this.f50954f = (AppCompatTextView) view.findViewById(R$id.tv_desc);
            this.f50955g = (AppCompatTextView) view.findViewById(R$id.tv_post_count);
            this.f50956h = (JoinAnimationView) view.findViewById(R$id.joinAnimationView);
        }

        public static final void i(or.a aVar, Group group, View it) {
            Intrinsics.g(group, "$group");
            if (aVar != null) {
                Intrinsics.f(it, "it");
                aVar.a(it, group, null);
            }
        }

        public static final void j(a this$0, Group group, String str, View view) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(group, "$group");
            this$0.g(group);
            pr.a.f74040a.f(str, "opt", OpSubBannerNew.OP_GROUPS, (1424 & 8) != 0 ? null : null, (1424 & 16) != 0 ? null : group.getGroupId(), (1424 & 32) != 0 ? null : null, (1424 & 64) != 0 ? null : null, (1424 & 128) != 0 ? null : group.getHasJoin(), (1424 & 256) != 0 ? null : null, (1424 & 512) != 0 ? null : null, (1424 & 1024) != 0 ? null : null, (1424 & 2048) != 0 ? Boolean.FALSE : null, (1424 & 4096) != 0 ? null : null, (1424 & 8192) != 0 ? null : null, (1424 & 16384) != 0 ? null : null);
        }

        public final void g(Group group) {
            com.alibaba.android.arouter.launcher.a.d().b("/room/detail").withString("id", group.getGroupId()).navigation();
        }

        public final void h(final Group group, final or.a aVar, final String str) {
            Intrinsics.g(group, "group");
            ShapeableImageView shapeableImageView = this.f50951b;
            if (shapeableImageView != null) {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = shapeableImageView.getContext();
                Intrinsics.f(context, "context");
                String avatar = group.getAvatar();
                if (avatar == null) {
                    avatar = "";
                }
                companion.r(context, shapeableImageView, avatar, (4088 & 8) != 0 ? companion.d() : f0.a(54.0f), (4088 & 16) != 0 ? companion.c() : f0.a(54.0f), (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
            }
            String name = group.getName();
            if (name == null || name.length() != 0) {
                AppCompatTextView appCompatTextView = this.f50953d;
                if (appCompatTextView != null) {
                    so.c.k(appCompatTextView);
                }
                AppCompatTextView appCompatTextView2 = this.f50953d;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setText(group.getName());
                }
            } else {
                AppCompatTextView appCompatTextView3 = this.f50953d;
                if (appCompatTextView3 != null) {
                    so.c.g(appCompatTextView3);
                }
            }
            Context context2 = this.itemView.getContext();
            Intrinsics.f(context2, "itemView.context");
            l(context2, group.getPostCount());
            String desc = group.getDesc();
            if (desc == null || desc.length() != 0) {
                AppCompatTextView appCompatTextView4 = this.f50954f;
                if (appCompatTextView4 != null) {
                    so.c.k(appCompatTextView4);
                }
                AppCompatTextView appCompatTextView5 = this.f50954f;
                if (appCompatTextView5 != null) {
                    appCompatTextView5.setText(group.getDesc());
                }
            } else {
                AppCompatTextView appCompatTextView6 = this.f50954f;
                if (appCompatTextView6 != null) {
                    so.c.g(appCompatTextView6);
                }
            }
            k(group);
            JoinAnimationView joinAnimationView = this.f50956h;
            if (joinAnimationView != null) {
                joinAnimationView.setOnClickListener(new View.OnClickListener(aVar, group) { // from class: com.transsion.banner.adapter.a

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ Group f50945a;

                    {
                        this.f50945a = group;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        c.a.i(null, this.f50945a, view);
                    }
                });
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.banner.adapter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.a.j(this.f50946a, group, str, view);
                }
            });
        }

        public final void k(Group group) {
            if (group == null || !Intrinsics.b(group.getHasJoin(), Boolean.FALSE)) {
                JoinAnimationView joinAnimationView = this.f50956h;
                if (joinAnimationView != null) {
                    so.c.g(joinAnimationView);
                    return;
                }
                return;
            }
            JoinAnimationView joinAnimationView2 = this.f50956h;
            if (joinAnimationView2 != null) {
                String string = joinAnimationView2.getContext().getString(R$string.join);
                Intrinsics.f(string, "context.getString(R.string.join)");
                joinAnimationView2.setTitle(string);
                joinAnimationView2.upDateState(1);
                joinAnimationView2.setJoinBackgroundResource(R$drawable.download_bg_white);
                joinAnimationView2.setJoinWH(f0.a(88.0f), f0.a(32.0f));
                joinAnimationView2.setTextColor(z2.a.getColor(joinAnimationView2.getContext(), R$color.white));
                joinAnimationView2.setTextSize(12.0f);
                joinAnimationView2.setCompoundDrawablesRelativeWithIntrinsicBounds(R$mipmap.ic_home_join, 0, 0, 0);
                so.c.k(joinAnimationView2);
            }
        }

        public final void l(Context context, Long l11) {
            AppCompatTextView appCompatTextView = this.f50955g;
            if (appCompatTextView == null) {
                return;
            }
            int i11 = R$string.tip_post_count;
            Object[] objArr = new Object[1];
            objArr[0] = Long.valueOf(l11 != null ? l11.longValue() : 0L);
            appCompatTextView.setText(context.getString(i11, objArr));
        }
    }

    public c(List<Group> datas, String str) {
        Intrinsics.g(datas, "datas");
        this.f50949i = datas;
        this.f50950j = str;
    }

    public final List<Group> d() {
        return this.f50949i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int i11) {
        Intrinsics.g(holder, "holder");
        holder.h(this.f50949i.get(i11), null, this.f50950j);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R$layout.view_groups_op, parent, false);
        Intrinsics.f(view, "view");
        return new a(view);
    }

    public final void g(or.a aVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f50949i.size();
    }
}
