package c3;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.error.VungleException;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
public class k extends l {
    public static int i(@NonNull FontStyle fontStyle, @NonNull FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // c3.l
    @Nullable
    public Typeface a(Context context, b3.e.c cVar, Resources resources, int i11) {
        try {
            FontFamily.Builder builder = null;
            for (b3.e.d dVar : cVar.a()) {
                try {
                    Font fontBuild = new Font.Builder(resources, dVar.b()).setWeight(dVar.e()).setSlant(dVar.f() ? 1 : 0).setTtcIndex(dVar.c()).setFontVariationSettings(dVar.d()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(h(fontFamilyBuild, i11).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // c3.l
    @Nullable
    public Typeface b(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull androidx.core.provider.g.b[] bVarArr, int i11) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (androidx.core.provider.g.b bVar : bVarArr) {
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(bVar.d(), CampaignEx.JSON_KEY_AD_R, cancellationSignal);
                    if (parcelFileDescriptorOpenFileDescriptor == null) {
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                        }
                    } else {
                        try {
                            Font fontBuild = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(bVar.e()).setSlant(bVar.f() ? 1 : 0).setTtcIndex(bVar.c()).build();
                            if (builder == null) {
                                builder = new FontFamily.Builder(fontBuild);
                            } else {
                                builder.addFont(fontBuild);
                            }
                        } catch (Throwable th2) {
                            try {
                                parcelFileDescriptorOpenFileDescriptor.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(h(fontFamilyBuild, i11).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // c3.l
    @Nullable
    public Typeface d(Context context, Resources resources, int i11, String str, int i12) {
        try {
            Font fontBuild = new Font.Builder(resources, i11).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // c3.l
    public androidx.core.provider.g.b g(androidx.core.provider.g.b[] bVarArr, int i11) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    public final Font h(@NonNull FontFamily fontFamily, int i11) {
        FontStyle fontStyle = new FontStyle((i11 & 1) != 0 ? LogSeverity.ALERT_VALUE : LogSeverity.WARNING_VALUE, (i11 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int i12 = i(fontStyle, font.getStyle());
        for (int i13 = 1; i13 < fontFamily.getSize(); i13++) {
            Font font2 = fontFamily.getFont(i13);
            int i14 = i(fontStyle, font2.getStyle());
            if (i14 < i12) {
                font = font2;
                i12 = i14;
            }
        }
        return font;
    }
}
