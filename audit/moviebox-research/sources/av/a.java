package av;

import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
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
public final class a implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0135a f13834c = new C0135a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public bv.a f13835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13836b;

    /* JADX INFO: renamed from: av.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0135a {
        public C0135a() {
        }

        public /* synthetic */ C0135a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final int a() {
        return this.f13836b;
    }

    public final void b(bv.a aVar) {
        this.f13835a = aVar;
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
        uo.b.a.f(uo.b.f78622a, "GifPlayerListener", "onCompletion", false, 4, null);
        bv.a aVar = this.f13835a;
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
        uo.b.a.f(uo.b.f78622a, "GifPlayerListener", "percent=" + i11, false, 4, null);
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
        uo.b.a.f(uo.b.f78622a, "GifPlayerListener", "errorInfo code=" + errorInfo.getErrorCode() + " message=" + errorInfo.getErrorMessage(), false, 4, null);
        Integer errorCode = errorInfo.getErrorCode();
        this.f13836b = errorCode != null ? errorCode.intValue() : 0;
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
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        uo.b.a.f(uo.b.f78622a, "GifPlayerListener", "onRenderFirstFrame", false, 4, null);
        bv.a aVar = this.f13835a;
        if (aVar != null) {
            aVar.p();
        }
        this.f13836b = 0;
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
    public void onTracksChange(ov.c cVar) {
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
        uo.b.a.f(uo.b.f78622a, "GifPlayerListener", "onVideoStart", false, 4, null);
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        e.a.J(this);
    }
}
