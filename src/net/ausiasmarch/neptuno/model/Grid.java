package net.ausiasmarch.neptuno.model;

/**
 * Grid.java
 * 
 * @author Luis
 */

import java.awt.Rectangle;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;

/**
 *
 * @author Luis
 */
public class Grid extends JTable {

    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private DefaultTableCellRenderer defaultTableCellRenderer =
                      new DefaultTableCellRenderer();

    // Constructor
    public SimpleTableModel getSimpleTableModel() {
        try {
            return (SimpleTableModel) super.getModel();
        } catch (Exception ex) {
            super.setModel(new SimpleTableModel(super.getModel()));
            return (SimpleTableModel) super.getModel();
        }
    }

    @Override
    // Establece el valor de una columna en una fila
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        getSimpleTableModel().setValue(rowIndex, columnIndex, value);
    }

    // Limpia el contenido del grid
    public void clear() {
        getSimpleTableModel().clear();
    }

    // Oculta una columna
    public void hideColumn(int column) {
        this.getColumnModel().removeColumn(this.getColumnModel().getColumn(column));
    }

    // Establece los identificadores de las cabecera de columna
    public void setColumnIdentifiers(String[] columns) {
        defaultTableModel.setColumnIdentifiers(columns);
        this.setModel(defaultTableModel);
    }

    //Establece el numero de filas del grid
    public void setNumRows(int numRows) {
        defaultTableModel.setNumRows(numRows);
        this.setModel(defaultTableModel);
    }

    //Establece el ancho de una columna
    public void widthColumn(int indexColumn, int width) {
        getColumnModel().getColumn(indexColumn).setMinWidth(width);
        getColumnModel().getColumn(indexColumn).setMaxWidth(width);
    }

    // Ordena el grid por la columna en la que se hace click
    public void gridRowSorted(TableModel model) {
        TableRowSorter<TableModel> ordena = new TableRowSorter<>(model);
        setRowSorter(ordena);
    }

    // Se mueve a la fila especificada
    public void moveToRow(int row) {
        Rectangle cellRect = this.getCellRect(row, 0, false);
        if (cellRect != null) {
            scrollRectToVisible(cellRect);
            addRowSelectionInterval(row, row);
        }
    }

    // Se mueve a la primera fila
    public void firstRow() {
        moveToRow(0);
    }

    // Se mueve a la ultima fila
    public void lastRow() {
        moveToRow(getRowCount() - 1);
        System.out.println(getSelectedRow());
    }

    // Se mueve a la siguiente fila
    public void nextRow() {
        int row = this.getSelectedRow() + 1;
        if (row < getRowCount()) {
            moveToRow(row);
        }
    }

    // Se mueve a la siguiente fila
    public void previusRow() {
        int row = getSelectedRow() - 1;
        if (row >= 0) {
            moveToRow(row);
        }
    }

    // Obtiene el indice de la columna de la cabecera sobre la que se hizo click
    public int getColumnHeader(MouseEvent evt) {
        //     JTable table = ((JTableHeader) evt.getSource()).getTable();
        TableColumnModel colModel = getColumnModel();

        // El indice de la columna de cabecera en la que se hizo click
        int vColIndex = colModel.getColumnIndexAtX(evt.getX());

        // Return -1 si no se hizo click en una cabecera de columna
        if (vColIndex != -1) {
            return convertColumnIndexToModel(vColIndex) + 1;
        }
        return vColIndex;
    }

    // Obtiene el numero de fila a partir del valor y el numero de una columna
    public int getRowFromColumnValue(Object value, int column) {
        int fila = -1;
        for (int i = 0; i < getRowCount(); i++) {
            if (getValueAt(i, column).equals(value)) {
                fila = i;
                break;
            }
        }
        return fila;
    }

    // Alinea horizontalmente el contenido de una columna
    public void setHorizontalAlignColumn(int column, int aling) {
        defaultTableCellRenderer.setHorizontalAlignment(aling);
        this.getColumnModel().getColumn(column).setCellRenderer(defaultTableCellRenderer);
    }

    // Alinea verticalmente el contenido de una columna
    public void setVerticalAlignColumn(int column, int aling) {
        defaultTableCellRenderer.setVerticalAlignment(aling);
        this.getColumnModel().getColumn(column).setCellRenderer(defaultTableCellRenderer);
    }

    // Oculta o hace visible el contenido de una columna
    public void setVisibleColumn(int column, boolean flag) {
        defaultTableCellRenderer.setVisible(flag);
        this.getColumnModel().getColumn(column).setCellRenderer(defaultTableCellRenderer);
    }
}
