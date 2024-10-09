package main.java.prova76;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = AppDatabase.getInstance(getApplicationContext());
        MyEntity entity = new MyEntity();
        entity.data = "Esempio di dati";
        db.myDao().insertAll(entity);

        List<MyEntity> entities = db.myDao().getAll();
        // Usa 'entities' come necessario, ad esempio visualizzandoli in un'interfaccia utente
    }
}
