package com.transsion.ninegridview;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.recyclerview.widget.RecyclerView;
import av.d;
import com.aliyun.player.bean.ErrorCode;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.util.networkinfo.g;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.player.config.RenderType;
import com.transsion.player.orplayer.f;
import com.transsion.player.p006enum.ScaleMode;
import com.transsion.player.ui.ORPlayerView;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a implements d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0578a f53943h = new C0578a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final iv.d f53944i = new iv.d(RenderType.TEXTURE_VIEW, false, 0, 1000, 1000, 200, 10, 0, 0, 0, 0, false, false, false, false, false, null, 130950, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f53945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public bv.a f53946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public av.c f53947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f53948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f53949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public av.a f53950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Context f53951g;

    /* JADX INFO: renamed from: com.transsion.ninegridview.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0578a {
        public C0578a() {
        }

        public /* synthetic */ C0578a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final iv.d a() {
            return a.f53944i;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements g {
        public b() {
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected() {
            g.a.a(this);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            av.a aVar = a.this.f53950f;
            if (aVar != null) {
                int iA = aVar.a();
                a aVar2 = a.this;
                if (aVar2.f53949e && iA == ErrorCode.ERROR_LOADING_TIMEOUT.getValue()) {
                    bv.a aVarG = aVar2.g();
                    if (aVarG != null) {
                        aVarG.w();
                    }
                    aVar2.f53949e = false;
                }
            }
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
            a.this.f53949e = true;
        }
    }

    @Override // av.d
    public void a() {
        Context context = this.f53951g;
        if (context != null) {
            j(context);
        }
    }

    public final void f() {
        f fVar = this.f53945a;
        if (fVar != null) {
            fVar.release();
        }
        this.f53945a = null;
        bv.a aVar = this.f53946b;
        if (aVar != null) {
            aVar.a();
        }
        this.f53946b = null;
        av.c cVar = this.f53947c;
        if (cVar != null) {
            cVar.e();
        }
        this.f53947c = null;
        com.tn.lib.util.networkinfo.f.f49475a.m(this.f53948d);
        this.f53948d = null;
    }

    public final bv.a g() {
        return this.f53946b;
    }

    public final void h() {
        if (this.f53947c == null) {
            this.f53947c = new av.c();
        }
        av.c cVar = this.f53947c;
        if (cVar != null) {
            cVar.e();
        }
    }

    public final void i() {
        if (this.f53948d == null) {
            b bVar = new b();
            this.f53948d = bVar;
            com.tn.lib.util.networkinfo.f.f49475a.l(bVar);
        }
    }

    public final void j(Context context) {
        Intrinsics.g(context, "context");
        if (this.f53945a == null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.f(applicationContext, "context.applicationContext");
            ORPlayerView oRPlayerView = new ORPlayerView(applicationContext, RenderType.TEXTURE_VIEW);
            Context applicationContext2 = context.getApplicationContext();
            Intrinsics.f(applicationContext2, "context.applicationContext");
            f fVarA = new f.a(applicationContext2).a();
            fVarA.setPlayerConfig(f53944i);
            fVarA.setTextureView(oRPlayerView.getTextureView());
            fVarA.setScaleMode(ScaleMode.SCALE_ASPECT_FILL);
            fVarA.setMute(true);
            this.f53946b = new bv.a(fVarA, oRPlayerView);
            av.a aVar = new av.a();
            aVar.b(this.f53946b);
            fVarA.setPlayerListener(aVar);
            this.f53950f = aVar;
            this.f53945a = fVarA;
            av.c cVar = this.f53947c;
            if (cVar != null) {
                cVar.k(this.f53946b);
            }
            i();
            uo.b.a.f(uo.b.f78622a, "GifPlayerManager", "initPlayer", false, 4, null);
        }
    }

    public final void k() {
        f fVar = this.f53945a;
        if (fVar != null) {
            fVar.pause();
        }
    }

    public final void l() {
        f fVar = this.f53945a;
        if (fVar != null) {
            fVar.play();
        }
    }

    public final void m() {
        bv.a aVar = this.f53946b;
        if (aVar == null) {
            return;
        }
        aVar.x(-1);
    }

    public final void n(RecyclerView recyclerView, BaseQuickAdapter<PostSubjectItem, BaseViewHolder> baseQuickAdapter) {
        Intrinsics.g(recyclerView, "recyclerView");
        this.f53951g = recyclerView.getContext();
        h();
        av.c cVar = this.f53947c;
        if (cVar != null) {
            cVar.j(baseQuickAdapter);
            recyclerView.addOnScrollListener(cVar);
        }
        av.c cVar2 = this.f53947c;
        if (cVar2 == null) {
            return;
        }
        cVar2.l(this);
    }
}
