package com.transsion.usercenter.profile.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.m;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.R$style;
import com.transsion.usercenter.profile.report.ReportViewModel;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class BlockDialog extends BaseDialog {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f59571i = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f59572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f59573d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f59574f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UserInfo f59575g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f59576h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BlockDialog a(String str, boolean z11, UserInfo userInfo) {
            BlockDialog blockDialog = new BlockDialog();
            blockDialog.setArguments(androidx.core.os.c.b(TuplesKt.a("report_type", str), TuplesKt.a("userInfo", userInfo), TuplesKt.a("isBlock", Boolean.valueOf(z11))));
            return blockDialog;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59577a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59577a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59577a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f59577a.invoke(obj);
        }
    }

    public BlockDialog() {
        super(R$layout.layout_block);
        this.f59572c = new Function0<Unit>() { // from class: com.transsion.usercenter.profile.dialog.BlockDialog$callBack$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        };
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.usercenter.profile.dialog.BlockDialog$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f59573d = FragmentViewModelLazyKt.a(this, Reflection.b(ReportViewModel.class), new Function0<x0>() { // from class: com.transsion.usercenter.profile.dialog.BlockDialog$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.f(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.usercenter.profile.dialog.BlockDialog$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object objInvoke = function0.invoke();
                m mVar = objInvoke instanceof m ? (m) objInvoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f59576h = true;
    }

    private final void t0(View view) {
        String str;
        String str2;
        TextView textView = (TextView) view.findViewById(R$id.tvTitle);
        TextView textView2 = (TextView) view.findViewById(R$id.tvDesc);
        TextView textView3 = (TextView) view.findViewById(R$id.tvBlock);
        UserInfo userInfo = this.f59575g;
        if (userInfo != null) {
            if (this.f59576h) {
                str = getString(R$string.str_unblock) + " " + userInfo.getNickname() + "?";
            } else {
                str = getString(R$string.str_block) + " " + userInfo.getNickname() + "?";
            }
            textView.setText(str);
            if (this.f59576h) {
                str2 = userInfo.getNickname() + " " + getString(R$string.unblock_desc);
            } else {
                str2 = userInfo.getNickname() + " " + getString(R$string.block_desc);
            }
            textView2.setText(str2);
        }
        ((TextView) view.findViewById(R$id.tvCancel)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.dialog.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BlockDialog.u0(this.f59579a, view2);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BlockDialog.v0(this.f59580a, view2);
            }
        });
        textView3.setText(this.f59576h ? getString(R$string.str_unblock) : getString(R$string.str_block));
    }

    public static final void u0(BlockDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void v0(BlockDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f59576h) {
            this$0.r0();
        } else {
            this$0.q0();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.report_style);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        Window window2;
        Dialog dialog = getDialog();
        if (dialog != null && (window2 = dialog.getWindow()) != null) {
            window2.setLayout(-1, -2);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setGravity(17);
        }
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        this.f59574f = arguments != null ? arguments.getString("report_type") : null;
        Bundle arguments2 = getArguments();
        this.f59575g = (UserInfo) (arguments2 != null ? arguments2.getSerializable("userInfo") : null);
        Bundle arguments3 = getArguments();
        this.f59576h = arguments3 != null ? arguments3.getBoolean("isBlock") : true;
        t0(view);
        p0();
    }

    public final void p0() {
        s0().e().j(this, new b(new Function1<BaseDto<Object>, Unit>() { // from class: com.transsion.usercenter.profile.dialog.BlockDialog$blockLiveData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseDto<Object> baseDto) {
                invoke2(baseDto);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BaseDto<Object> baseDto) {
                if (baseDto != null) {
                    if (Intrinsics.b(baseDto.getCode(), "200")) {
                        this.this$0.f59572c.invoke();
                    } else {
                        zp.b.f82110a.e(baseDto.getMsg());
                    }
                }
                this.this$0.dismiss();
            }
        }));
    }

    public final void q0() {
        String userId;
        UserInfo userInfo = this.f59575g;
        if (userInfo == null || (userId = userInfo.getUserId()) == null) {
            return;
        }
        s0().d(userId);
    }

    public final void r0() {
        String userId;
        UserInfo userInfo = this.f59575g;
        if (userInfo == null || (userId = userInfo.getUserId()) == null) {
            return;
        }
        s0().i(userId);
    }

    public final ReportViewModel s0() {
        return (ReportViewModel) this.f59573d.getValue();
    }

    public final void w0(Context context, String str, Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        j0(context, str);
        this.f59572c = callback;
    }
}
