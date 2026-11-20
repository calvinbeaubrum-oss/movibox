package com.transsion.usercenter.setting.labelsfeedback;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.usercenter.setting.labelsfeedback.model.FBContact;
import com.transsion.usercenter.setting.labelsfeedback.model.FbDataModel;
import com.transsnet.loginapi.bean.Country;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import xy.z;

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
public final class h extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FbDataModel f59727i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f59728j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f59729k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class a extends RecyclerView.a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinearLayout f59730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final UCEditText f59731c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AppCompatTextView f59732d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ShapeableImageView f59733f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AppCompatEditText f59734g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final AppCompatEditText f59735h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ h f59736i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h hVar, z binding) {
            super(binding.getRoot());
            Intrinsics.g(binding, "binding");
            this.f59736i = hVar;
            LinearLayout root = binding.getRoot();
            Intrinsics.f(root, "binding.root");
            this.f59730b = root;
            UCEditText uCEditText = binding.f80995d;
            Intrinsics.f(uCEditText, "binding.editText");
            this.f59731c = uCEditText;
            AppCompatTextView appCompatTextView = binding.f80993b;
            Intrinsics.f(appCompatTextView, "binding.countTextView");
            this.f59732d = appCompatTextView;
            ShapeableImageView shapeableImageView = binding.f80996f;
            Intrinsics.f(shapeableImageView, "binding.imageView");
            this.f59733f = shapeableImageView;
            AppCompatEditText appCompatEditText = binding.f80994c;
            Intrinsics.f(appCompatEditText, "binding.countryEditText");
            this.f59734g = appCompatEditText;
            AppCompatEditText appCompatEditText2 = binding.f80997g;
            Intrinsics.f(appCompatEditText2, "binding.phoneEditText");
            this.f59735h = appCompatEditText2;
        }

        public final AppCompatTextView e() {
            return this.f59732d;
        }

        public final AppCompatEditText f() {
            return this.f59734g;
        }

        public final UCEditText g() {
            return this.f59731c;
        }

        public final ShapeableImageView h() {
            return this.f59733f;
        }

        public final AppCompatEditText i() {
            return this.f59735h;
        }

        public final LinearLayout j() {
            return this.f59730b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f59737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f59738b;

        public b(a aVar, h hVar) {
            this.f59737a = aVar;
            this.f59738b = hVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String string;
            int length = editable != null ? editable.length() : 0;
            this.f59737a.e().setText(length + "/500");
            this.f59738b.j().setContent((editable == null || (string = editable.toString()) == null) ? null : StringsKt__StringsKt.Z0(string).toString());
            i iVarI = this.f59738b.i();
            if (iVarI != null) {
                iVarI.k(this.f59738b);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String string;
            FBContact contact = h.this.j().getContact();
            if (editable == null || (string = editable.toString()) == null) {
                string = "";
            }
            contact.setPhone(string);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public h(FbDataModel model, i iVar) {
        Intrinsics.g(model, "model");
        this.f59727i = model;
        this.f59728j = iVar;
    }

    public static final void l(h this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        i iVar = this$0.f59728j;
        if (iVar != null) {
            iVar.s(this$0);
        }
    }

    public static final void m(h this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        i iVar = this$0.f59728j;
        if (iVar != null) {
            iVar.j(this$0);
        }
    }

    public static final void n(h this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        i iVar = this$0.f59728j;
        if (iVar != null) {
            iVar.w(this$0);
        }
    }

    public final void g(Country country) {
        AppCompatEditText appCompatEditTextF;
        if (country != null) {
            this.f59727i.getContact().setCountry(country);
            String str = country.getCountry_s() + " +" + country.getCode();
            a aVar = this.f59729k;
            if (aVar == null || (appCompatEditTextF = aVar.f()) == null) {
                return;
            }
            appCompatEditTextF.setText(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public final void h(String str) {
        ShapeableImageView shapeableImageViewH;
        i iVar;
        this.f59727i.setImagePath(str);
        a aVar = this.f59729k;
        if (aVar == null || (shapeableImageViewH = aVar.h()) == null || (iVar = this.f59728j) == null) {
            return;
        }
        iVar.n(this, shapeableImageViewH);
    }

    public final i i() {
        return this.f59728j;
    }

    public final FbDataModel j() {
        return this.f59727i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int i11) {
        Intrinsics.g(holder, "holder");
        holder.j().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.labelsfeedback.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.l(this.f59724a, view);
            }
        });
        holder.h().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.labelsfeedback.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.m(this.f59725a, view);
            }
        });
        holder.e().setText("0/500");
        holder.g().addTextChangedListener(new b(holder, this));
        holder.f().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.labelsfeedback.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.n(this.f59726a, view);
            }
        });
        holder.i().addTextChangedListener(new c());
        String content = this.f59727i.getContent();
        if (content != null) {
            holder.g().setText(new SpannableStringBuilder(content));
        }
        h(this.f59727i.getImagePath());
        g(this.f59727i.getContact().getCountry());
        holder.i().setText(new SpannableStringBuilder(this.f59727i.getContact().getPhone()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        z zVarC = z.c(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.f(zVarC, "inflate(layoutInflater, parent, false)");
        a aVar = new a(this, zVarC);
        this.f59729k = aVar;
        return aVar;
    }
}
