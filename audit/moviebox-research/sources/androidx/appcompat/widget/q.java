package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public TextView f1733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public TextClassifier f1734b;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(26)
    public static final class a {
        @NonNull
        public static TextClassifier a(@NonNull TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
    }

    public q(@NonNull TextView textView) {
        this.f1733a = (TextView) androidx.core.util.i.g(textView);
    }

    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier a() {
        TextClassifier textClassifier = this.f1734b;
        return textClassifier == null ? a.a(this.f1733a) : textClassifier;
    }

    @RequiresApi(api = 26)
    public void b(@Nullable TextClassifier textClassifier) {
        this.f1734b = textClassifier;
    }
}
