/**
 * SimpleTableModel.java
 * 
 * @author Luis
 */

package net.ausiasmarch.neptuno.model;

import java.util.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class SimpleTableModel extends AbstractTableModel {

    List<List<Object>> _values=new ArrayList<>();
    int _columnCount;
    TableModel _parentTableModel;
    
    
    public SimpleTableModel(TableModel parentTableModel) {
        _parentTableModel=parentTableModel;
        _columnCount=_parentTableModel.getColumnCount();
    }
    
    @Override
    public String getColumnName(int column) {
	return _parentTableModel.getColumnName(column);
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
	return _parentTableModel.getColumnClass(columnIndex);
    }

    /**
     *  Returns false.  This is the default implementation for all cells.
     *
     *  @param  rowIndex  the row being queried
     *  @param  columnIndex the column being queried
     *  @return false
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
	//return _parentTableModel.isCellEditable(rowIndex, columnIndex);
        return false;
    }
    
    
    
    @Override
    public int getRowCount() {
        return _values.size();
    }

    @Override
    public int getColumnCount() {
        return _columnCount;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value;
        
        if (rowIndex>=_values.size()){
            value=null;
        } else if (columnIndex>=_values.get(rowIndex).size()) {
            value=null;
        } else {
            value=_values.get(rowIndex).get(columnIndex);
        }

        return value;
        
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        setValue(rowIndex, columnIndex, aValue);
    }

    public void setValue(int rowIndex, int columnIndex,Object value) {
        if (columnIndex>=_columnCount) {
            _columnCount=columnIndex+1;
        }
        
        while (rowIndex>=_values.size()){
            _values.add(new ArrayList<>());
        }
        
        List<Object> _row=_values.get(rowIndex);
        while (columnIndex>=_row.size()){
            _row.add(null);
        } 
        
        _values.get(rowIndex).set(columnIndex, value);
        
        this.fireTableStructureChanged();
    }

    public void clear() {
        _values=new ArrayList<>();
        fireTableStructureChanged();
    }
    
}
