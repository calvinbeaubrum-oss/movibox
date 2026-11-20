package com.transsion.postdetail.test;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.player.MediaSource;
import com.transsion.player.config.RenderType;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.player.p006enum.ScaleMode;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ov.c;
import ro.g;

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
public final class TestActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f55512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public zv.a f55513d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f55515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public bv.a f55516h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55510a = TestActivity.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f55511b = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f55514f = "https://test-acdn.aoneroom.com/media/video/2022/08/11/5970c1ffed2920c3b2d80da029fe3944-sd.mp4";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements e {
        public a() {
        }

        @Override // com.transsion.player.orplayer.e
        public void initPlayer() {
            e.a.a(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
            e.a.b(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onBufferedPosition(long j11, MediaSource mediaSource) {
            e.a.c(this, j11, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onCompletion(MediaSource mediaSource) {
            e.a.d(this, mediaSource);
            bv.a aVar = TestActivity.this.f55516h;
            if (aVar != null) {
                aVar.q();
            }
        }

        @Override // com.transsion.player.orplayer.e
        public void onFocusChange(boolean z11) {
            e.a.f(this, z11);
        }

        @Override // com.transsion.player.orplayer.e
        public void onIsPlayingChanged(boolean z11) {
            e.a.g(this, z11);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoadingBegin(MediaSource mediaSource) {
            e.a.h(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoadingEnd(MediaSource mediaSource) {
            e.a.j(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoadingProgress(int i11, float f11, MediaSource mediaSource) {
            e.a.l(this, i11, f11, mediaSource);
            uo.b.a aVar = uo.b.f78622a;
            String TAG = TestActivity.this.f55510a;
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, "percent=" + i11, false, 4, null);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoopingStart() {
            e.a.n(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onMediaItemTransition(String str) {
            e.a.o(this, str);
        }

        @Override // com.transsion.player.orplayer.e
        public void onPlayError(PlayError errorInfo, MediaSource mediaSource) {
            Intrinsics.g(errorInfo, "errorInfo");
            e.a.p(this, errorInfo, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onPlayerRelease(MediaSource mediaSource) {
            e.a.s(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onPlayerReset() {
            e.a.u(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onPrepare(MediaSource mediaSource) {
            e.a.v(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onProgress(long j11, MediaSource mediaSource) {
            e.a.x(this, j11, mediaSource);
            uo.b.a aVar = uo.b.f78622a;
            String TAG = TestActivity.this.f55510a;
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, "process=" + j11, false, 4, null);
        }

        @Override // com.transsion.player.orplayer.e
        public void onRenderFirstFrame() {
            uo.b.a aVar = uo.b.f78622a;
            String TAG = TestActivity.this.f55510a;
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, "onRenderFirstFrame", false, 4, null);
            bv.a aVar2 = TestActivity.this.f55516h;
            if (aVar2 != null) {
                aVar2.p();
            }
        }

        @Override // com.transsion.player.orplayer.e
        public void onSetDataSource() {
            e.a.A(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onTracksAudioBitrateChange(int i11) {
            e.a.B(this, i11);
        }

        @Override // com.transsion.player.orplayer.e
        public void onTracksChange(c cVar) {
            e.a.C(this, cVar);
        }

        @Override // com.transsion.player.orplayer.e
        public void onTracksVideoBitrateChange(int i11) {
            e.a.D(this, i11);
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoPause(MediaSource mediaSource) {
            e.a.E(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoSizeChanged(int i11, int i12) {
            e.a.G(this, i11, i12);
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoStart(MediaSource mediaSource) {
            e.a.H(this, mediaSource);
            uo.b.a aVar = uo.b.f78622a;
            String TAG = TestActivity.this.f55510a;
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, "onVideoStart", false, 4, null);
        }

        @Override // com.transsion.player.orplayer.e
        public void setOnSeekCompleteListener() {
            e.a.J(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends RecyclerView.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f55518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f55519b;

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            Intrinsics.g(recyclerView, "recyclerView");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            zv.a aVar;
            List<PostSubjectItem> listD;
            List<PostSubjectItem> listD2;
            Intrinsics.g(recyclerView, "recyclerView");
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                throw new RuntimeException("Unsupported layoutManager.");
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            this.f55518a = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            this.f55519b = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            bv.a aVar2 = TestActivity.this.f55516h;
            int iB = aVar2 != null ? aVar2.b() : 0;
            boolean z11 = iB < iFindFirstVisibleItemPosition || iB > iFindLastVisibleItemPosition;
            if (linearLayoutManager.getChildCount() <= 0 || (aVar = TestActivity.this.f55513d) == null || (listD = aVar.D()) == null || !(!listD.isEmpty()) || !z11) {
                return;
            }
            View childAt = linearLayoutManager.getChildAt(i12 < 0 ? linearLayoutManager.getChildCount() - 1 : 0);
            if (childAt != null) {
                int position = linearLayoutManager.getPosition(childAt);
                zv.a aVar3 = TestActivity.this.f55513d;
                PostSubjectItem postSubjectItem = (aVar3 == null || (listD2 = aVar3.D()) == null) ? null : listD2.get(position);
                bv.a aVar4 = TestActivity.this.f55516h;
                if (aVar4 != null) {
                    aVar4.s(postSubjectItem, childAt, position);
                }
            }
        }
    }

    private final void Q() {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < 21; i11++) {
            ArrayList arrayList2 = new ArrayList();
            Image image = new Image(200, 2000, "https://cdn.shalltry.com/tcmservice/tcmservice/111630622592760357.jpg", 200, null, null, new GifBean("https://test-acdn.aoneroom.com/image/2022/08/16/61e43091d911c7e773efd9189332fadb.webp", "https://test-acdn.aoneroom.com/media/video/2022/08/11/5970c1ffed2920c3b2d80da029fe3944-sd.mp4"), null, null, 0.0f, 0.0f, 0, 0, 0, 16256, null);
            int i12 = i11 % 9;
            if (i12 >= 0) {
                while (true) {
                    arrayList2.add(image);
                    int i13 = i13 != i12 ? i13 + 1 : 0;
                }
            }
            arrayList.add(new PostSubjectItem(null, null, null, null, null, null, new Media(null, null, null, arrayList2, MediaType.IMAGE.getValue(), null, null), null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, null, false, null, false, 1072168960, null));
        }
        this.f55513d = new zv.a(arrayList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.recycler_view);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.addItemDecoration(new g(200, 0, 2, null));
            recyclerView.setAdapter(this.f55513d);
        } else {
            recyclerView = null;
        }
        this.f55512c = recyclerView;
    }

    private final void initPlayer() {
        ORPlayerView oRPlayerView = new ORPlayerView(this, RenderType.TEXTURE_VIEW);
        f fVarA = new f.a(this).a();
        fVarA.setTextureView(oRPlayerView.getTextureView());
        fVarA.setScaleMode(ScaleMode.SCALE_ASPECT_FILL);
        this.f55516h = new bv.a(fVarA, oRPlayerView);
        fVarA.setPlayerListener(new a());
        this.f55515g = fVarA;
    }

    public final void R() {
        RecyclerView recyclerView = this.f55512c;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new b());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_test);
        Q();
        initPlayer();
        R();
    }
}
