package com.transsion.room.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.room.R$id;
import com.transsion.room.R$string;
import com.transsion.room.fragment.RoomsFragment;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.JoinRoomEvent;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.w0;

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
@Route(path = "/room/my")
@Metadata
@SourceDebugExtension
public final class MyRoomActivity extends BaseNewActivity<sw.d> implements r00.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f57099l = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RoomsFragment f57100i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f57101j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f57102k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String U() {
        String string = getString(R$string.str_room_title);
        Intrinsics.f(string, "getString(R.string.str_room_title)");
        return string;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void X() {
        Function1<JoinRoomEvent, Unit> function1 = new Function1<JoinRoomEvent, Unit>() { // from class: com.transsion.room.activity.MyRoomActivity$initListener$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JoinRoomEvent joinRoomEvent) {
                invoke2(joinRoomEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JoinRoomEvent value) {
                RoomsFragment roomsFragment;
                Intrinsics.g(value, "value");
                MyRoomActivity myRoomActivity = this.this$0;
                try {
                    Result.Companion companion = Result.Companion;
                    if (!value.getJoin() && (roomsFragment = myRoomActivity.f57100i) != null) {
                        roomsFragment.o1();
                    }
                    Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m163constructorimpl(ResultKt.a(th2));
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = JoinRoomEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Y() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Z() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void c0() {
        if (this.f57100i == null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.f(supportFragmentManager, "supportFragmentManager");
            FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
            RoomsFragment roomsFragmentA = RoomsFragment.f57229v.a(this.f57101j, this.f57102k);
            fragmentTransactionBeginTransaction.replace(R$id.flContent, roomsFragmentA);
            this.f57100i = roomsFragmentA;
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "myrooms";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isChangeStatusBar() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isStatusDark() {
        return !o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i11, int i12, Intent intent) {
        RoomsFragment roomsFragment;
        super.onActivityResult(i11, i12, intent);
        if (i11 == 10086 && i12 == -1 && (roomsFragment = this.f57100i) != null) {
            roomsFragment.o1();
        }
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.f57101j = intent.getStringExtra("userId");
            this.f57102k = intent.getBooleanExtra("isSelf", false);
        }
        super.onCreate(bundle);
    }

    @Override // r00.a
    public void onLogin(UserInfo userInfo) {
        r00.a.C0822a.a(this, userInfo);
    }

    @Override // r00.a
    public void onLogout() {
        r00.a.C0822a.b(this);
    }

    @Override // r00.a
    public void onUpdateUserInfo(UserInfo userInfo) {
        r00.a.C0822a.c(this, userInfo);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public sw.d getViewBinding() {
        sw.d dVarC = sw.d.c(getLayoutInflater());
        Intrinsics.f(dVarC, "inflate(layoutInflater)");
        return dVarC;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
        i0();
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            k0();
        } else {
            g0();
            c0();
        }
    }
}
