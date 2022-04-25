import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileWriter;

public class confirm {
    public static void main(String[] args){
        String[] command = {"python", "res.py", args[0], args[1], args[2]};
        String file = "Report.csv";
       //To download resource
        try
        {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            int count = 0;
            FileWriter fw = new FileWriter(file);
            while((line = br.readLine()) != null)
            {
                if(count > 2)
                fw.write(line.replace(" ", ",") + "\n");

                count++;
            }
            fw.close();
        }
        catch(Exception e){}

        //Print resource
        try
        {
            String line = "";
            String date = "";
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null)
            {
                String[] value = line.split(",");
                date = value[0];
                System.out.println(value[5]);
            }
            System.out.println(date);
            br.close();
        }
        catch(Exception e){}

        //delete  file
        Path path = Paths.get(file);
        try
        {
            Files.deleteIfExists(path);
        }
        catch(Exception e){}
    }
}
