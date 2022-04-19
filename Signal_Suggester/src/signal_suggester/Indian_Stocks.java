
package signal_suggester;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Live implements Runnable{
    String[] Ticker = null;
    int FirstMA = 0;
    int SecondMA = 0;
    int TimeFrame = 0;
    String Interval = null;
    String SMA_EMA = null;
    DefaultTableModel tableModel = null;
    Live(String[] Ticker, int FirstMA, int SecondMA, int TimeFrame, String Interval, String SMA_EMA, DefaultTableModel tableModel)
    {
        this.Ticker = Ticker;
        this.FirstMA = FirstMA;
        this.SecondMA = SecondMA;
        this.TimeFrame = TimeFrame;
        this.Interval = Interval;
        this.SMA_EMA = SMA_EMA;
        this.tableModel = tableModel;
    }
    @Override
    public void run()
    {
        Signal obj = new Signal();
        if(SMA_EMA.equals("Both"))
        {
            for(String s : Ticker)
            {
                try
                {
                    obj.fetch_data(s.concat(".NS"), TimeFrame, Interval);
                    obj.sma_calculate(FirstMA, SecondMA);
                    obj.ema_calculate(FirstMA, SecondMA);
                    obj.SMA_Signal_Find();
                    obj.EMA_Signal_Find();
                    obj.Final_Signal_Find();
                    tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, s, obj.close_price.get(obj.close_price.size() - 1), obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.Final_Signal});
                }
                catch(Exception e1)
                {
                    obj.Clear_Previous();
                    try
                    {
                        obj.fetch_data(s.concat(".BO"), TimeFrame, Interval);
                        obj.sma_calculate(FirstMA, SecondMA);
                        obj.ema_calculate(FirstMA, SecondMA);
                        obj.SMA_Signal_Find();
                        obj.EMA_Signal_Find();
                        obj.Final_Signal_Find();
                        tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, s, obj.close_price.get(obj.close_price.size() - 1), obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.Final_Signal});
                    }
                    catch(Exception e2)
                    {
                        obj.Clear_Previous();
                    }
                }
            }
        }
        else if(SMA_EMA.equals("SMA"))
        {
            for(String s : Ticker)
            {
                try
                {
                    obj.fetch_data(s.concat(".NS"), TimeFrame, Interval);
                    obj.sma_calculate(FirstMA, SecondMA);
                    obj.SMA_Signal_Find();
                    tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, obj.close_price.get(obj.close_price.size() - 1), obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), null, obj.SMA_Signal.get(obj.SMA_Signal.size() - 1)});
                }
                catch(Exception e1)
                {
                    obj.Clear_Previous();
                    try
                    {
                        obj.fetch_data(s.concat(".BO"), TimeFrame, Interval);
                        obj.sma_calculate(FirstMA, SecondMA);
                        obj.SMA_Signal_Find();
                        tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, obj.close_price.get(obj.close_price.size() - 1), obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), null, obj.SMA_Signal.get(obj.SMA_Signal.size() - 1)});
                    }
                    catch(Exception e2)
                    {
                        obj.Clear_Previous();
                    }
                }
            }
        }
        else
        {
            for(String s : Ticker)
            {
                try
                {
                    obj.fetch_data(s.concat(".NS"), TimeFrame, Interval);
                    obj.sma_calculate(FirstMA, SecondMA);
                    obj.SMA_Signal_Find();
                    tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, obj.close_price.get(obj.close_price.size() - 1), null, obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1)});
                }
                catch(Exception e1)
                {
                    obj.Clear_Previous();
                    try
                    {
                        obj.fetch_data(s.concat(".BO"), TimeFrame, Interval);
                        obj.sma_calculate(FirstMA, SecondMA);
                        obj.SMA_Signal_Find();
                        tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, obj.close_price.get(obj.close_price.size() - 1), null, obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1)});
                    }
                    catch(Exception e2)
                    {
                        obj.Clear_Previous();
                    }
                }
            }            
        }
    }
}
public class Indian_Stocks implements ActionListener{
    Connection con= null;
    Statement stmt = null;
    
