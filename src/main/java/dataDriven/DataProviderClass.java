package dataDriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataProviderClass {

    @Test(dataProvider = "loginData")
    public void testCase(){

    }
    @DataProvider(name = "loginData")
    public String [][] getData(){

        String loginData[][] = {
                {"9003349787", "Welcome@123", "invalid"},
                {"9524557835", "Kasthuri@09", "valid"},

        };
        return loginData;
    }

    @DataProvider(name = "excelDataCheck")
    public String [][] getExcelData() throws IOException {

        String path = ".\\ExcelFile\\Book1.xlsx";
        XLUtilities utilities = new XLUtilities(path);
        int totalRows = utilities.getRowCount("Sheet1");
        int totalCols = utilities.getCellCount("Sheet1", 1);

        String excelDataCheck[][] = new String[totalRows][totalCols];

        for (int i=1; i<=totalRows;i++){
            for (int j=0; j<totalCols;j++){
                excelDataCheck[i-1][j] = utilities.getCellData("Sheet1", 1, 1);
            }
        }
        return excelDataCheck;
    }




}
