package com.transsion.postdetail.shorttv;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.ImmersionBar;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.baseui.music.MusicFloatManager;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.shorttv.vskitstyle.ShortTvListFragment;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes7.dex */
@Route(path = "/shorts/detail")
@Metadata
@SourceDebugExtension
public final class ShortTvListActivity extends BaseActivity<tv.d> implements com.transsion.baselib.report.g, com.transsion.videofloat.manager.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f55358h = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Autowired(name = "ep")
    @JvmField
    public int f55359a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Autowired(name = "ms")
    @JvmField
    public long f55360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Autowired(name = "historyFist")
    @JvmField
    public boolean f55361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Autowired(name = "item_object")
    @JvmField
    public Subject f55362d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Autowired(name = "id")
    @JvmField
    public String f55363f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ShortTvListFragment f55364g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, Subject subject, Integer num, long j11, boolean z11, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                num = null;
            }
            Integer num2 = num;
            if ((i11 & 8) != 0) {
                j11 = 0;
            }
            aVar.a(context, subject, num2, j11, (i11 & 16) != 0 ? false : z11);
        }

        public final void a(Context context, Subject subject, Integer num, long j11, boolean z11) {
            Intrinsics.g(context, "context");
            Intrinsics.g(subject, "subject");
            Intent intent = new Intent(context, (Class<?>) ShortTvListActivity.class);
            Bundle bundleA = androidx.core.os.c.a();
            bundleA.putSerializable("item_object", subject);
            if (num != null) {
                num.intValue();
                bundleA.putInt("ep", num.intValue());
                bundleA.putLong("ms", j11);
                bundleA.putBoolean("historyFist", z11);
            }
            intent.putExtras(bundleA);
            context.startActivity(intent);
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public tv.d getViewBinding() {
        tv.d dVarC = tv.d.c(getLayoutInflater());
        Intrinsics.f(dVarC, "inflate(layoutInflater)");
        return dVarC;
    }

    public final void O() {
        com.transsion.ad.bidding.interstitial.a.f50342m.a("ShortTvInterstitialScene");
        com.transsion.ad.bidding.video.f.f50385m.a("ShortTvVideoScene");
    }

    public final void Q() {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag("ShortTvListFragment");
        ShortTvListFragment shortTvListFragment = fragmentFindFragmentByTag instanceof ShortTvListFragment ? (ShortTvListFragment) fragmentFindFragmentByTag : null;
        this.f55364g = shortTvListFragment;
        if (shortTvListFragment == null) {
            ShortTvListFragment shortTvListFragment2 = new ShortTvListFragment();
            shortTvListFragment2.setArguments(getIntent().getExtras());
            this.f55364g = shortTvListFragment2;
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            int i11 = R$id.f54878fl;
            ShortTvListFragment shortTvListFragment3 = this.f55364g;
            Intrinsics.d(shortTvListFragment3);
            fragmentTransactionBeginTransaction.replace(i11, shortTvListFragment3, "ShortTvListFragment");
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        }
    }

    @Override // com.transsion.baseui.activity.BaseMusicFloatActivity
    public boolean isMusicFloatingAttach() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.transsion.shorttv.utils.a.f57889a.b(new com.transsion.postdetail.shorttv.vskitstyle.b());
        O();
        com.alibaba.android.arouter.launcher.a.d().f(this);
        ImmersionBar.with(this).statusBarDarkFont(false).init();
        Q();
        MusicFloatManager.f51403i.b().z(null);
        com.transsion.player.mediasession.c.f54613a.p();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        ShortTvListFragment shortTvListFragment;
        super.onNewIntent(intent);
        int intExtra = intent != null ? intent.getIntExtra("ep", -1) : -1;
        String subjectId = null;
        String stringExtra = intent != null ? intent.getStringExtra("id") : null;
        Serializable serializableExtra = intent != null ? intent.getSerializableExtra("item_object") : null;
        Subject subject = serializableExtra instanceof Subject ? (Subject) serializableExtra : null;
        if (subject != null) {
            stringExtra = subject.getSubjectId();
        }
        Subject subject2 = this.f55362d;
        if (subject2 == null) {
            subjectId = this.f55363f;
        } else if (subject2 != null) {
            subjectId = subject2.getSubjectId();
        }
        boolean zB = Intrinsics.b(subjectId, stringExtra);
        setIntent(intent);
        com.alibaba.android.arouter.launcher.a.d().f(this);
        if (!zB) {
            Q();
        } else {
            if (intExtra < 0 || (shortTvListFragment = this.f55364g) == null) {
                return;
            }
            shortTvListFragment.f1(intExtra);
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        ShortTvListFragment shortTvListFragment;
        super.onPause();
        if (!isFinishing() || (shortTvListFragment = this.f55364g) == null) {
            return;
        }
        shortTvListFragment.d1();
    }

    @Override // com.transsion.videofloat.manager.c
    public void v() {
        ShortTvListFragment shortTvListFragment = this.f55364g;
        if (shortTvListFragment != null) {
            shortTvListFragment.d1();
        }
    }
}
