package OooO0o0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.cloud.tmc.miniapp.ui.WebViewActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mb.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o0OOO0o extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ String OooO00o;
    public final /* synthetic */ o0ooOOo OooO0O0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0OOO0o(String str, o0ooOOo o0ooooo) {
        super(1);
        this.OooO00o = str;
        this.OooO0O0 = o0ooooo;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        View it = view;
        Intrinsics.g(it, "it");
        String str = TextUtils.isEmpty(this.OooO00o) ? "https://h5.dlight-app.com/outside/privacy-policy?lang=" : this.OooO00o;
        WebViewActivity.a aVar = WebViewActivity.f31752h;
        Context context = this.OooO0O0.f27a;
        WebViewActivity.a.a(aVar, context, d.a(str, context), null, null, 12);
        return Unit.f68710a;
    }
}
