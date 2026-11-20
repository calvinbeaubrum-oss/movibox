package hz;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blankj.utilcode.util.Utils;
import com.google.android.material.card.MaterialCardView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
import com.transsnet.downloader.adapter.d0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tp.f;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PopupWindow f66800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0.b f66801b;

    public static final void d(c this$0, boolean z11, View view) {
        Intrinsics.g(this$0, "this$0");
        d0.b bVar = this$0.f66801b;
        if (bVar != null) {
            bVar.b(0, 0, 2, z11);
        }
        PopupWindow popupWindow = this$0.f66800a;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public static final void e(c this$0, boolean z11, View view) {
        Intrinsics.g(this$0, "this$0");
        d0.b bVar = this$0.f66801b;
        if (bVar != null) {
            bVar.b(0, 0, 1, z11);
        }
        PopupWindow popupWindow = this$0.f66800a;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public final View c(Context context, final boolean z11) {
        String string;
        View view = LayoutInflater.from(context).inflate(R$layout.popup_report_layout, (ViewGroup) null);
        view.findViewById(R$id.menu_item1).setOnClickListener(new View.OnClickListener() { // from class: hz.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.d(this.f66796a, z11, view2);
            }
        });
        TextView textView = (TextView) view.findViewById(R$id.menu_item2);
        textView.setOnClickListener(new View.OnClickListener() { // from class: hz.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.e(this.f66798a, z11, view2);
            }
        });
        if (z11) {
            textView.setVisibility(8);
            string = textView.getResources().getString(R$string.str_unblock);
        } else {
            string = textView.getResources().getString(R$string.str_block);
        }
        textView.setText(string);
        Intrinsics.f(view, "view");
        return view;
    }

    public final void f(d0.b listener) {
        Intrinsics.g(listener, "listener");
        this.f66801b = listener;
    }

    public final void g(View anchorView, boolean z11) {
        Intrinsics.g(anchorView, "anchorView");
        Context context = anchorView.getContext();
        Intrinsics.f(context, "anchorView.context");
        View viewC = c(context, z11);
        PopupWindow popupWindow = new PopupWindow(viewC, -2, -2, true);
        this.f66800a = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        int[] iArrA = com.transsnet.downloader.popup.c.f61091a.a(anchorView, viewC);
        f fVar = f.f77260a;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        int iA = fVar.a(applicationA, 16.0f);
        int i11 = iArrA[0] - iA;
        iArrA[0] = i11;
        int i12 = iArrA[1] - iA;
        iArrA[1] = i12;
        PopupWindow popupWindow2 = this.f66800a;
        if (popupWindow2 != null) {
            popupWindow2.showAtLocation(anchorView, MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START, i11, i12);
        }
    }
}
