package net.ausiasmarch.neptuno.model;

/**
 * RenderGrid.java
 *
 * @author Luis
 */
import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Luis
 */
public class RenderGrid extends JLabel implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        @SuppressWarnings("UnusedAssignment")
        NumberFormat nf = NumberFormat.getInstance();

        setText(value == null ? "" : value.toString());

        setOpaque(true);
        setBackground(table.getBackground());
        setForeground(table.getForeground());

        // Si el objeto que nos pasan es un String, lo ponemos en le JLabel
        if (value instanceof String) {

            setText(" " + value.toString());
            setHorizontalAlignment(SwingConstants.LEFT);
        }

        // Si el objeto que nos pasan es de tipo Number, lo alineamos a la derecha
        if (value instanceof Number) {
            setHorizontalAlignment(SwingConstants.RIGHT);
            setForeground(Color.BLUE);
        }

        if (value instanceof Integer) {
            int valor = Integer.parseInt(value.toString());
            nf = NumberFormat.getInstance();
            setText(nf.format(valor));
            if (valor < 0) {
                setForeground(Color.RED);
            }
        }

        if (value instanceof Long) {
            Long valor = Long.parseLong(value.toString());
            nf = NumberFormat.getInstance();
            setText(nf.format(valor));
            if (valor < 0) {
                setForeground(Color.RED);
            }
        }

        if (value instanceof BigDecimal) {
            BigDecimal valor = new BigDecimal(value.toString());
            BigDecimal cero = new BigDecimal("0");
            nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(2);
            setText(nf.format(valor));
            if (valor.compareTo(cero) < 0) {
                setForeground(Color.RED);
            }
        }

        if (value instanceof Double) {
            Double valor = Double.parseDouble(value.toString());
            nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(2);
            setText(nf.format(valor));
            if (valor < 0.0) {
                setForeground(Color.RED);
            }
        }

        if (value instanceof Date) {
            SimpleDateFormat df;
            df = new SimpleDateFormat("dd/MM/yyyy");
            setText(df.format((Date) value));
        }

        if (value instanceof ImageIcon) {
            ImageIcon icono = (ImageIcon) value;
            setIcon(icono);
            setHorizontalAlignment(SwingConstants.CENTER);
            setText("");

        }

        if (value instanceof Date) {
            setHorizontalAlignment(SwingConstants.CENTER);

        }
        if (row % 2 != 0) {
            setBackground(new Color(225, 225, 225));

        } else {
            setBackground(Color.white);
        }
        if (isSelected) {
            setBackground(Color.BLUE);
            setForeground(Color.WHITE);
        }

        return this;
    }
}
