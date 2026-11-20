package com.transsion.subtitle.helper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;

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
public final class g implements View.OnTouchListener {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f58278p = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f58279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public vx.a f58280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f58281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f58282d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f58283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EditText f58284g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f58286i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function2<? super vx.a, ? super Long, Unit> f58287j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0<Unit> f58288k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f58289l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f58290m;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Handler f58285h = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Runnable f58291n = new Runnable() { // from class: com.transsion.subtitle.helper.e
        @Override // java.lang.Runnable
        public final void run() {
            g.s(this.f58276a);
        }
    };

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f58292o = new c(Looper.getMainLooper());

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s11) {
            Editable text;
            Intrinsics.g(s11, "s");
            g.this.f58285h.removeCallbacks(g.this.f58291n);
            EditText editText = g.this.f58284g;
            if (editText == null || (text = editText.getText()) == null) {
                return;
            }
            g gVar = g.this;
            float fM = g.m(gVar, text, 0.0f, 2, null);
            if (gVar.f58286i != fM) {
                gVar.f58286i = fM;
            }
            if (gVar.f58290m == fM) {
                return;
            }
            if (!l.u(text.toString(), "s", false, 2, null)) {
                EditText editText2 = gVar.f58284g;
                if (editText2 != null) {
                    editText2.setText(((Object) text) + "s");
                }
                EditText editText3 = gVar.f58284g;
                if (editText3 != null) {
                    editText3.setSelection(text.length());
                }
            }
            gVar.f58290m = fM;
            gVar.u((long) (fM * 1000));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s11, int i11, int i12, int i13) {
            Intrinsics.g(s11, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s11, int i11, int i12, int i13) {
            Intrinsics.g(s11, "s");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Intrinsics.g(msg, "msg");
            super.handleMessage(msg);
            int i11 = msg.what;
            int i12 = msg.arg1;
            if (i11 == 1) {
                g.this.t(i12 == R$id.iv_sync_adjust_plus);
                sendMessageDelayed(obtainMessage(i11, msg.arg1, msg.arg2), 100L);
            }
        }
    }

    public g(ViewGroup viewGroup) {
        this.f58279a = viewGroup;
    }

    public static /* synthetic */ float m(g gVar, CharSequence charSequence, float f11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f11 = Float.NaN;
        }
        return gVar.l(charSequence, f11);
    }

    public static final void p(g this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Function0<Unit> function0 = this$0.f58288k;
        if (function0 != null) {
            function0.invoke();
        }
        this$0.f58285h.removeCallbacks(this$0.f58291n);
        this$0.n();
    }

    public static final void s(g this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.n();
    }

    public final float l(CharSequence charSequence, float f11) {
        if (charSequence.length() == 0) {
            return f11;
        }
        String string = charSequence.toString();
        if (l.u(string, "s", false, 2, null)) {
            string = string.substring(0, string.length() - 1);
            Intrinsics.f(string, "substring(...)");
        }
        if (StringsKt__StringsKt.Q(string, "s", false, 2, null)) {
            l.F(string, "s", "", false, 4, null);
        }
        try {
            return Float.parseFloat(string);
        } catch (Throwable unused) {
            return f11;
        }
    }

    public final void n() {
        ViewGroup viewGroup = this.f58279a;
        if (viewGroup != null) {
            so.c.g(viewGroup);
            KeyboardUtils.e(viewGroup);
        }
    }

    public final void o(Function2<? super vx.a, ? super Long, Unit> function2) {
        this.f58287j = function2;
        ViewGroup viewGroup = this.f58279a;
        this.f58281c = viewGroup != null ? (ImageView) viewGroup.findViewById(R$id.iv_close) : null;
        ViewGroup viewGroup2 = this.f58279a;
        this.f58282d = viewGroup2 != null ? (ImageView) viewGroup2.findViewById(R$id.iv_sync_adjust_plus) : null;
        ViewGroup viewGroup3 = this.f58279a;
        this.f58283f = viewGroup3 != null ? (ImageView) viewGroup3.findViewById(R$id.iv_sync_adjust_minus) : null;
        ViewGroup viewGroup4 = this.f58279a;
        this.f58284g = viewGroup4 != null ? (EditText) viewGroup4.findViewById(R$id.et_sync_adjust) : null;
        ImageView imageView = this.f58281c;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.helper.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.p(this.f58277a, view);
                }
            });
        }
        ImageView imageView2 = this.f58282d;
        if (imageView2 != null) {
            imageView2.setOnTouchListener(this);
        }
        ImageView imageView3 = this.f58283f;
        if (imageView3 != null) {
            imageView3.setOnTouchListener(this);
        }
        ImageView imageView4 = this.f58282d;
        if (imageView4 != null) {
            imageView4.setFocusable(true);
        }
        ImageView imageView5 = this.f58283f;
        if (imageView5 != null) {
            imageView5.setFocusable(true);
        }
        ImageView imageView6 = this.f58282d;
        if (imageView6 != null) {
            imageView6.setClickable(true);
        }
        ImageView imageView7 = this.f58283f;
        if (imageView7 != null) {
            imageView7.setClickable(true);
        }
        EditText editText = this.f58284g;
        if (editText != null) {
            editText.addTextChangedListener(new b());
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Integer numValueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            this.f58289l = System.currentTimeMillis();
            c cVar = this.f58292o;
            cVar.sendMessageDelayed(cVar.obtainMessage(1, view != null ? view.getId() : 0, 0), 1200L);
            if (view != null) {
                view.setPressed(true);
            }
        } else if (numValueOf != null && numValueOf.intValue() == 1) {
            this.f58292o.removeCallbacksAndMessages(null);
            if (System.currentTimeMillis() - this.f58289l <= 400) {
                t((view != null ? view.getId() : 0) == R$id.iv_sync_adjust_plus);
            }
            if (view != null) {
                view.setPressed(false);
            }
        }
        return true;
    }

    public final void q(Function2<? super vx.a, ? super Long, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f58287j = callback;
    }

    public final void r(vx.a aVar) {
        SubtitleDownloadTable subtitleDownloadTableB;
        Long delay;
        this.f58280b = aVar;
        float fLongValue = ((aVar == null || (subtitleDownloadTableB = aVar.b()) == null || (delay = subtitleDownloadTableB.getDelay()) == null) ? 0L : delay.longValue()) / 1000.0f;
        this.f58286i = fLongValue;
        this.f58290m = fLongValue;
        EditText editText = this.f58284g;
        if (editText != null) {
            editText.setText(fLongValue + "s");
        }
        com.transsion.subtitle.a.f58119a.a(g.class.getSimpleName() + " --> setCurDefVideoSubtitleBean() --> cur duration = " + this.f58286i);
    }

    public final void t(boolean z11) {
        float f11 = (z11 ? (this.f58286i * 1000.0f) + 100 : (this.f58286i * 1000.0f) - 100) / 1000.0f;
        this.f58286i = f11;
        EditText editText = this.f58284g;
        if (editText != null) {
            editText.setText(f11 + "s");
        }
        this.f58285h.removeCallbacks(this.f58291n);
    }

    public final void u(long j11) {
        vx.a aVar = this.f58280b;
        SubtitleDownloadTable subtitleDownloadTableB = aVar != null ? aVar.b() : null;
        if (subtitleDownloadTableB != null) {
            subtitleDownloadTableB.setDelay(Long.valueOf(j11));
        }
        Function2<? super vx.a, ? super Long, Unit> function2 = this.f58287j;
        if (function2 != null) {
            function2.invoke(this.f58280b, Long.valueOf(j11));
        }
    }
}
