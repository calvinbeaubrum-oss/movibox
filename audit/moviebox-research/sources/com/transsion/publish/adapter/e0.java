package com.transsion.publish.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.google.android.gms.gcm.Task;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$string;
import com.transsion.publish.TempTransitData;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.ui.ClippingImageActivity;
import com.transsion.publish.ui.GalleryActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class e0 extends RecyclerView.Adapter<f0> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<Integer, Unit> f56404i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<PhotoEntity> f56405j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout.LayoutParams f56406k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f56407l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<PhotoEntity> f56408m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f56409n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f56410o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Activity f56411p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f56412q;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PhotoEntity f56414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f0 f56415c;

        public a(PhotoEntity photoEntity, f0 f0Var) {
            this.f56414b = photoEntity;
            this.f56415c = f0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e0 e0Var;
            Activity activity;
            if (com.transsion.baseui.util.c.f51452a.a(view != null ? view.getId() : 0, 500L)) {
                return;
            }
            if (e0.this.f56410o == 5 || e0.this.f56410o == 7) {
                String localPath = this.f56414b.getLocalPath();
                if (localPath == null || (activity = (e0Var = e0.this).f56411p) == null) {
                    return;
                }
                ClippingImageActivity.a.b(ClippingImageActivity.f56481k, activity, localPath, e0Var.f56410o, null, 8, null);
                return;
            }
            if (e0.this.r()) {
                e0.this.q(this.f56414b, this.f56415c, true);
            } else if (this.f56414b.getEnableSelect()) {
                e0.this.q(this.f56414b, this.f56415c, true);
            } else {
                e0.this.k(this.f56414b, this.f56415c);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e0(Function1<? super Integer, Unit> selectItem) {
        Intrinsics.g(selectItem, "selectItem");
        this.f56404i = selectItem;
        this.f56405j = new ArrayList();
        this.f56408m = new ArrayList();
        this.f56409n = 9;
        this.f56412q = Task.EXTRAS_LIMIT_BYTES;
        this.f56407l = (com.blankj.utilcode.util.d0.b() - (com.blankj.utilcode.util.f0.a(3.0f) * 5)) / 4;
        int i11 = this.f56407l;
        this.f56406k = new FrameLayout.LayoutParams(i11, i11);
    }

    private final String n(PhotoEntity photoEntity) {
        int i11 = 0;
        for (Object obj : this.f56408m) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            if (Intrinsics.b(photoEntity.getLocalPath(), ((PhotoEntity) obj).getLocalPath())) {
                return String.valueOf(i12);
            }
            i11 = i12;
        }
        return "-1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean r() {
        return this.f56408m.size() >= this.f56409n;
    }

    public static final void t(f0 holder, e0 this$0, PhotoEntity info, int i11, View view) {
        Activity activity;
        String string;
        Intrinsics.g(holder, "$holder");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(info, "$info");
        if (holder.h().getVisibility() == 0) {
            Activity activity2 = this$0.f56411p;
            if (activity2 == null || (string = activity2.getString(R$string.add_img_max_tips)) == null) {
                string = "";
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this$0.f56409n)}, 1));
            Intrinsics.f(str, "format(...)");
            com.tn.lib.widget.toast.core.h.f50034a.l(str);
            return;
        }
        int i12 = this$0.f56410o;
        if (i12 != 5 && i12 != 7) {
            TempTransitData.f56359b.a().d(this$0.f56405j);
            GalleryActivity.a aVar = GalleryActivity.f56500g;
            Context context = holder.itemView.getContext();
            Intrinsics.f(context, "holder.itemView.context");
            aVar.a(context, this$0.f56408m, i11, 1, this$0.f56409n);
            return;
        }
        if (info.getImageSize() > this$0.f56412q) {
            zp.b.f82110a.e(Utils.a().getResources().getString(R$string.add_media_max_size_tips, 10));
            return;
        }
        String localPath = info.getLocalPath();
        if (localPath == null || (activity = this$0.f56411p) == null) {
            return;
        }
        ClippingImageActivity.a.b(ClippingImageActivity.f56481k, activity, localPath, this$0.f56410o, null, 8, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f56405j.size();
    }

    public final void j(List<PhotoEntity> data) {
        Intrinsics.g(data, "data");
        int size = this.f56405j.size();
        this.f56405j.addAll(data);
        notifyItemRangeInserted(size, data.size());
    }

    public final void k(PhotoEntity photoEntity, f0 f0Var) {
        m(photoEntity);
        this.f56408m.add(photoEntity);
        this.f56404i.invoke(Integer.valueOf(this.f56408m.size()));
        photoEntity.setEnableSelect(true);
        f0Var.g().setText(n(photoEntity));
        f0Var.g().setBackgroundResource(R$drawable.bg_linear_r16);
        if (r()) {
            notifyDataSetChanged();
        }
    }

    public final void l() {
        List<PhotoEntity> list = this.f56408m;
        if (list != null) {
            list.clear();
        }
    }

    public final void m(PhotoEntity photoEntity) {
        PhotoEntity photoEntity2 = null;
        for (PhotoEntity photoEntity3 : this.f56408m) {
            if (TextUtils.equals(photoEntity3.getLocalPath(), photoEntity.getLocalPath())) {
                photoEntity2 = photoEntity3;
            }
        }
        if (this.f56408m.contains(photoEntity)) {
            this.f56408m.remove(photoEntity);
        }
        if (photoEntity2 != null) {
            TypeIntrinsics.a(this.f56408m).remove(photoEntity2);
        }
    }

    public final List<PhotoEntity> o() {
        return this.f56405j;
    }

    public final List<PhotoEntity> p() {
        return this.f56408m;
    }

    public final void q(PhotoEntity photoEntity, f0 f0Var, boolean z11) {
        if (photoEntity.getEnableSelect()) {
            m(photoEntity);
            this.f56404i.invoke(Integer.valueOf(this.f56408m.size()));
            photoEntity.setEnableSelect(false);
            f0Var.g().setText("");
            f0Var.g().setBackgroundResource(R$drawable.ic_select_number_bro);
            if (z11) {
                notifyDataSetChanged();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final f0 holder, final int i11) {
        Intrinsics.g(holder, "holder");
        final PhotoEntity photoEntity = this.f56405j.get(i11);
        holder.itemView.setLayoutParams(this.f56406k);
        if (TextUtils.isEmpty(photoEntity.getThumbPath())) {
            String localPath = photoEntity.getLocalPath();
            if (localPath != null && localPath.length() > 0) {
                File file = new File(photoEntity.getLocalPath());
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = holder.e().getContext();
                Intrinsics.f(context, "holder.ivCover.context");
                ImageView imageViewE = holder.e();
                Uri uriFromFile = Uri.fromFile(file);
                int i12 = R$mipmap.home_ic_default_res;
                int i13 = this.f56407l;
                companion.g(context, imageViewE, uriFromFile, i12, 0, i13, i13);
            }
        } else {
            File file2 = new File(photoEntity.getThumbPath());
            ImageHelper.Companion companion2 = ImageHelper.f51371a;
            Context context2 = holder.e().getContext();
            Intrinsics.f(context2, "holder.ivCover.context");
            ImageView imageViewE2 = holder.e();
            Uri uriFromFile2 = Uri.fromFile(file2);
            int i14 = R$mipmap.home_ic_default_res;
            int i15 = this.f56407l;
            companion2.g(context2, imageViewE2, uriFromFile2, i14, 0, i15, i15);
        }
        if (this.f56410o != 0) {
            holder.h().setVisibility(8);
            holder.g().setBackgroundResource(0);
        } else if (!r()) {
            holder.h().setVisibility(8);
            if (photoEntity.getEnableSelect()) {
                holder.g().setText(n(photoEntity));
                holder.g().setBackgroundResource(R$drawable.bg_linear_r16);
            } else {
                holder.g().setText("");
                holder.g().setBackgroundResource(R$drawable.ic_select_number_bro);
            }
        } else if (photoEntity.getEnableSelect()) {
            holder.h().setVisibility(8);
            holder.g().setText(n(photoEntity));
            holder.g().setBackgroundResource(R$drawable.bg_linear_r16);
        } else {
            holder.h().setVisibility(0);
            holder.g().setText("");
            holder.g().setBackgroundResource(R$drawable.ic_select_number_bro);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e0.t(holder, this, photoEntity, i11, view);
            }
        });
        holder.f().setOnClickListener(new a(photoEntity, holder));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public f0 onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_select_image, (ViewGroup) null);
        Intrinsics.f(view, "view");
        return new f0(view);
    }

    public final void v() {
        List<PhotoEntity> list = this.f56405j;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((PhotoEntity) it.next()).setEnableSelect(false);
            }
        }
    }

    public final void w(int i11, Activity activity) {
        Intrinsics.g(activity, "activity");
        this.f56410o = i11;
        this.f56411p = activity;
    }

    public final void x(int i11) {
        this.f56409n = i11;
    }

    public final void y(PhotoEntity photoEntity) {
        if (photoEntity == null || this.f56408m.contains(photoEntity)) {
            return;
        }
        this.f56408m.add(photoEntity);
    }
}
