
package signal_suggester;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Signal {
    
    ArrayList<Double> close_price  = new ArrayList<>();
    ArrayList<Double> first_sma    = new ArrayList<>();
    ArrayList<Double> second_sma   = new ArrayList<>();
    ArrayList<Double> first_ema    = new ArrayList<>();
    ArrayList<Double> second_ema   = new ArrayList<>();
    ArrayList<String> SMA_Signal   = new ArrayList<>();
    ArrayList<String> EMA_Signal   = new ArrayList<>();
    String Date = null;
    String Final_Signal = null;
    
    private long epoch(){
        long period = System.currentTimeMillis()/1000;
        return period;
    }
    
    private void fetch_data(String Ticker, int TimeDuration, String Interval) throws Exception{
        
        String line;
        int ignore_first_line = 0;
        Signal obj = new Signal();
        long period_to = obj.epoch();
        long period_from = period_to - (86400 * TimeDuration);
        String command[] = {"curl" , "\"https://query1.finance.yahoo.com/v7/finance/download/" + Ticker + "?period1=" + period_from + "&period2=" + period_to + "&interval=" + Interval +"\""};
        Process p = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while((line = reader.readLine()) != null)
        {
            String[] values = line.split(",");
            if(ignore_first_line>0)
            {
                if(!values[4].equals("null"))
                {
                    Date = values[0];
                    close_price.add(Double.parseDouble(values[4]));
                }
                else
                {
                    Date = values[0];
                    close_price.add(close_price.get(close_price.size()-1));
                }
                
            }
            else
                ignore_first_line++;
            
        }
    }
    
    private void sma_calculate(int Duration_1, int Duration_2){
        
        Double sum = 0.0; 
        int count = 0;
        // Duration_1 sma example: 20day SMA
        for(int i = 0; i < close_price.size(); i++)
        {
            if(count < Duration_1)
            {
                sum = sum + close_price.get(i);
                count ++;
            }
            else if(count == Duration_1)
            {
                first_sma.add(sum / Duration_1);
                sum = 0.0;
                count = 0;
                i = i - Duration_1;
            }
        }

        //Duration_2 sma example: 50day SMA
        sum = 0.0;
        count = 0;
        for(int i = 0; i < close_price.size(); i++)
        {
            if(count < Duration_2)
            {
                sum = sum + close_price.get(i);
                count ++;
            }
            else if(count == Duration_2)
            {
                second_sma.add(sum / Duration_2);
                sum = 0.0;
                count = 0;
                i = i - Duration_2;
            }
        }
    }
    
    private void ema_calculate(int Duration_1, int Duration_2){
        
        // Duration_1 ema example: 20day ema
        for(int i = Duration_1; i < close_price.size(); i++)
        {
            if(i == Duration_1)
            {
                first_ema.add(first_sma.get(0));
            }
            else
            {
                Double close = close_price.get(i) * (2 / (Duration_1 + 1));
                int size = first_ema.size() - 1;
                Double ema_value = first_ema.get(size) * (1 - (2 / (Duration_1 + 1)));
                Double value = close + ema_value;
                first_ema.add(value);
            }
        }

        //Duration_2 ema example: 50day ema
        for(int i = Duration_2; i < close_price.size(); i++)
        {
            if(i == Duration_2)
            {
                second_ema.add(second_sma.get(0));
            }
            else
            {
                Double close = close_price.get(i) * (2 / (Duration_2 + 1));
                int size = second_ema.size() - 1;
                Double ema_value = second_ema.get(size) * (1 - (2 / (Duration_2 + 1)));
                Double value = close + ema_value;
                second_ema.add(value);
            }
        }
    }
    
    private void SMA_Signal_Find(){
       
        int Difference = first_sma.size() - second_sma.size();
        //Finding Buy/Sell/Neutral Signals
        for(int i = 0; i < second_sma.size(); i++)
        {
            if(first_sma.get(i + Difference) > second_sma.get(i))
            {
                SMA_Signal.add("Buy");
            }
            else if(first_sma.get(i + Difference) < second_sma.get(i))
            {
                SMA_Signal.add("Sell");
            }
            else
            {
                SMA_Signal.add("Neutral");
            }
        }

        //Filtering Signals
        for(int i = 0; i < SMA_Signal.size(); i++)
        {
            if((i+1) < (SMA_Signal.size() - 1))
            {
                if((SMA_Signal.get(i).equals("Buy") || SMA_Signal.get(i).equals("Hold Buy")) && SMA_Signal.get(i+1).equals("Buy"))
                {
                    SMA_Signal.set(i+1, "Hold Buy");
                }
                else if((SMA_Signal.get(i).equals("Sell") || SMA_Signal.get(i).equals("Hold Sell")) && SMA_Signal.get(i+1).equals("Sell"))
                {
                    SMA_Signal.set(i+1, "Hold Sell");
                }
                else if(SMA_Signal.get(i).equals("Neutral"))
                {
                    SMA_Signal.set(i, SMA_Signal.get(i-1));
                }
            }
            else if(SMA_Signal.get(i).equals("Buy") && SMA_Signal.get(i-1).equals("Hold Buy"))
            {
                SMA_Signal.set(i, "Hold Buy");
            }
            else if(SMA_Signal.get(i).equals("Sell") && SMA_Signal.get(i-1).equals("Hold Sell"))
            {
                SMA_Signal.set(i, "Hold Sell");
            }
        }
    }
    
    private void EMA_Signal_Find(){
        
        int Difference = first_ema.size() - second_ema.size();
        //Finding Buy/Sell/Neutral Signals
        for(int i = 0; i < second_ema.size(); i++)
        {
            if(first_ema.get(i + Difference) > second_ema.get(i))
            {
                EMA_Signal.add("Buy");
            }
            else if(first_ema.get(i + Difference) < second_ema.get(i))
            {
                EMA_Signal.add("Sell");
            }
            else
            {
                EMA_Signal.add("Neutral");
            }
        }

        //Filtering Signals
        for(int i = 0; i < EMA_Signal.size(); i++)
        {
            if((i+1) < EMA_Signal.size())
            {
                if((EMA_Signal.get(i).equals("Buy") || EMA_Signal.get(i).equals("Hold Buy")) && EMA_Signal.get(i+1).equals("Buy"))
                {
                    EMA_Signal.set(i+1, "Hold Buy");
                }
                else if((EMA_Signal.get(i).equals("Sell") || EMA_Signal.get(i).equals("Hold Sell")) && EMA_Signal.get(i+1).equals("Sell"))
                {
                    EMA_Signal.set(i+1, "Hold Sell");
                }
                else if(EMA_Signal.get(i).equals("Neutral"))
                {
                    EMA_Signal.set(i, EMA_Signal.get(i-1));
                }
            }
            else if(EMA_Signal.get(i).equals("Buy") && EMA_Signal.get(i-1).equals("Hold Buy"))
            {
                EMA_Signal.set(i, "Hold Buy");
            }
            else if(EMA_Signal.get(i).equals("Sell") && EMA_Signal.get(i-1).equals("Hold Sell"))
            {
                EMA_Signal.set(i, "Hold Sell");
            }
        }
    }
    
    private void Final_Signal_Find(){
        
        //Finding Decision Making Signal from MASignal and EMASignal (Whichever Signals first)
        if((SMA_Signal.get(SMA_Signal.size() - 1).equals("Buy") && EMA_Signal.get(EMA_Signal.size() - 1).equals("Buy")) || (SMA_Signal.get(SMA_Signal.size() - 1).equals("Buy") && EMA_Signal.get(EMA_Signal.size() - 1).equals("Hold Sell")) || (SMA_Signal.get(SMA_Signal.size() - 1).equals("Hold Sell") && EMA_Signal.get(EMA_Signal.size() - 1).equals("Buy")))
        {
            Final_Signal = "Buy";
        }
        else if((SMA_Signal.get(SMA_Signal.size() - 1).equals("Sell") && EMA_Signal.get(EMA_Signal.size() - 1).equals("Sell")) || (SMA_Signal.get(SMA_Signal.size() - 1).equals("Sell") && EMA_Signal.get(EMA_Signal.size() - 1).equals("Hold Buy")) || (SMA_Signal.get(SMA_Signal.size() - 1).equals("Hold Buy") && EMA_Signal.get(EMA_Signal.size() - 1).equals("Sell")))
        {
            Final_Signal = "Sell";
        }
        else if((SMA_Signal.get(SMA_Signal.size() - 1).equals("Hold Buy") && EMA_Signal.get(EMA_Signal.size() - 1).equals("Hold Buy")) || (SMA_Signal.get(SMA_Signal.size() - 1).equals("Buy") && EMA_Signal.get(EMA_Signal.size() - 1).equals("Hold Buy")) || (SMA_Signal.get(SMA_Signal.size() - 1).equals("Hold Buy") && EMA_Signal.get(EMA_Signal.size() - 1).equals("Buy")))
        {
            Final_Signal = "Hold Buy";
        }
        else if((SMA_Signal.get(SMA_Signal.size() - 1).equals("Hold Sell") && EMA_Signal.get(EMA_Signal.size() - 1).equals("Hold Sell")) || (SMA_Signal.get(SMA_Signal.size() - 1).equals("Sell") && EMA_Signal.get(EMA_Signal.size() - 1).equals("Hold Sell")) || (SMA_Signal.get(SMA_Signal.size() - 1).equals("Hold Sell") && EMA_Signal.get(EMA_Signal.size() - 1).equals("Sell")))
        {
            Final_Signal = "Hold Sell";
        }
        else
        {
            int sma_nearest_call = 0, ema_nearest_call = 0;
            
            //finding sma nearest call (Buy/Sell)
            for(int i = SMA_Signal.size() - 1; i >= 0; i--)
            {
                if(SMA_Signal.get(i).equals("Buy") || SMA_Signal.get(i).equals("Sell"))
                {
                    sma_nearest_call = i;
                    break;
                }
            }
            
            //finding ema nearest call (Buy/Sell)
            for(int i = EMA_Signal.size() - 1; i >= 0; i--)
            {
                if(EMA_Signal.get(i).equals("Buy") || EMA_Signal.get(i).equals("Sell"))
                {
                    ema_nearest_call = i;
                    if(ema_nearest_call == sma_nearest_call)
                    {
                        break;
                    }
                }
            }
            
            if(sma_nearest_call > ema_nearest_call)
            {
                Final_Signal = "Hold " + SMA_Signal.get(sma_nearest_call);
            }
            else
            {
                Final_Signal = "Hold " + EMA_Signal.get(ema_nearest_call);
            }
        }
    }
    
    public static void main(String[] args){
        Signal obj = new Signal();
        try
        {
            String Ticker = args[0];
            int timeframe = Integer.parseInt(args[1]);
            String interval = args[2];
            obj.fetch_data(Ticker, timeframe, interval);
            
            if(args[3].equals("Both"))
            {
                int sma1 = Integer.parseInt(args[4]);
                int sma2 = Integer.parseInt(args[5]);
                int ema1 = Integer.parseInt(args[6]);
                int ema2 = Integer.parseInt(args[7]);
                obj.sma_calculate(sma1, sma2);
                obj.ema_calculate(ema1, ema2);
                obj.SMA_Signal_Find();
                obj.EMA_Signal_Find();
                obj.Final_Signal_Find();
            }
            else if(args[3].equals("SMA"))
            {
                int sma1 = Integer.parseInt(args[4]);
                int sma2 = Integer.parseInt(args[5]);
                obj.sma_calculate(sma1, sma2);
                obj.SMA_Signal_Find();
            }
            else if(args[3].equals("EMA"))
            {
                int ema1 = Integer.parseInt(args[4]);
                int ema2 = Integer.parseInt(args[5]);
                obj.ema_calculate(ema1, ema2);
                obj.EMA_Signal_Find();
            }
        }
        catch(Exception e){}
    }
}
