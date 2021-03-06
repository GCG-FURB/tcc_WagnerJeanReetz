package br.com.furb.tagarela.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table SYMBOL_PLAN.
*/
public class SymbolPlanDao extends AbstractDao<SymbolPlan, Void> {

    public static final String TABLENAME = "SYMBOL_PLAN";

    /**
     * Properties of entity SymbolPlan.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ServerID = new Property(0, Integer.class, "serverID", false, "SERVER_ID");
        public final static Property PlanID = new Property(1, Integer.class, "planID", false, "PLAN_ID");
        public final static Property SymbolID = new Property(2, Integer.class, "symbolID", false, "SYMBOL_ID");
        public final static Property Position = new Property(3, Integer.class, "position", false, "POSITION");
    };


    public SymbolPlanDao(DaoConfig config) {
        super(config);
    }
    
    public SymbolPlanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'SYMBOL_PLAN' (" + //
                "'SERVER_ID' INTEGER," + // 0: serverID
                "'PLAN_ID' INTEGER," + // 1: planID
                "'SYMBOL_ID' INTEGER," + // 2: symbolID
                "'POSITION' INTEGER);"); // 3: position
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'SYMBOL_PLAN'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, SymbolPlan entity) {
        stmt.clearBindings();
 
        Integer serverID = entity.getServerID();
        if (serverID != null) {
            stmt.bindLong(1, serverID);
        }
 
        Integer planID = entity.getPlanID();
        if (planID != null) {
            stmt.bindLong(2, planID);
        }
 
        Integer symbolID = entity.getSymbolID();
        if (symbolID != null) {
            stmt.bindLong(3, symbolID);
        }
 
        Integer position = entity.getPosition();
        if (position != null) {
            stmt.bindLong(4, position);
        }
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public SymbolPlan readEntity(Cursor cursor, int offset) {
        SymbolPlan entity = new SymbolPlan( //
            cursor.isNull(offset + 0) ? null : cursor.getInt(offset + 0), // serverID
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // planID
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // symbolID
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3) // position
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, SymbolPlan entity, int offset) {
        entity.setServerID(cursor.isNull(offset + 0) ? null : cursor.getInt(offset + 0));
        entity.setPlanID(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setSymbolID(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setPosition(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(SymbolPlan entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(SymbolPlan entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
