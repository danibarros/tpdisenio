package external.utils;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.event.TableModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

import edu.core.entities.Banda;
import edu.organizador.gui.VentanaAlertDecorator;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TablaOrdenBandas extends JFrame implements TableModelListener, ActionListener
{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2122919742115350637L;
	ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    MyTableModel model1;
    JTable table1;
    Container c;
    boolean pause = true;
    JPanel pnlBottom;
    List<Banda> bandas;
	
 
    public List<Banda> dibujar(List<Banda> bandas)
    {
    	this.bandas = bandas;
    	c  = getContentPane();
    	pnlBottom = new JPanel();
    	int i = 0;
    	
    	for (Banda banda : bandas) {
    		ArrayList<String> datos = new ArrayList<String>();
    		String nombre = bandas.get(i).getNombre();
    		i++;
    		datos.add(String.valueOf(i));
    		datos.add(nombre);
    		data.add(datos);
		}
    	
		JButton btnComprar = new JButton();
		btnComprar.setName("ordenar");
		btnComprar.setText("Ordenar Bandas");
		btnComprar.addActionListener(this);
    	
        setTitle("JTables");
        pnlBottom.add(btnComprar);
        c.setLayout(new GridLayout(2,1));
        model1 = new MyTableModel("table1");
        table1 = new JTable(model1);
        model1.addTableModelListener(this);
        JScrollPane jsTable1 = new JScrollPane(table1);
        c.add(jsTable1);
        c.add(pnlBottom);
        setSize(500,300);
        this.setVisible(true);
		
		return bandas;
    }
    @Override
    public void tableChanged(TableModelEvent evt)
    {
        AbstractTableModel model = (MyTableModel)evt.getSource();
            table1.repaint();
    }
    
    public ArrayList<ArrayList<String>> readData(ArrayList<ArrayList<String>> data)
    {
        return data;
    }
    
    private class MyTableModel extends AbstractTableModel
    {
        /**
		 * 
		 */
		private static final long serialVersionUID = -2136795410228169159L;
		String columns[] ;
        String sTableName;
        public MyTableModel(String tableName)
        {
            sTableName = tableName;
            if ("table1".equals(sTableName))
            {
                columns = new String[] {"Orden","Banda"};
            }
        }
        @Override
        public String getColumnName(int columnIndex)
        {
            return columns[columnIndex];
        }
        @Override
        public int getRowCount()
        {
            return data.size();
        }
        @Override 
        public int getColumnCount()
        {
            return columns.length;
        }
        @Override
        public Object getValueAt(int row, int col)
        {
            return data.get(row).get(col);
        }
        @Override
        public void setValueAt(Object aValue, int rowIndex, int colIndex)
        {
            data.get(rowIndex).set(colIndex,(String)aValue);
            fireTableCellUpdated(rowIndex,colIndex);
        }
        @Override
        public boolean isCellEditable(int row, int col)
        {
            return true;
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {

		String event = e.getActionCommand();
		switch (event) {
		case "Ordenar Bandas":
			JButton btn = (JButton) e.getSource();
			if(validarDatos()){
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.dibujar();
				data.clear();
				this.getContentPane().removeAll();
				dibujar(bandas);
			}else{
				pause = false;
			}
			break;
		default:
			break;
		}
	
    }
	
	private boolean validarDatos(){
		List<Integer> orden = new ArrayList<Integer>();
		for(ArrayList<String> dato : data){
			orden.add(Integer.valueOf(dato.get(0)));
		}
		Set<Integer> set = new HashSet<Integer>(orden);
		
		if(set.size() < orden.size()){
		    return false;
		}else{
			return true;
		}
	}
	
	private void ordenarBandas(){
		int cantBandas = bandas.size();
		List<Banda> bandasDup = bandas;
		int i;
		int menor = cantBandas + 1;
		int numeroBanda = 0;
		for (i = 0;i<cantBandas;i++){
			for(ArrayList<String> datos : data){
				if (menor > Integer.valueOf(datos.get(0))){
					menor = Integer.valueOf(datos.get(0));
					for (Banda banda : bandas){
						if (datos.get(1).equals(banda.getNombre()))
							numeroBanda = bandas.indexOf(banda);
					}
				}
			}
			bandasDup.add(bandas.get(numeroBanda - 1));
		}
		bandas = bandasDup;
	}
}