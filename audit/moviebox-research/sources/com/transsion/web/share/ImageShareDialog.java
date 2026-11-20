package com.transsion.web.share;

import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baselib.report.h;
import com.transsion.baselib.report.m;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialogFragment;
import com.transsion.share.share.i;
import com.transsion.web.R$id;
import com.transsion.web.R$layout;
import com.transsion.web.R$string;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
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
public final class ImageShareDialog extends BaseDialogFragment<zz.b> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f60203g = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Uri f60204f;

    /* JADX INFO: renamed from: com.transsion.web.share.ImageShareDialog$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, zz.b> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(3, zz.b.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/transsion/web/databinding/DialogImgeShareBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ zz.b invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }

        public final zz.b invoke(LayoutInflater p11, ViewGroup viewGroup, boolean z11) {
            Intrinsics.g(p11, "p0");
            return zz.b.c(p11, viewGroup, z11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ImageShareDialog a(Uri imageUrl) {
            Intrinsics.g(imageUrl, "imageUrl");
            ImageShareDialog imageShareDialog = new ImageShareDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("imageUrl", imageUrl);
            imageShareDialog.setArguments(bundle);
            return imageShareDialog;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends BaseQuickAdapter<c, BaseViewHolder> {
        public b() {
            super(R$layout.item_share, null, 2, null);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
        public void x(BaseViewHolder holder, c item) {
            Intrinsics.g(holder, "holder");
            Intrinsics.g(item, "item");
            TextView textView = (TextView) holder.getView(R$id.tv_share);
            textView.setText(item.a());
            textView.setCompoundDrawablesWithIntrinsicBounds(0, item.c(), 0, 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f60205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f60206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f60207c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f60208d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f60209e;

        public c(int i11, @StringRes int i12, String txt, String packageName, String str) {
            Intrinsics.g(txt, "txt");
            Intrinsics.g(packageName, "packageName");
            this.f60205a = i11;
            this.f60206b = i12;
            this.f60207c = txt;
            this.f60208d = packageName;
            this.f60209e = str;
        }

        public /* synthetic */ c(int i11, int i12, String str, String str2, String str3, int i13, DefaultConstructorMarker defaultConstructorMarker) {
            this(i11, i12, str, str2, (i13 & 16) != 0 ? null : str3);
        }

        public final int a() {
            return this.f60206b;
        }

        public final String b() {
            return this.f60209e;
        }

        public final int c() {
            return this.f60205a;
        }

        public final String d() {
            return this.f60208d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f60205a == cVar.f60205a && this.f60206b == cVar.f60206b && Intrinsics.b(this.f60207c, cVar.f60207c) && Intrinsics.b(this.f60208d, cVar.f60208d) && Intrinsics.b(this.f60209e, cVar.f60209e);
        }

        public int hashCode() {
            int iHashCode = ((((((this.f60205a * 31) + this.f60206b) * 31) + this.f60207c.hashCode()) * 31) + this.f60208d.hashCode()) * 31;
            String str = this.f60209e;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ShareItem(iconRes=" + this.f60205a + ", appNameRes=" + this.f60206b + ", txt=" + this.f60207c + ", packageName=" + this.f60208d + ", backPackageName=" + this.f60209e + ")";
        }
    }

    public ImageShareDialog() {
        super(AnonymousClass1.INSTANCE);
    }

    public static final void r0(ImageShareDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void s0(List list, ImageShareDialog this$0, b this_apply, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.g(list, "$list");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        c cVar = (c) list.get(i11);
        this$0.t0(cVar.d(), cVar.b());
        HashMap map = new HashMap();
        String string = this_apply.getContext().getString(cVar.a());
        Intrinsics.f(string, "context.getString(item.appNameRes)");
        map.put("module_name", string);
        m mVar = m.f51277a;
        map.put("source", mVar.f());
        mVar.m("web_share_panel", "click", map);
        this$0.dismiss();
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment
    public void initView() {
        Bundle arguments = getArguments();
        this.f60204f = arguments != null ? (Uri) arguments.getParcelable("imageUrl") : null;
        ShapeableImageView shapeableImageView = getMViewBinding().f82200c;
        Intrinsics.f(shapeableImageView, "mViewBinding.ivShare");
        qw.a.a(shapeableImageView, this.f60204f, 4.0f);
        getMViewBinding().f82199b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.web.share.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImageShareDialog.r0(this.f60231a, view);
            }
        });
        RecyclerView recyclerView = getMViewBinding().f82201d;
        recyclerView.addItemDecoration(new ro.c(f0.a(16.0f)));
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        final List<c> listQ0 = q0();
        final b bVar = new b();
        bVar.x0(listQ0);
        bVar.B0(new f9.d() { // from class: com.transsion.web.share.b
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                ImageShareDialog.s0(listQ0, this, bVar, baseQuickAdapter, view, i11);
            }
        });
        recyclerView.setAdapter(bVar);
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment
    public void k0() {
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment
    public h newLogViewConfig() {
        return new h("share_panel", false, 2, null);
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BottomDialogTheme);
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = com.transsion.core.utils.e.a(287.0f);
        attributes.width = -1;
        window.setGravity(80);
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(h0());
        }
        window.setAttributes(attributes);
    }

    public final String p0(String str, String str2) {
        if (str != null && com.transsion.baseui.util.a.f51450a.c(getContext(), str)) {
            return str;
        }
        if (str2 == null || !com.transsion.baseui.util.a.f51450a.c(getContext(), str2)) {
            return null;
        }
        return str2;
    }

    public final List<c> q0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c(R$mipmap.player_ic_whatsapp, R$string.whatsapp, "whatsup", "com.whatsapp", null, 16, null));
        arrayList.add(new c(R$mipmap.player_ic_telegram, R$string.telegram, "Telegram", "org.telegram.messenger", "org.telegram.messenger.web"));
        return arrayList;
    }

    public final void t0(String str, String str2) {
        final String strP0 = p0(str, str2);
        if (Intrinsics.b(str, "org.telegram.messenger")) {
            i iVar = i.f57758a;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
            iVar.b(fragmentActivityRequireActivity, this.f60204f, new Function1<Boolean, Unit>() { // from class: com.transsion.web.share.ImageShareDialog$shareImage$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11) {
                    this.this$0.u0(z11, strP0);
                }
            });
            return;
        }
        if (Intrinsics.b(str, "com.whatsapp")) {
            i iVar2 = i.f57758a;
            FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
            Intrinsics.f(fragmentActivityRequireActivity2, "requireActivity()");
            iVar2.a(fragmentActivityRequireActivity2, strP0, this.f60204f, new Function1<Boolean, Unit>() { // from class: com.transsion.web.share.ImageShareDialog$shareImage$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11) {
                    this.this$0.u0(z11, strP0);
                }
            });
        }
    }

    public final void u0(boolean z11, String str) {
        if (z11) {
            return;
        }
        if (str == null || str.length() == 0) {
            com.tn.lib.widget.toast.core.h.f50034a.k(R$string.web_app_not_exist);
        } else {
            com.tn.lib.widget.toast.core.h.f50034a.k(R$string.share_failed_tips);
        }
    }
}
