package com.vungle.warren.utility;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ImpressionTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Map<View, a> f62576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f62577b;

    /* JADX INFO: compiled from: source.java */
    public class VisibilityRunnable implements Runnable {

        @NonNull
        private final ArrayList<View> mVisibleViews = new ArrayList<>();
        final /* synthetic */ ImpressionTracker this$0;

        public VisibilityRunnable(ImpressionTracker impressionTracker) {
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f62577b = false;
            for (Map.Entry entry : this.this$0.f62576a.entrySet()) {
                View view = (View) entry.getKey();
                if (this.this$0.d(view, ((a) entry.getValue()).f62578a)) {
                    this.mVisibleViews.add(view);
                }
            }
            for (View view2 : this.mVisibleViews) {
                this.this$0.e(view2);
            }
            this.mVisibleViews.clear();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f62578a;
    }

    public final boolean d(@Nullable View view, int i11) {
        throw null;
    }

    public void e(@NonNull View view) {
        throw null;
    }
}
