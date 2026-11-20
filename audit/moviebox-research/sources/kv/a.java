package kv;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.player.longvideo.constants.LongVodPageType;
import com.transsion.player.longvideo.ui.LongVodUiType;
import com.transsion.player.orplayer.f;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.videofloat.bean.FloatActionType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.g;
import lv.c;

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
public interface a {

    /* JADX INFO: renamed from: kv.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0746a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(a aVar, String str, LongVodPageType longVodPageType, String str2, FrameLayout frameLayout, ViewGroup viewGroup, List list, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
            }
            if ((i11 & 32) != 0) {
                list = g.l();
            }
            aVar.init(str, longVodPageType, str2, frameLayout, viewGroup, list);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface b {
        void a();

        boolean b();

        boolean c(FloatActionType floatActionType);

        void d(lv.a aVar);

        void e(LongVodUiType longVodUiType);

        View f();

        void g(boolean z11);

        void onCompletion();
    }

    long currentPosition();

    void exitFullScreen();

    f getPlayer();

    ORPlayerView getPlayerView();

    c getPlayingStream();

    SimpleSubtitleView getSubtitleView();

    ViewGroup getSubtitleViewGroup();

    void hasNextEpisode(boolean z11);

    void hideBottomController(boolean z11);

    void init(String str, LongVodPageType longVodPageType, String str2, FrameLayout frameLayout, ViewGroup viewGroup, List<DubsInfo> list);

    boolean onBackPressed();

    void onHandlePause();

    void onHandlePlay();

    void onPageDestroy();

    void onPipModeChanged(boolean z11);

    void onSaveHistory();

    void onViewPause();

    void onViewResume();

    void release();

    void removeNoNetError();

    void replay();

    void reset();

    void setCallback(b bVar);

    void setDataSource(lv.a aVar);

    void setFloatIsShow(boolean z11);

    void showNoNetError();

    void showReplay();
}
