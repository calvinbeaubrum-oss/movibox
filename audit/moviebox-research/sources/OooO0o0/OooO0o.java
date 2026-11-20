package OooO0o0;

import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class OooO0o extends Lambda implements Function1<Drawable, Unit> {
    public final /* synthetic */ AppCompatImageView OooO00o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooO0o(AppCompatImageView appCompatImageView) {
        super(1);
        this.OooO00o = appCompatImageView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Drawable drawable) {
        this.OooO00o.setImageDrawable(drawable);
        return Unit.f68710a;
    }
}
