package com.prayers.app.navigation;

import android.app.Activity;
import android.os.Bundle;

import com.prayers.app.activity.AbstractClosableActivity;
import com.prayers.app.activity.ninth.NinthBeginActivity;
import com.prayers.app.activity.ninth.NinthChildJesusPrayerActivity;
import com.prayers.app.activity.ninth.NinthConsiderationActivity;
import com.prayers.app.activity.ninth.NinthEndActivity;
import com.prayers.app.activity.ninth.NinthGloryBeActivity;
import com.prayers.app.activity.ninth.NinthHailMaryActivity;
import com.prayers.app.activity.ninth.NinthInitialPrayerActivity;
import com.prayers.app.activity.ninth.NinthJoysActivity;
import com.prayers.app.activity.ninth.NinthOurFatherActivity;
import com.prayers.app.activity.ninth.NinthParagraphActivity;
import com.prayers.app.activity.ninth.NinthSaintJosephPrayerActivity;
import com.prayers.app.activity.ninth.NinthVirginMaryPrayerActivity;
import com.prayers.app.activity.rosary.RosaryApostlesCreedActivity;
import com.prayers.app.activity.rosary.RosaryBeginActivity;
import com.prayers.app.activity.rosary.RosaryCurrentMysteryActivity;
import com.prayers.app.activity.rosary.RosaryEndActivity;
import com.prayers.app.activity.rosary.RosaryFatimaActivity;
import com.prayers.app.activity.rosary.RosaryGloryBeActivity;
import com.prayers.app.activity.rosary.RosaryHailHolyQueenActivity;
import com.prayers.app.activity.rosary.RosaryHailMaryActivity;
import com.prayers.app.activity.rosary.RosaryMysteriesActivity;
import com.prayers.app.activity.rosary.RosaryOurFatherActivity;
import com.prayers.app.utils.RedirectionUtils;

import java.util.HashMap;
import java.util.Map;

public enum PrayerScreen {

    ROSARY_MYSTERIES(       RosaryMysteriesActivity.class,       null,                                RosaryBeginActivity.class),
    ROSARY_BEGIN(           RosaryBeginActivity.class,           RosaryMysteriesActivity.class,       RosaryApostlesCreedActivity.class),
    ROSARY_APOSTLES_CREED(  RosaryApostlesCreedActivity.class,   RosaryBeginActivity.class,           RosaryCurrentMysteryActivity.class),
    ROSARY_CURRENT_MYSTERY( RosaryCurrentMysteryActivity.class,  null,                                RosaryOurFatherActivity.class),
    ROSARY_OUR_FATHER(      RosaryOurFatherActivity.class,       RosaryCurrentMysteryActivity.class,  RosaryHailMaryActivity.class),
    ROSARY_HAIL_MARY(       RosaryHailMaryActivity.class,        RosaryOurFatherActivity.class,       null),
    ROSARY_GLORY_BE(        RosaryGloryBeActivity.class,         RosaryHailMaryActivity.class,        RosaryFatimaActivity.class),
    ROSARY_FATIMA(          RosaryFatimaActivity.class,          RosaryGloryBeActivity.class,         RosaryCurrentMysteryActivity.class),
    ROSARY_HAIL_HOLY_QUEEN( RosaryHailHolyQueenActivity.class,   RosaryHailMaryActivity.class,        RosaryEndActivity.class),
    ROSARY_END(             RosaryEndActivity.class,             RosaryHailHolyQueenActivity.class,   null),

    NINTH_BEGIN(            NinthBeginActivity.class,            null,                                NinthInitialPrayerActivity.class),
    NINTH_INITIAL_PRAYER(   NinthInitialPrayerActivity.class,    NinthBeginActivity.class,            NinthGloryBeActivity.class),
    NINTH_GLORY_BE(         NinthGloryBeActivity.class,          NinthInitialPrayerActivity.class,    NinthConsiderationActivity.class),
    NINTH_CONSIDERATION(    NinthConsiderationActivity.class,    NinthGloryBeActivity.class,          NinthParagraphActivity.class),
    NINTH_PARAGRAPH(        NinthParagraphActivity.class,        NinthConsiderationActivity.class,    NinthVirginMaryPrayerActivity.class),
    NINTH_VIRGIN_MARY(      NinthVirginMaryPrayerActivity.class, NinthParagraphActivity.class,        NinthHailMaryActivity.class),
    NINTH_HAIL_MARY(        NinthHailMaryActivity.class,         NinthVirginMaryPrayerActivity.class, NinthSaintJosephPrayerActivity.class),
    NINTH_SAINT_JOSEPH(     NinthSaintJosephPrayerActivity.class,NinthHailMaryActivity.class,         NinthOurFatherActivity.class),
    NINTH_OUR_FATHER(       NinthOurFatherActivity.class,        NinthSaintJosephPrayerActivity.class,NinthJoysActivity.class),
    NINTH_JOYS(             NinthJoysActivity.class,             NinthOurFatherActivity.class,        NinthChildJesusPrayerActivity.class),
    NINTH_CHILD_JESUS(      NinthChildJesusPrayerActivity.class, NinthJoysActivity.class,             NinthEndActivity.class),
    NINTH_END(              NinthEndActivity.class,              NinthChildJesusPrayerActivity.class, null);

    public final Class<? extends Activity> screen;
    public final Class<? extends Activity> prev;
    public final Class<? extends Activity> next;

    PrayerScreen(Class<? extends Activity> screen,
                 Class<? extends Activity> prev,
                 Class<? extends Activity> next) {
        this.screen = screen;
        this.prev = prev;
        this.next = next;
    }

    private static final Map<Class<?>, PrayerScreen> BY_CLASS = new HashMap<>();
    static {
        for (PrayerScreen s : values()) {
            BY_CLASS.put(s.screen, s);
        }
    }

    public static PrayerScreen of(Class<?> activityClass) {
        PrayerScreen s = BY_CLASS.get(activityClass);
        if (s == null) {
            throw new IllegalStateException("No PrayerScreen registered for " + activityClass.getSimpleName());
        }
        return s;
    }

    public static void goPrev(AbstractClosableActivity from, Bundle bundle) {
        Class<? extends Activity> target = of(from.getClass()).prev;
        if (target == null) {
            throw new IllegalStateException(
                from.getClass().getSimpleName() + " has no static prev — override backAction()");
        }
        RedirectionUtils.redirectToAnotherActivityWithExtras(from, bundle, target);
    }

    public static void goNext(AbstractClosableActivity from, Bundle bundle) {
        Class<? extends Activity> target = of(from.getClass()).next;
        if (target == null) {
            throw new IllegalStateException(
                from.getClass().getSimpleName() + " has no static next — override nextAction()");
        }
        RedirectionUtils.redirectToAnotherActivityWithExtras(from, bundle, target);
    }
}
