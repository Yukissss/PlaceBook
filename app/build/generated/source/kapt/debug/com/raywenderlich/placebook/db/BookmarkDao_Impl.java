package com.raywenderlich.placebook.db;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.InvalidationTracker.Observer;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.raywenderlich.placebook.model.Bookmark;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public class BookmarkDao_Impl implements BookmarkDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfBookmark;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfBookmark;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfBookmark;

  public BookmarkDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBookmark = new EntityInsertionAdapter<Bookmark>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `Bookmark`(`id`,`placeId`,`name`,`address`,`latitude`,`longitude`,`phone`,`notes`,`category`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Bookmark value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getPlaceId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPlaceId());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddress());
        }
        stmt.bindDouble(5, value.getLatitude());
        stmt.bindDouble(6, value.getLongitude());
        if (value.getPhone() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPhone());
        }
        if (value.getNotes() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNotes());
        }
        if (value.getCategory() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCategory());
        }
      }
    };
    this.__deletionAdapterOfBookmark = new EntityDeletionOrUpdateAdapter<Bookmark>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Bookmark` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Bookmark value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfBookmark = new EntityDeletionOrUpdateAdapter<Bookmark>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `Bookmark` SET `id` = ?,`placeId` = ?,`name` = ?,`address` = ?,`latitude` = ?,`longitude` = ?,`phone` = ?,`notes` = ?,`category` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Bookmark value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getPlaceId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPlaceId());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddress());
        }
        stmt.bindDouble(5, value.getLatitude());
        stmt.bindDouble(6, value.getLongitude());
        if (value.getPhone() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPhone());
        }
        if (value.getNotes() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNotes());
        }
        if (value.getCategory() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCategory());
        }
        if (value.getId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getId());
        }
      }
    };
  }

  @Override
  public long insertBookmark(Bookmark bookmark) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfBookmark.insertAndReturnId(bookmark);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteBookmark(Bookmark bookmark) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfBookmark.handle(bookmark);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateBookmark(Bookmark bookmark) {
    __db.beginTransaction();
    try {
      __updateAdapterOfBookmark.handle(bookmark);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Bookmark>> loadAll() {
    final String _sql = "SELECT * FROM Bookmark ORDER BY name";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Bookmark>>() {
      private Observer _observer;

      @Override
      protected List<Bookmark> compute() {
        if (_observer == null) {
          _observer = new Observer("Bookmark") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfPlaceId = _cursor.getColumnIndexOrThrow("placeId");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfAddress = _cursor.getColumnIndexOrThrow("address");
          final int _cursorIndexOfLatitude = _cursor.getColumnIndexOrThrow("latitude");
          final int _cursorIndexOfLongitude = _cursor.getColumnIndexOrThrow("longitude");
          final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("phone");
          final int _cursorIndexOfNotes = _cursor.getColumnIndexOrThrow("notes");
          final int _cursorIndexOfCategory = _cursor.getColumnIndexOrThrow("category");
          final List<Bookmark> _result = new ArrayList<Bookmark>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Bookmark _item;
            _item = new Bookmark();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpPlaceId;
            _tmpPlaceId = _cursor.getString(_cursorIndexOfPlaceId);
            _item.setPlaceId(_tmpPlaceId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
            final String _tmpAddress;
            _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            _item.setAddress(_tmpAddress);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            _item.setLatitude(_tmpLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            _item.setLongitude(_tmpLongitude);
            final String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            _item.setPhone(_tmpPhone);
            final String _tmpNotes;
            _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            _item.setNotes(_tmpNotes);
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            _item.setCategory(_tmpCategory);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public Bookmark loadBookmark(long bookmarkId) {
    final String _sql = "SELECT * FROM Bookmark WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, bookmarkId);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfPlaceId = _cursor.getColumnIndexOrThrow("placeId");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfAddress = _cursor.getColumnIndexOrThrow("address");
      final int _cursorIndexOfLatitude = _cursor.getColumnIndexOrThrow("latitude");
      final int _cursorIndexOfLongitude = _cursor.getColumnIndexOrThrow("longitude");
      final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("phone");
      final int _cursorIndexOfNotes = _cursor.getColumnIndexOrThrow("notes");
      final int _cursorIndexOfCategory = _cursor.getColumnIndexOrThrow("category");
      final Bookmark _result;
      if(_cursor.moveToFirst()) {
        _result = new Bookmark();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpPlaceId;
        _tmpPlaceId = _cursor.getString(_cursorIndexOfPlaceId);
        _result.setPlaceId(_tmpPlaceId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _result.setName(_tmpName);
        final String _tmpAddress;
        _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        _result.setAddress(_tmpAddress);
        final double _tmpLatitude;
        _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        _result.setLatitude(_tmpLatitude);
        final double _tmpLongitude;
        _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
        _result.setLongitude(_tmpLongitude);
        final String _tmpPhone;
        _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        _result.setPhone(_tmpPhone);
        final String _tmpNotes;
        _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
        _result.setNotes(_tmpNotes);
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        _result.setCategory(_tmpCategory);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<Bookmark> loadLiveBookmark(long bookmarkId) {
    final String _sql = "SELECT * FROM Bookmark WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, bookmarkId);
    return new ComputableLiveData<Bookmark>() {
      private Observer _observer;

      @Override
      protected Bookmark compute() {
        if (_observer == null) {
          _observer = new Observer("Bookmark") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfPlaceId = _cursor.getColumnIndexOrThrow("placeId");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfAddress = _cursor.getColumnIndexOrThrow("address");
          final int _cursorIndexOfLatitude = _cursor.getColumnIndexOrThrow("latitude");
          final int _cursorIndexOfLongitude = _cursor.getColumnIndexOrThrow("longitude");
          final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("phone");
          final int _cursorIndexOfNotes = _cursor.getColumnIndexOrThrow("notes");
          final int _cursorIndexOfCategory = _cursor.getColumnIndexOrThrow("category");
          final Bookmark _result;
          if(_cursor.moveToFirst()) {
            _result = new Bookmark();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _result.setId(_tmpId);
            final String _tmpPlaceId;
            _tmpPlaceId = _cursor.getString(_cursorIndexOfPlaceId);
            _result.setPlaceId(_tmpPlaceId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _result.setName(_tmpName);
            final String _tmpAddress;
            _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            _result.setAddress(_tmpAddress);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            _result.setLatitude(_tmpLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            _result.setLongitude(_tmpLongitude);
            final String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            _result.setPhone(_tmpPhone);
            final String _tmpNotes;
            _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            _result.setNotes(_tmpNotes);
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            _result.setCategory(_tmpCategory);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }
}