    String currentOption = "Ticker";
    JFrame frame = new JFrame();
    JMenuBar menubar;
    JMenu historical, live;
    JMenuItem historicalByTicker, historicalByIndex, liveByTicker, liveByIndex;
    JLabel intro, enterTicker, selectIndex, hint, optional, basedOn, timeFrame, maPeriod, interval;
    JTextField inputTicker;
    JCheckBox sma, ema;
    JSpinner firstMA, secondMA;
    SpinnerNumberModel fmavalues, smavalues;
    JComboBox time_Frame, Interval;
    JButton historicalShow, liveShow;
    JTable resultContainer;
    DefaultTableModel tableModel;
    JScrollPane scrollResult;
    Indian_Stocks()
    {
        intro = new JLabel("Suggest By Ticker");
        intro.setFont(new Font("Ariel", Font.BOLD, 24));
        intro.setBounds(0, 30, 800, 30);
        intro.setHorizontalAlignment(JLabel.CENTER);
        enterTicker = new JLabel("Enter Ticker: ");
        selectIndex = new JLabel("Select Index: ");
        hint = new JLabel("To add multiple Ticker add coma (,) Eg.(TCS, INFY)");
        optional = new JLabel("Optional: ");
        basedOn = new JLabel("Based on: ");
        timeFrame = new JLabel("Time Frame: ");
        String[] timeFrame_values = {"1month", "3month", "6month", "1year", "2year", "3year", "5year"};
        time_Frame = new JComboBox(timeFrame_values);
        interval = new JLabel("Interval: ");
        String[] interval_values = {"1min", "5min", "15min", "30min", "1hr", "1.5hr", "1day", "5day", "1week", "1month", "3month"};
        Interval = new JComboBox(interval_values);
        maPeriod = new JLabel("MA Period: ");
        fmavalues = new SpinnerNumberModel(1, 1, null, 1);
        smavalues = new SpinnerNumberModel(1, 1, null, 1);
        firstMA = new JSpinner(fmavalues);
        secondMA = new JSpinner(smavalues);
        enterTicker.setFont(new Font("Ariel", Font.BOLD, 18));
        selectIndex.setFont(new Font("Ariel", Font.BOLD, 18));
        hint.setFont(new Font("Ariel", Font.PLAIN, 12));
        basedOn.setFont(new Font("Ariel", Font.PLAIN, 16));
        timeFrame.setFont(new Font("Ariel", Font.PLAIN, 16));
        time_Frame.setFont(new Font("Ariel", Font.PLAIN, 16));
        maPeriod.setFont(new Font("Ariel", Font.PLAIN, 16));
        firstMA.setFont(new Font("Ariel", Font.PLAIN, 16));
        secondMA.setFont(new Font("Ariel", Font.PLAIN, 16));
        interval.setFont(new Font("Ariel", Font.PLAIN, 16));
        Interval.setFont(new Font("Ariel", Font.PLAIN, 16));
        optional.setFont(new Font("Ariel", Font.BOLD, 18));
        time_Frame.setFont(new Font("Ariel", Font.PLAIN, 16));
        enterTicker.setBounds(150, 100, 150, 20);
        hint.setBounds(300, 130, 400, 20);
        selectIndex.setBounds(150, 100, 150, 20);
        optional.setBounds(150, 160, 150, 20);
        basedOn.setBounds(300, 160, 90, 20);
        maPeriod.setBounds(300, 190, 90, 20);
        firstMA.setBounds(415, 190, 60, 20);
        secondMA.setBounds(490, 190, 60, 20);
        timeFrame.setBounds(300, 220, 110, 20);
        time_Frame.setBounds(415, 220, 100, 25);
        interval.setBounds(300, 250, 110, 20);
        Interval.setBounds(415, 250, 100, 25);
        
        firstMA.setValue(20);
        secondMA.setValue(50);
        time_Frame.setSelectedIndex(4);
        Interval.setSelectedIndex(6);
        
        inputTicker = new JTextField();
        inputTicker.setFont(new Font("Ariel", Font.PLAIN, 16));
        inputTicker.setBounds(300, 100, 275, 20);
        
        sma = new JCheckBox("SMA");
        ema = new JCheckBox("EMA");
        sma.setFont(new Font("Ariel", Font.PLAIN, 16));
        ema.setFont(new Font("Ariel", Font.PLAIN, 16));
        sma.setBounds(415, 160, 60, 20);
        ema.setBounds(490, 160, 70, 20);
        sma.setSelected(true);
        ema.setSelected(true);
        
        historicalShow = new JButton("Show");
        liveShow = new JButton("Show");
        historicalShow.setFont(new Font("Ariel", Font.BOLD, 18));
        liveShow.setFont(new Font("Ariel", Font.BOLD, 18));
        historicalShow.setBounds(300, 300, 100, 30);
        liveShow.setBounds(300, 300, 100, 30);
        
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Date");
        tableModel.addColumn("Ticker");
        tableModel.addColumn("Price");
        tableModel.addColumn("SMA Signal");
        tableModel.addColumn("EMA Signal");
        tableModel.addColumn("Final Signal");
        resultContainer = new JTable(tableModel);
        resultContainer.getColumnModel().getColumn(1).setPreferredWidth(100);
        resultContainer.setFont(new Font("Ariel", Font.BOLD, 12));
        scrollResult = new JScrollPane(resultContainer);
        scrollResult.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        resultContainer.setDefaultEditor(Object.class, null);
        scrollResult.setBounds(10, 350, 770, 280);
        
        historicalShow.addActionListener(this);
        liveShow.addActionListener(this);
        
        selectIndex.setVisible(false);
        liveShow.setVisible(false);
        
        menubar = new JMenuBar();
        historical = new JMenu("Historical");
        live = new JMenu("Live");
        historicalByTicker = new JMenuItem("By Ticker");
        liveByTicker= new JMenuItem("By Ticker");
        historicalByIndex = new JMenuItem("By Index");
        liveByIndex = new JMenuItem("By Index");
        historical.add(historicalByTicker);
        live.add(liveByTicker);
        historical.add(historicalByIndex);
        live.add(liveByIndex);
        
        historicalByTicker.addActionListener(this);
        liveByTicker.addActionListener(this);
        historicalByIndex.addActionListener(this);
        liveByIndex.addActionListener(this);
        sma.addActionListener(this);
        ema.addActionListener(this);
        
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/signal_suggester", "root", "root");
            stmt = con.createStatement();
        }
        catch(SQLException e){}
        menubar.add(historical);
        menubar.add(live);
        frame.setJMenuBar(menubar);
        frame.add(intro);
        frame.add(enterTicker);
        frame.add(inputTicker);
        frame.add(selectIndex);
        frame.add(hint);
        frame.add(optional);
        frame.add(basedOn);
        frame.add(sma);
        frame.add(ema);
        frame.add(maPeriod);
        frame.add(firstMA);
        frame.add(secondMA);
        frame.add(timeFrame);
        frame.add(time_Frame);
        frame.add(interval);
        frame.add(Interval);
        frame.add(historicalShow);
        frame.add(liveShow);
        frame.add(scrollResult);
        frame.setSize(800,700);
        frame.setTitle("Signal Suggester - Indian Stocks");
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Signal_Suggester.main(null);
                
