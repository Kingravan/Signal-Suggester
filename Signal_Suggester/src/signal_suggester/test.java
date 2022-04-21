package signal_suggester;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class test
{
    public static void main(String[] args)
    {
//        String[] index = {"NIFTY_50", "NIFTY_NEXT_50", "NIFTY_100", "NIFTY_MIDCAP_50", "NIFTY_MIDCAP_100", "NIFTY_SMALLCAP_100", "NIFTY_SMALLCAP_50", "NIFTY_SMALLCAP_250", "NIFTY_BANK", "NIFTY_AUTO", "NIFTY_FINANCIAL_SERVICES", "NIFTY_FMCG", "NIFTY_IT", "NIFTY_MEDIA", "NIFTY_METAL", "NIFTY_PHARMA", "NIFTY_PSU_BANK", "NIFTY_PRIVATE_BANK", "NIFTY_REALTY", "NIFTY_CONSUMER_DURABLES", "NIFTY_OIL_and_GAS", "NIFTY_COMMODITIES", "NIFTY_ENERGY", "NIFTY_INFRASTRUCTURE", "NIFTY_MNC"};
        // String url = https://www.nseindia.com/api/equity-stockIndices?csv=true&index=NIFTY_50 
//        System.out.println(index.length);
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/signal_suggester", "root", "root");
            Statement stmt = con.createStatement();
//            To create tables
//            for(int i = 0; i < index.length; i++)
//            {
//                stmt.execute("Create table " + index[i] + " (Name varchar(150) unique)");
//            }
//            String[] download = new String[index.length];
            //Conver _ to %20
//            for(int i = 0; i < index.length; i ++)
//            {
//                download[i] = index[i].replace("_", "%20");
//            }
//            
            //download index list
//            for(String s : download)
//            {
//                try
//                {
//                    Desktop.getDesktop().browse(new URI("https://www.nseindia.com/api/equity-stockIndices?csv=true&index=" + s));
//                    TimeUnit.SECONDS.sleep(2);
//                }
//                catch(Exception e){System.out.println(e);}
//            }

            // read file
//            String[] current = new String[index.length];
//            for(int i = 0; i < index.length; i++)
//            {
//                current[i] = index[i].replace("_", "-");
//            }
//            for(int i = 0; i < current.length; i++)
//            {
                String file = "C:\\Users\\Neeraj\\Desktop\\Book1.csv";
                String line = "";
                int count = 0;
                try
                {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    while((line = br.readLine()) != null)
                    {
                        if(count > 0)
                        {
                            String[] data = line.split(",");
//                            if(data[2].contains("."))
                            System.out.println(data[1]);
//                            String temp = data[0].replace("\"", "");
                            stmt.executeUpdate("Insert into s_and_p_100 values ('" + data[1] + "')");
                    }
                    count++;
                }
                }
                catch(Exception e){System.out.println(e);}   
//            }
            
        }
        catch(SQLException e){System.out.print(e);}
    }
}