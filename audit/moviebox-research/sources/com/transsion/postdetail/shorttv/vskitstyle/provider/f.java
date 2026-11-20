package com.transsion.postdetail.shorttv.vskitstyle.provider;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.Utils;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.shorttv.o;
import com.transsion.postdetail.shorttv.vskitstyle.unlock.ShortTvHisvanaAdUnlockRequest;
import com.transsion.postdetail.shorttv.vskitstyle.unlock.ShortTvInterstitialAdUnlockRequest;
import com.transsnet.downloader.util.ShortTvMmkv;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.h;
import rx.i;

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
public final class f implements rx.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f55443b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<rx.d> f55444a = g.h(new ShortTvHisvanaAdUnlockRequest(), new ShortTvInterstitialAdUnlockRequest());

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
    public static final class b implements rx.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rx.e f55445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f55446b;

        public b(rx.e eVar, f fVar) {
            this.f55445a = eVar;
            this.f55446b = fVar;
        }

        @Override // rx.e
        public void a(rx.g result) {
            Intrinsics.g(result, "result");
            this.f55445a.a(result instanceof rx.c ? new h(((rx.c) result).b()) : result);
            this.f55446b.i(result);
        }
    }

    public static final void h(Context context, Subject subject, f this$0, rx.e unlockRequestCallback, qx.d dVar, View view) {
        String subjectId;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(unlockRequestCallback, "$unlockRequestCallback");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 1000L)) {
            return;
        }
        tp.e eVar = tp.e.f77259a;
        Intrinsics.f(context, "context");
        if (!eVar.a(context)) {
            com.tn.lib.widget.toast.core.h.f50034a.k(R$string.player_no_network_tip2);
            return;
        }
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            subjectId = "";
        }
        rx.f fVar = new rx.f(subjectId, subject != null ? Integer.valueOf(subject.getTotalEpisode()) : null, null, 4, null);
        int iB = dVar.b();
        int iG = kotlin.ranges.a.g((ShortTvMmkv.f61142a.e() + iB) - 1, subject != null ? subject.getTotalEpisode() : 0);
        if (iB <= iG) {
            while (true) {
                fVar.d().add(Integer.valueOf(iB));
                if (iB == iG) {
                    break;
                } else {
                    iB++;
                }
            }
        }
        this$0.a(context, fVar, unlockRequestCallback);
        o.b(o.f55416a, dVar.d(), "dialog_minitv_unlock", "1", null, 8, null);
    }

    public static final void j(String msg) {
        Intrinsics.g(msg, "$msg");
        com.tn.lib.widget.toast.core.h.f50034a.l(msg);
    }

    @Override // rx.a, rx.d
    public void a(Context context, rx.f params, rx.e callback) {
        Intrinsics.g(context, "context");
        Intrinsics.g(params, "params");
        Intrinsics.g(callback, "callback");
        rx.a.C0834a.c(this, context, params, new b(callback, this));
    }

    @Override // rx.a
    public int b(Subject subject) {
        String subjectId;
        ShortTvMmkv shortTvMmkv = ShortTvMmkv.f61142a;
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            subjectId = "";
        }
        return shortTvMmkv.c(subjectId);
    }

    @Override // rx.a
    public List<rx.d> c() {
        return this.f55444a;
    }

    @Override // rx.a
    public View d(ViewStub viewStub, final qx.d dVar, final Subject subject, final rx.e unlockRequestCallback) {
        Intrinsics.g(viewStub, "viewStub");
        Intrinsics.g(unlockRequestCallback, "unlockRequestCallback");
        if (viewStub.getParent() == null || dVar == null) {
            return null;
        }
        viewStub.setLayoutResource(R$layout.dialog_short_tv_unlock_tips);
        View viewInflate = viewStub.inflate();
        tv.h hVarA = tv.h.a(viewInflate);
        Intrinsics.f(hVarA, "bind(unlockView)");
        final Context context = viewStub.getContext();
        AppCompatImageView appCompatImageView = hVarA.f77753d;
        Intrinsics.f(appCompatImageView, "unlockBinding.ivClose");
        so.c.g(appCompatImageView);
        AppCompatTextView appCompatTextView = hVarA.f77754f;
        int totalEpisode = subject != null ? subject.getTotalEpisode() : 0;
        ShortTvMmkv shortTvMmkv = ShortTvMmkv.f61142a;
        appCompatTextView.setText(shortTvMmkv.e() + shortTvMmkv.c(dVar.d()) >= totalEpisode ? context.getString(R$string.short_tv_watch_ad_tips, context.getString(R$string.short_tv_all)) : context.getString(R$string.short_tv_watch_ad_tips, String.valueOf(shortTvMmkv.e())));
        hVarA.f77755g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.shorttv.vskitstyle.provider.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.h(context, subject, this, unlockRequestCallback, dVar, view);
            }
        });
        o.d(o.f55416a, dVar.d(), "dialog_minitv_unlock", null, 4, null);
        return viewInflate;
    }

    public final void i(rx.g gVar) {
        rx.f fVarA;
        String str = "ad_success";
        if (gVar instanceof i) {
            fVarA = ((i) gVar).a();
        } else if (gVar instanceof h) {
            fVarA = ((h) gVar).a();
        } else if (gVar instanceof rx.c) {
            fVarA = ((rx.c) gVar).b();
            str = "ad_load_fail";
        } else {
            if (!(gVar instanceof rx.b)) {
                throw new NoWhenBranchMatchedException();
            }
            fVarA = ((rx.b) gVar).a();
            str = "ad_cancel";
        }
        String str2 = str;
        StringBuilder sb2 = new StringBuilder();
        Iterator<Integer> it = fVarA.d().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (iIntValue > i11) {
                i11 = iIntValue;
            }
            sb2.append(iIntValue);
            sb2.append(",");
        }
        o oVar = o.f55416a;
        String strB = fVarA.b();
        String strA = fVarA.a();
        String strSubstring = sb2.substring(0, sb2.length() - 1);
        Intrinsics.f(strSubstring, "stringBuilder.substring(…stringBuilder.length - 1)");
        o.h(oVar, strB, strA, str2, strSubstring, null, 16, null);
        if (gVar instanceof rx.b) {
            return;
        }
        ShortTvMmkv shortTvMmkv = ShortTvMmkv.f61142a;
        shortTvMmkv.h(fVarA.b(), i11);
        Integer numC = fVarA.c();
        final String string = i11 >= (numC != null ? numC.intValue() : shortTvMmkv.e()) ? Utils.a().getString(R$string.short_tv_unlock_success, Utils.a().getString(R$string.short_tv_all)) : Utils.a().getString(R$string.short_tv_unlock_success, String.valueOf(shortTvMmkv.e()));
        Intrinsics.f(string, "if (max >= totalEpisode)…toString())\n            }");
        new Handler().postDelayed(new Runnable() { // from class: com.transsion.postdetail.shorttv.vskitstyle.provider.e
            @Override // java.lang.Runnable
            public final void run() {
                f.j(string);
            }
        }, 500L);
    }
}
