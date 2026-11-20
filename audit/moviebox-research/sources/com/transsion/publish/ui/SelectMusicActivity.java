package com.transsion.publish.ui;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.PermissionUtils;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.publish.R$id;
import com.transsion.publish.api.AudioEntity;
import com.transsion.publish.view.CustomHeader;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.mvel2.ast.ASTNode;

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
public final class SelectMusicActivity extends BaseActivity<ew.f> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f56545l = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f56546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.transsion.publish.adapter.b0 f56547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gw.a f56548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f56549d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f56550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ProgressBar f56551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public iw.c f56552h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f56553i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h10.b f56554j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f56555k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.g(context, "context");
            Intent intent = new Intent(context, (Class<?>) SelectMusicActivity.class);
            intent.setFlags(ASTNode.DEOP);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b implements com.transsion.publish.adapter.x {
        public b() {
        }

        public static final void c(SelectMusicActivity this$0, AudioEntity info, MediaPlayer mediaPlayer) {
            int i11;
            List<AudioEntity> listF;
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(info, "$info");
            com.transsion.publish.adapter.b0 b0Var = this$0.f56547b;
            if (b0Var == null || (listF = b0Var.f()) == null) {
                i11 = -1;
            } else {
                i11 = -1;
                int i12 = 0;
                for (Object obj : listF) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        kotlin.collections.g.u();
                    }
                    if (Intrinsics.b(info, (AudioEntity) obj)) {
                        i11 = i12;
                    }
                    i12 = i13;
                }
            }
            if (i11 != -1) {
                info.setPlay(false);
                com.transsion.publish.adapter.b0 b0Var2 = this$0.f56547b;
                if (b0Var2 != null) {
                    b0Var2.notifyItemChanged(i11);
                }
            }
        }

        @Override // com.transsion.publish.adapter.x
        public void a(final AudioEntity info) {
            Context context;
            iw.c cVar;
            Intrinsics.g(info, "info");
            try {
                if (SelectMusicActivity.this.f56552h == null) {
                    SelectMusicActivity.this.f56552h = new iw.c();
                }
                if (Intrinsics.b(SelectMusicActivity.this.f56555k, info.getLocalPath()) && (cVar = SelectMusicActivity.this.f56552h) != null && cVar.b()) {
                    iw.c cVar2 = SelectMusicActivity.this.f56552h;
                    if (cVar2 != null) {
                        cVar2.c();
                        return;
                    }
                    return;
                }
                String localPath = info.getLocalPath();
                if (localPath != null) {
                    final SelectMusicActivity selectMusicActivity = SelectMusicActivity.this;
                    RecyclerView recyclerView = selectMusicActivity.f56546a;
                    if (recyclerView != null && (context = recyclerView.getContext()) != null) {
                        Intrinsics.f(context, "context");
                        iw.c cVar3 = selectMusicActivity.f56552h;
                        if (cVar3 != null) {
                            cVar3.d(context, localPath, false, new MediaPlayer.OnCompletionListener() { // from class: com.transsion.publish.ui.m0
                                @Override // android.media.MediaPlayer.OnCompletionListener
                                public final void onCompletion(MediaPlayer mediaPlayer) {
                                    SelectMusicActivity.b.c(selectMusicActivity, info, mediaPlayer);
                                }
                            });
                        }
                    }
                }
                SelectMusicActivity.this.f56555k = info.getLocalPath();
            } catch (Exception e11) {
                String message = e11.getMessage();
                if (message != null) {
                    uo.b.a.f(uo.b.f78622a, "audioTAG", message, false, 4, null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements io.reactivex.rxjava3.core.o<List<AudioEntity>> {
        public c() {
        }

        @Override // io.reactivex.rxjava3.core.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<AudioEntity> t11) {
            Intrinsics.g(t11, "t");
            if (t11.isEmpty() || (t11.size() == 1 && TextUtils.isEmpty(t11.get(0).getLocalPath()))) {
                LinearLayout linearLayout = SelectMusicActivity.this.f56549d;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
            } else {
                com.transsion.publish.adapter.b0 b0Var = SelectMusicActivity.this.f56547b;
                if (b0Var != null) {
                    b0Var.e(t11);
                }
            }
            SelectMusicActivity.this.f0();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            h10.b bVar = SelectMusicActivity.this.f56554j;
            if (bVar != null) {
                bVar.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable e11) {
            Intrinsics.g(e11, "e");
            uo.b.a.f(uo.b.f78622a, "SelectVideoManager", "onError e:" + e11, false, 4, null);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b d11) {
            Intrinsics.g(d11, "d");
            SelectMusicActivity.this.f56554j = d11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements PermissionUtils.b {
        public d() {
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void a() {
            LinearLayout linearLayout = SelectMusicActivity.this.f56550f;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onGranted() {
            LinearLayout linearLayout = SelectMusicActivity.this.f56550f;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            SelectMusicActivity.this.j0();
        }
    }

    public SelectMusicActivity() {
        this.f56553i = Build.VERSION.SDK_INT < 33 ? "android.permission.WRITE_EXTERNAL_STORAGE" : "android.permission.READ_MEDIA_AUDIO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        ProgressBar progressBar = this.f56551g;
        if (progressBar == null) {
            return;
        }
        progressBar.setVisibility(8);
    }

    public static final void g0(SelectMusicActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.finish();
    }

    public static final void h0(SelectMusicActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.l0();
    }

    public static final void i0(View view) {
        PermissionUtils.v();
    }

    private final void initView() {
        CustomHeader customHeader = (CustomHeader) findViewById(R$id.sv_title_bar);
        customHeader.setOnBackClick(new View.OnClickListener() { // from class: com.transsion.publish.ui.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectMusicActivity.g0(this.f56594a, view);
            }
        });
        customHeader.setOnEditClick(new View.OnClickListener() { // from class: com.transsion.publish.ui.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectMusicActivity.h0(this.f56596a, view);
            }
        });
        this.f56551g = (ProgressBar) findViewById(R$id.select_video_loading);
        this.f56549d = (LinearLayout) findViewById(R$id.sv_no_content_view);
        this.f56550f = (LinearLayout) findViewById(R$id.sv_lock_view);
        TextView textView = (TextView) findViewById(R$id.sv_tv_grant);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.l0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectMusicActivity.i0(view);
                }
            });
        }
        this.f56546a = (RecyclerView) findViewById(R$id.select_video_recycler);
        this.f56547b = new com.transsion.publish.adapter.b0();
        RecyclerView recyclerView = this.f56546a;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        RecyclerView recyclerView2 = this.f56546a;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.f56547b);
        }
        int iB = (com.blankj.utilcode.util.d0.b() - (com.blankj.utilcode.util.f0.a(3.0f) * 5)) / 6;
        RecyclerView recyclerView3 = this.f56546a;
        if (recyclerView3 != null) {
            recyclerView3.setPadding(0, 0, 0, iB);
        }
        com.transsion.publish.adapter.b0 b0Var = this.f56547b;
        if (b0Var != null) {
            b0Var.n(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0() {
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        showLoading();
        this.f56548c = new gw.a(this);
        io.reactivex.rxjava3.core.j.f(new io.reactivex.rxjava3.core.l() { // from class: com.transsion.publish.ui.i0
            @Override // io.reactivex.rxjava3.core.l
            public final void a(io.reactivex.rxjava3.core.k kVar) throws Throwable {
                SelectMusicActivity.k0(this.f56592a, kVar);
            }
        }).a(12).r(io.reactivex.rxjava3.android.schedulers.b.c()).A(q10.a.b()).subscribe(new c());
    }

    public static final void k0(SelectMusicActivity this$0, io.reactivex.rxjava3.core.k emitter) throws Throwable {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(emitter, "emitter");
        uo.b.a.f(uo.b.f78622a, "SelectMusicManager", "loadLocalMusic success", false, 4, null);
        gw.a aVar = this$0.f56548c;
        if (aVar != null) {
            aVar.a(emitter);
        }
        if (emitter.isDisposed()) {
            return;
        }
        emitter.onComplete();
    }

    private final void l0() {
        com.transsion.publish.adapter.b0 b0Var = this.f56547b;
        AudioEntity audioEntityG = b0Var != null ? b0Var.g() : null;
        if (audioEntityG == null) {
            finish();
            return;
        }
        cw.a aVar = new cw.a();
        aVar.o(2);
        aVar.n(1);
        aVar.k(audioEntityG);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = cw.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, aVar, 0L);
        finish();
    }

    private final void m0() {
        if (PermissionUtils.s(this.f56553i)) {
            j0();
        } else {
            PermissionUtils.x(this.f56553i).m(new d()).y();
        }
    }

    private final void showLoading() {
        ProgressBar progressBar = this.f56551g;
        if (progressBar == null) {
            return;
        }
        progressBar.setVisibility(0);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public ew.f getViewBinding() {
        ew.f fVarC = ew.f.c(getLayoutInflater());
        Intrinsics.f(fVarC, "inflate(layoutInflater)");
        return fVarC;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("select_music", false, 2, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        m0();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        h10.b bVar = this.f56554j;
        if (bVar != null) {
            bVar.dispose();
        }
        iw.c cVar = this.f56552h;
        if (cVar != null) {
            cVar.f();
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        iw.c cVar = this.f56552h;
        if (cVar != null) {
            cVar.c();
        }
        com.transsion.publish.adapter.b0 b0Var = this.f56547b;
        if (b0Var != null) {
            b0Var.m();
        }
    }
}
