package com.example.crysn.goodgame.view;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;

        import com.example.crysn.goodgame.R;

public class TeacherMainMenu extends AppCompatActivity {

    private Button toAchievements;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main_menu);
        toAchievements = findViewById(R.id.students_achievements);
        toAchievements.setOnClickListener(v -> {
            Intent intent;
            intent = new Intent(v.getContext(), StudentsAchievements.class);
            startActivity(intent);
        });
    }

    public void showWords(View view) {
        Intent intent = new Intent(this, EditWordsMenu.class);
        startActivity(intent);
    }
    public void registerStudent(View view) {
        Intent intent = new Intent(this, RegisterStudent.class);
        startActivity(intent);
    }
    public void deleteStudent(View view) {
        Intent intent = new Intent(this, DeleteStudent.class);
        startActivity(intent);
    }
}