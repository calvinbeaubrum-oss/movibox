package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.baselib.helper.LocalVideoPlayerConfigMmkv;
import com.transsion.player.p006enum.ScaleMode;
import com.transsion.postdetail.R$mipmap;
import com.transsion.postdetail.R$string;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class ImmScaleView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f55959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f55960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f55961c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void a(ScaleMode scaleMode, String str);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f55963a;

        static {
            int[] iArr = new int[ScaleMode.values().length];
            try {
                iArr[ScaleMode.SCALE_ASPECT_FIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScaleMode.SCALE_ASPECT_FILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f55963a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmScaleView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        a(LocalVideoPlayerConfigMmkv.f51172a.b());
        so.c.c(this, 0L, new Function1<View, Unit>() { // from class: com.transsion.postdetail.ui.view.ImmScaleView.1

            /* JADX INFO: renamed from: com.transsion.postdetail.ui.view.ImmScaleView$1$a */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            public /* synthetic */ class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f55962a;

                static {
                    int[] iArr = new int[ScaleMode.values().length];
                    try {
                        iArr[ScaleMode.SCALE_TO_FILL.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ScaleMode.SCALE_ASPECT_FIT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f55962a = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                ScaleMode scaleMode;
                String string;
                Intrinsics.g(it, "it");
                int i11 = a.f55962a[LocalVideoPlayerConfigMmkv.f51172a.b().ordinal()];
                if (i11 == 1) {
                    scaleMode = ScaleMode.SCALE_ASPECT_FILL;
                    string = ImmScaleView.this.getContext().getString(R$string.video_crop);
                    Intrinsics.f(string, "context.getString(R.string.video_crop)");
                } else if (i11 != 2) {
                    scaleMode = ScaleMode.SCALE_ASPECT_FIT;
                    string = ImmScaleView.this.getContext().getString(R$string.video_fit_screen);
                    Intrinsics.f(string, "context.getString(R.string.video_fit_screen)");
                } else {
                    scaleMode = ScaleMode.SCALE_TO_FILL;
                    string = ImmScaleView.this.getContext().getString(R$string.video_stretch);
                    Intrinsics.f(string, "context.getString(R.string.video_stretch)");
                }
                ImmScaleView.this.a(scaleMode);
                a onModelChangeListener = ImmScaleView.this.getOnModelChangeListener();
                if (onModelChangeListener != null) {
                    onModelChangeListener.a(scaleMode, string);
                }
                String str = ImmScaleView.this.f55959a;
                if (str != null) {
                    com.transsion.baselib.report.m.f51277a.m(str, "click", kotlin.collections.s.l(new Pair("module_name", "scale_mode"), new Pair("subject_id", ImmScaleView.this.f55960b), new Pair("type", String.valueOf(scaleMode.getValue()))));
                }
            }
        }, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmScaleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        a(LocalVideoPlayerConfigMmkv.f51172a.b());
        so.c.c(this, 0L, new Function1<View, Unit>() { // from class: com.transsion.postdetail.ui.view.ImmScaleView.1

            /* JADX INFO: renamed from: com.transsion.postdetail.ui.view.ImmScaleView$1$a */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            public /* synthetic */ class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f55962a;

                static {
                    int[] iArr = new int[ScaleMode.values().length];
                    try {
                        iArr[ScaleMode.SCALE_TO_FILL.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ScaleMode.SCALE_ASPECT_FIT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f55962a = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                ScaleMode scaleMode;
                String string;
                Intrinsics.g(it, "it");
                int i11 = a.f55962a[LocalVideoPlayerConfigMmkv.f51172a.b().ordinal()];
                if (i11 == 1) {
                    scaleMode = ScaleMode.SCALE_ASPECT_FILL;
                    string = ImmScaleView.this.getContext().getString(R$string.video_crop);
                    Intrinsics.f(string, "context.getString(R.string.video_crop)");
                } else if (i11 != 2) {
                    scaleMode = ScaleMode.SCALE_ASPECT_FIT;
                    string = ImmScaleView.this.getContext().getString(R$string.video_fit_screen);
                    Intrinsics.f(string, "context.getString(R.string.video_fit_screen)");
                } else {
                    scaleMode = ScaleMode.SCALE_TO_FILL;
                    string = ImmScaleView.this.getContext().getString(R$string.video_stretch);
                    Intrinsics.f(string, "context.getString(R.string.video_stretch)");
                }
                ImmScaleView.this.a(scaleMode);
                a onModelChangeListener = ImmScaleView.this.getOnModelChangeListener();
                if (onModelChangeListener != null) {
                    onModelChangeListener.a(scaleMode, string);
                }
                String str = ImmScaleView.this.f55959a;
                if (str != null) {
                    com.transsion.baselib.report.m.f51277a.m(str, "click", kotlin.collections.s.l(new Pair("module_name", "scale_mode"), new Pair("subject_id", ImmScaleView.this.f55960b), new Pair("type", String.valueOf(scaleMode.getValue()))));
                }
            }
        }, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmScaleView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        a(LocalVideoPlayerConfigMmkv.f51172a.b());
        so.c.c(this, 0L, new Function1<View, Unit>() { // from class: com.transsion.postdetail.ui.view.ImmScaleView.1

            /* JADX INFO: renamed from: com.transsion.postdetail.ui.view.ImmScaleView$1$a */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            public /* synthetic */ class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f55962a;

                static {
                    int[] iArr = new int[ScaleMode.values().length];
                    try {
                        iArr[ScaleMode.SCALE_TO_FILL.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ScaleMode.SCALE_ASPECT_FIT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f55962a = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                ScaleMode scaleMode;
                String string;
                Intrinsics.g(it, "it");
                int i12 = a.f55962a[LocalVideoPlayerConfigMmkv.f51172a.b().ordinal()];
                if (i12 == 1) {
                    scaleMode = ScaleMode.SCALE_ASPECT_FILL;
                    string = ImmScaleView.this.getContext().getString(R$string.video_crop);
                    Intrinsics.f(string, "context.getString(R.string.video_crop)");
                } else if (i12 != 2) {
                    scaleMode = ScaleMode.SCALE_ASPECT_FIT;
                    string = ImmScaleView.this.getContext().getString(R$string.video_fit_screen);
                    Intrinsics.f(string, "context.getString(R.string.video_fit_screen)");
                } else {
                    scaleMode = ScaleMode.SCALE_TO_FILL;
                    string = ImmScaleView.this.getContext().getString(R$string.video_stretch);
                    Intrinsics.f(string, "context.getString(R.string.video_stretch)");
                }
                ImmScaleView.this.a(scaleMode);
                a onModelChangeListener = ImmScaleView.this.getOnModelChangeListener();
                if (onModelChangeListener != null) {
                    onModelChangeListener.a(scaleMode, string);
                }
                String str = ImmScaleView.this.f55959a;
                if (str != null) {
                    com.transsion.baselib.report.m.f51277a.m(str, "click", kotlin.collections.s.l(new Pair("module_name", "scale_mode"), new Pair("subject_id", ImmScaleView.this.f55960b), new Pair("type", String.valueOf(scaleMode.getValue()))));
                }
            }
        }, 1, null);
    }

    public final void a(ScaleMode scaleMode) {
        LocalVideoPlayerConfigMmkv.f51172a.d(scaleMode);
        int i11 = b.f55963a[scaleMode.ordinal()];
        if (i11 == 1) {
            setImageResource(R$mipmap.ic_video_fit_screen);
        } else if (i11 != 2) {
            setImageResource(R$mipmap.ic_video_stretch);
        } else {
            setImageResource(R$mipmap.ic_video_crop);
        }
    }

    public final a getOnModelChangeListener() {
        return this.f55961c;
    }

    public final void setOnModelChangeListener(a aVar) {
        this.f55961c = aVar;
    }

    public final void setPageParams(String str, String subjectId) {
        Intrinsics.g(subjectId, "subjectId");
        this.f55959a = str;
        this.f55960b = subjectId;
    }
}
