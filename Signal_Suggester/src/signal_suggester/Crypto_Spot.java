
package signal_suggester;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Crypto_Spot implements ActionListener{
    Connection con= null;
    Statement stmt = null;
    
    JFrame frame = new JFrame();
    JLabel intro, enterTicker, selectIndex, hint1, hint2, optional, basedOn, timeFrame, maPeriod, interval;
    JTextField inputTicker;
    JCheckBox sma, ema;
    JSpinner firstMA, secondMA;
    SpinnerNumberModel fmavalues, smavalues;
    JComboBox time_Frame, Interval;
    JButton showTicker, reset;
    JTable resultContainer;
    DefaultTableModel tableModel;
    JScrollPane scrollResult;
    Crypto_Spot()
    {
        intro = new JLabel("Suggest By Ticker");
        intro.setFont(new Font("Ariel", Font.BOLD, 24));
        intro.setBounds(0, 30, 800, 30);
        intro.setHorizontalAlignment(JLabel.CENTER);
        enterTicker = new JLabel("Enter Ticker: ");
        selectIndex = new JLabel("Select Index: ");
        hint1 = new JLabel("To add multiple Ticker add coma (,) Eg.(BTC, ETH)");
        hint2 = new JLabel("To get result in other Pairs enter currency name Eg.(BTC-INR, ETH-INR)");
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
        hint1.setFont(new Font("Ariel", Font.PLAIN, 12));
        hint2.setFont(new Font("Ariel", Font.PLAIN, 12));
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
        hint1.setBounds(300, 120, 400, 20);
        hint2.setBounds(300, 135, 400, 20);
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
        
        showTicker = new JButton("Show");
        reset = new JButton("Reset");
        showTicker.setFont(new Font("Ariel", Font.BOLD, 18));
        reset.setFont(new Font("Ariel", Font.BOLD, 18));
        showTicker.setBounds(300, 300, 100, 30);
        reset.setBounds(450, 300, 100, 30);
        
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
        
        showTicker.addActionListener(this);
        reset.addActionListener(this);
        
        selectIndex.setVisible(false);
        
        sma.addActionListener(this);
        ema.addActionListener(this);
        
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/signal_suggester", "root", "root");
            stmt = con.createStatement();
        }
        catch(SQLException e){}
        frame.add(intro);
        frame.add(enterTicker);
        frame.add(inputTicker);
        frame.add(selectIndex);
        frame.add(hint1);
        frame.add(hint2);
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
        frame.add(showTicker);
        frame.add(reset);
        frame.add(scrollResult);
        frame.setSize(800,700);
        frame.setTitle("Signal Suggester - Crypto_Spot");
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
    
    public void singleTicker(String Ticker, int FirstMA, int SecondMA, int FinalTimeFrame, String finalInterval){
        Signal obj = new Signal();
        if(sma.isSelected() && ema.isSelected())
        {
            if(!Ticker.contains("-"))
            {
                try
                {
                    obj.fetch_data(Ticker.concat("-USD"), FinalTimeFrame, finalInterval);
                    obj.sma_calculate(FirstMA, SecondMA);
                    obj.ema_calculate(FirstMA, SecondMA);
                    obj.SMA_Signal_Find();
                    obj.EMA_Signal_Find();
                    obj.Final_Signal_Find();
                    tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, Math.round(obj.close_price.get(obj.close_price.size() - 1) * 100) / 100.0, obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.Final_Signal});
                }
                catch(Exception e1)
                {
                    JOptionPane.showMessageDialog(null, "Enter Valid Ticker");
                }
                finally
                {
                    obj.Clear_Previous();
                }
            }
            else
            {
                try
                {
                    obj.fetch_data(Ticker, FinalTimeFrame, finalInterval);
                    obj.sma_calculate(FirstMA, SecondMA);
                    obj.ema_calculate(FirstMA, SecondMA);
                    obj.SMA_Signal_Find();
                    obj.EMA_Signal_Find();
                    obj.Final_Signal_Find();
                    tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, Math.round(obj.close_price.get(obj.close_price.size() - 1) * 100) / 100.0, obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.Final_Signal});
                }
                catch(Exception e1)
                {
                    JOptionPane.showMessageDialog(null, "Enter Valid Ticker");
                }
                finally
                {
                    obj.Clear_Previous();
                }                
            }
        }
        else if(sma.isSelected())
        {
            if(!Ticker.contains("-"))
            {
                try
                {
                    obj.fetch_data(Ticker.concat("-USD"), FinalTimeFrame, finalInterval);
                    obj.sma_calculate(FirstMA, SecondMA);
                    obj.SMA_Signal_Find();
                    tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, Math.round(obj.close_price.get(obj.close_price.size() - 1) * 100) / 100.0, obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), null, obj.SMA_Signal.get(obj.SMA_Signal.size() - 1)});
                }
                catch(Exception e1)
                {
                    JOptionPane.showMessageDialog(null, "Enter valid Ticker");
                }
                finally
                {
                    obj.Clear_Previous();
                }                
            }
            else
            {
                try
                {
                    obj.fetch_data(Ticker, FinalTimeFrame, finalInterval);
                    obj.sma_calculate(FirstMA, SecondMA);
                    obj.SMA_Signal_Find();
                    tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, Math.round(obj.close_price.get(obj.close_price.size() - 1) * 100) / 100.0, obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), null, obj.SMA_Signal.get(obj.SMA_Signal.size() - 1)});
                }
                catch(Exception e1)
                {
                    JOptionPane.showMessageDialog(null, "Enter valid Ticker");
                }
                finally
                {
                    obj.Clear_Previous();
                }                
            }
        }
        else if(ema.isSelected())
        {
            if(!Ticker.contains("-"))
            {
                try
                {
                    obj.fetch_data(Ticker.concat("-USD"), FinalTimeFrame, finalInterval);
                    obj.ema_calculate(FirstMA, SecondMA);
                    obj.EMA_Signal_Find();
                    tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, Math.round(obj.close_price.get(obj.close_price.size() - 1) * 100) / 100.0, null, obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1)});
                }
                catch(Exception e1)
                {
                    JOptionPane.showMessageDialog(null, "Enter valid Ticker");
                }
                finally
                {
                    obj.Clear_Previous();
                }
            }
            else
            {
                try
                {
                    obj.fetch_data(Ticker, FinalTimeFrame, finalInterval);
                    obj.ema_calculate(FirstMA, SecondMA);
                    obj.EMA_Signal_Find();
                    tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, Ticker, Math.round(obj.close_price.get(obj.close_price.size() - 1) * 100) / 100.0, null, obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1)});
                }
                catch(Exception e1)
                {
                    JOptionPane.showMessageDialog(null, "Enter valid Ticker");
                }
                finally
                {
                    obj.Clear_Previous();
                }                
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Select atleast one from SMA and EMA");
        }
    }
    
    public void multipleTicker(String[] List, int FirstMA, int SecondMA, int FinalTimeFrame, String finalInterval){
        Signal obj = new Signal();
        if(sma.isSelected() && ema.isSelected())
        {
            for(String s : List)
            {
                if(!s.contains("-"))
                {
                    try
                    {
                        obj.fetch_data(s.concat("-USD"), FinalTimeFrame, finalInterval);
                        obj.sma_calculate(FirstMA, SecondMA);
                        obj.ema_calculate(FirstMA, SecondMA);
                        obj.SMA_Signal_Find();
                        obj.EMA_Signal_Find();
                        obj.Final_Signal_Find();
                        tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, s, Math.round(obj.close_price.get(obj.close_price.size() - 1) * 100) / 100.0, obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.Final_Signal});
                    }
                    catch(Exception e1)
                    {
                        JOptionPane.showMessageDialog(null, "Enter Valid Ticker");
                    }
                    finally
                    {
                        obj.Clear_Previous();
                    }
                }
                else
                {
                    try
                    {
                        obj.fetch_data(s, FinalTimeFrame, finalInterval);
                        obj.sma_calculate(FirstMA, SecondMA);
                        obj.ema_calculate(FirstMA, SecondMA);
                        obj.SMA_Signal_Find();
                        obj.EMA_Signal_Find();
                        obj.Final_Signal_Find();
                        tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, s, Math.round(obj.close_price.get(obj.close_price.size() - 1) * 100) / 100.0, obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.Final_Signal});
                    }
                    catch(Exception e1)
                    {
                        JOptionPane.showMessageDialog(null, "Enter Valid Ticker");
                    }
                    finally
                    {
                        obj.Clear_Previous();
                    }                    
                }
            }
        }
        else if(sma.isSelected())
        {
            for(String s : List)
            {
                if(!s.contains("-"))
                {
                    try
                    {
                        obj.fetch_data(s.concat("-USD"), FinalTimeFrame, finalInterval);
                        obj.sma_calculate(FirstMA, SecondMA);
                        obj.SMA_Signal_Find();
                        tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, s, Math.round(obj.close_price.get(obj.close_price.size() - 1) * 100) / 100.0, obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), null, obj.SMA_Signal.get(obj.SMA_Signal.size() - 1)});
                    }
                    catch(Exception e1)
                    {
                        JOptionPane.showMessageDialog(null, "Enter valid Ticker");
                    }
                    finally
                    {
                        obj.Clear_Previous();
                    }
                }
                else
                {
                    try
                    {
                        obj.fetch_data(s, FinalTimeFrame, finalInterval);
                        obj.sma_calculate(FirstMA, SecondMA);
                        obj.SMA_Signal_Find();
                        tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, s, Math.round(obj.close_price.get(obj.close_price.size() - 1) * 100) / 100.0, obj.SMA_Signal.get(obj.SMA_Signal.size() - 1), null, obj.SMA_Signal.get(obj.SMA_Signal.size() - 1)});
                    }
                    catch(Exception e1)
                    {
                        JOptionPane.showMessageDialog(null, "Enter valid Ticker");
                    }
                    finally
                    {
                        obj.Clear_Previous();
                    }                    
                }
            }
        }
        else if(ema.isSelected())
        {
            for(String s : List)
            {
                if(!s.contains("-"))
                {
                   try
                    {
                        obj.fetch_data(s.concat("-USD"), FinalTimeFrame, finalInterval);
                        obj.ema_calculate(FirstMA, SecondMA);
                        obj.EMA_Signal_Find();
                        tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, s, Math.round(obj.close_price.get(obj.close_price.size() - 1) * 100) / 100.0, null, obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1)});
                    }
                    catch(Exception e1)
                    {
                        JOptionPane.showMessageDialog(null, "Enter valid Ticker");
                    }
                    finally
                    {
                        obj.Clear_Previous();
                    } 
                }
                else
                {
                   try
                    {
                        obj.fetch_data(s, FinalTimeFrame, finalInterval);
                        obj.ema_calculate(FirstMA, SecondMA);
                        obj.EMA_Signal_Find();
                        tableModel.insertRow(tableModel.getRowCount(), new Object[] {obj.Date, s, Math.round(obj.close_price.get(obj.close_price.size() - 1) * 100) / 100.0, null, obj.EMA_Signal.get(obj.EMA_Signal.size() - 1), obj.EMA_Signal.get(obj.EMA_Signal.size() - 1)});
                    }
                    catch(Exception e1)
                    {
                        JOptionPane.showMessageDialog(null, "Enter valid Ticker");
                    }
                    finally
                    {
                        obj.Clear_Previous();
                    }                    
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Select atleast one from SMA and EMA");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == showTicker)
        { 
            tableModel.setRowCount(0);
            String Ticker = inputTicker.getText().trim().toUpperCase();
            int FirstMA = (Integer) firstMA.getValue();
            int SecondMA = (Integer) secondMA.getValue();
            int TimeFrame = time_Frame.getSelectedIndex();
            int FinalTimeFrame = 0;
            switch(TimeFrame)
            {
                case 0 -> FinalTimeFrame = 30;
                case 1 -> FinalTimeFrame = (30 * 3);
                case 2 -> FinalTimeFrame = (30 * 6);
                case 3 -> FinalTimeFrame = 365;
                case 4 -> FinalTimeFrame = (365 * 2);
                case 5 -> FinalTimeFrame = (365 * 3);
                case 6 -> FinalTimeFrame = (365 * 5);
            }
            int tempInterval = Interval.getSelectedIndex();
            String finalInterval = null;
            switch(tempInterval)
            {
                case 0 -> finalInterval = "1m";
                case 1 -> finalInterval = "5m";
                case 2 -> finalInterval = "15m";
                case 3 -> finalInterval = "30m";
                case 4 -> finalInterval = "1h";
                case 5 -> finalInterval = "90m";
                case 6 -> finalInterval = "1d";
                case 7 -> finalInterval = "5d";
                case 8 -> finalInterval = "1wk";
                case 9 -> finalInterval = "1mo";
                case 10 -> finalInterval = "3mo";
            }
                String[] List;
                if(Ticker.contains(","))
                {
                    List = Ticker.split(",");
                    for(int i = 0; i < List.length; i++)
                    {
                        List[i] = List[i].trim().toUpperCase();
                    }
                    multipleTicker(List, FirstMA, SecondMA, FinalTimeFrame, finalInterval);
                }
                else
                {
                    singleTicker(Ticker, FirstMA, SecondMA, FinalTimeFrame, finalInterval);
                }
        }
        else if(e.getSource() == reset)
        {
            inputTicker.setText("");
            tableModel.setRowCount(0);
        }
    }
    
    public static void main(String[] args){
        new Crypto_Spot();
    }
}
