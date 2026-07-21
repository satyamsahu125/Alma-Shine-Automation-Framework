package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Read , Write and save the data into excel sheet
 */
public class ExcelUtility {

	private FileInputStream fis;
	private Workbook excel;
	private String path;
	private String sheetName;

	public ExcelUtility(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			excel = WorkbookFactory.create(fis);
			fis.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ExcelUtility(String path, String sheetName) {
		this(path);
		this.sheetName = sheetName;

	}

	/**
	 * getData reads the data from cell if cell is null return blank or else return
	 * value
	 * 
	 * @param SheetName
	 * @param row
	 * @Param column index.
	 */
	public String getData(String sheetName, int row, int col) {
		Sheet sheet = excel.getSheet(sheetName);
		if (sheet == null) {
			throw new RuntimeException("No Sheet found with name " + sheetName);
		}
		Row r = sheet.getRow(row);
		if (r == null) {
			return "";
		}

		Cell c = r.getCell(col);

		if (c == null) {
			return "";
		}

		return c.toString().trim();

	}

	public String getData(int row, int col) {
		Sheet sheet = excel.getSheet(sheetName);
		if (sheet == null) {
			throw new RuntimeException("No Sheet found with name " + sheetName);
		}
		Row r = sheet.getRow(row);
		if (r == null) {
			return "";
		}

		Cell c = r.getCell(col);

		if (c == null) {
			return "";
		}

		return c.toString().trim();

	}

	/**
	 * to create the Sheet into the workbook
	 * 
	 * @param SheetName
	 * 
	 */
	public void CreateSheet(String sheetName) {
		Sheet sheet = excel.getSheet(sheetName);
		if (sheet == null) {
			sheet = excel.createSheet(sheetName);
		}
	}

	/**
	 * to write data into workbook file
	 * 
	 * @param sheetName
	 * @param row
	 * @param col
	 * @param value
	 */
	public void writeData(String sheetName, int row, int col, String value) {

		Sheet sheet = excel.getSheet(sheetName);
		if (sheet == null) {
			CreateSheet(sheetName);
		}
		Row r = sheet.getRow(row);
		if (r == null) {
			r = sheet.createRow(row);
		}

		Cell c = r.getCell(col);
		if (c == null) {

			c = r.createCell(col);
		}

		c.setCellValue(value);

	}

	/**
	 * saveData is used to export workbook into excel file
	 */
	public void saveData() {
		try {
			FileOutputStream file = new FileOutputStream(path);
			excel.write(file);
			file.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void closeWorkbook() {
		try {
			excel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// errors in this
	public int getRowLength(String sheetName) {

		Sheet sheet = excel.getSheet(sheetName);

		if (sheet == null) {
			throw new RuntimeException("Sheet not found in Excel file: " + sheetName);
		}

		int colLength = getColLength(sheetName);

		int length = 0;
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			length++;
			int count = 0;
			for (int j = 0; j < colLength; j++) {

				if (sheet.getRow(i).getCell(j) == null) {
					count++;
				}
			}

			if (count > 5) {
				return length;
			}

		}

		return excel.getSheet(sheetName).getPhysicalNumberOfRows();

	}

	public int getColLength(String sheetName) {

		int count = 1;
		int temp = 0;

		Sheet sheet = excel.getSheet(sheetName);
		if (sheet == null) {
			throw new RuntimeException("Sheet not found in Excel file: " + sheetName);
		}

		for (int i = 0; i < sheet.getRow(0).getPhysicalNumberOfCells(); i++) {

			if (sheet.getRow(0).getCell(i) != null) {
				count++;

			} else {
				temp++;
			}

			if (temp > 2) {
				break;
			}
		}

		return count - 1;

	}

}
