package utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FileUtils {
    public static Iterator<Object[]> readCsvFile(String filePath) throws Exception {
        List<Object[]> dataArray = new ArrayList<Object[]>();
        Reader in = new FileReader(filePath);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        for(CSVRecord record:records){
            List<Object> rowList = new ArrayList();
            Iterator i = record.iterator();
            while(i.hasNext()){
                rowList.add(i.next());
            }
            Object[] rowArray = rowList.toArray();
            dataArray.add(rowArray);
        }
        return dataArray.iterator();
    }

    public static String readYmlFile(String path,String attribute) throws Exception{
        Yaml yaml = new Yaml();
        FileInputStream fileInputStream = new FileInputStream(path);
        Map map = yaml.loadAs(fileInputStream, Map.class);
        fileInputStream.close();
        return (String)map.get(attribute);
    }

    public static Map readYmlFile(String path) throws Exception{
        Yaml yaml = new Yaml();
        FileInputStream fileInputStream = new FileInputStream(path);
        Map map = yaml.loadAs(fileInputStream, Map.class);
        return map;
    }

    public static void main(String[] args)throws Exception{
       String path = getPath("/clickBanner.yml");
       String value = readYmlFile(path,"expectTitle");
    }

    public static String getPath(String partPath) throws Exception{
        String path = FileUtils.class.getResource(partPath).getPath();
        return URLDecoder.decode(path,"UTF-8");
    }
}
