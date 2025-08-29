package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

import java.io.IOException;
import java.io.InputStream;

public class ReadExcel {

    public String[][] readData(String filePath, String sheetName) {
        try {
            InputStream file = getClass().getClassLoader().getResourceAsStream(filePath);
            if (file == null) {
                throw new IOException("File is not found " + filePath);
            }

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getLastCellNum();

            String[][] data = new String[rows - 1][cols];
            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i < rows; i++) {
                XSSFRow row = sheet.getRow(i);
                for (int j = 0; j < cols; j++) {
                    data[i - 1][j] = (row != null && row.getCell(j) != null)
                            ? formatter.formatCellValue(row.getCell(j)) : "";
                }
            }

            workbook.close();
            file.close();
            return data;

        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + e.getMessage(), e);
        }
    }
}
