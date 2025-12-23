package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    File file;
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;

    public ExcelReader(String filePath) throws IOException {
        this.file = new File(filePath);
        this.fis = new FileInputStream(this.file);
        this.wb = new XSSFWorkbook(this.fis);
    }

    public String getStringData(String sheetName, int rowNumber, int cellNumber) {
        this.sheet = this.wb.getSheet(sheetName);
        this.row = this.sheet.getRow(rowNumber);
        this.cell = this.row.getCell(cellNumber);
        return this.cell.getStringCellValue();
    }

    public int getIntegerData(String sheetName, int rowNumber, int cellNumber) {
        this.sheet = this.wb.getSheet(sheetName);
        this.row = this.sheet.getRow(rowNumber);
        this.cell = this.row.getCell(cellNumber);
        return (int) this.cell.getNumericCellValue();
    }

    public int getLastRow(String sheet) {
        this.sheet = this.wb.getSheet(sheet);
        return this.sheet.getLastRowNum();
    }
}
