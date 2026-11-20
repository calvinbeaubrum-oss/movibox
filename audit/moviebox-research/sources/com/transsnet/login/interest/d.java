package com.transsnet.login.interest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;
import com.transsnet.login.R$mipmap;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class d extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f61533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<List<Integer>, Unit> f61534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<Integer> f61535k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<Integer> f61536l;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends RecyclerView.a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AppCompatTextView f61537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AppCompatImageView f61538c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            Intrinsics.g(view, "view");
            View viewFindViewById = view.findViewById(R$id.tv_interest);
            Intrinsics.f(viewFindViewById, "view.findViewById(R.id.tv_interest)");
            this.f61537b = (AppCompatTextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R$id.iv_interest);
            Intrinsics.f(viewFindViewById2, "view.findViewById(R.id.iv_interest)");
            this.f61538c = (AppCompatImageView) viewFindViewById2;
        }

        public final AppCompatImageView e() {
            return this.f61538c;
        }

        public final AppCompatTextView f() {
            return this.f61537b;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<String> dataList, Function1<? super List<Integer>, Unit> listener) {
        Intrinsics.g(dataList, "dataList");
        Intrinsics.g(listener, "listener");
        this.f61533i = dataList;
        this.f61534j = listener;
        this.f61535k = new ArrayList<>();
        this.f61536l = g.h(Integer.valueOf(R$mipmap.login_interest_animal_plant), Integer.valueOf(R$mipmap.login_interest_sport), Integer.valueOf(R$mipmap.login_interest_food), Integer.valueOf(R$mipmap.login_interest_game), Integer.valueOf(R$mipmap.login_interest_transportation), Integer.valueOf(R$mipmap.login_interest_fitness), Integer.valueOf(R$mipmap.login_interest_music), Integer.valueOf(R$mipmap.login_interest_animation), Integer.valueOf(R$mipmap.login_interest_art), Integer.valueOf(R$mipmap.login_interest_travel), Integer.valueOf(R$mipmap.login_interest_comedy), Integer.valueOf(R$mipmap.login_interest_fashion));
    }

    public static final void g(d this$0, int i11, View view) {
        Intrinsics.g(this$0, "this$0");
        boolean z11 = !view.isSelected();
        if (z11) {
            this$0.f61535k.add(Integer.valueOf(i11));
        } else {
            this$0.f61535k.remove(Integer.valueOf(i11));
        }
        view.setSelected(z11);
        this$0.f61534j.invoke(this$0.f61535k);
    }

    public final List<Integer> e() {
        return this.f61535k;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, final int i11) {
        Intrinsics.g(holder, "holder");
        holder.f().setText(this.f61533i.get(i11));
        AppCompatImageView appCompatImageViewE = holder.e();
        Integer num = this.f61536l.get(i11);
        Intrinsics.f(num, "mImgIdRes[position]");
        appCompatImageViewE.setImageResource(num.intValue());
        holder.itemView.setSelected(this.f61535k.contains(Integer.valueOf(i11)));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.interest.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.g(this.f61531a, i11, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f61533i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.login_item_interest, parent, false);
        Intrinsics.f(viewInflate, "from(parent.context).inf…_interest, parent, false)");
        return new a(viewInflate);
    }
}
