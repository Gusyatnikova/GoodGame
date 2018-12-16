package com.example.crysn.goodgame.view;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;

        import com.example.crysn.goodgame.R;

public class TeacherMainMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main_menu);
    }

    public void showWords(View view) {
        Intent intent = new Intent(this, EditWordsMenu.class);
        startActivity(intent);
    }
    //
}