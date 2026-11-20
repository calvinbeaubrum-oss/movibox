package com.transsion.usercenter.setting.labelsfeedback;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.R$drawable;
import com.transsion.usercenter.setting.labelsfeedback.model.FbDataModel;
import com.transsion.usercenter.setting.labelsfeedback.model.FbOption;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.w;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xy.y;

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
public final class c extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FbDataModel f59715i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f59716j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public mz.a f59717k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class a extends RecyclerView.a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConstraintLayout f59718b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AppCompatTextView f59719c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AppCompatCheckBox f59720d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f59721f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final View f59722g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ c f59723h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, y binding) {
            super(binding.getRoot());
            Intrinsics.g(binding, "binding");
            this.f59723h = cVar;
            ConstraintLayout root = binding.getRoot();
            Intrinsics.f(root, "binding.root");
            this.f59718b = root;
            AppCompatTextView appCompatTextView = binding.f80991f;
            Intrinsics.f(appCompatTextView, "binding.textView");
            this.f59719c = appCompatTextView;
            AppCompatCheckBox appCompatCheckBox = binding.f80990d;
            Intrinsics.f(appCompatCheckBox, "binding.radioButton");
            this.f59720d = appCompatCheckBox;
            View view = binding.f80988b;
            Intrinsics.f(view, "binding.bgView");
            this.f59721f = view;
            View view2 = binding.f80989c;
            Intrinsics.f(view2, "binding.divider");
            this.f59722g = view2;
        }

        public final View e() {
            return this.f59721f;
        }

        public final View f() {
            return this.f59722g;
        }

        public final AppCompatCheckBox g() {
            return this.f59720d;
        }

        public final AppCompatTextView h() {
            return this.f59719c;
        }
    }

    public c(FbDataModel model) {
        Intrinsics.g(model, "model");
        this.f59715i = model;
    }

    public static final void f(int i11, c this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Set setG = w.g(Integer.valueOf(i11));
        Integer selectedIndex = this$0.f59715i.getSelectedIndex();
        if (selectedIndex != null) {
            setG.add(Integer.valueOf(selectedIndex.intValue()));
        }
        FbDataModel fbDataModel = this$0.f59715i;
        Integer selectedIndex2 = fbDataModel.getSelectedIndex();
        fbDataModel.setSelectedIndex((selectedIndex2 != null && selectedIndex2.intValue() == i11) ? null : Integer.valueOf(i11));
        Iterator it = setG.iterator();
        while (it.hasNext()) {
            this$0.notifyItemChanged(((Number) it.next()).intValue());
        }
        this$0.f59715i.setSelectedId(null);
        Integer selectedIndex3 = this$0.f59715i.getSelectedIndex();
        if (selectedIndex3 != null) {
            int iIntValue = selectedIndex3.intValue();
            FbDataModel fbDataModel2 = this$0.f59715i;
            fbDataModel2.setSelectedId(Integer.valueOf(fbDataModel2.getOptions().get(iIntValue).getId()));
        }
        d dVar = this$0.f59716j;
        if (dVar != null) {
            dVar.C(this$0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"ClickableViewAccessibility"})
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, final int i11) {
        int i12;
        Intrinsics.g(holder, "holder");
        FbOption fbOption = this.f59715i.getOptions().get(i11);
        Integer selectedIndex = this.f59715i.getSelectedIndex();
        boolean z11 = selectedIndex != null && selectedIndex.intValue() == i11;
        holder.h().setText(fbOption.getName());
        holder.g().setChecked(z11);
        View viewE = holder.e();
        if (i11 == 0) {
            so.c.g(holder.f());
            i12 = R$drawable.bg_radius_top_6_color_white_6p;
        } else {
            i12 = i11 == this.f59715i.getOptions().size() - 1 ? R$drawable.bg_radius_bottom_6_color_white_6p : R$color.white_6;
        }
        viewE.setBackgroundResource(i12);
        holder.h().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.labelsfeedback.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.f(i11, this, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        y yVarC = y.c(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.f(yVarC, "inflate(layoutInflater, parent, false)");
        return new a(this, yVarC);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f59715i.getOptions().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i11) {
        return super.getItemViewType(i11);
    }

    public final void h(mz.a aVar) {
        this.f59717k = aVar;
    }

    public final void i(d dVar) {
        this.f59716j = dVar;
    }
}
