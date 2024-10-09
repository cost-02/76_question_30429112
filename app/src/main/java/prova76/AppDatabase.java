package prova76;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SupportFactory;

@Database(entities = {MyEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MyDao myDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    final byte[] passphrase = SQLiteDatabase.getBytes("your_password_here".toCharArray());
                    final SupportFactory factory = new SupportFactory(passphrase);

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, "database-name.db")
                        .openHelperFactory(factory)
                        .build();
                }
            }
        }
        return INSTANCE;
    }
}
