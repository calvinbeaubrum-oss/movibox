package com.transsnet.downloader.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsnet.downloader.R$layout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class DownloadMoreDialog extends BaseDialog {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f60517i = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h00.i f60518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f60519d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function3<? super Integer, ? super String, ? super String, Unit> f60520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f60521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<Pair<String, String>> f60522h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadMoreDialog a(List<Pair<String, String>> contents) {
            Intrinsics.g(contents, "contents");
            DownloadMoreDialog downloadMoreDialog = new DownloadMoreDialog();
            downloadMoreDialog.setArguments(androidx.core.os.c.b(TuplesKt.a("contents", contents)));
            return downloadMoreDialog;
        }
    }

    public DownloadMoreDialog() {
        super(R$layout.dialog_download_more);
        this.f60522h = new ArrayList();
    }

    private final void o0() {
        RecyclerView recyclerView;
        List<Pair<String, String>> list = this.f60522h;
        ArrayList arrayList = new ArrayList(kotlin.collections.h.v(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Pair) it.next()).getFirst());
        }
        l lVar = new l(CollectionsKt___CollectionsKt.M0(arrayList));
        lVar.B0(new f9.d() { // from class: com.transsnet.downloader.dialog.j
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                DownloadMoreDialog.p0(this.f60590a, baseQuickAdapter, view, i11);
            }
        });
        this.f60519d = lVar;
        h00.i iVar = this.f60518c;
        if (iVar == null || (recyclerView = iVar.f65897b) == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.f60519d);
    }

    public static final void p0(DownloadMoreDialog this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        this$0.dismissAllowingStateLoss();
        Function3<? super Integer, ? super String, ? super String, Unit> function3 = this$0.f60520f;
        if (function3 != null) {
            Integer numValueOf = Integer.valueOf(i11);
            Object item = adapter.getItem(i11);
            Intrinsics.e(item, "null cannot be cast to non-null type kotlin.String");
            function3.invoke(numValueOf, (String) item, this$0.f60522h.get(i11).getSecond());
        }
    }

    private final void q0(View view) {
        AppCompatTextView appCompatTextView;
        h00.i iVarA = h00.i.a(view);
        this.f60518c = iVarA;
        if (iVarA == null || (appCompatTextView = iVarA.f65898c) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DownloadMoreDialog.r0(this.f60592a, view2);
            }
        });
    }

    public static final void r0(DownloadMoreDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        Function0<Unit> function0 = this$0.f60521g;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BottomDialogTheme);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(contextRequireContext, getTheme());
        Window window = bVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.BaseBottomDialogAnimation);
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
            window2.setBackgroundDrawable(null);
            window2.setAttributes(attributes);
        }
        return bVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("contents") : null;
        List list = TypeIntrinsics.l(serializable) ? (List) serializable : null;
        if (list != null) {
            this.f60522h.clear();
            this.f60522h.addAll(list);
        }
        q0(view);
        o0();
    }

    public final void s0(Function3<? super Integer, ? super String, ? super String, Unit> call) {
        Intrinsics.g(call, "call");
        this.f60520f = call;
    }
}
