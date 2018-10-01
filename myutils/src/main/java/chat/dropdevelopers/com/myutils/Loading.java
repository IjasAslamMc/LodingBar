package chat.dropdevelopers.com.myutils;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class Loading extends LinearLayout implements Animation.AnimationListener {

    private LinearLayout loadingBar;
    private Animation loadingAnimation;
    private int Colos;
    private int Width, Height;

    public Loading(Context context) {
        super(context);
        init();
    }

    public Loading(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context, attrs);

        }

    public Loading(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context, attrs);
    }


  //Animation
    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        loadingBar.startAnimation(loadingAnimation);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    private void init() {
        inflate(getContext(), R.layout.activity_loading, this);
        loadingAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.move);
        loadingBar = findViewById(R.id.loadingBar);
        loadingBar.startAnimation(loadingAnimation);
        loadingAnimation.setAnimationListener(this);
    }

    //View

    private void initViews(Context context, AttributeSet attrs) {

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.LovelyView, 0, 0);
        try {
            // get the text and colors specified using the names in attrs.xml
            Colos = a.getColor(R.styleable.LovelyView_setColor, 0);
            Width = a.getInt(R.styleable.LovelyView_setWidth, 0);
            Height = a.getInt(R.styleable.LovelyView_setHeight, 0);

        } finally {
            a.recycle();
        }

        LayoutInflater.from(context).inflate(R.layout.activity_loading, this);
        loadingBar.setBackgroundColor(Colos);

        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(Width,Height);
        loadingBar.setLayoutParams(parms);
    }


}
