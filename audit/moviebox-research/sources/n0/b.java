package n0;

import android.app.Application;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends Toast implements o0.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f71319a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Application application) {
        super(application);
        Intrinsics.g(application, "application");
    }

    @Override // o0.e
    public ImageView a(View view) {
        return o0.e.a.a(view);
    }

    @Override // android.widget.Toast, o0.e
    public void setText(CharSequence charSequence) {
        TextView textView = this.f71319a;
        if (textView != null) {
            textView.setText(charSequence);
            return;
        }
        try {
            super.setText(charSequence);
        } catch (Throwable th2) {
            TmcLogger.g("SystemToast", "super.setText failed!", th2);
        }
    }

    @Override // android.widget.Toast, o0.e
    public void setView(View view) {
        super.setView(view);
        if (view == null) {
            this.f71319a = null;
        } else {
            this.f71319a = o0.e.a.b(view);
        }
    }
}
