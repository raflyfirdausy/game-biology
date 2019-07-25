package id.raflyfirdausy.biologyst;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;

public class InGameActivity extends AppCompatActivity {

    private TextView tvLevel;
    private TextView tvMyPoint;
    private TextView tvTimer;
    private TextView tvPoint;
    private RoundCornerProgressBar progress;
    private TextView tvSoal;
    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;
    private TextView fiftyFifty;
    private TextView telp;
    private TextView ask;

    private CountDownTimer countDownTimer;
    private AlertDialog.Builder dialog;
    private LayoutInflater inflater;
    private View dialogView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.red_dark));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_in_game);

        tvLevel = findViewById(R.id.tvLevel);
        tvMyPoint = findViewById(R.id.tvMyPoint);
        tvTimer = findViewById(R.id.tvTimer);
        tvPoint = findViewById(R.id.tvPoint);
        progress = findViewById(R.id.progress);
        tvSoal = findViewById(R.id.tvSoal);
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        fiftyFifty = findViewById(R.id.fiftyFifty);
        telp = findViewById(R.id.telp);
        ask = findViewById(R.id.ask);

        countDownTimer = new CountDownTimer(31000, 1000) {
            public void onTick(long millisUntilFinished) {
                long berapaDetikLagi = millisUntilFinished / 1000;
                float persen = (float) berapaDetikLagi / 30 * 100;

                if (persen > 75) {
                    progress.setProgressColor(getResources().getColor(R.color.greenMuda));
                } else if (persen > 40) {
                    progress.setProgressColor(getResources().getColor(R.color.colorBlueDark));
                } else {
                    progress.setProgressColor(getResources().getColor(R.color.red_accent));
                }

                progress.setProgress(persen);
                tvTimer.setText(String.valueOf(berapaDetikLagi));
            }

            public void onFinish() {
                tvLevel.setText("Game Over!");
                showGameOver("Waktu habis!");
            }
        };
        countDownTimer.start();

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetWarnaPilihan();
                btnA.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red_accent)));
                showGameOver("Jawaban kamu salah!");
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetWarnaPilihan();
                btnB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.greenMuda)));
                showWin();
                tvMyPoint.setText(String.valueOf(Integer.parseInt(tvMyPoint.getText().toString()) + 12));
                tvLevel.setText(String.valueOf(Integer.parseInt(tvLevel.getText().toString()) + 1));
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetWarnaPilihan();
                btnC.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red_accent)));
                showGameOver("Jawaban kamu salah!");
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetWarnaPilihan();
                btnD.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red_accent)));
                showGameOver("Jawaban kamu salah!");
            }
        });

        fiftyFifty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFifty();
            }
        });

        telp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTelp();
            }
        });

        ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAsk();
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void showAsk(){
        ask.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
        ask.setTextColor(getResources().getColor(R.color.white));
        ask.setClickable(false);

        dialog = new AlertDialog.Builder(InGameActivity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.layout_ask, null);
        dialog.setView(dialogView);
        dialog.setCancelable(false);

        final AlertDialog alertDialog = dialog.create();

        RelativeLayout btnOK = dialogView.findViewById(R.id.btnOK);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });


        alertDialog.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void showTelp() {
        telp.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
        telp.setTextColor(getResources().getColor(R.color.white));
        telp.setClickable(false);

        dialog = new AlertDialog.Builder(InGameActivity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.layout_telp, null);
        dialog.setView(dialogView);
        dialog.setCancelable(false);

        final AlertDialog alertDialog = dialog.create();

        RelativeLayout btnOK = dialogView.findViewById(R.id.btnOK);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });


        alertDialog.show();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void showFifty() {
        btnA.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.gray_tua)));
        btnB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBlueDark)));
        btnC.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.gray_tua)));
        btnD.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBlueDark)));

        btnA.setClickable(false);
        btnC.setClickable(false);

        fiftyFifty.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
        fiftyFifty.setTextColor(getResources().getColor(R.color.white));
        fiftyFifty.setClickable(false);
    }

    private void showGameOver(String penyebab) {
        countDownTimer.cancel();
        dialog = new AlertDialog.Builder(InGameActivity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.layout_game_over, null);
        dialog.setView(dialogView);
        dialog.setCancelable(false);

        RelativeLayout btnUlangi = dialogView.findViewById(R.id.btnUlangi);
        RelativeLayout btnKeluar = dialogView.findViewById(R.id.btnKeluar);
        TextView tvPenyebab = dialogView.findViewById(R.id.tvPenyebab);
        tvPenyebab.setText(penyebab);

        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InGameActivity.this, MainActivity.class));
                finish();
            }
        });

        btnUlangi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InGameActivity.this, InGameActivity.class));
                finish();
            }
        });

        dialog.show();
    }

    private void showWin(){
        countDownTimer.cancel();
        dialog = new AlertDialog.Builder(InGameActivity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.layout_jawaban_benar, null);
        dialog.setView(dialogView);
        dialog.setCancelable(false);

        final AlertDialog alertDialog = dialog.create();

        RelativeLayout btnLanjut = dialogView.findViewById(R.id.btnLanjut);
        RelativeLayout btnKeluar = dialogView.findViewById(R.id.btnKeluar);

        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InGameActivity.this, MainActivity.class));
                finish();
            }
        });

        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                resetWarnaPilihan();
                alertDialog.dismiss();
                countDownTimer = new CountDownTimer(31000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        long berapaDetikLagi = millisUntilFinished / 1000;
                        float persen = (float) berapaDetikLagi / 30 * 100;

                        if (persen > 75) {
                            progress.setProgressColor(getResources().getColor(R.color.greenMuda));
                        } else if (persen > 40) {
                            progress.setProgressColor(getResources().getColor(R.color.colorBlueDark));
                        } else {
                            progress.setProgressColor(getResources().getColor(R.color.red_accent));
                        }

                        progress.setProgress(persen);
                        tvTimer.setText(String.valueOf(berapaDetikLagi));
                    }

                    public void onFinish() {
                        tvLevel.setText("Game Over!");
                        showGameOver("Waktu habis!");
                    }
                };
                countDownTimer.start();
            }
        });

        alertDialog.show();
    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void resetWarnaPilihan() {
        btnA.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBlueDark)));
        btnB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBlueDark)));
        btnC.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBlueDark)));
        btnD.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBlueDark)));
    }
}
