package com.transsion.member.history;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.member.R$id;
import com.transsion.member.R$string;
import com.transsion.member.bean.PointsHistoryData;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import qu.b;
import so.c;

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
@Route(path = "/member/point_history")
@Metadata
@SourceDebugExtension
public final class PointsHistoryActivity extends BaseNewActivity<b> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f53332i;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f53333a;

        public a(Function1 function) {
            Intrinsics.g(function, "function");
            this.f53333a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f53333a;
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
            this.f53333a.invoke(obj);
        }
    }

    public PointsHistoryActivity() {
        final Function0 function0 = null;
        this.f53332i = new ViewModelLazy(Reflection.b(PointsHistoryViewModel.class), new Function0<x0>() { // from class: com.transsion.member.history.PointsHistoryActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<v0.c>() { // from class: com.transsion.member.history.PointsHistoryActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                return this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<r3.a>() { // from class: com.transsion.member.history.PointsHistoryActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final r3.a invoke() {
                r3.a aVar;
                Function0 function1 = function0;
                return (function1 == null || (aVar = (r3.a) function1.invoke()) == null) ? this.getDefaultViewModelCreationExtras() : aVar;
            }
        });
    }

    public static final void r0(PointsHistoryActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.finish();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String U() {
        return "";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void X() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Y() {
        ((b) getMViewBinding()).f74899c.f74977c.setText(getString(R$string.points_history_title));
        ((b) getMViewBinding()).f74899c.f74976b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.history.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PointsHistoryActivity.r0(this.f53343a, view);
            }
        });
        LinearLayoutCompat linearLayoutCompatB = ((b) getMViewBinding()).getRoot();
        Intrinsics.f(linearLayoutCompatB, "mViewBinding.root");
        c.e(linearLayoutCompatB);
        e0();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Z() {
        p0().d().j(this, new a(new Function1<PointsHistoryData, Unit>() { // from class: com.transsion.member.history.PointsHistoryActivity$initViewModel$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PointsHistoryData pointsHistoryData) {
                invoke2(pointsHistoryData);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PointsHistoryData pointsHistoryData) {
                String coinBalance;
                AppCompatTextView appCompatTextView = ((b) this.this$0.getMViewBinding()).f74900d;
                if (pointsHistoryData == null || (coinBalance = pointsHistoryData.getCoinBalance()) == null) {
                    coinBalance = "0";
                }
                appCompatTextView.setText(coinBalance);
            }
        }));
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean b0() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void c0() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void d0() {
        super.d0();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.f(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
        fragmentTransactionBeginTransaction.replace(R$id.container, PointsHistoryFragment.f53334r.a());
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isTranslucent() {
        return true;
    }

    public final PointsHistoryViewModel p0() {
        return (PointsHistoryViewModel) this.f53332i.getValue();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public b getViewBinding() {
        b bVarC = b.c(getLayoutInflater());
        Intrinsics.f(bVarC, "inflate(layoutInflater)");
        return bVarC;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
    }
}
