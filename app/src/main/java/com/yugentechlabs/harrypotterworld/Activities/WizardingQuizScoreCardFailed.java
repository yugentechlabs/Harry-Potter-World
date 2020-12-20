package com.yugentechlabs.harrypotterworld.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.yugentechlabs.harrypotterworld.R;

public class WizardingQuizScoreCardFailed extends AppCompatDialogFragment {
    RewardedAd rewardedAd;
    TextView continueBtn,mainMenu, helpText, adText,ortext;
    ImageView adButton;
    int x;
    public static final String AD_UNIT="ca-app-pub-6981984644596212/6670192850";
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity(),R.style.CustomAlertDialog);

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.scorecard_failed,null);


        setCancelable(false);

        super.onCreate(savedInstanceState);

        mainMenu=view.findViewById(R.id.main_menu);
        continueBtn=view.findViewById(R.id.continue_btn);
        helpText=view.findViewById(R.id.help_text);
        adText=view.findViewById(R.id.watch_ad_text);
        ortext=view.findViewById(R.id.or);
        adButton=view.findViewById(R.id.ad_button);
        x=0;

        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),MainActivity.class));
            }
        });

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getContext(),QuizLevels.class));
                getActivity().onBackPressed();
            }
        });
        final int[] errorCode = new int[1];

        // SAMPLE AD ID ca-app-pub-3940256099942544/1033173712
        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                helpText.setVisibility(View.VISIBLE);
                adButton.setVisibility(View.VISIBLE);
                adText.setVisibility(View.VISIBLE);
                ortext.setVisibility(View.VISIBLE);
                adButton.setImageResource(R.drawable.ad_icon);
                adText.setText("Watch an Ad to continue");
            }

            @Override
            public void onRewardedAdFailedToLoad(LoadAdError error) {
                String errorDomain = error.getDomain();
                // Gets the error code. See
                // https://developers.google.com/android/reference/com/google/android/gms/ads/AdRequest#constant-summary
                // for a list of possible codes.
                errorCode[0] = error.getCode();
                // Gets an error message.
                // For example "Account not approved yet". See
                // https://support.google.com/admob/answer/9905175 for explanations of
                // common errors.
                String errorMessage = error.getMessage();
                // Gets additional response information about the request. See
                // https://developers.google.com/admob/android/response-info for more
                // information.
                adButton.setImageResource(R.drawable.no_ads);
                adText.setText("Sorry! No Ads to show at the moment!");
                ortext.setVisibility(View.GONE);
                ResponseInfo responseInfo = error.getResponseInfo();
                // Gets the cause of the error, if available.
                AdError cause = error.getCause();
                // All of this information is available via the error's toString() method.
                Log.d("Ads", error.toString());
            }
        };
        AdRequest ad = new AdRequest.Builder().build();
        rewardedAd = new RewardedAd(getActivity(), AD_UNIT);

        rewardedAd.loadAd(ad, adLoadCallback);



        adButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progress=new ProgressDialog(getContext());
                progress.setCancelable(false);
                progress.show();
                progress.setContentView(R.layout.loading_dialog);
                progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                if (rewardedAd.isLoaded()) {
                    Activity activityContext = getActivity();
                    RewardedAdCallback adCallback = new RewardedAdCallback() {
                        @Override
                        public void onRewardedAdOpened() {
                            progress.dismiss();
                            // Ad opened.
                        }

                        @Override
                        public void onRewardedAdClosed() {
                            // Ad closed.
                            startActivity(new Intent(getContext(),QuizLevels.class));

                        }

                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem reward) {
                            // User earned reward.
                            x=1;
                            dismiss();

                        }

                        @Override
                        public void onRewardedAdFailedToShow(AdError error) {
                            progress.dismiss();
                            // Ad failed to display.
                            int errorCode = error.getCode();
                            if(errorCode==2 || errorCode==0){
                                Toast.makeText(getContext(), "Sorry, we failed to display the Ad! Please check your internet connection.", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(getContext(), "Sorry, we failed to display the Ad! Please try again later.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    };
                    rewardedAd.show(activityContext, adCallback);
                } else {
                    progress.dismiss();
                        //Toast.makeText(getContext(), "Sorry, we failed to display the Ad! Please try again later.", Toast.LENGTH_SHORT).show();
                    if(errorCode[0]==2 || errorCode[0]==0){
                        Toast.makeText(getContext(), "Sorry, we failed to display the Ad! Please check your internet connection.", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getContext(), "Sorry, we failed to display the Ad! Please try again later.", Toast.LENGTH_SHORT).show();
                    }
                    Log.d("TAG", "The rewarded ad wasn't loaded yet.");
                }
            }
        });

        builder.setView(view);
        return builder.create();
    }
}
