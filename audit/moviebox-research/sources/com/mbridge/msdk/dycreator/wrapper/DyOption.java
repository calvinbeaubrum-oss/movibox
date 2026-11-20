package com.mbridge.msdk.dycreator.wrapper;

import com.mbridge.msdk.dycreator.listener.DyCountDownListenerWrapper;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class DyOption {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f43701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f43702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CampaignEx f43703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DyAdType f43704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f43705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f43706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f43707g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f43708h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f43709i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f43710j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f43711k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f43712l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f43713m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f43714n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f43715o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f43716p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f43717q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private DyCountDownListenerWrapper f43718r;

    /* JADX INFO: compiled from: source.java */
    public static class Builder implements IViewOptionBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<String> f43719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private File f43720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CampaignEx f43721c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private DyAdType f43722d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f43723e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f43724f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f43725g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f43726h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f43727i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f43728j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f43729k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f43730l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f43731m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f43732n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f43733o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f43734p;

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder adChoiceLink(String str) {
            this.f43724f = str;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public DyOption build() {
            return new DyOption(this);
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder campaignEx(CampaignEx campaignEx) {
            this.f43721c = campaignEx;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder canSkip(boolean z11) {
            this.f43723e = z11;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder countDownTime(int i11) {
            this.f43733o = i11;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder dyAdType(DyAdType dyAdType) {
            this.f43722d = dyAdType;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder file(File file) {
            this.f43720b = file;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder fileDirs(List<String> list) {
            this.f43719a = list;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder isApkInfoVisible(boolean z11) {
            this.f43728j = z11;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder isClickButtonVisible(boolean z11) {
            this.f43726h = z11;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder isLogoVisible(boolean z11) {
            this.f43729k = z11;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder isScreenClick(boolean z11) {
            this.f43725g = z11;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder isShakeVisible(boolean z11) {
            this.f43727i = z11;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder orientation(int i11) {
            this.f43732n = i11;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder shakeStrenght(int i11) {
            this.f43730l = i11;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder shakeTime(int i11) {
            this.f43731m = i11;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder templateType(int i11) {
            this.f43734p = i11;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface IViewOptionBuilder {
        IViewOptionBuilder adChoiceLink(String str);

        DyOption build();

        IViewOptionBuilder campaignEx(CampaignEx campaignEx);

        IViewOptionBuilder canSkip(boolean z11);

        IViewOptionBuilder countDownTime(int i11);

        IViewOptionBuilder dyAdType(DyAdType dyAdType);

        IViewOptionBuilder file(File file);

        IViewOptionBuilder fileDirs(List<String> list);

        IViewOptionBuilder isApkInfoVisible(boolean z11);

        IViewOptionBuilder isClickButtonVisible(boolean z11);

        IViewOptionBuilder isLogoVisible(boolean z11);

        IViewOptionBuilder isScreenClick(boolean z11);

        IViewOptionBuilder isShakeVisible(boolean z11);

        IViewOptionBuilder orientation(int i11);

        IViewOptionBuilder shakeStrenght(int i11);

        IViewOptionBuilder shakeTime(int i11);

        IViewOptionBuilder templateType(int i11);
    }

    public DyOption(Builder builder) {
        this.f43701a = builder.f43719a;
        this.f43702b = builder.f43720b;
        this.f43703c = builder.f43721c;
        this.f43704d = builder.f43722d;
        this.f43707g = builder.f43723e;
        this.f43705e = builder.f43724f;
        this.f43706f = builder.f43725g;
        this.f43708h = builder.f43726h;
        this.f43710j = builder.f43728j;
        this.f43709i = builder.f43727i;
        this.f43711k = builder.f43729k;
        this.f43712l = builder.f43730l;
        this.f43713m = builder.f43731m;
        this.f43714n = builder.f43732n;
        this.f43715o = builder.f43733o;
        this.f43717q = builder.f43734p;
    }

    public String getAdChoiceLink() {
        return this.f43705e;
    }

    public CampaignEx getCampaignEx() {
        return this.f43703c;
    }

    public int getCountDownTime() {
        return this.f43715o;
    }

    public int getCurrentCountDown() {
        return this.f43716p;
    }

    public DyAdType getDyAdType() {
        return this.f43704d;
    }

    public File getFile() {
        return this.f43702b;
    }

    public List<String> getFileDirs() {
        return this.f43701a;
    }

    public int getOrientation() {
        return this.f43714n;
    }

    public int getShakeStrenght() {
        return this.f43712l;
    }

    public int getShakeTime() {
        return this.f43713m;
    }

    public int getTemplateType() {
        return this.f43717q;
    }

    public boolean isApkInfoVisible() {
        return this.f43710j;
    }

    public boolean isCanSkip() {
        return this.f43707g;
    }

    public boolean isClickButtonVisible() {
        return this.f43708h;
    }

    public boolean isClickScreen() {
        return this.f43706f;
    }

    public boolean isLogoVisible() {
        return this.f43711k;
    }

    public boolean isShakeVisible() {
        return this.f43709i;
    }

    public void setDyCountDownListener(int i11) {
        DyCountDownListenerWrapper dyCountDownListenerWrapper = this.f43718r;
        if (dyCountDownListenerWrapper != null) {
            dyCountDownListenerWrapper.getCountDownValue(i11);
        }
        this.f43716p = i11;
    }

    public void setDyCountDownListenerWrapper(DyCountDownListenerWrapper dyCountDownListenerWrapper) {
        this.f43718r = dyCountDownListenerWrapper;
    }
}
