package com.raywenderlich.placebook.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class PlaceBookDatabase_Impl extends PlaceBookDatabase {
  private volatile BookmarkDao _bookmarkDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Bookmark` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `placeId` TEXT, `name` TEXT NOT NULL, `address` TEXT NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `phone` TEXT NOT NULL, `notes` TEXT NOT NULL, `category` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"4d466ce1a42cb1a91d772bf49a47ff20\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Bookmark`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsBookmark = new HashMap<String, TableInfo.Column>(9);
        _columnsBookmark.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsBookmark.put("placeId", new TableInfo.Column("placeId", "TEXT", false, 0));
        _columnsBookmark.put("name", new TableInfo.Column("name", "TEXT", true, 0));
        _columnsBookmark.put("address", new TableInfo.Column("address", "TEXT", true, 0));
        _columnsBookmark.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0));
        _columnsBookmark.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0));
        _columnsBookmark.put("phone", new TableInfo.Column("phone", "TEXT", true, 0));
        _columnsBookmark.put("notes", new TableInfo.Column("notes", "TEXT", true, 0));
        _columnsBookmark.put("category", new TableInfo.Column("category", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBookmark = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBookmark = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBookmark = new TableInfo("Bookmark", _columnsBookmark, _foreignKeysBookmark, _indicesBookmark);
        final TableInfo _existingBookmark = TableInfo.read(_db, "Bookmark");
        if (! _infoBookmark.equals(_existingBookmark)) {
          throw new IllegalStateException("Migration didn't properly handle Bookmark(com.raywenderlich.placebook.model.Bookmark).\n"
                  + " Expected:\n" + _infoBookmark + "\n"
                  + " Found:\n" + _existingBookmark);
        }
      }
    }, "4d466ce1a42cb1a91d772bf49a47ff20", "e9f1faa77f506184356b466b0093c825");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Bookmark");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Bookmark`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public BookmarkDao bookmarkDao() {
    if (_bookmarkDao != null) {
      return _bookmarkDao;
    } else {
      synchronized(this) {
        if(_bookmarkDao == null) {
          _bookmarkDao = new BookmarkDao_Impl(this);
        }
        return _bookmarkDao;
      }
    }
  }
}
