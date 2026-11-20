package com.transsion.postdetail.layer;

import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.layer.listener.LayerFlag;
import com.transsion.postdetail.layer.local.LocalUiType;
import com.transsion.subtitle.VideoSubtitleControl;
import com.transsion.videofloat.bean.FloatActionType;
import com.vungle.warren.error.VungleException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55085a = "LayerManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<BaseLayer> f55086b = new ArrayList();

    /* JADX INFO: renamed from: com.transsion.postdetail.layer.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class C0588a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f55087a;

        static {
            int[] iArr = new int[LayerFlag.values().length];
            try {
                iArr[LayerFlag.SET_PLAYER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayerFlag.SET_PARAMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LayerFlag.SET_MANAGER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LayerFlag.INIT_PLAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LayerFlag.RENDER_FIRST_FRAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LayerFlag.COMPLETION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[LayerFlag.VIDEO_SIZE_CHANGED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[LayerFlag.LOADING_BEGIN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[LayerFlag.LOADING_END.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[LayerFlag.VIDEO_START.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[LayerFlag.VIDEO_PAUSE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[LayerFlag.PROGRESS.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[LayerFlag.PLAY_ERROR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[LayerFlag.LOOPING_START.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[LayerFlag.PLAYER_RESET.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[LayerFlag.INIT_VIEW.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[LayerFlag.INIT_VIEW_TYPE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[LayerFlag.INIT_DATA.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[LayerFlag.ADD_SURFACE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[LayerFlag.SCREEN_ORIENTATION_CHANGED.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[LayerFlag.LOCAL_UI_CHANGED.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[LayerFlag.LAYER_EVENT.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[LayerFlag.UPDATE_DATA.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[LayerFlag.UPDATE_DOWNLOAD_DATA.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[LayerFlag.UPDATE_TITLE.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[LayerFlag.BACK_PRESSED.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[LayerFlag.FRAGMENT_RESUME.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[LayerFlag.FRAGMENT_PAUSE.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[LayerFlag.FRAGMENT_STOP.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[LayerFlag.RELEASE_PLAYER.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[LayerFlag.FRAGMENT_DESTROY.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[LayerFlag.BOTTOM_CONTROL.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[LayerFlag.SUBTITLE_CONTROL.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[LayerFlag.DOWNLOAD_PROGRESS.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[LayerFlag.DOWNLOAD_SPEED.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[LayerFlag.DOWNLOAD_CALLBACK.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[LayerFlag.SHOW_TOAST.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[LayerFlag.REMOVE_TOAST.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[LayerFlag.NETWORK_CHANGE.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[LayerFlag.PLAYER_TIMEOUT_TIPS.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[LayerFlag.REQUEST_FORYOU.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[LayerFlag.SERIES_INIT.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[LayerFlag.SERIES_EVENT.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[LayerFlag.SERIES_PLAY.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[LayerFlag.SERIES_LOCAL2NET.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[LayerFlag.UPDATE_SPEED.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr[LayerFlag.UPDATE_ROTATION.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr[LayerFlag.SHOW_FLOAT_2_WINDOW.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                iArr[LayerFlag.INTO_PIP.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            f55087a = iArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements wv.a<BaseLayer> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LayerFlag f55089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object[] f55090c;

        public b(LayerFlag layerFlag, Object[] objArr) {
            this.f55089b = layerFlag;
            this.f55090c = objArr;
        }

        @Override // wv.a
        public boolean a(Object data) {
            Intrinsics.g(data, "data");
            return data instanceof BaseLayer;
        }

        @Override // wv.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(BaseLayer listener) {
            Intrinsics.g(listener, "listener");
            a aVar = a.this;
            LayerFlag layerFlag = this.f55089b;
            Object[] objArr = this.f55090c;
            aVar.i(listener, layerFlag, Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements wv.a<e> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LayerFlag f55092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object[] f55093c;

        public c(LayerFlag layerFlag, Object[] objArr) {
            this.f55092b = layerFlag;
            this.f55093c = objArr;
        }

        @Override // wv.a
        public boolean a(Object data) {
            Intrinsics.g(data, "data");
            return data instanceof e;
        }

        @Override // wv.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(e listener) {
            Intrinsics.g(listener, "listener");
            a aVar = a.this;
            LayerFlag layerFlag = this.f55092b;
            Object[] objArr = this.f55093c;
            aVar.k(listener, layerFlag, Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements wv.a<wv.d> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LayerFlag f55095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object[] f55096c;

        public d(LayerFlag layerFlag, Object[] objArr) {
            this.f55095b = layerFlag;
            this.f55096c = objArr;
        }

        @Override // wv.a
        public boolean a(Object data) {
            Intrinsics.g(data, "data");
            return data instanceof wv.d;
        }

        @Override // wv.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(wv.d listener) {
            Intrinsics.g(listener, "listener");
            a aVar = a.this;
            LayerFlag layerFlag = this.f55095b;
            Object[] objArr = this.f55096c;
            aVar.j(listener, layerFlag, Arrays.copyOf(objArr, objArr.length));
        }
    }

    public final void d(BaseLayer layer) {
        Intrinsics.g(layer, "layer");
        if (!this.f55086b.contains(layer)) {
            this.f55086b.add(layer);
            return;
        }
        uo.b.a.f(uo.b.f78622a, this.f55085a, layer + " is already add", false, 4, null);
    }

    public final void e(LayerFlag flag, Object... params) {
        Intrinsics.g(flag, "flag");
        Intrinsics.g(params, "params");
        f(new b(flag, params));
    }

    public final <T> void f(wv.a<T> aVar) {
        if (!this.f55086b.isEmpty()) {
            List<BaseLayer> list = this.f55086b;
            ArrayList arrayList = new ArrayList();
            for (T t11 : list) {
                if (aVar.a((BaseLayer) t11)) {
                    arrayList.add(t11);
                }
            }
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    aVar.b((BaseLayer) it.next());
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public final void g(LayerFlag flag, Object... params) {
        Intrinsics.g(flag, "flag");
        Intrinsics.g(params, "params");
        f(new c(flag, params));
    }

    public final void h(LayerFlag flag, Object... params) {
        Intrinsics.g(flag, "flag");
        Intrinsics.g(params, "params");
        f(new d(flag, params));
    }

    public final void i(BaseLayer baseLayer, LayerFlag layerFlag, Object... objArr) {
        int i11 = C0588a.f55087a[layerFlag.ordinal()];
        if (i11 == 1) {
            if (objArr.length == 2) {
                Object obj = objArr[0];
                Intrinsics.e(obj, "null cannot be cast to non-null type com.transsion.player.orplayer.ORPlayer");
                Object obj2 = objArr[1];
                Intrinsics.e(obj2, "null cannot be cast to non-null type com.transsion.player.ui.ORPlayerView");
                baseLayer.L((f) obj, (ORPlayerView) obj2);
                return;
            }
            return;
        }
        if (i11 != 2) {
            if (i11 == 3 && objArr.length == 1) {
                Object obj3 = objArr[0];
                Intrinsics.e(obj3, "null cannot be cast to non-null type com.transsion.postdetail.layer.LayerManager");
                baseLayer.K((a) obj3);
                return;
            }
            return;
        }
        if (objArr.length == 2) {
            Object obj4 = objArr[0];
            Intrinsics.e(obj4, "null cannot be cast to non-null type kotlin.String");
            Object obj5 = objArr[1];
            Intrinsics.e(obj5, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.PostSubjectItem");
            baseLayer.M((String) obj4, (PostSubjectItem) obj5);
        }
    }

    public final void j(wv.d dVar, LayerFlag layerFlag, Object... objArr) {
        Object objP;
        Object objP2;
        switch (C0588a.f55087a[layerFlag.ordinal()]) {
            case 16:
                if (objArr.length == 2) {
                    Object obj = objArr[0];
                    Intrinsics.e(obj, "null cannot be cast to non-null type android.view.View");
                    Object obj2 = objArr[1];
                    Intrinsics.e(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    dVar.z((View) obj, ((Boolean) obj2).booleanValue());
                }
                break;
            case 17:
                if (objArr.length == 2) {
                    Object obj3 = objArr[0];
                    Intrinsics.e(obj3, "null cannot be cast to non-null type android.view.View");
                    Object obj4 = objArr[1];
                    Intrinsics.e(obj4, "null cannot be cast to non-null type com.transsion.postdetail.layer.local.LocalUiType");
                    dVar.r((View) obj3, (LocalUiType) obj4);
                }
                break;
            case 18:
                if (objArr.length == 5) {
                    Object obj5 = objArr[0];
                    Intrinsics.e(obj5, "null cannot be cast to non-null type kotlin.String");
                    Object obj6 = objArr[1];
                    Intrinsics.e(obj6, "null cannot be cast to non-null type kotlin.String");
                    Object obj7 = objArr[2];
                    Intrinsics.e(obj7, "null cannot be cast to non-null type kotlin.String");
                    Object obj8 = objArr[3];
                    Intrinsics.e(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                    boolean zBooleanValue = ((Boolean) obj8).booleanValue();
                    Object obj9 = objArr[4];
                    Intrinsics.e(obj9, "null cannot be cast to non-null type kotlin.Boolean");
                    dVar.p((String) obj5, (String) obj6, (String) obj7, zBooleanValue, ((Boolean) obj9).booleanValue());
                }
                break;
            case 19:
                if (objArr.length == 2) {
                    Object obj10 = objArr[0];
                    Intrinsics.e(obj10, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue = ((Integer) obj10).intValue();
                    Object obj11 = objArr[1];
                    Intrinsics.e(obj11, "null cannot be cast to non-null type kotlin.Int");
                    dVar.q(iIntValue, ((Integer) obj11).intValue());
                }
                break;
            case 20:
                if (objArr.length == 1) {
                    Object obj12 = objArr[0];
                    Intrinsics.e(obj12, "null cannot be cast to non-null type com.transsion.postdetail.layer.local.LocalUiType");
                    dVar.m((LocalUiType) obj12);
                }
                break;
            case 21:
                if (objArr.length == 1) {
                    Object obj13 = objArr[0];
                    Intrinsics.e(obj13, "null cannot be cast to non-null type com.transsion.postdetail.layer.local.LocalUiType");
                    dVar.a((LocalUiType) obj13);
                }
                break;
            case 22:
                if (objArr.length == 1) {
                    Object obj14 = objArr[0];
                    Intrinsics.e(obj14, "null cannot be cast to non-null type com.transsion.postdetail.layer.listener.LayerEvent");
                    dVar.e((wv.b) obj14);
                }
                break;
            case 23:
                if (objArr.length == 1) {
                    Object obj15 = objArr[0];
                    Intrinsics.e(obj15, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.PostSubjectItem");
                    dVar.w((PostSubjectItem) obj15);
                }
                break;
            case 24:
                if (objArr.length == 3) {
                    Object obj16 = objArr[0];
                    Intrinsics.e(obj16, "null cannot be cast to non-null type com.transsion.baselib.db.download.DownloadBean");
                    Object obj17 = objArr[1];
                    Intrinsics.e(obj17, "null cannot be cast to non-null type kotlin.String");
                    Object obj18 = objArr[2];
                    Intrinsics.e(obj18, "null cannot be cast to non-null type kotlin.Boolean");
                    dVar.k((DownloadBean) obj16, (String) obj17, ((Boolean) obj18).booleanValue());
                }
                break;
            case 25:
                if (objArr.length == 1) {
                    Object obj19 = objArr[0];
                    Intrinsics.e(obj19, "null cannot be cast to non-null type kotlin.String");
                    dVar.updateTitle((String) obj19);
                }
                break;
            case 26:
                if (dVar.isVisible()) {
                    dVar.onBackPressed();
                }
                break;
            case 27:
                if (dVar.isVisible()) {
                    dVar.onViewResume();
                }
                break;
            case 28:
                if (dVar.isVisible()) {
                    dVar.onViewPause();
                }
                break;
            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                if (dVar.isVisible()) {
                    dVar.n();
                }
                break;
            case 30:
                if (dVar.isVisible()) {
                    dVar.A();
                }
                break;
            case VungleException.WEB_CRASH /* 31 */:
                dVar.c();
                break;
            case 32:
                if (objArr.length == 2) {
                    Object obj20 = objArr[0];
                    Intrinsics.e(obj20, "null cannot be cast to non-null type kotlin.Boolean");
                    boolean zBooleanValue2 = ((Boolean) obj20).booleanValue();
                    Object obj21 = objArr[1];
                    Intrinsics.e(obj21, "null cannot be cast to non-null type kotlin.Boolean");
                    dVar.b(zBooleanValue2, ((Boolean) obj21).booleanValue());
                }
                break;
            case 33:
                if (objArr.length == 1) {
                    Object obj22 = objArr[0];
                    Intrinsics.e(obj22, "null cannot be cast to non-null type com.transsion.subtitle.VideoSubtitleControl");
                    dVar.B((VideoSubtitleControl) obj22);
                }
                break;
            case 34:
                if (objArr.length == 1) {
                    Object obj23 = objArr[0];
                    Intrinsics.e(obj23, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.Int, kotlin.Int>");
                    dVar.l(TypeIntrinsics.d(obj23));
                }
                break;
            case 35:
                if (objArr.length == 1) {
                    Object obj24 = objArr[0];
                    Intrinsics.e(obj24, "null cannot be cast to non-null type kotlin.String");
                    dVar.y((String) obj24);
                }
                break;
            case 36:
                if (objArr.length == 1) {
                    Object obj25 = objArr[0];
                    Intrinsics.e(obj25, "null cannot be cast to non-null type com.transsion.baselib.db.download.DownloadBean");
                    dVar.D((DownloadBean) obj25);
                }
                break;
            case 37:
                if (objArr.length == 1) {
                    Object obj26 = objArr[0];
                    Intrinsics.e(obj26, "null cannot be cast to non-null type kotlin.String");
                    wv.d.a.k(dVar, (String) obj26, 0L, 2, null);
                } else if (objArr.length == 2) {
                    Object obj27 = objArr[0];
                    Intrinsics.e(obj27, "null cannot be cast to non-null type kotlin.String");
                    Object obj28 = objArr[1];
                    Intrinsics.e(obj28, "null cannot be cast to non-null type kotlin.Long");
                    dVar.j((String) obj27, ((Long) obj28).longValue());
                }
                break;
            case 38:
                dVar.s();
                break;
            case 39:
                if (objArr.length == 1) {
                    Object obj29 = objArr[0];
                    Intrinsics.e(obj29, "null cannot be cast to non-null type kotlin.Boolean");
                    dVar.v(((Boolean) obj29).booleanValue());
                }
                break;
            case 40:
                dVar.h();
                break;
            case 41:
                if (objArr.length == 2) {
                    Object obj30 = objArr[0];
                    Intrinsics.e(obj30, "null cannot be cast to non-null type kotlin.Boolean");
                    boolean zBooleanValue3 = ((Boolean) obj30).booleanValue();
                    Object obj31 = objArr[1];
                    Intrinsics.e(obj31, "null cannot be cast to non-null type kotlin.String");
                    dVar.g(zBooleanValue3, (String) obj31);
                }
                break;
            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                if (objArr.length == 2) {
                    Object obj32 = objArr[0];
                    Intrinsics.e(obj32, "null cannot be cast to non-null type kotlin.String");
                    Object obj33 = objArr[1];
                    Intrinsics.e(obj33, "null cannot be cast to non-null type kotlin.String");
                    dVar.i((String) obj32, (String) obj33);
                }
                break;
            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                if (objArr.length == 1) {
                    Object obj34 = objArr[0];
                    Intrinsics.e(obj34, "null cannot be cast to non-null type com.transsion.postdetail.layer.listener.SeriesEvent");
                    dVar.x((wv.c) obj34);
                }
                break;
            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                if (dVar.isVisible() && objArr.length == 2) {
                    Object obj35 = objArr[0];
                    Intrinsics.e(obj35, "null cannot be cast to non-null type kotlin.String");
                    Object obj36 = objArr[1];
                    Intrinsics.e(obj36, "null cannot be cast to non-null type kotlin.String");
                    dVar.u((String) obj35, (String) obj36);
                    break;
                }
                break;
            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                dVar.d();
                break;
            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                Object objP3 = kotlin.collections.d.P(objArr);
                if (objP3 != null && (objP3 instanceof Float)) {
                    dVar.o(((Number) objP3).floatValue());
                    break;
                }
                break;
            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                Object objP4 = kotlin.collections.d.P(objArr);
                if (objP4 != null && (objP4 instanceof Integer)) {
                    dVar.C(((Number) objP4).intValue());
                    break;
                }
                break;
            case 48:
                if (dVar.isVisible() && (objP = kotlin.collections.d.P(objArr)) != null && (objP instanceof FloatActionType)) {
                    dVar.f((FloatActionType) objP);
                    break;
                }
                break;
            case 49:
                if (dVar.isVisible() && (objP2 = kotlin.collections.d.P(objArr)) != null && (objP2 instanceof Boolean)) {
                    dVar.t(((Boolean) objP2).booleanValue());
                    break;
                }
                break;
        }
    }

    public final void k(e eVar, LayerFlag layerFlag, Object... objArr) {
        switch (C0588a.f55087a[layerFlag.ordinal()]) {
            case 4:
                eVar.initPlayer();
                break;
            case 5:
                eVar.onRenderFirstFrame();
                break;
            case 6:
                e.a.e(eVar, null, 1, null);
                break;
            case 7:
                if (objArr.length == 2) {
                    Object obj = objArr[0];
                    Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue = ((Integer) obj).intValue();
                    Object obj2 = objArr[1];
                    Intrinsics.e(obj2, "null cannot be cast to non-null type kotlin.Int");
                    eVar.onVideoSizeChanged(iIntValue, ((Integer) obj2).intValue());
                }
                break;
            case 8:
                e.a.i(eVar, null, 1, null);
                break;
            case 9:
                e.a.k(eVar, null, 1, null);
                break;
            case 10:
                e.a.I(eVar, null, 1, null);
                break;
            case 11:
                e.a.F(eVar, null, 1, null);
                break;
            case 12:
                if (objArr.length == 1) {
                    Object obj3 = objArr[0];
                    Intrinsics.e(obj3, "null cannot be cast to non-null type kotlin.Long");
                    e.a.y(eVar, ((Long) obj3).longValue(), null, 2, null);
                }
                break;
            case 13:
                if (objArr.length == 1) {
                    Object obj4 = objArr[0];
                    Intrinsics.e(obj4, "null cannot be cast to non-null type com.transsion.player.orplayer.PlayError");
                    e.a.q(eVar, (PlayError) obj4, null, 2, null);
                }
                break;
            case 14:
                eVar.onLoopingStart();
                break;
            case 15:
                eVar.onPlayerReset();
                break;
        }
    }
}
