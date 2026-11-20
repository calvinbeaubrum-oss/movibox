package androidx.media3.exoplayer;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.core.view.PointerIconCompat;
import androidx.media3.common.PlaybackException;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class ExoPlaybackException extends PlaybackException {
    public static final int TYPE_REMOTE = 3;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_UNEXPECTED = 2;
    final boolean isRecoverable;

    @Nullable
    public final androidx.media3.exoplayer.source.l.b mediaPeriodId;

    @Nullable
    public final androidx.media3.common.y rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;

    @Nullable
    public final String rendererName;
    public final int type;

    @Deprecated
    public static final androidx.media3.common.i<ExoPlaybackException> CREATOR = new androidx.media3.common.b();
    private static final String FIELD_TYPE = z3.u0.E0(1001);
    private static final String FIELD_RENDERER_NAME = z3.u0.E0(1002);
    private static final String FIELD_RENDERER_INDEX = z3.u0.E0(1003);
    private static final String FIELD_RENDERER_FORMAT = z3.u0.E0(1004);
    private static final String FIELD_RENDERER_FORMAT_SUPPORT = z3.u0.E0(1005);
    private static final String FIELD_IS_RECOVERABLE = z3.u0.E0(PointerIconCompat.TYPE_CELL);

    private ExoPlaybackException(int i11, Throwable th2, int i12) {
        this(i11, th2, null, i12, null, -1, null, 4, false);
    }

    private ExoPlaybackException(int i11, @Nullable Throwable th2, @Nullable String str, int i12, @Nullable String str2, int i13, @Nullable androidx.media3.common.y yVar, int i14, boolean z11) {
        this(deriveMessage(i11, str, str2, i13, yVar, i14), th2, i12, i11, str2, i13, yVar, i14, null, SystemClock.elapsedRealtime(), z11);
    }

    private ExoPlaybackException(Bundle bundle) {
        super(bundle);
        this.type = bundle.getInt(FIELD_TYPE, 2);
        this.rendererName = bundle.getString(FIELD_RENDERER_NAME);
        this.rendererIndex = bundle.getInt(FIELD_RENDERER_INDEX, -1);
        Bundle bundle2 = bundle.getBundle(FIELD_RENDERER_FORMAT);
        this.rendererFormat = bundle2 == null ? null : androidx.media3.common.y.e(bundle2);
        this.rendererFormatSupport = bundle.getInt(FIELD_RENDERER_FORMAT_SUPPORT, 4);
        this.isRecoverable = bundle.getBoolean(FIELD_IS_RECOVERABLE, false);
        this.mediaPeriodId = null;
    }

    private ExoPlaybackException(String str, @Nullable Throwable th2, int i11, int i12, @Nullable String str2, int i13, @Nullable androidx.media3.common.y yVar, int i14, @Nullable androidx.media3.exoplayer.source.l.b bVar, long j11, boolean z11) {
        super(str, th2, i11, j11);
        z3.a.a(!z11 || i12 == 1);
        z3.a.a(th2 != null || i12 == 3);
        this.type = i12;
        this.rendererName = str2;
        this.rendererIndex = i13;
        this.rendererFormat = yVar;
        this.rendererFormatSupport = i14;
        this.mediaPeriodId = bVar;
        this.isRecoverable = z11;
    }

    public static ExoPlaybackException createForRemote(String str) {
        return new ExoPlaybackException(3, null, str, 1001, null, -1, null, 4, false);
    }

    public static ExoPlaybackException createForRenderer(Throwable th2, String str, int i11, @Nullable androidx.media3.common.y yVar, int i12, boolean z11, int i13) {
        return new ExoPlaybackException(1, th2, null, i13, str, i11, yVar, yVar == null ? 4 : i12, z11);
    }

    public static ExoPlaybackException createForSource(IOException iOException, int i11) {
        return new ExoPlaybackException(0, iOException, i11);
    }

    @Deprecated
    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException) {
        return createForUnexpected(runtimeException, 1000);
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException, int i11) {
        return new ExoPlaybackException(2, runtimeException, i11);
    }

    private static String deriveMessage(int i11, @Nullable String str, @Nullable String str2, int i12, @Nullable androidx.media3.common.y yVar, int i13) {
        String str3;
        if (i11 == 0) {
            str3 = "Source error";
        } else if (i11 != 1) {
            str3 = i11 != 3 ? "Unexpected runtime error" : "Remote error";
        } else {
            str3 = str2 + " error, index=" + i12 + ", format=" + yVar + ", format_supported=" + z3.u0.d0(i13);
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        return str3 + ": " + str;
    }

    public static ExoPlaybackException fromBundle(Bundle bundle) {
        return new ExoPlaybackException(bundle);
    }

    @CheckResult
    public ExoPlaybackException copyWithMediaPeriodId(@Nullable androidx.media3.exoplayer.source.l.b bVar) {
        return new ExoPlaybackException((String) z3.u0.i(getMessage()), getCause(), this.errorCode, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, bVar, this.timestampMs, this.isRecoverable);
    }

    @Override // androidx.media3.common.PlaybackException
    public boolean errorInfoEquals(@Nullable PlaybackException playbackException) {
        if (!super.errorInfoEquals(playbackException)) {
            return false;
        }
        ExoPlaybackException exoPlaybackException = (ExoPlaybackException) z3.u0.i(playbackException);
        return this.type == exoPlaybackException.type && z3.u0.c(this.rendererName, exoPlaybackException.rendererName) && this.rendererIndex == exoPlaybackException.rendererIndex && z3.u0.c(this.rendererFormat, exoPlaybackException.rendererFormat) && this.rendererFormatSupport == exoPlaybackException.rendererFormatSupport && z3.u0.c(this.mediaPeriodId, exoPlaybackException.mediaPeriodId) && this.isRecoverable == exoPlaybackException.isRecoverable;
    }

    public Exception getRendererException() {
        z3.a.g(this.type == 1);
        return (Exception) z3.a.e(getCause());
    }

    public IOException getSourceException() {
        z3.a.g(this.type == 0);
        return (IOException) z3.a.e(getCause());
    }

    public RuntimeException getUnexpectedException() {
        z3.a.g(this.type == 2);
        return (RuntimeException) z3.a.e(getCause());
    }

    @Override // androidx.media3.common.PlaybackException
    public Bundle toBundle() {
        Bundle bundle = super.toBundle();
        bundle.putInt(FIELD_TYPE, this.type);
        bundle.putString(FIELD_RENDERER_NAME, this.rendererName);
        bundle.putInt(FIELD_RENDERER_INDEX, this.rendererIndex);
        androidx.media3.common.y yVar = this.rendererFormat;
        if (yVar != null) {
            bundle.putBundle(FIELD_RENDERER_FORMAT, yVar.k());
        }
        bundle.putInt(FIELD_RENDERER_FORMAT_SUPPORT, this.rendererFormatSupport);
        bundle.putBoolean(FIELD_IS_RECOVERABLE, this.isRecoverable);
        return bundle;
    }
}