                try
                {
                    if(con != null)
                    {
                        con.close();
                    }
                }
                catch(SQLException e1){}
                frame.dispose();
            }
        });
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == historicalByTicker)
        {
            intro.setText("Suggest By Ticker");
            currentOption = "Ticker";
            enterTicker.setVisible(true);
            selectIndex.setVisible(false);
            hint.setVisible(true);
            inputTicker.setVisible(true);
            historicalShow.setVisible(true);
            liveShow.setVisible(false);
        }
        else if(e.getSource() == historicalByIndex)
        {
            intro.setText("Suggest By Index");
            currentOption = "Index";
            enterTicker.setVisible(false);
            selectIndex.setVisible(true);
            hint.setVisible(false);
            inputTicker.setVisible(false);
            historicalShow.setVisible(true);
            liveShow.setVisible(false);
        }
        else if(e.getSource() == liveByTicker)
        {
            intro.setText("Suggest By Ticker");
            currentOption = "Ticker";
            enterTicker.setVisible(true);
            selectIndex.setVisible(false);
            hint.setVisible(true);
            inputTicker.setVisible(true);
            historicalShow.setVisible(false);
            liveShow.setVisible(true);
        }
        else if(e.getSource() == liveByIndex)
        {
            intro.setText("Suggest By Index");
            currentOption = "Index";
            enterTicker.setVisible(false);
            selectIndex.setVisible(true);
            hint.setVisible(false);
            inputTicker.setVisible(false);
            historicalShow.setVisible(false);
            liveShow.setVisible(true);
        }
        else if(e.getSource() == historicalShow)
        {
            if(currentOption.equals("Ticker"))
            {
                String Ticker = inputTicker.getText().trim().toUpperCase();
                String isSMA = null;
                String isEMA = null;
                if(sma.isSelected())
                {
                    isSMA = "Yes";
                }
                if(ema.isSelected())
                {
                    isEMA = "Yes";
                }
                if(isSMA == null && isEMA == null)
                {
                    JOptionPane.showMessageDialog(null, "Select atleast one from SMA or EMA");
                }
                int FirstMA = (Integer) firstMA.getValue();
                int SecondMA = (Integer) secondMA.getValue();
                int TimeFrame = time_Frame.getSelectedIndex();
                int FinalTimeFrame = 0;
                switch(TimeFrame)
                {
                    case 0: FinalTimeFrame = 30; break;
                    case 1: FinalTimeFrame = (30 * 3); break;
                    case 2: FinalTimeFrame = (30 * 6); break;
                    case 3: FinalTimeFrame = 365; break;
                    case 4: FinalTimeFrame = (365 * 2); break;
                    case 5: FinalTimeFrame = (365 * 3); break;
                    case 6: FinalTimeFrame = (365 * 5); break;
                }
                int tempInterval = Interval.getSelectedIndex();
                String finalInterval = null;
                switch(tempInterval)
                {
                    case 0: finalInterval = "1m"; break;
                    case 1: finalInterval = "5m"; break;
                    case 2: finalInterval = "15m"; break;
                    case 3: finalInterval = "30m"; break;
                    case 4: finalInterval = "1h"; break;
                    case 5: finalInterval = "90m"; break;
                    case 6: finalInterval = "1d"; break;
                    case 7: finalInterval = "5d"; break;
                    case 8: finalInterval = "1wk"; break;
                    case 9: finalInterval = "1mo"; break;
                    case 10: finalInterval = "3mo"; break;
                }
                Signal obj = new Signal();
                String[] List = null;
                if(Ticker.contains(","))
                {
                    List = Ticker.split(",");
                    for(int i = 0; i < List.length; i++)
                    {
                        List[i] = List[i].trim().toUpperCase();
                    }
                }
                if(sma.isSelected() && ema.isSelected())
                {
                    try
                    {
                        if(Ticker.contains(","))
                        {
                            for(String s : List)
                            {
                                try
                                {
                                    obj.fetch_data(s.concat(".NS"), FinalTimeFrame, finalInterval);
                                    obj.sma_calculate(FirstMA, SecondMA);
                                    obj.ema_calculate(FirstMA, SecondMA);
                                    obj.SMA_Signal_Find();
                                    obj.EMA_Signal_Find();
                                    obj.Final_Signal_Find();
                                    tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, s, obj.close_price.get(obj.close_price.size() - 1), obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.Final_Signal});
                                }
                                catch(Exception e1)
                                { 
                                    obj.Clear_Previous();
                                    try
                                    {
                                        obj.fetch_data(s.concat(".BO"), FinalTimeFrame, finalInterval);
                                        obj.sma_calculate(FirstMA, SecondMA);
                                        obj.ema_calculate(FirstMA, SecondMA);
                                        obj.SMA_Signal_Find();
                                        obj.EMA_Signal_Find();
                                        obj.Final_Signal_Find();
                                        tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, s, obj.close_price.get(obj.close_price.size() - 1), obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.Final_Signal});
                                    }
                                    catch(Exception e2)
                                    {
                                        obj.Clear_Previous();
                                        JOptionPane.showMessageDialog(null, "Enter Valid Ticker");
                                    }
                                }
                            }
                        }
                        else
                        {
                            try
                            {
                                obj.fetch_data(Ticker.concat(".NS"), FinalTimeFrame, finalInterval);
                                obj.sma_calculate(FirstMA, SecondMA);
                                obj.ema_calculate(FirstMA, SecondMA);
                                obj.SMA_Signal_Find();
                                obj.EMA_Signal_Find();
                                obj.Final_Signal_Find();
                                System.out.println(Ticker + "\n" + obj.close_price.get(obj.close_price.size() - 1) + "\n" + obj.SMA_Signal.get(obj.SMA_Signal.size() - 1) + "\n" + obj.EMA_Signal.get(obj.EMA_Signal.size() - 1) + "\n" + obj.Final_Signal);
                                tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, obj.close_price.get(obj.close_price.size() - 1), obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.Final_Signal});
                            }
                            catch(Exception e1)
                            {
                                obj.Clear_Previous();
                                try
                                {
                                    obj.fetch_data(Ticker.concat(".BO"), FinalTimeFrame, finalInterval);
                                    obj.sma_calculate(FirstMA, SecondMA);
                                    obj.ema_calculate(FirstMA, SecondMA);
                                    obj.SMA_Signal_Find();
                                    obj.EMA_Signal_Find();
                                    obj.Final_Signal_Find();
                                    System.out.println(Ticker + "\n" + obj.close_price.get(obj.close_price.size() - 1) + "\n" + obj.SMA_Signal.get(obj.SMA_Signal.size() - 1) + "\n" + obj.EMA_Signal.get(obj.EMA_Signal.size() - 1) + "\n" + obj.Final_Signal);
                                    tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, obj.close_price.get(obj.close_price.size() - 1), obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.Final_Signal});
                                }
                                catch(Exception e2)
                                {
                                    JOptionPane.showMessageDialog(null, "Enter Valid Ticker");
                                }
                            }
                        }
                    }
                    catch(HeadlessException e1)
                    {
                        JOptionPane.showMessageDialog(null, "Something went wrong");
                    }
                    finally
                    {
                        obj.Clear_Previous();
                        inputTicker.setText("");
                        firstMA.setValue(20);
                        secondMA.setValue(50);
                        sma.setSelected(true);
                        ema.setSelected(true);
                        time_Frame.setSelectedIndex(4);
                        Interval.setSelectedIndex(6);
                    }
                }
                else if(sma.isSelected())
                {
                    try
                    {
                        if(Ticker.contains(","))
                        {
                            for(String s : List)
                            {
                                try
                                {
                                    obj.fetch_data(s.concat(".NS"), FinalTimeFrame, finalInterval);
                                    obj.sma_calculate(FirstMA, SecondMA);
                                    obj.SMA_Signal_Find();
                                    tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, obj.close_price.get(obj.close_price.size() - 1), obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), null, obj.SMA_Signal.get(obj.SMA_Signal.size() - 1)});
                                }
                                catch(Exception e1)
                                {
                                    obj.Clear_Previous();
                                    try
                                    {
                                        obj.fetch_data(s.concat(".BO"), FinalTimeFrame, finalInterval);
                                        obj.sma_calculate(FirstMA, SecondMA);
                                        obj.SMA_Signal_Find();
                                        tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, obj.close_price.get(obj.close_price.size() - 1), obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), null, obj.SMA_Signal.get(obj.SMA_Signal.size() - 1)});
                                    }
                                    catch(Exception e2)
                                    {
                                        JOptionPane.showMessageDialog(null, "Enter valid Ticker");
                                    }
                                }
                            }
                        }
                        else
                        {
                            try
                            {
                                obj.fetch_data(Ticker.concat(".NS"), FinalTimeFrame, finalInterval);
                                obj.sma_calculate(FirstMA, SecondMA);
                                obj.SMA_Signal_Find();
                                tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, obj.close_price.get(obj.close_price.size() - 1), obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), null, obj.SMA_Signal.get(obj.SMA_Signal.size() - 1)});
                            }
                            catch(Exception e1)
                            {
                                obj.Clear_Previous();
                                try
                                {
                                    obj.fetch_data(Ticker.concat(".BO"), FinalTimeFrame, finalInterval);
                                    obj.sma_calculate(FirstMA, SecondMA);
                                    obj.SMA_Signal_Find();
                                    tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, obj.close_price.get(obj.close_price.size() - 1), obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), null, obj.SMA_Signal.get(obj.SMA_Signal.size() - 1)});
                                }
                                catch(Exception e2)
                                {
                                    JOptionPane.showMessageDialog(null, "Enter valid Ticker");
                                }
                            }
                        }
                    }
                    catch(HeadlessException e1)
                    {
                        JOptionPane.showMessageDialog(null, "Something went wrong");
                    }
                    finally
                    {
                        obj.Clear_Previous();
                        inputTicker.setText("");
                        firstMA.setValue(20);
                        secondMA.setValue(50);
                        sma.setSelected(true);
                        ema.setSelected(true);
                        time_Frame.setSelectedIndex(4);
                        Interval.setSelectedIndex(6);
                    }
                }
                else if(ema.isSelected())
                {
                    try
                    {
                        if(Ticker.contains(","))
                        {
                            for(String s : List)
                            {
                                try
                                {
                                    obj.fetch_data(s.concat(".NS"), FinalTimeFrame, finalInterval);
                                    obj.ema_calculate(FirstMA, SecondMA);
                                    obj.EMA_Signal_Find();  
                                    tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, obj.close_price.get(obj.close_price.size() - 1), null, obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1)});
                                }
                                catch(Exception e1)
                                {
                                    obj.Clear_Previous();
                                    try
                                    {
                                        obj.fetch_data(s.concat(".BO"), FinalTimeFrame, finalInterval);
                                        obj.ema_calculate(FirstMA, SecondMA);
                                        obj.EMA_Signal_Find();
                                        tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, obj.close_price.get(obj.close_price.size() - 1), null, obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1)});
                                    }
                                    catch(Exception e2)
                                    {
                                        JOptionPane.showMessageDialog(null, "Enter valid Ticker");
                                    }

                                }
                            }
                        }
                        else
                        {
                            try
                            {
                                obj.fetch_data(Ticker.concat(".NS"), FinalTimeFrame, finalInterval);
                                obj.ema_calculate(FirstMA, SecondMA);
                                obj.EMA_Signal_Find();
                                tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, obj.close_price.get(obj.close_price.size() - 1), null, obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1)});
                            }
                            catch(Exception e1)
                            {
                                obj.Clear_Previous();
                                try
                                {
                                    obj.fetch_data(Ticker.concat(".BO"), FinalTimeFrame, finalInterval);
                                    obj.ema_calculate(FirstMA, SecondMA);
                                    obj.EMA_Signal_Find();
                                    tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, obj.close_price.get(obj.close_price.size() - 1), null, obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1)});
                                }
                                catch(Exception e2)
                                {
                                    JOptionPane.showMessageDialog(null, "Enter valid Ticker");
                                }
                            }                            
                        }
                    }
                    catch(HeadlessException e1)
                    {
                        JOptionPane.showMessageDialog(null, "Something went wrong");
                    }
                    finally
                    {
                        obj.Clear_Previous();
                        inputTicker.setText("");
                        firstMA.setValue(20);
                        secondMA.setValue(50);
                        sma.setSelected(true);
                        ema.setSelected(true);
                        time_Frame.setSelectedIndex(4);
                        Interval.setSelectedIndex(6);
                    }
                }
                
            }
            else
            {
                
            }
        }
        else if(e.getSource() == liveShow)
        {
            if(currentOption.equals("Ticker"))
            {
                
            }
            else
            {
                
            }
        }
    }
    
    public static void main(String[] args){
        new Indian_Stocks();
    }
}
