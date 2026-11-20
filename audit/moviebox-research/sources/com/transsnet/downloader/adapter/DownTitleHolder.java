package com.transsnet.downloader.adapter;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.TnTextView;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.commercializationapi.IInterceptReportApi;
import com.transsion.memberapi.IMemberApi;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.dialog.DownloadTaskControlManagerDialog;
import com.transsnet.downloader.fragment.DownloadPanelFragment;
import com.transsnet.downloader.util.BatteryPermissionUtils;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

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
public final class DownTitleHolder extends BaseViewHolder implements d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DownloadPanelFragment f60301b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownTitleHolder(View view, DownloadPanelFragment fragment) {
        super(view);
        Intrinsics.g(view, "view");
        Intrinsics.g(fragment, "fragment");
        this.f60301b = fragment;
    }

    public static final void f(boolean z11, boolean z12, View view) {
        new DownloadTaskControlManagerDialog(z11, z12).j0(com.blankj.utilcode.util.a.b(), "DownloadTaskControlManagerDialog");
        ((IInterceptReportApi) com.alibaba.android.arouter.launcher.a.d().h(IInterceptReportApi.class)).o();
    }

    @Override // com.transsnet.downloader.adapter.d0
    public void a(int i11, e9.a aVar) {
        d0.a.a(this, i11, aVar);
    }

    @Override // com.transsnet.downloader.adapter.d0
    public void c(d0.b bVar) {
        d0.a.b(this, bVar);
    }

    @Override // com.transsnet.downloader.adapter.d0
    public void d(int i11, final e9.a aVar) {
        int iA;
        final int i12;
        final boolean zG;
        if (aVar instanceof DownloadBean) {
            TnTextView tnTextView = (TnTextView) getView(R$id.tvTitle);
            View view = getView(R$id.vTopSpace);
            DownloadBean downloadBean = (DownloadBean) aVar;
            float f11 = 12.0f;
            if (downloadBean.isMore()) {
                iA = com.blankj.utilcode.util.f0.a(12.0f);
                i12 = R$string.str_downloading_title;
            } else {
                List<DownloadBean> listF = DownloadListManager.f61186m.a().v().f();
                if (listF != null && listF.size() > 0) {
                    f11 = 8.0f;
                }
                iA = com.blankj.utilcode.util.f0.a(f11);
                i12 = R$string.str_downloaded_title;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = iA;
            view.setLayoutParams(layoutParams);
            if (downloadBean.getCount() > 0) {
                tnTextView.setTextAction(new Function0<CharSequence>() { // from class: com.transsnet.downloader.adapter.DownTitleHolder$initData$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final CharSequence invoke() {
                        String string = this.this$0.itemView.getResources().getString(i12);
                        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                        String string2 = this.this$0.itemView.getContext().getString(R$string.str_count);
                        Intrinsics.f(string2, "itemView.context.getString(R.string.str_count)");
                        String str = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(((DownloadBean) aVar).getCount())}, 1));
                        Intrinsics.f(str, "format(...)");
                        return string + " " + str;
                    }
                });
            }
            TextView textView = (TextView) getView(R$id.tvManager);
            if (Build.VERSION.SDK_INT < 23) {
                zG = false;
            } else {
                BatteryPermissionUtils batteryPermissionUtils = BatteryPermissionUtils.f61124a;
                Context context = textView.getContext();
                Intrinsics.f(context, "this.context");
                zG = batteryPermissionUtils.g(context);
            }
            final boolean zE1 = ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).e1();
            if (!zE1 && zG) {
                textView.setVisibility(8);
            } else if (i11 != 0) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.adapter.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        DownTitleHolder.f(zG, zE1, view2);
                    }
                });
            }
        }
    }
}
