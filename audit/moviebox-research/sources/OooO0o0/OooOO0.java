package OooO0o0;

import OooO0o0.OooOO0;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatImageView;
import com.cloud.tmc.kernel.resource.IResourceProcessor;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.cloud.tmc.miniapp.dialog.BottomActionSheetDialog$ActionItemAdapter$ViewHolder$requestDrawable$1", f = "BottomActionSheetDialog.kt", l = {}, m = "invokeSuspend")
public final class OooOO0 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    public final /* synthetic */ OooO OooO00o;
    public final /* synthetic */ String OooO0O0;
    public final /* synthetic */ String OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public final /* synthetic */ OooO.OooO00o f50OooO0Oo;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public final /* synthetic */ Function1<Drawable, Unit> f51OooO0o0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OooOO0(OooO oooO, String str, String str2, OooO.OooO00o oooO00o, Function1<? super Drawable, Unit> function1, Continuation<? super OooOO0> continuation) {
        super(2, continuation);
        this.OooO00o = oooO;
        this.OooO0O0 = str;
        this.OooO0OO = str2;
        this.f50OooO0Oo = oooO00o;
        this.f51OooO0o0 = function1;
    }

    public static final void OooO00o(Function1 function1, File file) {
        if (function1 != null) {
            function1.invoke(Drawable.createFromPath(file != null ? file.getAbsolutePath() : null));
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OooOO0(this.OooO00o, this.OooO0O0, this.OooO0OO, this.f50OooO0Oo, this.f51OooO0o0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((OooOO0) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        ResultKt.b(obj);
        Object value = this.OooO00o.f6p.getValue();
        Intrinsics.f(value, "<get-processor>(...)");
        final File file = ((IResourceProcessor) value).get(this.OooO0O0, this.OooO0OO);
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.f50OooO0Oo.f10f.getValue();
        if (appCompatImageView != null) {
            final Function1<Drawable, Unit> function1 = this.f51OooO0o0;
            Boxing.a(appCompatImageView.post(new Runnable() { // from class: j.e
                @Override // java.lang.Runnable
                public final void run() {
                    OooOO0.OooO00o(function1, file);
                }
            }));
        }
        return Unit.f68710a;
    }
}
