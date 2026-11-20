package com.transsion.publish.adapter;

import android.content.Context;
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
import com.transsion.publish.TempTransitData;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.ui.GalleryActivity;
import com.transsion.publish.ui.SelectImageActivity;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class g extends RecyclerView.Adapter<c> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f56422m = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout.LayoutParams f56424j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f56426l;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<PhotoEntity> f56423i = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f56425k = (com.blankj.utilcode.util.d0.b() - (com.blankj.utilcode.util.f0.a(3.0f) * 5)) / 4;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public g() {
        int i11 = this.f56425k;
        this.f56424j = new FrameLayout.LayoutParams(i11, i11);
    }

    public static final void i(c holder, g this$0, View view) {
        Context context;
        Intrinsics.g(holder, "$holder");
        Intrinsics.g(this$0, "this$0");
        View viewE = holder.e();
        if (viewE == null || (context = viewE.getContext()) == null) {
            return;
        }
        SelectImageActivity.f56514r.a(context, 0, 9 - this$0.j().size(), new ArrayList());
    }

    public static final void n(g this$0, c holder, int i11, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(holder, "$holder");
        List<PhotoEntity> listJ = this$0.j();
        TempTransitData.f56359b.a().d(listJ);
        GalleryActivity.a aVar = GalleryActivity.f56500g;
        Context context = holder.itemView.getContext();
        Intrinsics.f(context, "holder.itemView.context");
        aVar.a(context, listJ, i11, 2, 9);
    }

    public static final void o(g this$0, PhotoEntity info, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(info, "$info");
        if (this$0.f56426l) {
            return;
        }
        this$0.f56426l = false;
        this$0.r(info);
        this$0.f56426l = false;
    }

    public final void g(List<PhotoEntity> data) {
        Intrinsics.g(data, "data");
        int size = this.f56423i.size();
        this.f56423i.addAll(data);
        notifyItemRangeInserted(size, data.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f56423i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i11) {
        return this.f56423i.get(i11).isAdd() ? 2 : 1;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0056  */
    /* JADX WARN: Code duplicated, block: B:24:0x005d  */
    /* JADX WARN: Instruction removed from duplicated block: B:24:0x005d, please report this as an issue */
    public final void h(final c cVar, PhotoEntity photoEntity) {
        TextView textViewH;
        if (getItemCount() == 0) {
            TextView textViewH2 = cVar.h();
            if (textViewH2 != null) {
                textViewH2.setText("0/9");
            }
        } else {
            List<PhotoEntity> list = this.f56423i;
            if (list != null) {
                Iterator<T> it = list.iterator();
                boolean z11 = false;
                while (it.hasNext()) {
                    if (((PhotoEntity) it.next()).isAdd()) {
                        z11 = true;
                    }
                }
                if (z11) {
                    TextView textViewH3 = cVar.h();
                    if (textViewH3 != null) {
                        textViewH3.setText((getItemCount() - 1) + "/9");
                    }
                } else {
                    textViewH = cVar.h();
                    if (textViewH != null) {
                        textViewH.setText(getItemCount() + "/9");
                    }
                }
            } else {
                textViewH = cVar.h();
                if (textViewH != null) {
                    textViewH.setText(getItemCount() + "/9");
                }
            }
        }
        View viewE = cVar.e();
        if (viewE != null) {
            viewE.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.i(cVar, this, view);
                }
            });
        }
    }

    public final List<PhotoEntity> j() {
        ArrayList arrayList = new ArrayList();
        for (PhotoEntity photoEntity : this.f56423i) {
            if (!photoEntity.isAdd()) {
                arrayList.add(photoEntity);
            }
        }
        return arrayList;
    }

    public final List<PhotoEntity> k() {
        return this.f56423i;
    }

    public final boolean l() {
        List<PhotoEntity> list = this.f56423i;
        return list != null && list.isEmpty();
    }

    public final void m(final c cVar, final PhotoEntity photoEntity, final int i11) {
        ImageView imageViewG = cVar.g();
        if (imageViewG != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = cVar.itemView.getContext();
            Intrinsics.f(context, "holder.itemView.context");
            String localPath = photoEntity.getLocalPath();
            int i12 = R$drawable.upload_error_cover;
            com.transsion.baseui.util.a aVar = com.transsion.baseui.util.a.f51450a;
            Context context2 = cVar.itemView.getContext();
            Intrinsics.f(context2, "holder.itemView.context");
            companion.g(context, imageViewG, localPath, (112 & 8) != 0 ? R$color.cl37 : i12, (112 & 16) != 0 ? 0 : (int) aVar.a(context2, 4.0f), (112 & 32) != 0 ? -1 : 0, (112 & 64) != 0 ? -1 : 0);
        }
        cVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.n(this.f56401a, cVar, i11, view);
            }
        });
        View viewF = cVar.f();
        if (viewF != null) {
            viewF.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.o(this.f56416a, photoEntity, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c holder, int i11) {
        Intrinsics.g(holder, "holder");
        PhotoEntity photoEntity = this.f56423i.get(i11);
        if (photoEntity.isAdd()) {
            h(holder, photoEntity);
        } else {
            m(holder, photoEntity, i11);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        if (i11 != 1) {
            return i11 != 2 ? new c(null) : new c(LayoutInflater.from(parent.getContext()).inflate(R$layout.item_publish_add_image, (ViewGroup) null));
        }
        return new c(LayoutInflater.from(parent.getContext()).inflate(R$layout.item_publish_image, (ViewGroup) null));
    }

    public final void r(PhotoEntity photoEntity) {
        this.f56423i.remove(photoEntity);
        cw.a aVar = new cw.a();
        boolean z11 = false;
        aVar.o(0);
        aVar.n(2);
        if (this.f56423i.size() == 0 || (this.f56423i.size() == 1 && this.f56423i.get(0).isAdd())) {
            List<PhotoEntity> list = this.f56423i;
            if (list != null) {
                list.clear();
            }
            notifyDataSetChanged();
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = cw.a.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.postEvent(name, aVar, 0L);
            return;
        }
        if (this.f56423i.size() == 8) {
            Iterator<T> it = this.f56423i.iterator();
            while (it.hasNext()) {
                if (((PhotoEntity) it.next()).isAdd()) {
                    z11 = true;
                }
            }
            if (!z11) {
                PhotoEntity photoEntity2 = new PhotoEntity();
                photoEntity2.setAdd(true);
                this.f56423i.add(photoEntity2);
            }
        }
        FlowEventBus flowEventBus2 = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = cw.a.class.getName();
        Intrinsics.f(name2, "T::class.java.name");
        flowEventBus2.postEvent(name2, aVar, 0L);
        notifyDataSetChanged();
    }

    public final void s() {
        List<PhotoEntity> list = this.f56423i;
        if (list != null) {
            list.clear();
        }
        notifyDataSetChanged();
    }

    public final void t(List<PhotoEntity> data) {
        Intrinsics.g(data, "data");
        this.f56423i.clear();
        this.f56423i.addAll(data);
        notifyDataSetChanged();
    }
}
