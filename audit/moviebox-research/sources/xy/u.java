package xy;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import com.transsion.usercenter.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class u implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f80969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Button f80970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Button f80971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final RadioButton f80972d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final RadioButton f80973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final RadioGroup f80974g;

    public u(@NonNull FrameLayout frameLayout, @NonNull Button button, @NonNull Button button2, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull RadioGroup radioGroup) {
        this.f80969a = frameLayout;
        this.f80970b = button;
        this.f80971c = button2;
        this.f80972d = radioButton;
        this.f80973f = radioButton2;
        this.f80974g = radioGroup;
    }

    @NonNull
    public static u a(@NonNull View view) {
        int i11 = R$id.btnCancel;
        Button button = (Button) n6.b.a(view, i11);
        if (button != null) {
            i11 = R$id.btnOk;
            Button button2 = (Button) n6.b.a(view, i11);
            if (button2 != null) {
                i11 = R$id.radioButtonDownload;
                RadioButton radioButton = (RadioButton) n6.b.a(view, i11);
                if (radioButton != null) {
                    i11 = R$id.radioButtonStream;
                    RadioButton radioButton2 = (RadioButton) n6.b.a(view, i11);
                    if (radioButton2 != null) {
                        i11 = R$id.radioGroup;
                        RadioGroup radioGroup = (RadioGroup) n6.b.a(view, i11);
                        if (radioGroup != null) {
                            return new u((FrameLayout) view, button, button2, radioButton, radioButton2, radioGroup);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f80969a;
    }
}
