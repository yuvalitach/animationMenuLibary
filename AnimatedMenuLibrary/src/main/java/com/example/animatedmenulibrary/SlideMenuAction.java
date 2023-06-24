package com.example.animatedmenulibrary;

import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface SlideMenuAction {

//תומך רק בהחלקה שמאלה
  int SLIDE_MODE_LEFT = 1001;
//תומך רק בהחלקה ימינה
  int SLIDE_MODE_RIGHT = 1002;
//תמיכה בהזזה שמאלה והזזה ימינה
  int SLIDE_MODE_LEFT_RIGHT = 1003;
//החלקה שמאלה וימינה אינה נתמכת
  int SLIDE_MODE_NONE = 1004;

  /**
   * set slide mode.(设置Slide模式)
   *
   * @param slideMode {@link #SLIDE_MODE_LEFT},{@link #SLIDE_MODE_LEFT_RIGHT},
   *                  {@link #SLIDE_MODE_RIGHT},{@link #SLIDE_MODE_NONE}
   */
  void setSlideMode(@SlideMode int slideMode);

  /**
   * הגדרת המרחק  מהתצוגה הראשית כאשר תפריט ההזזה הצידי נפתח
   *
   * @param slidePadding pixels
   */
  void setSlidePadding(int slidePadding);

  /**
   * Set the time for the sliding menu to open
   *
   * @param slideTime 单位ms
   */
  void setSlideTime(int slideTime);

  /**
   * Set parallax effect switch
   *
   * @param parallax Parallax effect switch，Default:true
   */
  void setParallaxSwitch(boolean parallax);

  /**
   * Set the transparency of the ContentView when the side menu is opened，This value will change continuously when sliding，Varies from 1.0 to set value.
   *
   * @param contentAlpha 0<contentAlpha<=1.0，A value of 1.0 means that the ContentView has no transparency change when sliding sideways.
   *                     Default:0.5
   */
  void setContentAlpha(@FloatRange(from = 0f, to = 1.0f) float contentAlpha);

  /**
   * Set the shadow color of ContentView during sliding
   *
   * @param color color, default color value：#000000
   */
  void setContentShadowColor(@ColorRes int color);

  /**
   * Set whether the ContentView clicks to close the side-sliding menu when the side-sliding menu is open.
   *
   * @param contentToggle Default:false
   */
  void setContentToggle(boolean contentToggle);

  /**
   * Determine whether to enable the side menu
   *
   * @param allowTogging Default:true
   */
  void setAllowTogging(boolean allowTogging);

  /**
   * Return to the left side view
   *
   * @return {@link View}
   */
  View getSlideLeftView();

  /**
   * Return to the right side
   *
   * @return {@link View}
   */
  View getSlideRightView();

  /**
   * Return to the main view
   *
   * @return {@link View}
   */
  View getSlideContentView();

  /**
   * Open/close the left side menu
   */
  void toggleLeftSlide();

  /**
   * Open the left menu
   */
  void openLeftSlide();

  /**
   * Close the left side menu
   */
  void closeLeftSlide();

  /**
   * Whether the left sliding menu is open
   */
  boolean isLeftSlideOpen();

  /**
   * Open/close right slide menu
   */
  void toggleRightSlide();

  /**
   * Open right slide menu
   */
  void openRightSlide();

  /**
   * Close right slide menu
   */
  void closeRightSlide();

  /**
   * Whether the right slide menu is open
   */
  boolean isRightSlideOpen();

  /**
   * Set the listener for side menu changes
   *
   * @param listener {@link OnSlideChangedListener}
   */
  void addOnSlideChangedListener(OnSlideChangedListener listener);

  /**
   * Slide Mode
   */
  @IntDef({SLIDE_MODE_LEFT, SLIDE_MODE_RIGHT, SLIDE_MODE_LEFT_RIGHT, SLIDE_MODE_NONE})
  @Retention(RetentionPolicy.SOURCE)
  public @interface SlideMode {

  }
}
