package ApacheCommon;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author WhomHim
 * @description
 * @date Create in 2019/6/25 16:09
 */
public class CsvTest {

    public static void main(String[] args) throws IOException {
        write();

    }

    public static void write() throws IOException {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\test.csv"));
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(
                        "id", "name", "age"
                ))
        ) {
            csvPrinter.printRecord("1", "test1", "11");
            csvPrinter.printRecord("2", "test2", "21");
            csvPrinter.printRecord("3", "test3", "31");
            csvPrinter.printRecord("4", "test4", "41");
            csvPrinter.printRecord("5", "test5", "51");
            csvPrinter.flush();
        }

    }

    /**
     * 读取包括头部第一行
     *
     * @throws IOException
     */
    public static void read() throws IOException {
        try (
                BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\test.csv"));
                CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT)
        ) {
            for (CSVRecord csvRecord : parser) {
                String id = csvRecord.get(0);
                String name = csvRecord.get(1);
                String age = csvRecord.get(2);
                System.out.println("id : " + id);
                System.out.println("name : " + name);
                System.out.println("age : " + age);
                System.out.println("---------------\n\n");
            }
        }
    }

    /**
     * 设置头部
     *
     * @throws IOException
     */
    private static void read2() throws IOException {
        try (
                BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\test.csv"));
                CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withHeader("id", "name", "age")
                        .withIgnoreHeaderCase()
                        .withTrim())
        ) {
            //key:头部名,value:顺序
            System.out.println(parser.getHeaderMap());
            for (CSVRecord csvRecord : parser) {
                System.out.println(csvRecord.getRecordNumber());
                String id = csvRecord.get("id");
                String name = csvRecord.get("name");
                String age = csvRecord.get("age");
                System.out.println("id : " + id);
                System.out.println("name : " + name);
                System.out.println("age : " + age);
                System.out.println("---------------\n\n");
            }
        }
    }

}