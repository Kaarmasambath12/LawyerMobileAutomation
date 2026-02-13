package dataDriven;

import base.BaseClass;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class XLUtilities extends BaseClass {

    String excelFilePath = ".\\DataFile\\TestData.xlsx";
    public FileInputStream inputStream;
    public FileOutputStream outputStream;
    public XSSFWorkbook workbook;
    public   XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    String path =null;

    public XLUtilities(String path){
        this.path = path;
    }

    public int getRowCount(String sheetName) throws IOException {
        inputStream = new FileInputStream(path);
        workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        workbook.close();
        inputStream.close();
        return rowCount;

    }

    public int getCellCount(String sheetName, int rowNum) throws IOException {
        inputStream = new FileInputStream(path);
        workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        int cellCount = row.getLastCellNum();
        workbook.close();
        inputStream.close();
        return cellCount;

    }

    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        inputStream = new FileInputStream(path);
        workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);

        DataFormatter formatter = new DataFormatter();
        String data;
        try {
            data = formatter.formatCellValue(cell);
        }catch (Exception e){
            data = "";
        }
        workbook.close();
        inputStream.close();
        return data;

    }

    public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {
        inputStream = new FileInputStream(path);
        workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet(sheetName);

        row = sheet.getRow(rowNum);
        cell = row.createCell(colNum);
        cell.setCellValue(data);
        outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        inputStream.close();
        outputStream.close();
    }

    public void readExcelByLoop() throws IOException {
        inputStream = new FileInputStream(excelFilePath);
        workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet("Sheet1");

        //USING FOR LOOP

        int rows = sheet.getLastRowNum();
        int column = sheet.getRow(1).getLastCellNum();

        for(int i=0; i<=rows; i++){
            row = sheet.getRow(i);

            for(int j=0; j<column; j++){
                cell = row.getCell(j);

                switch(cell.getCellType()){
                    case STRING: System.out.print(cell.getStringCellValue()); break;
                    case NUMERIC: System.out.print(cell.getNumericCellValue()); break;
                    case BOOLEAN: System.out.print(cell.getBooleanCellValue()); break;
                }

            }
            System.out.println();
        }

    }

    public void readExcelByIterator(){
        Iterator iterator = sheet.iterator();
        while (iterator.hasNext()){
            row = (XSSFRow) iterator.next();
            Iterator cellIterator = row.cellIterator();

            while (cellIterator.hasNext()){
                cell = (XSSFCell) cellIterator.next();

                switch(cell.getCellType()){
                    case STRING: System.out.print(cell.getStringCellValue()); break;
                    case NUMERIC: System.out.print(cell.getNumericCellValue()); break;
                    case BOOLEAN: System.out.print(cell.getBooleanCellValue()); break;
                }
                System.out.println(" | ");
            }
            System.out.println();

        }
    }

    public void writeExcel() throws IOException {

        //create workbook-->sheet-->Rows-->Cells
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("New sheet");

        Object testData[][] = { {"EmpId", "Name", "Job"},
                {101, "karthik", "tester"},
                {102, "Praneeth", "tester"},
                {103, "Ralph", "Designer"},
        };

        int rows = testData.length;
        int cols = testData[0].length;

        System.out.println(rows);
        System.out.println(cols);

        for(int i=0; i<rows;i++){
           XSSFRow row = sheet.createRow(i);

           for(int k=0;k<cols;k++){
               XSSFCell cell = row.createCell(k);
               Object value = testData[i][k];

               if(value instanceof String)
                   cell.setCellValue((String) value);
               if(value instanceof Integer)
                   cell.setCellValue((Integer) value);
               if(value instanceof Boolean)
                   cell.setCellValue((Boolean) value);

           }
        }
        String filePath = ".\\DataFile\\WriteTestData.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        outputStream.close();
    }


}
