package com.transsion.publish.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$style;
import com.transsion.publish.view.operation.OperationBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class OpertaionVerticalDialogFragment extends BaseDialog {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f56507h = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<OperationBean> f56508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f56509d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public jw.i f56510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.transsion.publish.adapter.a f56511g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements jw.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f56513b;

        public b(View view) {
            this.f56513b = view;
        }

        @Override // jw.b
        public void a(OperationBean item, int i11) {
            com.transsion.publish.adapter.a aVar;
            Intrinsics.g(item, "item");
            int type = item.getType();
            if (type == 0) {
                com.transsion.publish.adapter.a aVar2 = OpertaionVerticalDialogFragment.this.f56511g;
                if (aVar2 != null) {
                    Context context = this.f56513b.getContext();
                    Intrinsics.f(context, "context");
                    aVar2.startPhoto(context);
                    return;
                }
                return;
            }
            if (type == 1) {
                com.transsion.publish.adapter.a aVar3 = OpertaionVerticalDialogFragment.this.f56511g;
                if (aVar3 != null) {
                    Context context2 = this.f56513b.getContext();
                    Intrinsics.f(context2, "context");
                    aVar3.startVideo(context2);
                    return;
                }
                return;
            }
            if (type == 2) {
                com.transsion.publish.adapter.a aVar4 = OpertaionVerticalDialogFragment.this.f56511g;
                if (aVar4 != null) {
                    Context context3 = this.f56513b.getContext();
                    Intrinsics.f(context3, "context");
                    aVar4.startAudio(context3);
                    return;
                }
                return;
            }
            if (type != 3) {
                if (type == 4 && (aVar = OpertaionVerticalDialogFragment.this.f56511g) != null) {
                    Context context4 = this.f56513b.getContext();
                    Intrinsics.f(context4, "context");
                    aVar.startLink(context4);
                    return;
                }
                return;
            }
            com.transsion.publish.adapter.a aVar5 = OpertaionVerticalDialogFragment.this.f56511g;
            if (aVar5 != null) {
                Context context5 = this.f56513b.getContext();
                Intrinsics.f(context5, "context");
                aVar5.startWork(context5);
            }
        }
    }

    public OpertaionVerticalDialogFragment() {
        super(R$layout.opertaion_vertical_layout);
        this.f56508c = new ArrayList();
    }

    private final void n0(View view) {
        this.f56509d = (RecyclerView) view.findViewById(R$id.f56357rv);
        jw.i iVar = new jw.i();
        this.f56510f = iVar;
        iVar.i(this.f56508c);
        RecyclerView recyclerView = this.f56509d;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 1, false));
            recyclerView.setAdapter(this.f56510f);
        }
        jw.i iVar2 = this.f56510f;
        if (iVar2 != null) {
            iVar2.j(new b(view));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BottomDialogThemes);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(contextRequireContext, getTheme());
        Window window = bVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.bottom_dialog_animations);
        }
        Window window2 = bVar.getWindow();
        if (window2 != null) {
            window2.setGravity(80);
            window2.setDimAmount(0.5f);
            WindowManager.LayoutParams attributes = window2.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            } else {
                Intrinsics.f(attributes, "it.attributes ?: WindowManager.LayoutParams()");
            }
            attributes.width = com.transsion.baseui.util.a.f51450a.b(contextRequireContext);
            attributes.height = -2;
            attributes.flags = 32;
            window2.setBackgroundDrawable(null);
            window2.setAttributes(attributes);
        }
        return bVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        n0(view);
    }
}
